package com.waes.backend.service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.naming.AuthenticationException;

import com.waes.backend.database.DatabaseMock;
import com.waes.backend.exceptions.UserRegistrationException;
import com.waes.backend.exceptions.UsernameNotFoundException;
import com.waes.backend.model.User;
import com.waes.backend.model.UserSafe;

public class UserService {

  private static Map<String, User> allUsers = DatabaseMock.getAllUsers();

  public Map<String, UserSafe> getAllUsers() {
    Map<String, UserSafe> allUsersSafe = new HashMap<>();
    allUsers.forEach((k, v) -> allUsersSafe.put(k, new UserSafe(v)));
    return allUsersSafe;
  }

  public UserSafe getUserByUsername(String username) {
    if (!allUsers.containsKey(username)) {
      throw new UsernameNotFoundException(username);
    }
    return new UserSafe(allUsers.get(username));
  }

  public UserSafe setUser(String username, User user) {
    if (allUsers.containsKey(username)) {
      throw new UserRegistrationException("The username '" + username + "' already exists.");
    } else if (emailAlreadyRegisteredAs(user.getEmail())) {
      throw new UserRegistrationException("The email '" + user.getEmail() + "' is already registered.");
    } else {
      allUsers.put(username, user);
    }
    return new UserSafe(allUsers.get(username));
  }

  public String getUsernameByAuthentication(String authString) throws AuthenticationException {
    String decodedAuth;
    String[] authParts = authString.split("\\s+");
    String authInfo = authParts[1];
    byte[] bytes = Base64.getDecoder().decode(authInfo);
    decodedAuth = new String(bytes);

    String[] usernameAndPassword = decodedAuth.split(":");
    if (!allUsers.containsKey(usernameAndPassword[0]) ||
        !allUsers.get(usernameAndPassword[0]).getPw().equals(usernameAndPassword[1])) {
      throw new AuthenticationException("Invalid username or password.");
    }
    return usernameAndPassword[0];
  }

  private boolean emailAlreadyRegisteredAs(String email) {
    for (Entry<String, User> entry : allUsers.entrySet()) {
      User v = entry.getValue();
      if (v.getEmail().equals(email)) {
        return true;
      }
    }
    return false;
  }

  public UserSafe updateUser(String username, User user) {
    allUsers.replace(username, user);
    return new UserSafe(allUsers.get(username));
  }

  public UserSafe deleteUser(String username) {
    return new UserSafe(allUsers.remove(username));
  }
}

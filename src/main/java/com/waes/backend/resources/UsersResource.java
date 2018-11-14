package com.waes.backend.resources;

import java.util.Map;

import javax.naming.AuthenticationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.waes.backend.model.User;
import com.waes.backend.model.UserSafe;
import com.waes.backend.service.UserService;

@Path("/v1/users/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

  private UserService userService = new UserService();

  @GET
  @Path("/all")
  public Map<String, UserSafe> getAllUsers(@HeaderParam("authorization") String authString)
      throws AuthenticationException {
    if (userService.getUserByUsername(userService.getUsernameByAuthentication(authString)).getIsAdmin()) {
      return userService.getAllUsers();
    } else {
      throw new AuthenticationException("You do not have access to this information.");
    }
  }

  @GET
  @Path("/access")
  public UserSafe getUserAuthorization(@HeaderParam("authorization") String authString)
      throws AuthenticationException {
    return userService.getUserByUsername(userService.getUsernameByAuthentication(authString));
  }

  @GET
  @Path("/details")
  public UserSafe getUserByUsername(@QueryParam("username") String username) {
    return userService.getUserByUsername(username);
  }

  @POST
  @Path("")
  public UserSafe setUserByUsername(@HeaderParam("username") String username, User user) {
    return userService.setUser(username, user);
  }

  @PUT
  @Path("")
  public UserSafe updateUserByUsername(@HeaderParam("authorization") String authString, User user)
      throws AuthenticationException {
    return userService.updateUser(userService.getUsernameByAuthentication(authString), user);
  }

  @DELETE
  @Path("")
  public UserSafe deleteUserByUsername(@HeaderParam("authorization") String authString)
      throws AuthenticationException {
    return userService.deleteUser(userService.getUsernameByAuthentication(authString));
  }
}

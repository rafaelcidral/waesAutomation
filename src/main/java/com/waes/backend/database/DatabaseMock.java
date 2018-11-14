package com.waes.backend.database;

import java.util.HashMap;
import java.util.Map;

import com.waes.backend.model.User;
import com.waes.backend.model.UserBuilder;

/**
 * This is a class in place of the database where production data would be stored.
 */
public final class DatabaseMock {

  private static HashMap<String, User> allUsers = new HashMap<>();

  private DatabaseMock() {
  }

  public static Map<String, User> getAllUsers() {
    createDefaultUsers();
    return allUsers;
  }

  public static void deleteAllUsers() {
    allUsers.clear();
  }

  /**
   * Default users for this mock database.
   */
  private static void createDefaultUsers() {
    User admin = new UserBuilder()
        .with($ -> {
          $.pw = "hero";
          $.name = "Amazing Admin";
          $.email = "a.admin@wearewaes.com";
          $.superpower = "Change the course of a waterfall.";
          $.dateOfBirth =
              new UserBuilder.DobBuilder()
                  .with($_dob -> {
                    $_dob.year = "1984";
                    $_dob.month = "April";
                    $_dob.day = "16";
                  }).createDob();
          $.isAdmin = true;
        }).createUser();
    User dev = new UserBuilder()
        .with($ -> {
          $.pw = "wizard";
          $.name = "Zuper Dooper Dev";
          $.email = "zd.dev@wearewaes.com";
          $.superpower = "Debug a repellent factory storage.";
          $.dateOfBirth =
              new UserBuilder.DobBuilder()
                  .with($_dob -> {
                    $_dob.year = "1999";
                    $_dob.month = "October";
                    $_dob.day = "10";
                  }).createDob();
          $.isAdmin = false;
        }).createUser();
    User tester = new UserBuilder()
        .with($ -> {
          $.pw = "maniac";
          $.name = "Al Skept-Cal Tester";
          $.email = "as.tester@wearewaes.com";
          $.superpower = "Voltage AND Current.";
          $.dateOfBirth =
              new UserBuilder.DobBuilder()
                  .with($_dob -> {
                    $_dob.year = "2014";
                    $_dob.month = "July";
                    $_dob.day = "15";
                  }).createDob();
          $.isAdmin = false;
        }).createUser();

    allUsers.put("admin", admin);
    allUsers.put("dev", dev);
    allUsers.put("tester", tester);
  }
}

package com.waes.backend.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.function.Consumer;

public class UserBuilder {

  public String pw;
  public String name;
  public String email;
  public String superpower;
  public LocalDate dateOfBirth;
  public Boolean isAdmin;

  public UserBuilder with(
      Consumer<UserBuilder> builderFunction) {
    builderFunction.accept(this);
    return this;
  }

  public User createUser() {
    return new User(pw, name, email, superpower, dateOfBirth, isAdmin);
  }

  public static class DobBuilder {

    public String year;
    public String month;
    public String day;

    public DobBuilder with(
        Consumer<DobBuilder> builderFunction) {
      builderFunction.accept(this);
      return this;
    }

    public LocalDate createDob() {
      return LocalDate.of(
          Integer.valueOf(year),
          Month.valueOf(month.toUpperCase()),
          Integer.valueOf(day));
    }
  }
}

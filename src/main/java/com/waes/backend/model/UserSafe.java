package com.waes.backend.model;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserSafe {

  private String name;
  private String email;
  private String superpower;
  private LocalDate dateOfBirth;
  private Boolean isAdmin;

  // serializable constructor
  public UserSafe() {
  }

  public UserSafe(User user) {
    super();
    this.name = user.getName();
    this.email = user.getEmail();
    this.superpower = user.getSuperpower();
    this.dateOfBirth = user.getDateOfBirth();
    this.isAdmin = user.getIsAdmin();
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getSuperpower() {
    return superpower;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public Boolean getIsAdmin() {
    return isAdmin;
  }
}

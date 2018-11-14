package com.waes.backend.model;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

  private String pw;
  private String name;
  private String email;
  private String superpower;
  private LocalDate dateOfBirth;
  private Boolean isAdmin;

  // serializable constructor
  public User() {
  }

  User(String pw, String name, String email, String superpower, LocalDate dob,
      Boolean isAdmin) {
    super();
    this.pw = pw;
    this.name = name;
    this.email = email;
    this.superpower = superpower;
    this.dateOfBirth = dob;
    this.isAdmin = isAdmin;
  }

  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    this.pw = pw;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSuperpower() {
    return superpower;
  }

  public void setSuperpower(String superpower) {
    this.superpower = superpower;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Boolean getIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(Boolean isAdmin) {
    this.isAdmin = isAdmin;
  }
}

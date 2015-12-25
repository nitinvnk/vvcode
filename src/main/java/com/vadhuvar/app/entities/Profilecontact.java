package com.vadhuvar.app.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the PROFILECONTACT database table.
 *
 */
@Entity
@Table(name = "PROFILECONTACT")
@NamedQuery(name = "Profilecontact.findAll", query = "SELECT p FROM Profilecontact p")
public class Profilecontact implements Serializable {

  private static final long serialVersionUID = 4659073150367771284L;

  @Column(name = "CREATED_BY")
  private String createdBy;

  @Column(name = "CREATED_DATE")
  private Timestamp createdDate;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "LASTUPDATED_BY")
  private String lastupdatedBy;

  @Column(name = "LASTUPDATED_DATE")
  private Timestamp lastupdatedDate;

  @Column(name = "MOBILE_NUMBER")
  private String mobileNumber;

  @Column(name = "PHONE_NUMBER")
  private String phoneNumber;

  @Column(name = "WHATSAPP")
  private String whatsapp;

  // bi-directional many-to-one association to Profile
  @ManyToOne
  @JoinColumn(name = "PROFILE_ID")
  private Profile profile;

  // bi-directional many-to-one association to Profilerelationship
  @ManyToOne
  @JoinColumn(name = "RELATIONSHIP_ID")
  private Profilerelationship profilerelationship;

  public Profilecontact() {}

  public String getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final String createdBy) {
    this.createdBy = createdBy;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getLastupdatedBy() {
    return this.lastupdatedBy;
  }

  public void setLastupdatedBy(final String lastupdatedBy) {
    this.lastupdatedBy = lastupdatedBy;
  }

  public Timestamp getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(final Timestamp createdDate) {
    this.createdDate = createdDate;
  }

  public Timestamp getLastupdatedDate() {
    return lastupdatedDate;
  }

  public void setLastupdatedDate(final Timestamp lastupdatedDate) {
    this.lastupdatedDate = lastupdatedDate;
  }

  public String getMobileNumber() {
    return this.mobileNumber;
  }

  public void setMobileNumber(final String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public void setPhoneNumber(final String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getWhatsapp() {
    return this.whatsapp;
  }

  public void setWhatsapp(final String whatsapp) {
    this.whatsapp = whatsapp;
  }

  public Profile getProfile() {
    return this.profile;
  }

  public void setProfile(final Profile profile) {
    this.profile = profile;
  }

  public Profilerelationship getProfilerelationship() {
    return this.profilerelationship;
  }

  public void setProfilerelationship(final Profilerelationship profilerelationship) {
    this.profilerelationship = profilerelationship;
  }

}

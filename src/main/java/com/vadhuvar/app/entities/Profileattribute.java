package com.vadhuvar.app.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the PROFILEATTRIBUTE database table.
 *
 */
@Entity
@Table(name = "PROFILEATTRIBUTE")
@NamedQuery(name = "Profileattribute.findAll", query = "SELECT p FROM Profileattribute p")
public class Profileattribute implements Serializable {

  private static final long serialVersionUID = -1355573311633684936L;

  @Column(name = "BLOOD_GROUP")
  private String bloodGroup;

  @Column(name = "CREATED_BY")
  private String createdBy;

  @Column(name = "CREATED_DATE")
  private Timestamp createdDate;

  @Column(name = "EXPECTATIONS")
  private String expectations;

  @Column(name = "HEIGHT")
  private String height;

  @Column(name = "HOBBIES")
  private String hobbies;

  @Column(name = "INCOME")
  private String income;

  @Column(name = "LANGUAGES")
  private String languages;

  @Column(name = "LASTUPDATED_BY")
  private String lastupdatedBy;

  @Column(name = "LASTUPDATED_DATE")
  private Timestamp lastupdatedDate;

  @Column(name = "MANGLIK")
  private String manglik;

  @Column(name = "OCCUPATION")
  private String occupation;

  @Column(name = "SKIN_COLOUR")
  private String skinColour;

  @Column(name = "WEIGHT")
  private BigDecimal weight;

  // bi-directional many-to-one association to Profile
  @ManyToOne
  @JoinColumn(name = "PROFILE_ID")
  private Profile profile;

  public Profileattribute() {}

  public String getBloodGroup() {
    return this.bloodGroup;
  }

  public void setBloodGroup(final String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  public String getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final String createdBy) {
    this.createdBy = createdBy;
  }

  public String getExpectations() {
    return this.expectations;
  }

  public void setExpectations(final String expectations) {
    this.expectations = expectations;
  }

  public String getHeight() {
    return this.height;
  }

  public void setHeight(final String height) {
    this.height = height;
  }

  public String getHobbies() {
    return this.hobbies;
  }

  public void setHobbies(final String hobbies) {
    this.hobbies = hobbies;
  }

  public String getIncome() {
    return this.income;
  }

  public void setIncome(final String income) {
    this.income = income;
  }

  public String getLanguages() {
    return this.languages;
  }

  public void setLanguages(final String languages) {
    this.languages = languages;
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

  public String getManglik() {
    return this.manglik;
  }

  public void setManglik(final String manglik) {
    this.manglik = manglik;
  }

  public String getOccupation() {
    return this.occupation;
  }

  public void setOccupation(final String occupation) {
    this.occupation = occupation;
  }

  public String getSkinColour() {
    return this.skinColour;
  }

  public void setSkinColour(final String skinColour) {
    this.skinColour = skinColour;
  }

  public BigDecimal getWeight() {
    return this.weight;
  }

  public void setWeight(final BigDecimal weight) {
    this.weight = weight;
  }

  public Profile getProfile() {
    return this.profile;
  }

  public void setProfile(final Profile profile) {
    this.profile = profile;
  }

}

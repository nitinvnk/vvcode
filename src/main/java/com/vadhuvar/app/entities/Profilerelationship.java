package com.vadhuvar.app.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the PROFILERELATIONSHIP database table.
 *
 */
@Entity
@Table(name = "PROFILERELATIONSHIP")
@NamedQuery(name = "Profilerelationship.findAll", query = "SELECT p FROM Profilerelationship p")
public class Profilerelationship implements Serializable {

  private static final long serialVersionUID = 7387603715535246456L;

  @Id
  @Column(name = "PR_ID")
  private long prId;

  @Column(name = "CREATED_BY")
  private String createdBy;

  @Column(name = "CREATED_DATE")
  private Timestamp createdDate;

  @Column(name = "LASTUPDATED_BY")
  private String lastupdatedBy;

  @Column(name = "LASTUPDATED_DATE")
  private Timestamp lastupdatedDate;

  @Column(name = "PROFILE_RELATIONSHIP")
  private String profileRelationship;

  // bi-directional many-to-one association to Profilecontact
  @OneToMany(mappedBy = "profilerelationship")
  private List<Profilecontact> profilecontacts;

  public Profilerelationship() {}

  public long getPrId() {
    return this.prId;
  }

  public void setPrId(final long prId) {
    this.prId = prId;
  }

  public String getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final String createdBy) {
    this.createdBy = createdBy;
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

  public String getProfileRelationship() {
    return this.profileRelationship;
  }

  public void setProfileRelationship(final String profileRelationship) {
    this.profileRelationship = profileRelationship;
  }

  public List<Profilecontact> getProfilecontacts() {
    return this.profilecontacts;
  }

  public void setProfilecontacts(final List<Profilecontact> profilecontacts) {
    this.profilecontacts = profilecontacts;
  }

  public Profilecontact addProfilecontact(final Profilecontact profilecontact) {
    getProfilecontacts().add(profilecontact);
    profilecontact.setProfilerelationship(this);

    return profilecontact;
  }

  public Profilecontact removeProfilecontact(final Profilecontact profilecontact) {
    getProfilecontacts().remove(profilecontact);
    profilecontact.setProfilerelationship(null);

    return profilecontact;
  }

}

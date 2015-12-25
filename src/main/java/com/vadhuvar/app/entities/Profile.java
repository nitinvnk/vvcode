package com.vadhuvar.app.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the "PROFILE" database table.
 *
 */
@Entity
@Table(name = "PROFILE")
@NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p")
public class Profile implements Serializable {

  private static final long serialVersionUID = 2543093921944036965L;

  @Id
  @Column(name = "PROFILE_ID")
  private long profileId;

  @Column(name = "ADRESS")
  private String address;

  @Column(name = "AGE")
  private BigDecimal age;

  @Column(name = "CITY")
  private String city;

  @Column(name = "CREATED_BY")
  private String createdBy;

  @Column(name = "CREATED_DATE")
  private Timestamp createdDate;

  @Column(name = "FIRSTNAME")
  private String firstname;

  @Column(name = "LASTNAME")
  private String lastname;

  @Column(name = "LASTUPDATED_BY")
  private String lastupdatedBy;

  @Column(name = "LASTUPDATED_DATE")
  private Timestamp lastupdatedDate;

  @Column(name = "MIDDLENAME")
  private String middlename;

  @Column(name = "PHOTO_URL")
  private String photoUrl;

  @Column(name = "STATE")
  private String state;

  // bi-directional many-to-one association to Caste
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "CASTE_ID")
  private Caste caste;

  // bi-directional many-to-one association to Maritalstatus
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "MARTIAL_STATUS_ID")
  private MaritalStatus maritalstatus;

  // bi-directional many-to-one association to Religion
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "RELIGION_ID")
  private Religion religion;

  // bi-directional many-to-one association to Sex
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "SEX_ID")
  private Sex sex;

  // bi-directional many-to-one association to Profileattribute
  @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Profileattribute> profileattributes;

  // bi-directional many-to-one association to Profilecontact
  @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Profilecontact> profilecontacts;

  public Profile() {}

  public long getProfileId() {
    return this.profileId;
  }

  public void setProfileId(final long profileId) {
    this.profileId = profileId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(final String address) {
    this.address = address;
  }

  public BigDecimal getAge() {
    return this.age;
  }

  public void setAge(final BigDecimal age) {
    this.age = age;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(final String city) {
    this.city = city;
  }

  public String getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final String createdBy) {
    this.createdBy = createdBy;
  }

  public String getFirstname() {
    return this.firstname;
  }

  public void setFirstname(final String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return this.lastname;
  }

  public void setLastname(final String lastname) {
    this.lastname = lastname;
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

  public String getMiddlename() {
    return this.middlename;
  }

  public void setMiddlename(final String middlename) {
    this.middlename = middlename;
  }

  public String getPhotoUrl() {
    return this.photoUrl;
  }

  public void setPhotoUrl(final String photoUrl) {
    this.photoUrl = photoUrl;
  }

  public String getState() {
    return this.state;
  }

  public void setState(final String state) {
    this.state = state;
  }

  public Caste getCaste() {
    return this.caste;
  }

  public void setCaste(final Caste caste) {
    this.caste = caste;
  }



  public Religion getReligion() {
    return this.religion;
  }

  public void setReligion(final Religion religion) {
    this.religion = religion;
  }

  public Sex getSex() {
    return this.sex;
  }

  public void setSex(final Sex sex) {
    this.sex = sex;
  }

  public List<Profileattribute> getProfileattributes() {
    if (this.profileattributes == null)
      this.profileattributes = new ArrayList<Profileattribute>();
    return this.profileattributes;
  }

  public void setProfileattributes(final List<Profileattribute> profileattributes) {
    this.profileattributes = profileattributes;
  }

  public MaritalStatus getMaritalstatus() {
    return maritalstatus;
  }

  public void setMaritalstatus(final MaritalStatus maritalstatus) {
    this.maritalstatus = maritalstatus;
  }

  public Profileattribute addProfileattribute(final Profileattribute profileattribute) {
    getProfileattributes().add(profileattribute);
    profileattribute.setProfile(this);

    return profileattribute;
  }

  public Profileattribute removeProfileattribute(final Profileattribute profileattribute) {
    getProfileattributes().remove(profileattribute);
    profileattribute.setProfile(null);

    return profileattribute;
  }

  public List<Profilecontact> getProfilecontacts() {
    if (this.profilecontacts == null)
      this.profilecontacts = new ArrayList<Profilecontact>();
    return this.profilecontacts;
  }

  public void setProfilecontacts(final List<Profilecontact> profilecontacts) {
    this.profilecontacts = profilecontacts;
  }

  public Profilecontact addProfilecontact(final Profilecontact profilecontact) {
    getProfilecontacts().add(profilecontact);
    profilecontact.setProfile(this);

    return profilecontact;
  }

  public Profilecontact removeProfilecontact(final Profilecontact profilecontact) {
    getProfilecontacts().remove(profilecontact);
    profilecontact.setProfile(null);

    return profilecontact;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((age == null) ? 0 : age.hashCode());
    result = prime * result + ((caste == null) ? 0 : caste.hashCode());
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
    result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
    result = prime * result + ((maritalstatus == null) ? 0 : maritalstatus.hashCode());
    result = prime * result + ((middlename == null) ? 0 : middlename.hashCode());
    result = prime * result + (int) (profileId ^ (profileId >>> 32));
    result = prime * result + ((religion == null) ? 0 : religion.hashCode());
    result = prime * result + ((sex == null) ? 0 : sex.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof Profile))
      return false;
    final Profile other = (Profile) obj;
    if (age == null) {
      if (other.age != null)
        return false;
    } else if (!age.equals(other.age))
      return false;
    if (caste == null) {
      if (other.caste != null)
        return false;
    } else if (!caste.equals(other.caste))
      return false;
    if (city == null) {
      if (other.city != null)
        return false;
    } else if (!city.equals(other.city))
      return false;
    if (firstname == null) {
      if (other.firstname != null)
        return false;
    } else if (!firstname.equals(other.firstname))
      return false;
    if (lastname == null) {
      if (other.lastname != null)
        return false;
    } else if (!lastname.equals(other.lastname))
      return false;
    if (maritalstatus == null) {
      if (other.maritalstatus != null)
        return false;
    } else if (!maritalstatus.equals(other.maritalstatus))
      return false;
    if (middlename == null) {
      if (other.middlename != null)
        return false;
    } else if (!middlename.equals(other.middlename))
      return false;
    if (profileId != other.profileId)
      return false;
    if (religion == null) {
      if (other.religion != null)
        return false;
    } else if (!religion.equals(other.religion))
      return false;
    if (sex == null) {
      if (other.sex != null)
        return false;
    } else if (!sex.equals(other.sex))
      return false;
    if (state == null) {
      if (other.state != null)
        return false;
    } else if (!state.equals(other.state))
      return false;
    return true;
  }
}

package com.vadhuvar.app.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * The persistent class for the CASTE database table.
 *
 */
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name = "CASTE")
public class Caste implements Serializable {

  private static final long serialVersionUID = -9172177608163380823L;

  @Id
  @Column(name = "CST_ID")
  private long cstId;

  @Column(name = "CASTE_NAME")
  private String casteName;

  @Column(name = "CREATED_BY")
  private String createdBy;

  @Column(name = "CREATED_DATE")
  private Timestamp createdDate;

  @Column(name = "LASTUPDATED_BY")
  private String lastupdatedBy;

  @Column(name = "LASTUPDATED_DATE")
  private Timestamp lastupdatedDate;

  // bi-directional many-to-one association to Religion
  @ManyToOne
  @JoinColumn(name = "REG_ID")
  private Religion religion;

  public Caste() {}

  public long getCstId() {
    return this.cstId;
  }

  public void setCstId(final long cstId) {
    this.cstId = cstId;
  }

  public String getCasteName() {
    return this.casteName;
  }

  public void setCasteName(final String casteName) {
    this.casteName = casteName;
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

  public Religion getReligion() {
    return this.religion;
  }

  public void setReligion(final Religion religion) {
    this.religion = religion;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((casteName == null) ? 0 : casteName.hashCode());
    result = prime * result + (int) (cstId ^ (cstId >>> 32));
    result = prime * result + ((religion == null) ? 0 : religion.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof Caste))
      return false;
    final Caste other = (Caste) obj;
    if (casteName == null) {
      if (other.casteName != null)
        return false;
    } else if (!casteName.equals(other.casteName))
      return false;
    if (cstId != other.cstId)
      return false;
    if (religion == null) {
      if (other.religion != null)
        return false;
    } else if (!religion.equals(other.religion))
      return false;
    return true;
  }

}

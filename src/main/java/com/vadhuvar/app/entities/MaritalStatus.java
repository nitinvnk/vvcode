package com.vadhuvar.app.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name = "MARITALSTATUS")
public class MaritalStatus implements Serializable {

  private static final long serialVersionUID = 5550903499294476841L;

  @Id
  @Column(name = "MS_ID")
  private long id;

  @Column(name = "MARITAL_STATUS")
  private String maritalStatus;

  @Column(name = "CREATED_DATE")
  private Timestamp createdDate;

  @Column(name = "CREATED_BY")
  private String createdBy;

  @Column(name = "LASTUPDATED_DATE")
  private Timestamp lastupdatedDate;

  @Column(name = "LASTUPDATED_BY")
  private String lastupdatedBy;

  public long getId() {
    return id;
  }

  public void setId(final long id) {
    this.id = id;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(final String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public Timestamp getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(final Timestamp createdDate) {
    this.createdDate = createdDate;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(final String createdBy) {
    this.createdBy = createdBy;
  }

  public Timestamp getLastupdatedDate() {
    return lastupdatedDate;
  }

  public void setLastupdatedDate(final Timestamp lastupdatedDate) {
    this.lastupdatedDate = lastupdatedDate;
  }

  public String getLastupdatedBy() {
    return lastupdatedBy;
  }

  public void setLastupdatedBy(final String lastupdatedBy) {
    this.lastupdatedBy = lastupdatedBy;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((maritalStatus == null) ? 0 : maritalStatus.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof MaritalStatus))
      return false;
    final MaritalStatus other = (MaritalStatus) obj;
    if (id != other.id)
      return false;
    if (maritalStatus == null) {
      if (other.maritalStatus != null)
        return false;
    } else if (!maritalStatus.equals(other.maritalStatus))
      return false;
    return true;
  }
}

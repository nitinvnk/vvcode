package com.vadhuvar.app.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The persistent class for the RELIGION database table.
 *
 */
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name = "RELIGION")
public class Religion implements Serializable {

  private static final long serialVersionUID = -771030352950436362L;

  @Id
  @Column(name = "REG_ID")
  private long regId;

  @Column(name = "CREATED_BY")
  private String createdBy;

  @Column(name = "CREATED_DATE")
  private Timestamp createdDate;

  @Column(name = "LASTUPDATED_BY")
  private String lastupdatedBy;

  @Column(name = "LASTUPDATED_DATE")
  private Timestamp lastupdatedDate;

  @Column(name = "RELIGION_NAME")
  private String religionName;

  // bi-directional many-to-one association to Caste
  @OneToMany(mappedBy = "religion", cascade = CascadeType.ALL)
  private List<Caste> castes;

  public Religion() {}

  public long getRegId() {
    return this.regId;
  }

  public void setRegId(final long regId) {
    this.regId = regId;
  }

  public String getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final String createdBy) {
    this.createdBy = createdBy;
  }

  public Timestamp getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(final Timestamp createdDate) {
    this.createdDate = createdDate;
  }

  public String getLastupdatedBy() {
    return this.lastupdatedBy;
  }

  public void setLastupdatedBy(final String lastupdatedBy) {
    this.lastupdatedBy = lastupdatedBy;
  }

  public Timestamp getLastupdatedDate() {
    return lastupdatedDate;
  }

  public void setLastupdatedDate(final Timestamp lastupdatedDate) {
    this.lastupdatedDate = lastupdatedDate;
  }

  public String getReligionName() {
    return this.religionName;
  }

  public void setReligionName(final String religionName) {
    this.religionName = religionName;
  }

  public List<Caste> getCastes() {
    return this.castes;
  }

  public void setCastes(final List<Caste> castes) {
    this.castes = castes;
  }

  public Caste addCaste(final Caste caste) {
    getCastes().add(caste);
    caste.setReligion(this);
    return caste;
  }

  public Caste removeCaste(final Caste caste) {
    getCastes().remove(caste);
    caste.setReligion(null);
    return caste;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((castes == null) ? 0 : castes.hashCode());
    result = prime * result + (int) (regId ^ (regId >>> 32));
    result = prime * result + ((religionName == null) ? 0 : religionName.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof Religion))
      return false;
    final Religion other = (Religion) obj;
    if (castes == null) {
      if (other.castes != null)
        return false;
    } else if (!castes.equals(other.castes))
      return false;
    if (regId != other.regId)
      return false;
    if (religionName == null) {
      if (other.religionName != null)
        return false;
    } else if (!religionName.equals(other.religionName))
      return false;
    return true;
  }
}

package com.vadhuvar.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vadhuvar.app.entities.Profile;

@Repository
@Transactional
public class ProfileDAOImpl extends Parent implements ProfileDAO {

  @SuppressWarnings("unchecked")
  @Override
  public List<Profile> listProfile(final String sortBy, final String sortType) throws Exception {
    final Criteria criteria = getSession().createCriteria(Profile.class);
    if (sortBy != null && sortType != null && sortType.equalsIgnoreCase("ASC")) {
      criteria.addOrder(Order.asc(sortBy));
    } else if (sortBy != null && sortType != null && sortType.equalsIgnoreCase("DESC")) {
      criteria.addOrder(Order.desc(sortBy));
    } else {
      criteria.addOrder(Order.desc("LASTUPDATED_DATE"));
    }
    criteria.setFirstResult(1);
    criteria.setMaxResults(10);
    final List<Profile> profiles = criteria.list();
    return profiles;
  }

  @Override
  public void saveProfile(final Profile profile) {
    getSession().save(profile);
  }

  @Override
  public Profile getProfile(final Long profileId) {
    final Profile profile = (Profile) getSession().get(Profile.class, profileId);
    return profile;
  }
}

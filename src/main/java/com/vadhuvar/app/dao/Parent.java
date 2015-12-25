package com.vadhuvar.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Parent {

  @Autowired
  SessionFactory sessionFactory;

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public void setSessionFactory(final SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public Session getSession() {
    return getSessionFactory().getCurrentSession();
  }
}

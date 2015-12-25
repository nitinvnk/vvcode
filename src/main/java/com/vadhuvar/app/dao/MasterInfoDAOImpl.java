package com.vadhuvar.app.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.vadhuvar.app.entities.MaritalStatus;
import com.vadhuvar.app.entities.Religion;
import com.vadhuvar.app.entities.Sex;

@Repository
@Transactional
public class MasterInfoDAOImpl extends Parent implements MasterInfoDAO {

  private final Logger logger = Logger.getLogger(MasterInfoDAOImpl.class);
  private long startTime = 0l;
  private long endTime = 0l;

  @SuppressWarnings("unchecked")
  @Override
  public List<MaritalStatus> listMarialStatus() throws Exception {
    logger.debug("Entering MasterInfoDAOImpl's listMarialStatus");
    startTime = System.currentTimeMillis();
    final List<MaritalStatus> maritalStatuses =
        getSession().createCriteria(MaritalStatus.class).list();
    endTime = System.currentTimeMillis();
    if (logger.isDebugEnabled()) {
      logger.debug("Exiting MasterInfoDAOImpl's listMarialStatus, time Took :: "
          + (endTime - startTime) + " ms.");
    }
    return maritalStatuses;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Sex> listSex() throws Exception {
    logger.debug("Entering MasterInfoDAOImpl's listSex");
    startTime = System.currentTimeMillis();
    final List<Sex> sexes = getSession().createCriteria(Sex.class).list();
    endTime = System.currentTimeMillis();
    if (logger.isDebugEnabled()) {
      logger.debug(
          "Exiting MasterInfoDAOImpl's listSex, time Took :: " + (endTime - startTime) + " ms.");
    }
    return sexes;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Religion> listReligion() throws Exception {
    logger.debug("Entering MasterInfoDAOImpl's listReligion");
    startTime = System.currentTimeMillis();
    final List<Religion> religions = getSession().createCriteria(Religion.class).list();
    if (!CollectionUtils.isEmpty(religions)) {
      for (final Religion religion : religions) {
        religion.getCastes().size();
      }
    }
    endTime = System.currentTimeMillis();
    if (logger.isDebugEnabled()) {
      logger.debug("Exiting MasterInfoDAOImpl's listReligion, time Took :: " + (endTime - startTime)
          + " ms.");
    }
    return religions;
  }
}

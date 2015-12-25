package com.vadhuvar.app.controller;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vadhuvar.app.services.MasterInfoService;
import com.vadhuvar.app.services.ProfileService;
import com.vadhuvar.app.utilities.MailingEngine;
import com.vadhuvar.app.vo.MaritalStatusVO;
import com.vadhuvar.app.vo.ProfileVO;
import com.vadhuvar.app.vo.ReligionVO;
import com.vadhuvar.app.vo.SexVO;

@RestController
@RequestMapping("/")
public class AppController {

  private final Logger logger = Logger.getLogger(AppController.class);

  private long startTime = 0l;

  private long endTime = 0l;

  @Autowired
  private MasterInfoService masterInfoService;

  @Autowired
  private ProfileService profileService;

  @Autowired
  private MailingEngine mailEngine;


  @RequestMapping(value = "/service/greeting/{name}")
  @ResponseBody
  public String greet(@PathVariable(value = "name") final String name) {
    return "Hello " + name;
  }

  @RequestMapping(value = "/service/listmaritalstatuses/")
  @ResponseBody
  public List<MaritalStatusVO> listMaritalStatus() {
    logger.info("Entering AppController's listMaritalStatus");
    try {
      startTime = System.currentTimeMillis();
      return masterInfoService.listMarialStatus();
    } catch (final Exception e) {
      e.printStackTrace();
    } finally {
      endTime = System.currentTimeMillis();
      logger.info("Exiting AppController's listMaritalStatus, total Time to Took :: "
          + (endTime - startTime) + " ms.");
    }
    return Collections.emptyList();
  }

  @RequestMapping(value = "/service/listsex/")
  @ResponseBody
  public List<SexVO> listsex() {
    logger.info("Entering AppController's listsex");
    try {
      startTime = System.currentTimeMillis();
      return masterInfoService.listSex();
    } catch (final Exception e) {
      e.printStackTrace();
    } finally {
      endTime = System.currentTimeMillis();
      logger.info("Exiting AppController's listsex, total Time to Took :: " + (endTime - startTime)
          + " ms.");
    }
    return Collections.emptyList();
  }

  @RequestMapping(value = "/service/listprofiles/{sortBy}/{sortType}")
  @ResponseBody
  public List<ProfileVO> listProfiles(@PathVariable(value = "sortBy") final String sortBy,
      @PathVariable(value = "sortType") final String sortType) {
    logger.info("Entering AppController's listProfiles");
    try {
      startTime = System.currentTimeMillis();
      return profileService.listProfiles(sortBy, sortType);
    } catch (final Exception e) {
      e.printStackTrace();
    } finally {
      endTime = System.currentTimeMillis();
      logger.info("Exiting AppController's listProfiles, total Time to Took :: "
          + (endTime - startTime) + " ms.");
    }
    return Collections.emptyList();
  }

  @RequestMapping(value = "/service/getprofiledetails/{profileId}")
  @ResponseBody
  public ProfileVO getProfileDetails(@PathVariable(value = "profileId") final String profileId) {
    logger.info("Entering AppController's getProfileDetails");
    startTime = System.currentTimeMillis();
    final ProfileVO profileVO = null;
    try {
      return profileService.getProfileDetails(Long.valueOf(profileId));
    } catch (final NumberFormatException e) {
      e.printStackTrace();
    } catch (final Exception e) {
      e.printStackTrace();
    } finally {
      endTime = System.currentTimeMillis();
      logger.info("Exiting AppController's getProfileDetails, total Time to Took :: "
          + (endTime - startTime) + " ms.");
    }
    return profileVO;
  }

  @RequestMapping(value = "/service/listreligions/")
  @ResponseBody
  public List<ReligionVO> listReligion() {
    logger.info("Entering AppController's listReligion");
    try {
      startTime = System.currentTimeMillis();
      return masterInfoService.listReligion();
    } catch (final Exception e) {
      e.printStackTrace();
    } finally {
      endTime = System.currentTimeMillis();
      logger.info("Exiting AppController's listReligion, total Time to Took :: "
          + (endTime - startTime) + " ms.");
    }
    return Collections.emptyList();
  }
}

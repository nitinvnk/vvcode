package com.vadhuvar.app.dao;

import java.util.List;

import com.vadhuvar.app.entities.Profile;

public interface ProfileDAO {

  public List<Profile> listProfile(String sortBy, String sortType) throws Exception;

  public void saveProfile(Profile profile);

  public Profile getProfile(Long profileId);

}

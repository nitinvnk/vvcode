package com.vadhuvar.app.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.vadhuvar.app.dao.ProfileDAO;
import com.vadhuvar.app.entities.Profile;
import com.vadhuvar.app.transformer.ProfileTransformer;
import com.vadhuvar.app.vo.ProfileVO;

@Service
public class ProfileServiceImpl implements ProfileService {

  @Autowired
  private ProfileDAO profileDAO;

  @Override
  public List<ProfileVO> listProfiles(final String sortBy, final String sortType) throws Exception {
    List<ProfileVO> profiles = Collections.<ProfileVO>emptyList();
    final List<Profile> listProfile = profileDAO.listProfile(sortBy, sortType);
    if (!CollectionUtils.isEmpty(listProfile)) {
      profiles = new ArrayList<ProfileVO>();
      for (final Profile profile : listProfile) {
        profiles.add(ProfileTransformer.convertToProfileVO(profile, false));
      }
    }
    return profiles;
  }

  @Override
  public ProfileVO getProfileDetails(final long profileId) throws Exception {
    final Profile profile = profileDAO.getProfile(profileId);
    return ProfileTransformer.convertToProfileVO(profile, true);
  }

}

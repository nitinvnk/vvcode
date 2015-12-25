package com.vadhuvar.app.transformer;

import com.vadhuvar.app.entities.Profile;
import com.vadhuvar.app.entities.Profileattribute;
import com.vadhuvar.app.entities.Profilecontact;
import com.vadhuvar.app.vo.ProfileVO;

public class ProfileTransformer {

  public static ProfileVO convertToProfileVO(final Profile profile, final boolean isDetails) {
    final ProfileVO profileVO = new ProfileVO();
    if (profile != null) {
      profileVO.setFirstname(profile.getFirstname());
      profileVO.setMiddlename(profile.getMiddlename());
      profileVO.setLastname(profile.getLastname());
      profileVO.setAge(profile.getAge().intValue());
      profileVO.setSex(profile.getSex().getSex());
      profileVO.setMaritalstatus(profile.getMaritalstatus().getMaritalStatus());
      profileVO.setPhotoUrl(profile.getPhotoUrl());
      profileVO.setCity(profile.getCity());
      profileVO.setState(profile.getState());

      final Profileattribute profileattribute = profile.getProfileattributes().get(0);
      profileVO.setBloodGroup(profileattribute.getBloodGroup());
      profileVO.setHeight(profileattribute.getHeight());
      profileVO.setOccupation(profileattribute.getOccupation());
      profileVO.setLanguages(profileattribute.getLanguages());
      if (isDetails) {
        profileVO.setHobbies(profileattribute.getHobbies());
        profileVO.setExpectations(profileattribute.getExpectations());
        profileVO.setIncome(profileattribute.getIncome());
        profileVO.setWeight(profileattribute.getWeight().intValue());

        final Profilecontact profilecontact = profile.getProfilecontacts().get(0);
        profileVO.setEmail(profilecontact.getEmail());
        profileVO.setMobileNumber(profilecontact.getMobileNumber());
        profileVO.setPhoneNumber(profilecontact.getPhoneNumber());
        profileVO.setWhatsapp(profilecontact.getWhatsapp());
      }
    }
    return profileVO;
  }

}

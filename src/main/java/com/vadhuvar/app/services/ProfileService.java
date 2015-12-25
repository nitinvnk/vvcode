package com.vadhuvar.app.services;

import java.util.List;

import com.vadhuvar.app.vo.ProfileVO;

public interface ProfileService {

	List<ProfileVO> listProfiles(String sortBy, String sortType) throws Exception;
	
	ProfileVO getProfileDetails(long profileId) throws Exception;
}

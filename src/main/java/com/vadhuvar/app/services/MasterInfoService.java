package com.vadhuvar.app.services;

import java.util.List;

import com.vadhuvar.app.vo.MaritalStatusVO;
import com.vadhuvar.app.vo.ReligionVO;
import com.vadhuvar.app.vo.SexVO;

public interface MasterInfoService {

	List<MaritalStatusVO> listMarialStatus() throws Exception;
	
	List<SexVO> listSex() throws Exception;
	
	List<ReligionVO> listReligion() throws Exception;
	
}

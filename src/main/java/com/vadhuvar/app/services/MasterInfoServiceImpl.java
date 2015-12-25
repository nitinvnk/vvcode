package com.vadhuvar.app.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.vadhuvar.app.dao.MasterInfoDAO;
import com.vadhuvar.app.entities.Caste;
import com.vadhuvar.app.entities.MaritalStatus;
import com.vadhuvar.app.entities.Religion;
import com.vadhuvar.app.entities.Sex;
import com.vadhuvar.app.vo.CasteVO;
import com.vadhuvar.app.vo.MaritalStatusVO;
import com.vadhuvar.app.vo.ReligionVO;
import com.vadhuvar.app.vo.SexVO;

@Service
public class MasterInfoServiceImpl implements MasterInfoService {

	@Autowired
	MasterInfoDAO masterInfoDAO;

	@Override
	public List<MaritalStatusVO> listMarialStatus() throws Exception {
		List<MaritalStatusVO> maritalStatusVOs = Collections.emptyList();
		List<MaritalStatus> listMarialStatus = masterInfoDAO.listMarialStatus();
		if (!CollectionUtils.isEmpty(listMarialStatus)) {
			maritalStatusVOs = new ArrayList<MaritalStatusVO>();
			for (MaritalStatus maritalStatus : listMarialStatus) {
				MaritalStatusVO maritalStatusVO = new MaritalStatusVO();
				maritalStatusVO.setId(maritalStatus.getId());
				maritalStatusVO.setMaritalStatus(maritalStatus.getMaritalStatus());
				maritalStatusVOs.add(maritalStatusVO);
			}
		}
		return maritalStatusVOs;
	}

	@Override
	public List<SexVO> listSex() throws Exception {
		List<SexVO> sexVOs = Collections.emptyList();
		List<Sex> listSex = masterInfoDAO.listSex();
		if (!CollectionUtils.isEmpty(listSex)) {
			sexVOs = new ArrayList<SexVO>();
			for (Sex sex : listSex) {
				SexVO sexVO = new SexVO();
				sexVO.setId(sex.getId());
				sexVO.setSex(sex.getSex());
				sexVOs.add(sexVO);
			}
		}
		return sexVOs;
	}

	@Override
	public List<ReligionVO> listReligion() throws Exception {
		List<ReligionVO> religionVOs = Collections.emptyList();
		List<Religion> religions = masterInfoDAO.listReligion();
		if (!CollectionUtils.isEmpty(religions)) {
			religionVOs = new ArrayList<ReligionVO>();
			List<CasteVO> castes = new ArrayList<CasteVO>();
			for (Religion religion : religions) {
				ReligionVO religionVO = new ReligionVO();
				religionVO.setRegId(religion.getRegId());
				religionVO.setRegName(religion.getReligionName());
				for (Caste caste : religion.getCastes()) {
					CasteVO casteVO = new CasteVO();
					casteVO.setCstId(caste.getCstId());
					casteVO.setCasteName(caste.getCasteName());
					casteVO.setRegId(caste.getReligion().getRegId());
					castes.add(casteVO);
					religionVO.setCasteVOs(castes);
				}
				
				religionVOs.add(religionVO);
			}
		}
		return religionVOs;
	}

}

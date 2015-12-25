package com.vadhuvar.app.dao;

import java.util.List;

import com.vadhuvar.app.entities.MaritalStatus;
import com.vadhuvar.app.entities.Religion;
import com.vadhuvar.app.entities.Sex;

public interface MasterInfoDAO {

  List<MaritalStatus> listMarialStatus() throws Exception;

  List<Sex> listSex() throws Exception;

  List<Religion> listReligion() throws Exception;
}

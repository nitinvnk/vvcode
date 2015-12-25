package com.vadhuvar.app.vo;

import java.util.List;

public class ReligionVO {

  private long regId;

  private String regName;

  private List<CasteVO> castes;

  public long getRegId() {
    return regId;
  }

  public void setRegId(final long regId) {
    this.regId = regId;
  }

  public String getRegName() {
    return regName;
  }

  public void setRegName(final String regName) {
    this.regName = regName;
  }

  public List<CasteVO> getCasteVOs() {
    return castes;
  }

  public void setCasteVOs(final List<CasteVO> casteVOs) {
    this.castes = casteVOs;
  }
}

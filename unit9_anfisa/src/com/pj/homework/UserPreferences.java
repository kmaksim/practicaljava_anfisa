package com.pj.homework;

import java.awt.Color;
import java.io.Serializable;

public class UserPreferences implements Serializable {

  public Color getPropColour() {
    return propColor;
  }

  public void setPropColour(Color propColor) {
    this.propColor = propColor;
  }

  public String getPropFontLogicalName() {
    return propFontLogicalName;
  }

  public void setPropFontLogicalName(String propFontLogicalName) {
    this.propFontLogicalName = propFontLogicalName;
  }

  public int getPropFontSize() {
    return propFontSize;
  }

  public void setPropFontSize(int propFontSize) {
    this.propFontSize = propFontSize;
  }

  /**
   * Text field properties 
   */
  private Color propColor;
  private String propFontLogicalName;
  private int propFontSize;

  public UserPreferences() {
    this.propColor = Color.BLUE;
    this.propFontLogicalName = "Serif";
    this.propFontSize = 12;

  }
  
  public UserPreferences(Color propColour, String propFontFace, int propFontSize) {
    this.propColor = propColor;
    this.propFontLogicalName = propFontFace;
    this.propFontSize = propFontSize;

  }
  
}  

  
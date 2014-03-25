package com.pj.BikeStore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener  {
	/**
   * 
   */
  private final BikesStore1 bikesStore1;

  /**
   * @param bikesStore1
   */
  ClickListener(BikesStore1 bikesStore1) {
    this.bikesStore1 = bikesStore1;
  }

  public void actionPerformed(ActionEvent e) {
		BikesStore1.log.info("clicked" + BikesStore1.comboBikeBrands.getSelectedIndex());
		
		try {
      this.bikesStore1.validateBikeNumber(BikesStore1.textFieldNumberOfBikes.getText());
    } catch (TooManyBikesException e1) {
      BikesStore1.log.info("Caught " + e1 + "\n");
      BikesStore1.textAreaOutputOrderStatus.setText("Thank you for your order! \nUnfortunetely we can  "+
       "deliver only \n" + BikesStore1.truckLimits + " bikes in one day.");
      //e1.printStackTrace();
    }   		
	}
}
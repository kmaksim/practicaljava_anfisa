package com.pj.frametests.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class ClickListener1 implements ActionListener {
	private Random r = new Random();

	public void actionPerformed(ActionEvent e) {
		
		System.out.println("clicked");
		//InnerClassOutTest.label.setText("test" + r.nextInt());
		InnerClassTakenOutTest.label.setText("test" + r.nextInt());
	}
}
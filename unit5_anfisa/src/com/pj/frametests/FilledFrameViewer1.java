package com.pj.frametests;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FilledFrameViewer1 {
	
	public static void main(String[] args) {
		JFrame frame = new FilledFrame();

		frame.setTitle("Frame sample title");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}

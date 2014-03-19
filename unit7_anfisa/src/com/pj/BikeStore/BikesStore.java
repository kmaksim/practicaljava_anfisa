package com.pj.BikeStore;
import javax.swing.BoxLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import java.util.logging.Logger;

/**
* Bike Store
* An example of custom exception usage, combobox usage, gridbag layout 
* and text field input value validation, including clipboard content
**/

public class BikesStore extends JFrame{
	private JButton buttonOrder;
  private GridBagLayout layoutGBC;
  private GridBagConstraints constraints;
  private JPanel panel;
  static String[] bikeBrands;
  static JLabel labelOutputOrderStatus;
	static JLabel labelTitle;
	static JLabel labelComboBikeBrands;
	static JComboBox<?> comboBikeBrands;
	static JLabel labelComboNumberOfBikes;
	static JTextField textFieldNumberOfBikes;
	static JTextArea textAreaOutputOrderStatus;
	static Logger log = Logger.getLogger("com.pj.BikeStore");
	static int truckLimits = 10;
	
  class TooManyBikesExc extends Exception {
    TooManyBikesExc() {
    }
     
    TooManyBikesExc(String message) {
      super(message);
      log.info ("Too many bikes !!!!" + message);
    }
  }
	
	public class ClickListener implements ActionListener  {
		public void actionPerformed(ActionEvent e) {
			log.info("clicked" + comboBikeBrands.getSelectedIndex());
			
			try {
	      validateBikeNumber(textFieldNumberOfBikes.getText());
	    } catch (TooManyBikesExc e1) {
	      log.info("Caught " + e1 + "\n");
	      textAreaOutputOrderStatus.setText("Thank you for your order! \nUnfortunetely we can  "+
	       "deliver only \n" + truckLimits + " bikes in one day.");
	      //e1.printStackTrace();
	    }   		
		}
	}
	
	 public void validateBikeNumber(String text) throws TooManyBikesExc {
	   log.info (" " + textFieldNumberOfBikes.getText() );
	   if ( textFieldNumberOfBikes.getText().equals("") ||  
	       Integer.parseInt(textFieldNumberOfBikes.getText()) == 0  ) {
       textAreaOutputOrderStatus.setText("Thank you for your interest! \n Add at least one bike to the order.");
	    } else if (Integer.parseInt(textFieldNumberOfBikes.getText())  > truckLimits ) {
	        throw new TooManyBikesExc(">>>Too many Bikes exception<<<");
	    } else if (Integer.parseInt(textFieldNumberOfBikes.getText())  == 1 ) {
	      textAreaOutputOrderStatus.setText("Thank you for your order! \nYou ordered " + 
	          Integer.parseInt(textFieldNumberOfBikes.getText()) + " \""  + bikeBrands[comboBikeBrands.getSelectedIndex()]
	              + "\" bike.\nWe will deliver it overnight.");
	    } else {
	      textAreaOutputOrderStatus.setText("Thank you for your order! \nYou ordered " + 
	      Integer.parseInt(textFieldNumberOfBikes.getText()) + " \""  + bikeBrands[comboBikeBrands.getSelectedIndex()]
	          + "\" bikes.\nWe will deliver them overnight.");
	    }
	  }
	
	public static void main(String[] args) {
    /**initiate brands*/
    bikeBrands = new String[] { "Helkama", "Dahon", "Kama", "Orlejonok", "Author" };
		JFrame frame = new BikesStore();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),
				BoxLayout.Y_AXIS));
		frame.setTitle("Bike Store");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

  public BikesStore() {
		createComponents();
		setSize(300,300);
	}
 
  
  private void addComponent( Component component,
      int row, int column, int width, int height )
  {
    constraints.gridx = column; // set gridx                           
    constraints.gridy = row; // set gridy                              
    constraints.gridwidth = width; // set gridwidth                    
    constraints.gridheight = height; // set gridheight                 
    layoutGBC.setConstraints( component, constraints ); 
    panel.add( component );                                  
  } 
  
  private void createComponents() {
    
	  labelComboBikeBrands = new JLabel("Choose the brand:");
	  comboBikeBrands = new JComboBox(bikeBrands);
	  comboBikeBrands.setSelectedIndex(0);
		labelComboNumberOfBikes = new JLabel("Enter the number of bikes to ship:");
		
		textFieldNumberOfBikes = new JFormattedTextField();
		/** the following code idea to filter out non-digital simbols is from
		 * http://edenti.deis.unibo.it/utils/Java-tips/Validating%20numerical%20input%20in%20a%20JTextField.txt
		 */
		textFieldNumberOfBikes.addKeyListener(new java.awt.event.KeyAdapter() {  
      public void keyTyped(java.awt.event.KeyEvent evt) {  
        char c=evt.getKeyChar();
        if (!(Character.isDigit(c)) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE) {
          getToolkit().beep();
          evt.consume();
        }
      }
		});
		/**setTransferHandler blocks paste*/
		textFieldNumberOfBikes.setTransferHandler(null);
		
    buttonOrder = new JButton("Click to place an order");
    textAreaOutputOrderStatus = new JTextArea(5,2);
    textAreaOutputOrderStatus.setBackground(Color.LIGHT_GRAY);
    textAreaOutputOrderStatus.setColumns(5);
    textAreaOutputOrderStatus.setEditable(false);
	  
		panel = new JPanel();
		ActionListener listener = new ClickListener();
		buttonOrder.addActionListener(listener); 
		/**titles for frames*/
		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder("Bike Shop");
		TitledBorder title2;
    title2 = BorderFactory.createTitledBorder("Order Status");
    textAreaOutputOrderStatus.setBorder(title2);
		
    /** Set the layout manager for this panel */
    layoutGBC = new GridBagLayout() ;                                                       
    constraints = new GridBagConstraints(); // instantiate constraints
    
    constraints.fill = GridBagConstraints.BOTH;
    addComponent( labelComboBikeBrands,      0, 0, 1, 1 );
    addComponent( comboBikeBrands,           1, 0, 1, 1 );
    addComponent( labelComboNumberOfBikes,   2, 0, 1, 1 );
    addComponent( textFieldNumberOfBikes,    3, 0, 1, 1 );
    addComponent( buttonOrder,               4, 0, 1, 1 );
    addComponent( textAreaOutputOrderStatus, 5, 0, 1, 1 );
    
		panel.setBorder(title1);
		panel.setBackground(Color.LIGHT_GRAY);
    panel.setLayout(layoutGBC);
		add(panel);
	}
}


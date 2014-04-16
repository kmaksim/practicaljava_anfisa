
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;


public class SwingWorkerTestProgress  {

  /**
   * Read files in GUI with SwingWorker help
   */
  private static final int PROGRESS_BAR_MAX = 10;
  static JButton buttonRead;
  static NewsReaderProgress task1;
  static NewsReaderProgress task2;
  public static JTextArea textArea1;
  public static JTextArea textArea2;
  static JProgressBar progressBar;
  
  static void setUpGUI() {
    
    String text = "File contents placeholder";
    
    textArea1 = new JTextArea(text, 5, 10);
    
    textArea1.setPreferredSize(new Dimension(100, 100));
    
    textArea2 = new JTextArea(text, 5, 10);
    
    textArea2.setPreferredSize(new Dimension(100, 100));
    
    JScrollPane scrollPane1 = new JScrollPane(textArea1,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    
    JScrollPane scrollPane2 = new JScrollPane(textArea2,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    
    textArea1.setLineWrap(true);
    
    textArea2.setLineWrap(true);

    buttonRead = new JButton("Read Files");
    
    progressBar = new JProgressBar(0, PROGRESS_BAR_MAX);
    
    JPanel panel = new JPanel();
    
    panel.setLayout(new FlowLayout());
        
    panel.add(scrollPane1);
    panel.add(scrollPane2); 
    panel.add(buttonRead);
    panel.add(progressBar);
    
    //create border 
    TitledBorder titleBorder = BorderFactory.createTitledBorder("File Reader");
    panel.setBorder(titleBorder);
    
    JFrame frame = new JFrame("SwingWorker");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(panel);
    frame.pack();
    frame.setVisible(true);
    
    frame.setSize(350,200);

    
    //add(panel);

    buttonRead.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        try{
          
          task1.execute();
          task2.execute();
          
          //String res1 = task1.get();
          //String res2 = task2.get();
          
          //textArea1.setText(res1);
          //textArea2.setText(res2);
                 
         } catch (Exception e1){
             e1.printStackTrace();
         }
          
      }
  });
       
    task1 = new NewsReaderProgress((new File("testText1.txt")),textArea1);
    task2 = new NewsReaderProgress((new File("testText2.txt")),textArea2);
    
    task1.addPropertyChangeListener(new PropertyChangeListener()
    {
        public void propertyChange(PropertyChangeEvent evt) {
            if    ("progress".equals(evt.getPropertyName())) {
                progressBar.setValue((Integer)evt.getNewValue())
    ;
            }
        }
    });
    
    // Define, instantiate and register a WindowAdapter
    // to process windowClosing Event of this frame

    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.out.println("Good bye!");
  	    System.exit(0);
        }
      });
  }
  
  public static void main(String args[]){
    
    
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        setUpGUI();
      }
  });
  }

}


import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;


public class SwingWorkerTest2 extends JFrame implements ActionListener {

  /**
   * Read files in GUI with SwingWorker help
   */
  
  JButton buttonRead;
  final NewsReader2 task1;
  final NewsReader2 task2;
  public static JTextArea textArea1;
  public static JTextArea textArea2;
  
  SwingWorkerTest2() {
    
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
    
    JPanel panel = new JPanel();
    
    panel.setLayout(new FlowLayout());
        
    panel.add(scrollPane1);
    panel.add(scrollPane2); 
    panel.add(buttonRead);
    
    //create border 
    TitledBorder titleBorder = BorderFactory.createTitledBorder("File Reader");
    panel.setBorder(titleBorder);
    
    add(panel);

    buttonRead.addActionListener(this);
       
    task1 = new NewsReader2(new File("testText1.txt"));
    task2 = new NewsReader2(new File("testText2.txt"));
    
    // Define, instantiate and register a WindowAdapter
    // to process windowClosing Event of this frame

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.out.println("Good bye!");
  	    System.exit(0);
        }
      });
  }


  public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    
    if (source == buttonRead ){
      // button processing
      try{
         
        task1.execute();
        task2.execute();
        
        //String res1 = task1.get();
        //String res2 = task2.get();
        
        //textArea1.setText(res1);
        //textArea2.setText(res2);
               
       } catch (Exception e){
           e.printStackTrace();
        }
     }    
  }
  
  public static void main(String args[]){
    SwingWorkerTest2 myFrame = new SwingWorkerTest2(); 

    myFrame.setSize(350,200);
    myFrame.setVisible(true);
  }
}

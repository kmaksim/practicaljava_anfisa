package com.pj.tictactoe.tests;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 * TicTacToe game for arbitrary board size
 * TODO: add AI, switch between players, message when game is even
 * change winning party test: 5 symbols in a row is enough to win
 * make it pretty (fix font, layout, play with images)
 */

public class TicTacToeAppletModified extends JApplet implements MouseListener
{	
  private static final String PLAYERX = "Player X"; 
  private static final String PLAYERO = "Player O";
  /**board side dimensions*/
  private static final int BOARDDIMENSIONS = 5;
  
  /**starting player name*/
  private String playerName = PLAYERX;
  
  private javax.swing.JButton[][] button;
  private javax.swing.JLabel playerNumber;
  private java.awt.Panel buttonsPanel;

  public void init(){
    initComponents();
  }

  private void initComponents(){
    buttonsPanel = new java.awt.Panel();
    
    /*Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);*/
    button = new JButton[BOARDDIMENSIONS][BOARDDIMENSIONS];
    for (int i=0;i<BOARDDIMENSIONS;i++) {
      for (int j=0;j<BOARDDIMENSIONS;j++) {  
        button[i][j] = new JButton("");
        button[i][j].addMouseListener(this);
        /*button[i][j].setFont(buttonFont);*/
        buttonsPanel.add(button[i][j]);
      }
    }
    
    playerNumber = new javax.swing.JLabel(playerName, SwingConstants.CENTER);
    buttonsPanel.setLayout(new java.awt.GridLayout(BOARDDIMENSIONS+1, BOARDDIMENSIONS));
    setPlayerName(PLAYERX); 
    buttonsPanel.add(playerNumber);
    JButton buttonClear = new JButton("clear");
    buttonsPanel.add(buttonClear);
    buttonClear.addMouseListener(this);
    add(buttonsPanel);
  }
  
  private void setPlayerName(String playerName){
    this.playerName = playerName;
    playerNumber.setText(playerName  + " your turn. ");
  }
  
  private void reset(){
    for (int i=0;i<BOARDDIMENSIONS;i++) {
      for (int j=0;j<BOARDDIMENSIONS;j++) {  
        button[i][j].setText("");
      }
    }
    setPlayerName(PLAYERX);
  }
  
  public void checkForWinner(){
	/**checks if there is a winner and informs player about game results*/   
    String [] str = {"OK"};
    String message; 
    String title;
    if(findThreeInARow()){
      String winnerName=(playerName == PLAYERX)?PLAYERO:PLAYERX;  
      message = winnerName.concat(" won!!! Congratulations!!!");
      title = "Congratulations!";  
      JOptionPane.showOptionDialog(this, message,
      		title, JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, str, "OK");
      reset(); 
    }       
  }
  
  public void mouseClicked(MouseEvent e) {
    javax.swing.JButton currentButton = (JButton)e.getComponent();
    if (currentButton.getText() == ""){
      if (playerName == PLAYERX) {
        currentButton.setText("X");
        setPlayerName(PLAYERO);
      } 
      else if (playerName == PLAYERO){
        currentButton.setText("O");
        setPlayerName(PLAYERX);
      }
    }
    if (currentButton.getText() == "clear"){
    	reset(); 
    }
    checkForWinner();
  }
  
  /**method below are necessary since we implement MouseListener*/
  public void mousePressed(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }
  
  private boolean findThreeInARow(){
    int i = 0;
    int j;
    String matches = "";
    /**test vertical matches*/
    for (i=0;i<BOARDDIMENSIONS;i++) {
      for (j=0;j<BOARDDIMENSIONS-1;j++) {	
        if (button[i][j].getText().equals(button[i][j+1].getText()) 
    		  && !button[i][j].getText().equals(""))  {
        	matches += "1"; 
        } else {
        	matches += "0";
        }
      }
      if (!matches.contains("0")) {
          return true;
      } else {
      	matches="";
      }
    }

    /**test horizontal matches*/
    matches="";
    for (j=0;j<BOARDDIMENSIONS-1;j++) {
      for (i=0;i<BOARDDIMENSIONS-1;i++) {	
        if (button[i][j].getText().equals(button[i+1 ][j].getText()) 
      		  && !button[i][j].getText().equals(""))  {
        	  matches += "1"; 
        } else {
          	matches += "0";
        }
      }
      if (!matches.contains("0")) {
        return true;
      } else {
        matches="";
      }  
    }
    
    /**test diagonal matches 1*/
    matches="";
    for (i=0;i<BOARDDIMENSIONS-1;i++) {
      if (button[i][i].getText().equals(button[i+1][i+1].getText()) 
    		  && !button[i][i].getText().equals("")) {
    	  matches += "1"; 
      } else {
      	matches += "0";
      }
    }
    if (!matches.contains("0")) {
        return true;
    }
    matches="";
    j = 0;
    for (i=BOARDDIMENSIONS-1;i>0;i--) {
      if (button[i][j].getText().equals(button[i - 1][j+1 ].getText()) 
          && !button[BOARDDIMENSIONS-1][0].getText().equals("")) {
    	  matches += "1"; 
      } else {
      	matches += "0";
      }
      j++;
    }
    if (!matches.contains("0")) {
      return true;
    } else {
      return false;
    }
    
  }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mttprojects.program;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
/**
 *
 * @author matiw
 */
public class mineCell extends JButton {
   private static final long serialVersionUID = 1L;  // to prevent serial warning

   
   int row, col;
   boolean isRevealed;
   boolean isMined;
   boolean isFlagged;

   /** Constructor */
   public mineCell(int row, int col) {
      super();   
      this.row = row;
      this.col = col;
      paint();
      super.setFont(new Font("Arial", Font.BOLD, 10));
   }

   /** Reset this cell, ready for a new game */
   public void newGame(boolean isMined) {
      this.isRevealed = false; // default
      this.isFlagged = false;  // default
      this.isMined = isMined;  // given
      super.setEnabled(true);  // enable button
      super.setText("");       // display blank
      paint();
   }

   /** Paint itself based on its status */
   public void paint() {
      super.setForeground(isRevealed? Color.BLACK: Color.ORANGE);
      if(isFlagged)
          super.setBackground(Color.ORANGE);
      else
      super.setBackground(isRevealed? Color.LIGHT_GRAY: Color.DARK_GRAY);
      
      
      if(isRevealed && super.getText() == "")
          super.setBackground(Color.DARK_GRAY);
      super.setBorderPainted(false);
      super.setAutoscrolls(false);
      
   }
   
   public void paintCell(Color color)
   {
       super.setBackground(color);
   }
}
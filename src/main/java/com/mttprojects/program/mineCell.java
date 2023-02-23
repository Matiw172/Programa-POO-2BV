/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mttprojects.program;
import java.awt.*;
import javax.swing.JButton;
/**
 *
 * @author matiw
 */
public class mineCell extends JButton {
  // private static final long serialVersionUID = 1L;  // to prevent serial warning

   
   int X, Y;
   boolean isReveal;
   boolean isMine;
   boolean isFlag;

   public mineCell(int X, int Y) {
      super();   
      this.X = X;
      this.Y = Y;
      paint();
      super.setFont(new Font("Arial", Font.BOLD, 10));
   }

   public void newGame(boolean isMined) {
      this.isReveal = false; 
      this.isFlag = false;  
      this.isMine = isMined;  
      super.setEnabled(true);  
      super.setText("");
      paint();
   }

   public void paint() {
      super.setForeground(Color.BLACK);
      if(isFlag)
          paintCell(Color.ORANGE);
      else
      paintCell(isReveal? Color.LIGHT_GRAY: Color.DARK_GRAY);
      
      if(isReveal && super.getText() == "")
          paintCell(Color.DARK_GRAY);
           
   }
   
   public void paintCell(Color color)
   {
       super.setBackground(color);
   }
}
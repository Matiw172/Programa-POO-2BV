/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mttprojects.program;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import static utils.ToolsClass.*;

/**
 *
 * @author matiw
 */
public class Tamagotchi extends javax.swing.JInternalFrame {

    ArrayList<JLabel> options = new ArrayList<>();
    
    int currentOption = 0;
    
    int foodValue = 50;
    int playValue = 50;
    int restValue = 50;
    int cleanValue = 50;
    
    LineBorder noBorder = new LineBorder(Color.WHITE, 1);
        LineBorder chooseBorder = new LineBorder(Color.BLACK, 2);
        LineBorder warningBorder = new LineBorder(Color.RED, 4);
        
        
    /**
     * Creates new form Tamagochi
     */
    public Tamagotchi() {
        initComponents();
        options.add(feedOP);
        options.add(playOP);
        options.add(restOP);
        options.add(cleanOP);
        
        chooseOption(currentOption);
        
        
        window.setComponentZOrder(FoodImage, 0);
        window.setComponentZOrder(GameWindow, 1);
        window.setComponentZOrder(Background, 2);
        
        ChoosePet();
        
        NewPet();
    }
    
    public void NewPet()
    {
        foodValue = randomRangeInt(25,100);
        playValue = randomRangeInt(25,100);
        restValue = randomRangeInt(25,100);
        cleanValue = randomRangeInt(25,100);
        
        updateValues();
        
        
    }
    
    public void ChoosePet()
    {
        FoodImage.setIcon(getImageScaled("apple.png",50,50));
        Background.setIcon(getImageScaled("bg.png",268,268));
        petImage.setIcon(getImageScaled("placeHolder.png",128,128));
    }
    
    public void chooseOption(int op)
    {
        for(JLabel option :options)
        {
            option.setBorder(noBorder);
        }
        options.get(op).setBorder(chooseBorder);
    }
    
    public void doOption()
    {
        switch(currentOption)
        {
            case 0: 
                break;
        }
    }
    
    public void updateValues()
    {
        feedBar.setValue(foodValue);
        playBar.setValue(playValue);
        restBar.setValue(restValue);
        cleanBar.setValue(cleanValue);
        
        feedBar.updateUI();
        playBar.updateUI();
        restBar.updateUI();
        cleanBar.updateUI();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        window = new javax.swing.JPanel();
        FoodImage = new javax.swing.JLabel();
        GameWindow = new javax.swing.JPanel();
        feedOP = new javax.swing.JLabel();
        feedBar = new javax.swing.JProgressBar();
        playOP = new javax.swing.JLabel();
        playBar = new javax.swing.JProgressBar();
        restOP = new javax.swing.JLabel();
        restBar = new javax.swing.JProgressBar();
        cleanOP = new javax.swing.JLabel();
        cleanBar = new javax.swing.JProgressBar();
        petImage = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        leftBT = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        rightBT = new javax.swing.JButton();

        setClosable(true);

        window.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        window.setPreferredSize(new java.awt.Dimension(268, 268));

        FoodImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        GameWindow.setOpaque(false);

        feedOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        feedOP.setIcon(getImageScaled("feedOP.png",50,50));
        feedOP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));

        feedBar.setBackground(new java.awt.Color(255, 255, 255));
        feedBar.setForeground(new java.awt.Color(0, 0, 0));
        feedBar.setValue(50);
        feedBar.setBorder(null);
        feedBar.setBorderPainted(false);

        playOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playOP.setIcon(getImageScaled("playOP.png",50,50));
        playOP.setToolTipText("");
        playOP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));

        playBar.setBackground(new java.awt.Color(255, 255, 255));
        playBar.setForeground(new java.awt.Color(0, 0, 0));
        playBar.setValue(50);
        playBar.setBorder(null);
        playBar.setBorderPainted(false);

        restOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restOP.setIcon(getImageScaled("restOP.png",50,50));
        restOP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));

        restBar.setBackground(new java.awt.Color(255, 255, 255));
        restBar.setForeground(new java.awt.Color(0, 0, 0));
        restBar.setValue(50);
        restBar.setBorder(null);
        restBar.setBorderPainted(false);

        cleanOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cleanOP.setIcon(getImageScaled("cleanOP.png",50,50));
        cleanOP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));

        cleanBar.setBackground(new java.awt.Color(255, 255, 255));
        cleanBar.setForeground(new java.awt.Color(0, 0, 0));
        cleanBar.setValue(50);
        cleanBar.setBorder(null);
        cleanBar.setBorderPainted(false);

        petImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        petImage.setIcon(getImageScaled("placeHolder.png",96,96));

        javax.swing.GroupLayout GameWindowLayout = new javax.swing.GroupLayout(GameWindow);
        GameWindow.setLayout(GameWindowLayout);
        GameWindowLayout.setHorizontalGroup(
            GameWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameWindowLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GameWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(feedBar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(feedOP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(GameWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GameWindowLayout.createSequentialGroup()
                        .addComponent(playOP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(restOP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cleanOP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GameWindowLayout.createSequentialGroup()
                        .addComponent(playBar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(restBar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cleanBar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GameWindowLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(petImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GameWindowLayout.setVerticalGroup(
            GameWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameWindowLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(GameWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(feedOP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playOP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restOP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cleanOP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(GameWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(feedBar, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playBar, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restBar, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cleanBar, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(petImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        Background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout windowLayout = new javax.swing.GroupLayout(window);
        window.setLayout(windowLayout);
        windowLayout.setHorizontalGroup(
            windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowLayout.createSequentialGroup()
                .addComponent(GameWindow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(windowLayout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(FoodImage, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );
        windowLayout.setVerticalGroup(
            windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowLayout.createSequentialGroup()
                .addComponent(GameWindow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowLayout.createSequentialGroup()
                    .addContainerGap(181, Short.MAX_VALUE)
                    .addComponent(FoodImage, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)))
        );

        leftBT.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 36)); // NOI18N
        leftBT.setText("<");
        leftBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftBTActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 36)); // NOI18N
        jButton5.setText("O");

        rightBT.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 36)); // NOI18N
        rightBT.setText(">");
        rightBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(window, 270, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leftBT, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rightBT, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(window, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leftBT, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(rightBT, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void leftBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftBTActionPerformed
        if(currentOption > 0)
            currentOption --;
        else
            currentOption = 3;
        
        chooseOption(currentOption);
    }//GEN-LAST:event_leftBTActionPerformed

    private void rightBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightBTActionPerformed
        if(currentOption < 3)
            currentOption ++;
        else
            currentOption = 0;
        
        chooseOption(currentOption);
    }//GEN-LAST:event_rightBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel FoodImage;
    private javax.swing.JPanel GameWindow;
    private javax.swing.JProgressBar cleanBar;
    private javax.swing.JLabel cleanOP;
    private javax.swing.JProgressBar feedBar;
    private javax.swing.JLabel feedOP;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton leftBT;
    private javax.swing.JLabel petImage;
    private javax.swing.JProgressBar playBar;
    private javax.swing.JLabel playOP;
    private javax.swing.JProgressBar restBar;
    private javax.swing.JLabel restOP;
    private javax.swing.JButton rightBT;
    private javax.swing.JPanel window;
    // End of variables declaration//GEN-END:variables
}

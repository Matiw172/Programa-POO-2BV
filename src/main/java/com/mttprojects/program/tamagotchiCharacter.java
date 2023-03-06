/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mttprojects.program;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import static utils.ToolsClass.*;

/**
 *
 * @author matiw
 */
public class tamagotchiCharacter {

    ImageIcon[][] sprites = new ImageIcon[1][4];
    public int imageSpeed = 1000;

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
PlayAnim();
        }

    };

    int imageIndex = 0;
    int spriteIndex = 0;
    
    
    public int idleAnim = 0;
    public int ateAnim = 3;
    public int playAnim = 4;
    public int restAnim = 5;
    public int cleanAnim = 6;

    JLabel currentDisplay;

    public tamagotchiCharacter(String spriteSheet, JLabel display) {

        currentDisplay = display;
        sprites = parseSpriteSheet(spriteSheet, 32, 32, 6, 1, 5);

        
        display.setIcon(sprites[0][0]);
        
        initializeTimer();
    }
    
    public Timer cycle = new Timer(imageSpeed, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
PlayAnim();
        }
    });
    
    public void debug()
    {
        System.out.print(sprites);
        for (int i = 0; i < 1; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                System.out.println(sprites[i][j]);
           
                
               
                
            }
        }      
    }

    public void initializeTimer() {
        printLog("Timer initialized!");
        cycle.start();
    }

    public void PlayAnim() {
        
        imageIndex++;
        if(imageIndex > 1) imageIndex = 0;
       // printLog("Updating anim!");
        currentDisplay.setIcon(sprites[spriteIndex][imageIndex]);
    }
    
    public void ForcePlayAnim()
    {
        currentDisplay.setIcon(sprites[spriteIndex][imageIndex]);
    }
    
    public void animIdle()
    {
        spriteIndex = idleAnim;
        ForcePlayAnim();
    }
    
    public void animEat()
    {
        spriteIndex = ateAnim;
        PlayAnim();
    }
    
    public void animPlay()
    {
        spriteIndex = playAnim;
        PlayAnim();
    }
    
    public void animRest()
    {
        spriteIndex = restAnim;
        PlayAnim();
                    
    }
    public void animClean()
    {
        spriteIndex = cleanAnim;
        ForcePlayAnim();
    }
}

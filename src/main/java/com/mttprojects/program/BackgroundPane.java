/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mttprojects.program;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

public class BackgroundPane extends JDesktopPane {
  private Image backgroundImage;

  public BackgroundPane() {
    try {
      URL url = new URL("https://i.imgur.com/5qhuw6T.png");
      backgroundImage = ImageIO.read(url);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (backgroundImage != null) {
      g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
  }
}
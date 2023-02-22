/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author matiw
 */
public class ToolsClass {
    public static void printLog(String text)
    {
        System.out.println(text);
    }
    
    public static ImageIcon getImage(String fileName)
    {
        return new ImageIcon("src/main/java/Images/" + fileName);
    }
    
    public static ImageIcon getImageScaled(String fileName, int width, int height)
    {
        ImageIcon loadImate = new ImageIcon("src/main/java/Images/" + fileName);
        Image image = loadImate.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_FAST);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        return scaledIcon;
    }
    
    public static void SetDarkMode(javax.swing.JFrame frame)
    {
        // Dark LAF
    try {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        UIManager.put("control", new Color(128, 128, 128));
        UIManager.put("info", new Color(128, 128, 128));
        UIManager.put("nimbusBase", new Color(18, 30, 49));
        UIManager.put("nimbusAlertYellow", new Color(248, 187, 0));
        UIManager.put("nimbusDisabledText", new Color(128, 128, 128));
        UIManager.put("nimbusFocus", new Color(115, 164, 209));
        UIManager.put("nimbusGreen", new Color(176, 179, 50));
        UIManager.put("nimbusInfoBlue", new Color(66, 139, 221));
        UIManager.put("nimbusLightBackground", new Color(18, 30, 49));
        UIManager.put("nimbusOrange", new Color(191, 98, 4));
        UIManager.put("nimbusRed", new Color(169, 46, 34));
        UIManager.put("nimbusSelectedText", new Color(255, 255, 255));
        UIManager.put("nimbusSelectionBackground", new Color(104, 93, 156));
        UIManager.put("text", new Color(230, 230, 230));
        SwingUtilities.updateComponentTreeUI(frame);
    } catch (UnsupportedLookAndFeelException exc) {
        System.err.println("Nimbus: Unsupported Look and feel!");
    }
    }
    
    public static int randomRangeInt(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min) + min;
}
    
    public static void showMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
    
    public static int messageGetInt(String message)
    {
        int myRet = 0;
        try
        {
            myRet = Integer.parseInt(JOptionPane.showInputDialog(message));
        }
        catch(Exception e)
        {
            myRet = 0;
        }
        return myRet;
    }
    
    public static int formatMaxMin(int num,  int min, int max)
    {
        if(num > max)
            return max;
        else if(num < min)
            return min;
        else 
            return num;
    }
    public static void SetDarkMode(javax.swing.JInternalFrame frame)
    {
        // Dark LAF
    try {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        UIManager.put("control", new Color(128, 128, 128));
        UIManager.put("info", new Color(128, 128, 128));
        UIManager.put("nimbusBase", new Color(18, 30, 49));
        UIManager.put("nimbusAlertYellow", new Color(248, 187, 0));
        UIManager.put("nimbusDisabledText", new Color(128, 128, 128));
        UIManager.put("nimbusFocus", new Color(115, 164, 209));
        UIManager.put("nimbusGreen", new Color(176, 179, 50));
        UIManager.put("nimbusInfoBlue", new Color(66, 139, 221));
        UIManager.put("nimbusLightBackground", new Color(18, 30, 49));
        UIManager.put("nimbusOrange", new Color(191, 98, 4));
        UIManager.put("nimbusRed", new Color(169, 46, 34));
        UIManager.put("nimbusSelectedText", new Color(255, 255, 255));
        UIManager.put("nimbusSelectionBackground", new Color(104, 93, 156));
        UIManager.put("text", new Color(230, 230, 230));
        SwingUtilities.updateComponentTreeUI(frame);
    } catch (UnsupportedLookAndFeelException exc) {
        System.err.println("Nimbus: Unsupported Look and feel!");
    }
    }
}

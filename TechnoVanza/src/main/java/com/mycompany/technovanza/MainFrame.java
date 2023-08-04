/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.technovanza;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author acer
 */
public class MainFrame extends JFrame{
    GamePanel panel;
    
    
    public MainFrame(){
        panel = new GamePanel();
        panel.setLocation(0,0);
        panel.setSize(this.getWidth(), this.getHeight());
        panel.setVisible(true);
        panel.setBackground(new Color(5,5,5));
        panel.add(panel.motivate);
        panel.add(panel.bg);
        this.addKeyListener(new KeyChecker(panel));
    }
}

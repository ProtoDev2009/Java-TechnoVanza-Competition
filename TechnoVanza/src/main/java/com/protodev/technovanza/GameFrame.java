package com.protodev.technovanza;

import java.awt.Color;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
    GamePanel panel;
    int height = 1280;
    int width = 1000;  
    
    public GameFrame(){
        panel = new GamePanel();
        panel.setLocation(0,0);
        panel.setSize(width,height);
        panel.setBackground(new Color(254,214,193,255));
        panel.setVisible(true);
        panel.add(panel.gameStatus);
        panel.add(panel.motivate);
        addKeyListener(new KeyChecker(panel));
    }  
}

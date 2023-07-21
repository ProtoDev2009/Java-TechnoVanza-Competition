package com.protodev.technovanza;

import java.awt.Color;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
    GameFrame(){
        GamePanel panel = new GamePanel();
        panel.setLocation(0,0);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setVisible(true);
        this.add(panel);
        
        addKeyListener(new KeyChecker(panel));
    }
}

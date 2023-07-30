package com.protodev.technovanza;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class TechnoVanza {
public static void main(String[] args) {
        final GamePanel panel = new GamePanel();
                
        int panelWidth = 1, panelHeight = 1;        
        GameFrame frame = new GameFrame();
        frame.add(frame.panel);
                
        //setting frame
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));
        
        frame.setResizable(false);
        frame.setTitle("Player Movement Course");
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

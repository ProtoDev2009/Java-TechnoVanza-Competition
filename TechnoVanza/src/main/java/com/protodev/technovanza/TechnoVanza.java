package com.protodev.technovanza;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class TechnoVanza {

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        
        //setting up frame
        frame.setSize(700, 700);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int) (screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int) (screenSize.getHeight()/2 - frame.getSize().getHeight()/2));
        
        frame.setResizable(false);
        frame.setTitle("Techno Vanza");
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

package com.protodev.technovanza;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
    GameFrame(){
        this.add(new GamePanel());
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}

package com.protodev.technovanza;

import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel {
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 400;

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.LIGHT_GRAY);
    }    
}

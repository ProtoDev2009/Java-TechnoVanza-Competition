package com.protodev.technovanza;

import java.awt.*;

public class Wall {
    
    int x, y;
    int width, height;
    
    Rectangle hitBox;// wall
    
    public Wall(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        hitBox = new Rectangle(x, y, width, height);
        
    }
    
    public void draw(Graphics2D gtd){
        gtd.setColor(new Color(255,119,76,255));
        gtd.fillRect(x + 1, y + 1, width - 2, height - 2);
    }
}

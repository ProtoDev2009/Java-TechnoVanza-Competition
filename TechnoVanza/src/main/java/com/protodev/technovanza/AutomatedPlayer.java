package com.protodev.technovanza;

import java.awt.*;
import java.awt.Rectangle;

class AutomatedPlayer {
    GamePanel panel;
    int x, y;
    int width, height;
    
    double xSpeed, ySpeed;
    
    boolean keyUp, keyDown, keyLeft, keyRight;
    Rectangle hitBox;
    
    public AutomatedPlayer(int x, int y, GamePanel panel){
        this.panel = panel;
        this.x = x;
        this.y = y;
        
        width = 25;
        height = 50;
        hitBox = new Rectangle(x, y, width, height);
    }
    
    public void set(){
        if(keyLeft && keyRight || !keyLeft && !keyRight) x *= 1;
        else if (keyLeft && !keyRight) x += 5;
        else if (keyRight && !keyLeft) x -= 5;
        
        if(keyUp){
            hitBox.y++;
            for(Wall wall:panel.walls) {
                if(wall.hitBox.intersects(hitBox)) ySpeed = -4;
            }
            hitBox.y--;
            
            ySpeed = -4;
        }
        
        ySpeed += 0.3;
        
        //Horizontal Collision
        hitBox.x += xSpeed;
        for(Wall wall: panel.walls){
            if(hitBox.intersects(wall.hitBox)){
                hitBox.x -= xSpeed;
                while(!wall.hitBox.intersects(hitBox)) hitBox.x += Math.signum(xSpeed);
                hitBox.x -= Math.signum(xSpeed);
                xSpeed = 0;
                x = hitBox.x;
            }
        }
        
        //Vertical Collision
        hitBox.y += ySpeed;
        for(Wall wall: panel.walls){
            if(hitBox.intersects(wall.hitBox)){
                hitBox.y -= ySpeed;
                while(!wall.hitBox.intersects(hitBox)) hitBox.y += Math.signum(ySpeed);
                hitBox.y -= Math.signum(ySpeed);
                ySpeed = 0;
                y = hitBox.y;
            }
        }
        
        x += xSpeed;
        y += ySpeed;
        
        hitBox.x = x;
        hitBox.y = y;
    }
    
    public void draw(Graphics2D gtd){
        gtd.setColor(Color.DARK_GRAY);
        gtd.fillRect(x, y, width, height);
    }
}

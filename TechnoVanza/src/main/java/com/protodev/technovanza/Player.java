package com.protodev.technovanza;

import java.awt.*;
import java.awt.Rectangle;

class Player {
    GamePanel panel;
    int x, y;
    int width, height;
    
    boolean hasPlayerReached = false;
    
    double xSpeed, ySpeed;// keeping check of player's location
    Rectangle hitBox;// name of the player
    
    boolean keyUp , keyDown, keyLeft, keyRight; // all the keys required for the project
    
    public Player(int x, int y, GamePanel panel){
        this.panel = panel;
        this.x = x;
        this.y = y;
        
        width = 25;
        height = 50;
        hitBox = new Rectangle(x, y, width, height);
    }
    
    public void set(){
        if(!hasPlayerReached){
            if(keyLeft && keyRight || !keyLeft && !keyRight) x *= 1;
        else if (keyLeft && !keyRight) x -= 5;
        else if (keyRight && !keyLeft) x += 5;
        
        if(keyUp){
            
            hitBox.y++;
            for(Wall wall:panel.walls){
                if(wall.hitBox.intersects(hitBox)) ySpeed = -4;
            }
            hitBox.y--;
            
            ySpeed = -4;
        }
        
        ySpeed += 0.3;
        
        // horizontal collision
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
        
        // vertical collision
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
        
        //Collision with ball
        if(hitBox.x == panel.ball1x && hitBox.y == panel.ball1y){
            panel.hasPlayerCleared = true;
            hasPlayerReached = true;
            System.out.println("Player Reached");
        }
        
        hitBox.x = x;
        hitBox.y = y;
        }
        else {
            x = panel.ball1x + 100;
        }
    }
    
    public void draw(Graphics2D gtd){
        gtd.setColor(new Color(226,49,75,255));
        gtd.fillRect(x, y, width, height);
    }
}

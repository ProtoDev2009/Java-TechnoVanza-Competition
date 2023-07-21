package com.protodev.technovanza;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GamePanel extends javax.swing.JPanel implements ActionListener {
    Player player;
    AutomatedPlayer automatedPlayer;
    boolean hasPlayerCleared = false;
    boolean hasAutomatedPlayerCleared = false;
        
    //Ball directions
    int ball1x = 200;
    int ball1y = 450;
    
    Timer gameTimer;
    ArrayList<Wall> walls = new ArrayList<>();
    
    public GamePanel(){
        //Instantiating Players
        player = new Player(250, 100, this);
        automatedPlayer = new AutomatedPlayer(300, 100, this);
        
        makeWalls();
        
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask(){
            @Override
            public void run(){
                player.set();
                automatedPlayer.set();
                repaint();
            }
        }, 0 ,17);
    }
    
    // Wall Design
    public void makeWalls(){
        for(int i = 50; i < 650; i += 50){
            walls.add(new Wall(i, 300,50,50));
        }
        
        walls.add(new Wall(50,350,50,50));
        walls.add(new Wall(50,400,50,50));
        walls.add(new Wall(50,450,50,50));
        walls.add(new Wall(50,500,50,50));
        
        walls.add(new Wall(50,500,50,50));
        walls.add(new Wall(100,500,50,50));
        walls.add(new Wall(150,500,50,50));
        walls.add(new Wall(200,500,50,50));
    }
    
    // paint method
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
        player.draw(gtd);
        automatedPlayer.draw(gtd);
        
        //drawing a ball
        draw(g);
        
        //load gui
        if(hasPlayerCleared == true && hasAutomatedPlayerCleared == true){
            System.out.println("wohoo we won");
        }
        
        for(Wall wall:walls) wall.draw(gtd); // painting walls
    }
    
    //drawing oval
    public void draw(Graphics g){
//        g.setColor(new Color(51,204,125));
        g.setColor(Color.WHITE);
        g.fillOval(ball1x, ball1y, 30, 30);
    }
    
    // key pressed check
    void keyPressed(KeyEvent e){
        if(e.getKeyChar() == 'a') {player.keyLeft = true; automatedPlayer.keyLeft = true;}
        if(e.getKeyChar() == 'w') {player.keyUp = true; automatedPlayer.keyUp = true;}
        if(e.getKeyChar() == 's') {player.keyDown = true; automatedPlayer.keyDown = true;}
        if(e.getKeyChar() == 'd') {player.keyRight = true; automatedPlayer.keyRight = true;}
                
    }
    
    void keyReleased(KeyEvent e){
        //changing the horizontal axis for automated player
        if(e.getKeyChar() == 'a') {player.keyLeft = false; automatedPlayer.keyLeft = false;}
        if(e.getKeyChar() == 'w') {player.keyUp = false; automatedPlayer.keyUp = false;}
        if(e.getKeyChar() == 's') {player.keyDown = false; automatedPlayer.keyDown = false;}
        if(e.getKeyChar() == 'd') {player.keyRight = false; automatedPlayer.keyRight = false;}
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

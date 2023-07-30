package com.protodev.technovanza;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class GamePanel extends javax.swing.JPanel implements ActionListener{
    //Creating player source
    Player player;
    AutomatedPlayer automatedPlayer;
        
    boolean hasPlayerCleared = false;
    boolean hasAutomatedPlayerCleared = false;
    
    JLabel gameStatus = new JLabel();
    JLabel motivate = new JLabel();
            
    //Ball directions
    int ball1x = 845;
    int ball1y = 350;
    
    Timer gameTimer;
    ArrayList<Wall> walls = new ArrayList<>();
    
    public GamePanel(){        
        setLayout(new FlowLayout(FlowLayout.CENTER));
        //Instantiating Players
        player = new Player(500, 50, this);
        automatedPlayer = new AutomatedPlayer(550, 50, this);
        
        //set label              
        motivate.setFont(new Font("Arial", Font.BOLD, 170));
        motivate.setForeground(new Color(215,43,66,50));
        motivate.setText("YOU CAN DO IT!");
        
        gameStatus.setFont(new Font("Arial", Font.BOLD, 30));
        gameStatus.setForeground(Color.WHITE);
        gameStatus.setToolTipText("STATES WHETHER USER HAS WON OR NOT!");
        
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
        
        motivate.setBorder(BorderFactory.createEmptyBorder(250, 0, 0, 0));
        gameStatus.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
    }
    
    // Wall Design
    public void makeWalls(){

        for(int i = 400; i < 1150; i += 50){
            walls.add(new Wall(i, 100, 50,50));
            if(i < 700)walls.add(new Wall(i, 600, 50,50));
            if(i > 800) walls.add(new Wall(i, 600, 50,50));
            if( i > 600)walls.add(new Wall(i, 400, 50, 50));
        }
        for(int i = 50; i < 550; i += 50){
            walls.add(new Wall(400, i + 50, 50,50));
            walls.add(new Wall(1100, i + 50, 50, 50));
            if( i > 250)walls.add(new Wall(750, i + 100, 50, 50));
        }
    }
    
    // paint method
    public void paint(Graphics g){
        
        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
        player.draw(gtd);
        automatedPlayer.draw(gtd);
        
        //drawing a ball
        draw(g);                        
        for(Wall wall:walls) wall.draw(gtd); // painting walls
               
        if(hasPlayerCleared && hasAutomatedPlayerCleared)gameStatus.setText("CONGRATS! YOU WON! ");
        else if((hasPlayerCleared && !hasAutomatedPlayerCleared) || (!hasPlayerCleared && hasAutomatedPlayerCleared)) gameStatus.setText("ONE MORE TO GO!");
        else gameStatus.setText("YOU CAN DO IT! WIN THE GAME BRO!");
    }
        
    //drawing oval
    public void draw(Graphics g){
        g.setColor(new Color(131,0,52,255));
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

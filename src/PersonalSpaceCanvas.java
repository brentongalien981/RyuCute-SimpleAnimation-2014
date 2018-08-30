import java.awt.Graphics;
import java.awt.Image;

import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class PersonalSpaceCanvas extends Applet implements Runnable, KeyListener{
	private volatile int xPos, yPos, imgNum;
	private BufferedImage img[];
	
	private BufferedImage walkRight[];
	private BufferedImage walkLeft[];
	private BufferedImage idle[];
	private BufferedImage punch[];
	private Thread thread;
	
    public void init(){    	
        setSize(200, 200);
        //(new Dimension(200, 200));
        //setBackground(Color.black);
        
        idle = new BufferedImage[6];
        walkRight = new BufferedImage[6];
        walkLeft = new BufferedImage[6];
        
        punch = new BufferedImage[6];
        
        
        imgNum = 0;
        
        String folderLoc = "C:\\Users\\Chust\\Documents\\Eclipse\\Ryu Cute\\idle\\";
        String imgLoc;
        
        try {
        	// FOR IDLE
	        for(int x=0; x<6; x++) {
	        	imgLoc = folderLoc + "idle" + Integer.toString(x+1) + ".gif";
	        	idle[x] = ImageIO.read(new File(imgLoc));
	        }
	        
	        
	        // FOR RIGHTT WALK
	        folderLoc = "C:\\Users\\Chust\\Documents\\Eclipse\\Ryu Cute\\walkRight\\";
	        for(int x=0; x<6; x++) {
	        	imgLoc = folderLoc + Integer.toString(x+1) + ".gif";
	        	walkRight[x] = ImageIO.read(new File(imgLoc));
	        }
	        
	        // FOR LEFT WALK
	        folderLoc = "C:\\Users\\Chust\\Documents\\Eclipse\\Ryu Cute\\walkLeft\\";
	        for(int x=0; x<6; x++) {
	        	imgLoc = folderLoc + Integer.toString(x+1) + ".gif";
	        	walkLeft[x] = ImageIO.read(new File(imgLoc));
	        }
	        
	    	 // FOR PUNCH
	        folderLoc = "C:\\Users\\Chust\\Documents\\Eclipse\\Ryu Cute\\punch\\";
	        for(int x=0; x<6; x++) {
	        	imgLoc = folderLoc + Integer.toString(x+1) + ".gif";
	        	punch[x] = ImageIO.read(new File(imgLoc));
	        }
        }
        catch(Exception e) {}      
        
        addKeyListener(this);
        
        img = idle;
        
        thread = new Thread(this);
        
    }
    
    public void start() {
    	thread.start();
    }
    
    private void walkRight() {
    	img = walkRight;
    	imgNum = 0;
    }
    
    private void walkLeft() {
    	img = walkLeft;
    	imgNum = 0;
    }
    
    private void punch() {
    	img = punch;
    	imgNum = 0;
    }
    
    public void keyTyped(KeyEvent e) {
    	if(e.getKeyChar() == 'a') {
    		walkLeft();
    	}
    	else if(e.getKeyChar() == 'd') { 
    		walkRight();
    	}  
    	else if(e.getKeyChar() == 'p') { 
    		punch();
    	}  
    }
    
   public void keyReleased(KeyEvent e) {}    
    public void keyPressed(KeyEvent e) {}
    
    
    public void run() {
    	if(img[5] != null) {repaint();}
    	
    	 while (true) {		    	
			  try {
			    Thread.sleep(130);
			    
			    // case for IMAGES ARRAY POINTER
			    if(img == walkRight){
			    	setLocation((getLocation().x + 12), getLocation().y);
			    }
			    else if(img == walkLeft) {
			    	setLocation((getLocation().x - 8), getLocation().y);
			    }
			    
			    
			    
			    if(imgNum == 5) {
			    	imgNum = 0;
			    	img = idle;
			    }
			    else {imgNum++;}
			    
			    repaint();
			    
			    /*
			    if(imgNum == 5) { // if the final image index is through
			    	imgNum = 0; 
			    	if(img != idle) { img = idle; } // reset to idle images
			    }
		        else if(img == walkRight) {
		        	
		        	imgNum++;
		        } 			    
			    */
			  }
			  catch (InterruptedException e) {
				  	System.out.println("Animation Interrupted");
					return;
			  }
    	 }
    }

    public void paint(Graphics g) {
    	g.drawImage(img[imgNum], 0, 0, null);
    }
}

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.imageio.ImageIO;

public class RyuMainScreen extends Applet {		
	private PersonalSpaceCanvas psc;
	
	public void init() {		
		setSize(500, 500);
		setLayout(null);
		setBackground(Color.black);
	}
	
	public void start() {
		
	}
	
	public void stop() {
		
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.drawRoundRect(0, 0, 50, 50, 10, 10);
	}
	
}

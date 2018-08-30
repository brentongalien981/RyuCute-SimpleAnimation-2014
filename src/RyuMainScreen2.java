import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.imageio.ImageIO;

public class RyuMainScreen2 extends JApplet {		
	private PersonalSpaceCanvas2 psc;
	
	public void init() {		
		try {
			SwingUtilities.invokeAndWait(new Runnable () {
				public void run() {
					initMainWindow();
				}
			});
		}
		catch(Exception exc) { System.out.println("Can't create because of "+ exc); }
	}	
	
	public void initMainWindow() {		
		setSize(500, 500);
		setLayout(null);
		
		getContentPane().setBackground(Color.black);
		
		psc = new PersonalSpaceCanvas2();
        psc.setLocation(0, getHeight()-210);
       	add(psc);	   	
	}	
}

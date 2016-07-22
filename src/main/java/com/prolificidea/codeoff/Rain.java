package com.prolificidea.codeoff;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;

public class Rain extends JPanel {

    private Drop[] drops;

    Rain() {
        drops = new Drop[Config.SCREEN_SIZE / Config.FONT_SIZE];
        for (int i = 0; i < drops.length; i++) {
            drops[i] = new Drop(i * Config.FONT_SIZE);
        }
    }
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Monospaced", Font.BOLD, Config.FONT_SIZE);
        g2.setFont(font);

        final BufferedImage image;
		try {
			image = ImageIO.read(new File("rsz_anony.jpg"));
            g.drawImage(image, 0, 0, null);
		   } catch (IOException e) {
			e.printStackTrace();
		}
		
        for (int i = 0; i < drops.length; i++) {
            if (drops[i].isOffScreen()) {
               // drops[i] = new Drop(i * Config.FONT_SIZE);
            }
        
            drops[i].draw(g2);
          
        }     
        try {
            Thread.sleep(2);
           }catch (Exception ex) {
            ex.printStackTrace();
        }
        repaint();
    }
   





}

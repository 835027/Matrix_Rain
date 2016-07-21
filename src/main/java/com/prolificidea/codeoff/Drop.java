package com.prolificidea.codeoff;

import java.awt.*;
import java.util.Random;

public class Drop {

    private Random rng = new Random();
    private int velocity, length, x, y;
    private char[][] text;

    Drop(int x) {
        this.x = x;
        length = getRandomInteger(120, 150);
        text = createContent(length);
        velocity = getRandomInteger(1, 5);
        this.y = (-1) * length * Config.FONT_SIZE;
    }

    protected char[][] createContent(int length) {
        char[][] result = new char[length][1];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = getRandomCharacter();
        }
        return result;
    }

    public void draw(Graphics2D g2) {
        int fontSize = g2.getFont().getSize();
        for (int i = 0; i < length; i++) {
        	
        	g2.setColor(new Color(28, 146, 44));
           if (getRandomInteger(0, length) == i){
        	   
        	   if (getRandomInteger(0, length) == i)
                   text[i][0] = getRandomCharacter();
               if (i == length - 1)
                   g2.setColor(new Color(159,159,159));
               else
                   g2.setColor(new Color(159,159,159));
    	     
           }
            g2.rotate(Math.toRadians(9*Math.tan(75)),0,0);
            g2.drawChars(text[i], 0, 1, x, y + (i * fontSize));
        }
        y += velocity;
    }
    	  
    
  

    public char getRandomCharacter() {
        return (char) (rng.nextInt(26) + 'A');
    }

    public int getRandomInteger(int min, int max) {
        int randomNum = rng.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public boolean isOffScreen() {
        return (y > Config.SCREEN_SIZE);
    }

    /*public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char[][] getText() {
        return text;
    }

    public void setText(char[][] text) {
        this.text = text;
    }*/
}
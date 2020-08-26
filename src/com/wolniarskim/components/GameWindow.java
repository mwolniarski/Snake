package com.wolniarskim.components;

import com.wolniarskim.objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JFrame {

    private GamePanel gamePanel;

    private static int WIDTH, HEIGHT;

    public GameWindow(int width, int height){
        initWindow(width, height);
        initListener();
        (new Timer(100, (ActionEvent a) -> {
            this.gamePanel.repaint();
        })).start();
    }

    private void initWindow(int width, int height){
        this.setSize(width,height);
        GameWindow.WIDTH = width;
        GameWindow.HEIGHT = height;
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        gamePanel = new GamePanel();
        this.add(gamePanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void initListener(){
        this.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        Snake snake = Snake.getInstance();
                        switch(e.getKeyCode()){
                            case 39:
                                if(snake.getSnakeDirect() != 'l')
                                    snake.setSnakeDirect('r');
                                break;
                            case 40:
                                if(snake.getSnakeDirect() != 'u')
                                    snake.setSnakeDirect('d');
                                break;
                            case 37:
                                if(snake.getSnakeDirect() != 'r')
                                    snake.setSnakeDirect('l');
                                break;
                            case 38:
                                if(snake.getSnakeDirect() != 'd')
                                    snake.setSnakeDirect('u');
                                break;
                        }
                    }
                }
        );
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }
}

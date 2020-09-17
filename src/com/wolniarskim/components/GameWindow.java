package com.wolniarskim.components;

import com.wolniarskim.objects.Snake;
import configuration.Direct;

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
        ImageIcon img = new ImageIcon("resources/game_icon.png");
        this.setIconImage(img.getImage());
        this.setSize(width,height);
        GameWindow.WIDTH = width-200;
        GameWindow.HEIGHT = height-200;
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
                        Snake snake = Snake.getInstance();
                        System.out.println(e.getKeyCode());
                        switch(e.getKeyCode()){
                            case 39:
                                if(snake.getActualDirect() != Direct.LEFT)
                                    snake.setSnakeDirect(Direct.RIGHT);
                                break;
                            case 40:
                                if(snake.getActualDirect() != Direct.UP)
                                    snake.setSnakeDirect(Direct.DOWN);
                                break;
                            case 37:
                                if(snake.getActualDirect() != Direct.RIGHT)
                                    snake.setSnakeDirect(Direct.LEFT);
                                break;
                            case 38:
                                if(snake.getActualDirect() != Direct.DOWN)
                                    snake.setSnakeDirect(Direct.UP);
                                break;
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

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

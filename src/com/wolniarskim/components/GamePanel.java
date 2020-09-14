package com.wolniarskim.components;

import com.wolniarskim.objects.Food;
import com.wolniarskim.objects.Snake;
import com.wolniarskim.objects.SnakeElement;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private int snakePositionY, snakePositionX;
    private final Food food;
    private final Snake snake;
    private Boolean gameOver;
    private int score;

    public GamePanel(){
        gameOver = false;
        score = 0;
        snakePositionX = 300;
        snakePositionY = 300;
        snake = Snake.getInstance();
        food = Food.getInstance();
    }

    @Override
    public void paintComponent(Graphics g) {
        if(!gameOver) {
            super.paintComponent(g);
            g.drawRect(0, 0, GameWindow.getHEIGHT(), GameWindow.getWIDTH());
            if (snake.getDirectChanged()) {
                snake.setActualDirect(snake.getSnakeDirect());
            }
            if (snakePositionX == food.getPositionX() && snakePositionY == food.getPositionY()) {
                food.drawCoordinates();
                score+=50;
                snake.addSize();
            }

            // moving cross the walls
            if (snakePositionY == GameWindow.getHEIGHT() - 10 && snake.getActualDirect() == 'd')
                snakePositionY = -10;
            else if (snakePositionY == 0 && snake.getActualDirect() == 'u')
                snakePositionY = GameWindow.getHEIGHT();
            else if (snakePositionX == GameWindow.getWIDTH() - 10 && snake.getActualDirect() == 'r')
                snakePositionX = -10;
            else if (snakePositionX == 0 && snake.getActualDirect() == 'l')
                snakePositionX = GameWindow.getWIDTH();

            int foundElement = 0;
            for (SnakeElement element : snake.getSnakeElements()) {
                //            g.drawString("#",element.getPositionX(),element.getPositionY());
                g.setColor(Color.GREEN);
                g.fillRect(element.getPositionX(), element.getPositionY(), 10, 10);
                g.setColor(Color.BLACK);
                g.drawRect(element.getPositionX(), element.getPositionY(), 10, 10);
                if (element.getPositionX() == snakePositionX && element.getPositionY() == snakePositionY) {
                    foundElement++;
                }
                if (foundElement > 1) {
                    gameOver = true;
                    closeGame();
                }
            }
            g.setColor(Color.RED);
            g.fillRect(food.getPositionX(), food.getPositionY(), 10, 10);
            g.setColor(Color.BLACK);
            g.drawRect(food.getPositionX(), food.getPositionY(), 10, 10);
            g.drawString("Score: "+ score,GameWindow.getHEIGHT()+100,GameWindow.getWIDTH());
            g.drawString("Snake size: "+ snake.getSnakeSize(),GameWindow.getHEIGHT()+100,GameWindow.getWIDTH()+20);
            changePosition();
        }
        else{
            super.paintComponent(g);
            for (SnakeElement element : snake.getSnakeElements()) {
                g.setColor(Color.GREEN);
                g.fillRect(element.getPositionX(), element.getPositionY(), 10, 10);
                g.setColor(Color.BLACK);
                g.drawRect(element.getPositionX(), element.getPositionY(), 10, 10);
            }
            g.setColor(Color.RED);
            g.fillRect(food.getPositionX(), food.getPositionY(), 10, 10);
            g.setColor(Color.BLACK);
            g.drawRect(food.getPositionX(), food.getPositionY(), 10, 10);
            g.drawString("Score: "+ score,GameWindow.getHEIGHT()+100,GameWindow.getWIDTH()+10);
            g.drawString("Snake size: "+ snake.getSnakeSize(),GameWindow.getHEIGHT()+100,GameWindow.getWIDTH()+10);
        }
    }

    public void changePosition(){
        if (snake.getSnakeDirect() == 'r') {
            snake.addSnakeElement(snakePositionY,snakePositionX +=10);
        }
        else if (snake.getSnakeDirect() == 'l') {
            snake.addSnakeElement(snakePositionY,snakePositionX -=10);
        }
        else if (snake.getSnakeDirect() == 'u') {
            snake.addSnakeElement(snakePositionY -=10,snakePositionX);
        }
        else if (snake.getSnakeDirect() == 'd') {
            snake.addSnakeElement(snakePositionY +=10,snakePositionX);
        }
    }

    private void closeGame(){
        JOptionPane.showMessageDialog(this,"Game Over!!! \n Your score: "+ score);
        System.exit(0);
    }
}

package com.wolniarskim.components;

import com.wolniarskim.objects.Food;
import com.wolniarskim.objects.Snake;
import com.wolniarskim.objects.SnakeElement;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private char[][] gameBoard = new char[GameWindow.getWIDTH()][GameWindow.getHEIGHT()];
    private int snakePositionY, snakePositionX;
    private Food food;
    private Snake snake;

    public GamePanel(){
        snakePositionX = 300;
        snakePositionY = 300;
        snake = Snake.getInstance();
        food = Food.getInstance();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(snakePositionX == food.getPositionX() && snakePositionY == food.getPositionY()){
            food.drawCoordinates();
            snake.addSize();
        }

        if(snakePositionY == GameWindow.getHEIGHT())
            snakePositionY = 0;
        else if(snakePositionY == 0)
            snakePositionY = GameWindow.getHEIGHT();
        else if(snakePositionX == GameWindow.getWIDTH())
            snakePositionX = 0;
        else if(snakePositionX == 0)
            snakePositionX = GameWindow.getWIDTH();

        int foundElement = 0;
        for(SnakeElement element : snake.getSnakeElements()){
            g.drawString("#",element.getPositionX(),element.getPositionY());
            if(element.getPositionX() == snakePositionX && element.getPositionY() == snakePositionY){
                foundElement++;
            }
            if(foundElement > 1){
                closeGame();
            }
        }
        g.drawString("O",food.getPositionX(),food.getPositionY());
        changePosition();
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
        System.exit(0);
    }
}

package com.wolniarskim.objects;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<SnakeElement> snakeElements = new ArrayList<>();
    private static Snake snake;
    private int snakeSize;
    // r = right
    // l = left
    // u = up
    // d = down
    private char snakeDirect;

    private Snake(){
        snakeElements.add(new SnakeElement(300,300));
        snakeSize = 3;
        snakeDirect = 'r';
    }

    public List<SnakeElement> getSnakeElements() {
        return snakeElements;
    }

    public void addSnakeElement(int positionY, int positionX){
        if(snakeElements.size() >= snakeSize){
            snakeElements.remove(snakeElements.size()-snakeSize);
        }
        snakeElements.add(new SnakeElement(positionY,positionX));
    }

    public static Snake getInstance(){
        if(snake == null){
            snake = new Snake();
        }
        return snake;
    }

    public char getSnakeDirect() {
        return snakeDirect;
    }

    public void addSize(){
        snakeSize++;
    }

    public void setSnakeDirect(char snakeDirect) {
        this.snakeDirect = snakeDirect;
    }
}

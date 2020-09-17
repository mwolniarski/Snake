package com.wolniarskim.objects;

import configuration.Direct;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<SnakeElement> snakeElements = new ArrayList<>();
    private static Snake snake;
    private int snakeSize;
    private Boolean directChanged = false;
    private Direct snakeDirect;
    private Direct actualDirect;

    private Snake(){
        snakeSize = 7;
        snakeDirect = Direct.RIGHT;
        actualDirect = Direct.RIGHT;
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

    public Direct getSnakeDirect() {
        return snakeDirect;
    }

    public void addSize(){
        snakeSize++;
    }

    public Boolean getDirectChanged() {
        return directChanged;
    }

    public Direct getActualDirect() {
        return actualDirect;
    }

    public void setActualDirect(Direct actualDirect) {
        this.actualDirect = actualDirect;
    }

    public void setSnakeDirect(Direct snakeDirect) {
        this.snakeDirect = snakeDirect;
        this.directChanged = true;
    }

    public int getSnakeSize() {
        return snakeSize;
    }
}

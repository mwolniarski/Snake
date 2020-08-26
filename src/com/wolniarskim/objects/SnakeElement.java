package com.wolniarskim.objects;

public class SnakeElement {

    private int positionX, positionY;

    public SnakeElement(int positionY, int positionX){
        this.positionY = positionY;
        this.positionX = positionX;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}

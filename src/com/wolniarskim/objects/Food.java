package com.wolniarskim.objects;

import com.wolniarskim.components.GameWindow;

public class Food {

    private static Food food;
    private int positionX, positionY;

    private Food(){
        drawCoordinates();
    }

    public void drawCoordinates(){
        Boolean draw = true;

        while(draw){
            positionX = (int)(Math.random()*GameWindow.getWIDTH()-50);
            positionY = (int)(Math.random()*GameWindow.getHEIGHT()-50);
            positionX = (positionX/10)*10+100;
            positionY = (positionY/10)*10+100;
            draw = false;
            for(SnakeElement element : Snake.getInstance().getSnakeElements()){
                if(element.getPositionX() == positionX && element.getPositionY() == positionY){
                    draw = true;
                }
            }
        }
    }

    public static Food getInstance(){
        if(food == null)
            food = new Food();
        return food;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}

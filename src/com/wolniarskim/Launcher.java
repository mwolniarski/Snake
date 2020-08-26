package com.wolniarskim;

import com.wolniarskim.components.GameWindow;

public class Launcher implements Runnable {
    @Override
    public void run() {
        new GameWindow(640,640);
    }
}

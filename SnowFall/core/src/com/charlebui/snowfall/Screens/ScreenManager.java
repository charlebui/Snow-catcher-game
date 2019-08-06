package com.charlebui.raindrops.Screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class ScreenManager {
    private Stack<Screen> screens;

    public ScreenManager () {
        this.screens = new Stack<Screen>();
    }

    public void push(Screen screen) {
        screens.push(screen);
    }

    public void pop(){
        screens.pop().dispose();
    }

    public void set(Screen screen) {
        screens.pop();
        screens.push(screen);
    }

    public void update(float dt) {
        screens.peek().update(dt);
    }

    public void render(SpriteBatch sb) {
        screens.peek().render(sb);
    }
}

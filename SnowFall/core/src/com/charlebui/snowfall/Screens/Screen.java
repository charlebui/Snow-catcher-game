package com.charlebui.raindrops.Screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class Screen {
    protected ScreenManager sm;
    protected Vector3 mouse;

    public Screen(ScreenManager sm) {
        this.sm = sm;
        mouse = new Vector3();
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}

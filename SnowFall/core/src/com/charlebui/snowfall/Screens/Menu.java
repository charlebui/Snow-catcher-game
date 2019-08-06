package com.charlebui.raindrops.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;


public class Menu extends Screen {
    private Texture bg;
    private Button play;
    private BitmapFont font;

    public Menu(ScreenManager sm) {
        super(sm);
        bg = new Texture("bg2.png");
        font = new BitmapFont();
        font.setColor(Color.BLUE);
        font.getData().setScale(2);
    }


    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            sm.set(new Play(sm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg,0, 0);
        font.draw(sb, "PRESS ANYWHERE TO START!", 100, 200);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        font.dispose();
    }
}

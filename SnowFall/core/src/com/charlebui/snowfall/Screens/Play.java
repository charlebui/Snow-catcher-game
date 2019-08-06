package com.charlebui.raindrops.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.charlebui.raindrops.Sprites.Bucket;
import com.charlebui.raindrops.Sprites.Drops;

import java.util.ArrayList;
import java.util.Random;

public class Play extends Screen {
    private static final int SNOWBALL_COUNT = 50;
    private ScreenManager sm;
    private Texture bg;
    private Bucket bucket;
    private Random rand;
    private ArrayList<Drops> drops;
    private Sound splat;
    private BitmapFont font;
    private int score;

    public Play(ScreenManager sm) {
        super(sm);
        score = 0;
        this.bg = new Texture("bg2.png");
        bucket = new Bucket();
        rand = new Random();
        drops = new ArrayList<Drops>();
        splat = Gdx.audio.newSound(Gdx.files.internal("splat.mp3"));

        font = new BitmapFont();
        font.setColor(Color.BLUE);
        font.getData().setScale(2);

        for (int i = 0; i < SNOWBALL_COUNT; i++) {
            int randomX = rand.nextInt(640);
            int randomY = rand.nextInt(5000) + 600;
            Drops drop = new Drops(randomX, randomY);
            drops.add(drop);
        }
    }

    @Override
    public void handleInput() {
        if (Gdx.input.isTouched()) {
            bucket.setPosition(Gdx.input.getX(), Gdx.input.getY());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && bucket.getPosition().x > 0) {
            bucket.setPosition(bucket.getPosition().x - 10, 0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && bucket.getPosition().x < 640 - bucket.getBucket().getWidth()) {
            bucket.setPosition(bucket.getPosition().x + 10, 0);
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        for (Drops drop : drops) {
            drop.update(dt);

            if (drop.position().y < -10) {
                int x = rand.nextInt(640);
                int y = rand.nextInt(5000) + 600;
                drop.setPosition(x, y);
            }

            if (drop.hitBucket(bucket.hitBox())) {
                splat.play(0.1f);
                int x = rand.nextInt(640);
                int y = rand.nextInt(5000) + 600;
                drop.setPosition(x, y);
                score++;
            }
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg, 0, 0);
        sb.draw(bucket.getBucket(), bucket.getPosition().x, 0);

        for (Drops drop : drops) {
            sb.draw(drop.getDrop(), drop.position().x, drop.position().y);
        }

        font.draw(sb, Integer.toString(score), 310, 350);

        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        for (Drops drop : drops) {
            drop.getDrop().dispose();
        }
        bucket.getBucket().dispose();
        splat.dispose();
        font.dispose();
    }
}

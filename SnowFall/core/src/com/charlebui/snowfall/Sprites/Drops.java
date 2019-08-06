package com.charlebui.raindrops.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Drops {
    private static final int GRAVITY = -2;

    private Texture drop;
    private Vector2 position;
    private Rectangle hitbox;

    public Drops(int x, int y) {
        drop = new Texture("raindrop.png");
        position = new Vector2(x, y);
        hitbox = new Rectangle(x, y, drop.getWidth(), drop.getHeight());
    }

    public boolean hitBucket(Rectangle bucket) {
        return hitbox.overlaps(bucket);
    }

    public void setPosition(float x, float y) {
        position.set(x, y);
        hitbox.setPosition(x, y);
    }

    public void update(float dt) {

        position().add(0, GRAVITY);
        hitbox.setPosition(position().x, position().y);
    }

    public Vector2 position() {
        return position;
    }

    public Texture getDrop() {
        return drop;
    }
}

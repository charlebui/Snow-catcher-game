package com.charlebui.raindrops.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bucket {
    private Texture bucket;
    private Vector2 position;
    private Rectangle bucketHitBox;

    public Bucket() {
        bucket = new Texture("bucket.png");
        bucketHitBox = new Rectangle();

        position = new Vector2();
        position.set(0, 0);
        bucketHitBox.set(position.x,bucket.getHeight()- 40, bucket.getWidth(),1);
    }

    public Rectangle hitBox() {
        return bucketHitBox;
    }

    public void setPosition(float x, float y) {
        position.set(x, y);
        bucketHitBox.setPosition(x, bucket.getHeight()-40);
    }

    public Texture getBucket() {
        return bucket;
    }

    public Vector2 getPosition() {
        return position;
    }
}


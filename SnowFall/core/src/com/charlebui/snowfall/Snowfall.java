package com.charlebui.raindrops;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.charlebui.raindrops.Screens.Menu;
import com.charlebui.raindrops.Screens.Play;
import com.charlebui.raindrops.Screens.ScreenManager;

public class Snowfall extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private ScreenManager sm;
	private Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
		sm = new ScreenManager();
		sm.push(new Menu(sm));
		music = Gdx.audio.newMusic(Gdx.files.internal("soundtrack.mp3"));
		music.play();
		music.setLooping(true);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sm.update(Gdx.graphics.getDeltaTime());
		sm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		music.dispose();
	}
}

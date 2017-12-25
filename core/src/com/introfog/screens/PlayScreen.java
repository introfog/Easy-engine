package com.introfog.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;

import com.introfog.GameSystem;
import com.introfog.MyGame;
import com.introfog.objects.Hole;
import com.introfog.primitiveIsometricEngine.*;
import com.introfog.objects.Character;

public class PlayScreen implements Screen{
	private Character character;
	private Hole hole;
	private OrthographicCamera camera;
	
	
	private static class PlayScreenHolder{
		private final static PlayScreen instance = new PlayScreen ();
	}
	
	private PlayScreen (){ }
	
	
	public static PlayScreen getInstance (){
		return PlayScreenHolder.instance;
	}
	
	@Override
	public void show (){
		new BodyPIE (100, 100, 200, 300);
		new BodyPIE (450, 50, 100, 500, BodyType.dynamical, 0.5f);
		
		hole = new Hole (600, 200, 150, 200);
		character = new Character (330, 50, 20, 20);
		
		camera = new OrthographicCamera (GameSystem.SCREEN_W, GameSystem.SCREEN_H);
		camera.setToOrtho (false);
	}
	
	@Override
	public void render (float delta){
		character.update ();
		hole.update ();
		
		Gdx.gl.glClearColor (0, 0, 0, 1);
		Gdx.gl.glClear (GL20.GL_COLOR_BUFFER_BIT);
		camera.update ();
		World.getInstance ().drawBody (camera.combined);
		
		if (Gdx.input.isKeyJustPressed (Input.Keys.ESCAPE)){
			MyGame.getInstance ().setScreen (MainMenuScreen.getInstance ());
		}
	}
	
	@Override
	public void resize (int width, int height){ }
	
	@Override
	public void pause (){ }
	
	@Override
	public void resume (){ }
	
	@Override
	public void hide (){ }
	
	@Override
	public void dispose (){ }
}

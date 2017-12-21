package com.introfog.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.introfog.GameSystem;
import com.introfog.MyGame;
import com.introfog.primitiveEngine.*;
import com.introfog.objects.Character;
import com.introfog.primitiveEngine.Render;

public class PlayScreen implements Screen{
	private Character character;
	
	
	private static class PlayScreenHolder{
		private final static PlayScreen instance = new PlayScreen ();
	}
	
	private PlayScreen (){ }
	
	
	public static PlayScreen getInstance (){
		return PlayScreenHolder.instance;
	}
	
	@Override
	public void show (){
		Body body;
		
		body = new Body (100, 100, 200, 300);
		World.getInstance ().addBody (body);
		body = new Body (320, 50, 100, 500, BodyType.dynamical, 0.5f);
		World.getInstance ().addBody (body);
		
		character = new Character (420.5f, 200);
		
		OrthographicCamera camera = new OrthographicCamera (GameSystem.SCREEN_W, GameSystem.SCREEN_H);
		camera.setToOrtho (false);
		Render.getInstance ().setOrthographicCamera (camera);
	}
	
	@Override
	public void render (float delta){
		character.update ();
		World.getInstance ().drawBody ();
		
		if (Gdx.input.isKeyJustPressed (Input.Keys.ESCAPE)){
			MyGame.getInstance ().setScreen (SelectedModeScreen.getInstance ());
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

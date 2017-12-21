package com.introfog.screens;

import com.badlogic.gdx.*;
import com.introfog.MyGame;
import com.introfog.primitiveEngine.*;
import com.introfog.primitiveEngine.Character;

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
		Body body = new Body (100, 100, 200, 300);
		World.getInstance ().addBody (body);
		body = new Body (320, 50, 100, 500);
		World.getInstance ().addBody (body);
		character = new Character ();
	}
	
	@Override
	public void render (float delta){
		World.getInstance ().update ();
		World.getInstance ().draw ();
		
		character.update ();
		
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

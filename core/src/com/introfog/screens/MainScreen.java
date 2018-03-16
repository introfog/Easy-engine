package com.introfog.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.introfog.RunTest;
import com.introfog.PrimitiveIsometricEngine.*;

public class MainScreen extends ScreenAdapter{
	private OrthographicCamera camera;
	private Label fpsLabel = new Label ("FPS: 0", TextStyle.getInstance ().labelStyle);
	private Stage stage;
	
	
	private static class PlayScreenHolder{
		private final static MainScreen instance = new MainScreen ();
	}
	
	private MainScreen (){
		stage = new Stage (new ScreenViewport ());
		fpsLabel.setPosition (0f, 0f);
		stage.addActor (fpsLabel);
	}
	
	
	public static MainScreen getInstance (){
		return PlayScreenHolder.instance;
	}
	
	@Override
	public void show (){
		camera = new OrthographicCamera (RunTest.SCREEN_W, RunTest.SCREEN_H);
		camera.setToOrtho (false);
	}
	
	@Override
	public void render (float delta){
		Gdx.gl.glClearColor (0, 0, 0, 1);
		Gdx.gl.glClear (GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update ();
		World.getInstance ().drawBody (camera.combined);
		
		fpsLabel.setText ("FPS: " + (int) (1 / delta));
		stage.act (delta);
		stage.draw ();
		
		if (Gdx.input.isKeyJustPressed (Input.Keys.ESCAPE)){
			World.getInstance ().clear ();
			Gdx.app.exit ();
		}
	}
}

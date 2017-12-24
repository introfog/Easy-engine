package com.introfog;

import com.badlogic.gdx.Game;

import com.introfog.screens.MainMenuScreen;

import static com.introfog.GameSystem.SCREEN_H;
import static com.introfog.GameSystem.SCREEN_W;

public class MyGame extends Game{
	public static final float ASPECT_RATIO = (float) ((SCREEN_W / 2 < SCREEN_H) ? SCREEN_W / 1366 : SCREEN_H / 768);
	public static final float BUTTON_W = 250 * ASPECT_RATIO;
	public static final float BUTTON_H = 55 * ASPECT_RATIO;
	public static final float DISTANCE_BETWEEN_BUTTONS = 15 * ASPECT_RATIO;
	public static final int   BUTTON_FONT_SIZE = (int) (3 * BUTTON_H / 5);
	
	
	private static class MyGameHolder{
		private final static MyGame instance = new MyGame ();
	}
	
	private MyGame (){ }
	
	
	public static MyGame getInstance (){
		return MyGameHolder.instance;
	}
	
	@Override
	public void create (){
		setScreen (MainMenuScreen.getInstance ());
	}
}
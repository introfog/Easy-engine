package com.introfog;

import com.badlogic.gdx.Game;

import com.introfog.screens.MainScreen;


public class RunTest extends Game{
	//public static final boolean FULL_SCREEN = true;
	public static final boolean IS_FULL_SCREEN = false;
	//public static final float SCREEN_W = getDefaultToolkit ().getScreenSize ().width;
	//public static final float SCREEN_H = getDefaultToolkit ().getScreenSize ().height;
	public static final float SCREEN_W = 800;
	public static final float SCREEN_H = 600;
	
	
	private static class MyGameHolder{
		private final static RunTest instance = new RunTest ();
	}
	
	private RunTest (){ }
	
	
	public static RunTest getInstance (){
		return MyGameHolder.instance;
	}
	
	@Override
	public void create (){
		setScreen (MainScreen.getInstance ());
	}
}
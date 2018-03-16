package com.introfog.desktop;

import com.introfog.RunTest;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher{
	public static void main (String[] arg){
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration ();
		
		config.title = "Primitive Isometric Engine";
		config.fullscreen = RunTest.IS_FULL_SCREEN;
		config.width = (int) RunTest.SCREEN_W;
		config.height = (int) RunTest.SCREEN_H;
		
		new LwjglApplication (RunTest.getInstance (), config);
	}
}

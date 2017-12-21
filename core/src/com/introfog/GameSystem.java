package com.introfog;

import static java.awt.Toolkit.getDefaultToolkit;


public abstract class GameSystem{
	public static final String NAME_JAR_ARCHIVE = "project6.jar";
	public static final boolean FULL_SCREEN = true;
	//public static final boolean FULL_SCREEN = false;
	public static final float SCREEN_W = getDefaultToolkit ().getScreenSize ().width;
	public static final float SCREEN_H = getDefaultToolkit ().getScreenSize ().height;
	//public static final float SCREEN_W = 800;
	//public static final float SCREEN_H = 600;
}
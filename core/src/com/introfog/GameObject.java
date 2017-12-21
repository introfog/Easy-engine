package com.introfog;


import static com.introfog.GameSystem.SCREEN_H;
import static com.introfog.GameSystem.SCREEN_W;

public abstract class GameObject{
	public static GameObject triggered[] = new GameObject[2];
	
	public static final float ASPECT_RATIO = (float) ((SCREEN_W / 2 < SCREEN_H) ? SCREEN_W / 1366 : SCREEN_H / 768);
	public static final float UNIT = 64 * ASPECT_RATIO; //условный метр в игре
	public static final float ANGLE = 0.75f;
}
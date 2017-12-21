package com.introfog.primitiveEngine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Character{
	private Body body;
	
	
	public Character (float x, float y){
		body = new Body (x, y, 20, 20);
		World.getInstance ().addBody (body);
	}
	
	public void update (){
		float deltaX = 0;
		float deltaY = 0;
		if (Gdx.input.isKeyPressed (Input.Keys.W)){
			deltaY = 100 * Gdx.graphics.getDeltaTime ();
		}
		if (Gdx.input.isKeyPressed (Input.Keys.D)){
			deltaX = 100 * Gdx.graphics.getDeltaTime ();
		}
		if (Gdx.input.isKeyPressed (Input.Keys.S)){
			deltaY = -100 * Gdx.graphics.getDeltaTime ();
		}
		if (Gdx.input.isKeyPressed (Input.Keys.A)){
			deltaX = -100 * Gdx.graphics.getDeltaTime ();
		}
		
		if (deltaX != 0 || deltaY != 0){
			body.move (deltaX, deltaY);
		}
	}
}

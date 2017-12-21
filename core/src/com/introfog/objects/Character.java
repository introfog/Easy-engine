package com.introfog.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.introfog.primitiveEngine.*;

public class Character{
	private Body body;
	
	
	public Character (float x, float y){
		body = new Body (x, y, 20, 20, BodyType.dynamical, 1f, Color.BLUE);
		World.getInstance ().addObject (body);
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

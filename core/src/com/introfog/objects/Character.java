package com.introfog.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.introfog.primitiveIsometricEngine.*;

public class Character{
	private BodyPIE bodyPIE;
	
	
	public Character (float x, float y){
		bodyPIE = new BodyPIE (x, y, 20, 20, BodyType.dynamical, 1f, Color.BLUE);
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
			bodyPIE.move (deltaX, deltaY);
		}
	}
}

package com.introfog.objects;

import com.badlogic.gdx.graphics.Color;

import com.introfog.primitiveIsometricEngine.*;

public class Hole{
	private TriggeredZone zone;
	
	
	
	public Hole (float x, float y, float w, float h){
		zone = new TriggeredZone (x, y, w, h, Color.CORAL);
	}
	
	public void update (){
		if (zone.getInZone () != null && zone.getInZone ().size () > 0){
			zone.setColor (Color.FOREST);
		}
		else{
			zone.setColor (Color.CORAL);
		}
	}
}

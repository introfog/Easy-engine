package com.introfog.objects;

import com.badlogic.gdx.graphics.Color;

import com.introfog.primitiveEngine.*;

public class Hole{
	private TriggeredZone zone;
	
	
	
	public Hole (float x, float y, float w, float h){
		zone = new TriggeredZone (x, y, w, h, Color.CORAL);
		World.getInstance ().addObject (zone);
	}
	
	public void update (){
		if (zone.getInZone () != null && zone.getInZone ().size () > 0){
			System.out.println ("Contains triggered zone: " + zone.getInZone ().size ());
		}
	}
}

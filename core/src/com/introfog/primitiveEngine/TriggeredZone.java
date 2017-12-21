package com.introfog.primitiveEngine;

public class TriggeredZone extends Body{
	private ZoneType type = ZoneType.intersects;
	
	
	public TriggeredZone (float x, float y, float w, float h, ZoneType type){
		super (x, y, w, h);
		this.type = type;
	}
}

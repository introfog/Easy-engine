package com.introfog.primitiveEngine;

import com.introfog.primitiveEngine.messages.WorldMessage;
import com.introfog.render.Render;

import java.util.LinkedList;

public class World{
	private LinkedList <Body> objects;
	
	
	private static class ObjectManagerHolder{
		private final static World instance = new World ();
	}
	
	private World (){
		objects = new LinkedList <> ();
	}
	
	
	public static World getInstance (){
		return ObjectManagerHolder.instance;
	}
	
	public void addBody (Body body){
		objects.add (body);
	}
	
	public void addMessage (WorldMessage message){
		boolean next = true;
		for (int i = objects.size () - 1; i > -1 && !objects.isEmpty () && next; i--){
			next = !objects.get (i).sendMessage (message);
		}
	}
	
	public void drawBody (){
		for (Body tmpB : objects){
			tmpB.drawBody ();
		}
		Render.getInstance ().renderScene ();
	}
}
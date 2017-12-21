package com.introfog.primitiveEngine;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.introfog.GameSystem;
import com.introfog.primitiveEngine.messages.WorldMessage;
import com.introfog.render.Render;

import java.util.LinkedList;

public class World{
	private LinkedList <WorldMessage> messages;
	private LinkedList <Body> objects;
	
	
	private static class ObjectManagerHolder{
		private final static World instance = new World ();
	}
	
	private World (){
		messages = new LinkedList <> ();
		objects = new LinkedList <> ();
		OrthographicCamera camera = new OrthographicCamera (GameSystem.SCREEN_W, GameSystem.SCREEN_H);
		camera.setToOrtho (false);
		Render.getInstance ().setOrthographicCamera (camera);
	}
	
	
	public static World getInstance (){
		return ObjectManagerHolder.instance;
	}
	
	public void addBody (Body body){
		objects.add (body);
	}
	
	public void addMessage (WorldMessage message){
		messages.add (message);
	}
	
	public void update (){
		while (!messages.isEmpty ()){
			WorldMessage msg = messages.remove ();
			
			for (int i = objects.size () - 1; i > -1 && !objects.isEmpty (); i--){
				objects.get (i).sendMessage (msg);
			}
		}
	}
	
	public void draw (){
		for (Body tmpB : objects){
			tmpB.drawBody ();
		}
		Render.getInstance ().renderScene ();
	}
}
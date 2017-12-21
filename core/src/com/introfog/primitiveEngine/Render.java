package com.introfog.primitiveEngine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.LinkedList;

public class Render{
	private OrthographicCamera camera;
	private ShapeRenderer shapeRenderer;
	private LinkedList <Rectangle> rectangles;
	
	
	private static class RenderHolder{
		private final static Render instance = new Render ();
	}
	
	private Render (){
		shapeRenderer = new ShapeRenderer ();
		rectangles = new LinkedList <> ();
	}
	
	
	public static Render getInstance (){
		return RenderHolder.instance;
	}
	
	public void setOrthographicCamera (OrthographicCamera camera){
		this.camera = camera;
	}
	
	public void renderScene (){
		Gdx.gl.glClearColor (0, 0, 0, 1);
		Gdx.gl.glClear (GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update ();
		
		shapeRenderer.setColor (Color.WHITE);
		shapeRenderer.begin (ShapeRenderer.ShapeType.Line);
		for (Rectangle tmpR : rectangles){
			shapeRenderer.rect (tmpR.getX (), tmpR.getY (), tmpR.getW (), tmpR.getH ());
		}
		shapeRenderer.end ();
		
		rectangles.clear ();
	}
	
	public void addRectangle (Rectangle rectangle){
		rectangles.add (rectangle);
	}
}
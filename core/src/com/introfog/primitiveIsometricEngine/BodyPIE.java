package com.introfog.primitiveIsometricEngine;

import com.badlogic.gdx.graphics.Color;

import com.introfog.primitiveIsometricEngine.messages.*;

public class BodyPIE{
	protected boolean isGhost = false;
	protected Rectangle body;
	
	private float pushOutX;
	private float pushOutY;
	private float friction = 1;
	private BodyType type = BodyType.statical;
	
	
	public BodyPIE (float x, float y, float w, float h){
		body = new Rectangle (x, y, w, h);
		World.getInstance ().addObject (this);
	}
	
	public BodyPIE (float x, float y, float w, float h, Color color){
		body = new Rectangle (x, y, w, h);
		body.color = color;
		World.getInstance ().addObject (this);
	}
	
	public BodyPIE (float x, float y, float w, float h, BodyType type, float friction){
		this.friction = friction;
		this.type = type;
		body = new Rectangle (x, y, w, h);
		World.getInstance ().addObject (this);
	}
	
	public BodyPIE (float x, float y, float w, float h, BodyType type, float friction, Color color){
		this.friction = friction;
		this.type = type;
		body = new Rectangle (x, y, w, h);
		body.color = color;
		World.getInstance ().addObject (this);
	}
	
	public boolean isGhost (){
		return isGhost;
	}
	
	public void setGhost (boolean isGhost){
		this.isGhost = isGhost;
	}
	
	public void move (float deltaX, float deltaY){
		if (isGhost){
			return;
		}
		World.getInstance ().addMessage (new MoveMessage (this, deltaX, deltaY));
		body.move (deltaX, deltaY);
	}
	
	public void drawBody (){
		RenderWorld.getInstance ().addRectangle (body);
	}
	
	public void sendMessage (WorldMessage message){
		if (message.type == MessageType.move && message.bodyPIE != this){
			MoveMessage msg = (MoveMessage) message;
			Rectangle rect = msg.bodyPIE.body;
			pushOutX = 0;
			pushOutY = 0;
			if (msg.deltaX != 0 && body.intersects (rect.getX () + msg.deltaX, rect.getY (), rect.getW (), rect.getH ())){
				if (body.contains (rect.getX () + msg.deltaX, rect.getY (), rect.getW (), rect.getH ())){
					return;
				}
				if (type == BodyType.statical){
					pushOutX = -msg.deltaX;
				}
				else if (type == BodyType.dynamical){
					move (msg.deltaX * friction, 0);
					pushOutX = -msg.deltaX * (1 - friction);
				}
			}
			if (msg.deltaY != 0 && body.intersects (rect.getX (), rect.getY () + msg.deltaY, rect.getW (), rect.getH ())){
				if (body.contains (rect.getX (), rect.getY () + msg.deltaY, rect.getW (), rect.getH ())){
					return;
				}
				if (type == BodyType.statical){
					pushOutY = -msg.deltaY;
				}
				else if (type == BodyType.dynamical){
					move (0, msg.deltaY * friction);
					pushOutY = -msg.deltaY * (1 - friction);
				}
			}
			if (pushOutX != 0 && pushOutY != 0){
				World.getInstance ().addMessage (new PushOutMessage (msg.bodyPIE, pushOutX * 1.2f, pushOutY * 1.2f));
			}
			else if (pushOutX != 0 || pushOutY != 0){
				World.getInstance ().addMessage (new PushOutMessage (msg.bodyPIE, pushOutX, pushOutY));
			}
		}
		else if (message.type == MessageType.pushOut && message.bodyPIE == this){
			PushOutMessage msg = (PushOutMessage) message;
			move (msg.deltaX, msg.deltaY);
		}
	}
	
	public void setBodyType (BodyType type){
		this.type = type;
	}
	
	public void setPosition (float x, float y){
		body.setPosition (x, y);
	}
	
	public void setBounds (float x, float y, float w, float h){
		body.setBounds (x, y, w, h);
	}
	
	public float getX (){
		return body.getX ();
	}
	
	public float getY (){
		return body.getY ();
	}
	
	public float getW (){
		return body.getW ();
	}
	
	public float getH (){
		return body.getH ();
	}
}
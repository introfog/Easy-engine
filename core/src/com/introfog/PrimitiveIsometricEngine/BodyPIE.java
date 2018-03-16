package com.introfog.PrimitiveIsometricEngine;

import com.badlogic.gdx.graphics.Color;

import com.introfog.PrimitiveIsometricEngine.messages.*;

public class BodyPIE{
	protected boolean isGhost = false;
	protected Rectangle body;
	
	private float friction = 1;
	private BodyType type = BodyType.statical;
	
	
	private void moveX (float deltaX){
		if (isGhost){
			return;
		}
		World.getInstance ().addMessage (new MoveMessage (this, deltaX, 0));
		body.move (deltaX, 0);
	}
	
	private void moveY (float deltaY){
		if (isGhost){
			return;
		}
		World.getInstance ().addMessage (new MoveMessage (this, 0, deltaY));
		body.move (0, deltaY);
	}
	
	
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
	
	public void setGhost (boolean isGhost){
		this.isGhost = isGhost;
	}
	
	public void move (float deltaX, float deltaY){
		if (isGhost){
			return;
		}
		if (deltaX != 0){
			moveX (deltaX);
		}
		if (deltaY != 0){
			moveY (deltaY);
		}
	}
	
	public void drawBody (){
		if (isGhost){
			return;
		}
		RenderWorld.getInstance ().addRectangle (body);
	}
	
	public void sendMessage (WorldMessage message){
		if (isGhost){
			return;
		}
		if (message.type == MessageType.move && message.bodyPIE != this){
			MoveMessage msg = (MoveMessage) message;
			Rectangle rect = msg.bodyPIE.body;
			float pushOutX;
			float pushOutY;
			
			if (body.contains (rect.getX () + msg.deltaX, rect.getY () + msg.deltaY, rect.getW (), rect.getH ())){
				return;
			}
			else if (body.intersects (rect.getX (), rect.getY (), rect.getW (), rect.getH ())){
				return;
			}
			else if (body.intersects (rect.getX () + msg.deltaX, rect.getY () + msg.deltaY, rect.getW (), rect.getH ())){
				if (type == BodyType.statical){
					pushOutX = -msg.deltaX;
					pushOutY = -msg.deltaY;
					World.getInstance ().addMessage (new PushOutMessage (msg.bodyPIE, pushOutX, pushOutY));
				}
				else if (type == BodyType.dynamical){
					move (msg.deltaX * friction, msg.deltaY * friction);
					pushOutX = -msg.deltaX * (1 - friction);
					pushOutY = -msg.deltaY * (1 - friction);
					msg.bodyPIE.move (pushOutX, pushOutY);
				}
			}
		}
		else if (message.type == MessageType.pushOut && message.bodyPIE == this){
			PushOutMessage msg = (PushOutMessage) message;
			move (msg.deltaX, msg.deltaY);
		}
		else if (message.type == MessageType.pushOut){
			PushOutMessage msg = (PushOutMessage) message;
			Rectangle rect = msg.bodyPIE.body;
			
			if (body.intersects (rect.getX () + msg.deltaX, rect.getY () + msg.deltaY, rect.getW (), rect.getH ())){
				if (type == BodyType.dynamical){
					move (msg.deltaX, msg.deltaY);
				}
			}
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
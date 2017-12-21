package com.introfog.primitiveEngine;

import com.introfog.primitiveEngine.messages.*;

public class Body{
	private float friction = 1;
	private BodyType type = BodyType.statical;
	protected Rectangle body;
	
	public Body (float x, float y, float w, float h){
		body = new Rectangle (x, y, w, h);
	}
	
	public Body (float x, float y, float w, float h, BodyType type, float friction){
		this.friction = friction;
		this.type = type;
		body = new Rectangle (x, y, w, h);
	}
	
	public void move (float deltaX, float deltaY){
		World.getInstance ().addMessage (new MoveMessage (this, deltaX, deltaY));
		body.move (deltaX, deltaY);
	}
	
	public void drawBody (){
		Render.getInstance ().addRectangle (body);
	}
	
	public void sendMessage (WorldMessage message){
		if (message.type == MessageType.move && message.body != this){
			MoveMessage msg = (MoveMessage) message;
			Rectangle rect = msg.body.body;
			if (msg.deltaX != 0 && body.intersects (rect.getX () + msg.deltaX, rect.getY (), rect.getW (), rect.getH ())){
				if (type == BodyType.statical){
					World.getInstance ().addMessage (new PushOutMessage (msg.body, -msg.deltaX, 0));
				}
				else if (type == BodyType.dynamical){
					move (msg.deltaX * friction, 0);
					World.getInstance ().addMessage (new PushOutMessage (msg.body, -msg.deltaX * friction, 0));
				}
			}
			if (msg.deltaY != 0 && body.intersects (rect.getX (), rect.getY () + msg.deltaY, rect.getW (), rect.getH ())){
				if (type == BodyType.statical){
					World.getInstance ().addMessage (new PushOutMessage (msg.body, 0, -msg.deltaY));
				}
				else if (type == BodyType.dynamical){
					move (0, msg.deltaY * friction);
					World.getInstance ().addMessage (new PushOutMessage (msg.body, 0, -msg.deltaY * friction));
				}
			}
		}
		else if (message.type == MessageType.pushOut && message.body == this){
			PushOutMessage msg = (PushOutMessage) message;
			move (msg.deltaX, msg.deltaY);
		}
	}
}
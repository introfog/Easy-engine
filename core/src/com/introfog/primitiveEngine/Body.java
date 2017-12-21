package com.introfog.primitiveEngine;

import com.introfog.primitiveEngine.messages.*;
import com.introfog.render.Render;

public class Body{
	private Rectangle body;
	
	public Body (float x, float y, float w, float h){
		body = new Rectangle (x, y, w, h);
	}
	
	public void move (float deltaX, float deltaY){
		World.getInstance ().addMessage (new MoveMessage (this, deltaX, deltaY));
		body.move (deltaX, deltaY);
	}
	
	public void drawBody (){
		Render.getInstance ().addRectangle (body);
	}
	
	public boolean sendMessage (WorldMessage message){
		if (message.type == MessageType.move && message.body != this){
			MoveMessage msg = (MoveMessage) message;
			Rectangle rect = msg.body.body;
			boolean handle = false;
			if (msg.deltaX != 0 && body.intersects (rect.getX () + msg.deltaX, rect.getY (), rect.getW (), rect.getH ())){
				World.getInstance ().addMessage (new PushOutMessage (msg.body, -msg.deltaX, 0));
				handle = true;
			}
			if (msg.deltaY != 0 && body.intersects (rect.getX (), rect.getY () + msg.deltaY, rect.getW (), rect.getH ())){
				World.getInstance ().addMessage (new PushOutMessage (msg.body, 0, -msg.deltaY));
				handle = true;
			}
			return handle;
		}
		else if (message.type == MessageType.pushOut && message.body == this){
			PushOutMessage msg = (PushOutMessage) message;
			body.move (msg.deltaX, msg.deltaY);
			return true;
		}
		return false;
	}
}

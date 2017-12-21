package com.introfog.primitiveEngine;

import com.introfog.primitiveEngine.messages.*;
import com.introfog.render.Render;

public class Body{
	private Rectangle rectangle;
	
	public Body (float x, float y, float w, float h){
		rectangle = new Rectangle (x, y, w, h);
	}
	
	public void move (float deltaX, float deltaY){
		System.out.println (rectangle.getX () + " " + rectangle.getY () + " " + deltaX + " " + deltaY);
		World.getInstance ().addMessage (new MoveMessage (this, deltaX, deltaY));
		rectangle.move (deltaX, deltaY);
	}
	
	public void drawBody (){
		Render.getInstance ().addRectangle (rectangle);
	}
	
	public void sendMessage (WorldMessage message){
		if (message.type == MessageType.move && message.body != this){
			MoveMessage msg = (MoveMessage) message;
			Rectangle rect = msg.body.rectangle;
			if (msg.deltaX != 0 && rectangle.intersects (rect.getX () + msg.deltaX, rect.getY (), rect.getW (), rect.getH ())){
				World.getInstance ().addMessage (new PushOutMessage (msg.body, -msg.deltaX, 0));
			}
			if (msg.deltaY != 0 && rectangle.intersects (rect.getX (), rect.getY () + msg.deltaY, rect.getW (), rect.getH ())){
				World.getInstance ().addMessage (new PushOutMessage (msg.body, 0, -msg.deltaY));
			}
		}
		else if (message.type == MessageType.pushOut && message.body == this){
			PushOutMessage msg = (PushOutMessage) message;
			rectangle.move (msg.deltaX, msg.deltaY);
			World.getInstance ().addMessage (new MoveMessage (this, msg.deltaX, msg.deltaY));
		}
	}
}

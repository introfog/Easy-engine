package com.introfog.primitiveEngine.messages;

import com.introfog.primitiveEngine.Body;

public class PushOutMessage extends WorldMessage{
	public float deltaX;
	public float deltaY;
	
	
	public PushOutMessage (Body body, float deltaX, float deltaY){
		this.type = MessageType.pushOut;
		this.body = body;
		
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
}

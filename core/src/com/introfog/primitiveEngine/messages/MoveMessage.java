package com.introfog.primitiveEngine.messages;


import com.introfog.primitiveEngine.Body;

public class MoveMessage extends WorldMessage{
	public float deltaX;
	public float deltaY;
	
	
	public MoveMessage (Body body, float deltaX, float deltaY){
		this.type = MessageType.move;
		this.body = body;
		
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
}

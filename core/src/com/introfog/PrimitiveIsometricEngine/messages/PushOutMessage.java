package com.introfog.PrimitiveIsometricEngine.messages;

import com.introfog.PrimitiveIsometricEngine.BodyPIE;

public class PushOutMessage extends WorldMessage{
	public float deltaX;
	public float deltaY;
	
	
	public PushOutMessage (BodyPIE bodyPIE, float deltaX, float deltaY){
		this.type = MessageType.pushOut;
		this.bodyPIE = bodyPIE;
		
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
}

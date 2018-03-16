package com.introfog.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import com.introfog.RunTest;

public class TextStyle{
	private int BUTTON_FONT_SIZE = (int) RunTest.SCREEN_H / 30;
	
	public Label.LabelStyle labelStyle;
	public TextButton.TextButtonStyle normalStyle;
	
	
	private void createStyle (){
		TextureAtlas buttonAtlas = new TextureAtlas ("core/assets/images/button/button.atlas");
		Skin skin = new Skin ();
		skin.addRegions (buttonAtlas);
		
		normalStyle = new TextButton.TextButtonStyle ();
		normalStyle.font = Font.generateFont ("core/assets/fonts/Russian font.ttf", BUTTON_FONT_SIZE, Color.WHITE);
		normalStyle.up = skin.getDrawable ("button_up");
		normalStyle.over = skin.getDrawable ("button_checked");
		normalStyle.down = skin.getDrawable ("button_checked");
		
		labelStyle = new Label.LabelStyle ();
		labelStyle.font = Font.generateFont ("core/assets/fonts/Russian font.ttf", BUTTON_FONT_SIZE, Color.WHITE);
	}
	
	private static class TextStyleHolder{
		private final static TextStyle instance = new TextStyle ();
	}
	
	private TextStyle (){
		createStyle ();
	}
	
	
	public static TextStyle getInstance (){
		return TextStyleHolder.instance;
	}
}
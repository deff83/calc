/**
 * 
 */
package com.Deff83.Application;

import java.io.IOException;
import java.io.StringReader;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * @author Deff83
 *
 */
public class MyButton extends Button {
	private String buttonColor = "#ee88aa";
	private String buttonOnMouseColor = "#cc6688";
	private String buttonOnPressColor = "#aa4477";
	
	
	public MyButton() {
		// TODO Auto-generated constructor stub
		
	}

	
	public MyButton(String arg0) {
		super(arg0);
		setColorButton();
	}
	

	public MyButton(String arg0, String buttonColor, String buttonOnMouseColor, String buttonOnPressColor) {
		super(arg0);
		this.buttonColor = buttonColor;
		this.buttonOnMouseColor = buttonOnMouseColor;
		this.buttonOnPressColor = buttonOnPressColor;
		setColorButton();
	}
	
	public MyButton(String arg0, String buttonColor) {
		super(arg0);
		this.buttonColor = buttonColor;
		StringReader brs = new StringReader(buttonColor);
		String red = "ff";
		String green = "ff";
		String blue = "ff";
		char[] rgb = new char[7];
		try {
			brs.read(rgb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int i = 1; i<7; i++) {
			if(rgb[i]!='a'&&rgb[i]!='A'&&rgb[i]!='0'&&
				rgb[i]!='b'&&rgb[i]!='B'&&rgb[i]!='1') {
			rgb[i] -= 2;
			}
			if(rgb[i]=='1') {
				rgb[i] -= 1;
				}
			
			if(rgb[i]=='a'||rgb[i]=='A') {
				rgb[i]='8';
			}
			if(rgb[i]=='b'||rgb[i]=='B') {
				rgb[i]='9';
			}
			
		}

		red = ""+rgb[1]+rgb[2];
		green = ""+rgb[3]+rgb[4];
		blue = ""+rgb[5]+rgb[6];
		String colorOnMouse = "#"+red+green+blue;
		
		for(int i = 1; i<7; i++) {
			if(rgb[i]!='a'&&rgb[i]!='A'&&rgb[i]!='0'&&
				rgb[i]!='b'&&rgb[i]!='B'&&rgb[i]!='1') {
			rgb[i] -= 2;
			}
			if(rgb[i]=='1') {
				rgb[i] -= 1;
				}
			
			if(rgb[i]=='a'||rgb[i]=='A') {
				rgb[i]='8';
			}
			if(rgb[i]=='b'||rgb[i]=='B') {
				rgb[i]='9';
			}
			
		}
		red = ""+rgb[1]+rgb[2];
		green = ""+rgb[3]+rgb[4];
		blue = ""+rgb[5]+rgb[6];
		String colorOnPress = "#"+red+green+blue;
		
		
		
		this.buttonOnMouseColor = colorOnMouse;
		this.buttonOnPressColor = colorOnPress;
		setColorButton();
	}
	
	
	

	public String getButtonColor() {
		return buttonColor;
	}

	public void setButtonColor(String buttonColor) {
		this.buttonColor = buttonColor;
	}

	public String getButtonOnMouseColor() {
		return buttonOnMouseColor;
	}

	public void setButtonOnMouseColor(String buttonOnMouseColor) {
		this.buttonOnMouseColor = buttonOnMouseColor;
	}

	public String getButtonOnPressColor() {
		return buttonOnPressColor;
	}

	public void setButtonOnPressColor(String buttonOnPressColor) {
		this.buttonOnPressColor = buttonOnPressColor;
	}
	
	private void setColorButton() {
		setStyle("-fx-background-color:"+buttonColor);
		// TODO Auto-generated constructor stub
			
		setOnMouseMoved(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setStyle("-fx-background-color:"+buttonOnMouseColor);
			}
			
		});
		setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setStyle("-fx-background-color:"+buttonColor);
			}
			
		});
		setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setStyle("-fx-background-color:"+buttonOnPressColor);
			}
			
		});
		setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setStyle("-fx-background-color:"+buttonOnMouseColor);
			}
			
		});
	}


}

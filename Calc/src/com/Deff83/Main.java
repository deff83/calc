package com.Deff83;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import com.Deff83.Application.MainApplication;

import javafx.application.Application;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable wind = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Application.launch(MainApplication.class, args);
			}
			
		};
	
		try {
			SwingUtilities.invokeAndWait(wind);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

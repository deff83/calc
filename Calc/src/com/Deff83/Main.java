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
		
		/*try(FileWriter fw = new FileWriter("char.txt")){
		for(int i = 0; i<65000; i++) {
			
				String chartext = ((char) i)+" - ((char) "+i+")";
				fw.write(chartext);
				fw.write("\r\n");
		}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		System.out.println("ok");
		
		*/
		/*try(FileWriter fw2 = new FileWriter("u0000.txt")){
			for(int i = 0; i<10000; i++) {
			String str = "\u0021";
			fw2.write(str);
			fw2.write("\r\n");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		
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

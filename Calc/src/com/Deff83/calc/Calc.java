package com.Deff83.calc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Calc {
	private String label = "calc";
	private String result = "0";
	private List<Calcv> calcs = new ArrayList<Calcv>();
	public Calc() {
		// TODO Auto-generated constructor stub
	}
	public void calc(String button) {
		if(calcs.size()==0) {
			calcs.add(new Calcv());
		}
		if (button.equals("C")) {
			
			calcs = new ArrayList<Calcv>();
			calcs.add(new Calcv());
			
			}
		if(button.equals("(")) {
			Calcv calcvcalcdel = calcs.get(calcs.size()-1);
			if(calcvcalcdel.getLabel().equals("calc")){
				calcvcalcdel.setLabel("");
			}
			
			
			Calcv newcalcv = new Calcv();
			calcs.add(newcalcv);
			newcalcv.setLabel("");
			
			
			
		}
		
		Calcv calcv = calcs.get(calcs.size()-1);
		calcv.calc(button);
		result = calcv.getResult();
		if(button.equals(")")) {}else {
		label = "";
		Iterator iterator = calcs.iterator();
		boolean otobrscobki = false;
		while(iterator.hasNext()) {
			Calcv calcvit = (Calcv) iterator.next();
			if (otobrscobki) {
				label += "(";
			}
			label += calcvit.getLabel();
			otobrscobki = true;
		}
		}
		String poslr = "";
		String poslrlabel = "";
		String posllabel = "";
		if(button.equals(")")) {
			if(calcs.size()>1) {
			Calcv calcvposl = calcs.get(calcs.size()-1);
			poslrlabel = calcvposl.getResult();
			calcvposl.calc("=");
			poslr = calcvposl.getResult();
			posllabel = calcvposl.getLabel();
			boolean resulget = calcvposl.isResinlabel();
			calcs.remove(calcs.size()-1);
			Calcv calcvtek = calcs.get(calcs.size()-1);
			//calcvtek.setLabel(calcvtek.getLabel());
			Double poslrlabeldouble = Double.parseDouble(poslrlabel);
			if(resulget==false) {
				poslrlabel = "";
				poslrlabeldouble = 1.0;
			}
			label = poslrlabeldouble>=0 ? label+poslrlabel+")":label+"("+poslrlabel+")"+")";
			
			result = poslr;
			calcvtek.setResult(poslr);
			}
		}
		if(button.equals("=")) {
			label = "";
			Calcv calcvravnofast = calcs.get(calcs.size()-1);
			result = calcvravnofast.getResult();
			if(calcs.size()>1) calcs.remove((calcs.size()-1));
			boolean cicl = false;
			while(calcs.size()>0) {
				cicl = true;
				Calcv calcvravno = calcs.get((calcs.size()-1));
				calcvravno.setResult(result);
				
				calcvravno.calc("=");
				result = calcvravno.getResult();
				if(calcs.size()>1) {
					calcs.remove((calcs.size()-1));
				}else {
					break;
				}
				
				
			}
			
			/*Calcv calcvravno = calcs.get(calcs.size()-1);
			calcvravno.setResult(result);
			
			calcvravno.calc("=");
			result = calcvravno.getResult();*/
			
		}
		
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}

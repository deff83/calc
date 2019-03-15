package com.Deff83.calc;

public class Calcv {

	private String label = "calc";
	private String result = "0";
	private boolean newPoint = true;
	private Double b =0.0;
	private Double a =0.0;
	private boolean point = true;
	private char c = '+';
	private boolean resinlabel = true;
	private String slochnayFunct = null;
	private String labelpred = null;
	
	public Calcv() {
		// TODO Auto-generated constructor stub
	}
	public void calc(String button) {
		char symbol = button.charAt(0);
		
		
		
		if(symbol>='0'&&symbol<='9') {
			if(newPoint) {
				
				result = button;
				if(symbol!='0') {
					newPoint = false;
				}
			}else {
				
				if(result.length()<13) {
				result += button;
				}
			}
			
			
		}
		if(symbol==',') {
			if(result.length()<13) {
				if (point) {
				result += ".";
				point = false;
				newPoint = false;
				}
				}
		}
		/*if (button.equals("C")) {
			b = 0.0; a = 0.0;
			c = '+';
			label = "calc";
			point = true;
			result = "0";
			newPoint = true;
			cpr = '+';
			respr = 0.0;
			}*/
		if(symbol=='+'||symbol=='*'||symbol=='/'||symbol=='-'||symbol=='^') {
			if(labelpred!=null) {
				slochnayFunct = null;
				labelpred = null;
			}
			changeLabel(result,symbol);
			
			primeDeist(a,Double.parseDouble(result),symbol);
			//System.out.println(respr);
			a = getRound(a);
			
			result = ""+a;
			newPoint = true;
			point = true;
			c = symbol;
		}
		if(button.equals("=")) {
			primeDeist(a,Double.parseDouble(result),'=');
			
			a = getRound(a);
			result = ""+a;
			//System.out.println(a+"---"+result);
			
			newPoint = true;
			point = true;
			label = "";
			b = 0.0; a = 0.0;
			c = '+'; respr = 0.0;
		}
		if(button.equals(String.valueOf((char) 177))) {//±
			double resnegativ = Double.parseDouble(result);
			resnegativ = -resnegativ;
			result = ""+resnegativ;
		}
		if(button.equals("sqr")) {
			double resnegativ = Double.parseDouble(result);
			resnegativ = Math.sqrt(resnegativ) ;
			if(label.equals("calc")) label = "";
			if(slochnayFunct==null) {
				slochnayFunct = "sqr(" + result +")";
				labelpred = label;
			}else {slochnayFunct = "sqr(" + slochnayFunct +")";}
			
			label = labelpred + slochnayFunct;
			result = ""+getRound(resnegativ);
			resinlabel = false;
		}
		if(button.equals("reciproc")) {
			double resnegativ = Double.parseDouble(result);
			resnegativ = 1/resnegativ ;
			if(label.equals("calc")) label = "";
			if(slochnayFunct==null) {
				slochnayFunct = "1/(" + result +")";
				labelpred = label;
			}else {slochnayFunct = "1/(" + slochnayFunct +")";}
			
			label = labelpred + slochnayFunct;
			result = ""+getRound(resnegativ);
			resinlabel = false;
		}
		if(button.equals("CE")) {
			result = "0";
			if(slochnayFunct!=null) {
				label = labelpred;
			}
			slochnayFunct = null;
			labelpred = null;
			newPoint = true;
			point = true;
			resinlabel = true;
		}
		if(button.equals("backspase")) {
			
			StringBuffer sbufbackspace = new StringBuffer(result);
			
			String symboldel = sbufbackspace.substring(sbufbackspace.length()-1);
			if(symboldel.equals(".")) {
				point = true;
			}
			//System.out.println(symboldel);
			Double resultdouble = Double.parseDouble(result);
			result = sbufbackspace.substring(0,sbufbackspace.length()-1);
			
			if(sbufbackspace.length()==1&&resultdouble>=0) {
				result = "0";
				newPoint = true;
			}
			if(sbufbackspace.length()==2&&resultdouble<0) {
				result = "0";
				newPoint = true;
			}
			
			
		}
	}
	private char cpr = '+';
	private double respr = 0.0;
	//функция простых вычислений
	private void primeDeist(double ad, double bd, char cd) {
		double res = 0.0;
		if(c=='+') {
			
			respr += ad;
			cpr = '+';
			a = bd;
			
			if(cd=='+'||cd=='-') {
			if(cpr=='+') {
				a += respr;
				respr = 0.0;
			}
			if(cpr=='-') {
				a = -respr-a;
				respr = 0.0;
			}
			}
		}
		if(c=='*') {
			a = ad * bd;
			if(cd=='+'||cd=='-') {
				if(cpr=='+') {
					a += respr;
					respr = 0.0;
				}
				if(cpr=='-') {
					a = -respr-a;
					respr = 0.0;
				}
				}
		}
		if(c=='/') {
			a = ad / bd;
			if(cd=='+'||cd=='-') {
				if(cpr=='+') {
					a += respr;
					respr = 0.0;
				}
				if(cpr=='-') {
					a = -respr-a;
					respr = 0.0;
				}
				}
		}
		if(c=='-') {
			
			respr -= ad;
			cpr = '-';
			a = bd;
			if(cd=='+'||cd=='-') {
				if(cpr=='+') {
					a += respr;
					respr = 0.0;
				}
				if(cpr=='-') {
					a = -respr-a;
					respr = 0.0;
				}
				}
		}
		if(cd=='=') {
			//System.out.println("равноооооооооо");
			
				if(cpr=='+') {
					a += respr;
					respr = 0.0;
				}
				if(cpr=='-') {
					a = -respr-a;
					respr = 0.0;
				}
			
			
		}
		
		
	}
	/*private Double getNum(String numstr) {
		Double num = 0.0;
		boolean pointnum = false;
		boolean minusznak = false;
		int pointpozic = 0;
		char[] funcchar = numstr.toCharArray();//массив символов строки func
		for(int i = 0; i<funcchar.length; i++) {
		char symbol = funcchar[i];
		if(symbol>='0'&&symbol<='9') {
			num = pointnum ? num + (symbol - 48)*Math.pow(0.1, i-pointpozic):num * 10 + (symbol - 48);
		}
		if(symbol=='.') {
			pointnum = true;
			pointpozic = i;
		}
		if(symbol=='-') {
			minusznak = true;
		}
		if(symbol=='E') {
			int stepeni = 0;
			boolean minusstepen = false;
			for(int j = i+1; j<funcchar.length; j++) {
				char symboll = funcchar[j];
				
				if(symboll=='-') {
					minusstepen = true;
				}
				if(symboll>='0'&&symboll<='9') {
					stepeni = stepeni*10 + (symbol - 48);
				}
			}
			if (minusstepen) {
				stepeni = -stepeni;
			}
			num = num * Math.pow(10, stepeni);
			
			break;
		}
		}
		if(minusznak) {
			num = - num;
		}
		return num;
	}*/
	
	private void changeLabel(String resultlb, char symbol) {
		if (label.equals("calc")) {
			label = "";
		}
		Double rusultlbdouble = Double.parseDouble(resultlb);
		if(resinlabel==false) {resultlb = "";
		rusultlbdouble = 1.0;
		}
		label = rusultlbdouble>=0 ? label +""+resultlb+symbol:label +"("+resultlb+")"+symbol;
		resinlabel = true;
	}
	private Double getRound(double isc) {
		int i = (int) Math.log10(Math.abs(isc));
		if (i<0) --i;
		double resRound = 0.0;
		
		String iscstr = isc+"";
		StringBuffer sbuf = new StringBuffer(iscstr);
		//System.out.println(sbuf.toString()+"***");
		if(i<=0&&sbuf.length()>11) {
		
		if(i>=-3) {if(sbuf.length()>13) sbuf.delete(13, sbuf.length());}else {
		if(i>-10) {
			sbuf.delete(sbuf.length()-3, sbuf.length());
			if(sbuf.length()>11) {
				sbuf.delete(11, sbuf.length());
			}
		};
		if(i<=-10) {
			sbuf.delete(sbuf.length()-4, sbuf.length());
			if(sbuf.length()>11) {
				sbuf.delete(11, sbuf.length());
			}
		}
		}
		if(i<-3) sbuf.append("E"+i);
		
		}
		
		if(i>0&&sbuf.length()>11) {
			if(i<7) {if(sbuf.length()>14) sbuf.delete(14, sbuf.length());}else {
				if(i>9) {
					sbuf.delete(sbuf.length()-3, sbuf.length());
					if(sbuf.length()>11) {
						sbuf.delete(11, sbuf.length());
					}
				};
				if(i<=9) {
					sbuf.delete(sbuf.length()-4, sbuf.length());
					if(sbuf.length()>11) {
						sbuf.delete(11, sbuf.length());
					}
				}
			}
			if(i>=7) sbuf.append("E"+i);
			
			}
		
		resRound = Double.parseDouble(sbuf.toString());
		//System.out.println(resRound+"<---"+sbuf.toString()+"<---"+isc);
		
		return resRound;
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
	public boolean isResinlabel() {
		return resinlabel;
	}
	
}

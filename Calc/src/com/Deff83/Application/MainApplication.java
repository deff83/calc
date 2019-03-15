package com.Deff83.Application;

import com.Deff83.calc.Calc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApplication extends Application {

	private Calc calc;
	private TextField textfield;
	private Label label;
	public MainApplication() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		calc = new Calc();
		
	}
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("wind");
		BorderPane bp = new BorderPane();
		Scene scene = new Scene(bp, 320, 385, Color.AQUAMARINE);
		BorderPane rootbp = new BorderPane();
		
		
		
		EventHandler<ActionEvent> eventhandler = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Button but = (Button) arg0.getSource();
				String button = but.getText();
				if(but.getText().equals("\u221A")) {
					button = "sqr";
				}
				if(but.getText().equals("1/x")) {
					button = "reciproc";
				}
				if(but.getText().equals("\u2190")) {
					button = "backspase";
				}
				//System.out.println(button);
				calc.calc(button);
				textfield.setText(calc.getResult());
				String res = calc.getLabel();
				if(res.length()>18) {
					StringBuffer sb = new StringBuffer(res);
					sb.delete(0, (sb.length()-1)-17);
					res = "..." + sb.toString();
				}
				label.setText(res);
			}
			
		};
		
		
		
		
		
		GridPane gp = new GridPane();
		
		gp.setHgap(5.0);
		gp.setVgap(5.0);
		GridPane gpleft = new GridPane();
		gpleft.setStyle("-fx-font:bold 12pt Arial;-fx-text-fill:#a0522d;");
		gpleft.setVgap(1.0);
		Button buttonCE = new Button("CE");
		buttonCE.setMinSize(50, 50);
		buttonCE.setOnAction(eventhandler);
		MyButton buttonC = new MyButton("C");
		buttonC.setMinSize(50, 50);
		buttonC.setOnAction(eventhandler);
		
		Button button1x = new Button("1/x");
		button1x.setMinSize(50, 50);
		button1x.setOnAction(eventhandler);
		MyButton buttonsqr = new MyButton("\u221A", "#5566ff");
	
		buttonsqr.setMinSize(50, 50);
		buttonsqr.setOnAction(eventhandler);
		gpleft.add(buttonCE, 0, 1, 1, 1);
		gpleft.add(buttonC, 0, 0, 1, 1);
		gpleft.add(button1x, 0, 2, 1, 1);
		gpleft.add(buttonsqr, 0, 3, 1, 1);
		
		GridPane gp19 = new GridPane();
		gp19.setStyle("-fx-font:bold 14pt Arial;-fx-text-fill:#a0522d;");
		gp19.setVgap(1.0);
		gp19.setHgap(1.0);
		Button button1 = new Button("1");
		button1.setMinSize(50, 50);
		button1.setOnAction(eventhandler);
		Button button2 = new Button("2");
		button2.setMinSize(50, 50);
		button2.setOnAction(eventhandler);
		Button button3 = new Button("3");
		button3.setOnAction(eventhandler);
		button3.setMinSize(50, 50);
		Button button4 = new Button("4");
		button4.setOnAction(eventhandler);
		button4.setMinSize(50, 50);
		MyButton button5 = new MyButton("5","#55ff55");
		button5.setOnAction(eventhandler);
		button5.setMinSize(50, 50);
		Button button6 = new Button("6");
		button6.setOnAction(eventhandler);
		button6.setMinSize(50, 50);
		Button button7 = new Button("7");
		button7.setOnAction(eventhandler);
		button7.setMinSize(50, 50);
		Button button8 = new Button("8");
		button8.setOnAction(eventhandler);
		button8.setMinSize(50, 50);
		Button button9 = new Button("9");
		button9.setOnAction(eventhandler);
		button9.setMinSize(50, 50);
		Button buttonpoin = new Button(",");
		buttonpoin.setOnAction(eventhandler);
		buttonpoin.setMinSize(50, 50);
		Button button0 = new Button("0");
		button0.setOnAction(eventhandler);
		button0.setMinSize(100, 50);
		
		gp19.add(button1, 0, 0, 1, 1);
		gp19.add(button2, 1, 0, 1, 1);
		gp19.add(button3, 2, 0, 1, 1);
		gp19.add(button4, 0, 1, 1, 1);
		gp19.add(button5, 1, 1, 1, 1);
		gp19.add(button6, 2, 1, 1, 1);
		gp19.add(button7, 0, 2, 1, 1);
		gp19.add(button8, 1, 2, 1, 1);
		gp19.add(button9, 2, 2, 1, 1);
		gp19.add(buttonpoin, 0, 3, 1, 1);
		
		gp19.add(button0, 1, 3, 2, 1);
		
		
		Button buttonplus = new Button("+");
		buttonplus.setMinSize(50, 50);
		buttonplus.setOnAction(eventhandler);
		Button buttonminus = new Button("-");
		buttonminus.setOnAction(eventhandler);
		buttonminus.setMinSize(50, 50);
		Button buttonunmn = new Button("*");
		buttonunmn.setOnAction(eventhandler);
		buttonunmn.setMinSize(50, 50);
		Button buttondel = new Button("/");
		buttondel.setOnAction(eventhandler);
		buttondel.setMinSize(50, 50);
		gp19.add(buttonplus, 3, 0, 1, 1);
		gp19.add(buttonminus, 3, 1, 1, 1);
		gp19.add(buttonunmn, 3, 2, 1, 1);
		gp19.add(buttondel, 3, 3, 1, 1);
		
		String plmin = String.valueOf((char) 177);//±
		Button buttonplmin = new Button(plmin);
		buttonplmin.setMinSize(50, 50);
		buttonplmin.setOnAction(eventhandler);
		gp19.add(buttonplmin, 4, 1, 1, 1);
		String backspacestr = "\u2190";
		Button backspace = new Button(backspacestr);
		backspace.setOnAction(eventhandler);
		backspace.setMinSize(50, 50);
		gp19.add(backspace, 4, 0, 1, 1);
		
		Button buttonravn = new Button("=");
		buttonravn.setMinSize(50, 100);
		buttonravn.setOnAction(eventhandler);
		gp19.add(buttonravn, 4, 2, 1, 2);
		
		GridPane gp_button_vverch = new GridPane();
		gp_button_vverch.setHgap(1.0);
		Button button_scobka_open = new Button("(");
		button_scobka_open.setMinSize(50, 50);
		button_scobka_open.setOnAction(eventhandler);
		Button button_scobka_exit = new Button(")");
		button_scobka_exit.setMinSize(50, 50);
		button_scobka_exit.setOnAction(eventhandler);
		Button button_scobka_th = new Button("th");
		button_scobka_th.setMinSize(50, 50);
		button_scobka_th.setOnAction(eventhandler);
		gp_button_vverch.addRow(0, button_scobka_open, button_scobka_exit);
		gp_button_vverch.setAlignment(Pos.CENTER_RIGHT);
		gp.add(gp_button_vverch, 1, 0);
		
		
		gp.addRow(1, gpleft, gp19);
		
		gp.setAlignment(Pos.CENTER);
		rootbp.setCenter(gp);
		
		Group grouptablo = new Group();
		textfield = new TextField();
		textfield.setMaxWidth(305);
		textfield.setMinHeight(85);
		textfield.setAlignment(Pos.BOTTOM_RIGHT);
		textfield.setStyle("-fx-font:bold 25pt Arial;-fx-text-fill:#552233;");
		textfield.setEditable(false);
		
		
		
		
		label = new Label();
		label.setMinWidth(280);
		label.setMaxWidth(280);
		
		label.setStyle("-fx-font:bold 18pt Arial;-fx-text-fill:#000033;");
		label.setAlignment(Pos.CENTER_RIGHT);
		
		rootbp.setMargin(grouptablo, new Insets(5,5,5,5));
		
		grouptablo.getChildren().addAll(textfield,label);
		rootbp.setTop(grouptablo);
		rootbp.setAlignment(grouptablo, Pos.CENTER);
		
		
		MenuBar menubar = new MenuBar();
		Menu menuVid = new Menu("Вид");
		Menu menuSpravka = new Menu("О программе");
		
		menubar.getMenus().addAll(menuSpravka);
		
		bp.setTop(menubar);
		bp.setCenter(rootbp);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println(arg0);
				switch(arg0.getText()) {
				case "0":
					if(arg0.isShiftDown()) {
						Event.fireEvent(button_scobka_exit, new ActionEvent());
					}else {
						Event.fireEvent(button0, new ActionEvent());
					}
				break;
				case "1":Event.fireEvent(button1, new ActionEvent());
				break;
				case "2":Event.fireEvent(button2, new ActionEvent());
				break;
				case "3":Event.fireEvent(button3, new ActionEvent());
				break;
				case "4":Event.fireEvent(button4, new ActionEvent());
				break;
				case "5":Event.fireEvent(button5, new ActionEvent());
				break;
				case "6":Event.fireEvent(button6, new ActionEvent());
				break;
				case "7":Event.fireEvent(button7, new ActionEvent());
				break;
				case "8":Event.fireEvent(button8, new ActionEvent());
				break;
				case "9":
					if(arg0.isShiftDown()) {
						Event.fireEvent(button_scobka_open, new ActionEvent());
					}else {
						Event.fireEvent(button9, new ActionEvent());
					}
					
				break;
				case "+":Event.fireEvent(buttonplus, new ActionEvent());
				break;
				case "-":Event.fireEvent(buttonminus, new ActionEvent());
				break;
				case "/":Event.fireEvent(buttondel, new ActionEvent());
				break;
				case "*":Event.fireEvent(buttonunmn, new ActionEvent());
				break;
				case "=":
					if(arg0.isShiftDown()) {
						Event.fireEvent(buttonplus, new ActionEvent());
					}else {
						Event.fireEvent(buttonravn, new ActionEvent());
					}
				break;
			
				}
				if(arg0.getCode()==KeyCode.ENTER) {
					Event.fireEvent(buttonravn, new ActionEvent());
				}
				if(arg0.getCode()==KeyCode.BACK_SPACE) {
					Event.fireEvent(backspace, new ActionEvent());
				}
				if(arg0.getCode()==KeyCode.ESCAPE) {
					Event.fireEvent(buttonCE, new ActionEvent());
				}
				if(arg0.getCode()==KeyCode.DECIMAL) {
					Event.fireEvent(buttonpoin, new ActionEvent());
				}
			}
			
		});
		
		
		textfield.setText(calc.getResult());
		label.setText(calc.getLabel());
		
		
		
		
		
		stage.setScene(scene);
		stage.show();
	}

}

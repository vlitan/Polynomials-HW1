package ui;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Polynome;

public class PolynomeGui {
	
	private JButton addButton;
	private JButton substractButton;
	private JButton multiplyButton;
	private JButton divideButton;
	private JButton integrateButton;
	private JButton differentiateButton;
	
	private JFrame window;
	
	private JTextField p1TextField;
	private JTextField p2TextField;
	private JLabel resultLabel;
	
	private ActionListener operationActionListener;
	
	public void setActionListener(ActionListener operationActionListener){
		this.operationActionListener = operationActionListener;
	}
	
	public void init(){
		window = new JFrame("Polynome calculator");
		
		window.setLayout(null);
		window.setBounds(0, 0, 500, 400);
		
		p1TextField = new JTextField("first polynome");
		p2TextField = new JTextField("second polynome");
		resultLabel = new JLabel("result polynome");
		
		addButton = new JButton("add");
		substractButton = new JButton("substract");
		multiplyButton = new JButton("multiply");
		divideButton = new JButton("divide");
		integrateButton = new JButton("integrate");
		differentiateButton = new JButton("differentiate");
		
		p1TextField.setBounds(10, 10, window.getWidth(), 50);
		p2TextField.setBounds(10, 70, window.getWidth(), 50);
		resultLabel.setBounds(10, 140, window.getWidth(), 50);
		addButton.setBounds(10, 200, 120, 30);
		substractButton.setBounds(10, 250, 120, 30);
		multiplyButton.setBounds(150, 200, 120, 30);
		divideButton.setBounds(150, 250, 120, 30);
		integrateButton.setBounds(300, 200, 120, 30);
		differentiateButton.setBounds(300, 250, 120, 30);
		
		p1TextField.setVisible(true);
		p2TextField.setVisible(true);
		resultLabel.setVisible(true);
		addButton.setVisible(true);
		substractButton.setVisible(true);
		multiplyButton.setVisible(true);
		divideButton.setVisible(true);
		integrateButton.setVisible(true);
		differentiateButton.setVisible(true);
		
		addButton.addActionListener(operationActionListener);
		substractButton.addActionListener(operationActionListener);
		multiplyButton.addActionListener(operationActionListener);
		divideButton.addActionListener(operationActionListener);
		integrateButton.addActionListener(operationActionListener);
		differentiateButton.addActionListener(operationActionListener);
		
		window.add(p1TextField);
		window.add(p2TextField);
		window.add(resultLabel);
		window.add(addButton);
		window.add(substractButton);
		window.add(multiplyButton);
		window.add(divideButton);
		window.add(integrateButton);
		window.add(differentiateButton);
		
		window.setVisible(true);
	}
	
	public String getPolynome1(){
		return (this.p1TextField.getText());
	}
	
	public String getPolynome2(){
		return (this.p2TextField.getText());
	}
	
	public void setResult(ArrayList<Polynome> results){
		String result = "";
		result = results.get(0).toString();
		for(int i = 1; i < results.size(); i++){
			result += " || " + results.get(i).toString();
		}
		setResultText(result);
	}
	
	private void setResultText(String result){
		resultLabel.setText(result);
	}
	
}

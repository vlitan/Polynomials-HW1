package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import logic.PolynomeCalculator;
import logic.PolynomeParser;
import model.Monome;
import model.Polynome;
import monomeOperations.AddMonome;
import polynomeOperations.AddPolynome;
import ui.PolynomeGui;

public class MainController {

	public static void main(String[] args) {
		PolynomeGui gui = new PolynomeGui();
		ActionListener operantionListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button = (JButton)e.getSource();
				boolean inputOk = false;
				Polynome p1 = new Polynome();
				Polynome p2 = new Polynome();
				//parse the inputs
				try {
					p1 = PolynomeParser.parse(gui.getPolynome1());
					inputOk = true;
				} catch (Exception e1) {
					System.out.println("error parsing polynome 1 " + e1.getMessage());
				}
				try {
					p2 = PolynomeParser.parse(gui.getPolynome2());
					inputOk &= true;
				} catch (Exception e1) {
					System.out.println("error parsing polynome 2 " + e1.getMessage());
				}
				// if the inputs did not generate any error, the result is computed and displayed
				if (inputOk){
					gui.setResult(PolynomeCalculator.instance().getOperation(button.getText()).execute(p1, p2));
				}
			}
		};
		gui.setActionListener(operantionListener);
		gui.init();
	}

}

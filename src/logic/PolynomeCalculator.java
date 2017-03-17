package logic;
import java.util.ArrayList;

import model.Polynome;
import polynomeOperations.*;

public class PolynomeCalculator {
	
	private static PolynomeCalculator instance;
	//returns the unique instance of the class
	public static PolynomeCalculator instance(){
		if (instance == null){
			instance = new PolynomeCalculator();
		}
		return (instance);
	}
	//returns the operation associated with the string
	public Operation<Polynome> getOperation(String operation){
		switch (operation){
			case "differentiate":
				return (DifferentiatePolynomial.instance());
			case "integrate":
				return (IntegratePolynomial.instance());
			case "add":
				return (AddPolynome.instance());
			case "substract":
				return (SubstractPolynome.instance());
			case "multiply":
				return (MultiplyPolinome.instance());
			case "divide":
				return (DividePolynome.instance());
		}
		return null;
	}
}

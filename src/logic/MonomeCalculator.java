package logic;

import model.Monome;
import monomeOperations.AddMonome;
import monomeOperations.DifferentiateMonome;
import monomeOperations.DivideMonome;
import monomeOperations.IntegrateMonome;
import monomeOperations.MultiplyMonome;
import monomeOperations.SubstractMonome;
import polynomeOperations.*;

public class MonomeCalculator {
	private static MonomeCalculator instance;
	//returns the unique instance of the class
	public static MonomeCalculator instance(){
		if (instance == null){
			instance = new MonomeCalculator();
		}
		return (instance);
	}
	//returns the operation associated with the string
	public Operation<Monome> getOperation(String operation){
		switch (operation){
			case "differentiate":
				return (DifferentiateMonome.instance());
			case "integrate":
				return (IntegrateMonome.instance());
			case "add":
				return (AddMonome.instance());
			case "substract":
				return (SubstractMonome.instance());
			case "multiply":
				return (MultiplyMonome.instance());
			case "divide":
				return (DivideMonome.instance());
		}
		return null;
	}
}

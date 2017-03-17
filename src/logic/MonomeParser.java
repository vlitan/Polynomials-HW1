package logic;

import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Monome;
import model.Polynome;

public class MonomeParser {
	/*
	 * converts a string into a Monome
	 * */
	public static Monome parse(String input) throws Exception{
		Monome monome = new Monome();
		boolean sign = true; //true means positive
		input = input.replaceAll("\\s+", ""); //remove all spaces
		//handle the first character
		if (input.startsWith("-") || input.startsWith("+")){
			if (input.startsWith("-")){
				sign = false;
			}
			input = input.substring(1);
		}
		int xInd = input.indexOf("x");
		if (xInd == -1){ // no x in the input
			monome.setExponent(0);
			monome.setCoefficinet(Double.parseDouble(input));
		}
		else {
			monome.setCoefficinet(Double.parseDouble(input.substring(0, xInd)));
			int pInd = input.indexOf("^");
			if (pInd == -1){
				throw new Exception(" ^ not found in monome");
			}
			else { // no ^ in the input
				monome.setExponent(Integer.parseInt(input.substring(pInd + 1)));
			}
		}
		if (!sign){// set sign 
			monome.setCoefficinet(-monome.getCoefficinet());
		}
		return (monome);
	}

}

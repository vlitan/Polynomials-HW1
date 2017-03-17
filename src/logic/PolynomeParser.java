package logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Polynome;

public class PolynomeParser {
	/*
	 * parses an input string and returns a polynomial or throws and error 
	 * */
	public static Polynome parse(String input) throws Exception{
		Polynome polynome = new Polynome();
		Pattern pattern = Pattern.compile("([+-]?[^-+]+)");//regex pattern
		Matcher matcher = pattern.matcher(input);

		while (matcher.find()) {
		    polynome.add(MonomeParser.parse(matcher.group(1)));
		}
		return (polynome);
	}

}

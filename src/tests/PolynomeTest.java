package tests;

import org.junit.*;

import static org.junit.Assert.*;

import logic.PolynomeCalculator;
import logic.PolynomeParser;
import model.Polynome;

public class PolynomeTest {
	
	Polynome poly1;
	Polynome poly2;
	
	@Before
	public void init(){
		try {
			poly1 = PolynomeParser.parse("4*x^1 + 3*x^2");
			poly2 = PolynomeParser.parse("-2*x^1 + 3*x^9");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void additionTest(){
		try {
			Polynome expected = PolynomeParser.parse("2*x^1 + 3*x^2 + 3*x^9");
			Polynome actual = PolynomeCalculator.instance().getOperation("add").execute(poly1, poly2).get(0);
			assertEquals(expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void substractionTest(){
		try {
			Polynome expected = PolynomeParser.parse("6*x^1 + 3*x^2 - 3*x^9");
			Polynome actual = PolynomeCalculator.instance().getOperation("substraction").execute(poly1, poly2).get(0);
			assertEquals(expected, actual);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void differentiationTest(){
		try {
			Polynome expected = PolynomeParser.parse("4*x^0 + 6*x^1");
			Polynome actual = PolynomeCalculator.instance().getOperation("differentiate").execute(poly1, poly2).get(0);
			assertEquals(expected, actual);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void integrationTest(){
		try {
			Polynome expected = PolynomeParser.parse("2*x^2 + 1*x^3");
			Polynome actual = PolynomeCalculator.instance().getOperation("integrate").execute(poly1, poly2).get(0);
			assertEquals(expected, actual);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void multiplicationTest(){
		try {
			Polynome expected = PolynomeParser.parse("-8*x^2 + 12*x^10 - 6*x^3 + 9*x^11");
			Polynome actual = PolynomeCalculator.instance().getOperation("multiply").execute(poly1, poly2).get(0);
			assertEquals(expected, actual);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

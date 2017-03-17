package polynomeOperations;

import java.util.ArrayList;

import logic.MonomeCalculator;
import logic.Operation;
import model.Monome;
import model.Polynome;

public class DifferentiatePolynomial implements Operation<Polynome> {

	private static DifferentiatePolynomial differentiatePolynomeInstance;
	
	public static DifferentiatePolynomial instance(){
		if (differentiatePolynomeInstance == null){
			differentiatePolynomeInstance = new DifferentiatePolynomial();
		}
		return (differentiatePolynomeInstance);
	}
	
	@Override
	public ArrayList<Polynome> execute(Polynome... m) {
		ArrayList<Polynome> rez = new ArrayList<Polynome>();
		Polynome pRez = new Polynome();
		for (Monome monome : m[0].getMonomes()) {
				pRez.getMonomes().add(MonomeCalculator.instance().getOperation("differentiate").execute(monome).get(0));
		}
		rez.add(pRez);
		return rez;
	}


}

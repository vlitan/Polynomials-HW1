package polynomeOperations;

import java.util.ArrayList;

import logic.MonomeCalculator;
import logic.Operation;
import model.Monome;
import model.Polynome;

public class IntegratePolynomial implements Operation<Polynome> {

	private static IntegratePolynomial integratePolynomeInstance;
	
	public static IntegratePolynomial instance(){
		if (integratePolynomeInstance == null){
			integratePolynomeInstance = new IntegratePolynomial();
		}
		return (integratePolynomeInstance);
	}
	
	@Override
	public ArrayList<Polynome> execute(Polynome... m) {
		ArrayList<Polynome> rez = new ArrayList<Polynome>();
		Polynome pRez = new Polynome();
		for (Monome monome : m[0].getMonomes()) {
				pRez.getMonomes().add(MonomeCalculator.instance().getOperation("integrate").execute(monome).get(0));
		}
		rez.add(pRez);
		return rez;
	}
}



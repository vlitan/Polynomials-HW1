package polynomeOperations;

import java.util.ArrayList;

import logic.MonomeCalculator;
import logic.Operation;
import model.Monome;
import model.Polynome;

public class SubstractPolynome implements Operation<Polynome> {

	private static SubstractPolynome substractPolynomeInstance;
	
	public static SubstractPolynome instance(){
		if (substractPolynomeInstance == null){
			substractPolynomeInstance = new SubstractPolynome();
		}
		return (substractPolynomeInstance);
	}
	
	@Override
	public ArrayList<Polynome> execute(Polynome... m) {
		ArrayList<Polynome> rez = new ArrayList<Polynome>();
		Polynome pRez = new Polynome(m[0]);
		for (Monome monome : m[1].getMonomes()) {
			pRez.getMonomes().add(new Monome(monome.getExponent(), -monome.getCoefficinet()));
		}
		pRez.normalise();
		rez.add(pRez);
		return rez;
	}


}

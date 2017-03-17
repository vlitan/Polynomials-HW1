package polynomeOperations;

import java.util.ArrayList;

import logic.MonomeCalculator;
import logic.Operation;
import model.Monome;
import model.Polynome;
import monomeOperations.MultiplyMonome;

public class MultiplyPolinome implements Operation<Polynome>{
	
	private static MultiplyPolinome multiplyPolynomeInstance;
	
	public static MultiplyPolinome instance(){
		if (multiplyPolynomeInstance == null){
			multiplyPolynomeInstance = new MultiplyPolinome();
		}
		return (multiplyPolynomeInstance);
	}
	
	public ArrayList<Polynome> execute(Polynome... m) {
		ArrayList<Polynome> rez = new ArrayList<Polynome>();
		Polynome pRez = new Polynome();
		if ((m[0].getMonomes().size() != 0) && (m[1].getMonomes().size() == 0)){
			pRez = new Polynome(m[1]);
		} else {
			for (Monome monome : m[1].getMonomes()) {
				for (Monome monome2 : m[0].getMonomes()) {
					pRez.getMonomes().add(MultiplyMonome.instance().execute(monome, monome2).get(0));
				}
			}
		}
		pRez.normalise();
		rez.add(pRez);
		return rez;
	}
}

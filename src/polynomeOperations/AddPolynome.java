package polynomeOperations;

import java.util.ArrayList;

import logic.MonomeCalculator;
import logic.Operation;
import model.Monome;
import model.Polynome;

public class AddPolynome implements Operation<Polynome> {

	private static AddPolynome addPolynomeInstance;
	
	public static AddPolynome instance(){
		if (addPolynomeInstance == null){
			addPolynomeInstance = new AddPolynome();
		}
		return (addPolynomeInstance);
	}
	
	@Override
	public ArrayList<Polynome> execute(Polynome... m) {
		ArrayList<Polynome> rez = new ArrayList<Polynome>();
		Polynome pRez = new Polynome(m[0]);
		if (m[0].getMonomes().size() == 0){
			pRez = new Polynome(m[1]);
		}
		else if (m[1].getMonomes().size() == 0){
			pRez = new Polynome(m[1]);
		} else {
			for (Monome monome : m[1].getMonomes()) {
					pRez.getMonomes().add(monome);
			}
			pRez.normalise();
		}
		rez.add(pRez);
		return rez;
	}


}

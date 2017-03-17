package polynomeOperations;

import java.util.ArrayList;

import logic.MonomeCalculator;
import logic.Operation;
import logic.PolynomeCalculator;
import model.Monome;
import model.Polynome;

public class DividePolynome implements Operation<Polynome> {

	private static DividePolynome dividePolynomeInstance;
	
	public static DividePolynome instance(){
		if (dividePolynomeInstance == null){
			dividePolynomeInstance = new DividePolynome();
		}
		return (dividePolynomeInstance);
	}
	
	@Override
	public ArrayList<Polynome> execute(Polynome... m) {/*
		ArrayList<Polynome> rez = new ArrayList<Polynome>();
		Polynome pRez = new Polynome();
		Polynome rem = new Polynome(m[0]);
		Monome auxM = new Monome();
		Polynome auxP = new Polynome();
		while (pRez.getDegree() < rem.getDegree()){

			auxM = MonomeCalculator.instance().getOperation("division").execute(rem.getMonomes().get(rem.getExponentIndex(rem.getDegree())), m[1].getMonomes().get(m[1].getExponentIndex(m[1].getDegree()))).get(0);
			pRez.add(auxM);
			auxP = PolynomeCalculator.execute("multiply", new Polynome(auxM), m[1]).get(0);
			rem = PolynomeCalculator.execute("substract", rem, auxP).get(0);
		}
		rez.add(pRez);
		rez.add(rem);*/
		return null;
	}

}
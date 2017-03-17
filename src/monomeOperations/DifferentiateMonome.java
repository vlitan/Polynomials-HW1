package monomeOperations;

import java.util.ArrayList;

import logic.Operation;
import model.Monome;

public class DifferentiateMonome implements Operation<Monome> {
	
	private static DifferentiateMonome differentiateMonomeInstance;
	
	public static DifferentiateMonome instance(){
		if (differentiateMonomeInstance == null){
			differentiateMonomeInstance = new DifferentiateMonome();
		}
		return (differentiateMonomeInstance);
	}
	
	public ArrayList<Monome> execute(Monome...m) {
		ArrayList<Monome> rez = new ArrayList<Monome>();
		Monome mRez = new Monome(m[0]);
		mRez.setCoefficinet(mRez.getCoefficinet() * mRez.getExponent());
		mRez.setExponent(mRez.getExponent() - 1);
		rez.add(mRez);
		return (rez);
	}

}

package monomeOperations;

import java.util.ArrayList;

import logic.Operation;
import model.Monome;

public class IntegrateMonome implements Operation<Monome> {
	
	private static IntegrateMonome integrateMonomeInstance;
	
	public static IntegrateMonome instance(){
		if (integrateMonomeInstance == null){
			integrateMonomeInstance = new IntegrateMonome();
		}
		return (integrateMonomeInstance);
	}
	
	public ArrayList<Monome> execute(Monome...m) {
		ArrayList<Monome> rez = new ArrayList<Monome>();
		Monome mRez = new Monome(m[0]);
		if (mRez.getCoefficinet() != 0){
			mRez.setExponent(mRez.getExponent() + 1);
			mRez.setCoefficinet(mRez.getCoefficinet() / mRez.getExponent());
		}
		rez.add(mRez);
		return (rez);
	}
}

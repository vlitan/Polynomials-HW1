package monomeOperations;

import java.util.ArrayList;

import logic.Operation;
import model.Monome;

public class MultiplyMonome implements Operation<Monome> {
	
	private static MultiplyMonome multiplyMonomeInstance;
	
	public static MultiplyMonome instance(){
		if (multiplyMonomeInstance == null){
			multiplyMonomeInstance = new MultiplyMonome();
		}
		return (multiplyMonomeInstance);
	}

	 public ArrayList<Monome> execute(Monome...m) {
		ArrayList<Monome> rez = new ArrayList<Monome>();
		Monome mRez = new Monome(m[0]);
		mRez.setCoefficinet(mRez.getCoefficinet() * m[1].getCoefficinet());
		mRez.setExponent(mRez.getExponent() + m[1].getExponent());
		rez.add(mRez);
		return (rez);
	}
}
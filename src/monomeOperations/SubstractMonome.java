package monomeOperations;

import java.util.ArrayList;

import logic.Operation;
import model.Monome;

public class SubstractMonome implements Operation<Monome> {

	private static SubstractMonome substractMonomeInstance;
	
	public static SubstractMonome instance(){
		if (substractMonomeInstance == null){
			substractMonomeInstance = new SubstractMonome();
		}
		return (substractMonomeInstance);
	}
	
	 public ArrayList<Monome> execute(Monome...m) {
		ArrayList<Monome> rez = new ArrayList<Monome>();
		Monome mRez = new Monome(m[0]);
		if (mRez.getExponent() == m[1].getExponent()){
			mRez.setCoefficinet(mRez.getCoefficinet() - m[1].getCoefficinet());
		}
		rez.add(mRez);
		return (rez);
	}
}

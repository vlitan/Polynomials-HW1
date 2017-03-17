package monomeOperations;

import java.util.ArrayList;

import logic.Operation;
import model.Monome;

public class AddMonome implements Operation<Monome> {

	private static AddMonome addMonomeInstance; //singleto instance
	
	public static AddMonome instance(){
		if (addMonomeInstance == null){
			addMonomeInstance = new AddMonome();
		}
		return (addMonomeInstance);
	}
	
	 public ArrayList<Monome> execute(Monome...m) {
		ArrayList<Monome> rez = new ArrayList<Monome>(); ///create a new list of monomes
		Monome mRez = new Monome(m[0]);//instanciate the monome result with the values of the first argument
		if (mRez.getExponent() == m[1].getExponent()){	//if the exponets match
			mRez.setCoefficinet(mRez.getCoefficinet() + m[1].getCoefficinet()); //the coefficints add
		}
		rez.add(mRez); //result is added to the result array
		return (rez);
	}

}

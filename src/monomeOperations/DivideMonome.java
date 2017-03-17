package monomeOperations;

import java.util.ArrayList;

import logic.Operation;
import model.Monome;

public class DivideMonome implements Operation<Monome> {
	
	private static DivideMonome divideMonomeInstance;
	
	public static DivideMonome instance(){
		if (divideMonomeInstance == null){
			divideMonomeInstance = new DivideMonome();
		}
		return (divideMonomeInstance);
	}
	
	public ArrayList<Monome> execute(Monome...m) {
			ArrayList<Monome> rez = new ArrayList<Monome>();
			Monome mRez = new Monome(m[0]);
			mRez.setCoefficinet(mRez.getCoefficinet() / m[1].getCoefficinet());
			mRez.setExponent(mRez.getExponent() - m[1].getExponent());
			rez.add(mRez);
			return (rez);
		}
}

package model;

public class Monome {
	private double coefficinet;
	private int exponent;
	
	public Monome(int exponent, double coefficient){
		setCoefficinet(coefficient);
		setExponent(exponent);
	}
	
	public Monome(){ // default contructor
		this(0,0);	//defaults to 0 0 
	}
	
	//copy constructor
	public Monome(Monome m){ 
		this.copy(m);
	}
	
	public void copy(Monome a){ //copy the contents of the argument into this
		this.setCoefficinet(a.getCoefficinet());
		this.setExponent(a.getExponent());
	}
	
	public double getCoefficinet() { // returns the coefficiet
		return coefficinet;
	}

	public void setCoefficinet(double coefficinet) { //sets the coefficient
		this.coefficinet = coefficinet;
	}

	public int getExponent() { // returns the exponent
		return exponent;
	}

	public void setExponent(int exponent) { // sets the exponent
		if (exponent < 0) return; // ensures that the exponent is always non-negative
		this.exponent = exponent;
	}
	
	public String toString(){ // converts a monome to string
		return (this.getCoefficinet() + "x^" + this.getExponent());
	}
	
	@Override
	public boolean equals(Object o){ //checks if equal
		if (o == this) return (true); // if it is the same
		if (o == null) return (false);// if it is null
		if (!(o instanceof Monome)) return (false); // if not a monome
		Monome m = (Monome)o; 
		return ((this.coefficinet == m.getCoefficinet()) && (this.exponent == m.getExponent()));
	}
	
}

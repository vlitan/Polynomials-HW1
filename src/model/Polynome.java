package model;

import java.util.ArrayList;

import logic.MonomeCalculator;

public class Polynome {
	private ArrayList<Monome> monomes; // the list holding the monomes
	
	//default constructor
	public Polynome(){
		monomes = new ArrayList<Monome>();
	}
	
	//create a polynome with a single monome
	public Polynome(Monome a){
		this();
		monomes.add(a);
	}
	
	//copy constructor
	public Polynome(Polynome polynome){
		monomes = new ArrayList<Monome>(polynome.cloneMonomes());
	}
	
	//retuns a clone of the monome list
	@SuppressWarnings("unchecked")
	public ArrayList<Monome> cloneMonomes(){
		return (ArrayList<Monome>) (monomes.clone());
	}
	
	//returns the actual list of monomes
	public ArrayList<Monome> getMonomes(){
		return (ArrayList<Monome>) (monomes);
	}
	
	//adds a monome in the list and then normalises the list
	public void add(Monome monome){
		monomes.add(monome);
		normalise();
	}
	
	// converts to string
	public String toString(){
		String result = "";
		if (monomes.size() == 0){
			return ("0");
		}
		if(monomes.get(0).getCoefficinet() != 0){
			result += monomes.get(0).toString();
		}
		for (int i = 1; i < monomes.size(); i++){
			if(monomes.get(i).getCoefficinet() != 0){
				if (monomes.get(i - 1).getCoefficinet() != 0){
					result += " + ";
				}
				result += monomes.get(i).toString();
			}
		}
		if (result == "") {
			result = "0";
		}
		return (result);
	}
	
	//retuns the index in the array of a given index
	public int getExponentIndex(int exponent){
		for (int i = 0; i < monomes.size(); i++){
			if (exponent == monomes.get(i).getExponent()){
				return (i);
			}
		}
		return (-1);
	}
	
	//removes 0s, merges duplicates
	public void normalise(){
		if (monomes.size() == 0) {
			return;
		}
		for (int i = 0; i < monomes.size(); i++){
			for (int j = i + 1; j < monomes.size(); j++){
				if (monomes.get(i).getExponent() == monomes.get(j).getExponent()){
					monomes.set(i, MonomeCalculator.instance().getOperation("add").execute(monomes.get(i), monomes.get(j)).get(0));
					monomes.remove(j);
				}
			}
			removeIfZero(i);
		}
	}
	
	//remove an elemente if it`s index is 0
	private void removeIfZero(int index){
		if (monomes.get(index).getCoefficinet() == 0){
			monomes.remove(index);
		}
	}
	
	//returns the degree of the polynome, the maximum exponent
	public int getDegree(){
		int max = 0;
		for (Monome monome : monomes){
			if (max < monome.getExponent()){
				max = monome.getExponent();
			}
		}
		return (max);
	}
	
	@Override
	public boolean equals(Object m){
		if (m == this) return (true);
		if (m == null) return (false);
		if (!(m instanceof Polynome)) return (false);
		
		Polynome aux = (Polynome)m;
		if (aux.getMonomes().size() != monomes.size()) return (false);
		
		for (Monome m1 : monomes){
			if (aux.getExponentIndex(m1.getExponent()) != -1){
				if (aux.getMonomes().get(aux.getExponentIndex(m1.getExponent())).equals(m1) == false){
					return (false);
				}
			}
			else{
				return (false);
			}
		}
		return (true);
	}
}

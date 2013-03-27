package es.weso.wirouter;

import java.util.List;

public class Grouping extends ComparableItem {
	private final List<CountryCode> countries;
	
	public Grouping(List<CountryCode> countries) {
		this.countries = countries; 
	}
	
	public String toString(){
		return "group(" + countries.toString() + ")";
	}
}

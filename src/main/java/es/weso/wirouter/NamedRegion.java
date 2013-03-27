package es.weso.wirouter;

public class NamedRegion extends ComparableItem {
	private final String name;
	
	public NamedRegion(String name) {
		this.name = name ;
	}
	
	public String toString() {
		return "region(" + name + ")";
	}
}

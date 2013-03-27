package es.weso.wirouter;

public class CountryCode extends ComparableItem {
	private final String code;
	public CountryCode(String code) {
		this.code = code;
	}
	
	public String toString() {
		return code;
	}
	
}

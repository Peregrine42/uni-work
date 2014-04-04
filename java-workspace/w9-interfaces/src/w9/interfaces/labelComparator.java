package w9.interfaces;

import java.util.Comparator;

class labelComparator implements Comparator<Object> {
	
	String label;
	
	labelComparator(String label) {
		this.label = label;
	}
	
	public int compare(Object o1, Object o2) {
		String title1 = ((Media) o1).getSearchableField(label);
		String title2 = ((Media) o2).getSearchableField(label);
		int comp = title1.compareTo(title2);
		return comp;
	}
}
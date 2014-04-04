package w9.interfaces;

public class Film implements Media {

	public String director;
	public String title;
	public double price;
	public String format;
	
	Film(String author,
		 String title,
		 double price,
		 String format) {
		
		this.director = author;
		this.title = title;
		this.price = price;
		this.format = format;
		
	}
	
	public String toString() {
		return title + " by " + director + " (" + format + ", priced: " + price + ")";
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getSearchableField(String label) {
		if (label.equals("director")) {
			return this.director;
		} else {
			if (label.equals("format")) {
				return this.format;
			}
		};
		return this.title;
	}
	
}

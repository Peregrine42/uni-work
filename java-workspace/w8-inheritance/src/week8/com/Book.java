package week8.com;

class Book {
	
	public String author;
	public String title;
	public double price;
	public String format;
	
	Book(String author,
		 String title,
		 double price,
		 String format) {
		
		this.author = author;
		this.title = title;
		this.price = price;
		this.format = format;
		
	}
	
	public String toString() {
		return title + " by " + author + " (" + format + ", priced: " + price + ")";
	}
	
	public String getSearchableField(String label) {
		if (label.equals("author")) {
			return this.author;
		} else {
			if (label.equals("format")) {
				return this.format;
			}
		};
		return this.title;
	}
	
}
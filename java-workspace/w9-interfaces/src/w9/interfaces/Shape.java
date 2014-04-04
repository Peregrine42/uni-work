package w9.interfaces;

interface hasArea {
	public double area();
	public double perimeter();
}

class Shape implements hasArea {
	
	public double area() {
		return 0.0;
	}
	
	public double perimeter() {
		return 0.0;
	}
	
}
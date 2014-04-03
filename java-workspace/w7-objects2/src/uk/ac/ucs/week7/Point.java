package uk.ac.ucs.week7;

class Point {
	
	private double x;
	private double y;
	
	Point(double x, double y) {
		setX(x);
		setY(y);
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}	
	
	public double distance(Point p) {
		double squared =  Math.pow(p.getX()-getX(), 2) +
						  Math.pow(p.getY()-getY(), 2);
		return Math.sqrt(squared);
	}
	
	public String toString() {
		String stringX = String.format("%.1f", getX());
		String stringY = String.format("%.1f", getY());
		return "point(" + stringX + ", " + stringY + ")";
	}
	
}
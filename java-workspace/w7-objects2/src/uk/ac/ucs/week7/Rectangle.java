package uk.ac.ucs.week7;

class Rectangle {
	
	Point[] p;
	
	Rectangle(Point p1, Point p2, Point p3, Point p4) {
		p = new Point[4];
		p[0] = p1;
		p[1] = p2;
		p[2] = p3;
		p[3] = p4;
	}
	
	public double perimeter() {
		return p[0].distance(p[1]) + 
			   p[1].distance(p[3]) + 
			   p[2].distance(p[3]) + 
			   p[0].distance(p[2]);
	}
	
	public double area() {
		return p[0].distance(p[1]) *
			   p[0].distance(p[2]);
	}
	
}
package uk.ac.ucs.week7;

class Circle {
	Point center;
	double radius;
	
	Circle(Point c, double r) {
		center = c;
		radius = r;
	}
	
	public boolean contains(Point p) {
		if (center.distance(p) < radius) {
			return true;
		}
		return false;
	}
}
package week6.com;

class Sphere {
	
	double radius;
	
	Sphere(double r) {
		radius = r;
	}
	
	public double surfaceArea() {
		return 4 * Math.PI * Math.pow(radius, 2);
	}
	
	public double volume() {
		return (4 * Math.PI * Math.pow(radius, 3)) / 3;
	}
}
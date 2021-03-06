
public class Circle implements Shape{

	double radius;
	String color;
	public Circle(double radius){
		this.radius = radius;
		color = null;
	}
	
	public Circle(double radius,String color){
		this.radius = radius;
		this.color = color;
	}
	
	@Override
	public void fillColor(String color) {
		// fill the method
		this.color = color;
	}

	@Override
	public String getColor() {
		//fill the method
		return color;
	}
	@Override
	public double getarea() {
		double area = Math.PI * radius * radius;
		return area;
	}
	
	public String toString(){
		return "Circle with radius:"+radius+" and color:"+color;
	}

}

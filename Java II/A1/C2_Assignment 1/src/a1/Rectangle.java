package a1;

public class Rectangle extends GeometricObject {
	
	protected double width;    //width of rectangle
	protected double height;   //height of rectangle 
	
	protected Rectangle() {     //POST: default rectangle: blue unfilled width and height 1.0
		super();
		width = 1.0;
		height = 1.0;
	}
	
	protected Rectangle(double width, double height) {      //PRE: width > 0.0 && height > 0.0
		super();                                         //POST: rectangle is blue unfilled with set width and height
		this.width = width;
		this.height = height;
	}
	
	protected Rectangle(double width, double height, String color, Boolean filled) {
		super (color,filled);               //PRE: width > 0.0 && height > 0.0
		this.width = width;                 //POST: rectangle is set by user
		this.height = height;
	}
	
	//accessors and modifiers
	
	public double getWidth() { return width; }
	
	public double getHeight() { return height; }
	
	public void setWidth(double width) { this.width = width; }   //PRE: width > 0.0
	
	public void setHeight(double height) { this.height = height; }   //PRE: height > 0.0
	
	@Override public double getArea() { return width*height; }     //POST: return area of rectangle
	
	@Override public double getPerimeter() { return 2*(width + height); }  //POST: return perimeter of rectangle
	
	@Override public String toString() {    //POST: return string representation of rectangle
		return super.toString() +" width:"+width+" height"+height+" area:"+String.format("%-6.2f",getArea())+
				" perimeter: "+String.format("%-10.2f",getPerimeter());
	}
}
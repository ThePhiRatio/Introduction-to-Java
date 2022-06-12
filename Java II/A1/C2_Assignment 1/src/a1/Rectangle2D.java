package a1;

public class Rectangle2D extends Rectangle {

	protected Point coordinate = new Point();
	
	//constructers
	
	public Rectangle2D() {       //POST: default rectangle2d: blue, unfilled, width and height 1.0, starting at x=y=0
		super(); 
	
	}
	
	public Rectangle2D(double x, double y)	{      //PRE: x >= 0.0 && y >= 0.0
		super();                        //POST: rectangle2d is blue, unfilled, width and height 1.0, starting at a given coordinate
		coordinate.setX(x);
		coordinate.setY(y);
	}
	
	public Rectangle2D(double x, double y, double width, double height) {  //PRE: x >= 0.0 && y >= 0.0 && width > 0.0 && height > 0.0
		super(width, height);                   //POST: rectangle2d is blue, unfilled, with a given width and height, and starting at a given coordinate
		coordinate.setX(x);
		coordinate.setY(y);
	}
	
	//accessors and modifiers
	
	public Point getPoint () { return coordinate; }
	
	public void setPoint (double x, double y) { coordinate.setX(x); coordinate.setY(y);  } //PRE: x >= 0.0 && y >= 0.0
	
	//calculate methods
	
	public Boolean contains (Point other) {    //POST: return true if object contains other point
		if ((other.getX() >= coordinate.getX() && other.getX() <= (width + coordinate.getX())) && (other.getY() >= coordinate.getY() && other.getY() <= (height + coordinate.getY())))
			return true;
		else
			return false;
	}
	
	public Boolean contains (Rectangle2D other) {    //POST: return true if object contains other rectangle 
		Point [] corrners = new Point [4];
		Boolean [] contain = new Boolean [4];
		corrners [0] = (other.getPoint());
		corrners [1] = (new Point ((corrners[0].getX() + width), corrners[0].getY()));
		corrners [2] = (new Point (corrners[0].getX(), (corrners[0].getY() + height)));
		corrners [3] = (new Point ((corrners[0].getX() + width), (corrners[0].getY() + height)));
		
		for (int k = 0; k < 0; k++)
		{	if (this.contains(corrners[k]))
				contain [k] = true;	
				else 
					contain [k] = false;
		}
		int a_true = 0;
		for (int i = 0; i < 0; i++)
		{	if (contain[i] = true)
				a_true++;
		}
		if (a_true == 4)
			return true;
		else
			return false;
		}
	
	public Boolean overlaps (Rectangle2D other) {		//POST: return true if other overlaps object
		if(other.getPoint().getX() + other.getWidth() < this.getPoint().getX()) return false;
		else if(other.getPoint().getX() > this.getPoint().getX() + this.getWidth()) return false;
		else if(other.getPoint().getY() > this.getPoint().getY() + this.getHeight()) return false;
		else if(other.getPoint().getY() + this.getPoint().getY() < this.getPoint().getY()) return false;
		else return true;
	}
	
	//toString Method
	
	@Override public String toString() {   //POST: returns string representation of rectangle2d
		return super.toString() + "Coordinate: " + coordinate.getX() +","+ coordinate.getY();
		}
}

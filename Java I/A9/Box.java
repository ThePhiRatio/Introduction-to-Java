package assignment9;

public class Box {
	int length;
	int width;
	int height;
	
	public Box()                                        //POST: returns length, width and height as 0
	{ length = 0; width = 0; height = 0;	}
	
	
	public Box(int l, int w, int h)                     //PRE: l > 0 && w > 0 && h > 0
	{	length = l; width = w; height = h;	}           //POST: length = l, width = w and height = h
	
	
	public double getArea()                             //POST: returns area of box
	{	double area = (2*(height*width))+(2*(height*length))+(2*(width*length));
		return area;
	}
	
	public double getVolume()                           //POST: returns volume of box
	{	double volume = length*width*height;
		return volume;
	}
	
}

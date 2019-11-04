package lecture03.fractals;

import processing.core.PApplet;

public class SierpinskiTriangleAnimated_GUI extends PApplet {
	
	// min size for all triangles
	public int minSize = 600;
	public int size = 600;
	public void setup()
	{
		//smooth();		
		size(size,size+1);
		//drawTriangle( 0,600,300,0,600,600 );
		// tell PApplet that we don't need a draw loop - we aren't animating anything
		//noLoop();
		frameRate(1);
	}
	
	public void draw( ){
		// erase the background
		background(255, 0, 0);
				
		drawTriangle( 0,600,300,0,600,600 );
		if (minSize >= 5)
			minSize = minSize/2;
		else
			minSize = size;
	}

	public void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3)
	{
		line(x1,y1, x2,y2);
		line(x2,y2, x3,y3);
		line(x3,y3, x1,y1);
		
		// if the distance between any two points in this triangle is 
		// sufficiently large then we should draw 3 inscribed
		// triangles inside this one
		if ( dist(x1,y1,x2,y2) > this.minSize )
		{
			// calculate midpoints
			int x1mid = (x1+x2)/2;
			int y1mid = (y1+y2)/2;
			
			int x2mid = (x2+x3)/2;
			int y2mid = (y2+y3)/2;
			
			int x3mid = (x3+x1)/2;
			int y3mid = (y3+y1)/2;
			
			// draw our 3 inscribed triangles
			
			// bottom left
			drawTriangle(x1,y1,x1mid,y1mid,x3mid,y3mid);
			
			// top
			drawTriangle(x1mid,y1mid,x2,y2,x2mid,y2mid);
			
			// bottom right
			drawTriangle(x3mid,y3mid,x2mid,y2mid,x3,y3);
		}
	}

}

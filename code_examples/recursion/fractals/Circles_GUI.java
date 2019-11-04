
package lecture03.fractals;
//code courtesy of Craig Kapp

import processing.core.PApplet;

public class Circles_GUI extends PApplet
{
	public void setup()
	{
		// make sure all graphics are smoothed out
		smooth();
		
		// draw a white background
		background(255);
		
		// fill using a semi-transparent black color
		fill(0, 25);
		
		// size our canvas
		size(600, 600);
		
		// draw a recursive circle in the center!
		drawCircle(300, 300, 300);
		
		// tell PApplet that we don't need a draw loop - we aren't animating anything
		noLoop();
	}
	
	// draw a circle
	public void drawCircle(int x, int y, int radius)
	{
		// draw a circle of the desired size
		ellipse(x,y,2*radius,2*radius);
		
		// if we are sufficiently large then we should also draw 
		// circles on the left and right.  these circles should be
		// smaller that our original size.  this is our recursive
		// case - if the boolean expression evals to false, it serves
		// as our base case
		if (radius > 1)
		{
			// size for the new ellipses
			int newRadius = radius/2;
			
			// offset for the new ellipses
			int offset = radius/2;
			
			// draw the left ellipse
			drawCircle(x - offset, y, newRadius);
			
			// draw the right ellipse
			drawCircle(x + offset, y, newRadius);
		}
	}

}

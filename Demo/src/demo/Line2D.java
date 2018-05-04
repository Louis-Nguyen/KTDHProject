/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author HoangThang
 */
public class Line2D extends MyShape{
    	
	public Line2D() {
		super();
	}

	/**
	 * Overloaded constructor that takes coordinates and color. It passes them
	 * to the constructor in MyShape
	 */
	public Line2D(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y1, x2, y2, color);
	}

	/**
	 * Overrides the draw method in Myshape. It sets the gets the color from
	 * Myshape and the coordinates it needs to draw from MyShape as well.
	 */
	@Override
	public void draw(Graphics g) {

		g.setColor(getColor()); // sets the color
		// g.drawLine(getX1(), getY1(), getX2(), getY2()); // draws the line
		Midpoint(g, getX1(), getY1(), getX2(), getY2());
		// putPixel(getX1()+10, getY1()+10, g);
	}

	private void DDA(Graphics g, int x1, int y1, int x2, int y2) {
		double Dx = x2 - x1;
		double Dy = y2 - y1;
		double step;
		if (Math.abs(Dx) > Math.abs(Dy)) {
			step = Math.abs(Dx);
		} else {
			step = Math.abs(Dy);
		}
		double xInc = Dx / step;
		double yInc = Dy / step;

		double x = x1;
		double y = y1;
		putPixel((int) x, (int) y, g);
		for (int i = 0; i < step; i++) {
			x += xInc;
			y += yInc;
			putPixel((int) Math.round(x), (int) Math.round(y), g);
		}
	}

	// Bresenham
	private void Bresenham(Graphics g, int x1, int y1, int x2, int y2) {
		int x, y, Dx, Dy;
		Dx = Math.abs(x2 - x1);
		Dy = Math.abs(y2 - y1);

		x = x1;
		y = y1;
		//if (Dx > Dy) {
			
			
		//}else {
	//		
	//	}
		int x_unit = 1, y_unit = 1;

		if (x2 - x1 < 0)
			x_unit = -x_unit;
		if (y2 - y1 < 0)
			y_unit = -y_unit;

		if (x1 == x2) // duong thang dung
		{
			while (y != y2 + 1) {
				// delay(DELAY);
				y += y_unit;
				putPixel(x, y, g);
			}
		}

		else if (y1 == y2) // duong ngang
		{
			while (x != x2 + 1) {
				// delay(DELAY);
				x += x_unit;
				putPixel(x, y, g);
			}
		} else {
			putPixel(x, y, g);
			if (Dx>Dy) {
				int p = 2 * Dy - Dx;
				int c1 = 2 * Dy;
				int c2 = 2 * (Dy - Dx);
				while (x != x2) {
					// delay(DELAY);
					if (p < 0)
						p += c1;
					else {
						p += c2;
						y += y_unit;
					}
					x += x_unit;
					putPixel(x, y, g);

				}
			}else {
				int p = 2 * Dx - Dy;
				int c1 = 2 * Dx;
				int c2 = 2 * (Dx - Dy);
				while (y != y2) {
					// delay(DELAY);
					if (p < 0)
						p += c1;
					else {
						p += c2;
						x += x_unit;
					}
					y += y_unit;
					putPixel(x, y, g);

				}
				
			}
			
		}
	}
	private void Midpoint(Graphics g, int x1, int y1, int x2, int y2) {
		int x, y, Dx, Dy;
		Dx = Math.abs(x2 - x1);
		Dy = Math.abs(y2 - y1);

		x = x1;
		y = y1;
	
		int x_unit = 1, y_unit = 1;

		if (x2 - x1 < 0)
			x_unit = -x_unit;
		if (y2 - y1 < 0)
			y_unit = -y_unit;

		if (x1 == x2) // duong thang dung
		{
			while (y != y2 + 1) {
				
				y += y_unit;
				putPixel(x, y, g);
			}
		}

		else if (y1 == y2) // duong ngang
		{
			while (x != x2 + 1) {
			
				x += x_unit;
				putPixel(x, y, g);
			}
		} else {
			putPixel(x, y, g);
			if (Math.abs(Dx)>Math.abs(Dy)) {
				int p=Dy-Dx/2;
			
				while (x != x2) {
				
					if (p < 0)
						p += Dy;
					else {
						p += Dy - Dx;
						y += y_unit;
					}
					x += x_unit;
					putPixel(x, y, g);

				}
			}else {
				int p=Dx-Dy/2;
				
				while (y != y2) {
				
					if (p < 0)
						p += Dx;
					else {
						p += Dx - Dy;
						x += x_unit;
					}
					y += y_unit;
					putPixel(x, y, g);

				}
				
			}
			
		}
	}
	
}

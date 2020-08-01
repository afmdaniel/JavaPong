package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
	
	public double x, y;
	public int width, height;
	
	public double dx, dy;
	public double speed = 2;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 5;
		this.height = 5;
		
		this.dx = new Random().nextGaussian();
		this.dy = new Random().nextGaussian();
	}
	
	public void tick() {
		x += dx*speed;
		y += dy*speed;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x,(int) y, width, height);
	}
}

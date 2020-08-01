package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	public int x, y;
	public int width, height;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 5;
		this.height = 5;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	}
}

package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	
	public double x, y;
	public int width, height;
	
	public double dx, dy;
	public double speed = 3;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 5;
		this.height = 5;
		
		int angle = new Random().nextInt(240 - 120) + 120;
		
		this.dx = Math.cos(Math.toRadians(angle));
		this.dy = Math.sin(Math.toRadians(angle));
	}
	
	public void tick() {
		if (y + dy*speed + height >= Game.HEIGHT) {
			dy *= -1;
		} else if (y + dy*speed < 0) {
			dy *= -1;
		}
		
		if (x + width >= Game.WIDTH) {
			System.out.println("USER GOAL");
			new Game();
			return;
		} else if (x < 0) {
			System.out.println("COMPUTER GOAL");
			new Game();
			return;
		}
		
		Rectangle boundsBall = new Rectangle((int) (x + dx*speed), (int) (y + dy*speed), width, height);
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int) Game.enemy.x,(int) Game.enemy.y, Game.enemy.width, Game.enemy.height);
		
		if (boundsBall.intersects(boundsPlayer) || boundsBall.intersects(boundsEnemy)) {
			dx *= -1;
		}
		
		x += dx*speed;
		y += dy*speed;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x,(int) y, width, height);
	}
}

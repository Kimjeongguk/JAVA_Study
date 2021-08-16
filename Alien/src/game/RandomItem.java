package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class RandomItem {
	Image image = new ImageIcon("images/mystery.png").getImage();
	public int x;
	public int y;
	public int width = image.getWidth(null);
	public int height = image.getHeight(null);
	public int speedX = 10;
	public int speedY = 10;
	public RandomItem(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void moveY() {
		y+=speedY;
	}
}

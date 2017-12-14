package Model;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface IItem
{
	String getName();
	int getId();
	public BufferedImage getImage();
//	void draw(Graphics graphics);
}
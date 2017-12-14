package Model;

import java.awt.*;

public interface IItem
{
	String getName();
	int getId();
	void draw(Graphics graphics);
}
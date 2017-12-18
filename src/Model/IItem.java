package Model;

import java.awt.image.BufferedImage;

public interface IItem
{
	void SetName(String name);
	void SetId(int id);
	String getName();
	int getId();
	BufferedImage getImage();
}
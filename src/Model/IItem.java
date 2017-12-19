package Model;

import java.awt.image.BufferedImage;

public interface IItem
{
	public void SetName(String name);
	public void SetId(int id);
	public String getName();
	public int getId();
	public BufferedImage getImage();
}
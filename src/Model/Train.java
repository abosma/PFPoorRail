package Model;

import java.awt.*;
import java.io.Serializable;

public class Train implements Serializable, IItem
{
	private int _id;
	private String _name;

	public Train(String name, int id)
	{
		_name = name;
		_id = id;
	}

	public String getName()
	{
		return _name;
	}

	public int getId()
	{
		return _id;
	}

	@Override
	public void draw(Graphics graphics)
	{
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fillRect(30, 80 + _id * 100, 80, 40);
		graphics.fillRect(80, 60 + _id * 100, 30, 30);
		graphics.drawRoundRect(85, 40 + _id * 100, 20, 20, 20, 20);
		graphics.drawRoundRect(85, _id * 100, 40, 40, 40, 40);
		graphics.setColor(Color.BLACK);
		graphics.fillRoundRect(35, 120 + _id * 100, 20, 20, 20, 20);
		graphics.fillRoundRect(80, 120 + _id * 100, 20, 20, 20, 20);
		graphics.drawString(_name, 40, 105 + _id * 100);
	}
}
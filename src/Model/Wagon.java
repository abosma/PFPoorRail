package Model;

import java.awt.*;

public class Wagon implements IComponent
{
	private int _id;
	private int _length;
	private String _name;

	@Override
	public int getSeats()
	{
		return 0;
	}

	@Override
	public int getLength()
	{
		return _length;
	}

	@Override
	public String getName()
	{
		return null;
	}

	@Override
	public int getId()
	{
		return _id;
	}

	@Override
	public void draw(Graphics graphics)
	{
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fillRect(30+_id*_length,80+_id*100,80,40);
		graphics.setColor(Color.BLACK);
		graphics.fillRoundRect(35+(_id -1 )*_length, 120+_id*100, 20, 20, 20, 20);
		graphics.fillRoundRect(80+(_id -1 )*_length, 120+_id*100, 20, 20, 20, 20);
		graphics.drawString(_name,40+(_id -1 )*_length,105+_id*100);
	}
}

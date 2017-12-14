package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class Wagon implements Serializable, IItem
{
	private int _id;
	private int _length;
	private String _name;
	private transient BufferedImage img;

	public Wagon(String name, int seats, int id)
	{
		this._id = id;
		this._length = seats;
		this._name = name;
	}

	public int getSeats()
	{
		return 0;
	}

	public int getLength()
	{
		return _length;
	}

	@Override
	public String getName()
	{
		return _name;
	}

	@Override
	public int getId()
	{
		return _id;
	}

	public BufferedImage getImage()
	{
		try
		{
			img = ImageIO.read(new File("src/images/wagon.png"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
}
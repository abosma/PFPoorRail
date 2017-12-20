package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class Wagon implements Component
{
	private int _id;
	private int _seats;
	private String _name;

	public Wagon(String name, int seats, int id)
	{
		this._id = id;
		this._seats = seats;
		this._name = name;
	}

	public int getSeats()
	{
		return _seats;
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
			return ImageIO.read(new File("src/images/wagon.png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void SetName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SetId(int id) {
		// TODO Auto-generated method stub
		
	}
}
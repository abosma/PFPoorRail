package Model;

public class Wagon implements Component
{
	private int _id;
	private int _seats;
	private String _name;

	public Wagon()
	{

	}

	public Wagon(String name, int seats)
	{
		_seats = seats;
		_name = name;
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

	@Override
	public void SetName(String name)
	{
		_name = name;

	}

	@Override
	public void SetId(int id)
	{
		_id = id;

	}
}
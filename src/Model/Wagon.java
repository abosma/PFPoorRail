package Model;

@SuppressWarnings("serial")
public class Wagon implements Component
{
	private int _id;
	private int _seats;
	private String _name;
	private int _parent;

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
	public int GetParent()
	{
		return _parent;
	}

	public void SetParent(int parentId)
	{
		_parent = parentId;
	}

	@Override
	public void SetId(int id)
	{
		_id = id;

	}
}
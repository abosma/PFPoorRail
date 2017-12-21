package Model;

@SuppressWarnings("serial")
public class Train implements IItem
{
	//private List<IItem> allComponents = new ArrayList<>();
	private int _id;
	private String _name;

	public Train()
	{

	}

	public Train(String name)
	{
		_name = name;
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
	public int GetParent()
	{
		return -1;
	}

	@Override
	public void SetParent(int id)
	{

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
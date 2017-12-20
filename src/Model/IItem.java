package Model;

public interface IItem
{
	void SetName(String name);
	void SetId(int id);
	String getName();
	int getId();
	int GetParent();
	void SetParent(int id);
}
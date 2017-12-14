package Extensions;

public class IntExtensions
{
    public static boolean IsInt(String value)
    {
        try
        {
            Integer.parseInt(value);
            return true;
        }
        catch (Exception ex){
            return false;
        }

    }
}

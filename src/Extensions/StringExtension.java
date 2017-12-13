package Extensions;

public class StringExtension
{
    public static boolean stringIsNullOrEmpty(String value)
    {
        return value == null || value.trim().length() == 0;
    }
}

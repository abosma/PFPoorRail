package Extensions;

import java.util.ArrayList;

public class StringExtension
{
    public static boolean stringIsNullOrEmpty(String value)
    {
        return value == null || value.trim().length() == 0;
    }

    public static String[] Split(String value,String regex, boolean removeEmpty)
    {
        String[] values = value.split(regex);

        if(!removeEmpty)
            return  values;
        ArrayList<String> data = new ArrayList<String>();
        for(String item : values)
        {
            if(StringExtension.stringIsNullOrEmpty(item))
                continue;
            data.add(item);
        }
        String[] returnValues = new String[data.size()];
        returnValues = data.toArray(returnValues);
        return returnValues;
    }
}

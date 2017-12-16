package Extensions;
import java.util.Arrays;

//Simple extensions
public class ArrayExtensions
{
    public static String[] Skip(String[] array, int skips)
    {
        return Arrays.copyOfRange(array, skips, array.length);
    }
}

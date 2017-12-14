package Extensions;
import java.util.Arrays;

public class ArrayExtensions
{
    public static String[] Skip(String[] array, int skips)
    {
        return Arrays.copyOfRange(array, 1, array.length);
    }
}

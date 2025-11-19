import java.util.ArrayList;
import java.util.Arrays;

public class EncodedData implements Decodable
{
    public ArrayList<Decodable> data;

    public EncodedData(String string)
    {
        data = new ArrayList<>();
        int counter = 0;
        char previous = string.charAt(0);
        for(int i = 0; i < string.length(); i++)
        {
            if(string.charAt(i) == previous)
            {
                //counts repeating literals
                counter++;
            }
            else
            {
                //adds the previous literal(s) or a series of previous literal
                switch (counter)
                {
                    //adds a single literal to the list
                    case 1: data.add(new Literal(previous)); break;
                    //adds two literals to the list
                    case 2: data.addAll(Arrays.asList(new Literal(previous), new Literal(previous))); break;
                    //adds a single series to the list
                    default:data.add(new Series(counter, previous)); break;
                }
                counter = 1;
                previous = string.charAt(i);
            }
        }
        //adds the last literal(s) or series
        switch (counter)
        {
            case 1: data.add(new Literal(previous)); break;
            case 2: data.addAll(Arrays.asList(new Literal(previous), new Literal(previous))); break;
            default:data.add(new Series(counter, previous)); break;
        }
    }

    @Override
    public String decode()
    {
        //decodes every stored literal and series, then concatenates them to a single string
        StringBuilder sb = new StringBuilder();
        for(Decodable d : data)
        {
            sb.append(d.decode());
        }
        return sb.toString();
    }

    @Override
    public String toString(String seriesSign)
    {
        StringBuilder sb = new StringBuilder();
        for(Decodable d : data)
        {
            sb.append(d.toString(seriesSign));
        }
        return sb.toString();
    }
}

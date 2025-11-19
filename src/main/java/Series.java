public class Series implements Decodable
{
    int count;
    char literal;

    public Series(int count, char literal)
    {
        this.count = count;
        this.literal = literal;
    }

    @Override
    public String decode()
    {
        //returns the string of [count] literals
        return String.valueOf(literal).repeat(Math.max(0, count));
    }

    @Override
    public String toString(String seriesSign) {
        return seriesSign + count + literal;
    }
}

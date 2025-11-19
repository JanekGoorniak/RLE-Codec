public class Literal implements Decodable
{
    char literal;

    public Literal(char literal)
    {
        this.literal = literal;
    }

    @Override
    public String decode()
    {
        //returns the literal as a String
        return String.valueOf(literal);
    }

    @Override
    public String toString(String seriesSign) {
        return String.valueOf(literal);
    }
}

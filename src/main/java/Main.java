public class Main
{
    public static EncodedData encode_rle(String data)
    {
        return new EncodedData(data);
    }

    public static String decode_rle(EncodedData encoded_data)
    {
        return encoded_data.decode();
    }

    public static void main(String[] args)
    {
        String testData = "AAAAAAAAAABBBBBBBBBBBBBBBBCCCCCCDEFGGHHHIIIIIIII";
        EncodedData encodedData = encode_rle(testData);
        System.out.println(encodedData.data);
        System.out.println(decode_rle(encodedData));
    }
}

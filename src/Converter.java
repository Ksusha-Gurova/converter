public class Converter {
    private String convert;

    public static String decToHex(String number){
        return Integer.toHexString(Integer.parseInt(number));
    }

    public static String decToBin(String number){
        return Integer.toBinaryString(Integer.parseInt(number));
    }
    public static String binToDec(String number){
        int dec = Integer.parseInt(number, 2);
        return Integer.toString(dec);
    }
    public static String  binToHex (String number) {
        return decToHex(binToDec(number));
    }
}

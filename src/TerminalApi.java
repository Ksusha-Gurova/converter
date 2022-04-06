import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TerminalApi {
    private static final List<String> fromSystemSupported = List.of("2", "10");
    private static final List<String> toSystemSupported = List.of("2", "10", "16");
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    


    public static void start (){
        System.out.println("Привет!");
        System.out.println("Это программа преобразует для вас двоичную и десятичную системы счисления в двоичную, десятичную и шестнадцатеричную системы");
        System.out.println("Для остановки программы напишите stop");
        System.out.println("Для простоты ввода вместо названия системы счисления указывайте соответсвующее ей число");
        System.out.println("2 - двоичная система счисления");
        System.out.println("10 - десятичная система счисления");
        System.out.println("16 - шестнадцатиричная система счисления");
    }

    public static  void requestDataFromUser () {
        try {
            System.out.println("Укажиет из кокой системы сисления будем преобразовывать");
            String fromSystem = getNumber(fromSystemSupported, reader);
            System.out.println("Укажите в какую систему счисления будем преобразовывать");
            String toSystem = getNumber(toSystemSupported, reader);
            System.out.println("Укажите число для преобразования");
            String number = getAnyNumber(reader);
            System.out.println(convert(fromSystem, toSystem, number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getAnyNumber (BufferedReader reader) throws IOException {
        String temp = reader.readLine();
        if (temp.equals("stop")){
            reader.close();
            System.exit(0);
        }
        return temp;
    }
    public static String getNumber (List<String> supportedValues, BufferedReader reader) throws IOException {
        String temp = getAnyNumber(reader);
        if(!supportedValues.contains(temp)){
            System.out.println("Вы ввели неверную систему счисления");
            System.out.println("мы поддерживаем " + supportedValues + " системы счисления");
            return getNumber(supportedValues, reader);
        }
        return temp;
    }
    public static String convert (String fromSystem, String toSystem, String number) {
        String result = null;
        if (fromSystem.equals("2") && toSystem.equals("2")) {
            result = number;
        }
        if(fromSystem.equals("2") && toSystem.equals("10")) {
            result = Converter.binToDec(number);
        }
        if (fromSystem.equals("2") && toSystem.equals("16")) {
            result = Converter.binToHex(number);
        }
        if (fromSystem.equals("10") && toSystem.equals("2")) {
            result = Converter.decToBin(number);
        }
        if (fromSystem.equals("10") && toSystem.equals("10")) {
            result = number;
        }
        if (fromSystem.equals("10") && toSystem.equals("16")) {
            result = Converter.decToHex(number);
        }
        return result;
    }


}
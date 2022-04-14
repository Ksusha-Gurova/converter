import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class TerminalApi {
    private static final List<String> fromSystemSupported = List.of("2", "10");
    private static final List<String> toSystemSupported = List.of("2", "10", "16");
    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    


    public static void start (){
        System.out.println("Привет!");
        System.out.println("Это программа преобразует для вас двоичную и десятичную системы счисления в двоичную, десятичную и шестнадцатеричную системы");
        System.out.println("Для остановки программы напишите stop");
        System.out.println("Для простоты ввода вместо названия системы счисления указывайте соответсвующее ей число");
        System.out.println("2 - двоичная система счисления");
        System.out.println("10 - десятичная система счисления");
        System.out.println("16 - шестнадцатиричная система счисления");
    }

    public static void requestDataFromUser () {
        try {
            System.out.println("Укажите из какой системы счисления будем преобразовывать");
            String fromSystem = getSupportedNumber(fromSystemSupported, reader);
            System.out.println("Укажите в какую систему счисления будем преобразовывать");
            String toSystem = getSupportedNumber(toSystemSupported, reader);
            System.out.println("Укажите число для преобразования");
            String number = getAnyNumber(reader);
            System.out.println("Ответ = " + convert(fromSystem, toSystem, number));
            System.out.println("Для конвертации следующего числа нажмите Enter");
            System.out.println("Для завершения работы программы напишите stop");
            getAnyNumber(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getAnyNumber (BufferedReader reader) throws IOException {
        String temp = reader.readLine();
        if (temp.equals("stop")){
            reader.close();
            System.out.println("Завершение работы программы");
            System.exit(0);
        }
        return temp;
    }
    public static String getSupportedNumber(List<String> supportedValues, BufferedReader reader) throws IOException {
        String temp = getAnyNumber(reader);
        if(!supportedValues.contains(temp)){
            System.out.println("Вы ввели неверную систему счисления");
            System.out.println("мы поддерживаем " + supportedValues + " системы счисления");
            System.out.println("Повторите запрос корректно");
            return getSupportedNumber(supportedValues, reader);
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
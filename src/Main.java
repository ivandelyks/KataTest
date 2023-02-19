import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static String calc(String input) throws Exception {
        String[] data = input.split(" ");

        String value1 = data[0];
        String value2 = data[2];
        String sign = data[1];
        int number1;
        int number2;
        boolean romeArab1;
        boolean romeArab2;
        int res = 0;
        try {
            number1 = rome(value1);
            romeArab1 = false;
        } catch (Exception e) {
            try {
                number1 = Integer.parseInt(value1);
                romeArab1 = true;
            } catch (Exception err) {
                throw new Exception();
            }
        }
        try {
            number2 = rome(value2);
            romeArab2 = false;
        } catch (Exception e) {
            try {
                number2 = Integer.parseInt(value2);
                romeArab2 = true;
            } catch (Exception err) {
                throw new Exception();
            }
        }
        if (romeArab1 == romeArab2) {
            if (number1 <= 10 && number1 >= 1 && number2 <= 10 && number2 >= 1) {
                switch (sign) {
                    case "+":
                        res = number1 + number2;
                        break;
                    case "-":
                        res = number1 - number2;
                        break;
                    case "*":
                        res = number1 * number2;
                        break;
                    case "/":
                        res = number1 / number2;
                        break;
                    default:
                        throw new Exception();
                }
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
        if(romeArab1) {
            return String.valueOf(res);
        } else {
            return arabToRome(res);
        }
    }
    private static String arabToRome(int inputA) throws Exception{
        if(inputA <= 0) {
            throw new Exception();
        } else {
            int houndred = inputA / 100;
            int ten = (inputA - houndred * 100) / 10;
            int solo = (inputA - ten * 10 - houndred * 100);
            return convertArab(houndred) + convertArabTen(ten) + convertArabSolo(solo);
        }
    }
    private static String convertArab(int inputHoundred) {
        if(inputHoundred == 1) {
            return "C";
        } else {
            return "";
        }
    }
    private static String convertArabTen(int inputTen) {
        switch (inputTen) {
            case 0:
                return "";
            case 1:
                return "X";
            case 2:
                return "XX";
            case 3:
                return "XXX";
            case 4:
                return "XL";
            case 5:
                return "L";
            case 6:
                return "LX";
            case 7:
                return "LXX";
            case 8:
                return "LXXX";
            case 9:
                return "XC";
        }
        return "";
    }

    private static String convertArabSolo(int inputSolo) {
        switch (inputSolo) {
            case 0:
                return "";
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
        }
        return "";
    }
    private static int rome(String input) throws Exception {
        int output;

        switch (input) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new Exception();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        try {
            System.out.println(calc(s));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}




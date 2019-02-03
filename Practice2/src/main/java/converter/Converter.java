package converter;

import alphabet.Alphabet;

public class Converter implements ConverterManager {
    private Alphabet alphabet;

    public Converter(){
        alphabet = new Alphabet();
    }

    public String convert(int from, String numericValue, int to) {
        if(from >= 0 && from <= 16 && to >= 0 && to <= 16){
            String result = "";
            result = convertToDecimal(from, numericValue);
            result = convertToConcrete(to, result);
            return result;
        } else {
            System.err.println("Incorrect input of the parameters! Required values from 1 to 16, Used: " + from + "/" + to);
            return "";
        }
    }

    private String convertToDecimal(int from, String nonDecimal){
        String result = "";
        int Number = 0;
        char[] chars = String.valueOf(nonDecimal).toCharArray();
        for(int index = chars.length - 1, exponent = 0; index >= 0; index--, exponent++){
            validateCharacter(alphabet.getValue(chars[index]), from);
            Number += (alphabet.getValue(chars[index])) * Math.pow(from, exponent);
        }
        result = String.valueOf(Number);
        return result;
    }

    private void validateCharacter(int current, int from) {
        if(current >= from || (int) String.valueOf(current).charAt(0) < (int) String.valueOf(0).charAt(0)){
            System.err.println("Incorrect input of the data!");
            System.exit(1);
        }
    }

    private String convertToConcrete(int to, String decimal){
        String result = "";
        int number = Integer.parseInt(decimal);
        int r;
        do {
            r = number % to;
            result += alphabet.getKey(r);
            number /= to;
        } while(number > 0);
        return reverse(result);
    }

    private String reverse(String text){
        String reversed = "";
        char[] chars = text.toCharArray();
        for(int index = chars.length - 1; index >= 0; index--){
            reversed += chars[index];
        }
        return reversed;
    }
}

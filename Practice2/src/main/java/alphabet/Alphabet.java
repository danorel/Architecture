package alphabet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Alphabet {
    private Map<Character, Integer> alphabet;

    public Alphabet(){
        alphabet = new HashMap<Character, Integer>();
        alphabet.put('0', 0);
        alphabet.put('1', 1);
        alphabet.put('2', 2);
        alphabet.put('3', 3);
        alphabet.put('4', 4);
        alphabet.put('5', 5);
        alphabet.put('6', 6);
        alphabet.put('7', 7);
        alphabet.put('8', 8);
        alphabet.put('9', 9);
        alphabet.put('a', 10);
        alphabet.put('b', 11);
        alphabet.put('c', 12);
        alphabet.put('d', 13);
        alphabet.put('e', 14);
        alphabet.put('f', 15);
    }

    public char getKey(int value){
        Set<Character> keys =  alphabet.keySet();
        for(char key : keys){
            if(alphabet.get(key) == value){
                return key;
            }
        }
        return ' ';
    }

    public int getValue(char key){
        if(alphabet.get(key) == null){
            System.err.println("\'" + key + "\' doesn't exist in the library!");
            System.exit(-1);
            return -1;
        } else {
            return alphabet.get(key);
        }
    }
}

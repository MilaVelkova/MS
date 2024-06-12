import java.util.HashMap;
import java.util.Map;

public class ArithmeticCodingExample {

    public static void main(String[] args) {
        String input = "DATA";
        System.out.println("Original: " + input);

        Map<Character, Double> probabilities = new HashMap<>();
        probabilities.put('D', 0.25);
        probabilities.put('A', 0.5);
        probabilities.put('T', 0.25);

        ArithmeticEncoding encoder = new ArithmeticEncoding();
        String encoded = encoder.encode(input, probabilities);
        System.out.println("Encoded: " + encoded);

        ArithmeticDecoding decoder = new ArithmeticDecoding();
        String decoded = decoder.decode(encoded, probabilities, input.length());
        System.out.println("Decoded: " + decoded);
    }
}


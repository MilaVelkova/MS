import java.util.HashMap;
import java.util.Map;

public class ArithmeticDecoding {

    public static class Interval {
        double low;
        double high;

        public Interval(double low, double high) {
            this.low = low;
            this.high = high;
        }
    }

    public String decode(String encoded, Map<Character, Double> probabilities, int length) {
        Map<Character, Interval> intervals = new HashMap<>();
        double low = 0.0;
        for (Map.Entry<Character, Double> entry : probabilities.entrySet()) {
            intervals.put(entry.getKey(), new Interval(low, low + entry.getValue()));
            low += entry.getValue();
        }

        double code = Double.parseDouble(encoded);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (Map.Entry<Character, Interval> entry : intervals.entrySet()) {
                if (code >= entry.getValue().low && code < entry.getValue().high) {
                    result.append(entry.getKey());
                    double range = entry.getValue().high - entry.getValue().low;
                    code = (code - entry.getValue().low) / range;
                    break;
                }
            }
        }
        return result.toString();
    }
}

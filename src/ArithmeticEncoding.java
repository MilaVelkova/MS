import java.util.HashMap;
import java.util.Map;

public class ArithmeticEncoding {

    public static class Interval {
        double low;
        double high;

        public Interval(double low, double high) {
            this.low = low;
            this.high = high;
        }
    }

    public String encode(String input, Map<Character, Double> probabilities) {
        Map<Character, Interval> intervals = new HashMap<>();
        double low = 0.0;
        for (Map.Entry<Character, Double> entry : probabilities.entrySet()) {
            intervals.put(entry.getKey(), new Interval(low, low + entry.getValue()));
            low += entry.getValue();
        }

        double currentLow = 0.0;
        double currentHigh = 1.0;
        for (char symbol : input.toCharArray()) {
            Interval interval = intervals.get(symbol);
            double range = currentHigh - currentLow;
            currentHigh = currentLow + range * interval.high;
            currentLow = currentLow + range * interval.low;
        }

        return Double.toString((currentLow + currentHigh) / 2);
    }
}

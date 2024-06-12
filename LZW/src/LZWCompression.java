import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZWCompression {

    public List<Integer> compress(String input) {
        int size = 256;
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            dict.put("" + (char) i, i);
        }

        String word = "";
        List<Integer> result = new ArrayList<>();
        for (char c : input.toCharArray()) {
            String wc = word + c;
            if (dict.containsKey(wc)) {
                word = wc;
            } else {
                result.add(dict.get(word));
                dict.put(wc, size++);
                word = "" + c;
            }
        }

        if (!word.isEmpty()) {
            result.add(dict.get(word));
        }
        return result;
    }
}



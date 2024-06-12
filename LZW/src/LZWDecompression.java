import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZWDecompression {

    public String decompress(List<Integer> compressed) {
        int size = 256;
        Map<Integer, String> dict = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            dict.put(i, "" + (char) i);
        }

        String word = "" + (char) (int) compressed.remove(0);
        StringBuilder result = new StringBuilder(word);
        for (int k : compressed) {
            String entry;
            if (dict.containsKey(k)) {
                entry = dict.get(k);
            } else if (k == size) {
                entry = word + word.charAt(0);
            } else {
                throw new IllegalArgumentException("Bad compressed word: " + k);
            }

            result.append(entry);

            dict.put(size++, word + entry.charAt(0));

            word = entry;
        }
        return result.toString();
    }
}

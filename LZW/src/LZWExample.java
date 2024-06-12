import java.util.List;

public class LZWExample {

    public static void main(String[] args) {
        String input = "WYS*WYGWYS*WYSWYSGWYSWYGWYS*WYS";
        System.out.println("Original word: " + input);

        LZWCompression compressor = new LZWCompression();
        List<Integer> compressed = compressor.compress(input);
        System.out.println("Compressed: " + compressed);

        LZWDecompression decompressor = new LZWDecompression();
        String decompressed = decompressor.decompress(compressed);
        System.out.println("Decompressed: " + decompressed);
    }
}

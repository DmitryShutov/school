public class BloomFilter {
    public int filter_len;
    public int bits;
    public static int FIRST_HASH_SEED = 17;
    public static int SECOND_HASH_SEED = 223;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        bits = 0;
    }

    // хэш-функции
    public int hash1(String str1) {
        int code = 0;
        for (int i = 0; i < str1.length(); i++) {
            code = (code * FIRST_HASH_SEED) + (int) str1.charAt(i);
        }
        return Math.abs(code) % filter_len;
    }

    public int hash2(String str1) {
        int code = 0;
        for (int i = 0; i < str1.length(); i++) {
            code = (code * SECOND_HASH_SEED) + (int) str1.charAt(i);
        }
        return Math.abs(code) % filter_len;
    }

    public void add(String str1) {
        bits = setBit(bits, hash1(str1));
        bits = setBit(bits, hash2(str1));
    }

    public boolean isValue(String str1) {
        return ((1 << hash1(str1) | 1 << hash2(str1)) & bits) != 0;
    }

    public int setBit(int number, int index) {
        return number | (1 << index);
    }
}
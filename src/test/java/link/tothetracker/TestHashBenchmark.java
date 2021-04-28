package link.tothetracker;

import link.tothetracker.util.Adler32Util;
import link.tothetracker.util.Blake2Util;
import link.tothetracker.util.CRC16Util;
import link.tothetracker.util.CRC32Util;
import link.tothetracker.util.CRC8Util;
import link.tothetracker.util.HmacUtil;
import link.tothetracker.util.MurmurHash2Util;
import link.tothetracker.util.MurmurHash3Util;
import link.tothetracker.util.ShaUtil;
import link.tothetracker.util.XXHashUtil;

/**
 * @author ntn5h
 */
class TestHashBenchmark {

    private static final String ORIGIN = """
        你好! 😥
        안녕하세요!
        Olá!
        سلام دنیا!
        हैलो वर्ल्ड!
        thế!
        Сайн байна уу ертөнц!
        こんにちは
        % & $ @ # ( ) = | [ ] { } ? . ! ~ ^ * - _
    """;

    private static final String FORMAT = "[%s]: %s%n%s%n%n";

    private static void print(String method, String hash) {
        var length = hash.length();
        System.out.format(FORMAT, method, length, hash);
    }

    private static void adler() {
        var hash = Adler32Util.hash(ORIGIN);
        print("adler", hash);
    }

    private static void crc() {
        var hash = CRC8Util.hash(ORIGIN);
        print("crc8", hash);
        hash = CRC16Util.hash(ORIGIN);
        print("crc16", hash);
        hash = CRC32Util.hash(ORIGIN);
        print("crc32", hash);
        hash = CRC32Util.hash_c(ORIGIN);
        print("crc32_c", hash);
        hash = CRC32Util.hash_zip(ORIGIN);
        print("crc32_zip", hash);
    }

    private static void murmur() {
        var hash = MurmurHash2Util.hash32(ORIGIN);
        print("murmur2-32", hash);
        hash = MurmurHash2Util.hash64(ORIGIN);
        print("murmur2-64", hash);
        hash = MurmurHash3Util.hash32(ORIGIN);
        print("murmur3-32", hash);
        hash = MurmurHash3Util.hash128(ORIGIN);
        print("murmur3-128", hash);
    }

    private static void xx_hash() {
        var hash = XXHashUtil.hash(ORIGIN);
        print("xx-hash", hash);
    }

    private static void sha() {
        var hash = ShaUtil.md5(ORIGIN);
        print("md5", hash);
        hash = ShaUtil.sha1(ORIGIN);
        print("sha1", hash);
        hash = ShaUtil.sha256(ORIGIN);
        print("sha256", hash);
        hash = ShaUtil.sha384(ORIGIN);
        print("sha384", hash);
        hash = ShaUtil.sha512(ORIGIN);
        print("sha512", hash);
        hash = ShaUtil.sha3_224(ORIGIN);
        print("sha3_224", hash);
        hash = ShaUtil.sha3_256(ORIGIN);
        print("sha3_256", hash);
        hash = ShaUtil.sha3_512(ORIGIN);
        print("sha3_512", hash);
        hash = ShaUtil.sha512_224(ORIGIN);
        print("sha512_224", hash);
        hash = ShaUtil.sha512_256(ORIGIN);
        print("sha512_256", hash);
    }

    private static void hmac() {
        var hash = HmacUtil.md5(ORIGIN);
        print("hmac-md5", hash);
        hash = HmacUtil.sha1(ORIGIN);
        print("hmac-sha1", hash);
        hash = HmacUtil.sha224(ORIGIN);
        print("hmac-sha224", hash);
        hash = HmacUtil.sha256(ORIGIN);
        print("hmac-sha256", hash);
        hash = HmacUtil.sha384(ORIGIN);
        print("hmac-sha384", hash);
        hash = HmacUtil.sha512(ORIGIN);
        print("hmac-sha512", hash);
    }

    private static void blake2() {
        var hash = Blake2Util.hash160(ORIGIN);
        print("blake2-160", hash);
        hash = Blake2Util.hash256(ORIGIN);
        print("blake2-256", hash);
        hash = Blake2Util.hash384(ORIGIN);
        print("blake2-384", hash);
        hash = Blake2Util.hash512(ORIGIN);
        print("blake2-512", hash);
    }

    public static void main(String[] args) {
        System.out.println(ORIGIN);
        adler();
        crc();
        murmur();
        xx_hash();
        sha();
        hmac();
        blake2();
    }

}
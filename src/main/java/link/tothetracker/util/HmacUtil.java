package link.tothetracker.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

/**
 * @author t3link
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HmacUtil {

    private static final String KEY = "hello,im,hello,im";

    public static String md5(String origin) {
        var instance = new HmacUtils(HmacAlgorithms.HMAC_MD5, KEY);
        return instance.hmacHex(origin);
    }

    public static String sha1(String origin) {
        var instance = new HmacUtils(HmacAlgorithms.HMAC_SHA_1, KEY);
        return instance.hmacHex(origin);
    }

    public static String sha224(String origin) {
        var instance = new HmacUtils(HmacAlgorithms.HMAC_SHA_224, KEY);
        return instance.hmacHex(origin);
    }

    public static String sha256(String origin) {
        var instance = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, KEY);
        return instance.hmacHex(origin);
    }

    public static String sha384(String origin) {
        var instance = new HmacUtils(HmacAlgorithms.HMAC_SHA_384, KEY);
        return instance.hmacHex(origin);
    }

    public static String sha512(String origin) {
        var instance = new HmacUtils(HmacAlgorithms.HMAC_SHA_512, KEY);
        return instance.hmacHex(origin);
    }

}

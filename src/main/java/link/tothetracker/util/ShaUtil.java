package link.tothetracker.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author t3link
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ShaUtil {

    public static String md5(String origin) {
        return DigestUtils.md5Hex(origin);
    }

    public static String sha1(String origin) {
        return DigestUtils.sha1Hex(origin);
    }

    public static String sha256(String origin) {
        return DigestUtils.sha256Hex(origin);
    }

    public static String sha384(String origin) {
        return DigestUtils.sha384Hex(origin);
    }

    public static String sha512(String origin) {
        return DigestUtils.sha512Hex(origin);
    }

    public static String sha3_224(String origin) {
        return DigestUtils.sha3_224Hex(origin);
    }

    public static String sha3_256(String origin) {
        return DigestUtils.sha3_256Hex(origin);
    }

    public static String sha3_512(String origin) {
        return DigestUtils.sha3_512Hex(origin);
    }

    public static String sha512_224(String origin) {
        return DigestUtils.sha512_224Hex(origin);
    }

    public static String sha512_256(String origin) {
        return DigestUtils.sha512_256Hex(origin);
    }

}

package link.tothetracker.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.MurmurHash2;

/**
 * @author t3link
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MurmurHash2Util {

    public static String hash32(String origin) {
        var cur = MurmurHash2.hash32(origin);
        return Long.toHexString(cur);
    }

    public static String hash64(String origin) {
        var cur = MurmurHash2.hash64(origin);
        return Long.toHexString(cur);
    }

}

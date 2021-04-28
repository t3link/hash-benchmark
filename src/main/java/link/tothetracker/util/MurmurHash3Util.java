package link.tothetracker.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.MurmurHash3;

import java.nio.charset.StandardCharsets;

/**
 * @author t3link
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MurmurHash3Util {

    public static String hash32(String origin) {
        var bytes = origin.getBytes(StandardCharsets.UTF_8);
        var cur = MurmurHash3.hash32x86(bytes);
        return Long.toHexString(cur);
    }

    public static String hash128(String origin) {
        var bytes = origin.getBytes(StandardCharsets.UTF_8);
        var cur = MurmurHash3.hash128x64(bytes)[0];
        return Long.toHexString(cur);
    }

}

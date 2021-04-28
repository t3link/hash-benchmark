package link.tothetracker.util;

import link.tothetracker.digest.CRC16;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;

/**
 * @author t3link
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CRC16Util {

    public static String hash(String origin) {
        var bytes = origin.getBytes(StandardCharsets.UTF_8);
        var instance = new CRC16();
        instance.update(bytes, 0, bytes.length);
        var cur = instance.getValue();
        return Long.toHexString(cur);
    }

}

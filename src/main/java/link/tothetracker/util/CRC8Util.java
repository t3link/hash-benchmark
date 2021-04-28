package link.tothetracker.util;

import link.tothetracker.digest.CRC8;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;

/**
 * @author t3link
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CRC8Util {

    private static final int CRC_POLYNOMIAL = 0x9C;
    private static final byte CRC_INITIAL = (byte) 0xFF;

    public static String hash(String origin) {
        var bytes = origin.getBytes(StandardCharsets.UTF_8);
        var instance = new CRC8(CRC_POLYNOMIAL, CRC_INITIAL);
        instance.update(bytes);
        var cur = instance.getValue();
        return Long.toHexString(cur);
    }

}

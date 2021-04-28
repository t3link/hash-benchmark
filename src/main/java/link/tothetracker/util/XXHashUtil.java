package link.tothetracker.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.XXHash32;

import java.nio.charset.StandardCharsets;

/**
 * @author t3link
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class XXHashUtil {

    public static String hash(String origin) {
        var bytes = origin.getBytes(StandardCharsets.UTF_8);
        var instance = new XXHash32();
        instance.update(bytes, 0, bytes.length);
        var cur = instance.getValue();
        return Long.toHexString(cur);
    }

}

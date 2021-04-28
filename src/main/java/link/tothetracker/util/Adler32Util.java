package link.tothetracker.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.util.zip.Adler32;

/**
 * @author t3link
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Adler32Util {

    public static String hash(String origin) {
        var bytes = origin.getBytes(StandardCharsets.UTF_8);
        var instance = new Adler32();
        instance.update(bytes);
        var cur = instance.getValue();
        return Long.toHexString(cur);
    }

}

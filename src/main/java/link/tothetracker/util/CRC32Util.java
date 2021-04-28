package link.tothetracker.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.PureJavaCrc32;
import org.apache.commons.codec.digest.PureJavaCrc32C;

import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;

/**
 * @author t3link
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CRC32Util {

    public static String hash(String origin) {
        var bytes = origin.getBytes(StandardCharsets.UTF_8);
        var instance = new PureJavaCrc32();
        instance.update(bytes, 0, bytes.length);
        var cur = instance.getValue();
        return Long.toHexString(cur);
    }

    public static String hash_c(String origin) {
        var bytes = origin.getBytes(StandardCharsets.UTF_8);
        var instance = new PureJavaCrc32C();
        instance.update(bytes, 0, bytes.length);
        var cur = instance.getValue();
        return Long.toHexString(cur);
    }

    public static String hash_zip(String origin) {
        var bytes = origin.getBytes(StandardCharsets.UTF_8);
        var instance = new CRC32();
        instance.update(bytes);
        var cur = instance.getValue();
        return Long.toHexString(cur);
    }

}

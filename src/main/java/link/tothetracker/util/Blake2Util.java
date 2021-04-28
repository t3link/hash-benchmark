package link.tothetracker.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;

/**
 * @author t3link
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Blake2Util {

    private static final int DIGEST_LENGTH_160 = 20;
    private static final int DIGEST_LENGTH_256 = 32;
    private static final int DIGEST_LENGTH_384 = 48;
    private static final int DIGEST_LENGTH_512 = 64;

    private static String hash(int strength, String origin) {
        var value = origin.getBytes(StandardCharsets.UTF_8);
        var digest = new Blake2bDigest(strength * 8);
        var hash = new byte[strength];
        digest.update(value, 0, value.length);
        digest.doFinal(hash, 0);
        return Hex.toHexString(hash);
    }

    public static String hash160(String origin) {
        return hash(DIGEST_LENGTH_160, origin);
    }

    public static String hash256(String origin) {
        return hash(DIGEST_LENGTH_256, origin);
    }

    public static String hash384(String origin) {
        return hash(DIGEST_LENGTH_384, origin);
    }

    public static String hash512(String origin) {
        return hash(DIGEST_LENGTH_512, origin);
    }

}

package link.tothetracker;

import link.tothetracker.util.Adler32Util;
import link.tothetracker.util.Blake2Util;
import link.tothetracker.util.CRC16Util;
import link.tothetracker.util.CRC32Util;
import link.tothetracker.util.CRC8Util;
import link.tothetracker.util.HmacUtil;
import link.tothetracker.util.MurmurHash2Util;
import link.tothetracker.util.MurmurHash3Util;
import link.tothetracker.util.ShaUtil;
import link.tothetracker.util.XXHashUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author t3link
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 2, time = 30)
@Measurement(iterations = 3, time = 150)
@Threads(12)
@Fork(2)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class HashBenchmarkApplication {

    @Param({"32", "64", "128", "256"})
    private int length;

    private String random() {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    @Benchmark
    public void adler32() {
        var origin = random();
        Adler32Util.hash(origin);
    }

    // region crc

    @Benchmark
    public void crc8() {
        var origin = random();
        CRC8Util.hash(origin);
    }
    @Benchmark
    public void crc16() {
        var origin = random();
        CRC16Util.hash(origin);
    }
    @Benchmark
    public void crc32() {
        var origin = random();
        CRC32Util.hash(origin);
    }
    @Benchmark
    public void crc32_c() {
        var origin = random();
        CRC32Util.hash_c(origin);
    }
    @Benchmark
    public void crc32_zip() {
        var origin = random();
        CRC32Util.hash_zip(origin);
    }

    // endregion

    // region murmur

    @Benchmark
    public void murmur2_32() {
        var origin = random();
        MurmurHash2Util.hash32(origin);
    }
    @Benchmark
    public void murmur2_64() {
        var origin = random();
        MurmurHash2Util.hash64(origin);
    }
    @Benchmark
    public void murmur3_32() {
        var origin = random();
        MurmurHash3Util.hash32(origin);
    }
    @Benchmark
    public void murmur3_128() {
        var origin = random();
        MurmurHash3Util.hash128(origin);
    }

    // endregion

    @Benchmark
    public void xx_hash() {
        var origin = random();
        XXHashUtil.hash(origin);
    }

    // region normal md5、sha

    @Benchmark
    public void md5() {
        var origin = random();
        ShaUtil.md5(origin);
    }
    @Benchmark
    public void sha1() {
        var origin = random();
        ShaUtil.sha1(origin);
    }
    @Benchmark
    public void sha256() {
        var origin = random();
        ShaUtil.sha256(origin);
    }
    @Benchmark
    public void sha384() {
        var origin = random();
        ShaUtil.sha384(origin);
    }
    @Benchmark
    public void sha512() {
        var origin = random();
        ShaUtil.sha512(origin);
    }
    @Benchmark
    public void sha3_224() {
        var origin = random();
        ShaUtil.sha3_224(origin);
    }
    @Benchmark
    public void sha3_256() {
        var origin = random();
        ShaUtil.sha3_256(origin);
    }
    @Benchmark
    public void sha3_512() {
        var origin = random();
        ShaUtil.sha3_512(origin);
    }
    @Benchmark
    public void sha512_224() {
        var origin = random();
        ShaUtil.sha512_224(origin);
    }
    @Benchmark
    public void sha512_256() {
        var origin = random();
        ShaUtil.sha512_256(origin);
    }

    // endregion

    // region hmac

    @Benchmark
    public void hmac_md5() {
        var origin = random();
        HmacUtil.md5(origin);
    }
    @Benchmark
    public void hmac_sha1() {
        var origin = random();
        HmacUtil.sha1(origin);
    }
    @Benchmark
    public void hmac_sha224() {
        var origin = random();
        HmacUtil.sha224(origin);
    }
    @Benchmark
    public void hmac_sha256() {
        var origin = random();
        HmacUtil.sha256(origin);
    }
    @Benchmark
    public void hmac_sha384() {
        var origin = random();
        HmacUtil.sha384(origin);
    }
    @Benchmark
    public void hmac_sha512() {
        var origin = random();
        HmacUtil.sha512(origin);
    }

    // endregion

    // region blake2

    @Benchmark
    public void blake2_160() {
        var origin = random();
        Blake2Util.hash160(origin);
    }
    @Benchmark
    public void blake2_256() {
        var origin = random();
        Blake2Util.hash256(origin);
    }
    @Benchmark
    public void blake2_384() {
        var origin = random();
        Blake2Util.hash384(origin);
    }
    @Benchmark
    public void blake2_512() {
        var origin = random();
        Blake2Util.hash512(origin);
    }

    // endregion

    public static void main(String[] args) throws RunnerException {
        var options = new OptionsBuilder()
                .include(HashBenchmarkApplication.class.getSimpleName())
                .output("benchmark.log")
                .build();

        System.out.println("In process!");
        new Runner(options).run();
    }

}



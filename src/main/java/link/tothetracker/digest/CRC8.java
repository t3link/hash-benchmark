package link.tothetracker.digest;

import java.util.zip.Checksum;

/**
 * @author t3link
 */
public class CRC8 implements Checksum {

    private static final int CRC_TABLE_LENGTH = 256;
    private static final int BIT_LENGTH = 8;

    private final short init;
    private final short[] table = new short[CRC_TABLE_LENGTH];
    private short value;

    /**
     * Construct a CRC8 specifying the polynomial and initial value.
     * @param polynomial Polynomial, typically one of the POLYNOMIAL_* constants.
     * @param init Initial value, typically either 0xff or zero.
     */
    public CRC8(int polynomial, short init) {
        this.value = this.init = init;
        for (var dividend = 0; dividend < CRC_TABLE_LENGTH; dividend++) {
            var remainder = dividend;
            for (var bit = 0; bit < BIT_LENGTH; ++bit) {
                if ((remainder & 0x01) != 0) {
                    remainder = (remainder >>> 1) ^ polynomial;
                } else {
                    remainder >>>= 1;
                }
            }
            table[dividend] = (short)remainder;
        }
    }

    @Override
    public void update(byte[] buffer, int offset, int len) {
        for (var i = 0; i < len; i++) {
            var data = buffer[offset+i] ^ value;
            value = (short)(table[data & 0xff] ^ (value << 8));
        }
    }

    /**
     * Updates the current checksum with the specified array of bytes.
     * Equivalent to calling <code>update(buffer, 0, buffer.length)</code>.
     * @param buffer the byte array to update the checksum with
     */
    @Override
    public void update(byte[] buffer) {
        update(buffer, 0, buffer.length);
    }

    @Override
    public void update(int b) {
        update(new byte[]{(byte)b}, 0, 1);
    }

    @Override
    public long getValue() {
        return value & 0xff;
    }

    @Override
    public void reset() {
        value = init;
    }

}

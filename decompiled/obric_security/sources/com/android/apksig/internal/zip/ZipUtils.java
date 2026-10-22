package com.android.apksig.internal.zip;

import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.internal.util.Pair;
import com.android.apksig.util.DataSource;
import com.android.apksig.zip.ZipFormatException;
import com.android.apksig.zip.ZipSections;
import com.bytedance.librarian.LibrarianImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
public abstract class ZipUtils {
    public static final short COMPRESSION_METHOD_DEFLATED = 8;
    public static final short COMPRESSION_METHOD_STORED = 0;
    public static final short GP_FLAG_DATA_DESCRIPTOR_USED = 8;
    public static final short GP_FLAG_EFS = 2048;
    private static final int UINT16_MAX_VALUE = 65535;
    private static final int ZIP_EOCD_CENTRAL_DIR_OFFSET_FIELD_OFFSET = 16;
    private static final int ZIP_EOCD_CENTRAL_DIR_SIZE_FIELD_OFFSET = 12;
    private static final int ZIP_EOCD_CENTRAL_DIR_TOTAL_RECORD_COUNT_OFFSET = 10;
    private static final int ZIP_EOCD_COMMENT_LENGTH_FIELD_OFFSET = 20;
    private static final int ZIP_EOCD_REC_MIN_SIZE = 22;
    private static final int ZIP_EOCD_REC_SIG = 101010256;

    public static class DeflateResult {
        public final long inputCrc32;
        public final int inputSizeBytes;
        public final byte[] output;

        public DeflateResult(int r1, long r2, byte[] r4) {
            this.inputSizeBytes = r1;
            this.inputCrc32 = r2;
            this.output = r4;
        }
    }

    private ZipUtils() {
    }

    static void assertByteOrderLittleEndian(ByteBuffer r1) {
        if (r1.order() != ByteOrder.LITTLE_ENDIAN) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    public static DeflateResult deflate(ByteBuffer r9) {
        int r0 = r9.remaining();
        if (r9.hasArray() == false) goto L5;
        byte[] r1 = r9.array();
        int r3 = r9.arrayOffset() + r9.position();
        r9.position(r9.limit());
    L6:
        CRC32 r10 = new CRC32();
        r10.update(r1, r3, r0);
        long r4 = r10.getValue();
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        Deflater r6 = new Deflater(9, true);
        r6.setInput(r1, r3, r0);
        r6.finish();
        byte[] r2 = new byte[65536];
    L8:
        if (r6.finished() == true) goto L11;
        r11.write(r2, 0, r6.deflate(r2));
        goto L8
    L11:
        return new DeflateResult(r0, r4, r11.toByteArray());
    L5:
        r1 = new byte[r0];
        r9.get(r1);
        r3 = 0;
        goto L6
    }

    public static Pair<ByteBuffer, Long> findZipEndOfCentralDirectoryRecord(DataSource r4) throws IOException {
        if (r4.size() >= 22) goto L6;
        return null;
    L6:
        Pair<ByteBuffer, Long> r0 = findZipEndOfCentralDirectoryRecord(r4, 0);
        if (r0 == null) goto L10;
        return r0;
    L10:
        return findZipEndOfCentralDirectoryRecord(r4, 65535);
    }

    public static int getUnsignedInt16(ByteBuffer r0, int r1) {
        return r0.getShort(r1) & UShort.MAX_VALUE;
    }

    static long getUnsignedInt32(ByteBuffer r2, int r3) {
        return ((long) r2.getInt(r3)) & 4294967295L;
    }

    public static long getZipEocdCentralDirectoryOffset(ByteBuffer r2) {
        assertByteOrderLittleEndian(r2);
        return getUnsignedInt32(r2, r2.position() + 16);
    }

    public static long getZipEocdCentralDirectorySizeBytes(ByteBuffer r2) {
        assertByteOrderLittleEndian(r2);
        return getUnsignedInt32(r2, r2.position() + 12);
    }

    public static int getZipEocdCentralDirectoryTotalRecordCount(ByteBuffer r1) {
        assertByteOrderLittleEndian(r1);
        return getUnsignedInt16(r1, r1.position() + 10);
    }

    public static List<CentralDirectoryRecord> parseZipCentralDirectory(DataSource r7, ZipSections r8) throws IOException, ApkFormatException {
        long r0 = r8.getZipCentralDirectorySizeBytes();
        if (r0 > 2147483647L) goto L18;
        long r2 = r8.getZipCentralDirectoryOffset();
        ByteBuffer r9 = r7.getByteBuffer(r2, (int) r0);
        r9.order(ByteOrder.LITTLE_ENDIAN);
        int r10 = r8.getZipCentralDirectoryRecordCount();
        ArrayList r1 = new ArrayList(r10);
        int r3 = 0;
    L5:
        if (r3 >= r10) goto L16;
        int r4 = r9.position();
        CentralDirectoryRecord r5 = CentralDirectoryRecord.getRecord(r9);     // Catch: ZipFormatException -> L13
        if (r5.getName().endsWith(LibrarianImpl.Constants.SEPARATOR) == true) goto L12;
        r1.add(r5);
    L12:
        r3 = r3 + 1;
    L13:
        e = move-exception;
        throw new ApkFormatException("Malformed ZIP Central Directory record #" + (r3 + 1) + " at file offset " + (r2 + ((long) r4)), e);
    L16:
        return r1;
    L18:
        throw new ApkFormatException("ZIP Central Directory too large: " + r0);
    }

    public static void putUnsignedInt16(ByteBuffer r2, int r3) {
        if (r3 < 0) goto L8;
        if (r3 > 65535) goto L8;
        r2.putShort((short) r3);
        return;
    L8:
        throw new IllegalArgumentException("uint16 value of out range: " + r3);
    }

    static void putUnsignedInt32(ByteBuffer r2, long r3) {
        if (r3 < 0) goto L9;
        if (r3 > 4294967295L) goto L9;
        r2.putInt((int) r3);
        return;
    L9:
        throw new IllegalArgumentException("uint32 value of out range: " + r3);
    }

    static void setUnsignedInt16(ByteBuffer r1, int r2, int r3) {
        if (r3 < 0) goto L8;
        if (r3 > 65535) goto L8;
        r1.putShort(r2, (short) r3);
        return;
    L8:
        throw new IllegalArgumentException("uint16 value of out range: " + r3);
    }

    static void setUnsignedInt32(ByteBuffer r2, int r3, long r4) {
        if (r4 < 0) goto L9;
        if (r4 > 4294967295L) goto L9;
        r2.putInt(r3, (int) r4);
        return;
    L9:
        throw new IllegalArgumentException("uint32 value of out range: " + r4);
    }

    public static int getUnsignedInt16(ByteBuffer r1) {
        return r1.getShort() & UShort.MAX_VALUE;
    }

    static long getUnsignedInt32(ByteBuffer r4) {
        return ((long) r4.getInt()) & 4294967295L;
    }

    private static Pair<ByteBuffer, Long> findZipEndOfCentralDirectoryRecord(DataSource r8, int r9) throws IOException {
        if (r9 < 0) goto L14;
        if (r9 > 65535) goto L14;
        long r0 = r8.size();
        if (r0 >= 22) goto L8;
        return null;
    L8:
        int r10 = ((int) Math.min(r9, r0 - 22)) + 22;
        long r1 = r0 - ((long) r10);
        ByteBuffer r11 = r8.getByteBuffer(r1, r10);
        ByteOrder r12 = ByteOrder.LITTLE_ENDIAN;
        r11.order(r12);
        int r2 = findZipEndOfCentralDirectoryRecord(r11);
        if (r2 != (-1)) goto L11;
        return null;
    L11:
        r11.position(r2);
        ByteBuffer r13 = r11.slice();
        r13.order(r12);
        return Pair.of(r13, Long.valueOf(r1 + ((long) r2)));
    L14:
        throw new IllegalArgumentException("maxCommentSize: " + r9);
    }

    private static int findZipEndOfCentralDirectoryRecord(ByteBuffer r7) {
        assertByteOrderLittleEndian(r7);
        int r0 = r7.capacity();
        if (r0 >= 22) goto L5;
        return -1;
    L5:
        int r1 = r0 - 22;
        int r2 = Math.min(r1, 65535);
        int r3 = 0;
    L6:
        if (r3 > r2) goto L13;
        int r4 = r1 - r3;
        if (r7.getInt(r4) != ZIP_EOCD_REC_SIG) goto L12;
        if (getUnsignedInt16(r7, r4 + 20) != r3) goto L12;
        return r4;
    L12:
        r3 = r3 + 1;
        goto L6
    L13:
        return -1;
    }
}

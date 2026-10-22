package okio;

import java.nio.charset.Charset;
import kotlin.UShort;

/* JADX INFO: loaded from: classes5.dex */
final class Util {
    public static final Charset UTF_8 = null;

    public static int reverseBytesInt(int r2) {
        int r0 = ((((-16777216) & r2) >>> 24) | ((16711680 & r2) >>> 8)) | ((65280 & r2) << 8);
        return ((r2 & 255) << 24) | r0;
    }

    public static long reverseBytesLong(long r8) {
        long r0 = ((((((((-72057594037927936L) & r8) >>> 56) | ((71776119061217280L & r8) >>> 40)) | ((280375465082880L & r8) >>> 24)) | ((1095216660480L & r8) >>> 8)) | ((4278190080L & r8) << 8)) | ((16711680 & r8) << 24)) | ((65280 & r8) << 40);
        return ((r8 & 255) << 56) | r0;
    }

    public static short reverseBytesShort(short r1) {
        int r2 = r1 & UShort.MAX_VALUE;
        int r0 = (65280 & r2) >>> 8;
        return (short) (((r2 & 255) << 8) | r0);
    }

    static {
        UTF_8 = Charset.forName("UTF-8");
    }

    private Util() {
    }

    public static void checkOffsetAndCount(long r4, long r6, long r8) {
        if ((r6 | r8) < 0) goto L10;
        if (r6 > r4) goto L10;
        if ((r4 - r6) < r8) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(r4), Long.valueOf(r6), Long.valueOf(r8)}));
    }

    public static void sneakyRethrow(Throwable r0) {
        sneakyThrow2(r0);
    }

    private static <T extends Throwable> void sneakyThrow2(Throwable r0) throws Throwable {
        throw r0;
    }

    public static boolean arrayRangeEquals(byte[] r4, int r5, byte[] r6, int r7, int r8) {
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L8;
        if (r4[r1 + r5] != r6[r1 + r7]) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }
}

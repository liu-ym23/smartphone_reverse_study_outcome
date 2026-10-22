package d.b.q;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static void a(ByteBuffer r1) {
        if (r1.order() != ByteOrder.LITTLE_ENDIAN) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    public static b<ByteBuffer, Long> b(FileChannel r2) {
        return c(r2, d(r2));
    }

    public static b<ByteBuffer, Long> c(FileChannel r7, long r8) {
        if (r8 < 32) goto L27;
        r7.position(r8 - 24);
        ByteBuffer r0 = ByteBuffer.allocate(24);
        r7.read(r0);
        ByteOrder r1 = ByteOrder.LITTLE_ENDIAN;
        r0.order(r1);
        if (r0.getLong(8) != 2334950737559900225L) goto L25;
        if (r0.getLong(16) != 3617552046287187010L) goto L25;
        long r3 = r0.getLong(0);
        if (r3 < r0.capacity()) goto L23;
        if (r3 > 2147483639) goto L23;
        int r2 = (int) (8 + r3);
        long r9 = r8 - ((long) r2);
        if (r9 < 0) goto L21;
        r7.position(r9);
        ByteBuffer r4 = ByteBuffer.allocate(r2);
        r7.read(r4);
        r4.order(r1);
        long r5 = r4.getLong(0);
        if (r5 != r3) goto L19;
        return b.b(r4, Long.valueOf(r9));
    L19:
        throw new e("APK Signing Block sizes in header and footer do not match: " + r5 + " vs " + r3);
    L21:
        throw new e("APK Signing Block offset out of range: " + r9);
    L23:
        throw new e("APK Signing Block size out of range: " + r3);
    L25:
        throw new e("No APK Signing Block before ZIP Central Directory");
    L27:
        throw new e("APK too small for APK Signing Block. ZIP Central Directory offset: " + r8);
    }

    public static long d(FileChannel r2) {
        return e(r2, h(r2));
    }

    public static long e(FileChannel r3, long r4) {
        ByteBuffer r0 = ByteBuffer.allocate(4);
        r0.order(ByteOrder.LITTLE_ENDIAN);
        r3.position((r3.size() - r4) - 6);
        r3.read(r0);
        return r0.getInt(0);
    }

    public static Map<Integer, ByteBuffer> f(ByteBuffer r10) {
        a(r10);
        ByteBuffer r11 = i(r10, 8, r10.capacity() - 24);
        LinkedHashMap r0 = new LinkedHashMap();
        int r2 = 0;
    L4:
        if (r11.hasRemaining() == false) goto L20;
        r2 = r2 + 1;
        if (r11.remaining() < 8) goto L19;
        long r3 = r11.getLong();
        if (r3 < 4) goto L17;
        if (r3 > 2147483647L) goto L17;
        int r4 = (int) r3;
        int r5 = r11.position() + r4;
        if (r4 > r11.remaining()) goto L15;
        r0.put(Integer.valueOf(r11.getInt()), g(r11, r4 - 4));
        r11.position(r5);
        goto L4
    L15:
        throw new e("APK Signing Block entry #" + r2 + " size out of range: " + r4 + ", available: " + r11.remaining());
    L17:
        throw new e("APK Signing Block entry #" + r2 + " size out of range: " + r3);
    L19:
        throw new e("Insufficient data to read size of APK Signing Block entry #" + r2);
    L20:
        return r0;
    }

    private static ByteBuffer g(ByteBuffer r3, int r4) {
        if (r4 < 0) goto L16;
        int r0 = r3.limit();
        int r1 = r3.position();
        int r5 = r4 + r1;
        if (r5 < r1) goto L14;
        if (r5 > r0) goto L14;
        r3.limit(r5);
        ByteBuffer r2 = r3.slice();     // Catch: Throwable -> L10
        r2.order(r3.order());     // Catch: Throwable -> L10
        r3.position(r5);     // Catch: Throwable -> L10
        r3.limit(r0);
        return r2;
    L10:
        th = move-exception;
        r3.limit(r0);
        throw th;
    L14:
        throw new BufferUnderflowException();
    L16:
        throw new IllegalArgumentException("size: " + r4);
    }

    public static long h(FileChannel r12) {
        long r0 = r12.size();
        if (r0 < 22) goto L17;
        long r1 = r0 - 22;
        long r2 = Math.min(r1, 65535);
        int r5 = 0;
    L5:
        long r6 = r5;
        if (r6 > r2) goto L15;
        long r7 = r1 - r6;
        ByteBuffer r8 = ByteBuffer.allocate(4);
        r12.position(r7);
        r12.read(r8);
        ByteOrder r9 = ByteOrder.LITTLE_ENDIAN;
        r8.order(r9);
        if (r8.getInt(0) != 101010256) goto L13;
        ByteBuffer r10 = ByteBuffer.allocate(2);
        r12.position(r7 + 20);
        r12.read(r10);
        r10.order(r9);
        short r11 = r10.getShort(0);
        if (r11 != r5) goto L13;
        return r11;
    L13:
        r5 = r5 + 1;
        goto L5
    L15:
        throw new IOException("ZIP End of Central Directory (EOCD) record not found");
    L17:
        throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
    }

    private static ByteBuffer i(ByteBuffer r3, int r4, int r5) {
        if (r4 < 0) goto L18;
        if (r5 < r4) goto L16;
        int r0 = r3.capacity();
        if (r5 > r3.capacity()) goto L14;
        int r1 = r3.limit();
        int r2 = r3.position();
        r3.position(0);     // Catch: Throwable -> L10
        r3.limit(r5);     // Catch: Throwable -> L10
        r3.position(r4);     // Catch: Throwable -> L10
        ByteBuffer r6 = r3.slice();     // Catch: Throwable -> L10
        r6.order(r3.order());     // Catch: Throwable -> L10
        r3.position(0);
        r3.limit(r1);
        r3.position(r2);
        return r6;
    L10:
        th = move-exception;
        r3.position(0);
        r3.limit(r1);
        r3.position(r2);
        throw th;
    L14:
        throw new IllegalArgumentException("end > capacity: " + r5 + " > " + r0);
    L16:
        throw new IllegalArgumentException("end < start: " + r5 + " < " + r4);
    L18:
        throw new IllegalArgumentException("start: " + r4);
    }
}

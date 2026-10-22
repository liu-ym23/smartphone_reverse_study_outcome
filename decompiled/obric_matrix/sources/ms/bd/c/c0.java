package ms.bd.c;

import android.text.TextUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    static final class a<A, B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final A f22322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final B f22323b;

        private a(A r1, B r2) {
            this.f22322a = r1;
            this.f22323b = r2;
        }

        public static <A, B> a<A, B> b(A r1, B r2) {
            return new a(r1, r2);
        }

        public A a() {
            return this.f22322a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (a.class == r5.getClass()) goto L11;
            return false;
        L11:
            a r6 = (a) r5;
            A r2 = this.f22322a;
            if (r2 != null) goto L17;
            if (r6.f22322a == null) goto L19;
            return false;
        L19:
            B r4 = this.f22323b;
            if (r4 != null) goto L27;
            if (r6.f22323b != null) goto L25;
            return true;
        L25:
            return false;
        L27:
            return r4.equals(r6.f22323b);
        L17:
            if (r2.equals(r6.f22322a) == true) goto L19;
            return false;
        }

        public int hashCode() {
            A r0 = this.f22322a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r2 + 31) * 31;
            B r4 = this.f22323b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }
    }

    public static class b extends Exception {
        public b(String r1) {
            super(r1);
        }
    }

    public static String a(JSONObject r7) {
        return r7.getString((String) m.a(16777217, 0, 0, "c5641f", new byte[]{127, 50, 81, 65, 49, 100, 109, 17, 105, 99, 77, 52, 77, 65, 0, 127, 101, 24}));
    L5:
        return "";
    }

    public static Map<Integer, String> b(String r11) {
        RandomAccessFile r1 = null;
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return null;
    L5:
        HashMap r0 = new HashMap();
        RandomAccessFile r2 = new RandomAccessFile(r11, (String) m.a(16777217, 0, 0, "377046", new byte[]{48}));     // Catch: Throwable -> L33
        a<ByteBuffer, Long> r12 = d(r2.getChannel());     // Catch: Throwable -> L26
        if (r12 == null) goto L40;
        Iterator r13 = ((LinkedHashMap) c(r12.a())).entrySet().iterator();     // Catch: Throwable -> L26
    L13:
        if (r13.hasNext() == false) goto L40;
        Map.Entry r3 = (Map.Entry) r13.next();     // Catch: Throwable -> L26
        if (r3 == null) goto L13;
        if (r3.getKey() == null) goto L13;
        if (((Integer) r3.getKey()).intValue() == 1896449818) goto L13;
        ByteBuffer r4 = (ByteBuffer) r3.getValue();     // Catch: Throwable -> L31
        byte[] r5 = r4.array();     // Catch: Throwable -> L31
        int r6 = r4.arrayOffset();     // Catch: Throwable -> L31
        r0.put(r3.getKey(), new String(Arrays.copyOfRange(r5, r4.position() + r6, r6 + r4.limit())));     // Catch: Throwable -> L31
    L40:
        r2.close();     // Catch: Throwable -> L32
    L30:
        return r0;
    L26:
        r1 = r2;
    L27:
        if (r1 == null) goto L30;
        r2 = r1;
        goto L40
    }

    public static Map<Integer, ByteBuffer> c(ByteBuffer r12) {
        if (r12.order() != ByteOrder.LITTLE_ENDIAN) goto L51;
        int r0 = r12.capacity() - 24;
        if (r0 < 8) goto L49;
        r12.capacity();
        if (r0 > r12.capacity()) goto L47;
        int r1 = r12.limit();
        int r5 = r12.position();
        r12.position(0);     // Catch: Throwable -> L43
        r12.limit(r0);     // Catch: Throwable -> L43
        r12.position(8);     // Catch: Throwable -> L43
        ByteBuffer r2 = r12.slice();     // Catch: Throwable -> L43
        r2.order(r12.order());     // Catch: Throwable -> L43
        r12.position(0);
        r12.limit(r1);
        r12.position(r5);
        LinkedHashMap r13 = new LinkedHashMap();
    L12:
        if (r2.hasRemaining() == false) goto L42;
        if (r2.remaining() < 8) goto L41;
        long r6 = r2.getLong();
        if (r6 < 4) goto L39;
        if (r6 > 2147483647L) goto L39;
        int r3 = (int) r6;
        int r7 = r2.position() + r3;
        if (r3 > r2.remaining()) goto L37;
        Integer r8 = Integer.valueOf(r2.getInt());
        int r4 = r3 - 4;
        if (r4 < 0) goto L35;
        int r9 = r2.limit();
        int r10 = r2.position();
        int r11 = r4 + r10;
        if (r11 < r10) goto L33;
        if (r11 > r9) goto L33;
        r2.limit(r11);
        ByteBuffer r14 = r2.slice();     // Catch: Throwable -> L29
        r14.order(r2.order());     // Catch: Throwable -> L29
        r2.position(r11);     // Catch: Throwable -> L29
        r2.limit(r9);
        r13.put(r8, r14);
        r2.position(r7);
    L29:
        th = move-exception;
        r2.limit(r9);
        throw th;
    L33:
        throw new BufferUnderflowException();
    L35:
        throw new IllegalArgumentException((String) m.a(16777217, 0, 0, "7f537e", new byte[]{116}));
    L37:
        throw new b((String) m.a(16777217, 0, 0, "0fe27c", new byte[]{121}));
    L39:
        throw new b((String) m.a(16777217, 0, 0, "f5c56d", new byte[]{32}));
    L41:
        throw new b((String) m.a(16777217, 0, 0, "338a56", new byte[]{116}));
    L42:
        return r13;
    L43:
        th = move-exception;
        r12.position(0);
        r12.limit(r1);
        r12.position(r5);
        throw th;
    L47:
        throw new IllegalArgumentException((String) m.a(16777217, 0, 0, "529c0a", new byte[]{113}));
    L49:
        throw new IllegalArgumentException((String) m.a(16777217, 0, 0, "48557d", new byte[]{113}));
    L51:
        throw new IllegalArgumentException((String) m.a(16777217, 0, 0, "0fd06d", new byte[]{112}));
    }

    public static a<ByteBuffer, Long> d(FileChannel r14) {
        long r0 = r14.size();
        if (r0 < 22) goto L38;
        long r1 = r0 - 22;
        long r2 = Math.min(r1, 65535);
        int r6 = 0;
    L5:
        long r7 = r6;
        if (r7 > r2) goto L36;
        long r8 = r1 - r7;
        ByteBuffer r10 = ByteBuffer.allocate(4);
        r14.position(r8);
        r14.read(r10);
        ByteOrder r11 = ByteOrder.LITTLE_ENDIAN;
        r10.order(r11);
        if (r10.getInt(0) != 101010256) goto L34;
        ByteBuffer r12 = ByteBuffer.allocate(2);
        r14.position(r8 + 20);
        r14.read(r12);
        r12.order(r11);
        short r9 = r12.getShort(0);
        if (r9 != r6) goto L34;
        ByteBuffer r3 = ByteBuffer.allocate(4);
        r3.order(r11);
        r14.position((r14.size() - ((long) r9)) - 6);
        r14.read(r3);
        long r4 = r3.getInt(0);
        if (r4 < 32) goto L33;
        r14.position(r4 - 24);
        ByteBuffer r5 = ByteBuffer.allocate(24);
        r14.read(r5);
        r5.order(r11);
        if (r5.getLong(8) == 2334950737559900225L) goto L16;
    L30:
        return null;
    L16:
        if (r5.getLong(16) != 3617552046287187010L) goto L30;
        long r13 = r5.getLong(0);
        if (r13 < r5.capacity()) goto L30;
        if (r13 > 2147483639) goto L30;
        int r15 = (int) (8 + r13);
        long r16 = r4 - ((long) r15);
        if (r16 < 0) goto L30;
        r14.position(r16);
        ByteBuffer r17 = ByteBuffer.allocate(r15);
        r14.read(r17);
        r17.order(r11);
        if (r17.getLong(0) != r13) goto L30;
        return a.b(r17, Long.valueOf(r16));
    L33:
        throw new b((String) m.a(16777217, 0, 0, "e42d5a", new byte[]{45}));
    L34:
        r6 = r6 + 1;
        goto L5
    L36:
        throw new IOException((String) m.a(16777217, 0, 0, "a7db1f", new byte[]{33, 101}));
    L38:
        throw new IOException((String) m.a(16777217, 0, 0, "520321", new byte[]{117, 97}));
    }

    public static boolean e() {
        return f(new String[]{(String) m.a(16777217, 0, 0, "fa0cf6", new byte[]{116, 108, 78, 89, 91, 56, 113, 69, 101, 50, 121, 96, 70, 89, 95, 51, 100, 77, 118, 60, 101, 104, 13, 20, 86, 51, 96, 14, 114, 55, 124, 110, 76, 25, 80, 53, 106, 82, 47, 0, 83, 72, 110, 24, 87, 40, 113, 79, 115, 6, 99, 106, 79, 4})});
    }

    private static boolean f(String... r6) {
        int r0 = r6.length;
        int r3 = 0;
        boolean r4 = true;
    L3:
        if (r3 >= r0) goto L12;
        Class.forName(r6[r3]);     // Catch: Throwable -> L7
        boolean r5 = true;
    L8:
        r4 = r4 & r5;
        if (r4 == false) goto L12;
        r3 = r3 + 1;
    L7:
        r5 = false;
    L12:
        return r4;
    }

    public static String g(JSONObject r7) {
        return r7.getString((String) m.a(16777217, 0, 0, "299600", new byte[]{49, 62, 70, 71, 14, 52, 52, 39, 106, 115, 42, 55, 78}));
    L5:
        return "";
    }

    public static boolean h() {
        return f(new String[]{(String) m.a(16777217, 0, 0, "8dc304", new byte[]{42, 105, 29, 9, 13, 58, 47, 64, 54, 98, 39, 101, 21, 9, 27, 55, 53, 64, 38, 45, 29, 82, 62, 66, 27, 10, 53, 76, 38})});
    }
}

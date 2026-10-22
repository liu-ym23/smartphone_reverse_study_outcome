package d.b.h.a.a.h.p;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import d.b.h.a.a.h.g;
import d.b.h.a.a.h.h;
import d.b.r.y;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import k.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f13706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f13707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, Integer> f13708c = null;

    static {
        f13708c = new ConcurrentHashMap();
    }

    public static void a(byte[] r4, int r5) {
        if (r4 == null) goto L8;
        if (r5 <= 0) goto L10;
        byte[] r0 = {-99, -114, 127, 90};
        int r1 = 0;
    L6:
        if (r1 >= r5) goto L11;
        r4[r1] = (byte) (r4[r1] ^ r0[r1 % 4]);
        r1 = r1 + 1;
        goto L6
    L11:
        return;
    L10:
        return;
    }

    private static int b(int r1) {
        if (r1 > 0) goto L6;
        return 5242880;
    L6:
        if (r1 >= 1048576) goto L8;
        return 1048576;
    L8:
        return r1;
    }

    private static boolean c(int r1) {
        if (r1 >= 4096) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 5242880) goto L7;
        return true;
    }

    public static void d(SharedPreferences r2) {
        f13706a = r2.getInt("read_response_buff_init_size", 0);
        f13707b = r2.getInt("read_response_buff_increase_size", 0);
    }

    public static void e(SharedPreferences.Editor r2) {
        r2.putInt("read_response_buff_init_size", f13706a);
        r2.putInt("read_response_buff_increase_size", f13707b);
    }

    public static void f(JSONObject r4) {
        f13706a = r4.optInt("read_response_buff_init_size", 0);
        f13707b = r4.optInt("read_response_buff_increase_size", 0);
        JSONObject r5 = r4.optJSONObject("specific_init_size");
        if (r5 == null) goto L17;
        f13708c.clear();
        Iterator<String> r0 = r5.keys();
    L6:
        if (r0.hasNext() == false) goto L10;
        String r1 = r0.next();
        int r2 = r5.optInt(r1);
        if (r2 < 4096) goto L6;
        f13708c.put(r1, Integer.valueOf(r2));
        goto L6
    L10:
        Logger.debug();
        return;
    }

    public static InputStream g(InputStream r0, Map<String, List<String>> r1, boolean r2, y r3) {
        if (r2 == true) goto L4;
        g.r r4 = g.q();
        if (r4 != null) goto L9;
        return r0;
    L9:
        return r4.a(r0, r1, r3);
    L4:
        return new GZIPInputStream(r0);
    }

    public static byte[] h(boolean r10, Map<String, List<String>> r11, int r12, InputStream r13, int[] r14, y r15) {
        int r16 = b(r12);
        if (r13 != null) goto L70;
        return null;
    L70:
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L67
        r13 = g(r13, r11, r10, r15);     // Catch: Throwable -> L67
        int r17 = 32768;
        if (c(f13706a) == false) goto L8;
        r17 = f13706a;     // Catch: Throwable -> L67
    L8:
        int r3 = 102400;
        if (c(f13707b) == false) goto L11;
        r3 = f13707b;     // Catch: Throwable -> L67
    L11:
        if (r15 == null) goto L20;
        URL r4 = r15.f14614a;     // Catch: Throwable -> L67
        if (r4 == null) goto L20;
        if (TextUtils.isEmpty(r4.getPath()) == true) goto L20;
        Integer r5 = f13708c.get(r15.f14614a.getPath());     // Catch: Throwable -> L67
        if (r5 == null) goto L20;
        r17 = r5.intValue();     // Catch: Throwable -> L67
    L20:
        if (Logger.debug() == false) goto L23;
        if (r15 == null) goto L23;
        URL r6 = r15.f14614a;     // Catch: Throwable -> L67
    L23:
        byte[] r18 = new byte[r17];     // Catch: Throwable -> L67
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L71:
    L52:
        e = move-exception;
        if (r10 == false) goto L66;
        if (r7 <= 0) goto L66;
    L55:
        if (r7 <= 0) goto L64;
        if (r15 == null) goto L58;
        r15.j0.put("streamReadTime", Long.valueOf(System.currentTimeMillis() - r1));     // Catch: Throwable -> L67
        r15.j0.put("streamReadByteCount", Long.valueOf(r7));     // Catch: Throwable -> L67
        r15.y0 = r9;     // Catch: Throwable -> L67
        r15.f14615b = r8;     // Catch: Throwable -> L67
        r15.f14616c = 0;     // Catch: Throwable -> L67
    L58:
        r14[0] = r7;     // Catch: Throwable -> L67
        if (Logger.debug() == false) goto L62;
        if (r15 == null) goto L62;
        URL r19 = r15.f14614a;     // Catch: Throwable -> L67
    L62:
        l(r13);
        return r18;
    L64:
        l(r13);
        return null;
    L66:
        throw e;     // Catch: Throwable -> L67
    L42:
        e = move-exception;
        String r20 = e.getMessage();     // Catch: Throwable -> L67
        if (r10 == false) goto L51;
        if (r7 <= 0) goto L51;
        if ("CRC mismatch".equals(r20) == true) goto L55;
        if ("Size mismatch".equals(r20) == true) goto L55;
    L51:
        throw e;     // Catch: Throwable -> L67
    L40:
        l(r13);
        return null;
    L27:
        if ((r7 + 4096) > r18.length) goto L29;
    L33:
        int r21 = r13.read(r18, r7, r18.length - r7);     // Catch: OutOfMemoryError -> L40 IOException -> L42 EOFException -> L52 Throwable -> L67
        r9 = r9 + 1;     // Catch: OutOfMemoryError -> L40 IOException -> L42 EOFException -> L52 Throwable -> L67
        if (r21 <= 0) goto L55;
        r7 = r7 + r21;     // Catch: OutOfMemoryError -> L40 IOException -> L42 EOFException -> L52 Throwable -> L67
        if (r7 <= r16) goto L71;
        throw new d.b.h.a.a.h.s.d(r16, r7);     // Catch: OutOfMemoryError -> L40 IOException -> L42 EOFException -> L52 Throwable -> L67
    L29:
        if (r18.length >= r3) goto L31;
        int r22 = r18.length + r3;     // Catch: OutOfMemoryError -> L40 IOException -> L42 EOFException -> L52 Throwable -> L67
    L32:
        byte[] r23 = new byte[r22];     // Catch: OutOfMemoryError -> L40 IOException -> L42 EOFException -> L52 Throwable -> L67
        System.arraycopy(r18, 0, r23, 0, r7);     // Catch: OutOfMemoryError -> L40 IOException -> L42 EOFException -> L52 Throwable -> L67
        r8 = r8 + 1;     // Catch: OutOfMemoryError -> L40 IOException -> L42 EOFException -> L52 Throwable -> L67
        r18 = r23;
        goto L33
    L31:
        r22 = r18.length * 2;     // Catch: OutOfMemoryError -> L40 IOException -> L42 EOFException -> L52 Throwable -> L67
    L67:
        th = move-exception;
        l(r13);
        throw th;
    }

    public static byte[] i(boolean r9, Map<String, List<String>> r10, int r11, InputStream r12, y r13) {
        if (r12 != null) goto L5;
        return null;
    L5:
        long r0 = System.currentTimeMillis();
        k.e r2 = new k.e();
        InputStream r14 = g(r12, r10, r9, r13);
        int r15 = b(r11);
        k.g r16 = q.b(q.j(r14));     // Catch: Throwable -> L29 Exception -> L31
    L36:
    L22:
        th = move-exception;
        if (r16 != null) goto L37;
    L28:
        throw th;     // Catch: Throwable -> L29 Exception -> L31
    L37:
        r16.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L29 Exception -> L31
        goto L28
    L8:
        if (r16.v() == true) goto L16;
        long r3 = r15;
        if (r16.Z(r2, r3 - r2.k0()) == (-1)) goto L15;
        if (r2.k0() <= r3) goto L36;
    L15:
        throw new d.b.h.a.a.h.s.d(r15, r2.k0());     // Catch: Throwable -> L22
    L16:
        if (r13 == null) goto L18;
        r13.j0.put("streamReadTime", Long.valueOf(System.currentTimeMillis() - r0));     // Catch: Throwable -> L22
        r13.j0.put("streamReadByteCount", Long.valueOf(r2.k0()));     // Catch: Throwable -> L22
        r13.f14616c = 1;     // Catch: Throwable -> L22
    L18:
        if (r16 == null) goto L20;
        r16.close();     // Catch: Throwable -> L29 Exception -> L31
    L20:
        l(r14);
        return r2.t();
    L29:
        th = move-exception;
        l(r14);
        throw th;
    L31:
        e = move-exception;
        throw e;     // Catch: Throwable -> L29
    }

    public static byte[] j(boolean r5, Map<String, List<String>> r6, int r7, InputStream r8, y r9) {
        if (Logger.debug() == false) goto L7;
        if (r9 == null) goto L7;
        URL r10 = r9.f14614a;
    L7:
        if (r8 != null) goto L9;
        return null;
    L9:
        long r0 = System.currentTimeMillis();
        InputStream r11 = g(r8, r6, r5, r9);
        r11.read(new byte[0]);     // Catch: Throwable -> L15 Exception -> L17
        int r12 = r11.available();     // Catch: Throwable -> L15 Exception -> L17
        Logger.debug();     // Catch: Throwable -> L15 Exception -> L17
        byte[] r13 = new byte[r12];     // Catch: Throwable -> L15 Exception -> L17
        r11.read(r13);     // Catch: Throwable -> L15 Exception -> L17
        if (r9 == null) goto L13;
        r9.j0.put("streamReadTime", Long.valueOf(System.currentTimeMillis() - r0));     // Catch: Throwable -> L15 Exception -> L17
        r9.f14616c = 2;     // Catch: Throwable -> L15 Exception -> L17
        r9.j0.put("streamReadByteCount", Long.valueOf(r12));     // Catch: Throwable -> L15 Exception -> L17
    L13:
        l(r11);
        return r13;
    L17:
        e = move-exception;
        throw e;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        l(r11);
        throw th;
    }

    public static byte[] k(boolean r7, Map<String, List<String>> r8, int r9, InputStream r10, int[] r11, h r12) {
        if (r10 != null) goto L18;
        return null;
    L18:
        byte[] r13 = h(r7, r8, r9, r10, r11, null);     // Catch: Exception -> L13
        if (r13 != null) goto L9;
    L12:
        return null;
    L9:
        if (r11[0] <= 0) goto L12;
        return r13;
    L13:
        e = move-exception;
        if (r12 != null) goto L20;
    L16:
        throw e;
    L20:
        r12.a();     // Catch: Throwable -> L17
        goto L16
    }

    public static void l(Closeable r1) {
        m(r1, null);
    }

    private static void m(Closeable r0, String r1) {
        if (r0 == null) goto L9;
        r0.close();     // Catch: Exception -> L5
        return;
    L5:
        Logger.debug();
        return;
    }

    public static boolean n(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        int r1 = r3.indexOf("application/octet-stream");
        if (r1 < 0) goto L8;
        r1 = r3.indexOf("ssmix=", r1 + 24);
    L8:
        if (r1 <= 0) goto L11;
        return true;
    L11:
        return false;
    }
}

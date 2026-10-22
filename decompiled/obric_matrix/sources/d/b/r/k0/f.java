package d.b.r.k0;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f14435a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f14436b = 1048576;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f14437c = 100;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f14438d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f14439e = 6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static d f14440f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f14441g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static CopyOnWriteArraySet<String> f14442h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static CopyOnWriteArraySet<String> f14443i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static CopyOnWriteArraySet<Pattern> f14444j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static CopyOnWriteArraySet<String> f14445k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static CopyOnWriteArraySet<String> f14446l;
    private static CopyOnWriteArraySet<Pattern> m;
    private static CopyOnWriteArraySet<String> n;
    private static CopyOnWriteArraySet<String> o;
    private static CopyOnWriteArraySet<Pattern> p;
    public static volatile c q;
    public static volatile Boolean r;
    private static final char[] s = null;
    private static a t;

    public interface a {
        byte[] compress(byte[] r1, int r2);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f14447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f14448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14449c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f14450d;

        b(int r1) {
            this.f14449c = r1;
        }
    }

    public interface c {
        byte[] compressData(byte[] r1, int r2, int r3, int r4);
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f14451g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f14452h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final d f14453i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final d f14454j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ d[] f14455k = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f14456f;

        static {
            d r0 = new d("NONE", 0, 0);
            f14451g = r0;
            d r1 = new d("GZIP", 1, 1);
            f14452h = r1;
            d r3 = new d("BROTLI", 2, 2);
            f14453i = r3;
            d r5 = new d("ZSTD", 3, 3);
            f14454j = r5;
            f14455k = new d[]{r0, r1, r3, r5};
        }

        private d(String r1, int r2, int r3) {
            super(r1, r2);
            this.f14456f = r3;
        }

        public static d valueOf(String r1) {
            return (d) Enum.valueOf(d.class, r1);
        }

        public static d[] values() {
            return (d[]) f14455k.clone();
        }

        public int a() {
            return this.f14456f;
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final e f14457g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final e f14458h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final e f14459i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final e f14460j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final e f14461k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final e f14462l = null;
        public static final e m = null;
        public static final e n = null;
        public static final e o = null;
        public static final e p = null;
        public static final e q = null;
        private static final /* synthetic */ e[] r = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f14463f;

        static {
            e r0 = new e("NONE", 0, 0);
            f14457g = r0;
            e r1 = new e("GLOBAL_DISABLE", 1, 1);
            f14458h = r1;
            e r3 = new e("TNC_DISABLE", 2, 2);
            f14459i = r3;
            e r5 = new e("URL_MISMATCH", 3, 3);
            f14460j = r5;
            e r7 = new e("BODY_SIZE_MISMATCH", 4, 4);
            f14461k = r7;
            e r9 = new e("BODY_SIZE_OVERFLOW", 5, 5);
            f14462l = r9;
            e r11 = new e("ZSTD_PREFIX_MISMATCH", 6, 6);
            m = r11;
            e r13 = new e("GZIP_PREFIX_MISMATCH", 7, 7);
            n = r13;
            e r15 = new e("BODY_ENCRYPTED", 8, 8);
            o = r15;
            e r14 = new e("REMOVE_ENCODING", 9, 9);
            p = r14;
            e r12 = new e("DATA_NULL", 10, 10);
            q = r12;
            r = new e[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        }

        private e(String r1, int r2, int r3) {
            super(r1, r2);
            this.f14463f = r3;
        }

        public static e valueOf(String r1) {
            return (e) Enum.valueOf(e.class, r1);
        }

        public static e[] values() {
            return (e[]) r.clone();
        }

        public int a() {
            return this.f14463f;
        }
    }

    static {
        f14440f = d.f14451g;
        f14442h = new CopyOnWriteArraySet();
        f14443i = new CopyOnWriteArraySet();
        f14444j = new CopyOnWriteArraySet();
        f14445k = new CopyOnWriteArraySet();
        f14446l = new CopyOnWriteArraySet();
        m = new CopyOnWriteArraySet();
        n = new CopyOnWriteArraySet();
        o = new CopyOnWriteArraySet();
        p = new CopyOnWriteArraySet();
        r = Boolean.FALSE;
        s = "0123456789ABCDEF".toCharArray();
    }

    public static byte[] a(byte[] r2, int r3, int r4) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (q != null) goto L8;
        return null;
    L8:
        return q.compressData(r2, r3, r4, d.f14453i.a());
    }

    private static String b(byte[] r6) {
        char[] r0 = new char[r6.length * 2];
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L7;
        int r2 = r6[r1] & 255;
        int r3 = r1 * 2;
        char[] r4 = s;
        r0[r3] = r4[r2 >>> 4];
        r0[r3 + 1] = r4[r2 & 15];
        r1 = r1 + 1;
        goto L4
    L7:
        return new String(r0);
    }

    public static boolean c(int r5, byte[] r6, d r7, b r8) {
        if (r6 != null) goto L5;
    L37:
        return false;
    L5:
        if (r6.length <= 3) goto L37;
        if (f14441g == true) goto L11;
        return true;
    L11:
        if (r6.length < r5) goto L15;
        r8.f14449c = e.f14462l.a();
        return false;
    L15:
        if (r7 != d.f14452h) goto L26;
        byte r9 = r6[0];
        byte r10 = r6[1];
        byte r11 = r6[2];
        if (r9 == 31) goto L19;
    L23:
        r8.f14449c = e.n.a();
        r8.f14450d = b(new byte[]{r9, r10, r11});
        return false;
    L19:
        if (r10 != (-117)) goto L23;
        if (r11 != 8) goto L23;
        return true;
    L26:
        if (r7 != d.f14454j) goto L36;
        byte r12 = r6[0];
        byte r13 = r6[1];
        byte r14 = r6[2];
        if (r12 == 40) goto L30;
    L34:
        r8.f14449c = e.m.a();
        r8.f14450d = b(new byte[]{r12, r13, r14});
        return false;
    L30:
        if (r13 != (-75)) goto L34;
        if (r14 != 47) goto L34;
        return true;
    L36:
        return true;
    }

    public static b d(byte[] r3, int r4, String r5, String r6, boolean r7) {
        b r0 = new b(0);
        if (r.booleanValue() == false) goto L7;
        Logger.debug();
        r0.f14449c = e.f14458h.a();
        return r0;
    L7:
        if (f14435a == false) goto L46;
        d r1 = f14440f;
        d r2 = d.f14451g;
        if (r1 == r2) goto L46;
        d r8 = f(r5, r6);
        if (r7 == true) goto L17;
        if (r8 != r2) goto L17;
        Logger.debug();
        r0.f14449c = e.f14460j.a();
        return r0;
    L17:
        if (r4 <= f14436b) goto L19;
    L44:
        Logger.debug();
        r0.f14449c = e.f14461k.a();
        return r0;
    L19:
        if (r4 < f14437c) goto L44;
        if (r8 != d.f14452h) goto L29;
        byte[] r9 = g(r3, r4);
        if (c(r4, r9, r8, r0) == true) goto L26;
        return r0;
    L26:
        r0.f14447a = r9;
        r0.f14448b = "gzip";
        return r0;
    L29:
        if (r8 != d.f14453i) goto L36;
        byte[] r10 = a(r3, r4, f14438d);
        if (c(r4, r10, r8, r0) == true) goto L33;
        return r0;
    L33:
        r0.f14447a = r10;
        r0.f14448b = "br";
        return r0;
    L36:
        if (r8 != d.f14454j) goto L42;
        byte[] r11 = r(r3, f14439e);
        if (c(r4, r11, r8, r0) == true) goto L40;
        return r0;
    L40:
        r0.f14447a = r11;
        r0.f14448b = "zstd";
        return r0;
    L42:
        return null;
    L46:
        Logger.debug();
        r0.f14449c = e.f14459i.a();
        return r0;
    }

    private static void e(int r1) {
        if (r1 != 1) goto L5;
        d r2 = d.f14452h;
    L12:
        f14440f = r2;
        return;
    L5:
        if (r1 != 2) goto L7;
        r2 = d.f14453i;
        goto L12
    L7:
        if (r1 == 3) goto L9;
        r2 = d.f14451g;
        goto L12
    L9:
        r2 = d.f14454j;
        goto L12
    }

    private static d f(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == true) goto L86;
        if (TextUtils.isEmpty(r3) == true) goto L86;
        if (i(f14445k) == true) goto L14;
        if (f14445k.contains(r3) == false) goto L14;
        return d.f14454j;
    L14:
        if (i(f14446l) == true) goto L23;
        Iterator<String> r0 = f14446l.iterator();
    L17:
        if (r0.hasNext() == false) goto L23;
        if (r3.startsWith(r0.next()) == false) goto L17;
        return d.f14454j;
    L23:
        if (i(m) == true) goto L34;
        Iterator<Pattern> r1 = m.iterator();
    L26:
        if (r1.hasNext() == false) goto L34;
        Pattern r4 = r1.next();
        if (r4 == null) goto L26;
        if (r4.matcher(r3).matches() == false) goto L26;
        return d.f14454j;
    L34:
        if (i(f14442h) == true) goto L40;
        if (f14442h.contains(r3) == false) goto L40;
        return f14440f;
    L40:
        if (i(f14443i) == true) goto L49;
        Iterator<String> r5 = f14443i.iterator();
    L43:
        if (r5.hasNext() == false) goto L49;
        if (r3.startsWith(r5.next()) == false) goto L43;
        return f14440f;
    L49:
        if (i(f14444j) == true) goto L60;
        Iterator<Pattern> r6 = f14444j.iterator();
    L52:
        if (r6.hasNext() == false) goto L60;
        Pattern r7 = r6.next();
        if (r7 == null) goto L52;
        if (r7.matcher(r3).matches() == false) goto L52;
        return f14440f;
    L60:
        if (i(n) == true) goto L84;
        if (j(r2) == false) goto L84;
        if (i(o) == true) goto L71;
        if (o.contains(r3) == false) goto L71;
        return d.f14451g;
    L71:
        if (i(p) == true) goto L82;
        Iterator<Pattern> r8 = p.iterator();
    L74:
        if (r8.hasNext() == false) goto L82;
        Pattern r9 = r8.next();
        if (r9 == null) goto L74;
        if (r9.matcher(r3).matches() == false) goto L74;
        return d.f14451g;
    L82:
        return f14440f;
    L84:
        return d.f14451g;
    L86:
        return d.f14451g;
    }

    public static byte[] g(byte[] r2, int r3) {
        GZIPOutputStream r4 = null;
        if (r2 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        GZIPOutputStream r1 = new GZIPOutputStream(r0);     // Catch: Throwable -> L16 IOException -> L25
        r1.write(r2);     // Catch: Throwable -> L14 IOException -> L34
        r1.close();     // Catch: IOException -> L10
        r0.close();     // Catch: IOException -> L10
    L13:
        return r0.toByteArray();
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L14:
        th = th;
        r4 = r1;
    L17:
        if (r4 != null) goto L37;
    L21:
        r0.close();     // Catch: IOException -> L19
    L24:
        throw th;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L24
    L37:
        r4.close();     // Catch: IOException -> L19
    L26:
        if (r1 != null) goto L39;
    L30:
        r0.close();     // Catch: IOException -> L28
    L33:
        return null;
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L39:
        r1.close();     // Catch: IOException -> L28
        goto L30
    L25:
        r1 = null;
    L16:
        th = th;
        goto L17
    }

    public static boolean h() {
        return f14441g;
    }

    private static boolean i(Set<?> r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }

    private static boolean j(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        Iterator<String> r0 = n.iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        if (k(r3, r0.next()) == false) goto L7;
        return true;
    L15:
        return false;
    }

    private static boolean k(String r12, String r13) {
        if (r12 == null) goto L29;
        if (r13 == null) goto L29;
        int r1 = r12.length();
        int r2 = r13.length();
        int r4 = 0;
        int r5 = 0;
        int r6 = -1;
        int r7 = -1;
    L8:
        if (r4 >= r1) goto L22;
        if (r5 >= r2) goto L15;
        if (r13.charAt(r5) == '?') goto L14;
        if (r13.charAt(r5) != r12.charAt(r4)) goto L15;
    L14:
        r4 = r4 + 1;
        r5 = r5 + 1;
    L15:
        if (r5 >= r2) goto L19;
        if (r13.charAt(r5) != '*') goto L19;
        r7 = r4;
        r6 = r5;
        r5 = r5 + 1;
    L19:
        if (r6 == (-1)) goto L20;
        r5 = r6 + 1;
        r7 = r7 + 1;
        r4 = r7;
        goto L8
    L20:
        return false;
    L22:
        if (r5 >= r2) goto L27;
        if (r13.charAt(r5) != '*') goto L25;
        r5 = r5 + 1;
        goto L22
    L25:
        return false;
    L27:
        return true;
    L29:
        return false;
    }

    public static void l(JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        o();
        JSONObject r4 = r3.optJSONObject("tt_compress");
        if (r4 != null) goto L7;
        return;
    L7:
        boolean r1 = false;
        if (r4.optInt("enabled", 0) <= 0) goto L10;
        boolean r0 = true;
    L11:
        f14435a = r0;
        if (r4.optInt("opt_enabled", 0) <= 0) goto L14;
        r1 = true;
    L14:
        f14441g = r1;
        f14436b = r4.optInt("max_body_size", 1048576);
        f14437c = r4.optInt("min_body_size", 100);
        int r2 = r4.optInt("br_level", 4);
        if (r2 >= 0) goto L17;
    L19:
        int r5 = r4.optInt("zstd_level", 6);
        if (r5 >= 1) goto L22;
    L24:
        e(r4.optInt(WsConstants.KEY_CONNECTION_TYPE, d.f14452h.a()));
        n(r4.optJSONArray("equal_path"), f14442h);
        n(r4.optJSONArray("prefix_path"), f14443i);
        m(r4.optJSONArray("regex_path"), f14444j);
        n(r4.optJSONArray("zstd_equal_path"), f14445k);
        n(r4.optJSONArray("zstd_prefix_path"), f14446l);
        m(r4.optJSONArray("zstd_regex_path"), m);
        n(r4.optJSONArray("host_group"), n);
        n(r4.optJSONArray("block_path_equal_list"), o);
        m(r4.optJSONArray("block_path_regex_list"), p);
        Logger.debug();
        return;
    L22:
        if (r5 > 22) goto L24;
        f14439e = r5;
        goto L24
    L17:
        if (r2 > 11) goto L19;
        f14438d = r2;
        goto L19
    L10:
        r0 = false;
        goto L11
    }

    private static void m(JSONArray r3, CopyOnWriteArraySet<Pattern> r4) {
        if (r3 == null) goto L13;
        if (r4 == null) goto L23;
        int r0 = 0;
    L16:
        if (r0 >= r3.length()) goto L25;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r1) == true) goto L12;
        r4.add(Pattern.compile(r1, 2));     // Catch: Throwable -> L14
    L12:
        r0 = r0 + 1;
        goto L16
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    private static void n(JSONArray r3, CopyOnWriteArraySet<String> r4) {
        if (r3 == null) goto L12;
        if (r4 == null) goto L19;
        int r0 = 0;
    L14:
        if (r0 >= r3.length()) goto L21;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r1) == true) goto L11;
        r4.add(r1);     // Catch: JSONException -> L13
    L11:
        r0 = r0 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    private static void o() {
        f14435a = false;
        f14436b = 1048576;
        f14437c = 100;
        f14440f = d.f14451g;
        f14442h.clear();
        f14443i.clear();
        f14444j.clear();
        f14445k.clear();
        f14446l.clear();
        m.clear();
        n.clear();
        o.clear();
        p.clear();
    }

    public static void p(c r0) {
        q = r0;
    }

    public static void q() {
        r = Boolean.TRUE;
    }

    public static byte[] r(byte[] r1, int r2) {
        a r0 = t;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.compress(r1, r2);
    }
}

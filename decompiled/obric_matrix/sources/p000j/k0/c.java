package p000j.k0;

import androidx.core.location.LocationRequestCompat;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import k.a0;
import k.e;
import k.g;
import k.h;
import k.z;
import p000j.e0;
import p000j.g0;
import p000j.v;
import p000j.w;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f17792a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f17793b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g0 f17794c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final h f17795d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final h f17796e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final h f17797f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final h f17798g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final h f17799h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Charset f17800i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Charset f17801j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Charset f17802k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Charset f17803l = null;
    private static final Charset m = null;
    private static final Charset n = null;
    public static final TimeZone o = null;
    public static final Comparator<String> p = null;
    private static final Method q = null;
    private static final Pattern r = null;

    static class a implements Comparator<String> {
        a() {
        }

        public int a(String r1, String r2) {
            return r1.compareTo(r2);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(String r1, String r2) {
            return a(r1, r2);
        }
    }

    static class b implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f17804f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f17805g;

        b(String r1, boolean r2) {
            this.f17804f = r1;
            this.f17805g = r2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r3) {
            Thread r0 = new Thread(r3, this.f17804f);
            r0.setDaemon(this.f17805g);
            return r0;
        }
    }

    static {
        byte[] r1 = new byte[0];
        f17792a = r1;
        f17793b = new String[0];
        Method r2 = null;
        f17794c = g0.x(null, r1);
        e0.d(null, r1);
        f17795d = h.c("efbbbf");
        f17796e = h.c("feff");
        f17797f = h.c("fffe");
        f17798g = h.c("0000ffff");
        f17799h = h.c("ffff0000");
        f17800i = Charset.forName("UTF-8");
        f17801j = Charset.forName("ISO-8859-1");
        f17802k = Charset.forName("UTF-16BE");
        f17803l = Charset.forName("UTF-16LE");
        m = Charset.forName("UTF-32BE");
        n = Charset.forName("UTF-32LE");
        o = TimeZone.getTimeZone("GMT");
        p = new a();
        r2 = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});     // Catch: Exception -> L6
    L4:
        q = r2;
        r = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    private c() {
    }

    public static boolean A(AssertionError r1) {
        if (r1.getCause() != null) goto L5;
    L9:
        return false;
    L5:
        if (r1.getMessage() == null) goto L9;
        if (r1.getMessage().contains("getsockname failed") == false) goto L9;
        return true;
    }

    public static boolean B(Comparator<String> r7, String[] r8, String[] r9) {
        if (r8 == null) goto L20;
        if (r9 == null) goto L20;
        if (r8.length == 0) goto L20;
        if (r9.length == 0) goto L20;
        int r1 = r8.length;
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L20;
        String r3 = r8[r2];
        int r4 = r9.length;
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L19;
        if (r7.compare(r3, r9[r5]) == 0) goto L16;
        r5 = r5 + 1;
        goto L13
    L16:
        return true;
    L19:
        r2 = r2 + 1;
    L20:
        return false;
    }

    public static X509TrustManager C() {
        TrustManagerFactory r0 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());     // Catch: GeneralSecurityException -> L10
        r0.init(null);     // Catch: GeneralSecurityException -> L10
        TrustManager[] r1 = r0.getTrustManagers();     // Catch: GeneralSecurityException -> L10
        if (r1.length != 1) goto L9;
        if ((r1[0] instanceof X509TrustManager) == false) goto L9;
        return (X509TrustManager) r1[0];
    L9:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r1));     // Catch: GeneralSecurityException -> L10
    L10:
        e = move-exception;
        throw b("No System TLS", e);
    }

    public static boolean D(z r11, int r12, TimeUnit r13) {
        long r0 = System.nanoTime();
        if (r11.e().e() == false) goto L5;
        long r5 = r11.e().c() - r0;
    L6:
        r11.e().d(Math.min(r5, r13.toNanos(r12)) + r0);
        e r14 = new e();     // Catch: Throwable -> L17 InterruptedIOException -> L23
    L9:
        if (r11.Z(r14, 8192) == (-1)) goto L12;
        r14.a();     // Catch: Throwable -> L17 InterruptedIOException -> L23
    L12:
        a0 r15 = r11.e();
        if (r5 != LocationRequestCompat.PASSIVE_INTERVAL) goto L15;
        r15.a();
    L16:
        return true;
    L15:
        r15.d(r0 + r5);
    L23:
        a0 r16 = r11.e();
        if (r5 != LocationRequestCompat.PASSIVE_INTERVAL) goto L26;
        r16.a();
    L27:
        return false;
    L26:
        r16.d(r0 + r5);
    L17:
        th = move-exception;
        a0 r17 = r11.e();
        if (r5 != LocationRequestCompat.PASSIVE_INTERVAL) goto L21;
        r17.a();
    L22:
        throw th;
    L21:
        r17.d(r0 + r5);
        goto L22
    L5:
        r5 = Long.MAX_VALUE;
        goto L6
    }

    public static int E(String r2, int r3, int r4) {
    L2:
        if (r3 >= r4) goto L15;
        char r0 = r2.charAt(r3);
        if (r0 == '\t') goto L14;
        if (r0 == '\n') goto L14;
        if (r0 == '\f') goto L14;
        if (r0 == '\r') goto L14;
        if (r0 == ' ') goto L14;
        return r3;
    L14:
        r3 = r3 + 1;
        goto L2
    L15:
        return r4;
    }

    public static int F(String r2, int r3, int r4) {
        int r5 = r4 - 1;
    L3:
        if (r5 < r3) goto L17;
        char r0 = r2.charAt(r5);
        if (r0 == '\t') goto L16;
        if (r0 == '\n') goto L16;
        if (r0 == '\f') goto L16;
        if (r0 == '\r') goto L16;
        if (r0 == ' ') goto L16;
        return r5 + 1;
    L16:
        r5 = r5 - 1;
        goto L3
    L17:
        return r3;
    }

    public static ThreadFactory G(String r1, boolean r2) {
        return new b(r1, r2);
    }

    public static v H(List<p000j.k0.i.c> r4) {
        v.a r0 = new v.a();
        Iterator<p000j.k0.i.c> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        p000j.k0.i.c r1 = r5.next();
        p000j.k0.a.f17790a.b(r0, r1.f17939a.F(), r1.f17940b.F());
        goto L4
    L7:
        return r0.d();
    }

    public static String I(String r0, int r1, int r2) {
        int r3 = E(r0, r1, r2);
        return r0.substring(r3, F(r0, r3, r2));
    }

    public static boolean J(String r1) {
        return r.matcher(r1).matches();
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static void a(Throwable r3, Throwable r4) {
        Method r0 = q;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.invoke(r3, new Object[]{r4});     // Catch: Throwable -> L7
        return;
    }

    public static AssertionError b(String r1, Exception r2) {
        AssertionError r0 = new AssertionError(r1);
        r0.initCause(r2);     // Catch: IllegalStateException -> L5
    L4:
        return r0;
    }

    public static Charset c(g r4, Charset r5) {
        h r0 = f17795d;
        if (r4.G(0, r0) == false) goto L6;
        r4.skip(r0.size());
        return f17800i;
    L6:
        h r1 = f17796e;
        if (r4.G(0, r1) == false) goto L10;
        r4.skip(r1.size());
        return f17802k;
    L10:
        h r2 = f17797f;
        if (r4.G(0, r2) == false) goto L14;
        r4.skip(r2.size());
        return f17803l;
    L14:
        h r3 = f17798g;
        if (r4.G(0, r3) == false) goto L18;
        r4.skip(r3.size());
        return m;
    L18:
        h r6 = f17799h;
        if (r4.G(0, r6) == false) goto L22;
        r4.skip(r6.size());
        return n;
    L22:
        return r5;
    }

    public static String d(String r3) {
        if (r3.contains(":") == true) goto L5;
        String r4 = IDN.toASCII(r3).toLowerCase(Locale.US);     // Catch: IllegalArgumentException -> L25
        if (r4.isEmpty() == false) goto L21;
        return null;
    L21:
        if (j(r4) == false) goto L24;
        return null;
    L24:
        return r4;
    L25:
        return null;
    L5:
        if (r3.startsWith("[") == true) goto L7;
    L9:
        InetAddress r0 = m(r3, 0, r3.length());
    L10:
        if (r0 != null) goto L12;
        return null;
    L12:
        byte[] r1 = r0.getAddress();
        if (r1.length != 16) goto L17;
        return y(r1);
    L17:
        throw new AssertionError("Invalid IPv6 address: '" + r3 + "'");
    L7:
        if (r3.endsWith("]") == false) goto L9;
        r0 = m(r3, 1, r3.length() - 1);
        goto L10
    }

    public static int e(String r5, long r6, TimeUnit r8) {
        if (r6 < 0) goto L17;
        Objects.requireNonNull(r8, "unit == null");
        long r7 = r8.toMillis(r6);
        if (r7 > 2147483647L) goto L15;
        if (r7 != 0) goto L13;
        if (r6 <= 0) goto L13;
        throw new IllegalArgumentException(r5 + " too small.");
    L13:
        return (int) r7;
    L15:
        throw new IllegalArgumentException(r5 + " too large.");
    L17:
        throw new IllegalArgumentException(r5 + " < 0");
    }

    public static void f(long r4, long r6, long r8) {
        if ((r6 | r8) < 0) goto L10;
        if (r6 > r4) goto L10;
        if ((r4 - r6) < r8) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException();
    }

    public static void g(Closeable r0) {
        if (r0 != null) goto L9;
        return;
    L9:
        r0.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static void h(Socket r2) {
        if (r2 != null) goto L17;
        return;
    L17:
        r2.close();     // Catch: RuntimeException -> L5 AssertionError -> L10 Exception -> L16
        goto L21
    L19:
        return;
    L10:
        e = move-exception;
        if (A(e) == true) goto L20;
        throw e;
    L20:
        return;
    L5:
        e = move-exception;
        if ("bio == null".equals(e.getMessage()) == false) goto L9;
        return;
    L9:
        throw e;
    }

    public static String[] i(String[] r4, String r5) {
        int r0 = r4.length + 1;
        String[] r1 = new String[r0];
        System.arraycopy(r4, 0, r1, 0, r4.length);
        r1[r0 - 1] = r5;
        return r1;
    }

    private static boolean j(String r5) {
        int r1 = 0;
    L4:
        if (r1 >= r5.length()) goto L15;
        char r2 = r5.charAt(r1);
        if (r2 <= 31) goto L14;
        if (r2 >= 127) goto L14;
        if (" #%/:?@[\\]".indexOf(r2) != (-1)) goto L12;
        r1 = r1 + 1;
        goto L4
    L12:
        return true;
    L14:
        return true;
    L15:
        return false;
    }

    public static int k(char r2) {
        if (r2 >= '0') goto L5;
    L8:
        char r0 = 'a';
        if (r2 >= 'a') goto L11;
    L14:
        r0 = 'A';
        if (r2 >= 'A') goto L17;
        return -1;
    L17:
        if (r2 <= 'F') goto L13;
        return -1;
    L13:
        return (r2 - r0) + 10;
    L11:
        if (r2 > 'f') goto L14;
    L5:
        if (r2 > '9') goto L8;
        return r2 - '0';
    }

    private static boolean l(String r7, int r8, int r9, byte[] r10, int r11) {
        int r0 = r11;
    L4:
        if (r8 >= r9) goto L32;
        if (r0 == r10.length) goto L7;
        if (r0 != r11) goto L10;
    L13:
        int r2 = r8;
        int r3 = 0;
    L14:
        if (r2 >= r9) goto L28;
        char r4 = r7.charAt(r2);
        if (r4 < '0') goto L28;
        if (r4 > '9') goto L28;
        if (r3 != 0) goto L23;
        if (r8 == r2) goto L23;
        return false;
    L23:
        r3 = ((r3 * 10) + r4) - 48;
        if (r3 > 255) goto L25;
        r2 = r2 + 1;
        goto L14
    L25:
        return false;
    L28:
        if ((r2 - r8) == 0) goto L29;
        r10[r0] = (byte) r3;
        r0 = r0 + 1;
        r8 = r2;
        goto L4
    L29:
        return false;
    L10:
        if (r7.charAt(r8) != '.') goto L11;
        r8 = r8 + 1;
        goto L13
    L11:
        return false;
    L7:
        return false;
    L32:
        if (r0 == (r11 + 4)) goto L34;
        return false;
    L34:
        return true;
    }

    private static InetAddress m(String r11, int r12, int r13) {
        byte[] r1 = new byte[16];
        int r5 = -1;
        int r6 = -1;
        int r4 = 0;
    L4:
        if (r12 >= r13) goto L42;
        if (r4 == 16) goto L6;
        int r8 = r12 + 2;
        if (r8 <= r13) goto L10;
    L17:
        if (r4 != 0) goto L19;
    L28:
        r6 = r12;
    L29:
        int r9 = 0;
        r12 = r6;
    L30:
        if (r12 >= r13) goto L35;
        int r10 = k(r11.charAt(r12));
        if (r10 == (-1)) goto L35;
        r9 = (r9 << 4) + r10;
        r12 = r12 + 1;
    L35:
        int r14 = r12 - r6;
        if (r14 == 0) goto L41;
        if (r14 > 4) goto L41;
        int r7 = r4 + 1;
        r1[r4] = (byte) ((r9 >>> 8) & 255);
        r4 = r7 + 1;
        r1[r7] = (byte) (r9 & 255);
    L41:
        return null;
    L19:
        if (r11.regionMatches(r12, ":", 0, 1) == false) goto L22;
        r12 = r12 + 1;
        goto L28
    L22:
        if (r11.regionMatches(r12, ".", 0, 1) == true) goto L24;
        return null;
    L24:
        if (l(r11, r6, r13, r1, r4 - 2) == true) goto L26;
        return null;
    L26:
        r4 = r4 + 2;
        goto L42
    L10:
        if (r11.regionMatches(r12, "::", 0, 2) == false) goto L17;
        if (r5 != (-1)) goto L12;
        r4 = r4 + 2;
        r5 = r4;
        if (r8 == r13) goto L42;
        r6 = r8;
        goto L29
    L12:
        return null;
    L6:
        return null;
    L42:
        if (r4 == 16) goto L50;
        if (r5 != (-1)) goto L45;
        return null;
    L45:
        int r15 = r4 - r5;
        System.arraycopy(r1, r5, r1, 16 - r15, r15);
        Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
    L50:
        return InetAddress.getByAddress(r1);
    L49:
        throw new AssertionError();
    }

    public static int n(String r1, int r2, int r3, char r4) {
    L2:
        if (r2 >= r3) goto L7;
        if (r1.charAt(r2) == r4) goto L5;
        r2 = r2 + 1;
        goto L2
    L5:
        return r2;
    L7:
        return r3;
    }

    public static int o(String r2, int r3, int r4, String r5) {
    L2:
        if (r3 >= r4) goto L7;
        if (r5.indexOf(r2.charAt(r3)) != (-1)) goto L5;
        r3 = r3 + 1;
        goto L2
    L5:
        return r3;
    L7:
        return r4;
    }

    public static boolean p(z r0, int r1, TimeUnit r2) {
        return D(r0, r1, r2);
    L4:
        return false;
    }

    public static boolean q(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    public static String r(String r1, Object... r2) {
        return String.format(Locale.US, r1, r2);
    }

    public static String s(w r3, boolean r4) {
        if (r3.m().contains(":") == false) goto L5;
        String r0 = "[" + r3.m() + "]";
    L6:
        if (r4 == true) goto L10;
        if (r3.y() != w.e(r3.D())) goto L10;
        return r0;
    L10:
        return r0 + ":" + r3.y();
    L5:
        r0 = r3.m();
        goto L6
    }

    public static <T> List<T> t(List<T> r1) {
        return Collections.unmodifiableList(new ArrayList(r1));
    }

    public static <T> List<T> u(T... r0) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) r0.clone()));
    }

    public static <K, V> Map<K, V> v(Map<K, V> r1) {
        if (r1.isEmpty() == false) goto L6;
        return Collections.emptyMap();
    L6:
        return Collections.unmodifiableMap(new LinkedHashMap(r1));
    }

    public static int w(Comparator<String> r3, String[] r4, String r5) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r3.compare(r4[r1], r5) == 0) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    public static int x(String r4) {
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        char r2 = r4.charAt(r1);
        if (r2 <= 31) goto L10;
        if (r2 >= 127) goto L10;
        r1 = r1 + 1;
    L10:
        return r1;
    L11:
        return -1;
    }

    private static String y(byte[] r8) {
        int r0 = 0;
        int r1 = -1;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r8.length) goto L18;
        int r4 = r2;
    L6:
        if (r4 >= 16) goto L12;
        if (r8[r4] != 0) goto L12;
        if (r8[r4 + 1] != 0) goto L12;
        r4 = r4 + 2;
    L12:
        int r5 = r4 - r2;
        if (r5 <= r3) goto L17;
        if (r5 < 4) goto L17;
        r1 = r2;
        r3 = r5;
    L17:
        r2 = r4 + 2;
        goto L4
    L18:
        e r6 = new e();
    L20:
        if (r0 >= r8.length) goto L30;
        if (r0 == r1) goto L23;
        if (r0 <= 0) goto L28;
        r6.s0(58);
    L28:
        r6.u0(((r8[r0] & 255) << 8) | (r8[r0 + 1] & 255));
        r0 = r0 + 2;
        goto L20
    L23:
        r6.s0(58);
        r0 = r0 + r3;
        if (r0 != 16) goto L20;
        r6.s0(58);
        goto L20
    L30:
        return r6.i0();
    }

    public static String[] z(Comparator<? super String> r8, String[] r9, String[] r10) {
        ArrayList r0 = new ArrayList();
        int r1 = r9.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L12;
        String r4 = r9[r3];
        int r5 = r10.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L10;
        if (r8.compare(r4, r10[r6]) == 0) goto L8;
        r6 = r6 + 1;
        goto L5
    L8:
        r0.add(r4);
    L10:
        r3 = r3 + 1;
        goto L3
    L12:
        return (String[]) r0.toArray(new String[r0.size()]);
    }
}

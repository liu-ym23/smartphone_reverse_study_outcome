package d.b.h.a.a.h;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.bdlocation.client.LocationInfoConst;
import d.b.r.c0;
import d.b.r.y;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private static AtomicBoolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f13385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s f13386b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static k f13387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static i f13388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static r f13389e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f13390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static h f13391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static d f13392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static l f13393i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static m f13394j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile AtomicBoolean f13395k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Object f13396l = null;
    private static CountDownLatch m;
    private static e n;
    private static j o;
    private static f p;
    private static volatile t q;
    private static volatile q r;
    private static volatile n s;
    private static final Map<String, o> t = null;
    private static volatile p u;
    private static b v;
    private static a w;
    private static boolean x;
    private static boolean y;
    private static int z;

    public interface a {
        Map<String, String> onCallToAddSecurityFactor(String r1, Map<String, List<String>> r2);
    }

    public interface b {
        Map<String, String> onCallToAddSecurityFactor(String r1, Map<String, List<String>> r2);
    }

    public interface c {
        boolean a();
    }

    public interface d<T extends d.b.h.a.a.h.b> {
        @Deprecated
        void a(String r1, long r2, T r4);

        String addCommonParams(String r1, boolean r2);

        String b(String r1, boolean r2, Object... r3);

        @Deprecated
        void c(String r1, Throwable r2, long r3, T r5);

        void d();

        void putCommonParams(Map<String, String> r1, boolean r2);
    }

    public interface e<T extends d.b.h.a.a.h.c> {
        void b(String r1, String r2, boolean r3);

        String f(String r1, T r2);
    }

    public interface f {
        Map<String, List<String>> a(URI r1, Map<String, List<String>> r2);

        void b(URI r1, Map<String, List<String>> r2);
    }

    /* JADX INFO: renamed from: d.b.h.a.a.h.g$g, reason: collision with other inner class name */
    public interface InterfaceC0359g {
    }

    public interface h {
        void a(List<String> r1);

        String b();
    }

    public interface i {
        boolean a(String r1);
    }

    public interface j {
        List<String> e(CookieManager r1, d.b.h.a.a.h.m.c r2, URI r3);

        List<String> g(String r1);
    }

    public interface k {
        void a(Set<String> r1);

        void b(String r1, String r2);
    }

    public interface l<T extends d.b.h.a.a.h.b> {
        void a(long r1, long r3, String r5, String r6, T r7);

        void b(long r1, long r3, String r5, String r6, T r7, Throwable r8);

        default boolean handleApiSample(String r1, String r2) {
            return false;
        }
    }

    public interface m {
        boolean a();
    }

    public interface n {
        d.b.h.a.a.h.i a(String r1, List<d.b.r.h0.b> r2, Map<String, List<String>> r3, boolean r4);
    }

    public interface o {
        d.b.h.a.a.h.i a(Map<String, List<String>> r1);
    }

    public interface p {
        d.b.h.a.a.h.i a(String r1, String r2, d.b.h.a.a.h.b r3, int r4, List<d.b.r.h0.b> r5, Map<String, List<String>> r6);
    }

    public interface q {
        d.b.h.a.a.h.i a(Map<String, List<String>> r1);
    }

    public interface r {
        InputStream a(InputStream r1, Map<String, List<String>> r2, y r3);
    }

    public static final class s implements c0.b {
        public s() {
        }

        private void d(Object r1) {
            URL r0 = ((d.b.h.a.a.h.b) r1).f13354a;
        }

        @Override // d.b.r.c0.b
        public boolean a() {
            if (g.b() != null) goto L7;
            return false;
        L7:
            return g.b().a();
        }

        @Override // d.b.r.c0.b
        public void b(long r11, long r13, String r15, String r16, Object r17) {
            if (g.a() != null) goto L5;
            return;
        L5:
            if (r17 == null) goto L17;
            d.b.h.a.a.h.b r1 = (d.b.h.a.a.h.b) r17;
            if (com.bytedance.common.utility.k.c(r1.E) == false) goto L9;
            return;
        L9:
            if (r1.b0 == true) goto L19;
            g.a().a(r11, r13, r15, r16, (d.b.h.a.a.h.b) r17);     // Catch: ClassCastException -> L13
            return;
        L13:
            d(r17);
            return;
        L19:
            return;
        }

        @Override // d.b.r.c0.b
        public void c(long r12, long r14, String r16, String r17, Object r18, Throwable r19) {
            if (g.a() != null) goto L5;
            return;
        L5:
            if (r18 == null) goto L17;
            d.b.h.a.a.h.b r1 = (d.b.h.a.a.h.b) r18;
            if (com.bytedance.common.utility.k.c(r1.E) == false) goto L9;
            return;
        L9:
            if (r1.b0 == true) goto L19;
            g.a().b(r12, r14, r16, r17, (d.b.h.a.a.h.b) r18, r19);     // Catch: ClassCastException -> L13
            return;
        L13:
            d(r18);
            return;
        L19:
            return;
        }
    }

    public interface t {
        boolean a(Map<String, List<String>> r1);
    }

    static {
        f13386b = new s();
        f13395k = new AtomicBoolean(false);
        f13396l = new Object();
        m = new CountDownLatch(1);
        t = new ConcurrentHashMap();
        x = false;
        y = true;
        z = 100;
        A = new AtomicBoolean(false);
    }

    public g() {
    }

    public static void A(String r9, d.b.h.a.a.h.b r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.b0 == true) goto L9;
        long r0 = r10.m;
        long r4 = r10.f13361h;
        B(r0 - r4, r4, r9, r10.Z, r10);
        return;
    }

    public static void B(long r9, long r11, String r13, String r14, d.b.h.a.a.h.b r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        if (com.bytedance.common.utility.k.c(r15.E) == false) goto L6;
        return;
    L6:
        if (r15.b0 == true) goto L28;
        l r1 = f13393i;
        if (com.bytedance.common.utility.k.c(r13) == false) goto L11;
        return;
    L11:
        if (r9 <= 0) goto L25;
        if (r1 != null) goto L14;
        return;
    L14:
        if (r15.G == false) goto L18;
        if (r15.V.get() == false) goto L18;
        return;
    L18:
        if (r15.G == false) goto L20;
        r15.V.set(true);
    L20:
        r1.a(r9, r11, r13, r14, r15);
        return;
    L25:
        return;
    }

    private static d.b.h.a.a.h.i C(Map<String, List<String>> r2) {
        if (r == null) goto L7;
        d.b.h.a.a.h.i r0 = r.a(r2);
        r2.remove("bdturing-verify");
        return r0;
    L7:
        if (q == null) goto L11;
        boolean r1 = q.a(r2);
        r2.remove("bdturing-verify");
        return new d.b.h.a.a.h.i(r1);
    L11:
        return new d.b.h.a.a.h.i(false);
    }

    public static void D(Map<String, String> r1, boolean r2) {
        d r0 = f13392h;
        if (r0 == null) goto L6;
        r0.putCommonParams(r1, r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void E(d.b.r.h0.c r2, d.b.h.a.a.h.b r3, Throwable r4, Boolean r5) {
        if (r4 != 0) goto L5;
        A(r2.G(), r3);
        return;
    L5:
        if ((r4 instanceof d.b.r.l0.d) == false) goto L15;
        d.b.r.l0.d r0 = (d.b.r.l0.d) r4;
        if (r0.f14469f == false) goto L15;
        if (r0.f14470g == false) goto L12;
        A(r2.G(), r3);
    L12:
        if (r0.f14471h == false) goto L24;
    L21:
        y(r2.G(), r3, r4);
        return;
    L24:
        return;
    L15:
        if ((r4 instanceof d.b.r.l0.a) == false) goto L20;
        if (((d.b.r.l0.a) r4).a() == true) goto L21;
        return;
    L20:
        if (r5.booleanValue() == true) goto L21;
    }

    @Deprecated
    public static synchronized void F(t r1) {
        monitor-enter(g.class);
        q = r1;     // Catch: Throwable -> L7
        monitor-exit(g.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void G(b r0) {
        v = r0;
    }

    public static void H(d r0) {
        f13392h = r0;
    }

    public static void I(e r0) {
        n = r0;
    }

    public static void J(InterfaceC0359g r0) {
    }

    public static void K(h r0) {
        f13391g = r0;
    }

    public static void L(i r0) {
        f13388d = r0;
    }

    public static void M(boolean r1) {
        if (f13395k.get() != r1) goto L5;
        return;
    L5:
        f13395k.getAndSet(r1);
        d();
        if (r1 == true) goto L9;
        m = new CountDownLatch(1);
        return;
    }

    public static void N(j r0) {
        o = r0;
    }

    public static void O(String r6) {
        if (r6 != null) goto L19;
    L16:
        f13390f = r6;
        return;
    L19:
        if (r6.length() <= 0) goto L16;
        char[] r0 = r6.toCharArray();     // Catch: Exception -> L18
        int r1 = r0.length;     // Catch: Exception -> L18
        int r2 = 0;
        boolean r3 = false;
    L6:
        if (r2 >= r1) goto L13;
        if (r0[r2] >= ' ') goto L10;
    L11:
        r0[r2] = '?';     // Catch: Exception -> L18
        r3 = true;
    L12:
        r2 = r2 + 1;     // Catch: Exception -> L18
        goto L6
    L10:
        if (r0[r2] <= '~') goto L12;
    L13:
        if (r3 == false) goto L16;
        r6 = new String(r0);     // Catch: Exception -> L18
        goto L16
    }

    public static void P(int r0) {
        z = r0;
    }

    public static void Q(boolean r1) {
        A.set(r1);
    }

    public static void R(l r0) {
        f13393i = r0;
        c0.v(f13386b);
    }

    public static void S(boolean r0) {
        y = r0;
    }

    public static synchronized boolean T(n r2) {
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (s == null) goto L9;
        boolean r3 = false;
    L7:
        monitor-exit(g.class);
        return r3;
    L9:
        s = r2;     // Catch: Throwable -> L11
        r3 = true;
        goto L7
    }

    private static d.b.h.a.a.h.i U(String r6, d.b.h.a.a.h.b r7, boolean r8, List<d.b.r.h0.b> r9, Map<String, List<String>> r10) {
        d.b.h.a.a.h.i r0 = new d.b.h.a.a.h.i(false);
        if (s != null) goto L6;
        return r0;
    L6:
        if (r9 == null) goto L17;
        Iterator<d.b.r.h0.b> r2 = r9.iterator();
    L9:
        if (r2.hasNext() == false) goto L17;
        d.b.r.h0.b r3 = r2.next();
        if (r3 == null) goto L9;
        if ("x-tt-bypass-retry-for-account".equalsIgnoreCase(r3.a()) == false) goto L9;
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r3.b()) == false) goto L9;
        return r0;
    L17:
        long r4 = SystemClock.uptimeMillis();
        r0 = s.a(r6, r9, r10, r8);     // Catch: Throwable -> L29
    L19:
        r7.R = SystemClock.uptimeMillis() - r4;
        if (r8 == true) goto L28;
        if (r0 == null) goto L28;
        if (r0.d() == false) goto L28;
        HashMap r11 = new HashMap();
        r11.put("x-tt-retry-for-account", LocationInfoConst.ALLOW_USE_LOCATION);
        if (r0.a() == null) goto L27;
        r11.putAll(r0.a());
    L27:
        r0.e(r11);
        r7.Q = true;
    L28:
        return r0;
    }

    private static d.b.h.a.a.h.i V(d.b.h.a.a.h.b r9, List<d.b.r.h0.b> r10, Map<String, List<String>> r11) {
        boolean r1 = false;
        d.b.h.a.a.h.i r0 = new d.b.h.a.a.h.i(false);
        if (r11 != null) goto L5;
    L46:
        return r0;
    L5:
        if (r11.isEmpty() == true) goto L46;
        if (t.isEmpty() == true) goto L46;
        Iterator<String> r2 = r11.keySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L17;
        String r3 = r2.next();
        if (com.bytedance.common.utility.k.c(r3) == true) goto L11;
        if (r3.toLowerCase().contains("verify") == false) goto L11;
        r1 = true;
    L17:
        if (r1 == true) goto L19;
        return r0;
    L19:
        Map.Entry<String, o> r4 = p(r11.keySet());
        if (r4 != null) goto L23;
        return r0;
    L23:
        if (r10 == null) goto L34;
        String r5 = "x-tt-bypass-retry-by-" + r4.getKey();
        Iterator<d.b.r.h0.b> r12 = r10.iterator();
    L26:
        if (r12.hasNext() == false) goto L34;
        d.b.r.h0.b r6 = r12.next();
        if (r6 == null) goto L26;
        if (r5.equalsIgnoreCase(r6.a()) == false) goto L26;
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r6.b()) == false) goto L26;
        return r0;
    L34:
        o r13 = r4.getValue();
        if (r13 != null) goto L37;
        return r0;
    L37:
        long r7 = SystemClock.uptimeMillis();
        d.b.h.a.a.h.i r14 = r13.a(r11);
        r9.N = SystemClock.uptimeMillis() - r7;
        r9.P = r4.getKey();
        if (r14 != null) goto L40;
    L45:
        return r14;
    L40:
        if (r14.d() == false) goto L45;
        r9.O = true;
        Map<String, String> r15 = r14.a();
        if (r15 != null) goto L44;
        r15 = new HashMap();
    L44:
        r15.put("x-tt-retry-by-" + r4.getKey(), LocationInfoConst.ALLOW_USE_LOCATION);
        r14.e(r15);
        goto L45
    }

    private static d.b.h.a.a.h.i W(d.b.r.h0.c r15, d.b.h.a.a.h.b r16, int r17, List<d.b.r.h0.b> r18, Map<String, List<String>> r19, boolean r20) {
        d.b.h.a.a.h.i r9 = new d.b.h.a.a.h.i(false);
        if (r20 == false) goto L5;
    L35:
        return r9;
    L5:
        if (r16.O == true) goto L35;
        if (r16.Q == true) goto L35;
        if (A.get() == true) goto L35;
        if (u == null) goto L35;
        d.b.h.a.a.h.j r7 = r16.T;
        if (r7 != null) goto L17;
        return r9;
    L17:
        if (r7.c() == false) goto L20;
        r7.d(r15.w(), r15.A(), r17, -1, r9, r16);
        return r9;
    L20:
        String r1 = r15.G();
        d.b.h.a.a.h.c.C0358c r0 = r7.b();
        if (r0 != null) goto L23;
        return r9;
    L23:
        String r2 = r0.f13380a;
        String r3 = r0.f13381b;
        if (TextUtils.isEmpty(r2) == true) goto L35;
        if (TextUtils.isEmpty(r3) == true) goto L35;
        String r10 = r15.w();
        String r11 = r15.A();
        String r12 = r1.replaceFirst(r10, r2).replaceFirst(r11, r3);
        long r13 = SystemClock.elapsedRealtime();
        r9 = u.a(r1, r12, r16, r17, r18, r19);     // Catch: Throwable -> L36
    L30:
        r7.d(r10, r11, r17, SystemClock.elapsedRealtime() - r13, r9, r16);
        if (r9 == null) goto L35;
        if (r9.d() == false) goto L35;
        r16.S = true;
        r9.f(r12);
        goto L35
    }

    private static d.b.h.a.a.h.i X(d.b.h.a.a.h.b r7, List<d.b.r.h0.b> r8, Map<String, List<String>> r9) {
        d.b.h.a.a.h.i r0 = new d.b.h.a.a.h.i(false);
        if (r9 != null) goto L5;
    L30:
        return r0;
    L5:
        if (r9.containsKey("bdturing-verify") == false) goto L30;
        if (r8 == null) goto L19;
        Iterator<d.b.r.h0.b> r10 = r8.iterator();
    L11:
        if (r10.hasNext() == false) goto L19;
        d.b.r.h0.b r3 = r10.next();
        if (r3 == null) goto L11;
        if ("x-tt-bypass-bdturing".equalsIgnoreCase(r3.a()) == false) goto L11;
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r3.b()) == false) goto L11;
        return r0;
    L19:
        TreeMap r11 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        r11.putAll(r9);
        long r4 = SystemClock.uptimeMillis();
        d.b.h.a.a.h.i r12 = C(r11);
        r7.N = SystemClock.uptimeMillis() - r4;
        if (r11.containsKey("bdturing-verify") == true) goto L22;
        r7.M = true;
        r7.P = "bdturing-verify";
    L22:
        if (r12 != null) goto L24;
    L29:
        return r12;
    L24:
        if (r12.d() == false) goto L29;
        r7.O = true;
        HashMap r13 = new HashMap();
        r13.put("x-tt-bdturing-retry", LocationInfoConst.ALLOW_USE_LOCATION);
        if (r12.a() == null) goto L28;
        r13.putAll(r12.a());
    L28:
        r12.e(r13);
        goto L29
    }

    public static d.b.h.a.a.h.i Y(d.b.r.h0.c r6, int r7, d.b.h.a.a.h.b r8, List<d.b.r.h0.b> r9, Map<String, List<String>> r10, boolean r11, boolean r12) {
        boolean r1 = false;
        d.b.h.a.a.h.i r0 = new d.b.h.a.a.h.i(false);
        r8.S = false;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L6;
        return r0;
    L6:
        if (r7 != 200) goto L35;
        if (r11 == false) goto L35;
        d.b.h.a.a.h.i r13 = X(r8, r9, r10);
        if (r8.M == true) goto L13;
        r13 = V(r8, r9, r10);
    L13:
        if (r13 != null) goto L15;
    L17:
        boolean r2 = false;
    L18:
        d.b.h.a.a.h.i r3 = U(r6.G(), r8, r2, r9, r10);
        if (r2 == true) goto L21;
        r13 = r3;
    L28:
        if (r13 != null) goto L30;
    L32:
        if (r1 == false) goto L35;
        return r13;
    L30:
        if (r13.d() == false) goto L32;
        r1 = true;
        goto L32
    L21:
        if (r3 == null) goto L28;
        if (r3.a() == null) goto L28;
        HashMap r4 = new HashMap();
        if (r13.a() == null) goto L27;
        r4.putAll(r13.a());
    L27:
        r4.putAll(r3.a());
        r13.e(r4);
        goto L28
    L15:
        if (r13.d() == false) goto L17;
        r2 = true;
    L35:
        return W(r6, r8, r7, r9, r10, r12);
    }

    public static Map<String, String> Z(String r1, Map<String, List<String>> r2) {
        a r0 = w;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.onCallToAddSecurityFactor(r1, r2);
    }

    static /* synthetic */ l a() {
        return f13393i;
    }

    public static String a0(String r1, boolean r2, Object... r3) {
        d r0 = f13392h;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return r0.b(r1, r2, r3);
    }

    static /* synthetic */ c b() {
        return f13385a;
    }

    public static Map<String, String> b0(String r1, Map<String, List<String>> r2) {
        b r0 = v;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.onCallToAddSecurityFactor(r1, r2);
    }

    public static String c(String r1, boolean r2) {
        d r0 = f13392h;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return r0.addCommonParams(r1, r2);
    }

    public static void c0() {
        d r0 = f13392h;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    private static void d() {
        CountDownLatch r0 = m;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getCount() <= 0) goto L9;
        m.countDown();
        return;
    }

    public static CookieManager d0() {
        Object r0 = f13396l;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (f13395k.get() == false) goto L24;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L19
        CookieManager r1 = null;
        r1 = CookieManager.getInstance();     // Catch: Throwable -> L22
        if (r1.acceptCookie() == true) goto L18;
        r1.setAcceptCookie(true);     // Catch: Throwable -> L22
    L18:
        return r1;
    L24:
        CountDownLatch r2 = m;     // Catch: Exception -> L23 Throwable -> L19
        if (r2 == null) goto L12;
        r2.await(CoroutineLiveDataKt.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);     // Catch: Exception -> L23 Throwable -> L19
        if (m.getCount() != 1) goto L12;
        m.countDown();     // Catch: Exception -> L23 Throwable -> L19
    L12:
        f13395k.getAndSet(true);     // Catch: Throwable -> L19
        goto L13
    }

    public static String e(String r1) {
        f(r1, null);
        return r1;
    }

    public static CookieManager e0() {
        return f0("");
    }

    public static String f(String r1, d.b.h.a.a.h.c r2) {
        if (com.bytedance.common.utility.k.c(r1) == false) goto L5;
        return r1;
    L5:
        e r0 = n;
        if (r0 == null) goto L8;
        r0.f(r1, r2);
    L8:
        return r1;
    }

    public static CookieManager f0(String r0) {
        c0();
        return d0();
    }

    public static f g() {
        return p;
    }

    public static h h() {
        return f13391g;
    }

    public static int i() {
        return 15000;
    }

    public static i j() {
        return f13388d;
    }

    public static j k() {
        return o;
    }

    public static k l() {
        return f13387c;
    }

    public static int m() {
        return z;
    }

    public static boolean n() {
        return x;
    }

    public static int o() {
        return 15000;
    }

    private static synchronized Map.Entry<String, o> p(Set<String> r6) {
        monitor-enter(g.class);
        Iterator<Map.Entry<String, o>> r1 = t.entrySet().iterator();     // Catch: Throwable -> L19
    L6:
        if (r1.hasNext() == false) goto L17;
        Map.Entry<String, o> r2 = r1.next();     // Catch: Throwable -> L19
        Iterator<String> r3 = r6.iterator();     // Catch: Throwable -> L19
    L9:
        if (r3.hasNext() == false) goto L6;
        String r4 = r3.next();     // Catch: Throwable -> L19
        if (com.bytedance.common.utility.k.c(r4) == true) goto L9;
        if (r4.equalsIgnoreCase(r2.getKey()) == false) goto L9;
        monitor-exit(g.class);
        return r2;
    L17:
        monitor-exit(g.class);
        return null;
    L19:
        th = move-exception;
        throw th;
    }

    public static r q() {
        return f13389e;
    }

    public static String r() {
        return f13390f;
    }

    @Deprecated
    public static void s(String r7, Throwable r8, d.b.h.a.a.h.b r9) {
        if (com.bytedance.common.utility.k.c(r7) == true) goto L17;
        if (r8 == null) goto L22;
        if (r9 != null) goto L8;
        return;
    L8:
        if (r9.b0 == true) goto L23;
        d r1 = f13392h;
        m r0 = f13394j;
        if (r1 == null) goto L19;
        if (r0 != null) goto L14;
        return;
    L14:
        if (r0.a() == false) goto L21;
        r1.c(r7, r8, r9.m - r9.f13361h, r9);
        return;
    L21:
        return;
    L19:
        return;
    L23:
        return;
    L22:
        return;
    }

    @Deprecated
    public static void t(String r6, d.b.h.a.a.h.b r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.b0 == true) goto L22;
        d r0 = f13392h;
        m r1 = f13394j;
        long r2 = r7.m - r7.f13361h;
        if (com.bytedance.common.utility.k.c(r6) == false) goto L9;
        return;
    L9:
        if (r2 <= 0) goto L18;
        if (r0 == null) goto L19;
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.a() == false) goto L21;
        r0.a(r6, r2, r7);
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }

    public static boolean u(String r2, String r3) {
        l r0 = f13393i;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (com.bytedance.common.utility.k.c(r2) == false) goto L7;
        return false;
    L7:
        if (com.bytedance.common.utility.k.c(r3) == false) goto L9;
        return false;
    L9:
        return r0.handleApiSample(r2, r3);
    }

    public static boolean v(Object r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if ((r1 instanceof d.b.h.a.a.h.c) == false) goto L8;
        if (((d.b.h.a.a.h.c) r1).x == false) goto L8;
        return true;
    }

    public static boolean w() {
        return y;
    }

    public static void x(long r9, long r11, String r13, String r14, d.b.h.a.a.h.b r15, Throwable r16) {
        if (r15 != null) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.k.c(r15.E) == false) goto L7;
        return;
    L7:
        if (r15.b0 == false) goto L10;
        return;
    L10:
        if (com.bytedance.common.utility.k.c(r13) == true) goto L22;
        if (r16 == null) goto L25;
        l r0 = f13393i;
        if (r0 != null) goto L16;
        return;
    L16:
        if (r15.G == false) goto L18;
        r15.V.set(true);
    L18:
        r0.b(r9, r11, r13, r14, r15, r16);
        return;
    L25:
        return;
    }

    public static void y(String r10, d.b.h.a.a.h.b r11, Throwable r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        long r0 = r11.m;
        long r4 = r11.f13361h;
        x(r0 - r4, r4, r10, r11.Z, r11, r12);
    }

    public static void z(String r1, String r2, boolean r3) {
        if (com.bytedance.common.utility.k.c(r1) == false) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.k.c(r2) == true) goto L13;
        e r0 = n;
        if (r0 == null) goto L12;
        r0.b(r1, r2, r3);
        return;
    L12:
        return;
    }
}

package ms.bd.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static volatile long f22446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static volatile long f22447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static volatile long f22448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static volatile long f22449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f22450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<String, i0> f22451f = null;

    public interface a {
        void a(String r1);

        void b(String r1);

        void c(String r1);

        void d(String r1);

        void e(String r1);
    }

    static {
        f22451f = new ConcurrentHashMap();
    }

    public static synchronized a a(String r6) {
        monitor-enter(p2.class);
        if (r6 == null) goto L23;
        if (f22450e == true) goto L11;
        monitor-exit(p2.class);
        return null;
    L11:
        Object r1 = b.b(67108866, r6);     // Catch: Throwable -> L24
        if (r1 != null) goto L15;
        monitor-exit(p2.class);
        return null;
    L15:
        i0 r7 = f22451f.get(r6);     // Catch: Throwable -> L24
        if (r7 != null) goto L19;
        monitor-exit(p2.class);
        return null;
    L19:
        o2 r2 = new o2(r7, ms.bd.c.a.a().c(), ((Long) r1).longValue());     // Catch: Throwable -> L24
        monitor-exit(p2.class);
        return r2;
    L23:
        throw new NullPointerException("appID must be set");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private static void b(final Context r2, final String r3, final i0 r4) {
        new Thread(new z4(r2, r4, r3)).start();
    }

    static synchronized void c(Context r17, String r18, boolean r19) {
        monitor-enter(p2.class);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (f22450e == true) goto L25;
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L27
        Context r9 = r17.getApplicationContext();     // Catch: Throwable -> L27
        ms.bd.c.a.a().b(r9);     // Catch: Throwable -> L27
        if (com.bytedance.mobsec.metasec.ml.a.c() == true) goto L10;
        Class.forName("com.bytedance.mobsec.sensor.ml.MSB");     // Catch: Throwable -> L30
        y.a(r9, "perception_ml");     // Catch: Throwable -> L30
    L10:
        y.a(r9, r18);     // Catch: Throwable -> L27
        f22448c = System.currentTimeMillis() - r2;     // Catch: Throwable -> L27
        if (com.bytedance.mobsec.metasec.ml.a.c() == true) goto L24;
        String r4 = (String) m.a(16777217, 0, 0, "fd06fd", new byte[]{57, 107, 80});     // Catch: Throwable -> L27
        b.c(50331649, new u0());     // Catch: Throwable -> L27
        b.c(16777218, new f1());     // Catch: Throwable -> L27
        b.c(16777217, new q1());     // Catch: Throwable -> L27
        String r0 = (String) m.a(16777217, 0, 0, "758d35", new byte[]{104, 58, 79});     // Catch: Throwable -> L27
        b.c(16777219, new b2());     // Catch: Throwable -> L27
        b.c(16777221, new i2());     // Catch: Throwable -> L27
        b.c(16777222, new j2());     // Catch: Throwable -> L27
        b.c(16777262, new k2());     // Catch: Throwable -> L27
        b.c(16777223, new m2());     // Catch: Throwable -> L27
        b.c(16777224, new n2());     // Catch: Throwable -> L27
        b.c(16777225, new k0());     // Catch: Throwable -> L27
        b.c(16777226, new l0());     // Catch: Throwable -> L27
        b.c(16777228, new m0());     // Catch: Throwable -> L27
        b.c(InputDeviceCompat.SOURCE_JOYSTICK, new n0());     // Catch: Throwable -> L27
        b.c(16777233, new o0());     // Catch: Throwable -> L27
        b.c(16777234, new p0());     // Catch: Throwable -> L27
        b.c(16777235, new q0());     // Catch: Throwable -> L27
        b.c(16777238, new r0());     // Catch: Throwable -> L27
        b.c(16777239, new s0());     // Catch: Throwable -> L27
        b.c(16777241, new t0());     // Catch: Throwable -> L27
        b.c(16777242, new v0());     // Catch: Throwable -> L27
        b.c(16777243, new w0());     // Catch: Throwable -> L27
        b.c(16777244, new x0());     // Catch: Throwable -> L27
        b.c(16777245, new y0());     // Catch: Throwable -> L27
        b.c(16777246, new z0());     // Catch: Throwable -> L27
        b.c(16777247, new a1());     // Catch: Throwable -> L27
        b.c(16777248, new b1());     // Catch: Throwable -> L27
        b.c(16777249, new c1());     // Catch: Throwable -> L27
        b.c(16777260, new d1());     // Catch: Throwable -> L27
        b.c(16777250, new e1());     // Catch: Throwable -> L27
        b.c(16777251, new g1());     // Catch: Throwable -> L27
        b.c(16777240, new h1());     // Catch: Throwable -> L27
        b.c(16777252, new i1());     // Catch: Throwable -> L27
        b.c(16777253, new j1());     // Catch: Throwable -> L27
        b.c(16777254, new k1());     // Catch: Throwable -> L27
        b.c(16777255, new l1());     // Catch: Throwable -> L27
        b.c(16777256, new m1());     // Catch: Throwable -> L27
        b.c(16777258, new n1());     // Catch: Throwable -> L27
        b.c(16777259, new o1());     // Catch: Throwable -> L27
        b.c(16777261, new p1());     // Catch: Throwable -> L27
        b.c(16777263, new r1());     // Catch: Throwable -> L27
        b.c(16777264, new s1());     // Catch: Throwable -> L27
        b.c(16777265, new t1());     // Catch: Throwable -> L27
        b.c(16777266, new u1());     // Catch: Throwable -> L27
        b.c(16777268, new v1());     // Catch: Throwable -> L27
        b.c(16777270, new w1());     // Catch: Throwable -> L27
        b.c(16777269, new x1());     // Catch: Throwable -> L27
        b.c(16777267, new y1());     // Catch: Throwable -> L27
        b.c(16777271, new z1());     // Catch: Throwable -> L27
        b.c(16777272, new a2());     // Catch: Throwable -> L27
        b.c(16777273, new c2());     // Catch: Throwable -> L27
        b.c(16777274, new d2());     // Catch: Throwable -> L27
        b.c(16777275, new e2());     // Catch: Throwable -> L27
        b.c(16777276, new f2());     // Catch: Throwable -> L27
        b.c(16777277, new g2());     // Catch: Throwable -> L27
        b.c(16777278, new h2());     // Catch: Throwable -> L27
        if (c0.h() == false) goto L15;
        b.a r1 = new c4();     // Catch: Throwable -> L27
    L16:
        b.c(InputDeviceCompat.SOURCE_HDMI, r1);     // Catch: Throwable -> L27
        if (r19 == false) goto L19;
    L22:
        b.a r5 = new y3();     // Catch: Throwable -> L27
    L21:
        b.c(33554434, r5);     // Catch: Throwable -> L27
        l.a();     // Catch: Throwable -> L27
        com.bytedance.mobsec.metasec.ml.e.a();     // Catch: Throwable -> L27
        goto L24
    L19:
        if (c0.h() == false) goto L22;
        r5 = new l2();     // Catch: Throwable -> L27
        goto L21
    L15:
        r1 = new y3();     // Catch: Throwable -> L27
    L24:
        f22449d = System.currentTimeMillis() - r2;     // Catch: Throwable -> L27
        int r3 = b.f22318b;     // Catch: Throwable -> L27
        m.a(16777219, 0, 0, null, r9);     // Catch: Throwable -> L27
        f22446a = System.currentTimeMillis() - r2;     // Catch: Throwable -> L27
        f22450e = true;     // Catch: Throwable -> L27
    L25:
        monitor-exit(p2.class);
    }

    public static synchronized boolean d(Context r9, i0 r10, String r11) {
        monitor-enter(p2.class);
        if (r9 == null) goto L55;
        if (r10 == null) goto L53;
        String r1 = r10.f22373a;     // Catch: Throwable -> L56
        if (r1 != null) goto L9;
    L11:
        String r2 = r10.f22379g;     // Catch: Throwable -> L56
    L12:
        if (r2 == null) goto L51;
        if (r2.length() <= 0) goto L51;
        String r3 = r10.n.get("kSt");     // Catch: Throwable -> L56
        if (r3 != null) goto L18;
    L20:
        boolean r4 = false;
    L21:
        c(r9, r11, r4);     // Catch: Throwable -> L56
        if (f22451f.containsKey(r2) == false) goto L25;
        monitor-exit(p2.class);
        return false;
    L25:
        monitor-enter(r10);     // Catch: Throwable -> L56
        JSONArray r12 = new JSONArray();     // Catch: Throwable -> L47
        r12.put(r10.a(r10.f22373a));     // Catch: Throwable -> L47
        r12.put(r10.a(r10.f22380h));     // Catch: Throwable -> L47
        r12.put(r10.a(r10.f22379g));     // Catch: Throwable -> L47
        r12.put(r10.a(r10.f22381i));     // Catch: Throwable -> L47
        r12.put(r10.a(o4.a()));     // Catch: Throwable -> L47
        r12.put(r10.a(r10.f22374b));     // Catch: Throwable -> L47
        r12.put(r10.a(r10.f22375c));     // Catch: Throwable -> L47
        r12.put(r10.a(r10.f22376d));     // Catch: Throwable -> L47
        r12.put(r10.a(r10.f22377e));     // Catch: Throwable -> L47
        r12.put(r10.a(r10.f22378f));     // Catch: Throwable -> L47
        r12.put(String.valueOf(r10.f22382j));     // Catch: Throwable -> L47
        r12.put(String.valueOf(r10.f22383k));     // Catch: Throwable -> L47
        r12.put(String.valueOf(r10.f22384l));     // Catch: Throwable -> L47
        r12.put(r10.a(r10.p));     // Catch: Throwable -> L47
        r12.put(String.valueOf(r10.q));     // Catch: Throwable -> L47
        JSONArray r5 = new JSONArray();     // Catch: Throwable -> L47
        Iterator<Map.Entry<String, String>> r6 = r10.m.entrySet().iterator();     // Catch: Throwable -> L47
    L28:
        if (r6.hasNext() == false) goto L32;
        Map.Entry<String, String> r7 = r6.next();     // Catch: Throwable -> L47
        if (TextUtils.isEmpty(r7.getKey()) == true) goto L28;
        r5.put(r10.a(r7.getKey()));     // Catch: Throwable -> L47
        r5.put(r10.a(r7.getValue()));     // Catch: Throwable -> L47
        goto L28
    L32:
        r12.put(r5);     // Catch: Throwable -> L47
        JSONArray r8 = new JSONArray();     // Catch: Throwable -> L47
        Iterator<Map.Entry<String, String>> r13 = r10.n.entrySet().iterator();     // Catch: Throwable -> L47
    L34:
        if (r13.hasNext() == false) goto L38;
        Map.Entry<String, String> r14 = r13.next();     // Catch: Throwable -> L47
        if (TextUtils.isEmpty(r14.getKey()) == true) goto L34;
        r8.put(r10.a(r14.getKey()));     // Catch: Throwable -> L47
        r8.put(r10.a(r14.getValue()));     // Catch: Throwable -> L47
        goto L34
    L38:
        r12.put(r8);     // Catch: Throwable -> L47
        String r15 = r12.toString();     // Catch: Throwable -> L47
        monitor-exit(r10);     // Catch: Throwable -> L56
        long r16 = System.currentTimeMillis();     // Catch: Throwable -> L56
        boolean r17 = ((Boolean) b.b(67108865, r15)).booleanValue();     // Catch: Throwable -> L56
        f22447b = System.currentTimeMillis() - r16;     // Catch: Throwable -> L56
        if (r17 == true) goto L44;
        monitor-exit(p2.class);
        return false;
    L44:
        f22451f.put(r2, r10);     // Catch: Throwable -> L56
        b(r9, r2, r10);     // Catch: Throwable -> L56
        monitor-exit(p2.class);
        return true;
    L47:
        th = move-exception;
        throw th;     // Catch: Throwable -> L56
    L18:
        if (r3.equals(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L20;
        r4 = true;
    L51:
        throw new NullPointerException("appID must be set");     // Catch: Throwable -> L56
    L9:
        if (r1.length() <= 0) goto L11;
        r2 = r10.f22373a;     // Catch: Throwable -> L56
        goto L12
    L53:
        throw new NullPointerException("config could not be null");     // Catch: Throwable -> L56
    L55:
        throw new NullPointerException("context could not be null");     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        throw th;
    }

    private static void e(Context r6, i0 r7, String r8) {
        f0.a(r6);
        y4.e(r6).g();
        e4.m();
    L4:
        if (r7.o == null) goto L42;
        String r9 = r7.f22375c;
        if (r9 != null) goto L9;
    L11:
        String r4 = r7.o.a();
        if (r4 == null) goto L30;
        if (r4.isEmpty() == true) goto L30;
        Object r10 = b.b(67108866, r8);
        if (r10 == null) goto L4;
        String r11 = r7.f22375c;
        if (r11 != null) goto L22;
    L24:
        r7.b(r4);
        m.a(33554446, 0, ((Long) r10).longValue(), r4, 0);
        return;
    L22:
        if (r11.isEmpty() == true) goto L24;
        return;
    L30:
        Thread.sleep(500);     // Catch: InterruptedException -> L29
        goto L4
    L9:
        if (r9.isEmpty() == true) goto L11;
        return;
    }

    public static /* synthetic */ void f(Context r0, i0 r1, String r2) {
        e(r0, r1, r2);
    }
}

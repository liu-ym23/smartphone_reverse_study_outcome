package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j5 {
    private static ConcurrentHashMap<String, Boolean> A = null;
    private static ConcurrentHashMap<String, Boolean> B = null;
    private static ArrayList<r0.a> C = null;
    private static volatile boolean D = false;
    private static Queue<r0.c> E = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f7422a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f7423b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f7424c = "6";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f7425d = "4";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f7426e = "9";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f7427f = "8";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Context f7428g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile boolean f7429h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Vector<f> f7430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Map<String, Integer> f7431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f7432k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static long f7433l;
    public static volatile boolean m;
    private static volatile ConcurrentHashMap<String, h> n;
    private static volatile ConcurrentHashMap<String, Long> o;
    private static volatile ConcurrentHashMap<String, e> p;
    private static boolean q;
    private static boolean r;
    public static int s;
    public static boolean t;
    public static boolean u;
    private static int v;
    public static boolean w;
    public static boolean x;
    private static int y;
    public static boolean z;

    final class a extends s1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f7434g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f7435h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f7436i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f7437j;

        a(String r1, String r2, String r3, String r4) {
            this.f7434g = r1;
            this.f7435h = r2;
            this.f7436i = r3;
            this.f7437j = r4;
        }

        @Override // com.loc.s1
        public final void b() {
            e r0 = (e) j5.T().get(this.f7434g);
            if (r0 != null) goto L5;
            return;
        L5:
            b r1 = r0.f7449c;
            t5 r3 = r0.f7447a;
            String r4 = r0.f7448b;
            c r8 = j5.b(j5.f7428g, r3, r4, this.f7435h, this.f7436i, this.f7437j);
            if (r8 == null) goto L10;
            if (r1 == null) goto L11;
            r1.a(r8);
            return;
        L11:
            return;
        }
    }

    public interface b {
        void a(c r1);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Deprecated
        public JSONObject f7438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public JSONObject f7439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7440c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f7441d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public a f7442e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b f7443f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f7444g;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f7445a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public JSONObject f7446b;

            public a() {
            }
        }

        public static class b {
            public b() {
            }
        }

        public c() {
            this.f7440c = 0;
        }

        static /* synthetic */ boolean a(c r0, boolean r1) {
            r0.f7444g = r1;
            return r1;
        }
    }

    static class d extends p0 {
        private String o;
        private Map<String, String> p;
        private String q;
        private String r;
        private String s;

        d(Context r1, t5 r2, String r3, String r4, String r5, String r6) {
            super(r1, r2);
            this.o = r3;
            this.p = null;
            this.q = r4;
            this.r = r5;
            this.s = r6;
            f(t0.c.f7815g);
            d(t0.a.f7804i);
        }

        private static String U(String r1, String r2) {
            if (TextUtils.isEmpty(r2) == true) goto L9;
            return Uri.parse(r1).buildUpon().encodedAuthority(r2).build().toString();
        L9:
            return r1;
        L10:
            return r1;
        }

        @Override // com.loc.p0
        public final byte[] O() {
            return null;
        }

        @Override // com.loc.p0
        public final byte[] P() {
            String r0 = l5.Z(this.f7589l);
            if (TextUtils.isEmpty(r0) == true) goto L5;
            r0 = p5.a(new StringBuilder(r0).reverse().toString());
        L5:
            HashMap r1 = new HashMap();
            if (TextUtils.isEmpty(this.o) == false) goto L8;
            String r2 = "";
        L9:
            r1.put("authkey", r2);
            r1.put("plattype", "android");
            r1.put("ccver", LocationInfoConst.ALLOW_USE_LOCATION);
            r1.put("product", this.m.a());
            r1.put("version", this.m.e());
            r1.put("output", "json");
            StringBuilder r3 = new StringBuilder();
            r3.append(Build.VERSION.SDK_INT);
            r1.put("androidversion", r3.toString());
            r1.put("deviceId", r0);
            r1.put("manufacture", Build.MANUFACTURER);
            Map<String, String> r4 = this.p;
            if (r4 != null) goto L12;
        L14:
            r1.put("abitype", u5.d(this.f7589l));
            r1.put("ext", this.m.g());
            return u5.o(u5.f(r1));
        L12:
            if (r4.isEmpty() == true) goto L14;
            r1.putAll(this.p);
            goto L14
        L8:
            r2 = this.o;
            goto L9
        }

        @Override // com.loc.p0
        protected final String Q() {
            return "3.0";
        }

        @Override // com.loc.t0
        public final Map<String, String> b() {
            if (TextUtils.isEmpty(this.s) == true) goto L6;
            HashMap r0 = new HashMap();
            r0.put("host", this.s);
            return r0;
        L6:
            return null;
        }

        @Override // com.loc.t0
        public final String j() {
            return U("https://restsdk.amap.com/v3/iasdkauth", this.q);
        }

        @Override // com.loc.o5, com.loc.t0
        public final String m() {
            return U("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.r);
        }

        @Override // com.loc.t0
        protected final String s() {
            if (TextUtils.isEmpty(this.s) == true) goto L7;
            return this.s;
        L7:
            return super.s();
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        t5 f7447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f7448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        b f7449c;

        private e() {
        }

        /* synthetic */ e(byte r1) {
            this();
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private AtomicInteger f7452c;

        public f(String r1, String r2, int r3) {
            this.f7450a = r1;
            this.f7451b = r2;
            this.f7452c = new AtomicInteger(r3);
        }

        static /* synthetic */ String b(f r0) {
            return r0.f7451b;
        }

        public static f d(String r5) {
            if (TextUtils.isEmpty(r5) == false) goto L8;
            return null;
        L8:
            JSONObject r0 = new JSONObject(r5);     // Catch: Throwable -> L7
            return new f(r0.optString("a"), r0.optString("f"), r0.optInt("h"));
        L7:
            return null;
        }

        static /* synthetic */ AtomicInteger f(f r0) {
            return r0.f7452c;
        }

        static /* synthetic */ String g(f r0) {
            return r0.f7450a;
        }

        public final int a() {
            AtomicInteger r0 = this.f7452c;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.get();
        }

        public final void c(String r1) {
            this.f7451b = r1;
        }

        public final String e() {
            JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
            r0.put("a", this.f7450a);     // Catch: Throwable -> L4
            r0.put("f", this.f7451b);     // Catch: Throwable -> L4
            r0.put("h", this.f7452c.get());     // Catch: Throwable -> L4
            return r0.toString();
        L4:
            return "";
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f7453a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static boolean f7454b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static boolean f7455c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static int f7456d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static boolean f7457e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static int f7458f;

        static {
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f7459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7460b;

        h(Long r3, String r4) {
            this.f7459a = 0;
            this.f7460b = "";
            this.f7459a = r3.longValue();
            this.f7460b = r4;
        }
    }

    static {
        f7430i = new Vector();
        f7431j = new HashMap();
        f7432k = null;
        f7433l = 0;
        m = false;
        n = new ConcurrentHashMap(8);
        o = new ConcurrentHashMap(8);
        p = new ConcurrentHashMap(8);
        q = false;
        r = false;
        s = 5000;
        t = true;
        u = false;
        v = 3;
        w = true;
        x = false;
        y = 3;
        z = false;
        A = new ConcurrentHashMap();
        B = new ConcurrentHashMap();
        C = new ArrayList();
        E = new LinkedList();
    }

    private static String A(List<String> r1) {
        if (r1 != null) goto L11;
        return "";
    L11:
        if (r1.size() <= 0) goto L13;
        String r2 = r1.get(0);     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r2) == true) goto L14;
        return r2;
    L14:
        return "";
    L13:
        return "";
    L15:
        return "";
    }

    public static void B(Context r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        f7429h = d0.m(r3, "open_common", "a2", true);
    }

    public static void C(r0.c r10) {
        ArrayList<r0.a> r0 = C;
        monitor-enter(r0);
        int r1 = 0;
        boolean r2 = false;
    L25:
    L22:
        th = move-exception;
        throw th;
    L6:
        if (r1 >= C.size()) goto L17;
        r0.a r3 = C.get(r1);     // Catch: Throwable -> L22
        if (r10.f7712h.equals(r3.f7702g) == false) goto L16;
        if (r10.f7713i.equals(r3.f7705j) == false) goto L16;
        int r4 = r10.r;     // Catch: Throwable -> L22
        int r6 = r3.f7706k;     // Catch: Throwable -> L22
        if (r4 != r6) goto L16;
        if (r6 != 1) goto L15;
        r3.n = ((((long) r3.o.get()) * r3.n) + r10.f7715k) / ((long) (r3.o.get() + 1));     // Catch: Throwable -> L22
    L15:
        r3.o.getAndIncrement();     // Catch: Throwable -> L22
        r2 = true;
    L16:
        r1 = r1 + 1;     // Catch: Throwable -> L22
        goto L25
    L17:
        if (r2 == true) goto L19;
        C.add(new r0.a(r10));     // Catch: Throwable -> L22
    L19:
        r0.g();     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
    }

    public static synchronized void D(String r2, boolean r3) {
        monitor-enter(j5.class);
        p(r2, r3, null, null, null);     // Catch: Throwable -> L8
        monitor-exit(j5.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static boolean E() {
        Context r0 = f7428g;
        if (r0 != null) goto L5;
        return false;
    L5:
        String r1 = l5.X(r0);
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return false;
    L8:
        Integer r2 = f7431j.get(r1.toUpperCase());
        if (r2 != null) goto L12;
        return false;
    L12:
        if (r2.intValue() != 2) goto L15;
        return true;
    L15:
        return false;
    }

    public static String F(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return r1;
    L5:
        return r1 + ";15K;16H;17I;1A4;17S;183";
    }

    private static void G(Context r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        t = d0.m(r4, "open_common", "a13", true);
        w = d0.m(r4, "open_common", "a6", true);
        u = d0.m(r4, "open_common", "a7", false);
        s = d0.b(r4, "open_common", "a8", 5000);
        v = d0.b(r4, "open_common", "a9", 3);
        x = d0.m(r4, "open_common", "a10", false);
        y = d0.b(r4, "open_common", "a11", 3);
        z = d0.m(r4, "open_common", "a12", false);
    }

    public static void H(r0.c r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (z == true) goto L7;
        return;
    L7:
        Queue<r0.c> r0 = E;
        monitor-enter(r0);
        E.offer(r2);     // Catch: Throwable -> L12
        r0.g();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static boolean I() {
        Context r0 = f7428g;
        if (r0 != null) goto L5;
        return false;
    L5:
        String r1 = l5.X(r0);
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return false;
    L8:
        Integer r2 = f7431j.get(r1.toUpperCase());
        if (r2 != null) goto L12;
        return false;
    L12:
        if (r2.intValue() < 2) goto L15;
        return true;
    L15:
        return false;
    }

    public static void J() {
        f r2 = c(f7428g, "IPV6_CONFIG_NAME", "open_common");     // Catch: Throwable -> L7
        String r3 = u5.c(System.currentTimeMillis(), "yyyyMMdd");     // Catch: Throwable -> L7
        if (r3.equals(f.b(r2)) == true) goto L5;
        r2.c(r3);     // Catch: Throwable -> L7
        f.f(r2).set(0);     // Catch: Throwable -> L7
    L5:
        f.f(r2).incrementAndGet();     // Catch: Throwable -> L7
        k(f7428g, "IPV6_CONFIG_NAME", "open_common", r2);     // Catch: Throwable -> L7
        return;
    }

    private static void K(Context r3) {
        if (q == false) goto L6;
        return;
    L6:
        com.loc.g.f7306e = d0.m(r3, "open_common", "a4", true);     // Catch: Throwable -> L8
        com.loc.g.f7307f = d0.m(r3, "open_common", "a5", true);     // Catch: Throwable -> L8
        q = true;     // Catch: Throwable -> L8
        return;
    }

    public static synchronized boolean L(String r5) {
        monitor-enter(j5.class);
    L24:
        th = move-exception;
        s.e(th, "at", "cslct");     // Catch: Throwable -> L28
    L26:
        monitor-exit(j5.class);
        return false;
    L28:
        th = move-exception;
        throw th;
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L10;
        monitor-exit(j5.class);
        return false;
    L10:
        if (p != null) goto L14;
        monitor-exit(j5.class);
        return false;
    L14:
        if (o != null) goto L17;
        o = new ConcurrentHashMap(8);     // Catch: Throwable -> L24
    L17:
        if (p.containsKey(r5) == false) goto L26;
        if (o.containsKey(r5) == true) goto L26;
        o.put(r5, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L24
        monitor-exit(j5.class);
        return true;
    }

    public static void M() {
        if (m == false) goto L11;
        return;
    L11:
        Context r1 = f7428g;     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        return;
    L8:
        m = true;     // Catch: Throwable -> L10
        n5.a().c(r1);     // Catch: Throwable -> L10
        B(r1);     // Catch: Throwable -> L10
        G(r1);     // Catch: Throwable -> L10
        g.f7453a = d0.m(r1, "open_common", "ucf", g.f7453a);     // Catch: Throwable -> L10
        g.f7454b = d0.m(r1, "open_common", "fsv2", g.f7454b);     // Catch: Throwable -> L10
        g.f7455c = d0.m(r1, "open_common", "usc", g.f7455c);     // Catch: Throwable -> L10
        g.f7456d = d0.b(r1, "open_common", "umv", g.f7456d);     // Catch: Throwable -> L10
        g.f7457e = d0.m(r1, "open_common", "ust", g.f7457e);     // Catch: Throwable -> L10
        g.f7458f = d0.b(r1, "open_common", "ustv", g.f7458f);     // Catch: Throwable -> L10
        return;
    }

    private static void N(Context r5) {
        if (r == false) goto L6;
        return;
    L6:
        w5.f7948d = v(d0.p(r5, "open_common", "a16", ""), true);     // Catch: Throwable -> L8
        w5.f7946b = d0.c(r5, "open_common", "a17", w5.f7945a);     // Catch: Throwable -> L8
        r = true;     // Catch: Throwable -> L8
        return;
    }

    public static synchronized void O(String r2) {
        monitor-enter(j5.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (o != null) goto L9;
        monitor-exit(j5.class);
        return;
    L9:
        if (o.containsKey(r2) == false) goto L11;
        o.remove(r2);     // Catch: Throwable -> L13
    L11:
        monitor-exit(j5.class);
    }

    public static r0.a P() {
        if (D == false) goto L5;
        return null;
    L5:
        ArrayList<r0.a> r0 = C;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (D == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return null;
    L11:
        Collections.sort(C);     // Catch: Throwable -> L18
        if (C.size() <= 0) goto L16;
        r0.a r1 = C.get(0).a();     // Catch: Throwable -> L18
        D = true;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r1;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return null;
    }

    public static synchronized h Q(String r3) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.loc.j5> r0 = com.loc.j5.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.j5$h> r1 = com.loc.j5.n     // Catch: java.lang.Throwable -> L22
            if (r1 != 0) goto L10
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap     // Catch: java.lang.Throwable -> L22
            r2 = 8
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L22
            com.loc.j5.n = r1     // Catch: java.lang.Throwable -> L22
        L10:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.j5$h> r1 = com.loc.j5.n     // Catch: java.lang.Throwable -> L22
            boolean r1 = r1.containsKey(r3)     // Catch: java.lang.Throwable -> L22
            if (r1 == 0) goto L2a
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.j5$h> r1 = com.loc.j5.n     // Catch: java.lang.Throwable -> L22
            java.lang.Object r3 = r1.get(r3)     // Catch: java.lang.Throwable -> L22
            com.loc.j5$h r3 = (com.loc.j5.h) r3     // Catch: java.lang.Throwable -> L22
            monitor-exit(r0)
            return r3
        L22:
            r3 = move-exception
            java.lang.String r1 = "at"
            java.lang.String r2 = "glcut"
            com.loc.s.e(r3, r1, r2)     // Catch: java.lang.Throwable -> L39
        L2a:
            com.loc.j5$h r3 = new com.loc.j5$h     // Catch: java.lang.Throwable -> L39
            r1 = 0
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L39
            java.lang.String r2 = ""
            r3.<init>(r1, r2)     // Catch: java.lang.Throwable -> L39
            monitor-exit(r0)
            return r3
        L39:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.j5.Q(java.lang.String):com.loc.j5$h");
    }

    public static r0.c R() {
        Queue<r0.c> r0 = E;
        monitor-enter(r0);
        r0.c r1 = E.poll();     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean S(String r4) {
    L25:
        return true;
    L4:
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return true;
    L7:
        if (t == true) goto L10;
        return false;
    L10:
        if (A.get(r4) != null) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        return false;
    L15:
        Context r2 = f7428g;     // Catch: Throwable -> L25
        if (r2 != null) goto L18;
        return true;
    L18:
        f r5 = c(r2, z(r4, "a14"), "open_common");     // Catch: Throwable -> L25
        if (r5 != null) goto L21;
        return true;
    L21:
        if (r5.a() >= v) goto L24;
        return true;
    L24:
        return false;
    L12:
        r1 = false;
        goto L13
    }

    static /* synthetic */ ConcurrentHashMap T() {
        return p;
    }

    public static boolean U(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return false;
    L7:
        if (x == true) goto L10;
        return false;
    L10:
        if (B.get(r4) != null) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        return false;
    L15:
        Context r2 = f7428g;     // Catch: Throwable -> L25
        if (r2 != null) goto L18;
        return true;
    L18:
        f r5 = c(r2, z(r4, "a15"), "open_common");     // Catch: Throwable -> L25
        if (r5 != null) goto L21;
        return true;
    L21:
        if (r5.a() >= y) goto L24;
        return true;
    L12:
        r1 = false;
    L24:
        return false;
    }

    private static void V() {
        Context r0 = f7428g;     // Catch: Throwable -> L51
        if (r0 == null) goto L17;
        String r1 = l5.X(r0);     // Catch: Throwable -> L51
        if (TextUtils.isEmpty(f7432k) == true) goto L14;
        if (TextUtils.isEmpty(r1) == true) goto L14;
        if (f7432k.equals(r1) == false) goto L14;
        if ((System.currentTimeMillis() - f7433l) >= 60000) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r1) == true) goto L19;
        f7432k = r1;     // Catch: Throwable -> L51
    L19:
        f7433l = System.currentTimeMillis();     // Catch: Throwable -> L51
        f7431j.clear();     // Catch: Throwable -> L51
        Iterator r2 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Throwable -> L51
    L20:
        if (r2.hasNext() == false) goto L50;
        NetworkInterface r3 = (NetworkInterface) r2.next();     // Catch: Throwable -> L51
        if (r3.getInterfaceAddresses().isEmpty() == true) goto L20;
        String r4 = r3.getDisplayName();     // Catch: Throwable -> L51
        int r5 = 0;
        Iterator<InterfaceAddress> r6 = r3.getInterfaceAddresses().iterator();     // Catch: Throwable -> L51
    L26:
        if (r6.hasNext() == false) goto L39;
        InetAddress r7 = r6.next().getAddress();     // Catch: Throwable -> L51
        if ((r7 instanceof Inet6Address) == true) goto L30;
        if ((r7 instanceof Inet4Address) == false) goto L26;
        Inet4Address r8 = (Inet4Address) r7;     // Catch: Throwable -> L51
        if (w(r8) == true) goto L26;
        if (r8.getHostAddress().startsWith(u5.u("FMTkyLjE2OC40My4")) == true) goto L26;
        r5 = r5 | 1;     // Catch: Throwable -> L51
        goto L26
    L30:
        if (w((Inet6Address) r7) == true) goto L26;
        r5 = r5 | 2;     // Catch: Throwable -> L51
        goto L26
    L39:
        if (r5 == 0) goto L20;
        if (r4 != null) goto L42;
    L45:
        if (r4 == null) goto L20;
        if (r4.startsWith("rmnet") == false) goto L20;
        Map<String, Integer> r9 = f7431j;     // Catch: Throwable -> L51
        String r10 = "MOBILE";
        Integer r11 = Integer.valueOf(r5);     // Catch: Throwable -> L51
    L44:
        r9.put(r10, r11);     // Catch: Throwable -> L51
        goto L20
    L42:
        if (r4.startsWith("wlan") == false) goto L45;
        r9 = f7431j;     // Catch: Throwable -> L51
        r10 = "WIFI";
        r11 = Integer.valueOf(r5);     // Catch: Throwable -> L51
        goto L44
    L50:
        return;
    L17:
        if ((System.currentTimeMillis() - f7433l) >= BDLocationConfig.sScanBleMaxInterval) goto L19;
        return;
    L51:
        th = move-exception;
        s.e(th, "at", "ipstack");
    }

    public static long a(List<String> r2) {
        if (r2 == null) goto L15;
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L4:
        if (r2.size() <= 0) goto L16;
        String r3 = r2.get(0);     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r3) == true) goto L17;
        return Long.valueOf(r3).longValue();
    L17:
        return 0;
    L16:
        return 0;
    L15:
        return 0;
    }

    public static c b(Context r0, t5 r1, String r2, String r3, String r4, String r5) {
        return x(r0, r1, r2, r3, r4, r5);
    }

    private static synchronized f c(Context r6, String r7, String r8) {
        monitor-enter(j5.class);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L15;
        int r1 = 0;
    L8:
        if (r1 >= f7430i.size()) goto L15;
        f r4 = f7430i.get(r1);     // Catch: Throwable -> L31
        if (r4 == null) goto L14;
        if (r7.equals(f.g(r4)) == false) goto L14;
    L16:
        if (r4 == null) goto L19;
        monitor-exit(j5.class);
        return r4;
    L19:
        if (r6 != null) goto L22;
        monitor-exit(j5.class);
        return null;
    L22:
        f r9 = f.d(d0.p(r6, r8, r7, ""));     // Catch: Throwable -> L31
        String r10 = u5.c(System.currentTimeMillis(), "yyyyMMdd");     // Catch: Throwable -> L31
        if (r9 != null) goto L26;
        r9 = new f(r7, r10, 0);     // Catch: Throwable -> L31
    L26:
        if (r10.equals(f.b(r9)) == true) goto L28;
        r9.c(r10);     // Catch: Throwable -> L31
        f.f(r9).set(0);     // Catch: Throwable -> L31
    L28:
        f7430i.add(r9);     // Catch: Throwable -> L31
        monitor-exit(j5.class);
        return r9;
    L14:
        r1 = r1 + 1;
    L15:
        r4 = null;
        goto L16
    }

    public static String d(String r1) {
        if (p.containsKey(r1) == false) goto L8;
        e r2 = p.get(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.f7448b;
    L8:
        return null;
    }

    public static void e(Context r0) {
        if (r0 == null) goto L5;
        f7428g = r0.getApplicationContext();
        return;
    }

    private static void f(Context r3, t5 r4, String r5) {
        HashMap r0 = new HashMap();
        r0.put("amap_sdk_auth_fail", LocationInfoConst.ALLOW_USE_LOCATION);
        r0.put("amap_sdk_auth_fail_type", r5);
        r0.put("amap_sdk_name", r4.a());
        r0.put("amap_sdk_version", r4.f());
        String r6 = new JSONObject(r0).toString();
        if (TextUtils.isEmpty(r6) == false) goto L8;
        return;
    L8:
        z0 r7 = new z0(r3, "core", "2.0", "O001");     // Catch: h5 -> L7
        r7.a(r6);     // Catch: h5 -> L7
        a1.d(r7, r3);     // Catch: h5 -> L7
        return;
    }

    public static synchronized void g(Context r4, t5 r5, String r6, b r7) {
        monitor-enter(j5.class);
        if (r4 == null) goto L35;
        if (r5 == null) goto L35;
    L28:
        th = move-exception;
        s.e(th, "at", "rglc");     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    L8:
        if (f7428g != null) goto L10;
        f7428g = r4.getApplicationContext();     // Catch: Throwable -> L28
    L10:
        String r8 = r5.a();     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r8) == false) goto L14;
        monitor-exit(j5.class);
        return;
    L14:
        m(r5);     // Catch: Throwable -> L28
        if (p != null) goto L18;
        p = new ConcurrentHashMap(8);     // Catch: Throwable -> L28
    L18:
        if (o != null) goto L21;
        o = new ConcurrentHashMap(8);     // Catch: Throwable -> L28
    L21:
        if (n != null) goto L24;
        n = new ConcurrentHashMap(8);     // Catch: Throwable -> L28
    L24:
        if (p.containsKey(r8) == true) goto L26;
        e r1 = new e(0);     // Catch: Throwable -> L28
        r1.f7447a = r5;     // Catch: Throwable -> L28
        r1.f7448b = r6;     // Catch: Throwable -> L28
        r1.f7449c = r7;     // Catch: Throwable -> L28
        p.put(r8, r1);     // Catch: Throwable -> L28
        long r9 = d0.c(f7428g, "open_common", r8, 0);     // Catch: Throwable -> L28
        n.put(r8, new h(Long.valueOf(r9), d0.p(f7428g, "open_common", r8 + "lct-info", "")));     // Catch: Throwable -> L28
        K(f7428g);     // Catch: Throwable -> L28
        N(f7428g);     // Catch: Throwable -> L28
    L26:
        monitor-exit(j5.class);
        return;
    L35:
        monitor-exit(j5.class);
    }

    private static void h(Context r18, t5 r19, String r20, c r21, JSONObject r22) {
        c.a r10 = new c.a();
        r10.f7445a = false;
        r21.f7442e = r10;
        String[] r0 = r20.split(";");     // Catch: Throwable -> L13
        if (r0 == null) goto L16;
        if (r0.length <= 0) goto L16;
        int r12 = r0.length;     // Catch: Throwable -> L13
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L16;
        String r14 = r0[r13];     // Catch: Throwable -> L13
        if (r22.has(r14) == false) goto L12;
        r21.f7441d.putOpt(r14, r22.get(r14));     // Catch: Throwable -> L13
    L12:
        r13 = r13 + 1;
    L16:
        if (u5.m(r22, "16H") == false) goto L22;
        c.a(r21, v(r22.getJSONObject("16H").optString("able"), false));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        s.e(th, "AuthConfigManager", "load 16H");
    L22:
        if (u5.m(r22, "11K") == false) goto L30;
        JSONObject r1 = r22.getJSONObject("11K");     // Catch: Throwable -> L27
        r10.f7445a = v(r1.getString("able"), false);     // Catch: Throwable -> L27
        if (r1.has("off") == false) goto L30;
        r10.f7446b = r1.getJSONObject("off");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        s.e(th, "AuthConfigManager", "load 11K");
    L30:
        if (u5.m(r22, "145") == false) goto L36;
        r21.f7438a = r22.getJSONObject("145");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        s.e(th, "AuthConfigManager", "load 145");
    L36:
        if (u5.m(r22, "14D") == false) goto L42;
        r21.f7439b = r22.getJSONObject("14D");     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        s.e(th, "AuthConfigManager", "load 14D");
    L42:
        if (u5.m(r22, "151") == false) goto L51;
        JSONObject r2 = r22.getJSONObject("151");     // Catch: Throwable -> L48
        c.b r9 = new c.b();     // Catch: Throwable -> L48
        if (r2 == null) goto L46;
        v(r2.optString("able"), false);     // Catch: Throwable -> L48
    L46:
        r21.f7443f = r9;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        s.e(th, "AuthConfigManager", "load 151");
    L51:
        if (u5.m(r22, "17S") == true) goto L155;
    L93:
        String r16 = "ust";
        String r17 = "umv";
    L95:
        if (u5.m(r22, "15K") == true) goto L159;
    L116:
        Context r3 = r18;
    L118:
        if (u5.m(r22, "183") == false) goto L124;
        q0.d(r19, r22.getJSONObject("183"));     // Catch: Throwable -> L121
    L121:
        th = move-exception;
        s.e(th, "AuthConfigManager", "load 183");
    L124:
        if (u5.m(r22, "17I") == false) goto L130;
        JSONObject r4 = r22.getJSONObject("17I");     // Catch: Throwable -> L127
        boolean r5 = v(r4.optString("na"), false);     // Catch: Throwable -> L127
        boolean r6 = v(r4.optString("aa"), false);     // Catch: Throwable -> L127
        com.loc.g.f7306e = r5;     // Catch: Throwable -> L127
        com.loc.g.f7307f = r6;     // Catch: Throwable -> L127
        SharedPreferences.Editor r7 = d0.d(r3, "open_common");     // Catch: Throwable -> L127
        d0.l(r7, "a4", r5);     // Catch: Throwable -> L127
        d0.l(r7, "a5", r6);     // Catch: Throwable -> L127
        d0.g(r7);     // Catch: Throwable -> L127
    L127:
        th = move-exception;
        s.e(th, "AuthConfigManager", "load 17I");
    L130:
        if (u5.m(r22, "1A4") == false) goto L168;
        JSONObject r8 = r22.getJSONObject("1A4");     // Catch: Throwable -> L133
        String r11 = r8.optString("ada");     // Catch: Throwable -> L133
        boolean r15 = v(r11, w5.f7947c);     // Catch: Throwable -> L133
        long r23 = r8.optLong("iv", w5.f7945a);     // Catch: Throwable -> L133
        w5.f7948d = r15;     // Catch: Throwable -> L133
        w5.f7946b = r23;     // Catch: Throwable -> L133
        SharedPreferences.Editor r24 = d0.d(r3, "open_common");     // Catch: Throwable -> L133
        d0.k(r24, "a16", r11);     // Catch: Throwable -> L133
        d0.j(r24, "a17", r23);     // Catch: Throwable -> L133
        d0.g(r24);     // Catch: Throwable -> L133
        return;
    L133:
        th = move-exception;
        s.e(th, "AuthConfigManager", "load 1A4");
        return;
    L168:
        return;
    L159:
        JSONObject r25 = r22.getJSONObject("15K");     // Catch: Throwable -> L114
        if (r25 == null) goto L116;
        boolean r26 = v(r25.optString("ucf"), g.f7453a);     // Catch: Throwable -> L114
        boolean r27 = v(r25.optString("fsv2"), g.f7454b);     // Catch: Throwable -> L114
        boolean r28 = v(r25.optString("usc"), g.f7455c);     // Catch: Throwable -> L114
        String r110 = r17;
        int r29 = r25.optInt(r110, g.f7456d);     // Catch: Throwable -> L114
        String r111 = r16;
        boolean r112 = v(r25.optString(r111), g.f7457e);     // Catch: Throwable -> L114
        int r30 = r25.optInt("ustv", g.f7458f);     // Catch: Throwable -> L114
        if (r26 == g.f7453a) goto L101;
    L110:
        g.f7453a = r26;     // Catch: Throwable -> L114
        g.f7454b = r27;     // Catch: Throwable -> L114
        g.f7455c = r28;     // Catch: Throwable -> L114
        g.f7456d = r29;     // Catch: Throwable -> L114
        g.f7457e = r112;     // Catch: Throwable -> L114
        g.f7458f = r30;     // Catch: Throwable -> L114
        r3 = r18;
        SharedPreferences.Editor r31 = d0.d(r3, "open_common");     // Catch: Throwable -> L136
        d0.l(r31, "ucf", g.f7453a);     // Catch: Throwable -> L136
        d0.l(r31, "fsv2", g.f7454b);     // Catch: Throwable -> L136
        d0.l(r31, "usc", g.f7455c);     // Catch: Throwable -> L136
        d0.i(r31, r110, g.f7456d);     // Catch: Throwable -> L136
        d0.l(r31, r111, g.f7457e);     // Catch: Throwable -> L136
        d0.i(r31, "ustv", g.f7458f);     // Catch: Throwable -> L136
        d0.g(r31);     // Catch: Throwable -> L136
        goto L118
    L101:
        if (r27 != g.f7454b) goto L110;
        if (r28 != g.f7455c) goto L110;
        if (r29 != g.f7456d) goto L110;
        if (r112 != g.f7457e) goto L110;
        if (r30 == g.f7456d) goto L116;
    L114:
        th = move-exception;
        r3 = r18;
        s.e(th, "AuthConfigManager", "load 15K");
        goto L118
    L155:
        JSONObject r32 = r22.getJSONObject("17S");     // Catch: Throwable -> L89
        if (r32 == null) goto L59;
        boolean r33 = v(r32.optString("able"), false);     // Catch: Throwable -> L89
        if (r33 == f7429h) goto L59;
        f7429h = r33;     // Catch: Throwable -> L89
        if (r18 == null) goto L59;
        SharedPreferences.Editor r113 = d0.d(r18, "open_common");     // Catch: Throwable -> L89
        d0.l(r113, "a2", r33);     // Catch: Throwable -> L89
        d0.g(r113);     // Catch: Throwable -> L89
    L59:
        if (r32 == null) goto L93;
        boolean r34 = v(r32.optString("static_enable"), true);     // Catch: Throwable -> L89
        boolean r114 = v(r32.optString("static_ip_direct_enable"), false);     // Catch: Throwable -> L89
        int r115 = r32.optInt("static_timeout", 5) * 1000;     // Catch: Throwable -> L89
        int r116 = r32.optInt("static_retry", 3);     // Catch: Throwable -> L89
        boolean r117 = v(r32.optString("bgp_enable"), true);     // Catch: Throwable -> L89
        r16 = "ust";
        boolean r118 = v(r32.optString("bgp_ip_direct_enable"), false);     // Catch: Throwable -> L87
        r17 = "umv";
        int r35 = r32.optInt("bgp_retry", 3);     // Catch: Throwable -> L85
        boolean r36 = v(r32.optString("perf_data_upload_enable"), false);     // Catch: Throwable -> L85
        if (r34 == t) goto L67;
    L80:
        t = r34;     // Catch: Throwable -> L85
        u = r114;     // Catch: Throwable -> L85
        s = r115;     // Catch: Throwable -> L85
        v = r116;     // Catch: Throwable -> L85
        w = r117;     // Catch: Throwable -> L85
        x = r118;     // Catch: Throwable -> L85
        y = r35;     // Catch: Throwable -> L85
        z = r36;     // Catch: Throwable -> L85
        if (r18 == null) goto L83;
        SharedPreferences.Editor r37 = d0.d(r18, "open_common");     // Catch: Throwable -> L85
        d0.l(r37, "a13", r34);     // Catch: Throwable -> L85
        d0.l(r37, "a6", r117);     // Catch: Throwable -> L85
        d0.l(r37, "a7", r114);     // Catch: Throwable -> L85
        d0.i(r37, "a8", r115);     // Catch: Throwable -> L85
        d0.i(r37, "a9", r116);     // Catch: Throwable -> L85
        d0.l(r37, "a10", r118);     // Catch: Throwable -> L85
        d0.i(r37, "a11", r35);     // Catch: Throwable -> L85
        d0.l(r37, "a12", r36);     // Catch: Throwable -> L85
        d0.g(r37);     // Catch: Throwable -> L85
    L83:
        new StringBuilder("static_enable=").append(t);     // Catch: Throwable -> L85
        r0.g();     // Catch: Throwable -> L85
        new StringBuilder("bgp_enable=").append(w);     // Catch: Throwable -> L85
        r0.g();     // Catch: Throwable -> L85
        new StringBuilder("static_ip_direct_enable=").append(u);     // Catch: Throwable -> L85
        r0.g();     // Catch: Throwable -> L85
        new StringBuilder("bgp_ip_direct_enable=").append(x);     // Catch: Throwable -> L85
        r0.g();     // Catch: Throwable -> L85
        new StringBuilder("perf_data_upload_enable=").append(z);     // Catch: Throwable -> L85
        r0.g();     // Catch: Throwable -> L85
        goto L95
    L67:
        if (r114 != u) goto L80;
        if (r115 != s) goto L80;
        if (r116 != v) goto L80;
        if (r117 != w) goto L80;
        if (r118 != x) goto L80;
        if (r35 != y) goto L80;
        if (r36 == z) goto L83;
    L85:
        th = th;
    L92:
        s.e(th, "AuthConfigManager", "load 17S");
    L87:
        th = th;
    L91:
        r17 = "umv";
    L89:
        th = th;
        r16 = "ust";
    L13:
        th = move-exception;
        s.e(th, "at", "co");
        goto L16
    }

    private static void i(Context r0, t5 r1, Throwable r2) {
        f(r0, r1, r2.getMessage());
    }

    public static void j(Context r0, String r1) {
        i5.b(r0, r1);
    }

    private static void k(Context r1, String r2, String r3, f r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(f.g(r4)) == true) goto L14;
        String r5 = r4.e();
        if (TextUtils.isEmpty(r5) == false) goto L9;
        return;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        SharedPreferences.Editor r6 = d0.d(r1, r3);
        r6.putString(r2, r5);
        d0.g(r6);
        return;
    }

    public static void l(r0.c r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (f7428g == null) goto L15;
        HashMap r0 = new HashMap();
        r0.put("serverip", r5.f7712h);
        r0.put("hostname", r5.f7714j);
        r0.put("path", r5.f7713i);
        r0.put("csid", r5.f7710f);
        r0.put("degrade", String.valueOf(r5.f7711g.a()));
        r0.put("errorcode", String.valueOf(r5.r));
        r0.put("errorsubcode", String.valueOf(r5.s));
        r0.put("connecttime", String.valueOf(r5.m));
        r0.put("writetime", String.valueOf(r5.n));
        r0.put("readtime", String.valueOf(r5.o));
        r0.put("datasize", String.valueOf(r5.q));
        r0.put("totaltime", String.valueOf(r5.f7715k));
        String r6 = new JSONObject(r0).toString();
        "--埋点--".concat(String.valueOf(r6));
        r0.g();
        if (TextUtils.isEmpty(r6) == false) goto L12;
        return;
    L12:
        z0 r1 = new z0(f7428g, "core", "2.0", "O008");     // Catch: h5 -> L11
        r1.a(r6);     // Catch: h5 -> L11
        a1.d(r1, f7428g);     // Catch: h5 -> L11
        return;
    L16:
        return;
    }

    private static void m(t5 r2) {
        if (r2 == null) goto L17;
        if (TextUtils.isEmpty(r2.a()) == false) goto L6;
        return;
    L6:
        String r0 = r2.f();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r0) == false) goto L10;
        r0 = r2.e();     // Catch: Throwable -> L14
    L10:
        if (TextUtils.isEmpty(r0) == false) goto L12;
        return;
    L12:
        com.loc.g.b(r2.a(), r0);     // Catch: Throwable -> L14
        return;
    L18:
        return;
    }

    private static synchronized void n(String r4, long r5, String r7) {
        monitor-enter(j5.class);
    L19:
        th = move-exception;
        s.e(th, "at", "ucut");     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    L5:
        if (p != null) goto L7;
    L17:
        monitor-exit(j5.class);
        return;
    L7:
        if (p.containsKey(r4) == false) goto L17;
        if (n != null) goto L12;
        n = new ConcurrentHashMap(8);     // Catch: Throwable -> L19
    L12:
        n.put(r4, new h(Long.valueOf(r5), r7));     // Catch: Throwable -> L19
        Context r1 = f7428g;     // Catch: Throwable -> L19
        if (r1 == null) goto L15;
        SharedPreferences.Editor r2 = d0.d(r1, "open_common");     // Catch: Throwable -> L19
        d0.j(r2, r4, r5);     // Catch: Throwable -> L19
        d0.k(r2, r4 + "lct-info", r7);     // Catch: Throwable -> L19
        d0.g(r2);     // Catch: Throwable -> L19
    L15:
        monitor-exit(j5.class);
    }

    private static void o(String r4, String r5) {
        f r0 = c(f7428g, r4, r5);
        String r1 = u5.c(System.currentTimeMillis(), "yyyyMMdd");
        if (r1.equals(f.b(r0)) == true) goto L5;
        r0.c(r1);
        f.f(r0).set(0);
    L5:
        f.f(r0).incrementAndGet();
        k(f7428g, r4, r5, r0);
    }

    public static synchronized void p(String r4, boolean r5, String r6, String r7, String r8) {
        monitor-enter(j5.class);
    L29:
        th = move-exception;
        s.e(th, "at", "lca");     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        monitor-exit(j5.class);
        return;
    L9:
        if (o != null) goto L11;
        o = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L11:
        o.put(r4, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L29
        if (p != null) goto L16;
        monitor-exit(j5.class);
        return;
    L16:
        if (p.containsKey(r4) == true) goto L20;
        monitor-exit(j5.class);
        return;
    L20:
        if (TextUtils.isEmpty(r4) == false) goto L23;
        monitor-exit(j5.class);
        return;
    L23:
        if (r5 == true) goto L25;
    L26:
        r1.f().d(new a(r4, r6, r7, r8));     // Catch: Throwable -> L29
        monitor-exit(j5.class);
        return;
    L25:
        q0.j(true, r4);     // Catch: Throwable -> L29
        goto L26
    }

    public static void q(String r4, boolean r5, boolean r6, boolean r7) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        if (f7428g == null) goto L32;
        HashMap r0 = new HashMap();
        r0.put(WsConstants.KEY_CONNECTION_URL, r4);
        r0.put("downLevel", String.valueOf(r5));
        int r8 = l5.M(f7428g);
        String r1 = BDLocationException.ERROR_TIMEOUT;
        if (r8 != 0) goto L10;
        Object r9 = BDLocationException.ERROR_TIMEOUT;
    L11:
        r0.put("ant", r9);
        if (r7 == false) goto L16;
        if (r5 == false) goto L15;
        String r10 = f7426e;
    L19:
        r0.put(WsConstants.KEY_CONNECTION_TYPE, r10);
        if (r6 == true) goto L23;
        r1 = LocationInfoConst.ALLOW_USE_LOCATION;
    L23:
        r0.put("status", r1);
        String r11 = new JSONObject(r0).toString();
        if (TextUtils.isEmpty(r11) == false) goto L29;
        return;
    L29:
        z0 r12 = new z0(f7428g, "core", "2.0", "O002");     // Catch: h5 -> L28
        r12.a(r11);     // Catch: h5 -> L28
        a1.d(r12, f7428g);     // Catch: h5 -> L28
        return;
    L33:
        return;
    L15:
        r10 = f7427f;
        goto L19
    L16:
        if (r5 == false) goto L18;
        r10 = f7424c;
        goto L19
    L18:
        r10 = f7425d;
        goto L19
    L10:
        r9 = LocationInfoConst.ALLOW_USE_LOCATION;
        goto L11
    }

    public static void r(boolean r4, r0.a r5) {
        if (D == false) goto L33;
        if (r5 == null) goto L46;
        ArrayList<r0.a> r0 = C;
        monitor-enter(r0);
        if (r4 == true) goto L34;
    L23:
        D = false;     // Catch: Throwable -> L30
        Iterator<r0.a> r6 = C.iterator();     // Catch: Throwable -> L30
    L24:
        r0.g();     // Catch: Throwable -> L30
        if (r6.hasNext() == false) goto L27;
        r0.a r7 = r6.next();     // Catch: Throwable -> L30
        StringBuilder r1 = new StringBuilder("----path=");     // Catch: Throwable -> L30
        r1.append(r7.f7705j);     // Catch: Throwable -> L30
        r1.append("-counts=");     // Catch: Throwable -> L30
        r1.append(r7.o);     // Catch: Throwable -> L30
        r1.append("-code=");     // Catch: Throwable -> L30
        r1.append(r7.f7706k);     // Catch: Throwable -> L30
        r1.append("----");     // Catch: Throwable -> L30
        goto L24
    L27:
        r0.g();     // Catch: Throwable -> L30
        monitor-exit(r0);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L34:
        Iterator<r0.a> r8 = C.iterator();     // Catch: Throwable -> L30
    L11:
        if (r8.hasNext() == false) goto L23;
        r0.a r2 = r8.next();     // Catch: Throwable -> L30
        if (r2.f7702g.equals(r5.f7702g) == false) goto L11;
        if (r2.f7705j.equals(r5.f7705j) == false) goto L11;
        if (r2.f7706k != r5.f7706k) goto L11;
        if (r2.o != r5.o) goto L22;
        r8.remove();     // Catch: Throwable -> L30
    L21:
        r0.g();     // Catch: Throwable -> L30
        goto L11
    L22:
        r2.o.set(r2.o.get() - r5.o.get());     // Catch: Throwable -> L30
        goto L21
    L46:
        return;
    }

    public static void s(boolean r3, String r4) {
        Boolean r0 = Boolean.TRUE;
        "--markHostNameFailed---hostname=".concat(String.valueOf(r4));     // Catch: Throwable -> L26
        r0.g();     // Catch: Throwable -> L26
        if (t == true) goto L8;
        if (r3 == true) goto L8;
        return;
    L8:
        if (x == true) goto L12;
        if (r3 == false) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(r4) == false) goto L15;
        return;
    L15:
        if (r3 == true) goto L22;
        if (A.get(r4) == null) goto L19;
        return;
    L19:
        A.put(r4, r0);     // Catch: Throwable -> L26
        o(z(r4, "a14"), "open_common");     // Catch: Throwable -> L26
        return;
    L22:
        if (B.get(r4) == null) goto L24;
        return;
    L24:
        B.put(r4, r0);     // Catch: Throwable -> L26
        o(z(r4, "a15"), "open_common");     // Catch: Throwable -> L26
        return;
    }

    public static boolean t() {
        if (f7428g == null) goto L11;
        V();
        if (I() == true) goto L8;
        return false;
    L8:
        if (E() == false) goto L11;
        return true;
    L11:
        if (f7429h == true) goto L13;
        return false;
    L13:
        f r0 = c(f7428g, "IPV6_CONFIG_NAME", "open_common");
        if (r0 != null) goto L17;
        return false;
    L17:
        if (r0.a() >= 5) goto L19;
        return true;
    L19:
        return false;
    }

    public static synchronized boolean u(String r7, long r8) {
        monitor-enter(j5.class);
        boolean r1 = false;
        if (TextUtils.isEmpty(r7) == false) goto L9;
        monitor-exit(j5.class);
        return false;
    L9:
        h r2 = Q(r7);     // Catch: Throwable -> L26
        long r3 = 0;
        if (r2 == null) goto L12;
        long r5 = r2.f7459a;     // Catch: Throwable -> L26
    L14:
        if (r8 == r5) goto L24;
        if (o != null) goto L18;
    L20:
        if ((SystemClock.elapsedRealtime() - r3) <= 30000) goto L24;
        r1 = true;
        goto L24
    L18:
        if (o.containsKey(r7) == false) goto L20;
        r3 = o.get(r7).longValue();     // Catch: Throwable -> L26
        goto L20
    L12:
        r5 = 0;
    L24:
        monitor-exit(j5.class);
        return r1;
    }

    public static boolean v(String r2, boolean r3) {
    L10:
        return r3;
    L3:
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return r3;
    L5:
        String[] r4 = URLDecoder.decode(r2).split("/");     // Catch: Throwable -> L10
        if ((r4[r4.length - 1].charAt(4) % 2) != 1) goto L8;
        return true;
    L8:
        return false;
    }

    private static boolean w(InetAddress r1) {
        if (r1.isLoopbackAddress() == false) goto L5;
        return true;
    L5:
        if (r1.isLinkLocalAddress() == false) goto L7;
        return true;
    L7:
        if (r1.isAnyLocalAddress() == true) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.loc.j5$c] */
    /* JADX WARN: Type inference failed for: r12v14, types: [com.loc.j5$c] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    private static c x(Context r22, t5 r23, String r24, String r25, String r26, String r27) {
        String r10 = "infocode";
        ?? r12 = "result";
        String r13 = "ver";
        c r5 = new c();
        r5.f7441d = new JSONObject();
        if (r22 == null) goto L5;
        f7428g = r22.getApplicationContext();
    L5:
        M();
        String r16 = null;
        m(r23);     // Catch: Throwable -> L63 IllegalBlockSizeException -> L67 h5 -> L71
        new o0();     // Catch: Throwable -> L63 IllegalBlockSizeException -> L67 h5 -> L71
        boolean r0 = TextUtils.isEmpty(r24);     // Catch: Throwable -> L63 IllegalBlockSizeException -> L67 h5 -> L71
        if (r0 == false) goto L135;
        String r17 = r24;
    L137:
        K(r22);     // Catch: Throwable -> L123 h5 -> L54
        N(r22);     // Catch: Throwable -> L123 h5 -> L54
        String r19 = "result";
        r12 = r5;
        String r20 = "ver";
        r13 = "at";
        String r21 = "infocode";
        r10 = "lc";
        u0 r1 = o0.c(new d(r22, r23, r17, r25, r26, r27));     // Catch: h5 -> L50 Throwable -> L122
        if (r0 == false) goto L20;
        return r12;
    L20:
        if (r1 != null) goto L144;
        byte[] r2 = null;
    L42:
        byte[] r3 = new byte[16];     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 h5 -> L48
        byte[] r4 = new byte[r2.length - 16];     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 h5 -> L48
        System.arraycopy(r2, 0, r3, 0, 16);     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 h5 -> L48
        System.arraycopy(r2, 16, r4, 0, r2.length - 16);     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 h5 -> L48
        SecretKeySpec r6 = new SecretKeySpec(r3, u5.u("EQUVT"));     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 h5 -> L48
        Cipher r7 = Cipher.getInstance(u5.u("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 h5 -> L48
        r7.init(2, r6, new IvParameterSpec(u5.v()));     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 h5 -> L48
        r16 = u5.g(r7.doFinal(r4));     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 h5 -> L48
        ?? r14 = r12;
    L75:
        String r8 = r17;
        if (r2 != null) goto L79;
        return r14;
    L79:
        if (TextUtils.isEmpty(r16) == false) goto L81;
        r16 = u5.g(r2);
    L81:
        String r9 = r16;
        if (TextUtils.isEmpty(r9) == false) goto L126;
        f(r22, r23, "result is null");
    L126:
        JSONObject r15 = new JSONObject(r9);     // Catch: Throwable -> L118
        if (r15.has("status") == false) goto L120;
        int r11 = r15.getInt("status");     // Catch: Throwable -> L118
        if (r11 != 1) goto L89;
        f7422a = 1;     // Catch: Throwable -> L118
    L103:
        String r18 = r20;
    L108:
        th = move-exception;
        s.e(th, r13, r10);     // Catch: Throwable -> L118
    L110:
        String r28 = r19;
        if (u5.m(r15, r28) == false) goto L120;
        JSONObject r29 = r15.getJSONObject(r28);     // Catch: Throwable -> L118
        h(r22, r23, r8, r14, r29);     // Catch: Throwable -> L118
        JSONObject r30 = r29.getJSONObject("15K");     // Catch: Throwable -> L121
        boolean r31 = v(r30.optString("isTargetAble"), false);     // Catch: Throwable -> L121
        if (v(r30.optString("able"), false) == true) goto L116;
        n5.a();     // Catch: Throwable -> L121
        n5.f(r22);     // Catch: Throwable -> L121
    L130:
        goto L120
    L116:
        n5.a().d(r22, r31);     // Catch: Throwable -> L121
        goto L130
    L105:
        if (r15.has(r18) == false) goto L110;
        r15.getInt(r18);     // Catch: Throwable -> L108
    L89:
        if (r11 != 0) goto L103;
        if (r1 == null) goto L93;
        String r32 = r1.f7858c;     // Catch: Throwable -> L118
        String r33 = r1.f7859d;     // Catch: Throwable -> L118
    L94:
        u5.i(r22, r32, r33, r15);     // Catch: Throwable -> L118
        f7422a = 0;     // Catch: Throwable -> L118
        if (r15.has(LocationMonitorConst.INFO) == false) goto L97;
        f7423b = r15.getString(LocationMonitorConst.INFO);     // Catch: Throwable -> L118
    L97:
        String r34 = "";
        String r35 = r21;
        if (r15.has(r35) == false) goto L100;
        r34 = r15.getString(r35);     // Catch: Throwable -> L118
    L100:
        v.j(r23, "/v3/iasdkauth", f7423b, r33, r32, r34);     // Catch: Throwable -> L118
        if (f7422a != 0) goto L103;
        return r14;
    L93:
        r32 = "authcsid";
        r33 = "authgsid";
    L120:
        return r14;
    L118:
        th = move-exception;
        s.e(th, r13, r10);
        goto L120
    L48:
        e = e;
    L74:
        e.a();
        f(r22, r23, e.a());
        v.h(r23, "/v3/iasdkauth", e);
        r14 = r12;
    L46:
        e = e;
    L70:
        i(r22, r23, e);
        r14 = r12;
    L44:
        e = th;
    L66:
        v.m(e, r13, r10);
        goto L70
    L144:
        r2 = r1.f7856a;     // Catch: Throwable -> L35 IllegalBlockSizeException -> L37 h5 -> L39
        Map<String, List<String>> r36 = r1.f7857b;     // Catch: Throwable -> L33
        if (r36 == null) goto L42;
        if (r36.containsKey("lct") == false) goto L42;
        List<String> r37 = r36.get("lct");     // Catch: Throwable -> L33
        List<String> r38 = r36.get("lct-info");     // Catch: Throwable -> L33
        r12.f7440c = a(r37);     // Catch: Throwable -> L33
        String r39 = A(r38);     // Catch: Throwable -> L33
        if (r12.f7440c == 0) goto L42;
        if (r23 == null) goto L42;
        String r40 = r23.a();     // Catch: Throwable -> L33
        if (TextUtils.isEmpty(r40) == true) goto L42;
        n(r40, r12.f7440c, r39);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 h5 -> L48
        v.m(th, r13, "lct");     // Catch: Throwable -> L44 IllegalBlockSizeException -> L46 h5 -> L48
        goto L42
    L39:
        e = e;
        r2 = null;
    L37:
        e = e;
        r2 = null;
    L35:
        e = th;
        r2 = null;
        goto L66
    L50:
        e = move-exception;
        throw e;     // Catch: Throwable -> L57 IllegalBlockSizeException -> L59 h5 -> L61
    L54:
        e = e;
    L56:
        throw e;     // Catch: Throwable -> L57 IllegalBlockSizeException -> L59 h5 -> L61
    L53:
        throw new h5("未知的错误");     // Catch: Throwable -> L57 IllegalBlockSizeException -> L59 h5 -> L61
    L135:
        r17 = F(r24);     // Catch: Throwable -> L10 h5 -> L12
        goto L137
    L12:
        e = e;
    L61:
        e = e;
    L73:
        r1 = null;
        r2 = null;
    L59:
        e = e;
    L69:
        r1 = null;
        r2 = null;
    L57:
        e = th;
    L65:
        r1 = null;
        r2 = null;
        goto L66
    L71:
        e = e;
        r21 = "infocode";
        r19 = "result";
        r20 = "ver";
        r12 = r5;
        r13 = "at";
        r10 = "lc";
        r17 = r24;
    L67:
        e = e;
        r21 = "infocode";
        r19 = "result";
        r20 = "ver";
        r12 = r5;
        r13 = "at";
        r10 = "lc";
        r17 = r24;
    L63:
        e = th;
        r21 = "infocode";
        r19 = "result";
        r20 = "ver";
        r12 = r5;
        r13 = "at";
        r10 = "lc";
        r17 = r24;
        goto L65
    }

    public static t5 y(String r1) {
        e r2 = p.get(r1);
        if (r2 != null) goto L5;
        return null;
    L5:
        return r2.f7447a;
    }

    private static String z(String r1, String r2) {
        return r2 + "_" + p5.b(r1.getBytes());
    }
}

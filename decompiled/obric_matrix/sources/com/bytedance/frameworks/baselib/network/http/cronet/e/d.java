package com.bytedance.frameworks.baselib.network.http.cronet.e;

import android.net.Uri;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.reflect.Reflect;
import com.obric.matrix.account.http.Resp;
import com.obric.matrix.common_api.INetworkApi;
import d.b.r.y;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class d extends c implements WeakHandler.IHandler {
    private static HandlerThread N;
    private static boolean O;
    private static Class P;
    private static String Q;
    private volatile boolean A;
    private volatile HttpURLConnection B;
    private volatile int C;
    private volatile HttpURLConnection D;
    private List<a> E;
    private volatile int F;
    private CountDownLatch G;
    private WeakHandler H;
    private long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f4711J;
    private boolean K;
    private long L;
    private long M;
    private String p;
    private Set<String> q;
    private String r;
    private a s;
    private String t;
    private String u;
    private String v;
    private List<String> w;
    private final Object x;
    private volatile AtomicInteger y;
    private List<HttpURLConnection> z;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f4713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f4714c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f4715d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f4716e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f4717f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        IOException f4718g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f4719h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        long f4720i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Boolean f4721j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        long f4722k;

        a(String r4) {
            this.f4712a = -1;
            this.f4713b = r4;
            this.f4714c = System.currentTimeMillis();
            this.f4716e = 0;
            this.f4717f = -1;
            this.f4719h = "";
            this.f4720i = -1;
            this.f4721j = Boolean.FALSE;
            this.f4722k = -1;
        }

        JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put("host", this.f4713b);     // Catch: JSONException -> L18
            r0.put("start", this.f4714c);     // Catch: JSONException -> L18
            r0.put("end", this.f4715d);     // Catch: JSONException -> L18
            r0.put("net_error", this.f4716e);     // Catch: JSONException -> L18
            r0.put("code", this.f4717f);     // Catch: JSONException -> L18
            IOException r1 = this.f4718g;     // Catch: JSONException -> L18
            if (r1 == null) goto L11;
            String r2 = r1.getMessage();     // Catch: JSONException -> L18
            if (TextUtils.isEmpty(r2) == false) goto L8;
        L10:
            r0.put("exception", r2);     // Catch: JSONException -> L18
            goto L11
        L8:
            if (r2.length() <= 64) goto L10;
            r2 = r2.substring(0, 64);     // Catch: JSONException -> L18
        L11:
            r0.put("dispatch", this.f4720i);     // Catch: JSONException -> L18
            r0.put("dpHost", this.f4719h);     // Catch: JSONException -> L18
            if (this.f4721j.booleanValue() == false) goto L14;
            r0.put("sentAlready", true);     // Catch: JSONException -> L18
        L14:
            long r3 = this.f4722k;     // Catch: JSONException -> L18
            if (r3 <= 0) goto L17;
            r0.put("cleanUpTime", r3);     // Catch: JSONException -> L18
        L17:
            return r0;
        }
    }

    static {
        N = new HandlerThread("Concurrent-Handler");
        Q = null;
        P = Class.forName("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl");     // Catch: ClassNotFoundException -> L5
    L7:
        N.start();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public d(d.b.r.h0.c r10, g.a r11) {
        super(r10);
        this.q = new CopyOnWriteArraySet();
        this.r = "";
        this.s = null;
        this.w = new ArrayList();
        this.x = new Object();
        int r2 = 0;
        this.y = new AtomicInteger(0);
        this.z = new CopyOnWriteArrayList();
        this.A = false;
        this.B = null;
        this.C = -1;
        this.D = null;
        this.E = new CopyOnWriteArrayList();
        this.F = 0;
        this.G = new CountDownLatch(1);
        this.H = new WeakHandler(N.getLooper(), this);
        this.K = false;
        this.L = 0;
        String r0 = r10.G();
        this.p = r0;
        Uri r1 = Uri.parse(r0);
        String r3 = r1.getScheme();
        String r4 = r3 + "://" + r1.getHost();
        String r5 = r1.getQuery();
        Iterator<String> r6 = r11.a().iterator();
    L4:
        if (r6.hasNext() == false) goto L15;
        String r7 = this.p.replaceFirst(r4, r3 + "://" + r6.next());
        if (TextUtils.isEmpty(r5) == true) goto L14;
        if (r5.contains("concurrent=") == true) goto L10;
        r7 = r7 + "&concurrent=" + r2;
    L10:
        if (r2 <= 0) goto L14;
        if (r5.contains("is_retry=") == true) goto L14;
        r7 = r7 + "&is_retry=1";
    L14:
        r2 = r2 + 1;
        this.w.add(r7);
        goto L4
    L15:
        this.t = UUID.randomUUID().toString();
        this.u = r11.f4735i;
        this.v = r11.p;
        this.I = r11.m;
        O = r11.n;
        this.f4711J = r11.o;
        this.L = r11.r;
        this.K = r11.q;
        p0(r10);
        Logger.debug();
        y r12 = this.f13419g.Y;
        if (r12 == null) goto L24;
        r12.f14624k = this.t;
        r12.f14625l = true;
        return;
    }

    private static boolean A0(int r3, String r4, String r5) {
        if (r3 < 200) goto L6;
        if (r3 >= 300) goto L6;
        return false;
    L6:
        if (r4 != null) goto L8;
    L10:
        if (r3 < 300) goto L17;
        if (r3 >= 600) goto L17;
        if (O == true) goto L17;
        return false;
    L17:
        if (g.d().c(r3, r5) == false) goto L19;
        return false;
    L19:
        return true;
    L8:
        if (r4.equals(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L10;
        return false;
    }

    private void n0() {
        Message r0 = Message.obtain();
        r0.what = 1;
        r0.obj = this;
        this.H.sendMessage(r0);
    }

    private void o0() {
        this.H.removeCallbacksAndMessages(null);
        Object r0 = this.x;
        monitor-enter(r0);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (this.A == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L29
        return;
    L8:
        Iterator<HttpURLConnection> r1 = this.z.iterator();     // Catch: Throwable -> L29
    L10:
        if (r1.hasNext() == false) goto L23;
        HttpURLConnection r2 = r1.next();     // Catch: Throwable -> L29
        if (r2 == null) goto L10;
        Iterator<a> r3 = this.E.iterator();     // Catch: Throwable -> L29
    L15:
        if (r3.hasNext() == false) goto L22;
        a r4 = r3.next();     // Catch: Throwable -> L29
        if (r4.f4712a != r2.hashCode()) goto L15;
        r4.f4715d = System.currentTimeMillis();     // Catch: Throwable -> L29
        if (this.K == false) goto L21;
        r4.f4722k = System.currentTimeMillis();     // Catch: Throwable -> L29
        goto L22
    L21:
        r4.f4716e = Resp.CODE_UNKNOWN;     // Catch: Throwable -> L29
        r4.f4718g = new IOException("cleanupMessagesAndPendingConnections");     // Catch: Throwable -> L29
    L22:
        r2.disconnect();     // Catch: Throwable -> L29
        this.z.remove(r2);     // Catch: Throwable -> L29
        goto L10
    L23:
        y r5 = this.f13419g.Y;     // Catch: Throwable -> L29
        if (r5 == null) goto L26;
        r5.f14623j = x0();     // Catch: Throwable -> L29
    L26:
        this.A = true;     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
    }

    private void p0(d.b.r.h0.c r7) {
        this.M = d.b.h.a.a.h.g.i() + d.b.h.a.a.h.g.o();
        if ((r7.t() instanceof d.b.h.a.a.h.c) == false) goto L12;
        d.b.h.a.a.h.c r8 = (d.b.h.a.a.h.c) r7.t();
        long r0 = r8.f13374i;
        if (r0 <= 0) goto L7;
    L6:
        this.M = r0;
        goto L12
    L7:
        long r1 = r8.f13368c;
        if (r1 <= 0) goto L12;
        long r4 = r8.f13369d;
        if (r4 <= 0) goto L12;
        r0 = r1 + r4;
    L12:
        this.M += 1000;
    }

    private String q0(String r5, a r6) {
        if (r6 != null) goto L5;
        return "";
    L5:
        long r0 = System.currentTimeMillis();
        String r4 = j.f0(r5, -1, true).a();     // Catch: Exception -> L14
        r6.f4720i = System.currentTimeMillis() - r0;
        r6.f4719h = new URI(r4).getHost();     // Catch: URISyntaxException -> L11
        Logger.debug();
        return r6.f4719h;
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private void r0() {
        d.b.h.a.a.g.a r6 = new d.b.h.a.a.g.a("Concurrent-Call", d.b.h.a.a.g.d.a.f13310j, 0, new b(this), this.f13419g.G);
        d.b.h.a.a.g.g.c().a(r6);
        y0(this.I);
    }

    private void s0() {
        if (this.H.obtainMessage(0) == null) goto L6;
        this.H.removeMessages(0);
        r0();
        return;
    }

    private IOException u0(Exception r9, String r10, HttpURLConnection r11, boolean r12) {
        if (this.K == false) goto L5;
    L12:
        int r0 = 0;
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r9.getClass().getName()) == false) goto L15;
    L16:
        r0 = j.l(r11);
    L18:
        if (TextUtils.isEmpty(r10) == false) goto L20;
        r10 = this.p;
    L20:
        String r5 = r10;
        if (r12 == false) goto L23;
        d.b.h.a.a.h.m.b.T(r5, this.f13419g, this, this, r9);
    L37:
        f(this.f13418f, r9);     // Catch: d.b.h.a.a.h.l.e -> L35
        e r13 = new e(r9, this.f13419g, r0);
        if (r12 == true) goto L29;
        boolean r2 = false;
        boolean r3 = false;
        boolean r4 = false;
    L33:
        d.b.h.a.a.h.b r7 = this.f13419g;
        r13.a(r2, r3, r4, r5, r7.Z, r7);
        return r13;
    L29:
        if (this.f13418f.N() == false) goto L31;
        this.f13419g.V.set(true);
    L31:
        r2 = true;
        r3 = false;
        r4 = true;
    L35:
        e = move-exception;
        return e;
    L23:
        if (r11 == null) goto L37;
        r11.disconnect();
        goto L37
    L15:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r9.getClass().getName()) == false) goto L18;
    L5:
        if ((r9 instanceof IOException) == false) goto L12;
        if (r9.getMessage() == null) goto L12;
        if (r9.getMessage().startsWith("request canceled") == false) goto L12;
        return (IOException) r9;
    }

    private /* synthetic */ void v0() {
        long r0 = SystemClock.uptimeMillis();
        HttpURLConnection r2 = null;
        String r3 = null;
        r2 = null;
        r2 = null;
        Object r4 = this.x;     // Catch: IOException -> L89
        monitor-enter(r4);     // Catch: IOException -> L89
    L81:
        th = th;
        String r5 = null;
        a r6 = null;
    L83:
        monitor-exit(r4);     // Catch: Throwable -> L87
        throw th;     // Catch: IOException -> L85
    L85:
        e = e;
        HttpURLConnection r7 = r2;
    L91:
        IOException e2 = e;
    L92:
        Object r8 = this.x;
        monitor-enter(r8);
        int r9 = -1;
        Class r10 = P;     // Catch: Throwable -> L134
        if (r10 == null) goto L142;
        if (r10.isInstance(e2) == false) goto L142;
        r9 = ((Integer) Reflect.on(e2).call("getCronetInternalErrorCode").get()).intValue();     // Catch: Throwable -> L134
        Logger.debug();     // Catch: Throwable -> L134
    L142:
    L131:
        th = move-exception;
        throw th;
    L101:
        if (this.D != null) goto L103;
        Logger.debug();     // Catch: Throwable -> L131
        this.D = r7;     // Catch: Throwable -> L131
    L104:
        if (r7 == null) goto L109;
        r7.disconnect();     // Catch: Throwable -> L131
        if (r6 == null) goto L108;
        r6.f4718g = u0(e2, r5, r7, false);     // Catch: Throwable -> L131
        r6.f4716e = r9;     // Catch: Throwable -> L131
        r6.f4715d = System.currentTimeMillis();     // Catch: Throwable -> L131
    L108:
        this.z.remove(r7);     // Catch: Throwable -> L131
    L109:
        int r11 = this.F + 1;     // Catch: Throwable -> L131
        this.F = r11;     // Catch: Throwable -> L131
        if (r11 < this.w.size()) goto L115;
        Logger.debug();     // Catch: Throwable -> L131
        this.G.countDown();     // Catch: Throwable -> L131
        monitor-exit(r8);     // Catch: Throwable -> L131
        return;
    L115:
        if (this.K == false) goto L122;
        if (this.f13421i == false) goto L122;
        Logger.debug();     // Catch: Throwable -> L131
        this.G.countDown();     // Catch: Throwable -> L131
        monitor-exit(r8);     // Catch: Throwable -> L131
        return;
    L122:
        if (g.d().c(r9, this.u) == false) goto L127;
        Logger.debug();     // Catch: Throwable -> L131
        this.G.countDown();     // Catch: Throwable -> L131
        monitor-exit(r8);     // Catch: Throwable -> L131
        return;
    L127:
        if ((SystemClock.uptimeMillis() - r0) >= this.I) goto L129;
        n0();     // Catch: Throwable -> L131
    L129:
        monitor-exit(r8);     // Catch: Throwable -> L131
        return;
    L103:
        Logger.debug();     // Catch: Throwable -> L131
        goto L104
    L6:
        if (this.y.get() < this.w.size()) goto L8;
    L78:
        this.H.removeCallbacksAndMessages(null);     // Catch: Throwable -> L81
        monitor-exit(r4);     // Catch: Throwable -> L81
        return;
    L8:
        if (this.B != null) goto L78;
        if (this.G.getCount() == 0) goto L78;
        if (this.f13421i == true) goto L78;
        int r12 = this.y.get();     // Catch: Throwable -> L81
        r5 = this.w.get(r12);     // Catch: Throwable -> L81
    L76:
        th = th;
        r6 = null;
        goto L83
    L16:
        if (this.v == null) goto L19;
        if (r12 <= 0) goto L19;
        d.b.h.a.a.h.s.k r13 = new d.b.h.a.a.h.s.k(r5);     // Catch: Throwable -> L76
        r13.b("bypass_rs", LocationInfoConst.ALLOW_USE_LOCATION);     // Catch: Throwable -> L76
        r5 = r13.c();     // Catch: Throwable -> L76
    L19:
        r6 = new a(new URL(r5).getHost());     // Catch: Throwable -> L76
        this.E.add(r6);     // Catch: Throwable -> L87
        if (this.v != null) goto L23;
    L33:
        Logger.debug();     // Catch: Throwable -> L87
        r7 = a0(r5, this.f13419g);     // Catch: Throwable -> L87
        Y(this.f13418f, this.f13419g, r7, null);     // Catch: Throwable -> L74
        if (this.f4711J == true) goto L37;
    L39:
        r7.setRequestProperty("transaction-id", this.t);     // Catch: Throwable -> L74
        this.y.incrementAndGet();     // Catch: Throwable -> L74
        this.z.add(r7);     // Catch: Throwable -> L74
        r6.f4712a = r7.hashCode();     // Catch: Throwable -> L74
        monitor-exit(r4);     // Catch: Throwable -> L74
        this.f4710l = b0(r7);     // Catch: IOException -> L72
        r6.f4717f = this.f4710l;     // Catch: IOException -> L72
        r6.f4715d = System.currentTimeMillis();     // Catch: IOException -> L72
        if (A0(this.f4710l, r7.getHeaderField("tt-api-source-5xx"), this.u) == true) goto L55;
        Object r14 = this.x;     // Catch: IOException -> L72
        monitor-enter(r14);     // Catch: IOException -> L72
    L52:
        th = move-exception;
        throw th;     // Catch: IOException -> L72
    L46:
        if (this.B != null) goto L48;
        this.B = r7;     // Catch: Throwable -> L52
        this.C = r12;     // Catch: Throwable -> L52
        this.p = r5;     // Catch: Throwable -> L52
        Logger.debug();     // Catch: Throwable -> L52
        this.G.countDown();     // Catch: Throwable -> L52
    L50:
        monitor-exit(r14);     // Catch: Throwable -> L52
    L155:
        return;
    L48:
        if (r7 == null) goto L50;
        r7.disconnect();     // Catch: Throwable -> L52
        this.z.remove(r7);     // Catch: Throwable -> L52
        goto L50
    L55:
        String r15 = r7.getResponseMessage();     // Catch: IOException -> L72
        int r16 = this.f13418f.x();     // Catch: Throwable -> L65
        InputStream r17 = r7.getInputStream();     // Catch: Exception -> L59 Throwable -> L65
    L58:
        InputStream r18 = r17;
        String r19 = r7.getHeaderField(INetworkApi.CONTENT_TYPE);     // Catch: Throwable -> L65
        if (TextUtils.isEmpty(r19) == false) goto L63;
        r19 = r7.getHeaderField(INetworkApi.CONTENT_TYPE.toLowerCase());     // Catch: Throwable -> L65
    L63:
        r3 = d.b.h.a.a.h.m.b.J(this.f13419g, r7.getHeaderFields(), r16, r18, r19, false);     // Catch: Throwable -> L65
    L71:
        throw new d.b.h.a.a.h.l.d(this.f4710l, r15, this.f13418f.A(), r3);     // Catch: IOException -> L72
    L59:
        r17 = r7.getErrorStream();     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        StringBuilder r20 = new StringBuilder();     // Catch: IOException -> L72
        r20.append("reason = ");     // Catch: IOException -> L72
        if (r15 != null) goto L69;
        r15 = "";
    L69:
        r20.append(r15);     // Catch: IOException -> L72
        r20.append("  exception = ");     // Catch: IOException -> L72
        r20.append(th.getMessage());     // Catch: IOException -> L72
        r15 = r20.toString();     // Catch: IOException -> L72
    L72:
        e2 = e;
        goto L92
    L37:
        if (this.v != null) goto L39;
        r7.setRequestProperty("x-tt-bp-rs", LocationInfoConst.ALLOW_USE_LOCATION);     // Catch: Throwable -> L74
    L74:
        th = th;
        r2 = r7;
        goto L83
    L23:
        if (t0(r5, r6).booleanValue() == false) goto L33;
        if (r12 <= 0) goto L33;
        this.F++;     // Catch: Throwable -> L87
        if (this.F < this.w.size()) goto L30;
        Logger.debug();     // Catch: Throwable -> L87
        this.G.countDown();     // Catch: Throwable -> L87
        monitor-exit(r4);     // Catch: Throwable -> L87
        return;
    L30:
        this.y.incrementAndGet();     // Catch: Throwable -> L87
        n0();     // Catch: Throwable -> L87
        monitor-exit(r4);     // Catch: Throwable -> L87
        return;
    L87:
        th = th;
    L89:
        e = e;
        r5 = null;
        r6 = null;
        r7 = null;
        goto L91
    }

    private JSONObject x0() {
        JSONObject r0 = new JSONObject();
        r0.put("concurrent", this.E.size() - 1);     // Catch: JSONException -> L14
        r0.put(TypedValues.TransitionType.S_DURATION, System.currentTimeMillis() - this.f13419g.f13361h);     // Catch: JSONException -> L14
        if (this.K == true) goto L6;
    L8:
        JSONArray r1 = new JSONArray();     // Catch: JSONException -> L14
        Iterator<a> r6 = this.E.iterator();     // Catch: JSONException -> L14
    L10:
        if (r6.hasNext() == false) goto L12;
        r1.put(r6.next().a());     // Catch: JSONException -> L14
        goto L10
    L12:
        r0.put("tasks", r1);     // Catch: JSONException -> L14
    L16:
        return r0;
    L6:
        if (TextUtils.isEmpty(Q) == true) goto L8;
        r0.put("call_msg", Q);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    private void y0(long r3) {
        Message r0 = Message.obtain();
        r0.what = 0;
        r0.obj = this;
        this.H.sendMessageDelayed(r0, r3);
    }

    private void z0(String r1, String r2) {
        j.K(r1, r2);     // Catch: Exception -> L4
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.e.c
    public HttpURLConnection Z() {
        if (this.B == null) goto L6;
        return this.B;
    L6:
        return this.D;
    }

    @Override // d.b.r.l0.c
    public void a(Throwable r3, boolean r4) {
        Object r0 = this.x;
        monitor-enter(r0);
        this.G.countDown();     // Catch: Throwable -> L7
        o0();     // Catch: Throwable -> L7
        W(this.B, r3, r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // d.b.r.n
    public void c() {
        d.b.h.a.a.h.m.b.A(this.f13419g, this);
    }

    @Override // d.b.r.h0.e
    public void cancel() {
        Logger.debug();
        Object r0 = this.x;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.K == true) goto L7;
        this.G.countDown();     // Catch: Throwable -> L10
    L7:
        o0();     // Catch: Throwable -> L10
        V(this.B);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.e.c, d.b.r.h0.e
    public boolean d(long r6) {
        super.d(r6);
        if (this.B != null) goto L9;
    L8:
        return true;
    L9:
        Reflect.on(this.B).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r6)});     // Catch: Throwable -> L7
    L7:
        return false;
    }

    @Override // d.b.h.a.a.h.m.b, d.b.r.h0.e
    public d.b.r.h0.d execute() {
        y r0 = this.f13419g.Y;
        if (r0 == null) goto L6;
        r0.s = System.currentTimeMillis();
    L6:
        if (this.f13421i == true) goto L72;
        d.b.h.a.a.h.m.b.R(this.f13418f, this.f13419g);
        d.b.h.a.a.h.m.b.g(e(), x(), this.f13418f.A());
        r0();
        boolean r9 = true;
        long r1 = this.M;     // Catch: Exception -> L62
        if (this.K == false) goto L11;
        r1 = Math.max(r1, this.L);     // Catch: Exception -> L62
    L11:
        this.G.await(r1, TimeUnit.MILLISECONDS);     // Catch: Exception -> L62
        this.G.countDown();     // Catch: Exception -> L62
        Object r2 = this.x;     // Catch: Exception -> L62
        monitor-enter(r2);     // Catch: Exception -> L62
    L59:
        th = move-exception;
        throw th;     // Catch: Exception -> L62
    L14:
        if (this.K == true) goto L21;
        if (this.f13421i == false) goto L21;
        throw new IOException("request canceled");     // Catch: Throwable -> L59
    L21:
        if (this.B != null) goto L34;
        g.d().h(this.u, false);     // Catch: Throwable -> L59
        if (this.E.size() <= 0) goto L30;
        if (this.E.get(0).f4718g == null) goto L30;
        throw this.E.get(0).f4718g;     // Catch: Throwable -> L59
    L30:
        if (this.K == false) goto L33;
        Q = "All urls have been tried and timed out by max wait time.";     // Catch: Throwable -> L59
    L35:
        monitor-exit(r2);     // Catch: Throwable -> L59
        o0();
    L50:
        e = move-exception;
    L53:
        th = th;
    L55:
        if (this.f13418f.N() == false) goto L57;
        if (r9 == true) goto L57;
    L58:
        throw th;
    L57:
        t();
        goto L58
    L52:
        throw u0(e, this.p, this.B, true);     // Catch: Throwable -> L53
    L48:
        th = th;
        r9 = false;
        goto L55
    L38:
        if (this.C > 0) goto L40;
    L42:
        g.d().h(this.u, true);     // Catch: Throwable -> L48 Exception -> L50
        List<String> r3 = N(this.f13418f, this.f13419g, this, true, true);     // Catch: Throwable -> L48 Exception -> L50
        F(this.f13419g, this);     // Catch: Throwable -> L48 Exception -> L50
        d.b.r.k0.i r4 = d.b.h.a.a.h.m.b.L(this.p, this.f13418f, this.f13419g, this, this, this, false);     // Catch: Throwable -> L48 Exception -> L50
        H(r4);     // Catch: Throwable -> L48 Exception -> L50
        d.b.r.h0.d r5 = new d.b.r.h0.d(this.p, this.f4710l, this.B.getResponseMessage(), d.b.h.a.a.h.m.b.i(this, r3), r4);     // Catch: Throwable -> L48 Exception -> L50
        r5.k(this.f13419g);     // Catch: Throwable -> L48 Exception -> L50
    L44:
        if (this.f13418f.N() == true) goto L47;
        t();
    L47:
        return r5;
    L40:
        if (TextUtils.isEmpty(this.v) == true) goto L42;
        Logger.debug();     // Catch: Throwable -> L48 Exception -> L50
        z0(new URL(this.w.get(this.C)).getHost(), this.v);     // Catch: Throwable -> L48 Exception -> L50
        goto L42
    L33:
        throw u0(new IOException("All urls have been tried and timed out by max wait time."), this.p, this.B, false);     // Catch: Throwable -> L59
    L34:
        this.z.remove(this.B);     // Catch: Throwable -> L59
    L62:
        e = move-exception;
        o0();
        if (this.B != null) goto L70;
        if (this.D == null) goto L70;
        throw u0(e, this.p, this.D, true);
    L70:
        throw u0(e, this.p, this.B, true);
    L72:
        throw new IOException("request canceled");
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r2) {
        if (r2 == null) goto L18;
        Object r1 = r2.obj;
        if ((r1 instanceof d) == false) goto L19;
        int r3 = r2.what;     // Catch: Throwable -> L14
        if (r3 != 0) goto L9;
        ((d) r1).r0();     // Catch: Throwable -> L14
    L15:
        return;
    L9:
        if (r3 != 1) goto L15;
        ((d) r1).s0();     // Catch: Throwable -> L14
    L20:
        return;
    L19:
        return;
    }

    public Boolean t0(String r6, a r7) {
        Boolean r0 = Boolean.FALSE;
        Boolean r1 = Boolean.TRUE;
        if (d.b.h.a.a.c.l() == false) goto L20;
        if (r7 == null) goto L20;
        new URL(r6).toURI();     // Catch: Exception -> L19
        if (this.y.get() != 0) goto L11;
        this.r = r6;     // Catch: Exception -> L19
        this.s = r7;     // Catch: Exception -> L19
        return r0;
    L11:
        if (this.y.get() != 1) goto L13;
        this.q.add(q0(this.r, this.s));     // Catch: Exception -> L19
    L13:
        q0(r6, r7);     // Catch: Exception -> L19
        if (this.q.contains(r7.f4719h) == false) goto L17;
        r7.f4721j = r1;     // Catch: Exception -> L19
        return r1;
    L17:
        this.q.add(r7.f4719h);     // Catch: Exception -> L19
        return r0;
    L19:
        return r1;
    L20:
        Logger.debug();
        return r1;
    }

    public /* synthetic */ void w0() {
        v0();
    }
}

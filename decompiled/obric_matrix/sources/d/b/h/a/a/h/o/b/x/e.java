package d.b.h.a.a.h.o.b.x;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements WeakHandler.IHandler {
    private static WeakHandler A;
    private static ExecutorService w;
    private static volatile e x;
    private static String y;
    private static HandlerThread z;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f13601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicBoolean f13602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile String f13603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ConcurrentSkipListSet<String> f13604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ConcurrentMap<String, CopyOnWriteArrayList<String>> f13605j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ConcurrentSkipListSet<String> f13606k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AtomicInteger f13607l;
    private AtomicInteger m;
    private AtomicInteger n;
    private AtomicInteger o;
    private AtomicInteger p;
    private AtomicInteger q;
    private final d r;
    private final d.b.h.a.a.h.o.b.h s;
    private volatile h t;
    private boolean u;
    private Handler v;

    class a extends Handler {
        a(e r1, Looper r2) {
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            super.handleMessage(r3);
            if (r3 != null) goto L5;
            return;
        L5:
            if ((r3.obj instanceof e) == false) goto L17;
            Bundle r2 = r3.getData();
            b r0 = (b) r2.getSerializable("callback_dnsresult_key");
            c r4 = (c) r2.getSerializable("callback_dnsresult_job_key");
            if (r4 != null) goto L12;
            Logger.debug();
            return;
        L12:
            if (r3.what != 1) goto L18;
            Logger.debug();
            r4.f13586f.a(r0);
            return;
        L18:
            return;
        }
    }

    static {
        w = Executors.newFixedThreadPool(6);
    }

    private e() {
        this.f13601f = new AtomicBoolean(true);
        this.f13602g = new AtomicBoolean(false);
        this.f13604i = new ConcurrentSkipListSet();
        this.f13605j = new ConcurrentHashMap();
        this.f13606k = new ConcurrentSkipListSet();
        this.f13607l = new AtomicInteger(30);
        this.m = new AtomicInteger(2000);
        this.n = new AtomicInteger(60);
        this.o = new AtomicInteger(0);
        this.p = new AtomicInteger(5);
        this.q = new AtomicInteger(5);
        this.s = new d.b.h.a.a.h.o.b.h();
        this.u = false;
        this.v = new a(this, Looper.getMainLooper());
        Logger.debug();
        HandlerThread r0 = new HandlerThread("TTOK-HTTPDNS");
        z = r0;
        r0.start();
        A = new WeakHandler(z.getLooper(), this);
        y = "4.2.228.16-pico";
        this.r = new d(A);
    }

    private Future<Void> D(String r8, List<Boolean> r9, boolean r10) {
        d.b.h.a.a.h.o.b.x.a r0 = this.r.m(r8);
        if (r0 != null) goto L5;
    L6:
        r9.set(0, Boolean.TRUE);
        if (this.r.q(r8) == true) goto L10;
        H(r8);
    L10:
        if (this.r.p(r8) == false) goto L12;
        Logger.debug();
        return this.r.l(r8);
    L12:
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L14:
        if (this.r.p(r8) == false) goto L16;
        Future<Void> r11 = this.r.l(r8);     // Catch: Throwable -> L20
    L17:
        monitor-exit(this);     // Catch: Throwable -> L20
        return r11;
    L16:
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L20
        r12.add(r8);     // Catch: Throwable -> L20
        r11 = E(r12, d.b.h.a.a.h.o.b.x.a.EnumC0360a.f13569f, r10);     // Catch: Throwable -> L20
        goto L17
    L5:
        if ((r0.d() + (r0.g() * 1000)) > (System.currentTimeMillis() + ((long) this.m.get()))) goto L10;
        goto L6
    }

    private void F(c r6) {
        ArrayList r0 = new ArrayList();
        r0.add(r6.b());
        E(r0, d.b.h.a.a.h.o.b.x.a.EnumC0360a.f13569f, false);
        Message r1 = Message.obtain();
        r1.what = 4;
        r1.obj = this;
        Bundle r2 = new Bundle();
        r2.putSerializable("dns_timeout_job_key", r6);
        r1.setData(r2);
        A.sendMessageDelayed(r1, ((long) this.p.get()) * 1000);
    }

    private synchronized Future<Void> H(String r6) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.r.q(r6) == false) goto L8;
        Logger.debug();     // Catch: Throwable -> L16
        Future<Void> r7 = this.r.o(r6);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r7;
    L8:
        Logger.debug();     // Catch: Throwable -> L16
        Future<Void> r0 = null;
        r0 = w.submit(new j(r6, this.r, A));     // Catch: RejectedExecutionException -> L12 Throwable -> L16
        this.r.g(r6, r0);     // Catch: RejectedExecutionException -> L12 Throwable -> L16
    L14:
        monitor-exit(this);
        return r0;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        goto L14
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private void d(c r4, b r5) {
        Logger.debug();
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 1;
        Bundle r1 = new Bundle();
        r1.putSerializable("callback_dnsresult_job_key", r4);
        r1.putSerializable("callback_dnsresult_key", r5);
        r0.setData(r1);
        this.v.sendMessage(r0);
    }

    private b f(Future<Void> r5, String r6, boolean r7) {
        Logger.debug();
        if (r5 != null) goto L7;
        Logger.debug();     // Catch: Throwable -> L14
        return u(r6, r7);
    L7:
        if (r5.isDone() == false) goto L11;
        Logger.debug();     // Catch: Throwable -> L14
        b r8 = t(r6, true);     // Catch: Throwable -> L14
        if (r8 == null) goto L18;
        return r8;
    L18:
        return u(r6, r7);
    L11:
        r5.get(q().l().get(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L14
        b r9 = t(r6, true);     // Catch: Throwable -> L14
        if (r9 == null) goto L18;
        return r9;
    L14:
        Logger.debug();
        return u(r6, r7);
    }

    private b g(String r3) {
        Logger.debug();
        if (this.f13605j.containsKey(r3) == false) goto L17;
        b r0 = new b();
        Iterator<String> r2 = this.f13605j.get(r3).iterator();
    L6:
        if (r2.hasNext() == false) goto L15;
        String r4 = r2.next();
        if (d.b.h.a.a.h.o.b.x.k.c.d(r4) == true) goto L9;
        if (d.b.h.a.a.h.o.b.x.k.c.c(r4) == true) goto L13;
        Logger.debug();
        goto L6
    L13:
        List<String> r1 = r0.f13576f;
    L10:
        r1.add(r4);
        goto L6
    L9:
        r1 = r0.f13577g;
        goto L10
    L15:
        r0.f13578h = b.a.f13585l;
        return r0;
    L17:
        return null;
    }

    private b o(String r7, boolean r8) {
        if (r8 == false) goto L6;
        return null;
    L6:
        if (this.r.p(r7) == false) goto L8;
        Future<Void> r9 = this.r.l(r7);
    L9:
        if (r9 != null) goto L12;
        return null;
    L12:
        if (r9.isDone() == true) goto L19;
        r9.get(((long) this.p.get()) * 1000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L16
        return t(r7, true);
    L20:
        return null;
    L19:
        return t(r7, true);
    L8:
        ArrayList r10 = new ArrayList();
        r10.add(r7);
        r9 = E(r10, d.b.h.a.a.h.o.b.x.a.EnumC0360a.f13569f, true);
        goto L9
    }

    public static e q() {
        if (x != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (x != null) goto L9;
        x = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return x;
    }

    private boolean r(String r3) {
        if (this.u == true) goto L7;
        Logger.debug();
        return true;
    L7:
        if (this.f13601f.get() == true) goto L11;
        Logger.debug();
        return true;
    L11:
        if (d.b.h.a.a.h.o.b.x.k.a.a(r3) == true) goto L15;
        Logger.debug();
        return true;
    L15:
        if (d.b.h.a.a.h.o.b.x.k.c.c(r3) == false) goto L17;
    L21:
        Logger.debug();
        return true;
    L17:
        if (d.b.h.a.a.h.o.b.x.k.c.d(r3) == true) goto L21;
        return false;
    }

    private b t(String r6, boolean r7) {
        Logger.debug();
        d.b.h.a.a.h.o.b.x.a r5 = this.r.i(r6);
        if (r5 != null) goto L5;
        return null;
    L5:
        b r0 = new b();
        r0.f13576f = r5.e();
        r0.f13577g = r5.f();
        if (r7 == false) goto L13;
        if (((r5.g() * 1000) + r5.d()) <= System.currentTimeMillis()) goto L11;
        r0.f13578h = b.a.f13582i;
        return r0;
    L11:
        return null;
    L13:
        if (((r5.g() * 1000) + r5.d()) <= System.currentTimeMillis()) goto L15;
        b.a r8 = b.a.f13580g;
    L16:
        r0.f13578h = r8;
        return r0;
    L15:
        r8 = b.a.f13581h;
        goto L16
    }

    private b u(String r2, boolean r3) {
        Logger.debug();
        b r0 = new b();
        d.b.h.a.a.h.o.b.x.a r1 = this.r.m(r2);
        if (r1 != null) goto L6;
        return null;
    L6:
        r0.f13576f = r1.e();
        r0.f13577g = r1.f();
        if (r3 == false) goto L9;
        b.a r4 = b.a.f13583j;
    L10:
        r0.f13578h = r4;
        return r0;
    L9:
        r4 = b.a.f13584k;
        goto L10
    }

    void A(String r2) {
        Logger.debug();
        if (d.b.h.a.a.h.o.b.x.k.a.a(r2) == false) goto L6;
        this.r.w(r2);
        return;
    }

    public void B(h r3) {
        if (this.u == false) goto L6;
        Logger.debug();
        return;
    L6:
        if (r3 != null) goto L8;
    L29:
        this.t = null;
        throw new IllegalArgumentException("you must set correct httpdns depend");
    L8:
        if (r3.getContext() == null) goto L29;
        if (TextUtils.isEmpty(r3.a()) == true) goto L29;
        if (r3.getAppId() == null) goto L29;
        this.t = r3;
        if (TextUtils.isEmpty(this.f13603h) == false) goto L16;
        this.f13603h = r3.a();
    L16:
        this.u = true;
        G();
        this.s.b(r3.getContext());
        if (this.f13606k.size() < 1) goto L19;
    L26:
        e(d.b.h.a.a.h.o.b.x.a.EnumC0360a.f13574k);
    L27:
        Message r4 = Message.obtain();
        r4.what = 5;
        r4.obj = this;
        A.sendMessage(r4);
        return;
    L19:
        if (this.t.c() != null) goto L21;
    L25:
        Logger.debug();
        goto L27
    L21:
        if (this.t.c().length <= 0) goto L25;
        if (this.t.c().length > 10) goto L25;
        this.f13606k.addAll(Arrays.asList(this.t.c()));
        goto L26
    }

    void C(JSONArray r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() <= 0) goto L18;
        this.f13604i.clear();
        int r1 = 0;
    L7:
        if (r1 >= r5.length()) goto L12;
        String r2 = r5.optString(r1);
        if (TextUtils.isEmpty(r2) == true) goto L11;
        this.f13604i.add(r2);
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        SharedPreferences.Editor r4 = a(this.t.getContext(), "dispatchersdk_httpdns_hardcodeips", 0).edit();
        r4.putString("httpdns_hardcodeips", String.valueOf(r5));
        r4.apply();
        return;
    }

    synchronized Future<Void> E(List<String> r9, d.b.h.a.a.h.o.b.x.a.EnumC0360a r10, boolean r11) {
        monitor-enter(this);
        Future<Void> r0 = null;
        if (r9 != null) goto L44;
    L36:
        Logger.debug();     // Catch: Throwable -> L39
        monitor-exit(this);
        return null;
    L44:
    L39:
        th = move-exception;
        throw th;
    L6:
        if (r9.size() == 0) goto L36;
        int r1 = 0;
    L10:
        if (r1 >= r9.size()) goto L21;
        if (this.r.p(r9.get(r1)) == false) goto L19;
        if (r11 == true) goto L15;
    L18:
        r9.remove(r9.get(r1));     // Catch: Throwable -> L39
        goto L19
    L15:
        if (r9.size() != 1) goto L18;
        if (r1 != 0) goto L18;
        r0 = this.r.l(r9.get(r1));     // Catch: Throwable -> L39
        Logger.debug();     // Catch: Throwable -> L39
    L19:
        r1 = r1 + 1;     // Catch: Throwable -> L39
        goto L10
    L21:
        if (r9.size() != 0) goto L24;
        monitor-exit(this);
        return r0;
    L24:
        Logger.debug();     // Catch: Throwable -> L39
        r0 = w.submit(new f(d.b.h.a.a.h.o.b.x.k.a.b(r9), y, this.r, r10, A));     // Catch: RejectedExecutionException -> L32 Throwable -> L39
        Iterator<String> r12 = r9.iterator();     // Catch: RejectedExecutionException -> L32 Throwable -> L39
    L27:
        if (r12.hasNext() == false) goto L34;
        String r13 = r12.next();     // Catch: RejectedExecutionException -> L32 Throwable -> L39
        this.r.d(r13, r0);     // Catch: RejectedExecutionException -> L32 Throwable -> L39
        if (this.f13602g.get() == false) goto L27;
        this.r.v(r13);     // Catch: RejectedExecutionException -> L32 Throwable -> L39
    L34:
        monitor-exit(this);
        return r0;
    L32:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L39
        Logger.debug();     // Catch: Throwable -> L39
        goto L34
    }

    void G() {
        w.submit(new i());     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    void b(String r1) {
        this.r.e(r1);
    }

    void c(List<String> r3) {
        Logger.debug();
        E(r3, d.b.h.a.a.h.o.b.x.a.EnumC0360a.f13575l, false);
    }

    synchronized void e(d.b.h.a.a.h.o.b.x.a.EnumC0360a r5) {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L4:
        if (this.t != null) goto L6;
    L28:
        monitor-exit(this);
        return;
    L6:
        if (d.b.h.a.a.h.s.h.h(this.t.getContext()) == false) goto L28;
        ConcurrentSkipListSet<String> r0 = this.f13606k;     // Catch: Throwable -> L30
        if (r0 == null) goto L28;
        if (r0.size() == 0) goto L28;
        if (this.f13606k.size() > 10) goto L28;
        Logger.debug();     // Catch: Throwable -> L30
        Iterator<String> r1 = this.f13606k.iterator();     // Catch: Throwable -> L30
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L30
    L16:
        if (r1.hasNext() == false) goto L22;
        String r3 = r1.next();     // Catch: Throwable -> L30
        if (this.r.p(r3) == true) goto L16;
        r2.add(r3);     // Catch: Throwable -> L30
        goto L16
    L22:
        if (r2.size() != 0) goto L25;
        monitor-exit(this);
        return;
    L25:
        Logger.debug();     // Catch: Throwable -> L30
        E(r2, r5, false);     // Catch: Throwable -> L30
        monitor-exit(this);
    }

    public h h() {
        return this.t;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r7) {
        Logger.debug();
        if (r7 == null) goto L169;
        Object r0 = r7.obj;
        if ((r0 instanceof e) == false) goto L7;
    L153:
        if ((r0 instanceof e) == false) goto L28;
        if (r7.what != 2) goto L28;
        Logger.debug();     // Catch: Throwable -> L150
        c r8 = (c) r7.getData().getSerializable("httpdns_timeout_job_key");     // Catch: Throwable -> L150
        if (r8 != null) goto L24;
        Logger.debug();     // Catch: Throwable -> L150
        return;
    L24:
        if (this.r.C(r8) == false) goto L170;
        Logger.debug();     // Catch: Throwable -> L150
        d(r8, u(r8.b(), r8.c()));     // Catch: Throwable -> L150
    L26:
        this.r.t(r8);     // Catch: Throwable -> L150
        return;
    L170:
        return;
    L28:
        if ((r0 instanceof f) == true) goto L30;
    L49:
        int r4 = 0;
        if ((r0 instanceof j) == false) goto L72;
        if (r7.what != 1) goto L72;
        Logger.debug();     // Catch: Throwable -> L150
        String r9 = r7.getData().getString("localdns_completed_host");     // Catch: Throwable -> L150
        if (r9 != null) goto L58;
        Logger.debug();     // Catch: Throwable -> L150
        return;
    L58:
        if (this.r.D(r9) == false) goto L172;
        Logger.debug();     // Catch: Throwable -> L150
        Iterator<c> r1 = this.r.n(r9).iterator();     // Catch: Throwable -> L150
    L61:
        if (r1.hasNext() == false) goto L190;
        c r2 = r1.next();     // Catch: Throwable -> L150
        b r3 = u(r9, true);     // Catch: Throwable -> L150
        if (r3 != null) goto L68;
        r3 = t(r9, false);     // Catch: Throwable -> L150
        if (r3 != null) goto L67;
        F(r2);     // Catch: Throwable -> L150
        this.r.c(r2.b(), r2);     // Catch: Throwable -> L150
    L69:
        this.r.x(r2);     // Catch: Throwable -> L150
    L67:
        d(r2, r3);     // Catch: Throwable -> L150
        goto L69
    L68:
        Logger.debug();     // Catch: Throwable -> L150
        goto L67
    L190:
        return;
    L172:
        return;
    L72:
        if ((r0 instanceof e) == false) goto L90;
        if (r7.what != 3) goto L90;
        Logger.debug();     // Catch: Throwable -> L150
        c r10 = (c) r7.getData().getSerializable("dns_timeout_job_key");     // Catch: Throwable -> L150
        if (r10 != null) goto L80;
        Logger.debug();     // Catch: Throwable -> L150
        return;
    L80:
        if (this.r.E(r10) == false) goto L173;
        Logger.debug();     // Catch: Throwable -> L150
        b r5 = t(r10.b(), false);     // Catch: Throwable -> L150
        if (r5 == null) goto L85;
        d(r10, r5);     // Catch: Throwable -> L150
    L88:
        this.r.x(r10);     // Catch: Throwable -> L150
        return;
    L85:
        if (this.r.p(r10.b()) == true) goto L87;
        F(r10);     // Catch: Throwable -> L150
    L87:
        this.r.c(r10.b(), r10);     // Catch: Throwable -> L150
        goto L88
    L173:
        return;
    L90:
        if ((r0 instanceof e) == false) goto L101;
        if (r7.what != 4) goto L101;
        Logger.debug();     // Catch: Throwable -> L150
        r8 = (c) r7.getData().getSerializable("dns_timeout_job_key");     // Catch: Throwable -> L150
        if (r8 != null) goto L98;
        Logger.debug();     // Catch: Throwable -> L150
        return;
    L98:
        if (this.r.C(r8) == false) goto L175;
        d(r8, null);     // Catch: Throwable -> L150
        goto L26
    L175:
        return;
    L101:
        if ((r0 instanceof e) == false) goto L121;
        if (r7.what != 5) goto L121;
        Logger.debug();     // Catch: Throwable -> L150
        String r11 = a(this.t.getContext(), "dispatchersdk_httpdns_hardcodeips", 0).getString("httpdns_hardcodeips", "");     // Catch: Throwable -> L150
        if (TextUtils.isEmpty(r11) == true) goto L116;
        this.f13604i.clear();     // Catch: Throwable -> L150
        JSONArray r6 = new JSONArray(r11);     // Catch: JSONException -> L149 Throwable -> L150
    L109:
        if (r4 >= r6.length()) goto L191;
        String r12 = r6.optString(r4);     // Catch: JSONException -> L149 Throwable -> L150
        if (TextUtils.isEmpty(r12) == true) goto L113;
        this.f13604i.add(r12);     // Catch: JSONException -> L149 Throwable -> L150
    L113:
        r4 = r4 + 1;
        goto L109
    L191:
        return;
    L114:
        Logger.debug();     // Catch: Throwable -> L150
        return;
    L116:
        if (this.t.b() != null) goto L118;
        return;
    L118:
        if (this.f13604i.size() != 0) goto L178;
        this.f13604i.addAll(Arrays.asList(this.t.b()));     // Catch: Throwable -> L150
        return;
    L178:
        return;
    L121:
        if ((r0 instanceof e) == false) goto L126;
        if (r7.what != 6) goto L126;
        Logger.debug();     // Catch: Throwable -> L150
        this.r.r(q().h().getContext());     // Catch: Throwable -> L150
        return;
    L126:
        if ((r0 instanceof e) == false) goto L131;
        if (r7.what != 7) goto L131;
        Logger.debug();     // Catch: Throwable -> L150
        G();     // Catch: Throwable -> L150
        return;
    L131:
        if ((r0 instanceof d.b.h.a.a.h.o.b.x.a) == false) goto L144;
        String r13 = r7.getData().getString("dnsrecord_host");     // Catch: Throwable -> L150
        if (TextUtils.isEmpty(r13) == false) goto L137;
        Logger.debug();     // Catch: Throwable -> L150
        return;
    L137:
        switch(r7.what) {
            case 10: goto L142;
            case 11: goto L141;
            case 12: goto L140;
            case 13: goto L139;
            default: goto L182;
        };     // Catch: Throwable -> L150
    L139:
        Logger.debug();     // Catch: Throwable -> L150
        q().z(r13);     // Catch: Throwable -> L150
        return;
    L140:
        Logger.debug();     // Catch: Throwable -> L150
        q().b(r13);     // Catch: Throwable -> L150
        return;
    L141:
        Logger.debug();     // Catch: Throwable -> L150
        q().A(r13);     // Catch: Throwable -> L150
        return;
    L142:
        Logger.debug();     // Catch: Throwable -> L150
        q().y(r13);     // Catch: Throwable -> L150
        return;
    L182:
        return;
    L144:
        if ((r0 instanceof d) == false) goto L114;
        if (r7.what != 20) goto L114;
        Logger.debug();     // Catch: Throwable -> L150
        this.r.z();     // Catch: Throwable -> L150
        return;
    L30:
        if (r7.what != 3) goto L49;
        Logger.debug();     // Catch: Throwable -> L150
        ArrayList<String> r14 = r7.getData().getStringArrayList("httpdns_completed_hosts");     // Catch: Throwable -> L150
        if (r14 != null) goto L35;
        Logger.debug();     // Catch: Throwable -> L150
        return;
    L35:
        Iterator<String> r15 = r14.iterator();     // Catch: Throwable -> L150
    L37:
        if (r15.hasNext() == false) goto L189;
        String r16 = r15.next();     // Catch: Throwable -> L150
        if (this.r.B(r16) == false) goto L37;
        Logger.debug();     // Catch: Throwable -> L150
        Iterator<c> r17 = this.r.k(r16).iterator();     // Catch: Throwable -> L150
    L43:
        if (r17.hasNext() == false) goto L37;
        c r18 = r17.next();     // Catch: Throwable -> L150
        b r19 = t(r16, true);     // Catch: Throwable -> L150
        if (q().s().get() == false) goto L48;
        if (r19 != null) goto L48;
        r19 = u(r16, r18.c());     // Catch: Throwable -> L150
    L48:
        Logger.debug();     // Catch: Throwable -> L150
        d(r18, r19);     // Catch: Throwable -> L150
        this.r.t(r18);     // Catch: Throwable -> L150
        goto L43
    L189:
        return;
    L188:
        return;
    L7:
        if ((r0 instanceof f) == true) goto L153;
        if ((r0 instanceof j) == true) goto L153;
        if ((r0 instanceof d.b.h.a.a.h.o.b.x.a) == true) goto L153;
        if ((r0 instanceof d) == true) goto L153;
        return;
    }

    String i() {
        return this.f13603h;
    }

    ConcurrentSkipListSet<String> j() {
        return this.f13604i;
    }

    public HandlerThread k() {
        return z;
    }

    AtomicInteger l() {
        return this.m;
    }

    AtomicInteger m() {
        return this.n;
    }

    public b n(String r8) {
        Logger.debug();
        if (r(r8) == false) goto L6;
        return null;
    L6:
        boolean r0 = r8.equals(this.f13603h);
        if (this.f13602g.get() == false) goto L13;
        if (r0 == true) goto L13;
        b r1 = t(r8, false);
        if (r1 == null) goto L12;
        return r1;
    L12:
        ArrayList r2 = new ArrayList();
        r2.add(0, Boolean.FALSE);
        b r3 = f(D(r8, r2, true), r8, r2.get(0).booleanValue());
    L34:
        if (r3 == null) goto L36;
        return r3;
    L36:
        return g(r8);
    L13:
        b r4 = u(r8, false);
        if (r4 == null) goto L17;
        return r4;
    L17:
        if (this.r.q(r8) == false) goto L19;
        Future<Void> r5 = this.r.o(r8);
    L20:
        if (r5 != null) goto L26;
        b r6 = o(r8, r0);
        if (r6 == null) goto L24;
        return r6;
    L24:
        return g(r8);
    L26:
        if (r5.isDone() == false) goto L38;
        b r7 = u(r8, true);
        if (r7 != null) goto L30;
    L29:
        r3 = o(r8, r0);
    L30:
        r3 = r7;
        goto L34
    L38:
        r5.get(((long) this.q.get()) * 1000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L37
        r7 = u(r8, true);     // Catch: Exception -> L37
        if (r7 != null) goto L30;
        r3 = o(r8, r0);     // Catch: Exception -> L37
    L19:
        r5 = H(r8);
        goto L20
    }

    AtomicInteger p() {
        return this.f13607l;
    }

    public AtomicBoolean s() {
        return this.f13602g;
    }

    public void v() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 6;
        A.sendMessage(r0);
    }

    public void w() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 7;
        A.sendMessage(r0);
    }

    public void x(JSONObject r8) {
        Logger.debug();
        if (this.t == null) goto L62;
        if (r8 == null) goto L77;
        int r0 = r8.optInt("ttnet_http_dns_enabled", -1);
        boolean r2 = false;
        if (r0 < 0) goto L13;
        AtomicBoolean r4 = this.f13601f;
        if (r0 != 1) goto L11;
        boolean r1 = true;
    L12:
        r4.set(r1);
        goto L13
    L11:
        r1 = false;
    L13:
        String r3 = r8.optString("ttnet_tt_http_dns_domain");
        if (TextUtils.isEmpty(r3) == true) goto L16;
        this.f13603h = r3;
    L16:
        JSONArray r5 = r8.optJSONArray("ttnet_tt_http_dns_preload_batch_host");
        if (r5 == null) goto L25;
        this.f13606k.clear();
        int r6 = 0;
    L20:
        if (r6 >= r5.length()) goto L25;
        String r7 = r5.optString(r6);
        if (TextUtils.isEmpty(r7) == true) goto L24;
        this.f13606k.add(r7);
    L24:
        r6 = r6 + 1;
    L25:
        int r9 = r8.optInt("localdns_cache_ttl", -1);
        if (r9 < 0) goto L28;
        this.f13607l.set(r9);
    L28:
        int r10 = r8.optInt("httpdns_prefer_time_ms", -1);
        if (r10 < 0) goto L31;
        this.m.set(r10);
    L31:
        int r11 = r8.optInt("httpdns_stale_cache_interval", -1);
        if (r11 < 0) goto L34;
        this.n.set(r11);
    L34:
        int r12 = r8.optInt("enable_compare_localdns_httpdns", -1);
        if (r12 < 0) goto L37;
        this.o.set(r12);
    L37:
        int r13 = r8.optInt("ttnet_http_dns_prefer", -1);
        if (r13 < 0) goto L43;
        AtomicBoolean r14 = this.f13602g;
        if (r13 != 1) goto L42;
        r2 = true;
    L42:
        r14.set(r2);
    L43:
        int r15 = r8.optInt("ttnet_http_dns_timeout", -1);
        if (r15 < 0) goto L46;
        this.p.set(r15);
    L46:
        int r16 = r8.optInt("ttnet_local_dns_time_out", -1);
        if (r16 < 0) goto L49;
        this.q.set(r16);
    L49:
        JSONObject r17 = r8.optJSONObject("ttnet_http_dns_addr");
        if (r17 == null) goto L76;
        this.f13605j.clear();
        Iterator<String> r18 = r17.keys();
    L53:
        if (r18.hasNext() == false) goto L78;
        String r19 = r18.next();
        String r20 = r17.optString(r19);
        if (TextUtils.isEmpty(r19) == true) goto L53;
        if (TextUtils.isEmpty(r20) == true) goto L53;
        String[] r21 = r20.split(",");
        if (r19.equals(this.f13603h) == true) goto L60;
        this.f13605j.put(r19, new CopyOnWriteArrayList(Arrays.asList(r21)));
        goto L53
    L60:
        this.f13604i.clear();
        this.f13604i.addAll(Arrays.asList(r21));
        goto L53
    L78:
        return;
    L76:
        return;
    L77:
        return;
    }

    void y(String r3) {
        if (d.b.h.a.a.h.o.b.x.k.a.a(r3) == true) goto L5;
        return;
    L5:
        if (this.r.p(r3) == false) goto L7;
        return;
    L7:
        if (this.f13602g.get() == false) goto L12;
        ArrayList r0 = new ArrayList();
        r0.add(r3);
        E(r0, d.b.h.a.a.h.o.b.x.a.EnumC0360a.f13573j, false);
        return;
    }

    void z(String r2) {
        if (d.b.h.a.a.h.o.b.x.k.a.a(r2) == true) goto L5;
        return;
    L5:
        if (this.r.p(r2) == true) goto L9;
        this.r.s(r2);
        return;
    }
}

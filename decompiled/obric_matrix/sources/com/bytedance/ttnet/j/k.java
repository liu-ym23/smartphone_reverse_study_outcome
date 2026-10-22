package com.bytedance.ttnet.j;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ttnet.TTNetInit;
import d.b.r.e0;
import d.b.r.y;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k implements d.b.r.l0.b {
    private static volatile k o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f6390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, f> f6391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile f f6392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReadWriteLock f6393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lock f6394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<d.b.r.h0.c> f6395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set<d.b.r.h0.c> f6396g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicLong f6397h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Set<d.b.r.h0.c> f6398i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map<Runnable, Executor> f6399j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ReadWriteLock f6400k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lock f6401l;
    private final Lock m;
    private final Condition n;

    class a extends d.b.h.a.a.d.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Runnable f6402f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ y f6403g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Executor f6404h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ k f6405i;

        a(k r1, long r2, long r4, Runnable r6, d.b.r.h0.c r7, y r8, Executor r9) {
            this.f6405i = r1;
            this.f6402f = r6;
            this.f6403g = r8;
            this.f6404h = r9;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            k.e(this.f6405i).lock();
        L8:
            th = move-exception;
            k.e(this.f6405i).unlock();
            throw th;
        L4:
            if (k.f(this.f6405i).containsKey(this.f6402f) == false) goto L6;
            Logger.debug();     // Catch: Throwable -> L8
            y r0 = this.f6403g;     // Catch: Throwable -> L8
            r0.E = System.currentTimeMillis() - this.f6403g.H;     // Catch: Throwable -> L8
            this.f6404h.execute(this.f6402f);     // Catch: Throwable -> L8
            k.f(this.f6405i).remove(this.f6402f);     // Catch: Throwable -> L8
        L6:
            k.e(this.f6405i).unlock();
        }
    }

    class b implements e0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ y f6406f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Executor f6407g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Runnable f6408h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ d.b.r.h0.c f6409i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f6410j;

        b(k r1, y r2, Executor r3, Runnable r4, d.b.r.h0.c r5, int r6) {
            this.f6406f = r2;
            this.f6407g = r3;
            this.f6408h = r4;
            this.f6409i = r5;
            this.f6410j = r6;
        }

        @Override // d.b.r.e0
        public y E() {
            return this.f6409i.z();
        }

        @Override // d.b.r.e0
        public int F() {
            return this.f6410j;
        }

        @Override // d.b.r.e0
        public int O() {
            return this.f6409i.B();
        }

        @Override // d.b.r.e0
        public boolean V() {
            return this.f6409i.N();
        }

        @Override // java.lang.Runnable
        public void run() {
            y r0 = this.f6406f;
            r0.E = System.currentTimeMillis() - this.f6406f.H;
            this.f6407g.execute(this.f6408h);
        }
    }

    class c extends d.b.h.a.a.d.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d.b.r.h0.c f6411f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ k f6412g;

        c(k r1, d.b.r.h0.c r2) {
            this.f6412g = r1;
            this.f6411f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean r0 = k.g(this.f6412g).remove(this.f6411f);
            if (Logger.debug() == false) goto L5;
            this.f6411f.z();
        L5:
            k.h(this.f6412g).remove(this.f6411f);
            k.i(this.f6412g).remove(this.f6411f);
            if (r0 == true) goto L8;
            return;
        L8:
            if (k.g(this.f6412g).size() != 0) goto L12;
            Logger.debug();
            k.j(this.f6412g);
            return;
        }
    }

    class d extends d.b.h.a.a.d.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Runnable f6413f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f6414g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Executor f6415h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ k f6416i;

        d(k r1, long r2, long r4, Runnable r6, int r7, Executor r8) {
            this.f6416i = r1;
            this.f6413f = r6;
            this.f6414g = r7;
            this.f6415h = r8;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            k.e(this.f6416i).lock();
        L11:
            th = move-exception;
            k.e(this.f6416i).unlock();
            throw th;
        L4:
            if (k.f(this.f6416i).containsKey(this.f6413f) == false) goto L9;
            Runnable r0 = this.f6413f;     // Catch: Throwable -> L11
            if ((r0 instanceof e0) == false) goto L8;
            y r1 = ((e0) r0).E();     // Catch: Throwable -> L11
            r1.E = System.currentTimeMillis() - r1.H;     // Catch: Throwable -> L11
            r1.I = this.f6414g;     // Catch: Throwable -> L11
        L8:
            Logger.debug();     // Catch: Throwable -> L11
            this.f6415h.execute(this.f6413f);     // Catch: Throwable -> L11
            k.f(this.f6416i).remove(this.f6413f);     // Catch: Throwable -> L11
        L9:
            k.e(this.f6416i).unlock();
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f6417f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final e f6418g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final e f6419h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final e f6420i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final e f6421j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ e[] f6422k = null;

        static {
            e r0 = new e("NO_DELAY", 0);
            f6417f = r0;
            e r1 = new e("BLACK_LIST", 1);
            f6418g = r1;
            e r3 = new e("WHITE_LIST", 2);
            f6419h = r3;
            e r5 = new e("RUNTIME", 3);
            f6420i = r5;
            e r7 = new e("NOT_REACHED", 4);
            f6421j = r7;
            f6422k = new e[]{r0, r1, r3, r5, r7};
        }

        private e(String r1, int r2) {
            super(r1, r2);
        }

        public static e valueOf(String r1) {
            return (e) Enum.valueOf(e.class, r1);
        }

        public static e[] values() {
            return (e[]) f6422k.clone();
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        e f6423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f6425c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f6426d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f6427e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f6428f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Set<String> f6429g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Map<String, Integer> f6430h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Set<String> f6431i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f6432j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Set<String> f6433k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Set<String> f6434l;
        Set<String> m;
        int n;
        int o;
        int p;
        int q;

        private f() {
            this.f6423a = e.f6417f;
            this.f6424b = -1;
            this.f6425c = "";
            this.f6426d = 1000;
            this.f6427e = 5;
            this.f6428f = 5;
            this.f6429g = new CopyOnWriteArraySet();
            this.f6430h = new ConcurrentHashMap();
            this.f6431i = new CopyOnWriteArraySet();
            this.f6432j = 100;
            this.f6433k = new CopyOnWriteArraySet();
            this.f6434l = new CopyOnWriteArraySet();
            this.m = new CopyOnWriteArraySet();
            this.n = 5000;
            this.o = 5000;
            this.p = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.q = 500;
        }

        /* synthetic */ f(j r1) {
            this();
        }
    }

    public k() {
        this.f6390a = new AtomicBoolean(false);
        this.f6391b = new ConcurrentHashMap();
        this.f6392c = new f(null);
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        this.f6393d = r0;
        this.f6394e = r0.readLock();
        r0.writeLock();
        this.f6395f = new CopyOnWriteArraySet();
        this.f6396g = new CopyOnWriteArraySet();
        this.f6397h = new AtomicLong(0);
        this.f6398i = new CopyOnWriteArraySet();
        this.f6399j = new ConcurrentHashMap();
        ReentrantReadWriteLock r1 = new ReentrantReadWriteLock();
        this.f6400k = r1;
        this.f6401l = r1.writeLock();
        ReentrantLock r2 = new ReentrantLock();
        this.m = r2;
        this.n = r2.newCondition();
    }

    static /* synthetic */ Lock e(k r0) {
        return r0.f6401l;
    }

    static /* synthetic */ Map f(k r0) {
        return r0.f6399j;
    }

    static /* synthetic */ Set g(k r0) {
        return r0.f6398i;
    }

    static /* synthetic */ Set h(k r0) {
        return r0.f6395f;
    }

    static /* synthetic */ Set i(k r0) {
        return r0.f6396g;
    }

    static /* synthetic */ void j(k r0) {
        r0.s();
    }

    private boolean k(f r3, d.b.r.h0.c r4) {
        if (p(r3.f6433k, r4.A()) == false) goto L7;
        this.f6397h.set(System.currentTimeMillis());
        this.f6398i.add(r4);
        Logger.debug();
        return false;
    L7:
        if (r3.f6434l.size() <= 0) goto L11;
        return p(r3.f6434l, r4.A());
    L11:
        if (r3.m.size() > 0) goto L13;
        return true;
    L13:
        return !p(r3.m, r4.A());
    }

    public static k l() {
        if (o != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (o != null) goto L9;
        o = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return o;
    }

    private Integer m(Map<String, Integer> r4, String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator<String> r0 = r4.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        String r1 = r0.next();
        if (r5.startsWith(r1) == false) goto L7;
        return r4.get(r1);
    L15:
        return null;
    }

    private int n(boolean r3, f r4, y r5, d.b.r.h0.c r6) {
        if (r6.z() != null) goto L5;
        r6.S(r5);
    L5:
        r5.B = r4.f6424b;
        r5.F = this.f6396g.size();
        r5.G = this.f6395f.size();
        if (p(r4.f6429g, r6.A()) == true) goto L32;
        if (r3 == true) goto L10;
    L12:
        if (r3 == false) goto L14;
    L16:
        e r7 = r4.f6423a;
        if (r7 != e.f6418g) goto L23;
        Integer r2 = m(r4.f6430h, r6.A());
        if (r2 != null) goto L21;
        return 0;
    L21:
        return r2.intValue();
    L23:
        if (r7 == e.f6419h) goto L25;
        return -1;
    L25:
        if (p(r4.f6431i, r6.A()) == false) goto L27;
        return 0;
    L27:
        return r4.f6432j;
    L14:
        if (this.f6396g.size() < r4.f6427e) goto L16;
        return 0;
    L10:
        if (this.f6395f.size() < r4.f6428f) goto L12;
        return 0;
    L32:
        throw new d.b.h.a.a.h.l.c();
    }

    private int o(boolean r4, int r5, int r6) {
        if (r4 == true) goto L5;
    L7:
        if (r4 == true) goto L12;
        if (this.f6396g.size() > 5) goto L12;
        return 0;
    L12:
        return new Random().nextInt((r6 - r5) + 1) + r5;
    L5:
        if (this.f6395f.size() > 5) goto L7;
        return 0;
    }

    private boolean p(Set<String> r2, String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Iterator<String> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L15;
        if (r3.startsWith(r4.next()) == false) goto L7;
        return true;
    L15:
        return false;
    }

    private boolean r() {
        if ((System.currentTimeMillis() - this.f6397h.get()) <= this.f6392c.n) goto L6;
        return true;
    L6:
        if (this.f6398i.size() <= 0) goto L10;
        return false;
    L10:
        return true;
    }

    private void s() {
        Logger.debug();
        this.m.lock();
        this.n.signalAll();     // Catch: Throwable -> L20
        this.m.unlock();
        this.f6394e.lock();
        int r0 = this.f6392c.q;     // Catch: Throwable -> L17
        int r1 = this.f6392c.p;     // Catch: Throwable -> L17
        this.f6394e.unlock();
        this.f6401l.lock();
        Iterator<Map.Entry<Runnable, Executor>> r2 = this.f6399j.entrySet().iterator();     // Catch: Throwable -> L14
    L9:
        if (r2.hasNext() == false) goto L12;
        Map.Entry<Runnable, Executor> r3 = r2.next();     // Catch: Throwable -> L14
        Runnable r11 = r3.getKey();     // Catch: Throwable -> L14
        Executor r13 = r3.getValue();     // Catch: Throwable -> L14
        int r12 = o(true, r0, r1);     // Catch: Throwable -> L14
        d.b.h.a.a.d.c.c(d.b.h.a.a.d.d.f13252f).d(new d(this, r12, 0, r11, r12, r13));     // Catch: Throwable -> L14
        goto L9
    L12:
        this.f6401l.unlock();
        this.f6395f.clear();
        this.f6396g.clear();
        return;
    L14:
        th = move-exception;
        this.f6401l.unlock();
        throw th;
    L17:
        th = move-exception;
        this.f6394e.unlock();
        throw th;
    L20:
        th = move-exception;
        this.m.unlock();
        throw th;
    }

    private void t(int r3, d.b.r.h0.c r4, y r5) {
        if (r3 > 0) goto L4;
        return;
    L4:
        this.f6396g.add(r4);
        r5.H = System.currentTimeMillis();
        r5.D = true;
        Thread.sleep(r3);     // Catch: Throwable -> L8 InterruptedException -> L10
        r5.E = System.currentTimeMillis() - r5.H;
        return;
    L10:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r5.E = System.currentTimeMillis() - r5.H;
        throw th;
    }

    private void u(int r9, Executor r10, Runnable r11, d.b.r.h0.c r12, y r13) {
        if (r9 > 0) goto L4;
        return;
    L4:
        r13.H = System.currentTimeMillis();
        r13.D = true;
        b r0 = new b(this, r13, r10, r11, r12, r9);
        this.f6395f.add(r12);
        r10.execute(r0);
    }

    @Override // d.b.r.l0.b
    public void a(d.b.r.h0.c r7, y r8) {
        if (this.f6390a.get() == true) goto L5;
        return;
    L5:
        if (r7 != null) goto L7;
        return;
    L7:
        if (r7.A() == null) goto L61;
        if (r8 == null) goto L62;
        this.f6394e.lock();
        int r0 = n(false, this.f6392c, r8, r7);     // Catch: Throwable -> L46 Exception -> L48
        Logger.debug();     // Catch: Throwable -> L46 Exception -> L48
        this.f6394e.unlock();
        if (r0 <= 0) goto L16;
        t(r0, r7, r8);
        return;
    L16:
        if (r0 != 0) goto L18;
        return;
    L18:
        this.f6394e.lock();
        int r1 = this.f6392c.q;
        int r2 = this.f6392c.p;
        int r3 = this.f6392c.o;
    L42:
        e = move-exception;
        throw e;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        this.f6394e.unlock();
        throw th;
    L20:
        if (this.f6392c.f6423a == e.f6420i) goto L24;
    L21:
        this.f6394e.unlock();
        return;
    L24:
        if (k(this.f6392c, r7) == false) goto L21;
        if (r() == true) goto L21;
        this.f6394e.unlock();
        this.m.lock();
        r8.H = SystemClock.uptimeMillis();     // Catch: Throwable -> L35 Exception -> L53
        this.f6396g.add(r7);     // Catch: Throwable -> L35 Exception -> L53
        Logger.debug();     // Catch: Throwable -> L35 Exception -> L53
        this.n.await(r3, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L35 Exception -> L53
        int r9 = o(false, r1, r2);     // Catch: Throwable -> L35 Exception -> L53
        long r4 = r9;
        r8.I = r4;     // Catch: Throwable -> L35 Exception -> L53
        if (r9 <= 0) goto L33;
        Thread.sleep(r4);     // Catch: Throwable -> L35 Exception -> L53
    L33:
        Logger.debug();     // Catch: Throwable -> L35 Exception -> L53
        r8.E = SystemClock.uptimeMillis() - r8.H;     // Catch: Throwable -> L35 Exception -> L53
        r8.D = true;     // Catch: Throwable -> L35 Exception -> L53
    L35:
        th = move-exception;
        this.m.unlock();
        throw th;
    L38:
        this.m.unlock();
        return;
    L46:
        th = move-exception;
        this.f6394e.unlock();
        throw th;
    L48:
        e = move-exception;
        throw e;     // Catch: Throwable -> L46
    L62:
        return;
    }

    @Override // d.b.r.l0.b
    public boolean b(d.b.r.h0.c r16, y r17, Executor r18, Runnable r19) {
        if (this.f6390a.get() == true) goto L5;
        return false;
    L5:
        if (r16 != null) goto L7;
    L41:
        return false;
    L7:
        if (r16.A() == null) goto L41;
        if (r17 == null) goto L41;
        this.f6394e.lock();
        int r1 = this.f6392c.o;
        int r3 = n(true, this.f6392c, r17, r16);     // Catch: Throwable -> L35 Exception -> L37
        Logger.debug();     // Catch: Throwable -> L35 Exception -> L37
        if (r3 <= 0) goto L17;
        u(r3, r18, r19, r16, r17);     // Catch: Throwable -> L35 Exception -> L37
        Lock r0 = this.f6394e;
    L15:
        r0.unlock();
        return true;
    L17:
        if (r3 != 0) goto L21;
    L18:
        this.f6394e.unlock();
        return false;
    L21:
        if (this.f6392c.f6423a != e.f6420i) goto L18;
        if (k(this.f6392c, r16) == false) goto L18;
        if (r() == true) goto L18;
        this.f6394e.unlock();
        this.f6401l.lock();
        this.f6395f.add(r16);     // Catch: Throwable -> L32
        Logger.debug();     // Catch: Throwable -> L32
        r17.H = System.currentTimeMillis();     // Catch: Throwable -> L32
        this.f6399j.put(r19, r18);     // Catch: Throwable -> L32
        r17.D = true;     // Catch: Throwable -> L32
        d.b.h.a.a.d.c.c(d.b.h.a.a.d.d.f13252f).d(new a(this, r1, 0, r19, r16, r17, r18));     // Catch: Throwable -> L32
        r0 = this.f6401l;
    L32:
        th = move-exception;
        this.f6401l.unlock();
        throw th;
    L37:
        e = move-exception;
        throw e;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        this.f6394e.unlock();
        throw th;
    }

    @Override // d.b.r.l0.b
    public void c(d.b.r.h0.c r3) {
        if (this.f6390a.get() == false) goto L5;
    L7:
        if (r3 != null) goto L9;
        return;
    L9:
        d.b.h.a.a.d.c.c(d.b.h.a.a.d.d.f13252f).d(new c(this, r3));
        return;
    L5:
        if (this.f6398i.size() > 0) goto L7;
    }

    public void q(JSONObject r13) {
        JSONArray r0 = r13.optJSONArray("tt_req_delay_config");
        boolean r3 = true;
        if (r13.optInt("state_delay_enabled") <= 0) goto L5;
        boolean r1 = true;
    L7:
        if (r13.optInt("state_new_strategy_enabled", 1) <= 0) goto L9;
        boolean r14 = true;
    L11:
        if (TTNetInit.getStateDelayNewStrategyEnabled() == false) goto L14;
        if (r14 == false) goto L14;
    L15:
        if (r1 == false) goto L90;
        if (r0 == null) goto L90;
        if (r3 == true) goto L90;
        ConcurrentHashMap r15 = new ConcurrentHashMap();
        int r4 = 0;
    L21:
        if (r4 >= r0.length()) goto L87;
        f r5 = new f(null);
        JSONObject r6 = r0.optJSONObject(r4);
        if (r6 == null) goto L86;
        r5.f6425c = r6.optString("state_name", "");
        if (r6.isNull("bl_with_delay_ms") == true) goto L34;
        r5.f6423a = e.f6418g;
        JSONObject r7 = r6.optJSONObject("bl_with_delay_ms");
        if (r7 == null) goto L66;
        Iterator<String> r8 = r7.keys();
    L31:
        if (r8.hasNext() == false) goto L66;
        String r9 = r8.next();
        r5.f6430h.put(r9, Integer.valueOf(r7.optInt(r9)));
    L66:
        if (r5.f6430h.size() > 0) goto L72;
        if (r5.f6431i.size() > 0) goto L72;
        if (r5.f6433k.size() <= 0) goto L86;
    L72:
        if (TextUtils.isEmpty(r5.f6425c) == true) goto L86;
        int r10 = r6.optInt("delay_disable_time_ms", 1000);
        r5.f6426d = r10;
        if (r10 > 0) goto L78;
        r5.f6426d = 1000;
    L78:
        if (r6.isNull("dl") == true) goto L85;
        JSONArray r11 = r6.optJSONArray("dl");
        if (r11 == null) goto L85;
        int r12 = 0;
    L83:
        if (r12 >= r11.length()) goto L85;
        r5.f6429g.add((String) r11.opt(r12));
        r12 = r12 + 1;
    L85:
        r5.f6424b = r6.optInt(WsConstants.KEY_CONNECTION_STATE, -1);
        r5.f6427e = r6.optInt("sync_req_delay_max_count", 10);
        r5.f6428f = r6.optInt("async_req_delay_max_count", 10);
        r15.put(r5.f6425c, r5);
        goto L86
    L34:
        if (r6.isNull("wl") == true) goto L45;
        r5.f6423a = e.f6419h;
        JSONArray r16 = r6.optJSONArray("wl");
        if (r16 == null) goto L41;
        int r17 = 0;
    L39:
        if (r17 >= r16.length()) goto L41;
        r5.f6431i.add((String) r16.opt(r17));
        r17 = r17 + 1;
    L41:
        int r18 = r6.optInt("delay_time_ms", 1000);
        r5.f6432j = r18;
        if (r18 > 0) goto L66;
        r5.f6432j = 1000;
        goto L66
    L45:
        if (r6.isNull("p0") == true) goto L66;
        r5.f6423a = e.f6420i;
        JSONArray r19 = r6.optJSONArray("p0");
        if (r19 == null) goto L52;
        int r20 = 0;
    L50:
        if (r20 >= r19.length()) goto L52;
        r5.f6433k.add((String) r19.opt(r20));
        r20 = r20 + 1;
    L52:
        JSONArray r21 = r6.optJSONArray("bl_for_runtime");
        if (r21 == null) goto L58;
        int r22 = 0;
    L56:
        if (r22 >= r21.length()) goto L58;
        r5.f6434l.add((String) r21.opt(r22));
        r22 = r22 + 1;
    L58:
        JSONArray r23 = r6.optJSONArray("wl_for_runtime");
        if (r23 == null) goto L64;
        int r24 = 0;
    L62:
        if (r24 >= r23.length()) goto L64;
        r5.m.add((String) r23.opt(r24));
        r24 = r24 + 1;
    L64:
        r5.n = r6.optInt("p0_check_max_ms", 5000);
        r5.o = r6.optInt("p1_wait_max_ms", 5000);
        r5.p = r6.optInt("random_send_ubound_ms", PathInterpolatorCompat.MAX_NUM_POINTS);
        r5.q = r6.optInt("random_send_lbound_ms", 500);
    L86:
        r4 = r4 + 1;
        goto L21
    L87:
        this.f6391b.clear();
        this.f6391b.putAll(r15);
    L88:
        this.f6390a.set(r1);
        return;
    L90:
        this.f6391b.clear();
    L14:
        r3 = false;
        goto L15
    L9:
        r14 = false;
        goto L11
    L5:
        r1 = false;
        goto L7
    }
}

package com.bytedance.ttnet.p;

import android.os.SystemClock;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<d.b.r.h0.c> f6519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lock f6521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Condition f6522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<d.b.r.h0.c> f6523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ReadWriteLock f6525h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lock f6526i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map<Runnable, Executor> f6527j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f6528k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f6529l;
    private int m;

    class a extends d.b.h.a.a.d.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Runnable f6530f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Executor f6531g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ y f6532h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ e f6533i;

        a(e r1, long r2, long r4, Runnable r6, Executor r7, y r8) {
            this.f6533i = r1;
            this.f6530f = r6;
            this.f6531g = r7;
            this.f6532h = r8;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a(this.f6533i).lock();
        L8:
            th = move-exception;
            e.a(this.f6533i).unlock();
            throw th;
        L4:
            if (e.b(this.f6533i).containsKey(this.f6530f) == false) goto L6;
            this.f6531g.execute(this.f6530f);     // Catch: Throwable -> L8
            e.b(this.f6533i).remove(this.f6530f);     // Catch: Throwable -> L8
            y r0 = this.f6532h;     // Catch: Throwable -> L8
            r0.E = SystemClock.uptimeMillis() - this.f6532h.H;     // Catch: Throwable -> L8
        L6:
            e.a(this.f6533i).unlock();
        }
    }

    class b extends d.b.h.a.a.d.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Runnable f6534f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f6535g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Executor f6536h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ e f6537i;

        b(e r1, long r2, long r4, Runnable r6, int r7, Executor r8) {
            this.f6537i = r1;
            this.f6534f = r6;
            this.f6535g = r7;
            this.f6536h = r8;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a(this.f6537i).lock();
        L11:
            th = move-exception;
            e.a(this.f6537i).unlock();
            throw th;
        L4:
            if (e.b(this.f6537i).containsKey(this.f6534f) == false) goto L9;
            Runnable r0 = this.f6534f;     // Catch: Throwable -> L11
            if ((r0 instanceof e0) == false) goto L8;
            y r1 = ((e0) r0).E();     // Catch: Throwable -> L11
            r1.E = System.currentTimeMillis() - r1.H;     // Catch: Throwable -> L11
            r1.I = this.f6535g;     // Catch: Throwable -> L11
        L8:
            this.f6536h.execute(this.f6534f);     // Catch: Throwable -> L11
            e.b(this.f6537i).remove(this.f6534f);     // Catch: Throwable -> L11
        L9:
            e.a(this.f6537i).unlock();
        }
    }

    public e() {
        this.f6518a = null;
        this.f6519b = new CopyOnWriteArraySet();
        this.f6520c = -1;
        ReentrantLock r1 = new ReentrantLock();
        this.f6521d = r1;
        this.f6522e = r1.newCondition();
        this.f6523f = new CopyOnWriteArraySet();
        this.f6524g = -1;
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        this.f6525h = r0;
        this.f6526i = r0.writeLock();
        this.f6527j = new ConcurrentHashMap();
        this.f6528k = 500;
        this.f6529l = PathInterpolatorCompat.MAX_NUM_POINTS;
        this.m = 100;
    }

    static /* synthetic */ Lock a(e r0) {
        return r0.f6526i;
    }

    static /* synthetic */ Map b(e r0) {
        return r0.f6527j;
    }

    private int c() {
        int r0 = this.f6528k;
        if (r0 > 0) goto L6;
        r0 = 500;
    L6:
        int r1 = this.f6529l;
        if (r1 > 0) goto L11;
        r1 = PathInterpolatorCompat.MAX_NUM_POINTS;
    L11:
        if (r0 < r1) goto L14;
        return 0;
    L14:
        if ((this.f6523f.size() + this.f6519b.size()) > 8) goto L17;
        return 0;
    L17:
        return new Random().nextInt((r1 - r0) + 1) + r0;
    }

    private boolean j() {
        if (this.m > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void d(JSONObject r3, String r4) {
        this.f6520c = r3.optInt("sync_req_delay_max_count", -1);
        this.f6524g = r3.optInt("async_req_delay_max_count", -1);
        this.f6528k = r3.optInt("random_send_lbound_ms", 500);
        this.f6529l = r3.optInt("random_send_ubound_ms", PathInterpolatorCompat.MAX_NUM_POINTS);
        this.m = r3.optInt("sparse_send_interval_ms", 100);
        i(r4);
    }

    public void e(d.b.r.h0.c r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.f6519b.remove(r2);
        this.f6523f.remove(r2);
    }

    public void f() {
        this.f6521d.lock();
        this.f6522e.signalAll();     // Catch: Throwable -> L19
        this.f6521d.unlock();
        this.f6526i.lock();
        int r0 = 0;
        Iterator<Map.Entry<Runnable, Executor>> r1 = this.f6527j.entrySet().iterator();     // Catch: Throwable -> L16
    L6:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<Runnable, Executor> r2 = r1.next();     // Catch: Throwable -> L16
        Runnable r10 = r2.getKey();     // Catch: Throwable -> L16
        Executor r12 = r2.getValue();     // Catch: Throwable -> L16
        if (j() == false) goto L11;
        r0 = c();     // Catch: Throwable -> L16
    L12:
        d.b.h.a.a.d.c.c(d.b.h.a.a.d.d.f13252f).d(new b(this, r0, 0, r10, r0, r12));     // Catch: Throwable -> L16
        goto L6
    L11:
        r0 = r0 + this.m;     // Catch: Throwable -> L16
        goto L12
    L14:
        this.f6526i.unlock();
        this.f6523f.clear();
        this.f6519b.clear();
        return;
    L16:
        th = move-exception;
        this.f6526i.unlock();
        throw th;
    L19:
        th = move-exception;
        this.f6521d.unlock();
        throw th;
    }

    public boolean g(d.b.r.h0.c r13, boolean r14, long r15, Runnable r17, Executor r18, y r19) {
        if (r15 > 0) goto L5;
        return false;
    L5:
        if (r14 == false) goto L7;
    L9:
        this.f6527j.put(r17, r18);
        this.f6523f.add(r13);
        r19.H = SystemClock.uptimeMillis();
        r19.C = this.f6518a;
        r19.G = this.f6523f.size();
        r19.D = true;
        d.b.h.a.a.d.c.c(d.b.h.a.a.d.d.f13252f).d(new a(this, r15, 0, r17, r18, r19));
        return true;
    L7:
        if (this.f6523f.size() < this.f6524g) goto L9;
        return false;
    }

    public void h(d.b.r.h0.c r3, boolean r4, boolean r5, long r6, y r8) {
        this.f6521d.lock();
        if (r6 > 0) goto L6;
    L4:
        this.f6521d.unlock();
        return;
    L6:
        if (r4 == false) goto L24;
    L10:
        long r0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L18 Exception -> L23
        this.f6519b.add(r3);     // Catch: Throwable -> L18 Exception -> L23
        r8.F = this.f6519b.size();     // Catch: Throwable -> L18 Exception -> L23
        r8.C = this.f6518a;     // Catch: Throwable -> L18 Exception -> L23
        r8.D = true;     // Catch: Throwable -> L18 Exception -> L23
        this.f6522e.await(r6, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L18 Exception -> L23
        if (r5 == false) goto L16;
        int r7 = c();     // Catch: Throwable -> L18 Exception -> L23
        if (r7 <= 0) goto L15;
        Thread.sleep(r7);     // Catch: Throwable -> L18 Exception -> L23
    L15:
        r8.I = r7;     // Catch: Throwable -> L18 Exception -> L23
    L16:
        r8.E = SystemClock.uptimeMillis() - r0;     // Catch: Throwable -> L18 Exception -> L23
    L21:
        this.f6521d.unlock();
        return;
    L18:
        th = move-exception;
        this.f6521d.unlock();
        throw th;
    L24:
        if (this.f6519b.size() < this.f6520c) goto L10;
        goto L10
    }

    public void i(String r1) {
        this.f6518a = r1;
    }
}

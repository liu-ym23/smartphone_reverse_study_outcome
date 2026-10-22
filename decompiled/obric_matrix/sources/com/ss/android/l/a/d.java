package com.ss.android.l.a;

import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ss.android.l.a.a f11996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f11997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ReentrantReadWriteLock f11998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LinkedList<e> f11999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f12000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f12001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Runnable f12002g;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f12003f;

        a(d r1) {
            this.f12003f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            c r0 = d.a(this.f12003f);
            d r1 = this.f12003f;
            if (r0 != null) goto L6;
            d.b(r1);
            return;
        L6:
            d.a(r1).a(true);
            throw null;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static d f12004a;

        static {
            f12004a = new d();
        }
    }

    public d() {
        new ArrayList();
        this.f11997b = null;
        this.f11998c = new ReentrantReadWriteLock();
        this.f11999d = new LinkedList();
        this.f12002g = new a(this);
    }

    static /* synthetic */ c a(d r0) {
        return r0.f12001f;
    }

    static /* synthetic */ void b(d r0) {
        r0.c();
    }

    private void c() {
        Handler r0 = this.f12000e;
        if (r0 == null) goto L12;
        com.ss.android.l.a.a r1 = this.f11996a;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.f11993a <= 0) goto L14;
        r0.removeCallbacks(this.f12002g);
        this.f12000e.postDelayed(this.f12002g, this.f11996a.f11993a);
        if (com.ss.android.l.a.b.f11994a == false) goto L15;
        com.ss.android.l.a.b.a("HAR", "HARService.checkAndPutContinuousPredictMsg continuousPredictIntervalMs:" + this.f11996a.f11993a);
        return;
    L15:
        return;
    L14:
        return;
    }

    public static d d() {
        return b.f12004a;
    }

    private List<e> g(int r3, boolean r4) {
        if (r4 == false) goto L6;
        if (this.f11997b == null) goto L6;
    L7:
        ArrayList r0 = new ArrayList();
        if (r4 == false) goto L13;
        e r5 = this.f11997b;
        if (r5 == null) goto L13;
        r0.add(r5);
        r3 = r3 - 1;
    L13:
        if (this.f11999d.isEmpty() == true) goto L25;
        this.f11998c.readLock().lock();
        int r6 = Math.min(r3, this.f11999d.size());     // Catch: Throwable -> L20
        int r7 = 0;
    L16:
        if (r7 >= r6) goto L19;
        r0.add(this.f11999d.get(r7));     // Catch: Throwable -> L20
        r7 = r7 + 1;
        goto L16
    L19:
        this.f11998c.readLock().unlock();
    L20:
        th = move-exception;
        this.f11998c.readLock().unlock();
        throw th;
    L25:
        if (com.ss.android.l.a.b.f11994a == false) goto L27;
        com.ss.android.l.a.b.a("HAR", "HARService.getRangeHistoryHarStatus outList:" + r0);
    L27:
        return r0;
    L6:
        if (this.f11999d.isEmpty() == false) goto L7;
        r0 = null;
        goto L25
    }

    public List<e> e(int r3, boolean r4) {
        List<e> r2 = g(r3, r4);
        if (r2 != null) goto L5;
    L9:
        ArrayList r5 = null;
    L11:
        if (com.ss.android.l.a.b.f11994a == false) goto L13;
        com.ss.android.l.a.b.a("HAR", "HARService.getLastRangeHARInfoWithoutFill out:" + r5);
    L13:
        return r5;
    L5:
        if (r2.isEmpty() == true) goto L9;
        r5 = new ArrayList();
        int r6 = Math.min(r2.size(), r3);
        int r0 = 0;
    L7:
        if (r0 >= r6) goto L11;
        r5.add(r2.get(r0));
        r0 = r0 + 1;
        goto L7
    }

    public int f(int r3, boolean r4) {
        List<e> r2 = g(r3, r4);
        int r5 = 0;
        if (r2 == null) goto L11;
        if (r2.isEmpty() == true) goto L11;
        HashMap r6 = new HashMap();
        int r0 = r2.size();
    L7:
        if (r5 >= r0) goto L9;
        r2.get(r5).a(r6);
        r5 = r5 + 1;
        goto L7
    L9:
        r5 = f.b(f.a(r6));
    L11:
        if (com.ss.android.l.a.b.f11994a == false) goto L13;
        com.ss.android.l.a.b.a("HAR", "HARService.getLastRangeMostIntStatus status:" + r5);
    L13:
        return r5;
    }
}

package com.obric.matrix.r.d;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.slardaros.client.i;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final a f9922g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f9924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedList<d> f9926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HandlerThread f9927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f9928f;

    /* JADX INFO: renamed from: com.obric.matrix.r.d.a$a, reason: collision with other inner class name */
    class RunnableC0284a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f9929f;

        RunnableC0284a(a r1) {
            this.f9929f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f9929f);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f9930f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f9931g;

        b(a r1, d r2) {
            this.f9931g = r1;
            this.f9930f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.b(this.f9931g) == false) goto L6;
            this.f9930f.k(a.c(this.f9931g));
            return;
        L6:
            if (a.d(this.f9931g).size() < 200) goto L8;
            com.obric.matrix.r.c.c.b("OApmAgent", "reportEvent cache size is 200, drop event.");
            a.d(this.f9931g).removeFirst();
        L8:
            a.d(this.f9931g).add(this.f9930f);
        }
    }

    static {
        f9922g = new a();
    }

    private a() {
        this.f9923a = null;
        this.f9924b = false;
        this.f9925c = false;
        HandlerThread r0 = new HandlerThread("OApmAgent");
        this.f9927e = r0;
        r0.start();
        this.f9928f = new Handler(r0.getLooper());
        this.f9926d = new LinkedList();
    }

    static /* synthetic */ void a(a r0) {
        r0.f();
    }

    static /* synthetic */ boolean b(a r0) {
        return r0.e();
    }

    static /* synthetic */ Context c(a r0) {
        return r0.f9923a;
    }

    static /* synthetic */ LinkedList d(a r0) {
        return r0.f9926d;
    }

    private boolean e() {
        return this.f9924b;
    }

    private void f() {
        Iterator<d> r0 = this.f9926d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().k(this.f9923a);
        r0.remove();
        goto L4
    }

    public static a g() {
        return f9922g;
    }

    public boolean h() {
        return this.f9925c;
    }

    public void i(Context r2) {
        if (this.f9924b == false) goto L6;
        com.obric.matrix.r.c.c.s("OApmAgent", "init already.");
        return;
    L6:
        this.f9923a = r2;
        i.d(r2);
        this.f9924b = true;
        this.f9928f.post(new RunnableC0284a(this));
    }

    public void j(d r3) {
        this.f9928f.post(new b(this, r3));
    }

    public void k(boolean r1) {
        this.f9925c = r1;
    }
}

package com.bytedance.apm.z;

import com.bytedance.apm.d;
import d.b.b.o.m.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f2136b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CopyOnWriteArraySet<com.bytedance.apm.w.a> f2137a;

    /* JADX INFO: renamed from: com.bytedance.apm.z.a$a, reason: collision with other inner class name */
    class RunnableC0066a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f2138f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f2139g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f2140h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f2141i;

        RunnableC0066a(a r1, String r2, String r3, JSONObject r4) {
            this.f2141i = r1;
            this.f2138f = r2;
            this.f2139g = r3;
            this.f2140h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<com.bytedance.apm.w.a> r0 = this.f2141i.f2137a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().a(this.f2138f, this.f2139g, this.f2140h);
            goto L4
        }
    }

    private a() {
        this.f2137a = new CopyOnWriteArraySet();
    }

    public static a b() {
        if (f2136b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2136b != null) goto L9;
        f2136b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f2136b;
    }

    public void a(com.bytedance.apm.w.a r1) {
        if (r1 == null) goto L8;
        this.f2137a.add(r1);     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public void c(String r3, String r4, JSONObject r5) {
        if (d.C() == false) goto L6;
        b.a("LogObserver", "logObserverList:" + this.f2137a.size());
    L6:
        if (this.f2137a.size() != 0) goto L8;
        return;
    L8:
        com.bytedance.apm.f0.b.f().p(new RunnableC0066a(this, r3, r4, r5));
    }
}

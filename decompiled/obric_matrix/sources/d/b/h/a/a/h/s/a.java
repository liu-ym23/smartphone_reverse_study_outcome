package d.b.h.a.a.h.s;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f13731d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f13732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<d.b.h.a.a.h.s.b, ScheduledFuture> f13733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<d.b.h.a.a.h.s.b, Runnable> f13734c;

    /* JADX INFO: renamed from: d.b.h.a.a.h.s.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0363a {
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private d.b.h.a.a.h.s.b f13735f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f13736g;

        private b(a r1, d.b.h.a.a.h.s.b r2) {
            this.f13736g = r1;
            this.f13735f = r2;
        }

        /* synthetic */ b(a r1, d.b.h.a.a.h.s.b r2, C0363a r3) {
            this(r1, r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            System.currentTimeMillis();     // Catch: Throwable -> L6
            this.f13735f.run();     // Catch: Throwable -> L6
            Logger.debug();     // Catch: Throwable -> L6
            if (this.f13735f.e() == true) goto L12;
        L8:
            a.a(this.f13736g).remove(this.f13735f);
            a.b(this.f13736g).remove(this.f13735f);
            return;
        L12:
            return;
        L7:
            if (this.f13735f.e() == false) goto L8;
        }
    }

    static {
    }

    private a() {
        this.f13733b = new ConcurrentHashMap();
        this.f13734c = new ConcurrentHashMap();
        ScheduledThreadPoolExecutor r0 = new ScheduledThreadPoolExecutor(1, new i("ttnet-io"));
        this.f13732a = r0;
        r0.setRemoveOnCancelPolicy(true);
    }

    static /* synthetic */ ConcurrentHashMap a(a r0) {
        return r0.f13733b;
    }

    static /* synthetic */ ConcurrentHashMap b(a r0) {
        return r0.f13734c;
    }

    public static a c() {
        if (f13731d != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13731d != null) goto L9;
        f13731d = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f13731d;
    }

    public void d(d.b.h.a.a.h.s.b r9) {
        if (r9 != null) goto L11;
        return;
    L11:
        b r7 = new b(this, r9, null);     // Catch: Throwable -> L10
        if (r9.e() == false) goto L7;
        ScheduledFuture<?> r0 = this.f13732a.scheduleWithFixedDelay(r7, r9.b(), r9.c(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.f13734c.put(r9, r7);     // Catch: Throwable -> L10
        this.f13733b.put(r9, r0);     // Catch: Throwable -> L10
        return;
    L7:
        r0 = this.f13732a.schedule(r7, r9.b(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    }

    public void e(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L23;
        return;
    L23:
        Iterator<Map.Entry<d.b.h.a.a.h.s.b, Runnable>> r0 = this.f13734c.entrySet().iterator();     // Catch: Throwable -> L22
    L7:
        if (r0.hasNext() == false) goto L11;
        d.b.h.a.a.h.s.b r1 = r0.next().getKey();     // Catch: Throwable -> L22
        if (r4.equals(r1.d()) == false) goto L7;
        r0.remove();     // Catch: Throwable -> L22
        this.f13732a.remove(r1);     // Catch: Throwable -> L22
        goto L7
    L11:
        Iterator<Map.Entry<d.b.h.a.a.h.s.b, ScheduledFuture>> r3 = this.f13733b.entrySet().iterator();     // Catch: Throwable -> L22
    L12:
        if (r3.hasNext() == false) goto L35;
        Map.Entry<d.b.h.a.a.h.s.b, ScheduledFuture> r2 = r3.next();     // Catch: Throwable -> L22
        if (r4.equals(r2.getKey().d()) == false) goto L12;
        ScheduledFuture r5 = r2.getValue();     // Catch: Throwable -> L22
        if (r5 == null) goto L19;
        r5.cancel(true);     // Catch: Throwable -> L22
    L19:
        r3.remove();     // Catch: Throwable -> L22
        goto L12
    L35:
        return;
    }
}

package d.b.u;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d.b.u.w.h f15075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f15076b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.b.u.a f15077c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final g f15078d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final j f15079e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Context f15080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static e f15081g;

    static class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ WsChannelMsg f15082f;

        a(WsChannelMsg r1) {
            this.f15082f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.a().a(this.f15082f);
        }
    }

    static class b implements d.b.u.w.m {
        b() {
        }

        @Override // d.b.u.w.m
        public void a(d.b.u.w.i.a r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            if (r2.f15120a == null) goto L9;
            d.b.u.x.b.e("recv mock data:" + new String(r2.f15120a));
            return;
        }
    }

    static {
        f15076b = new AtomicBoolean(false);
        f15077c = new d.b.u.a();
        f15078d = new g();
        f15079e = new j();
        r.b();
    }

    public t() {
    }

    static /* synthetic */ d.b.u.w.h a() {
        return f15075a;
    }

    public static Collection<n> b() {
        if (c() == true) goto L6;
        return null;
    L6:
        Collection<n> r0 = f15075a.c();
        if (r0 == null) goto L16;
        Iterator<n> r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L16;
        n r2 = r1.next();
        if (r2 == null) goto L10;
        if (r2.e() != 1) goto L10;
        r1.remove();
    L16:
        return r0;
    }

    public static boolean c() {
        if (f15076b.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (f15075a == null) goto L7;
        return true;
    }

    public static void d(Context r3, e r4) {
        monitor-enter(t.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (c() == false) goto L8;
        monitor-exit(t.class);     // Catch: Throwable -> L12
        return;
    L8:
        d.b.u.x.b.a("init " + r4 + ", sdk version = 1.1.0-alpha.27");     // Catch: Throwable -> L12
        f15080f = r3;     // Catch: Throwable -> L12
        d.b.u.x.b.d(r4.f15032j);     // Catch: Throwable -> L12
        f15081g = r4;     // Catch: Throwable -> L12
        f15075a = new u(r3, r4);     // Catch: Throwable -> L12
        f15076b.set(true);     // Catch: Throwable -> L12
        monitor-exit(t.class);     // Catch: Throwable -> L12
        j r5 = f15079e;
        r5.a();
        r5.deleteObservers();
        f15077c.c();
    }

    public static void e(WsChannelMsg r2) {
        d.b.u.x.b.e("onReceiveWsEvent");
        if (r2 != null) goto L5;
    L9:
        d.b.u.x.b.e("onReceiveWsEvent not process. serviceId isn't 20032");
        return;
    L5:
        if (r2.s() != 20032) goto L9;
        f15078d.c(new a(r2));
    }

    public static d.b.u.w.i f(m r4) {
        if (r4.f15057a != 1) goto L7;
        d.b.u.x.b.b("inner business,not allow to register");
        return null;
    L7:
        if (c() == true) goto L11;
        return f15077c.b(r4);
    L11:
        return f15075a.e(r4);
    }

    private static void g() {
        m.a r0 = new m.a(1);
        r0.e(d.b.u.b0.b.g(f15080f));
        m r1 = r0.f();
        f15075a.e(r1);
        Iterator<Long> r2 = p.f15070a.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Long r3 = r2.next();
        d.b.u.w.h r4 = f15075a;
        m.a r5 = new m.a(r3.longValue());
        r5.e(new b());
        r4.e(r5.f());
        goto L4
    }

    public static void h(String r2, String r3) {
        d.b.u.x.b.e("#start, did = " + r2 + ", iid = " + r3);
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L13:
        d.b.u.x.b.c("#start#ignore, did or iid is null");
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        if (c() == false) goto L12;
        d.b.u.x.b.a("#start");
        r.a(f15080f, f15081g, r2);
        f15075a.b(r2);
        f15078d.b();
        g();
        return;
    L12:
        throw new IllegalStateException("please init first");
    }
}

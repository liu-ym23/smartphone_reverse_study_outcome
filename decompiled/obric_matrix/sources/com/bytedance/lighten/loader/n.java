package com.bytedance.lighten.loader;

import androidx.annotation.NonNull;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import d.c.i.p.g0;
import d.c.i.p.l0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class n extends d.c.i.p.c<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.k.a.m f4948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4949b;

    class a extends d.c.i.p.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.b.k.a.y.h f4950a;

        a(n r1, d.b.k.a.y.h r2) {
            this.f4950a = r2;
        }

        @Override // d.c.i.p.m0
        public void a() {
            this.f4950a.cancel();
        }
    }

    public static class b extends d.c.i.p.t {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public d.b.k.a.g f4951h;

        public b(d.c.i.p.k<d.c.i.l.e> r1, l0 r2) {
            super(r1, r2);
        }
    }

    public n(d.b.k.a.m r1) {
        this.f4948a = r1;
    }

    @Override // d.c.i.p.c, d.c.i.p.g0
    public /* bridge */ /* synthetic */ void a(d.c.i.p.t r1, int r2) {
        i((b) r1, r2);
    }

    @Override // d.c.i.p.c, d.c.i.p.g0
    public /* bridge */ /* synthetic */ Map c(d.c.i.p.t r1, int r2) {
        return h((b) r1, r2);
    }

    @Override // d.c.i.p.g0
    public /* bridge */ /* synthetic */ void d(d.c.i.p.t r1, g0.a r2) {
        g((b) r1, r2);
    }

    @Override // d.c.i.p.g0
    public /* bridge */ /* synthetic */ d.c.i.p.t e(d.c.i.p.k r1, l0 r2) {
        return f(r1, r2);
    }

    public b f(d.c.i.p.k<d.c.i.l.e> r1, l0 r2) {
        b r0 = new b(r1, r2);
        r0.f4951h = new d.b.k.a.g();
        return r0;
    }

    public void g(b r4, g0.a r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        l r0 = new l(r5);
        d.b.k.a.g r6 = r4.f4951h;
        r6.f14006f = r4.j();
        d.b.k.a.g r7 = r4.f4951h;
        r7.f14007g = new m(r4.c());
        d.b.k.a.g r8 = r4.f4951h;
        r8.f14004d = r4.e();
        d.b.k.a.g r9 = r4.f4951h;
        r9.f14010j = r4.a();
        d.h.a.e r10 = q.a();
        if (r10 == null) goto L7;
        d.b.k.a.g r1 = r4.f4951h;
        r1.f14009i = r10.s();
    L7:
        d.b.k.a.y.h r11 = this.f4948a.a();
        this.f4949b = r11.getClass().getName();
        r11.b(r4.f4951h, r0);
        r4.c().d(new a(this, r11));
        r11.a(r4.f4951h, r0);
    }

    public Map<String, String> h(b r12, int r13) {
        HashMap r11 = new HashMap(5);
        d.b.k.a.g r0 = r12.f4951h;
        long r1 = r0.f14002b;
        if (r1 == 0) goto L8;
        long r9 = r0.f14001a;
        if (r9 == 0) goto L8;
        String r2 = Long.toString(r1 - r9);
    L9:
        r11.put("queue_time", r2);
        d.b.k.a.g r3 = r12.f4951h;
        long r4 = r3.f14003c;
        if (r4 == 0) goto L15;
        long r10 = r3.f14002b;
        if (r10 == 0) goto L15;
        String r5 = Long.toString(r4 - r10);
    L16:
        r11.put("fetch_time", r5);
        d.b.k.a.g r6 = r12.f4951h;
        long r7 = r6.f14003c;
        if (r7 == 0) goto L22;
        long r14 = r6.f14001a;
        if (r14 == 0) goto L22;
        String r8 = Long.toString(r7 - r14);
    L23:
        r11.put(ICronetClient.KEY_TOTAL_TIME, r8);
        r11.put("image_size", Integer.toString(r13));
        if (r12.f4951h.f14005e == false) goto L26;
        String r15 = LocationInfoConst.ALLOW_USE_LOCATION;
    L27:
        r11.put("hit_cdn_cache", r15);
        r11.put("content_length", Long.toString(r12.f4951h.f14011k));
        return r11;
    L26:
        r15 = BDLocationException.ERROR_TIMEOUT;
    L22:
        r8 = Long.toString(-1);
    L15:
        r5 = Long.toString(-1);
    L8:
        r2 = Long.toString(-1);
        goto L9
    }

    public void i(b r1, int r2) {
        Runnable r0 = r1.f4951h.f14008h;
        if (r0 == null) goto L6;
        r0.run();
        return;
    }

    @NonNull
    public String toString() {
        return "use fetcher: " + this.f4949b;
    }
}

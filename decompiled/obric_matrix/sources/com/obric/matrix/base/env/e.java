package com.obric.matrix.base.env;

import com.bytedance.bdlocation.client.LocationInfoConst;
import d.b.r.d0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/matrix/base/env/BoePpeEvnInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "()V", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "Companion", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e implements d.b.r.j0.a {
    static {
    }

    public e() {
    }

    @Override // d.b.r.j0.a
    public d0<?> a(d.b.r.j0.a.InterfaceC0391a r19) {
        o.f(r19, "chain");
        ArrayList r1 = new ArrayList();
        d r2 = d.f8838a;
        if (r2.e() == false) goto L9;
        r1.add(new d.b.r.h0.b("X-Tt-Env", r2.b()));
        r1.add(new d.b.r.h0.b("x-use-boe", LocationInfoConst.ALLOW_USE_LOCATION));
        Iterator<Map.Entry<String, String>> r3 = r2.c().entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L14;
        Map.Entry<String, String> r4 = r3.next();
        r1.add(new d.b.r.h0.b(r4.getKey(), r4.getValue()));
    L14:
        d.b.r.h0.c r5 = r19.b();
        List<d.b.r.h0.b> r6 = r5.v();
        d.b.r.h0.c.a r7 = r5.O();
        r1.addAll(r6);
        r7.b(r1);
        com.obric.matrix.r.c.e.d("BoePpeEvnInterceptor", "intercept: " + r5.G() + ", add headers: " + r1);
        String r8 = r5.G();
        o.e(r8, "request.url");
        String r9 = null;
        if (k.F(r8, "appmonitor/v4/settings", false, 2, null) == false) goto L17;
        com.obric.matrix.r.c.c.t("BoePpeEvnInterceptor", "intercept settings", new Throwable("test"));
    L17:
        d0<?> r0 = r19.c(r7.a());
        String r10 = r5.G();
        d.b.r.h0.d r11 = r0.g();
        if (r11 == null) goto L20;
        Integer r12 = Integer.valueOf(r11.e());
    L21:
        d.b.r.h0.d r13 = r0.g();
        if (r13 == null) goto L26;
        List<d.b.r.h0.b> r14 = r13.d();
        if (r14 == null) goto L26;
        r9 = r.Z(r14, ", ", null, null, 0, null, null, 62, null);
    L26:
        com.obric.matrix.r.c.e.a("BoePpeEvnInterceptor", "Request url: [" + r10 + ']');
        com.obric.matrix.r.c.e.a("BoePpeEvnInterceptor", "Response status: [" + r12 + "], headers: [" + r9 + ']');
        o.e(r0, "ssResponse");
        return r0;
    L20:
        r12 = null;
        goto L21
    L9:
        if (r2.f() == false) goto L14;
        r1.add(new d.b.r.h0.b("X-Tt-Env", r2.d()));
        r1.add(new d.b.r.h0.b("x-use-ppe", LocationInfoConst.ALLOW_USE_LOCATION));
        Iterator<Map.Entry<String, String>> r15 = r2.c().entrySet().iterator();
    L12:
        if (r15.hasNext() == false) goto L14;
        Map.Entry<String, String> r16 = r15.next();
        r1.add(new d.b.r.h0.b(r16.getKey(), r16.getValue()));
        goto L12
    }
}

package com.obric.matrix.q.g;

import d.b.r.d0;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/base/network/NetworkStatusInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "()V", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class h implements d.b.r.j0.a {
    public h() {
    }

    @Override // d.b.r.j0.a
    public d0<?> a(d.b.r.j0.a.InterfaceC0391a r7) {
        o.c(r7);
        d.b.r.h0.c r6 = r7.b();
        o.e(r6, "chain!!.request()");
        boolean r0 = com.obric.matrix.r.e.h.b();
        com.obric.matrix.r.c.c.f("NetworkStatusInterceptor", "isNetworkAvailable is " + r0);
        if (r0 == false) goto L5;
        d0<?> r8 = r7.c(r6);
        String r9 = "{\n            chain.proceed(request)\n        }";
    L6:
        o.e(r8, r9);
        return r8;
    L5:
        r8 = d0.c(new d.b.r.k0.k(""), new d.b.r.h0.d(r6.G(), -100012, "Network is unavailable", r.g(), null));
        r9 = "{\n            val rawRes…), rawResponse)\n        }";
        goto L6
    }
}

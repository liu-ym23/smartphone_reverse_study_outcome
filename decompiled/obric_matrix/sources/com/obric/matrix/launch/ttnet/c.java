package com.obric.matrix.launch.ttnet;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.news.common.settings.e;
import com.bytedance.ttnet.m.d;
import com.obric.matrix.base.settings.iconfig.IMatrixTtnetConfig;
import d.b.r.d0;
import java.net.URI;
import java.util.Map;
import kotlin.Metadata;
import kotlin.i0.m0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/launch/ttnet/TimeOutIntercept;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "()V", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c implements d.b.r.j0.a {
    public c() {
    }

    @Override // d.b.r.j0.a
    public d0<?> a(d.b.r.j0.a.InterfaceC0391a r9) {
        o.f(r9, "chain");
        d.b.r.h0.c r0 = r9.b();
        o.e(r0, "chain.request()");
        if (r0.t() != null) goto L6;
    L12:
        d r1 = new d();     // Catch: Exception -> L32
    L13:
        long r2 = ((IMatrixTtnetConfig) e.e(IMatrixTtnetConfig.class)).getRequestTimeoutConfig().b();     // Catch: Exception -> L32
        Map<String, Integer> r8 = ((IMatrixTtnetConfig) e.e(IMatrixTtnetConfig.class)).getRequestTimeoutConfig().c();     // Catch: Exception -> L32
        if (r8 != null) goto L17;
        r8 = m0.h();     // Catch: Exception -> L32
    L17:
        if (r2 >= WsConstants.EXIT_DELAY_TIME) goto L19;
        r2 = 20000;
    L19:
        String r4 = URI.create(r0.G()).getPath();     // Catch: Exception -> L32
        if (r8.containsKey(r4) == false) goto L27;
        Integer r10 = r8.get(r4);     // Catch: Exception -> L32
        if (r10 != null) goto L24;
        r10 = Long.valueOf(r2);     // Catch: Exception -> L32
    L24:
        r2 = r10.longValue();     // Catch: Exception -> L32
    L25:
        r1.f13374i = r2;     // Catch: Exception -> L32
    L29:
        r1.x = true;     // Catch: Exception -> L32
        r0.R(r1);     // Catch: Exception -> L32
        goto L30
    L27:
        if (r1.f13374i > 0) goto L29;
    L6:
        if ((r0.t() instanceof d) == false) goto L12;
        Object r3 = r0.t();     // Catch: Exception -> L32
        if (r3 == null) goto L11;
        r1 = (d) r3;     // Catch: Exception -> L32
        goto L13
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ttnet.http.RequestContext");     // Catch: Exception -> L32
    L30:
        d0 r11 = r9.c(r0);
        o.e(r11, "chain.proceed(request)");
        return r11;
    }
}

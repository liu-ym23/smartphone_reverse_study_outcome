package com.obric.matrix.common_api;

import com.bytedance.ttnet.s.d;
import com.obric.matrix.q.g.g;
import com.obric.matrix.q.g.h;
import com.obric.matrix.q.g.i;
import d.b.r.v;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u0002H\f\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/matrix/common_api/PlatformApiManager;", "", "()V", "HOST_LIST", "", "Lcom/obric/matrix/common_api/Env;", "", "RETROFIT", "Lcom/bytedance/retrofit2/Retrofit;", "isInterceptorAdded", "Ljava/util/concurrent/atomic/AtomicBoolean;", "create", "T", "service", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "env", "getBaseUrl", "getHostByEnv", "common_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8951a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<a, String> f8952b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f8953c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final v f8954d = null;

    static {
        c r0 = new c();
        f8951a = r0;
        f8952b = m0.k(new u[]{a0.a(a.f8946f, "https://pdev-api-boe.bytedance.net"), a0.a(a.f8947g, "https://platform-cn.picovr.com"), a0.a(a.f8948h, "https://platform-cn.picovr.com")});
        f8953c = new AtomicBoolean(false);
        v r1 = d.b(r0.c(), r.g(), null, null, null);
        o.e(r1, "createRetrofit(\n        …l,\n            null\n    )");
        f8954d = r1;
    }

    private c() {
    }

    private final a b() {
        com.obric.matrix.base.env.d r1 = com.obric.matrix.base.env.d.f8838a;
        if (r1.e() == false) goto L6;
        return a.f8946f;
    L6:
        if (r1.f() == false) goto L9;
        return a.f8947g;
    L9:
        return a.f8948h;
    }

    private final String c() {
        String r0 = d();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    private final String d() {
        return f8952b.get(b());
    }

    public final <T> T a(Class<T> r3) {
        if (f8953c.compareAndSet(false, true) == false) goto L6;
        v r2 = f8954d;
        r2.i().add(new h());
        r2.i().add(new i());
        r2.i().add(new g());
    L6:
        return (T) f8954d.e(r3);
    }
}

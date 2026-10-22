package com.obric.matrix.q.g;

import android.text.TextUtils;
import com.obric.matrix.base.settings.iconfig.IOpenAuthConfig;
import d.b.r.d0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/matrix/base/network/CheckTokenInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "()V", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "Companion", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class g implements d.b.r.j0.a {
    static {
    }

    public g() {
    }

    private static final boolean b(d.b.r.h0.b r1) {
        o.f(r1, "it");
        String r2 = r1.a();
        o.e(r2, "it.name");
        String r3 = r2.toLowerCase();
        o.e(r3, "this as java.lang.String).toLowerCase()");
        return o.a(r3, "x-tt-token");
    }

    public static /* synthetic */ boolean c(d.b.r.h0.b r0) {
        return b(r0);
    }

    @Override // d.b.r.j0.a
    public d0<?> a(d.b.r.j0.a.InterfaceC0391a r9) {
        o.c(r9);
        d.b.r.h0.c r8 = r9.b();
        o.e(r8, "chain!!.request()");
        if (((IOpenAuthConfig) com.bytedance.news.common.settings.e.e(IOpenAuthConfig.class)).getOpenAuthConfig().b() == false) goto L16;
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L21
        List<d.b.r.h0.b> r1 = r8.v();     // Catch: Exception -> L21
        o.e(r1, "request.headers");     // Catch: Exception -> L21
        r0.addAll(r1);     // Catch: Exception -> L21
        boolean r2 = false;
        Iterator<d.b.r.h0.b> r3 = r0.iterator();     // Catch: Exception -> L21
    L7:
        if (r3.hasNext() == false) goto L13;
        d.b.r.h0.b r4 = r3.next();     // Catch: Exception -> L21
        String r5 = r4.a();     // Catch: Exception -> L21
        o.e(r5, "h.name");     // Catch: Exception -> L21
        Locale r6 = Locale.ROOT;     // Catch: Exception -> L21
        o.e(r6, "ROOT");     // Catch: Exception -> L21
        String r7 = r5.toLowerCase(r6);     // Catch: Exception -> L21
        o.e(r7, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L21
        if (o.a("x-access-token", r7) == false) goto L7;
        if (TextUtils.isEmpty(r4.b()) == true) goto L7;
        com.obric.matrix.r.c.c.b("CheckTokenInterceptor", "has acces token , don't need add x-tt-token");     // Catch: Exception -> L21
        r2 = true;
    L13:
        if (r2 == false) goto L15;
        r0.removeIf(a.f9855a);     // Catch: Exception -> L21
    L15:
        d.b.r.h0.c.a r10 = r8.O();     // Catch: Exception -> L21
        r10.b(r0);     // Catch: Exception -> L21
        d.b.r.h0.c r11 = r10.a();     // Catch: Exception -> L21
    L17:
        o.e(r11, "{\n            val openAu…t\n            }\n        }");     // Catch: Exception -> L21
        r8 = r11;
        goto L19
    L16:
        r11 = r8;
    L19:
        d0<?> r12 = r9.c(r8);
        o.e(r12, "chain.proceed(request)");
        return r12;
    }
}

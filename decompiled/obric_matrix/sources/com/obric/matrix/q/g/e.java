package com.obric.matrix.q.g;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.r.e.l;
import d.b.r.d0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/base/network/AddThirdAppCommonParamsIntercept;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "()V", "addCommonUrl", "", "request", "Lcom/bytedance/retrofit2/client/Request;", "appid", "getAppId", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "Companion", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e implements d.b.r.j0.a {
    static {
    }

    public e() {
    }

    private final String b(d.b.r.h0.c r13, String r14) {
        String r12 = r13.G();
        boolean r15 = TextUtils.isEmpty(r14);
        o.e(r12, WsConstants.KEY_CONNECTION_URL);
        if (r15 == false) goto L5;
        return r12;
    L5:
        boolean r3 = kotlin.u0.k.E(r12, '?', false, 2, null);
        StringBuilder r4 = new StringBuilder(r12);
        if (r3 == false) goto L9;
        r4.append('&');
    L13:
        f r16 = k.f9865a.b(r14);
        if (r16 == null) goto L21;
        l r7 = l.f9944a;
        kotlin.u0.k.g(r4, new Object[]{"third_app_name", '=', r7.c(r16.b())});
        r4.append('&');
        if (kotlin.u0.k.F(r12, "third_app_version", false, 2, null) == true) goto L18;
        kotlin.u0.k.g(r4, new Object[]{"third_app_version", '=', Long.valueOf(r16.d())});
        r4.append('&');
    L18:
        kotlin.u0.k.g(r4, new Object[]{"platform_sdk_version_str", '=', r7.c(r16.c())});
        r4.append('&');
        kotlin.u0.k.g(r4, new Object[]{"loader_version", '=', r7.c(r16.a())});
        r4.append('&');
        if (kotlin.u0.k.F(r12, "platform_sdk_version", false, 2, null) == true) goto L21;
        kotlin.u0.k.g(r4, new Object[]{"platform_sdk_version", '=', r7.c(r16.a())});
    L21:
        String r17 = r4.toString();
        o.e(r17, "builder.toString()");
        return r17;
    L9:
        if (kotlin.u0.k.J0(r4) == '?') goto L13;
        if (kotlin.u0.k.J0(r4) == '&') goto L13;
        r4.append('?');
        goto L13
    }

    @Override // d.b.r.j0.a
    public d0<?> a(d.b.r.j0.a.InterfaceC0391a r3) {
        o.c(r3);
        d.b.r.h0.c r0 = r3.b();
        o.e(r0, "chain!!.request()");
        String r2 = b(r0, c(r0));
        d.b.r.h0.c.a r1 = r0.O();
        r1.h(r2);
        d0<?> r4 = r3.c(r1.a());
        o.e(r4, "chain.proceed(builder.build())");
        return r4;
    }

    public final String c(d.b.r.h0.c r12) {
        o.f(r12, "request");
        com.obric.matrix.r.c.e.d("AddThirdAppCommonPa", "header = " + r12.v());
        List<d.b.r.h0.b> r11 = r12.v();
        String r0 = null;
        if (r11 == null) goto L23;
        Iterator<T> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L23;
        d.b.r.h0.b r2 = (d.b.r.h0.b) r13.next();
        if (o.a(r2.a(), "appId") == true) goto L10;
        if (o.a(r2.a(), "Agw-Auth") == false) goto L6;
        if (TextUtils.isEmpty(r2.b()) == true) goto L6;
        String r3 = r2.b();
        o.e(r3, "it.value");
        if (kotlin.u0.k.A(r3, "auth-v2", false, 2, null) == false) goto L6;
        String r5 = r2.b();
        o.e(r5, "it.value");
        List r4 = kotlin.u0.k.n0(r5, new String[]{"/"}, false, 0, 6, null);
        if (r4.size() != 5) goto L6;
        return (String) r4.get(1);
    L10:
        if (TextUtils.isEmpty(r2.b()) == true) goto L6;
        String r14 = r2.b();
        o.e(r14, "it.value");
        return r14;
    L23:
        d.b.r.k0.j r15 = r12.s();
        if ((r15 instanceof d.b.r.k0.g) == false) goto L35;
        byte[] r16 = ((d.b.r.k0.g) r15).k();
        o.e(r16, "typedOutput.bytes");
        Map<String, Object> r17 = com.obric.matrix.r.e.e.c(new String(r16, kotlin.u0.d.f21429a));
        if (r17 == null) goto L35;
        Object r18 = r17.get("appId");
        if ((r18 instanceof String) == false) goto L30;
        r0 = (String) r18;
    L30:
        if (r0 != null) goto L33;
        r0 = "";
    L33:
        if (TextUtils.isEmpty(r0) == true) goto L35;
        return r0;
    L35:
        return "";
    }
}

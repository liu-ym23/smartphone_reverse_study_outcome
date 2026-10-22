package com.obric.matrix.q.g;

import androidx.core.internal.view.SupportMenu;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.r.e.m;
import d.b.r.d0;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.n0.d.i0;
import kotlin.n0.d.o;
import kotlin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001e\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¨\u0006\""}, d2 = {"Lcom/obric/matrix/base/network/TTNetSignInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "()V", "addCommonUrl", "", "request", "Lcom/bytedance/retrofit2/client/Request;", "did", "getCommonParamFromBody", "key", "getCommonQueryParams", "getHeaders", "", "Lcom/bytedance/retrofit2/client/Header;", "oldHeaders", "", "sign", "accessToken", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "paredDownBody", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "parseBody", "Lkotlin/Pair;", "parseHeader", "sha256HMAC", "data", "", "ver", "ak", "sk", "Companion", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class i implements d.b.r.j0.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final kotlin.r0.d f9864f = null;

    static {
        f9864f = new kotlin.r0.d(0, SupportMenu.USER_MASK);
    }

    public i() {
    }

    private final String b(d.b.r.h0.c r6, String r7) {
        String r8 = r6.G();
        o.e(r8, WsConstants.KEY_CONNECTION_URL);
        boolean r1 = kotlin.u0.k.E(r8, '?', false, 2, null);
        StringBuilder r2 = new StringBuilder(r8);
        if (r1 == false) goto L6;
        r2.append('&');
    L10:
        r2.append("_nonce");
        r2.append('=');
        r2.append(kotlin.r0.e.k(f9864f, kotlin.q0.c.f18452f));
        r2.append('&');
        r2.append("_timestamp");
        r2.append('=');
        r2.append(System.currentTimeMillis());
        r2.append('&');
        r2.append("third_app_version");
        r2.append('=');
        r2.append(c(r6, "thirdAppVersion"));
        r2.append('&');
        r2.append("platform_sdk_version");
        r2.append('=');
        r2.append(c(r6, "platformSdkVersion"));
        r2.append('&');
        r2.append("zone_name");
        r2.append('=');
        m r5 = m.f9945a;
        String r9 = r5.e();
        if (r9 != null) goto L13;
        r9 = "";
    L13:
        r2.append(r9);
        r2.append('&');
        r2.append("timestamp");
        r2.append('=');
        r2.append(r5.d());
        String r10 = r2.toString();
        o.e(r10, "builder.toString()");
        return r10;
    L6:
        if (kotlin.u0.k.J0(r2) == '?') goto L10;
        if (kotlin.u0.k.J0(r2) == '&') goto L10;
        r2.append('?');
        goto L10
    }

    private final String c(d.b.r.h0.c r3, String r4) {
        d.b.r.k0.j r2 = r3.s();
        String r0 = "";
        if ((r2 instanceof d.b.r.k0.g) == false) goto L19;
        byte[] r5 = ((d.b.r.k0.g) r2).k();
        o.e(r5, "typedOutput.bytes");
        Map<String, Object> r6 = com.obric.matrix.r.e.e.c(new String(r5, kotlin.u0.d.f21429a));
        if (r6 == null) goto L19;
        Object r7 = r6.get(r4);
        if ((r7 instanceof String) == false) goto L9;
        String r8 = (String) r7;
    L10:
        if (r8 == null) goto L14;
        r0 = r8;
    L14:
        if (r0.length() != 0) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == false) goto L19;
        com.obric.matrix.r.c.c.f("SETTNetSignInterceptor", r4 + " is empty,please check.");
        goto L19
    L16:
        r9 = false;
        goto L17
    L9:
        r8 = null;
    L19:
        return r0;
    }

    private static final boolean e(d.b.r.h0.b r1) {
        o.f(r1, "it");
        return o.a(r1.a(), "accessToken");
    }

    private static final boolean f(d.b.r.h0.b r1) {
        o.f(r1, "it");
        return o.a(r1.a(), "appId");
    }

    public static /* synthetic */ boolean g(d.b.r.h0.b r0) {
        return f(r0);
    }

    public static /* synthetic */ boolean h(d.b.r.h0.b r0) {
        return e(r0);
    }

    private final d.b.r.k0.j i(d.b.r.h0.c r5) {
        d.b.r.k0.j r4 = r5.s();
        if ((r4 instanceof d.b.r.k0.g) == false) goto L6;
        byte[] r6 = ((d.b.r.k0.g) r4).k();
        o.e(r6, "typedOutput.bytes");
        Charset r1 = kotlin.u0.d.f21429a;
        JSONObject r7 = new JSONObject(new String(r6, r1));
        r7.remove("appId");
        r7.remove("accessToken");
        r7.remove("thirdAppVersion");
        r7.remove("platformSdkVersion");
        String r8 = r7.toString();
        o.e(r8, "jo.toString()");
        String r2 = r4.a();
        byte[] r9 = r8.getBytes(r1);
        o.e(r9, "this as java.lang.String).getBytes(charset)");
        return new d.b.r.k0.g(r2, r9, new String[]{r4.c()});
    L6:
        return r4;
    }

    private final u<String, String> j(d.b.r.h0.c r4) {
        d.b.r.k0.j r3 = r4.s();
        String r0 = "";
        if ((r3 instanceof d.b.r.k0.g) == false) goto L30;
        byte[] r5 = ((d.b.r.k0.g) r3).k();
        o.e(r5, "typedOutput.bytes");
        Map<String, Object> r6 = com.obric.matrix.r.e.e.c(new String(r5, kotlin.u0.d.f21429a));
        if (r6 == null) goto L30;
        Object r7 = r6.get("appId");
        String r2 = null;
        if ((r7 instanceof String) == false) goto L9;
        String r8 = (String) r7;
    L10:
        Object r9 = r6.get("accessToken");
        if ((r9 instanceof String) == false) goto L13;
        r2 = (String) r9;
    L13:
        if (r8 != null) goto L15;
    L18:
        boolean r10 = true;
    L19:
        if (r10 == false) goto L22;
        com.obric.matrix.r.c.c.f("SETTNetSignInterceptor", "appId empty,please check.");
    L22:
        if (r8 != null) goto L24;
        r8 = "";
    L24:
        if (r2 == null) goto L28;
        r0 = r2;
    L28:
        return new u(r8, r0);
    L15:
        if (r8.length() == 0) goto L18;
        r10 = false;
        goto L19
    L9:
        r8 = null;
    L30:
        return new u("", "");
    }

    private final u<String, String> k(d.b.r.h0.c r8) {
        List<d.b.r.h0.b> r7 = r8.v();
        o.e(r7, "request.headers");
        if (r7.isEmpty() == false) goto L5;
        return null;
    L5:
        Iterator<T> r9 = r7.iterator();
        String r10 = "";
        String r1 = "";
    L6:
        boolean r3 = true;
        if (r9.hasNext() == false) goto L27;
        d.b.r.h0.b r2 = (d.b.r.h0.b) r9.next();
        if (o.a(r2.a(), "appId") == true) goto L10;
        if (o.a(r2.a(), "accessToken") == false) goto L6;
        String r4 = r2.b();
        if (r4 == null) goto L6;
        o.e(r4, "it.value ?: accessToken");
        r1 = r4;
        goto L6
    L10:
        String r5 = r2.b();
        if (r5 == null) goto L15;
        o.e(r5, "it.value ?: appId");
        r10 = r5;
    L15:
        if (r10.length() == 0) goto L18;
        r3 = false;
    L18:
        if (r3 == false) goto L6;
        com.obric.matrix.r.c.c.f("SETTNetSignInterceptor", "appId is empty, please check.");
        goto L6
    L27:
        if (r10.length() == 0) goto L30;
        r3 = false;
    L30:
        if (r3 == false) goto L33;
        return null;
    L33:
        return new u(r10, r1);
    }

    private final String l(String r8, byte[] r9) {
        Mac r0 = Mac.getInstance("HmacSHA256");
        o.e(r0, "getInstance(\"HmacSHA256\")");
        byte[] r10 = r8.getBytes(kotlin.u0.d.f21429a);
        o.e(r10, "this as java.lang.String).getBytes(charset)");
        r0.init(new SecretKeySpec(r10, "HmacSHA256"));
        byte[] r7 = r0.doFinal(r9);
        o.e(r7, "sha256_HMAC.doFinal(data)");
        byte[] r11 = new byte[r7.length * 2];
        int r12 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r12) goto L6;
        i0 r3 = i0.f18445a;
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf((byte) (r7[r1] & (-1)))}, 1));
        o.e(r4, "format(format, *args)");
        byte[] r5 = r4.getBytes(kotlin.u0.d.f21429a);
        o.e(r5, "this as java.lang.String).getBytes(charset)");
        int r6 = r1 * 2;
        r11[r6] = r5[0];
        r11[r6 + 1] = r5[1];
        r1 = r1 + 1;
        goto L3
    L6:
        return new String(r11, kotlin.u0.d.f21429a);
    }

    @Override // d.b.r.j0.a
    public d0<?> a(d.b.r.j0.a.InterfaceC0391a r11) {
        o.c(r11);
        d.b.r.h0.c r0 = r11.b();
        o.e(r0, "chain!!.request()");
        u<String, String> r1 = k(r0);
        if (r1 != null) goto L5;
        r1 = j(r0);
    L5:
        String r2 = com.obric.matrix.ostracker_api.b.c();
        String r3 = "";
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        String r4 = b(r0, r2);
        boolean r5 = true;
        String r6 = r4.substring(kotlin.u0.k.P(r4, '?', 0, false, 6, null) + 1);
        o.e(r6, "this as java.lang.String).substring(startIndex)");
        d.b.r.k0.j r7 = i(r0);
        if (o.a(r0.y(), "GET") == false) goto L11;
        byte[] r8 = r6.getBytes(kotlin.u0.d.f21429a);
        o.e(r8, "this as java.lang.String).getBytes(charset)");
    L16:
        String r9 = com.obric.matrix.base.settings.iconfig.a.f8887b.a().c();
        if (r9 == null) goto L21;
        r3 = r9;
    L21:
        if (r3.length() == 0) goto L24;
        r5 = false;
    L24:
        if (r5 == false) goto L26;
        com.obric.matrix.r.c.c.j("SETTNetSignInterceptor", "sk empty url: " + r4);
    L26:
        String r10 = m("auth-v2", r1.c(), r3, r8);
        List<d.b.r.h0.b> r12 = r0.v();
        o.e(r12, "request.headers");
        List<d.b.r.h0.b> r13 = d(r12, r10, r1.d());
        d.b.r.h0.c.a r14 = r0.O();
        r14.h(r4);
        r14.b(r13);
        r14.c(r0.y(), r7);
        d0<?> r15 = r11.c(r14.a());
        o.e(r15, "chain.proceed(builder.build())");
        return r15;
    L11:
        ByteArrayOutputStream r16 = new ByteArrayOutputStream();
        if (r7 != null) goto L33;
    L14:
        byte[] r17 = r16.toByteArray();     // Catch: Throwable -> L28
        kotlin.m0.b.a(r16, null);
        r8 = r17;
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        kotlin.m0.b.a(r16, th);
        throw th;
    L33:
        r7.b(r16);     // Catch: Throwable -> L28
        goto L14
    }

    public final List<d.b.r.h0.b> d(List<d.b.r.h0.b> r2, String r3, String r4) {
        o.f(r2, "oldHeaders");
        o.f(r3, "sign");
        ArrayList r1 = new ArrayList();
        r1.addAll(r2);
        r1.add(new d.b.r.h0.b("Agw-Auth", r3));
        r1.add(new d.b.r.h0.b("User-Agent", "pico_pui"));
        r1.add(new d.b.r.h0.b("X-Access-Token", r4));
        r1.removeIf(c.f9857a);
        r1.removeIf(b.f9856a);
        return r1;
    }

    public final String m(String r6, String r7, String r8, byte[] r9) {
        o.f(r6, "ver");
        o.f(r7, "ak");
        o.f(r8, "sk");
        long r0 = System.currentTimeMillis() / 1000;
        i0 r2 = i0.f18445a;
        String r10 = String.format("%s/%s/%d/%d", Arrays.copyOf(new Object[]{r6, r7, Long.valueOf(r0), 1800}, 4));
        o.e(r10, "format(format, *args)");
        byte[] r3 = r10.getBytes(kotlin.u0.d.f21429a);
        o.e(r3, "this as java.lang.String).getBytes(charset)");
        String r5 = String.format("%s/%s", Arrays.copyOf(new Object[]{r10, l(l(r8, r3), r9)}, 2));
        o.e(r5, "format(format, *args)");
        return r5;
    }
}

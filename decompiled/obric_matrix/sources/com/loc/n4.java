package com.loc;

import android.content.Context;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.matrix.common_api.INetworkApi;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class n4 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static n4 f7568e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7572d;

    static {
    }

    private n4(Context r2) {
        this.f7569a = null;
        this.f7570b = s4.f7776i;
        this.f7571c = false;
        this.f7572d = 0;
        n5.a().c(r2);     // Catch: Throwable -> L6
    L4:
        this.f7569a = r2;
        o0.b();
    }

    public static n4 b(Context r1) {
        if (f7568e != null) goto L6;
        f7568e = new n4(r1);
    L6:
        return f7568e;
    }

    public final u0 a(o4 r1) {
        if (this.f7571c == false) goto L6;
        r1.f(t0.c.f7815g);
    L6:
        return o0.c(r1);
    }

    public final o4 c(Context r11, byte[] r12, String r13, String r14, boolean r15) {
        HashMap r1 = new HashMap(16);     // Catch: Throwable -> L23
        o4 r3 = new o4(r11, s4.q());     // Catch: Throwable -> L23
        r1.put(INetworkApi.CONTENT_TYPE, "application/octet-stream");     // Catch: Throwable -> L25
        r1.put("Accept-Encoding", "gzip");     // Catch: Throwable -> L25
        r1.put("gzipped", LocationInfoConst.ALLOW_USE_LOCATION);     // Catch: Throwable -> L25
        r1.put("Connection", "Keep-Alive");     // Catch: Throwable -> L25
        r1.put("User-Agent", "AMAP_Location_SDK_Android 6.4.0");     // Catch: Throwable -> L25
        r1.put("KEY", i5.j(r11));     // Catch: Throwable -> L25
        r1.put("enginever", s4.f7768a);     // Catch: Throwable -> L25
        String r4 = k5.a();     // Catch: Throwable -> L25
        String r5 = k5.c(r11, r4, "key=" + i5.j(r11));     // Catch: Throwable -> L25
        r1.put("ts", r4);     // Catch: Throwable -> L25
        r1.put("scode", r5);     // Catch: Throwable -> L25
        if (Double.valueOf(s4.f7768a).doubleValue() < 5.3d) goto L7;
        r1.put("aps_s_src", "openapi");     // Catch: Throwable -> L25
    L7:
        r1.put("encr", LocationInfoConst.ALLOW_USE_LOCATION);     // Catch: Throwable -> L25
        r3.W(r1);     // Catch: Throwable -> L25
        String r0 = "loc";
        if (r15 == true) goto L10;
        r0 = "locf";
    L10:
        r3.a0(true);     // Catch: Throwable -> L25
        r3.V(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[]{"6.4.0", r0, 3}));     // Catch: Throwable -> L25
        r3.X(r15);     // Catch: Throwable -> L25
        r3.Z(r13);     // Catch: Throwable -> L25
        r3.c0(r14);     // Catch: Throwable -> L25
        r3.b0(a5.w(r12));     // Catch: Throwable -> L25
        r3.h(s5.c(r11));     // Catch: Throwable -> L25
        HashMap r16 = new HashMap(16);     // Catch: Throwable -> L25
        r16.put("output", "bin");     // Catch: Throwable -> L25
        r16.put("policy", "3103");     // Catch: Throwable -> L25
        int r17 = this.f7572d;     // Catch: Throwable -> L25
        if (r17 == 0) goto L15;
        if (r17 == 1) goto L18;
        if (r17 != 2) goto L15;
        String r18 = "language:en";
    L17:
        r16.put("custom", r18);     // Catch: Throwable -> L25
    L19:
        r3.U(r16);     // Catch: Throwable -> L25
        r3.c(this.f7570b);     // Catch: Throwable -> L25
        r3.l(this.f7570b);     // Catch: Throwable -> L25
        if (this.f7571c == false) goto L30;
        r3.f(t0.c.f7815g);     // Catch: Throwable -> L25
        return r3;
    L30:
        return r3;
    L18:
        r18 = "language:cn";
    L15:
        r16.remove("custom");     // Catch: Throwable -> L25
    L32:
        return r3;
    L23:
        return null;
    }

    public final String d(Context r9, double r10, double r12) {
        HashMap r0 = new HashMap(16);     // Catch: Throwable -> L25
        o4 r2 = new o4(r9, s4.q());     // Catch: Throwable -> L25
        r0.clear();     // Catch: Throwable -> L25
        r0.put(INetworkApi.CONTENT_TYPE, "application/x-www-form-urlencoded");     // Catch: Throwable -> L25
        r0.put("Connection", "Keep-Alive");     // Catch: Throwable -> L25
        r0.put("User-Agent", "AMAP_Location_SDK_Android 6.4.0");     // Catch: Throwable -> L25
        HashMap r3 = new HashMap(16);     // Catch: Throwable -> L25
        r3.put("custom", "26260A1F00020002");     // Catch: Throwable -> L25
        r3.put("key", i5.j(r9));     // Catch: Throwable -> L25
        int r1 = this.f7572d;     // Catch: Throwable -> L25
        if (r1 == 0) goto L7;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L7;
        String r4 = "en";
    L9:
        r3.put("language", r4);     // Catch: Throwable -> L25
    L12:
        if (a5.e0(this.f7569a) == false) goto L14;
        String r6 = "coarseLoc";
    L15:
        r3.put("curLocationType", r6);     // Catch: Throwable -> L25
        String r5 = k5.a();     // Catch: Throwable -> L25
        String r7 = k5.c(r9, r5, u5.r(r3));     // Catch: Throwable -> L25
        r3.put("ts", r5);     // Catch: Throwable -> L25
        r3.put("scode", r7);     // Catch: Throwable -> L25
        r2.Y(("output=json&radius=1000&extensions=all&location=" + r12 + "," + r10).getBytes("UTF-8"));     // Catch: Throwable -> L25
        r2.a0(false);     // Catch: Throwable -> L25
        r2.X(true);     // Catch: Throwable -> L25
        r2.V(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[]{"6.4.0", "loc", 3}));     // Catch: Throwable -> L25
        r2.U(r3);     // Catch: Throwable -> L25
        r2.W(r0);     // Catch: Throwable -> L25
        r2.h(s5.c(r9));     // Catch: Throwable -> L25
        r2.c(s4.f7776i);     // Catch: Throwable -> L25
        r2.l(s4.f7776i);     // Catch: Throwable -> L25
        r2.c0("http://dualstack-arestapi.amap.com/v3/geocode/regeo");     // Catch: Throwable -> L21
        r2.Z("http://restsdk.amap.com/v3/geocode/regeo");     // Catch: Throwable -> L21
        if (this.f7571c == false) goto L19;
        r2.f(t0.c.f7815g);     // Catch: Throwable -> L21
    L19:
        goto L23
    L29:
        return new String(o0.c(r2).f7856a, "utf-8");
    L21:
        th = move-exception;
        s4.h(th, "LocNetManager", "post");     // Catch: Throwable -> L25
        goto L23
    L14:
        r6 = "fineLoc";
        goto L15
    L10:
        r4 = "zh-CN";
    L7:
        r3.remove("language");     // Catch: Throwable -> L25
    L23:
        return null;
    }

    public final void e(long r1, boolean r3, int r4) {
        this.f7571c = r3;     // Catch: Throwable -> L4
        this.f7570b = Long.valueOf(r1).intValue();     // Catch: Throwable -> L4
        this.f7572d = r4;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "LocNetManager", "setOption");
    }
}

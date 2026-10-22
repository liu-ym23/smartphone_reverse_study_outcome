package com.bytedance.frameworks.baselib.network.http.cronet.e;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.obric.matrix.common_api.INetworkApi;
import d.b.r.n;
import d.b.r.y;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends d.b.h.a.a.h.m.b implements n {
    protected static volatile boolean n = true;
    protected static volatile boolean o = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected volatile int f4710l;
    private volatile long m;

    static {
    }

    c(d.b.r.h0.c r4) {
        super(r4);
        this.f4710l = 0;
        this.m = 0;
        d.b.h.a.a.h.b r0 = this.f13419g;     // Catch: Exception -> L5
        r0.B = 0;     // Catch: Exception -> L5
        r0.f13363j = d.b.h.a.a.h.a.b();     // Catch: Exception -> L5
        this.f13419g.F.put("hc", "SsCronetHttpClient");     // Catch: Exception -> L5
        this.f13419g.F.put("hcv", j.o());     // Catch: Exception -> L5
        return;
    }

    private static void U(JSONObject r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (j.n() == null) goto L7;
        JSONObject r0 = j.n().j();
    L8:
        if (r0 == null) goto L16;
        r2.put("ab_test", r0);     // Catch: JSONException -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        return;
    L7:
        r0 = null;
        goto L8
    }

    private void X(boolean r2, String r3, String r4) {
        if (r2 == true) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (r3.contains("net::ERR_INTERNET_DISCONNECTED") == false) goto L12;
        d.b.h.a.a.h.l.e r1 = new d.b.h.a.a.h.l.e("network not available for " + r4 + ", message:" + r3);
        r1.b(true);
        throw r1;
    }

    private int c0(d.b.r.h0.c r1) {
        return j.k(r1.A(), this.f13419g);
    }

    private static String d0(d.b.r.k0.j r2) {
        if ((r2 instanceof d.b.r.k0.a) == false) goto L5;
        d.b.r.k0.a r0 = (d.b.r.k0.a) r2;
        if (TextUtils.isEmpty(r0.f()) == true) goto L9;
        String r3 = r0.h();
        TextUtils.isEmpty(r3);
        return r3;
    L9:
        return r2.e();
    L5:
        return r2.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T e0(Object r1, Class<T> r2, T r3) {
        if (r1 != 0) goto L4;
    L6:
        return r3;
    L4:
        if (r1.getClass().equals(r2) == false) goto L6;
        return r1;
    }

    static /* synthetic */ void f0(String r0, String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        j.A(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);     // Catch: Exception -> L4
        return;
    }

    private static void g0(d.b.r.h0.c r2) {
        if (r2.z() != null) goto L5;
        return;
    L5:
        d.b.r.h0.b r0 = r2.u("x-bd-content-encoding");
        if (r0 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r0.b()) == true) goto L19;
        JSONObject r3 = r2.z().w0;
        if (r3 != null) goto L16;
        return;
    L16:
        r3.put("encode", r0.b());     // Catch: JSONException -> L15
        r3.put("disableReason", d.b.r.k0.f.e.p.a());     // Catch: JSONException -> L15
        return;
    L20:
        return;
    }

    private static void h0(long r3, long r5, int r7, long r8, d.b.r.h0.c r10, d.b.r.k0.f.b r11) {
        if (r10.z() != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put("beforeSize", r3);     // Catch: JSONException -> L10
        if (r7 == 0) goto L12;
        r1.put("disableReason", r7);     // Catch: JSONException -> L10
    L12:
        if (r11 != null) goto L33;
    L13:
        r10.z().w0 = r1;
        return;
    L33:
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L16:
        if (TextUtils.isEmpty(r11.f14448b) == true) goto L18;
        r1.put(WsConstants.KEY_CONNECTION_TYPE, r11.f14448b);     // Catch: JSONException -> L29
        r1.put("afterSize", r5);     // Catch: JSONException -> L29
    L18:
        int r4 = r11.f14449c;     // Catch: JSONException -> L29
        if (r4 == 0) goto L27;
        r1.put("disableReason", r4);     // Catch: JSONException -> L29
        if (r11.f14449c == d.b.r.k0.f.e.n.a()) goto L25;
        if (r11.f14449c != d.b.r.k0.f.e.m.a()) goto L27;
    L25:
        if (TextUtils.isEmpty(r11.f14450d) == true) goto L27;
        r1.put("prefix", r11.f14450d);     // Catch: JSONException -> L29
    L27:
        r1.put(TypedValues.TransitionType.S_DURATION, System.currentTimeMillis() - r8);     // Catch: JSONException -> L29
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static void j0(boolean r0) {
        n = r0;
    }

    public static void k0(boolean r0) {
        o = r0;
    }

    private static boolean l0(d.b.r.h0.c r1) {
        d.b.r.h0.b r2 = r1.u("x-metasec-content-encoding");
        if (r2 != null) goto L7;
        return false;
    L7:
        return LocationInfoConst.ALLOW_USE_LOCATION.equals(r2.b());
    }

    private static String m0(d.b.r.k0.j r11, d.b.r.h0.c r12) {
        if ((r11 instanceof d.b.r.k0.a) == false) goto L22;
        if (r12 == null) goto L22;
        d.b.r.k0.a r0 = (d.b.r.k0.a) r11;
        if (TextUtils.isEmpty(r0.f()) == false) goto L9;
        long r2 = r11.length();
        long r7 = System.currentTimeMillis();
        if (r0.j() == true) goto L13;
    L17:
        d.b.r.k0.f.b r9 = r0.g(r12.w(), r12.A(), l0(r12));
        if (r9 != null) goto L20;
        long r4 = 0;
        d.b.r.k0.f.e r13 = d.b.r.k0.f.e.q;
    L15:
        h0(r2, r4, r13.a(), r7, r12, null);
        return null;
    L20:
        h0(r2, r11.length(), 0, r7, r12, r9);
        return r9.f14448b;
    L13:
        if (d.b.r.k0.f.h() == false) goto L17;
        r4 = 0;
        r13 = d.b.r.k0.f.e.o;
        goto L15
    L9:
        return r0.f();
    L22:
        return null;
    }

    @Override // d.b.h.a.a.h.m.b
    protected void H(d.b.r.k0.i r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.f13418f.N() == false) goto L6;
        return;
    L6:
        if ((r3 instanceof d.b.r.k0.g) == false) goto L14;
        d.b.h.a.a.h.r.b.n().t(Z(), ((d.b.r.k0.g) r3).k(), a.f4708a);     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    @Override // d.b.h.a.a.h.m.b
    protected void I(String r8, d.b.r.h0.c r9, d.b.h.a.a.h.b r10, Map<String, String> r11) {
        r10.f13356c = c0(r9);     // Catch: Exception -> L15
        if (n == true) goto L6;
    L12:
        boolean r1 = false;
    L13:
        r10.f13355b = r1;     // Catch: Exception -> L15
        Logger.debug();     // Catch: Exception -> L15
        HttpURLConnection r2 = a0(r8, r10);     // Catch: Exception -> L15
        Y(r9, r10, r2, r11);     // Catch: Exception -> L15
        i0(r2);     // Catch: Exception -> L15
        return;
    L6:
        if (o == false) goto L12;
        if (r10.f13356c > 0) goto L12;
        if (r10.G == true) goto L12;
        r1 = true;
    L15:
        e = move-exception;
        d.b.h.a.a.h.m.b.T(r8, r10, this, this, e);
        this.f13421i = true;
        if ((e instanceof d.b.r.l0.d) == false) goto L19;
        throw e;
    L19:
        d.b.r.l0.d r7 = new d.b.r.l0.d(e.getMessage(), e.getCause());
        r7.a(true, false, true, r8, r10.Z, r10);
        throw r7;
    }

    protected void V(HttpURLConnection r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f13421i == true) goto L17;
        r10.disconnect();
        this.f13421i = true;
        if (this.f13418f.N() == false) goto L16;
        c();
        d.b.h.a.a.h.b r11 = this.f13419g;
        r11.m = System.currentTimeMillis();
        d.b.h.a.a.h.b r12 = this.f13419g;
        r12.f13363j = d.b.h.a.a.h.a.b();
        T r13 = this.f13419g.f13358e;
        if (r13 != 0) goto L11;
    L12:
        d.b.h.a.a.h.g.A(this.f13418f.G(), this.f13419g);
    L13:
        k r1 = k.a();
        String r2 = this.f13418f.G();
        d.b.h.a.a.h.b r9 = this.f13419g;
        r1.c(r2, r9.x, r9.y, r9.W, r9.E);
        return;
    L11:
        if (r13.w == false) goto L13;
    L16:
        return;
    }

    protected void W(HttpURLConnection r9, Throwable r10, boolean r11) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (this.f13421i == true) goto L17;
        r9.disconnect();
        this.f13421i = true;
        c();
        d.b.h.a.a.h.b r12 = this.f13419g;
        r12.m = System.currentTimeMillis();
        d.b.h.a.a.h.b r13 = this.f13419g;
        r13.f13363j = d.b.h.a.a.h.a.b();
        d.b.h.a.a.h.b r14 = this.f13419g;
        T r0 = r14.f13358e;
        if (r0 != 0) goto L9;
    L10:
        d.b.h.a.a.h.g.E(this.f13418f, r14, r10, Boolean.valueOf(r11));
    L12:
        if (this.f13418f.N() == false) goto L16;
        k r1 = k.a();
        String r2 = this.f13418f.G();
        d.b.h.a.a.h.b r8 = this.f13419g;
        r1.c(r2, r8.x, r8.y, r8.W, r8.E);
        return;
    L16:
        return;
    L9:
        if (r0.w == false) goto L12;
    }

    protected void Y(d.b.r.h0.c r20, d.b.h.a.a.h.b r21, HttpURLConnection r22, Map<String, String> r23) {
        long r3 = SystemClock.uptimeMillis();
        r22.setRequestMethod(r20.y());
        r22.setDoInput(true);
        r22.setInstanceFollowRedirects(true);
        T r6 = r21.f13358e;
        if (r6 == 0) goto L5;
        r22.setInstanceFollowRedirects(r6.u);
    L5:
        String r7 = r20.A();
        T r8 = r21.f13358e;
        if (r8 != 0) goto L8;
        int r9 = 0;
    L9:
        int r10 = j.m(r7, r9);
        if (r10 <= 0) goto L15;
        Reflect.on(r22).call("setOutputStreamBufferSize", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r10)});     // Catch: Throwable -> L151
        if (r20.z() == null) goto L15;
        r20.z().x0 = r10;     // Catch: Throwable -> L151
    L15:
        if (r21.f13356c > 0) goto L181;
    L17:
        T r11 = r21.f13358e;
        if (r11 == 0) goto L69;
        long r14 = r11.f13368c;
        if (r14 <= 0) goto L22;
        r22.setConnectTimeout((int) r14);
    L22:
        long r15 = r11.f13369d;
        if (r15 <= 0) goto L26;
        r22.setReadTimeout((int) r15);
    L26:
        if (r11.f13374i > 0) goto L189;
    L41:
        String r16 = "setSocketReadTimeout";
    L42:
        int r12 = r11.n;
        int r13 = r11.s;
        if (r11.v == true) goto L45;
    L46:
        r13 = r13 | 16;
    L48:
        if (r11.z == false) goto L50;
        r13 = r13 | 128;
    L50:
        if (r13 > 0) goto L169;
    L55:
        long r17 = r3;
    L57:
        if (r11.y == false) goto L59;
        r12 = r12 | 2;
    L59:
        if (r12 > 0) goto L175;
    L61:
        d.b.h.a.a.h.c.a r4 = r11.A;
        if (r4 != null) goto L64;
    L70:
        T r2 = r21.f13358e;
        if (r2 != 0) goto L73;
    L74:
        d.b.h.a.a.h.p.e.a r5 = new d.b.h.a.a.h.p.e.a();
        int r18 = d.b.h.a.a.h.p.e.a(r22.getURL(), r5);
        r22.addRequestProperty("x-ttnet-bypass-to", Integer.toString(r18));
        if (r18 > 0) goto L171;
    L167:
        Reflect.on(r22).call("setRequestPriority", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r20.E())});     // Catch: Throwable -> L158
    L86:
        T r19 = r21.f13358e;
        if (r19 == 0) goto L91;
        long r24 = r19.t;
        long r25 = 0;
        if (r24 > 0) goto L94;
    L92:
        r24 = this.m;
    L94:
        if (r24 > r25) goto L185;
    L96:
        Iterator<d.b.r.h0.b> r26 = r20.v().iterator();
        String r27 = "";
    L98:
        if (r26.hasNext() == false) goto L114;
        d.b.r.h0.b r28 = r26.next();
        if (com.bytedance.common.utility.k.c(r28.a()) == true) goto L98;
        if (com.bytedance.common.utility.k.c(r28.b()) == true) goto L98;
        if (d.b.r.k0.f.h() == false) goto L110;
        if ("x-bd-content-encoding".equalsIgnoreCase(r28.a()) == true) goto L98;
    L110:
        if ("User-Agent".equalsIgnoreCase(r28.a()) == false) goto L112;
        r27 = r28.b();
    L112:
        r22.setRequestProperty(r28.a(), r28.b());
        goto L98
    L114:
        if (com.bytedance.common.utility.k.c(r27) == false) goto L165;
        r27 = d.b.h.a.a.h.g.r();
        if (com.bytedance.common.utility.k.c(r27) == true) goto L165;
        r27 = r27 + " cronet/" + j.o();     // Catch: Exception -> L160
    L119:
        r22.setRequestProperty("User-Agent", r27);
    L165:
        r21.F.put("ua", r27);     // Catch: Exception -> L161
    L121:
        d.b.r.k0.j r29 = r20.s();
        if (r29 == null) goto L136;
        r22.setDoOutput(true);
        r22.setRequestProperty(INetworkApi.CONTENT_TYPE, r29.a());
        String r30 = d0(r29);
        if (r30 == null) goto L126;
        r22.setRequestProperty("X-SS-STUB", r30);
    L126:
        String r31 = m0(r29, r20);
        if (TextUtils.isEmpty(r31) == true) goto L130;
        r22.setRequestProperty("x-bd-content-encoding", r31);
    L132:
        long r32 = r29.length();
        if (r32 == (-1)) goto L135;
        r22.setFixedLengthStreamingMode((int) r32);
        r22.setRequestProperty("Content-Length", String.valueOf(r32));
        goto L136
    L135:
        r22.setChunkedStreamingMode(4096);
        goto L136
    L130:
        if (d.b.r.k0.f.h() == false) goto L132;
        g0(r20);
    L136:
        if (r23 != null) goto L138;
    L147:
        r21.f13354a = r22.getURL();
        y r1 = r21.Y;
        if (r1 == null) goto L210;
        r1.D0 = SystemClock.uptimeMillis() - r17;
        r21.Y.f14614a = r21.f13354a;
        return;
    L210:
        return;
    L138:
        if (r23.isEmpty() == true) goto L147;
        Iterator<Map.Entry<String, String>> r33 = r23.entrySet().iterator();
    L141:
        if (r33.hasNext() == false) goto L147;
        Map.Entry<String, String> r34 = r33.next();
        String r35 = r34.getKey();
        String r36 = r34.getValue();
        if (TextUtils.isEmpty(r35) == true) goto L141;
        if (TextUtils.isEmpty(r36) == true) goto L141;
        r22.setRequestProperty(r35, r36);
        goto L141
    L185:
        Reflect.on(r22).call("setThrottleNetSpeed", new Class[]{Integer.TYPE}, new Object[]{Long.valueOf(r24)});     // Catch: Throwable -> L159
        goto L96
    L91:
        r25 = 0;
        goto L92
    L171:
        Reflect r37 = Reflect.on(r22);     // Catch: Throwable -> L157
        Class<?> r38 = Integer.TYPE;     // Catch: Throwable -> L157
        r37.call("setRequestTimeout", new Class[]{r38}, new Object[]{Integer.valueOf(r18 * 1000)});     // Catch: Throwable -> L157
        r22.setConnectTimeout(0);     // Catch: Throwable -> L157
        r22.setReadTimeout(0);     // Catch: Throwable -> L157
        if (r5.f13703a <= 0) goto L80;
        Reflect.on(r22).call("setSocketConnectTimeout", new Class[]{r38}, new Object[]{Integer.valueOf(r5.f13703a * 1000)});     // Catch: Throwable -> L157
    L80:
        if (r5.f13704b <= 0) goto L83;
        Reflect.on(r22).call(r16, new Class[]{r38}, new Object[]{Integer.valueOf(r5.f13704b * 1000)});     // Catch: Throwable -> L157
    L83:
        if (r5.f13705c <= 0) goto L167;
        Reflect.on(r22).call("setSocketWriteTimeout", new Class[]{r38}, new Object[]{Integer.valueOf(r5.f13705c * 1000)});     // Catch: Throwable -> L157
        goto L167
    L73:
        if (r2.f13374i > 0) goto L167;
    L64:
        if (r4.f13378a == null) goto L70;
        if (r4.f13379b == null) goto L70;
        Reflect.on(r22).call("setAuthCredentials", new Class[]{String.class, String.class}, new Object[]{r4.f13378a, r4.f13379b});     // Catch: Throwable -> L156
        goto L70
    L175:
        Reflect.on(r22).call("setRequestTypeFlags", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r12)});     // Catch: Throwable -> L155
        goto L61
    L169:
        r17 = r3;
        Reflect.on(r22).call("setRequestFlag", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r13)});     // Catch: Throwable -> L154
        goto L57
    L45:
        if ((r12 & 1) > 0) goto L48;
    L189:
        Reflect r110 = Reflect.on(r22);     // Catch: Throwable -> L164
        Class<?> r111 = Integer.TYPE;     // Catch: Throwable -> L164
        Class<?>[] r112 = {r111};     // Catch: Throwable -> L164
        Object[] r113 = new Object[1];     // Catch: Throwable -> L164
        r113[0] = Integer.valueOf((int) r11.f13374i);     // Catch: Throwable -> L163
        r110.call("setRequestTimeout", r112, r113);     // Catch: Throwable -> L163
        r22.setConnectTimeout(0);     // Catch: Throwable -> L163
        r22.setReadTimeout(0);     // Catch: Throwable -> L163
        if (r11.f13371f <= 0) goto L32;
    L37:
        Reflect.on(r22).call("setSocketConnectTimeout", new Class[]{r111}, new Object[]{Integer.valueOf((int) r11.f13371f)});     // Catch: Throwable -> L163
        r16 = "setSocketReadTimeout";
        Reflect.on(r22).call(r16, new Class[]{r111}, new Object[]{Integer.valueOf((int) r11.f13373h)});     // Catch: Throwable -> L153
        Reflect.on(r22).call("setSocketWriteTimeout", new Class[]{r111}, new Object[]{Integer.valueOf((int) r11.f13372g)});     // Catch: Throwable -> L153
        goto L42
    L32:
        if (r11.f13373h > 0) goto L37;
        if (r11.f13372g > 0) goto L37;
    L36:
        r16 = "setSocketReadTimeout";
        goto L42
    L69:
        r17 = r3;
        r16 = "setSocketReadTimeout";
        goto L70
    L181:
        Reflect.on(r22).call("setInputStreamBufferSize", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r21.f13356c)});     // Catch: Throwable -> L152
        goto L17
    L8:
        r9 = r8.r;
        goto L9
    }

    abstract HttpURLConnection Z();

    protected HttpURLConnection a0(String r5, d.b.h.a.a.h.b r6) {
        long r0 = SystemClock.uptimeMillis();
        HttpURLConnection r4 = j.E(r5, r6);
        y r7 = r6.Y;
        if (r7 == null) goto L5;
        r7.B0 = SystemClock.uptimeMillis() - r0;
    L5:
        return r4;
    }

    @Override // d.b.h.a.a.h.m.j
    public void b(d.b.h.a.a.h.b r11) {
        Map<String, Object> r10 = j.v(Z());
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L16;
        r11.f13357d = (String) e0(r10.get(ICronetClient.KEY_REMOTE_IP), String.class, "");
        r11.o = ((Long) e0(r10.get(ICronetClient.KEY_DNS_TIME), Long.class, -1L)).longValue();
        r11.p = ((Long) e0(r10.get(ICronetClient.KEY_CONNECT_TIME), Long.class, -1L)).longValue();
        r11.q = ((Long) e0(r10.get(ICronetClient.KEY_SSL_TIME), Long.class, -1L)).longValue();
        r11.r = ((Long) e0(r10.get(ICronetClient.KEY_SEND_TIME), Long.class, -1L)).longValue();
        r11.s = ((Long) e0(r10.get(ICronetClient.KEY_PUSH_TIME), Long.class, -1L)).longValue();
        r11.t = ((Long) e0(r10.get(ICronetClient.KEY_RECEIVE_TIME), Long.class, -1L)).longValue();
        Object r3 = r10.get(ICronetClient.KEY_SOCKET_REUSED);
        Boolean r7 = Boolean.FALSE;
        r11.u = ((Boolean) e0(r3, Boolean.class, r7)).booleanValue();
        r11.v = ((Long) e0(r10.get(ICronetClient.KEY_TTFB), Long.class, -1L)).longValue();
        r11.w = ((Long) e0(r10.get(ICronetClient.KEY_TOTAL_TIME), Long.class, -1L)).longValue();
        r11.x = ((Long) e0(r10.get(ICronetClient.KEY_SEND_BYTE_COUNT), Long.class, -1L)).longValue();
        r11.y = ((Long) e0(r10.get(ICronetClient.KEY_RECEIVED_BYTE_COUNT), Long.class, -1L)).longValue();
        r11.E = (String) e0(r10.get(ICronetClient.KEY_REQUEST_LOG), String.class, "");
        r11.z = ((Long) e0(r10.get(ICronetClient.KEY_RETRY_ATTEMPTS), Long.class, -1L)).longValue();
        r11.H = (String) e0(r10.get(ICronetClient.KEY_REQUEST_HEADERS), String.class, "");
        r11.I = (String) e0(r10.get(ICronetClient.KEY_RESPONSE_HEADERS), String.class, "");
        r11.K = ((Long) e0(r10.get(ICronetClient.KEY_POST_TASK_START), Long.class, -1L)).longValue();
        r11.f13353J = ((Long) e0(r10.get(ICronetClient.KEY_REQUEST_START), Long.class, -1L)).longValue();
        r11.L = ((Long) e0(r10.get(ICronetClient.KEY_WAIT_CONTEXT), Long.class, -1L)).longValue();
        r11.a0 = ((Boolean) e0(r10.get(ICronetClient.KEY_PRE_SAMPLING_REPORTABLE), Boolean.class, r7)).booleanValue();
        r11.b0 = ((Boolean) e0(r10.get(ICronetClient.KEY_BYPASS_API_REPORT), Boolean.class, r7)).booleanValue();
        y r0 = r11.Y;
        if (r0 == null) goto L11;
        r0.E0 = ((Long) e0(r10.get(ICronetClient.KEY_UPPER_ADD_COOKIE_US), Long.class, -1L)).longValue();
        y r1 = r11.Y;
        r1.F0 = ((Long) e0(r10.get(ICronetClient.KEY_UPPER_SAVE_COOKIE_US), Long.class, -1L)).longValue();
        y r2 = r11.Y;
        r2.G0 = ((Integer) e0(r10.get(ICronetClient.KEY_REQ_COOKIE_SOURCE_TYPE), Integer.class, -1)).intValue();
    L11:
        if (TextUtils.isEmpty(r11.E) == false) goto L15;
        U(r11.F);
        return;
    L15:
        return;
    }

    protected int b0(HttpURLConnection r2) {
        d.b.r.k0.j r1 = this.f13418f.s();
        if (r1 == null) goto L6;
        r1.b(r2.getOutputStream());
    L6:
        return r2.getResponseCode();
    }

    @Override // d.b.r.h0.e
    public boolean d(long r1) {
        this.m = r1;
        return true;
    }

    @Override // d.b.h.a.a.h.m.b
    protected boolean e() {
        if (this.f13420h == false) goto L5;
    L8:
        return true;
    L5:
        if (j.q() == true) goto L8;
        return false;
    }

    @Override // d.b.h.a.a.h.m.b
    protected void f(d.b.r.h0.c r2, Exception r3) {
        X(j.q(), r3.getMessage(), this.f13418f.A());
    }

    void i0(HttpURLConnection r1) {
    }

    @Override // d.b.h.a.a.h.m.h
    public InputStream k() {
        if (Z() != null) goto L7;
        return null;
    L7:
        return Z().getInputStream();
    }

    @Override // d.b.h.a.a.h.m.h
    public int l() {
        return this.f4710l;
    }

    @Override // d.b.h.a.a.h.m.h
    public String m(String r3) {
        if (Z() != null) goto L6;
        return null;
    L6:
        String r0 = Z().getHeaderField(r3);
        if (TextUtils.isEmpty(r0) == true) goto L9;
        return r0;
    L9:
        return Z().getHeaderField(r3.toLowerCase());
    }

    @Override // d.b.h.a.a.h.m.h
    public InputStream n() {
        if (Z() != null) goto L7;
        return null;
    L7:
        return Z().getErrorStream();
    }

    @Override // d.b.h.a.a.h.m.h
    public String o() {
        return m(INetworkApi.CONTENT_TYPE);
    }

    @Override // d.b.h.a.a.h.m.h
    public boolean p() {
        return false;
    }

    @Override // d.b.h.a.a.h.m.h
    public long q() {
        if (Z() != null) goto L7;
        return 0;
    L7:
        return Z().getContentLength();
    }

    @Override // d.b.h.a.a.h.m.h
    public String r() {
        if (Z() != null) goto L7;
        return "";
    L7:
        return Z().getResponseMessage();
    }

    @Override // d.b.h.a.a.h.m.h
    public boolean s() {
        return false;
    }

    @Override // d.b.h.a.a.h.m.h
    public void t() {
        if (Z() == null) goto L6;
        Z().disconnect();
        return;
    }

    @Override // d.b.h.a.a.h.m.h
    public Map<String, List<String>> u() {
        if (Z() != null) goto L7;
        return null;
    L7:
        return Z().getHeaderFields();
    }

    @Override // d.b.h.a.a.h.m.b
    protected void v() {
        this.f4710l = b0(Z());
    }

    @Override // d.b.h.a.a.h.m.b
    protected Context x() {
        return j.j();
    }
}

package com.bytedance.android.sdk.bdticketguard;

import android.util.Base64;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h1 f780a = null;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.p<String, String, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.d0 f781f;

        a(kotlin.n0.d.d0 r1) {
            this.f781f = r1;
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(String r3, String r4) {
            kotlin.n0.d.o.g(r3, "key");
            kotlin.n0.d.o.g(r4, "value");
            s0.f1065a.e("TicketGuardNetworkHelper", "attestation logid: " + r4);
            this.f781f.f18431f = r4;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(String r1, String r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<String, String, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.d0 f782f;

        b(kotlin.n0.d.d0 r1) {
            this.f782f = r1;
            super(2);
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [T, java.lang.Integer] */
        public final void a(String r2, String r3) {
            kotlin.n0.d.o.g(r2, "key");
            kotlin.n0.d.o.g(r3, "value");
            kotlin.n0.d.d0 r1 = this.f782f;
            r1.f18431f = Integer.valueOf(Integer.parseInt(r3));
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(String r1, String r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    static final class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f783f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f784g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f785h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ p f786i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ w f787j;

        c(String r1, boolean r2, String r3, p r4, w r5) {
            this.f783f = r1;
            this.f784g = r2;
            this.f785h = r3;
            this.f786i = r4;
            this.f787j = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h1.f780a.d(this.f783f, this.f784g, this.f785h, this.f786i, this.f787j);
        }
    }

    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.s<Long, String, String, String, String, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f788f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f789g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f790h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ p f791i;

        d(String r1, boolean r2, boolean r3, p r4) {
            this.f788f = r1;
            this.f789g = r2;
            this.f790h = r3;
            this.f791i = r4;
            super(5);
        }

        public final void a(long r16, String r18, String r19, String r20, String r21) {
            kotlin.n0.d.o.g(r18, "logid");
            String r8 = this.f788f;
            boolean r10 = this.f789g;
            boolean r11 = this.f790h;
            boolean r3 = false;
            if (r19 != null) goto L5;
        L8:
            boolean r5 = true;
        L9:
            boolean r12 = !r5;
            if (r20 != null) goto L12;
        L15:
            boolean r6 = true;
        L16:
            boolean r13 = !r6;
            if (r21 != null) goto L19;
        L20:
            r3 = true;
        L21:
            z0.O(true, null, r16, r8, r18, r10, r11, r12, r13, !r3);
            this.f791i.a(r19, r20);
            return;
        L19:
            if (r21.length() != 0) goto L21;
        L12:
            if (r20.length() == 0) goto L15;
            r6 = false;
            goto L16
        L5:
            if (r19.length() == 0) goto L8;
            r5 = false;
            goto L9
        }
    }

    static final class e extends kotlin.n0.d.q implements kotlin.n0.c.l<String, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f792f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f793g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f794h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ p f795i;

        e(String r1, boolean r2, boolean r3, p r4) {
            this.f792f = r1;
            this.f793g = r2;
            this.f794h = r3;
            this.f795i = r4;
            super(1);
        }

        public final void a(String r12) {
            z0.O(false, r12, 0, this.f792f, null, this.f793g, this.f794h, false, false, false);
            this.f795i.a(null, null);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(String r1) {
            a(r1);
            return kotlin.f0.f18324a;
        }
    }

    static {
        f780a = new h1();
    }

    private h1() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final g a(i r14, f r15, String r16) {
        kotlin.n0.d.o.g(r14, "snapshot");
        kotlin.n0.d.o.g(r15, "request");
        kotlin.n0.d.o.g(r16, "attestationAdapterName");
        String r0 = r15.e();
        String r3 = r15.d();
        String r5 = r15.c();
        String r6 = r15.b();
        f1 r7 = d1.f706b.a();
        Integer r8 = null;
        if (r7 == null) goto L5;
        c1 r9 = r7.G();
    L6:
        if (r9 == null) goto L57;
        w r10 = r9.d();
        if (r10 == null) goto L57;
        s0.f1065a.e("TicketGuardNetworkHelper", "doAttestationRequest, network impl: " + r10.getClass().getName() + ", initParam: " + r9.getClass().getName());
        i0 r1 = r15.a();
        HashMap r11 = new HashMap();
        r11.put("bd-ticket-guard-attest-certs", r6);
        if (r1 != null) goto L12;
    L17:
        HashMap r12 = new HashMap();
        r12.put("bd-ticket-guard-ree-public-key", r3);
        r12.put("bd-ticket-guard-client-cert", r5);
        ArrayList r13 = new ArrayList(r12.size());
        Iterator r17 = r12.entrySet().iterator();
    L19:
        if (r17.hasNext() == false) goto L21;
        Map.Entry r18 = (Map.Entry) r17.next();
        r13.add(new t0((String) r18.getKey(), (String) r18.getValue()));
        goto L19
    L21:
        List<t0> r19 = kotlin.i0.r.B0(r13);
        if (r1 == null) goto L58;
        if ((!r1.b().isEmpty()) == false) goto L58;
        r19.addAll(r1.b());
    L58:
        u0 r2 = r10.a(Integer.MAX_VALUE, "https://security.snssdk.com/passport/ticket_guard/verify_pub_key/", r11, r19);     // Catch: Exception -> L53
        if (r2 != null) goto L30;
    L48:
        StringBuilder r4 = new StringBuilder();
        r4.append("request failed. code: ");
        if (r2 == null) goto L51;
        r8 = Integer.valueOf(r2.c());
    L51:
        r4.append(r8);
        throw new com.bytedance.android.sdk.bdticketguard.c(r14, -1203, r4.toString(), null, 8, null);
    L30:
        if (r2.d() != true) goto L48;
        kotlin.n0.d.d0 r20 = new kotlin.n0.d.d0();
        r20.f18431f = "";
        kotlin.n0.d.d0 r21 = new kotlin.n0.d.d0();
        r21.f18431f = null;
        t r22 = new t(new kotlin.u[]{kotlin.a0.a("X-Tt-Logid", new a(r20)), kotlin.a0.a("bd-ticket-guard-verify-public-key-result", new b(r21))});
        List<t0> r23 = r2.b();
        if (r23 == null) goto L38;
        Iterator<T> r24 = r23.iterator();
    L36:
        if (r24.hasNext() == false) goto L38;
        t0 r25 = (t0) r24.next();
        kotlin.n0.d.o.b(r25, "it");
        String r26 = r25.a();
        kotlin.n0.d.o.b(r26, "it.name");
        String r27 = r25.b();
        kotlin.n0.d.o.b(r27, "it.value");
        r22.c(r26, r27);
    L38:
        Integer r28 = (Integer) r21.f18431f;
        if (r28 == null) goto L47;
        int r29 = r28.intValue();
        if (r29 != 0) goto L45;
        return new g(r0, r3, r16, (String) r20.f18431f, null, 16, null);
    L45:
        throw new com.bytedance.android.sdk.bdticketguard.e(r14, r29, (String) r20.f18431f);
    L47:
        throw new com.bytedance.android.sdk.bdticketguard.c(r14, -1204, "no attest result", null, 8, null);
    L53:
        e = move-exception;
        throw new com.bytedance.android.sdk.bdticketguard.c(r14, -1202, "network exception", e);
    L12:
        if ((!r1.a().isEmpty()) == false) goto L17;
        Iterator<Map.Entry<String, String>> r110 = r1.a().entrySet().iterator();
    L15:
        if (r110.hasNext() == false) goto L17;
        Map.Entry<String, String> r111 = r110.next();
        r11.put(r111.getKey(), r111.getValue());
    L57:
        throw new com.bytedance.android.sdk.bdticketguard.c(r14, -1201, "no network implementation", null, 8, null);
    L5:
        r9 = null;
        goto L6
    }

    public static final void b(String r10, boolean r11, p r12, String r13) {
        kotlin.n0.d.o.g(r12, "callback");
        kotlin.n0.d.o.g(r13, "scene");
        if (r10 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        boolean r1 = !r11;
        if (r0 == false) goto L14;
        if (r1 == false) goto L14;
        s0.f1065a.a("TicketGuardNetworkHelper", "getCert, no need for any cert. callback");
        r12.a(null, null);
        return;
    L14:
        f1 r2 = d1.f706b.a();
        if (r2 == null) goto L19;
        c1 r3 = r2.G();
        if (r3 == null) goto L19;
        w r9 = r3.d();
    L20:
        if (r9 != null) goto L23;
        s0.f1065a.a("TicketGuardNetworkHelper", "get cert fail, for no network implementation");
        r12.a(null, null);
        return;
    L23:
        new Thread(new c(r10, r11, r13, r12, r9)).start();
        return;
    L19:
        r9 = null;
        goto L20
    L5:
        if (r10.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    private final Map<String, String> c(u0 r4) {
        HashMap r3 = new HashMap();
        if (r4.b() == null) goto L10;
        List<t0> r0 = r4.b();
        kotlin.n0.d.o.b(r0, "resp.headers");
        if ((!r0.isEmpty()) == false) goto L10;
        Iterator<t0> r5 = r4.b().iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        t0 r1 = r5.next();
        kotlin.n0.d.o.b(r1, "header");
        String r2 = r1.a();
        kotlin.n0.d.o.b(r2, "header.name");
        String r6 = r1.b();
        kotlin.n0.d.o.b(r6, "header.value");
        r3.put(r2, r6);
    L10:
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    public final void d(String r19, boolean r20, String r21, p r22, w r23) {
        kotlin.n0.d.o.g(r21, "scene");
        kotlin.n0.d.o.g(r22, "callback");
        kotlin.n0.d.o.g(r23, "network");
        if (r19 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        boolean r7 = !r20;
        HashMap r8 = new HashMap();
        if (r19 != null) goto L12;
    L15:
        Object[] r9 = true;
    L16:
        if (r9 == true) goto L22;
        Charset r10 = kotlin.u0.d.f21429a;
        if (r19 == null) goto L21;
        byte[] r0 = r19.getBytes(r10);
        kotlin.n0.d.o.b(r0, "(this as java.lang.String).getBytes(charset)");
        r8.put("csr", Base64.encodeToString(r0, 2));
        goto L22
    L21:
        throw new kotlin.b0("null cannot be cast to non-null type java.lang.String");
    L22:
        if (r20 == false) goto L24;
        r8.put("server_data", LocationInfoConst.ALLOW_USE_LOCATION);
    L24:
        t0 r11 = new t0("x-tt-request-tag", "t=" + (!kotlin.n0.d.o.a(r21, "init") ? 1 : 0) + ";n=1");
        d r12 = new d(r21, r6, r7, r22);
        e r13 = new e(r21, r6, r7, r22);
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L44
        u0 r2 = r23.a(Integer.MAX_VALUE, "https://security.snssdk.com/passport/ticket_guard/get_client_cert/", r8, kotlin.i0.r.e(new t0[]{r11}));     // Catch: Exception -> L44
        long r14 = System.currentTimeMillis() - r1;     // Catch: Exception -> L44
        if (r2 != null) goto L28;
    L42:
        r13.a("resp or resp.body is null");     // Catch: Exception -> L44
        return;
    L28:
        if (r2.a() == null) goto L42;
        String r3 = c(r2).get("x-tt-logid");     // Catch: Exception -> L44
        if (r3 != null) goto L34;
        r3 = "";
    L34:
        String r15 = r3;
        String r4 = r2.a();     // Catch: Exception -> L44
        if (r4 != null) goto L38;
        r4 = "{}";
    L38:
        JSONObject r5 = new JSONObject(r4).optJSONObject("data");     // Catch: Exception -> L44
        if (r5 == null) goto L41;
        r12.a(r14, r15, r5.optString("cert"), r5.optString("server_cert"), r5.optString("server_sn"));     // Catch: Exception -> L44
        return;
    L41:
        r13.a(null);     // Catch: Exception -> L44
        return;
    L44:
        e = move-exception;
        s0.f1065a.c("TicketGuardNetworkHelper", "get cert exception", e);
        r13.a(Log.getStackTraceString(e));
        return;
    L12:
        if (r19.length() == 0) goto L15;
        r9 = false;
        goto L16
    L5:
        if (r19.length() == 0) goto L8;
        r6 = false;
        goto L9
    }
}

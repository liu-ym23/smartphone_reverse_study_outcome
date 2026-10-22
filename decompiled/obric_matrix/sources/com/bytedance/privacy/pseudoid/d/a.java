package com.bytedance.privacy.pseudoid.d;

import androidx.core.app.NotificationCompat;
import com.bytedance.privacy.pseudoid.PseudoManager;
import com.obric.matrix.common_api.INetworkApi;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import p000j.a0;
import p000j.d0;
import p000j.e0;
import p000j.f0;
import p000j.v;
import p000j.y;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5468a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f5469b = "https://ocean-secret-boe.bytedance.net/api/identity/pseudonymize";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f5470c = "https://ocean-secret.oceancloudapi.com/api/identity/pseudonymize";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final a0 f5471d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile a f5472e;

    static {
        f5471d = new a0();
    }

    public a() {
    }

    private c a(String r6) {
        int r0 = g(r6);
        String r1 = h(r6);
        d r3 = null;
        if (r0 < 200) goto L11;
        if (r0 >= 300) goto L11;
        r3 = e(r6);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.privacy.f.b.b(f5468a, "buildNetworkResponse exception: " + e.getMessage());
    L11:
        return new c(r0, r1, r3);
    }

    private d0 b(b r8) {
        e0 r0 = e0.c(y.d("application/json"), "{}");
        Map<String, String> r1 = com.bytedance.privacy.pseudoid.c.a.f5466a.d();
        Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry<String, String> r3 = r2.next();
        com.bytedance.privacy.f.b.a(f5468a, "xttTokenMap entry key:" + r3.getKey() + " value:" + r3.getValue());
        goto L4
    L6:
        v r4 = v.i(r1);
        d0.a r5 = new d0.a();
        r5.k(r8.c());
        r5.f(r8.b(), r0);
        r5.e(r4);
        r5.a(INetworkApi.CONTENT_TYPE, "application/json");
        r5.a("x-att-certchain", r8.a());
        return r5.b();
    }

    public static a d() {
        if (f5472e != null) goto L15;
        monitor-enter(PseudoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5472e != null) goto L9;
        f5472e = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PseudoManager.class);     // Catch: Throwable -> L11
    L15:
        return f5472e;
    }

    private d e(String r3) {
        JSONObject r0 = new JSONObject(new JSONObject(r3).getString("data"));     // Catch: Exception -> L5
        return new d(r0.optString("rpdid", ""), r0.optString("rpuid", ""));
    L5:
        e = move-exception;
        com.bytedance.privacy.f.b.b(f5468a, "getPseudoID exception: " + e.getMessage());
        return null;
    }

    public static String f() {
        if (com.bytedance.privacy.e.b.a().c() == false) goto L7;
        return f5469b;
    L7:
        return f5470c;
    }

    private int g(String r3) {
        return new JSONObject(r3).getInt("code");
    L4:
        e = move-exception;
        com.bytedance.privacy.f.b.b(f5468a, "getResponseCode exception: " + e.getMessage());
        return 400;
    }

    private String h(String r3) {
        return new JSONObject(r3).getString(NotificationCompat.CATEGORY_MESSAGE);
    L4:
        e = move-exception;
        com.bytedance.privacy.f.b.b(f5468a, "getResponseMsg exception: " + e.getMessage());
        return "";
    }

    public c c(b r13) {
        String r1 = f5468a;
        com.bytedance.privacy.f.b.a(r1, "executeRequest enter");
        d0 r14 = b(r13);
        com.bytedance.privacy.f.b.a(r1, "PseudoID Request:" + r14.toString());
        com.bytedance.privacy.f.b.a(r1, "PseudoID Request body:" + r14.a());
        c r2 = new c(400, "", null);
        int r3 = 1;
    L4:
        if (r3 > 3) goto L50;
        f0 r6 = f5471d.w(r14).execute();     // Catch: Exception -> L37 IOException -> L39 ConnectException -> L41 SocketTimeoutException -> L43
    L30:
        th = move-exception;
        if (r6 != null) goto L56;
    L36:
        throw th;     // Catch: Exception -> L37 IOException -> L39 ConnectException -> L41 SocketTimeoutException -> L43
    L56:
        r6.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L37 IOException -> L39 ConnectException -> L41 SocketTimeoutException -> L43
        goto L36
    L7:
        if (r6.a() == null) goto L9;
        String r7 = r6.a().C();     // Catch: Throwable -> L30
    L12:
        if (r6.M() == true) goto L13;
        String r8 = f5468a;     // Catch: Throwable -> L30
        com.bytedance.privacy.f.b.b(r8, "PseudoID Attempt " + r3 + ": Response failed, code = " + r6.s());     // Catch: Throwable -> L30
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L30
        r10.append("PseudoID Response body:");     // Catch: Throwable -> L30
        r10.append(r7);     // Catch: Throwable -> L30
        com.bytedance.privacy.f.b.b(r8, r10.toString());     // Catch: Throwable -> L30
        c r9 = new c(r6.s(), r6.N(), null);     // Catch: Throwable -> L30
        if (r6 != null) goto L58;
    L29:
        r2 = r9;
    L46:
        if (r3 >= 3) goto L49;
        Thread.sleep(500);     // Catch: InterruptedException -> L51
    L49:
        r3 = r3 + 1;
        goto L4
    L58:
        r6.close();     // Catch: Exception -> L21 IOException -> L23 ConnectException -> L25 SocketTimeoutException -> L27
    L25:
        e = e;
        r2 = r9;
    L42:
        String r11 = f5468a;
        StringBuilder r12 = new StringBuilder();
        r12.append("Challenge Attempt ");
        r12.append(r3);
        r12.append(": ConnectException (connect timeout): ");
        String r15 = e.getMessage();
    L45:
        r12.append(r15);
        com.bytedance.privacy.f.b.b(r11, r12.toString());
    L27:
        e = e;
        r2 = r9;
    L44:
        r11 = f5468a;
        r12 = new StringBuilder();
        r12.append("Challenge Attempt ");
        r12.append(r3);
        r12.append(": SocketTimeoutException (read/write timeout): ");
        r15 = e.getMessage();
    L23:
        e = e;
        r2 = r9;
    L40:
        r11 = f5468a;
        r12 = new StringBuilder();
        r12.append("Challenge Attempt ");
        r12.append(r3);
        r12.append(": IOException: ");
        r15 = e.getMessage();
    L21:
        e = e;
        r2 = r9;
    L38:
        r11 = f5468a;
        r12 = new StringBuilder();
        r12.append("Challenge Attempt ");
        r12.append(r3);
        r12.append(": Unexpected exception: ");
        r15 = e.getMessage();
        goto L45
    L13:
        String r16 = f5468a;     // Catch: Throwable -> L30
        com.bytedance.privacy.f.b.a(r16, "PseudoID Response received successfully");     // Catch: Throwable -> L30
        com.bytedance.privacy.f.b.a(r16, "PseudoID Response body:" + r7);     // Catch: Throwable -> L30
        r2 = a(r7);     // Catch: Throwable -> L30
        if (r6 == null) goto L50;
        r6.close();     // Catch: Exception -> L37 IOException -> L39 ConnectException -> L41 SocketTimeoutException -> L43
        goto L50
    L9:
        r7 = "";
    L41:
        e = e;
    L43:
        e = e;
    L39:
        e = e;
    L37:
        e = e;
    L50:
        return r2;
    }
}

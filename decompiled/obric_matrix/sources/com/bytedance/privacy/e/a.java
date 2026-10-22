package com.bytedance.privacy.e;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import org.json.JSONObject;
import p000j.a0;
import p000j.d0;
import p000j.f0;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5364a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a0 f5365b = null;

    static {
        f5365b = new a0();
    }

    private static String a(String r3) {
        return new JSONObject(new JSONObject(r3).getString("data")).getString("nonce");
    L4:
        e = move-exception;
        com.bytedance.privacy.f.b.b(f5364a, "getChallenge exception: " + e.getMessage());
        return "";
    }

    private static String b() {
        d0.a r1 = new d0.a();
        r1.k(c());
        r1.c();
        d0 r2 = r1.b();
        String r3 = f5364a;
        com.bytedance.privacy.f.b.a(r3, "Challenge Request:" + r2.toString());
        com.bytedance.privacy.f.b.a(r3, "Challenge Request body:" + r2.a());
        int r4 = 1;
        String r5 = "";
    L4:
        if (r4 > 3) goto L41;
        f0 r6 = f5365b.w(r2).execute();     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L21:
        th = move-exception;
        if (r6 != null) goto L43;
    L27:
        throw th;     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L43:
        r6.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
        goto L27
    L7:
        if (r6.a() == null) goto L9;
        String r7 = r6.a().C();     // Catch: Throwable -> L21
    L12:
        if (r6.M() == true) goto L13;
        String r8 = f5364a;     // Catch: Throwable -> L21
        com.bytedance.privacy.f.b.b(r8, "Challenge Attempt " + r4 + ": Response failed, code = " + r6.s());     // Catch: Throwable -> L21
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L21
        r10.append("Challenge Response body:");     // Catch: Throwable -> L21
        r10.append(r7);     // Catch: Throwable -> L21
        com.bytedance.privacy.f.b.b(r8, r10.toString());     // Catch: Throwable -> L21
        if (r6 == null) goto L37;
        r6.close();     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L37:
        if (r4 >= 3) goto L40;
        Thread.sleep(500);     // Catch: InterruptedException -> L42
    L40:
        r4 = r4 + 1;
        goto L4
    L13:
        String r9 = f5364a;     // Catch: Throwable -> L21
        com.bytedance.privacy.f.b.a(r9, "Challenge Response received successfully");     // Catch: Throwable -> L21
        com.bytedance.privacy.f.b.a(r9, "Challenge Response body:" + r7);     // Catch: Throwable -> L21
        r5 = e(r7);     // Catch: Throwable -> L21
        if (r6 == null) goto L41;
        r6.close();     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
        goto L41
    L9:
        r7 = "";
    L32:
        e = move-exception;
        String r11 = f5364a;
        StringBuilder r12 = new StringBuilder();
        r12.append("Challenge Attempt ");
        r12.append(r4);
        r12.append(": ConnectException (connect timeout): ");
        String r13 = e.getMessage();
    L36:
        r12.append(r13);
        com.bytedance.privacy.f.b.b(r11, r12.toString());
    L34:
        e = move-exception;
        r11 = f5364a;
        r12 = new StringBuilder();
        r12.append("Challenge Attempt ");
        r12.append(r4);
        r12.append(": SocketTimeoutException (read/write timeout): ");
        r13 = e.getMessage();
    L30:
        e = move-exception;
        r11 = f5364a;
        r12 = new StringBuilder();
        r12.append("Challenge Attempt ");
        r12.append(r4);
        r12.append(": IOException: ");
        r13 = e.getMessage();
    L28:
        e = move-exception;
        com.bytedance.privacy.f.b.c(f5364a, "Challenge Attempt " + r4 + ": Unexpected exception: ", e);
        e.printStackTrace();
    L41:
        return r5;
    }

    private static String c() {
        if (b.a().c() == false) goto L6;
        return "https://ocean-secret-boe.bytedance.net/api/auth/challenge";
    L6:
        return "https://ocean-secret.oceancloudapi.com/api/auth/challenge";
    }

    private static int d(String r3) {
        return new JSONObject(r3).getInt("code");
    L4:
        e = move-exception;
        com.bytedance.privacy.f.b.b(f5364a, "getResponseCode exception: " + e.getMessage());
        return 400;
    }

    private static String e(String r4) {
        int r0 = d(r4);
        if (r0 >= 200) goto L5;
        return "";
    L5:
        if (r0 >= 300) goto L14;
        return a(r4);
    L8:
        e = move-exception;
        com.bytedance.privacy.f.b.b(f5364a, "parseChallenge exception: " + e.getMessage());
        return "";
    L14:
        return "";
    }

    public static String f() {
        return b();
    }
}

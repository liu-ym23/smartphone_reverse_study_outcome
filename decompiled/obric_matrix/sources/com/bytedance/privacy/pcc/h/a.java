package com.bytedance.privacy.pcc.h;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.privacy.e.b;
import com.bytedance.privacy.pcc.h.b.c;
import com.bytedance.privacy.pcc.h.b.e;
import com.obric.matrix.common_api.INetworkApi;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import p000j.a0;
import p000j.d0;
import p000j.e0;
import p000j.f0;
import p000j.y;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5424a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a0 f5425b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f5426c;

    static {
        f5425b = new a0();
    }

    private a() {
    }

    private static d0.a a(d0.a r2) {
        if (b.a().c() == true) goto L5;
        r2.a("x-use-ppe", LocationInfoConst.ALLOW_USE_LOCATION);
        r2.a("x-tt-env", "ppe_prod");
    L5:
        return r2;
    }

    private static String b() {
        if (b.a().c() == false) goto L5;
        return "https://opcc-gateway-boe.bytedance.net";
    L5:
        return "https://opcc-gateway.obriccloud.com";
    }

    public static a d() {
        if (f5426c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5426c != null) goto L9;
        f5426c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f5426c;
    }

    public c c(String r7, String r8, String r9) {
        String r0 = b() + "/opcc/v1/auth/create/channel";
        e0 r1 = e0.c(y.d(INetworkApi.DEFAULT_CONTENT_TYPE), r9);
        d0.a r2 = new d0.a();
        r2.k(r0);
        r2.g(r1);
        r2.a(INetworkApi.CONTENT_TYPE, "application/json");
        r2.a("x-requestId", r7);
        r2.a("x-timestamp", r8);
        a(r2);
        d0 r10 = r2.b();
        String r11 = f5424a;
        com.bytedance.privacy.f.b.a(r11, "PCC CreateChannel request: " + r0);
        com.bytedance.privacy.f.b.a(r11, "PCC CreateChannel request body: " + r9);
        int r12 = 1;
    L4:
        if (r12 > 3) goto L41;
        f0 r3 = f5425b.w(r10).execute();     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L21:
        th = move-exception;
        if (r3 != null) goto L44;
    L27:
        throw th;     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L44:
        r3.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
        goto L27
    L8:
        if (r3.a() == null) goto L10;
        String r4 = r3.a().C();     // Catch: Throwable -> L21
    L11:
        String r5 = r3.C("x-responseId", "");     // Catch: Throwable -> L21
        if (r3.M() == true) goto L13;
        com.bytedance.privacy.f.b.b(f5424a, "PCC CreateChannel attempt " + r12 + ": HTTP " + r3.s() + " body=" + r4);     // Catch: Throwable -> L21
        if (r3 == null) goto L37;
        r3.close();     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L37:
        if (r12 >= 3) goto L40;
        Thread.sleep(500);     // Catch: InterruptedException -> L43
    L40:
        r12 = r12 + 1;
        goto L4
    L13:
        com.bytedance.privacy.f.b.a(f5424a, "PCC CreateChannel response: " + r4);     // Catch: Throwable -> L21
        c r6 = c.j(r4, r5);     // Catch: Throwable -> L21
        if (r3 == null) goto L16;
        r3.close();     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L16:
        return r6;
    L10:
        r4 = "";
    L32:
        e = move-exception;
        String r13 = f5424a;
        StringBuilder r14 = new StringBuilder();
        r14.append("PCC CreateChannel attempt ");
        r14.append(r12);
        r14.append(": ConnectException: ");
        String r15 = e.getMessage();
    L36:
        r14.append(r15);
        com.bytedance.privacy.f.b.b(r13, r14.toString());
    L34:
        e = move-exception;
        r13 = f5424a;
        r14 = new StringBuilder();
        r14.append("PCC CreateChannel attempt ");
        r14.append(r12);
        r14.append(": SocketTimeoutException: ");
        r15 = e.getMessage();
    L30:
        e = move-exception;
        r13 = f5424a;
        r14 = new StringBuilder();
        r14.append("PCC CreateChannel attempt ");
        r14.append(r12);
        r14.append(": IOException: ");
        r15 = e.getMessage();
    L28:
        e = move-exception;
        com.bytedance.privacy.f.b.c(f5424a, "PCC CreateChannel attempt " + r12 + ": unexpected exception: ", e);
        goto L37
    L41:
        return null;
    }

    public String e(String r8) {
        String r0 = b() + "/opcc/v1/auth/get/challenge";
        d0.a r1 = new d0.a();
        r1.k(r0);
        r1.c();
        r1.a("x-requestId", r8);
        r1.a("x-timestamp", String.valueOf(System.currentTimeMillis()));
        a(r1);
        d0 r9 = r1.b();
        com.bytedance.privacy.f.b.a(f5424a, "PCC GetChallenge request: " + r0);
        int r2 = 1;
    L3:
        String r3 = "";
        if (r2 > 3) goto L45;
        f0 r4 = f5425b.w(r9).execute();     // Catch: Exception -> L32 IOException -> L34 ConnectException -> L36 SocketTimeoutException -> L38
        if (r4.a() == null) goto L10;
        r3 = r4.a().C();     // Catch: Throwable -> L25
    L10:
        if (r4.M() == false) goto L20;
        String r5 = f5424a;     // Catch: Throwable -> L25
        com.bytedance.privacy.f.b.a(r5, "PCC GetChallenge response: " + r3);     // Catch: Throwable -> L25
        String r6 = com.bytedance.privacy.pcc.h.b.a.b(r3).a();     // Catch: Throwable -> L25
        if (r6 != null) goto L14;
    L18:
        String r7 = "PCC GetChallenge attempt " + r2 + ": nonce empty in response";     // Catch: Throwable -> L25
    L19:
        com.bytedance.privacy.f.b.b(r5, r7);     // Catch: Throwable -> L25
        if (r4 == null) goto L41;
        r4.close();     // Catch: Exception -> L32 IOException -> L34 ConnectException -> L36 SocketTimeoutException -> L38
    L41:
        if (r2 >= 3) goto L44;
        Thread.sleep(500);     // Catch: InterruptedException -> L46
    L44:
        r2 = r2 + 1;
        goto L3
    L14:
        if (r6.isEmpty() == true) goto L18;
        if (r4 == null) goto L17;
        r4.close();     // Catch: Exception -> L32 IOException -> L34 ConnectException -> L36 SocketTimeoutException -> L38
    L17:
        return r6;
    L20:
        r5 = f5424a;     // Catch: Throwable -> L25
        r7 = "PCC GetChallenge attempt " + r2 + ": HTTP " + r4.s() + " body=" + r3;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        if (r4 != null) goto L51;
    L31:
        throw th;     // Catch: Exception -> L32 IOException -> L34 ConnectException -> L36 SocketTimeoutException -> L38
    L51:
        r4.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L32 IOException -> L34 ConnectException -> L36 SocketTimeoutException -> L38
    L36:
        e = move-exception;
        String r10 = f5424a;
        StringBuilder r11 = new StringBuilder();
        r11.append("PCC GetChallenge attempt ");
        r11.append(r2);
        r11.append(": ConnectException: ");
        String r12 = e.getMessage();
    L40:
        r11.append(r12);
        com.bytedance.privacy.f.b.b(r10, r11.toString());
    L38:
        e = move-exception;
        r10 = f5424a;
        r11 = new StringBuilder();
        r11.append("PCC GetChallenge attempt ");
        r11.append(r2);
        r11.append(": SocketTimeoutException: ");
        r12 = e.getMessage();
    L34:
        e = move-exception;
        r10 = f5424a;
        r11 = new StringBuilder();
        r11.append("PCC GetChallenge attempt ");
        r11.append(r2);
        r11.append(": IOException: ");
        r12 = e.getMessage();
    L32:
        e = move-exception;
        com.bytedance.privacy.f.b.c(f5424a, "PCC GetChallenge attempt " + r2 + ": unexpected exception: ", e);
        goto L41
    L45:
        return "";
    }

    public String f(String r6, String r7, String r8) {
        String r0 = b() + "/opcc/v1/auth/upload/channelRet";
        e0 r1 = e0.c(y.d(INetworkApi.DEFAULT_CONTENT_TYPE), r8);
        d0.a r2 = new d0.a();
        r2.k(r0);
        r2.g(r1);
        r2.a(INetworkApi.CONTENT_TYPE, "application/json");
        r2.a("x-requestId", r6);
        r2.a("x-timestamp", r7);
        a(r2);
        d0 r9 = r2.b();
        String r10 = f5424a;
        com.bytedance.privacy.f.b.a(r10, "PCC UploadChannelRet request: " + r0);
        com.bytedance.privacy.f.b.a(r10, "PCC UploadChannelRet body: " + r8);
        int r11 = 1;
    L3:
        String r12 = "";
        if (r11 > 3) goto L39;
        f0 r3 = f5425b.w(r9).execute();     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L19:
        th = move-exception;
        if (r3 != null) goto L45;
    L25:
        throw th;     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L45:
        r3.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
        goto L25
    L7:
        if (r3.a() == null) goto L10;
        r12 = r3.a().C();     // Catch: Throwable -> L19
    L10:
        if (r3.M() == true) goto L11;
        com.bytedance.privacy.f.b.b(f5424a, "PCC UploadChannelRet attempt " + r11 + ": HTTP " + r3.s() + " body=" + r12);     // Catch: Throwable -> L19
        if (r3 == null) goto L35;
        r3.close();     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L35:
        if (r11 >= 3) goto L38;
        Thread.sleep(500);     // Catch: InterruptedException -> L40
    L38:
        r11 = r11 + 1;
        goto L3
    L11:
        com.bytedance.privacy.f.b.a(f5424a, "PCC UploadChannelRet response: " + r12);     // Catch: Throwable -> L19
        String r13 = e.b(r12).a();     // Catch: Throwable -> L19
        if (r3 == null) goto L14;
        r3.close();     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L14:
        return r13;
    L30:
        e = move-exception;
        String r4 = f5424a;
        StringBuilder r5 = new StringBuilder();
        r5.append("PCC UploadChannelRet attempt ");
        r5.append(r11);
        r5.append(": ConnectException: ");
        String r14 = e.getMessage();
    L34:
        r5.append(r14);
        com.bytedance.privacy.f.b.b(r4, r5.toString());
    L32:
        e = move-exception;
        r4 = f5424a;
        r5 = new StringBuilder();
        r5.append("PCC UploadChannelRet attempt ");
        r5.append(r11);
        r5.append(": SocketTimeoutException: ");
        r14 = e.getMessage();
    L28:
        e = move-exception;
        r4 = f5424a;
        r5 = new StringBuilder();
        r5.append("PCC UploadChannelRet attempt ");
        r5.append(r11);
        r5.append(": IOException: ");
        r14 = e.getMessage();
    L26:
        e = move-exception;
        com.bytedance.privacy.f.b.c(f5424a, "PCC UploadChannelRet attempt " + r11 + ": unexpected exception: ", e);
        goto L35
    L39:
        return "";
    }
}

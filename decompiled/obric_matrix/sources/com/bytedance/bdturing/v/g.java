package com.bytedance.bdturing.v;

import android.os.Build;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.b0;
import kotlin.f0;
import kotlin.i0.i;
import kotlin.n0.d.o;
import kotlin.u;
import kotlin.u0.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f3203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f3204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.bdturing.ttnet.b f3205d;

    public interface a {
        void a(int r1, String r2, long r3);
    }

    public g(String r2, Map<String, String> r3, a r4, com.bytedance.bdturing.ttnet.b r5) {
        o.g(r2, "mUrl");
        o.g(r3, "params");
        o.g(r4, "mCallback");
        o.g(r5, "mHttpClient");
        this.f3202a = r2;
        this.f3203b = r3;
        this.f3204c = r4;
        this.f3205d = r5;
    }

    private final String a(byte[] r2, byte[] r3, InputStream r4) {
        if (Build.VERSION.SDK_INT < 19) goto L19;
        if (r2 == null) goto L17;
        if (r3 == null) goto L17;
        SecretKeySpec r1 = new SecretKeySpec(r2, "AES");
        GCMParameterSpec r0 = new GCMParameterSpec(128, new IvParameterSpec(r3).getIV());
        Cipher r5 = Cipher.getInstance("AES/GCM/NoPadding");
        r5.init(2, r1, r0);
        GZIPInputStream r6 = new GZIPInputStream(new ByteArrayInputStream(r5.doFinal(kotlin.m0.a.c(r4))));
        String r7 = kotlin.m0.c.c(new InputStreamReader(r6));     // Catch: Throwable -> L11
        f0 r8 = f0.f18324a;     // Catch: Throwable -> L11
        kotlin.m0.b.a(r6, null);
        return r7;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        kotlin.m0.b.a(r6, th);
        throw th;
    L17:
        return kotlin.m0.c.c(new InputStreamReader(r4));
    L19:
        throw new SecurityException("Below Android 4.4 or API 19 is not supported.");
    }

    private final u<byte[], byte[]> b(String r4, String r5) {
        MessageDigest r3 = MessageDigest.getInstance("SHA-256");
        Charset r0 = kotlin.u0.d.f21429a;
        if (r4 == null) goto L15;
        byte[] r6 = r4.getBytes(r0);
        o.b(r6, "(this as java.lang.String).getBytes(charset)");
        byte[] r7 = r3.digest(r6);
        MessageDigest r8 = MessageDigest.getInstance("MD5");
        if (r5 == null) goto L13;
        byte[] r9 = r5.getBytes(r0);
        o.b(r9, "(this as java.lang.String).getBytes(charset)");
        byte[] r10 = r8.digest(r9);
        if (r10 == null) goto L9;
        byte[] r11 = i.i(r10, 0, 12);
    L11:
        return new u(r7, r11);
    L9:
        r11 = null;
        goto L11
    L13:
        throw new b0("null cannot be cast to non-null type java.lang.String");
    L15:
        throw new b0("null cannot be cast to non-null type java.lang.String");
    }

    private final u<String, String> c() {
        kotlin.q0.c r3 = kotlin.q0.d.a(System.nanoTime());
        return new u(x.a(kotlin.q0.e.a(r3), 16), x.a(kotlin.q0.e.a(r3), 16));
    }

    public final void d() {
        long r0 = System.currentTimeMillis();
        String r2 = "";
        u<String, String> r3 = c();
        this.f3203b.put("key", r3.c());
        this.f3203b.put("iv", r3.d());
        u<byte[], byte[]> r4 = b(r3.c(), r3.d());
        byte[] r5 = r4.c();
        byte[] r6 = r4.d();
        String r7 = new JSONObject(this.f3203b).toString();     // Catch: Throwable -> L13 Exception -> L15
        o.b(r7, "JSONObject(params).toString()");     // Catch: Throwable -> L13 Exception -> L15
        LinkedHashMap r8 = new LinkedHashMap();     // Catch: Throwable -> L13 Exception -> L15
        r8.put("Content-type", "application/json;tt-data=g");     // Catch: Throwable -> L13 Exception -> L15
        com.bytedance.bdturing.ttnet.b r9 = this.f3205d;     // Catch: Throwable -> L13 Exception -> L15
        String r10 = this.f3202a;     // Catch: Throwable -> L13 Exception -> L15
        Charset r11 = kotlin.u0.d.f21429a;     // Catch: Throwable -> L13 Exception -> L15
        if (r7 == null) goto L12;
        byte[] r12 = r7.getBytes(r11);     // Catch: Throwable -> L13 Exception -> L15
        o.b(r12, "(this as java.lang.String).getBytes(charset)");     // Catch: Throwable -> L13 Exception -> L15
        byte[] r13 = r9.post(r10, r8, r12);     // Catch: Throwable -> L13 Exception -> L15
        if (r13 != null) goto L8;
    L10:
        int r14 = 204;
    L18:
        this.f3204c.a(r14, r2, System.currentTimeMillis() - r0);
        return;
    L8:
        if (r13.length <= 0) goto L10;
        r14 = 200;
        r2 = a(r5, r6, new ByteArrayInputStream(r13));     // Catch: Throwable -> L13 Exception -> L15
        goto L18
    L12:
        throw new b0("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L13 Exception -> L15
    L15:
        e = move-exception;
        r14 = 500;
        e.printStackTrace();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.f3204c.a(-1, "", System.currentTimeMillis() - r0);
        throw th;
    }
}

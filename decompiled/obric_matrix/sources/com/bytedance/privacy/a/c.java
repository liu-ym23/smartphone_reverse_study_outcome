package com.bytedance.privacy.a;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.privacy.PrivacySdk;
import com.bytedance.privacy.f.d;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5355a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f5356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, a> f5357c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f5358d = 0;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f5360b;

        public a(String r3) {
            this.f5359a = r3;
            this.f5360b = System.currentTimeMillis();
        }

        public String a() {
            return this.f5359a;
        }

        public boolean b() {
            if ((System.currentTimeMillis() - this.f5360b) < c.a()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        f5357c = new ConcurrentHashMap();
        f5358d = TimeUnit.DAYS.toMillis(1);
    }

    public c() {
    }

    static /* synthetic */ long a() {
        return f5358d;
    }

    private Bundle b(Context r4, String r5, com.bytedance.privacy.a.a r6) {
        Bundle r0 = new Bundle();
        r0.putString("attest_appid", r5);
    L35:
        e = move-exception;
        throw new com.bytedance.privacy.c.a("PseudoManager not initialized", -13, e);
    L4:
        if (r6.c(com.bytedance.privacy.a.a.c.f5352g) == false) goto L13;
        String r1 = PrivacySdk.getPseudoManager().getPseudoDID(r4, r5);     // Catch: IllegalStateException -> L35
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.putString("attest_rpdid", r1);     // Catch: IllegalStateException -> L35
    L11:
        throw new com.bytedance.privacy.c.a("Get RPDID failed", -10);     // Catch: IllegalStateException -> L35
    L13:
        if (r6.c(com.bytedance.privacy.a.a.c.f5353h) == false) goto L22;
        String r7 = PrivacySdk.getPseudoManager().getPseudoUID(r4, r5);     // Catch: IllegalStateException -> L35
        if (r7 == null) goto L20;
        if (r7.isEmpty() == true) goto L20;
        r0.putString("attest_rpuid", r7);     // Catch: IllegalStateException -> L35
    L20:
        throw new com.bytedance.privacy.c.a("Get RPUID failed", -11);     // Catch: IllegalStateException -> L35
    L22:
        if (r6.c(com.bytedance.privacy.a.a.c.f5351f) == false) goto L29;
        String r3 = g();     // Catch: IllegalStateException -> L35
        if (r3.isEmpty() == true) goto L27;
        r0.putString("attest_udid", r3);     // Catch: IllegalStateException -> L35
        goto L29
    L27:
        throw new com.bytedance.privacy.c.a("Get UDID failed", -12);     // Catch: IllegalStateException -> L35
    L29:
        if (r6.b() == false) goto L32;
        r0.putBoolean("device_health_status_required", true);     // Catch: IllegalStateException -> L35
    L32:
        if (r6.a() == null) goto L34;
        r0.putString("attest_custom_info", r6.a());
    L34:
        return r0;
    }

    private Bundle c() {
        Bundle r2 = new Bundle();
        r2.putInt("key_algorithm", 2);
        r2.putInt("key_length", 256);
        r2.putInt("key_purpose", 64);
        return r2;
    }

    private String d(Context r12, String r13, String r14, com.bytedance.privacy.a.a r15) {
        h(r12, r13, r14, r15);
        if (d.a() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        String r1 = f5355a;
        if (r0 == true) goto L20;
        com.bytedance.privacy.f.b.d(r1, "Entering cache check...");
        a r2 = f5357c.get(r14);
        if (r2 != null) goto L13;
    L16:
        if (r2 != null) goto L18;
        StringBuilder r3 = new StringBuilder();
        String r4 = "Attestation cache miss for keyAlias: ";
    L19:
        r3.append(r4);
        r3.append(r14);
        com.bytedance.privacy.f.b.d(r1, r3.toString());
        String r5 = "Exiting cache check, moving to network flow";
    L21:
        com.bytedance.privacy.f.b.d(r1, r5);
        String r6 = r14.intern();
        monitor-enter(r6);
        Map<String, a> r7 = f5357c;     // Catch: Throwable -> L49
        a r8 = r7.get(r14);     // Catch: Throwable -> L49
        if (r0 == true) goto L31;
        if (r8 == null) goto L31;
        if (r8.b() == true) goto L31;
        com.bytedance.privacy.f.b.d(f5355a, "Cache hit after wait for keyAlias: " + r14);     // Catch: Throwable -> L49
        String r11 = r8.a();     // Catch: Throwable -> L49
        monitor-exit(r6);     // Catch: Throwable -> L49
        return r11;
    L31:
        String r9 = f5355a;     // Catch: Throwable -> L49
        com.bytedance.privacy.f.b.a(r9, r15.toString());     // Catch: Throwable -> L49
        Bundle r10 = b(r12, r13, r15);     // Catch: Throwable -> L49
        Bundle r16 = c();     // Catch: Throwable -> L49
        String r17 = com.bytedance.privacy.pseudoid.c.a.f5466a.a();     // Catch: Throwable -> L49
        if (r17.isEmpty() == true) goto L48;
        com.bytedance.privacy.d.a.g().c(r12, r14);     // Catch: Throwable -> L49
        List<Certificate> r18 = com.bytedance.privacy.d.a.g().f(r12, r13, r17, r14, r16, r10);     // Catch: Throwable -> L49
        if (r18 == null) goto L46;
        if (r18.isEmpty() == true) goto L46;
        String r19 = com.bytedance.privacy.f.a.a(r18, 3);     // Catch: Exception -> L42 Throwable -> L49
        r7.put(r14, new a(r19));     // Catch: Throwable -> L49
        com.bytedance.privacy.f.b.d(r9, "Successfully gen attestation and stored in cache for keyAlias: " + r14);     // Catch: Throwable -> L49
        com.bytedance.privacy.d.a.g().c(r12, r14);     // Catch: Throwable -> L49
        monitor-exit(r6);     // Catch: Throwable -> L49
        return r19;
    L42:
        e = move-exception;
        com.bytedance.privacy.f.b.c(f5355a, "certsToPemString unexpected error: " + e.getMessage(), e);     // Catch: Throwable -> L49
        throw new com.bytedance.privacy.c.a(e.getMessage(), -100, e);     // Catch: Throwable -> L49
    L46:
        throw new com.bytedance.privacy.c.a("Get id attest cert chain failed", -9);     // Catch: Throwable -> L49
    L48:
        throw new com.bytedance.privacy.c.a("Get device id failed", -4);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;
    L18:
        r3 = new StringBuilder();
        r4 = "Attestation cache expired for keyAlias: ";
        goto L19
    L13:
        if (r2.b() == true) goto L16;
        com.bytedance.privacy.f.b.d(r1, "Cache hit, returning cert chain for keyAlias: " + r14);
        return r2.a();
    L20:
        r5 = "Debug mode with force cloud fetch, skipping cache check";
        goto L21
    L5:
        if (d.b(2) == false) goto L7;
        r0 = true;
        goto L8
    }

    public static c f() {
        if (f5356b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5356b != null) goto L9;
        f5356b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f5356b;
    }

    private String g() {
        String r3 = com.bytedance.privacy.pseudoid.c.a.f5466a.b();
        if (r3.length() == 64) goto L6;
        com.bytedance.privacy.f.b.b(f5355a, "Invalid UDID length: " + r3.length());
        return "";
    L6:
        return r3;
    }

    private void h(Context r1, String r2, String r3, com.bytedance.privacy.a.a r4) {
        com.bytedance.privacy.f.c.c("context", r1);
        com.bytedance.privacy.f.c.c("config", r4);
        com.bytedance.privacy.f.c.a("appId", r2, 128);
        com.bytedance.privacy.f.c.a("keyAlias", r3, 128);
    }

    public String e(Context r10, String r11, String r12, com.bytedance.privacy.a.a r13) {
        if (r10 == null) goto L5;
        String r4 = r10.getPackageName();
    L6:
        long r1 = System.currentTimeMillis();
        String r9 = d(r10, r11, r12, r13);     // Catch: Throwable -> L17 com.bytedance.privacy.c.a -> L19
        long r6 = System.currentTimeMillis() - r1;
        if (r11 == null) goto L11;
        String r5 = r11;
    L12:
        if (r13 != null) goto L15;
        r13 = new com.bytedance.privacy.a.a.b().d();
    L15:
        b.a(0, 0, r4, r5, r6, r13);
        return r9;
    L11:
        r5 = "";
        goto L12
    L17:
        th = th;
        int r14 = 0;
    L24:
        long r7 = System.currentTimeMillis() - r1;
        if (r11 == null) goto L27;
        String r8 = r11;
    L28:
        if (r13 != null) goto L31;
        r13 = new com.bytedance.privacy.a.a.b().d();
    L31:
        b.a(r14, 0, r4, r8, r7, r13);
        throw th;
    L27:
        r8 = "";
    L19:
        e = move-exception;
        r14 = e.a();     // Catch: Throwable -> L17
        com.bytedance.privacy.f.b.b(f5355a, "getIDAttestationString failed: " + e.getMessage());     // Catch: Throwable -> L23
        throw e;     // Catch: Throwable -> L23
    L23:
        th = th;
        goto L24
    L5:
        r4 = "";
        goto L6
    }
}

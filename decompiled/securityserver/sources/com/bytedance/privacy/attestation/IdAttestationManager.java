package com.bytedance.privacy.attestation;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.privacy.PrivacySdk;
import com.bytedance.privacy.bridge.IAccountBridge;
import com.bytedance.privacy.exception.BdPrivacyException;
import com.bytedance.privacy.keymanager.AttestKeyManager;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import com.bytedance.privacy.security.SecurityFrameworkCompat;
import com.bytedance.privacy.utils.CertUtils;
import com.bytedance.privacy.utils.LogUtils;
import com.bytedance.privacy.utils.ParamValidator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class IdAttestationManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile IdAttestationManager f8a;
    public static final ConcurrentHashMap b = null;
    public static final long c = 0;

    public static class CachedAttestation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9a;
        public final long b;

        public CachedAttestation(String r3) {
            this.f9a = r3;
            this.b = System.currentTimeMillis();
        }
    }

    static {
        b = new ConcurrentHashMap();
        c = TimeUnit.DAYS.toMillis(1);
    }

    public static Bundle a(Context r6, AttestationConfig r7) {
        Bundle r0 = new Bundle();
        SecurityFrameworkCompat.i();
        r0.putString("attest_appid", "ocean_securityserver");
        boolean[] r1 = r7.f6a;     // Catch: IllegalStateException -> L10
        if (r1[1] == false) goto L15;
        String r4 = PrivacySdk.getPseudoManager().getPseudoDID(r6, "ocean_securityserver");     // Catch: IllegalStateException -> L10
        if (r4 == null) goto L13;
        if (r4.isEmpty() == true) goto L13;
        SecurityFrameworkCompat.b();     // Catch: IllegalStateException -> L10
        r0.putString("attest_rpdid", r4);     // Catch: IllegalStateException -> L10
    L13:
        throw new BdPrivacyException("Get RPDID failed", -10);     // Catch: IllegalStateException -> L10
    L15:
        if (r1[2] == false) goto L24;
        String r8 = PrivacySdk.getPseudoManager().getPseudoUID(r6, "ocean_securityserver");     // Catch: IllegalStateException -> L10
        if (r8 == null) goto L22;
        if (r8.isEmpty() == true) goto L22;
        SecurityFrameworkCompat.c();     // Catch: IllegalStateException -> L10
        r0.putString("attest_rpuid", r8);     // Catch: IllegalStateException -> L10
    L22:
        throw new BdPrivacyException("Get RPUID failed", -11);     // Catch: IllegalStateException -> L10
    L24:
        if (r1[0] == false) goto L42;
        IAccountBridge r9 = AccountApi.f23a;     // Catch: IllegalStateException -> L10
        if (r9 == null) goto L28;
        String r10 = r9.c();     // Catch: IllegalStateException -> L10
    L29:
        String r2 = "";
        if (r10 != null) goto L33;
        r10 = "";
    L33:
        if (r10.length() == 64) goto L35;
        LogUtils.b("IdAttestationManager", "Invalid UDID length: " + r10.length());     // Catch: IllegalStateException -> L10
    L37:
        if (r2.isEmpty() == true) goto L40;
        SecurityFrameworkCompat.i();     // Catch: IllegalStateException -> L10
        r0.putString("attest_udid", r2);     // Catch: IllegalStateException -> L10
        goto L42
    L40:
        throw new BdPrivacyException("Get UDID failed", -12);     // Catch: IllegalStateException -> L10
    L35:
        r2 = r10;
        goto L37
    L28:
        r10 = null;
    L42:
        if (r7.c == false) goto L44;
        SecurityFrameworkCompat.g();     // Catch: IllegalStateException -> L10
        r0.putBoolean("device_health_status_required", true);     // Catch: IllegalStateException -> L10
    L44:
        String r11 = r7.b;
        if (r11 == null) goto L47;
        SecurityFrameworkCompat.i();
        r0.putString("attest_custom_info", r11);
    L47:
        return r0;
    L10:
        e = move-exception;
        throw new BdPrivacyException("PseudoManager not initialized", -13, e);
    }

    public static String b(Context r11, AttestationConfig r12) {
        if (r11 == null) goto L47;
        ParamValidator.a(128, "appId");
        SecurityFrameworkCompat.i();
        ParamValidator.a(128, "keyAlias");
        LogUtils.d("IdAttestationManager", "Entering cache check...");
        ConcurrentHashMap r4 = b;
        CachedAttestation r5 = (CachedAttestation) r4.get("ocean_securityserver");
        if (r5 != null) goto L7;
    L11:
        if (r5 != null) goto L13;
        LogUtils.d("IdAttestationManager", "Attestation cache miss for keyAlias: ".concat("ocean_securityserver"));
    L14:
        LogUtils.d("IdAttestationManager", "Exiting cache check, moving to network flow");
        String r6 = "ocean_securityserver".intern();
        monitor-enter(r6);
        CachedAttestation r7 = (CachedAttestation) r4.get("ocean_securityserver");     // Catch: Throwable -> L26
        if (r7 != null) goto L19;
    L28:
        LogUtils.a("IdAttestationManager", r12.toString());     // Catch: Throwable -> L26
        Bundle r13 = a(r11, r12);     // Catch: Throwable -> L26
        Bundle r3 = new Bundle();     // Catch: Throwable -> L26
        SecurityFrameworkCompat.j();     // Catch: Throwable -> L26
        SecurityFrameworkCompat.i();     // Catch: Throwable -> L26
        r3.putInt("key_algorithm", 2);     // Catch: Throwable -> L26
        SecurityFrameworkCompat.l();     // Catch: Throwable -> L26
        r3.putInt("key_length", 256);     // Catch: Throwable -> L26
        SecurityFrameworkCompat.m();     // Catch: Throwable -> L26
        SecurityFrameworkCompat.n();     // Catch: Throwable -> L26
        r3.putInt("key_purpose", 64);     // Catch: Throwable -> L26
        String r8 = AccountApi.a();     // Catch: Throwable -> L26
        if (r8.isEmpty() == true) goto L43;
        AttestKeyManager.d().getClass();     // Catch: Throwable -> L26
        AttestKeyManager.a(r11, "ocean_securityserver");     // Catch: Throwable -> L26
        AttestKeyManager.d().getClass();     // Catch: Throwable -> L26
        List r14 = AttestKeyManager.c(r11, r8, r3, r13);     // Catch: Throwable -> L26
        if (r14.isEmpty() == true) goto L41;
        String r15 = CertUtils.a(r14, 3);     // Catch: Throwable -> L26 Exception -> L37
        r4.put("ocean_securityserver", new CachedAttestation(r15));     // Catch: Throwable -> L26
        LogUtils.d("IdAttestationManager", "Successfully gen attestation and stored in cache for keyAlias: ".concat("ocean_securityserver"));     // Catch: Throwable -> L26
        AttestKeyManager.d().getClass();     // Catch: Throwable -> L26
        AttestKeyManager.a(r11, "ocean_securityserver");     // Catch: Throwable -> L26
        monitor-exit(r6);     // Catch: Throwable -> L26
        return r15;
    L37:
        e = move-exception;
        LogUtils.c("IdAttestationManager", "certsToPemString unexpected error: " + e.getMessage(), e);     // Catch: Throwable -> L26
        throw new BdPrivacyException(e.getMessage(), -100, e);     // Catch: Throwable -> L26
    L41:
        throw new BdPrivacyException("Get id attest cert chain failed", -9);     // Catch: Throwable -> L26
    L43:
        throw new BdPrivacyException("Get device id failed", -4);     // Catch: Throwable -> L26
    L19:
        if ((System.currentTimeMillis() - r7.b) < c) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == true) goto L28;
        LogUtils.d("IdAttestationManager", "Cache hit after wait for keyAlias: ".concat("ocean_securityserver"));     // Catch: Throwable -> L26
        String r16 = r7.f9a;     // Catch: Throwable -> L26
        monitor-exit(r6);     // Catch: Throwable -> L26
        return r16;
    L21:
        r9 = false;
    L26:
        th = move-exception;
        throw th;
    L13:
        LogUtils.d("IdAttestationManager", "Attestation cache expired for keyAlias: ".concat("ocean_securityserver"));
        goto L14
    L7:
        if ((System.currentTimeMillis() - r5.b) >= c) goto L11;
        LogUtils.d("IdAttestationManager", "Cache hit, returning cert chain for keyAlias: ".concat("ocean_securityserver"));
        return r5.f9a;
    L47:
        throw new BdPrivacyException("context".concat(" is null"), -2);
    }

    public static String c(Context r8, AttestationConfig r9) {
        if (r8 == null) goto L5;
        String r1 = r8.getPackageName();
    L6:
        long r3 = System.currentTimeMillis();
        String r10 = b(r8, r9);     // Catch: Throwable -> L10 BdPrivacyException -> L12
        IdAttestationEventTrace.a(0, r1, "ocean_securityserver", System.currentTimeMillis() - r3, r9);
        return r10;
    L10:
        th = move-exception;
        IdAttestationEventTrace.a(0, r1, "ocean_securityserver", System.currentTimeMillis() - r3, r9);
        throw th;
    L12:
        e = move-exception;
        int r5 = e.b;     // Catch: Throwable -> L10
        LogUtils.b("IdAttestationManager", "getIDAttestationString failed: " + e.getMessage());     // Catch: Throwable -> L10
        throw e;     // Catch: Throwable -> L10
    L5:
        r1 = "";
        goto L6
    }
}

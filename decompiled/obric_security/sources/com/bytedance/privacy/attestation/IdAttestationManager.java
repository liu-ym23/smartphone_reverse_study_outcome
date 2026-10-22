package com.bytedance.privacy.attestation;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.privacy.PrivacySdk;
import com.bytedance.privacy.exception.BdPrivacyException;
import com.bytedance.privacy.keymanager.AttestKeyManager;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import com.bytedance.privacy.security.SecurityFrameworkCompat;
import com.bytedance.privacy.utils.CertUtils;
import com.bytedance.privacy.utils.LogUtils;
import com.bytedance.privacy.utils.ParamValidator;
import com.bytedance.privacy.utils.PrivacyConfig;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class IdAttestationManager {
    private static final long CACHE_ENTRY_LIFETIME_MS = 0;
    public static final String TAG = "IdAttestationManager";
    private static final Map<String, CachedAttestation> attestationCacheMap = null;
    private static volatile IdAttestationManager idAttestationManager;

    public static class CachedAttestation {
        private final String certChain;
        private final long timestamp;

        public CachedAttestation(String r3) {
            this.certChain = r3;
            this.timestamp = System.currentTimeMillis();
        }

        public boolean isExpired() {
            if ((System.currentTimeMillis() - this.timestamp) < IdAttestationManager.access$000()) goto L5;
            return true;
        L5:
            return false;
        }

        public String getCertChain() {
            return this.certChain;
        }
    }

    public IdAttestationManager() {
    }

    static /* synthetic */ long access$000() {
        return CACHE_ENTRY_LIFETIME_MS;
    }

    public static IdAttestationManager getInstance() {
        if (idAttestationManager != null) goto L15;
        monitor-enter(IdAttestationManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (idAttestationManager != null) goto L9;
        idAttestationManager = new IdAttestationManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(IdAttestationManager.class);     // Catch: Throwable -> L11
    L15:
        return idAttestationManager;
    }

    static {
        attestationCacheMap = new ConcurrentHashMap();
        CACHE_ENTRY_LIFETIME_MS = TimeUnit.DAYS.toMillis(1);
    }

    private String getIDAttestation(Context r15, String r16, String r17, AttestationConfig r18) throws BdPrivacyException {
        validateInput(r15, r16, r17, r18);
        if (PrivacyConfig.isDebug() == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L19;
        String r3 = TAG;
        LogUtils.i(r3, "Entering cache check...");
        CachedAttestation r4 = attestationCacheMap.get(r17);
        if (r4 != null) goto L12;
    L15:
        if (r4 != null) goto L17;
        LogUtils.i(r3, "Attestation cache miss for keyAlias: " + r17);
    L18:
        LogUtils.i(r3, "Exiting cache check, moving to network flow");
    L20:
        String r11 = r17.intern();
        monitor-enter(r11);
        Map<String, CachedAttestation> r12 = attestationCacheMap;     // Catch: Throwable -> L48
        CachedAttestation r5 = r12.get(r17);     // Catch: Throwable -> L48
        if (r2 == true) goto L30;
        if (r5 == null) goto L30;
        if (r5.isExpired() == true) goto L30;
        LogUtils.i(TAG, "Cache hit after wait for keyAlias: " + r17);     // Catch: Throwable -> L48
        String r0 = r5.getCertChain();     // Catch: Throwable -> L48
        monitor-exit(r11);     // Catch: Throwable -> L48
        return r0;
    L30:
        String r13 = TAG;     // Catch: Throwable -> L48
        LogUtils.d(r13, r18.toString());     // Catch: Throwable -> L48
        Bundle r7 = buildAttestBundle(r15, r16, r18);     // Catch: Throwable -> L48
        Bundle r6 = buildKeyBundle();     // Catch: Throwable -> L48
        String r8 = AccountApi.INSTANCE.getDeviceId();     // Catch: Throwable -> L48
        if (r8.isEmpty() == true) goto L47;
        AttestKeyManager.getInstance().deleteAttestKey(r15, r17);     // Catch: Throwable -> L48
        List<Certificate> r1 = AttestKeyManager.getInstance().getIdAttestCertChain(r15, r16, r8, r17, r6, r7);     // Catch: Throwable -> L48
        if (r1 == null) goto L45;
        if (r1.isEmpty() == true) goto L45;
        String r9 = CertUtils.certsToPemString(r1, 3);     // Catch: Exception -> L41 Throwable -> L48
        r12.put(r17, new CachedAttestation(r9));     // Catch: Throwable -> L48
        LogUtils.i(r13, "Successfully gen attestation and stored in cache for keyAlias: " + r17);     // Catch: Throwable -> L48
        AttestKeyManager.getInstance().deleteAttestKey(r15, r17);     // Catch: Throwable -> L48
        monitor-exit(r11);     // Catch: Throwable -> L48
        return r9;
    L41:
        e = move-exception;
        LogUtils.e(TAG, "certsToPemString unexpected error: " + e.getMessage(), e);     // Catch: Throwable -> L48
        throw new BdPrivacyException(e.getMessage(), -100, e);     // Catch: Throwable -> L48
    L45:
        throw new BdPrivacyException("Get id attest cert chain failed", -9);     // Catch: Throwable -> L48
    L47:
        throw new BdPrivacyException("Get device id failed", -4);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    L17:
        LogUtils.i(r3, "Attestation cache expired for keyAlias: " + r17);
        goto L18
    L12:
        if (r4.isExpired() == true) goto L15;
        LogUtils.i(r3, "Cache hit, returning cert chain for keyAlias: " + r17);
        return r4.getCertChain();
    L19:
        LogUtils.i(TAG, "Debug mode with force cloud fetch, skipping cache check");
        goto L20
    L5:
        if (PrivacyConfig.isForceFetchFromCloud(2) == false) goto L7;
        r2 = true;
        goto L8
    }

    public String getIDAttestationString(Context r12, String r13, String r14, AttestationConfig r15) throws BdPrivacyException {
        if (r12 == null) goto L5;
        String r6 = r12.getPackageName();
    L6:
        long r3 = System.currentTimeMillis();
        String r11 = getIDAttestation(r12, r13, r14, r15);     // Catch: Throwable -> L17 BdPrivacyException -> L19
        long r7 = System.currentTimeMillis() - r3;
        if (r13 == null) goto L11;
        String r4 = r13;
    L12:
        if (r15 != null) goto L15;
        r15 = new AttestationConfig.Builder().build();
    L15:
        IdAttestationEventTrace.eventTrace(0, 0, r6, r4, r7, r15);
        return r11;
    L11:
        r4 = "";
        goto L12
    L17:
        th = move-exception;
        long r8 = System.currentTimeMillis() - r3;
        if (r13 == null) goto L25;
        String r9 = r13;
    L26:
        if (r15 != null) goto L29;
        r15 = new AttestationConfig.Builder().build();
    L29:
        IdAttestationEventTrace.eventTrace(0, 0, r6, r9, r8, r15);
        throw th;
    L25:
        r9 = "";
    L19:
        e = move-exception;
        e.getErrorCode();     // Catch: Throwable -> L17
        LogUtils.e(TAG, "getIDAttestationString failed: " + e.getMessage());     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L5:
        r6 = "";
        goto L6
    }

    private void validateInput(Context r1, String r2, String r3, AttestationConfig r4) throws BdPrivacyException {
        ParamValidator.checkNotNull("context", r1);
        ParamValidator.checkNotNull("config", r4);
        ParamValidator.checkLength("appId", r2, 128);
        ParamValidator.checkLength("keyAlias", r3, SecurityFrameworkCompat.maxKeyAliasLen());
    }

    private Bundle buildAttestBundle(Context r4, String r5, AttestationConfig r6) throws BdPrivacyException {
        Bundle r0 = new Bundle();
        r0.putString(SecurityFrameworkCompat.attestAppIdKey(), r5);
    L35:
        e = move-exception;
        throw new BdPrivacyException("PseudoManager not initialized", -13, e);
    L4:
        if (r6.isIdRequested(AttestationConfig.IdType.RPDID) == false) goto L13;
        String r1 = PrivacySdk.getPseudoManager().getPseudoDID(r4, r5);     // Catch: IllegalStateException -> L35
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.putString(SecurityFrameworkCompat.attestPrdidKey(), r1);     // Catch: IllegalStateException -> L35
    L11:
        throw new BdPrivacyException("Get RPDID failed", -10);     // Catch: IllegalStateException -> L35
    L13:
        if (r6.isIdRequested(AttestationConfig.IdType.RPUID) == false) goto L22;
        String r7 = PrivacySdk.getPseudoManager().getPseudoUID(r4, r5);     // Catch: IllegalStateException -> L35
        if (r7 == null) goto L20;
        if (r7.isEmpty() == true) goto L20;
        r0.putString(SecurityFrameworkCompat.attestPruidKey(), r7);     // Catch: IllegalStateException -> L35
    L20:
        throw new BdPrivacyException("Get RPUID failed", -11);     // Catch: IllegalStateException -> L35
    L22:
        if (r6.isIdRequested(AttestationConfig.IdType.UDID) == false) goto L29;
        String r3 = getUDID();     // Catch: IllegalStateException -> L35
        if (r3.isEmpty() == true) goto L27;
        r0.putString(SecurityFrameworkCompat.attestUdidKey(), r3);     // Catch: IllegalStateException -> L35
        goto L29
    L27:
        throw new BdPrivacyException("Get UDID failed", -12);     // Catch: IllegalStateException -> L35
    L29:
        if (r6.isDevHealthStatusRequired() == false) goto L32;
        r0.putBoolean(SecurityFrameworkCompat.deviceHealthStatusRequiredKey(), true);     // Catch: IllegalStateException -> L35
    L32:
        if (r6.getCustomInfo() == null) goto L34;
        r0.putString(SecurityFrameworkCompat.attestCustomInfoKey(), r6.getCustomInfo());
    L34:
        return r0;
    }

    private Bundle buildKeyBundle() {
        Bundle r2 = new Bundle();
        r2.putInt(SecurityFrameworkCompat.keyAlgoKey(), SecurityFrameworkCompat.keyAlgorithmEcc());
        r2.putInt(SecurityFrameworkCompat.keyLenKey(), 256);
        r2.putInt(SecurityFrameworkCompat.keyPurposeKey(), SecurityFrameworkCompat.purposeAttestKey());
        return r2;
    }

    private String getUDID() {
        String r3 = AccountApi.INSTANCE.getUDID();
        if (r3.length() == 64) goto L6;
        LogUtils.e(TAG, "Invalid UDID length: " + r3.length());
        return "";
    L6:
        return r3;
    }
}

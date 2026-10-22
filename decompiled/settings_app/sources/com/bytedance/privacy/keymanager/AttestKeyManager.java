package com.bytedance.privacy.keymanager;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.privacy.network.ChallengeManager;
import com.bytedance.privacy.security.SecurityFrameworkCompat;
import com.bytedance.privacy.utils.LogUtils;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AttestKeyManager {
    public static final String TAG = "AttestKeyManager";
    private static volatile AttestKeyManager keyManager;

    static {
    }

    public AttestKeyManager() {
    }

    public static AttestKeyManager getInstance() {
        if (keyManager != null) goto L15;
        monitor-enter(AttestKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (keyManager != null) goto L9;
        keyManager = new AttestKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AttestKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return keyManager;
    }

    public List<Certificate> getAttestCertChain(Context r3, String r4, String r5, boolean r6, Bundle r7) {
        String r0 = ChallengeManager.requestChallenge();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        LogUtils.e(TAG, "Request challenge failed!!");
        return new ArrayList();
    L6:
        int r8 = generateKeyPair(r3, r4, r7);
        if (r8 == SecurityFrameworkCompat.kmSuccess()) goto L11;
        LogUtils.e(TAG, "Generate attestation key pair failed! ret:" + r8);
        return new ArrayList();
    L11:
        return attestKey(r3, r4, r0 + ":" + r5 + ":" + r4, r6);
    }

    private int generateKeyPair(Context r1, String r2, Bundle r3) {
        int r0 = SecurityFrameworkCompat.generateKeyPair(r1, r2, r3);
        if (r0 == SecurityFrameworkCompat.kmSuccess()) goto L7;
        LogUtils.e(TAG, "Generate key pair failed! ret:" + r0);
        return r0;
    L7:
        return SecurityFrameworkCompat.kmSuccess();
    }

    private List<Certificate> attestKey(Context r2, String r3, String r4, boolean r5) {
        Bundle r1 = new Bundle();
        if (r5 == false) goto L5;
        r1.putBoolean(SecurityFrameworkCompat.deviceHealthStatusRequiredKey(), true);
        r1.putString(SecurityFrameworkCompat.challengeKey(), r4);
    L6:
        SecurityFrameworkCompat.KeyManagerResultCompat r6 = SecurityFrameworkCompat.keyAttestation(r2, r3, r1);
        if (r6.getResultCode() == SecurityFrameworkCompat.kmSuccess()) goto L10;
        LogUtils.e(TAG, "Attest key failed! ret:" + r6.getResultCode());
        return new ArrayList();
    L10:
        List<Certificate> r7 = r6.getCertChain();
        LogUtils.d(TAG, "Attest key succeed! cert chain size:" + r7.size());
        return r7;
    L5:
        r1.putString(SecurityFrameworkCompat.challengeKey(), r4);
        goto L6
    }

    private List<Certificate> attestKeyWithIds(Context r1, String r2, String r3, Bundle r4) {
        if (r4 != null) goto L5;
        LogUtils.e(TAG, "Attest bundle is null");
        return new ArrayList();
    L5:
        r4.putString(SecurityFrameworkCompat.challengeKey(), r3);
        SecurityFrameworkCompat.KeyManagerResultCompat r0 = SecurityFrameworkCompat.keyAttestation(r1, r2, r4);
        if (r0.getResultCode() == SecurityFrameworkCompat.kmSuccess()) goto L9;
        LogUtils.e(TAG, "Attest key with ids failed! ret:" + r0.getResultCode());
        return new ArrayList();
    L9:
        List<Certificate> r5 = r0.getCertChain();
        if (r5 != null) goto L12;
    L16:
        LogUtils.e(TAG, "keyAttestation result certChain invalid for keyAlias=" + r2);
        return new ArrayList();
    L12:
        if (r5.isEmpty() == true) goto L16;
        LogUtils.d(TAG, "Attest key with ids succeed! keyAlias=" + r2 + ", cert chain size: " + r5.size());
        return r5;
    }

    public void deleteAttestKey(Context r3, String r4) {
        int r2 = SecurityFrameworkCompat.deleteKey(r3, r4, new Bundle());
        if (r2 != SecurityFrameworkCompat.kmSuccess()) goto L5;
        LogUtils.i(TAG, "Deleted attest key successfully: " + r4);
        return;
    L5:
        LogUtils.e(TAG, "Failed to delete attest key: " + r4 + ", ret: " + r2);
    }

    public List<Certificate> getIdAttestCertChain(Context r3, String r4, String r5, String r6, Bundle r7, Bundle r8) {
        String r0 = ChallengeManager.requestChallenge();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        LogUtils.e(TAG, "Request challenge failed!!");
        return new ArrayList();
    L6:
        int r9 = generateKeyPair(r3, r6, r7);
        if (r9 == SecurityFrameworkCompat.kmSuccess()) goto L10;
        LogUtils.e(TAG, "Generate attestation key pair failed! ret:" + r9);
        return new ArrayList();
    L10:
        List<Certificate> r10 = attestKeyWithIds(r3, r6, r0 + ":" + r5 + ":" + r4, r8);
        if (r10.isEmpty() == false) goto L14;
        LogUtils.e(TAG, "attestKeyWithIds failed, delete keyAlias: " + r6);
        deleteAttestKey(r3, r6);
        return new ArrayList();
    L14:
        return r10;
    }
}

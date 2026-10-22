package com.bytedance.privacy.pcc;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.privacy.security.SecurityFrameworkCompat;
import com.bytedance.privacy.utils.CertUtils;
import com.bytedance.privacy.utils.LogUtils;
import java.security.cert.Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class KeyAttestationHelper {
    private static final String TAG = "KeyAttestationHelper";

    static {
    }

    private KeyAttestationHelper() {
    }

    public static String generateAndAttestSignKey(Context r4, String r5, String r6, String r7, String r8) throws Exception {
        deleteSignKey(r4, r5);
        Bundle r0 = new Bundle();
        r0.putInt(SecurityFrameworkCompat.keyAlgoKey(), SecurityFrameworkCompat.keyAlgorithmEcc());
        r0.putInt(SecurityFrameworkCompat.keyLenKey(), 256);
        r0.putInt(SecurityFrameworkCompat.keyPurposeKey(), SecurityFrameworkCompat.purposeAttestKey() | SecurityFrameworkCompat.purposeSign());
        int r1 = SecurityFrameworkCompat.generateKeyPair(r4, r5, r0);
        if (r1 != SecurityFrameworkCompat.kmSuccess()) goto L17;
        Bundle r2 = new Bundle();
        r2.putString(SecurityFrameworkCompat.challengeKey(), r6);
        r2.putString(SecurityFrameworkCompat.attestPrdidKey(), r7);
        r2.putString(SecurityFrameworkCompat.attestPruidKey(), r8);
        r2.putBoolean(SecurityFrameworkCompat.deviceHealthStatusRequiredKey(), true);
        SecurityFrameworkCompat.KeyManagerResultCompat r9 = SecurityFrameworkCompat.keyAttestation(r4, r5, r2);
        if (r9.getResultCode() != SecurityFrameworkCompat.kmSuccess()) goto L15;
        List<Certificate> r10 = r9.getCertChain();
        if (r10 == null) goto L13;
        if (r10.isEmpty() == true) goto L13;
        return CertUtils.certsToPemString(r10, Math.min(r10.size(), 3));
    L13:
        throw new Exception("cert chain is empty");
    L15:
        throw new Exception("keyAttestation failed: ret=" + r9.getResultCode());
    L17:
        throw new Exception("generateKeyPair failed: ret=" + r1);
    }

    public static byte[] sign(Context r1, String r2, byte[] r3) throws Exception {
        SecurityFrameworkCompat.KeyManagerResultCompat r4 = SecurityFrameworkCompat.sign(r1, r2, r3, new Bundle());
        byte[] r5 = r4.getOutData();
        if (r4.getResultCode() != SecurityFrameworkCompat.kmSuccess()) goto L9;
        if (r5 == null) goto L9;
        if (r5.length == 0) goto L9;
        return r5;
    L9:
        throw new Exception("sign failed: ret=" + r4.getResultCode());
    }

    public static void deleteSignKey(Context r3, String r4) {
        int r5 = SecurityFrameworkCompat.deleteKey(r3, r4, new Bundle());
        if (r5 != SecurityFrameworkCompat.kmSuccess()) goto L5;
        LogUtils.d(TAG, "deleteSignKey: alias=" + r4);
        return;
    L5:
        LogUtils.e(TAG, "deleteSignKey: ret=" + r5 + " alias=" + r4);
    }
}

package com.bytedance.privacy.security;

import android.content.Context;
import android.os.Bundle;
import com.aiassistant.security.keymanager.KeyManager;
import com.aiassistant.security.keymanager.KeyManagerResult;
import com.aiassistant.security.secretdata.AddResult;
import com.aiassistant.security.secretdata.QueryResult;
import com.aiassistant.security.secretdata.SecretData;
import com.aiassistant.security.secretdata.SecretDataManager;
import com.bytedance.privacy.utils.LogUtils;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SecurityFrameworkCompat {
    private static final String CLASS_AIASSISTANT_SDM = "com.aiassistant.security.secretdata.SecretDataManager";
    private static final String CLASS_OBRIC_SDM = "com.obric.security.secretdata.SecretDataManager";
    private static final String TAG = "SecurityFrameworkCompat";
    private static volatile Impl sImpl;

    /* JADX INFO: renamed from: com.bytedance.privacy.security.SecurityFrameworkCompat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class AiassistantImpl implements Impl {
        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestAppIdKey() {
            return "attest_appid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestCustomInfoKey() {
            return "attest_custom_info";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestPrdidKey() {
            return "attest_rpdid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestPruidKey() {
            return "attest_rpuid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestUdidKey() {
            return "attest_udid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String basePkg() {
            return "com.aiassistant.security";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String challengeKey() {
            return "challenge";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String deviceHealthStatusRequiredKey() {
            return "device_health_status_required";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String keyAlgoKey() {
            return "key_algorithm";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int keyAlgorithmEcc() {
            return 2;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String keyLenKey() {
            return "key_length";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String keyPurposeKey() {
            return "key_purpose";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int kmSuccess() {
            return 0;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int maxAttestationCustomInfoLen() {
            return 1024;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int maxKeyAliasLen() {
            return 128;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int purposeAttestKey() {
            return 64;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int purposeSign() {
            return 4;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int queryModeIfDataExist() {
            return 0;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int queryModePreciseQueryAndDecrypt() {
            return 2;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String secretBundleKeyQueryMode() {
            return "query_mode";
        }

        private AiassistantImpl() {
        }

        /* synthetic */ AiassistantImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int generateKeyPair(Context r1, String r2, Bundle r3) {
            return KeyManager.getInstance().generateKeyPair(r1, r2, r3);
        L4:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "generateKeyPair failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int deleteKey(Context r1, String r2, Bundle r3) {
            return KeyManager.getInstance().deleteKey(r1, r2, r3);
        L4:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "deleteKey failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public KeyManagerResultCompat keyAttestation(Context r1, String r2, Bundle r3) {
            KeyManagerResult r0 = KeyManager.getInstance().keyAttestation(r1, r2, r3);     // Catch: Throwable -> L8
            if (r0 != null) goto L7;
            return KeyManagerResultCompat.nullResult();
        L7:
            return KeyManagerResultCompat.of(r0.getResultCode(), r0.getCertChain(), r0.getOutData());
        L8:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "keyAttestation failed", th);
            return KeyManagerResultCompat.nullResult();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public KeyManagerResultCompat sign(Context r1, String r2, byte[] r3, Bundle r4) {
            KeyManagerResult r0 = KeyManager.getInstance().sign(r1, r2, r3, r4);     // Catch: Throwable -> L8
            if (r0 != null) goto L7;
            return KeyManagerResultCompat.nullResult();
        L7:
            return KeyManagerResultCompat.of(r0.getResultCode(), r0.getCertChain(), r0.getOutData());
        L8:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "sign failed", th);
            return KeyManagerResultCompat.nullResult();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public SecretQueryResult querySecretData(Context r1, String r2, Bundle r3) {
            QueryResult r0 = SecretDataManager.getInstance().queryData(r1, r2, r3);     // Catch: Throwable -> L16
            if (r0 == null) goto L5;
            List r4 = r0.getDataList();     // Catch: Throwable -> L16
            if (r4 != null) goto L9;
        L13:
            String r5 = null;
        L15:
            return SecretQueryResult.of(r0.getResultCode(), r5);
        L9:
            if (r4.isEmpty() == true) goto L13;
            SecretData r6 = (SecretData) r4.get(0);     // Catch: Throwable -> L16
            if (r6 == null) goto L13;
            r5 = r6.privateData;     // Catch: Throwable -> L16
            goto L15
        L5:
            return SecretQueryResult.nullResult();
        L16:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "SecretDataManager.queryData failed", th);
            return SecretQueryResult.nullResult();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int addSecretData(Context r2, String r3, String r4, String r5, String r6, Bundle r7) {
            SecretData r0 = new SecretData();     // Catch: Throwable -> L7
            r0.privateData = r3;     // Catch: Throwable -> L7
            r0.associate = r4;     // Catch: Throwable -> L7
            r0.alias = r5;     // Catch: Throwable -> L7
            r0.dataType = r6;     // Catch: Throwable -> L7
            AddResult r8 = SecretDataManager.getInstance().addData(r2, r0, r7);     // Catch: Throwable -> L7
            if (r8 == null) goto L12;
            return r8.getResultCode();
        L12:
            return -1;
        L7:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "SecretDataManager.addData failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int deleteSecretData(Context r1, String r2, Bundle r3) {
            return SecretDataManager.getInstance().deleteData(r1, r2, r3);
        L4:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "SecretDataManager.deleteData failed", th);
            return -1;
        }
    }

    private interface Impl {
        int addSecretData(Context r1, String r2, String r3, String r4, String r5, Bundle r6);

        String attestAppIdKey();

        String attestCustomInfoKey();

        String attestPrdidKey();

        String attestPruidKey();

        String attestUdidKey();

        String basePkg();

        String challengeKey();

        int deleteKey(Context r1, String r2, Bundle r3);

        int deleteSecretData(Context r1, String r2, Bundle r3);

        String deviceHealthStatusRequiredKey();

        int generateKeyPair(Context r1, String r2, Bundle r3);

        String keyAlgoKey();

        int keyAlgorithmEcc();

        KeyManagerResultCompat keyAttestation(Context r1, String r2, Bundle r3);

        String keyLenKey();

        String keyPurposeKey();

        int kmSuccess();

        int maxAttestationCustomInfoLen();

        int maxKeyAliasLen();

        int purposeAttestKey();

        int purposeSign();

        int queryModeIfDataExist();

        int queryModePreciseQueryAndDecrypt();

        SecretQueryResult querySecretData(Context r1, String r2, Bundle r3);

        String secretBundleKeyQueryMode();

        KeyManagerResultCompat sign(Context r1, String r2, byte[] r3, Bundle r4);
    }

    public static final class KeyManagerResultCompat {
        private final List<Certificate> certChain;
        private final boolean isNull;
        private final byte[] outData;
        private final int resultCode;

        private KeyManagerResultCompat(boolean r1, int r2, List<Certificate> r3, byte[] r4) {
            this.isNull = r1;
            this.resultCode = r2;
            if (r3 != null) goto L6;
            r3 = Collections.emptyList();
        L6:
            this.certChain = r3;
            this.outData = r4;
        }

        static KeyManagerResultCompat nullResult() {
            return new KeyManagerResultCompat(true, -1, Collections.emptyList(), null);
        }

        static KeyManagerResultCompat of(int r2, List<Certificate> r3, byte[] r4) {
            return new KeyManagerResultCompat(false, r2, r3, r4);
        }

        public boolean isNull() {
            return this.isNull;
        }

        public int getResultCode() {
            return this.resultCode;
        }

        public List<Certificate> getCertChain() {
            return this.certChain;
        }

        public byte[] getOutData() {
            return this.outData;
        }
    }

    private static final class ObricImpl implements Impl {
        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestAppIdKey() {
            return "attest_appid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestCustomInfoKey() {
            return "attest_custom_info";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestPrdidKey() {
            return "attest_rpdid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestPruidKey() {
            return "attest_rpuid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String attestUdidKey() {
            return "attest_udid";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String basePkg() {
            return "com.obric.security";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String challengeKey() {
            return "challenge";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String deviceHealthStatusRequiredKey() {
            return "device_health_status_required";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String keyAlgoKey() {
            return "key_algorithm";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int keyAlgorithmEcc() {
            return 2;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String keyLenKey() {
            return "key_length";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String keyPurposeKey() {
            return "key_purpose";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int kmSuccess() {
            return 0;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int maxAttestationCustomInfoLen() {
            return 1024;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int maxKeyAliasLen() {
            return 128;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int purposeAttestKey() {
            return 64;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int purposeSign() {
            return 4;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int queryModeIfDataExist() {
            return 0;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int queryModePreciseQueryAndDecrypt() {
            return 2;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public String secretBundleKeyQueryMode() {
            return "query_mode";
        }

        private ObricImpl() {
        }

        /* synthetic */ ObricImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int generateKeyPair(Context r1, String r2, Bundle r3) {
            return com.obric.security.keymanager.KeyManager.getInstance().generateKeyPair(r1, r2, r3);
        L4:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "generateKeyPair failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int deleteKey(Context r1, String r2, Bundle r3) {
            return com.obric.security.keymanager.KeyManager.getInstance().deleteKey(r1, r2, r3);
        L4:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "deleteKey failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public KeyManagerResultCompat keyAttestation(Context r1, String r2, Bundle r3) {
            com.obric.security.keymanager.KeyManagerResult r0 = com.obric.security.keymanager.KeyManager.getInstance().keyAttestation(r1, r2, r3);     // Catch: Throwable -> L8
            if (r0 != null) goto L7;
            return KeyManagerResultCompat.nullResult();
        L7:
            return KeyManagerResultCompat.of(r0.getResultCode(), r0.getCertChain(), r0.getOutData());
        L8:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "keyAttestation failed", th);
            return KeyManagerResultCompat.nullResult();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public KeyManagerResultCompat sign(Context r1, String r2, byte[] r3, Bundle r4) {
            com.obric.security.keymanager.KeyManagerResult r0 = com.obric.security.keymanager.KeyManager.getInstance().sign(r1, r2, r3, r4);     // Catch: Throwable -> L8
            if (r0 != null) goto L7;
            return KeyManagerResultCompat.nullResult();
        L7:
            return KeyManagerResultCompat.of(r0.getResultCode(), r0.getCertChain(), r0.getOutData());
        L8:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "sign failed", th);
            return KeyManagerResultCompat.nullResult();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public SecretQueryResult querySecretData(Context r1, String r2, Bundle r3) {
            com.obric.security.secretdata.QueryResult r0 = com.obric.security.secretdata.SecretDataManager.getInstance().queryData(r1, r2, r3);     // Catch: Throwable -> L16
            if (r0 == null) goto L5;
            List r4 = r0.getDataList();     // Catch: Throwable -> L16
            if (r4 != null) goto L9;
        L13:
            String r5 = null;
        L15:
            return SecretQueryResult.of(r0.getResultCode(), r5);
        L9:
            if (r4.isEmpty() == true) goto L13;
            com.obric.security.secretdata.SecretData r6 = (com.obric.security.secretdata.SecretData) r4.get(0);     // Catch: Throwable -> L16
            if (r6 == null) goto L13;
            r5 = r6.privateData;     // Catch: Throwable -> L16
            goto L15
        L5:
            return SecretQueryResult.nullResult();
        L16:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "SecretDataManager.queryData failed", th);
            return SecretQueryResult.nullResult();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int addSecretData(Context r2, String r3, String r4, String r5, String r6, Bundle r7) {
            com.obric.security.secretdata.SecretData r0 = new com.obric.security.secretdata.SecretData();     // Catch: Throwable -> L7
            r0.privateData = r3;     // Catch: Throwable -> L7
            r0.associate = r4;     // Catch: Throwable -> L7
            r0.alias = r5;     // Catch: Throwable -> L7
            r0.dataType = r6;     // Catch: Throwable -> L7
            com.obric.security.secretdata.AddResult r8 = com.obric.security.secretdata.SecretDataManager.getInstance().addData(r2, r0, r7);     // Catch: Throwable -> L7
            if (r8 == null) goto L12;
            return r8.getResultCode();
        L12:
            return -1;
        L7:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "SecretDataManager.addData failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public int deleteSecretData(Context r1, String r2, Bundle r3) {
            return com.obric.security.secretdata.SecretDataManager.getInstance().deleteData(r1, r2, r3);
        L4:
            th = move-exception;
            LogUtils.e(SecurityFrameworkCompat.TAG, "SecretDataManager.deleteData failed", th);
            return -1;
        }
    }

    public static final class SecretQueryResult {
        private final String firstPrivateData;
        private final boolean isNull;
        private final int resultCode;

        private SecretQueryResult(boolean r1, int r2, String r3) {
            this.isNull = r1;
            this.resultCode = r2;
            this.firstPrivateData = r3;
        }

        static SecretQueryResult nullResult() {
            return new SecretQueryResult(true, -1, null);
        }

        static SecretQueryResult of(int r2, String r3) {
            return new SecretQueryResult(false, r2, r3);
        }

        public boolean isNull() {
            return this.isNull;
        }

        public int getResultCode() {
            return this.resultCode;
        }

        public String getFirstPrivateData() {
            return this.firstPrivateData;
        }
    }

    private SecurityFrameworkCompat() {
    }

    private static Impl impl() {
        Impl r1 = sImpl;
        if (r1 == null) goto L6;
        return r1;
    L6:
        monitor-enter(SecurityFrameworkCompat.class);
        Impl r2 = sImpl;     // Catch: Throwable -> L21
        if (r2 == null) goto L11;
        monitor-exit(SecurityFrameworkCompat.class);     // Catch: Throwable -> L21
        return r2;
    L11:
        boolean r3 = hasFrameworkClass(CLASS_OBRIC_SDM);     // Catch: Throwable -> L21
        boolean r4 = hasFrameworkClass(CLASS_AIASSISTANT_SDM);     // Catch: Throwable -> L21
        AnonymousClass1 r5 = null;
        if (r3 == false) goto L14;
        Impl r6 = new ObricImpl(r5);     // Catch: Throwable -> L21
    L16:
        sImpl = r6;     // Catch: Throwable -> L21
        LogUtils.i(TAG, "Using security framework package: " + r6.basePkg());     // Catch: Throwable -> L21
        monitor-exit(SecurityFrameworkCompat.class);     // Catch: Throwable -> L21
        return r6;
    L14:
        if (r4 == false) goto L19;
        r6 = new AiassistantImpl(r5);     // Catch: Throwable -> L21
        goto L16
    L19:
        LogUtils.e(TAG, "No supported security framework found. Tried: com.obric.security.secretdata.SecretDataManager, com.aiassistant.security.secretdata.SecretDataManager");     // Catch: Throwable -> L21
        throw new IllegalStateException("No supported security framework found. Tried: com.obric.security.secretdata.SecretDataManager, com.aiassistant.security.secretdata.SecretDataManager");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    private static boolean hasFrameworkClass(String r3) {
        Class.forName(r3, false, null);     // Catch: ClassNotFoundException -> L6
        return true;
    L6:
        e = move-exception;
        LogUtils.e(TAG, "Class not found:" + e);
        return false;
    }

    public static String keyAlgoKey() {
        return impl().keyAlgoKey();
    }

    public static String keyLenKey() {
        return impl().keyLenKey();
    }

    public static String keyPurposeKey() {
        return impl().keyPurposeKey();
    }

    public static int keyAlgorithmEcc() {
        return impl().keyAlgorithmEcc();
    }

    public static int purposeAttestKey() {
        return impl().purposeAttestKey();
    }

    public static int purposeSign() {
        return impl().purposeSign();
    }

    public static String challengeKey() {
        return impl().challengeKey();
    }

    public static String deviceHealthStatusRequiredKey() {
        return impl().deviceHealthStatusRequiredKey();
    }

    public static String attestAppIdKey() {
        return impl().attestAppIdKey();
    }

    public static String attestPrdidKey() {
        return impl().attestPrdidKey();
    }

    public static String attestPruidKey() {
        return impl().attestPruidKey();
    }

    public static String attestUdidKey() {
        return impl().attestUdidKey();
    }

    public static String attestCustomInfoKey() {
        return impl().attestCustomInfoKey();
    }

    public static int maxKeyAliasLen() {
        return impl().maxKeyAliasLen();
    }

    public static int maxAttestationCustomInfoLen() {
        return impl().maxAttestationCustomInfoLen();
    }

    public static int kmSuccess() {
        return impl().kmSuccess();
    }

    public static int generateKeyPair(Context r1, String r2, Bundle r3) {
        return impl().generateKeyPair(r1, r2, r3);
    }

    public static int deleteKey(Context r1, String r2, Bundle r3) {
        return impl().deleteKey(r1, r2, r3);
    }

    public static KeyManagerResultCompat keyAttestation(Context r1, String r2, Bundle r3) {
        return impl().keyAttestation(r1, r2, r3);
    }

    public static KeyManagerResultCompat sign(Context r1, String r2, byte[] r3, Bundle r4) {
        return impl().sign(r1, r2, r3, r4);
    }

    public static String secretBundleKeyQueryMode() {
        return impl().secretBundleKeyQueryMode();
    }

    public static int queryModeIfDataExist() {
        return impl().queryModeIfDataExist();
    }

    public static int queryModePreciseQueryAndDecrypt() {
        return impl().queryModePreciseQueryAndDecrypt();
    }

    public static SecretQueryResult querySecretData(Context r1, String r2, Bundle r3) {
        return impl().querySecretData(r1, r2, r3);
    }

    public static int addSecretData(Context r7, String r8, String r9, String r10, String r11, Bundle r12) {
        return impl().addSecretData(r7, r8, r9, r10, r11, r12);
    }

    public static int deleteSecretData(Context r1, String r2, Bundle r3) {
        return impl().deleteSecretData(r1, r2, r3);
    }
}

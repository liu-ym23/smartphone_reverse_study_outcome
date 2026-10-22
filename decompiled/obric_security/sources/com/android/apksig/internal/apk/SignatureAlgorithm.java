package com.android.apksig.internal.apk;

import com.android.apksig.internal.util.Pair;
import com.bytedance.privacy.utils.PrivacyConst;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

/* JADX INFO: loaded from: classes.dex */
public final enum SignatureAlgorithm extends Enum<SignatureAlgorithm> {
    private static final /* synthetic */ SignatureAlgorithm[] $VALUES = null;
    public static final SignatureAlgorithm DSA_WITH_SHA256 = null;
    public static final SignatureAlgorithm ECDSA_WITH_SHA256 = null;
    public static final SignatureAlgorithm ECDSA_WITH_SHA512 = null;
    public static final SignatureAlgorithm RSA_PKCS1_V1_5_WITH_SHA256 = null;
    public static final SignatureAlgorithm RSA_PKCS1_V1_5_WITH_SHA512 = null;
    public static final SignatureAlgorithm RSA_PSS_WITH_SHA256 = null;
    public static final SignatureAlgorithm RSA_PSS_WITH_SHA512 = null;
    public static final SignatureAlgorithm VERITY_DSA_WITH_SHA256 = null;
    public static final SignatureAlgorithm VERITY_ECDSA_WITH_SHA256 = null;
    public static final SignatureAlgorithm VERITY_RSA_PKCS1_V1_5_WITH_SHA256 = null;
    private final ContentDigestAlgorithm mContentDigestAlgorithm;
    private final int mId;
    private final String mJcaKeyAlgorithm;
    private final int mJcaSigAlgMinSdkVersion;
    private final Pair<String, ? extends AlgorithmParameterSpec> mJcaSignatureAlgAndParams;
    private final int mMinSdkVersion;

    static {
        ContentDigestAlgorithm r10 = ContentDigestAlgorithm.CHUNKED_SHA256;
        SignatureAlgorithm r9 = new SignatureAlgorithm("RSA_PSS_WITH_SHA256", 0, 257, r10, "RSA", Pair.of("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1)), 24, 23);
        RSA_PSS_WITH_SHA256 = r9;
        ContentDigestAlgorithm r21 = ContentDigestAlgorithm.CHUNKED_SHA512;
        SignatureAlgorithm r20 = new SignatureAlgorithm("RSA_PSS_WITH_SHA512", 1, 258, r21, "RSA", Pair.of("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1)), 24, 23);
        RSA_PSS_WITH_SHA512 = r20;
        SignatureAlgorithm r11 = new SignatureAlgorithm("RSA_PKCS1_V1_5_WITH_SHA256", 2, 259, r10, "RSA", Pair.of("SHA256withRSA", null), 24, 1);
        RSA_PKCS1_V1_5_WITH_SHA256 = r11;
        SignatureAlgorithm r14 = new SignatureAlgorithm("RSA_PKCS1_V1_5_WITH_SHA512", 3, 260, r21, "RSA", Pair.of("SHA512withRSA", null), 24, 1);
        RSA_PKCS1_V1_5_WITH_SHA512 = r14;
        SignatureAlgorithm r15 = new SignatureAlgorithm("ECDSA_WITH_SHA256", 4, 513, r10, PrivacyConst.ALGORITHM_EC, Pair.of("SHA256withECDSA", null), 24, 11);
        ECDSA_WITH_SHA256 = r15;
        SignatureAlgorithm r16 = new SignatureAlgorithm("ECDSA_WITH_SHA512", 5, 514, r21, PrivacyConst.ALGORITHM_EC, Pair.of("SHA512withECDSA", null), 24, 11);
        ECDSA_WITH_SHA512 = r16;
        SignatureAlgorithm r17 = new SignatureAlgorithm("DSA_WITH_SHA256", 6, 769, r10, "DSA", Pair.of("SHA256withDSA", null), 24, 1);
        DSA_WITH_SHA256 = r17;
        ContentDigestAlgorithm r1 = ContentDigestAlgorithm.VERITY_CHUNKED_SHA256;
        SignatureAlgorithm r0 = new SignatureAlgorithm("VERITY_RSA_PKCS1_V1_5_WITH_SHA256", 7, 1057, r1, "RSA", Pair.of("SHA256withRSA", null), 28, 1);
        VERITY_RSA_PKCS1_V1_5_WITH_SHA256 = r0;
        SignatureAlgorithm r2 = new SignatureAlgorithm("VERITY_ECDSA_WITH_SHA256", 8, 1059, r1, PrivacyConst.ALGORITHM_EC, Pair.of("SHA256withECDSA", null), 28, 11);
        VERITY_ECDSA_WITH_SHA256 = r2;
        SignatureAlgorithm r3 = new SignatureAlgorithm("VERITY_DSA_WITH_SHA256", 9, 1061, r1, "DSA", Pair.of("SHA256withDSA", null), 28, 1);
        VERITY_DSA_WITH_SHA256 = r3;
        $VALUES = new SignatureAlgorithm[]{r9, r20, r11, r14, r15, r16, r17, r0, r2, r3};
    }

    private SignatureAlgorithm(String r1, int r2, int r3, ContentDigestAlgorithm r4, String r5, Pair r6, int r7, int r8) {
        super(r1, r2);
        this.mId = r3;
        this.mContentDigestAlgorithm = r4;
        this.mJcaKeyAlgorithm = r5;
        this.mJcaSignatureAlgAndParams = r6;
        this.mMinSdkVersion = r7;
        this.mJcaSigAlgMinSdkVersion = r8;
    }

    public static SignatureAlgorithm findById(int r5) {
        SignatureAlgorithm[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        SignatureAlgorithm r3 = r0[r2];
        if (r3.getId() == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static SignatureAlgorithm valueOf(String r1) {
        return (SignatureAlgorithm) Enum.valueOf(SignatureAlgorithm.class, r1);
    }

    public static SignatureAlgorithm[] values() {
        return (SignatureAlgorithm[]) $VALUES.clone();
    }

    public ContentDigestAlgorithm getContentDigestAlgorithm() {
        return this.mContentDigestAlgorithm;
    }

    public int getId() {
        return this.mId;
    }

    public String getJcaKeyAlgorithm() {
        return this.mJcaKeyAlgorithm;
    }

    public int getJcaSigAlgMinSdkVersion() {
        return this.mJcaSigAlgMinSdkVersion;
    }

    public Pair<String, ? extends AlgorithmParameterSpec> getJcaSignatureAlgorithmAndParams() {
        return this.mJcaSignatureAlgAndParams;
    }

    public int getMinSdkVersion() {
        return this.mMinSdkVersion;
    }
}

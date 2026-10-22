package com.android.apksig.internal.apk.v3;

import com.android.apksig.ApkVerifier;
import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.apk.ApkUtils;
import com.android.apksig.internal.apk.ApkSigningBlockUtils;
import com.android.apksig.internal.apk.ContentDigestAlgorithm;
import com.android.apksig.internal.apk.SignatureAlgorithm;
import com.android.apksig.internal.apk.SignatureInfo;
import com.android.apksig.internal.util.ByteBufferUtils;
import com.android.apksig.internal.util.GuaranteedEncodedFormX509Certificate;
import com.android.apksig.internal.util.X509CertificateUtils;
import com.android.apksig.util.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class V3SchemeVerifier {
    private V3SchemeVerifier() {
    }

    private static void parseSigner(ByteBuffer r15, CertificateFactory r16, ApkSigningBlockUtils.Result.SignerInfo r17, Set<ContentDigestAlgorithm> r18) throws ApkFormatException, NoSuchAlgorithmException {
        ByteBuffer r0 = ApkSigningBlockUtils.getLengthPrefixedSlice(r15);
        byte[] r2 = new byte[r0.remaining()];
        r0.get(r2);
        r0.flip();
        r17.signedData = r2;
        int r3 = r15.getInt();
        int r4 = r15.getInt();
        r17.minSdkVersion = r3;
        r17.maxSdkVersion = r4;
        if (r3 < 0) goto L5;
        if (r3 > r4) goto L5;
    L6:
        ByteBuffer r7 = ApkSigningBlockUtils.getLengthPrefixedSlice(r15);
        byte[] r8 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r15);
        ArrayList r9 = new ArrayList(1);
        int r10 = 0;
    L8:
        if (r7.hasRemaining() == false) goto L18;
        r10 = r10 + 1;
        ByteBuffer r11 = ApkSigningBlockUtils.getLengthPrefixedSlice(r7);     // Catch: Throwable -> L15
        int r12 = r11.getInt();     // Catch: Throwable -> L15
        byte[] r13 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r11);     // Catch: Throwable -> L15
        r17.signatures.add(new ApkSigningBlockUtils.Result.SignerInfo.Signature(r12, r13));     // Catch: Throwable -> L15
        SignatureAlgorithm r14 = SignatureAlgorithm.findById(r12);     // Catch: Throwable -> L15
        if (r14 == null) goto L12;
        r9.add(new ApkSigningBlockUtils.SupportedSignature(r14, r13));     // Catch: Throwable -> L15
        goto L8
    L12:
        r17.addWarning(ApkVerifier.Issue.V3_SIG_UNKNOWN_SIG_ALGORITHM, new Object[]{Integer.valueOf(r12)});     // Catch: Throwable -> L15
    L15:
        r17.addError(ApkVerifier.Issue.V3_SIG_MALFORMED_SIGNATURE, new Object[]{Integer.valueOf(r10)});
        return;
    L18:
        if (r17.signatures.isEmpty() == false) goto L115;
        r17.addError(ApkVerifier.Issue.V3_SIG_NO_SIGNATURES, new Object[0]);
        return;
    L115:
        Iterator r19 = ApkSigningBlockUtils.getSignaturesToVerify(r9, r17.minSdkVersion, r17.maxSdkVersion).iterator();
    L24:
        if (r19.hasNext() == false) goto L42;
        ApkSigningBlockUtils.SupportedSignature r20 = (ApkSigningBlockUtils.SupportedSignature) r19.next();
        SignatureAlgorithm r110 = r20.algorithm;
        String r111 = r110.getJcaSignatureAlgorithmAndParams().getFirst();
        AlgorithmParameterSpec r112 = r110.getJcaSignatureAlgorithmAndParams().getSecond();
        PublicKey r113 = KeyFactory.getInstance(r110.getJcaKeyAlgorithm()).generatePublic(new X509EncodedKeySpec(r8));     // Catch: Exception -> L39
        Signature r114 = Signature.getInstance(r111);     // Catch: Throwable -> L36
        r114.initVerify(r113);     // Catch: Throwable -> L36
        if (r112 == null) goto L30;
        r114.setParameter(r112);     // Catch: Throwable -> L36
    L30:
        r0.position(0);     // Catch: Throwable -> L36
        r114.update(r0);     // Catch: Throwable -> L36
        byte[] r21 = r20.signature;     // Catch: Throwable -> L36
        if (r114.verify(r21) == false) goto L32;
        r17.verifiedSignatures.put(r110, r21);     // Catch: Throwable -> L36
        r18.add(r110.getContentDigestAlgorithm());     // Catch: Throwable -> L36
        goto L24
    L32:
        r17.addError(ApkVerifier.Issue.V3_SIG_DID_NOT_VERIFY, new Object[]{r110});     // Catch: Throwable -> L36
        return;
    L36:
        e = move-exception;
        r17.addError(ApkVerifier.Issue.V3_SIG_VERIFY_EXCEPTION, new Object[]{r110, e});
        return;
    L39:
        e = move-exception;
        r17.addError(ApkVerifier.Issue.V3_SIG_MALFORMED_PUBLIC_KEY, new Object[]{e});
        return;
    L42:
        r0.position(0);
        ByteBuffer r22 = ApkSigningBlockUtils.getLengthPrefixedSlice(r0);
        ByteBuffer r23 = ApkSigningBlockUtils.getLengthPrefixedSlice(r0);
        int r115 = r0.getInt();
        if (r115 == r3) goto L45;
        r17.addError(ApkVerifier.Issue.V3_MIN_SDK_VERSION_MISMATCH_BETWEEN_SIGNER_AND_SIGNED_DATA_RECORD, new Object[]{Integer.valueOf(r3), Integer.valueOf(r115)});
    L45:
        int r5 = r0.getInt();
        if (r5 == r4) goto L48;
        r17.addError(ApkVerifier.Issue.V3_MAX_SDK_VERSION_MISMATCH_BETWEEN_SIGNER_AND_SIGNED_DATA_RECORD, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)});
    L48:
        ByteBuffer r6 = ApkSigningBlockUtils.getLengthPrefixedSlice(r0);
        int r24 = -1;
    L50:
        if (r23.hasRemaining() == false) goto L58;
        int r116 = r24 + 1;
        byte[] r1 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r23);
        r17.certs.add(new GuaranteedEncodedFormX509Certificate(X509CertificateUtils.generateCertificate(r1, r16), r1));
        r24 = r116;
    L54:
        e = move-exception;
        r17.addError(ApkVerifier.Issue.V3_SIG_MALFORMED_CERTIFICATE, new Object[]{Integer.valueOf(r116), Integer.valueOf(r24 + 2), e});
        return;
    L58:
        if (r17.certs.isEmpty() == false) goto L61;
        r17.addError(ApkVerifier.Issue.V3_SIG_NO_CERTIFICATES, new Object[0]);
        return;
    L61:
        X509Certificate r25 = r17.certs.get(0);
        byte[] r26 = ApkSigningBlockUtils.encodePublicKey(r25.getPublicKey());     // Catch: InvalidKeyException -> L64
    L67:
        if (Arrays.equals(r8, r26) == true) goto L70;
        r17.addError(ApkVerifier.Issue.V3_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD, new Object[]{ApkSigningBlockUtils.toHex(r26), ApkSigningBlockUtils.toHex(r8)});
        return;
    L70:
        int r27 = 0;
    L72:
        if (r22.hasRemaining() == false) goto L80;
        r27 = r27 + 1;
        ByteBuffer r28 = ApkSigningBlockUtils.getLengthPrefixedSlice(r22);     // Catch: IllegalArgumentException -> L76 Throwable -> L78
        r17.contentDigests.add(new ApkSigningBlockUtils.Result.SignerInfo.ContentDigest(r28.getInt(), ApkSigningBlockUtils.readLengthPrefixedByteArray(r28)));     // Catch: IllegalArgumentException -> L76 Throwable -> L78
    L78:
        r17.addError(ApkVerifier.Issue.V3_SIG_MALFORMED_DIGEST, new Object[]{Integer.valueOf(r27)});
        return;
    L76:
        System.err.println("(--NOTE--)IllegalArgumentException(\"V3 Negative length\")");
        r17.addError(ApkVerifier.Issue.V3_SIG_NEGATIVE_LEN, new Object[0]);
        return;
    L80:
        ArrayList r29 = new ArrayList(r17.signatures.size());
        Iterator<ApkSigningBlockUtils.Result.SignerInfo.Signature> r30 = r17.signatures.iterator();
    L82:
        if (r30.hasNext() == false) goto L84;
        r29.add(Integer.valueOf(r30.next().getAlgorithmId()));
        goto L82
    L84:
        ArrayList r31 = new ArrayList(r17.contentDigests.size());
        Iterator<ApkSigningBlockUtils.Result.SignerInfo.ContentDigest> r32 = r17.contentDigests.iterator();
    L86:
        if (r32.hasNext() == false) goto L89;
        r31.add(Integer.valueOf(r32.next().getSignatureAlgorithmId()));
        goto L86
    L89:
        if (r29.equals(r31) == true) goto L92;
        r17.addError(ApkVerifier.Issue.V3_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS, new Object[]{r29, r31});
        return;
    L92:
        int r33 = 0;
    L94:
        if (r6.hasRemaining() == false) goto L142;
        r33 = r33 + 1;
        ByteBuffer r34 = ApkSigningBlockUtils.getLengthPrefixedSlice(r6);     // Catch: IllegalArgumentException -> L101 Throwable -> L103
        int r35 = r34.getInt();     // Catch: IllegalArgumentException -> L101 Throwable -> L103
        r17.additionalAttributes.add(new ApkSigningBlockUtils.Result.SignerInfo.AdditionalAttribute(r35, ByteBufferUtils.toByteArray(r34)));     // Catch: IllegalArgumentException -> L101 Throwable -> L103
        if (r35 == 1000370060) goto L94;
        r17.addWarning(ApkVerifier.Issue.V3_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE, new Object[]{Integer.valueOf(r35)});     // Catch: IllegalArgumentException -> L101 Throwable -> L103
    L103:
        r17.addError(ApkVerifier.Issue.V3_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE, new Object[]{Integer.valueOf(r33)});
        return;
    L101:
        System.err.println("(--NOTE--)IllegalArgumentException(\"V3 Negative length\")");
        r17.addError(ApkVerifier.Issue.V3_SIG_NEGATIVE_LEN, new Object[0]);
        return;
    L142:
        return;
    L64:
        e = move-exception;
        System.out.println("Caught an exception encoding the public key: " + e);
        e.printStackTrace();
        r26 = r25.getPublicKey().getEncoded();
    L105:
        r17.addError(ApkVerifier.Issue.V3_SIG_NO_SUPPORTED_SIGNATURES, new Object[0]);
        return;
    L5:
        r17.addError(ApkVerifier.Issue.V3_SIG_INVALID_SDK_VERSIONS, new Object[]{Integer.valueOf(r3), Integer.valueOf(r4)});
        goto L6
    }

    public static void parseSigners(ByteBuffer r6, Set<ContentDigestAlgorithm> r7, ApkSigningBlockUtils.Result r8) throws NoSuchAlgorithmException {
        ByteBuffer r9 = ApkSigningBlockUtils.getLengthPrefixedSlice(r6);     // Catch: IllegalArgumentException -> L22 ApkFormatException -> L24
    L5:
        if (r9.hasRemaining() == true) goto L26;
        r8.addError(ApkVerifier.Issue.V3_SIG_NO_SIGNERS, new Object[0]);
        return;
    L26:
        CertificateFactory r2 = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L19
        int r3 = 0;
    L11:
        if (r9.hasRemaining() == false) goto L33;
        int r4 = r3 + 1;
        ApkSigningBlockUtils.Result.SignerInfo r5 = new ApkSigningBlockUtils.Result.SignerInfo();
        r5.index = r3;
        r8.signers.add(r5);
        parseSigner(ApkSigningBlockUtils.getLengthPrefixedSlice(r9), r2, r5, r7);     // Catch: IllegalArgumentException -> L15 Throwable -> L17
        r3 = r4;
        goto L11
    L17:
        r5.addError(ApkVerifier.Issue.V3_SIG_MALFORMED_SIGNER, new Object[0]);
        return;
    L15:
        System.err.println("(--NOTE--)IllegalArgumentException(\"V3 Negative length\")");
        r5.addError(ApkVerifier.Issue.V3_SIG_NEGATIVE_LEN, new Object[0]);
        return;
    L33:
        return;
    L19:
        e = move-exception;
        throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e);
    L24:
        r8.addError(ApkVerifier.Issue.V3_SIG_MALFORMED_SIGNERS, new Object[0]);
        return;
    L22:
        System.err.println("(--NOTE--)IllegalArgumentException(\"V3 Negative length\")");
        r8.addError(ApkVerifier.Issue.V3_SIG_NEGATIVE_LEN, new Object[0]);
    }

    public static ApkSigningBlockUtils.Result verify(DataSource r1, ApkUtils.ZipSections r2, int r3, int r4) throws IOException, NoSuchAlgorithmException, ApkSigningBlockUtils.SignatureNotFoundException {
        ApkSigningBlockUtils.Result r0 = new ApkSigningBlockUtils.Result(r3);
        SignatureInfo r5 = ApkSigningBlockUtils.findSignature(r1, r2, r4, r0);
        HashSet r6 = new HashSet(1);
        parseSigners(r5.signatureBlock, r6, r0);
        r0.verified = true;
        return r0;
    }
}

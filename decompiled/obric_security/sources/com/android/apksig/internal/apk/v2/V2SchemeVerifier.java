package com.android.apksig.internal.apk.v2;

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
import java.nio.ByteOrder;
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
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class V2SchemeVerifier {
    private V2SchemeVerifier() {
    }

    private static void parseSigner(ByteBuffer r14, CertificateFactory r15, ApkSigningBlockUtils.Result.SignerInfo r16, Set<ContentDigestAlgorithm> r17, Map<Integer, String> r18, Set<Integer> r19, int r20, int r21) throws ApkFormatException, NoSuchAlgorithmException {
        ByteBuffer r0 = ApkSigningBlockUtils.getLengthPrefixedSlice(r14);
        byte[] r2 = new byte[r0.remaining()];
        r0.get(r2);
        r0.flip();
        r16.signedData = r2;
        ByteBuffer r3 = ApkSigningBlockUtils.getLengthPrefixedSlice(r14);
        byte[] r4 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r14);
        ArrayList r5 = new ArrayList(1);
        int r7 = 0;
    L4:
        if (r3.hasRemaining() == false) goto L16;
        r7 = r7 + 1;
        ByteBuffer r8 = ApkSigningBlockUtils.getLengthPrefixedSlice(r3);     // Catch: IllegalArgumentException -> L11 Throwable -> L13
        int r10 = r8.getInt();     // Catch: IllegalArgumentException -> L11 Throwable -> L13
        byte[] r9 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r8);     // Catch: IllegalArgumentException -> L11 Throwable -> L13
        r16.signatures.add(new ApkSigningBlockUtils.Result.SignerInfo.Signature(r10, r9));     // Catch: IllegalArgumentException -> L11 Throwable -> L13
        SignatureAlgorithm r11 = SignatureAlgorithm.findById(r10);     // Catch: IllegalArgumentException -> L11 Throwable -> L13
        if (r11 == null) goto L8;
        r5.add(new ApkSigningBlockUtils.SupportedSignature(r11, r9));     // Catch: IllegalArgumentException -> L11 Throwable -> L13
        goto L4
    L8:
        r16.addWarning(ApkVerifier.Issue.V2_SIG_UNKNOWN_SIG_ALGORITHM, new Object[]{Integer.valueOf(r10)});     // Catch: IllegalArgumentException -> L11 Throwable -> L13
        goto L4
    L13:
        r16.addError(ApkVerifier.Issue.V2_SIG_MALFORMED_SIGNATURE, new Object[]{Integer.valueOf(r7)});
        return;
    L11:
        System.err.println("(--NOTE--)IllegalArgumentException(\"V2 Negative length\")");
        r16.addError(ApkVerifier.Issue.V2_SIG_NEGATIVE_LEN, new Object[0]);
        return;
    L16:
        if (r16.signatures.isEmpty() == false) goto L114;
        r16.addError(ApkVerifier.Issue.V2_SIG_NO_SIGNATURES, new Object[0]);
        return;
    L114:
        Iterator r6 = ApkSigningBlockUtils.getSignaturesToVerify(r5, r20, r21).iterator();
    L23:
        if (r6.hasNext() == false) goto L41;
        ApkSigningBlockUtils.SupportedSignature r12 = (ApkSigningBlockUtils.SupportedSignature) r6.next();
        SignatureAlgorithm r13 = r12.algorithm;
        String r110 = r13.getJcaSignatureAlgorithmAndParams().getFirst();
        AlgorithmParameterSpec r111 = r13.getJcaSignatureAlgorithmAndParams().getSecond();
        PublicKey r112 = KeyFactory.getInstance(r13.getJcaKeyAlgorithm()).generatePublic(new X509EncodedKeySpec(r4));     // Catch: Exception -> L38
        Signature r113 = Signature.getInstance(r110);     // Catch: Throwable -> L35
        r113.initVerify(r112);     // Catch: Throwable -> L35
        if (r111 == null) goto L29;
        r113.setParameter(r111);     // Catch: Throwable -> L35
    L29:
        r0.position(0);     // Catch: Throwable -> L35
        r113.update(r0);     // Catch: Throwable -> L35
        byte[] r22 = r12.signature;     // Catch: Throwable -> L35
        if (r113.verify(r22) == false) goto L31;
        r16.verifiedSignatures.put(r13, r22);     // Catch: Throwable -> L35
        r17.add(r13.getContentDigestAlgorithm());     // Catch: Throwable -> L35
        goto L23
    L31:
        r16.addError(ApkVerifier.Issue.V2_SIG_DID_NOT_VERIFY, new Object[]{r13});     // Catch: Throwable -> L35
        return;
    L35:
        e = move-exception;
        r16.addError(ApkVerifier.Issue.V2_SIG_VERIFY_EXCEPTION, new Object[]{r13, e});
        return;
    L38:
        e = move-exception;
        r16.addError(ApkVerifier.Issue.V2_SIG_MALFORMED_PUBLIC_KEY, new Object[]{e});
        return;
    L41:
        r0.position(0);
        ByteBuffer r23 = ApkSigningBlockUtils.getLengthPrefixedSlice(r0);
        ByteBuffer r24 = ApkSigningBlockUtils.getLengthPrefixedSlice(r0);
        ByteBuffer r25 = ApkSigningBlockUtils.getLengthPrefixedSlice(r0);
        int r114 = -1;
    L43:
        if (r24.hasRemaining() == false) goto L51;
        int r115 = r114 + 1;
        byte[] r1 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r24);
        r16.certs.add(new GuaranteedEncodedFormX509Certificate(X509CertificateUtils.generateCertificate(r1, r15), r1));
        r114 = r115;
    L47:
        e = move-exception;
        r16.addError(ApkVerifier.Issue.V2_SIG_MALFORMED_CERTIFICATE, new Object[]{Integer.valueOf(r115), Integer.valueOf(r114 + 2), e});
        return;
    L51:
        if (r16.certs.isEmpty() == false) goto L54;
        r16.addError(ApkVerifier.Issue.V2_SIG_NO_CERTIFICATES, new Object[0]);
        return;
    L54:
        X509Certificate r26 = r16.certs.get(0);
        byte[] r27 = ApkSigningBlockUtils.encodePublicKey(r26.getPublicKey());     // Catch: InvalidKeyException -> L57
    L60:
        if (Arrays.equals(r4, r27) == true) goto L63;
        r16.addError(ApkVerifier.Issue.V2_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD, new Object[]{ApkSigningBlockUtils.toHex(r27), ApkSigningBlockUtils.toHex(r4)});
        return;
    L63:
        int r28 = 0;
    L65:
        if (r23.hasRemaining() == false) goto L73;
        r28 = r28 + 1;
        ByteBuffer r29 = ApkSigningBlockUtils.getLengthPrefixedSlice(r23);     // Catch: IllegalArgumentException -> L69 Throwable -> L71
        r16.contentDigests.add(new ApkSigningBlockUtils.Result.SignerInfo.ContentDigest(r29.getInt(), ApkSigningBlockUtils.readLengthPrefixedByteArray(r29)));     // Catch: IllegalArgumentException -> L69 Throwable -> L71
    L71:
        r16.addError(ApkVerifier.Issue.V2_SIG_MALFORMED_DIGEST, new Object[]{Integer.valueOf(r28)});
        return;
    L69:
        System.err.println("(--NOTE--)IllegalArgumentException(\"V2 Negative length\")");
        r16.addError(ApkVerifier.Issue.V2_SIG_NEGATIVE_LEN, new Object[0]);
        return;
    L73:
        ArrayList r30 = new ArrayList(r16.signatures.size());
        Iterator<ApkSigningBlockUtils.Result.SignerInfo.Signature> r31 = r16.signatures.iterator();
    L75:
        if (r31.hasNext() == false) goto L77;
        r30.add(Integer.valueOf(r31.next().getAlgorithmId()));
        goto L75
    L77:
        ArrayList r32 = new ArrayList(r16.contentDigests.size());
        Iterator<ApkSigningBlockUtils.Result.SignerInfo.ContentDigest> r33 = r16.contentDigests.iterator();
    L79:
        if (r33.hasNext() == false) goto L82;
        r32.add(Integer.valueOf(r33.next().getSignatureAlgorithmId()));
        goto L79
    L82:
        if (r30.equals(r32) == true) goto L85;
        r16.addError(ApkVerifier.Issue.V2_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS, new Object[]{r30, r32});
        return;
    L85:
        Set<Integer> r34 = r18.keySet();
        HashSet r35 = new HashSet(1);
        int r36 = 0;
    L87:
        if (r25.hasRemaining() == false) goto L101;
        r36 = r36 + 1;
        ByteBuffer r37 = ApkSigningBlockUtils.getLengthPrefixedSlice(r25);     // Catch: IllegalArgumentException -> L97 Throwable -> L99
        int r116 = r37.getInt();     // Catch: IllegalArgumentException -> L97 Throwable -> L99
        byte[] r38 = ByteBufferUtils.toByteArray(r37);     // Catch: IllegalArgumentException -> L97 Throwable -> L99
        r16.additionalAttributes.add(new ApkSigningBlockUtils.Result.SignerInfo.AdditionalAttribute(r116, r38));     // Catch: IllegalArgumentException -> L97 Throwable -> L99
        if (r116 != (-1091571699)) goto L91;
        int r39 = ByteBuffer.wrap(r38).order(ByteOrder.LITTLE_ENDIAN).getInt();     // Catch: IllegalArgumentException -> L97 Throwable -> L99
        if (r34.contains(Integer.valueOf(r39)) == true) goto L94;
        r16.addWarning(ApkVerifier.Issue.V2_SIG_UNKNOWN_APK_SIG_SCHEME_ID, new Object[]{Integer.valueOf(r16.index), Integer.valueOf(r39)});     // Catch: IllegalArgumentException -> L97 Throwable -> L99
        goto L87
    L94:
        r35.add(Integer.valueOf(r39));     // Catch: IllegalArgumentException -> L97 Throwable -> L99
        goto L87
    L91:
        r16.addWarning(ApkVerifier.Issue.V2_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE, new Object[]{Integer.valueOf(r116)});     // Catch: IllegalArgumentException -> L97 Throwable -> L99
        goto L87
    L99:
        r16.addError(ApkVerifier.Issue.V2_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE, new Object[]{Integer.valueOf(r36)});
        return;
    L97:
        System.err.println("(--NOTE--)IllegalArgumentException(\"V2 Negative length\")");
        r16.addError(ApkVerifier.Issue.V2_SIG_NEGATIVE_LEN, new Object[0]);
        return;
    L101:
        Iterator r40 = r35.iterator();
    L103:
        if (r40.hasNext() == false) goto L108;
        int r41 = ((Integer) r40.next()).intValue();
        if (r19.contains(Integer.valueOf(r41)) == true) goto L103;
        r16.addError(ApkVerifier.Issue.V2_SIG_MISSING_APK_SIG_REFERENCED, new Object[]{Integer.valueOf(r16.index), (String) r18.get(Integer.valueOf(r41))});
        goto L103
    L108:
        return;
    L57:
        e = move-exception;
        System.out.println("Caught an exception encoding the public key: " + e);
        e.printStackTrace();
        r27 = r26.getPublicKey().getEncoded();
    L109:
        e = move-exception;
        r16.addError(ApkVerifier.Issue.V2_SIG_NO_SUPPORTED_SIGNATURES, new Object[]{e});
    }

    public static void parseSigners(ByteBuffer r15, Set<ContentDigestAlgorithm> r16, Map<Integer, String> r17, Set<Integer> r18, int r19, int r20, ApkSigningBlockUtils.Result r21) throws NoSuchAlgorithmException {
        ByteBuffer r3 = ApkSigningBlockUtils.getLengthPrefixedSlice(r15);     // Catch: IllegalArgumentException -> L22 ApkFormatException -> L24
    L5:
        if (r3.hasRemaining() == true) goto L26;
        r21.addError(ApkVerifier.Issue.V2_SIG_NO_SIGNERS, new Object[0]);
        return;
    L26:
        CertificateFactory r4 = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L19
        int r5 = 0;
    L11:
        if (r3.hasRemaining() == false) goto L33;
        int r13 = r5 + 1;
        ApkSigningBlockUtils.Result.SignerInfo r14 = new ApkSigningBlockUtils.Result.SignerInfo();
        r14.index = r5;
        r21.signers.add(r14);
        parseSigner(ApkSigningBlockUtils.getLengthPrefixedSlice(r3), r4, r14, r16, r17, r18, r19, r20);     // Catch: IllegalArgumentException -> L15 Throwable -> L17
        r5 = r13;
        goto L11
    L17:
        r14.addError(ApkVerifier.Issue.V2_SIG_MALFORMED_SIGNER, new Object[0]);
        return;
    L15:
        System.err.println("(--NOTE--)IllegalArgumentException(\"V2 Negative length\")");
        r14.addError(ApkVerifier.Issue.V2_SIG_NEGATIVE_LEN, new Object[0]);
        return;
    L33:
        return;
    L19:
        e = move-exception;
        throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e);
    L24:
        r21.addError(ApkVerifier.Issue.V2_SIG_MALFORMED_SIGNERS, new Object[0]);
        return;
    L22:
        System.err.println("(--NOTE--)IllegalArgumentException(\"V2 Negative length\")");
        r21.addError(ApkVerifier.Issue.V2_SIG_NEGATIVE_LEN, new Object[0]);
    }

    public static ApkSigningBlockUtils.Result verify(DataSource r8, ApkUtils.ZipSections r9, Map<Integer, String> r10, Set<Integer> r11, int r12, int r13) throws IOException, ApkFormatException, NoSuchAlgorithmException, ApkSigningBlockUtils.SignatureNotFoundException {
        ApkSigningBlockUtils.Result r7 = new ApkSigningBlockUtils.Result(2);
        SignatureInfo r14 = ApkSigningBlockUtils.findSignature(r8, r9, V2SchemeConstants.APK_SIGNATURE_SCHEME_V2_BLOCK_ID, r7);
        HashSet r1 = new HashSet(1);
        parseSigners(r14.signatureBlock, r1, r10, r11, r12, r13, r7);
        r7.verified = true;
        return r7;
    }
}

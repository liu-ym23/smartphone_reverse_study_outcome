package com.android.apksig.internal.apk;

import com.android.apksig.ApkVerifier;
import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.apk.ApkUtils;
import com.android.apksig.internal.asn1.Asn1BerParser;
import com.android.apksig.internal.asn1.Asn1DerEncoder;
import com.android.apksig.internal.x509.RSAPublicKey;
import com.android.apksig.internal.x509.SubjectPublicKeyInfo;
import com.android.apksig.util.DataSource;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ApkSigningBlockUtils {
    public static final int VERSION_APK_SIGNATURE_SCHEME_V2 = 2;
    public static final int VERSION_APK_SIGNATURE_SCHEME_V3 = 3;
    public static final int VERSION_APK_SIGNATURE_SCHEME_V31 = 31;
    public static final int VERSION_JAR_SIGNATURE_SCHEME = 1;
    public static final int VERSION_SOURCE_STAMP = 0;

    public static class NoSupportedSignaturesException extends NoApkSupportedSignaturesException {
        public NoSupportedSignaturesException(String r1) {
            super(r1);
        }
    }

    public static class Result extends ApkSigResult {
        private final List<ApkVerifier.IssueWithParams> mErrors;
        public final List<SignerInfo> signers;

        public static class SignerInfo extends ApkSignerInfo {
            public List<AdditionalAttribute> additionalAttributes;
            public List<ContentDigest> contentDigests;
            private final List<ApkVerifier.IssueWithParams> mErrors;
            private final List<ApkVerifier.IssueWithParams> mWarnings;
            public int maxSdkVersion;
            public int minSdkVersion;
            public List<Signature> signatures;
            public byte[] signedData;
            public Map<SignatureAlgorithm, byte[]> verifiedSignatures;

            public static class AdditionalAttribute {
                private final int mId;
                private final byte[] mValue;

                public AdditionalAttribute(int r1, byte[] r2) {
                    this.mId = r1;
                    this.mValue = (byte[]) r2.clone();
                }

                public int getId() {
                    return this.mId;
                }

                public byte[] getValue() {
                    return (byte[]) this.mValue.clone();
                }
            }

            public static class ContentDigest {
                private final int mSignatureAlgorithmId;
                private final byte[] mValue;

                public ContentDigest(int r1, byte[] r2) {
                    this.mSignatureAlgorithmId = r1;
                    this.mValue = r2;
                }

                public int getSignatureAlgorithmId() {
                    return this.mSignatureAlgorithmId;
                }

                public byte[] getValue() {
                    return this.mValue;
                }
            }

            public static class Signature {
                private final int mAlgorithmId;
                private final byte[] mValue;

                public Signature(int r1, byte[] r2) {
                    this.mAlgorithmId = r1;
                    this.mValue = r2;
                }

                public int getAlgorithmId() {
                    return this.mAlgorithmId;
                }

                public byte[] getValue() {
                    return this.mValue;
                }
            }

            public SignerInfo() {
                this.mWarnings = new ArrayList();
                this.mErrors = new ArrayList();
                this.contentDigests = new ArrayList();
                this.signatures = new ArrayList();
                this.verifiedSignatures = new HashMap();
                this.additionalAttributes = new ArrayList();
            }

            public void addError(ApkVerifier.Issue r2, Object... r3) {
                this.mErrors.add(new ApkVerifier.IssueWithParams(r2, r3));
            }

            public void addWarning(ApkVerifier.Issue r2, Object... r3) {
                this.mWarnings.add(new ApkVerifier.IssueWithParams(r2, r3));
            }

            @Override // com.android.apksig.internal.apk.ApkSignerInfo
            public List<ApkVerifier.IssueWithParams> getErrors() {
                return this.mErrors;
            }

            @Override // com.android.apksig.internal.apk.ApkSignerInfo
            public List<ApkVerifier.IssueWithParams> getWarnings() {
                return this.mWarnings;
            }
        }

        public Result(int r1) {
            super(r1);
            this.signers = new ArrayList();
            this.mErrors = new ArrayList();
        }

        public void addError(ApkVerifier.Issue r2, Object... r3) {
            this.mErrors.add(new ApkVerifier.IssueWithParams(r2, r3));
        }

        @Override // com.android.apksig.internal.apk.ApkSigResult
        public List<ApkVerifier.IssueWithParams> getErrors() {
            return this.mErrors;
        }
    }

    public static class SignatureNotFoundException extends Exception {
        private static final long serialVersionUID = 1;

        public SignatureNotFoundException(String r1) {
            super(r1);
        }
    }

    public static class SupportedSignature extends ApkSupportedSignature {
        public SupportedSignature(SignatureAlgorithm r1, byte[] r2) {
            super(r1, r2);
        }
    }

    public ApkSigningBlockUtils() {
    }

    public static byte[] encodePublicKey(PublicKey r9) throws InvalidKeyException, NoSuchAlgorithmException {
        byte[] r1 = null;
        if ("X.509".equals(r9.getFormat()) == false) goto L14;
        byte[] r0 = r9.getEncoded();
        if ("RSA".equals(r9.getAlgorithm()) == true) goto L26;
    L12:
        r1 = r0;
        goto L14
    L26:
        SubjectPublicKeyInfo r2 = (SubjectPublicKeyInfo) Asn1BerParser.parse(ByteBuffer.wrap(r0), SubjectPublicKeyInfo.class);     // Catch: Throwable -> L10
        ByteBuffer r3 = r2.subjectPublicKey;     // Catch: Throwable -> L10
        byte r4 = r3.get();     // Catch: Throwable -> L10
        RSAPublicKey r5 = (RSAPublicKey) Asn1BerParser.parse(r3, RSAPublicKey.class);     // Catch: Throwable -> L10
        if (r5.modulus.compareTo(BigInteger.ZERO) >= 0) goto L12;
        byte[] r6 = r5.modulus.toByteArray();     // Catch: Throwable -> L10
        byte[] r7 = new byte[r6.length + 1];     // Catch: Throwable -> L10
        r7[0] = 0;     // Catch: Throwable -> L10
        System.arraycopy(r6, 0, r7, 1, r6.length);     // Catch: Throwable -> L10
        r5.modulus = new BigInteger(r7);     // Catch: Throwable -> L10
        byte[] r8 = Asn1DerEncoder.encode(r5);     // Catch: Throwable -> L10
        byte[] r10 = new byte[r8.length + 1];     // Catch: Throwable -> L10
        r10[0] = r4;     // Catch: Throwable -> L10
        System.arraycopy(r8, 0, r10, 1, r8.length);     // Catch: Throwable -> L10
        r2.subjectPublicKey = ByteBuffer.wrap(r10);     // Catch: Throwable -> L10
        r1 = Asn1DerEncoder.encode(r2);     // Catch: Throwable -> L10
    L10:
        e = move-exception;
        System.out.println("Caught a exception encoding the public key: " + e);
        e.printStackTrace();
    L14:
        if (r1 == null) goto L28;
    L20:
        if (r1 == null) goto L25;
        if (r1.length == 0) goto L25;
        return r1;
    L25:
        throw new InvalidKeyException("Failed to obtain X.509 encoded form of public key " + r9 + " of class " + r9.getClass().getName());
    L28:
        r1 = ((X509EncodedKeySpec) KeyFactory.getInstance(r9.getAlgorithm()).getKeySpec(r9, X509EncodedKeySpec.class)).getEncoded();     // Catch: InvalidKeySpecException -> L17
    L17:
        e = move-exception;
        throw new InvalidKeyException("Failed to obtain X.509 encoded form of public key " + r9 + " of class " + r9.getClass().getName(), e);
    }

    public static SignatureInfo findSignature(DataSource r0, ApkUtils.ZipSections r1, int r2, Result r3) throws IOException, SignatureNotFoundException {
        return ApkSigningBlockUtilsLite.findSignature(r0, r1, r2);
    L4:
        e = move-exception;
        throw new SignatureNotFoundException(e.getMessage());
    }

    public static ByteBuffer getLengthPrefixedSlice(ByteBuffer r0) throws ApkFormatException {
        return ApkSigningBlockUtilsLite.getLengthPrefixedSlice(r0);
    }

    public static <T extends ApkSupportedSignature> List<T> getSignaturesToVerify(List<T> r1, int r2, int r3) throws NoSupportedSignaturesException {
        return getSignaturesToVerify(r1, r2, r3, false);
    }

    public static byte[] readLengthPrefixedByteArray(ByteBuffer r0) throws ApkFormatException {
        return ApkSigningBlockUtilsLite.readLengthPrefixedByteArray(r0);
    }

    public static String toHex(byte[] r0) {
        return ApkSigningBlockUtilsLite.toHex(r0);
    }

    public static <T extends ApkSupportedSignature> List<T> getSignaturesToVerify(List<T> r0, int r1, int r2, boolean r3) throws NoSupportedSignaturesException {
        return ApkSigningBlockUtilsLite.getSignaturesToVerify(r0, r1, r2, r3);
    L4:
        e = move-exception;
        throw new NoSupportedSignaturesException(e.getMessage());
    }
}

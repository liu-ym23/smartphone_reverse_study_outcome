package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeysetReader;
import com.google.crypto.tink.PemKeyType;
import com.google.crypto.tink.proto.EcdsaParams;
import com.google.crypto.tink.proto.EcdsaSignatureEncoding;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.RsaSsaPkcs1Params;
import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.signature.internal.SigUtil;
import com.google.crypto.tink.subtle.Enums;
import com.google.crypto.tink.subtle.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.security.Key;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class SignaturePemKeysetReader implements KeysetReader {
    private List<PemKey> pemKeys;

    /* JADX INFO: renamed from: com.google.crypto.tink.signature.SignaturePemKeysetReader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = null;

        static {
            int[] r0 = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = r0;
            r0[Enums.HashType.SHA256.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA384.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final class Builder {
        private List<PemKey> pemKeys;

        Builder() {
            this.pemKeys = new ArrayList();
        }

        public KeysetReader build() {
            return new SignaturePemKeysetReader(this.pemKeys);
        }

        public Builder addPem(String pem, PemKeyType keyType) {
            PemKey r0 = new PemKey(null);
            r0.reader = new BufferedReader(new StringReader(pem));
            r0.type = keyType;
            this.pemKeys.add(r0);
            return this;
        }
    }

    private static final class PemKey {
        BufferedReader reader;
        PemKeyType type;

        private PemKey() {
        }

        /* synthetic */ PemKey(AnonymousClass1 r1) {
            this();
        }
    }

    SignaturePemKeysetReader(List<PemKey> pemKeys) {
        this.pemKeys = pemKeys;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() throws IOException {
        Keyset.Builder r0 = Keyset.newBuilder();
        Iterator<PemKey> r4 = this.pemKeys.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        PemKey r1 = r4.next();
        Keyset.Key r2 = readKey(r1.reader, r1.type);
    L6:
        if (r2 == null) goto L4;
        r0.addKey(r2);
        r2 = readKey(r1.reader, r1.type);
        goto L6
    L9:
        if (r0.getKeyCount() == 0) goto L13;
        r0.setPrimaryKeyId(r0.getKey(0).getKeyId());
        return (Keyset) r0.build();
    L13:
        throw new IOException("cannot find any key");
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Nullable
    private static Keyset.Key readKey(BufferedReader reader, PemKeyType pemKeyType) throws IOException {
        Key r2 = pemKeyType.readKey(reader);
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof RSAPublicKey) == false) goto L9;
        KeyData r3 = convertRsaPublicKey(pemKeyType, (RSAPublicKey) r2);
    L12:
        return (Keyset.Key) Keyset.Key.newBuilder().setKeyData(r3).setStatus(KeyStatusType.ENABLED).setOutputPrefixType(OutputPrefixType.RAW).setKeyId(Random.randInt()).build();
    L9:
        if ((r2 instanceof ECPublicKey) == false) goto L13;
        r3 = convertEcPublicKey(pemKeyType, (ECPublicKey) r2);
        goto L12
    L13:
        return null;
    }

    private static KeyData convertRsaPublicKey(PemKeyType pemKeyType, RSAPublicKey key) throws IOException {
        if (pemKeyType.algorithm.equals("RSASSA-PKCS1-v1_5") == false) goto L7;
        return (KeyData) KeyData.newBuilder().setTypeUrl(RsaSsaPkcs1VerifyKeyManager.getKeyType()).setValue(((com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey) com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey.newBuilder().setVersion(0).setParams((RsaSsaPkcs1Params) RsaSsaPkcs1Params.newBuilder().setHashType(getHashType(pemKeyType)).build()).setE(SigUtil.toUnsignedIntByteString(key.getPublicExponent())).setN(SigUtil.toUnsignedIntByteString(key.getModulus())).build()).toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC).build();
    L7:
        if (pemKeyType.algorithm.equals("RSASSA-PSS") == false) goto L11;
        return (KeyData) KeyData.newBuilder().setTypeUrl(RsaSsaPssVerifyKeyManager.getKeyType()).setValue(((com.google.crypto.tink.proto.RsaSsaPssPublicKey) com.google.crypto.tink.proto.RsaSsaPssPublicKey.newBuilder().setVersion(0).setParams((RsaSsaPssParams) RsaSsaPssParams.newBuilder().setSigHash(getHashType(pemKeyType)).setMgf1Hash(getHashType(pemKeyType)).setSaltLength(getDigestSizeInBytes(pemKeyType)).build()).setE(SigUtil.toUnsignedIntByteString(key.getPublicExponent())).setN(SigUtil.toUnsignedIntByteString(key.getModulus())).build()).toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC).build();
    L11:
        throw new IOException("unsupported RSA signature algorithm: " + pemKeyType.algorithm);
    }

    private static KeyData convertEcPublicKey(PemKeyType pemKeyType, ECPublicKey key) throws IOException {
        if (pemKeyType.algorithm.equals("ECDSA") == false) goto L7;
        return (KeyData) KeyData.newBuilder().setTypeUrl(EcdsaVerifyKeyManager.getKeyType()).setValue(((com.google.crypto.tink.proto.EcdsaPublicKey) com.google.crypto.tink.proto.EcdsaPublicKey.newBuilder().setVersion(0).setParams((EcdsaParams) EcdsaParams.newBuilder().setHashType(getHashType(pemKeyType)).setCurve(getCurveType(pemKeyType)).setEncoding(EcdsaSignatureEncoding.DER).build()).setX(SigUtil.toUnsignedIntByteString(key.getW().getAffineX())).setY(SigUtil.toUnsignedIntByteString(key.getW().getAffineY())).build()).toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC).build();
    L7:
        throw new IOException("unsupported EC signature algorithm: " + pemKeyType.algorithm);
    }

    private static HashType getHashType(PemKeyType pemKeyType) {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[pemKeyType.hash.ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return HashType.SHA512;
    L11:
        throw new IllegalArgumentException("unsupported hash type: " + pemKeyType.hash.name());
    L13:
        return HashType.SHA384;
    L15:
        return HashType.SHA256;
    }

    private static int getDigestSizeInBytes(PemKeyType pemKeyType) {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[pemKeyType.hash.ordinal()];
        if (r0 != 1) goto L5;
        return 32;
    L5:
        if (r0 != 2) goto L7;
        return 48;
    L7:
        if (r0 != 3) goto L11;
        return 64;
    L11:
        throw new IllegalArgumentException("unsupported hash type: " + pemKeyType.hash.name());
    }

    private static EllipticCurveType getCurveType(PemKeyType pemKeyType) {
        int r0 = pemKeyType.keySizeInBits;
        if (r0 == 256) goto L15;
        if (r0 == 384) goto L13;
        if (r0 != 521) goto L11;
        return EllipticCurveType.NIST_P521;
    L11:
        throw new IllegalArgumentException("unsupported curve for key size: " + pemKeyType.keySizeInBits);
    L13:
        return EllipticCurveType.NIST_P384;
    L15:
        return EllipticCurveType.NIST_P256;
    }
}

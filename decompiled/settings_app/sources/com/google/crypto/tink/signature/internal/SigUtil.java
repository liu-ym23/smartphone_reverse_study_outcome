package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.proto.EcdsaSignatureEncoding;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.Enums;
import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class SigUtil {
    static final String INVALID_PARAMS = "Invalid ECDSA parameters";

    /* JADX INFO: renamed from: com.google.crypto.tink.signature.internal.SigUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$EcdsaSignatureEncoding = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType = null;

        static {
            int[] r0 = new int[EcdsaSignatureEncoding.values().length];
            $SwitchMap$com$google$crypto$tink$proto$EcdsaSignatureEncoding = r0;
            r0[EcdsaSignatureEncoding.IEEE_P1363.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L24:
            $SwitchMap$com$google$crypto$tink$proto$EcdsaSignatureEncoding[EcdsaSignatureEncoding.DER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L6:
            int[] r2 = new int[EllipticCurveType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType = r2;
            r2[EllipticCurveType.NIST_P256.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L32:
            $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType[EllipticCurveType.NIST_P384.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L38:
            $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType[EllipticCurveType.NIST_P521.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L11:
            int[] r3 = new int[HashType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = r3;
            r3[HashType.SHA256.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L26:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA384.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L30:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static Enums.HashType toHashType(HashType hash) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$HashType[hash.ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return Enums.HashType.SHA512;
    L11:
        throw new GeneralSecurityException("unsupported hash type: " + hash.name());
    L13:
        return Enums.HashType.SHA384;
    L15:
        return Enums.HashType.SHA256;
    }

    public static EllipticCurves.CurveType toCurveType(EllipticCurveType type) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$EllipticCurveType[type.ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return EllipticCurves.CurveType.NIST_P521;
    L11:
        throw new GeneralSecurityException("unknown curve type: " + type.name());
    L13:
        return EllipticCurves.CurveType.NIST_P384;
    L15:
        return EllipticCurves.CurveType.NIST_P256;
    }

    public static EllipticCurves.EcdsaEncoding toEcdsaEncoding(EcdsaSignatureEncoding encoding) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$EcdsaSignatureEncoding[encoding.ordinal()];
        if (r0 == 1) goto L11;
        if (r0 != 2) goto L9;
        return EllipticCurves.EcdsaEncoding.DER;
    L9:
        throw new GeneralSecurityException("unknown ECDSA encoding: " + encoding.name());
    L11:
        return EllipticCurves.EcdsaEncoding.IEEE_P1363;
    }

    public static ByteString toUnsignedIntByteString(BigInteger i) {
        byte[] r2 = i.toByteArray();
        if (r2[0] != 0) goto L7;
        return ByteString.copyFrom(r2, 1, r2.length - 1);
    L7:
        return ByteString.copyFrom(r2);
    }

    private SigUtil() {
    }
}

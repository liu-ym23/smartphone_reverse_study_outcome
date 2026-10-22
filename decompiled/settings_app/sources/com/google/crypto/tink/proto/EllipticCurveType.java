package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes4.dex */
public final enum EllipticCurveType extends Enum<EllipticCurveType> implements Internal.EnumLite {
    private static final /* synthetic */ EllipticCurveType[] $VALUES = null;
    public static final EllipticCurveType CURVE25519 = null;
    public static final int CURVE25519_VALUE = 5;
    public static final EllipticCurveType NIST_P256 = null;
    public static final int NIST_P256_VALUE = 2;
    public static final EllipticCurveType NIST_P384 = null;
    public static final int NIST_P384_VALUE = 3;
    public static final EllipticCurveType NIST_P521 = null;
    public static final int NIST_P521_VALUE = 4;
    public static final EllipticCurveType UNKNOWN_CURVE = null;
    public static final int UNKNOWN_CURVE_VALUE = 0;
    public static final EllipticCurveType UNRECOGNIZED = null;
    private static final Internal.EnumLiteMap<EllipticCurveType> internalValueMap = null;
    private final int value;

    private static final class EllipticCurveTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private EllipticCurveTypeVerifier() {
        }

        static {
            INSTANCE = new EllipticCurveTypeVerifier();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            if (EllipticCurveType.forNumber(number) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static EllipticCurveType valueOf(String name) {
        return (EllipticCurveType) Enum.valueOf(EllipticCurveType.class, name);
    }

    public static EllipticCurveType[] values() {
        return (EllipticCurveType[]) $VALUES.clone();
    }

    static {
        EllipticCurveType r0 = new EllipticCurveType("UNKNOWN_CURVE", 0, 0);
        UNKNOWN_CURVE = r0;
        EllipticCurveType r1 = new EllipticCurveType("NIST_P256", 1, 2);
        NIST_P256 = r1;
        EllipticCurveType r3 = new EllipticCurveType("NIST_P384", 2, 3);
        NIST_P384 = r3;
        EllipticCurveType r6 = new EllipticCurveType("NIST_P521", 3, 4);
        NIST_P521 = r6;
        EllipticCurveType r8 = new EllipticCurveType("CURVE25519", 4, 5);
        CURVE25519 = r8;
        EllipticCurveType r10 = new EllipticCurveType("UNRECOGNIZED", 5, -1);
        UNRECOGNIZED = r10;
        $VALUES = new EllipticCurveType[]{r0, r1, r3, r6, r8, r10};
        internalValueMap = new AnonymousClass1();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static EllipticCurveType valueOf(int value) {
        return forNumber(value);
    }

    public static EllipticCurveType forNumber(int value) {
        if (value == 0) goto L22;
        if (value == 2) goto L20;
        if (value == 3) goto L18;
        if (value == 4) goto L16;
        if (value == 5) goto L14;
        return null;
    L14:
        return CURVE25519;
    L16:
        return NIST_P521;
    L18:
        return NIST_P384;
    L20:
        return NIST_P256;
    L22:
        return UNKNOWN_CURVE;
    }

    public static Internal.EnumLiteMap<EllipticCurveType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return EllipticCurveTypeVerifier.INSTANCE;
    }

    private EllipticCurveType(String $enum$name, int $enum$ordinal, int value) {
        super($enum$name, $enum$ordinal);
        this.value = value;
    }
}

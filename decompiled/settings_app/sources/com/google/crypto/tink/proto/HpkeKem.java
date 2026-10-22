package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes4.dex */
public final enum HpkeKem extends Enum<HpkeKem> implements Internal.EnumLite {
    private static final /* synthetic */ HpkeKem[] $VALUES = null;
    public static final HpkeKem DHKEM_P256_HKDF_SHA256 = null;
    public static final int DHKEM_P256_HKDF_SHA256_VALUE = 2;
    public static final HpkeKem DHKEM_P384_HKDF_SHA384 = null;
    public static final int DHKEM_P384_HKDF_SHA384_VALUE = 3;
    public static final HpkeKem DHKEM_P521_HKDF_SHA512 = null;
    public static final int DHKEM_P521_HKDF_SHA512_VALUE = 4;
    public static final HpkeKem DHKEM_X25519_HKDF_SHA256 = null;
    public static final int DHKEM_X25519_HKDF_SHA256_VALUE = 1;
    public static final HpkeKem KEM_UNKNOWN = null;
    public static final int KEM_UNKNOWN_VALUE = 0;
    public static final HpkeKem UNRECOGNIZED = null;
    private static final Internal.EnumLiteMap<HpkeKem> internalValueMap = null;
    private final int value;

    private static final class HpkeKemVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private HpkeKemVerifier() {
        }

        static {
            INSTANCE = new HpkeKemVerifier();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            if (HpkeKem.forNumber(number) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static HpkeKem valueOf(String name) {
        return (HpkeKem) Enum.valueOf(HpkeKem.class, name);
    }

    public static HpkeKem[] values() {
        return (HpkeKem[]) $VALUES.clone();
    }

    static {
        HpkeKem r0 = new HpkeKem("KEM_UNKNOWN", 0, 0);
        KEM_UNKNOWN = r0;
        HpkeKem r1 = new HpkeKem("DHKEM_X25519_HKDF_SHA256", 1, 1);
        DHKEM_X25519_HKDF_SHA256 = r1;
        HpkeKem r3 = new HpkeKem("DHKEM_P256_HKDF_SHA256", 2, 2);
        DHKEM_P256_HKDF_SHA256 = r3;
        HpkeKem r5 = new HpkeKem("DHKEM_P384_HKDF_SHA384", 3, 3);
        DHKEM_P384_HKDF_SHA384 = r5;
        HpkeKem r7 = new HpkeKem("DHKEM_P521_HKDF_SHA512", 4, 4);
        DHKEM_P521_HKDF_SHA512 = r7;
        HpkeKem r9 = new HpkeKem("UNRECOGNIZED", 5, -1);
        UNRECOGNIZED = r9;
        $VALUES = new HpkeKem[]{r0, r1, r3, r5, r7, r9};
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
    public static HpkeKem valueOf(int value) {
        return forNumber(value);
    }

    public static HpkeKem forNumber(int value) {
        if (value == 0) goto L22;
        if (value == 1) goto L20;
        if (value == 2) goto L18;
        if (value == 3) goto L16;
        if (value == 4) goto L14;
        return null;
    L14:
        return DHKEM_P521_HKDF_SHA512;
    L16:
        return DHKEM_P384_HKDF_SHA384;
    L18:
        return DHKEM_P256_HKDF_SHA256;
    L20:
        return DHKEM_X25519_HKDF_SHA256;
    L22:
        return KEM_UNKNOWN;
    }

    public static Internal.EnumLiteMap<HpkeKem> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return HpkeKemVerifier.INSTANCE;
    }

    private HpkeKem(String $enum$name, int $enum$ordinal, int value) {
        super($enum$name, $enum$ordinal);
        this.value = value;
    }
}

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes4.dex */
public final enum HpkeKdf extends Enum<HpkeKdf> implements Internal.EnumLite {
    private static final /* synthetic */ HpkeKdf[] $VALUES = null;
    public static final HpkeKdf HKDF_SHA256 = null;
    public static final int HKDF_SHA256_VALUE = 1;
    public static final HpkeKdf HKDF_SHA384 = null;
    public static final int HKDF_SHA384_VALUE = 2;
    public static final HpkeKdf HKDF_SHA512 = null;
    public static final int HKDF_SHA512_VALUE = 3;
    public static final HpkeKdf KDF_UNKNOWN = null;
    public static final int KDF_UNKNOWN_VALUE = 0;
    public static final HpkeKdf UNRECOGNIZED = null;
    private static final Internal.EnumLiteMap<HpkeKdf> internalValueMap = null;
    private final int value;

    private static final class HpkeKdfVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private HpkeKdfVerifier() {
        }

        static {
            INSTANCE = new HpkeKdfVerifier();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            if (HpkeKdf.forNumber(number) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static HpkeKdf valueOf(String name) {
        return (HpkeKdf) Enum.valueOf(HpkeKdf.class, name);
    }

    public static HpkeKdf[] values() {
        return (HpkeKdf[]) $VALUES.clone();
    }

    static {
        HpkeKdf r0 = new HpkeKdf("KDF_UNKNOWN", 0, 0);
        KDF_UNKNOWN = r0;
        HpkeKdf r1 = new HpkeKdf("HKDF_SHA256", 1, 1);
        HKDF_SHA256 = r1;
        HpkeKdf r3 = new HpkeKdf("HKDF_SHA384", 2, 2);
        HKDF_SHA384 = r3;
        HpkeKdf r5 = new HpkeKdf("HKDF_SHA512", 3, 3);
        HKDF_SHA512 = r5;
        HpkeKdf r7 = new HpkeKdf("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r7;
        $VALUES = new HpkeKdf[]{r0, r1, r3, r5, r7};
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
    public static HpkeKdf valueOf(int value) {
        return forNumber(value);
    }

    public static HpkeKdf forNumber(int value) {
        if (value == 0) goto L18;
        if (value == 1) goto L16;
        if (value == 2) goto L14;
        if (value == 3) goto L12;
        return null;
    L12:
        return HKDF_SHA512;
    L14:
        return HKDF_SHA384;
    L16:
        return HKDF_SHA256;
    L18:
        return KDF_UNKNOWN;
    }

    public static Internal.EnumLiteMap<HpkeKdf> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return HpkeKdfVerifier.INSTANCE;
    }

    private HpkeKdf(String $enum$name, int $enum$ordinal, int value) {
        super($enum$name, $enum$ordinal);
        this.value = value;
    }
}

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes4.dex */
public final enum HpkeAead extends Enum<HpkeAead> implements Internal.EnumLite {
    private static final /* synthetic */ HpkeAead[] $VALUES = null;
    public static final HpkeAead AEAD_UNKNOWN = null;
    public static final int AEAD_UNKNOWN_VALUE = 0;
    public static final HpkeAead AES_128_GCM = null;
    public static final int AES_128_GCM_VALUE = 1;
    public static final HpkeAead AES_256_GCM = null;
    public static final int AES_256_GCM_VALUE = 2;
    public static final HpkeAead CHACHA20_POLY1305 = null;
    public static final int CHACHA20_POLY1305_VALUE = 3;
    public static final HpkeAead UNRECOGNIZED = null;
    private static final Internal.EnumLiteMap<HpkeAead> internalValueMap = null;
    private final int value;

    private static final class HpkeAeadVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private HpkeAeadVerifier() {
        }

        static {
            INSTANCE = new HpkeAeadVerifier();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            if (HpkeAead.forNumber(number) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static HpkeAead valueOf(String name) {
        return (HpkeAead) Enum.valueOf(HpkeAead.class, name);
    }

    public static HpkeAead[] values() {
        return (HpkeAead[]) $VALUES.clone();
    }

    static {
        HpkeAead r0 = new HpkeAead("AEAD_UNKNOWN", 0, 0);
        AEAD_UNKNOWN = r0;
        HpkeAead r1 = new HpkeAead("AES_128_GCM", 1, 1);
        AES_128_GCM = r1;
        HpkeAead r3 = new HpkeAead("AES_256_GCM", 2, 2);
        AES_256_GCM = r3;
        HpkeAead r5 = new HpkeAead("CHACHA20_POLY1305", 3, 3);
        CHACHA20_POLY1305 = r5;
        HpkeAead r7 = new HpkeAead("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r7;
        $VALUES = new HpkeAead[]{r0, r1, r3, r5, r7};
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
    public static HpkeAead valueOf(int value) {
        return forNumber(value);
    }

    public static HpkeAead forNumber(int value) {
        if (value == 0) goto L18;
        if (value == 1) goto L16;
        if (value == 2) goto L14;
        if (value == 3) goto L12;
        return null;
    L12:
        return CHACHA20_POLY1305;
    L14:
        return AES_256_GCM;
    L16:
        return AES_128_GCM;
    L18:
        return AEAD_UNKNOWN;
    }

    public static Internal.EnumLiteMap<HpkeAead> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return HpkeAeadVerifier.INSTANCE;
    }

    private HpkeAead(String $enum$name, int $enum$ordinal, int value) {
        super($enum$name, $enum$ordinal);
        this.value = value;
    }
}

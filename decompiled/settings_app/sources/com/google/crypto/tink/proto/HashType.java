package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes4.dex */
public final enum HashType extends Enum<HashType> implements Internal.EnumLite {
    private static final /* synthetic */ HashType[] $VALUES = null;
    public static final HashType SHA1 = null;
    public static final int SHA1_VALUE = 1;
    public static final HashType SHA224 = null;
    public static final int SHA224_VALUE = 5;
    public static final HashType SHA256 = null;
    public static final int SHA256_VALUE = 3;
    public static final HashType SHA384 = null;
    public static final int SHA384_VALUE = 2;
    public static final HashType SHA512 = null;
    public static final int SHA512_VALUE = 4;
    public static final HashType UNKNOWN_HASH = null;
    public static final int UNKNOWN_HASH_VALUE = 0;
    public static final HashType UNRECOGNIZED = null;
    private static final Internal.EnumLiteMap<HashType> internalValueMap = null;
    private final int value;

    private static final class HashTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private HashTypeVerifier() {
        }

        static {
            INSTANCE = new HashTypeVerifier();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            if (HashType.forNumber(number) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static HashType valueOf(String name) {
        return (HashType) Enum.valueOf(HashType.class, name);
    }

    public static HashType[] values() {
        return (HashType[]) $VALUES.clone();
    }

    static {
        HashType r0 = new HashType("UNKNOWN_HASH", 0, 0);
        UNKNOWN_HASH = r0;
        HashType r1 = new HashType("SHA1", 1, 1);
        SHA1 = r1;
        HashType r3 = new HashType("SHA384", 2, 2);
        SHA384 = r3;
        HashType r5 = new HashType("SHA256", 3, 3);
        SHA256 = r5;
        HashType r7 = new HashType("SHA512", 4, 4);
        SHA512 = r7;
        HashType r9 = new HashType("SHA224", 5, 5);
        SHA224 = r9;
        HashType r11 = new HashType("UNRECOGNIZED", 6, -1);
        UNRECOGNIZED = r11;
        $VALUES = new HashType[]{r0, r1, r3, r5, r7, r9, r11};
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
    public static HashType valueOf(int value) {
        return forNumber(value);
    }

    public static HashType forNumber(int value) {
        if (value == 0) goto L26;
        if (value == 1) goto L24;
        if (value == 2) goto L22;
        if (value == 3) goto L20;
        if (value == 4) goto L18;
        if (value == 5) goto L16;
        return null;
    L16:
        return SHA224;
    L18:
        return SHA512;
    L20:
        return SHA256;
    L22:
        return SHA384;
    L24:
        return SHA1;
    L26:
        return UNKNOWN_HASH;
    }

    public static Internal.EnumLiteMap<HashType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return HashTypeVerifier.INSTANCE;
    }

    private HashType(String $enum$name, int $enum$ordinal, int value) {
        super($enum$name, $enum$ordinal);
        this.value = value;
    }
}

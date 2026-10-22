package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes4.dex */
public final enum JwtRsaSsaPssAlgorithm extends Enum<JwtRsaSsaPssAlgorithm> implements Internal.EnumLite {
    private static final /* synthetic */ JwtRsaSsaPssAlgorithm[] $VALUES = null;
    public static final JwtRsaSsaPssAlgorithm PS256 = null;
    public static final int PS256_VALUE = 1;
    public static final JwtRsaSsaPssAlgorithm PS384 = null;
    public static final int PS384_VALUE = 2;
    public static final JwtRsaSsaPssAlgorithm PS512 = null;
    public static final int PS512_VALUE = 3;
    public static final JwtRsaSsaPssAlgorithm PS_UNKNOWN = null;
    public static final int PS_UNKNOWN_VALUE = 0;
    public static final JwtRsaSsaPssAlgorithm UNRECOGNIZED = null;
    private static final Internal.EnumLiteMap<JwtRsaSsaPssAlgorithm> internalValueMap = null;
    private final int value;

    private static final class JwtRsaSsaPssAlgorithmVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private JwtRsaSsaPssAlgorithmVerifier() {
        }

        static {
            INSTANCE = new JwtRsaSsaPssAlgorithmVerifier();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            if (JwtRsaSsaPssAlgorithm.forNumber(number) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static JwtRsaSsaPssAlgorithm valueOf(String name) {
        return (JwtRsaSsaPssAlgorithm) Enum.valueOf(JwtRsaSsaPssAlgorithm.class, name);
    }

    public static JwtRsaSsaPssAlgorithm[] values() {
        return (JwtRsaSsaPssAlgorithm[]) $VALUES.clone();
    }

    static {
        JwtRsaSsaPssAlgorithm r0 = new JwtRsaSsaPssAlgorithm("PS_UNKNOWN", 0, 0);
        PS_UNKNOWN = r0;
        JwtRsaSsaPssAlgorithm r1 = new JwtRsaSsaPssAlgorithm("PS256", 1, 1);
        PS256 = r1;
        JwtRsaSsaPssAlgorithm r3 = new JwtRsaSsaPssAlgorithm("PS384", 2, 2);
        PS384 = r3;
        JwtRsaSsaPssAlgorithm r5 = new JwtRsaSsaPssAlgorithm("PS512", 3, 3);
        PS512 = r5;
        JwtRsaSsaPssAlgorithm r7 = new JwtRsaSsaPssAlgorithm("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r7;
        $VALUES = new JwtRsaSsaPssAlgorithm[]{r0, r1, r3, r5, r7};
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
    public static JwtRsaSsaPssAlgorithm valueOf(int value) {
        return forNumber(value);
    }

    public static JwtRsaSsaPssAlgorithm forNumber(int value) {
        if (value == 0) goto L18;
        if (value == 1) goto L16;
        if (value == 2) goto L14;
        if (value == 3) goto L12;
        return null;
    L12:
        return PS512;
    L14:
        return PS384;
    L16:
        return PS256;
    L18:
        return PS_UNKNOWN;
    }

    public static Internal.EnumLiteMap<JwtRsaSsaPssAlgorithm> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return JwtRsaSsaPssAlgorithmVerifier.INSTANCE;
    }

    private JwtRsaSsaPssAlgorithm(String $enum$name, int $enum$ordinal, int value) {
        super($enum$name, $enum$ordinal);
        this.value = value;
    }
}

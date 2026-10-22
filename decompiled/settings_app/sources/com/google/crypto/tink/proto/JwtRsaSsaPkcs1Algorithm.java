package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes4.dex */
public final enum JwtRsaSsaPkcs1Algorithm extends Enum<JwtRsaSsaPkcs1Algorithm> implements Internal.EnumLite {
    private static final /* synthetic */ JwtRsaSsaPkcs1Algorithm[] $VALUES = null;
    public static final JwtRsaSsaPkcs1Algorithm RS256 = null;
    public static final int RS256_VALUE = 1;
    public static final JwtRsaSsaPkcs1Algorithm RS384 = null;
    public static final int RS384_VALUE = 2;
    public static final JwtRsaSsaPkcs1Algorithm RS512 = null;
    public static final int RS512_VALUE = 3;
    public static final JwtRsaSsaPkcs1Algorithm RS_UNKNOWN = null;
    public static final int RS_UNKNOWN_VALUE = 0;
    public static final JwtRsaSsaPkcs1Algorithm UNRECOGNIZED = null;
    private static final Internal.EnumLiteMap<JwtRsaSsaPkcs1Algorithm> internalValueMap = null;
    private final int value;

    private static final class JwtRsaSsaPkcs1AlgorithmVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private JwtRsaSsaPkcs1AlgorithmVerifier() {
        }

        static {
            INSTANCE = new JwtRsaSsaPkcs1AlgorithmVerifier();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            if (JwtRsaSsaPkcs1Algorithm.forNumber(number) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static JwtRsaSsaPkcs1Algorithm valueOf(String name) {
        return (JwtRsaSsaPkcs1Algorithm) Enum.valueOf(JwtRsaSsaPkcs1Algorithm.class, name);
    }

    public static JwtRsaSsaPkcs1Algorithm[] values() {
        return (JwtRsaSsaPkcs1Algorithm[]) $VALUES.clone();
    }

    static {
        JwtRsaSsaPkcs1Algorithm r0 = new JwtRsaSsaPkcs1Algorithm("RS_UNKNOWN", 0, 0);
        RS_UNKNOWN = r0;
        JwtRsaSsaPkcs1Algorithm r1 = new JwtRsaSsaPkcs1Algorithm("RS256", 1, 1);
        RS256 = r1;
        JwtRsaSsaPkcs1Algorithm r3 = new JwtRsaSsaPkcs1Algorithm("RS384", 2, 2);
        RS384 = r3;
        JwtRsaSsaPkcs1Algorithm r5 = new JwtRsaSsaPkcs1Algorithm("RS512", 3, 3);
        RS512 = r5;
        JwtRsaSsaPkcs1Algorithm r7 = new JwtRsaSsaPkcs1Algorithm("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r7;
        $VALUES = new JwtRsaSsaPkcs1Algorithm[]{r0, r1, r3, r5, r7};
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
    public static JwtRsaSsaPkcs1Algorithm valueOf(int value) {
        return forNumber(value);
    }

    public static JwtRsaSsaPkcs1Algorithm forNumber(int value) {
        if (value == 0) goto L18;
        if (value == 1) goto L16;
        if (value == 2) goto L14;
        if (value == 3) goto L12;
        return null;
    L12:
        return RS512;
    L14:
        return RS384;
    L16:
        return RS256;
    L18:
        return RS_UNKNOWN;
    }

    public static Internal.EnumLiteMap<JwtRsaSsaPkcs1Algorithm> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return JwtRsaSsaPkcs1AlgorithmVerifier.INSTANCE;
    }

    private JwtRsaSsaPkcs1Algorithm(String $enum$name, int $enum$ordinal, int value) {
        super($enum$name, $enum$ordinal);
        this.value = value;
    }
}

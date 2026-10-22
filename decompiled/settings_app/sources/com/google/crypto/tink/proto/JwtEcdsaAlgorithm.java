package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes4.dex */
public final enum JwtEcdsaAlgorithm extends Enum<JwtEcdsaAlgorithm> implements Internal.EnumLite {
    private static final /* synthetic */ JwtEcdsaAlgorithm[] $VALUES = null;
    public static final JwtEcdsaAlgorithm ES256 = null;
    public static final int ES256_VALUE = 1;
    public static final JwtEcdsaAlgorithm ES384 = null;
    public static final int ES384_VALUE = 2;
    public static final JwtEcdsaAlgorithm ES512 = null;
    public static final int ES512_VALUE = 3;
    public static final JwtEcdsaAlgorithm ES_UNKNOWN = null;
    public static final int ES_UNKNOWN_VALUE = 0;
    public static final JwtEcdsaAlgorithm UNRECOGNIZED = null;
    private static final Internal.EnumLiteMap<JwtEcdsaAlgorithm> internalValueMap = null;
    private final int value;

    private static final class JwtEcdsaAlgorithmVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private JwtEcdsaAlgorithmVerifier() {
        }

        static {
            INSTANCE = new JwtEcdsaAlgorithmVerifier();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            if (JwtEcdsaAlgorithm.forNumber(number) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static JwtEcdsaAlgorithm valueOf(String name) {
        return (JwtEcdsaAlgorithm) Enum.valueOf(JwtEcdsaAlgorithm.class, name);
    }

    public static JwtEcdsaAlgorithm[] values() {
        return (JwtEcdsaAlgorithm[]) $VALUES.clone();
    }

    static {
        JwtEcdsaAlgorithm r0 = new JwtEcdsaAlgorithm("ES_UNKNOWN", 0, 0);
        ES_UNKNOWN = r0;
        JwtEcdsaAlgorithm r1 = new JwtEcdsaAlgorithm("ES256", 1, 1);
        ES256 = r1;
        JwtEcdsaAlgorithm r3 = new JwtEcdsaAlgorithm("ES384", 2, 2);
        ES384 = r3;
        JwtEcdsaAlgorithm r5 = new JwtEcdsaAlgorithm("ES512", 3, 3);
        ES512 = r5;
        JwtEcdsaAlgorithm r7 = new JwtEcdsaAlgorithm("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r7;
        $VALUES = new JwtEcdsaAlgorithm[]{r0, r1, r3, r5, r7};
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
    public static JwtEcdsaAlgorithm valueOf(int value) {
        return forNumber(value);
    }

    public static JwtEcdsaAlgorithm forNumber(int value) {
        if (value == 0) goto L18;
        if (value == 1) goto L16;
        if (value == 2) goto L14;
        if (value == 3) goto L12;
        return null;
    L12:
        return ES512;
    L14:
        return ES384;
    L16:
        return ES256;
    L18:
        return ES_UNKNOWN;
    }

    public static Internal.EnumLiteMap<JwtEcdsaAlgorithm> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return JwtEcdsaAlgorithmVerifier.INSTANCE;
    }

    private JwtEcdsaAlgorithm(String $enum$name, int $enum$ordinal, int value) {
        super($enum$name, $enum$ordinal);
        this.value = value;
    }
}

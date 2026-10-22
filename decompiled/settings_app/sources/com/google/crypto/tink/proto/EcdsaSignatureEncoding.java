package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes4.dex */
public final enum EcdsaSignatureEncoding extends Enum<EcdsaSignatureEncoding> implements Internal.EnumLite {
    private static final /* synthetic */ EcdsaSignatureEncoding[] $VALUES = null;
    public static final EcdsaSignatureEncoding DER = null;
    public static final int DER_VALUE = 2;
    public static final EcdsaSignatureEncoding IEEE_P1363 = null;
    public static final int IEEE_P1363_VALUE = 1;
    public static final EcdsaSignatureEncoding UNKNOWN_ENCODING = null;
    public static final int UNKNOWN_ENCODING_VALUE = 0;
    public static final EcdsaSignatureEncoding UNRECOGNIZED = null;
    private static final Internal.EnumLiteMap<EcdsaSignatureEncoding> internalValueMap = null;
    private final int value;

    private static final class EcdsaSignatureEncodingVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private EcdsaSignatureEncodingVerifier() {
        }

        static {
            INSTANCE = new EcdsaSignatureEncodingVerifier();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            if (EcdsaSignatureEncoding.forNumber(number) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static EcdsaSignatureEncoding valueOf(String name) {
        return (EcdsaSignatureEncoding) Enum.valueOf(EcdsaSignatureEncoding.class, name);
    }

    public static EcdsaSignatureEncoding[] values() {
        return (EcdsaSignatureEncoding[]) $VALUES.clone();
    }

    static {
        EcdsaSignatureEncoding r0 = new EcdsaSignatureEncoding("UNKNOWN_ENCODING", 0, 0);
        UNKNOWN_ENCODING = r0;
        EcdsaSignatureEncoding r1 = new EcdsaSignatureEncoding("IEEE_P1363", 1, 1);
        IEEE_P1363 = r1;
        EcdsaSignatureEncoding r3 = new EcdsaSignatureEncoding("DER", 2, 2);
        DER = r3;
        EcdsaSignatureEncoding r5 = new EcdsaSignatureEncoding("UNRECOGNIZED", 3, -1);
        UNRECOGNIZED = r5;
        $VALUES = new EcdsaSignatureEncoding[]{r0, r1, r3, r5};
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
    public static EcdsaSignatureEncoding valueOf(int value) {
        return forNumber(value);
    }

    public static EcdsaSignatureEncoding forNumber(int value) {
        if (value == 0) goto L14;
        if (value == 1) goto L12;
        if (value == 2) goto L10;
        return null;
    L10:
        return DER;
    L12:
        return IEEE_P1363;
    L14:
        return UNKNOWN_ENCODING;
    }

    public static Internal.EnumLiteMap<EcdsaSignatureEncoding> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return EcdsaSignatureEncodingVerifier.INSTANCE;
    }

    private EcdsaSignatureEncoding(String $enum$name, int $enum$ordinal, int value) {
        super($enum$name, $enum$ordinal);
        this.value = value;
    }
}

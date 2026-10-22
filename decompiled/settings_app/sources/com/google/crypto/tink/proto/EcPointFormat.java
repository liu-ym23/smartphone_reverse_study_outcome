package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes4.dex */
public final enum EcPointFormat extends Enum<EcPointFormat> implements Internal.EnumLite {
    private static final /* synthetic */ EcPointFormat[] $VALUES = null;
    public static final EcPointFormat COMPRESSED = null;
    public static final int COMPRESSED_VALUE = 2;
    public static final EcPointFormat DO_NOT_USE_CRUNCHY_UNCOMPRESSED = null;
    public static final int DO_NOT_USE_CRUNCHY_UNCOMPRESSED_VALUE = 3;
    public static final EcPointFormat UNCOMPRESSED = null;
    public static final int UNCOMPRESSED_VALUE = 1;
    public static final EcPointFormat UNKNOWN_FORMAT = null;
    public static final int UNKNOWN_FORMAT_VALUE = 0;
    public static final EcPointFormat UNRECOGNIZED = null;
    private static final Internal.EnumLiteMap<EcPointFormat> internalValueMap = null;
    private final int value;

    private static final class EcPointFormatVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private EcPointFormatVerifier() {
        }

        static {
            INSTANCE = new EcPointFormatVerifier();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            if (EcPointFormat.forNumber(number) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static EcPointFormat valueOf(String name) {
        return (EcPointFormat) Enum.valueOf(EcPointFormat.class, name);
    }

    public static EcPointFormat[] values() {
        return (EcPointFormat[]) $VALUES.clone();
    }

    static {
        EcPointFormat r0 = new EcPointFormat("UNKNOWN_FORMAT", 0, 0);
        UNKNOWN_FORMAT = r0;
        EcPointFormat r1 = new EcPointFormat("UNCOMPRESSED", 1, 1);
        UNCOMPRESSED = r1;
        EcPointFormat r3 = new EcPointFormat("COMPRESSED", 2, 2);
        COMPRESSED = r3;
        EcPointFormat r5 = new EcPointFormat("DO_NOT_USE_CRUNCHY_UNCOMPRESSED", 3, 3);
        DO_NOT_USE_CRUNCHY_UNCOMPRESSED = r5;
        EcPointFormat r7 = new EcPointFormat("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r7;
        $VALUES = new EcPointFormat[]{r0, r1, r3, r5, r7};
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
    public static EcPointFormat valueOf(int value) {
        return forNumber(value);
    }

    public static EcPointFormat forNumber(int value) {
        if (value == 0) goto L18;
        if (value == 1) goto L16;
        if (value == 2) goto L14;
        if (value == 3) goto L12;
        return null;
    L12:
        return DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
    L14:
        return COMPRESSED;
    L16:
        return UNCOMPRESSED;
    L18:
        return UNKNOWN_FORMAT;
    }

    public static Internal.EnumLiteMap<EcPointFormat> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return EcPointFormatVerifier.INSTANCE;
    }

    private EcPointFormat(String $enum$name, int $enum$ordinal, int value) {
        super($enum$name, $enum$ordinal);
        this.value = value;
    }
}

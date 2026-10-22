package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes4.dex */
public final enum OutputPrefixType extends Enum<OutputPrefixType> implements Internal.EnumLite {
    private static final /* synthetic */ OutputPrefixType[] $VALUES = null;
    public static final OutputPrefixType CRUNCHY = null;
    public static final int CRUNCHY_VALUE = 4;
    public static final OutputPrefixType LEGACY = null;
    public static final int LEGACY_VALUE = 2;
    public static final OutputPrefixType RAW = null;
    public static final int RAW_VALUE = 3;
    public static final OutputPrefixType TINK = null;
    public static final int TINK_VALUE = 1;
    public static final OutputPrefixType UNKNOWN_PREFIX = null;
    public static final int UNKNOWN_PREFIX_VALUE = 0;
    public static final OutputPrefixType UNRECOGNIZED = null;
    private static final Internal.EnumLiteMap<OutputPrefixType> internalValueMap = null;
    private final int value;

    private static final class OutputPrefixTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private OutputPrefixTypeVerifier() {
        }

        static {
            INSTANCE = new OutputPrefixTypeVerifier();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            if (OutputPrefixType.forNumber(number) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static OutputPrefixType valueOf(String name) {
        return (OutputPrefixType) Enum.valueOf(OutputPrefixType.class, name);
    }

    public static OutputPrefixType[] values() {
        return (OutputPrefixType[]) $VALUES.clone();
    }

    static {
        OutputPrefixType r0 = new OutputPrefixType("UNKNOWN_PREFIX", 0, 0);
        UNKNOWN_PREFIX = r0;
        OutputPrefixType r1 = new OutputPrefixType("TINK", 1, 1);
        TINK = r1;
        OutputPrefixType r3 = new OutputPrefixType("LEGACY", 2, 2);
        LEGACY = r3;
        OutputPrefixType r5 = new OutputPrefixType("RAW", 3, 3);
        RAW = r5;
        OutputPrefixType r7 = new OutputPrefixType("CRUNCHY", 4, 4);
        CRUNCHY = r7;
        OutputPrefixType r9 = new OutputPrefixType("UNRECOGNIZED", 5, -1);
        UNRECOGNIZED = r9;
        $VALUES = new OutputPrefixType[]{r0, r1, r3, r5, r7, r9};
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
    public static OutputPrefixType valueOf(int value) {
        return forNumber(value);
    }

    public static OutputPrefixType forNumber(int value) {
        if (value == 0) goto L22;
        if (value == 1) goto L20;
        if (value == 2) goto L18;
        if (value == 3) goto L16;
        if (value == 4) goto L14;
        return null;
    L14:
        return CRUNCHY;
    L16:
        return RAW;
    L18:
        return LEGACY;
    L20:
        return TINK;
    L22:
        return UNKNOWN_PREFIX;
    }

    public static Internal.EnumLiteMap<OutputPrefixType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return OutputPrefixTypeVerifier.INSTANCE;
    }

    private OutputPrefixType(String $enum$name, int $enum$ordinal, int value) {
        super($enum$name, $enum$ordinal);
        this.value = value;
    }
}

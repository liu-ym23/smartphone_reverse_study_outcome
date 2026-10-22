package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes4.dex */
public final enum NullValue extends java.lang.Enum<NullValue> implements Internal.EnumLite {
    private static final /* synthetic */ NullValue[] $VALUES = null;
    public static final NullValue NULL_VALUE = null;
    public static final int NULL_VALUE_VALUE = 0;
    public static final NullValue UNRECOGNIZED = null;
    private static final Internal.EnumLiteMap<NullValue> internalValueMap = null;
    private final int value;

    private static final class NullValueVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private NullValueVerifier() {
        }

        static {
            INSTANCE = new NullValueVerifier();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            if (NullValue.forNumber(number) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static NullValue valueOf(String name) {
        return (NullValue) java.lang.Enum.valueOf(NullValue.class, name);
    }

    public static NullValue[] values() {
        return (NullValue[]) $VALUES.clone();
    }

    static {
        NullValue r0 = new NullValue("NULL_VALUE", 0, 0);
        NULL_VALUE = r0;
        NullValue r1 = new NullValue("UNRECOGNIZED", 1, -1);
        UNRECOGNIZED = r1;
        $VALUES = new NullValue[]{r0, r1};
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
    public static NullValue valueOf(int value) {
        return forNumber(value);
    }

    public static NullValue forNumber(int value) {
        if (value == 0) goto L6;
        return null;
    L6:
        return NULL_VALUE;
    }

    public static Internal.EnumLiteMap<NullValue> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return NullValueVerifier.INSTANCE;
    }

    private NullValue(String $enum$name, int $enum$ordinal, int value) {
        super($enum$name, $enum$ordinal);
        this.value = value;
    }
}

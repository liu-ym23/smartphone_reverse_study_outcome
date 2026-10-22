package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* JADX INFO: loaded from: classes4.dex */
public final enum KeyStatusType extends Enum<KeyStatusType> implements Internal.EnumLite {
    private static final /* synthetic */ KeyStatusType[] $VALUES = null;
    public static final KeyStatusType DESTROYED = null;
    public static final int DESTROYED_VALUE = 3;
    public static final KeyStatusType DISABLED = null;
    public static final int DISABLED_VALUE = 2;
    public static final KeyStatusType ENABLED = null;
    public static final int ENABLED_VALUE = 1;
    public static final KeyStatusType UNKNOWN_STATUS = null;
    public static final int UNKNOWN_STATUS_VALUE = 0;
    public static final KeyStatusType UNRECOGNIZED = null;
    private static final Internal.EnumLiteMap<KeyStatusType> internalValueMap = null;
    private final int value;

    private static final class KeyStatusTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private KeyStatusTypeVerifier() {
        }

        static {
            INSTANCE = new KeyStatusTypeVerifier();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            if (KeyStatusType.forNumber(number) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static KeyStatusType valueOf(String name) {
        return (KeyStatusType) Enum.valueOf(KeyStatusType.class, name);
    }

    public static KeyStatusType[] values() {
        return (KeyStatusType[]) $VALUES.clone();
    }

    static {
        KeyStatusType r0 = new KeyStatusType("UNKNOWN_STATUS", 0, 0);
        UNKNOWN_STATUS = r0;
        KeyStatusType r1 = new KeyStatusType("ENABLED", 1, 1);
        ENABLED = r1;
        KeyStatusType r3 = new KeyStatusType("DISABLED", 2, 2);
        DISABLED = r3;
        KeyStatusType r5 = new KeyStatusType("DESTROYED", 3, 3);
        DESTROYED = r5;
        KeyStatusType r7 = new KeyStatusType("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r7;
        $VALUES = new KeyStatusType[]{r0, r1, r3, r5, r7};
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
    public static KeyStatusType valueOf(int value) {
        return forNumber(value);
    }

    public static KeyStatusType forNumber(int value) {
        if (value == 0) goto L18;
        if (value == 1) goto L16;
        if (value == 2) goto L14;
        if (value == 3) goto L12;
        return null;
    L12:
        return DESTROYED;
    L14:
        return DISABLED;
    L16:
        return ENABLED;
    L18:
        return UNKNOWN_STATUS;
    }

    public static Internal.EnumLiteMap<KeyStatusType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return KeyStatusTypeVerifier.INSTANCE;
    }

    private KeyStatusType(String $enum$name, int $enum$ordinal, int value) {
        super($enum$name, $enum$ordinal);
        this.value = value;
    }
}

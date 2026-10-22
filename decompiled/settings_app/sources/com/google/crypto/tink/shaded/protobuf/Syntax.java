package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes4.dex */
public final enum Syntax extends java.lang.Enum<Syntax> implements Internal.EnumLite {
    private static final /* synthetic */ Syntax[] $VALUES = null;
    public static final Syntax SYNTAX_EDITIONS = null;
    public static final int SYNTAX_EDITIONS_VALUE = 2;
    public static final Syntax SYNTAX_PROTO2 = null;
    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final Syntax SYNTAX_PROTO3 = null;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    public static final Syntax UNRECOGNIZED = null;
    private static final Internal.EnumLiteMap<Syntax> internalValueMap = null;
    private final int value;

    private static final class SyntaxVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private SyntaxVerifier() {
        }

        static {
            INSTANCE = new SyntaxVerifier();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            if (Syntax.forNumber(number) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static Syntax valueOf(String name) {
        return (Syntax) java.lang.Enum.valueOf(Syntax.class, name);
    }

    public static Syntax[] values() {
        return (Syntax[]) $VALUES.clone();
    }

    static {
        Syntax r0 = new Syntax("SYNTAX_PROTO2", 0, 0);
        SYNTAX_PROTO2 = r0;
        Syntax r1 = new Syntax("SYNTAX_PROTO3", 1, 1);
        SYNTAX_PROTO3 = r1;
        Syntax r3 = new Syntax("SYNTAX_EDITIONS", 2, 2);
        SYNTAX_EDITIONS = r3;
        Syntax r5 = new Syntax("UNRECOGNIZED", 3, -1);
        UNRECOGNIZED = r5;
        $VALUES = new Syntax[]{r0, r1, r3, r5};
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
    public static Syntax valueOf(int value) {
        return forNumber(value);
    }

    public static Syntax forNumber(int value) {
        if (value == 0) goto L14;
        if (value == 1) goto L12;
        if (value == 2) goto L10;
        return null;
    L10:
        return SYNTAX_EDITIONS;
    L12:
        return SYNTAX_PROTO3;
    L14:
        return SYNTAX_PROTO2;
    }

    public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return SyntaxVerifier.INSTANCE;
    }

    private Syntax(String $enum$name, int $enum$ordinal, int value) {
        super($enum$name, $enum$ordinal);
        this.value = value;
    }
}

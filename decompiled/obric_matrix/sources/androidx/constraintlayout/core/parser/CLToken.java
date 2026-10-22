package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class CLToken extends CLElement {
    int index;
    char[] tokenFalse;
    char[] tokenNull;
    char[] tokenTrue;
    Type type;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.parser.CLToken$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type = null;

        static {
            int[] r0 = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type = r0;
            r0[Type.TRUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.FALSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.NULL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type FALSE = null;
        public static final Type NULL = null;
        public static final Type TRUE = null;
        public static final Type UNKNOWN = null;

        static {
            Type r0 = new Type("UNKNOWN", 0);
            UNKNOWN = r0;
            Type r1 = new Type("TRUE", 1);
            TRUE = r1;
            Type r3 = new Type("FALSE", 2);
            FALSE = r3;
            Type r5 = new Type("NULL", 3);
            NULL = r5;
            $VALUES = new Type[]{r0, r1, r3, r5};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public CLToken(char[] r1) {
        super(r1);
        this.index = 0;
        this.type = Type.UNKNOWN;
        this.tokenTrue = "true".toCharArray();
        this.tokenFalse = "false".toCharArray();
        this.tokenNull = "null".toCharArray();
    }

    public static CLElement allocate(char[] r1) {
        return new CLToken(r1);
    }

    public boolean getBoolean() {
        Type r0 = this.type;
        if (r0 != Type.TRUE) goto L7;
        return true;
    L7:
        if (r0 != Type.FALSE) goto L11;
        return false;
    L11:
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    public Type getType() {
        return this.type;
    }

    public boolean isNull() {
        if (this.type != Type.NULL) goto L7;
        return true;
    L7:
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int r1, int r2) {
        StringBuilder r3 = new StringBuilder();
        addIndent(r3, r1);
        r3.append(content());
        return r3.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        if (CLParser.DEBUG == false) goto L7;
        return "<" + content() + ">";
    L7:
        return content();
    }

    public boolean validate(char r6, long r7) {
        int r0 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[this.type.ordinal()];
        boolean r1 = false;
        if (r0 != 1) goto L5;
        char[] r2 = this.tokenTrue;
        int r3 = this.index;
        if (r2[r3] != r6) goto L38;
        r1 = true;
    L38:
        if (r1 == true) goto L40;
    L42:
        this.index++;
        return r1;
    L40:
        if ((r3 + 1) != r2.length) goto L42;
    L27:
        setEnd(r7);
        goto L42
    L5:
        if (r0 != 2) goto L7;
        char[] r4 = this.tokenFalse;
        int r5 = this.index;
        if (r4[r5] != r6) goto L31;
        r1 = true;
    L31:
        if (r1 == false) goto L42;
        if ((r5 + 1) != r4.length) goto L42;
    L7:
        if (r0 != 3) goto L9;
        char[] r8 = this.tokenNull;
        int r9 = this.index;
        if (r8[r9] != r6) goto L24;
        r1 = true;
    L24:
        if (r1 == false) goto L42;
        if ((r9 + 1) != r8.length) goto L42;
    L9:
        if (r0 != 4) goto L42;
        char[] r10 = this.tokenTrue;
        int r11 = this.index;
        if (r10[r11] != r6) goto L16;
        Type r12 = Type.TRUE;
    L14:
        this.type = r12;
        r1 = true;
        goto L42
    L16:
        if (this.tokenFalse[r11] != r6) goto L19;
        r12 = Type.FALSE;
        goto L14
    L19:
        if (this.tokenNull[r11] != r6) goto L42;
        r12 = Type.NULL;
        goto L14
    }
}

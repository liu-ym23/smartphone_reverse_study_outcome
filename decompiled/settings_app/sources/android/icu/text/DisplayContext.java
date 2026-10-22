package android.icu.text;

/* JADX INFO: loaded from: classes.dex */
public final enum DisplayContext extends Enum<DisplayContext> {
    private static final /* synthetic */ DisplayContext[] $VALUES = null;
    public static final DisplayContext CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE = null;
    public static final DisplayContext CAPITALIZATION_FOR_MIDDLE_OF_SENTENCE = null;
    public static final DisplayContext CAPITALIZATION_FOR_STANDALONE = null;
    public static final DisplayContext CAPITALIZATION_FOR_UI_LIST_OR_MENU = null;
    public static final DisplayContext CAPITALIZATION_NONE = null;
    public static final DisplayContext DIALECT_NAMES = null;
    public static final DisplayContext LENGTH_FULL = null;
    public static final DisplayContext LENGTH_SHORT = null;
    public static final DisplayContext NO_SUBSTITUTE = null;
    public static final DisplayContext STANDARD_NAMES = null;
    public static final DisplayContext SUBSTITUTE = null;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type CAPITALIZATION = null;
        public static final Type DIALECT_HANDLING = null;
        public static final Type DISPLAY_LENGTH = null;
        public static final Type SUBSTITUTE_HANDLING = null;

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Type r0 = new Type("DIALECT_HANDLING", 0);
            DIALECT_HANDLING = r0;
            Type r1 = new Type("CAPITALIZATION", 1);
            CAPITALIZATION = r1;
            Type r3 = new Type("DISPLAY_LENGTH", 2);
            DISPLAY_LENGTH = r3;
            Type r5 = new Type("SUBSTITUTE_HANDLING", 3);
            SUBSTITUTE_HANDLING = r5;
            $VALUES = new Type[]{r0, r1, r3, r5};
        }
    }

    public static DisplayContext valueOf(String r1) {
        return (DisplayContext) Enum.valueOf(DisplayContext.class, r1);
    }

    public static DisplayContext[] values() {
        return (DisplayContext[]) $VALUES.clone();
    }

    private DisplayContext(String r1, int r2) {
        super(r1, r2);
    }

    static {
        DisplayContext r0 = new DisplayContext("STANDARD_NAMES", 0);
        STANDARD_NAMES = r0;
        DisplayContext r1 = new DisplayContext("DIALECT_NAMES", 1);
        DIALECT_NAMES = r1;
        DisplayContext r3 = new DisplayContext("CAPITALIZATION_NONE", 2);
        CAPITALIZATION_NONE = r3;
        DisplayContext r5 = new DisplayContext("CAPITALIZATION_FOR_MIDDLE_OF_SENTENCE", 3);
        CAPITALIZATION_FOR_MIDDLE_OF_SENTENCE = r5;
        DisplayContext r7 = new DisplayContext("CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE", 4);
        CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE = r7;
        DisplayContext r9 = new DisplayContext("CAPITALIZATION_FOR_UI_LIST_OR_MENU", 5);
        CAPITALIZATION_FOR_UI_LIST_OR_MENU = r9;
        DisplayContext r11 = new DisplayContext("CAPITALIZATION_FOR_STANDALONE", 6);
        CAPITALIZATION_FOR_STANDALONE = r11;
        DisplayContext r13 = new DisplayContext("LENGTH_FULL", 7);
        LENGTH_FULL = r13;
        DisplayContext r15 = new DisplayContext("LENGTH_SHORT", 8);
        LENGTH_SHORT = r15;
        DisplayContext r14 = new DisplayContext("SUBSTITUTE", 9);
        SUBSTITUTE = r14;
        DisplayContext r12 = new DisplayContext("NO_SUBSTITUTE", 10);
        NO_SUBSTITUTE = r12;
        $VALUES = new DisplayContext[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
    }

    public Type type() {
        throw new RuntimeException("Stub!");
    }

    public int value() {
        throw new RuntimeException("Stub!");
    }
}

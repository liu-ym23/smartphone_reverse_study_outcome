package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class CLParser {
    static boolean DEBUG = false;
    private boolean hasComment;
    private int lineNumber;
    private String mContent;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.parser.CLParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE = null;

        static {
            int[] r0 = new int[TYPE.values().length];
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE = r0;
            r0[TYPE.OBJECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.ARRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.KEY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.TOKEN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static final enum TYPE extends Enum<TYPE> {
        private static final /* synthetic */ TYPE[] $VALUES = null;
        public static final TYPE ARRAY = null;
        public static final TYPE KEY = null;
        public static final TYPE NUMBER = null;
        public static final TYPE OBJECT = null;
        public static final TYPE STRING = null;
        public static final TYPE TOKEN = null;
        public static final TYPE UNKNOWN = null;

        static {
            TYPE r0 = new TYPE("UNKNOWN", 0);
            UNKNOWN = r0;
            TYPE r1 = new TYPE("OBJECT", 1);
            OBJECT = r1;
            TYPE r3 = new TYPE("ARRAY", 2);
            ARRAY = r3;
            TYPE r5 = new TYPE("NUMBER", 3);
            NUMBER = r5;
            TYPE r7 = new TYPE("STRING", 4);
            STRING = r7;
            TYPE r9 = new TYPE("KEY", 5);
            KEY = r9;
            TYPE r11 = new TYPE("TOKEN", 6);
            TOKEN = r11;
            $VALUES = new TYPE[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private TYPE(String r1, int r2) {
            super(r1, r2);
        }

        public static TYPE valueOf(String r1) {
            return (TYPE) Enum.valueOf(TYPE.class, r1);
        }

        public static TYPE[] values() {
            return (TYPE[]) $VALUES.clone();
        }
    }

    static {
    }

    public CLParser(String r2) {
        this.hasComment = false;
        this.mContent = r2;
    }

    private CLElement createElement(CLElement r4, int r5, TYPE r6, boolean r7, char[] r8) {
        if (DEBUG == false) goto L6;
        System.out.println("CREATE " + r6 + " at " + r8[r5]);
    L6:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[r6.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L7:
        CLElement r9 = null;
    L15:
        if (r9 != null) goto L17;
        return null;
    L17:
        r9.setLine(this.lineNumber);
        if (r7 == false) goto L21;
        r9.setStart(r5);
    L21:
        if ((r4 instanceof CLContainer) == false) goto L23;
        r9.setContainer((CLContainer) r4);
    L23:
        return r9;
    L8:
        r9 = CLToken.allocate(r8);
        goto L15
    L9:
        r9 = CLKey.allocate(r8);
        goto L15
    L10:
        r9 = CLNumber.allocate(r8);
        goto L15
    L11:
        r9 = CLString.allocate(r8);
        goto L15
    L12:
        r9 = CLArray.allocate(r8);
    L14:
        r5 = r5 + 1;
        goto L15
    L13:
        r9 = CLObject.allocate(r8);
        goto L14
    }

    private CLElement getNextJsonElement(int r8, char r9, CLElement r10, char[] r11) {
        if (r9 != '\t') goto L5;
        return r10;
    L5:
        if (r9 != '\n') goto L7;
        return r10;
    L7:
        if (r9 != '\r') goto L9;
        return r10;
    L9:
        if (r9 != ' ') goto L11;
        return r10;
    L11:
        if (r9 == '\"') goto L43;
        if (r9 == '\'') goto L43;
        if (r9 == '[') goto L59;
        if (r9 != ']') goto L19;
    L40:
        r10.setEnd(r8 - 1);
        CLElement r12 = r10.getContainer();
        r12.setEnd(r8);
        return r12;
    L19:
        if (r9 == '{') goto L57;
        if (r9 == '}') goto L40;
        switch(r9) {
            case 43: goto L56;
            case 44: goto L51;
            case 45: goto L56;
            case 46: goto L56;
            case 47: goto L33;
            case 48: goto L56;
            case 49: goto L56;
            case 50: goto L56;
            case 51: goto L56;
            case 52: goto L56;
            case 53: goto L56;
            case 54: goto L56;
            case 55: goto L56;
            case 56: goto L56;
            case 57: goto L56;
            case 58: goto L51;
            default: goto L24;
        };
    L33:
        int r13 = r8 + 1;
        if (r13 < r11.length) goto L36;
        return r10;
    L36:
        if (r11[r13] != '/') goto L54;
        this.hasComment = true;
        return r10;
    L54:
        return r10;
    L51:
        return r10;
    L24:
        if ((r10 instanceof CLContainer) == false) goto L52;
        if ((r10 instanceof CLObject) == true) goto L52;
        CLElement r14 = createElement(r10, r8, TYPE.TOKEN, true, r11);
        CLToken r15 = (CLToken) r14;
        if (r15.validate(r9, r8) == false) goto L31;
        return r14;
    L31:
        throw new CLParsingException("incorrect token <" + r9 + "> at line " + this.lineNumber, r15);
    L52:
        return createElement(r10, r8, TYPE.KEY, true, r11);
    L56:
        return createElement(r10, r8, TYPE.NUMBER, true, r11);
    L57:
        return createElement(r10, r8, TYPE.OBJECT, true, r11);
    L59:
        return createElement(r10, r8, TYPE.ARRAY, true, r11);
    L43:
        if ((r10 instanceof CLObject) == false) goto L46;
        return createElement(r10, r8, TYPE.KEY, true, r11);
    L46:
        return createElement(r10, r8, TYPE.STRING, true, r11);
    }

    public static CLObject parse(String r1) {
        return new CLParser(r1).parse();
    }

    public CLObject parse() {
        char[] r1 = this.mContent.toCharArray();
        int r2 = r1.length;
        int r3 = 1;
        this.lineNumber = 1;
        boolean r4 = false;
        int r5 = 0;
    L4:
        if (r5 >= r2) goto L11;
        char r8 = r1[r5];
        if (r8 == '{') goto L12;
        if (r8 != '\n') goto L10;
        this.lineNumber++;
    L10:
        r5 = r5 + 1;
    L12:
        if (r5 == (-1)) goto L99;
        CLObject r6 = CLObject.allocate(r1);
        r6.setLine(this.lineNumber);
        r6.setStart(r5);
        int r7 = r5 + 1;
        CLElement r9 = r6;
    L14:
        if (r7 >= r2) goto L86;
        char r10 = r1[r7];
        if (r10 != '\n') goto L19;
        this.lineNumber += r3;
    L19:
        if (this.hasComment == false) goto L22;
        if (r10 != '\n') goto L85;
        this.hasComment = r4;
    L85:
        r7 = r7 + 1;
        r3 = 1;
        r4 = false;
    L22:
        if (r9 == null) goto L86;
        if (r9.isDone() == false) goto L28;
    L26:
        r9 = getNextJsonElement(r7, r10, r9, r1);
    L79:
        if (r9.isDone() == false) goto L85;
        if ((r9 instanceof CLKey) == true) goto L83;
    L84:
        r9 = r9.getContainer();
        goto L85
    L83:
        if (((CLKey) r9).mElements.size() <= 0) goto L85;
    L28:
        if ((r9 instanceof CLObject) == false) goto L32;
        if (r10 != '}') goto L26;
    L40:
        r9.setEnd(r7 - 1);
        goto L79
    L32:
        if ((r9 instanceof CLArray) == false) goto L35;
        if (r10 != ']') goto L26;
    L35:
        boolean r11 = r9 instanceof CLString;
        if (r11 == false) goto L42;
        long r12 = r9.start;
        if (r1[(int) r12] != r10) goto L79;
        r9.setStart(r12 + 1);
        goto L40
    L42:
        if ((r9 instanceof CLToken) == false) goto L49;
        CLToken r15 = (CLToken) r9;
        if (r15.validate(r10, r7) == true) goto L49;
        throw new CLParsingException("parsing incorrect token " + r15.content() + " at line " + this.lineNumber, r15);
    L49:
        if ((r9 instanceof CLKey) == true) goto L51;
        if (r11 == true) goto L51;
    L58:
        if (r9.isDone() == true) goto L79;
        if (r10 == '}') goto L72;
        if (r10 == ']') goto L72;
        if (r10 == ',') goto L72;
        if (r10 == ' ') goto L72;
        if (r10 == '\t') goto L72;
        if (r10 == '\r') goto L72;
        if (r10 == '\n') goto L72;
        if (r10 != ':') goto L79;
    L72:
        long r13 = r7 - 1;
        r9.setEnd(r13);
        if (r10 == '}') goto L75;
        if (r10 != ']') goto L79;
    L75:
        r9 = r9.getContainer();
        r9.setEnd(r13);
        if ((r9 instanceof CLKey) == false) goto L79;
        r9 = r9.getContainer();
        r9.setEnd(r13);
    L51:
        long r14 = r9.start;
        char r16 = r1[(int) r14];
        if (r16 != '\'') goto L54;
    L55:
        if (r16 != r10) goto L58;
        r9.setStart(r14 + 1);
        r9.setEnd(r7 - 1);
        goto L58
    L54:
        if (r16 != '\"') goto L58;
    L86:
        if (r9 == null) goto L95;
        if (r9.isDone() == true) goto L95;
        if ((r9 instanceof CLString) == false) goto L93;
        r9.setStart(((int) r9.start) + 1);
    L93:
        r9.setEnd(r2 - 1);
        r9 = r9.getContainer();
    L95:
        if (DEBUG == false) goto L97;
        System.out.println("Root: " + r6.toJSON());
    L97:
        return r6;
    L99:
        throw new CLParsingException("invalid json content", null);
    L11:
        r5 = -1;
        goto L12
    }
}

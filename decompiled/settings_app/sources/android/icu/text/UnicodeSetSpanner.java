package android.icu.text;

/* JADX INFO: loaded from: classes.dex */
public class UnicodeSetSpanner {

    public static final enum CountMethod extends Enum<CountMethod> {
        private static final /* synthetic */ CountMethod[] $VALUES = null;
        public static final CountMethod MIN_ELEMENTS = null;
        public static final CountMethod WHOLE_SPAN = null;

        public static CountMethod valueOf(String r1) {
            return (CountMethod) Enum.valueOf(CountMethod.class, r1);
        }

        public static CountMethod[] values() {
            return (CountMethod[]) $VALUES.clone();
        }

        private CountMethod(String r1, int r2) {
            super(r1, r2);
        }

        static {
            CountMethod r0 = new CountMethod("WHOLE_SPAN", 0);
            WHOLE_SPAN = r0;
            CountMethod r1 = new CountMethod("MIN_ELEMENTS", 1);
            MIN_ELEMENTS = r1;
            $VALUES = new CountMethod[]{r0, r1};
        }
    }

    public static final enum TrimOption extends Enum<TrimOption> {
        private static final /* synthetic */ TrimOption[] $VALUES = null;
        public static final TrimOption BOTH = null;
        public static final TrimOption LEADING = null;
        public static final TrimOption TRAILING = null;

        public static TrimOption valueOf(String r1) {
            return (TrimOption) Enum.valueOf(TrimOption.class, r1);
        }

        public static TrimOption[] values() {
            return (TrimOption[]) $VALUES.clone();
        }

        private TrimOption(String r1, int r2) {
            super(r1, r2);
        }

        static {
            TrimOption r0 = new TrimOption("LEADING", 0);
            LEADING = r0;
            TrimOption r1 = new TrimOption("BOTH", 1);
            BOTH = r1;
            TrimOption r3 = new TrimOption("TRAILING", 2);
            TRAILING = r3;
            $VALUES = new TrimOption[]{r0, r1, r3};
        }
    }

    public UnicodeSetSpanner(UnicodeSet r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet getUnicodeSet() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public int countIn(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public int countIn(CharSequence r1, CountMethod r2) {
        throw new RuntimeException("Stub!");
    }

    public int countIn(CharSequence r1, CountMethod r2, UnicodeSet.SpanCondition r3) {
        throw new RuntimeException("Stub!");
    }

    public String deleteFrom(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public String deleteFrom(CharSequence r1, UnicodeSet.SpanCondition r2) {
        throw new RuntimeException("Stub!");
    }

    public String replaceFrom(CharSequence r1, CharSequence r2) {
        throw new RuntimeException("Stub!");
    }

    public String replaceFrom(CharSequence r1, CharSequence r2, CountMethod r3) {
        throw new RuntimeException("Stub!");
    }

    public String replaceFrom(CharSequence r1, CharSequence r2, CountMethod r3, UnicodeSet.SpanCondition r4) {
        throw new RuntimeException("Stub!");
    }

    public CharSequence trim(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public CharSequence trim(CharSequence r1, TrimOption r2) {
        throw new RuntimeException("Stub!");
    }

    public CharSequence trim(CharSequence r1, TrimOption r2, UnicodeSet.SpanCondition r3) {
        throw new RuntimeException("Stub!");
    }
}

package android.icu.text;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class IDNA {
    public static final int CHECK_BIDI = 4;
    public static final int CHECK_CONTEXTJ = 8;
    public static final int CHECK_CONTEXTO = 64;
    public static final int DEFAULT = 0;
    public static final int NONTRANSITIONAL_TO_ASCII = 16;
    public static final int NONTRANSITIONAL_TO_UNICODE = 32;
    public static final int USE_STD3_RULES = 2;

    public static final enum Error extends Enum<Error> {
        private static final /* synthetic */ Error[] $VALUES = null;
        public static final Error BIDI = null;
        public static final Error CONTEXTJ = null;
        public static final Error CONTEXTO_DIGITS = null;
        public static final Error CONTEXTO_PUNCTUATION = null;
        public static final Error DISALLOWED = null;
        public static final Error DOMAIN_NAME_TOO_LONG = null;
        public static final Error EMPTY_LABEL = null;
        public static final Error HYPHEN_3_4 = null;
        public static final Error INVALID_ACE_LABEL = null;
        public static final Error LABEL_HAS_DOT = null;
        public static final Error LABEL_TOO_LONG = null;
        public static final Error LEADING_COMBINING_MARK = null;
        public static final Error LEADING_HYPHEN = null;
        public static final Error PUNYCODE = null;
        public static final Error TRAILING_HYPHEN = null;

        public static Error valueOf(String r1) {
            return (Error) Enum.valueOf(Error.class, r1);
        }

        public static Error[] values() {
            return (Error[]) $VALUES.clone();
        }

        private Error(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Error r0 = new Error("EMPTY_LABEL", 0);
            EMPTY_LABEL = r0;
            Error r1 = new Error("LABEL_TOO_LONG", 1);
            LABEL_TOO_LONG = r1;
            Error r3 = new Error("DOMAIN_NAME_TOO_LONG", 2);
            DOMAIN_NAME_TOO_LONG = r3;
            Error r5 = new Error("LEADING_HYPHEN", 3);
            LEADING_HYPHEN = r5;
            Error r7 = new Error("TRAILING_HYPHEN", 4);
            TRAILING_HYPHEN = r7;
            Error r9 = new Error("HYPHEN_3_4", 5);
            HYPHEN_3_4 = r9;
            Error r11 = new Error("LEADING_COMBINING_MARK", 6);
            LEADING_COMBINING_MARK = r11;
            Error r13 = new Error("DISALLOWED", 7);
            DISALLOWED = r13;
            Error r15 = new Error("PUNYCODE", 8);
            PUNYCODE = r15;
            Error r14 = new Error("LABEL_HAS_DOT", 9);
            LABEL_HAS_DOT = r14;
            Error r12 = new Error("INVALID_ACE_LABEL", 10);
            INVALID_ACE_LABEL = r12;
            Error r10 = new Error("BIDI", 11);
            BIDI = r10;
            Error r8 = new Error("CONTEXTJ", 12);
            CONTEXTJ = r8;
            Error r6 = new Error("CONTEXTO_PUNCTUATION", 13);
            CONTEXTO_PUNCTUATION = r6;
            Error r4 = new Error("CONTEXTO_DIGITS", 14);
            CONTEXTO_DIGITS = r4;
            $VALUES = new Error[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4};
        }
    }

    public static final class Info {
        public Info() {
            throw new RuntimeException("Stub!");
        }

        public boolean hasErrors() {
            throw new RuntimeException("Stub!");
        }

        public Set<Error> getErrors() {
            throw new RuntimeException("Stub!");
        }

        public boolean isTransitionalDifferent() {
            throw new RuntimeException("Stub!");
        }
    }

    public abstract StringBuilder labelToASCII(CharSequence r1, StringBuilder r2, Info r3);

    public abstract StringBuilder labelToUnicode(CharSequence r1, StringBuilder r2, Info r3);

    public abstract StringBuilder nameToASCII(CharSequence r1, StringBuilder r2, Info r3);

    public abstract StringBuilder nameToUnicode(CharSequence r1, StringBuilder r2, Info r3);

    IDNA() {
        throw new RuntimeException("Stub!");
    }

    public static IDNA getUTS46Instance(int r1) {
        throw new RuntimeException("Stub!");
    }
}

package com.google.common.base;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract enum CaseFormat extends Enum<CaseFormat> {
    private static final /* synthetic */ CaseFormat[] $VALUES = null;
    public static final CaseFormat LOWER_CAMEL = null;
    public static final CaseFormat LOWER_HYPHEN = null;
    public static final CaseFormat LOWER_UNDERSCORE = null;
    public static final CaseFormat UPPER_CAMEL = null;
    public static final CaseFormat UPPER_UNDERSCORE = null;
    private final CharMatcher wordBoundary;
    private final String wordSeparator;

    private static final class StringConverter extends Converter<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;

        @Override // com.google.common.base.Converter
        protected /* bridge */ /* synthetic */ String doBackward(String r1) {
            return doBackward2(r1);
        }

        @Override // com.google.common.base.Converter
        protected /* bridge */ /* synthetic */ String doForward(String r1) {
            return doForward2(r1);
        }

        StringConverter(CaseFormat r1, CaseFormat r2) {
            this.sourceFormat = (CaseFormat) Preconditions.checkNotNull(r1);
            this.targetFormat = (CaseFormat) Preconditions.checkNotNull(r2);
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        protected String doForward2(String r2) {
            return this.sourceFormat.to(this.targetFormat, r2);
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        protected String doBackward2(String r2) {
            return this.targetFormat.to(this.sourceFormat, r2);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@CheckForNull Object r4) {
            if ((r4 instanceof StringConverter) == false) goto L10;
            StringConverter r5 = (StringConverter) r4;
            if (this.sourceFormat.equals(r5.sourceFormat) == true) goto L7;
            return false;
        L7:
            if (this.targetFormat.equals(r5.targetFormat) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = this.sourceFormat.hashCode();
            return this.targetFormat.hashCode() ^ r0;
        }

        public String toString() {
            String r0 = String.valueOf(this.sourceFormat);
            String r3 = String.valueOf(this.targetFormat);
            return new StringBuilder((String.valueOf(r0).length() + 14) + String.valueOf(r3).length()).append(r0).append(".converterTo(").append(r3).append(")").toString();
        }
    }

    abstract String normalizeWord(String r1);

    private static /* synthetic */ CaseFormat[] $values() {
        return new CaseFormat[]{LOWER_HYPHEN, LOWER_UNDERSCORE, LOWER_CAMEL, UPPER_CAMEL, UPPER_UNDERSCORE};
    }

    public static CaseFormat valueOf(String r1) {
        return (CaseFormat) Enum.valueOf(CaseFormat.class, r1);
    }

    public static CaseFormat[] values() {
        return (CaseFormat[]) $VALUES.clone();
    }

    /* synthetic */ CaseFormat(String r1, int r2, CharMatcher r3, String r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    static /* synthetic */ String access$100(String r0) {
        return firstCharOnlyToUpper(r0);
    }

    static {
        final CharMatcher r1 = CharMatcher.is('-');
        final String r2 = "-";
        final String r3 = "LOWER_HYPHEN";
        final int r4 = 0;
        LOWER_HYPHEN = new AnonymousClass1(r3, r4, r1, r2);
        final CharMatcher r5 = CharMatcher.is('_');
        final String r6 = "LOWER_UNDERSCORE";
        final int r7 = 1;
        final String r8 = "_";
        LOWER_UNDERSCORE = new AnonymousClass2(r6, r7, r5, r8);
        final CharMatcher r9 = CharMatcher.inRange('A', 'Z');
        final String r10 = "LOWER_CAMEL";
        final int r11 = 2;
        final String r12 = "";
        LOWER_CAMEL = new AnonymousClass3(r10, r11, r9, r12);
        final int r13 = 3;
        final CharMatcher r14 = CharMatcher.inRange('A', 'Z');
        final String r15 = "UPPER_CAMEL";
        UPPER_CAMEL = new AnonymousClass4(r15, r13, r14, r12);
        final int r16 = 4;
        final CharMatcher r17 = CharMatcher.is('_');
        final String r18 = "UPPER_UNDERSCORE";
        UPPER_UNDERSCORE = new AnonymousClass5(r18, r16, r17, r8);
        $VALUES = $values();
    }

    private CaseFormat(String r1, int r2, CharMatcher r3, String r4) {
        super(r1, r2);
        this.wordBoundary = r3;
        this.wordSeparator = r4;
    }

    public final String to(CaseFormat r1, String r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        if (r1 != this) goto L6;
        return r2;
    L6:
        return convert(r1, r2);
    }

    String convert(CaseFormat r7, String r8) {
        StringBuilder r0 = null;
        int r1 = 0;
        int r3 = -1;
    L3:
        r3 = this.wordBoundary.indexIn(r8, r3 + 1);
        if (r3 == (-1)) goto L9;
        if (r1 != 0) goto L7;
        r0 = new StringBuilder(r8.length() + (r7.wordSeparator.length() * 4));
        r0.append(r7.normalizeFirstWord(r8.substring(r1, r3)));
    L8:
        r0.append(r7.wordSeparator);
        r1 = this.wordSeparator.length() + r3;
        goto L3
    L7:
        ((StringBuilder) java.util.Objects.requireNonNull(r0)).append(r7.normalizeWord(r8.substring(r1, r3)));
        goto L8
    L9:
        if (r1 != 0) goto L12;
        return r7.normalizeFirstWord(r8);
    L12:
        return ((StringBuilder) java.util.Objects.requireNonNull(r0)).append(r7.normalizeWord(r8.substring(r1))).toString();
    }

    public Converter<String, String> converterTo(CaseFormat r2) {
        return new StringConverter(this, r2);
    }

    String normalizeFirstWord(String r1) {
        return normalizeWord(r1);
    }

    private static String firstCharOnlyToUpper(String r3) {
        if (r3.isEmpty() == true) goto L7;
        char r0 = Ascii.toUpperCase(r3.charAt(0));
        String r4 = Ascii.toLowerCase(r3.substring(1));
        return new StringBuilder(String.valueOf(r4).length() + 1).append(r0).append(r4).toString();
    L7:
        return r3;
    }
}

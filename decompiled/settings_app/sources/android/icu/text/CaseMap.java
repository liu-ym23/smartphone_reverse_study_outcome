package android.icu.text;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class CaseMap {

    /* JADX INFO: renamed from: android.icu.text.CaseMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Fold extends CaseMap {
        @Override // android.icu.text.CaseMap
        public /* bridge */ /* synthetic */ CaseMap omitUnchangedText() {
            return omitUnchangedText();
        }

        private Fold() {
            super(null);
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.CaseMap
        public Fold omitUnchangedText() {
            throw new RuntimeException("Stub!");
        }

        public Fold turkic() {
            throw new RuntimeException("Stub!");
        }

        public String apply(CharSequence r1) {
            throw new RuntimeException("Stub!");
        }

        public <A extends Appendable> A apply(CharSequence r1, A r2, Edits r3) {
            throw new RuntimeException("Stub!");
        }
    }

    public static final class Lower extends CaseMap {
        @Override // android.icu.text.CaseMap
        public /* bridge */ /* synthetic */ CaseMap omitUnchangedText() {
            return omitUnchangedText();
        }

        private Lower() {
            super(null);
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.CaseMap
        public Lower omitUnchangedText() {
            throw new RuntimeException("Stub!");
        }

        public String apply(Locale r1, CharSequence r2) {
            throw new RuntimeException("Stub!");
        }

        public <A extends Appendable> A apply(Locale r1, CharSequence r2, A r3, Edits r4) {
            throw new RuntimeException("Stub!");
        }
    }

    public static final class Title extends CaseMap {
        @Override // android.icu.text.CaseMap
        public /* bridge */ /* synthetic */ CaseMap omitUnchangedText() {
            return omitUnchangedText();
        }

        private Title() {
            super(null);
            throw new RuntimeException("Stub!");
        }

        public Title wholeString() {
            throw new RuntimeException("Stub!");
        }

        public Title sentences() {
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.CaseMap
        public Title omitUnchangedText() {
            throw new RuntimeException("Stub!");
        }

        public Title noLowercase() {
            throw new RuntimeException("Stub!");
        }

        public Title noBreakAdjustment() {
            throw new RuntimeException("Stub!");
        }

        public Title adjustToCased() {
            throw new RuntimeException("Stub!");
        }

        public String apply(Locale r1, BreakIterator r2, CharSequence r3) {
            throw new RuntimeException("Stub!");
        }

        public <A extends Appendable> A apply(Locale r1, BreakIterator r2, CharSequence r3, A r4, Edits r5) {
            throw new RuntimeException("Stub!");
        }
    }

    public static final class Upper extends CaseMap {
        @Override // android.icu.text.CaseMap
        public /* bridge */ /* synthetic */ CaseMap omitUnchangedText() {
            return omitUnchangedText();
        }

        private Upper() {
            super(null);
            throw new RuntimeException("Stub!");
        }

        @Override // android.icu.text.CaseMap
        public Upper omitUnchangedText() {
            throw new RuntimeException("Stub!");
        }

        public String apply(Locale r1, CharSequence r2) {
            throw new RuntimeException("Stub!");
        }

        public <A extends Appendable> A apply(Locale r1, CharSequence r2, A r3, Edits r4) {
            throw new RuntimeException("Stub!");
        }
    }

    public abstract CaseMap omitUnchangedText();

    /* synthetic */ CaseMap(AnonymousClass1 r1) {
        this();
    }

    private CaseMap() {
        throw new RuntimeException("Stub!");
    }

    public static Lower toLower() {
        throw new RuntimeException("Stub!");
    }

    public static Upper toUpper() {
        throw new RuntimeException("Stub!");
    }

    public static Title toTitle() {
        throw new RuntimeException("Stub!");
    }

    public static Fold fold() {
        throw new RuntimeException("Stub!");
    }
}

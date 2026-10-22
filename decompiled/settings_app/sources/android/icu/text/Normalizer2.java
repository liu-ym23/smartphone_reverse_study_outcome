package android.icu.text;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class Normalizer2 {

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode COMPOSE = null;
        public static final Mode COMPOSE_CONTIGUOUS = null;
        public static final Mode DECOMPOSE = null;
        public static final Mode FCD = null;

        public static Mode valueOf(String r1) {
            return (Mode) Enum.valueOf(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Mode r0 = new Mode("COMPOSE", 0);
            COMPOSE = r0;
            Mode r1 = new Mode("DECOMPOSE", 1);
            DECOMPOSE = r1;
            Mode r3 = new Mode("FCD", 2);
            FCD = r3;
            Mode r5 = new Mode("COMPOSE_CONTIGUOUS", 3);
            COMPOSE_CONTIGUOUS = r5;
            $VALUES = new Mode[]{r0, r1, r3, r5};
        }
    }

    public abstract StringBuilder append(StringBuilder r1, CharSequence r2);

    public abstract String getDecomposition(int r1);

    public abstract boolean hasBoundaryAfter(int r1);

    public abstract boolean hasBoundaryBefore(int r1);

    public abstract boolean isInert(int r1);

    public abstract boolean isNormalized(CharSequence r1);

    public abstract Appendable normalize(CharSequence r1, Appendable r2);

    public abstract StringBuilder normalize(CharSequence r1, StringBuilder r2);

    public abstract StringBuilder normalizeSecondAndAppend(StringBuilder r1, CharSequence r2);

    public abstract Normalizer.QuickCheckResult quickCheck(CharSequence r1);

    public abstract int spanQuickCheckYes(CharSequence r1);

    Normalizer2() {
        throw new RuntimeException("Stub!");
    }

    public static Normalizer2 getNFCInstance() {
        throw new RuntimeException("Stub!");
    }

    public static Normalizer2 getNFDInstance() {
        throw new RuntimeException("Stub!");
    }

    public static Normalizer2 getNFKCInstance() {
        throw new RuntimeException("Stub!");
    }

    public static Normalizer2 getNFKDInstance() {
        throw new RuntimeException("Stub!");
    }

    public static Normalizer2 getNFKCCasefoldInstance() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public static Normalizer2 getInstance(InputStream r0, String r1, Mode r2) {
        throw new RuntimeException("Stub!");
    }

    public String normalize(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public String getRawDecomposition(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int composePair(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public int getCombiningClass(int r1) {
        throw new RuntimeException("Stub!");
    }
}

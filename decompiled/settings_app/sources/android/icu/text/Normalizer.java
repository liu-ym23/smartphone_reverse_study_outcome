package android.icu.text;

/* JADX INFO: loaded from: classes.dex */
public final class Normalizer implements Cloneable {
    public static final int COMPARE_CODE_POINT_ORDER = 32768;
    public static final int COMPARE_IGNORE_CASE = 65536;
    public static final int FOLD_CASE_DEFAULT = 0;
    public static final int FOLD_CASE_EXCLUDE_SPECIAL_I = 1;
    public static final int INPUT_IS_FCD = 131072;
    public static final QuickCheckResult MAYBE = null;
    public static final QuickCheckResult NO = null;
    public static final QuickCheckResult YES = null;

    public static final class QuickCheckResult {
        private QuickCheckResult() {
            throw new RuntimeException("Stub!");
        }
    }

    static {
    }

    Normalizer() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    public static int compare(char[] r0, int r1, int r2, char[] r3, int r4, int r5, int r6) {
        throw new RuntimeException("Stub!");
    }

    public static int compare(String r0, String r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public static int compare(char[] r0, char[] r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public static int compare(int r0, int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public static int compare(int r0, String r1, int r2) {
        throw new RuntimeException("Stub!");
    }
}

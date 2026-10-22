package android.icu.text;

/* JADX INFO: loaded from: classes.dex */
public interface UnicodeMatcher {
    public static final char ETHER = 65535;
    public static final int U_MATCH = 2;
    public static final int U_MISMATCH = 0;
    public static final int U_PARTIAL_MATCH = 1;

    void addMatchSetTo(UnicodeSet r1);

    int matches(Replaceable r1, int[] r2, int r3, boolean r4);

    boolean matchesIndexValue(int r1);

    String toPattern(boolean r1);
}

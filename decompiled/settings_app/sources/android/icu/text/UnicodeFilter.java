package android.icu.text;

/* JADX INFO: loaded from: classes.dex */
public abstract class UnicodeFilter implements UnicodeMatcher {
    public abstract boolean contains(int r1);

    UnicodeFilter() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.UnicodeMatcher
    public int matches(Replaceable r1, int[] r2, int r3, boolean r4) {
        throw new RuntimeException("Stub!");
    }
}

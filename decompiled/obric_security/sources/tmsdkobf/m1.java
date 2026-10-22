package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public abstract class m1 {
    public static long a(int r2, long r3) {
        if (r2 < 0) goto L10;
        if (r3 < 0) goto L8;
        return ((long) r2) + r3;
    L8:
        throw new IllegalStateException("thread pool parent-ident is illegal");
    L10:
        throw new IllegalStateException("thread pool sub-ident is negative");
    }
}

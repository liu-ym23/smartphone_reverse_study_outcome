package tmsdk.common;

/* JADX INFO: loaded from: classes5.dex */
public class CallerIdent {
    public static final long DEFAULT = 9223372032559808512L;
    public static final long TMS = 4294967296L;
    public static final int TMS_IDENT_NONE = 3;

    public CallerIdent() {
    }

    public static long getIdent(int r2, long r3) {
        if (r2 < 0) goto L10;
        if (r3 < 0) goto L8;
        return ((long) r2) + r3;
    L8:
        throw new IllegalStateException("thread pool parent-ident is illegal");
    L10:
        throw new IllegalStateException("thread pool sub-ident is negative");
    }
}

package androidx.tracing;

/* JADX INFO: loaded from: classes.dex */
final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(String r0, int r1) {
        android.os.Trace.beginAsyncSection(r0, r1);
    }

    public static void endAsyncSection(String r0, int r1) {
        android.os.Trace.endAsyncSection(r0, r1);
    }

    public static void setCounter(String r2, int r3) {
        android.os.Trace.setCounter(r2, r3);
    }
}

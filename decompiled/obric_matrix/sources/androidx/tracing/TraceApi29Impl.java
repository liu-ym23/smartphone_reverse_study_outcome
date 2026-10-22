package androidx.tracing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(@NonNull String r0, int r1) {
        android.os.Trace.beginAsyncSection(r0, r1);
    }

    public static void endAsyncSection(@NonNull String r0, int r1) {
        android.os.Trace.endAsyncSection(r0, r1);
    }

    public static void setCounter(@NonNull String r2, int r3) {
        android.os.Trace.setCounter(r2, r3);
    }
}

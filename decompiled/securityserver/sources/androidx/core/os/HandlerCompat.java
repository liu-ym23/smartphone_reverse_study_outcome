package androidx.core.os;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class HandlerCompat {
    private static final String TAG = "HandlerCompat";

    private HandlerCompat() {
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper r0) {
        return Handler.createAsync(r0);
    }

    public static boolean postDelayed(@NonNull Handler r0, @NonNull Runnable r1, @Nullable Object r2, long r3) {
        return r0.postDelayed(r1, r2, r3);
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper r0, @NonNull Handler.Callback r1) {
        return Handler.createAsync(r0, r1);
    }
}

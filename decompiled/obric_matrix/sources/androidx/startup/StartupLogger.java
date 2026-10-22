package androidx.startup;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class StartupLogger {
    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";

    private StartupLogger() {
    }

    public static void e(@NonNull String r1, @Nullable Throwable r2) {
        Log.e(TAG, r1, r2);
    }

    public static void i(@NonNull String r1) {
        Log.i(TAG, r1);
    }

    public static void w(@NonNull String r1) {
        Log.w(TAG, r1);
    }
}

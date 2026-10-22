package androidx.core.provider;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
class CalleeHandler {
    private CalleeHandler() {
    }

    @NonNull
    static Handler create() {
        if (Looper.myLooper() != null) goto L6;
        return new Handler(Looper.getMainLooper());
    L6:
        return new Handler();
    }
}

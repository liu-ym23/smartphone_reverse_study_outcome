package androidx.core.app;

import android.app.Dialog;
import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class DialogCompat {

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static <T> T requireViewById(Dialog r0, int r1) {
            return (T) r0.requireViewById(r1);
        }
    }

    private DialogCompat() {
    }

    @NonNull
    public static View requireViewById(@NonNull Dialog r2, int r3) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        View r4 = r2.findViewById(r3);
        if (r4 == null) goto L10;
        return r4;
    L10:
        throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
    L5:
        return (View) Api28Impl.requireViewById(r2, r3);
    }
}

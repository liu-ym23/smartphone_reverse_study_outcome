package androidx.core.app;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class DialogCompat {

    static class Api28Impl {
        private Api28Impl() {
        }

        static <T> T requireViewById(Dialog r0, int r1) {
            return (T) r0.requireViewById(r1);
        }
    }

    private DialogCompat() {
    }

    public static View requireViewById(Dialog r0, int r1) {
        return (View) Api28Impl.requireViewById(r0, r1);
    }
}

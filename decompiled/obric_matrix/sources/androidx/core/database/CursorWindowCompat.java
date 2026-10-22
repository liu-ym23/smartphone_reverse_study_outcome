package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class CursorWindowCompat {

    @RequiresApi(15)
    static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static CursorWindow createCursorWindow(String r1) {
            return new CursorWindow(r1);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static CursorWindow createCursorWindow(String r1, long r2) {
            return new CursorWindow(r1, r2);
        }
    }

    private CursorWindowCompat() {
    }

    @NonNull
    public static CursorWindow create(@Nullable String r2, long r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L7;
        return Api28Impl.createCursorWindow(r2, r3);
    L7:
        if (r0 < 15) goto L11;
        return Api15Impl.createCursorWindow(r2);
    L11:
        return new CursorWindow(false);
    }
}

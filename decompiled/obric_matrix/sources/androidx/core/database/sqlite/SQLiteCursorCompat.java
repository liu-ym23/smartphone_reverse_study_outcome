package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class SQLiteCursorCompat {

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static void setFillWindowForwardOnly(SQLiteCursor r0, boolean r1) {
            r0.setFillWindowForwardOnly(r1);
        }
    }

    private SQLiteCursorCompat() {
    }

    public static void setFillWindowForwardOnly(@NonNull SQLiteCursor r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28Impl.setFillWindowForwardOnly(r2, r3);
        return;
    }
}

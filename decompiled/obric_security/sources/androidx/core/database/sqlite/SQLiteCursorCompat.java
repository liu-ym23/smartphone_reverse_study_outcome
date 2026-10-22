package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;

/* JADX INFO: loaded from: classes.dex */
public final class SQLiteCursorCompat {

    static class Api28Impl {
        private Api28Impl() {
        }

        static void setFillWindowForwardOnly(SQLiteCursor r0, boolean r1) {
            r0.setFillWindowForwardOnly(r1);
        }
    }

    private SQLiteCursorCompat() {
    }

    public static void setFillWindowForwardOnly(SQLiteCursor r0, boolean r1) {
        Api28Impl.setFillWindowForwardOnly(r0, r1);
    }
}

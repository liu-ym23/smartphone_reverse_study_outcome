package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

/* JADX INFO: loaded from: classes.dex */
class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    private final SQLiteProgram mDelegate;

    FrameworkSQLiteProgram(SQLiteProgram r1) {
        this.mDelegate = r1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r1, byte[] r2) {
        this.mDelegate.bindBlob(r1, r2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r1, double r2) {
        this.mDelegate.bindDouble(r1, r2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r1, long r2) {
        this.mDelegate.bindLong(r1, r2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r1) {
        this.mDelegate.bindNull(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r1, String r2) {
        this.mDelegate.bindString(r1, r2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.mDelegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDelegate.close();
    }
}

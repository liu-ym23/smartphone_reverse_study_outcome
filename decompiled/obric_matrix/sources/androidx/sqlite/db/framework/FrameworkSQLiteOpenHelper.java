package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* JADX INFO: loaded from: classes.dex */
class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    private final OpenHelper mDelegate;

    static class OpenHelper extends SQLiteOpenHelper {
        final SupportSQLiteOpenHelper.Callback mCallback;
        final FrameworkSQLiteDatabase[] mDbRef;
        private boolean mMigrated;

        OpenHelper(Context r7, String r8, final FrameworkSQLiteDatabase[] r9, final SupportSQLiteOpenHelper.Callback r10) {
            super(r7, r8, null, r10.version, new AnonymousClass1(r10, r9));
            this.mCallback = r10;
            this.mDbRef = r9;
        }

        static FrameworkSQLiteDatabase getWrappedDb(FrameworkSQLiteDatabase[] r2, SQLiteDatabase r3) {
            FrameworkSQLiteDatabase r1 = r2[0];
            if (r1 != null) goto L5;
        L6:
            r2[0] = new FrameworkSQLiteDatabase(r3);
        L8:
            return r2[0];
        L5:
            if (r1.isDelegate(r3) == true) goto L8;
            goto L6
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            monitor-enter(this);
            super.close();     // Catch: Throwable -> L6
            this.mDbRef[0] = null;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized SupportSQLiteDatabase getReadableSupportDatabase() {
            monitor-enter(this);
            this.mMigrated = false;     // Catch: Throwable -> L12
            SQLiteDatabase r0 = super.getReadableDatabase();     // Catch: Throwable -> L12
            if (this.mMigrated == false) goto L9;
            close();     // Catch: Throwable -> L12
            SupportSQLiteDatabase r1 = getReadableSupportDatabase();     // Catch: Throwable -> L12
            monitor-exit(this);
            return r1;
        L9:
            FrameworkSQLiteDatabase r2 = getWrappedDb(r0);     // Catch: Throwable -> L12
            monitor-exit(this);
            return r2;
        L12:
            th = move-exception;
            throw th;
        }

        FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase r1) {
            return getWrappedDb(this.mDbRef, r1);
        }

        synchronized SupportSQLiteDatabase getWritableSupportDatabase() {
            monitor-enter(this);
            this.mMigrated = false;     // Catch: Throwable -> L12
            SQLiteDatabase r0 = super.getWritableDatabase();     // Catch: Throwable -> L12
            if (this.mMigrated == false) goto L9;
            close();     // Catch: Throwable -> L12
            SupportSQLiteDatabase r1 = getWritableSupportDatabase();     // Catch: Throwable -> L12
            monitor-exit(this);
            return r1;
        L9:
            FrameworkSQLiteDatabase r2 = getWrappedDb(r0);     // Catch: Throwable -> L12
            monitor-exit(this);
            return r2;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase r2) {
            this.mCallback.onConfigure(getWrappedDb(r2));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r2) {
            this.mCallback.onCreate(getWrappedDb(r2));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r2, int r3, int r4) {
            this.mMigrated = true;
            this.mCallback.onDowngrade(getWrappedDb(r2), r3, r4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase r2) {
            if (this.mMigrated == true) goto L6;
            this.mCallback.onOpen(getWrappedDb(r2));
            return;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r2, int r3, int r4) {
            this.mMigrated = true;
            this.mCallback.onUpgrade(getWrappedDb(r2), r3, r4);
        }
    }

    FrameworkSQLiteOpenHelper(Context r1, String r2, SupportSQLiteOpenHelper.Callback r3) {
        this.mDelegate = createDelegate(r1, r2, r3);
    }

    private OpenHelper createDelegate(Context r2, String r3, SupportSQLiteOpenHelper.Callback r4) {
        return new OpenHelper(r2, r3, new FrameworkSQLiteDatabase[1], r4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void close() {
        this.mDelegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return this.mDelegate.getReadableSupportDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return this.mDelegate.getWritableSupportDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean r1) {
        this.mDelegate.setWriteAheadLoggingEnabled(r1);
    }
}

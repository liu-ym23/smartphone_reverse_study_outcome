package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.room.util.CopyLock;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes.dex */
class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper {

    @NonNull
    private final Context mContext;

    @Nullable
    private final String mCopyFromAssetPath;

    @Nullable
    private final File mCopyFromFile;

    @Nullable
    private DatabaseConfiguration mDatabaseConfiguration;
    private final int mDatabaseVersion;

    @NonNull
    private final SupportSQLiteOpenHelper mDelegate;
    private boolean mVerified;

    SQLiteCopyOpenHelper(@NonNull Context r1, @Nullable String r2, @Nullable File r3, int r4, @NonNull SupportSQLiteOpenHelper r5) {
        this.mContext = r1;
        this.mCopyFromAssetPath = r2;
        this.mCopyFromFile = r3;
        this.mDatabaseVersion = r4;
        this.mDelegate = r5;
    }

    private void copyDatabaseFile(File r4) {
        if (this.mCopyFromAssetPath == null) goto L6;
        ReadableByteChannel r0 = Channels.newChannel(this.mContext.getAssets().open(this.mCopyFromAssetPath));
    L8:
        File r3 = File.createTempFile("room-copy-helper", ".tmp", this.mContext.getCacheDir());
        r3.deleteOnExit();
        FileUtil.copy(r0, new FileOutputStream(r3).getChannel());
        File r1 = r4.getParentFile();
        if (r1 == null) goto L18;
        if (r1.exists() == true) goto L18;
        if (r1.mkdirs() == true) goto L18;
        throw new IOException("Failed to create directories for " + r4.getAbsolutePath());
    L18:
        if (r3.renameTo(r4) == false) goto L21;
        return;
    L21:
        throw new IOException("Failed to move intermediate file (" + r3.getAbsolutePath() + ") to destination (" + r4.getAbsolutePath() + ").");
    L6:
        if (this.mCopyFromFile == null) goto L23;
        r0 = new FileInputStream(this.mCopyFromFile).getChannel();
        goto L8
    L23:
        throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
    }

    private void verifyDatabaseFile() {
        String r1 = getDatabaseName();
        File r2 = this.mContext.getDatabasePath(r1);
        DatabaseConfiguration r3 = this.mDatabaseConfiguration;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        CopyLock r5 = new CopyLock(r1, this.mContext.getFilesDir(), r4);
        r5.lock();     // Catch: Throwable -> L45
        if (r2.exists() == true) goto L20;
        copyDatabaseFile(r2);     // Catch: IOException -> L16 Throwable -> L45
        r5.unlock();
        return;
    L16:
        e = move-exception;
        throw new RuntimeException("Unable to copy database file.", e);     // Catch: Throwable -> L45
    L20:
        if (this.mDatabaseConfiguration != null) goto L48;
        r5.unlock();
        return;
    L48:
        int r6 = DBUtil.readVersion(r2);     // Catch: IOException -> L41 Throwable -> L45
        int r7 = this.mDatabaseVersion;     // Catch: Throwable -> L45
        if (r6 != r7) goto L29;
        r5.unlock();
        return;
    L29:
        if (this.mDatabaseConfiguration.isMigrationRequired(r6, r7) == false) goto L33;
        r5.unlock();
        return;
    L33:
        if (this.mContext.deleteDatabase(r1) == true) goto L50;
        Log.w("ROOM", "Failed to delete database file (" + r1 + ") for a copy destructive migration.");     // Catch: Throwable -> L45
    L39:
        r5.unlock();
        return;
    L50:
        copyDatabaseFile(r2);     // Catch: IOException -> L36 Throwable -> L45
    L36:
        e = move-exception;
        Log.w("ROOM", "Unable to copy database file.", e);     // Catch: Throwable -> L45
        goto L39
    L41:
        e = move-exception;
        Log.w("ROOM", "Unable to read database version.", e);     // Catch: Throwable -> L45
        r5.unlock();
        return;
    L45:
        th = move-exception;
        r5.unlock();
        throw th;
    L5:
        if (r3.multiInstanceInvalidation == true) goto L8;
        r4 = false;
        goto L9
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized void close() {
        monitor-enter(this);
        this.mDelegate.close();     // Catch: Throwable -> L6
        this.mVerified = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase getReadableDatabase() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mVerified == true) goto L6;
        verifyDatabaseFile();     // Catch: Throwable -> L9
        this.mVerified = true;     // Catch: Throwable -> L9
    L6:
        SupportSQLiteDatabase r0 = this.mDelegate.getReadableDatabase();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase getWritableDatabase() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mVerified == true) goto L6;
        verifyDatabaseFile();     // Catch: Throwable -> L9
        this.mVerified = true;     // Catch: Throwable -> L9
    L6:
        SupportSQLiteDatabase r0 = this.mDelegate.getWritableDatabase();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    void setDatabaseConfiguration(@Nullable DatabaseConfiguration r1) {
        this.mDatabaseConfiguration = r1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean r1) {
        this.mDelegate.setWriteAheadLoggingEnabled(r1);
    }
}

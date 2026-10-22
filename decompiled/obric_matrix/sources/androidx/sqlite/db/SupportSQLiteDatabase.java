package androidx.sqlite.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import java.io.Closeable;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public interface SupportSQLiteDatabase extends Closeable {
    void beginTransaction();

    void beginTransactionNonExclusive();

    void beginTransactionWithListener(SQLiteTransactionListener r1);

    void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r1);

    SupportSQLiteStatement compileStatement(String r1);

    int delete(String r1, String r2, Object[] r3);

    @RequiresApi(api = 16)
    void disableWriteAheadLogging();

    boolean enableWriteAheadLogging();

    void endTransaction();

    void execSQL(String r1);

    void execSQL(String r1, Object[] r2);

    List<Pair<String, String>> getAttachedDbs();

    long getMaximumSize();

    long getPageSize();

    String getPath();

    int getVersion();

    boolean inTransaction();

    long insert(String r1, int r2, ContentValues r3);

    boolean isDatabaseIntegrityOk();

    boolean isDbLockedByCurrentThread();

    boolean isOpen();

    boolean isReadOnly();

    @RequiresApi(api = 16)
    boolean isWriteAheadLoggingEnabled();

    boolean needUpgrade(int r1);

    Cursor query(SupportSQLiteQuery r1);

    @RequiresApi(api = 16)
    Cursor query(SupportSQLiteQuery r1, CancellationSignal r2);

    Cursor query(String r1);

    Cursor query(String r1, Object[] r2);

    @RequiresApi(api = 16)
    void setForeignKeyConstraintsEnabled(boolean r1);

    void setLocale(Locale r1);

    void setMaxSqlCacheSize(int r1);

    long setMaximumSize(long r1);

    void setPageSize(long r1);

    void setTransactionSuccessful();

    void setVersion(int r1);

    int update(String r1, int r2, ContentValues r3, String r4, Object[] r5);

    boolean yieldIfContendedSafely();

    boolean yieldIfContendedSafely(long r1);
}

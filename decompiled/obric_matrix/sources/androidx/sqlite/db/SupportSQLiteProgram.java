package androidx.sqlite.db;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int r1, byte[] r2);

    void bindDouble(int r1, double r2);

    void bindLong(int r1, long r2);

    void bindNull(int r1);

    void bindString(int r1, String r2);

    void clearBindings();
}

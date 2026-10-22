package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface SupportSQLiteOpenHelper {

    public static abstract class Callback {
        private static final String TAG = "SupportSQLite";
        public final int version;

        public Callback(int r1) {
            this.version = r1;
        }

        private void deleteDatabaseFile(String r3) {
            if (r3.equalsIgnoreCase(":memory:") == false) goto L5;
            return;
        L5:
            if (r3.trim().length() == 0) goto L29;
            Log.w(TAG, "deleting the database file: " + r3);
        L19:
            e = move-exception;
            Log.w(TAG, "delete failed: ", e);
            return;
        L9:
            if (Build.VERSION.SDK_INT < 16) goto L25;
            SQLiteDatabase.deleteDatabase(new File(r3));     // Catch: Exception -> L19
        L22:
            return;
        L25:
        L16:
            e = move-exception;
            Log.e(TAG, "error while deleting corrupted database file", e);     // Catch: Exception -> L19
            goto L22
        L13:
            if (new File(r3).delete() == true) goto L22;
            Log.e(TAG, "Could not delete the database file " + r3);     // Catch: Exception -> L16
        }

        public void onConfigure(SupportSQLiteDatabase r1) {
        }

        public void onCorruption(SupportSQLiteDatabase r3) {
            Log.e(TAG, "Corruption reported by sqlite on database: " + r3.getPath());
            if (r3.isOpen() == true) goto L6;
            deleteDatabaseFile(r3.getPath());
            return;
        L6:
            List<Pair<String, String>> r0 = null;
            r0 = r3.getAttachedDbs();     // Catch: Throwable -> L9 SQLiteException -> L27
        L9:
            th = move-exception;
            if (r0 == null) goto L18;
            Iterator<Pair<String, String>> r4 = r0.iterator();
        L16:
            if (r4.hasNext() == false) goto L19;
            deleteDatabaseFile((String) r4.next().second);
        L19:
            throw th;
        L18:
            deleteDatabaseFile(r3.getPath());
        L29:
            r3.close();     // Catch: Throwable -> L9 IOException -> L28
        L20:
            if (r0 == null) goto L25;
            Iterator<Pair<String, String>> r5 = r0.iterator();
        L23:
            if (r5.hasNext() == false) goto L35;
            deleteDatabaseFile((String) r5.next().second);
            goto L23
        L35:
            return;
        L25:
            deleteDatabaseFile(r3.getPath());
        }

        public abstract void onCreate(SupportSQLiteDatabase r1);

        public void onDowngrade(SupportSQLiteDatabase r2, int r3, int r4) {
            throw new SQLiteException("Can't downgrade database from version " + r3 + " to " + r4);
        }

        public void onOpen(SupportSQLiteDatabase r1) {
        }

        public abstract void onUpgrade(SupportSQLiteDatabase r1, int r2, int r3);
    }

    public static class Configuration {

        @NonNull
        public final Callback callback;

        @NonNull
        public final Context context;

        @Nullable
        public final String name;

        public static class Builder {
            Callback mCallback;
            Context mContext;
            String mName;

            Builder(@NonNull Context r1) {
                this.mContext = r1;
            }

            public Configuration build() {
                Callback r0 = this.mCallback;
                if (r0 == null) goto L11;
                Context r1 = this.mContext;
                if (r1 == null) goto L9;
                return new Configuration(r1, this.mName, r0);
            L9:
                throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
            L11:
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            }

            public Builder callback(@NonNull Callback r1) {
                this.mCallback = r1;
                return this;
            }

            public Builder name(@Nullable String r1) {
                this.mName = r1;
                return this;
            }
        }

        Configuration(@NonNull Context r1, @Nullable String r2, @NonNull Callback r3) {
            this.context = r1;
            this.name = r2;
            this.callback = r3;
        }

        public static Builder builder(Context r1) {
            return new Builder(r1);
        }
    }

    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration r1);
    }

    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean r1);
}

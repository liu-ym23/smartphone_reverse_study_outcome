package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SupportSQLiteOpenHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H'R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Ljava/io/Closeable;", "databaseName", "", "getDatabaseName", "()Ljava/lang/String;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", "close", "", "setWriteAheadLoggingEnabled", "enabled", "", "Callback", "Configuration", "Factory", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SupportSQLiteOpenHelper extends Closeable {

    /* JADX INFO: compiled from: SupportSQLiteOpenHelper.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H&R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "", "version", "", "(I)V", "deleteDatabaseFile", "", "fileName", "", "onConfigure", CloudControlInf.DB, "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onCorruption", "onCreate", "onDowngrade", "oldVersion", "newVersion", "onOpen", "onUpgrade", "Companion", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Callback {
        public static final Companion Companion = null;
        private static final String TAG = "SupportSQLite";
        public final int version;

        /* JADX INFO: compiled from: SupportSQLiteOpenHelper.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback$Companion;", "", "()V", "TAG", "", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        public void onConfigure(SupportSQLiteDatabase r1) {
            Intrinsics.checkNotNullParameter(r1, CloudControlInf.DB);
        }

        public abstract void onCreate(SupportSQLiteDatabase r1);

        public void onOpen(SupportSQLiteDatabase r1) {
            Intrinsics.checkNotNullParameter(r1, CloudControlInf.DB);
        }

        public abstract void onUpgrade(SupportSQLiteDatabase r1, int r2, int r3);

        public Callback(int r1) {
            this.version = r1;
        }

        public void onDowngrade(SupportSQLiteDatabase r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, CloudControlInf.DB);
            throw new SQLiteException("Can't downgrade database from version " + r3 + " to " + r4);
        }

        public void onCorruption(SupportSQLiteDatabase r4) {
            Intrinsics.checkNotNullParameter(r4, CloudControlInf.DB);
            Log.e(TAG, "Corruption reported by sqlite on database: " + r4 + ".path");
            if (r4.isOpen() == true) goto L8;
            String r5 = r4.getPath();
            if (r5 == null) goto L41;
            deleteDatabaseFile(r5);
            return;
        L41:
            return;
        L8:
            List<Pair<String, String>> r1 = null;
            r1 = r4.getAttachedDbs();     // Catch: Throwable -> L11 SQLiteException -> L33
        L11:
            th = move-exception;
            if (r1 == null) goto L20;
            Iterator<T> r6 = r1.iterator();
        L18:
            if (r6.hasNext() == false) goto L23;
            Object r2 = ((Pair) r6.next()).second;
            Intrinsics.checkNotNullExpressionValue(r2, "p.second");
            deleteDatabaseFile((String) r2);
        L23:
            throw th;
        L20:
            String r7 = r4.getPath();
            if (r7 == null) goto L23;
            deleteDatabaseFile(r7);
        L37:
            r4.close();     // Catch: Throwable -> L11 IOException -> L34
        L24:
            if (r1 == null) goto L29;
            Iterator<T> r8 = r1.iterator();
        L27:
            if (r8.hasNext() == false) goto L43;
            Object r3 = ((Pair) r8.next()).second;
            Intrinsics.checkNotNullExpressionValue(r3, "p.second");
            deleteDatabaseFile((String) r3);
            goto L27
        L43:
            return;
        L29:
            String r9 = r4.getPath();
            if (r9 == null) goto L42;
            deleteDatabaseFile(r9);
            return;
        }

        private final void deleteDatabaseFile(String r8) {
            boolean r0 = true;
            if (StringsKt.equals(r8, ":memory:", true) == true) goto L44;
            String r7 = r8;
            int r1 = r7.length() - 1;
            int r3 = 0;
            boolean r4 = false;
        L5:
            if (r3 > r1) goto L21;
            if (r4 == true) goto L8;
            int r5 = r3;
        L10:
            if (Intrinsics.compare(r7.charAt(r5), 32) > 0) goto L12;
            boolean r6 = true;
        L13:
            if (r4 == false) goto L14;
            if (r6 == false) goto L21;
            r1 = r1 - 1;
            goto L5
        L14:
            if (r6 == false) goto L15;
            r3 = r3 + 1;
            goto L5
        L15:
            r4 = true;
            goto L5
        L12:
            r6 = false;
            goto L13
        L8:
            r5 = r1;
        L21:
            if (r7.subSequence(r3, r1 + 1).toString().length() == 0) goto L24;
            r0 = false;
        L24:
            if (r0 == true) goto L45;
            Log.w(TAG, "deleting the database file: " + r8);
            SupportSQLiteCompat.Api16Impl.deleteDatabase(new File(r8));     // Catch: Exception -> L29
            return;
        L29:
            e = move-exception;
            Log.w(TAG, "delete failed: ", e);
            return;
        L45:
            return;
        }
    }

    /* JADX INFO: compiled from: SupportSQLiteOpenHelper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR\u0010\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "", "context", "Landroid/content/Context;", "name", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "useNoBackupDirectory", "", "allowDataLossOnRecovery", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;ZZ)V", "Builder", "Companion", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Configuration {
        public static final Companion Companion = null;
        public final boolean allowDataLossOnRecovery;
        public final Callback callback;
        public final Context context;
        public final String name;
        public final boolean useNoBackupDirectory;

        /* JADX INFO: compiled from: SupportSQLiteOpenHelper.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowDataLossOnRecovery", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "name", "", "useNoBackupDirectory", "build", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "noBackupDirectory", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static class Builder {
            private boolean allowDataLossOnRecovery;
            private Callback callback;
            private final Context context;
            private String name;
            private boolean useNoBackupDirectory;

            public Builder(Context r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                this.context = r2;
            }

            public Configuration build() {
                Callback r3 = this.callback;
                if (r3 == null) goto L22;
                boolean r1 = true;
                if (this.useNoBackupDirectory == false) goto L16;
                String r0 = this.name;
                if (r0 != null) goto L9;
            L12:
                boolean r2 = true;
            L13:
                if (r2 == false) goto L16;
                r1 = false;
                goto L16
            L9:
                if (r0.length() == 0) goto L12;
                r2 = false;
            L16:
                if (r1 == false) goto L20;
                return new Configuration(this.context, this.name, r3, this.useNoBackupDirectory, this.allowDataLossOnRecovery);
            L20:
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.".toString());
            L22:
                throw new IllegalArgumentException("Must set a callback to create the configuration.".toString());
            }

            public Builder name(String r2) {
                this.name = r2;
                return this;
            }

            public Builder callback(Callback r2) {
                Intrinsics.checkNotNullParameter(r2, "callback");
                this.callback = r2;
                return this;
            }

            public Builder noBackupDirectory(boolean r2) {
                this.useNoBackupDirectory = r2;
                return this;
            }

            public Builder allowDataLossOnRecovery(boolean r2) {
                this.allowDataLossOnRecovery = r2;
                return this;
            }
        }

        /* JADX INFO: compiled from: SupportSQLiteOpenHelper.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Companion;", "", "()V", "builder", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "context", "Landroid/content/Context;", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Builder builder(Context r1) {
                Intrinsics.checkNotNullParameter(r1, "context");
                return new Builder(r1);
            }
        }

        static {
            Companion = new Companion(null);
        }

        @JvmStatic
        public static final Builder builder(Context r1) {
            return Companion.builder(r1);
        }

        public Configuration(Context r2, String r3, Callback r4, boolean r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, "callback");
            this.context = r2;
            this.name = r3;
            this.callback = r4;
            this.useNoBackupDirectory = r5;
            this.allowDataLossOnRecovery = r6;
        }

        public /* synthetic */ Configuration(Context r8, String r9, Callback r10, boolean r11, boolean r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 8) == 0) goto L5;
            boolean r5 = false;
        L7:
            if ((r13 & 16) == 0) goto L9;
            boolean r6 = false;
        L10:
            this(r8, r9, r10, r5, r6);
            return;
        L9:
            r6 = r12;
            goto L10
        L5:
            r5 = r11;
            goto L7
        }
    }

    /* JADX INFO: compiled from: SupportSQLiteOpenHelper.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "", "create", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "configuration", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration r1);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean r1);
}

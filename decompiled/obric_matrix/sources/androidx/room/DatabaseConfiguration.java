package androidx.room;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;

    @Nullable
    public final List<RoomDatabase.Callback> callbacks;

    @NonNull
    public final Context context;

    @Nullable
    public final String copyFromAssetPath;

    @Nullable
    public final File copyFromFile;
    public final RoomDatabase.JournalMode journalMode;
    private final Set<Integer> mMigrationNotRequiredFrom;

    @NonNull
    public final RoomDatabase.MigrationContainer migrationContainer;
    public final boolean multiInstanceInvalidation;

    @Nullable
    public final String name;

    @NonNull
    public final Executor queryExecutor;
    public final boolean requireMigration;

    @NonNull
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;

    @NonNull
    public final Executor transactionExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context r17, @Nullable String r18, @NonNull SupportSQLiteOpenHelper.Factory r19, @NonNull RoomDatabase.MigrationContainer r20, @Nullable List<RoomDatabase.Callback> r21, boolean r22, RoomDatabase.JournalMode r23, @NonNull Executor r24, @NonNull Executor r25, boolean r26, boolean r27, boolean r28, @Nullable Set<Integer> r29) {
        this(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, null, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NonNull Context r1, @Nullable String r2, @NonNull SupportSQLiteOpenHelper.Factory r3, @NonNull RoomDatabase.MigrationContainer r4, @Nullable List<RoomDatabase.Callback> r5, boolean r6, RoomDatabase.JournalMode r7, @NonNull Executor r8, @NonNull Executor r9, boolean r10, boolean r11, boolean r12, @Nullable Set<Integer> r13, @Nullable String r14, @Nullable File r15) {
        this.sqliteOpenHelperFactory = r3;
        this.context = r1;
        this.name = r2;
        this.migrationContainer = r4;
        this.callbacks = r5;
        this.allowMainThreadQueries = r6;
        this.journalMode = r7;
        this.queryExecutor = r8;
        this.transactionExecutor = r9;
        this.multiInstanceInvalidation = r10;
        this.requireMigration = r11;
        this.allowDestructiveMigrationOnDowngrade = r12;
        this.mMigrationNotRequiredFrom = r13;
        this.copyFromAssetPath = r14;
        this.copyFromFile = r15;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context r17, @Nullable String r18, @NonNull SupportSQLiteOpenHelper.Factory r19, @NonNull RoomDatabase.MigrationContainer r20, @Nullable List<RoomDatabase.Callback> r21, boolean r22, RoomDatabase.JournalMode r23, @NonNull Executor r24, boolean r25, @Nullable Set<Integer> r26) {
        this(r17, r18, r19, r20, r21, r22, r23, r24, r24, false, r25, false, r26, null, null);
    }

    public boolean isMigrationRequired(int r3, int r4) {
        if (r3 <= r4) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L11;
        if (this.allowDestructiveMigrationOnDowngrade == false) goto L11;
        return false;
    L11:
        if (this.requireMigration == false) goto L18;
        Set<Integer> r2 = this.mMigrationNotRequiredFrom;
        if (r2 != null) goto L15;
        return true;
    L15:
        if (r2.contains(Integer.valueOf(r3)) == true) goto L18;
        return true;
    L18:
        return false;
    L5:
        r5 = false;
        goto L6
    }

    @Deprecated
    public boolean isMigrationRequiredFrom(int r2) {
        return isMigrationRequired(r2, r2 + 1);
    }
}

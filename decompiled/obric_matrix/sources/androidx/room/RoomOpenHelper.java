package androidx.room;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {

    @Nullable
    private DatabaseConfiguration mConfiguration;

    @NonNull
    private final Delegate mDelegate;

    @NonNull
    private final String mIdentityHash;

    @NonNull
    private final String mLegacyHash;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class Delegate {
        public final int version;

        public Delegate(int r1) {
            this.version = r1;
        }

        protected abstract void createAllTables(SupportSQLiteDatabase r1);

        protected abstract void dropAllTables(SupportSQLiteDatabase r1);

        protected abstract void onCreate(SupportSQLiteDatabase r1);

        protected abstract void onOpen(SupportSQLiteDatabase r1);

        protected void onPostMigrate(SupportSQLiteDatabase r1) {
        }

        protected void onPreMigrate(SupportSQLiteDatabase r1) {
        }

        @NonNull
        protected ValidationResult onValidateSchema(@NonNull SupportSQLiteDatabase r2) {
            validateMigration(r2);
            return new ValidationResult(true, null);
        }

        @Deprecated
        protected void validateMigration(SupportSQLiteDatabase r1) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ValidationResult {

        @Nullable
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean r1, @Nullable String r2) {
            this.isValid = r1;
            this.expectedFoundMsg = r2;
        }
    }

    public RoomOpenHelper(@NonNull DatabaseConfiguration r2, @NonNull Delegate r3, @NonNull String r4) {
        this(r2, r3, "", r4);
    }

    public RoomOpenHelper(@NonNull DatabaseConfiguration r2, @NonNull Delegate r3, @NonNull String r4, @NonNull String r5) {
        super(r3.version);
        this.mConfiguration = r2;
        this.mDelegate = r3;
        this.mIdentityHash = r4;
        this.mLegacyHash = r5;
    }

    private void checkIdentity(SupportSQLiteDatabase r4) {
        if (hasRoomMasterTable(r4) == false) goto L18;
        String r0 = null;
        Cursor r5 = r4.query(new SimpleSQLiteQuery(RoomMasterTable.READ_QUERY));
    L15:
        th = move-exception;
        r5.close();
        throw th;
    L6:
        if (r5.moveToFirst() == false) goto L8;
        r0 = r5.getString(0);     // Catch: Throwable -> L15
    L8:
        r5.close();
        if (this.mIdentityHash.equals(r0) == false) goto L11;
        return;
    L11:
        if (this.mLegacyHash.equals(r0) == false) goto L14;
        return;
    L14:
        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
    L18:
        ValidationResult r1 = this.mDelegate.onValidateSchema(r4);
        if (r1.isValid == false) goto L23;
        this.mDelegate.onPostMigrate(r4);
        updateIdentity(r4);
        return;
    L23:
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r1.expectedFoundMsg);
    }

    private void createMasterTableIfNotExists(SupportSQLiteDatabase r1) {
        r1.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    private static boolean hasEmptySchema(SupportSQLiteDatabase r2) {
        Cursor r3 = r2.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        boolean r1 = false;
        if (r3.moveToFirst() == false) goto L8;
        if (r3.getInt(0) != 0) goto L8;
        r1 = true;
    L8:
        r3.close();
        return r1;
    L10:
        th = move-exception;
        r3.close();
        throw th;
    }

    private static boolean hasRoomMasterTable(SupportSQLiteDatabase r2) {
        Cursor r3 = r2.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        boolean r1 = false;
        if (r3.moveToFirst() == false) goto L8;
        if (r3.getInt(0) == 0) goto L8;
        r1 = true;
    L8:
        r3.close();
        return r1;
    L10:
        th = move-exception;
        r3.close();
        throw th;
    }

    private void updateIdentity(SupportSQLiteDatabase r1) {
        createMasterTableIfNotExists(r1);
        r1.execSQL(RoomMasterTable.createInsertQuery(this.mIdentityHash));
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(SupportSQLiteDatabase r1) {
        super.onConfigure(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(SupportSQLiteDatabase r3) {
        boolean r0 = hasEmptySchema(r3);
        this.mDelegate.createAllTables(r3);
        if (r0 == true) goto L9;
        ValidationResult r1 = this.mDelegate.onValidateSchema(r3);
        if (r1.isValid == true) goto L9;
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r1.expectedFoundMsg);
    L9:
        updateIdentity(r3);
        this.mDelegate.onCreate(r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(SupportSQLiteDatabase r1, int r2, int r3) {
        onUpgrade(r1, r2, r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(SupportSQLiteDatabase r2) {
        super.onOpen(r2);
        checkIdentity(r2);
        this.mDelegate.onOpen(r2);
        this.mConfiguration = null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(SupportSQLiteDatabase r3, int r4, int r5) {
        DatabaseConfiguration r0 = this.mConfiguration;
        if (r0 == null) goto L15;
        List<Migration> r1 = r0.migrationContainer.findMigrationPath(r4, r5);
        if (r1 == null) goto L15;
        this.mDelegate.onPreMigrate(r3);
        Iterator<Migration> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r2.next().migrate(r3);
        goto L8
    L10:
        ValidationResult r6 = this.mDelegate.onValidateSchema(r3);
        if (r6.isValid == false) goto L14;
        this.mDelegate.onPostMigrate(r3);
        updateIdentity(r3);
        boolean r7 = true;
    L16:
        if (r7 == true) goto L24;
        DatabaseConfiguration r8 = this.mConfiguration;
        if (r8 == null) goto L23;
        if (r8.isMigrationRequired(r4, r5) == true) goto L23;
        this.mDelegate.dropAllTables(r3);
        this.mDelegate.createAllTables(r3);
        return;
    L23:
        throw new IllegalStateException("A migration from " + r4 + " to " + r5 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    L24:
        return;
    L14:
        throw new IllegalStateException("Migration didn't properly handle: " + r6.expectedFoundMsg);
    L15:
        r7 = false;
        goto L16
    }
}

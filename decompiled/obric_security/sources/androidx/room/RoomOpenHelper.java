package androidx.room;

import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoomOpenHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/room/RoomOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "configuration", "Landroidx/room/DatabaseConfiguration;", "delegate", "Landroidx/room/RoomOpenHelper$Delegate;", "legacyHash", "", "(Landroidx/room/DatabaseConfiguration;Landroidx/room/RoomOpenHelper$Delegate;Ljava/lang/String;)V", "identityHash", "(Landroidx/room/DatabaseConfiguration;Landroidx/room/RoomOpenHelper$Delegate;Ljava/lang/String;Ljava/lang/String;)V", "checkIdentity", "", CloudControlInf.DB, "Landroidx/sqlite/db/SupportSQLiteDatabase;", "createMasterTableIfNotExists", "onConfigure", "onCreate", "onDowngrade", "oldVersion", "", "newVersion", "onOpen", "onUpgrade", "updateIdentity", "Companion", "Delegate", "ValidationResult", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    public static final Companion Companion = null;
    private DatabaseConfiguration configuration;
    private final Delegate delegate;
    private final String identityHash;
    private final String legacyHash;

    /* JADX INFO: compiled from: RoomOpenHelper.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/room/RoomOpenHelper$Companion;", "", "()V", "hasEmptySchema", "", CloudControlInf.DB, "Landroidx/sqlite/db/SupportSQLiteDatabase;", "hasEmptySchema$room_runtime_release", "hasRoomMasterTable", "hasRoomMasterTable$room_runtime_release", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final boolean hasRoomMasterTable$room_runtime_release(SupportSQLiteDatabase r3) {
            Intrinsics.checkNotNullParameter(r3, CloudControlInf.DB);
            Cursor r2 = r3.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            Cursor r4 = r2;     // Catch: Throwable -> L10
            boolean r1 = false;
            if (r4.moveToFirst() == false) goto L8;
            if (r4.getInt(0) == 0) goto L8;
            r1 = true;
        L8:
            CloseableKt.closeFinally(r2, null);
            return r1;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            CloseableKt.closeFinally(r2, th);
            throw th;
        }

        public final boolean hasEmptySchema$room_runtime_release(SupportSQLiteDatabase r3) {
            Intrinsics.checkNotNullParameter(r3, CloudControlInf.DB);
            Cursor r2 = r3.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            Cursor r4 = r2;     // Catch: Throwable -> L10
            boolean r1 = false;
            if (r4.moveToFirst() == false) goto L8;
            if (r4.getInt(0) != 0) goto L8;
            r1 = true;
        L8:
            CloseableKt.closeFinally(r2, null);
            return r1;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            CloseableKt.closeFinally(r2, th);
            throw th;
        }
    }

    /* JADX INFO: compiled from: RoomOpenHelper.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH\u0015R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/room/RoomOpenHelper$Delegate;", "", "version", "", "(I)V", "createAllTables", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "dropAllTables", "onCreate", "onOpen", "onPostMigrate", "onPreMigrate", "onValidateSchema", "Landroidx/room/RoomOpenHelper$ValidationResult;", CloudControlInf.DB, "validateMigration", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Delegate {
        public final int version;

        public abstract void createAllTables(SupportSQLiteDatabase r1);

        public abstract void dropAllTables(SupportSQLiteDatabase r1);

        public abstract void onCreate(SupportSQLiteDatabase r1);

        public abstract void onOpen(SupportSQLiteDatabase r1);

        public void onPostMigrate(SupportSQLiteDatabase r1) {
            Intrinsics.checkNotNullParameter(r1, "database");
        }

        public void onPreMigrate(SupportSQLiteDatabase r1) {
            Intrinsics.checkNotNullParameter(r1, "database");
        }

        public Delegate(int r1) {
            this.version = r1;
        }

        @Deprecated(message = "Use [onValidateSchema(SupportSQLiteDatabase)]")
        protected void validateMigration(SupportSQLiteDatabase r1) {
            Intrinsics.checkNotNullParameter(r1, CloudControlInf.DB);
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }

        public ValidationResult onValidateSchema(SupportSQLiteDatabase r2) {
            Intrinsics.checkNotNullParameter(r2, CloudControlInf.DB);
            validateMigration(r2);
            return new ValidationResult(true, null);
        }
    }

    /* JADX INFO: compiled from: RoomOpenHelper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/room/RoomOpenHelper$ValidationResult;", "", "isValid", "", "expectedFoundMsg", "", "(ZLjava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class ValidationResult {
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean r1, String r2) {
            this.isValid = r1;
            this.expectedFoundMsg = r2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RoomOpenHelper(DatabaseConfiguration r2, Delegate r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "configuration");
        Intrinsics.checkNotNullParameter(r3, "delegate");
        Intrinsics.checkNotNullParameter(r4, "identityHash");
        Intrinsics.checkNotNullParameter(r5, "legacyHash");
        super(r3.version);
        this.configuration = r2;
        this.delegate = r3;
        this.identityHash = r4;
        this.legacyHash = r5;
    }

    public RoomOpenHelper(DatabaseConfiguration r2, Delegate r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "configuration");
        Intrinsics.checkNotNullParameter(r3, "delegate");
        Intrinsics.checkNotNullParameter(r4, "legacyHash");
        this(r2, r3, "", r4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(SupportSQLiteDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, CloudControlInf.DB);
        super.onConfigure(r2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(SupportSQLiteDatabase r3) {
        Intrinsics.checkNotNullParameter(r3, CloudControlInf.DB);
        boolean r0 = Companion.hasEmptySchema$room_runtime_release(r3);
        this.delegate.createAllTables(r3);
        if (r0 == true) goto L9;
        ValidationResult r1 = this.delegate.onValidateSchema(r3);
        if (r1.isValid == true) goto L9;
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r1.expectedFoundMsg);
    L9:
        updateIdentity(r3);
        this.delegate.onCreate(r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(SupportSQLiteDatabase r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, CloudControlInf.DB);
        DatabaseConfiguration r0 = this.configuration;
        boolean r1 = false;
        if (r0 == null) goto L15;
        List<Migration> r2 = r0.migrationContainer.findMigrationPath(r4, r5);
        if (r2 == null) goto L15;
        this.delegate.onPreMigrate(r3);
        Iterator<T> r6 = r2.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        ((Migration) r6.next()).migrate(r3);
        goto L8
    L10:
        ValidationResult r7 = this.delegate.onValidateSchema(r3);
        if (r7.isValid == false) goto L14;
        this.delegate.onPostMigrate(r3);
        updateIdentity(r3);
        r1 = true;
        goto L15
    L14:
        throw new IllegalStateException("Migration didn't properly handle: " + r7.expectedFoundMsg);
    L15:
        if (r1 == true) goto L23;
        DatabaseConfiguration r8 = this.configuration;
        if (r8 == null) goto L22;
        if (r8.isMigrationRequired(r4, r5) == true) goto L22;
        this.delegate.dropAllTables(r3);
        this.delegate.createAllTables(r3);
        return;
    L22:
        throw new IllegalStateException("A migration from " + r4 + " to " + r5 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(SupportSQLiteDatabase r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, CloudControlInf.DB);
        onUpgrade(r2, r3, r4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(SupportSQLiteDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, CloudControlInf.DB);
        super.onOpen(r2);
        checkIdentity(r2);
        this.delegate.onOpen(r2);
        this.configuration = null;
    }

    private final void checkIdentity(SupportSQLiteDatabase r4) {
        if (Companion.hasRoomMasterTable$room_runtime_release(r4) == false) goto L22;
        Cursor r5 = r4.query(new SimpleSQLiteQuery(RoomMasterTable.READ_QUERY));
        Cursor r0 = r5;     // Catch: Throwable -> L17
        if (r0.moveToFirst() == false) goto L8;
        String r1 = r0.getString(0);     // Catch: Throwable -> L17
    L10:
        CloseableKt.closeFinally(r5, null);
        if (Intrinsics.areEqual(this.identityHash, r1) == false) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(this.legacyHash, r1) == false) goto L16;
        return;
    L16:
        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + this.identityHash + ", found: " + r1);
    L8:
        String r2 = (String) null;     // Catch: Throwable -> L17
        r1 = null;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L22:
        ValidationResult r3 = this.delegate.onValidateSchema(r4);
        if (r3.isValid == false) goto L27;
        this.delegate.onPostMigrate(r4);
        updateIdentity(r4);
        return;
    L27:
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r3.expectedFoundMsg);
    }

    private final void updateIdentity(SupportSQLiteDatabase r1) {
        createMasterTableIfNotExists(r1);
        r1.execSQL(RoomMasterTable.createInsertQuery(this.identityHash));
    }

    private final void createMasterTableIfNotExists(SupportSQLiteDatabase r1) {
        r1.execSQL(RoomMasterTable.CREATE_QUERY);
    }
}

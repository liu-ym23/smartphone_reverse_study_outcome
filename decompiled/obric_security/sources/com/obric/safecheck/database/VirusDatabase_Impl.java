package com.obric.safecheck.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.obric.safecheck.database.dao.VirusApkDao;
import com.obric.safecheck.database.dao.VirusApkDao_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class VirusDatabase_Impl extends VirusDatabase {
    private volatile VirusApkDao _virusApkDao;

    public VirusDatabase_Impl() {
    }

    static /* synthetic */ List access$000(VirusDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$100(VirusDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$1000(VirusDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$200(VirusDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$300(VirusDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$400(VirusDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$500(VirusDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ SupportSQLiteDatabase access$602(VirusDatabase_Impl r0, SupportSQLiteDatabase r1) {
        r0.mDatabase = r1;
        return r1;
    }

    static /* synthetic */ void access$700(VirusDatabase_Impl r0, SupportSQLiteDatabase r1) {
        r0.internalInitInvalidationTracker(r1);
    }

    static /* synthetic */ List access$800(VirusDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$900(VirusDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
        final int r2 = 2;
        RoomOpenHelper r0 = new RoomOpenHelper(configuration, new AnonymousClass1(this, r2), "2bd9b32f1bdaed5e3086b654b8dde38a", "7338531e2d37b93d2a5309cb8327edea");
        SupportSQLiteOpenHelper.Configuration r3 = SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(r0).build();
        return configuration.sqliteOpenHelperFactory.create(r3);
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"virus_apk_items"});
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `virus_apk_items`");     // Catch: Throwable -> L8
        super.setTransactionSuccessful();     // Catch: Throwable -> L8
        super.endTransaction();
        r2.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r2.inTransaction() == true) goto L15;
        r2.execSQL("VACUUM");
        return;
    L15:
        return;
    L8:
        th = move-exception;
        super.endTransaction();
        r2.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r2.inTransaction() == true) goto L12;
        r2.execSQL("VACUUM");
    L12:
        throw th;
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r2 = new HashMap();
        r2.put(VirusApkDao.class, VirusApkDao_Impl.getRequiredConverters());
        return r2;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // com.obric.safecheck.database.VirusDatabase
    public VirusApkDao virusApkDao() {
        if (this._virusApkDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._virusApkDao != null) goto L10;
        this._virusApkDao = new VirusApkDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        VirusApkDao r0 = this._virusApkDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._virusApkDao;
    }
}

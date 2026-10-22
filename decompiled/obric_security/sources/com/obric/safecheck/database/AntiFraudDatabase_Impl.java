package com.obric.safecheck.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.obric.safecheck.database.dao.EndDataDao;
import com.obric.safecheck.database.dao.EndDataDao_Impl;
import com.obric.safecheck.database.dao.GxbAntiFraudRuleDao;
import com.obric.safecheck.database.dao.GxbAntiFraudRuleDao_Impl;
import com.obric.safecheck.database.dao.PhoneDao;
import com.obric.safecheck.database.dao.PhoneDao_Impl;
import com.obric.safecheck.database.dao.PkgSignDao;
import com.obric.safecheck.database.dao.PkgSignDao_Impl;
import com.obric.safecheck.database.dao.UrlDomainDao;
import com.obric.safecheck.database.dao.UrlDomainDao_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class AntiFraudDatabase_Impl extends AntiFraudDatabase {
    private volatile EndDataDao _endDataDao;
    private volatile GxbAntiFraudRuleDao _gxbAntiFraudRuleDao;
    private volatile PhoneDao _phoneDao;
    private volatile PkgSignDao _pkgSignDao;
    private volatile UrlDomainDao _urlDomainDao;

    public AntiFraudDatabase_Impl() {
    }

    static /* synthetic */ List access$000(AntiFraudDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$100(AntiFraudDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$1000(AntiFraudDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$200(AntiFraudDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$300(AntiFraudDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$400(AntiFraudDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$500(AntiFraudDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ SupportSQLiteDatabase access$602(AntiFraudDatabase_Impl r0, SupportSQLiteDatabase r1) {
        r0.mDatabase = r1;
        return r1;
    }

    static /* synthetic */ void access$700(AntiFraudDatabase_Impl r0, SupportSQLiteDatabase r1) {
        r0.internalInitInvalidationTracker(r1);
    }

    static /* synthetic */ List access$800(AntiFraudDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$900(AntiFraudDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
        final int r2 = 4;
        RoomOpenHelper r0 = new RoomOpenHelper(configuration, new AnonymousClass1(this, r2), "0ae52efce9245732ef9e97dbd98fd129", "827219384cf32da82b8e951680ba2dc2");
        SupportSQLiteOpenHelper.Configuration r3 = SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(r0).build();
        return configuration.sqliteOpenHelperFactory.create(r3);
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"pkg_sign_items", "phone_items", "url_domain_items", "end_data_table", "gxb_anti_fraud_rules"});
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `pkg_sign_items`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `phone_items`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `url_domain_items`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `end_data_table`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `gxb_anti_fraud_rules`");     // Catch: Throwable -> L8
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
        r2.put(PkgSignDao.class, PkgSignDao_Impl.getRequiredConverters());
        r2.put(PhoneDao.class, PhoneDao_Impl.getRequiredConverters());
        r2.put(UrlDomainDao.class, UrlDomainDao_Impl.getRequiredConverters());
        r2.put(EndDataDao.class, EndDataDao_Impl.getRequiredConverters());
        r2.put(GxbAntiFraudRuleDao.class, GxbAntiFraudRuleDao_Impl.getRequiredConverters());
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

    @Override // com.obric.safecheck.database.AntiFraudDatabase
    public PkgSignDao pkgSignDao() {
        if (this._pkgSignDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._pkgSignDao != null) goto L10;
        this._pkgSignDao = new PkgSignDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PkgSignDao r0 = this._pkgSignDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._pkgSignDao;
    }

    @Override // com.obric.safecheck.database.AntiFraudDatabase
    public PhoneDao phoneDao() {
        if (this._phoneDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._phoneDao != null) goto L10;
        this._phoneDao = new PhoneDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PhoneDao r0 = this._phoneDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._phoneDao;
    }

    @Override // com.obric.safecheck.database.AntiFraudDatabase
    public UrlDomainDao urlDomainDao() {
        if (this._urlDomainDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._urlDomainDao != null) goto L10;
        this._urlDomainDao = new UrlDomainDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UrlDomainDao r0 = this._urlDomainDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._urlDomainDao;
    }

    @Override // com.obric.safecheck.database.AntiFraudDatabase
    public EndDataDao endDataDao() {
        if (this._endDataDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._endDataDao != null) goto L10;
        this._endDataDao = new EndDataDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        EndDataDao r0 = this._endDataDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._endDataDao;
    }

    @Override // com.obric.safecheck.database.AntiFraudDatabase
    public GxbAntiFraudRuleDao gxbAntiFraudRuleDao() {
        if (this._gxbAntiFraudRuleDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._gxbAntiFraudRuleDao != null) goto L10;
        this._gxbAntiFraudRuleDao = new GxbAntiFraudRuleDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        GxbAntiFraudRuleDao r0 = this._gxbAntiFraudRuleDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._gxbAntiFraudRuleDao;
    }
}

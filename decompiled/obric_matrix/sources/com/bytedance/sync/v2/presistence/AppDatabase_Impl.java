package com.bytedance.sync.v2.presistence;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sync.v2.presistence.c.b;
import com.bytedance.sync.v2.presistence.c.c;
import com.bytedance.sync.v2.presistence.c.d;
import com.bytedance.sync.v2.presistence.c.e;
import com.bytedance.sync.v2.presistence.c.f;
import com.bytedance.sync.v2.presistence.c.g;
import com.bytedance.sync.v2.presistence.c.h;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppDatabase_Impl extends AppDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile com.bytedance.sync.v2.presistence.c.a f6164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile e f6165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile g f6166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile c f6167d;

    class a extends RoomOpenHelper.Delegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppDatabase_Impl f6168a;

        a(AppDatabase_Impl r1, int r2) {
            this.f6168a = r1;
            super(r2);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase r1) {
            r1.execSQL("CREATE TABLE IF NOT EXISTS `t_business` (`id` INTEGER NOT NULL, `consume_type` INTEGER, `bucket` INTEGER, PRIMARY KEY(`id`))");
            r1.execSQL("CREATE TABLE IF NOT EXISTS `t_report_synclog` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sync_id` TEXT, `business` INTEGER NOT NULL, `did` TEXT, `uid` TEXT, `bucket` INTEGER, `cursor` INTEGER NOT NULL, `data` BLOB, `md5` TEXT, `msg_id` TEXT)");
            r1.execSQL("CREATE TABLE IF NOT EXISTS `t_sync_cursor` (`sync_id` TEXT NOT NULL, `did` TEXT, `uid` TEXT, `topic_type` INTEGER, `bucket` INTEGER, `recv_cursor` INTEGER NOT NULL, `report_cursor` INTEGER NOT NULL, PRIMARY KEY(`sync_id`))");
            r1.execSQL("CREATE TABLE IF NOT EXISTS `t_synclog` (`sync_id` TEXT NOT NULL, `did` TEXT, `uid` TEXT, `sync_cursor` INTEGER NOT NULL, `data` BLOB, `md5` TEXT, `business` INTEGER NOT NULL, `consume_type` INTEGER, `data_type` INTEGER, `publish_ts` INTEGER NOT NULL, `receive_ts` INTEGER NOT NULL, `bucket` INTEGER, `req_id` TEXT, `topic_type` INTEGER NOT NULL, `packet_status` INTEGER NOT NULL, `extra` TEXT, PRIMARY KEY(`sync_id`, `sync_cursor`))");
            r1.execSQL("CREATE TABLE IF NOT EXISTS `t_snapshot` (`sync_id` TEXT NOT NULL, `business` INTEGER NOT NULL, `uid` TEXT, `did` TEXT, `cursor` INTEGER NOT NULL, `data` BLOB, `notified` INTEGER NOT NULL, `bucket` INTEGER, `data_type` INTEGER, `publish_ts` INTEGER NOT NULL, `receive_ts` INTEGER NOT NULL, `consume_type` INTEGER, `patch_cnt` INTEGER NOT NULL, PRIMARY KEY(`sync_id`, `business`))");
            r1.execSQL("CREATE TABLE IF NOT EXISTS `t_history_synclog` (`sync_id` TEXT NOT NULL, `did` TEXT, `uid` TEXT, `sync_cursor` INTEGER NOT NULL, `data` BLOB, `md5` TEXT, `business` INTEGER NOT NULL, `consume_type` INTEGER, `data_type` INTEGER, `publish_ts` INTEGER NOT NULL, `receive_ts` INTEGER NOT NULL, `bucket` INTEGER, `req_id` TEXT, `topic_type` INTEGER, `packet_status` INTEGER, `extra` TEXT, PRIMARY KEY(`sync_id`, `sync_cursor`))");
            r1.execSQL(RoomMasterTable.CREATE_QUERY);
            r1.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"d8b316d9e908a9c46e9d5dbb800b7ff6\")");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase r1) {
            r1.execSQL("DROP TABLE IF EXISTS `t_business`");
            r1.execSQL("DROP TABLE IF EXISTS `t_report_synclog`");
            r1.execSQL("DROP TABLE IF EXISTS `t_sync_cursor`");
            r1.execSQL("DROP TABLE IF EXISTS `t_synclog`");
            r1.execSQL("DROP TABLE IF EXISTS `t_snapshot`");
            r1.execSQL("DROP TABLE IF EXISTS `t_history_synclog`");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase r4) {
            if (AppDatabase_Impl.e(this.f6168a) == null) goto L7;
            int r0 = 0;
            int r1 = AppDatabase_Impl.f(this.f6168a).size();
        L5:
            if (r0 >= r1) goto L9;
            ((RoomDatabase.Callback) AppDatabase_Impl.g(this.f6168a).get(r0)).onCreate(r4);
            r0 = r0 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase r4) {
            AppDatabase_Impl.h(this.f6168a, r4);
            AppDatabase_Impl.i(this.f6168a, r4);
            if (AppDatabase_Impl.j(this.f6168a) == null) goto L7;
            int r0 = 0;
            int r1 = AppDatabase_Impl.k(this.f6168a).size();
        L5:
            if (r0 >= r1) goto L9;
            ((RoomDatabase.Callback) AppDatabase_Impl.l(this.f6168a).get(r0)).onOpen(r4);
            r0 = r0 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void validateMigration(SupportSQLiteDatabase r26) {
            HashMap r1 = new HashMap(3);
            r1.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
            r1.put("consume_type", new TableInfo.Column("consume_type", "INTEGER", false, 0));
            r1.put("bucket", new TableInfo.Column("bucket", "INTEGER", false, 0));
            TableInfo r10 = new TableInfo("t_business", r1, new HashSet(0), new HashSet(0));
            TableInfo r2 = TableInfo.read(r26, "t_business");
            if (r10.equals(r2) == false) goto L26;
            HashMap r3 = new HashMap(10);
            r3.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
            r3.put("sync_id", new TableInfo.Column("sync_id", "TEXT", false, 0));
            r3.put("business", new TableInfo.Column("business", "INTEGER", true, 0));
            r3.put("did", new TableInfo.Column("did", "TEXT", false, 0));
            r3.put("uid", new TableInfo.Column("uid", "TEXT", false, 0));
            r3.put("bucket", new TableInfo.Column("bucket", "INTEGER", false, 0));
            r3.put("cursor", new TableInfo.Column("cursor", "INTEGER", true, 0));
            r3.put("data", new TableInfo.Column("data", "BLOB", false, 0));
            r3.put("md5", new TableInfo.Column("md5", "TEXT", false, 0));
            r3.put("msg_id", new TableInfo.Column("msg_id", "TEXT", false, 0));
            TableInfo r7 = new TableInfo("t_report_synclog", r3, new HashSet(0), new HashSet(0));
            TableInfo r4 = TableInfo.read(r26, "t_report_synclog");
            if (r7.equals(r4) == false) goto L24;
            HashMap r5 = new HashMap(7);
            r5.put("sync_id", new TableInfo.Column("sync_id", "TEXT", true, 1));
            r5.put("did", new TableInfo.Column("did", "TEXT", false, 0));
            r5.put("uid", new TableInfo.Column("uid", "TEXT", false, 0));
            r5.put("topic_type", new TableInfo.Column("topic_type", "INTEGER", false, 0));
            r5.put("bucket", new TableInfo.Column("bucket", "INTEGER", false, 0));
            r5.put("recv_cursor", new TableInfo.Column("recv_cursor", "INTEGER", true, 0));
            r5.put("report_cursor", new TableInfo.Column("report_cursor", "INTEGER", true, 0));
            TableInfo r6 = new TableInfo("t_sync_cursor", r5, new HashSet(0), new HashSet(0));
            TableInfo r8 = TableInfo.read(r26, "t_sync_cursor");
            if (r6.equals(r8) == false) goto L22;
            HashMap r9 = new HashMap(16);
            r9.put("sync_id", new TableInfo.Column("sync_id", "TEXT", true, 1));
            r9.put("did", new TableInfo.Column("did", "TEXT", false, 0));
            r9.put("uid", new TableInfo.Column("uid", "TEXT", false, 0));
            r9.put("sync_cursor", new TableInfo.Column("sync_cursor", "INTEGER", true, 2));
            r9.put("data", new TableInfo.Column("data", "BLOB", false, 0));
            r9.put("md5", new TableInfo.Column("md5", "TEXT", false, 0));
            r9.put("business", new TableInfo.Column("business", "INTEGER", true, 0));
            r9.put("consume_type", new TableInfo.Column("consume_type", "INTEGER", false, 0));
            r9.put("data_type", new TableInfo.Column("data_type", "INTEGER", false, 0));
            r9.put("publish_ts", new TableInfo.Column("publish_ts", "INTEGER", true, 0));
            r9.put("receive_ts", new TableInfo.Column("receive_ts", "INTEGER", true, 0));
            r9.put("bucket", new TableInfo.Column("bucket", "INTEGER", false, 0));
            r9.put("req_id", new TableInfo.Column("req_id", "TEXT", false, 0));
            r9.put("topic_type", new TableInfo.Column("topic_type", "INTEGER", true, 0));
            r9.put("packet_status", new TableInfo.Column("packet_status", "INTEGER", true, 0));
            r9.put(WsConstants.KEY_EXTRA, new TableInfo.Column(WsConstants.KEY_EXTRA, "TEXT", false, 0));
            TableInfo r11 = new TableInfo("t_synclog", r9, new HashSet(0), new HashSet(0));
            TableInfo r12 = TableInfo.read(r26, "t_synclog");
            if (r11.equals(r12) == false) goto L20;
            HashMap r13 = new HashMap(13);
            r13.put("sync_id", new TableInfo.Column("sync_id", "TEXT", true, 1));
            r13.put("business", new TableInfo.Column("business", "INTEGER", true, 2));
            r13.put("uid", new TableInfo.Column("uid", "TEXT", false, 0));
            r13.put("did", new TableInfo.Column("did", "TEXT", false, 0));
            r13.put("cursor", new TableInfo.Column("cursor", "INTEGER", true, 0));
            r13.put("data", new TableInfo.Column("data", "BLOB", false, 0));
            r13.put("notified", new TableInfo.Column("notified", "INTEGER", true, 0));
            r13.put("bucket", new TableInfo.Column("bucket", "INTEGER", false, 0));
            r13.put("data_type", new TableInfo.Column("data_type", "INTEGER", false, 0));
            r13.put("publish_ts", new TableInfo.Column("publish_ts", "INTEGER", true, 0));
            r13.put("receive_ts", new TableInfo.Column("receive_ts", "INTEGER", true, 0));
            r13.put("consume_type", new TableInfo.Column("consume_type", "INTEGER", false, 0));
            r13.put("patch_cnt", new TableInfo.Column("patch_cnt", "INTEGER", true, 0));
            TableInfo r14 = new TableInfo("t_snapshot", r13, new HashSet(0), new HashSet(0));
            TableInfo r15 = TableInfo.read(r26, "t_snapshot");
            if (r14.equals(r15) == false) goto L18;
            HashMap r16 = new HashMap(16);
            r16.put("sync_id", new TableInfo.Column("sync_id", "TEXT", true, 1));
            r16.put("did", new TableInfo.Column("did", "TEXT", false, 0));
            r16.put("uid", new TableInfo.Column("uid", "TEXT", false, 0));
            r16.put("sync_cursor", new TableInfo.Column("sync_cursor", "INTEGER", true, 2));
            r16.put("data", new TableInfo.Column("data", "BLOB", false, 0));
            r16.put("md5", new TableInfo.Column("md5", "TEXT", false, 0));
            r16.put("business", new TableInfo.Column("business", "INTEGER", true, 0));
            r16.put("consume_type", new TableInfo.Column("consume_type", "INTEGER", false, 0));
            r16.put("data_type", new TableInfo.Column("data_type", "INTEGER", false, 0));
            r16.put("publish_ts", new TableInfo.Column("publish_ts", "INTEGER", true, 0));
            r16.put("receive_ts", new TableInfo.Column("receive_ts", "INTEGER", true, 0));
            r16.put("bucket", new TableInfo.Column("bucket", "INTEGER", false, 0));
            r16.put("req_id", new TableInfo.Column("req_id", "TEXT", false, 0));
            r16.put("topic_type", new TableInfo.Column("topic_type", "INTEGER", false, 0));
            r16.put("packet_status", new TableInfo.Column("packet_status", "INTEGER", false, 0));
            r16.put(WsConstants.KEY_EXTRA, new TableInfo.Column(WsConstants.KEY_EXTRA, "TEXT", false, 0));
            TableInfo r17 = new TableInfo("t_history_synclog", r16, new HashSet(0), new HashSet(0));
            TableInfo r0 = TableInfo.read(r26, "t_history_synclog");
            if (r17.equals(r0) == false) goto L16;
            return;
        L16:
            throw new IllegalStateException("Migration didn't properly handle t_history_synclog(com.bytedance.sync.v2.presistence.table.SyncHistoryLog).\n Expected:\n" + r17 + "\n Found:\n" + r0);
        L18:
            throw new IllegalStateException("Migration didn't properly handle t_snapshot(com.bytedance.sync.v2.presistence.table.Snapshot).\n Expected:\n" + r14 + "\n Found:\n" + r15);
        L20:
            throw new IllegalStateException("Migration didn't properly handle t_synclog(com.bytedance.sync.v2.presistence.table.SyncLog).\n Expected:\n" + r11 + "\n Found:\n" + r12);
        L22:
            throw new IllegalStateException("Migration didn't properly handle t_sync_cursor(com.bytedance.sync.v2.presistence.table.SyncCursor).\n Expected:\n" + r6 + "\n Found:\n" + r8);
        L24:
            throw new IllegalStateException("Migration didn't properly handle t_report_synclog(com.bytedance.sync.v2.presistence.table.UploadItem).\n Expected:\n" + r7 + "\n Found:\n" + r4);
        L26:
            throw new IllegalStateException("Migration didn't properly handle t_business(com.bytedance.sync.v2.presistence.table.Business).\n Expected:\n" + r10 + "\n Found:\n" + r2);
        }
    }

    public AppDatabase_Impl() {
    }

    static /* synthetic */ List e(AppDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List f(AppDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List g(AppDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ SupportSQLiteDatabase h(AppDatabase_Impl r0, SupportSQLiteDatabase r1) {
        r0.mDatabase = r1;
        return r1;
    }

    static /* synthetic */ void i(AppDatabase_Impl r0, SupportSQLiteDatabase r1) {
        r0.internalInitInvalidationTracker(r1);
    }

    static /* synthetic */ List j(AppDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List k(AppDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List l(AppDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    @Override // com.bytedance.sync.v2.presistence.AppDatabase
    public com.bytedance.sync.v2.presistence.c.a a() {
        if (this.f6164a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f6164a != null) goto L10;
        this.f6164a = new b(this);     // Catch: Throwable -> L13
    L10:
        com.bytedance.sync.v2.presistence.c.a r0 = this.f6164a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.f6164a;
    }

    @Override // com.bytedance.sync.v2.presistence.AppDatabase
    public c b() {
        if (this.f6167d != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f6167d != null) goto L10;
        this.f6167d = new d(this);     // Catch: Throwable -> L13
    L10:
        c r0 = this.f6167d;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.f6167d;
    }

    @Override // com.bytedance.sync.v2.presistence.AppDatabase
    public e c() {
        if (this.f6165b != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f6165b != null) goto L10;
        this.f6165b = new f(this);     // Catch: Throwable -> L13
    L10:
        e r0 = this.f6165b;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.f6165b;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `t_business`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `t_report_synclog`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `t_sync_cursor`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `t_synclog`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `t_snapshot`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `t_history_synclog`");     // Catch: Throwable -> L8
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
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new String[]{"t_business", "t_report_synclog", "t_sync_cursor", "t_synclog", "t_snapshot", "t_history_synclog"});
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r4) {
        RoomOpenHelper r0 = new RoomOpenHelper(r4, new a(this, 4), "d8b316d9e908a9c46e9d5dbb800b7ff6", "ccad3d5cc1da4af4352df7344d0c2f6d");
        SupportSQLiteOpenHelper.Configuration r3 = SupportSQLiteOpenHelper.Configuration.builder(r4.context).name(r4.name).callback(r0).build();
        return r4.sqliteOpenHelperFactory.create(r3);
    }

    @Override // com.bytedance.sync.v2.presistence.AppDatabase
    public g d() {
        if (this.f6166c != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f6166c != null) goto L10;
        this.f6166c = new h(this);     // Catch: Throwable -> L13
    L10:
        g r0 = this.f6166c;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.f6166c;
    }
}

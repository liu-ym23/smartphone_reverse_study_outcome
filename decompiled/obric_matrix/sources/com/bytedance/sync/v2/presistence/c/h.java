package com.bytedance.sync.v2.presistence.c;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f6207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter f6208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityInsertionAdapter f6209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter f6210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter f6211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SharedSQLiteStatement f6212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SharedSQLiteStatement f6213g;

    class a extends EntityInsertionAdapter<com.bytedance.sync.v2.presistence.d.f> {
        a(h r1, RoomDatabase r2) {
            super(r2);
        }

        public void a(SupportSQLiteStatement r4, com.bytedance.sync.v2.presistence.d.f r5) {
            r4.bindLong(1, r5.f6260a);
            String r3 = r5.f6261b;
            if (r3 != null) goto L5;
            r4.bindNull(2);
        L6:
            r4.bindLong(3, r5.f6262c);
            String r6 = r5.f6263d;
            if (r6 != null) goto L9;
            r4.bindNull(4);
        L10:
            String r7 = r5.f6264e;
            if (r7 != null) goto L13;
            r4.bindNull(5);
        L14:
            r4.bindLong(6, com.bytedance.sync.v2.presistence.b.a.a(r5.f6265f));
            r4.bindLong(7, r5.f6266g);
            byte[] r8 = r5.f6267h;
            if (r8 != null) goto L17;
            r4.bindNull(8);
        L18:
            String r9 = r5.f6268i;
            if (r9 != null) goto L21;
            r4.bindNull(9);
        L22:
            String r10 = r5.f6269j;
            if (r10 != null) goto L25;
            r4.bindNull(10);
            return;
        L25:
            r4.bindString(10, r10);
            return;
        L21:
            r4.bindString(9, r9);
            goto L22
        L17:
            r4.bindBlob(8, r8);
            goto L18
        L13:
            r4.bindString(5, r7);
            goto L14
        L9:
            r4.bindString(4, r6);
            goto L10
        L5:
            r4.bindString(2, r3);
            goto L6
        }

        @Override // androidx.room.EntityInsertionAdapter
        public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement r1, com.bytedance.sync.v2.presistence.d.f r2) {
            a(r1, r2);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR ABORT INTO `t_report_synclog`(`id`,`sync_id`,`business`,`did`,`uid`,`bucket`,`cursor`,`data`,`md5`,`msg_id`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends EntityInsertionAdapter<com.bytedance.sync.v2.presistence.d.f> {
        b(h r1, RoomDatabase r2) {
            super(r2);
        }

        public void a(SupportSQLiteStatement r4, com.bytedance.sync.v2.presistence.d.f r5) {
            r4.bindLong(1, r5.f6260a);
            String r3 = r5.f6261b;
            if (r3 != null) goto L5;
            r4.bindNull(2);
        L6:
            r4.bindLong(3, r5.f6262c);
            String r6 = r5.f6263d;
            if (r6 != null) goto L9;
            r4.bindNull(4);
        L10:
            String r7 = r5.f6264e;
            if (r7 != null) goto L13;
            r4.bindNull(5);
        L14:
            r4.bindLong(6, com.bytedance.sync.v2.presistence.b.a.a(r5.f6265f));
            r4.bindLong(7, r5.f6266g);
            byte[] r8 = r5.f6267h;
            if (r8 != null) goto L17;
            r4.bindNull(8);
        L18:
            String r9 = r5.f6268i;
            if (r9 != null) goto L21;
            r4.bindNull(9);
        L22:
            String r10 = r5.f6269j;
            if (r10 != null) goto L25;
            r4.bindNull(10);
            return;
        L25:
            r4.bindString(10, r10);
            return;
        L21:
            r4.bindString(9, r9);
            goto L22
        L17:
            r4.bindBlob(8, r8);
            goto L18
        L13:
            r4.bindString(5, r7);
            goto L14
        L9:
            r4.bindString(4, r6);
            goto L10
        L5:
            r4.bindString(2, r3);
            goto L6
        }

        @Override // androidx.room.EntityInsertionAdapter
        public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement r1, com.bytedance.sync.v2.presistence.d.f r2) {
            a(r1, r2);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_report_synclog`(`id`,`sync_id`,`business`,`did`,`uid`,`bucket`,`cursor`,`data`,`md5`,`msg_id`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
        }
    }

    class c extends EntityDeletionOrUpdateAdapter<com.bytedance.sync.v2.presistence.d.f> {
        c(h r1, RoomDatabase r2) {
            super(r2);
        }

        public void a(SupportSQLiteStatement r3, com.bytedance.sync.v2.presistence.d.f r4) {
            r3.bindLong(1, r4.f6260a);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement r1, com.bytedance.sync.v2.presistence.d.f r2) {
            a(r1, r2);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `t_report_synclog` WHERE `id` = ?";
        }
    }

    class d extends EntityDeletionOrUpdateAdapter<com.bytedance.sync.v2.presistence.d.f> {
        d(h r1, RoomDatabase r2) {
            super(r2);
        }

        public void a(SupportSQLiteStatement r4, com.bytedance.sync.v2.presistence.d.f r5) {
            r4.bindLong(1, r5.f6260a);
            String r3 = r5.f6261b;
            if (r3 != null) goto L5;
            r4.bindNull(2);
        L6:
            r4.bindLong(3, r5.f6262c);
            String r6 = r5.f6263d;
            if (r6 != null) goto L9;
            r4.bindNull(4);
        L10:
            String r7 = r5.f6264e;
            if (r7 != null) goto L13;
            r4.bindNull(5);
        L14:
            r4.bindLong(6, com.bytedance.sync.v2.presistence.b.a.a(r5.f6265f));
            r4.bindLong(7, r5.f6266g);
            byte[] r8 = r5.f6267h;
            if (r8 != null) goto L17;
            r4.bindNull(8);
        L18:
            String r9 = r5.f6268i;
            if (r9 != null) goto L21;
            r4.bindNull(9);
        L22:
            String r10 = r5.f6269j;
            if (r10 != null) goto L25;
            r4.bindNull(10);
        L26:
            r4.bindLong(11, r5.f6260a);
            return;
        L25:
            r4.bindString(10, r10);
            goto L26
        L21:
            r4.bindString(9, r9);
            goto L22
        L17:
            r4.bindBlob(8, r8);
            goto L18
        L13:
            r4.bindString(5, r7);
            goto L14
        L9:
            r4.bindString(4, r6);
            goto L10
        L5:
            r4.bindString(2, r3);
            goto L6
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement r1, com.bytedance.sync.v2.presistence.d.f r2) {
            a(r1, r2);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR REPLACE `t_report_synclog` SET `id` = ?,`sync_id` = ?,`business` = ?,`did` = ?,`uid` = ?,`bucket` = ?,`cursor` = ?,`data` = ?,`md5` = ?,`msg_id` = ? WHERE `id` = ?";
        }
    }

    class e extends SharedSQLiteStatement {
        e(h r1, RoomDatabase r2) {
            super(r2);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM t_report_synclog WHERE t_report_synclog.business not in (SELECT distinct id from t_business) ";
        }
    }

    class f extends SharedSQLiteStatement {
        f(h r1, RoomDatabase r2) {
            super(r2);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM t_report_synclog WHERE sync_id = ? AND cursor > 0 AND cursor <=?";
        }
    }

    public h(RoomDatabase r2) {
        this.f6207a = r2;
        this.f6208b = new a(this, r2);
        this.f6209c = new b(this, r2);
        this.f6210d = new c(this, r2);
        this.f6211e = new d(this, r2);
        this.f6212f = new e(this, r2);
        this.f6213g = new f(this, r2);
    }

    @Override // com.bytedance.sync.v2.presistence.c.g
    public int a(List<? extends com.bytedance.sync.v2.presistence.d.f> r2) {
        this.f6207a.beginTransaction();
        int r3 = this.f6210d.handleMultiple(r2) + 0;     // Catch: Throwable -> L6
        this.f6207a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f6207a.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.f6207a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.g
    public void b(List<? extends com.bytedance.sync.v2.presistence.d.f> r2) {
        this.f6207a.beginTransaction();
        this.f6209c.insert(r2);     // Catch: Throwable -> L6
        this.f6207a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f6207a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f6207a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.g
    public int c(List<? extends com.bytedance.sync.v2.presistence.d.f> r2) {
        this.f6207a.beginTransaction();
        int r3 = this.f6211e.handleMultiple(r2) + 0;     // Catch: Throwable -> L6
        this.f6207a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f6207a.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.f6207a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.g
    public long d(com.bytedance.sync.v2.presistence.d.f r3) {
        this.f6207a.beginTransaction();
        long r0 = this.f6208b.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.f6207a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f6207a.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.f6207a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.g
    public List<com.bytedance.sync.v2.presistence.d.f> g(com.bytedance.sync.v2.j.g r12, String r13, String r14, int r15) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM t_report_synclog WHERE cursor <= 0 and did = ? and uid = ? and business in (SELECT distinct id from t_business where bucket=?) ORDER BY id ASC LIMIT ?", 4);
        if (r13 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r14 != null) goto L9;
        r0.bindNull(2);
    L10:
        r0.bindLong(3, com.bytedance.sync.v2.presistence.b.a.a(r12));
        r0.bindLong(4, r15);
        Cursor r11 = this.f6207a.query(r0);
        int r16 = r11.getColumnIndexOrThrow("id");     // Catch: Throwable -> L18
        int r17 = r11.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L18
        int r18 = r11.getColumnIndexOrThrow("business");     // Catch: Throwable -> L18
        int r19 = r11.getColumnIndexOrThrow("did");     // Catch: Throwable -> L18
        int r1 = r11.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L18
        int r2 = r11.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L18
        int r3 = r11.getColumnIndexOrThrow("cursor");     // Catch: Throwable -> L18
        int r4 = r11.getColumnIndexOrThrow("data");     // Catch: Throwable -> L18
        int r5 = r11.getColumnIndexOrThrow("md5");     // Catch: Throwable -> L18
        int r6 = r11.getColumnIndexOrThrow("msg_id");     // Catch: Throwable -> L18
        ArrayList r7 = new ArrayList(r11.getCount());     // Catch: Throwable -> L18
    L13:
        if (r11.moveToNext() == false) goto L16;
        com.bytedance.sync.v2.presistence.d.f r8 = new com.bytedance.sync.v2.presistence.d.f();     // Catch: Throwable -> L18
        r8.f6260a = r11.getLong(r16);     // Catch: Throwable -> L18
        r8.f6261b = r11.getString(r17);     // Catch: Throwable -> L18
        r8.f6262c = r11.getLong(r18);     // Catch: Throwable -> L18
        r8.f6263d = r11.getString(r19);     // Catch: Throwable -> L18
        r8.f6264e = r11.getString(r1);     // Catch: Throwable -> L18
        r8.f6265f = com.bytedance.sync.v2.presistence.b.a.b(r11.getInt(r2));     // Catch: Throwable -> L18
        r8.f6266g = r11.getLong(r3);     // Catch: Throwable -> L18
        r8.f6267h = r11.getBlob(r4);     // Catch: Throwable -> L18
        r8.f6268i = r11.getString(r5);     // Catch: Throwable -> L18
        r8.f6269j = r11.getString(r6);     // Catch: Throwable -> L18
        r7.add(r8);     // Catch: Throwable -> L18
        goto L13
    L16:
        r11.close();
        r0.release();
        return r7;
    L18:
        th = move-exception;
        r11.close();
        r0.release();
        throw th;
    L9:
        r0.bindString(2, r14);
        goto L10
    L5:
        r0.bindString(1, r13);
        goto L7
    }

    @Override // com.bytedance.sync.v2.presistence.c.g
    public List<com.bytedance.sync.v2.presistence.d.f> h(com.bytedance.sync.v2.j.g r13, String r14, int r15) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM t_report_synclog WHERE cursor <= 0 and did = ? and business in (SELECT distinct id from t_business where bucket=?) ORDER BY id ASC LIMIT ?", 3);
        if (r14 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, com.bytedance.sync.v2.presistence.b.a.a(r13));
        r0.bindLong(3, r15);
        Cursor r12 = this.f6207a.query(r0);
        int r16 = r12.getColumnIndexOrThrow("id");     // Catch: Throwable -> L14
        int r17 = r12.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L14
        int r18 = r12.getColumnIndexOrThrow("business");     // Catch: Throwable -> L14
        int r1 = r12.getColumnIndexOrThrow("did");     // Catch: Throwable -> L14
        int r2 = r12.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L14
        int r3 = r12.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L14
        int r4 = r12.getColumnIndexOrThrow("cursor");     // Catch: Throwable -> L14
        int r5 = r12.getColumnIndexOrThrow("data");     // Catch: Throwable -> L14
        int r6 = r12.getColumnIndexOrThrow("md5");     // Catch: Throwable -> L14
        int r7 = r12.getColumnIndexOrThrow("msg_id");     // Catch: Throwable -> L14
        ArrayList r8 = new ArrayList(r12.getCount());     // Catch: Throwable -> L14
    L9:
        if (r12.moveToNext() == false) goto L12;
        com.bytedance.sync.v2.presistence.d.f r9 = new com.bytedance.sync.v2.presistence.d.f();     // Catch: Throwable -> L14
        r9.f6260a = r12.getLong(r16);     // Catch: Throwable -> L14
        r9.f6261b = r12.getString(r17);     // Catch: Throwable -> L14
        r9.f6262c = r12.getLong(r18);     // Catch: Throwable -> L14
        r9.f6263d = r12.getString(r1);     // Catch: Throwable -> L14
        r9.f6264e = r12.getString(r2);     // Catch: Throwable -> L14
        r9.f6265f = com.bytedance.sync.v2.presistence.b.a.b(r12.getInt(r3));     // Catch: Throwable -> L14
        r9.f6266g = r12.getLong(r4);     // Catch: Throwable -> L14
        r9.f6267h = r12.getBlob(r5);     // Catch: Throwable -> L14
        r9.f6268i = r12.getString(r6);     // Catch: Throwable -> L14
        r9.f6269j = r12.getString(r7);     // Catch: Throwable -> L14
        r8.add(r9);     // Catch: Throwable -> L14
        goto L9
    L12:
        r12.close();
        r0.release();
        return r8;
    L14:
        th = move-exception;
        r12.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r14);
        goto L6
    }

    @Override // com.bytedance.sync.v2.presistence.c.g
    public void i(long r3, long r5) {
        SupportSQLiteStatement r0 = this.f6213g.acquire();
        this.f6207a.beginTransaction();
        r0.bindLong(1, r3);     // Catch: Throwable -> L6
        r0.bindLong(2, r5);     // Catch: Throwable -> L6
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.f6207a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f6207a.endTransaction();
        this.f6213g.release(r0);
        return;
    L6:
        th = move-exception;
        this.f6207a.endTransaction();
        this.f6213g.release(r0);
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.g
    public void l() {
        SupportSQLiteStatement r0 = this.f6212f.acquire();
        this.f6207a.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.f6207a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f6207a.endTransaction();
        this.f6212f.release(r0);
        return;
    L6:
        th = move-exception;
        this.f6207a.endTransaction();
        this.f6212f.release(r0);
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.g
    public List<com.bytedance.sync.v2.presistence.d.f> n(String r14, int r15) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM t_report_synclog WHERE cursor > 0 and sync_id=? ORDER BY cursor ASC LIMIT ?", 2);
        if (r14 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r15);
        Cursor r13 = this.f6207a.query(r0);
        int r16 = r13.getColumnIndexOrThrow("id");     // Catch: Throwable -> L14
        int r17 = r13.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L14
        int r1 = r13.getColumnIndexOrThrow("business");     // Catch: Throwable -> L14
        int r2 = r13.getColumnIndexOrThrow("did");     // Catch: Throwable -> L14
        int r3 = r13.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L14
        int r4 = r13.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L14
        int r5 = r13.getColumnIndexOrThrow("cursor");     // Catch: Throwable -> L14
        int r6 = r13.getColumnIndexOrThrow("data");     // Catch: Throwable -> L14
        int r7 = r13.getColumnIndexOrThrow("md5");     // Catch: Throwable -> L14
        int r8 = r13.getColumnIndexOrThrow("msg_id");     // Catch: Throwable -> L14
        ArrayList r9 = new ArrayList(r13.getCount());     // Catch: Throwable -> L14
    L9:
        if (r13.moveToNext() == false) goto L12;
        com.bytedance.sync.v2.presistence.d.f r10 = new com.bytedance.sync.v2.presistence.d.f();     // Catch: Throwable -> L14
        r10.f6260a = r13.getLong(r16);     // Catch: Throwable -> L14
        r10.f6261b = r13.getString(r17);     // Catch: Throwable -> L14
        r10.f6262c = r13.getLong(r1);     // Catch: Throwable -> L14
        r10.f6263d = r13.getString(r2);     // Catch: Throwable -> L14
        r10.f6264e = r13.getString(r3);     // Catch: Throwable -> L14
        r10.f6265f = com.bytedance.sync.v2.presistence.b.a.b(r13.getInt(r4));     // Catch: Throwable -> L14
        r10.f6266g = r13.getLong(r5);     // Catch: Throwable -> L14
        r10.f6267h = r13.getBlob(r6);     // Catch: Throwable -> L14
        r10.f6268i = r13.getString(r7);     // Catch: Throwable -> L14
        r10.f6269j = r13.getString(r8);     // Catch: Throwable -> L14
        r9.add(r10);     // Catch: Throwable -> L14
        goto L9
    L12:
        r13.close();
        r0.release();
        return r9;
    L14:
        th = move-exception;
        r13.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r14);
        goto L6
    }
}

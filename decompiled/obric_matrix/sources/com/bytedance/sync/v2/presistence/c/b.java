package com.bytedance.sync.v2.presistence.c;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.bytedance.sync.v2.presistence.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f6193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter f6194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityInsertionAdapter f6195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SharedSQLiteStatement f6196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SharedSQLiteStatement f6197e;

    class a extends EntityInsertionAdapter<com.bytedance.sync.v2.presistence.d.a> {
        a(b r1, RoomDatabase r2) {
            super(r2);
        }

        public void a(SupportSQLiteStatement r3, com.bytedance.sync.v2.presistence.d.a r4) {
            r3.bindLong(1, r4.f6214a);
            r3.bindLong(2, com.bytedance.sync.v2.presistence.b.b.a(r4.f6215b));
            r3.bindLong(3, com.bytedance.sync.v2.presistence.b.a.a(r4.f6216c));
        }

        @Override // androidx.room.EntityInsertionAdapter
        public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement r1, com.bytedance.sync.v2.presistence.d.a r2) {
            a(r1, r2);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_business`(`id`,`consume_type`,`bucket`) VALUES (?,?,?)";
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sync.v2.presistence.c.b$b, reason: collision with other inner class name */
    class C0196b extends EntityInsertionAdapter<com.bytedance.sync.v2.presistence.d.c> {
        C0196b(b r1, RoomDatabase r2) {
            super(r2);
        }

        public void a(SupportSQLiteStatement r4, com.bytedance.sync.v2.presistence.d.c r5) {
            String r3 = r5.f6229a;
            if (r3 != null) goto L5;
            r4.bindNull(1);
        L6:
            String r6 = r5.f6230b;
            if (r6 != null) goto L9;
            r4.bindNull(2);
        L10:
            String r7 = r5.f6231c;
            if (r7 != null) goto L13;
            r4.bindNull(3);
        L14:
            r4.bindLong(4, com.bytedance.sync.v2.presistence.b.g.a(r5.f6232d));
            r4.bindLong(5, com.bytedance.sync.v2.presistence.b.a.a(r5.f6233e));
            r4.bindLong(6, r5.f6234f);
            r4.bindLong(7, r5.f6235g);
            return;
        L13:
            r4.bindString(3, r7);
            goto L14
        L9:
            r4.bindString(2, r6);
            goto L10
        L5:
            r4.bindString(1, r3);
            goto L6
        }

        @Override // androidx.room.EntityInsertionAdapter
        public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement r1, com.bytedance.sync.v2.presistence.d.c r2) {
            a(r1, r2);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_sync_cursor`(`sync_id`,`did`,`uid`,`topic_type`,`bucket`,`recv_cursor`,`report_cursor`) VALUES (?,?,?,?,?,?,?)";
        }
    }

    class c extends SharedSQLiteStatement {
        c(b r1, RoomDatabase r2) {
            super(r2);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE t_sync_cursor SET report_cursor = ?,did=?,uid=?,bucket=? WHERE sync_id = ? ";
        }
    }

    class d extends SharedSQLiteStatement {
        d(b r1, RoomDatabase r2) {
            super(r2);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE t_sync_cursor SET report_cursor = ? WHERE sync_id = ? ";
        }
    }

    class e extends SharedSQLiteStatement {
        e(b r1, RoomDatabase r2) {
            super(r2);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE t_sync_cursor SET recv_cursor = 0 WHERE sync_id=?";
        }
    }

    public b(RoomDatabase r2) {
        this.f6193a = r2;
        this.f6194b = new a(this, r2);
        this.f6195c = new C0196b(this, r2);
        new c(this, r2);
        this.f6196d = new d(this, r2);
        this.f6197e = new e(this, r2);
    }

    @Override // com.bytedance.sync.v2.presistence.c.a
    public void a(List<? extends com.bytedance.sync.v2.presistence.d.a> r2) {
        this.f6193a.beginTransaction();
        this.f6194b.insert(r2);     // Catch: Throwable -> L6
        this.f6193a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f6193a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f6193a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.a
    public void b(List<? extends com.bytedance.sync.v2.presistence.d.c> r2) {
        this.f6193a.beginTransaction();
        this.f6195c.insert(r2);     // Catch: Throwable -> L6
        this.f6193a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f6193a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f6193a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.a
    public void c(List<String> r4) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE from t_sync_cursor where sync_id in (");
        StringUtil.appendPlaceholders(r0, r4.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.f6193a.compileStatement(r1);
        Iterator<String> r5 = r4.iterator();
        int r3 = 1;
    L4:
        if (r5.hasNext() == false) goto L10;
        String r6 = r5.next();
        if (r6 != null) goto L8;
        r2.bindNull(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r2.bindString(r3, r6);
        goto L9
    L10:
        this.f6193a.beginTransaction();
        r2.executeUpdateDelete();     // Catch: Throwable -> L14
        this.f6193a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.f6193a.endTransaction();
        return;
    L14:
        th = move-exception;
        this.f6193a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.a
    public com.bytedance.sync.v2.presistence.d.c d(long r8) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM t_sync_cursor WHERE sync_id = ?", 1);
        r0.bindLong(1, r8);
        Cursor r7 = this.f6193a.query(r0);
        int r9 = r7.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L10
        int r10 = r7.getColumnIndexOrThrow("did");     // Catch: Throwable -> L10
        int r1 = r7.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L10
        int r2 = r7.getColumnIndexOrThrow("topic_type");     // Catch: Throwable -> L10
        int r3 = r7.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L10
        int r4 = r7.getColumnIndexOrThrow("recv_cursor");     // Catch: Throwable -> L10
        int r5 = r7.getColumnIndexOrThrow("report_cursor");     // Catch: Throwable -> L10
        if (r7.moveToFirst() == false) goto L7;
        com.bytedance.sync.v2.presistence.d.c r6 = new com.bytedance.sync.v2.presistence.d.c();     // Catch: Throwable -> L10
        r6.f6229a = r7.getString(r9);     // Catch: Throwable -> L10
        r6.f6230b = r7.getString(r10);     // Catch: Throwable -> L10
        r6.f6231c = r7.getString(r1);     // Catch: Throwable -> L10
        r6.f6232d = com.bytedance.sync.v2.presistence.b.g.b(r7.getInt(r2));     // Catch: Throwable -> L10
        r6.f6233e = com.bytedance.sync.v2.presistence.b.a.b(r7.getInt(r3));     // Catch: Throwable -> L10
        r6.f6234f = r7.getLong(r4);     // Catch: Throwable -> L10
        r6.f6235g = r7.getLong(r5);     // Catch: Throwable -> L10
    L8:
        r7.close();
        r0.release();
        return r6;
    L7:
        r6 = null;
    L10:
        th = move-exception;
        r7.close();
        r0.release();
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.a
    public void e(String r3) {
        SupportSQLiteStatement r0 = this.f6197e.acquire();
        this.f6193a.beginTransaction();
        if (r3 != null) goto L5;
        r0.bindNull(1);     // Catch: Throwable -> L9
    L6:
        r0.executeUpdateDelete();     // Catch: Throwable -> L9
        this.f6193a.setTransactionSuccessful();     // Catch: Throwable -> L9
        this.f6193a.endTransaction();
        this.f6197e.release(r0);
        return;
    L5:
        r0.bindString(1, r3);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.f6193a.endTransaction();
        this.f6197e.release(r0);
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.a
    public List<com.bytedance.sync.v2.presistence.d.c> f(String r12) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM t_sync_cursor WHERE did = ?", 1);
        if (r12 != null) goto L5;
        r0.bindNull(1);
    L6:
        Cursor r11 = this.f6193a.query(r0);
        int r13 = r11.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L14
        int r1 = r11.getColumnIndexOrThrow("did");     // Catch: Throwable -> L14
        int r2 = r11.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L14
        int r3 = r11.getColumnIndexOrThrow("topic_type");     // Catch: Throwable -> L14
        int r4 = r11.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L14
        int r5 = r11.getColumnIndexOrThrow("recv_cursor");     // Catch: Throwable -> L14
        int r6 = r11.getColumnIndexOrThrow("report_cursor");     // Catch: Throwable -> L14
        ArrayList r7 = new ArrayList(r11.getCount());     // Catch: Throwable -> L14
    L9:
        if (r11.moveToNext() == false) goto L12;
        com.bytedance.sync.v2.presistence.d.c r8 = new com.bytedance.sync.v2.presistence.d.c();     // Catch: Throwable -> L14
        r8.f6229a = r11.getString(r13);     // Catch: Throwable -> L14
        r8.f6230b = r11.getString(r1);     // Catch: Throwable -> L14
        r8.f6231c = r11.getString(r2);     // Catch: Throwable -> L14
        r8.f6232d = com.bytedance.sync.v2.presistence.b.g.b(r11.getInt(r3));     // Catch: Throwable -> L14
        r8.f6233e = com.bytedance.sync.v2.presistence.b.a.b(r11.getInt(r4));     // Catch: Throwable -> L14
        r8.f6234f = r11.getLong(r5);     // Catch: Throwable -> L14
        r8.f6235g = r11.getLong(r6);     // Catch: Throwable -> L14
        r7.add(r8);     // Catch: Throwable -> L14
        goto L9
    L12:
        r11.close();
        r0.release();
        return r7;
    L14:
        th = move-exception;
        r11.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r12);
        goto L6
    }

    @Override // com.bytedance.sync.v2.presistence.c.a
    public int g(String r3, long r4) {
        SupportSQLiteStatement r0 = this.f6196d.acquire();
        this.f6193a.beginTransaction();
        r0.bindLong(1, r4);     // Catch: Throwable -> L10
        if (r3 != null) goto L6;
        r0.bindNull(2);     // Catch: Throwable -> L10
    L7:
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f6193a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f6193a.endTransaction();
        this.f6196d.release(r0);
        return r5;
    L6:
        r0.bindString(2, r3);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.f6193a.endTransaction();
        this.f6196d.release(r0);
        throw th;
    }
}

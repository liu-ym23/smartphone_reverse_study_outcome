package com.bytedance.sync.v2.presistence.c;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sync.v2.j.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class f implements com.bytedance.sync.v2.presistence.c.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f6201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter f6202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityInsertionAdapter f6203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter f6204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SharedSQLiteStatement f6205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SharedSQLiteStatement f6206f;

    class a extends EntityInsertionAdapter<com.bytedance.sync.v2.presistence.d.e> {
        a(f r1, RoomDatabase r2) {
            super(r2);
        }

        public void a(SupportSQLiteStatement r4, com.bytedance.sync.v2.presistence.d.e r5) {
            String r3 = r5.f6248a;
            if (r3 != null) goto L5;
            r4.bindNull(1);
        L6:
            String r6 = r5.f6249b;
            if (r6 != null) goto L9;
            r4.bindNull(2);
        L10:
            String r7 = r5.f6250c;
            if (r7 != null) goto L13;
            r4.bindNull(3);
        L14:
            r4.bindLong(4, r5.f6251d);
            byte[] r8 = r5.f6252e;
            if (r8 != null) goto L17;
            r4.bindNull(5);
        L18:
            String r9 = r5.f6253f;
            if (r9 != null) goto L21;
            r4.bindNull(6);
        L22:
            r4.bindLong(7, r5.f6254g);
            r4.bindLong(8, com.bytedance.sync.v2.presistence.b.b.a(r5.f6255h));
            r4.bindLong(9, d.b.u.a0.a.a.a(r5.f6256i));
            r4.bindLong(10, r5.f6257j);
            r4.bindLong(11, r5.f6258k);
            r4.bindLong(12, com.bytedance.sync.v2.presistence.b.a.a(r5.f6259l));
            String r10 = r5.m;
            if (r10 != null) goto L25;
            r4.bindNull(13);
        L26:
            r4.bindLong(14, com.bytedance.sync.v2.presistence.b.g.a(r5.n));
            r4.bindLong(15, com.bytedance.sync.v2.presistence.b.d.a(r5.o));
            String r11 = com.bytedance.sync.v2.presistence.b.c.a(r5.p);
            if (r11 != null) goto L29;
            r4.bindNull(16);
            return;
        L29:
            r4.bindString(16, r11);
            return;
        L25:
            r4.bindString(13, r10);
            goto L26
        L21:
            r4.bindString(6, r9);
            goto L22
        L17:
            r4.bindBlob(5, r8);
            goto L18
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
        public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement r1, com.bytedance.sync.v2.presistence.d.e r2) {
            a(r1, r2);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_synclog`(`sync_id`,`did`,`uid`,`sync_cursor`,`data`,`md5`,`business`,`consume_type`,`data_type`,`publish_ts`,`receive_ts`,`bucket`,`req_id`,`topic_type`,`packet_status`,`extra`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends EntityInsertionAdapter<com.bytedance.sync.v2.presistence.d.b> {
        b(f r1, RoomDatabase r2) {
            super(r2);
        }

        public void a(SupportSQLiteStatement r4, com.bytedance.sync.v2.presistence.d.b r5) {
            String r3 = r5.f6217a;
            if (r3 != null) goto L5;
            r4.bindNull(1);
        L6:
            r4.bindLong(2, r5.f6218b);
            String r6 = r5.f6219c;
            if (r6 != null) goto L9;
            r4.bindNull(3);
        L10:
            String r7 = r5.f6220d;
            if (r7 != null) goto L13;
            r4.bindNull(4);
        L14:
            r4.bindLong(5, r5.f6221e);
            byte[] r8 = r5.f6222f;
            if (r8 != null) goto L17;
            r4.bindNull(6);
        L18:
            r4.bindLong(7, r5.f6223g);
            r4.bindLong(8, com.bytedance.sync.v2.presistence.b.a.a(r5.f6224h));
            r4.bindLong(9, d.b.u.a0.a.a.a(r5.f6225i));
            r4.bindLong(10, r5.f6226j);
            r4.bindLong(11, r5.f6227k);
            r4.bindLong(12, com.bytedance.sync.v2.presistence.b.b.a(r5.f6228l));
            r4.bindLong(13, r5.m);
            return;
        L17:
            r4.bindBlob(6, r8);
            goto L18
        L13:
            r4.bindString(4, r7);
            goto L14
        L9:
            r4.bindString(3, r6);
            goto L10
        L5:
            r4.bindString(1, r3);
            goto L6
        }

        @Override // androidx.room.EntityInsertionAdapter
        public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement r1, com.bytedance.sync.v2.presistence.d.b r2) {
            a(r1, r2);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_snapshot`(`sync_id`,`business`,`uid`,`did`,`cursor`,`data`,`notified`,`bucket`,`data_type`,`publish_ts`,`receive_ts`,`consume_type`,`patch_cnt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class c extends EntityDeletionOrUpdateAdapter<com.bytedance.sync.v2.presistence.d.e> {
        c(f r1, RoomDatabase r2) {
            super(r2);
        }

        public void a(SupportSQLiteStatement r3, com.bytedance.sync.v2.presistence.d.e r4) {
            String r2 = r4.f6248a;
            if (r2 != null) goto L5;
            r3.bindNull(1);
        L6:
            r3.bindLong(2, r4.f6251d);
            return;
        L5:
            r3.bindString(1, r2);
            goto L6
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement r1, com.bytedance.sync.v2.presistence.d.e r2) {
            a(r1, r2);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `t_synclog` WHERE `sync_id` = ? AND `sync_cursor` = ?";
        }
    }

    class d extends SharedSQLiteStatement {
        d(f r1, RoomDatabase r2) {
            super(r2);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM t_synclog WHERE sync_id = ?";
        }
    }

    class e extends SharedSQLiteStatement {
        e(f r1, RoomDatabase r2) {
            super(r2);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM t_snapshot WHERE sync_id = ?";
        }
    }

    public f(RoomDatabase r2) {
        this.f6201a = r2;
        this.f6202b = new a(this, r2);
        this.f6203c = new b(this, r2);
        this.f6204d = new c(this, r2);
        this.f6205e = new d(this, r2);
        this.f6206f = new e(this, r2);
    }

    @Override // com.bytedance.sync.v2.presistence.c.e
    public void a(String r3) {
        SupportSQLiteStatement r0 = this.f6206f.acquire();
        this.f6201a.beginTransaction();
        if (r3 != null) goto L5;
        r0.bindNull(1);     // Catch: Throwable -> L9
    L6:
        r0.executeUpdateDelete();     // Catch: Throwable -> L9
        this.f6201a.setTransactionSuccessful();     // Catch: Throwable -> L9
        this.f6201a.endTransaction();
        this.f6206f.release(r0);
        return;
    L5:
        r0.bindString(1, r3);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.f6201a.endTransaction();
        this.f6206f.release(r0);
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.e
    public void b(String r3) {
        SupportSQLiteStatement r0 = this.f6205e.acquire();
        this.f6201a.beginTransaction();
        if (r3 != null) goto L5;
        r0.bindNull(1);     // Catch: Throwable -> L9
    L6:
        r0.executeUpdateDelete();     // Catch: Throwable -> L9
        this.f6201a.setTransactionSuccessful();     // Catch: Throwable -> L9
        this.f6201a.endTransaction();
        this.f6205e.release(r0);
        return;
    L5:
        r0.bindString(1, r3);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.f6201a.endTransaction();
        this.f6205e.release(r0);
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.e
    public List<com.bytedance.sync.v2.presistence.d.e> c(Set<Long> r20, n r21, int r22, int r23) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM t_synclog WHERE sync_id in (");
        int r1 = r20.size();
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(") AND packet_status =");
        r0.append("?");
        r0.append(" ORDER BY sync_id, business, sync_cursor ASC LIMIT ");
        r0.append("?");
        r0.append(" offset ");
        r0.append("?");
        int r2 = r1 + 3;
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire(r0.toString(), r2);
        Iterator<Long> r4 = r20.iterator();
        int r5 = 1;
    L4:
        if (r4.hasNext() == false) goto L10;
        Long r6 = r4.next();
        if (r6 != null) goto L8;
        r3.bindNull(r5);
    L9:
        r5 = r5 + 1;
        goto L4
    L8:
        r3.bindLong(r5, r6.longValue());
        goto L9
    L10:
        r3.bindLong(r1 + 1, com.bytedance.sync.v2.presistence.b.d.a(r21));
        r3.bindLong(r1 + 2, r22);
        r3.bindLong(r2, r23);
        Cursor r7 = this.f6201a.query(r3);
        int r8 = r7.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L22
        int r9 = r7.getColumnIndexOrThrow("did");     // Catch: Throwable -> L22
        int r10 = r7.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L22
        int r11 = r7.getColumnIndexOrThrow("sync_cursor");     // Catch: Throwable -> L22
        int r12 = r7.getColumnIndexOrThrow("data");     // Catch: Throwable -> L22
        int r13 = r7.getColumnIndexOrThrow("md5");     // Catch: Throwable -> L22
        int r14 = r7.getColumnIndexOrThrow("business");     // Catch: Throwable -> L22
        int r15 = r7.getColumnIndexOrThrow("consume_type");     // Catch: Throwable -> L22
        int r16 = r7.getColumnIndexOrThrow("data_type");     // Catch: Throwable -> L22
        int r17 = r7.getColumnIndexOrThrow("publish_ts");     // Catch: Throwable -> L22
        int r18 = r7.getColumnIndexOrThrow("receive_ts");     // Catch: Throwable -> L22
        int r19 = r7.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L22
        int r110 = r7.getColumnIndexOrThrow("req_id");     // Catch: Throwable -> L22
        int r111 = r7.getColumnIndexOrThrow("topic_type");     // Catch: Throwable -> L22
        RoomSQLiteQuery r112 = r3;
        int r113 = r7.getColumnIndexOrThrow("packet_status");     // Catch: Throwable -> L20
        int r24 = r7.getColumnIndexOrThrow(WsConstants.KEY_EXTRA);     // Catch: Throwable -> L20
        int r25 = r111;
        ArrayList r26 = new ArrayList(r7.getCount());     // Catch: Throwable -> L20
    L15:
        if (r7.moveToNext() == false) goto L18;
        com.bytedance.sync.v2.presistence.d.e r114 = new com.bytedance.sync.v2.presistence.d.e();     // Catch: Throwable -> L20
        ArrayList r27 = r26;
        r114.f6248a = r7.getString(r8);     // Catch: Throwable -> L20
        r114.f6249b = r7.getString(r9);     // Catch: Throwable -> L20
        r114.f6250c = r7.getString(r10);     // Catch: Throwable -> L20
        int r28 = r9;
        r114.f6251d = r7.getLong(r11);     // Catch: Throwable -> L20
        r114.f6252e = r7.getBlob(r12);     // Catch: Throwable -> L20
        r114.f6253f = r7.getString(r13);     // Catch: Throwable -> L20
        r114.f6254g = r7.getLong(r14);     // Catch: Throwable -> L20
        r114.f6255h = com.bytedance.sync.v2.presistence.b.b.b(r7.getInt(r15));     // Catch: Throwable -> L20
        r114.f6256i = d.b.u.a0.a.a.b(r7.getInt(r16));     // Catch: Throwable -> L20
        r114.f6257j = r7.getLong(r17);     // Catch: Throwable -> L20
        r114.f6258k = r7.getLong(r18);     // Catch: Throwable -> L20
        r114.f6259l = com.bytedance.sync.v2.presistence.b.a.b(r7.getInt(r19));     // Catch: Throwable -> L20
        r114.m = r7.getString(r110);     // Catch: Throwable -> L20
        int r29 = r25;
        r114.n = com.bytedance.sync.v2.presistence.b.g.b(r7.getInt(r29));     // Catch: Throwable -> L20
        int r30 = r113;
        int r115 = r8;
        r114.o = com.bytedance.sync.v2.presistence.b.d.b(r7.getInt(r30));     // Catch: Throwable -> L20
        int r31 = r24;
        r24 = r31;
        r114.p = com.bytedance.sync.v2.presistence.b.c.b(r7.getString(r31));     // Catch: Throwable -> L20
        r27.add(r114);     // Catch: Throwable -> L20
        r25 = r29;
        r9 = r28;
        r8 = r115;
        r113 = r30;
        r26 = r27;
        goto L15
    L18:
        ArrayList r32 = r26;
        r7.close();
        r112.release();
        return r32;
    L20:
        th = th;
    L24:
        r7.close();
        r112.release();
        throw th;
    L22:
        th = th;
        r112 = r3;
        goto L24
    }

    @Override // com.bytedance.sync.v2.presistence.c.e
    public void d(com.bytedance.sync.v2.presistence.d.b r2) {
        this.f6201a.beginTransaction();
        this.f6203c.insert(r2);     // Catch: Throwable -> L6
        this.f6201a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f6201a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f6201a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.e
    public long e(com.bytedance.sync.v2.presistence.d.b r3) {
        this.f6201a.beginTransaction();
        long r0 = this.f6203c.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.f6201a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f6201a.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.f6201a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.e
    public List<com.bytedance.sync.v2.presistence.d.b> f(int r18, int r19) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM t_snapshot WHERE notified < cursor ORDER BY sync_id,business LIMIT ? offset ?", 2);
        r2.bindLong(1, r18);
        r2.bindLong(2, r19);
        Cursor r1 = this.f6201a.query(r2);
        int r0 = r1.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L14
        int r3 = r1.getColumnIndexOrThrow("business");     // Catch: Throwable -> L14
        int r4 = r1.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L14
        int r5 = r1.getColumnIndexOrThrow("did");     // Catch: Throwable -> L14
        int r6 = r1.getColumnIndexOrThrow("cursor");     // Catch: Throwable -> L14
        int r7 = r1.getColumnIndexOrThrow("data");     // Catch: Throwable -> L14
        int r8 = r1.getColumnIndexOrThrow("notified");     // Catch: Throwable -> L14
        int r9 = r1.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L14
        int r10 = r1.getColumnIndexOrThrow("data_type");     // Catch: Throwable -> L14
        int r11 = r1.getColumnIndexOrThrow("publish_ts");     // Catch: Throwable -> L14
        int r12 = r1.getColumnIndexOrThrow("receive_ts");     // Catch: Throwable -> L14
        int r13 = r1.getColumnIndexOrThrow("consume_type");     // Catch: Throwable -> L14
        int r14 = r1.getColumnIndexOrThrow("patch_cnt");     // Catch: Throwable -> L14
        RoomSQLiteQuery r16 = r2;
        ArrayList r15 = new ArrayList(r1.getCount());     // Catch: Throwable -> L12
    L7:
        if (r1.moveToNext() == false) goto L10;
        com.bytedance.sync.v2.presistence.d.b r17 = new com.bytedance.sync.v2.presistence.d.b();     // Catch: Throwable -> L12
        r17.f6217a = r1.getString(r0);     // Catch: Throwable -> L12
        r17.f6218b = r1.getLong(r3);     // Catch: Throwable -> L12
        r17.f6219c = r1.getString(r4);     // Catch: Throwable -> L12
        r17.f6220d = r1.getString(r5);     // Catch: Throwable -> L12
        r17.f6221e = r1.getLong(r6);     // Catch: Throwable -> L12
        r17.f6222f = r1.getBlob(r7);     // Catch: Throwable -> L12
        r17.f6223g = r1.getLong(r8);     // Catch: Throwable -> L12
        r17.f6224h = com.bytedance.sync.v2.presistence.b.a.b(r1.getInt(r9));     // Catch: Throwable -> L12
        r17.f6225i = d.b.u.a0.a.a.b(r1.getInt(r10));     // Catch: Throwable -> L12
        r17.f6226j = r1.getLong(r11);     // Catch: Throwable -> L12
        r17.f6227k = r1.getLong(r12);     // Catch: Throwable -> L12
        r17.f6228l = com.bytedance.sync.v2.presistence.b.b.b(r1.getInt(r13));     // Catch: Throwable -> L12
        r14 = r14;
        r17.m = r1.getInt(r14);     // Catch: Throwable -> L12
        r15 = r15;
        r15.add(r17);     // Catch: Throwable -> L12
        goto L7
    L10:
        r1.close();
        r16.release();
        return r15;
    L12:
        th = th;
    L16:
        r1.close();
        r16.release();
        throw th;
    L14:
        th = th;
        r16 = r2;
        goto L16
    }

    @Override // com.bytedance.sync.v2.presistence.c.e
    public void g(ArrayList<com.bytedance.sync.v2.presistence.d.e> r2) {
        this.f6201a.beginTransaction();
        this.f6202b.insert(r2);     // Catch: Throwable -> L6
        this.f6201a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f6201a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f6201a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.e
    public List<com.bytedance.sync.v2.presistence.d.e> h(long r19, int r21, com.bytedance.sync.v2.j.h r22, int r23) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM t_synclog WHERE business = ? AND consume_type = ? ORDER BY sync_cursor ASC limit ? offset ?", 4);
        r2.bindLong(1, r19);
        r2.bindLong(2, com.bytedance.sync.v2.presistence.b.b.a(r22));
        r2.bindLong(3, r21);
        r2.bindLong(4, r23);
        Cursor r1 = this.f6201a.query(r2);
        int r0 = r1.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L14
        int r3 = r1.getColumnIndexOrThrow("did");     // Catch: Throwable -> L14
        int r4 = r1.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L14
        int r5 = r1.getColumnIndexOrThrow("sync_cursor");     // Catch: Throwable -> L14
        int r6 = r1.getColumnIndexOrThrow("data");     // Catch: Throwable -> L14
        int r7 = r1.getColumnIndexOrThrow("md5");     // Catch: Throwable -> L14
        int r8 = r1.getColumnIndexOrThrow("business");     // Catch: Throwable -> L14
        int r9 = r1.getColumnIndexOrThrow("consume_type");     // Catch: Throwable -> L14
        int r10 = r1.getColumnIndexOrThrow("data_type");     // Catch: Throwable -> L14
        int r11 = r1.getColumnIndexOrThrow("publish_ts");     // Catch: Throwable -> L14
        int r12 = r1.getColumnIndexOrThrow("receive_ts");     // Catch: Throwable -> L14
        int r13 = r1.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L14
        int r14 = r1.getColumnIndexOrThrow("req_id");     // Catch: Throwable -> L14
        int r15 = r1.getColumnIndexOrThrow("topic_type");     // Catch: Throwable -> L14
        RoomSQLiteQuery r16 = r2;
        int r18 = r1.getColumnIndexOrThrow("packet_status");     // Catch: Throwable -> L12
        int r110 = r1.getColumnIndexOrThrow(WsConstants.KEY_EXTRA);     // Catch: Throwable -> L12
        int r20 = r15;
        ArrayList r17 = new ArrayList(r1.getCount());     // Catch: Throwable -> L12
    L7:
        if (r1.moveToNext() == false) goto L10;
        com.bytedance.sync.v2.presistence.d.e r111 = new com.bytedance.sync.v2.presistence.d.e();     // Catch: Throwable -> L12
        ArrayList r24 = r17;
        r111.f6248a = r1.getString(r0);     // Catch: Throwable -> L12
        r111.f6249b = r1.getString(r3);     // Catch: Throwable -> L12
        r111.f6250c = r1.getString(r4);     // Catch: Throwable -> L12
        int r25 = r3;
        r111.f6251d = r1.getLong(r5);     // Catch: Throwable -> L12
        r111.f6252e = r1.getBlob(r6);     // Catch: Throwable -> L12
        r111.f6253f = r1.getString(r7);     // Catch: Throwable -> L12
        r111.f6254g = r1.getLong(r8);     // Catch: Throwable -> L12
        r111.f6255h = com.bytedance.sync.v2.presistence.b.b.b(r1.getInt(r9));     // Catch: Throwable -> L12
        r111.f6256i = d.b.u.a0.a.a.b(r1.getInt(r10));     // Catch: Throwable -> L12
        r111.f6257j = r1.getLong(r11);     // Catch: Throwable -> L12
        r111.f6258k = r1.getLong(r12);     // Catch: Throwable -> L12
        r111.f6259l = com.bytedance.sync.v2.presistence.b.a.b(r1.getInt(r13));     // Catch: Throwable -> L12
        r111.m = r1.getString(r14);     // Catch: Throwable -> L12
        int r26 = r20;
        r111.n = com.bytedance.sync.v2.presistence.b.g.b(r1.getInt(r26));     // Catch: Throwable -> L12
        int r27 = r18;
        int r112 = r0;
        r111.o = com.bytedance.sync.v2.presistence.b.d.b(r1.getInt(r27));     // Catch: Throwable -> L12
        int r28 = r110;
        r110 = r28;
        r111.p = com.bytedance.sync.v2.presistence.b.c.b(r1.getString(r28));     // Catch: Throwable -> L12
        r24.add(r111);     // Catch: Throwable -> L12
        r20 = r26;
        r17 = r24;
        r0 = r112;
        r18 = r27;
        r3 = r25;
        goto L7
    L10:
        ArrayList r29 = r17;
        r1.close();
        r16.release();
        return r29;
    L12:
        th = th;
    L16:
        r1.close();
        r16.release();
        throw th;
    L14:
        th = th;
        r16 = r2;
        goto L16
    }

    @Override // com.bytedance.sync.v2.presistence.c.e
    public int i(List<? extends com.bytedance.sync.v2.presistence.d.e> r2) {
        this.f6201a.beginTransaction();
        int r3 = this.f6204d.handleMultiple(r2) + 0;     // Catch: Throwable -> L6
        this.f6201a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f6201a.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.f6201a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.e
    public com.bytedance.sync.v2.presistence.d.b k(String r13, long r14) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM t_snapshot WHERE sync_id = ? AND business = ? ", 2);
        if (r13 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r14);
        Cursor r12 = this.f6201a.query(r0);
        int r15 = r12.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L14
        int r16 = r12.getColumnIndexOrThrow("business");     // Catch: Throwable -> L14
        int r17 = r12.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L14
        int r1 = r12.getColumnIndexOrThrow("did");     // Catch: Throwable -> L14
        int r2 = r12.getColumnIndexOrThrow("cursor");     // Catch: Throwable -> L14
        int r3 = r12.getColumnIndexOrThrow("data");     // Catch: Throwable -> L14
        int r4 = r12.getColumnIndexOrThrow("notified");     // Catch: Throwable -> L14
        int r5 = r12.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L14
        int r6 = r12.getColumnIndexOrThrow("data_type");     // Catch: Throwable -> L14
        int r7 = r12.getColumnIndexOrThrow("publish_ts");     // Catch: Throwable -> L14
        int r8 = r12.getColumnIndexOrThrow("receive_ts");     // Catch: Throwable -> L14
        int r9 = r12.getColumnIndexOrThrow("consume_type");     // Catch: Throwable -> L14
        int r10 = r12.getColumnIndexOrThrow("patch_cnt");     // Catch: Throwable -> L14
        if (r12.moveToFirst() == false) goto L11;
        com.bytedance.sync.v2.presistence.d.b r11 = new com.bytedance.sync.v2.presistence.d.b();     // Catch: Throwable -> L14
        r11.f6217a = r12.getString(r15);     // Catch: Throwable -> L14
        r11.f6218b = r12.getLong(r16);     // Catch: Throwable -> L14
        r11.f6219c = r12.getString(r17);     // Catch: Throwable -> L14
        r11.f6220d = r12.getString(r1);     // Catch: Throwable -> L14
        r11.f6221e = r12.getLong(r2);     // Catch: Throwable -> L14
        r11.f6222f = r12.getBlob(r3);     // Catch: Throwable -> L14
        r11.f6223g = r12.getLong(r4);     // Catch: Throwable -> L14
        r11.f6224h = com.bytedance.sync.v2.presistence.b.a.b(r12.getInt(r5));     // Catch: Throwable -> L14
        r11.f6225i = d.b.u.a0.a.a.b(r12.getInt(r6));     // Catch: Throwable -> L14
        r11.f6226j = r12.getLong(r7);     // Catch: Throwable -> L14
        r11.f6227k = r12.getLong(r8);     // Catch: Throwable -> L14
        r11.f6228l = com.bytedance.sync.v2.presistence.b.b.b(r12.getInt(r9));     // Catch: Throwable -> L14
        r11.m = r12.getInt(r10);     // Catch: Throwable -> L14
    L12:
        r12.close();
        r0.release();
        return r11;
    L11:
        r11 = null;
    L14:
        th = move-exception;
        r12.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r13);
        goto L6
    }
}

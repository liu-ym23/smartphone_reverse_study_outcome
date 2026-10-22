package com.bytedance.sync.v2.presistence.c;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sync.v2.j.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f6198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter f6199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter f6200c;

    class a extends EntityInsertionAdapter<com.bytedance.sync.v2.presistence.d.d> {
        a(d r1, RoomDatabase r2) {
            super(r2);
        }

        public void a(SupportSQLiteStatement r4, com.bytedance.sync.v2.presistence.d.d r5) {
            String r3 = r5.f6236a;
            if (r3 != null) goto L5;
            r4.bindNull(1);
        L6:
            String r6 = r5.f6237b;
            if (r6 != null) goto L9;
            r4.bindNull(2);
        L10:
            String r7 = r5.f6238c;
            if (r7 != null) goto L13;
            r4.bindNull(3);
        L14:
            r4.bindLong(4, r5.f6239d);
            byte[] r8 = r5.f6240e;
            if (r8 != null) goto L17;
            r4.bindNull(5);
        L18:
            String r9 = r5.f6241f;
            if (r9 != null) goto L21;
            r4.bindNull(6);
        L22:
            r4.bindLong(7, r5.f6242g);
            r4.bindLong(8, com.bytedance.sync.v2.presistence.b.b.a(r5.f6243h));
            r4.bindLong(9, d.b.u.a0.a.a.a(r5.f6244i));
            r4.bindLong(10, r5.f6245j);
            r4.bindLong(11, r5.f6246k);
            r4.bindLong(12, com.bytedance.sync.v2.presistence.b.a.a(r5.f6247l));
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
        public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement r1, com.bytedance.sync.v2.presistence.d.d r2) {
            a(r1, r2);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_history_synclog`(`sync_id`,`did`,`uid`,`sync_cursor`,`data`,`md5`,`business`,`consume_type`,`data_type`,`publish_ts`,`receive_ts`,`bucket`,`req_id`,`topic_type`,`packet_status`,`extra`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<com.bytedance.sync.v2.presistence.d.d> {
        b(d r1, RoomDatabase r2) {
            super(r2);
        }

        public void a(SupportSQLiteStatement r3, com.bytedance.sync.v2.presistence.d.d r4) {
            String r2 = r4.f6236a;
            if (r2 != null) goto L5;
            r3.bindNull(1);
        L6:
            r3.bindLong(2, r4.f6239d);
            return;
        L5:
            r3.bindString(1, r2);
            goto L6
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement r1, com.bytedance.sync.v2.presistence.d.d r2) {
            a(r1, r2);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `t_history_synclog` WHERE `sync_id` = ? AND `sync_cursor` = ?";
        }
    }

    public d(RoomDatabase r2) {
        this.f6198a = r2;
        this.f6199b = new a(this, r2);
        this.f6200c = new b(this, r2);
    }

    @Override // com.bytedance.sync.v2.presistence.c.c
    public List<com.bytedance.sync.v2.presistence.d.d> a(String r19, String r20, long r21, p r23, int r24) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM t_history_synclog  WHERE did=? AND uid in (0, ?) AND business =?  AND topic_type = ? ORDER BY sync_cursor DESC  LIMIT ?", 5);
        if (r19 != null) goto L5;
        r2.bindNull(1);
    L7:
        if (r20 != null) goto L9;
        r2.bindNull(2);
    L10:
        r2.bindLong(3, r21);
        r2.bindLong(4, com.bytedance.sync.v2.presistence.b.g.a(r23));
        r2.bindLong(5, r24);
        Cursor r1 = this.f6198a.query(r2);
        int r0 = r1.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L22
        int r3 = r1.getColumnIndexOrThrow("did");     // Catch: Throwable -> L22
        int r4 = r1.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L22
        int r5 = r1.getColumnIndexOrThrow("sync_cursor");     // Catch: Throwable -> L22
        int r6 = r1.getColumnIndexOrThrow("data");     // Catch: Throwable -> L22
        int r7 = r1.getColumnIndexOrThrow("md5");     // Catch: Throwable -> L22
        int r8 = r1.getColumnIndexOrThrow("business");     // Catch: Throwable -> L22
        int r9 = r1.getColumnIndexOrThrow("consume_type");     // Catch: Throwable -> L22
        int r10 = r1.getColumnIndexOrThrow("data_type");     // Catch: Throwable -> L22
        int r11 = r1.getColumnIndexOrThrow("publish_ts");     // Catch: Throwable -> L22
        int r12 = r1.getColumnIndexOrThrow("receive_ts");     // Catch: Throwable -> L22
        int r13 = r1.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L22
        int r14 = r1.getColumnIndexOrThrow("req_id");     // Catch: Throwable -> L22
        int r15 = r1.getColumnIndexOrThrow("topic_type");     // Catch: Throwable -> L22
        RoomSQLiteQuery r16 = r2;
        int r18 = r1.getColumnIndexOrThrow("packet_status");     // Catch: Throwable -> L20
        int r110 = r1.getColumnIndexOrThrow(WsConstants.KEY_EXTRA);     // Catch: Throwable -> L20
        int r22 = r15;
        ArrayList r17 = new ArrayList(r1.getCount());     // Catch: Throwable -> L20
    L15:
        if (r1.moveToNext() == false) goto L18;
        com.bytedance.sync.v2.presistence.d.d r111 = new com.bytedance.sync.v2.presistence.d.d();     // Catch: Throwable -> L20
        ArrayList r25 = r17;
        r111.f6236a = r1.getString(r0);     // Catch: Throwable -> L20
        r111.f6237b = r1.getString(r3);     // Catch: Throwable -> L20
        r111.f6238c = r1.getString(r4);     // Catch: Throwable -> L20
        int r26 = r3;
        r111.f6239d = r1.getLong(r5);     // Catch: Throwable -> L20
        r111.f6240e = r1.getBlob(r6);     // Catch: Throwable -> L20
        r111.f6241f = r1.getString(r7);     // Catch: Throwable -> L20
        r111.f6242g = r1.getLong(r8);     // Catch: Throwable -> L20
        r111.f6243h = com.bytedance.sync.v2.presistence.b.b.b(r1.getInt(r9));     // Catch: Throwable -> L20
        r111.f6244i = d.b.u.a0.a.a.b(r1.getInt(r10));     // Catch: Throwable -> L20
        r111.f6245j = r1.getLong(r11);     // Catch: Throwable -> L20
        r111.f6246k = r1.getLong(r12);     // Catch: Throwable -> L20
        r111.f6247l = com.bytedance.sync.v2.presistence.b.a.b(r1.getInt(r13));     // Catch: Throwable -> L20
        r111.m = r1.getString(r14);     // Catch: Throwable -> L20
        int r27 = r22;
        r111.n = com.bytedance.sync.v2.presistence.b.g.b(r1.getInt(r27));     // Catch: Throwable -> L20
        int r28 = r18;
        int r112 = r0;
        r111.o = com.bytedance.sync.v2.presistence.b.d.b(r1.getInt(r28));     // Catch: Throwable -> L20
        int r29 = r110;
        r110 = r29;
        r111.p = com.bytedance.sync.v2.presistence.b.c.b(r1.getString(r29));     // Catch: Throwable -> L20
        r25.add(r111);     // Catch: Throwable -> L20
        r22 = r27;
        r17 = r25;
        r0 = r112;
        r18 = r28;
        r3 = r26;
        goto L15
    L18:
        ArrayList r30 = r17;
        r1.close();
        r16.release();
        return r30;
    L20:
        th = th;
    L24:
        r1.close();
        r16.release();
        throw th;
    L22:
        th = th;
        r16 = r2;
        goto L24
    L9:
        r2.bindString(2, r20);
        goto L10
    L5:
        r2.bindString(1, r19);
        goto L7
    }

    @Override // com.bytedance.sync.v2.presistence.c.c
    public void b(List<? extends com.bytedance.sync.v2.presistence.d.d> r2) {
        this.f6198a.beginTransaction();
        this.f6200c.handleMultiple(r2);     // Catch: Throwable -> L6
        this.f6198a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f6198a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f6198a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.sync.v2.presistence.c.c
    public List<com.bytedance.sync.v2.presistence.d.d> c(String r20, String r21, long r22, p r24, String r25, int r26) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM t_history_synclog  WHERE did=? AND uid in (0, ?) AND business =?  AND topic_type = ? AND req_id = ? ORDER BY sync_cursor DESC LIMIT ?", 6);
        if (r20 != null) goto L5;
        r3.bindNull(1);
    L7:
        if (r21 != null) goto L9;
        r3.bindNull(2);
    L10:
        r3.bindLong(3, r22);
        r3.bindLong(4, com.bytedance.sync.v2.presistence.b.g.a(r24));
        if (r25 != null) goto L13;
        r3.bindNull(5);
    L14:
        r3.bindLong(6, r26);
        Cursor r1 = this.f6198a.query(r3);
        int r0 = r1.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L26
        int r2 = r1.getColumnIndexOrThrow("did");     // Catch: Throwable -> L26
        int r4 = r1.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L26
        int r5 = r1.getColumnIndexOrThrow("sync_cursor");     // Catch: Throwable -> L26
        int r6 = r1.getColumnIndexOrThrow("data");     // Catch: Throwable -> L26
        int r7 = r1.getColumnIndexOrThrow("md5");     // Catch: Throwable -> L26
        int r8 = r1.getColumnIndexOrThrow("business");     // Catch: Throwable -> L26
        int r9 = r1.getColumnIndexOrThrow("consume_type");     // Catch: Throwable -> L26
        int r10 = r1.getColumnIndexOrThrow("data_type");     // Catch: Throwable -> L26
        int r11 = r1.getColumnIndexOrThrow("publish_ts");     // Catch: Throwable -> L26
        int r12 = r1.getColumnIndexOrThrow("receive_ts");     // Catch: Throwable -> L26
        int r13 = r1.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L26
        int r14 = r1.getColumnIndexOrThrow("req_id");     // Catch: Throwable -> L26
        int r15 = r1.getColumnIndexOrThrow("topic_type");     // Catch: Throwable -> L26
        RoomSQLiteQuery r16 = r3;
        int r19 = r1.getColumnIndexOrThrow("packet_status");     // Catch: Throwable -> L24
        int r23 = r1.getColumnIndexOrThrow(WsConstants.KEY_EXTRA);     // Catch: Throwable -> L24
        int r27 = r15;
        ArrayList r17 = new ArrayList(r1.getCount());     // Catch: Throwable -> L24
    L19:
        if (r1.moveToNext() == false) goto L22;
        com.bytedance.sync.v2.presistence.d.d r18 = new com.bytedance.sync.v2.presistence.d.d();     // Catch: Throwable -> L24
        ArrayList r28 = r17;
        r18.f6236a = r1.getString(r0);     // Catch: Throwable -> L24
        r18.f6237b = r1.getString(r2);     // Catch: Throwable -> L24
        r18.f6238c = r1.getString(r4);     // Catch: Throwable -> L24
        int r29 = r2;
        r18.f6239d = r1.getLong(r5);     // Catch: Throwable -> L24
        r18.f6240e = r1.getBlob(r6);     // Catch: Throwable -> L24
        r18.f6241f = r1.getString(r7);     // Catch: Throwable -> L24
        r18.f6242g = r1.getLong(r8);     // Catch: Throwable -> L24
        r18.f6243h = com.bytedance.sync.v2.presistence.b.b.b(r1.getInt(r9));     // Catch: Throwable -> L24
        r18.f6244i = d.b.u.a0.a.a.b(r1.getInt(r10));     // Catch: Throwable -> L24
        r18.f6245j = r1.getLong(r11);     // Catch: Throwable -> L24
        r18.f6246k = r1.getLong(r12);     // Catch: Throwable -> L24
        r18.f6247l = com.bytedance.sync.v2.presistence.b.a.b(r1.getInt(r13));     // Catch: Throwable -> L24
        r18.m = r1.getString(r14);     // Catch: Throwable -> L24
        int r30 = r27;
        r18.n = com.bytedance.sync.v2.presistence.b.g.b(r1.getInt(r30));     // Catch: Throwable -> L24
        int r31 = r19;
        int r110 = r0;
        r18.o = com.bytedance.sync.v2.presistence.b.d.b(r1.getInt(r31));     // Catch: Throwable -> L24
        int r32 = r23;
        r23 = r32;
        r18.p = com.bytedance.sync.v2.presistence.b.c.b(r1.getString(r32));     // Catch: Throwable -> L24
        r28.add(r18);     // Catch: Throwable -> L24
        r27 = r30;
        r2 = r29;
        r0 = r110;
        r19 = r31;
        r17 = r28;
        goto L19
    L22:
        ArrayList r33 = r17;
        r1.close();
        r16.release();
        return r33;
    L24:
        th = th;
    L28:
        r1.close();
        r16.release();
        throw th;
    L26:
        th = th;
        r16 = r3;
        goto L28
    L13:
        r3.bindString(5, r25);
        goto L14
    L9:
        r3.bindString(2, r21);
        goto L10
    L5:
        r3.bindString(1, r20);
        goto L7
    }

    @Override // com.bytedance.sync.v2.presistence.c.c
    public List<com.bytedance.sync.v2.presistence.d.d> d(String r19, String r20, long r21, p r23, int r24) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM t_history_synclog  WHERE did=? AND uid in (0, ?) AND business =?  AND topic_type = ? ORDER BY publish_ts DESC  LIMIT ?", 5);
        if (r19 != null) goto L5;
        r2.bindNull(1);
    L7:
        if (r20 != null) goto L9;
        r2.bindNull(2);
    L10:
        r2.bindLong(3, r21);
        r2.bindLong(4, com.bytedance.sync.v2.presistence.b.g.a(r23));
        r2.bindLong(5, r24);
        Cursor r1 = this.f6198a.query(r2);
        int r0 = r1.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L22
        int r3 = r1.getColumnIndexOrThrow("did");     // Catch: Throwable -> L22
        int r4 = r1.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L22
        int r5 = r1.getColumnIndexOrThrow("sync_cursor");     // Catch: Throwable -> L22
        int r6 = r1.getColumnIndexOrThrow("data");     // Catch: Throwable -> L22
        int r7 = r1.getColumnIndexOrThrow("md5");     // Catch: Throwable -> L22
        int r8 = r1.getColumnIndexOrThrow("business");     // Catch: Throwable -> L22
        int r9 = r1.getColumnIndexOrThrow("consume_type");     // Catch: Throwable -> L22
        int r10 = r1.getColumnIndexOrThrow("data_type");     // Catch: Throwable -> L22
        int r11 = r1.getColumnIndexOrThrow("publish_ts");     // Catch: Throwable -> L22
        int r12 = r1.getColumnIndexOrThrow("receive_ts");     // Catch: Throwable -> L22
        int r13 = r1.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L22
        int r14 = r1.getColumnIndexOrThrow("req_id");     // Catch: Throwable -> L22
        int r15 = r1.getColumnIndexOrThrow("topic_type");     // Catch: Throwable -> L22
        RoomSQLiteQuery r16 = r2;
        int r18 = r1.getColumnIndexOrThrow("packet_status");     // Catch: Throwable -> L20
        int r110 = r1.getColumnIndexOrThrow(WsConstants.KEY_EXTRA);     // Catch: Throwable -> L20
        int r22 = r15;
        ArrayList r17 = new ArrayList(r1.getCount());     // Catch: Throwable -> L20
    L15:
        if (r1.moveToNext() == false) goto L18;
        com.bytedance.sync.v2.presistence.d.d r111 = new com.bytedance.sync.v2.presistence.d.d();     // Catch: Throwable -> L20
        ArrayList r25 = r17;
        r111.f6236a = r1.getString(r0);     // Catch: Throwable -> L20
        r111.f6237b = r1.getString(r3);     // Catch: Throwable -> L20
        r111.f6238c = r1.getString(r4);     // Catch: Throwable -> L20
        int r26 = r3;
        r111.f6239d = r1.getLong(r5);     // Catch: Throwable -> L20
        r111.f6240e = r1.getBlob(r6);     // Catch: Throwable -> L20
        r111.f6241f = r1.getString(r7);     // Catch: Throwable -> L20
        r111.f6242g = r1.getLong(r8);     // Catch: Throwable -> L20
        r111.f6243h = com.bytedance.sync.v2.presistence.b.b.b(r1.getInt(r9));     // Catch: Throwable -> L20
        r111.f6244i = d.b.u.a0.a.a.b(r1.getInt(r10));     // Catch: Throwable -> L20
        r111.f6245j = r1.getLong(r11);     // Catch: Throwable -> L20
        r111.f6246k = r1.getLong(r12);     // Catch: Throwable -> L20
        r111.f6247l = com.bytedance.sync.v2.presistence.b.a.b(r1.getInt(r13));     // Catch: Throwable -> L20
        r111.m = r1.getString(r14);     // Catch: Throwable -> L20
        int r27 = r22;
        r111.n = com.bytedance.sync.v2.presistence.b.g.b(r1.getInt(r27));     // Catch: Throwable -> L20
        int r28 = r18;
        int r112 = r0;
        r111.o = com.bytedance.sync.v2.presistence.b.d.b(r1.getInt(r28));     // Catch: Throwable -> L20
        int r29 = r110;
        r110 = r29;
        r111.p = com.bytedance.sync.v2.presistence.b.c.b(r1.getString(r29));     // Catch: Throwable -> L20
        r25.add(r111);     // Catch: Throwable -> L20
        r22 = r27;
        r17 = r25;
        r0 = r112;
        r18 = r28;
        r3 = r26;
        goto L15
    L18:
        ArrayList r30 = r17;
        r1.close();
        r16.release();
        return r30;
    L20:
        th = th;
    L24:
        r1.close();
        r16.release();
        throw th;
    L22:
        th = th;
        r16 = r2;
        goto L24
    L9:
        r2.bindString(2, r20);
        goto L10
    L5:
        r2.bindString(1, r19);
        goto L7
    }

    @Override // com.bytedance.sync.v2.presistence.c.c
    public void e(ArrayList<com.bytedance.sync.v2.presistence.d.d> r2) {
        this.f6198a.beginTransaction();
        this.f6199b.insert(r2);     // Catch: Throwable -> L6
        this.f6198a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f6198a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f6198a.endTransaction();
        throw th;
    }
}

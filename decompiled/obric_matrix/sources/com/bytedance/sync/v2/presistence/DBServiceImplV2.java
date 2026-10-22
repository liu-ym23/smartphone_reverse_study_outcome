package com.bytedance.sync.v2.presistence;

import android.content.Context;
import android.util.Log;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import com.bytedance.sync.v2.j.g;
import com.bytedance.sync.v2.j.n;
import com.bytedance.sync.v2.j.p;
import d.b.u.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.h;
import kotlin.i;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;

/* JADX INFO: loaded from: classes.dex */
public final class DBServiceImplV2 implements com.bytedance.sync.v2.f.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final /* synthetic */ l[] f6169k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h f6170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final DBServiceImplV2$migration_1_2$1 f6171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final DBServiceImplV2$migration_2_3$1 f6172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final DBServiceImplV2$migration_3_4$1 f6173i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f6174j;

    static final class a<V> implements Callable<Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ DBServiceImplV2 f6175f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f6176g;

        a(DBServiceImplV2 r1, String r2) {
            this.f6175f = r1;
            this.f6176g = r2;
        }

        public final boolean a() {
            DBServiceImplV2.M(this.f6175f).c().b(this.f6176g);
            DBServiceImplV2.M(this.f6175f).c().a(this.f6176g);
            DBServiceImplV2.M(this.f6175f).a().e(this.f6176g);
            return true;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Boolean call() {
            return Boolean.valueOf(a());
        }
    }

    static final class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ DBServiceImplV2 f6177f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayList f6178g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.bytedance.sync.v2.presistence.d.c f6179h;

        b(DBServiceImplV2 r1, ArrayList r2, com.bytedance.sync.v2.presistence.d.c r3) {
            this.f6177f = r1;
            this.f6178g = r2;
            this.f6179h = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DBServiceImplV2.M(this.f6177f).c().g(this.f6178g);
            DBServiceImplV2.M(this.f6177f).a().b(r.e(new com.bytedance.sync.v2.presistence.d.c[]{this.f6179h}));
        }
    }

    static final class c extends q implements kotlin.n0.c.a<AppDatabase> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ DBServiceImplV2 f6180f;

        c(DBServiceImplV2 r1) {
            this.f6180f = r1;
            super(0);
        }

        public final AppDatabase a() {
            RoomDatabase.Builder r0 = Room.databaseBuilder(DBServiceImplV2.F(this.f6180f), AppDatabase.class, "bd_sync_sdk_v2.db");
            o.b(r0, "Room.databaseBuilder(mCo…ava, SyncConstants.DB_V2)");
            r0.addMigrations(new Migration[]{DBServiceImplV2.o0(this.f6180f), DBServiceImplV2.p0(this.f6180f), DBServiceImplV2.q0(this.f6180f)});
            return (AppDatabase) r0.build();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ AppDatabase invoke() {
            return a();
        }
    }

    static final class d<V> implements Callable<Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ DBServiceImplV2 f6181f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.bytedance.sync.v2.presistence.d.b f6182g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f6183h;

        d(DBServiceImplV2 r1, com.bytedance.sync.v2.presistence.d.b r2, List r3) {
            this.f6181f = r1;
            this.f6182g = r2;
            this.f6183h = r3;
        }

        public final boolean a() {
            if (DBServiceImplV2.M(this.f6181f).c().e(this.f6182g) > 0) goto L5;
        L7:
            return false;
        L5:
            if (this.f6181f.i0(this.f6183h) == false) goto L7;
            return true;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Boolean call() {
            return Boolean.valueOf(a());
        }
    }

    static final class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ DBServiceImplV2 f6184f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f6185g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f6186h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f6187i;

        e(DBServiceImplV2 r1, List r2, List r3, List r4) {
            this.f6184f = r1;
            this.f6185g = r2;
            this.f6186h = r3;
            this.f6187i = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DBServiceImplV2.M(this.f6184f).a().a(this.f6185g);
            DBServiceImplV2.M(this.f6184f).a().b(this.f6186h);
            DBServiceImplV2.M(this.f6184f).a().c(this.f6187i);
        }
    }

    static final class f<V> implements Callable<Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ DBServiceImplV2 f6188f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f6189g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f6190h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ com.bytedance.sync.v2.presistence.d.c f6191i;

        f(DBServiceImplV2 r1, List r2, List r3, com.bytedance.sync.v2.presistence.d.c r4) {
            this.f6188f = r1;
            this.f6189g = r2;
            this.f6190h = r3;
            this.f6191i = r4;
        }

        public final boolean a() {
            if ((!this.f6189g.isEmpty()) == true) goto L5;
        L7:
            boolean r0 = false;
        L9:
            if ((!this.f6190h.isEmpty()) == true) goto L11;
        L14:
            if (r0 == false) goto L19;
            com.bytedance.sync.v2.presistence.c.a r1 = DBServiceImplV2.M(this.f6188f).a();
            String r3 = this.f6191i.f6229a;
            o.b(r3, "syncCursor.syncId");
            if (r1.g(r3, this.f6191i.f6235g) <= 0) goto L19;
            return true;
        L19:
            return false;
        L11:
            if (DBServiceImplV2.M(this.f6188f).d().a(this.f6190h) <= 0) goto L13;
            r0 = true;
            goto L14
        L13:
            r0 = false;
            goto L14
        L5:
            if (DBServiceImplV2.M(this.f6188f).d().c(this.f6189g) <= 0) goto L7;
            r0 = true;
            goto L9
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Boolean call() {
            return Boolean.valueOf(a());
        }
    }

    static {
        f6169k = new l[]{e0.g(new y(e0.b(DBServiceImplV2.class), "mDbInst", "getMDbInst()Lcom/bytedance/sync/v2/presistence/AppDatabase;"))};
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.sync.v2.presistence.DBServiceImplV2$migration_1_2$1] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.sync.v2.presistence.DBServiceImplV2$migration_2_3$1] */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.bytedance.sync.v2.presistence.DBServiceImplV2$migration_3_4$1] */
    public DBServiceImplV2(Context r3) {
        o.g(r3, "mContext");
        this.f6174j = r3;
        this.f6170f = i.b(new c(this));
        final int r0 = 1;
        final int r1 = 2;
        this.f6171g = new DBServiceImplV2$migration_1_2$1(r0, r1);
        final int r2 = 3;
        this.f6172h = new DBServiceImplV2$migration_2_3$1(r1, r2);
        final int r4 = 4;
        this.f6173i = new DBServiceImplV2$migration_3_4$1(r2, r4);
    }

    public static final /* synthetic */ Context F(DBServiceImplV2 r0) {
        return r0.f6174j;
    }

    public static final /* synthetic */ AppDatabase M(DBServiceImplV2 r0) {
        return r0.r0();
    }

    public static final /* synthetic */ DBServiceImplV2$migration_1_2$1 o0(DBServiceImplV2 r0) {
        return r0.f6171g;
    }

    public static final /* synthetic */ DBServiceImplV2$migration_2_3$1 p0(DBServiceImplV2 r0) {
        return r0.f6172h;
    }

    public static final /* synthetic */ DBServiceImplV2$migration_3_4$1 q0(DBServiceImplV2 r0) {
        return r0.f6173i;
    }

    private final AppDatabase r0() {
        h r2 = this.f6170f;
        l r0 = f6169k[0];
        return (AppDatabase) r2.getValue();
    }

    @Override // com.bytedance.sync.v2.f.b
    public List<com.bytedance.sync.v2.presistence.d.d> J(p r8, long r9, String r11, int r12) {
        o.g(r8, "topicType");
        List<com.bytedance.sync.v2.presistence.d.d> r7 = s0(r8, r9, r11, -1);     // Catch: Throwable -> L19
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L19
        Iterator<T> r13 = r7.iterator();     // Catch: Throwable -> L19
        int r14 = 0;
    L5:
        if (r13.hasNext() == false) goto L18;
        Object r15 = r13.next();     // Catch: Throwable -> L19
        int r0 = r14 + 1;     // Catch: Throwable -> L19
        if (r14 < 0) goto L15;
        com.bytedance.sync.v2.presistence.d.d r1 = (com.bytedance.sync.v2.presistence.d.d) r15;     // Catch: Throwable -> L19
        if (r14 < r12) goto L11;
        boolean r16 = true;
    L12:
        if (r16 == false) goto L14;
        r10.add(r15);     // Catch: Throwable -> L19
    L14:
        r14 = r0;
        goto L5
    L11:
        r16 = false;
        goto L12
    L15:
        r.p();     // Catch: Throwable -> L19
        throw null;
    L18:
        return r10;
    L19:
        th = move-exception;
        d.b.u.x.b.b(Log.getStackTraceString(th));
        d.b.u.r.f(th, "deleteLimitHistorySyncLog failed, error: " + Log.getStackTraceString(th));
        return r.g();
    }

    @Override // com.bytedance.sync.v2.f.b
    public void R(List<? extends com.bytedance.sync.v2.presistence.d.d> r2) {
        o.g(r2, "deleteHistoryLogs");
        r0().b().b(r2);     // Catch: Throwable -> L5
        return;
    }

    @Override // com.bytedance.sync.v2.f.b
    public boolean T(com.bytedance.sync.v2.presistence.d.b r3, List<? extends com.bytedance.sync.v2.presistence.d.e> r4) {
        o.g(r3, "snapshot");
        o.g(r4, "syncLogs");
        Object r2 = r0().runInTransaction(new d(this, r3, r4));
        o.b(r2, "mDbInst.runInTransaction…Log(syncLogs))\n        })");
        return ((Boolean) r2).booleanValue();
    }

    @Override // com.bytedance.sync.v2.f.b
    public boolean U(String r4) {
        o.g(r4, "syncId");
        Object r3 = r0().runInTransaction(new a(this, r4));     // Catch: Exception -> L5
        o.b(r3, "mDbInst.runInTransaction…      true\n            })");     // Catch: Exception -> L5
        return ((Boolean) r3).booleanValue();
    L5:
        e = move-exception;
        d.b.u.x.b.b(Log.getStackTraceString(e));
        k.c().ensureNotReachHere(e, "error when delete " + r4);
        return false;
    }

    @Override // com.bytedance.sync.v2.f.b
    public boolean Y(List<? extends com.bytedance.sync.v2.presistence.d.f> r3, com.bytedance.sync.v2.presistence.d.c r4, List<? extends com.bytedance.sync.v2.presistence.d.f> r5) {
        o.g(r3, "undistributedUploads");
        o.g(r4, "syncCursor");
        o.g(r5, "pendingDeleteList");
        Object r2 = r0().runInTransaction(new f(this, r3, r5, r4));     // Catch: Exception -> L5
        o.b(r2, "mDbInst.runInTransaction…ble result\n            })");     // Catch: Exception -> L5
        return ((Boolean) r2).booleanValue();
    L5:
        e = move-exception;
        k.c().ensureNotReachHere(e, "execute sql failed when updateUploadCursor");
        d.b.u.x.b.b(Log.getStackTraceString(e));
        return false;
    }

    @Override // com.bytedance.sync.v2.f.b
    public long Z(List<? extends com.bytedance.sync.v2.presistence.d.f> r2) {
        o.g(r2, "items");
        r0().d().b(r2);
        return 0;
    }

    @Override // com.bytedance.sync.v2.f.b
    public void a0(ArrayList<com.bytedance.sync.v2.presistence.d.d> r2) {
        o.g(r2, "historyLogs");
        r0().b().e(r2);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.b.u.x.b.b(Log.getStackTraceString(th));
        d.b.u.r.f(th, "insertHistorySyncLog failed, error: " + Log.getStackTraceString(th));
    }

    @Override // com.bytedance.sync.v2.f.b
    public void d(com.bytedance.sync.v2.presistence.d.b r2) {
        o.g(r2, "it");
        r0().c().d(r2);
    }

    @Override // com.bytedance.sync.v2.f.b
    public List<com.bytedance.sync.v2.presistence.d.b> f(int r1, int r2) {
        return r0().c().f(r1, r2);
    }

    @Override // com.bytedance.sync.v2.f.b
    public List<com.bytedance.sync.v2.presistence.d.f> g(g r2, String r3, String r4, int r5) {
        o.g(r2, "bucket");
        o.g(r3, "did");
        o.g(r4, "uid");
        return r0().d().g(r2, r3, r4, r5);
    }

    @Override // com.bytedance.sync.v2.f.b
    public List<com.bytedance.sync.v2.presistence.d.f> h(g r2, String r3, int r4) {
        o.g(r2, "bucket");
        o.g(r3, "did");
        return r0().d().h(r2, r3, r4);
    }

    @Override // com.bytedance.sync.v2.f.b
    public void i(long r1, long r3) {
        r0().d().i(r1, r3);
    }

    @Override // com.bytedance.sync.v2.f.b
    public boolean i0(List<? extends com.bytedance.sync.v2.presistence.d.e> r3) {
        o.g(r3, "obj");
        if (r0().c().i(r3) > 0) goto L12;
        return false;
    L12:
        return true;
    L6:
        e = move-exception;
        k.c().ensureNotReachHere(e, "execute sql failed when deleteSyncLog");
        return false;
    }

    @Override // com.bytedance.sync.v2.f.b
    public com.bytedance.sync.v2.presistence.d.b k(String r2, long r3) {
        o.g(r2, "syncId");
        return r0().c().k(r2, r3);
    }

    @Override // com.bytedance.sync.v2.f.b
    public void l() {
        r0().d().l();
    }

    @Override // com.bytedance.sync.v2.f.b
    public void l0(List<com.bytedance.sync.v2.presistence.d.c> r3, List<String> r4, List<? extends com.bytedance.sync.v2.presistence.d.a> r5) {
        o.g(r3, "syncCursors");
        o.g(r4, "pendingDelete");
        o.g(r5, "businesses");
        r0().runInTransaction(new e(this, r5, r3, r4));
    }

    @Override // com.bytedance.sync.v2.f.b
    public List<com.bytedance.sync.v2.presistence.d.f> n(String r2, int r3) {
        o.g(r2, "syncId");
        return r0().d().n(r2, r3);
    }

    @Override // com.bytedance.sync.v2.f.b
    public long n0(com.bytedance.sync.v2.presistence.d.f r2) {
        o.g(r2, "item");
        return r0().d().d(r2);
    }

    public List<com.bytedance.sync.v2.presistence.d.d> s0(p r11, long r12, String r14, int r15) {
        o.g(r11, "topicType");
        com.ss.android.ug.bus.a r0 = com.ss.android.ug.bus.b.a(d.b.u.w.b.class);     // Catch: Throwable -> L16
        o.b(r0, "UgBusFramework.getServic…ceInfoGetter::class.java)");     // Catch: Throwable -> L16
        d.b.u.c0.a.d r1 = ((d.b.u.w.b) r0).e();     // Catch: Throwable -> L16
        int r2 = com.bytedance.sync.v2.presistence.a.f6192a[r11.ordinal()];     // Catch: Throwable -> L16
        if (r2 != 1) goto L7;
        com.bytedance.sync.v2.presistence.c.c r3 = r0().b();     // Catch: Throwable -> L16
        String r4 = r1.f15019a;     // Catch: Throwable -> L16
        o.b(r4, "deviceInfo.did");     // Catch: Throwable -> L16
        String r5 = r1.f15020b;     // Catch: Throwable -> L16
        o.b(r5, "deviceInfo.uid");     // Catch: Throwable -> L16
        return r3.a(r4, r5, r12, r11, r15);
    L7:
        if (r2 != 2) goto L9;
        String r9 = r12 + ':' + r14;     // Catch: Throwable -> L16
        com.bytedance.sync.v2.presistence.c.c r6 = r0().b();     // Catch: Throwable -> L16
        String r7 = r1.f15019a;     // Catch: Throwable -> L16
        o.b(r7, "deviceInfo.did");     // Catch: Throwable -> L16
        String r8 = r1.f15020b;     // Catch: Throwable -> L16
        o.b(r8, "deviceInfo.uid");     // Catch: Throwable -> L16
        return r6.c(r7, r8, r12, r11, r9, r15);
    L9:
        if (r2 != 3) goto L11;
        com.bytedance.sync.v2.presistence.c.c r10 = r0().b();     // Catch: Throwable -> L16
        String r13 = r1.f15019a;     // Catch: Throwable -> L16
        o.b(r13, "deviceInfo.did");     // Catch: Throwable -> L16
        String r16 = r1.f15020b;     // Catch: Throwable -> L16
        o.b(r16, "deviceInfo.uid");     // Catch: Throwable -> L16
        return r10.d(r13, r16, r12, r11, r15);
    L11:
        return r.g();
    L16:
        th = move-exception;
        d.b.u.x.b.b(Log.getStackTraceString(th));
        return r.g();
    }

    @Override // com.bytedance.sync.v2.f.b
    public List<com.bytedance.sync.v2.presistence.d.e> u(long r7, int r9, int r10) {
        return r0().c().h(r7, r9, com.bytedance.sync.v2.j.h.f6096g, r10);
    L4:
        th = move-exception;
        d.b.u.x.b.b(Log.getStackTraceString(th));
        k.c().ensureNotReachHere(th, th.getMessage());
        List<com.bytedance.sync.v2.presistence.d.e> r6 = Collections.emptyList();
        o.b(r6, "Collections.emptyList()");
        return r6;
    }

    @Override // com.bytedance.sync.v2.f.b
    public List<com.bytedance.sync.v2.presistence.d.c> v(d.b.u.c0.a.d r6) {
        o.g(r6, "deviceInfo");
        com.bytedance.sync.v2.presistence.c.a r5 = r0().a();     // Catch: Throwable -> L5
        String r0 = r6.f15019a;     // Catch: Throwable -> L5
        o.b(r0, "deviceInfo.did");     // Catch: Throwable -> L5
        List<com.bytedance.sync.v2.presistence.d.c> r7 = r5.f(r0);     // Catch: Throwable -> L5
    L7:
        ArrayList r1 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L19;
        Object r2 = r8.next();
        com.bytedance.sync.v2.presistence.d.c r3 = (com.bytedance.sync.v2.presistence.d.c) r2;
        if (r3.f6233e != g.f6091g) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L9;
        r1.add(r2);
        goto L9
    L13:
        if (d.b.u.d0.b.b(r3.f6231c, r6.f15020b) == true) goto L16;
        r4 = false;
        goto L17
    L19:
        return r1;
    L5:
        th = move-exception;
        d.b.u.x.b.b(Log.getStackTraceString(th));
        d.b.u.r.f(th, "exception when queryLocalSyncCursorInfo");
        r7 = new ArrayList();
        goto L7
    }

    @Override // com.bytedance.sync.v2.f.b
    public List<com.bytedance.sync.v2.presistence.d.e> w(Set<Long> r2, n r3, int r4, int r5) {
        o.g(r2, "syncIds");
        o.g(r3, "packetStatus");
        return r0().c().c(r2, r3, r4, r5);
    }

    @Override // com.bytedance.sync.v2.f.b
    public com.bytedance.sync.v2.presistence.d.c x(long r1) {
        return r0().a().d(r1);
    }

    @Override // com.bytedance.sync.v2.f.b
    public void z(ArrayList<com.bytedance.sync.v2.presistence.d.e> r3, com.bytedance.sync.v2.presistence.d.c r4) {
        o.g(r3, "logs");
        o.g(r4, "newCursor");
        r0().runInTransaction(new b(this, r3, r4));
    }
}

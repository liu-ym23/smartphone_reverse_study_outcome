package com.bytedance.sync.v2.i.h;

import android.content.Context;
import com.bytedance.sync.v2.j.g;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final /* synthetic */ l[] f6014e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f6015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f6016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.u.b0.a f6017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f6018d;

    /* JADX INFO: renamed from: com.bytedance.sync.v2.i.h.a$a, reason: collision with other inner class name */
    public static final class C0190a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f6019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.sync.v2.presistence.d.c f6020b;

        public C0190a(boolean r1, com.bytedance.sync.v2.presistence.d.c r2) {
            this.f6019a = r1;
            this.f6020b = r2;
        }

        public final boolean a() {
            return this.f6019a;
        }

        public final com.bytedance.sync.v2.presistence.d.c b() {
            return this.f6020b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L5;
        L15:
            return true;
        L5:
            if ((r5 instanceof C0190a) == false) goto L14;
            C0190a r6 = (C0190a) r5;
            if (this.f6019a != r6.f6019a) goto L9;
            boolean r1 = true;
        L10:
            if (r1 == false) goto L14;
            if (o.a(this.f6020b, r6.f6020b) == false) goto L14;
        L9:
            r1 = false;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean r0 = this.f6019a;
            ?? r1 = r0;
            if (r0 == false) goto L5;
            r1 = 1;
        L5:
            int r2 = r1 * 31;
            com.bytedance.sync.v2.presistence.d.c r3 = this.f6020b;
            if (r3 == null) goto L8;
            int r4 = r3.hashCode();
        L10:
            return r2 + r4;
        L8:
            r4 = 0;
            goto L10
        }

        public String toString() {
            return "PatchResult(success=" + this.f6019a + ", syncCursor=" + this.f6020b + ")";
        }
    }

    static final class b extends q implements kotlin.n0.c.a<com.bytedance.sync.v2.f.b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f6021f = null;

        static {
            f6021f = new b();
        }

        b() {
            super(0);
        }

        public final com.bytedance.sync.v2.f.b a() {
            return (com.bytedance.sync.v2.f.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ com.bytedance.sync.v2.f.b invoke() {
            return a();
        }
    }

    static final class c extends q implements kotlin.n0.c.a<d.b.u.w.c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f6022f = null;

        static {
            f6022f = new c();
        }

        c() {
            super(0);
        }

        public final d.b.u.w.c a() {
            return (d.b.u.w.c) com.ss.android.ug.bus.b.a(d.b.u.w.c.class);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ d.b.u.w.c invoke() {
            return a();
        }
    }

    static {
        f6014e = new l[]{e0.g(new y(e0.b(a.class), "dbService", "getDbService()Lcom/bytedance/sync/v2/intf/IDBServiceV2;")), e0.g(new y(e0.b(a.class), "fileDataCache", "getFileDataCache()Lcom/bytedance/sync/interfaze/IFileDataCacheService;"))};
    }

    public a(Context r2, d.b.u.e r3) {
        o.g(r2, "context");
        o.g(r3, "configuration");
        this.f6018d = r2;
        this.f6015a = i.b(b.f6021f);
        this.f6016b = i.b(c.f6022f);
        d.b.u.b0.b r4 = d.b.u.b0.b.g(r2);
        o.b(r4, "SyncSettings.inst(context)");
        d.b.u.b0.a r5 = r4.f();
        o.b(r5, "SyncSettings.inst(context).settingsV2");
        this.f6017c = r5;
    }

    protected final boolean c(long r3, com.bytedance.sync.v2.j.b r5, com.bytedance.sync.v2.presistence.d.c r6) {
        o.g(r5, "header");
        o.g(r6, "syncCursor");
        String r2 = r6.f6229a;
        o.b(r2, "syncCursor.syncId");
        if (r3 == Long.parseLong(r2)) goto L8;
        StringBuilder r4 = new StringBuilder();
        r4.append("syncId not match. server = ");
        r4.append(r3);
        r4.append(", local db = ");
        String r7 = r6.f6229a;
    L5:
        r4.append(r7);
        d.b.u.x.b.b(r4.toString());
        return false;
    L8:
        if ((!o.a(r5.f6037h, r6.f6230b)) == false) goto L11;
        r4 = new StringBuilder();
        r4.append("did not match. server = ");
        r4.append(r5.f6037h);
        r4.append(", local db = ");
        r7 = r6.f6230b;
        goto L5
    L11:
        if (r6.f6233e == g.f6092h) goto L13;
    L15:
        return true;
    L13:
        if ((!o.a(r5.f6036g, r6.f6231c)) == false) goto L15;
        r4 = new StringBuilder();
        r4.append("uid not match. server = ");
        r4.append(r5.f6036g);
        r4.append(", local db = ");
        r7 = r6.f6231c;
        goto L5
    }

    protected final com.bytedance.sync.v2.f.b d() {
        h r2 = this.f6015a;
        l r0 = f6014e[0];
        return (com.bytedance.sync.v2.f.b) r2.getValue();
    }

    protected final d.b.u.w.c e() {
        h r2 = this.f6016b;
        l r0 = f6014e[1];
        return (d.b.u.w.c) r2.getValue();
    }

    protected final d.b.u.b0.a f() {
        return this.f6017c;
    }
}

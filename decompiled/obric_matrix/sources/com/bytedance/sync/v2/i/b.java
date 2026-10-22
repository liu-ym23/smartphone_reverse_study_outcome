package com.bytedance.sync.v2.i;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.j;
import com.bytedance.sync.v2.j.n;
import d.b.u.k;
import d.b.u.r;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.b0;
import kotlin.h;
import kotlin.i;
import kotlin.m;
import kotlin.n0.d.e0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements com.bytedance.sync.v2.f.d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final /* synthetic */ l[] f5980k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h f5981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final h f5982g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.bytedance.sync.v2.f.b f5983h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Context f5984i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.bytedance.sync.v2.a f5985j;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f5986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f5987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f5988c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f5989d;

        public a(boolean r1, String r2, String r3, long r4) {
            this.f5986a = r1;
            this.f5987b = r2;
            this.f5988c = r3;
            this.f5989d = r4;
        }

        public /* synthetic */ a(boolean r7, String r8, String r9, long r10, int r12, g r13) {
            if ((r12 & 2) == 0) goto L5;
            r8 = null;
        L5:
            String r2 = r8;
            if ((r12 & 4) == 0) goto L8;
            r9 = "";
        L8:
            String r3 = r9;
            if ((r12 & 8) == 0) goto L11;
            r10 = 0;
        L11:
            this(r7, r2, r3, r10);
        }

        public final String a() {
            return this.f5987b;
        }

        public final String b() {
            return this.f5988c;
        }

        public final boolean c() {
            return this.f5986a;
        }

        public final long d() {
            return this.f5989d;
        }

        public final void e(String r1) {
            this.f5988c = r1;
        }

        public final void f(boolean r1) {
            this.f5986a = r1;
        }

        public final void g(long r1) {
            this.f5989d = r1;
        }

        public String toString() {
            return "PatchResult(success=" + this.f5986a + ", data=~~~, errMsg=" + this.f5988c + ", timeConsumed=" + this.f5989d + ')';
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sync.v2.i.b$b, reason: collision with other inner class name */
    private static final class C0189b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f5990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f5992c;

        public C0189b() {
            this(false, 0, null, 7, null);
        }

        public C0189b(boolean r2, int r3, String r4) {
            o.g(r4, "errMsg");
            this.f5990a = r2;
            this.f5991b = r3;
            this.f5992c = r4;
        }

        public /* synthetic */ C0189b(boolean r2, int r3, String r4, int r5, g r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = "";
        L11:
            this(r2, r3, r4);
        }

        public final int a() {
            return this.f5991b;
        }

        public final boolean b() {
            return this.f5990a;
        }

        public final void c(int r1) {
            this.f5991b = r1;
        }

        public final void d(String r2) {
            o.g(r2, "<set-?>");
            this.f5992c = r2;
        }

        public final void e(boolean r1) {
            this.f5990a = r1;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L5;
        L20:
            return true;
        L5:
            if ((r5 instanceof C0189b) == false) goto L19;
            C0189b r6 = (C0189b) r5;
            if (this.f5990a != r6.f5990a) goto L9;
            boolean r1 = true;
        L10:
            if (r1 == false) goto L19;
            if (this.f5991b != r6.f5991b) goto L14;
            boolean r2 = true;
        L15:
            if (r2 == false) goto L19;
            if (o.a(this.f5992c, r6.f5992c) == false) goto L19;
        L14:
            r2 = false;
            goto L15
        L9:
            r1 = false;
        L19:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean r0 = this.f5990a;
            ?? r1 = r0;
            if (r0 == false) goto L5;
            r1 = 1;
        L5:
            int r2 = ((r1 * 31) + this.f5991b) * 31;
            String r3 = this.f5992c;
            if (r3 == null) goto L8;
            int r4 = r3.hashCode();
        L10:
            return r2 + r4;
        L8:
            r4 = 0;
            goto L10
        }

        public String toString() {
            return "SyncIdPatchResult(success=" + this.f5990a + ", deleteCnt=" + this.f5991b + ", errMsg=" + this.f5992c + ")";
        }
    }

    static final class c extends q implements kotlin.n0.c.a<d.b.u.w.c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f5993f = null;

        static {
            f5993f = new c();
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

    static final class d extends q implements kotlin.n0.c.a<Handler> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f5994f = null;

        static {
            f5994f = new d();
        }

        d() {
            super(0);
        }

        public final Handler a() {
            return new Handler(((d.b.u.w.e) com.ss.android.ug.bus.b.a(d.b.u.w.e.class)).get());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Handler invoke() {
            return a();
        }
    }

    static final class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f5995f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Set f5996g;

        e(b r1, Set r2) {
            this.f5995f = r1;
            this.f5996g = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.F(this.f5995f, this.f5996g);
        }
    }

    static {
        f5980k = new l[]{e0.g(new y(e0.b(b.class), "mHandler", "getMHandler()Landroid/os/Handler;")), e0.g(new y(e0.b(b.class), "mFileCache", "getMFileCache()Lcom/bytedance/sync/interfaze/IFileDataCacheService;"))};
    }

    public b(Context r2, d.b.u.e r3, com.bytedance.sync.v2.a r4) {
        o.g(r2, "context");
        o.g(r3, "configuration");
        o.g(r4, "notifier");
        this.f5984i = r2;
        this.f5985j = r4;
        this.f5981f = i.b(d.f5994f);
        this.f5982g = i.b(c.f5993f);
    }

    public static final /* synthetic */ void F(b r0, Set r1) {
        r0.s0(r1);
    }

    private final a M(com.bytedance.sync.v2.presistence.d.b r14, com.bytedance.sync.v2.presistence.d.e r15) {
        if (r14 != null) goto L4;
    L7:
        d.b.u.v.a r0 = new d.b.u.v.a();
        d.b.u.y.a r1 = r15.f6256i;     // Catch: Throwable -> L77
        if (r1 != null) goto L12;
        byte[] r16 = r15.f6252e;     // Catch: Throwable -> L77
        o.b(r16, "log.data");     // Catch: Throwable -> L77
        String r2 = new String(r16, kotlin.u0.d.f21429a);     // Catch: Throwable -> L77
    L19:
        if (r2 == null) goto L76;
        if (r14 == null) goto L23;
        byte[] r17 = r14.f6222f;     // Catch: Throwable -> L77
    L24:
        String r3 = "";
        if (r17 == null) goto L40;
        d.b.u.y.a r18 = r14.f6225i;     // Catch: Throwable -> L77
        if (r18 != null) goto L30;
        byte[] r13 = r14.f6222f;     // Catch: Throwable -> L77
        o.b(r13, "snapshots.data");     // Catch: Throwable -> L77
        String r19 = new String(r13, kotlin.u0.d.f21429a);     // Catch: Throwable -> L77
    L37:
        if (r19 == null) goto L39;
    L41:
        LinkedList<d.b.u.v.a.e> r110 = (LinkedList) r0.E(r2);     // Catch: Throwable -> L77
        if (r110 == null) goto L74;
        Object[] r111 = r0.C(r110, r19);     // Catch: Throwable -> L77
        if (r111 == null) goto L72;
        if (r111.length != 2) goto L72;
        if (r111[0] == null) goto L72;
        if (r111[1] == null) goto L72;
        Object r112 = r111[0];     // Catch: Throwable -> L77
        if (r112 == null) goto L70;
        String r7 = (String) r112;     // Catch: Throwable -> L77
        Object r113 = r111[1];     // Catch: Throwable -> L77
        if (r113 == null) goto L68;
        boolean[] r114 = (boolean[]) r113;     // Catch: Throwable -> L77
        int r115 = r114.length;     // Catch: Throwable -> L77
        int r4 = 0;
        boolean r6 = true;
    L57:
        if (r4 >= r115) goto L64;
        boolean r5 = r114[r4];     // Catch: Throwable -> L77
        if (r6 == false) goto L62;
        if (r5 == false) goto L62;
        r6 = true;
    L63:
        r4 = r4 + 1;     // Catch: Throwable -> L77
    L62:
        r6 = false;
        goto L63
    L64:
        if (r6 == true) goto L84;
        r3 = "patch_apply failed with dmp";
    L84:
        return new a(r6, r7, r3, 0, 8, null);
    L68:
        throw new b0("null cannot be cast to non-null type kotlin.BooleanArray");     // Catch: Throwable -> L77
    L70:
        throw new b0("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L77
    L72:
        return new a(false, null, "apply patch error", 0, 10, null);
    L74:
        return new a(false, null, "patches is empty", 0, 10, null);
    L39:
        return new a(false, null, "read snapshot file from cache failed", 0, 10, null);
    L30:
        int r116 = com.bytedance.sync.v2.i.c.f5998b[r18.ordinal()];     // Catch: Throwable -> L77
        if (r116 == 1) goto L36;
        if (r116 != 2) goto L35;
        byte[] r117 = r14.f6222f;     // Catch: Throwable -> L77
        o.b(r117, "snapshots.data");     // Catch: Throwable -> L77
        r19 = new String(r117, kotlin.u0.d.f21429a);     // Catch: Throwable -> L77
        goto L37
    L35:
        throw new m();     // Catch: Throwable -> L77
    L36:
        d.b.u.w.c r118 = o0();     // Catch: Throwable -> L77
        String r119 = r14.f6217a;     // Catch: Throwable -> L77
        o.b(r119, "snapshots.syncId");     // Catch: Throwable -> L77
        long r8 = Long.parseLong(r119);     // Catch: Throwable -> L77
        byte[] r120 = r14.f6222f;     // Catch: Throwable -> L77
        o.b(r120, "snapshots.data");     // Catch: Throwable -> L77
        r19 = r118.A(r8, new String(r120, kotlin.u0.d.f21429a));     // Catch: Throwable -> L77
        goto L37
    L40:
        r19 = "";
        goto L41
    L23:
        r17 = null;
        goto L24
    L76:
        return new a(false, null, "read diff file from cache failed", 0, 10, null);
    L12:
        int r9 = com.bytedance.sync.v2.i.c.f5997a[r1.ordinal()];     // Catch: Throwable -> L77
        if (r9 == 1) goto L18;
        if (r9 != 2) goto L17;
        d.b.u.w.c r10 = o0();     // Catch: Throwable -> L77
        String r11 = r15.f6248a;     // Catch: Throwable -> L77
        o.b(r11, "log.syncId");     // Catch: Throwable -> L77
        long r12 = Long.parseLong(r11);     // Catch: Throwable -> L77
        byte[] r121 = r15.f6252e;     // Catch: Throwable -> L77
        o.b(r121, "log.data");     // Catch: Throwable -> L77
        r2 = r10.A(r12, new String(r121, kotlin.u0.d.f21429a));     // Catch: Throwable -> L77
        goto L19
    L17:
        throw new m();     // Catch: Throwable -> L77
    L18:
        byte[] r122 = r15.f6252e;     // Catch: Throwable -> L77
        o.b(r122, "log.data");     // Catch: Throwable -> L77
        r2 = new String(r122, kotlin.u0.d.f21429a);     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        k.c().ensureNotReachHere(th, "patch error");
        th.printStackTrace();
        return new a(false, null, Log.getStackTraceString(th), 0, 10, null);
    L4:
        if (r14.f6221e < r15.f6251d) goto L7;
        return new a(false, null, "local snapshot's cursor " + r14.f6221e + " is equals or bigger than payload cursor " + r15.f6251d, 0, 10, null);
    }

    private final d.b.u.w.c o0() {
        h r2 = this.f5982g;
        l r0 = f5980k[1];
        return (d.b.u.w.c) r2.getValue();
    }

    private final Handler p0() {
        h r2 = this.f5981f;
        l r0 = f5980k[0];
        return (Handler) r2.getValue();
    }

    private final void q0(List<? extends com.bytedance.sync.v2.presistence.d.e> r1) {
        this.f5985j.m(r1);
    }

    private final a r0(String r5, com.bytedance.sync.v2.presistence.d.e r6, com.bytedance.sync.v2.presistence.d.b r7) {
        String r8 = r6.f6248a;
        o.b(r8, "log.syncId");
        if (Long.parseLong(r8) > 0) goto L5;
        return null;
    L5:
        if (r6.f6254g <= 0) goto L16;
        long r0 = SystemClock.currentThreadTimeMillis();
        a r4 = M(r7, r6);
        r4.g(SystemClock.currentThreadTimeMillis() - r0);
        if (r4.c() == false) goto L12;
        String r9 = j.a(r4.a(), "MD5");
        if (TextUtils.equals(r6.f6253f, r9) == true) goto L12;
        r4.e("different md5. local is {" + r9 + "},server is {" + r6.f6253f + "} when patch {" + r6.f6251d + "} and syncId = " + r6.f6248a);
        r4.f(false);
    L12:
        JSONObject r10 = new JSONObject();
        r10.put("success", r4.c());
        r10.put("reason", r4.b());
        JSONObject r11 = new JSONObject();
        r11.put("time_consuming", r4.d());
        r.c("sync_sdk_patch", r10, r11, com.bytedance.sync.v2.l.b.d(r6));
        return r4;
    L16:
        return null;
    }

    private final void s0(Set<Long> r18) {
        com.ss.android.ug.bus.a r2 = com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.b.class);
        o.b(r2, "UgBusFramework.getServic…IDBServiceV2::class.java)");
        this.f5983h = (com.bytedance.sync.v2.f.b) r2;
        LinkedHashSet r3 = new LinkedHashSet();
        boolean r5 = true;
        int r6 = 0;
    L3:
        if (r5 == false) goto L48;
        com.bytedance.sync.v2.f.b r7 = this.f5983h;     // Catch: Exception -> L45
        if (r7 == null) goto L42;
        List<com.bytedance.sync.v2.presistence.d.e> r8 = r7.w(r18, n.f6123g, 100, r6);     // Catch: Exception -> L45
        if (r8.isEmpty() == true) goto L48;
        if (r8.size() < 100) goto L13;
        boolean r9 = true;
    L14:
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<T> r11 = r8.iterator();
    L16:
        if (r11.hasNext() == false) goto L21;
        Object r12 = r11.next();
        String r13 = ((com.bytedance.sync.v2.presistence.d.e) r12).f6248a;
        Object r14 = r10.get(r13);
        if (r14 != null) goto L20;
        r14 = new ArrayList();
        r10.put(r13, r14);
    L20:
        ((List) r14).add(r12);
        goto L16
    L21:
        Iterator r15 = r10.entrySet().iterator();
    L23:
        if (r15.hasNext() == false) goto L41;
        Map.Entry r16 = (Map.Entry) r15.next();
        Iterable r17 = (Iterable) r16.getValue();
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator r110 = r17.iterator();
    L26:
        if (r110.hasNext() == false) goto L31;
        Object r111 = r110.next();
        Long r112 = Long.valueOf(((com.bytedance.sync.v2.presistence.d.e) r111).f6254g);
        Object r113 = r19.get(r112);
        if (r113 != null) goto L30;
        r113 = new ArrayList();
        r19.put(r112, r113);
    L30:
        ((List) r113).add(r111);
        goto L26
    L31:
        Iterator r114 = r19.entrySet().iterator();
    L33:
        if (r114.hasNext() == false) goto L23;
        Map.Entry r115 = (Map.Entry) r114.next();
        Object r116 = r16.getKey();
        o.b(r116, "syncIdToSyncLog.key");
        C0189b r4 = t0((String) r116, ((Number) r115.getKey()).longValue(), (List) r115.getValue());
        if (r4.b() == false) goto L36;
        d.b.u.x.b.a("patch success " + ((String) r16.getKey()));
        r6 = r6 + (((List) r115.getValue()).size() - r4.a());
        goto L33
    L36:
        d.b.u.x.b.b("patch error, clear local data " + ((String) r16.getKey()));
        com.bytedance.sync.v2.f.c r20 = (com.bytedance.sync.v2.f.c) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.c.class);
        Object r117 = r16.getKey();
        o.b(r117, "syncIdToSyncLog.key");
        if (r20.C((String) r117, true) == true) goto L38;
        d.b.u.x.b.b("delete local data error, syncId = " + ((String) r16.getKey()));
        goto L23
    L38:
        Object r21 = r16.getKey();
        o.b(r21, "syncIdToSyncLog.key");
        r3.add(r21);
        goto L23
    L41:
        r5 = r9;
        goto L3
    L13:
        r9 = false;
        goto L14
    L42:
        o.v("dbService");     // Catch: Exception -> L45
        throw null;
    L45:
        e = move-exception;
        k.c().ensureNotReachHere(e, "execute sql failed when querySyncLogWithSyncId.");
        e.printStackTrace();
    L48:
        if (r3.isEmpty() == true) goto L70;
        ((com.bytedance.sync.v2.f.c) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.c.class)).B(r3);
        return;
    }

    private final C0189b t0(String r31, long r32, List<? extends com.bytedance.sync.v2.presistence.d.e> r34) {
        String r2 = r31;
        C0189b r12 = new C0189b(false, 0, null, 7, null);
        if (r34.get(0).f6255h != com.bytedance.sync.v2.j.h.f6096g) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        q0(r34);
        r12.e(true);
        r12.c(0);
    L81:
        return r12;
    L8:
        ArrayList r7 = new ArrayList();
        com.bytedance.sync.v2.f.b r1 = this.f5983h;     // Catch: Exception -> L85
        if (r1 != null) goto L13;
        o.v("dbService");     // Catch: Exception -> L85
        throw null;
    L13:
        com.bytedance.sync.v2.presistence.d.b r11 = r1.k(r2, r32);     // Catch: Exception -> L85
        Iterator<? extends com.bytedance.sync.v2.presistence.d.e> r13 = r34.iterator();
        com.bytedance.sync.v2.presistence.d.b r3 = null;
    L16:
        if (r13.hasNext() == false) goto L81;
        com.bytedance.sync.v2.presistence.d.e r14 = r13.next();
        if (r3 == null) goto L20;
        com.bytedance.sync.v2.presistence.d.b r15 = r3;
    L21:
        a r16 = r0(r2, r14, r15);
        if (r16 == null) goto L81;
        if (r16.c() == false) goto L81;
        r12.c(r12.a() + 1);
        r7.add(r14);
        if (r3 == null) goto L97;
        r7 = r7;
    L33:
        com.bytedance.sync.v2.presistence.d.b r6 = r3;
        String r4 = r16.a();     // Catch: UnsupportedEncodingException -> L79
        if (r4 == null) goto L41;
        Charset r8 = kotlin.u0.d.f21429a;     // Catch: UnsupportedEncodingException -> L79
        if (r4 == null) goto L40;
        byte[] r5 = r4.getBytes(r8);     // Catch: UnsupportedEncodingException -> L79
        o.b(r5, "(this as java.lang.String).getBytes(charset)");     // Catch: UnsupportedEncodingException -> L79
    L42:
        r6.f6222f = r5;     // Catch: UnsupportedEncodingException -> L79
        d.b.u.y.a r9 = d.b.u.y.a.f15124g;     // Catch: UnsupportedEncodingException -> L79
        r6.f6225i = r9;     // Catch: UnsupportedEncodingException -> L79
        r6.f6226j = r14.f6257j;     // Catch: UnsupportedEncodingException -> L79
        r6.f6227k = r14.f6258k;     // Catch: UnsupportedEncodingException -> L79
        r6.f6221e = r14.f6251d;     // Catch: UnsupportedEncodingException -> L79
        r6.m++;     // Catch: UnsupportedEncodingException -> L79
        d.b.u.b0.b r10 = d.b.u.b0.b.g(this.f5984i);     // Catch: UnsupportedEncodingException -> L75
        o.b(r10, "SyncSettings.inst(context)");     // Catch: UnsupportedEncodingException -> L75
        d.b.u.b0.a r17 = r10.f();     // Catch: UnsupportedEncodingException -> L75
        int r18 = r6.f6222f.length;     // Catch: UnsupportedEncodingException -> L75
        o.b(r17, "settings");     // Catch: UnsupportedEncodingException -> L75
        if (r18 <= r17.f()) goto L50;
        String r19 = o0().e0("snapshot", Long.parseLong(r31), r6.f6221e, r6.f6222f, ((com.bytedance.sync.v2.presistence.d.e) kotlin.i0.r.b0(r34)).f6253f);     // Catch: UnsupportedEncodingException -> L75
        o.b(r19, "mFileCache.putData(\n    …                        )");     // Catch: UnsupportedEncodingException -> L75
        Charset r20 = kotlin.u0.d.f21429a;     // Catch: UnsupportedEncodingException -> L75
        if (r19 == null) goto L49;
        byte[] r21 = r19.getBytes(r20);     // Catch: UnsupportedEncodingException -> L75
        o.b(r21, "(this as java.lang.String).getBytes(charset)");     // Catch: UnsupportedEncodingException -> L75
        r6.f6222f = r21;     // Catch: UnsupportedEncodingException -> L75
        r6.f6225i = d.b.u.y.a.f15125h;     // Catch: UnsupportedEncodingException -> L75
        boolean r110 = true;
    L95:
        com.bytedance.sync.v2.f.b r22 = this.f5983h;     // Catch: Exception -> L70
        ArrayList r23 = r7;
        if (r22 != null) goto L93;
        boolean r24 = true;
        o.v("dbService");     // Catch: Exception -> L68
        throw null;
    L68:
        e = e;
    L73:
        e.printStackTrace();     // Catch: UnsupportedEncodingException -> L88
        k.c().ensureNotReachHere(e, "execute sql failed when updateSnapshotAndDeleteSyncLog.");     // Catch: UnsupportedEncodingException -> L88
        r12.e(false);     // Catch: UnsupportedEncodingException -> L88
        r12.c(0);     // Catch: UnsupportedEncodingException -> L88
        r12.d("execute sql failed when updateSnapshotAndDeleteSyncLog.");     // Catch: UnsupportedEncodingException -> L88
    L77:
        d.b.u.x.b.b("patch failed, reason: UnsupportedEncodingException when save to file");
        r12.d("UnsupportedEncodingException when save to file");
        r12.e(false);
    L78:
        r7 = r23;
        r3 = r6;
        r2 = r31;
        goto L16
    L74:
        return r12;
    L93:
        if (r22.T(r6, r23) == true) goto L99;
        r24 = true;
        r12.e(false);     // Catch: UnsupportedEncodingException -> L88
        r12.d("patch failed, reason: updateSnapshotAndDeleteSyncLog failed");     // Catch: UnsupportedEncodingException -> L88
        d.b.u.x.b.b("patch failed, reason: updateSnapshotAndDeleteSyncLog failed");     // Catch: UnsupportedEncodingException -> L88
        goto L78
    L99:
        u0(r23, r11, r6);     // Catch: UnsupportedEncodingException -> L89
        com.bytedance.sync.v2.a.p(this.f5985j, r14, 0, 2, null);     // Catch: UnsupportedEncodingException -> L89
        r24 = true;
        r12.e(true);     // Catch: UnsupportedEncodingException -> L88
        JSONObject r111 = new JSONObject();     // Catch: UnsupportedEncodingException -> L88
        r111.put("save_file", r110);     // Catch: UnsupportedEncodingException -> L88
        r.d("sync_sdk_snapshot_save_file", r111, null, com.bytedance.sync.v2.l.b.c(r6), 4, null);     // Catch: UnsupportedEncodingException -> L88
    L76:
        r24 = true;
    L62:
        e = e;
    L72:
        r24 = true;
    L70:
        e = e;
        r23 = r7;
        goto L72
    L49:
        throw new b0("null cannot be cast to non-null type java.lang.String");     // Catch: UnsupportedEncodingException -> L75
    L50:
        r6.f6225i = r9;     // Catch: UnsupportedEncodingException -> L75
        r110 = false;
    L75:
        r23 = r7;
        goto L76
    L40:
        throw new b0("null cannot be cast to non-null type java.lang.String");     // Catch: UnsupportedEncodingException -> L79
    L79:
        e = move-exception;
        e.printStackTrace();
        r16.f(false);
        r16.e("unsupported encoding when update snapshot");
        goto L81
    L41:
        r5 = null;
        goto L42
    L97:
        r3 = new com.bytedance.sync.v2.presistence.d.b();     // Catch: UnsupportedEncodingException -> L79
        if (r11 == null) goto L30;
        long r25 = r11.f6223g;     // Catch: UnsupportedEncodingException -> L79
    L31:
        r3.f6223g = r25;     // Catch: UnsupportedEncodingException -> L79
        r3.f6218b = r14.f6254g;     // Catch: UnsupportedEncodingException -> L79
        r3.f6220d = r14.f6249b;     // Catch: UnsupportedEncodingException -> L79
        r3.f6219c = r14.f6250c;     // Catch: UnsupportedEncodingException -> L79
        r3.f6217a = r14.f6248a;     // Catch: UnsupportedEncodingException -> L79
        r3.f6224h = r14.f6259l;     // Catch: UnsupportedEncodingException -> L79
        r3.f6228l = r14.f6255h;     // Catch: UnsupportedEncodingException -> L79
        goto L33
    L30:
        r25 = 0;
        goto L31
    L20:
        r15 = r11;
    L85:
        e = move-exception;
        k.c().ensureNotReachHere(e, "execute sql failed when patchWithSyncIdAndBusinessId.");
        r12.e(false);
        r12.c(0);
        return r12;
    L5:
        r0 = false;
        goto L6
    }

    private final void u0(List<com.bytedance.sync.v2.presistence.d.e> r6, com.bytedance.sync.v2.presistence.d.b r7, com.bytedance.sync.v2.presistence.d.b r8) {
        Iterator<T> r0 = r6.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        com.bytedance.sync.v2.presistence.d.e r1 = (com.bytedance.sync.v2.presistence.d.e) r0.next();
        if (r1.f6256i != d.b.u.y.a.f15125h) goto L4;
        d.b.u.w.c r2 = o0();     // Catch: Throwable -> L9
        byte[] r3 = r1.f6252e;     // Catch: Throwable -> L9
        o.b(r3, "it.data");     // Catch: Throwable -> L9
        r2.S(new String(r3, kotlin.u0.d.f21429a));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L4
    L11:
        if (r7 == null) goto L23;
        d.b.u.y.a r4 = r7.f6225i;
        d.b.u.y.a r5 = d.b.u.y.a.f15125h;
        if (r4 != r5) goto L23;
        byte[] r9 = r7.f6222f;     // Catch: Throwable -> L21
        o.b(r9, "originalSnapshot.data");     // Catch: Throwable -> L21
        Charset r10 = kotlin.u0.d.f21429a;     // Catch: Throwable -> L21
        String r11 = new String(r9, r10);     // Catch: Throwable -> L21
        String r12 = null;
        if (r8.f6225i != r5) goto L18;
        byte[] r13 = r8.f6222f;     // Catch: Throwable -> L21
        o.b(r13, "snapshot.data");     // Catch: Throwable -> L21
        r12 = new String(r13, r10);     // Catch: Throwable -> L21
    L18:
        if (TextUtils.equals(r12, r11) == true) goto L23;
        o0().S(r11);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();
    L23:
        r6.clear();
    }

    @Override // com.bytedance.sync.v2.f.d
    public void o(Set<Long> r3) {
        o.g(r3, "syncIds");
        d.b.u.x.b.e("notify patch " + r3);
        p0().post(new e(this, r3));
    }
}

package com.obric.android.alog;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Alog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f8031c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f8032d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f8033e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f8034f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f8035g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f8036h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile List<com.obric.android.alog.b> f8037i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ArrayList<String> f8038j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f8039k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8041b;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f8042g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f8043h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f8044i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ a[] f8045j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f8046f;

        static {
            a r0 = new a("NONE", 0, 0);
            f8042g = r0;
            a r1 = new a("EC_SECP256K1", 1, 1);
            f8043h = r1;
            a r3 = new a("EC_SECP256R1", 2, 2);
            f8044i = r3;
            f8045j = new a[]{r0, r1, r3};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f8046f = r3;
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f8045j.clone();
        }

        int a() {
            return this.f8046f;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f8047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f8048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f8049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f8050d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f8051e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f8052f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f8053g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f8054h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f8055i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f8056j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f8057k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f8058l;
        private int m;
        private int n;
        private int o;
        private int p;
        private int q;
        private int r;
        private String s;

        public b(Context r3) {
            this.f8048b = 0;
            this.f8049c = false;
            this.f8050d = null;
            this.f8051e = null;
            this.f8052f = 2097152;
            this.f8053g = 20971520;
            this.f8054h = 7;
            this.f8055i = null;
            this.f8056j = 65536;
            this.f8057k = 196608;
            this.f8058l = null;
            this.m = Alog.a();
            this.n = Alog.b();
            this.o = Alog.c();
            this.p = Alog.d();
            this.q = Alog.e();
            this.r = Alog.f();
            this.s = "b012e20c9aab1cb5257aca2069cb79a9339b3a2224f771c78d64972137936eaf0b2f7ebd8d46c2607e1d7fe7723d40b147b8ecfa8fe2eaeee05210c75822381a";
            Context r0 = r3.getApplicationContext();
            if (r0 == null) goto L5;
            r3 = r0;
        L5:
            this.f8047a = r3;
        }

        public Alog a() {
            if (this.f8050d != null) goto L5;
            this.f8050d = "default";
        L5:
            ArrayList r1 = Alog.g();
            monitor-enter(r1);
            Iterator r2 = Alog.g().iterator();     // Catch: Throwable -> L37
        L9:
            if (r2.hasNext() == false) goto L14;
            if (((String) r2.next()).equals(this.f8050d) == false) goto L9;
            monitor-exit(r1);     // Catch: Throwable -> L37
            return null;
        L14:
            Alog.g().add(this.f8050d);     // Catch: Throwable -> L37
            monitor-exit(r1);     // Catch: Throwable -> L37
            if (this.f8051e != null) goto L24;
            File r3 = this.f8047a.getExternalFilesDir(null);
            if (r3 == null) goto L21;
            String r4 = r3.getPath() + "/alog";
        L22:
            this.f8051e = r4;
            goto L24
        L21:
            r4 = this.f8047a.getFilesDir() + "/alog";
        L24:
            if (this.f8055i != null) goto L27;
            this.f8055i = this.f8047a.getFilesDir() + "/alog";
        L27:
            if (this.f8058l != null) goto L29;
            this.f8058l = com.obric.android.alog.e.a(this.f8047a);
        L29:
            int r5 = (this.f8056j / 4096) * 4096;
            this.f8056j = r5;
            int r6 = (this.f8057k / 4096) * 4096;
            this.f8057k = r6;
            if (r5 >= 4096) goto L32;
            this.f8056j = 4096;
        L32:
            int r7 = this.f8056j;
            if (r6 >= (r7 * 2)) goto L36;
            this.f8057k = r7 * 2;
        L36:
            return new Alog(this.f8047a, this.f8048b, this.f8049c, this.f8050d, this.f8051e, this.f8052f, this.f8053g, this.f8054h, this.f8055i, this.f8056j, this.f8057k, this.f8058l, this.m, this.n, this.o, this.p, this.q, this.r, this.s);
        L37:
            th = move-exception;
            throw th;
        }

        public b b(a r1) {
            this.r = r1.a();
            return this;
        }

        public b c(String r1) {
            this.f8055i = r1;
            return this;
        }

        public b d(int r1) {
            this.f8056j = r1;
            return this;
        }

        public b e(int r1) {
            this.f8057k = r1;
            return this;
        }

        public b f(c r1) {
            this.p = r1.a();
            return this;
        }

        public b g(String r4) {
            if (TextUtils.isEmpty(r4) == false) goto L5;
        L13:
            return this;
        L5:
            if (r4.contains("-") == false) goto L8;
            r4 = r4.replace("-", "");
        L8:
            if (r4.contains("_") == false) goto L11;
            r4 = r4.replace("_", "");
        L11:
            if (TextUtils.isEmpty(r4) == true) goto L13;
            this.f8050d = r4;
            goto L13
        }

        public b h(int r1) {
            this.f8048b = r1;
            return this;
        }

        public b i(String r1) {
            this.f8051e = r1;
            return this;
        }

        public b j(int r1) {
            this.f8054h = r1;
            return this;
        }

        public b k(int r1) {
            this.f8052f = r1;
            return this;
        }

        public b l(int r1) {
            this.f8053g = r1;
            return this;
        }

        public b m(d r1) {
            this.m = r1.a();
            return this;
        }

        public b n(e r1) {
            this.o = r1.a();
            return this;
        }

        public b o(String r1) {
            this.s = r1;
            return this;
        }

        public b p(f r1) {
            this.q = r1.a();
            return this;
        }

        public b q(boolean r1) {
            this.f8049c = r1;
            return this;
        }

        public b r(g r1) {
            this.n = r1.a();
            return this;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f8059g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f8060h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f8061i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ c[] f8062j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f8063f;

        static {
            c r0 = new c("NONE", 0, 0);
            f8059g = r0;
            c r1 = new c("ZLIB", 1, 1);
            f8060h = r1;
            c r3 = new c("ZSTD", 2, 2);
            f8061i = r3;
            f8062j = new c[]{r0, r1, r3};
        }

        private c(String r1, int r2, int r3) {
            super(r1, r2);
            this.f8063f = r3;
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f8062j.clone();
        }

        int a() {
            return this.f8063f;
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f8064g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f8065h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ d[] f8066i = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f8067f;

        static {
            d r0 = new d("SPEED", 0, 0);
            f8064g = r0;
            d r1 = new d("SAFE", 1, 1);
            f8065h = r1;
            f8066i = new d[]{r0, r1};
        }

        private d(String r1, int r2, int r3) {
            super(r1, r2);
            this.f8067f = r3;
        }

        public static d valueOf(String r1) {
            return (d) Enum.valueOf(d.class, r1);
        }

        public static d[] values() {
            return (d[]) f8066i.clone();
        }

        int a() {
            return this.f8067f;
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final e f8068g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final e f8069h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ e[] f8070i = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f8071f;

        static {
            e r0 = new e("DEFAULT", 0, 0);
            f8068g = r0;
            e r1 = new e("LEGACY", 1, 1);
            f8069h = r1;
            f8070i = new e[]{r0, r1};
        }

        private e(String r1, int r2, int r3) {
            super(r1, r2);
            this.f8071f = r3;
        }

        public static e valueOf(String r1) {
            return (e) Enum.valueOf(e.class, r1);
        }

        public static e[] values() {
            return (e[]) f8070i.clone();
        }

        int a() {
            return this.f8071f;
        }
    }

    public static final enum f extends Enum<f> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final f f8072g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final f f8073h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final f f8074i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final f f8075j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ f[] f8076k = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f8077f;

        static {
            f r0 = new f("NONE", 0, 0);
            f8072g = r0;
            f r1 = new f("TEA_16", 1, 1);
            f8073h = r1;
            f r3 = new f("TEA_32", 2, 2);
            f8074i = r3;
            f r5 = new f("TEA_64", 3, 3);
            f8075j = r5;
            f8076k = new f[]{r0, r1, r3, r5};
        }

        private f(String r1, int r2, int r3) {
            super(r1, r2);
            this.f8077f = r3;
        }

        public static f valueOf(String r1) {
            return (f) Enum.valueOf(f.class, r1);
        }

        public static f[] values() {
            return (f[]) f8076k.clone();
        }

        int a() {
            return this.f8077f;
        }
    }

    public static final enum g extends Enum<g> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final g f8078g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final g f8079h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ g[] f8080i = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f8081f;

        static {
            g r0 = new g("RAW", 0, 1);
            f8078g = r0;
            g r1 = new g("ISO_8601", 1, 1);
            f8079h = r1;
            f8080i = new g[]{r0, r1};
        }

        private g(String r1, int r2, int r3) {
            super(r1, r2);
            this.f8081f = r3;
        }

        public static g valueOf(String r1) {
            return (g) Enum.valueOf(g.class, r1);
        }

        public static g[] values() {
            return (g[]) f8080i.clone();
        }

        int a() {
            return this.f8081f;
        }
    }

    static {
        f8031c = d.f8065h.a();
        f8032d = g.f8078g.a();
        f8033e = e.f8068g.a();
        f8034f = c.f8061i.a();
        f8035g = f.f8073h.a();
        f8036h = a.f8043h.a();
        f8037i = null;
        f8038j = new ArrayList();
        f8039k = false;
    }

    public Alog(Context r4, int r5, boolean r6, String r7, String r8, int r9, int r10, int r11, String r12, int r13, int r14, String r15, int r16, int r17, int r18, int r19, int r20, int r21, String r22) {
        this.f8040a = r5;
        int r2 = r14 / r13;
        this.f8041b = nativeCreate(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    static /* synthetic */ int a() {
        return f8031c;
    }

    static /* synthetic */ int b() {
        return f8032d;
    }

    static /* synthetic */ int c() {
        return f8033e;
    }

    static /* synthetic */ int d() {
        return f8034f;
    }

    static /* synthetic */ int e() {
        return f8035g;
    }

    static /* synthetic */ int f() {
        return f8036h;
    }

    static /* synthetic */ ArrayList g() {
        return f8038j;
    }

    private static native void nativeAsyncFlush(long r0);

    private static native long nativeCreate(int r0, boolean r1, String r2, String r3, int r4, int r5, int r6, String r7, int r8, int r9, String r10, int r11, int r12, int r13, int r14, int r15, int r16, String r17);

    private static native void nativeDestroy(long r0);

    private static native long nativeGetLegacyFlushFuncAddr();

    private static native long nativeGetLegacyGetLogFileDirFuncAddr();

    private static native long nativeGetLegacyWriteFuncAddr();

    private static native long nativeGetNativeWriteFuncAddr();

    static native void nativeSetDefaultInstance(long r0);

    private static native void nativeSetLevel(long r0, int r2);

    private static native void nativeSetSyslog(long r0, boolean r2);

    private static native void nativeSyncFlush(long r0);

    private static native void nativeTimedSyncFlush(long r0, int r2);

    private static native void nativeWrite(long r0, int r2, String r3, String r4);

    private static native void nativeWriteAsyncMsg(long r0, int r2, String r3, String r4, long r5, long r7);

    public static synchronized void o(com.obric.android.alog.a r2) {
        monitor-enter(Alog.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f8039k == false) goto L8;
        monitor-exit(Alog.class);
        return;
    L8:
        if (r2 != null) goto L10;
        System.loadLibrary("oalog");     // Catch: Throwable -> L14
    L11:
        f8039k = true;     // Catch: Throwable -> L14
        monitor-exit(Alog.class);
        return;
    L10:
        r2.loadLibrary("oalog");     // Catch: Throwable -> L14
        goto L11
    }

    public void finalize() {
        super.finalize();     // Catch: Throwable -> L5
        i();
        return;
    L5:
        th = move-exception;
        i();
        throw th;
    }

    public void h() {
        long r0 = this.f8041b;
        if (r0 == 0) goto L6;
        nativeAsyncFlush(r0);
        return;
    }

    public void i() {
        monitor-enter(this);
        long r0 = this.f8041b;     // Catch: Throwable -> L8
        if (r0 == 0) goto L6;
        this.f8040a = 6;     // Catch: Throwable -> L8
        nativeDestroy(r0);     // Catch: Throwable -> L8
        this.f8041b = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void j(String r2, String r3) {
        q(1, r2, r3);
    }

    public void k(String r2, String r3) {
        q(4, r2, r3);
    }

    public long l() {
        if (this.f8041b != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyWriteFuncAddr();
    }

    public long m() {
        return this.f8041b;
    }

    public void n(String r2, String r3) {
        q(2, r2, r3);
    }

    public void p(int r5) {
        this.f8040a = r5;
        long r0 = this.f8041b;
        if (r0 == 0) goto L6;
        nativeSetLevel(r0, r5);
        return;
    }

    public void q(int r5, String r6, String r7) {
        if (this.f8041b != 0) goto L5;
        return;
    L5:
        if (r5 < this.f8040a) goto L21;
        if (r6 == null) goto L22;
        if (r7 != null) goto L9;
        return;
    L9:
        if (f8037i == null) goto L17;
        com.obric.android.alog.d r0 = new com.obric.android.alog.d(r5, r6, r7);
        Iterator<com.obric.android.alog.b> r8 = f8037i.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        r0 = r8.next().a(r0);
        goto L12
    L14:
        if (r0 != null) goto L16;
        return;
    L16:
        nativeWrite(this.f8041b, r0.f8083a, r0.f8084b, r0.f8085c);
        return;
    L17:
        nativeWrite(this.f8041b, r5, r6, r7);
        return;
    L22:
        return;
    }

    public void r(int r13, String r14, String r15, long r16, long r18) {
        if (this.f8041b != 0) goto L5;
        return;
    L5:
        if (r13 < this.f8040a) goto L21;
        if (r14 == null) goto L22;
        if (r15 != null) goto L9;
        return;
    L9:
        if (f8037i == null) goto L17;
        com.obric.android.alog.d r1 = new com.obric.android.alog.d(r13, r14, r15);
        Iterator<com.obric.android.alog.b> r2 = f8037i.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        r1 = r2.next().a(r1);
        goto L12
    L14:
        if (r1 != null) goto L16;
        return;
    L16:
        nativeWriteAsyncMsg(this.f8041b, r1.f8083a, r1.f8084b, r1.f8085c, r16, r18);
        return;
    L17:
        nativeWriteAsyncMsg(this.f8041b, r13, r14, r15, r16, r18);
        return;
    L22:
        return;
    }
}

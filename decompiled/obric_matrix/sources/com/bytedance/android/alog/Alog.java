package com.bytedance.android.alog;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class Alog {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f555j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f556k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f557l = 0;
    private static final int m = 0;
    private static final int n = 0;
    private static final int o = 0;
    private static final ArrayList<String> p = null;
    private static boolean q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f562e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f564g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f565h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f566i;

    class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Pattern f567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Alog f568b;

        a(Alog r1, Pattern r2) {
            this.f568b = r1;
            this.f567a = r2;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r1, String r2) {
            return this.f567a.matcher(r2).find();
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f569g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f570h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f571i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ b[] f572j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f573f;

        static {
            b r0 = new b("NONE", 0, 0);
            f569g = r0;
            b r1 = new b("EC_SECP256K1", 1, 1);
            f570h = r1;
            b r3 = new b("EC_SECP256R1", 2, 2);
            f571i = r3;
            f572j = new b[]{r0, r1, r3};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f573f = r3;
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) f572j.clone();
        }

        int a() {
            return this.f573f;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f576c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f577d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f578e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f579f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f580g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f581h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f582i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f583j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f584k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f585l;
        private int m;
        private int n;
        private int o;
        private int p;
        private int q;
        private int r;
        private String s;

        public c(Context r3) {
            this.f575b = 0;
            this.f576c = false;
            this.f577d = null;
            this.f578e = null;
            this.f579f = 2097152;
            this.f580g = 20971520;
            this.f581h = 7;
            this.f582i = null;
            this.f583j = 65536;
            this.f584k = 196608;
            this.f585l = null;
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
            this.f574a = r3;
        }

        public Alog a() {
            if (this.f577d != null) goto L5;
            this.f577d = "default";
        L5:
            ArrayList r1 = Alog.g();
            monitor-enter(r1);
            Iterator r2 = Alog.g().iterator();     // Catch: Throwable -> L37
        L9:
            if (r2.hasNext() == false) goto L14;
            if (((String) r2.next()).equals(this.f577d) == false) goto L9;
            monitor-exit(r1);     // Catch: Throwable -> L37
            return null;
        L14:
            Alog.g().add(this.f577d);     // Catch: Throwable -> L37
            monitor-exit(r1);     // Catch: Throwable -> L37
            if (this.f578e != null) goto L24;
            File r3 = this.f574a.getExternalFilesDir(null);
            if (r3 == null) goto L21;
            String r4 = r3.getPath() + "/alog";
        L22:
            this.f578e = r4;
            goto L24
        L21:
            r4 = this.f574a.getFilesDir() + "/alog";
        L24:
            if (this.f582i != null) goto L27;
            this.f582i = this.f574a.getFilesDir() + "/alog";
        L27:
            if (this.f585l != null) goto L29;
            this.f585l = com.bytedance.android.alog.d.a(this.f574a);
        L29:
            int r5 = (this.f583j / 4096) * 4096;
            this.f583j = r5;
            int r6 = (this.f584k / 4096) * 4096;
            this.f584k = r6;
            if (r5 >= 4096) goto L32;
            this.f583j = 4096;
        L32:
            int r7 = this.f583j;
            if (r6 >= (r7 * 2)) goto L36;
            this.f584k = r7 * 2;
        L36:
            return new Alog(this.f574a, this.f575b, this.f576c, this.f577d, this.f578e, this.f579f, this.f580g, this.f581h, this.f582i, this.f583j, this.f584k, this.f585l, this.m, this.n, this.o, this.p, this.q, this.r, this.s);
        L37:
            th = move-exception;
            throw th;
        }

        public c b(b r1) {
            this.r = r1.a();
            return this;
        }

        public c c(String r1) {
            this.f582i = r1;
            return this;
        }

        public c d(int r1) {
            this.f583j = r1;
            return this;
        }

        public c e(int r1) {
            this.f584k = r1;
            return this;
        }

        public c f(d r1) {
            this.p = r1.a();
            return this;
        }

        public c g(String r4) {
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
            this.f577d = r4;
            goto L13
        }

        public c h(int r1) {
            this.f575b = r1;
            return this;
        }

        public c i(String r1) {
            this.f578e = r1;
            return this;
        }

        public c j(int r1) {
            this.f581h = r1;
            return this;
        }

        public c k(int r1) {
            this.f579f = r1;
            return this;
        }

        public c l(int r1) {
            this.f580g = r1;
            return this;
        }

        public c m(e r1) {
            this.m = r1.a();
            return this;
        }

        public c n(f r1) {
            this.o = r1.a();
            return this;
        }

        public c o(String r1) {
            this.s = r1;
            return this;
        }

        public c p(g r1) {
            this.q = r1.a();
            return this;
        }

        public c q(boolean r1) {
            this.f576c = r1;
            return this;
        }

        public c r(h r1) {
            this.n = r1.a();
            return this;
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f586g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f587h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final d f588i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ d[] f589j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f590f;

        static {
            d r0 = new d("NONE", 0, 0);
            f586g = r0;
            d r1 = new d("ZLIB", 1, 1);
            f587h = r1;
            d r3 = new d("ZSTD", 2, 2);
            f588i = r3;
            f589j = new d[]{r0, r1, r3};
        }

        private d(String r1, int r2, int r3) {
            super(r1, r2);
            this.f590f = r3;
        }

        public static d valueOf(String r1) {
            return (d) Enum.valueOf(d.class, r1);
        }

        public static d[] values() {
            return (d[]) f589j.clone();
        }

        int a() {
            return this.f590f;
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final e f591g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final e f592h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ e[] f593i = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f594f;

        static {
            e r0 = new e("SPEED", 0, 0);
            f591g = r0;
            e r1 = new e("SAFE", 1, 1);
            f592h = r1;
            f593i = new e[]{r0, r1};
        }

        private e(String r1, int r2, int r3) {
            super(r1, r2);
            this.f594f = r3;
        }

        public static e valueOf(String r1) {
            return (e) Enum.valueOf(e.class, r1);
        }

        public static e[] values() {
            return (e[]) f593i.clone();
        }

        int a() {
            return this.f594f;
        }
    }

    public static final enum f extends Enum<f> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final f f595g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final f f596h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ f[] f597i = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f598f;

        static {
            f r0 = new f("DEFAULT", 0, 0);
            f595g = r0;
            f r1 = new f("LEGACY", 1, 1);
            f596h = r1;
            f597i = new f[]{r0, r1};
        }

        private f(String r1, int r2, int r3) {
            super(r1, r2);
            this.f598f = r3;
        }

        public static f valueOf(String r1) {
            return (f) Enum.valueOf(f.class, r1);
        }

        public static f[] values() {
            return (f[]) f597i.clone();
        }

        int a() {
            return this.f598f;
        }
    }

    public static final enum g extends Enum<g> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final g f599g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final g f600h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final g f601i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final g f602j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ g[] f603k = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f604f;

        static {
            g r0 = new g("NONE", 0, 0);
            f599g = r0;
            g r1 = new g("TEA_16", 1, 1);
            f600h = r1;
            g r3 = new g("TEA_32", 2, 2);
            f601i = r3;
            g r5 = new g("TEA_64", 3, 3);
            f602j = r5;
            f603k = new g[]{r0, r1, r3, r5};
        }

        private g(String r1, int r2, int r3) {
            super(r1, r2);
            this.f604f = r3;
        }

        public static g valueOf(String r1) {
            return (g) Enum.valueOf(g.class, r1);
        }

        public static g[] values() {
            return (g[]) f603k.clone();
        }

        int a() {
            return this.f604f;
        }
    }

    public static final enum h extends Enum<h> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final h f605g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final h f606h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ h[] f607i = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f608f;

        static {
            h r0 = new h("RAW", 0, 0);
            f605g = r0;
            h r1 = new h("ISO_8601", 1, 1);
            f606h = r1;
            f607i = new h[]{r0, r1};
        }

        private h(String r1, int r2, int r3) {
            super(r1, r2);
            this.f608f = r3;
        }

        public static h valueOf(String r1) {
            return (h) Enum.valueOf(h.class, r1);
        }

        public static h[] values() {
            return (h[]) f607i.clone();
        }

        int a() {
            return this.f608f;
        }
    }

    static {
        f555j = e.f592h.a();
        f556k = h.f605g.a();
        f557l = f.f595g.a();
        m = d.f588i.a();
        n = g.f600h.a();
        o = b.f570h.a();
        p = new ArrayList();
        q = false;
    }

    public Alog(Context r7, int r8, boolean r9, String r10, String r11, int r12, int r13, int r14, String r15, int r16, int r17, String r18, int r19, int r20, int r21, int r22, int r23, int r24, String r25) {
        this.f558a = r7;
        this.f559b = r8;
        this.f560c = r11;
        this.f561d = r15;
        this.f562e = r16;
        this.f563f = r17 / r16;
        this.f564g = null;
        this.f565h = r10;
        this.f566i = nativeCreate(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
    }

    static /* synthetic */ int a() {
        return f555j;
    }

    static /* synthetic */ int b() {
        return f556k;
    }

    static /* synthetic */ int c() {
        return f557l;
    }

    static /* synthetic */ int d() {
        return m;
    }

    static /* synthetic */ int e() {
        return n;
    }

    static /* synthetic */ int f() {
        return o;
    }

    static /* synthetic */ ArrayList g() {
        return p;
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

    public static synchronized void u(com.bytedance.android.alog.b r2) {
        monitor-enter(Alog.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (q == false) goto L8;
        monitor-exit(Alog.class);
        return;
    L8:
        if (r2 != null) goto L10;
        System.loadLibrary("alog");     // Catch: Throwable -> L14
    L11:
        q = true;     // Catch: Throwable -> L14
        monitor-exit(Alog.class);
        return;
    L10:
        r2.loadLibrary("alog");     // Catch: Throwable -> L14
        goto L11
    }

    public void A(String r2, String r3) {
        B(3, r2, r3);
    }

    public void B(int r5, String r6, String r7) {
        long r0 = this.f566i;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (r5 < this.f559b) goto L11;
        if (r6 == null) goto L12;
        if (r7 == null) goto L13;
        nativeWrite(r0, r5, r6, r7);
        return;
    L13:
        return;
    L12:
        return;
    }

    public void C(int r10, String r11, String r12, long r13, long r15) {
        long r1 = this.f566i;
        if (r1 != 0) goto L5;
        return;
    L5:
        if (r10 < this.f559b) goto L11;
        if (r11 == null) goto L12;
        if (r12 == null) goto L13;
        nativeWriteAsyncMsg(r1, r10, r11, r12, r13, r15);
        return;
    L13:
        return;
    L12:
        return;
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
        long r0 = this.f566i;
        if (r0 == 0) goto L6;
        nativeAsyncFlush(r0);
        return;
    }

    public void i() {
        monitor-enter(this);
        long r0 = this.f566i;     // Catch: Throwable -> L8
        if (r0 == 0) goto L6;
        this.f558a = null;     // Catch: Throwable -> L8
        this.f559b = 6;     // Catch: Throwable -> L8
        nativeDestroy(r0);     // Catch: Throwable -> L8
        this.f566i = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void j(String r2, String r3) {
        B(1, r2, r3);
    }

    public void k(String r2, String r3) {
        B(4, r2, r3);
    }

    public HashMap<String, String> l() {
        return com.bytedance.android.alog.a.a();
    }

    public long m() {
        if (this.f566i != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyFlushFuncAddr();
    }

    public long n() {
        if (this.f566i != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyGetLogFileDirFuncAddr();
    }

    public long o() {
        if (this.f566i != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyWriteFuncAddr();
    }

    public File[] p(String r8, String r9, long r10, long r12) {
        return com.bytedance.android.alog.a.b(this.f560c, r8, r9, r10, r12);
    }

    public long q() {
        return this.f566i;
    }

    public long r() {
        if (this.f566i != 0) goto L5;
        return 0;
    L5:
        return nativeGetNativeWriteFuncAddr();
    }

    public String s() {
        if (q == true) goto L7;
        return "not inited";
    L7:
        if (this.f564g != null) goto L9;
        this.f564g = com.bytedance.android.alog.d.b(this.f558a);
    L9:
        String r1 = this.f564g;
        if (r1 != null) goto L13;
        return "get process name failed";
    L13:
        String r2 = r1.replace(':', '-');
        File r3 = new File(this.f561d);
        if (r3.exists() == true) goto L17;
        return "cache dir not exists";
    L17:
        File[] r4 = r3.listFiles();
        if (r4 != null) goto L21;
        return "cache dir is empty";
    L21:
        String r5 = r2 + "__" + this.f565h + ".alog.cache.guard";
        Pattern r6 = Pattern.compile("^" + Pattern.quote(r2) + "__" + Pattern.quote(this.f565h) + "__\\d{5}\\.alog\\.cache$");
        int r7 = r4.length;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L22:
        if (r8 >= r7) goto L39;
        File r13 = r4[r8];
        if (r13.getName().equals(r5) == false) goto L30;
        r9 = r9 + 1;
        if (r13.length() < 24576) goto L28;
        r10 = r10 + 1;
    L28:
        File[] r16 = r4;
    L29:
        Pattern r15 = r6;
        int r17 = r7;
    L37:
        r8 = r8 + 1;
        r6 = r15;
        r4 = r16;
        r7 = r17;
        goto L22
    L30:
        String r14 = r13.getName();
        StringBuilder r18 = new StringBuilder();
        r18.append(r2);
        r18.append("__");
        r16 = r4;
        r18.append(this.f565h);
        r18.append("__");
        if (r14.startsWith(r18.toString()) == false) goto L29;
        if (r6.matcher(r13.getName()).find() == false) goto L29;
        r11 = r11 + 1;
        r15 = r6;
        r17 = r7;
        if (r13.length() < this.f562e) goto L37;
        r12 = r12 + 1;
        goto L37
    L39:
        if (r9 >= 1) goto L42;
        Log.d("alog_trace", r5);
        Log.d("alog_trace", r3.getAbsolutePath());
        return "cache guard not exists";
    L42:
        if (r10 >= 1) goto L45;
        return "cache guard size insufficiently";
    L45:
        int r19 = this.f563f;
        if (r11 >= r19) goto L49;
        return "cache block count insufficiently";
    L49:
        if (r12 >= r19) goto L52;
        return "cache block size insufficiently";
    L52:
        File r20 = new File(this.f560c);
        if (r20.exists() == true) goto L56;
        return "log dir not exists";
    L56:
        File[] r0 = r20.listFiles(new a(this, Pattern.compile("^\\d{4}_\\d{2}_\\d{2}_\\d+__" + Pattern.quote(r2) + "__" + Pattern.quote(this.f565h) + "\\.alog\\.hot$")));
        if (r0 != null) goto L59;
        return "no log file for current process and instance";
    L59:
        if (r0.length == 0) goto L69;
        return "OK";
    L69:
        return "no log file for current process and instance";
    }

    public void t(String r2, String r3) {
        B(2, r2, r3);
    }

    public void v(int r5) {
        long r0 = this.f566i;
        if (r0 == 0) goto L6;
        nativeSetLevel(r0, r5);
        return;
    }

    public void w(boolean r5) {
        long r0 = this.f566i;
        if (r0 == 0) goto L6;
        nativeSetSyslog(r0, r5);
        return;
    }

    public void x() {
        long r0 = this.f566i;
        if (r0 == 0) goto L6;
        nativeSyncFlush(r0);
        return;
    }

    public void y(int r5) {
        long r0 = this.f566i;
        if (r0 == 0) goto L6;
        nativeTimedSyncFlush(r0, r5);
        return;
    }

    public void z(String r2, String r3) {
        B(0, r2, r3);
    }
}

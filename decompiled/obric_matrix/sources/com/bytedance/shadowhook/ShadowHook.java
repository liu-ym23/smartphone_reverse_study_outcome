package com.bytedance.shadowhook;

import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes.dex */
public final class ShadowHook {
    private static final int ERRNO_INIT_EXCEPTION = 101;
    private static final int ERRNO_LOAD_LIBRARY_EXCEPTION = 100;
    private static final int ERRNO_OK = 0;
    private static final int ERRNO_PENDING = 1;
    private static final int ERRNO_UNINIT = 2;
    private static final boolean defaultDebuggable = false;
    private static final d defaultLibLoader = null;
    private static final int defaultMode = 0;
    private static long initCostMs = -1;
    private static int initErrno = 2;
    private static boolean inited = false;
    private static final String libName = "shadowhook";
    private static final int recordItemAll = 1023;
    private static final int recordItemBackupLen = 128;
    private static final int recordItemCallerLibName = 2;
    private static final int recordItemErrno = 256;
    private static final int recordItemLibName = 8;
    private static final int recordItemNewAddr = 64;
    private static final int recordItemOp = 4;
    private static final int recordItemStub = 512;
    private static final int recordItemSymAddr = 32;
    private static final int recordItemSymName = 16;
    private static final int recordItemTimestamp = 1;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5807a = null;

        static {
            int[] r0 = new int[f.values().length];
            f5807a = r0;
            r0[f.f5818f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            f5807a[f.f5819g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            f5807a[f.f5820h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            f5807a[f.f5821i.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            f5807a[f.f5822j.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            f5807a[f.f5823k.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            f5807a[f.f5824l.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            f5807a[f.m.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            f5807a[f.n.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            f5807a[f.o.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f5808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5809b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f5810c;

        public b() {
        }

        public boolean a() {
            return this.f5810c;
        }

        public d b() {
            return this.f5808a;
        }

        public int c() {
            return this.f5809b;
        }

        public void d(boolean r1) {
            this.f5810c = r1;
        }

        public void e(d r1) {
            this.f5808a = r1;
        }

        public void f(int r1) {
            this.f5809b = r1;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f5811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5812b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f5813c;

        public c() {
            this.f5811a = ShadowHook.access$000();
            this.f5812b = ShadowHook.access$100();
            this.f5813c = false;
        }

        public b a() {
            b r0 = new b();
            r0.e(this.f5811a);
            r0.f(this.f5812b);
            r0.d(this.f5813c);
            return r0;
        }
    }

    public interface d {
        void loadLibrary(String r1);
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final e f5814g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final e f5815h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ e[] f5816i = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f5817f;

        static {
            e r0 = new e("SHARED", 0, 0);
            f5814g = r0;
            e r1 = new e("UNIQUE", 1, 1);
            f5815h = r1;
            f5816i = new e[]{r0, r1};
        }

        private e(String r1, int r2, int r3) {
            super(r1, r2);
            this.f5817f = r3;
        }

        public static e valueOf(String r1) {
            return (e) Enum.valueOf(e.class, r1);
        }

        public static e[] values() {
            return (e[]) f5816i.clone();
        }

        int a() {
            return this.f5817f;
        }
    }

    public static final enum f extends Enum<f> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f5818f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final f f5819g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final f f5820h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final f f5821i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final f f5822j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final f f5823k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final f f5824l = null;
        public static final f m = null;
        public static final f n = null;
        public static final f o = null;
        private static final /* synthetic */ f[] p = null;

        static {
            f r0 = new f("TIMESTAMP", 0);
            f5818f = r0;
            f r1 = new f("CALLER_LIB_NAME", 1);
            f5819g = r1;
            f r3 = new f("OP", 2);
            f5820h = r3;
            f r5 = new f("LIB_NAME", 3);
            f5821i = r5;
            f r7 = new f("SYM_NAME", 4);
            f5822j = r7;
            f r9 = new f("SYM_ADDR", 5);
            f5823k = r9;
            f r11 = new f("NEW_ADDR", 6);
            f5824l = r11;
            f r13 = new f("BACKUP_LEN", 7);
            m = r13;
            f r15 = new f("ERRNO", 8);
            n = r15;
            f r14 = new f("STUB", 9);
            o = r14;
            p = new f[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        }

        private f(String r1, int r2) {
            super(r1, r2);
        }

        public static f valueOf(String r1) {
            return (f) Enum.valueOf(f.class, r1);
        }

        public static f[] values() {
            return (f[]) p.clone();
        }
    }

    static {
        defaultMode = e.f5814g.a();
    }

    public ShadowHook() {
    }

    static /* synthetic */ d access$000() {
        return defaultLibLoader;
    }

    static /* synthetic */ int access$100() {
        return defaultMode;
    }

    public static String getArch() {
        if (isInitedOk() == true) goto L5;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L5:
        return nativeGetArch();
    }

    public static long getInitCostMs() {
        return initCostMs;
    }

    public static int getInitErrno() {
        return initErrno;
    }

    public static String getRecords(f... r5) {
        if (isInitedOk() == false) goto L24;
        int r0 = r5.length;
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r1 >= r0) goto L20;
        switch(a.f5807a[r5[r1].ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            default: goto L19;
        };
    L9:
        r2 = r2 | 512;
        goto L19
    L10:
        r2 = r2 | 256;
        goto L19
    L11:
        r2 = r2 | 128;
        goto L19
    L12:
        r2 = r2 | 64;
        goto L19
    L13:
        r2 = r2 | 32;
        goto L19
    L14:
        r2 = r2 | 16;
        goto L19
    L15:
        r2 = r2 | 8;
        goto L19
    L16:
        r2 = r2 | 4;
        goto L19
    L17:
        r2 = r2 | 2;
        goto L19
    L18:
        r2 = r2 | 1;
    L19:
        r1 = r1 + 1;
        goto L5
    L20:
        if (r2 != 0) goto L23;
        r2 = recordItemAll;
    L23:
        return nativeGetRecords(r2);
    L24:
        return null;
    }

    public static int init() {
        if (inited == false) goto L7;
        return initErrno;
    L7:
        return init(new c().a());
    }

    public static synchronized int init(b r5) {
        monitor-enter(ShadowHook.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L10;
        int r6 = initErrno;     // Catch: Throwable -> L22
        monitor-exit(ShadowHook.class);
        return r6;
    L10:
        inited = true;     // Catch: Throwable -> L22
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L22
        if (loadLibrary(r5) == true) goto L26;
        initErrno = 100;     // Catch: Throwable -> L22
        initCostMs = System.currentTimeMillis() - r1;     // Catch: Throwable -> L22
        int r7 = initErrno;     // Catch: Throwable -> L22
        monitor-exit(ShadowHook.class);
        return r7;
    L26:
        initErrno = nativeInit(r5.c(), r5.a());     // Catch: Throwable -> L17
    L19:
        initCostMs = System.currentTimeMillis() - r1;     // Catch: Throwable -> L22
        int r8 = initErrno;     // Catch: Throwable -> L22
        monitor-exit(ShadowHook.class);
        return r8;
    L18:
        initErrno = 101;     // Catch: Throwable -> L22
        goto L19
    }

    private static boolean isInitedOk() {
        if (inited == false) goto L10;
        if (initErrno != 0) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (loadLibrary() == true) goto L20;
        return false;
    L20:
        int r0 = nativeGetInitErrno();     // Catch: Throwable -> L19
        if (r0 == 2) goto L15;
        initErrno = r0;     // Catch: Throwable -> L19
        inited = true;     // Catch: Throwable -> L19
    L15:
        if (r0 != 0) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    private static boolean loadLibrary() {
        return loadLibrary(null);
    }

    private static boolean loadLibrary(b r2) {
        if (r2 != null) goto L13;
    L8:
        System.loadLibrary(libName);     // Catch: Throwable -> L11
        return true;
    L11:
        return false;
    L13:
        if (r2.b() == null) goto L8;
        r2.b().loadLibrary(libName);     // Catch: Throwable -> L11
        return true;
    }

    private static native String nativeGetArch();

    private static native int nativeGetInitErrno();

    private static native String nativeGetRecords(int r0);

    private static native int nativeInit(int r0, boolean r1);

    private static native void nativeSetDebuggable(boolean r0);

    private static native String nativeToErrmsg(int r0);

    public static void setDebuggable(boolean r1) {
        if (isInitedOk() == false) goto L6;
        nativeSetDebuggable(r1);
        return;
    }

    public static String toErrmsg(int r1) {
        if (r1 != 0) goto L6;
        return "OK";
    L6:
        if (r1 != 1) goto L10;
        return "Pending task";
    L10:
        if (r1 != 2) goto L14;
        return "Not initialized";
    L14:
        if (r1 != 100) goto L18;
        return "Load libshadowhook.so failed";
    L18:
        if (r1 != 101) goto L22;
        return "Init exception";
    L22:
        if (isInitedOk() == true) goto L24;
        return "Unknown";
    L24:
        return nativeToErrmsg(r1);
    }
}

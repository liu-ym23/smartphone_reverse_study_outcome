package com.bytedance.android.bytehook;

/* JADX INFO: loaded from: classes.dex */
public class ByteHook {
    private static final boolean defaultDebug = false;
    private static final com.bytedance.android.bytehook.a defaultLibLoader = null;
    private static final int defaultMode = 0;
    private static int initStatus = 1;
    private static boolean inited = false;
    private static final String libName = "bytehook";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bytedance.android.bytehook.a f619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f621c;

        public a() {
        }

        public boolean a() {
            return this.f621c;
        }

        public com.bytedance.android.bytehook.a b() {
            return this.f619a;
        }

        public int c() {
            return this.f620b;
        }

        public void d(boolean r1) {
            this.f621c = r1;
        }

        public void e(com.bytedance.android.bytehook.a r1) {
            this.f619a = r1;
        }

        public void f(int r1) {
            this.f620b = r1;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bytedance.android.bytehook.a f622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f624c;

        public b() {
            this.f622a = ByteHook.access$000();
            this.f623b = ByteHook.access$100();
            this.f624c = false;
        }

        public a a() {
            a r0 = new a();
            r0.e(this.f622a);
            r0.f(this.f623b);
            r0.d(this.f624c);
            return r0;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f625g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f626h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ c[] f627i = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f628f;

        static {
            c r0 = new c("AUTOMATIC", 0, 0);
            f625g = r0;
            c r1 = new c("MANUAL", 1, 1);
            f626h = r1;
            f627i = new c[]{r0, r1};
        }

        private c(String r1, int r2, int r3) {
            super(r1, r2);
            this.f628f = r3;
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f627i.clone();
        }

        int a() {
            return this.f628f;
        }
    }

    static {
        defaultMode = c.f625g.a();
    }

    public ByteHook() {
    }

    static /* synthetic */ com.bytedance.android.bytehook.a access$000() {
        return defaultLibLoader;
    }

    static /* synthetic */ int access$100() {
        return defaultMode;
    }

    public static String getRecords() {
        if (initStatus == 0) goto L5;
        return null;
    L5:
        return nativeGetRecords();
    }

    public static int init() {
        if (inited == false) goto L7;
        return initStatus;
    L7:
        return init(new b().a());
    }

    public static synchronized int init(a r3) {
        monitor-enter(ByteHook.class);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L10;
        int r4 = initStatus;     // Catch: Throwable -> L26
        monitor-exit(ByteHook.class);
        return r4;
    L10:
        inited = true;     // Catch: Throwable -> L26
        if (r3.b() != null) goto L14;
        System.loadLibrary(libName);     // Catch: Throwable -> L22
    L30:
        initStatus = nativeInit(r3.c(), r3.a());     // Catch: Throwable -> L17
    L19:
        int r5 = initStatus;     // Catch: Throwable -> L26
        monitor-exit(ByteHook.class);
        return r5;
    L18:
        initStatus = 101;     // Catch: Throwable -> L26
        goto L19
    L14:
        r3.b().loadLibrary(libName);     // Catch: Throwable -> L22
        goto L30
    L23:
        initStatus = 100;     // Catch: Throwable -> L26
        return 100;
    }

    private static native String nativeGetRecords();

    private static native int nativeInit(int r0, boolean r1);

    private static native void nativeSetDebug(boolean r0);

    public static void setDebug(boolean r1) {
        if (initStatus != 0) goto L6;
        nativeSetDebug(r1);
        return;
    }
}

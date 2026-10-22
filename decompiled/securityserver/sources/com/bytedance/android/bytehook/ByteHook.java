package com.bytedance.android.bytehook;

/* JADX INFO: loaded from: classes.dex */
public class ByteHook {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2a = 0;
    private static final boolean defaultDebug = false;
    private static final ILibLoader defaultLibLoader = null;
    private static final int defaultMode = 0;
    private static int initStatus = 1;
    private static boolean inited = false;
    private static final String libName = "bytehook";

    public static class Config {
        private boolean debug;
        private ILibLoader libLoader;
        private int mode;

        public Config() {
        }

        public boolean getDebug() {
            return this.debug;
        }

        public ILibLoader getLibLoader() {
            return this.libLoader;
        }

        public int getMode() {
            return this.mode;
        }

        public void setDebug(boolean r1) {
            this.debug = r1;
        }

        public void setLibLoader(ILibLoader r1) {
            this.libLoader = r1;
        }

        public void setMode(int r1) {
            this.mode = r1;
        }
    }

    public static class ConfigBuilder {
        private boolean debug;
        private ILibLoader libLoader;
        private int mode;

        public ConfigBuilder() {
            this.libLoader = ByteHook.access$000();
            this.mode = ByteHook.access$100();
            this.debug = false;
        }

        public Config build() {
            Config r0 = new Config();
            r0.setLibLoader(this.libLoader);
            r0.setMode(this.mode);
            r0.setDebug(this.debug);
            return r0;
        }

        public ConfigBuilder setDebug(boolean r1) {
            this.debug = r1;
            return this;
        }

        public ConfigBuilder setLibLoader(ILibLoader r1) {
            this.libLoader = r1;
            return this;
        }

        public ConfigBuilder setMode(Mode r1) {
            this.mode = r1.getValue();
            return this;
        }
    }

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode AUTOMATIC = null;
        public static final Mode MANUAL = null;
        private final int value;

        static {
            Mode r0 = new Mode("AUTOMATIC", 0, 0);
            AUTOMATIC = r0;
            Mode r1 = new Mode("MANUAL", 1, 1);
            MANUAL = r1;
            $VALUES = new Mode[]{r0, r1};
        }

        private Mode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static Mode valueOf(String r1) {
            return (Mode) Enum.valueOf(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    static {
        defaultMode = Mode.AUTOMATIC.getValue();
    }

    public ByteHook() {
    }

    public static /* synthetic */ ILibLoader access$000() {
        return defaultLibLoader;
    }

    public static /* synthetic */ int access$100() {
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
        return init(new ConfigBuilder().build());
    }

    private static native String nativeGetRecords();

    private static native int nativeInit(int r0, boolean r1);

    private static native void nativeSetDebug(boolean r0);

    public static void setDebug(boolean r1) {
        if (initStatus != 0) goto L6;
        nativeSetDebug(r1);
        return;
    }

    public static synchronized int init(Config r3) {
        monitor-enter(ByteHook.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L12;
        int r4 = initStatus;     // Catch: Throwable -> L9
        monitor-exit(ByteHook.class);
        return r4;
    L12:
        inited = true;     // Catch: Throwable -> L9
        if (r3.getLibLoader() != null) goto L16;
        System.loadLibrary(libName);     // Catch: Throwable -> L24
    L30:
        initStatus = nativeInit(r3.getMode(), r3.getDebug());     // Catch: Throwable -> L19
    L21:
        int r5 = initStatus;     // Catch: Throwable -> L9
        monitor-exit(ByteHook.class);
        return r5;
    L20:
        initStatus = 101;     // Catch: Throwable -> L9
        goto L21
    L16:
        r3.getLibLoader().loadLibrary(libName);     // Catch: Throwable -> L24
        goto L30
    L25:
        initStatus = 100;     // Catch: Throwable -> L9
        return 100;
    }
}

package com.bytedance.android.bytehook;

/* JADX INFO: loaded from: classes3.dex */
public class ByteHook {
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

        public void setLibLoader(ILibLoader r1) {
            this.libLoader = r1;
        }

        public ILibLoader getLibLoader() {
            return this.libLoader;
        }

        public void setMode(int r1) {
            this.mode = r1;
        }

        public int getMode() {
            return this.mode;
        }

        public void setDebug(boolean r1) {
            this.debug = r1;
        }

        public boolean getDebug() {
            return this.debug;
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

        public ConfigBuilder setLibLoader(ILibLoader r1) {
            this.libLoader = r1;
            return this;
        }

        public ConfigBuilder setMode(Mode r1) {
            this.mode = r1.getValue();
            return this;
        }

        public ConfigBuilder setDebug(boolean r1) {
            this.debug = r1;
            return this;
        }

        public Config build() {
            Config r0 = new Config();
            r0.setLibLoader(this.libLoader);
            r0.setMode(this.mode);
            r0.setDebug(this.debug);
            return r0;
        }
    }

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode AUTOMATIC = null;
        public static final Mode MANUAL = null;
        private final int value;

        public static Mode valueOf(String r1) {
            return (Mode) Enum.valueOf(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

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

        int getValue() {
            return this.value;
        }
    }

    private static native String nativeGetRecords();

    private static native int nativeInit(int r0, boolean r1);

    private static native void nativeSetDebug(boolean r0);

    public ByteHook() {
    }

    static /* synthetic */ ILibLoader access$000() {
        return defaultLibLoader;
    }

    static /* synthetic */ int access$100() {
        return defaultMode;
    }

    static {
        defaultMode = Mode.AUTOMATIC.getValue();
    }

    public static int init() {
        if (inited == false) goto L7;
        return initStatus;
    L7:
        return init(new ConfigBuilder().build());
    }

    public static synchronized int init(Config r3) {
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
        if (r3.getLibLoader() != null) goto L14;
        System.loadLibrary(libName);     // Catch: Throwable -> L22
    L30:
        initStatus = nativeInit(r3.getMode(), r3.getDebug());     // Catch: Throwable -> L17
    L19:
        int r5 = initStatus;     // Catch: Throwable -> L26
        monitor-exit(ByteHook.class);
        return r5;
    L18:
        initStatus = 101;     // Catch: Throwable -> L26
        goto L19
    L14:
        r3.getLibLoader().loadLibrary(libName);     // Catch: Throwable -> L22
        goto L30
    L23:
        initStatus = 100;     // Catch: Throwable -> L26
        return 100;
    }

    public static void setDebug(boolean r1) {
        if (initStatus != 0) goto L6;
        nativeSetDebug(r1);
        return;
    }

    public static String getRecords() {
        if (initStatus == 0) goto L5;
        return null;
    L5:
        return nativeGetRecords();
    }
}

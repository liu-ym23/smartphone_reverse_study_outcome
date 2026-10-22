package com.bytedance.shadowhook;

import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class ShadowHook {
    private static final int ERRNO_INIT_EXCEPTION = 101;
    private static final int ERRNO_LOAD_LIBRARY_EXCEPTION = 100;
    private static final int ERRNO_OK = 0;
    private static final int ERRNO_PENDING = 1;
    private static final int ERRNO_UNINIT = 2;
    private static final boolean defaultDebuggable = false;
    private static final ILibLoader defaultLibLoader = null;
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

    /* JADX INFO: renamed from: com.bytedance.shadowhook.ShadowHook$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem = null;

        static {
            int[] r0 = new int[RecordItem.values().length];
            $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem = r0;
            r0[RecordItem.TIMESTAMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.CALLER_LIB_NAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.OP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.LIB_NAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.SYM_NAME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.SYM_ADDR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.NEW_ADDR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.BACKUP_LEN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.ERRNO.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.STUB.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static class Config {
        private boolean debuggable;
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

        public void setDebuggable(boolean r1) {
            this.debuggable = r1;
        }

        public boolean getDebuggable() {
            return this.debuggable;
        }
    }

    public static class ConfigBuilder {
        private boolean debuggable;
        private ILibLoader libLoader;
        private int mode;

        public ConfigBuilder() {
            this.libLoader = ShadowHook.access$000();
            this.mode = ShadowHook.access$100();
            this.debuggable = false;
        }

        public ConfigBuilder setLibLoader(ILibLoader r1) {
            this.libLoader = r1;
            return this;
        }

        public ConfigBuilder setMode(Mode r1) {
            this.mode = r1.getValue();
            return this;
        }

        public ConfigBuilder setDebuggable(boolean r1) {
            this.debuggable = r1;
            return this;
        }

        public Config build() {
            Config r0 = new Config();
            r0.setLibLoader(this.libLoader);
            r0.setMode(this.mode);
            r0.setDebuggable(this.debuggable);
            return r0;
        }
    }

    public interface ILibLoader {
        void loadLibrary(String r1);
    }

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode SHARED = null;
        public static final Mode UNIQUE = null;
        private final int value;

        public static Mode valueOf(String r1) {
            return (Mode) Enum.valueOf(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        static {
            Mode r0 = new Mode("SHARED", 0, 0);
            SHARED = r0;
            Mode r1 = new Mode("UNIQUE", 1, 1);
            UNIQUE = r1;
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

    public static final enum RecordItem extends Enum<RecordItem> {
        private static final /* synthetic */ RecordItem[] $VALUES = null;
        public static final RecordItem BACKUP_LEN = null;
        public static final RecordItem CALLER_LIB_NAME = null;
        public static final RecordItem ERRNO = null;
        public static final RecordItem LIB_NAME = null;
        public static final RecordItem NEW_ADDR = null;
        public static final RecordItem OP = null;
        public static final RecordItem STUB = null;
        public static final RecordItem SYM_ADDR = null;
        public static final RecordItem SYM_NAME = null;
        public static final RecordItem TIMESTAMP = null;

        private RecordItem(String r1, int r2) {
            super(r1, r2);
        }

        public static RecordItem valueOf(String r1) {
            return (RecordItem) Enum.valueOf(RecordItem.class, r1);
        }

        public static RecordItem[] values() {
            return (RecordItem[]) $VALUES.clone();
        }

        static {
            RecordItem r0 = new RecordItem("TIMESTAMP", 0);
            TIMESTAMP = r0;
            RecordItem r1 = new RecordItem("CALLER_LIB_NAME", 1);
            CALLER_LIB_NAME = r1;
            RecordItem r3 = new RecordItem("OP", 2);
            OP = r3;
            RecordItem r5 = new RecordItem("LIB_NAME", 3);
            LIB_NAME = r5;
            RecordItem r7 = new RecordItem("SYM_NAME", 4);
            SYM_NAME = r7;
            RecordItem r9 = new RecordItem("SYM_ADDR", 5);
            SYM_ADDR = r9;
            RecordItem r11 = new RecordItem("NEW_ADDR", 6);
            NEW_ADDR = r11;
            RecordItem r13 = new RecordItem("BACKUP_LEN", 7);
            BACKUP_LEN = r13;
            RecordItem r15 = new RecordItem("ERRNO", 8);
            ERRNO = r15;
            RecordItem r14 = new RecordItem("STUB", 9);
            STUB = r14;
            $VALUES = new RecordItem[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        }
    }

    private static native String nativeGetArch();

    private static native int nativeGetInitErrno();

    private static native String nativeGetRecords(int r0);

    private static native int nativeInit(int r0, boolean r1);

    private static native void nativeSetDebuggable(boolean r0);

    private static native String nativeToErrmsg(int r0);

    public ShadowHook() {
    }

    static /* synthetic */ ILibLoader access$000() {
        return defaultLibLoader;
    }

    static /* synthetic */ int access$100() {
        return defaultMode;
    }

    static {
        defaultMode = Mode.SHARED.getValue();
    }

    public static int init() {
        if (inited == false) goto L7;
        return initErrno;
    L7:
        return init(new ConfigBuilder().build());
    }

    public static synchronized int init(Config r5) {
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
        initErrno = nativeInit(r5.getMode(), r5.getDebuggable());     // Catch: Throwable -> L17
    L19:
        initCostMs = System.currentTimeMillis() - r1;     // Catch: Throwable -> L22
        int r8 = initErrno;     // Catch: Throwable -> L22
        monitor-exit(ShadowHook.class);
        return r8;
    L18:
        initErrno = 101;     // Catch: Throwable -> L22
        goto L19
    }

    public static int getInitErrno() {
        return initErrno;
    }

    public static long getInitCostMs() {
        return initCostMs;
    }

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

    public static String getRecords(RecordItem... r5) {
        if (isInitedOk() == false) goto L24;
        int r0 = r5.length;
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r1 >= r0) goto L20;
        switch(AnonymousClass1.$SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[r5[r1].ordinal()]) {
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

    public static String getArch() {
        if (isInitedOk() == true) goto L5;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L5:
        return nativeGetArch();
    }

    private static boolean loadLibrary(Config r2) {
        if (r2 != null) goto L13;
    L8:
        System.loadLibrary(libName);     // Catch: Throwable -> L11
        return true;
    L11:
        return false;
    L13:
        if (r2.getLibLoader() == null) goto L8;
        r2.getLibLoader().loadLibrary(libName);     // Catch: Throwable -> L11
        return true;
    }

    private static boolean loadLibrary() {
        return loadLibrary(null);
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
}

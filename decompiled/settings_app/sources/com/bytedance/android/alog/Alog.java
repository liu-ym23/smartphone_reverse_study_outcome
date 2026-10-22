package com.bytedance.android.alog;

import android.content.Context;
import android.text.TextUtils;
import com.android.settingslib.accessibility.AccessibilityUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class Alog {
    public static final int LEVEL_ALL = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_SILENT = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static final int defaultAsymCrypt = 0;
    private static final int defaultCacheFileSizeEach = 65536;
    private static final int defaultCacheFileSizeTotal = 196608;
    private static final int defaultCompress = 0;
    private static final String defaultInstanceName = "default";
    private static final int defaultLevel = 0;
    private static final int defaultLogFileExpDays = 7;
    private static final int defaultLogFileSizeEach = 2097152;
    private static final int defaultLogFileSizeTotal = 20971520;
    private static final int defaultMode = 0;
    private static final int defaultPrefixFormat = 0;
    private static final String defaultServerPublicKey = "b012e20c9aab1cb5257aca2069cb79a9339b3a2224f771c78d64972137936eaf0b2f7ebd8d46c2607e1d7fe7723d40b147b8ecfa8fe2eaeee05210c75822381a";
    private static final String defaultSubFolder = "/alog";
    private static final int defaultSymCrypt = 0;
    private static final boolean defaultSyslog = false;
    private static final int defaultTimeFormat = 0;
    private static boolean inited = false;
    private static final ArrayList<String> instanceNames = null;
    private static final String libName = "alog";
    private int cacheFileCount;
    private String cacheFileDir;
    private int cacheFileSizeEach;
    private Context ctx;
    private String instanceName;
    private int level;
    private String logFileDir;
    private String processName;
    private long ref;

    public static final enum AsymCrypt extends Enum<AsymCrypt> {
        private static final /* synthetic */ AsymCrypt[] $VALUES = null;
        public static final AsymCrypt EC_SECP256K1 = null;
        public static final AsymCrypt EC_SECP256R1 = null;
        public static final AsymCrypt NONE = null;
        private final int value;

        public static AsymCrypt valueOf(String r1) {
            return (AsymCrypt) Enum.valueOf(AsymCrypt.class, r1);
        }

        public static AsymCrypt[] values() {
            return (AsymCrypt[]) $VALUES.clone();
        }

        static {
            AsymCrypt r0 = new AsymCrypt("NONE", 0, 0);
            NONE = r0;
            AsymCrypt r1 = new AsymCrypt("EC_SECP256K1", 1, 1);
            EC_SECP256K1 = r1;
            AsymCrypt r3 = new AsymCrypt("EC_SECP256R1", 2, 2);
            EC_SECP256R1 = r3;
            $VALUES = new AsymCrypt[]{r0, r1, r3};
        }

        private AsymCrypt(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        int getValue() {
            return this.value;
        }
    }

    public static class Builder {
        private String appVersion;
        private int asymCrypt;
        private String cacheFileDir;
        private int cacheFileSizeEach;
        private int cacheFileSizeTotal;
        private int compress;
        private Context ctx;
        private String instanceName;
        private int level;
        private String logFileDir;
        private int logFileExpDays;
        private int logFileSizeEach;
        private int logFileSizeTotal;
        private int mode;
        private int prefixFormat;
        private String serverPublicKey;
        private int symCrypt;
        private boolean syslog;
        private int timeFormat;

        public Builder(Context r3) {
            this.level = 0;
            this.syslog = false;
            this.instanceName = null;
            this.logFileDir = null;
            this.logFileSizeEach = 2097152;
            this.logFileSizeTotal = Alog.defaultLogFileSizeTotal;
            this.logFileExpDays = 7;
            this.cacheFileDir = null;
            this.cacheFileSizeEach = 65536;
            this.cacheFileSizeTotal = 196608;
            this.appVersion = null;
            this.mode = Alog.access$000();
            this.timeFormat = Alog.access$100();
            this.prefixFormat = Alog.access$200();
            this.compress = Alog.access$300();
            this.symCrypt = Alog.access$400();
            this.asymCrypt = Alog.access$500();
            this.serverPublicKey = Alog.defaultServerPublicKey;
            Context r0 = r3.getApplicationContext();
            if (r0 == null) goto L5;
            r3 = r0;
        L5:
            this.ctx = r3;
        }

        public Builder setLevel(int r1) {
            this.level = r1;
            return this;
        }

        public Builder setSyslog(boolean r1) {
            this.syslog = r1;
            return this;
        }

        public Builder setInstanceName(String r4) {
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
            this.instanceName = r4;
            goto L13
        }

        public Builder setLogFileDir(String r1) {
            this.logFileDir = r1;
            return this;
        }

        public Builder setLogFileSizeEach(int r1) {
            this.logFileSizeEach = r1;
            return this;
        }

        public Builder setLogFileSizeTotal(int r1) {
            this.logFileSizeTotal = r1;
            return this;
        }

        public Builder setLogFileExpDays(int r1) {
            this.logFileExpDays = r1;
            return this;
        }

        public Builder setCacheFileDir(String r1) {
            this.cacheFileDir = r1;
            return this;
        }

        public Builder setCacheFileSizeEach(int r1) {
            this.cacheFileSizeEach = r1;
            return this;
        }

        public Builder setCacheFileSizeTotal(int r1) {
            this.cacheFileSizeTotal = r1;
            return this;
        }

        public Builder setAppVersion(String r1) {
            this.appVersion = r1;
            return this;
        }

        public Builder setMode(Mode r1) {
            this.mode = r1.getValue();
            return this;
        }

        public Builder setTimeFormat(TimeFormat r1) {
            this.timeFormat = r1.getValue();
            return this;
        }

        public Builder setPrefixFormat(PrefixFormat r1) {
            this.prefixFormat = r1.getValue();
            return this;
        }

        public Builder setCompress(Compress r1) {
            this.compress = r1.getValue();
            return this;
        }

        public Builder setSymCrypt(SymCrypt r1) {
            this.symCrypt = r1.getValue();
            return this;
        }

        public Builder setAsymCrypt(AsymCrypt r1) {
            this.asymCrypt = r1.getValue();
            return this;
        }

        public Builder setServerPublicKey(String r1) {
            this.serverPublicKey = r1;
            return this;
        }

        public Alog build() {
            if (this.instanceName != null) goto L5;
            this.instanceName = "default";
        L5:
            ArrayList r1 = Alog.access$600();
            monitor-enter(r1);
            Iterator r2 = Alog.access$600().iterator();     // Catch: Throwable -> L36
        L9:
            if (r2.hasNext() == false) goto L14;
            if (((String) r2.next()).equals(this.instanceName) == false) goto L9;
            monitor-exit(r1);     // Catch: Throwable -> L36
            return null;
        L14:
            Alog.access$600().add(this.instanceName);     // Catch: Throwable -> L36
            monitor-exit(r1);     // Catch: Throwable -> L36
            if (this.logFileDir != null) goto L23;
            File r3 = this.ctx.getExternalFilesDir(null);
            if (r3 == null) goto L21;
            this.logFileDir = r3.getPath() + Alog.defaultSubFolder;
            goto L23
        L21:
            this.logFileDir = this.ctx.getFilesDir() + Alog.defaultSubFolder;
        L23:
            if (this.cacheFileDir != null) goto L26;
            this.cacheFileDir = this.ctx.getFilesDir() + Alog.defaultSubFolder;
        L26:
            if (this.appVersion != null) goto L28;
            this.appVersion = Util.getAppVersion(this.ctx);
        L28:
            int r4 = (this.cacheFileSizeEach / 4096) * 4096;
            this.cacheFileSizeEach = r4;
            int r5 = (this.cacheFileSizeTotal / 4096) * 4096;
            this.cacheFileSizeTotal = r5;
            if (r4 >= 4096) goto L31;
            this.cacheFileSizeEach = 4096;
        L31:
            int r6 = this.cacheFileSizeEach;
            if (r5 >= (r6 * 2)) goto L35;
            this.cacheFileSizeTotal = r6 * 2;
        L35:
            return new Alog(this.ctx, this.level, this.syslog, this.instanceName, this.logFileDir, this.logFileSizeEach, this.logFileSizeTotal, this.logFileExpDays, this.cacheFileDir, this.cacheFileSizeEach, this.cacheFileSizeTotal, this.appVersion, this.mode, this.timeFormat, this.prefixFormat, this.compress, this.symCrypt, this.asymCrypt, this.serverPublicKey);
        L36:
            th = move-exception;
            throw th;
        }
    }

    public static final enum Compress extends Enum<Compress> {
        private static final /* synthetic */ Compress[] $VALUES = null;
        public static final Compress NONE = null;
        public static final Compress ZLIB = null;
        public static final Compress ZSTD = null;
        private final int value;

        public static Compress valueOf(String r1) {
            return (Compress) Enum.valueOf(Compress.class, r1);
        }

        public static Compress[] values() {
            return (Compress[]) $VALUES.clone();
        }

        static {
            Compress r0 = new Compress("NONE", 0, 0);
            NONE = r0;
            Compress r1 = new Compress("ZLIB", 1, 1);
            ZLIB = r1;
            Compress r3 = new Compress("ZSTD", 2, 2);
            ZSTD = r3;
            $VALUES = new Compress[]{r0, r1, r3};
        }

        private Compress(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        int getValue() {
            return this.value;
        }
    }

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode SAFE = null;
        public static final Mode SPEED = null;
        private final int value;

        public static Mode valueOf(String r1) {
            return (Mode) Enum.valueOf(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        static {
            Mode r0 = new Mode("SPEED", 0, 0);
            SPEED = r0;
            Mode r1 = new Mode("SAFE", 1, 1);
            SAFE = r1;
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

    public static final enum PrefixFormat extends Enum<PrefixFormat> {
        private static final /* synthetic */ PrefixFormat[] $VALUES = null;
        public static final PrefixFormat DEFAULT = null;
        public static final PrefixFormat LEGACY = null;
        private final int value;

        public static PrefixFormat valueOf(String r1) {
            return (PrefixFormat) Enum.valueOf(PrefixFormat.class, r1);
        }

        public static PrefixFormat[] values() {
            return (PrefixFormat[]) $VALUES.clone();
        }

        static {
            PrefixFormat r0 = new PrefixFormat("DEFAULT", 0, 0);
            DEFAULT = r0;
            PrefixFormat r1 = new PrefixFormat("LEGACY", 1, 1);
            LEGACY = r1;
            $VALUES = new PrefixFormat[]{r0, r1};
        }

        private PrefixFormat(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        int getValue() {
            return this.value;
        }
    }

    public static final enum SymCrypt extends Enum<SymCrypt> {
        private static final /* synthetic */ SymCrypt[] $VALUES = null;
        public static final SymCrypt NONE = null;
        public static final SymCrypt TEA_16 = null;
        public static final SymCrypt TEA_32 = null;
        public static final SymCrypt TEA_64 = null;
        private final int value;

        public static SymCrypt valueOf(String r1) {
            return (SymCrypt) Enum.valueOf(SymCrypt.class, r1);
        }

        public static SymCrypt[] values() {
            return (SymCrypt[]) $VALUES.clone();
        }

        static {
            SymCrypt r0 = new SymCrypt("NONE", 0, 0);
            NONE = r0;
            SymCrypt r1 = new SymCrypt("TEA_16", 1, 1);
            TEA_16 = r1;
            SymCrypt r3 = new SymCrypt("TEA_32", 2, 2);
            TEA_32 = r3;
            SymCrypt r5 = new SymCrypt("TEA_64", 3, 3);
            TEA_64 = r5;
            $VALUES = new SymCrypt[]{r0, r1, r3, r5};
        }

        private SymCrypt(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        int getValue() {
            return this.value;
        }
    }

    public static final enum TimeFormat extends Enum<TimeFormat> {
        private static final /* synthetic */ TimeFormat[] $VALUES = null;
        public static final TimeFormat ISO_8601 = null;
        public static final TimeFormat RAW = null;
        private final int value;

        public static TimeFormat valueOf(String r1) {
            return (TimeFormat) Enum.valueOf(TimeFormat.class, r1);
        }

        public static TimeFormat[] values() {
            return (TimeFormat[]) $VALUES.clone();
        }

        static {
            TimeFormat r0 = new TimeFormat("RAW", 0, 0);
            RAW = r0;
            TimeFormat r1 = new TimeFormat("ISO_8601", 1, 1);
            ISO_8601 = r1;
            $VALUES = new TimeFormat[]{r0, r1};
        }

        private TimeFormat(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        int getValue() {
            return this.value;
        }
    }

    private static native void nativeAsyncFlush(long r0);

    private static native long nativeCreate(int r0, boolean r1, String r2, String r3, int r4, int r5, int r6, String r7, int r8, int r9, String r10, int r11, int r12, int r13, int r14, int r15, int r16, String r17);

    private static native void nativeDestroy(long r0);

    private static native long nativeGetLegacyFlushFuncAddr();

    private static native long nativeGetLegacyGetLogFileDirFuncAddr();

    private static native long nativeGetLegacyWriteFuncAddr();

    private static native void nativeSetLevel(long r0, int r2);

    private static native void nativeSetSyslog(long r0, boolean r2);

    private static native void nativeSyncFlush(long r0);

    private static native void nativeTimedSyncFlush(long r0, int r2);

    private static native void nativeWrite(long r0, int r2, String r3, String r4);

    static /* synthetic */ int access$000() {
        return defaultMode;
    }

    static /* synthetic */ int access$100() {
        return defaultTimeFormat;
    }

    static /* synthetic */ int access$200() {
        return defaultPrefixFormat;
    }

    static /* synthetic */ int access$300() {
        return defaultCompress;
    }

    static /* synthetic */ int access$400() {
        return defaultSymCrypt;
    }

    static /* synthetic */ int access$500() {
        return defaultAsymCrypt;
    }

    static /* synthetic */ ArrayList access$600() {
        return instanceNames;
    }

    static {
        defaultMode = Mode.SAFE.getValue();
        defaultTimeFormat = TimeFormat.RAW.getValue();
        defaultPrefixFormat = PrefixFormat.DEFAULT.getValue();
        defaultCompress = Compress.ZSTD.getValue();
        defaultSymCrypt = SymCrypt.TEA_16.getValue();
        defaultAsymCrypt = AsymCrypt.EC_SECP256K1.getValue();
        instanceNames = new ArrayList();
        inited = false;
    }

    public static synchronized void init() {
        monitor-enter(Alog.class);
        init(null);     // Catch: Throwable -> L8
        monitor-exit(Alog.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(ILibLoader r2) {
        monitor-enter(Alog.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L8;
        monitor-exit(Alog.class);
        return;
    L8:
        if (r2 != null) goto L10;
        System.loadLibrary("alog");     // Catch: Throwable -> L14
    L11:
        inited = true;     // Catch: Throwable -> L14
        monitor-exit(Alog.class);
        return;
    L10:
        r2.loadLibrary("alog");     // Catch: Throwable -> L14
        goto L11
    }

    public Alog(Context r7, int r8, boolean r9, String r10, String r11, int r12, int r13, int r14, String r15, int r16, int r17, String r18, int r19, int r20, int r21, int r22, int r23, int r24, String r25) {
        this.ctx = r7;
        this.level = r8;
        this.logFileDir = r11;
        this.cacheFileDir = r15;
        this.cacheFileSizeEach = r16;
        this.cacheFileCount = r17 / r16;
        this.processName = null;
        this.instanceName = r10;
        this.ref = nativeCreate(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
    }

    public void close() {
        monitor-enter(this);
        long r0 = this.ref;     // Catch: Throwable -> L8
        if (r0 <= 0) goto L6;
        this.ctx = null;     // Catch: Throwable -> L8
        this.level = 6;     // Catch: Throwable -> L8
        nativeDestroy(r0);     // Catch: Throwable -> L8
        this.ref = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void finalize() throws Throwable {
        super.finalize();     // Catch: Throwable -> L5
        close();
        return;
    L5:
        th = move-exception;
        close();
        throw th;
    }

    public void write(int r5, String r6, String r7) {
        long r0 = this.ref;
        if (r0 > 0) goto L5;
        return;
    L5:
        if (r5 < this.level) goto L11;
        if (r6 == null) goto L12;
        if (r7 == null) goto L13;
        nativeWrite(r0, r5, r6, r7);
        return;
    L13:
        return;
    L12:
        return;
    }

    public void asyncFlush() {
        long r0 = this.ref;
        if (r0 <= 0) goto L6;
        nativeAsyncFlush(r0);
        return;
    }

    public void syncFlush() {
        long r0 = this.ref;
        if (r0 <= 0) goto L6;
        nativeSyncFlush(r0);
        return;
    }

    public void timedSyncFlush(int r5) {
        long r0 = this.ref;
        if (r0 <= 0) goto L6;
        nativeTimedSyncFlush(r0, r5);
        return;
    }

    public void setLevel(int r5) {
        long r0 = this.ref;
        if (r0 <= 0) goto L6;
        nativeSetLevel(r0, r5);
        return;
    }

    public void setSyslog(boolean r5) {
        long r0 = this.ref;
        if (r0 <= 0) goto L6;
        nativeSetSyslog(r0, r5);
        return;
    }

    public long getLegacyWriteFuncAddr() {
        if (this.ref > 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyWriteFuncAddr();
    }

    public long getLegacyFlushFuncAddr() {
        if (this.ref > 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyFlushFuncAddr();
    }

    public long getLegacyGetLogFileDirFuncAddr() {
        if (this.ref > 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyGetLogFileDirFuncAddr();
    }

    public void v(String r2, String r3) {
        write(0, r2, r3);
    }

    public void d(String r2, String r3) {
        write(1, r2, r3);
    }

    public void i(String r2, String r3) {
        write(2, r2, r3);
    }

    public void w(String r2, String r3) {
        write(3, r2, r3);
    }

    public void e(String r2, String r3) {
        write(4, r2, r3);
    }

    public void f(String r2, String r3) {
        write(5, r2, r3);
    }

    public File[] getLogs(long r8, long r10) {
        if (this.processName != null) goto L9;
        String r0 = Util.getProcessName(this.ctx);
        this.processName = r0;
        if (r0 != null) goto L9;
        return new File[0];
    L9:
        return FileManager.getLogs(this.logFileDir, this.processName, this.instanceName, r8, r10);
    }

    public File[] getLogs(String r8, String r9, long r10, long r12) {
        return FileManager.getLogs(this.logFileDir, r8, r9, r10, r12);
    }

    public static File[] getLogs(String r0, String r1, String r2, long r3, long r5) {
        return FileManager.getLogs(r0, r1, r2, r3, r5);
    }

    public String getStatus() {
        if (inited == true) goto L7;
        return "not inited";
    L7:
        if (this.processName != null) goto L9;
        this.processName = Util.getProcessName(this.ctx);
    L9:
        String r1 = this.processName;
        if (r1 != null) goto L13;
        return "get process name failed";
    L13:
        String r2 = r1.replace(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR, '-');
        File r3 = new File(this.cacheFileDir);
        if (r3.exists() == true) goto L17;
        return "cache dir not exists";
    L17:
        File[] r4 = r3.listFiles();
        if (r4 != null) goto L21;
        return "cache dir is empty";
    L21:
        String r5 = r2 + "__" + this.instanceName + ".alog.cache.guard";
        Pattern r6 = Pattern.compile("^" + Pattern.quote(r2) + "__" + Pattern.quote(this.instanceName) + "__\\d{5}\\.alog\\.cache$");
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
        r16 = r4;
        if (r13.getName().startsWith(r2 + "__" + this.instanceName + "__") == false) goto L29;
        if (r6.matcher(r13.getName()).find() == false) goto L29;
        r11 = r11 + 1;
        r15 = r6;
        r17 = r7;
        if (r13.length() < this.cacheFileSizeEach) goto L37;
        r12 = r12 + 1;
        goto L37
    L39:
        if (r9 >= 1) goto L42;
        android.util.Log.d("alog_trace", r5);
        android.util.Log.d("alog_trace", r3.getAbsolutePath());
        return "cache guard not exists";
    L42:
        if (r10 >= 1) goto L45;
        return "cache guard size insufficiently";
    L45:
        int r14 = this.cacheFileCount;
        if (r11 >= r14) goto L49;
        return "cache block count insufficiently";
    L49:
        if (r12 >= r14) goto L52;
        return "cache block size insufficiently";
    L52:
        File r18 = new File(this.logFileDir);
        if (r18.exists() == true) goto L56;
        return "log dir not exists";
    L56:
        final Pattern r19 = Pattern.compile("^\\d{4}_\\d{2}_\\d{2}_\\d+__" + Pattern.quote(r2) + "__" + Pattern.quote(this.instanceName) + "\\.alog\\.hot$");
        File[] r0 = r18.listFiles(new AnonymousClass1(this, r19));
        if (r0 != null) goto L59;
        return "no log file for current process and instance";
    L59:
        if (r0.length == 0) goto L69;
        return "OK";
    L69:
        return "no log file for current process and instance";
    }
}

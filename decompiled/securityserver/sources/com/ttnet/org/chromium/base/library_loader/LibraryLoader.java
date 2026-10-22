package com.ttnet.org.chromium.base.library_loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.system.Os;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bytedance.librarian.LibrarianImpl;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.ttnet.org.chromium.base.CommandLine;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.JNIUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.StrictModeContext;
import com.ttnet.org.chromium.base.TimeUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import com.ttnet.org.chromium.base.metrics.UmaRecorderHolder;
import com.ttnet.org.chromium.build.BuildConfig;
import com.ttnet.org.chromium.build.NativeLibraries;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
public class LibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean ALLOW_CHROMIUM_LINKER_IN_ZYGOTE = true;
    private static final String BACKGROUND_THREAD_POOL_KEY = "background_thread_pool_enabled";
    static final boolean DEBUG = false;
    private static final int DEFAULT_REACHED_CODE_SAMPLING_INTERVAL_US = 10000;
    private static final String DEPRECATED_REACHED_CODE_PROFILER_KEY = "reached_code_profiler_enabled";
    private static final String REACHED_CODE_SAMPLING_INTERVAL_KEY = "reached_code_sampling_interval";
    private static final String TAG = "LibraryLoader";
    private static boolean sBrowserStartupBlockedForTesting;
    private static LibraryLoader sInstance;

    @GuardedBy
    private boolean mCommandLineSwitched;
    private boolean mConfigurationSet;
    private boolean mFallbackToSystemLinker;
    private volatile boolean mInitialized;

    @GuardedBy
    private NativeLibraryPreloader mLibraryPreloader;

    @GuardedBy
    private boolean mLibraryPreloaderCalled;
    private int mLibraryProcessType;

    @GuardedBy
    private Linker mLinker;
    private volatile int mLoadState;

    @GuardedBy
    private boolean mLoadedByZygote;
    private final Object mLock;
    private final MultiProcessMediator mMediator;
    private final Object mNonMainDexLock;
    private boolean mUseChromiumLinker;
    private boolean mUseModernLinker;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CreatedIn {
        public static final int CHILD_WITHOUT_ZYGOTE = 2;
        public static final int MAIN = 0;
        public static final int ZYGOTE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadState {
        public static final int LOADED = 2;
        public static final int MAIN_DEX_LOADED = 1;
        public static final int NOT_LOADED = 0;
    }

    public class MultiProcessMediator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final String LINKER_HISTOGRAM_PREFIX = "ChromiumAndroidLinker.";
        private volatile int mCreatedIn;
        private volatile boolean mInitDone;
        private long mLoadAddress;
        final /* synthetic */ LibraryLoader this$0;

        public MultiProcessMediator(LibraryLoader r1) {
            this.this$0 = r1;
            this.mCreatedIn = 0;
        }

        public static /* synthetic */ void access$500(MultiProcessMediator r0) {
            r0.recordLinkerHistogramsAfterLibraryLoad();
        }

        public static /* synthetic */ void access$600(MultiProcessMediator r0, long r1) {
            r0.recordLoadTimeHistogram(r1);
        }

        private String creationAsString() {
            int r1 = this.mCreatedIn;
            if (r1 != 0) goto L5;
            return "Browser";
        L5:
            if (r1 != 1) goto L7;
            return "Zygote";
        L7:
            if (r1 == 2) goto L10;
            return "";
        L10:
            return "Child";
        }

        private long getLoadAddress() {
            Object r0 = LibraryLoader.access$000(this.this$0);
            monitor-enter(r0);
            long r1 = this.mLoadAddress;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        private void recordLinkerHistogramsAfterLibraryLoad() {
            if (LibraryLoader.access$100(this.this$0) == true) goto L5;
            return;
        L5:
            LibraryLoader.access$200(this.this$0).recordHistograms(creationAsString());
        }

        private void recordLoadTimeHistogram(long r3) {
            RecordHistogram.recordTimesHistogram(LINKER_HISTOGRAM_PREFIX + creationAsString() + "LoadTime2", r3);
        }

        public void ensureInitializedInMainProcess() {
            if (this.mInitDone == false) goto L6;
            return;
        L6:
            if (LibraryLoader.access$100(this.this$0) == false) goto L12;
            boolean r0 = LibraryLoader.mainProcessIntendsToProvideRelroFd();
            if (r0 == false) goto L10;
            int r2 = 2;
        L11:
            LibraryLoader.access$200(this.this$0).ensureInitialized(r0, r2, 0);
            goto L12
        L10:
            r2 = 0;
        L12:
            this.mCreatedIn = 0;
            this.mInitDone = true;
        }

        public void initInAppZygote() {
            if (LibraryLoader.access$100(this.this$0) == true) goto L5;
        L7:
            LibraryLoader.access$302(this.this$0, true);
        L8:
            this.mCreatedIn = 1;
            return;
        L5:
            if (LibraryLoader.mainProcessIntendsToProvideRelroFd() == true) goto L7;
            LibraryLoader.access$200(this.this$0).ensureInitialized(true, 0, 0);
            goto L8
        }

        public void initInChildProcess() {
            if (LibraryLoader.access$100(this.this$0) == true) goto L7;
            this.mInitDone = true;
            return;
        L7:
            if (LibraryLoader.mainProcessIntendsToProvideRelroFd() == false) goto L10;
            LibraryLoader.access$200(this.this$0).ensureInitialized(false, 1, getLoadAddress());
        L17:
            if (this.mCreatedIn == 1) goto L19;
            this.mCreatedIn = 2;
        L19:
            this.mInitDone = true;
            return;
        L10:
            if (this.this$0.isLoadedByZygote() == true) goto L17;
            if (this.mCreatedIn != 1) goto L15;
            LibraryLoader.access$200(this.this$0).ensureInitialized(false, 1, getLoadAddress());
            goto L17
        L15:
            LibraryLoader.access$200(this.this$0).ensureInitialized(false, 0, getLoadAddress());
            goto L17
        }

        public void putLoadAddressToBundle(Bundle r2) {
            if (LibraryLoader.access$100(this.this$0) == false) goto L6;
            LibraryLoader.access$200(this.this$0).putLoadAddressToBundle(r2);
            return;
        }

        public void putSharedRelrosToBundle(Bundle r2) {
            if (LibraryLoader.access$100(this.this$0) == false) goto L6;
            LibraryLoader.access$200(this.this$0).putSharedRelrosToBundle(r2);
            return;
        }

        public void recordLoadThreadTimeHistogram(long r3) {
            RecordHistogram.recordTimesHistogram(LINKER_HISTOGRAM_PREFIX + creationAsString() + "ThreadLoadTime", r3);
        }

        public void takeLoadAddressFromBundle(Bundle r3) {
            this.mLoadAddress = Linker.extractLoadAddressFromBundle(r3);
        }

        public void takeSharedRelrosFromBundle(Bundle r2) {
            if (LibraryLoader.access$100(this.this$0) == false) goto L6;
            LibraryLoader.access$200(this.this$0).takeSharedRelrosFromBundle(r2);
            return;
        }
    }

    public interface Natives {
        boolean libraryLoaded(int r1);

        void registerNonMainDexJni();
    }

    static {
        sInstance = new LibraryLoader();
    }

    @VisibleForTesting
    public LibraryLoader() {
        this.mNonMainDexLock = new Object();
        this.mMediator = new MultiProcessMediator(this);
        this.mLock = new Object();
    }

    public static /* synthetic */ Object access$000(LibraryLoader r0) {
        return r0.mLock;
    }

    public static /* synthetic */ boolean access$100(LibraryLoader r0) {
        return r0.useChromiumLinker();
    }

    public static /* synthetic */ Linker access$200(LibraryLoader r0) {
        return r0.getLinker();
    }

    public static /* synthetic */ boolean access$302(LibraryLoader r0, boolean r1) {
        r0.mFallbackToSystemLinker = r1;
        return r1;
    }

    public static /* synthetic */ int access$400(LibraryLoader r0) {
        return r0.mLoadState;
    }

    @GuardedBy
    private void ensureCommandLineSwitchedAlreadyLocked() {
        if (this.mCommandLineSwitched == false) goto L5;
        return;
    L5:
        CommandLine.enableNativeProxy();
        this.mCommandLineSwitched = true;
    }

    private boolean forceSystemLinker() {
        if (this.mUseChromiumLinker == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mUseModernLinker == true) goto L7;
        return true;
    }

    public static LibraryLoader getInstance() {
        return sInstance;
    }

    private Linker getLinker() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mLinker == null) goto L7;
    L17:
        Linker r4 = this.mLinker;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r4;
    L7:
        if (this.mUseModernLinker == false) goto L11;
        Linker r1 = new ModernLinker();     // Catch: Throwable -> L9
    L12:
        this.mLinker = r1;     // Catch: Throwable -> L9
        if (this.mUseModernLinker == false) goto L15;
        String r2 = "Using ModernLinker";
    L16:
        Log.i(TAG, r2, new Object[0]);     // Catch: Throwable -> L9
        goto L17
    L15:
        r2 = "Using LegacyLinker";
        goto L16
    L11:
        r1 = new LegacyLinker();     // Catch: Throwable -> L9
        goto L12
    }

    @VisibleForTesting
    public static int getReachedCodeSamplingIntervalUs() {
        StrictModeContext r0 = StrictModeContext.allowDiskReads();
    L13:
        th = move-exception;
        if (r0 != null) goto L20;
    L19:
        throw th;
    L20:
        r0.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    L4:
        if (ContextUtils.getAppSharedPreferences().getBoolean(DEPRECATED_REACHED_CODE_PROFILER_KEY, false) == false) goto L9;
        if (r0 == null) goto L24;
        r0.close();
        return 10000;
    L24:
        return 10000;
    L9:
        int r1 = ContextUtils.getAppSharedPreferences().getInt(REACHED_CODE_SAMPLING_INTERVAL_KEY, 0);     // Catch: Throwable -> L13
        if (r0 == null) goto L12;
        r0.close();
    L12:
        return r1;
    }

    @GuardedBy
    private void initializeAlreadyLocked() {
        if (this.mInitialized == false) goto L6;
        return;
    L6:
        if (this.mLibraryProcessType != 1) goto L13;
        int r0 = getReachedCodeSamplingIntervalUs();
        if (r0 <= 0) goto L11;
        CommandLine.getInstance().appendSwitch(BaseSwitches.ENABLE_REACHED_CODE_PROFILER);
        CommandLine.getInstance().appendSwitchWithValue(BaseSwitches.REACHED_CODE_SAMPLING_INTERVAL_US, Integer.toString(r0));
    L11:
        if (isBackgroundThreadPoolEnabled() == false) goto L13;
        CommandLine.getInstance().appendSwitch(BaseSwitches.ENABLE_BACKGROUND_THREAD_POOL);
    L13:
        ensureCommandLineSwitchedAlreadyLocked();
        if (LibraryLoaderJni.get().libraryLoaded(this.mLibraryProcessType) == false) goto L17;
        Log.i(TAG, "Successfully loaded native library", new Object[0]);
        UmaRecorderHolder.onLibraryLoaded();
        TraceEvent.onNativeTracingReady();
        this.mInitialized = true;
        return;
    L17:
        Log.e(TAG, "error calling LibraryLoaderJni.get().libraryLoaded", new Object[0]);
        throw new ProcessInitException(1);
    }

    @VisibleForTesting
    public static boolean isBackgroundThreadPoolEnabled() {
        StrictModeContext r0 = StrictModeContext.allowDiskReads();
        boolean r1 = ContextUtils.getAppSharedPreferences().getBoolean(BACKGROUND_THREAD_POOL_KEY, false);     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        r0.close();
    L6:
        return r1;
    L7:
        th = move-exception;
        if (r0 != null) goto L16;
    L13:
        throw th;
    L16:
        r0.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public static boolean isBrowserProcessStartupBlockedForTesting() {
        return sBrowserStartupBlockedForTesting;
    }

    private static boolean isInZipFile() {
        return NativeLibraries.sUseLibraryInZipFile;
    }

    private void loadWithChromiumLinker(ApplicationInfo r4, String r5) {
        Linker r0 = getLinker();
        if (isInZipFile() == false) goto L5;
        String r6 = r4.sourceDir;
        r0.setApkFilePath(r6);
        Log.i(TAG, "Loading %s from within %s", new Object[]{r5, r6});
    L6:
        r0.loadLibrary(r5);
        MultiProcessMediator.access$500(getMediator());
        return;
    L5:
        Log.i(TAG, "Loading %s", new Object[]{r5});
        goto L6
    }

    @GuardedBy
    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private void loadWithSystemLinkerAlreadyLocked(ApplicationInfo r9, boolean r10) {
        setEnvForNative();
        preloadAlreadyLocked(r9.packageName, r10);
        String[] r11 = NativeLibraries.LIBRARIES;
        int r0 = r11.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L14;
        String r3 = r11[r2];
        boolean r4 = !forceSystemLinker();
        if (isInZipFile() == false) goto L12;
        if (r4 == true) goto L12;
        boolean r5 = ApiHelperForM.isProcess64Bit();
        String r6 = r9.sourceDir;
        boolean r7 = forceSystemLinker();
        StringBuilder r8 = a.a.t(r6, "!/");
        r8.append(makeLibraryPathInZipFile(r3, r7, r5));
        String r12 = r8.toString();
        Log.i(TAG, "libraryName: %s", new Object[]{r12});
        if (r7 == false) goto L11;
        Log.w(TAG, "Forcing system linker, relocations will not be shared. This negatively impacts memory usage.", new Object[0]);
    L11:
        System.load(r12);
    L13:
        r2 = r2 + 1;
    L12:
        System.loadLibrary(r3);
        goto L13
    }

    private void logLinkersUsed() {
        Log.i(TAG, "Configuration: useChromiumLinker() = %b, mUseModernLinker = %b", new Object[]{Boolean.valueOf(useChromiumLinker()), Boolean.valueOf(this.mUseModernLinker)});
    }

    public static boolean mainProcessIntendsToProvideRelroFd() {
        return false;
    }

    @NonNull
    public static String makeLibraryPathInZipFile(String r2, boolean r3, boolean r4) {
        int r0 = NativeLibraries.sCpuFamily;
        if (r0 != 1) goto L5;
        if (r4 == false) goto L18;
        String r5 = "arm64-v8a";
    L19:
        if (r3 == false) goto L21;
        String r6 = "crazy.";
    L22:
        Locale r1 = Locale.US;
        return "lib/" + r5 + LibrarianImpl.Constants.SEPARATOR + r6 + System.mapLibraryName(r2);
    L21:
        r6 = "";
        goto L22
    L18:
        r5 = "armeabi-v7a";
        goto L19
    L5:
        if (r0 != 2) goto L7;
        if (r4 == false) goto L15;
        r5 = "mips64";
        goto L19
    L15:
        r5 = "mips";
        goto L19
    L7:
        if (r0 != 3) goto L12;
        if (r4 == false) goto L10;
        r5 = "x86_64";
        goto L19
    L10:
        r5 = "x86";
        goto L19
    L12:
        throw new RuntimeException("Unknown CPU ABI for native libraries");
    }

    @GuardedBy
    private void preloadAlreadyLocked(String r3, boolean r4) {
        TraceEvent r5 = TraceEvent.scoped("LibraryLoader.preloadAlreadyLocked");
        NativeLibraryPreloader r0 = this.mLibraryPreloader;     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
    L11:
        if (r5 == null) goto L24;
        r5.close();
        return;
    L24:
        return;
    L6:
        if (this.mLibraryPreloaderCalled == true) goto L11;
        r0.loadLibrary(r3);     // Catch: Throwable -> L9
        this.mLibraryPreloaderCalled = true;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r5 != null) goto L20;
    L19:
        throw th;
    L20:
        r5.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    }

    public static void setBackgroundThreadPoolEnabledOnNextRuns(boolean r2) {
        ContextUtils.getAppSharedPreferences().edit().putBoolean(BACKGROUND_THREAD_POOL_KEY, r2).apply();
    }

    public static void setBrowserProcessStartupBlockedForTesting() {
        sBrowserStartupBlockedForTesting = true;
    }

    public static void setEnvForNative() {
        if (BuildConfig.IS_UBSAN == false) goto L11;
        Os.setenv("UBSAN_OPTIONS", "print_stacktrace=1 stack_trace_format='#%n pc %o %m' handle_segv=0 handle_sigbus=0 handle_sigfpe=0", true);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Log.w(TAG, "failed to set UBSAN_OPTIONS", new Object[]{e});
        return;
    }

    @VisibleForTesting
    public static void setLibraryLoaderForTesting(LibraryLoader r0) {
        sInstance = r0;
    }

    @GuardedBy
    private void setLinkerImplementationIfNeededAlreadyLocked() {
        if (this.mConfigurationSet == false) goto L5;
        return;
    L5:
        this.mUseChromiumLinker = NativeLibraries.sUseLinker;
        this.mUseModernLinker = NativeLibraries.sUseModernLinker;
        this.mConfigurationSet = true;
    }

    public static void setReachedCodeProfilerEnabledOnNextRuns(boolean r1, int r2) {
        if (r1 == false) goto L5;
        if (r2 != 0) goto L5;
        r2 = 10000;
    L7:
        SharedPreferences.Editor r3 = ContextUtils.getAppSharedPreferences().edit();
        r3.remove(DEPRECATED_REACHED_CODE_PROFILER_KEY);
        r3.putInt(REACHED_CODE_SAMPLING_INTERVAL_KEY, r2).apply();
        return;
    L5:
        if (r1 == true) goto L7;
        r2 = 0;
        goto L7
    }

    private boolean useChromiumLinker() {
        if (this.mUseChromiumLinker == true) goto L5;
    L7:
        return false;
    L5:
        if (forceSystemLinker() == true) goto L7;
        return true;
    }

    public void assertCompatibleProcessType(int r1) {
    }

    @CheckDiscard("")
    public void enableJniChecks() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        NativeLibraryLoadedStatus.setProvider(new AnonymousClass1(this));
    }

    public void ensureInitialized() {
        if (isInitialized() == false) goto L5;
        return;
    L5:
        ensureMainDexInitialized();
        loadNonMainDex();
    }

    public void ensureMainDexInitialized() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        loadMainDexAlreadyLocked(ContextUtils.getApplicationContext().getApplicationInfo(), false);     // Catch: Throwable -> L7
        initializeAlreadyLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final MultiProcessMediator getMediator() {
        return this.mMediator;
    }

    public void initialize() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        initializeAlreadyLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isInitialized() {
        if (this.mInitialized == true) goto L5;
    L7:
        return false;
    L5:
        if (isLoaded() == false) goto L7;
        return true;
    }

    public boolean isLoaded() {
        if (this.mLoadState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLoadedByZygote() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mLoadedByZygote;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @GuardedBy
    @VisibleForTesting
    public void loadMainDexAlreadyLocked(ApplicationInfo r6, boolean r7) {
        if (this.mLoadState < 1) goto L29;
        return;
    L29:
        TraceEvent r0 = TraceEvent.scoped("LibraryLoader.loadMainDexAlreadyLocked");     // Catch: UnsatisfiedLinkError -> L18
        setLinkerImplementationIfNeededAlreadyLocked();     // Catch: Throwable -> L11
        TimeUtils.UptimeMillisTimer r2 = new TimeUtils.UptimeMillisTimer();     // Catch: Throwable -> L11
        TimeUtils.CurrentThreadTimeMillisTimer r3 = new TimeUtils.CurrentThreadTimeMillisTimer();     // Catch: Throwable -> L11
        if (useChromiumLinker() == true) goto L9;
    L13:
        loadWithSystemLinkerAlreadyLocked(r6, r7);     // Catch: Throwable -> L11
    L14:
        long r8 = r2.getElapsedMillis();     // Catch: Throwable -> L11
        MultiProcessMediator.access$600(getMediator(), r8);     // Catch: Throwable -> L11
        getMediator().recordLoadThreadTimeHistogram(r3.getElapsedMillis());     // Catch: Throwable -> L11
        this.mLoadState = 1;     // Catch: Throwable -> L11
        if (r0 == null) goto L20;
        r0.close();     // Catch: UnsatisfiedLinkError -> L18
        return;
    L20:
        return;
    L9:
        if (this.mFallbackToSystemLinker == true) goto L13;
        loadWithChromiumLinker(r6, NativeLibraries.LIBRARIES[0]);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r0 != null) goto L30;
    L26:
        throw th;     // Catch: UnsatisfiedLinkError -> L18
    L30:
        r0.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: UnsatisfiedLinkError -> L18
    L18:
        e = move-exception;
        throw new ProcessInitException(2, e);
    }

    @VisibleForTesting
    public void loadNonMainDex() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            int r0 = r4.mLoadState
            r1 = 2
            if (r0 != r1) goto L6
            return
        L6:
            java.lang.Object r0 = r4.mNonMainDexLock
            monitor-enter(r0)
            int r2 = r4.mLoadState     // Catch: java.lang.Throwable -> Lf
            if (r2 != r1) goto L11
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lf
            return
        Lf:
            r4 = move-exception
            goto L3b
        L11:
            java.lang.String r2 = "LibraryLoader.loadNonMainDex"
            com.ttnet.org.chromium.base.TraceEvent r2 = com.ttnet.org.chromium.base.TraceEvent.scoped(r2)     // Catch: java.lang.Throwable -> Lf
            boolean r3 = com.ttnet.org.chromium.base.JNIUtils.isSelectiveJniRegistrationEnabled()     // Catch: java.lang.Throwable -> L25
            if (r3 != 0) goto L27
            com.ttnet.org.chromium.base.library_loader.LibraryLoader$Natives r3 = com.ttnet.org.chromium.base.library_loader.LibraryLoaderJni.get()     // Catch: java.lang.Throwable -> L25
            r3.registerNonMainDexJni()     // Catch: java.lang.Throwable -> L25
            goto L27
        L25:
            r4 = move-exception
            goto L30
        L27:
            r4.mLoadState = r1     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L2e
            r2.close()     // Catch: java.lang.Throwable -> Lf
        L2e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lf
            return
        L30:
            if (r2 == 0) goto L3a
            r2.close()     // Catch: java.lang.Throwable -> L36
            goto L3a
        L36:
            r1 = move-exception
            r4.addSuppressed(r1)     // Catch: java.lang.Throwable -> Lf
        L3a:
            throw r4     // Catch: java.lang.Throwable -> Lf
        L3b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lf
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ttnet.org.chromium.base.library_loader.LibraryLoader.loadNonMainDex():void");
    }

    public void loadNow() {
        loadNowOverrideApplicationContext(ContextUtils.getApplicationContext());
    }

    public void loadNowInZygote(ApplicationInfo r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        loadMainDexAlreadyLocked(r3, true);     // Catch: Throwable -> L8
        loadNonMainDex();     // Catch: Throwable -> L8
        this.mLoadedByZygote = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void loadNowOverrideApplicationContext(Context r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mLoadState != 0) goto L7;
    L13:
        loadMainDexAlreadyLocked(r3.getApplicationInfo(), false);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        loadNonMainDex();
        return;
    L7:
        if (r3 == ContextUtils.getApplicationContext()) goto L13;
        throw new IllegalStateException("Attempt to load again from alternate context.");     // Catch: Throwable -> L11
    }

    public void preloadNow() {
        preloadNowOverridePackageName(ContextUtils.getApplicationContext().getApplicationInfo().packageName);
    }

    public void preloadNowOverridePackageName(String r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        setLinkerImplementationIfNeededAlreadyLocked();     // Catch: Throwable -> L8
        if (useChromiumLinker() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        preloadAlreadyLocked(r3, false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void setLibrariesLoadedForNativeTests() {
        this.mLoadState = 2;
        this.mInitialized = true;
    }

    public void setLibraryProcessType(int r2) {
        int r0 = this.mLibraryProcessType;
        if (r2 != r0) goto L5;
        return;
    L5:
        if (r0 != 0) goto L9;
        this.mLibraryProcessType = r2;
        return;
    L9:
        throw new IllegalStateException(String.format("Trying to change the LibraryProcessType from %d to %d", new Object[]{Integer.valueOf(this.mLibraryProcessType), Integer.valueOf(r2)}));
    }

    public void setLinkerImplementation(boolean r1, boolean r2) {
        this.mUseChromiumLinker = r1;
        this.mUseModernLinker = r2;
        this.mConfigurationSet = true;
    }

    public void setNativeLibraryPreloader(NativeLibraryPreloader r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLibraryPreloader = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void switchCommandLineForWebView() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ensureCommandLineSwitchedAlreadyLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}

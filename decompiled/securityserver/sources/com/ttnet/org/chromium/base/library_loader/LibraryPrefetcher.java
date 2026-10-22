package com.ttnet.org.chromium.base.library_loader;

import com.bytedance.securityserver.b;
import com.ttnet.org.chromium.base.CommandLine;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.SysUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import com.ttnet.org.chromium.base.task.PostTask;
import com.ttnet.org.chromium.base.task.TaskTraits;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
public class LibraryPrefetcher {
    private static final String TAG = "LibraryPrefetcher";
    private static final AtomicBoolean sPrefetchLibraryHasBeenCalled = null;

    public interface Natives {
        void forkAndPrefetchNativeLibrary();

        int percentageOfResidentNativeLibraryCode();

        void periodicallyCollectResidency();
    }

    static {
        sPrefetchLibraryHasBeenCalled = new AtomicBoolean();
    }

    public LibraryPrefetcher() {
    }

    public static /* synthetic */ void a(boolean r0) {
        lambda$asyncPrefetchLibrariesToMemory$1(r0);
    }

    public static void asyncPrefetchLibrariesToMemory() {
        SysUtils.logPageFaultCountToTracing();
        final boolean r0 = sPrefetchLibraryHasBeenCalled.compareAndSet(false, true);
        if (r0 == true) goto L5;
    L8:
        PostTask.postTask(TaskTraits.USER_BLOCKING, new a(r0));
        return;
    L5:
        if (CommandLine.getInstance().hasSwitch("log-native-library-residency") == false) goto L8;
        new Thread(new b(5)).start();
    }

    public static /* synthetic */ void b() {
        lambda$asyncPrefetchLibrariesToMemory$0();
    }

    private static /* synthetic */ void lambda$asyncPrefetchLibrariesToMemory$0() {
        LibraryPrefetcherJni.get().periodicallyCollectResidency();
    }

    private static /* synthetic */ void lambda$asyncPrefetchLibrariesToMemory$1(boolean r4) {
        int r1 = LibraryPrefetcherJni.get().percentageOfResidentNativeLibraryCode();
        TraceEvent r2 = TraceEvent.scoped("LibraryPrefetcher.asyncPrefetchLibrariesToMemory", Integer.toString(r1));
        if (r4 == false) goto L10;
        if (r1 >= 90) goto L10;
        LibraryPrefetcherJni.get().forkAndPrefetchNativeLibrary();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (r2 != null) goto L28;
    L21:
        throw th;
    L28:
        r2.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);
    L10:
        if (r1 == (-1)) goto L22;
        if (r4 == false) goto L13;
        String r5 = ".ColdStartup";
    L14:
        RecordHistogram.recordPercentageHistogram("LibraryLoader.PercentageOfResidentCodeBeforePrefetch".concat(r5), r1);     // Catch: Throwable -> L7
        goto L22
    L13:
        r5 = ".WarmStartup";
    L22:
        if (r2 == null) goto L24;
        r2.close();
    L24:
        ContextUtils.getAppSharedPreferences().edit().remove("dont_prefetch_libraries").apply();
    }
}

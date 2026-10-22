package com.ttnet.org.chromium.base.library_loader;

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

    interface Natives {
        void forkAndPrefetchNativeLibrary();

        int percentageOfResidentNativeLibraryCode();

        void periodicallyCollectResidency();
    }

    static {
        sPrefetchLibraryHasBeenCalled = new AtomicBoolean();
    }

    public LibraryPrefetcher() {
    }

    static /* synthetic */ void a() {
        LibraryPrefetcherJni.get().periodicallyCollectResidency();
    }

    public static void asyncPrefetchLibrariesToMemory() {
        SysUtils.logPageFaultCountToTracing();
        final boolean r0 = sPrefetchLibraryHasBeenCalled.compareAndSet(false, true);
        if (r0 == true) goto L5;
    L8:
        PostTask.postTask(TaskTraits.USER_BLOCKING, new b(r0));
        return;
    L5:
        if (CommandLine.getInstance().hasSwitch("log-native-library-residency") == false) goto L8;
        new Thread(a.f12349f).start();
    }

    static /* synthetic */ void b(boolean r4) {
        int r0 = LibraryPrefetcherJni.get().percentageOfResidentNativeLibraryCode();
        TraceEvent r1 = TraceEvent.scoped("LibraryPrefetcher.asyncPrefetchLibrariesToMemory", Integer.toString(r0));
        if (r4 == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L13;
        LibraryPrefetcherJni.get().forkAndPrefetchNativeLibrary();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r1 != null) goto L32;
    L25:
        throw th;
    L32:
        r1.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);
    L13:
        if (r0 == (-1)) goto L26;
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L10
        r3.append("LibraryLoader.PercentageOfResidentCodeBeforePrefetch");     // Catch: Throwable -> L10
        if (r4 == false) goto L17;
        String r5 = ".ColdStartup";
    L18:
        r3.append(r5);     // Catch: Throwable -> L10
        RecordHistogram.recordPercentageHistogram(r3.toString(), r0);     // Catch: Throwable -> L10
        goto L26
    L17:
        r5 = ".WarmStartup";
    L26:
        if (r1 == null) goto L28;
        r1.close();
    L28:
        ContextUtils.getAppSharedPreferences().edit().remove("dont_prefetch_libraries").apply();
        return;
    L5:
        if (r0 >= 90) goto L7;
        r2 = true;
        goto L8
    }
}

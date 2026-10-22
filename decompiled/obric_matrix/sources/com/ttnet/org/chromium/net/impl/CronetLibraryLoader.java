package com.ttnet.org.chromium.net.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.net.NetworkChangeNotifier;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
@VisibleForTesting
public class CronetLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String LIBRARY_NAME = "sscronet";
    private static final String TAG = "CronetLibraryLoader";
    private static final HandlerThread sInitThread = null;
    private static volatile boolean sInitThreadInitDone;
    private static volatile boolean sLibraryLoaded;
    private static final Object sLoadLock = null;
    private static final ConditionVariable sWaitForLibLoad = null;

    interface Natives {
        void createNetworkChangeNotifierOnInitThread();

        void cronetInitOnInitThread();

        String getCronetVersion();
    }

    static {
        sLoadLock = new Object();
        sInitThread = new HandlerThread("CronetInit");
        sLibraryLoaded = false;
        sWaitForLibLoad = new ConditionVariable();
    }

    public CronetLibraryLoader() {
    }

    static void createNetworkChangeNotifierOnInitThread() {
        CronetLibraryLoaderJni.get().createNetworkChangeNotifierOnInitThread();
    }

    public static void ensureInitialized(Context r6, CronetEngineBuilderImpl r7) {
        Object r0 = sLoadLock;
        monitor-enter(r0);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (sInitThreadInitDone == true) goto L11;
        ContextUtils.initApplicationContext(r6);     // Catch: Throwable -> L29
        HandlerThread r8 = sInitThread;     // Catch: Throwable -> L29
        if (r8.isAlive() == true) goto L9;
        r8.start();     // Catch: Throwable -> L29
    L9:
        postToInitThread(new AnonymousClass1());     // Catch: Throwable -> L29
    L11:
        if (sLibraryLoaded == true) goto L27;
        TTCronetInitTimingInfo.sLoadCronetSoStart = System.nanoTime();     // Catch: Throwable -> L29
        loadCronetLibrary(r7);     // Catch: Throwable -> L29
        TTCronetInitTimingInfo.sLoadCronetSoEnd = System.nanoTime();     // Catch: Throwable -> L29
        String r9 = ImplVersion.getCronetVersion();     // Catch: Throwable -> L29
        if (r7 == null) goto L22;
        if (r7.optInit() == false) goto L22;
        if (r9.equals("107.0.5273.2") == false) goto L20;
    L24:
        sLibraryLoaded = true;     // Catch: Throwable -> L29
        sWaitForLibLoad.open();     // Catch: Throwable -> L29
        goto L27
    L20:
        throw new RuntimeException(String.format("Expected Cronet version number %s, actual version number %s.", new Object[]{r9, "107.0.5273.2"}));     // Catch: Throwable -> L29
    L22:
        if (r9.equals(CronetLibraryLoaderJni.get().getCronetVersion()) == false) goto L26;
        Log.i(TAG, "Cronet version: %s, arch: %s", new Object[]{r9, System.getProperty("os.arch")});     // Catch: Throwable -> L29
        goto L24
    L26:
        throw new RuntimeException(String.format("Expected Cronet version number %s, actual version number %s.", new Object[]{r9, CronetLibraryLoaderJni.get().getCronetVersion()}));     // Catch: Throwable -> L29
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L29
    }

    @CalledByNative
    private static void ensureInitializedFromNative() {
        Object r0 = sLoadLock;
        monitor-enter(r0);
        sLibraryLoaded = true;     // Catch: Throwable -> L9
        sWaitForLibLoad.open();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        ensureInitialized(ContextUtils.getApplicationContext(), null);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    static void ensureInitializedOnInitThread() {
        if (sInitThreadInitDone == false) goto L5;
        return;
    L5:
        TTCronetInitTimingInfo.sInitThreadStart = System.nanoTime();
        NetworkChangeNotifier.init();
        NetworkChangeNotifier.registerToReceiveNotificationsAlways();
        sWaitForLibLoad.block();
        CronetLibraryLoaderJni.get().cronetInitOnInitThread();
        sInitThreadInitDone = true;
        TTCronetInitTimingInfo.sInitThreadEnd = System.nanoTime();
    }

    @CalledByNative
    private static String getDefaultUserAgent() {
        return UserAgent.from(ContextUtils.getApplicationContext());
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private static void loadCronetLibrary(CronetEngineBuilderImpl r3) {
        String r0 = r3.getCronetSoPath();
        if (TextUtils.isEmpty(r0) == true) goto L11;
        File r1 = new File(r0);
        if (r1.exists() == false) goto L11;
        if (r1.isDirectory() == true) goto L11;
        Log.i(TAG, "cronet so load: %s", new Object[]{r0});
        System.load(r0);
        return;
    L11:
        if (r3.libraryLoader() == null) goto L13;
        r3.libraryLoader().loadLibrary(LIBRARY_NAME);
        return;
    L13:
        System.loadLibrary(LIBRARY_NAME);
    }

    private static boolean onInitThread() {
        if (sInitThread.getLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void postToInitThread(Runnable r2) {
        if (onInitThread() == false) goto L5;
        r2.run();
        return;
    L5:
        new Handler(sInitThread.getLooper()).post(r2);
    }

    @CalledByNative
    private static void setNetworkThreadPriorityOnNetworkThread(int r0) {
        Process.setThreadPriority(r0);
    }
}

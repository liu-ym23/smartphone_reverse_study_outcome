package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class StackLeakChecker {
    public static final long CHECK_INTERVAL_10_SEC = 10000000;
    private static final int LEAK_THREAD_THRESHOLD = 10;
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mCheckerEnabled = false;
    private static ArrayList<StackLeakItem> mLeakList = null;
    private static int mLeakThreadThreshold = 10;
    private static ArrayList<StackLeakListener> mListeners = null;
    private static long mStackCheckInterval = 60000000;

    public interface StackLeakListener {
        void onLeakReport(ArrayList<StackLeakItem> r1);
    }

    static {
        mLeakList = new ArrayList();
        mListeners = new ArrayList();
    }

    private StackLeakChecker() {
    }

    private static void addLeakItem(int r12, long r13, long r15, long r17, String r19, String r20) {
        mLeakList.add(new StackLeakItem(r12, r13, r15, r17, r19, r20));
    }

    public static synchronized void disableChecker() {
        monitor-enter(StackLeakChecker.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (mCheckerEnabled == false) goto L10;
        setEnable(false, 0, 0, 0, null);     // Catch: Throwable -> L8
    L10:
        monitor-exit(StackLeakChecker.class);
    }

    public static synchronized boolean enableChecker(Context r8, String[] r9) {
        monitor-enter(StackLeakChecker.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (mCheckerEnabled == false) goto L11;
        monitor-exit(StackLeakChecker.class);
        return true;
    L11:
        if (loadOptimizerOnNeed(r8) == true) goto L26;
        monitor-exit(StackLeakChecker.class);
        return false;
    L26:
        boolean r10 = setEnable(true, Build.VERSION.SDK_INT, mLeakThreadThreshold, mStackCheckInterval, r9);     // Catch: Throwable -> L15 UnsatisfiedLinkError -> L17
        mCheckerEnabled = r10;     // Catch: Throwable -> L15 UnsatisfiedLinkError -> L17
        monitor-exit(StackLeakChecker.class);
        return r10;
    L17:
        e = move-exception;
        Log.e(TAG, "UnsatisfiedLinkError", e);     // Catch: Throwable -> L15
        return false;
    }

    private static boolean loadOptimizerOnNeed(Context r0) {
        return false;
    }

    public static synchronized void registerStackLeakListener(StackLeakListener r2) {
        monitor-enter(StackLeakChecker.class);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(StackLeakChecker.class);
        return;
    L11:
        mListeners.add(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private static void reportLeak() {
        Iterator<StackLeakListener> r0 = mListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onLeakReport(mLeakList);
        goto L4
    L6:
        mLeakList.clear();
    }

    private static native boolean setEnable(boolean r0, int r1, int r2, long r3, String[] r5);

    public static synchronized void setInterval(int r7, long r8) {
        monitor-enter(StackLeakChecker.class);
        if (r7 <= 0) goto L6;
    L5:
        int r3 = r7;
        mLeakThreadThreshold = r3;     // Catch: Throwable -> L10
        if (r8 <= CHECK_INTERVAL_10_SEC) goto L12;
        long r4 = (r8 / CHECK_INTERVAL_10_SEC) * CHECK_INTERVAL_10_SEC;     // Catch: Throwable -> L10
    L13:
        mStackCheckInterval = r4;     // Catch: Throwable -> L10
        if (mCheckerEnabled == false) goto L16;
        setEnable(true, 0, r3, r4, null);     // Catch: Throwable -> L10
    L16:
        monitor-exit(StackLeakChecker.class);
        return;
    L12:
        r4 = 10000000;
    L10:
        th = move-exception;
        throw th;
    L6:
        r7 = 10;
        goto L5
    }
}

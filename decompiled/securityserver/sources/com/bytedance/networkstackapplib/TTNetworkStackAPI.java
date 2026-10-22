package com.bytedance.networkstackapplib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Process;
import java.io.PrintStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class TTNetworkStackAPI {
    public static final String CHECK_SERVER_ADDR = "8.8.8.8";
    public static final int ERROR_SDK_VERSION_NOT_SUPPORT = -99;
    public static final int MAX_CHECK_NETWORK_TIMEOUT = 100;
    public static final int NET_CAP_ERROR_NEED_CONTEXT = 3;
    public static final int NET_CAP_INVALIDATED = 1;
    public static final int NET_CAP_PARTAL = 2;
    public static final int NET_CAP_VALIDATED = 0;
    public static final int TYPE_ERROR_DENY_BY_FIREWALL = -2;
    public static final int TYPE_ERROR_NO_DEFAULT_ROUTE = -1;
    public static final int TYPE_ERROR_TOO_BUSY = -101;
    public static final int TYPE_ERROR_TRY_AGAIN = -100;
    public static final int TYPE_NO_ERROR = 0;
    private int mCheckErrorType;
    private final Object mCheckNetworkLock;
    ConnectivityManager mCm;
    private Context mContext;
    private boolean mDebugLog;
    private boolean mIsCheckingNetwork;
    private NetworkQualityCollect mNqc;

    public TTNetworkStackAPI(Context r3) {
        this.mCheckErrorType = 0;
        this.mIsCheckingNetwork = false;
        this.mCheckNetworkLock = new Object();
        this.mDebugLog = false;
        this.mCm = null;
        this.mNqc = null;
        this.mContext = r3;
        this.mNqc = NetworkQualityCollect.getInstance(r3);
    }

    public static /* synthetic */ Object access$000(TTNetworkStackAPI r0) {
        return r0.mCheckNetworkLock;
    }

    public static /* synthetic */ boolean access$102(TTNetworkStackAPI r0, boolean r1) {
        r0.mIsCheckingNetwork = r1;
        return r1;
    }

    public static /* synthetic */ int access$202(TTNetworkStackAPI r0, int r1) {
        r0.mCheckErrorType = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$300(TTNetworkStackAPI r0) {
        return r0.mDebugLog;
    }

    public int getDataLevel() {
        return this.mNqc.getDataLevel();
    }

    public String getDataType() {
        return this.mNqc.getDataType();
    }

    public boolean getDebugLogFeature() {
        return this.mDebugLog;
    }

    public int getNetworkCap(Context r7) {
    L6:
        e = move-exception;
        e.printStackTrace();
        return 1;
    L4:
        if (this.mCm != null) goto L8;
        this.mCm = (ConnectivityManager) r7.getSystemService("connectivity");     // Catch: Exception -> L6
    L8:
        Network r8 = this.mCm.getActiveNetwork();     // Catch: Exception -> L6
        NetworkCapabilities r3 = this.mCm.getNetworkCapabilities(r8);     // Catch: Exception -> L6
        if (r8 == null) goto L23;
        if (r3 == null) goto L23;
        if (this.mDebugLog == false) goto L16;
        PrintStream r6 = System.out;     // Catch: Exception -> L6
        r6.println("TTNetworkStackAPI nc portal = " + r3.hasCapability(17));     // Catch: Exception -> L6
        r6.println("TTNetworkStackAPI nc validated = " + r3.hasCapability(16));     // Catch: Exception -> L6
    L16:
        if (r3.hasCapability(16) == false) goto L19;
        return 0;
    L19:
        if (r3.hasCapability(17) == false) goto L23;
        return 2;
    L23:
        return 1;
    }

    public String getNetworkType() {
        return this.mNqc.getNetworkType();
    }

    public int getSimNetworkType() {
        return this.mNqc.mSimNetworkType;
    }

    public int getSpecalNetworkError() {
        if (this.mDebugLog == false) goto L5;
        System.out.println("TTNetworkStackAPI:getSpecalNetworkError, caller pid = " + Process.myPid() + ", tid = " + Process.myTid());
    L5:
        long r0 = System.currentTimeMillis();
        Object r2 = this.mCheckNetworkLock;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mIsCheckingNetwork == false) goto L14;
        monitor-exit(r2);     // Catch: Throwable -> L12
        return -100;
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L12
        final CountDownLatch r3 = new CountDownLatch(1);
        new Thread(new AnonymousClass1(this, r3)).start();
        r3.await(100, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L18
    L20:
        long r5 = System.currentTimeMillis() - r0;
        if (this.mDebugLog == false) goto L24;
        System.out.println("TTNetworkStackAPI: getSpecalNetworkError costTime = " + r5);
    L24:
        if (r5 < 100) goto L27;
        return -101;
    L27:
        Object r1 = this.mCheckNetworkLock;
        monitor-enter(r1);
        this.mIsCheckingNetwork = false;     // Catch: Throwable -> L33
        int r8 = this.mCheckErrorType;     // Catch: Throwable -> L33
        monitor-exit(r1);     // Catch: Throwable -> L33
        return r8;
    L33:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        System.out.println("TTNetworkStackAPI: InterruptedException happen. " + e);
        e.printStackTrace();
        goto L20
    }

    public int getWifiLevel() {
        return this.mNqc.getWifiLevel();
    }

    public boolean is5G() {
        return this.mNqc.is5G();
    }

    public void setDebugLogFeature(boolean r1) {
        this.mDebugLog = r1;
    }
}

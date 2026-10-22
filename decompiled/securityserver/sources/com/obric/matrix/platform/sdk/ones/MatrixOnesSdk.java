package com.obric.matrix.platform.sdk.ones;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.obric.matrix.platform.sdk.ones.internal.config.a;
import com.obric.matrix.platform.sdk.ones.internal.monitor.SdkMonitorManager;
import com.obric.matrix.platform.sdk.ones.internal.tunnel.CmdManager;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.proto.Request;
import com.obric.matrix.proto.Response;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"StaticFieldLeak"})
public final class MatrixOnesSdk {

    @NotNull
    public static final MatrixOnesSdk INSTANCE = null;

    @NotNull
    private static final String TAG = "MatrixOnesSdk";

    @Nullable
    private static IMatrixBridge bridge;

    @Nullable
    private static Context context;
    private static volatile boolean isInit;

    static {
        INSTANCE = new MatrixOnesSdk();
    }

    private MatrixOnesSdk() {
    }

    public static /* synthetic */ void a(Throwable r0) {
        m12init$lambda0(r0);
    }

    /* JADX INFO: renamed from: init$lambda-0, reason: not valid java name */
    private static final void m12init$lambda0(Throwable r3) {
        MLog.e$default(TAG, "Rxjava error " + Log.getStackTraceString(r3), null, 4, null);
    }

    public final synchronized void checkInit$sdk_platform_ones_release() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (context == null) goto L12;
        if (bridge == null) goto L12;
        monitor-exit(this);
        return;
    L12:
        throw new RuntimeException("please call init first ");     // Catch: Throwable -> L9
    }

    public final void enableLog(boolean r1) {
        MLog.INSTANCE.setEnabled(r1);
    }

    @Nullable
    public final IMatrixBridge getBridge$sdk_platform_ones_release() {
        return bridge;
    }

    @Nullable
    public final Context getContext$sdk_platform_ones_release() {
        return context;
    }

    public final synchronized void init(@NotNull Context r5, @NotNull IMatrixBridge r6) {
        monitor-enter(this);
        Intrinsics.f(r5, "ctx");     // Catch: Throwable -> L12
        Intrinsics.f(r6, "iBridge");     // Catch: Throwable -> L12
        if (isInit == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        isInit = true;     // Catch: Throwable -> L12
        context = r5.getApplicationContext();     // Catch: Throwable -> L12
        bridge = r6;     // Catch: Throwable -> L12
        MLog.d$default(TAG, "ones sdk init start, sdk version: [1.6.29-alpha.37]", null, 4, null);     // Catch: Throwable -> L12
        SdkMonitorManager r7 = SdkMonitorManager.INSTANCE;     // Catch: Throwable -> L12
        r7.initSDKMonitor(r5);     // Catch: Throwable -> L12
        r7.reportSdkInitSuccess();     // Catch: Throwable -> L12
        CmdManager.INSTANCE.init$sdk_platform_ones_release();     // Catch: Throwable -> L12
        RxJavaPlugins.setErrorHandler(new a(1));     // Catch: Throwable -> L12 Exception -> L14
    L16:
        MLog.d$default(TAG, "ones sdk init end", null, 4, null);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L14:
        e = move-exception;
        MLog.e$default(TAG, "Rxjava set error handler " + Log.getStackTraceString(e), null, 4, null);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public final void sendCmd(int r1, @NotNull Request r2, @Nullable SendCMDResultCallback r3) {
        Intrinsics.f(r2, "request");
        CmdManager.INSTANCE.sendCmd(r1, r2, r3);
    }

    @Nullable
    public final Response sendCmdSync(int r1, @NotNull Request r2) {
        Intrinsics.f(r2, "request");
        return CmdManager.INSTANCE.sendCmdSync(r1, r2);
    }
}

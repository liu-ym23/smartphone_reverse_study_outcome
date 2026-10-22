package com.obric.matrix.platform.sdk.ones;

import android.content.Context;
import android.util.Log;
import com.obric.matrix.platform.sdk.ones.internal.monitor.EventConstants;
import com.obric.matrix.platform.sdk.ones.internal.monitor.SdkMonitorManager;
import com.obric.matrix.platform.sdk.ones.internal.tunnel.CmdManager;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.proto.Request;
import com.obric.matrix.proto.Response;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixOnesSdk.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000fJ\u0016\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0006J \u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0018\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/MatrixOnesSdk;", "", "()V", "TAG", "", "<set-?>", "Lcom/obric/matrix/platform/sdk/ones/IMatrixBridge;", "bridge", "getBridge$sdk_platform_ones_release", "()Lcom/obric/matrix/platform/sdk/ones/IMatrixBridge;", "Landroid/content/Context;", "context", "getContext$sdk_platform_ones_release", "()Landroid/content/Context;", "isInit", "", "checkInit", "", "checkInit$sdk_platform_ones_release", "enableLog", "enable", "init", "ctx", "iBridge", "sendCmd", EventConstants.EVENT_KEY_CMD, "", "request", "Lcom/obric/matrix/proto/Request;", "sendCMDResultCallback", "Lcom/obric/matrix/platform/sdk/ones/SendCMDResultCallback;", "sendCmdSync", "Lcom/obric/matrix/proto/Response;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixOnesSdk {
    public static final MatrixOnesSdk INSTANCE = null;
    private static final String TAG = "MatrixOnesSdk";
    private static IMatrixBridge bridge;
    private static Context context;
    private static volatile boolean isInit;

    public static /* synthetic */ void $r8$lambda$9SsLfXuTTmpkQE_jeUe1BLrrE28(Throwable r0) {
        m147init$lambda0(r0);
    }

    static {
        INSTANCE = new MatrixOnesSdk();
    }

    private MatrixOnesSdk() {
    }

    public final Context getContext$sdk_platform_ones_release() {
        return context;
    }

    public final IMatrixBridge getBridge$sdk_platform_ones_release() {
        return bridge;
    }

    public final synchronized void init(Context r5, IMatrixBridge r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "ctx");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r6, "iBridge");     // Catch: Throwable -> L17
        if (isInit == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        isInit = true;     // Catch: Throwable -> L17
        context = r5.getApplicationContext();     // Catch: Throwable -> L17
        bridge = r6;     // Catch: Throwable -> L17
        MLog.d$default(TAG, "ones sdk init start, sdk version: [1.6.29-alpha.52]", null, 4, null);     // Catch: Throwable -> L17
        SdkMonitorManager.INSTANCE.initSDKMonitor(r5);     // Catch: Throwable -> L17
        SdkMonitorManager.INSTANCE.reportSdkInitSuccess();     // Catch: Throwable -> L17
        CmdManager.INSTANCE.init$sdk_platform_ones_release();     // Catch: Throwable -> L17
        RxJavaPlugins.setErrorHandler(new MatrixOnesSdk$$ExternalSyntheticLambda0());     // Catch: Exception -> L12 Throwable -> L17
    L14:
        MLog.d$default(TAG, "ones sdk init end", null, 4, null);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L12:
        e = move-exception;
        MLog.e$default(TAG, "Rxjava set error handler " + Log.getStackTraceString(e), null, 4, null);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: init$lambda-0, reason: not valid java name */
    private static final void m147init$lambda0(Throwable r3) {
        MLog.e$default(TAG, "Rxjava error " + Log.getStackTraceString(r3), null, 4, null);
    }

    public final void enableLog(boolean r1) {
        MLog.INSTANCE.setEnabled(r1);
    }

    public final void sendCmd(int r1, Request r2, SendCMDResultCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        CmdManager.INSTANCE.sendCmd(r1, r2, r3);
    }

    public final Response sendCmdSync(int r1, Request r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        return CmdManager.INSTANCE.sendCmdSync(r1, r2);
    }

    public final synchronized void checkInit$sdk_platform_ones_release() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (context == null) goto L10;
        if (bridge == null) goto L10;
        monitor-exit(this);
        return;
    L10:
        throw new RuntimeException("please call init first ");     // Catch: Throwable -> L11
    }
}

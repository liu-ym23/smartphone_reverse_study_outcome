package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.platform.sdk.ones.MatrixOnesSdk;
import com.obric.matrix.platform.sdk.ones.internal.monitor.ReportMonitorHelper;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.platform.server.IServerBroker;
import com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixBinderManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r*\u00015\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u000109H\u0002J\u000e\u0010?\u001a\u00020=2\u0006\u0010@\u001a\u00020AJ\u000e\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020\u0007J\u0006\u0010D\u001a\u00020=J\u0012\u0010E\u001a\u00020=2\n\b\u0002\u0010>\u001a\u0004\u0018\u000109J\u0006\u0010F\u001a\u00020=J\u0010\u0010G\u001a\u00020=2\u0006\u0010H\u001a\u00020\u001eH\u0002J\b\u0010I\u001a\u00020=H\u0002J\u000e\u0010J\u001a\u00020=2\u0006\u0010K\u001a\u00020&J\u000e\u0010L\u001a\u00020=2\u0006\u0010K\u001a\u00020&J\u000e\u0010M\u001a\u00020=2\u0006\u0010>\u001a\u000209R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020908¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;¨\u0006N"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/MatrixBinderManager;", "", "()V", "MATRIX_SERVICE", "", "TAG", "bind", "Lcom/obric/matrix/platform/server/IServerBroker;", "getBind$sdk_platform_ones_release", "()Lcom/obric/matrix/platform/server/IServerBroker;", "setBind$sdk_platform_ones_release", "(Lcom/obric/matrix/platform/server/IServerBroker;)V", "delayCheckConnectedRunnable", "Ljava/lang/Runnable;", "delayReconnectTime", "", "getDelayReconnectTime", "()J", "setDelayReconnectTime", "(J)V", "delayReconnectTimeStep", "getDelayReconnectTimeStep", "setDelayReconnectTimeStep", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "isBinding", "", "()Z", "setBinding", "(Z)V", "isCalledOnBind", "setCalledOnBind", "notificationSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/CmdResultCallback;", "getNotificationSet$sdk_platform_ones_release", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "reConnectRunnable", "getReConnectRunnable", "()Ljava/lang/Runnable;", "setReConnectRunnable", "(Ljava/lang/Runnable;)V", "serviceBind", "Landroid/os/IBinder;", "getServiceBind", "()Landroid/os/IBinder;", "setServiceBind", "(Landroid/os/IBinder;)V", "serviceConnection", "com/obric/matrix/platform/sdk/ones/internal/tunnel/MatrixBinderManager$serviceConnection$1", "Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/MatrixBinderManager$serviceConnection$1;", "waitConnectCallbackSet", "", "Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/ServiceConnectCallback;", "getWaitConnectCallbackSet", "()Ljava/util/Set;", "addConnectCallbackIfNeed", "", "connectCallback", "callDisconnect", "name", "Landroid/content/ComponentName;", "callOnBind", "binder", "checkReconnect", "connectBinder", "initBinder", "onConnectCallbackResult", "isConnected", "registerActivityLifecycle", "registerNotification", ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION, "unregisterNotification", "waitConnectResult", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixBinderManager {
    public static final MatrixBinderManager INSTANCE = null;
    private static final String MATRIX_SERVICE = "com.obric.matrix.server.MatrixServer";
    private static final String TAG = "MatrixBinderManager";
    private static IServerBroker bind;
    private static final Runnable delayCheckConnectedRunnable = null;
    private static long delayReconnectTime;
    private static long delayReconnectTimeStep;
    private static Handler handler;
    private static boolean isBinding;
    private static boolean isCalledOnBind;
    private static final CopyOnWriteArraySet<CmdResultCallback> notificationSet = null;
    private static Runnable reConnectRunnable;
    private static IBinder serviceBind;
    private static final MatrixBinderManager$serviceConnection$1 serviceConnection = null;
    private static final Set<ServiceConnectCallback> waitConnectCallbackSet = null;

    public static /* synthetic */ void $r8$lambda$HqDnfCxxwZOfxWb2Z9pUx6pS4kc() {
        m181delayCheckConnectedRunnable$lambda1();
    }

    public static /* synthetic */ void $r8$lambda$tZoWS5TKRfpQhtY0GD3KxIMKIHE() {
        m182reConnectRunnable$lambda0();
    }

    private MatrixBinderManager() {
    }

    public static final /* synthetic */ Runnable access$getDelayCheckConnectedRunnable$p() {
        return delayCheckConnectedRunnable;
    }

    public static final /* synthetic */ void access$onConnectCallbackResult(MatrixBinderManager r0, boolean r1) {
        r0.onConnectCallbackResult(r1);
    }

    public final IBinder getServiceBind() {
        return serviceBind;
    }

    public final void setServiceBind(IBinder r1) {
        serviceBind = r1;
    }

    public final void setBind$sdk_platform_ones_release(IServerBroker r1) {
        bind = r1;
    }

    public final IServerBroker getBind$sdk_platform_ones_release() {
        MatrixOnesSdk.INSTANCE.checkInit$sdk_platform_ones_release();
        return bind;
    }

    public final long getDelayReconnectTime() {
        return delayReconnectTime;
    }

    public final void setDelayReconnectTime(long r1) {
        delayReconnectTime = r1;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.matrix.platform.sdk.ones.internal.tunnel.MatrixBinderManager$serviceConnection$1] */
    static {
        INSTANCE = new MatrixBinderManager();
        delayReconnectTimeStep = WsConstants.EXIT_DELAY_TIME;
        handler = new Handler(Looper.getMainLooper());
        reConnectRunnable = new MatrixBinderManager$$ExternalSyntheticLambda0();
        waitConnectCallbackSet = new LinkedHashSet();
        notificationSet = new CopyOnWriteArraySet();
        serviceConnection = new MatrixBinderManager$serviceConnection$1();
        delayCheckConnectedRunnable = new MatrixBinderManager$$ExternalSyntheticLambda1();
    }

    public final long getDelayReconnectTimeStep() {
        return delayReconnectTimeStep;
    }

    public final void setDelayReconnectTimeStep(long r1) {
        delayReconnectTimeStep = r1;
    }

    public final Handler getHandler() {
        return handler;
    }

    public final void setHandler(Handler r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        handler = r1;
    }

    public final boolean isBinding() {
        return isBinding;
    }

    public final void setBinding(boolean r1) {
        isBinding = r1;
    }

    public final Runnable getReConnectRunnable() {
        return reConnectRunnable;
    }

    public final void setReConnectRunnable(Runnable r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        reConnectRunnable = r1;
    }

    /* JADX INFO: renamed from: reConnectRunnable$lambda-0, reason: not valid java name */
    private static final void m182reConnectRunnable$lambda0() {
        MatrixBinderManager r0 = INSTANCE;
        isBinding = false;
        connectBinder$default(r0, null, 1, null);
        MLog.d$default(TAG, "called reConnectRunnable", null, 4, null);
        delayReconnectTime = delayReconnectTimeStep;
    }

    public final Set<ServiceConnectCallback> getWaitConnectCallbackSet() {
        return waitConnectCallbackSet;
    }

    public final CopyOnWriteArraySet<CmdResultCallback> getNotificationSet$sdk_platform_ones_release() {
        return notificationSet;
    }

    public final boolean isCalledOnBind() {
        return isCalledOnBind;
    }

    public final void setCalledOnBind(boolean r1) {
        isCalledOnBind = r1;
    }

    public final void initBinder() {
        connectBinder$default(this, null, 1, null);
        registerActivityLifecycle();
    }

    public final void registerNotification(CmdResultCallback r2) {
        Intrinsics.checkNotNullParameter(r2, ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        checkReconnect();
        notificationSet.add(r2);
    }

    public final void unregisterNotification(CmdResultCallback r1) {
        Intrinsics.checkNotNullParameter(r1, ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        notificationSet.remove(r1);
    }

    public static /* synthetic */ void connectBinder$default(MatrixBinderManager r0, ServiceConnectCallback r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.connectBinder(r1);
    }

    public final synchronized void connectBinder(ServiceConnectCallback r10) {
        monitor-enter(this);
        MLog.d$default(TAG, "start connect binder isbinding " + isBinding, null, 4, null);     // Catch: Throwable -> L33
        MatrixOnesSdk.INSTANCE.checkInit$sdk_platform_ones_release();     // Catch: Throwable -> L33
        addConnectCallbackIfNeed(r10);     // Catch: Exception -> L36 Throwable -> L33
        if (isBinding == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        if (getBind$sdk_platform_ones_release() == null) goto L22;
        IBinder r11 = serviceBind;     // Catch: Exception -> L36 Throwable -> L33
        if (r11 == null) goto L22;
        if (r11 != null) goto L15;
    L17:
        boolean r12 = false;
    L18:
        if (r12 == false) goto L22;
        MLog.d$default(TAG, "binder alive , don't need rebind", null, 4, null);     // Catch: Exception -> L36 Throwable -> L33
        onConnectCallbackResult(true);     // Catch: Exception -> L36 Throwable -> L33
        monitor-exit(this);
        return;
    L15:
        if (r11.isBinderAlive() != true) goto L17;
        r12 = true;
    L22:
        isBinding = true;     // Catch: Exception -> L36 Throwable -> L33
        Intent r13 = new Intent();     // Catch: Exception -> L36 Throwable -> L33
        r13.setComponent(new ComponentName("com.obric.matrix", MATRIX_SERVICE));     // Catch: Exception -> L36 Throwable -> L33
        Context r6 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();     // Catch: Exception -> L36 Throwable -> L33
        if (r6 == null) goto L25;
        Boolean r14 = Boolean.valueOf(r6.bindService(r13, serviceConnection, 1));     // Catch: Exception -> L36 Throwable -> L33
    L26:
        ReportMonitorHelper.INSTANCE.monitorBinderResult(r14);     // Catch: Exception -> L36 Throwable -> L33
        if (Intrinsics.areEqual(r14, true) == true) goto L29;
        MLog.e$default(TAG, "CallBinder call reConnect bind result = " + r14, null, 4, null);     // Catch: Exception -> L36 Throwable -> L33
        Handler r1 = handler;     // Catch: Exception -> L36 Throwable -> L33
        Runnable r3 = delayCheckConnectedRunnable;     // Catch: Exception -> L36 Throwable -> L33
        r1.removeCallbacks(r3);     // Catch: Exception -> L36 Throwable -> L33
        handler.postDelayed(r3, delayReconnectTime);     // Catch: Exception -> L36 Throwable -> L33
        onConnectCallbackResult(false);     // Catch: Exception -> L36 Throwable -> L33
    L30:
        MLog.d$default(TAG, "initBinder: bindResult = " + r14, null, 4, null);     // Catch: Exception -> L36 Throwable -> L33
        goto L31
    L29:
        Handler r2 = handler;     // Catch: Exception -> L36 Throwable -> L33
        Runnable r4 = delayCheckConnectedRunnable;     // Catch: Exception -> L36 Throwable -> L33
        r2.removeCallbacks(r4);     // Catch: Exception -> L36 Throwable -> L33
        handler.postDelayed(r4, delayReconnectTimeStep);     // Catch: Exception -> L36 Throwable -> L33
        goto L30
    L25:
        r14 = null;
    L31:
        monitor-exit(this);
        return;
    L33:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: delayCheckConnectedRunnable$lambda-1, reason: not valid java name */
    private static final void m181delayCheckConnectedRunnable$lambda1() {
        StringBuilder r0 = new StringBuilder("CallBinder post delay in handler bind = ");
        MatrixBinderManager r1 = INSTANCE;
        MLog.d$default(TAG, r0.append(r1.getBind$sdk_platform_ones_release()).append(", isBinding = ").append(isBinding).toString(), null, 4, null);
        if (r1.getBind$sdk_platform_ones_release() != null) goto L6;
        isBinding = false;
        reConnectRunnable.run();
        return;
    }

    private final synchronized void addConnectCallbackIfNeed(ServiceConnectCallback r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        waitConnectCallbackSet.add(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private final synchronized void onConnectCallbackResult(boolean r6) {
        monitor-enter(this);
        StringBuilder r0 = new StringBuilder("onConnectCallbackResult isconnected ").append(r6).append(' ');     // Catch: Throwable -> L11
        Set<ServiceConnectCallback> r2 = waitConnectCallbackSet;     // Catch: Throwable -> L11
        MLog.d$default(TAG, r0.append(r2.size()).toString(), null, 4, null);     // Catch: Throwable -> L11
        Iterator<T> r1 = r2.iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        ((ServiceConnectCallback) r1.next()).onResult(r6);     // Catch: Throwable -> L11
        goto L6
    L8:
        waitConnectCallbackSet.clear();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private final void registerActivityLifecycle() {
        Context r1 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();
        Intrinsics.checkNotNull(r1);
        Context r2 = r1.getApplicationContext();
        if (r2 == null) goto L7;
        ((Application) r2).registerActivityLifecycleCallbacks(new AnonymousClass1());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }

    public final void checkReconnect() {
        if (getBind$sdk_platform_ones_release() == null) goto L12;
        IBinder r0 = serviceBind;
        if (r0 == null) goto L12;
        boolean r2 = false;
        if (r0 != null) goto L9;
    L11:
        if (r2 == true) goto L12;
        return;
    L9:
        if (r0.isBinderAlive() == true) goto L11;
        r2 = true;
    L12:
        connectBinder$default(this, null, 1, null);
    }

    public final void waitConnectResult(ServiceConnectCallback r5) {
        Intrinsics.checkNotNullParameter(r5, "connectCallback");
        if (getBind$sdk_platform_ones_release() == null) goto L13;
        IBinder r0 = serviceBind;
        if (r0 == null) goto L13;
        boolean r1 = false;
        if (r0 != null) goto L9;
    L11:
        if (r1 == false) goto L13;
        r5.onResult(true);
        return;
    L9:
        if (r0.isBinderAlive() != true) goto L11;
        r1 = true;
    L13:
        MLog.d$default(TAG, "waitConnectResult call ", null, 4, null);
        connectBinder(r5);
    }

    public final synchronized void callOnBind(IServerBroker r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "binder");     // Catch: Throwable -> L8
        if (isCalledOnBind == true) goto L6;
        isCalledOnBind = true;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void callDisconnect(ComponentName r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "name");     // Catch: Throwable -> L6
        isCalledOnBind = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}

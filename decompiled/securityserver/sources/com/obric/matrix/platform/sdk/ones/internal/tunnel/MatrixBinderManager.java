package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.annotation.SuppressLint;
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
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"CheckResult"})
public final class MatrixBinderManager {

    @NotNull
    public static final MatrixBinderManager INSTANCE = null;

    @NotNull
    private static final String MATRIX_SERVICE = "com.obric.matrix.server.MatrixServer";

    @NotNull
    private static final String TAG = "MatrixBinderManager";

    @Nullable
    private static IServerBroker bind;

    @NotNull
    private static final Runnable delayCheckConnectedRunnable = null;
    private static long delayReconnectTime;
    private static long delayReconnectTimeStep;

    @NotNull
    private static Handler handler;
    private static boolean isBinding;
    private static boolean isCalledOnBind;

    @NotNull
    private static final CopyOnWriteArraySet<CmdResultCallback> notificationSet = null;

    @NotNull
    private static Runnable reConnectRunnable;

    @Nullable
    private static IBinder serviceBind;

    @NotNull
    private static final MatrixBinderManager$serviceConnection$1 serviceConnection = null;

    @NotNull
    private static final Set<ServiceConnectCallback> waitConnectCallbackSet = null;

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.matrix.platform.sdk.ones.internal.tunnel.MatrixBinderManager$serviceConnection$1] */
    static {
        INSTANCE = new MatrixBinderManager();
        delayReconnectTimeStep = WsConstants.EXIT_DELAY_TIME;
        handler = new Handler(Looper.getMainLooper());
        reConnectRunnable = new com.bytedance.securityserver.b(3);
        waitConnectCallbackSet = new LinkedHashSet();
        notificationSet = new CopyOnWriteArraySet();
        serviceConnection = new MatrixBinderManager$serviceConnection$1();
        delayCheckConnectedRunnable = new com.bytedance.securityserver.b(4);
    }

    private MatrixBinderManager() {
    }

    public static /* synthetic */ void a() {
        m34reConnectRunnable$lambda0();
    }

    public static final /* synthetic */ Runnable access$getDelayCheckConnectedRunnable$p() {
        return delayCheckConnectedRunnable;
    }

    public static final /* synthetic */ void access$onConnectCallbackResult(MatrixBinderManager r0, boolean r1) {
        r0.onConnectCallbackResult(r1);
    }

    private final synchronized void addConnectCallbackIfNeed(ServiceConnectCallback r2) {
        monitor-enter(this);
        if (r2 != null) goto L10;
    L8:
        monitor-exit(this);
        return;
    L10:
        waitConnectCallbackSet.add(r2);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void b() {
        m33delayCheckConnectedRunnable$lambda1();
    }

    public static /* synthetic */ void connectBinder$default(MatrixBinderManager r0, ServiceConnectCallback r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.connectBinder(r1);
    }

    /* JADX INFO: renamed from: delayCheckConnectedRunnable$lambda-1, reason: not valid java name */
    private static final void m33delayCheckConnectedRunnable$lambda1() {
        StringBuilder r0 = new StringBuilder("CallBinder post delay in handler bind = ");
        MatrixBinderManager r1 = INSTANCE;
        r0.append(r1.getBind$sdk_platform_ones_release());
        r0.append(", isBinding = ");
        r0.append(isBinding);
        MLog.d$default(TAG, r0.toString(), null, 4, null);
        if (r1.getBind$sdk_platform_ones_release() != null) goto L6;
        isBinding = false;
        reConnectRunnable.run();
        return;
    }

    private final synchronized void onConnectCallbackResult(boolean r6) {
        monitor-enter(this);
        StringBuilder r2 = new StringBuilder("onConnectCallbackResult isconnected ");     // Catch: Throwable -> L8
        r2.append(r6);     // Catch: Throwable -> L8
        r2.append(' ');     // Catch: Throwable -> L8
        Set<ServiceConnectCallback> r0 = waitConnectCallbackSet;     // Catch: Throwable -> L8
        r2.append(r0.size());     // Catch: Throwable -> L8
        MLog.d$default(TAG, r2.toString(), null, 4, null);     // Catch: Throwable -> L8
        Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        ((ServiceConnectCallback) r1.next()).onResult(r6);     // Catch: Throwable -> L8
        goto L6
    L10:
        waitConnectCallbackSet.clear();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: reConnectRunnable$lambda-0, reason: not valid java name */
    private static final void m34reConnectRunnable$lambda0() {
        isBinding = false;
        connectBinder$default(INSTANCE, null, 1, null);
        MLog.d$default(TAG, "called reConnectRunnable", null, 4, null);
        delayReconnectTime = delayReconnectTimeStep;
    }

    private final void registerActivityLifecycle() {
        Context r1 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();
        Intrinsics.c(r1);
        Context r2 = r1.getApplicationContext();
        if (r2 == null) goto L7;
        ((Application) r2).registerActivityLifecycleCallbacks(new AnonymousClass1());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }

    public final synchronized void callDisconnect(@NotNull ComponentName r2) {
        monitor-enter(this);
        Intrinsics.f(r2, "name");     // Catch: Throwable -> L6
        isCalledOnBind = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void callOnBind(@NotNull IServerBroker r2) {
        monitor-enter(this);
        Intrinsics.f(r2, "binder");     // Catch: Throwable -> L7
        if (isCalledOnBind == true) goto L9;
        isCalledOnBind = true;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void checkReconnect() {
        if (getBind$sdk_platform_ones_release() == null) goto L9;
        IBinder r0 = serviceBind;
        if (r0 == null) goto L9;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isBinderAlive() == false) goto L9;
        return;
    L9:
        connectBinder$default(this, null, 1, null);
    }

    public final synchronized void connectBinder(@Nullable ServiceConnectCallback r10) {
        monitor-enter(this);
        MLog.d$default(TAG, "start connect binder isbinding " + isBinding, null, 4, null);     // Catch: Throwable -> L19
        MatrixOnesSdk r2 = MatrixOnesSdk.INSTANCE;     // Catch: Throwable -> L19
        r2.checkInit$sdk_platform_ones_release();     // Catch: Throwable -> L19
        addConnectCallbackIfNeed(r10);     // Catch: Throwable -> L19 Exception -> L34
        if (isBinding == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        if (getBind$sdk_platform_ones_release() == null) goto L21;
        IBinder r11 = serviceBind;     // Catch: Throwable -> L19 Exception -> L34
        if (r11 == null) goto L21;
        if (r11 == null) goto L21;
        if (r11.isBinderAlive() != true) goto L21;
        MLog.d$default(TAG, "binder alive , don't need rebind", null, 4, null);     // Catch: Throwable -> L19 Exception -> L34
        onConnectCallbackResult(true);     // Catch: Throwable -> L19 Exception -> L34
        monitor-exit(this);
        return;
    L21:
        isBinding = true;     // Catch: Throwable -> L19 Exception -> L34
        Intent r12 = new Intent();     // Catch: Throwable -> L19 Exception -> L34
        r12.setComponent(new ComponentName("com.obric.matrix", MATRIX_SERVICE));     // Catch: Throwable -> L19 Exception -> L34
        Context r3 = r2.getContext$sdk_platform_ones_release();     // Catch: Throwable -> L19 Exception -> L34
        if (r3 == null) goto L24;
        Boolean r13 = Boolean.valueOf(r3.bindService(r12, serviceConnection, 1));     // Catch: Throwable -> L19 Exception -> L34
    L25:
        ReportMonitorHelper.INSTANCE.monitorBinderResult(r13);     // Catch: Throwable -> L19 Exception -> L34
        if (Intrinsics.a(r13, Boolean.TRUE) == true) goto L28;
        MLog.e$default(TAG, "CallBinder call reConnect bind result = " + r13, null, 4, null);     // Catch: Throwable -> L19 Exception -> L34
        Handler r1 = handler;     // Catch: Throwable -> L19 Exception -> L34
        Runnable r4 = delayCheckConnectedRunnable;     // Catch: Throwable -> L19 Exception -> L34
        r1.removeCallbacks(r4);     // Catch: Throwable -> L19 Exception -> L34
        handler.postDelayed(r4, delayReconnectTime);     // Catch: Throwable -> L19 Exception -> L34
        onConnectCallbackResult(false);     // Catch: Throwable -> L19 Exception -> L34
    L29:
        MLog.d$default(TAG, "initBinder: bindResult = " + r13, null, 4, null);     // Catch: Throwable -> L19 Exception -> L34
        goto L30
    L28:
        Handler r5 = handler;     // Catch: Throwable -> L19 Exception -> L34
        Runnable r6 = delayCheckConnectedRunnable;     // Catch: Throwable -> L19 Exception -> L34
        r5.removeCallbacks(r6);     // Catch: Throwable -> L19 Exception -> L34
        handler.postDelayed(r6, delayReconnectTimeStep);     // Catch: Throwable -> L19 Exception -> L34
        goto L29
    L24:
        r13 = null;
    L30:
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Nullable
    public final IServerBroker getBind$sdk_platform_ones_release() {
        MatrixOnesSdk.INSTANCE.checkInit$sdk_platform_ones_release();
        return bind;
    }

    public final long getDelayReconnectTime() {
        return delayReconnectTime;
    }

    public final long getDelayReconnectTimeStep() {
        return delayReconnectTimeStep;
    }

    @NotNull
    public final Handler getHandler() {
        return handler;
    }

    @NotNull
    public final CopyOnWriteArraySet<CmdResultCallback> getNotificationSet$sdk_platform_ones_release() {
        return notificationSet;
    }

    @NotNull
    public final Runnable getReConnectRunnable() {
        return reConnectRunnable;
    }

    @Nullable
    public final IBinder getServiceBind() {
        return serviceBind;
    }

    @NotNull
    public final Set<ServiceConnectCallback> getWaitConnectCallbackSet() {
        return waitConnectCallbackSet;
    }

    public final void initBinder() {
        connectBinder$default(this, null, 1, null);
        registerActivityLifecycle();
    }

    public final boolean isBinding() {
        return isBinding;
    }

    public final boolean isCalledOnBind() {
        return isCalledOnBind;
    }

    public final void registerNotification(@NotNull CmdResultCallback r2) {
        Intrinsics.f(r2, "notification");
        checkReconnect();
        notificationSet.add(r2);
    }

    public final void setBind$sdk_platform_ones_release(@Nullable IServerBroker r1) {
        bind = r1;
    }

    public final void setBinding(boolean r1) {
        isBinding = r1;
    }

    public final void setCalledOnBind(boolean r1) {
        isCalledOnBind = r1;
    }

    public final void setDelayReconnectTime(long r1) {
        delayReconnectTime = r1;
    }

    public final void setDelayReconnectTimeStep(long r1) {
        delayReconnectTimeStep = r1;
    }

    public final void setHandler(@NotNull Handler r1) {
        Intrinsics.f(r1, "<set-?>");
        handler = r1;
    }

    public final void setReConnectRunnable(@NotNull Runnable r1) {
        Intrinsics.f(r1, "<set-?>");
        reConnectRunnable = r1;
    }

    public final void setServiceBind(@Nullable IBinder r1) {
        serviceBind = r1;
    }

    public final void unregisterNotification(@NotNull CmdResultCallback r1) {
        Intrinsics.f(r1, "notification");
        notificationSet.remove(r1);
    }

    public final void waitConnectResult(@NotNull ServiceConnectCallback r5) {
        Intrinsics.f(r5, "connectCallback");
        if (getBind$sdk_platform_ones_release() == null) goto L10;
        IBinder r0 = serviceBind;
        if (r0 == null) goto L10;
        if (r0 == null) goto L10;
        if (r0.isBinderAlive() != true) goto L10;
        r5.onResult(true);
        return;
    L10:
        MLog.d$default(TAG, "waitConnectResult call ", null, 4, null);
        connectBinder(r5);
    }
}

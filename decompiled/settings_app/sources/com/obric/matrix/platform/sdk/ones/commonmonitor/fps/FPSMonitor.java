package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.util.Printer;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.framwork.core.sdklib.thread.AsyncEventManager;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FPSMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J.\u0010\u0012\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSMonitor;", "", "()V", "TAG", "", "printerHasReset", "", "checkResetPrinter", "", "monitorLifecycleOwnerFps", "owner", "Landroidx/lifecycle/LifecycleOwner;", "monitorPeriodFps", "scene", "durationInSecond", "", "durationInMs", "", "monitorRecyclerView", "view", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSMonitorOnScrollListener;", "forceCollect", "fpsCallback", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/IFPSCallBack;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FPSMonitor {
    public static final FPSMonitor INSTANCE = null;
    public static final String TAG = "FPSMonitor";
    private static boolean printerHasReset;

    public static /* synthetic */ void $r8$lambda$3pf87IPUl7AxbmQ6G5Z8ptXmIVg(String r0, FPSSceneMonitor r1) {
        m1017monitorPeriodFps$lambda1(r0, r1);
    }

    static {
        INSTANCE = new FPSMonitor();
    }

    private FPSMonitor() {
    }

    public static final /* synthetic */ void access$checkResetPrinter(FPSMonitor r0) {
        r0.checkResetPrinter();
    }

    @JvmStatic
    public static final void monitorRecyclerView(String r1, RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "view");
        r2.addOnScrollListener(new FPSMonitorOnScrollListener(r1));
    }

    public static /* synthetic */ FPSMonitorOnScrollListener monitorRecyclerView$default(String r0, RecyclerView r1, boolean r2, IFPSCallBack r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 8) == 0) goto L9;
        r3 = null;
    L9:
        return monitorRecyclerView(r0, r1, r2, r3);
    }

    @JvmStatic
    public static final FPSMonitorOnScrollListener monitorRecyclerView(String r1, RecyclerView r2, boolean r3, IFPSCallBack r4) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "view");
        FPSMonitorOnScrollListener r0 = new FPSMonitorOnScrollListener(r1, r3, r4);
        r2.addOnScrollListener(r0);
        return r0;
    }

    @JvmStatic
    public static final void monitorPeriodFps(final String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        final FPSSceneMonitor r0 = new FPSSceneMonitor(r3, false, null);
        r0.start();
        AsyncEventManager.getInstance().postDelay(new FPSMonitor$$ExternalSyntheticLambda0(r3, r0), r4);
    }

    /* JADX INFO: renamed from: monitorPeriodFps$lambda-1, reason: not valid java name */
    private static final void m1017monitorPeriodFps$lambda1(String r3, FPSSceneMonitor r4) {
        Intrinsics.checkNotNullParameter(r3, "$scene");
        Intrinsics.checkNotNullParameter(r4, "$fpsSceneMonitor");
        MLog.i$default(TAG, "monitorPeriodFps stop: " + r3, null, 4, null);
        r4.stop();
    }

    @JvmStatic
    public static final void monitorLifecycleOwnerFps(final LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        MLog.d$default(TAG, "monitor " + r4.getClass().getName() + " fps", null, 4, null);
        r4.getLifecycle().addObserver(new AnonymousClass1(r4));
    }

    private final void checkResetPrinter() {
        if (printerHasReset == false) goto L5;
        return;
    L5:
        if (CommonUtil.INSTANCE.getCurrentPrinter() != null) goto L17;
        MLog.d$default(TAG, "CurrentPrinter() == null, now reset.", null, 4, null);
        Field r3 = LooperPrinterUtils.class.getDeclaredField("sPrinterWrapper");     // Catch: Exception -> L12
        r3.setAccessible(true);     // Catch: Exception -> L12
        Object r4 = r3.get(null);     // Catch: Exception -> L12
        if (r4 == null) goto L11;
        Looper r1 = Looper.getMainLooper();     // Catch: Exception -> L12
        r1.setMessageLogging((Printer) r4);     // Catch: Exception -> L12
        printerHasReset = true;     // Catch: Exception -> L12
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @JvmStatic
    public static final void monitorPeriodFps(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        monitorPeriodFps(r2, r3 * 1000);
    }
}

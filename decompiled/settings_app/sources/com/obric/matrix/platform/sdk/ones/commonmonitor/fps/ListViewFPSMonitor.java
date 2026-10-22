package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.util.Printer;
import android.widget.ListView;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.framwork.core.sdklib.thread.AsyncEventManager;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListViewFPSMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0007J.\u0010\t\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/ListViewFPSMonitor;", "", "()V", "TAG", "", "printerHasReset", "", "checkResetPrinter", "", "monitorListView", "scene", "view", "Landroid/widget/ListView;", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/ListViewFPSMonitorOnScrollListener;", "forceCollect", "fpsCallback", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/ListViewFPSMonitorOnScrollListener$IFPSCallBack;", "monitorPeriodFps", "durationInMs", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ListViewFPSMonitor {
    public static final ListViewFPSMonitor INSTANCE = null;
    public static final String TAG = "ListViewFPSMonitor";
    private static boolean printerHasReset;

    public static /* synthetic */ void $r8$lambda$wOfPa2uKwvhPynuFuGZgKgxcSz0(String r0, FpsTracer r1) {
        m1018monitorPeriodFps$lambda1(r0, r1);
    }

    static {
        INSTANCE = new ListViewFPSMonitor();
    }

    private ListViewFPSMonitor() {
    }

    @JvmStatic
    public static final void monitorListView(String r1, ListView r2) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "view");
        r2.setOnScrollListener(new ListViewFPSMonitorOnScrollListener(r1));
    }

    public static /* synthetic */ ListViewFPSMonitorOnScrollListener monitorListView$default(String r0, ListView r1, boolean r2, ListViewFPSMonitorOnScrollListener.IFPSCallBack r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 8) == 0) goto L9;
        r3 = null;
    L9:
        return monitorListView(r0, r1, r2, r3);
    }

    @JvmStatic
    public static final ListViewFPSMonitorOnScrollListener monitorListView(String r1, ListView r2, boolean r3, ListViewFPSMonitorOnScrollListener.IFPSCallBack r4) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "view");
        ListViewFPSMonitorOnScrollListener r0 = new ListViewFPSMonitorOnScrollListener(r1, r3, r4);
        r2.setOnScrollListener(r0);
        return r0;
    }

    @JvmStatic
    public static final void monitorPeriodFps(final String r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "scene");
        final FpsTracer r0 = new FpsTracer(r5);
        r0.start();
        MLog.i$default(TAG, "monitorPeriodFps start: " + r5, null, 4, null);
        AsyncEventManager.getInstance().postDelay(new ListViewFPSMonitor$$ExternalSyntheticLambda0(r5, r0), r6);
    }

    /* JADX INFO: renamed from: monitorPeriodFps$lambda-1, reason: not valid java name */
    private static final void m1018monitorPeriodFps$lambda1(String r3, FpsTracer r4) {
        Intrinsics.checkNotNullParameter(r3, "$scene");
        Intrinsics.checkNotNullParameter(r4, "$fpsTracer");
        MLog.i$default(TAG, "monitorPeriodFps stop: " + r3, null, 4, null);
        r4.stop();
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
}

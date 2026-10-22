package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.util.Printer;
import android.widget.ListView;
import androidx.constraintlayout.motion.widget.a;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.framwork.core.sdklib.thread.AsyncEventManager;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ListViewFPSMonitor {

    @NotNull
    public static final ListViewFPSMonitor INSTANCE = null;

    @NotNull
    public static final String TAG = "ListViewFPSMonitor";
    private static boolean printerHasReset;

    static {
        INSTANCE = new ListViewFPSMonitor();
    }

    private ListViewFPSMonitor() {
    }

    public static /* synthetic */ void a(String r0, FpsTracer r1) {
        m21monitorPeriodFps$lambda1(r0, r1);
    }

    private final void checkResetPrinter() {
        if (printerHasReset == false) goto L5;
        return;
    L5:
        if (CommonUtil.INSTANCE.getCurrentPrinter() != null) goto L18;
        MLog.d$default(TAG, "CurrentPrinter() == null, now reset.", null, 4, null);
        Field r3 = LooperPrinterUtils.class.getDeclaredField("sPrinterWrapper");     // Catch: Exception -> L10
        r3.setAccessible(true);     // Catch: Exception -> L10
        Object r4 = r3.get(null);     // Catch: Exception -> L10
        if (r4 == null) goto L13;
        Looper r1 = Looper.getMainLooper();     // Catch: Exception -> L10
        r1.setMessageLogging((Printer) r4);     // Catch: Exception -> L10
        printerHasReset = true;     // Catch: Exception -> L10
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @JvmStatic
    public static final void monitorListView(@NotNull String r1, @NotNull ListView r2) {
        Intrinsics.f(r1, "scene");
        Intrinsics.f(r2, "view");
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
    public static final void monitorPeriodFps(@NotNull String r5, long r6) {
        Intrinsics.f(r5, "scene");
        FpsTracer r0 = new FpsTracer(r5);
        r0.start();
        MLog.i$default(TAG, "monitorPeriodFps start: ".concat(r5), null, 4, null);
        AsyncEventManager.getInstance().postDelay(new a(8, r5, r0), r6);
    }

    /* JADX INFO: renamed from: monitorPeriodFps$lambda-1, reason: not valid java name */
    private static final void m21monitorPeriodFps$lambda1(String r3, FpsTracer r4) {
        Intrinsics.f(r3, "$scene");
        Intrinsics.f(r4, "$fpsTracer");
        MLog.i$default(TAG, "monitorPeriodFps stop: ".concat(r3), null, 4, null);
        r4.stop();
    }

    @JvmStatic
    @NotNull
    public static final ListViewFPSMonitorOnScrollListener monitorListView(@NotNull String r1, @NotNull ListView r2, boolean r3, @Nullable ListViewFPSMonitorOnScrollListener.IFPSCallBack r4) {
        Intrinsics.f(r1, "scene");
        Intrinsics.f(r2, "view");
        ListViewFPSMonitorOnScrollListener r0 = new ListViewFPSMonitorOnScrollListener(r1, r3, r4);
        r2.setOnScrollListener(r0);
        return r0;
    }
}

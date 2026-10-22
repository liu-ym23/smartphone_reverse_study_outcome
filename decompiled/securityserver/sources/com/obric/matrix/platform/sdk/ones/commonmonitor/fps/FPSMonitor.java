package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.util.Printer;
import androidx.constraintlayout.motion.widget.a;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
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
public final class FPSMonitor {

    @NotNull
    public static final FPSMonitor INSTANCE = null;

    @NotNull
    public static final String TAG = "FPSMonitor";
    private static boolean printerHasReset;

    static {
        INSTANCE = new FPSMonitor();
    }

    private FPSMonitor() {
    }

    public static /* synthetic */ void a(String r0, FPSSceneMonitor r1) {
        m20monitorPeriodFps$lambda1(r0, r1);
    }

    public static final /* synthetic */ void access$checkResetPrinter(FPSMonitor r0) {
        r0.checkResetPrinter();
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
    public static final void monitorLifecycleOwnerFps(@NotNull final LifecycleOwner r4) {
        Intrinsics.f(r4, "owner");
        MLog.d$default(TAG, "monitor " + r4.getClass().getName() + " fps", null, 4, null);
        r4.getLifecycle().addObserver(new AnonymousClass1(r4));
    }

    @JvmStatic
    public static final void monitorPeriodFps(@NotNull String r4, long r5) {
        Intrinsics.f(r4, "scene");
        FPSSceneMonitor r0 = new FPSSceneMonitor(r4, false, null);
        r0.start();
        AsyncEventManager.getInstance().postDelay(new a(7, r4, r0), r5);
    }

    /* JADX INFO: renamed from: monitorPeriodFps$lambda-1, reason: not valid java name */
    private static final void m20monitorPeriodFps$lambda1(String r3, FPSSceneMonitor r4) {
        Intrinsics.f(r3, "$scene");
        Intrinsics.f(r4, "$fpsSceneMonitor");
        MLog.i$default(TAG, "monitorPeriodFps stop: ".concat(r3), null, 4, null);
        r4.stop();
    }

    @JvmStatic
    public static final void monitorRecyclerView(@NotNull String r1, @NotNull RecyclerView r2) {
        Intrinsics.f(r1, "scene");
        Intrinsics.f(r2, "view");
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
    @NotNull
    public static final FPSMonitorOnScrollListener monitorRecyclerView(@NotNull String r1, @NotNull RecyclerView r2, boolean r3, @Nullable IFPSCallBack r4) {
        Intrinsics.f(r1, "scene");
        Intrinsics.f(r2, "view");
        FPSMonitorOnScrollListener r0 = new FPSMonitorOnScrollListener(r1, r3, r4);
        r2.addOnScrollListener(r0);
        return r0;
    }

    @JvmStatic
    public static final void monitorPeriodFps(@NotNull String r2, int r3) {
        Intrinsics.f(r2, "scene");
        monitorPeriodFps(r2, r3 * 1000);
    }
}

package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Printer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FPSMonitorOnScrollListener extends RecyclerView.OnScrollListener {

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    private static final ConcurrentLinkedQueue<FpsBean> FPS_BEANS = null;

    @NotNull
    private static final String TAG = "FPSMonitorOnScrollListener";

    @Nullable
    private FpsBean curFpsBean;
    private int distanceX;
    private int distanceY;
    private long dragStart;
    private final boolean forceCollect;

    @Nullable
    private final IFPSCallBack fpsCallBack;

    @Nullable
    private FpsBean lastFpsBean;

    @NotNull
    private final FpsTracer mFpsTracer;
    private boolean printerHasReset;

    @NotNull
    private final String scene;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        FPS_BEANS = new ConcurrentLinkedQueue();
    }

    public /* synthetic */ FPSMonitorOnScrollListener(String r1, boolean r2, IFPSCallBack r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ ConcurrentLinkedQueue access$getFPS_BEANS$cp() {
        return FPS_BEANS;
    }

    public static final /* synthetic */ IFPSCallBack access$getFpsCallBack$p(FPSMonitorOnScrollListener r0) {
        return r0.fpsCallBack;
    }

    public static final /* synthetic */ FpsBean access$getLastFpsBean$p(FPSMonitorOnScrollListener r0) {
        return r0.lastFpsBean;
    }

    public static final /* synthetic */ String access$getScene$p(FPSMonitorOnScrollListener r0) {
        return r0.scene;
    }

    public static final /* synthetic */ void access$setLastFpsBean$p(FPSMonitorOnScrollListener r0, FpsBean r1) {
        r0.lastFpsBean = r1;
    }

    private final void checkResetPrinter() {
        if (this.printerHasReset == false) goto L5;
        return;
    L5:
        if (CommonUtil.INSTANCE.getCurrentPrinter() != null) goto L18;
        MLog.d$default(TAG, "CurrentPrinter() == null, now reset.", null, 4, null);
        Field r0 = LooperPrinterUtils.class.getDeclaredField("sPrinterWrapper");     // Catch: Exception -> L10
        Intrinsics.e(r0, "LooperPrinterUtils::clas…dField(\"sPrinterWrapper\")");     // Catch: Exception -> L10
        r0.setAccessible(true);     // Catch: Exception -> L10
        Object r1 = r0.get(null);     // Catch: Exception -> L10
        if (r1 == null) goto L13;
        Looper r2 = Looper.getMainLooper();     // Catch: Exception -> L10
        r2.setMessageLogging((Printer) r1);     // Catch: Exception -> L10
        this.printerHasReset = true;     // Catch: Exception -> L10
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private final void initFpsTracerCallbacks() {
        this.mFpsTracer.setIFPSCallBack(new AnonymousClass1(this));
        this.mFpsTracer.setDropFrameCallback(new AnonymousClass2(this));
    }

    private final void reset() {
        this.distanceX = 0;
        this.distanceY = 0;
        this.dragStart = -1;
        FpsBean r0 = this.curFpsBean;
        if (r0 == null) goto L6;
        FPS_BEANS.add(r0);
        this.curFpsBean = null;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView r5, int r6) {
        Intrinsics.f(r5, "recyclerView");
        super.onScrollStateChanged(r5, r6);
        if (r6 != 0) goto L5;
        FpsBean r7 = this.curFpsBean;
        if (r7 != null) goto L20;
    L23:
        reset();
        this.mFpsTracer.stop();
        return;
    L20:
        if (this.dragStart <= 0) goto L22;
        r7.setDuration(SystemClock.elapsedRealtime() - this.dragStart);
    L22:
        r7.setDistantX(this.distanceX);
        r7.setDistantY(this.distanceY);
        r7.setEndX(r5.computeHorizontalScrollOffset());
        r7.setEndY(r5.computeVerticalScrollOffset());
        goto L23
    L5:
        if (r6 == 1) goto L8;
        return;
    L8:
        if (this.dragStart < 0) goto L10;
    L16:
        checkResetPrinter();
        this.mFpsTracer.start();
        return;
    L10:
        if (this.curFpsBean != null) goto L12;
        this.curFpsBean = FpsBean.Companion.obtain();
    L12:
        FpsBean r8 = this.curFpsBean;
        if (r8 == null) goto L15;
        r8.setStartX(r5.computeHorizontalScrollOffset());
        r8.setStartY(r5.computeVerticalScrollOffset());
    L15:
        this.dragStart = SystemClock.elapsedRealtime();
        goto L16
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView r2, int r3, int r4) {
        Intrinsics.f(r2, "recyclerView");
        super.onScrolled(r2, r3, r4);
        int r5 = this.distanceX;
        this.distanceX = Math.abs(r3) + r5;
        int r6 = this.distanceY;
        this.distanceY = Math.abs(r4) + r6;
    }

    public final void removeFpsCallback() {
        this.mFpsTracer.setIFPSCallBack(null);
    }

    public FPSMonitorOnScrollListener(@NotNull String r2, boolean r3, @Nullable IFPSCallBack r4) {
        Intrinsics.f(r2, "scene");
        this.scene = r2;
        this.forceCollect = r3;
        this.fpsCallBack = r4;
        this.mFpsTracer = new FpsTracer(r2, r3);
        this.dragStart = -1;
        initFpsTracerCallbacks();
    }

    public FPSMonitorOnScrollListener(@NotNull String r3) {
        Intrinsics.f(r3, "scene");
        this(r3, false, null);
    }
}

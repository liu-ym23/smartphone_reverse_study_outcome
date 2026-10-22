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

/* JADX INFO: compiled from: FPSMonitorOnScrollListener.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0016J \u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0016J\u0006\u0010\u001f\u001a\u00020\u0016J\b\u0010 \u001a\u00020\u0016H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSMonitorOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "scene", "", "(Ljava/lang/String;)V", "forceCollect", "", "fpsCallBack", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/IFPSCallBack;", "(Ljava/lang/String;ZLcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/IFPSCallBack;)V", "curFpsBean", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean;", "distanceX", "", "distanceY", "dragStart", "", "lastFpsBean", "mFpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "printerHasReset", "checkResetPrinter", "", "initFpsTracerCallbacks", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "removeFpsCallback", "reset", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FPSMonitorOnScrollListener extends RecyclerView.OnScrollListener {
    public static final Companion Companion = null;
    private static final ConcurrentLinkedQueue<FpsBean> FPS_BEANS = null;
    private static final String TAG = "FPSMonitorOnScrollListener";
    private FpsBean curFpsBean;
    private int distanceX;
    private int distanceY;
    private long dragStart;
    private final boolean forceCollect;
    private final IFPSCallBack fpsCallBack;
    private FpsBean lastFpsBean;
    private final FpsTracer mFpsTracer;
    private boolean printerHasReset;
    private final String scene;

    /* JADX INFO: compiled from: FPSMonitorOnScrollListener.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSMonitorOnScrollListener$Companion;", "", "()V", "FPS_BEANS", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean;", "TAG", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
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

    public FPSMonitorOnScrollListener(String r2, boolean r3, IFPSCallBack r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.scene = r2;
        this.forceCollect = r3;
        this.fpsCallBack = r4;
        this.mFpsTracer = new FpsTracer(r2, r3);
        this.dragStart = -1;
        initFpsTracerCallbacks();
    }

    static {
        Companion = new Companion(null);
        FPS_BEANS = new ConcurrentLinkedQueue();
    }

    public FPSMonitorOnScrollListener(String r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        this(r3, false, null);
    }

    private final void initFpsTracerCallbacks() {
        this.mFpsTracer.setIFPSCallBack(new AnonymousClass1(this));
        this.mFpsTracer.setDropFrameCallback(new AnonymousClass2(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
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
    public void onScrolled(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrolled(r2, r3, r4);
        this.distanceX += Math.abs(r3);
        this.distanceY += Math.abs(r4);
    }

    private final void checkResetPrinter() {
        if (this.printerHasReset == false) goto L5;
        return;
    L5:
        if (CommonUtil.INSTANCE.getCurrentPrinter() != null) goto L17;
        MLog.d$default(TAG, "CurrentPrinter() == null, now reset.", null, 4, null);
        Field r0 = LooperPrinterUtils.class.getDeclaredField("sPrinterWrapper");     // Catch: Exception -> L12
        Intrinsics.checkNotNullExpressionValue(r0, "LooperPrinterUtils::clas…dField(\"sPrinterWrapper\")");     // Catch: Exception -> L12
        r0.setAccessible(true);     // Catch: Exception -> L12
        Object r1 = r0.get(null);     // Catch: Exception -> L12
        if (r1 == null) goto L11;
        Looper r2 = Looper.getMainLooper();     // Catch: Exception -> L12
        r2.setMessageLogging((Printer) r1);     // Catch: Exception -> L12
        this.printerHasReset = true;     // Catch: Exception -> L12
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void removeFpsCallback() {
        this.mFpsTracer.setIFPSCallBack(null);
    }
}

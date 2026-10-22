package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.SystemClock;
import android.widget.AbsListView;
import com.bytedance.apm.trace.fps.FpsTracer;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListViewFPSMonitorOnScrollListener.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J(\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\rH\u0016J\u0006\u0010\u001f\u001a\u00020\u0016J\b\u0010 \u001a\u00020\u0016H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/ListViewFPSMonitorOnScrollListener;", "Landroid/widget/AbsListView$OnScrollListener;", "scene", "", "(Ljava/lang/String;)V", "forceCollect", "", "fpsCallBack", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/ListViewFPSMonitorOnScrollListener$IFPSCallBack;", "(Ljava/lang/String;ZLcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/ListViewFPSMonitorOnScrollListener$IFPSCallBack;)V", "curFpsBean", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean;", "distanceX", "", "distanceY", "dragStart", "", "lastFpsBean", "mFpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "printerHasReset", "initFpsTracerCallbacks", "", "onScroll", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "removeFpsCallback", "reset", "Companion", "IFPSCallBack", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ListViewFPSMonitorOnScrollListener implements AbsListView.OnScrollListener {
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

    /* JADX INFO: compiled from: ListViewFPSMonitorOnScrollListener.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/ListViewFPSMonitorOnScrollListener$Companion;", "", "()V", "FPS_BEANS", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean;", "TAG", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ListViewFPSMonitorOnScrollListener.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/ListViewFPSMonitorOnScrollListener$IFPSCallBack;", "", "fpsCallBack", "", "fpsBean", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IFPSCallBack {
        void fpsCallBack(FpsBean r1);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    public ListViewFPSMonitorOnScrollListener(String r2, boolean r3, IFPSCallBack r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.scene = r2;
        this.forceCollect = r3;
        this.fpsCallBack = r4;
        this.mFpsTracer = new FpsTracer(r2, r3);
        this.dragStart = -1;
        initFpsTracerCallbacks();
    }

    public /* synthetic */ ListViewFPSMonitorOnScrollListener(String r1, boolean r2, IFPSCallBack r3, int r4, DefaultConstructorMarker r5) {
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

    public static final /* synthetic */ IFPSCallBack access$getFpsCallBack$p(ListViewFPSMonitorOnScrollListener r0) {
        return r0.fpsCallBack;
    }

    public static final /* synthetic */ FpsBean access$getLastFpsBean$p(ListViewFPSMonitorOnScrollListener r0) {
        return r0.lastFpsBean;
    }

    public static final /* synthetic */ void access$setLastFpsBean$p(ListViewFPSMonitorOnScrollListener r0, FpsBean r1) {
        r0.lastFpsBean = r1;
    }

    static {
        Companion = new Companion(null);
        FPS_BEANS = new ConcurrentLinkedQueue();
    }

    public ListViewFPSMonitorOnScrollListener(String r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        this(r3, false, null);
    }

    private final void initFpsTracerCallbacks() {
        this.mFpsTracer.setIFPSCallBack(new AnonymousClass1(this));
        this.mFpsTracer.setDropFrameCallback(new AnonymousClass2(this));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        if (r6 != 0) goto L5;
        FpsBean r7 = this.curFpsBean;
        if (r7 != null) goto L17;
    L19:
        reset();
        this.mFpsTracer.stop();
        return;
    L17:
        if (this.dragStart <= 0) goto L19;
        r7.setDuration(SystemClock.elapsedRealtime() - this.dragStart);
        goto L19
    L5:
        if (r6 == 1) goto L8;
        return;
    L8:
        if (this.dragStart < 0) goto L10;
    L13:
        this.mFpsTracer.start();
        return;
    L10:
        if (this.curFpsBean != null) goto L12;
        this.curFpsBean = FpsBean.Companion.obtain();
    L12:
        this.dragStart = SystemClock.elapsedRealtime();
        goto L13
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

    public final void removeFpsCallback() {
        this.mFpsTracer.setIFPSCallBack(null);
    }
}

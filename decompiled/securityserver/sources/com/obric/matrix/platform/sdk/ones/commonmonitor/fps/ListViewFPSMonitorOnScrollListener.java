package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.SystemClock;
import android.widget.AbsListView;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.trace.fps.FpsTracer;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ListViewFPSMonitorOnScrollListener implements AbsListView.OnScrollListener {

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

    @Metadata
    public interface IFPSCallBack {
        @WorkerThread
        void fpsCallBack(@Nullable FpsBean r1);
    }

    static {
        Companion = new Companion(null);
        FPS_BEANS = new ConcurrentLinkedQueue();
    }

    public ListViewFPSMonitorOnScrollListener(@NotNull String r2, boolean r3, @Nullable IFPSCallBack r4) {
        Intrinsics.f(r2, "scene");
        this.scene = r2;
        this.forceCollect = r3;
        this.fpsCallBack = r4;
        this.mFpsTracer = new FpsTracer(r2, r3);
        this.dragStart = -1;
        initFpsTracerCallbacks();
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

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(@NotNull AbsListView r1, int r2, int r3, int r4) {
        Intrinsics.f(r1, "view");
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(@NotNull AbsListView r5, int r6) {
        Intrinsics.f(r5, "view");
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

    public final void removeFpsCallback() {
        this.mFpsTracer.setIFPSCallBack(null);
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

    public ListViewFPSMonitorOnScrollListener(@NotNull String r3) {
        Intrinsics.f(r3, "scene");
        this(r3, false, null);
    }
}

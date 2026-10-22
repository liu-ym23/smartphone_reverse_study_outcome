package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.SystemClock;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FPSSceneMonitor {

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    private static final String TAG = "FPSSceneMonitor";
    private final boolean forceCollect;

    @Nullable
    private final IFPSCallBack fpsCallBack;

    @Nullable
    private FpsBean mFpsBean;

    @NotNull
    private final FpsTracer mFpsTracer;

    @NotNull
    private final String scene;
    private long start;

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
    }

    public FPSSceneMonitor(@NotNull String r2, boolean r3, @Nullable IFPSCallBack r4) {
        Intrinsics.f(r2, "scene");
        this.scene = r2;
        this.forceCollect = r3;
        this.fpsCallBack = r4;
        FpsTracer r5 = new FpsTracer(r2, r3);
        this.mFpsTracer = r5;
        r5.setIFPSCallBack(new AnonymousClass1(this));
        r5.setDropFrameCallback(new AnonymousClass2(this));
    }

    public static final /* synthetic */ IFPSCallBack access$getFpsCallBack$p(FPSSceneMonitor r0) {
        return r0.fpsCallBack;
    }

    public static final /* synthetic */ FpsBean access$getMFpsBean$p(FPSSceneMonitor r0) {
        return r0.mFpsBean;
    }

    public static final /* synthetic */ String access$getScene$p(FPSSceneMonitor r0) {
        return r0.scene;
    }

    public static final /* synthetic */ void access$setMFpsBean$p(FPSSceneMonitor r0, FpsBean r1) {
        r0.mFpsBean = r1;
    }

    public static final /* synthetic */ void access$setStart$p(FPSSceneMonitor r0, long r1) {
        r0.start = r1;
    }

    public final void start() {
        if (this.start <= 0) goto L6;
        MLog.w$default(TAG, "start: already start", null, 4, null);
        return;
    L6:
        this.start = SystemClock.elapsedRealtime();
        this.mFpsTracer.start();
    }

    public final void stop() {
        if (this.start > 0) goto L6;
        MLog.w$default(TAG, "stop: not start", null, 4, null);
        return;
    L6:
        FpsBean r0 = FpsBean.Companion.obtain();
        r0.setDuration(SystemClock.elapsedRealtime() - this.start);
        this.mFpsBean = r0;
        this.mFpsTracer.stop();
        this.start = 0;
    }

    public /* synthetic */ FPSSceneMonitor(String r1, boolean r2, IFPSCallBack r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        this(r1, r2, r3);
    }
}

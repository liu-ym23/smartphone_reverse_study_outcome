package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.SystemClock;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FPSSceneMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSSceneMonitor;", "", "scene", "", "forceCollect", "", "fpsCallBack", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/IFPSCallBack;", "(Ljava/lang/String;ZLcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/IFPSCallBack;)V", "mFpsBean", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean;", "mFpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "start", "", "", "stop", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FPSSceneMonitor {
    public static final Companion Companion = null;
    private static final String TAG = "FPSSceneMonitor";
    private final boolean forceCollect;
    private final IFPSCallBack fpsCallBack;
    private FpsBean mFpsBean;
    private final FpsTracer mFpsTracer;
    private final String scene;
    private long start;

    /* JADX INFO: compiled from: FPSSceneMonitor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSSceneMonitor$Companion;", "", "()V", "TAG", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FPSSceneMonitor(String r2, boolean r3, IFPSCallBack r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.scene = r2;
        this.forceCollect = r3;
        this.fpsCallBack = r4;
        FpsTracer r5 = new FpsTracer(r2, r3);
        this.mFpsTracer = r5;
        r5.setIFPSCallBack(new AnonymousClass1(this));
        r5.setDropFrameCallback(new AnonymousClass2(this));
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
}

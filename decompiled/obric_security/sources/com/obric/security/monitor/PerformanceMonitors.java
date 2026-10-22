package com.obric.security.monitor;

import android.os.SystemClock;
import android.view.View;
import com.obric.matrix.platform.sdk.ones.commonmonitor.fps.FPSSceneMonitor;
import com.obric.matrix.platform.sdk.ones.commonmonitor.page.PageMonitor;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: PerformanceMonitors.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J \u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H\u0007J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0016H\u0007J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0016H\u0007J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/security/monitor/PerformanceMonitors;", "", "()V", "EVENT_PAGE_ACTION_TIME", "", "EVENT_SCENE_ACTION_TIME", "TAG", "composePagePeriodScene", "pageScene", "period", "createPageMonitor", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/page/PageMonitor;", "scene", "markRealShowOnce", "", "view", "Landroid/view/View;", "action", "Lkotlin/Function0;", "runnable", "Ljava/lang/Runnable;", "nowElapsedMs", "", "reportActionTime", "durationMs", "reportPageActionTime", "reportSceneFrequency", "reportThreads", "FpsSceneSession", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PerformanceMonitors {
    private static final String EVENT_PAGE_ACTION_TIME = "page_action_time";
    private static final String EVENT_SCENE_ACTION_TIME = "scene_action_time";
    public static final PerformanceMonitors INSTANCE = null;
    private static final String TAG = "PerformanceMonitors";

    /* JADX INFO: compiled from: PerformanceMonitors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/security/monitor/PerformanceMonitors$FpsSceneSession;", "", "scene", "", "(Ljava/lang/String;)V", "monitor", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSSceneMonitor;", "started", "", "start", "", "stop", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FpsSceneSession {
        private FPSSceneMonitor monitor;
        private final String scene;
        private boolean started;

        public FpsSceneSession(String r2) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            this.scene = r2;
        }

        public static final /* synthetic */ String access$getScene$p(FpsSceneSession r0) {
            return r0.scene;
        }

        public final void start() {
            if (this.started == false) goto L5;
            return;
        L5:
            this.started = true;
            FPSSceneMonitor r0 = new FPSSceneMonitor(this.scene, false, new PerformanceMonitors$FpsSceneSession$start$1(this));
            r0.start();
            Unit r1 = Unit.INSTANCE;
            this.monitor = r0;
        }

        public final void stop() {
            if (this.started == true) goto L5;
            return;
        L5:
            this.started = false;
            FPSSceneMonitor r0 = this.monitor;
            if (r0 == null) goto L8;
            r0.stop();
        L8:
            FPSSceneMonitor r1 = (FPSSceneMonitor) null;
            this.monitor = null;
        }
    }

    static {
        INSTANCE = new PerformanceMonitors();
    }

    private PerformanceMonitors() {
    }

    @JvmStatic
    public static final void reportSceneFrequency(String r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        MatrixTeaManager.onButtonClickEvent$default(MatrixTeaManager.Companion.getInstance(), r3, null, 2, null);     // Catch: Throwable -> L5
        Object r1 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.m777exceptionOrNullimpl(r1);
        if (r2 == null) goto L13;
        OLog.e(TAG, "reportSceneFrequency failed scene=" + r3 + " error=" + r2.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final void reportActionTime(String r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        if (r5 >= 0) goto L13;
        return;
    L13:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        MatrixTeaManager.Companion.getInstance().onEvent(EVENT_SCENE_ACTION_TIME, new JSONObject(new JSONObject().put("scene", r4).put("duration", r5).toString()));     // Catch: Throwable -> L7
        Object r0 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r2 = Result.m777exceptionOrNullimpl(r0);
        if (r2 == null) goto L15;
        OLog.e(TAG, "reportActionTime failed scene=" + r4 + " durationMs=" + r5 + " error=" + r2.getMessage());
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r0 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @JvmStatic
    public static final void reportPageActionTime(String r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        if (r5 >= 0) goto L13;
        return;
    L13:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        MatrixTeaManager.Companion.getInstance().onEvent(EVENT_PAGE_ACTION_TIME, new JSONObject(new JSONObject().put("scene", r4).put("duration", r5).toString()));     // Catch: Throwable -> L7
        Object r0 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r2 = Result.m777exceptionOrNullimpl(r0);
        if (r2 == null) goto L15;
        OLog.e(TAG, "reportPageActionTime failed scene=" + r4 + " durationMs=" + r5 + " error=" + r2.getMessage());
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r0 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @JvmStatic
    public static final String composePagePeriodScene(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "pageScene");
        Intrinsics.checkNotNullParameter(r2, "period");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return r1;
    L9:
        return r1 + '_' + r2;
    L5:
        r0 = false;
        goto L6
    }

    @JvmStatic
    public static final long nowElapsedMs() {
        return SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final PageMonitor createPageMonitor(String r1) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        PageMonitor r0 = new PageMonitor(r1);
        r0.start();
        return r0;
    }

    @JvmStatic
    public static final void reportThreads(String r9) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Class<?> r3 = Class.forName("com.bytedance.platform.thread.monitor.ThreadMonitorManager");     // Catch: Throwable -> L5
        r3.getMethod("monitorThreadPoolInfo", new Class[]{String.class}).invoke(null, new Object[]{r9});     // Catch: Throwable -> L5
        r3.getMethod("monitorHandlerThreadInfo", new Class[]{String.class}).invoke(null, new Object[]{r9});     // Catch: Throwable -> L5
        OLog.i(TAG, "reportThreads scene=" + r9 + " alive=" + r3.getMethod("getAllAliveThread", new Class[0]).invoke(null, new Object[0]));     // Catch: Throwable -> L5
        Object r1 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.m777exceptionOrNullimpl(r1);
        if (r4 == null) goto L13;
        OLog.e(TAG, "reportThreads failed scene=" + r9 + " error=" + r4.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final void markRealShowOnce(final View r2, final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        if (r2 != null) goto L5;
        return;
    L5:
        r2.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1(r2, r3));
    }

    @JvmStatic
    public static final void markRealShowOnce(View r1, final Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        markRealShowOnce(r1, new AnonymousClass2(r2));
    }
}

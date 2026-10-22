package com.obric.matrix.platform.sdk.ones.commonmonitor.applaunch;

import a.a;
import android.app.Application;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AppLaunchMonitor {
    private static final long COLD_LAUNCH_MAX_TIME_THRESHOLD = 10000;

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    public static final String PERIOD_APP_ATTACH = "app_attach";

    @NotNull
    public static final String PERIOD_APP_CREATE = "app_create";

    @NotNull
    public static final String PERIOD_FIRST_FRAME_SHOW = "first_frame_show";

    @NotNull
    public static final String PERIOD_HOME_FRAGMENT_CREATE = "home_fragment_create";

    @NotNull
    public static final String PERIOD_HOME_FRAGMENT_CREATE_VIEW = "home_fragment_create_view";

    @NotNull
    public static final String PERIOD_HOME_FRAGMENT_RESUME = "home_fragment_resume";

    @NotNull
    public static final String PERIOD_MAIN_ACT_CREATE = "main_act_create";

    @NotNull
    public static final String PERIOD_MAIN_ACT_RESUME = "main_act_resume";

    @NotNull
    public static final String PERIOD_USERDATA_REAL_SHOW = "userdata_real_show";

    @NotNull
    private static final String TAG = "AppLaunchMonitor";

    @NotNull
    private static final AppLaunchMonitor instance = null;
    private long createCnt;

    @NotNull
    private String entranceActivityName;
    private boolean mReportDuration;
    private boolean mReportHomeShow;

    @NotNull
    private final LinkedHashMap<String, Long> periodEndMap;

    @NotNull
    private final LinkedHashMap<String, Long> periodStartMap;

    @NotNull
    private final Application.ActivityLifecycleCallbacks sActivityLifecycleCallbacks;
    private long start;
    private long startWithMain;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final AppLaunchMonitor getInstance() {
            return AppLaunchMonitor.access$getInstance$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        instance = new AppLaunchMonitor();
    }

    private AppLaunchMonitor() {
        this.start = -1;
        this.startWithMain = -1;
        this.createCnt = 1;
        this.periodStartMap = new LinkedHashMap();
        this.periodEndMap = new LinkedHashMap();
        this.entranceActivityName = "";
        this.sActivityLifecycleCallbacks = new AppLaunchMonitor$sActivityLifecycleCallbacks$1(this);
    }

    public static final /* synthetic */ String access$getEntranceActivityName$p(AppLaunchMonitor r0) {
        return r0.entranceActivityName;
    }

    public static final /* synthetic */ AppLaunchMonitor access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ long access$getStart$p(AppLaunchMonitor r2) {
        return r2.start;
    }

    public static final /* synthetic */ void access$reportFirstFrameDuation(AppLaunchMonitor r0) {
        r0.reportFirstFrameDuation();
    }

    public static final /* synthetic */ void access$setStart$p(AppLaunchMonitor r0, long r1) {
        r0.start = r1;
    }

    @NotNull
    public static final AppLaunchMonitor getInstance() {
        return Companion.getInstance();
    }

    private final void reportFirstFrameDuation() {
        if (this.mReportDuration == false) goto L6;
        return;
    L6:
        if (LaunchSceneMonitor.INSTANCE.launchWithAct() == false) goto L11;
        this.mReportDuration = true;
        long r0 = SystemClock.elapsedRealtime() - this.start;
        if (r0 >= COLD_LAUNCH_MAX_TIME_THRESHOLD) goto L12;
        MLog.i$default(TAG, a.h("reportDuration: ", r0), null, 4, null);
        MatrixTeaManager.Companion.getInstance().onApmColdLaunchFirstFrameEvent(r0);
        return;
    L12:
        return;
    }

    private final void reportUserDataRealShowDuration() {
        if (this.mReportHomeShow == false) goto L5;
        return;
    L5:
        this.mReportHomeShow = true;
        if (LaunchSceneMonitor.INSTANCE.launchWithMainAct() == true) goto L8;
        return;
    L8:
        if (this.startWithMain <= 0) goto L40;
        JSONObject r0 = new JSONObject();
        if (this.periodEndMap.size() <= 0) goto L41;
        Iterator<Map.Entry<String, Long>> r1 = this.periodEndMap.entrySet().iterator();
    L13:
        if (r1.hasNext() == false) goto L17;
        Map.Entry<String, Long> r4 = r1.next();
        String r5 = r4.getKey();
        long r6 = r4.getValue().longValue();
        Long r7 = this.periodStartMap.get(r5);
        if (r7 == null) goto L13;
        r0.put(r5, r6 - r7.longValue()).put(a.j(r5, "_start"), r7.longValue()).put(r5 + "_end", r6);
        goto L13
    L17:
        Long r2 = this.periodEndMap.get(PERIOD_FIRST_FRAME_SHOW);
        Long r8 = this.periodStartMap.get(PERIOD_HOME_FRAGMENT_CREATE);
        if (r2 == null) goto L23;
        if (r8 == null) goto L23;
        if (r2.longValue() <= r8.longValue()) goto L23;
        r0.put("home_create_to_first_show", r2.longValue() - r8.longValue());
    L23:
        Long r12 = this.periodEndMap.get("userdata_real_show");
        if (r12 == null) goto L29;
        if (r8 == null) goto L29;
        if (r12.longValue() <= r8.longValue()) goto L29;
        r0.put("home_create_to_feed_show", r12.longValue() - r8.longValue());
    L29:
        StringBuilder r13 = new StringBuilder("reportAppLaunchDuration() now = ");
        r13.append(SystemClock.elapsedRealtime());
        r13.append(" , appStartTime= ");
        LaunchSceneMonitor r3 = LaunchSceneMonitor.INSTANCE;
        r13.append(r3.getAppStartTime());
        MLog.i$default(TAG, r13.toString(), null, 4, null);
        long r9 = SystemClock.elapsedRealtime() - r3.getAppStartTime();
        if (r9 <= 0) goto L32;
        MLog.i$default(TAG, "reportAppLaunchDuration() total_duration= " + r9 + ", event= " + r0, null, 4, null);
        MatrixTeaManager.Companion.getInstance().onApmColdLaunchUserCompleteEvent(r9, r0);
        return;
    L32:
        MLog.e$default(TAG, "reportAppLaunchDuration()数据非法 total_duration <= 0", null, 4, null);
        return;
    L41:
        return;
    }

    public final long getStartMainTime() {
        return this.startWithMain;
    }

    public final void markEnd(@NotNull String r5) {
        Intrinsics.f(r5, TypedValues.CycleType.S_WAVE_PERIOD);
        if (this.mReportHomeShow == false) goto L6;
        return;
    L6:
        if (LaunchSceneMonitor.INSTANCE.launchWithMainAct() == true) goto L8;
        return;
    L8:
        if (this.startWithMain <= 0) goto L14;
        long r0 = SystemClock.elapsedRealtime() - this.startWithMain;
        this.periodEndMap.put(r5, Long.valueOf(r0));
        MLog.i$default(TAG, "markEnd " + r5 + ' ' + r0, null, 4, null);
        if (r5.equals("userdata_real_show") == false) goto L15;
        reportUserDataRealShowDuration();
        this.periodStartMap.clear();
        this.periodEndMap.clear();
        return;
    L15:
        return;
    }

    public final void markStart(@NotNull String r5) {
        Intrinsics.f(r5, TypedValues.CycleType.S_WAVE_PERIOD);
        if (this.mReportHomeShow == false) goto L6;
        return;
    L6:
        if (LaunchSceneMonitor.INSTANCE.launchWithMainAct() == true) goto L8;
        return;
    L8:
        if (this.startWithMain <= 0) goto L12;
        long r0 = SystemClock.elapsedRealtime() - this.startWithMain;
        this.periodStartMap.put(r5, Long.valueOf(r0));
        MLog.i$default(TAG, "markStart " + r5 + ' ' + r0, null, 4, null);
        return;
    }

    public final void registerActivityLifecycleCallbacks(@NotNull Application r2) {
        Intrinsics.f(r2, "app");
        r2.registerActivityLifecycleCallbacks(this.sActivityLifecycleCallbacks);
    }

    public final void startTrace(@NotNull String r4) {
        Intrinsics.f(r4, "entranceActivity");
        LaunchSceneMonitor r0 = LaunchSceneMonitor.INSTANCE;
        r0.inject();
        this.entranceActivityName = r4;
        if (r0.launchWithAct() == false) goto L6;
        this.start = SystemClock.elapsedRealtime();
    L6:
        if (r0.launchWithMainAct() == false) goto L9;
        this.startWithMain = SystemClock.elapsedRealtime();
        markStart(PERIOD_APP_ATTACH);
        return;
    }
}

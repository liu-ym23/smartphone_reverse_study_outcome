package com.android.settings.teaevent;

import com.android.settings.SettingsApplication;
import com.android.settings.Utils;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.settings.utils.SysUtils;
import com.obric.olog.OLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppMetricsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0003\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001c\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0002J \u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u0004J\u001e\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u0004J\u0016\u0010+\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000bJ\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010/\u001a\u00020\u000bJ\u000e\u00100\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0004J\u0016\u00101\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004J\u001e\u00101\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u000bJ\u000e\u00103\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0004J\u0018\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u000107J\u0018\u00108\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020%J\u000e\u00109\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u0004J\u0016\u0010:\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010;\u001a\u00020%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/android/settings/teaevent/AppMetricsUtils;", "", "()V", "ACTIVITY_EVENT_ACTION", "", "DURATION_EVENT_SCENE", "FRAGMENT_EVENT_ACTION", "SWAP_EVENT_SCENE", "TAG", "TRANSITION_SCENE", "activityEventId", "", "coldStartTime", "getColdStartTime", "()J", "setColdStartTime", "(J)V", "durationMap", "", "durationMapUnique", "fragmentEventId", "startingActivity", "startingFragment", "swapMap", "visibleMap", "activityEventEnd", "", "targetActivity", "activityEventStart", "activityEventStoped", "currentActivity", "calcDeltaTime", "startTime", "callingPackageEvent", "callingPackage", "className", "isFragment", "", "durationEventEnd", "action", "timestamp", "length", "", "durationEventStart", "fragmentEventEnd", "fragmentEventStart", "startingF", "getNanoTimeMillis", "recordVisibleTime", "reportColdStartActivity", "coldStartTimePassed", "reportColdStartProvider", "reportSetLockCredentialError", "type", "error", "", "reportVisibleTime", "swapSceneEnd", "swapSceneStart", "checked", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppMetricsUtils {
    private static final String ACTIVITY_EVENT_ACTION = "activity_transition";
    private static final String DURATION_EVENT_SCENE = "duration_scene";
    private static final String FRAGMENT_EVENT_ACTION = "fragment_transition";
    public static final AppMetricsUtils INSTANCE = null;
    private static final String SWAP_EVENT_SCENE = "swap_scene";
    private static final String TAG = "AppMetricsUtils";
    private static final String TRANSITION_SCENE = "transition_scene";
    private static long activityEventId;
    private static long coldStartTime;
    private static final Map<String, Long> durationMap = null;
    private static final Map<String, Long> durationMapUnique = null;
    private static long fragmentEventId;
    private static String startingActivity;
    private static String startingFragment;
    private static final Map<String, Long> swapMap = null;
    private static final Map<String, Long> visibleMap = null;

    private AppMetricsUtils() {
    }

    private final long calcDeltaTime(long r3) {
        return getNanoTimeMillis() - r3;
    }

    static {
        INSTANCE = new AppMetricsUtils();
        startingActivity = "";
        startingFragment = "";
        durationMap = new ConcurrentHashMap();
        durationMapUnique = new ConcurrentHashMap();
        swapMap = new ConcurrentHashMap();
        visibleMap = new ConcurrentHashMap();
    }

    public final void activityEventStart(String r3) {
        if (r3 != null) goto L4;
        String r0 = "";
    L5:
        startingActivity = r0;
        activityEventId = getNanoTimeMillis();
        OLog.d(TAG, "activityEventStart " + r3 + " with " + activityEventId);
        return;
    L4:
        r0 = r3;
        goto L5
    }

    public final void activityEventEnd(String r9) {
        OLog.d(TAG, "activityEventEnd " + r9 + " with " + activityEventId);
        long r0 = activityEventId;
        if (r0 > 0) goto L5;
        return;
    L5:
        if (r9 != null) goto L7;
        r9 = "";
    L7:
        TeaEventReportUtil.INSTANCE.report("settings_transition_scene_activity_transition", MapsKt.mapOf(new Pair[]{TuplesKt.to("source_name", startingActivity), TuplesKt.to(IndexDatabaseHelper.IndexColumns.CLASS_NAME, r9), TuplesKt.to("delta_time", Long.valueOf(calcDeltaTime(r0)))}));
        activityEventId = 0;
        startingActivity = "";
    }

    public final void activityEventStoped(String r3) {
        OLog.d(TAG, "activityEventStoped " + r3 + " with " + activityEventId);
        activityEventId = 0;
    }

    public final void fragmentEventStart(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "startingF");
        Intrinsics.checkNotNullParameter(r4, "className");
        startingFragment = r3;
        fragmentEventId = getNanoTimeMillis();
        OLog.d(TAG, "fragmentEventStart " + r3 + " with " + fragmentEventId);
    }

    public final void fragmentEventEnd(String r8) {
        Intrinsics.checkNotNullParameter(r8, "className");
        OLog.d(TAG, "fragmentEventEnd " + r8 + " with " + fragmentEventId);
        long r0 = fragmentEventId;
        if (r0 <= 0) goto L6;
        TeaEventReportUtil.INSTANCE.report("settings_transition_scene_fragment_transition", MapsKt.mapOf(new Pair[]{TuplesKt.to("source_name", startingFragment), TuplesKt.to(IndexDatabaseHelper.IndexColumns.CLASS_NAME, r8), TuplesKt.to("delta_time", Long.valueOf(calcDeltaTime(r0)))}));
        fragmentEventId = 0;
        startingFragment = "";
        return;
    }

    public final void durationEventStart(String r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        String r5 = "settings_duration_scene_" + r4;
        long r0 = getNanoTimeMillis();
        durationMap.put(r5, Long.valueOf(r0));
        OLog.i(TAG, "durationEventStart " + r5 + " with " + r0);
    }

    public final void durationEventEnd(String r7) {
        Intrinsics.checkNotNullParameter(r7, "action");
        String r0 = "settings_duration_scene_" + r7;
        Map<String, Long> r1 = durationMap;
        Long r2 = r1.getOrDefault(r0, null);
        OLog.i(TAG, "durationEventEnd " + r0 + " with " + r2);
        if (r2 == null) goto L6;
        TeaEventReportUtil.INSTANCE.report("settings_duration_scene", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene_action", r7), TuplesKt.to("delta_time", Long.valueOf(calcDeltaTime(r2.longValue())))}));
        r1.remove(r0);
        return;
    }

    public final long getNanoTimeMillis() {
        return System.nanoTime() / ((long) 1000000);
    }

    public final void durationEventStart(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        String r1 = "settings_duration_scene_" + r2;
        durationMapUnique.put(r1, Long.valueOf(r3));
        OLog.i(TAG, "durationEventStart " + r1 + " with " + r3);
    }

    public final void durationEventEnd(String r5, long r6, int r8) {
        Intrinsics.checkNotNullParameter(r5, "action");
        String r0 = "settings_duration_scene_" + r5;
        Long r1 = durationMapUnique.getOrDefault(r0, null);
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.longValue() != r6) goto L9;
        long r7 = calcDeltaTime(r1.longValue());
        OLog.i(TAG, "durationEventEnd " + r0 + " with " + r1 + ", deltaTime=" + r7);
        TeaEventReportUtil.INSTANCE.report("settings_duration_scene", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene_action", r5), TuplesKt.to("delta_time", Long.valueOf(r7)), TuplesKt.to("count_for_sth", Integer.valueOf(r8))}));
        durationMap.remove(r0);
        return;
    }

    public final void swapSceneStart(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "action");
        StringBuilder r5 = new StringBuilder("settings_swap_scene_").append(r3).append('_');
        if (r4 == false) goto L5;
        String r6 = "on";
    L6:
        String r7 = r5.append(r6).toString();
        long r0 = getNanoTimeMillis();
        swapMap.put(r7, Long.valueOf(r0));
        OLog.i(TAG, "swapSceneStart " + r7 + " with " + r0);
        return;
    L5:
        r6 = "off";
        goto L6
    }

    public final void swapSceneEnd(String r11) {
        Intrinsics.checkNotNullParameter(r11, "action");
        String r0 = "settings_swap_scene_" + r11 + "_on";
        String r1 = "settings_swap_scene_" + r11 + "_off";
        Map<String, Long> r4 = swapMap;
        Long r6 = r4.getOrDefault(r0, null);
        if (r6 != null) goto L5;
        Long r5 = r4.getOrDefault(r1, null);
    L6:
        OLog.i(TAG, "swapSceneEnd " + r11 + " with " + r5);
        if (r5 == null) goto L14;
        long r7 = calcDeltaTime(r5.longValue());
        TeaEventReportUtil r10 = TeaEventReportUtil.INSTANCE;
        Pair[] r8 = new Pair[2];
        r8[0] = TuplesKt.to("delta_time", Long.valueOf(r7));
        if (r6 == null) goto L11;
        StringBuilder r12 = new StringBuilder().append(r11).append("_on");
    L12:
        r8[1] = TuplesKt.to("scene_action", r12.toString());
        r10.report("settings_swap_scene", MapsKt.mapOf(r8));
        r4.remove(r0);
        r4.remove(r1);
        return;
    L11:
        r12 = new StringBuilder().append(r11).append("_off");
        goto L12
    L14:
        return;
    L5:
        r5 = r6;
        goto L6
    }

    public static /* synthetic */ void callingPackageEvent$default(AppMetricsUtils r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.callingPackageEvent(r1, r2, r3);
    }

    public final void callingPackageEvent(String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "callingPackage");
        Intrinsics.checkNotNullParameter(r4, "className");
        TeaEventReportUtil.INSTANCE.report("settings_calling_package", MapsKt.mapOf(new Pair[]{TuplesKt.to("calling_package", r3), TuplesKt.to(IndexDatabaseHelper.IndexColumns.CLASS_NAME, r4), TuplesKt.to("is_fragment", Boolean.valueOf(r5))}));
    }

    public final long getColdStartTime() {
        return coldStartTime;
    }

    public final void setColdStartTime(long r1) {
        coldStartTime = r1;
    }

    public final void reportColdStartActivity(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "callingPackage");
        Intrinsics.checkNotNullParameter(r8, "className");
        if (coldStartTime != 0) goto L5;
        return;
    L5:
        long r0 = getNanoTimeMillis() - coldStartTime;
        OLog.i("AppLifecycle", "coldStartTime=" + coldStartTime + " deltaTime=" + r0);
        coldStartTime = 0;
        TeaEventReportUtil.INSTANCE.report("settings_cold_start_activity", MapsKt.mapOf(new Pair[]{TuplesKt.to("calling_package", r7), TuplesKt.to(IndexDatabaseHelper.IndexColumns.CLASS_NAME, r8), TuplesKt.to("delta_time", Long.valueOf(r0))}));
    }

    public final void reportColdStartActivity(String r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "callingPackage");
        Intrinsics.checkNotNullParameter(r5, "className");
        if (r6 != 0) goto L5;
        return;
    L5:
        long r0 = getNanoTimeMillis() - r6;
        OLog.i("AppLifecycle", "coldStartTimePassed=" + r6 + " deltaTime=" + r0);
        TeaEventReportUtil.INSTANCE.report("settings_cold_start_activity", MapsKt.mapOf(new Pair[]{TuplesKt.to("calling_package", r4), TuplesKt.to(IndexDatabaseHelper.IndexColumns.CLASS_NAME, r5), TuplesKt.to("delta_time", Long.valueOf(r0))}));
    }

    public final void reportColdStartProvider(String r7) {
        Intrinsics.checkNotNullParameter(r7, "className");
        if (coldStartTime != 0) goto L5;
        return;
    L5:
        long r0 = getNanoTimeMillis() - coldStartTime;
        coldStartTime = 0;
        TeaEventReportUtil.INSTANCE.report("settings_cold_start_provider", MapsKt.mapOf(new Pair[]{TuplesKt.to(IndexDatabaseHelper.IndexColumns.CLASS_NAME, r7), TuplesKt.to("delta_time", Long.valueOf(r0))}));
    }

    public final void recordVisibleTime(String r4) {
        Intrinsics.checkNotNullParameter(r4, "className");
        visibleMap.put(r4, Long.valueOf(getNanoTimeMillis()));
    }

    public static /* synthetic */ void reportVisibleTime$default(AppMetricsUtils r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.reportVisibleTime(r1, r2);
    }

    public final void reportVisibleTime(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "className");
        Long r4 = visibleMap.get(r5);
        if (r4 == null) goto L6;
        r4.longValue();
        long r0 = INSTANCE.getNanoTimeMillis() - r4.longValue();
        TeaEventReportUtil.INSTANCE.report("settings_visible_time", MapsKt.mapOf(new Pair[]{TuplesKt.to(IndexDatabaseHelper.IndexColumns.CLASS_NAME, r5), TuplesKt.to("delta_time", Long.valueOf(r0)), TuplesKt.to("is_fragment", Boolean.valueOf(r6))}));
        return;
    }

    public final void reportSetLockCredentialError(String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r4, "type");
        TeaEventReportUtil r3 = TeaEventReportUtil.INSTANCE;
        Pair[] r0 = new Pair[5];
        r0[0] = TuplesKt.to("cur_version", SysUtils.getOsOtaVersion());
        r0[1] = TuplesKt.to("set_lock_type", r4);
        r0[2] = TuplesKt.to("exception_msg", String.valueOf(r5));
        if (r5 == null) goto L7;
        Class<?> r6 = r5.getClass();
        if (r6 == null) goto L7;
        String r7 = r6.getName();
    L8:
        if (r7 != null) goto L10;
        r7 = "null";
    L10:
        r0[3] = TuplesKt.to("exception_type", r7);
        r0[4] = TuplesKt.to("is_device_setup_complete", Boolean.valueOf(Utils.isDeviceSetupComplete(SettingsApplication.getApplication())));
        r3.report("settings_set_lock_credential_error", MapsKt.mapOf(r0));
        return;
    L7:
        r7 = null;
        goto L8
    }
}

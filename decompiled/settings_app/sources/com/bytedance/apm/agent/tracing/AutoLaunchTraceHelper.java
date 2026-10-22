package com.bytedance.apm.agent.tracing;

import com.android.settings.utils.HanziToPinyin;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.thread.AsyncEventManager;
import obric.tablet.widget.BytedanceJustifyTextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AutoLaunchTraceHelper {
    private static long sAttachBaseContextEndTime = 0;
    private static long sAttachBaseContextStartTime = 0;
    private static long sConstructorEndTime = 0;
    private static long sConstructorStartTime = 0;
    private static boolean sIsValid = false;
    private static long sLauncherActivityCreateEndTime = 0;
    private static long sLauncherActivityCreateStartTime = 0;
    public static String sLauncherActivityName = null;
    private static long sLauncherActivityOnWindowFocusChangedTime = 0;
    private static long sLauncherActivityResumeEndTime = 0;
    private static long sLauncherActivityResumeStartTime = 0;
    private static long sLauncherActivityStartEndTime = 0;
    private static long sLauncherActivityStartStartTime = 0;
    private static long sMaxValidTimeMs = 15000;
    private static long sOnCreateEndTime;
    private static long sOnCreateStartTime;

    static {
    }

    public AutoLaunchTraceHelper() {
    }

    public static void assignAppTime(long r4, long r6, long r8, long r10, long r12, long r14) {
        LaunchAnalysisContext.getInstance().logD("assignAppTime: " + sOnCreateEndTime);
        sConstructorStartTime = r4;
        sConstructorEndTime = r6;
        sAttachBaseContextStartTime = r8;
        sAttachBaseContextEndTime = r10;
        sOnCreateStartTime = r12;
        sOnCreateEndTime = r14;
        ApmContext.setAppLaunchStartTimestamp(r4);
    }

    public static void launcherActivityOnCreateStart(String r11) {
        LaunchAnalysisContext r0 = LaunchAnalysisContext.getInstance();
        StringBuilder r1 = new StringBuilder().append(r11).append(" onCreateStart ").append(sLauncherActivityCreateStartTime).append(HanziToPinyin.Token.SEPARATOR);
        boolean r5 = false;
        if ((sLauncherActivityCreateStartTime - sOnCreateEndTime) >= 800) goto L5;
        boolean r4 = true;
    L6:
        r0.logD(r1.append(r4).toString());
        if (sLauncherActivityCreateStartTime != 0) goto L15;
        sLauncherActivityCreateStartTime = System.currentTimeMillis();
        LaunchAnalysisContext r2 = LaunchAnalysisContext.getInstance();
        StringBuilder r3 = new StringBuilder().append(r11).append(" onCreateStart ").append(sLauncherActivityCreateStartTime).append(BytedanceJustifyTextView.TWO_BLANK).append(sOnCreateEndTime).append(HanziToPinyin.Token.SEPARATOR);
        if ((sLauncherActivityCreateStartTime - sOnCreateEndTime) >= 800) goto L11;
        r5 = true;
    L11:
        r2.logD(r3.append(r5).toString());
        if ((sLauncherActivityCreateStartTime - sOnCreateEndTime) >= 800) goto L16;
        sIsValid = true;
        sLauncherActivityName = r11;
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r4 = false;
        goto L6
    }

    public static void launcherActivityOnCreateEnd() {
        LaunchAnalysisContext.getInstance().logD("onCreateEnd " + sLauncherActivityCreateStartTime + HanziToPinyin.Token.SEPARATOR + sLauncherActivityCreateEndTime);
        if (sLauncherActivityCreateEndTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityCreateEndTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnStartStart(String r4) {
        LaunchAnalysisContext.getInstance().logD(r4 + " onStart " + sLauncherActivityStartStartTime);
        if (sLauncherActivityStartStartTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityStartStartTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnStartEnd(String r4) {
        LaunchAnalysisContext.getInstance().logD("onStartEnd " + sLauncherActivityStartStartTime + HanziToPinyin.Token.SEPARATOR + sLauncherActivityStartEndTime);
        if (sLauncherActivityStartEndTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityStartEndTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnResumeStart(String r4) {
        LaunchAnalysisContext.getInstance().logD(r4 + " onResume " + sLauncherActivityResumeStartTime);
        if (sLauncherActivityResumeStartTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityResumeStartTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnResumeEnd() {
        LaunchAnalysisContext.getInstance().logD("onResumeEnd " + sLauncherActivityResumeStartTime + HanziToPinyin.Token.SEPARATOR + sLauncherActivityResumeEndTime);
        if (sLauncherActivityResumeEndTime == 0) goto L5;
        return;
    L5:
        if (sIsValid == false) goto L9;
        sLauncherActivityResumeEndTime = System.currentTimeMillis();
        return;
    }

    public static void launcherActivityOnWindowFocusChangedStart(String r5) {
        LaunchAnalysisContext.getInstance().logD("OnWindowFocusChanged " + r5 + HanziToPinyin.Token.SEPARATOR + sLauncherActivityOnWindowFocusChangedTime + HanziToPinyin.Token.SEPARATOR + sOnCreateStartTime + HanziToPinyin.Token.SEPARATOR + sIsValid);
        if (sLauncherActivityOnWindowFocusChangedTime == 0) goto L5;
    L9:
        AsyncEventManager.getInstance().post(new AnonymousClass1());
        return;
    L5:
        if (sOnCreateStartTime <= 0) goto L9;
        if (sIsValid == false) goto L9;
        sLauncherActivityOnWindowFocusChangedTime = System.currentTimeMillis();
        sLauncherActivityName = r5;
        sIsValid = false;
        goto L9
    }

    public static JSONArray assemblySpan() throws JSONException {
        JSONArray r0 = new JSONArray();
        JSONObject r1 = new JSONObject();
        r1.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        r1.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "app_constructor");
        r1.put("start", sConstructorStartTime);
        r1.put(TraceStatsConsts.STATS_KEY_END, sConstructorEndTime);
        JSONObject r6 = new JSONObject();
        r6.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        r6.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "app_attachBaseContext");
        r6.put("start", sAttachBaseContextStartTime);
        r6.put(TraceStatsConsts.STATS_KEY_END, sAttachBaseContextEndTime);
        JSONObject r7 = new JSONObject();
        r7.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        r7.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "app_onCreate");
        r7.put("start", sOnCreateStartTime);
        r7.put(TraceStatsConsts.STATS_KEY_END, sOnCreateEndTime);
        JSONObject r9 = new JSONObject();
        r9.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        r9.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "activity_onCreate");
        r9.put("start", sLauncherActivityCreateStartTime);
        r9.put(TraceStatsConsts.STATS_KEY_END, sLauncherActivityCreateEndTime);
        JSONObject r10 = new JSONObject();
        r10.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        r10.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "activity_onResume");
        r10.put("start", sLauncherActivityResumeStartTime);
        r10.put(TraceStatsConsts.STATS_KEY_END, sLauncherActivityResumeEndTime);
        JSONObject r11 = new JSONObject();
        r11.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        r11.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "activity_onStart");
        r11.put("start", sLauncherActivityStartStartTime);
        r11.put(TraceStatsConsts.STATS_KEY_END, sLauncherActivityStartEndTime);
        if (sLauncherActivityOnWindowFocusChangedTime <= 0) goto L5;
        JSONObject r8 = new JSONObject();
        r8.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, TraceStatsConsts.STATS_BASE_MODULE);
        r8.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, "activity_onWindowFocusChanged");
        r8.put("start", sLauncherActivityOnWindowFocusChangedTime);
        r0.put(r8);
    L5:
        r0.put(r1);
        r0.put(r6);
        r0.put(r7);
        r0.put(r9);
        r0.put(r10);
        r0.put(r11);
        return r0;
    }

    public static void setMaxValidTimeMs(long r0) {
        sMaxValidTimeMs = r0;
    }

    public static void reportStats() {
        if (ApmContext.getLaunchMode() != (-1)) goto L7;
        LaunchAnalysisContext.getInstance().logD("auto launch mode not init");     // Catch: JSONException -> L17
        return;
    L7:
        long r1 = sLauncherActivityOnWindowFocusChangedTime - sConstructorStartTime;     // Catch: JSONException -> L17
        if (r1 > 0) goto L10;
        return;
    L10:
        if (r1 > sMaxValidTimeMs) goto L20;
        JSONArray r2 = assemblySpan();     // Catch: JSONException -> L17
        JSONObject r3 = new JSONObject();     // Catch: JSONException -> L17
        r3.put("name", TraceStatsConsts.START_STATS_NAME);     // Catch: JSONException -> L17
        r3.put("start", sConstructorStartTime);     // Catch: JSONException -> L17
        r3.put(TraceStatsConsts.STATS_KEY_END, sLauncherActivityOnWindowFocusChangedTime);     // Catch: JSONException -> L17
        r3.put(TraceStatsConsts.STATS_KEY_SPANS, r2);     // Catch: JSONException -> L17
        r3.put(TraceStatsConsts.START_STATS_KEY_COLLECT_FROM, 1);     // Catch: JSONException -> L17
        r3.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, sLauncherActivityName);     // Catch: JSONException -> L17
        r3.put("launch_mode", ApmContext.getLaunchMode());     // Catch: JSONException -> L17
        JSONObject r9 = new JSONObject();     // Catch: JSONException -> L17
        r9.put(TraceStatsConsts.STATS_KEY_TRACE, r3);     // Catch: JSONException -> L17
        if (ApmContext.isDebugMode() == false) goto L15;
        LaunchAnalysisContext.getInstance().logD("auto span: " + r3);     // Catch: JSONException -> L17
    L15:
        CommonDataPipeline.getInstance().handle(new PerfData("start_trace", "", null, null, r9));     // Catch: JSONException -> L17
        return;
    L20:
        return;
    }
}

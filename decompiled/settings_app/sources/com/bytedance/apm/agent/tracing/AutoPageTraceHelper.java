package com.bytedance.apm.agent.tracing;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.trace.mapping.ApmPageLoadMappingTool;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AutoPageTraceHelper {
    private static boolean sIsFirstWindowFocusChangedActivity;
    private static long sMaxValidTimeMs;
    private static final HashSet<String> sMethodSet = null;
    private static final ConcurrentLinkedQueue<PageTraceEntity> sPageList = null;

    public AutoPageTraceHelper() {
    }

    static /* synthetic */ void access$000() {
        reportStats();
    }

    static {
        sMethodSet = new HashSet(32);
        sPageList = new ConcurrentLinkedQueue();
        sMaxValidTimeMs = TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS;
    }

    public static void setMaxValidTimeMs(long r0) {
        sMaxValidTimeMs = r0;
    }

    public static void onTrace(String r4, String r5, boolean r6) {
        if (TextUtils.equals("onCreate", r5) == false) goto L19;
        if (r6 == false) goto L13;
        if (sIsFirstWindowFocusChangedActivity == true) goto L8;
        AutoLaunchTraceHelper.launcherActivityOnCreateStart(r4);
    L8:
        ConcurrentLinkedQueue<PageTraceEntity> r7 = sPageList;
        if (r7.size() <= 50) goto L11;
        r7.poll();
    L11:
        r7.add(new PageTraceEntity(r4, System.currentTimeMillis()));
        return;
    L13:
        if (sIsFirstWindowFocusChangedActivity == true) goto L15;
        AutoLaunchTraceHelper.launcherActivityOnCreateEnd();
    L15:
        PageTraceEntity r8 = sPageList.peek();
        if (r8 == null) goto L57;
        r8.onCreateEndTs = System.currentTimeMillis();
        return;
    L57:
        return;
    L19:
        if (TextUtils.equals("onResume", r5) == false) goto L34;
        if (r6 == false) goto L28;
        if (sIsFirstWindowFocusChangedActivity == true) goto L24;
        AutoLaunchTraceHelper.launcherActivityOnResumeStart(r4);
    L24:
        PageTraceEntity r9 = sPageList.peek();
        if (r9 == null) goto L59;
        r9.onResumeStartTs = System.currentTimeMillis();
        return;
    L59:
        return;
    L28:
        if (sIsFirstWindowFocusChangedActivity == true) goto L30;
        AutoLaunchTraceHelper.launcherActivityOnResumeEnd();
    L30:
        PageTraceEntity r10 = sPageList.peek();
        if (r10 == null) goto L61;
        r10.onResumeEndTs = System.currentTimeMillis();
        return;
    L61:
        return;
    L34:
        if (TextUtils.equals("onWindowFocusChanged", r5) == false) goto L47;
        if (r6 == true) goto L37;
        return;
    L37:
        if (sIsFirstWindowFocusChangedActivity == true) goto L39;
        AutoLaunchTraceHelper.launcherActivityOnWindowFocusChangedStart(r4);
        sIsFirstWindowFocusChangedActivity = true;
    L39:
        PageTraceEntity r11 = sPageList.peek();
        if (r11 != null) goto L42;
        return;
    L42:
        if (r11.onWindowFocusTs != 0) goto L65;
        r11.onWindowFocusTs = System.currentTimeMillis();
        if (ApmPageLoadMappingTool.queryViewId(r4) != null) goto L66;
        AsyncEventManager.getInstance().post(new AnonymousClass1());
        return;
    L66:
        return;
    L65:
        return;
    L47:
        if (TextUtils.equals("onStart", r5) == false) goto L68;
        if (r6 == false) goto L53;
        if (sIsFirstWindowFocusChangedActivity == true) goto L69;
        AutoLaunchTraceHelper.launcherActivityOnStartStart(r4);
        return;
    L69:
        return;
    L53:
        if (sIsFirstWindowFocusChangedActivity == true) goto L71;
        AutoLaunchTraceHelper.launcherActivityOnStartEnd(r4);
        return;
    L71:
        return;
    }

    public static void reportViewIdStats(long r2, String r4) {
        PageTraceEntity r0 = sPageList.peek();
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r4, r0.pageName) == false) goto L10;
        r0.onViewShowTs = r2;
        AsyncEventManager.getInstance().post(new AnonymousClass2());
        return;
    }

    private static void reportStats() {
        int r3 = sPageList.size();     // Catch: Exception -> L39
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L58;
        ConcurrentLinkedQueue<PageTraceEntity> r5 = sPageList;     // Catch: Exception -> L39
        PageTraceEntity r6 = r5.peek();     // Catch: Exception -> L39
        if (r6 == null) goto L59;
        if (r6.onWindowFocusTs == 0) goto L10;
    L12:
        PageTraceEntity r7 = r5.poll();     // Catch: Exception -> L39
        if (r7.isCreateAndResumeValid() == false) goto L56;
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L39
        r8.put("name", "onCreate");     // Catch: Exception -> L39
        r8.put("start", r7.onCreateStartTs);     // Catch: Exception -> L39
        r8.put(TraceStatsConsts.STATS_KEY_END, r7.onCreateEndTs);     // Catch: Exception -> L39
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L39
        r9.put("name", "onResume");     // Catch: Exception -> L39
        r9.put("start", r7.onResumeStartTs);     // Catch: Exception -> L39
        r9.put(TraceStatsConsts.STATS_KEY_END, r7.onResumeEndTs);     // Catch: Exception -> L39
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L39
        r10.put("name", "onWindowFocusChanged");     // Catch: Exception -> L39
        r10.put("start", r7.onWindowFocusTs);     // Catch: Exception -> L39
        JSONArray r11 = new JSONArray();     // Catch: Exception -> L39
        r11.put(r8);     // Catch: Exception -> L39
        r11.put(r9);     // Catch: Exception -> L39
        r11.put(r10);     // Catch: Exception -> L39
        if (r7.onViewShowTs <= 0) goto L18;
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L39
        r12.put("name", "viewShow");     // Catch: Exception -> L39
        r12.put("start", r7.onViewShowTs);     // Catch: Exception -> L39
        r11.put(r12);     // Catch: Exception -> L39
    L18:
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L39
        r13.put("name", TraceStatsConsts.PAGE_LOAD_STATS_NAME);     // Catch: Exception -> L39
        r13.put("page_type", "activity");     // Catch: Exception -> L39
        r13.put("start", r7.onCreateStartTs);     // Catch: Exception -> L39
        if (r7.onViewShowTs <= 0) goto L25;
        r13.put(TraceStatsConsts.STATS_KEY_END, r7.onViewShowTs);     // Catch: Exception -> L39
        if ((r7.onViewShowTs - r7.onCreateStartTs) < 0) goto L38;
        if ((r7.onViewShowTs - r7.onCreateStartTs) > sMaxValidTimeMs) goto L38;
    L30:
        r13.put(TraceStatsConsts.STATS_KEY_SPANS, r11);     // Catch: Exception -> L39
        HashSet<String> r14 = sMethodSet;     // Catch: Exception -> L39
        if (r14.contains(r7.pageName) == false) goto L33;
        int r15 = 2;
    L34:
        r14.add(r7.pageName);     // Catch: Exception -> L39
        r13.put("launch_mode", r15);     // Catch: Exception -> L39
        r13.put(TraceStatsConsts.START_STATS_KEY_COLLECT_FROM, 1);     // Catch: Exception -> L39
        r13.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, r7.pageName);     // Catch: Exception -> L39
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L39
        r16.put(TraceStatsConsts.STATS_KEY_TRACE, r13);     // Catch: Exception -> L39
        if (ApmAlogHelper.isFeedbackALogEnabled() == false) goto L37;
        ApmAlogHelper.feedbackI("PageLoadTrace", r13.toString());     // Catch: Exception -> L39
    L37:
        MonitorTool.monitorPerformance("page_load_trace", null, null, r16);     // Catch: Exception -> L39
        goto L38
    L33:
        r15 = 1;
    L38:
        r4 = r4 + 1;
        goto L4
    L25:
        r13.put(TraceStatsConsts.STATS_KEY_END, r7.onWindowFocusTs);     // Catch: Exception -> L39
        if ((r7.onWindowFocusTs - r7.onCreateStartTs) < 0) goto L38;
        if ((r7.onWindowFocusTs - r7.onCreateStartTs) <= sMaxValidTimeMs) goto L30;
    L56:
        return;
    L10:
        if (r6.onViewShowTs != 0) goto L12;
        return;
    L59:
        return;
    L58:
        return;
    L39:
        e = move-exception;
        if (ApmContext.isDebugMode() == false) goto L57;
        e.printStackTrace();
        return;
    }
}

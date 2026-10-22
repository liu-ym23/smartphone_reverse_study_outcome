package com.bytedance.apm.agent.v2.instrumentation;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.thread.ApmHandlerThread;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.trace.TraceConfig;
import com.bytedance.apm.trace.mapping.ApmPageLoadMappingTool;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTimeAgent {
    private static final String TAG = "FragmentTimeAgent";
    private static long sCheckVisibilityStartTime = 0;
    private static String sFragmentName = null;
    private static long sMaxWaitTime = 60000;
    private static HashSet<String> sMethodSet;
    private static long sOnActivityCreatedEnd;
    private static long sOnActivityCreatedStart;
    private static long sOnCreateEnd;
    private static long sOnCreateStart;
    private static ViewTreeObserver.OnGlobalLayoutListener sOnGlobalLayoutListener;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnViewCreatedEnd;
    private static long sOnViewCreatedStart;
    private static boolean sReported;
    private static WeakReference<View> sRootViewRef;
    private static Runnable sWaitViewTimeoutRunnable;

    public FragmentTimeAgent() {
    }

    static /* synthetic */ String access$000() {
        return sFragmentName;
    }

    static /* synthetic */ HashSet access$100() {
        return sMethodSet;
    }

    static /* synthetic */ void access$200(boolean r0, String r1, long r2, long r4) {
        reportStats(r0, r1, r2, r4);
    }

    static /* synthetic */ WeakReference access$300() {
        return sRootViewRef;
    }

    static /* synthetic */ WeakReference access$302(WeakReference r0) {
        sRootViewRef = r0;
        return r0;
    }

    static /* synthetic */ long access$400() {
        return sCheckVisibilityStartTime;
    }

    static /* synthetic */ long access$402(long r0) {
        sCheckVisibilityStartTime = r0;
        return r0;
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$500() {
        return sOnGlobalLayoutListener;
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$502(ViewTreeObserver.OnGlobalLayoutListener r0) {
        sOnGlobalLayoutListener = r0;
        return r0;
    }

    static /* synthetic */ Runnable access$600() {
        return sWaitViewTimeoutRunnable;
    }

    static /* synthetic */ long access$700() {
        return sMaxWaitTime;
    }

    static /* synthetic */ void access$800(String r0, String r1, long r2, long r4) {
        reportTraceTime(r0, r1, r2, r4);
    }

    public static void onHiddenChanged(Fragment r6, boolean r7) {
        if (r7 == false) goto L12;
        return;
    L12:
        String r0 = r6.getClass().getCanonicalName();     // Catch: Exception -> L11
        Integer r2 = ApmPageLoadMappingTool.queryViewId(r0);     // Catch: Exception -> L11
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.intValue() <= 0) goto L15;
        registerOnGlobalLayoutListener(r0, r6.getView(), r2, System.currentTimeMillis(), TraceConfig.KEY_FRAGMENT_HIDECHANGED_TO_VIEW_SHOW_TIME);     // Catch: Exception -> L11
        return;
    L15:
        return;
    }

    public static void setUserVisibleHint(Fragment r6, boolean r7) {
        if (r7 == true) goto L4;
        return;
    L4:
        if (r6.isResumed() == true) goto L6;
        return;
    L6:
        if (r6.isHidden() == true) goto L22;
        String r0 = r6.getClass().getCanonicalName();     // Catch: Exception -> L15
        Integer r2 = ApmPageLoadMappingTool.queryViewId(r0);     // Catch: Exception -> L15
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.intValue() <= 0) goto L21;
        registerOnGlobalLayoutListener(r0, r6.getView(), r2, System.currentTimeMillis(), TraceConfig.KEY_FRAGMENT_VISIBLEHINT_TO_VIEW_SHOW_TIME);     // Catch: Exception -> L15
        return;
    L21:
        return;
    L23:
        return;
    }

    public static void onTrace(Fragment r3, String r4, String r5, boolean r6) {
        if (TextUtils.equals("onCreate", r5) == false) goto L13;
        if (r6 == false) goto L10;
        sFragmentName = r4;
        sOnCreateStart = System.currentTimeMillis();
        if (sMaxWaitTime != 0) goto L8;
        sMaxWaitTime = ApmDelegate.getInstance().getApmInitConfig().getMaxValidPageLoadTimeMs();
    L8:
        sReported = false;
        return;
    L10:
        if (isValid(r4) == false) goto L56;
        sOnCreateEnd = System.currentTimeMillis();
        return;
    L56:
        return;
    L13:
        if (TextUtils.equals("onViewCreated", r5) == false) goto L24;
        if (isValid(r4) == false) goto L24;
        if (r6 == false) goto L21;
        if (sOnCreateStart <= 0) goto L58;
        sOnViewCreatedStart = System.currentTimeMillis();
        return;
    L58:
        return;
    L21:
        if (sOnCreateStart <= 0) goto L60;
        sOnViewCreatedEnd = System.currentTimeMillis();
        return;
    L60:
        return;
    L24:
        if (TextUtils.equals("onActivityCreated", r5) == false) goto L35;
        if (isValid(r4) == false) goto L35;
        if (r6 == false) goto L32;
        if (sOnCreateStart <= 0) goto L62;
        sOnActivityCreatedStart = System.currentTimeMillis();
        return;
    L62:
        return;
    L32:
        if (sOnCreateStart <= 0) goto L64;
        sOnActivityCreatedEnd = System.currentTimeMillis();
        return;
    L64:
        return;
    L35:
        if (TextUtils.equals("onResume", r5) == true) goto L37;
        return;
    L37:
        if (isValid(r4) == false) goto L67;
        if (r6 == false) goto L43;
        if (sOnCreateStart <= 0) goto L68;
        sOnResumeStart = System.currentTimeMillis();
        onResumeShow(r3, r4);
        return;
    L68:
        return;
    L43:
        if (sOnCreateStart <= 0) goto L70;
        sOnResumeEnd = System.currentTimeMillis();
        Integer r7 = ApmPageLoadMappingTool.queryViewId(r4);     // Catch: Exception -> L52
        if (r7 != null) goto L48;
    L49:
        AsyncEventManager.getInstance().post(new AnonymousClass1());     // Catch: Exception -> L52
        goto L50
    L48:
        if (r7.intValue() <= 0) goto L49;
    L50:
        sReported = true;
        sFragmentName = null;
        return;
    L70:
        return;
    }

    private static void reportStats(boolean r9, String r10, long r11, long r13) {
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L12
        r3.put("name", "onCreate");     // Catch: Exception -> L12
        r3.put("start", sOnCreateStart);     // Catch: Exception -> L12
        r3.put(TraceStatsConsts.STATS_KEY_END, sOnCreateEnd);     // Catch: Exception -> L12
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L12
        r4.put("name", "onViewCreated");     // Catch: Exception -> L12
        r4.put("start", sOnViewCreatedStart);     // Catch: Exception -> L12
        r4.put(TraceStatsConsts.STATS_KEY_END, sOnViewCreatedEnd);     // Catch: Exception -> L12
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L12
        r5.put("name", "onActivityCreated");     // Catch: Exception -> L12
        r5.put("start", sOnActivityCreatedStart);     // Catch: Exception -> L12
        r5.put(TraceStatsConsts.STATS_KEY_END, sOnActivityCreatedEnd);     // Catch: Exception -> L12
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L12
        r6.put("name", "onResume");     // Catch: Exception -> L12
        r6.put("start", sOnResumeStart);     // Catch: Exception -> L12
        r6.put(TraceStatsConsts.STATS_KEY_END, sOnResumeEnd);     // Catch: Exception -> L12
        JSONArray r7 = new JSONArray();     // Catch: Exception -> L12
        r7.put(r3);     // Catch: Exception -> L12
        r7.put(r4);     // Catch: Exception -> L12
        r7.put(r5);     // Catch: Exception -> L12
        r7.put(r6);     // Catch: Exception -> L12
        if (r10 == null) goto L6;
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L12
        r8.put("name", r10);     // Catch: Exception -> L12
        r8.put("start", r11);     // Catch: Exception -> L12
        r8.put(TraceStatsConsts.STATS_KEY_END, r13);     // Catch: Exception -> L12
        r7.put(r8);     // Catch: Exception -> L12
    L6:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L12
        r12.put("name", TraceStatsConsts.PAGE_LOAD_STATS_NAME);     // Catch: Exception -> L12
        r12.put("page_type", "fragment");     // Catch: Exception -> L12
        r12.put("start", sOnCreateStart);     // Catch: Exception -> L12
        r12.put(TraceStatsConsts.STATS_KEY_SPANS, r7);     // Catch: Exception -> L12
        if (r9 == false) goto L9;
        int r14 = 2;
    L10:
        r12.put(TraceStatsConsts.STATS_KEY_LAUNCH_MODE, r14);     // Catch: Exception -> L12
        r12.put(TraceStatsConsts.START_STATS_KEY_COLLECT_FROM, 1);     // Catch: Exception -> L12
        r12.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, sFragmentName);     // Catch: Exception -> L12
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L12
        r15.put(TraceStatsConsts.STATS_KEY_TRACE, r12);     // Catch: Exception -> L12
        MonitorTool.monitorPerformance("page_load_trace", null, null, r15);     // Catch: Exception -> L12
        return;
    L9:
        r14 = 1;
    L12:
        e = move-exception;
        if (ApmContext.isDebugMode() == false) goto L19;
        e.printStackTrace();
        return;
    }

    private static void reportTraceTime(String r7, final String r8, final long r9, final long r11) {
        AsyncEventManager.getInstance().post(new AnonymousClass2(r8, r9, r11));
    }

    public static void onResumeShow(Fragment r7, String r8) {
        if (r7.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r7.isHidden() == true) goto L20;
        Integer r3 = ApmPageLoadMappingTool.queryViewId(r8);     // Catch: Exception -> L14
        if (r3 != null) goto L10;
        return;
    L10:
        if (r3.intValue() <= 0) goto L19;
        registerOnGlobalLayoutListener(r8, r7.getView(), r3, sOnCreateStart, TraceConfig.KEY_FRAGMENT_CREATE_TO_VIEW_SHOW_TIME);     // Catch: Exception -> L14
        return;
    L19:
        return;
    L21:
        return;
    }

    private static void registerOnGlobalLayoutListener(String r2, View r3, final Integer r4, final long r5, final String r7) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.intValue() <= 0) goto L21;
        sFragmentName = r2;
        WeakReference<View> r6 = sRootViewRef;
        if (r6 != null) goto L9;
    L18:
        sRootViewRef = new WeakReference(r3);
        sCheckVisibilityStartTime = 0;
        sOnGlobalLayoutListener = new AnonymousClass3(r4, r5, r7);
        r3.getViewTreeObserver().addOnGlobalLayoutListener(sOnGlobalLayoutListener);
        sWaitViewTimeoutRunnable = new AnonymousClass4();
        ApmHandlerThread.getDefaultMainHandler().postDelayed(sWaitViewTimeoutRunnable, sMaxWaitTime);
        return;
    L9:
        if (r6.get() == r3) goto L18;
        ViewTreeObserver r8 = sRootViewRef.get().getViewTreeObserver();
        if (r8.isAlive() == false) goto L16;
        ViewTreeObserver.OnGlobalLayoutListener r0 = sOnGlobalLayoutListener;
        if (r0 == null) goto L16;
        r8.removeOnGlobalLayoutListener(r0);
    L16:
        if (sWaitViewTimeoutRunnable == null) goto L18;
        ApmHandlerThread.getDefaultMainHandler().removeCallbacks(sWaitViewTimeoutRunnable);
        goto L18
    }

    static {
        sMethodSet = new HashSet(32);
    }

    private static boolean isValid(String r1) {
        if (sReported == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r1, sFragmentName) == false) goto L10;
        return true;
    L10:
        return false;
    }
}

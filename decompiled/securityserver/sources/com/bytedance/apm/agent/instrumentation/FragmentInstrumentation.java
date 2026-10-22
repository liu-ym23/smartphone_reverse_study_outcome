package com.bytedance.apm.agent.instrumentation;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.agent.helper.PageShowHelper;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.thread.ApmHandlerThread;
import com.bytedance.apm.trace.TraceConfig;
import com.bytedance.apm.trace.mapping.ApmPageLoadMappingTool;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class FragmentInstrumentation {
    private static final String TAG = "FragmentInstrumentation";
    private static long sCheckVisibilityStartTime;
    private static String sFragmentName;
    private static long sMaxWaitTime;
    private static HashSet<String> sMethodSet;
    private static long sOnActivityCreatedEnd;
    private static long sOnActivityCreatedStart;
    private static long sOnCreateEnd;
    private static String sOnCreateFragmentName;
    private static long sOnCreateStart;
    private static long sOnCreateTime;
    private static ViewTreeObserver.OnGlobalLayoutListener sOnGlobalLayoutListener;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnViewCreatedEnd;
    private static long sOnViewCreatedStart;
    private static WeakReference<View> sRootViewRef;
    private static Runnable sWaitViewTimeoutRunnable;

    static {
        sMethodSet = new HashSet(32);
    }

    public FragmentInstrumentation() {
    }

    public static /* synthetic */ WeakReference access$000() {
        return sRootViewRef;
    }

    public static /* synthetic */ WeakReference access$002(WeakReference r0) {
        sRootViewRef = r0;
        return r0;
    }

    public static /* synthetic */ long access$100() {
        return sCheckVisibilityStartTime;
    }

    public static /* synthetic */ long access$102(long r0) {
        sCheckVisibilityStartTime = r0;
        return r0;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$200() {
        return sOnGlobalLayoutListener;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$202(ViewTreeObserver.OnGlobalLayoutListener r0) {
        sOnGlobalLayoutListener = r0;
        return r0;
    }

    public static /* synthetic */ Runnable access$300() {
        return sWaitViewTimeoutRunnable;
    }

    public static /* synthetic */ long access$400() {
        return sMaxWaitTime;
    }

    public static /* synthetic */ String access$500() {
        return sFragmentName;
    }

    public static boolean isValid(String r1) {
        if (TextUtils.isEmpty(sFragmentName) == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r1, sFragmentName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Keep
    public static void onCreate(String r4) {
        sOnCreateFragmentName = r4;
        sOnCreateTime = System.currentTimeMillis();
        if (sMaxWaitTime != 0) goto L6;
        sMaxWaitTime = ApmDelegate.getInstance().getApmInitConfig().getMaxValidPageLoadTimeMs();
        return;
    }

    @Keep
    public static void onHiddenChanged(Fragment r6, boolean r7) {
        PageShowHelper.onPageShowHideAction(r6, !r7);
        if (r7 == true) goto L9;
        String r0 = r6.getClass().getCanonicalName();     // Catch: Exception -> L6
        registerOnGlobalLayoutListener(r0, r6.getView(), ApmPageLoadMappingTool.queryViewId(r0), System.currentTimeMillis(), TraceConfig.KEY_FRAGMENT_HIDECHANGED_TO_VIEW_SHOW_TIME);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Keep
    public static void onPause(Fragment r1) {
        if (r1.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r1.isHidden() == true) goto L9;
        PageShowHelper.onPageShowHideAction(r1, false);
        return;
    }

    @Keep
    public static void onResume(Fragment r7) {
        if (r7.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r7.isHidden() == true) goto L16;
        String r1 = r7.getClass().getCanonicalName();
        PageShowHelper.onPageShowHideAction(r7, true);     // Catch: Exception -> L12
        if (TextUtils.equals(r1, sOnCreateFragmentName) == true) goto L10;
        return;
    L10:
        Integer r3 = ApmPageLoadMappingTool.queryViewId(r1);     // Catch: Exception -> L12
        registerOnGlobalLayoutListener(r1, r7.getView(), r3, sOnCreateTime, TraceConfig.KEY_FRAGMENT_CREATE_TO_VIEW_SHOW_TIME);     // Catch: Exception -> L12
        return;
    L17:
        return;
    }

    @Keep
    public static void onTrace(Fragment r11, String r12, String r13, boolean r14) {
        if (TextUtils.equals("onCreate", r13) == false) goto L10;
        if (r14 == false) goto L7;
        sFragmentName = r12;
        sOnCreateStart = System.currentTimeMillis();
        return;
    L7:
        if (isValid(r12) == false) goto L55;
        sOnCreateEnd = System.currentTimeMillis();
        return;
    L55:
        return;
    L10:
        if (TextUtils.equals("onViewCreated", r13) == false) goto L21;
        if (isValid(r12) == false) goto L21;
        if (r14 == false) goto L18;
        if (sOnCreateStart <= 0) goto L57;
        sOnViewCreatedStart = System.currentTimeMillis();
        return;
    L57:
        return;
    L18:
        if (sOnCreateStart <= 0) goto L59;
        sOnViewCreatedEnd = System.currentTimeMillis();
        return;
    L59:
        return;
    L21:
        if (TextUtils.equals("onActivityCreated", r13) == false) goto L32;
        if (isValid(r12) == false) goto L32;
        if (r14 == false) goto L29;
        if (sOnCreateStart <= 0) goto L61;
        sOnActivityCreatedStart = System.currentTimeMillis();
        return;
    L61:
        return;
    L29:
        if (sOnCreateStart <= 0) goto L63;
        sOnActivityCreatedEnd = System.currentTimeMillis();
        return;
    L63:
        return;
    L32:
        if (TextUtils.equals("onResume", r13) == true) goto L34;
        return;
    L34:
        if (isValid(r12) == false) goto L66;
        if (r14 == false) goto L40;
        if (sOnCreateStart <= 0) goto L67;
        sOnResumeStart = System.currentTimeMillis();
        return;
    L67:
        return;
    L40:
        if (sOnCreateStart <= 0) goto L69;
        long r6 = System.currentTimeMillis();
        sOnResumeEnd = r6;
        if ((r6 - sOnCreateStart) < PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS) goto L52;
    L49:
        sOnCreateStart = 0;
        sFragmentName = null;
        return;
    L52:
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L51
        r15.put(AgentConstants.BEGIN_TIME, sOnCreateStart);     // Catch: Exception -> L51
        r15.put("end_time", sOnResumeEnd);     // Catch: Exception -> L51
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L51
        r7.put("onCreate", sOnCreateEnd - sOnCreateStart);     // Catch: Exception -> L51
        r7.put("onViewCreated", sOnViewCreatedEnd - sOnViewCreatedStart);     // Catch: Exception -> L51
        r7.put("onActivityCreated", sOnActivityCreatedEnd - sOnActivityCreatedStart);     // Catch: Exception -> L51
        r7.put("onResume", sOnResumeEnd - sOnResumeStart);     // Catch: Exception -> L51
        r7.put("fragment_create_to_resume", sOnResumeEnd - sOnCreateStart);     // Catch: Exception -> L51
        if (r11 != null) goto L46;
    L48:
        r15.put("page_type", "fragment");     // Catch: Exception -> L51
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L51
        r16.put("is_first", !sMethodSet.contains(sFragmentName + r13));     // Catch: Exception -> L51
        r16.put("scene", r12);     // Catch: Exception -> L51
        sMethodSet.add(sFragmentName + r13);     // Catch: Exception -> L51
        MonitorTool.monitorPerformance("page_load", r7, r16, r15);     // Catch: Exception -> L51
        goto L49
    L46:
        if (r11.getActivity() == null) goto L48;
        r15.put("attached_activity", r11.getActivity().getClass().getName());     // Catch: Exception -> L51
        goto L48
    L69:
        return;
    }

    @TargetApi(16)
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
        sOnGlobalLayoutListener = new AnonymousClass1(r4, r5, r7);
        r3.getViewTreeObserver().addOnGlobalLayoutListener(sOnGlobalLayoutListener);
        sWaitViewTimeoutRunnable = new AnonymousClass2();
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

    @Keep
    public static void setUserVisibleHint(Fragment r6, boolean r7) {
        if (r6.isResumed() == true) goto L5;
        return;
    L5:
        if (r6.isHidden() == true) goto L14;
        PageShowHelper.onPageShowHideAction(r6, r7);
        if (r7 == false) goto L15;
        String r0 = r6.getClass().getCanonicalName();     // Catch: Exception -> L10
        Integer r2 = ApmPageLoadMappingTool.queryViewId(r0);     // Catch: Exception -> L10
        registerOnGlobalLayoutListener(r0, r6.getView(), r2, System.currentTimeMillis(), TraceConfig.KEY_FRAGMENT_VISIBLEHINT_TO_VIEW_SHOW_TIME);     // Catch: Exception -> L10
        return;
    L16:
        return;
    L15:
        return;
    }
}

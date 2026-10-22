package com.bytedance.apm.agent.instrumentation;

import android.text.TextUtils;
import com.bytedance.apm.agent.helper.PageShowHelper;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.AgentConstants;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ActivityInstrumentation {
    private static final String TAG = "ActivityInstrumentation";
    static boolean isFirstWindowFocusChanged = false;
    private static String sActivityName;
    private static HashSet<String> sMethodSet;
    private static long sOnCreateEnd;
    private static long sOnCreateStart;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnWindowFocusedChangeStart;

    public ActivityInstrumentation() {
    }

    static {
        sMethodSet = new HashSet(32);
    }

    static boolean isValid(String r1) {
        if (TextUtils.isEmpty(sActivityName) == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r1, sActivityName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static void onTrace(String r10, String r11, boolean r12) {
        if (TextUtils.equals("onCreate", r11) == false) goto L13;
        if (r12 == false) goto L9;
        sActivityName = r10;
        sOnCreateStart = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L50;
        AppInstrumentation.launcherActivityOnCreateStart(sActivityName);
        return;
    L50:
        return;
    L9:
        if (isValid(r10) == false) goto L52;
        sOnCreateEnd = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L53;
        AppInstrumentation.launcherActivityOnCreateEnd();
        return;
    L53:
        return;
    L52:
        return;
    L13:
        boolean r3 = true;
        if (TextUtils.equals("onResume", r11) == false) goto L30;
        if (isValid(r10) == false) goto L30;
        if (r12 == false) goto L25;
        if (sOnCreateStart <= 0) goto L55;
        sOnResumeStart = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L23;
        AppInstrumentation.launcherActivityOnResumeStart(sActivityName);
    L23:
        PageShowHelper.onPageShowHideAction(sActivityName, true);
        return;
    L55:
        return;
    L25:
        if (sOnCreateStart <= 0) goto L57;
        sOnResumeEnd = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L58;
        AppInstrumentation.launcherActivityOnResumeEnd();
        return;
    L58:
        return;
    L57:
        return;
    L30:
        if (TextUtils.equals(AgentConstants.ON_WINDOW_FOCUS_CHANGED, r11) == true) goto L32;
        return;
    L32:
        if (isValid(r10) == true) goto L34;
        return;
    L34:
        if (sOnCreateStart > 0) goto L36;
        return;
    L36:
        if (isFirstWindowFocusChanged == true) goto L38;
        AppInstrumentation.launcherActivityOnWindowFocusChangedStart(sActivityName);
        isFirstWindowFocusChanged = true;
    L38:
        long r6 = System.currentTimeMillis();
        sOnWindowFocusedChangeStart = r6;
        if ((r6 - sOnCreateStart) < 5000) goto L48;
    L45:
        sOnCreateStart = 0;
        sActivityName = null;
        return;
    L48:
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L47
        r13.put(AgentConstants.BEGIN_TIME, sOnCreateStart);     // Catch: Exception -> L47
        r13.put("end_time", sOnWindowFocusedChangeStart);     // Catch: Exception -> L47
        r13.put("page_type", "activity");     // Catch: Exception -> L47
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L47
        r14.put("onCreate", sOnCreateEnd - sOnCreateStart);     // Catch: Exception -> L47
        r14.put("onResume", sOnResumeEnd - sOnResumeStart);     // Catch: Exception -> L47
        r14.put("activityOnCreateToWindowFocusChanged", sOnWindowFocusedChangeStart - sOnCreateStart);     // Catch: Exception -> L47
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L47
        r0.put("scene", sActivityName);     // Catch: Exception -> L47
        if (sMethodSet.contains(sActivityName + r11) == false) goto L44;
        r3 = false;
    L44:
        r0.put("is_first", r3);     // Catch: Exception -> L47
        sMethodSet.add(sActivityName + r11);     // Catch: Exception -> L47
        MonitorTool.monitorPerformance("page_load", r14, r0, r13);     // Catch: Exception -> L47
        goto L45
    }
}

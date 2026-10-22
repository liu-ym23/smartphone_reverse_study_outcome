package com.bytedance.apm.agent.instrumentation;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.helper.ApmAgentHelper;
import com.bytedance.apm.agent.monitor.MonitorTool;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ClickInstrumentation {
    private static final String ACTION_NAME = "view_click";
    private static final String CLICK_TYPE = "click_type";
    private static final String VIEW_ID = "view_id";
    private static final String VIEW_NAME = "view_name";
    private static final String VIEW_TEXT = "view_text";
    private static final int VIEW_TEXT_LENGTH_LIMIT = 100;

    public ClickInstrumentation() {
    }

    @Keep
    public static void onClick(View r5) {
        if (r5 != null) goto L46;
        return;
    L46:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L8
        Resources r2 = r5.getContext().getResources();     // Catch: Exception -> L8
        if (r5.getId() == (-1)) goto L11;
        r1.put(VIEW_ID, r5.getId());     // Catch: Exception -> L8
        r1.put(VIEW_NAME, r2.getResourceEntryName(r5.getId()));     // Catch: Exception -> L8
    L11:
        if ((r5 instanceof TextView) == false) goto L19;
        CharSequence r3 = ((TextView) r5).getText();     // Catch: Exception -> L8
        if (r3 == null) goto L19;
        String r4 = r3.toString();     // Catch: Exception -> L8
        if (r4.length() <= 100) goto L17;
        r4 = r4.substring(0, 100);     // Catch: Exception -> L8
    L17:
        r1.put(VIEW_TEXT, r4);     // Catch: Exception -> L8
    L19:
        if (r5.getParent() == null) goto L25;
        String r6 = r5.getParent().getClass().getSimpleName();     // Catch: Exception -> L8
        if (r5.getParent().getParent() == null) goto L23;
        r6 = r5.getParent().getParent().getClass().getSimpleName() + "#" + r6 + "#" + r5.getClass().getSimpleName();     // Catch: Exception -> L8
    L23:
        r1.put("view_path", r6);     // Catch: Exception -> L8
    L25:
        if (r5.getTag(ApmAgentHelper.VIEW_DATA_KEY_1) == null) goto L30;
        if (TextUtils.isEmpty(r5.getTag(ApmAgentHelper.VIEW_DATA_KEY_1).toString()) == true) goto L30;
        r1.put("view_tag_1", r5.getTag(ApmAgentHelper.VIEW_DATA_KEY_1).toString());     // Catch: Exception -> L8
    L30:
        if (r5.getTag(ApmAgentHelper.VIEW_DATA_KEY_2) == null) goto L35;
        if (TextUtils.isEmpty(r5.getTag(ApmAgentHelper.VIEW_DATA_KEY_2).toString()) == true) goto L35;
        r1.put("view_tag_2", r5.getTag(ApmAgentHelper.VIEW_DATA_KEY_2).toString());     // Catch: Exception -> L8
    L35:
        if (r5.getTag(ApmAgentHelper.VIEW_DATA_KEY_MAP) != null) goto L37;
    L42:
        r1.put(CLICK_TYPE, "View#OnClick");     // Catch: Exception -> L8
        MonitorTool.monitorUIAction(ACTION_NAME, "", r1);     // Catch: Exception -> L8
        return;
    L37:
        if ((r5.getTag(ApmAgentHelper.VIEW_DATA_KEY_MAP) instanceof Map) == false) goto L42;
        Iterator r7 = ((Map) r5.getTag(ApmAgentHelper.VIEW_DATA_KEY_MAP)).entrySet().iterator();     // Catch: Exception -> L8
    L40:
        if (r7.hasNext() == false) goto L42;
        Map.Entry r0 = (Map.Entry) r7.next();     // Catch: Exception -> L8
        r1.put("view_tag_map_" + r0.getKey().toString(), r0.getValue().toString());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    @Keep
    public static void onTabChanged(String r2) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put(VIEW_NAME, r2);     // Catch: Exception -> L4
        r0.put(CLICK_TYPE, "TabHost#OnTabChanged");     // Catch: Exception -> L4
        MonitorTool.monitorUIAction(ACTION_NAME, "", r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}

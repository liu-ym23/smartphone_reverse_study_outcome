package com.bytedance.apm.agent.v2.instrumentation;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.agent.monitor.MonitorTool;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ClickAgent {
    private static final String ACTION_NAME = "view_click";
    private static final String CLICK_TYPE = "click_type";
    private static final String VIEW_ID = "view_id";
    private static final String VIEW_NAME = "view_name";
    private static final String VIEW_TEXT = "view_text";
    private static final int VIEW_TEXT_LENGTH_LIMIT = 100;

    public ClickAgent() {
    }

    public static void onClick(View r5) {
        if (r5 != null) goto L29;
        return;
    L29:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L24
        Resources r2 = r5.getContext().getResources();     // Catch: Exception -> L24
        if (r5.getId() == (-1)) goto L9;
        r1.put(VIEW_ID, r5.getId());     // Catch: Exception -> L24
        r1.put(VIEW_NAME, r2.getResourceEntryName(r5.getId()));     // Catch: Exception -> L24
    L9:
        if ((r5 instanceof TextView) == false) goto L17;
        CharSequence r3 = ((TextView) r5).getText();     // Catch: Exception -> L24
        if (r3 == null) goto L17;
        String r4 = r3.toString();     // Catch: Exception -> L24
        if (r4.length() <= 100) goto L15;
        r4 = r4.substring(0, 100);     // Catch: Exception -> L24
    L15:
        r1.put(VIEW_TEXT, r4);     // Catch: Exception -> L24
    L17:
        if (r5.getParent() == null) goto L22;
        String r6 = r5.getParent().getClass().getSimpleName();     // Catch: Exception -> L24
        if (r5.getParent().getParent() == null) goto L21;
        r6 = r5.getParent().getParent().getClass().getSimpleName() + "#" + r6 + "#" + r5.getClass().getSimpleName();     // Catch: Exception -> L24
    L21:
        r1.put("view_path", r6);     // Catch: Exception -> L24
    L22:
        r1.put(CLICK_TYPE, "View#OnClick");     // Catch: Exception -> L24
        MonitorTool.monitorUIAction(ACTION_NAME, "", r1);     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        if (ApmContext.isDebugMode() == false) goto L31;
        e.printStackTrace();
        return;
    }

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

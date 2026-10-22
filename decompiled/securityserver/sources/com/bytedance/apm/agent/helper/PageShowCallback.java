package com.bytedance.apm.agent.helper;

import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.agent.v2.InstructOperationSwitch;
import com.bytedance.apm.internal.ApmDelegate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PageShowCallback {
    public PageShowCallback() {
    }

    public static void onPageShowHideAction(Object r3, boolean r4) {
        if (InstructOperationSwitch.sUiSwitch == true) goto L6;
        return;
    L6:
        if ((r3 instanceof String) == false) goto L8;
        String r0 = (String) r3;
    L9:
        JSONObject r1 = new JSONObject();
        if ((r3 instanceof IPageMonitor) == false) goto L13;
        r1.put("label", ((IPageMonitor) r3).getMonitorLabel());     // Catch: Exception -> L22
    L13:
        if (r4 == false) goto L15;
        String r5 = "page_show";
    L16:
        if (r4 == true) goto L18;
    L20:
        MonitorTool.monitorUIAction(r5, r0, r1);
        return;
    L18:
        if (ApmDelegate.getInstance().getApmInitConfig().getTraceListener() == null) goto L20;
        ApmDelegate.getInstance().getApmInitConfig().getTraceListener().pageShow(r0, true);
        goto L20
    L15:
        r5 = "page_hide";
        goto L16
    L8:
        r0 = r3.getClass().getName();
        goto L9
    }
}

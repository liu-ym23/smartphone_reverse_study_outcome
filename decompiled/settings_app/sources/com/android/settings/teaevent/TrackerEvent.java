package com.android.settings.teaevent;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TrackerEvent {
    public TrackerEvent() {
    }

    public static void buttonEvent(String r1, Map<String, Object> r2) {
        if (r2 != null) goto L4;
        r2 = new HashMap();
    L4:
        r2.put("click_for", r1);
        uploadEvent("button_click", r2);
    }

    public static void buttonEvent(String r2) {
        HashMap r0 = new HashMap();
        r0.put("click_for", r2);
        uploadEvent("button_click", r0);
    }

    public static void chooseEvent(String r2, String r3) {
        HashMap r0 = new HashMap();
        r0.put("scene", r2);
        r0.put("value", r3);
        uploadEvent("choose_event", r0);
    }

    public static void switchEvent(String r2, boolean r3) {
        HashMap r0 = new HashMap();
        r0.put("scene", r2);
        r0.put("is_enabled", Boolean.valueOf(r3));
        uploadEvent("switch_event", r0);
    }

    public static void uploadEvent(String r1, Map<String, Object> r2) {
        TeaEventReportUtil.INSTANCE.report(r1, r2);
    }
}

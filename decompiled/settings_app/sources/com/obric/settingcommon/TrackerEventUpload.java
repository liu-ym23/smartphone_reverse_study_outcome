package com.obric.settingcommon;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class TrackerEventUpload {
    private static volatile TrackerEventUpload sInstance;
    private EventUpload mEventUpload;

    public interface EventUpload {
        void uploadEvent(String r1, Map<String, Object> r2);
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
        getInstance().onEvent(r1, r2);
    }

    public static TrackerEventUpload getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(TrackerEventUpload.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TrackerEventUpload();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TrackerEventUpload.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private TrackerEventUpload() {
    }

    private void onEvent(String r1, Map<String, Object> r2) {
        EventUpload r0 = this.mEventUpload;
        if (r0 == null) goto L6;
        r0.uploadEvent(r1, r2);
        return;
    }

    public void setEventUpload(EventUpload r1) {
        this.mEventUpload = r1;
    }

    public void release() {
        this.mEventUpload = null;
        sInstance = null;
    }
}

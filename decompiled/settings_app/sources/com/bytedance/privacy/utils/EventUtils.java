package com.bytedance.privacy.utils;

import com.bytedance.privacy.bridge.IEventBridge;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class EventUtils {
    private static IEventBridge mEventBridge;

    public EventUtils() {
    }

    public static void init(IEventBridge r0) {
        mEventBridge = r0;
    }

    public static void onEvent(String r1, JSONObject r2) {
        IEventBridge r0 = mEventBridge;
        if (r0 == null) goto L6;
        r0.onEvent(r1, r2);
        return;
    }
}

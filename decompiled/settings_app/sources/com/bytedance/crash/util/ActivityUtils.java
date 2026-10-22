package com.bytedance.crash.util;

import java.util.concurrent.Callable;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityUtils {
    private static Callable<JSONArray> sActivityImpl;

    static {
    }

    public ActivityUtils() {
    }

    public static JSONArray getActivityTrack() {
        Callable<JSONArray> r0 = sActivityImpl;
        if (r0 != null) goto L9;
        return null;
    L9:
        return r0.call();
    L11:
        return null;
    }

    public static void setActivityImpl(Callable<JSONArray> r0) {
        sActivityImpl = r0;
    }
}

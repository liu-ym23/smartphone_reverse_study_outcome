package com.bytedance.crash.util;

import androidx.annotation.Nullable;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityUtils {
    private static Callable<JSONArray> sActivityImpl;

    public ActivityUtils() {
    }

    @Nullable
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

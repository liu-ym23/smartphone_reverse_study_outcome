package com.bytedance.ttnet.config;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public class ExperimentalSwitches {
    private static final AtomicBoolean sEnableJsonWrapperRefine = null;
    private static final AtomicBoolean sEnableTNCJsonoptRefine = null;

    public ExperimentalSwitches() {
    }

    static {
        sEnableJsonWrapperRefine = new AtomicBoolean(false);
        sEnableTNCJsonoptRefine = new AtomicBoolean(false);
    }

    public static boolean isEnableJsonWrapperRefine() {
        return sEnableJsonWrapperRefine.get();
    }

    public static boolean isEnableTNCJsonoptRefine() {
        return sEnableTNCJsonoptRefine.get();
    }

    public static void onServerConfigChanged(Object r5) {
    L15:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if ((r5 instanceof JsonOptConfig.JsonWrapper) == false) goto L20;
        AtomicBoolean r1 = sEnableJsonWrapperRefine;     // Catch: JSONException -> L15
        boolean r3 = true;
        if (((JsonOptConfig.JsonWrapper) r5).jsonObject().optJSONObject("data").optInt("enable_json_wrapper") <= 0) goto L8;
        boolean r2 = true;
    L9:
        r1.set(r2);     // Catch: JSONException -> L15
        AtomicBoolean r4 = sEnableTNCJsonoptRefine;     // Catch: JSONException -> L15
        if (((JsonOptConfig.JsonWrapper) r5).jsonObject().optJSONObject("data").optInt("enable_tnc_jsonopt") > 0) goto L13;
        r3 = false;
    L13:
        r4.set(r3);     // Catch: JSONException -> L15
        return;
    L8:
        r2 = false;
        goto L9
    }
}

package com.bytedance.ttnet.config;

import android.os.Build;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall;
import com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall;
import com.bytedance.ttnet.TTNetInit;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ExperimentalSwitches {
    private static final String TAG = "ExperimentalSwitches";
    private static final AtomicBoolean sDisableFallbackReasonBoot = null;
    private static final AtomicBoolean sDisableFallbackReasonCronetException = null;
    private static final AtomicBoolean sDisableFallbackReasonNullAppconfig = null;
    private static final AtomicBoolean sEnableJsonWrapperRefine = null;
    private static final AtomicBoolean sEnableTNCJsonoptRefine = null;
    private static final AtomicBoolean sEnableWithContainArmabi = null;
    private static final List<String> sMergeModelBlackList = null;

    public ExperimentalSwitches() {
    }

    static {
        sEnableJsonWrapperRefine = new AtomicBoolean(false);
        sEnableTNCJsonoptRefine = new AtomicBoolean(false);
        sEnableWithContainArmabi = new AtomicBoolean(false);
        sDisableFallbackReasonBoot = new AtomicBoolean(false);
        sDisableFallbackReasonCronetException = new AtomicBoolean(false);
        sDisableFallbackReasonNullAppconfig = new AtomicBoolean(true);
        sMergeModelBlackList = new CopyOnWriteArrayList();
    }

    public static boolean isEnableJsonWrapperRefine() {
        return sEnableJsonWrapperRefine.get();
    }

    public static boolean isEnableTNCJsonoptRefine() {
        return sEnableTNCJsonoptRefine.get();
    }

    public static boolean isEnableWithContainArmabi() {
        return sEnableWithContainArmabi.get();
    }

    public static boolean isDisableFallbackReasonBoot() {
        return sDisableFallbackReasonBoot.get();
    }

    public static boolean isDisableFallbackReasonCronetException() {
        return sDisableFallbackReasonCronetException.get();
    }

    public static boolean isDisableFallbackReasonNullAppconfig() {
        return sDisableFallbackReasonNullAppconfig.get();
    }

    public static List<String> getMergeModelBlackList() {
        return sMergeModelBlackList;
    }

    public static void onServerConfigChanged(Object r13) {
    L64:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        if ((r13 instanceof JsonOptConfig.JsonWrapper) == false) goto L11;
        JSONObject r14 = ((JsonOptConfig.JsonWrapper) r13).jsonObject();     // Catch: JSONException -> L64
        if (r14 == null) goto L9;
        JSONObject r15 = r14.optJSONObject("data");     // Catch: JSONException -> L64
    L16:
        if (r15 != null) goto L18;
        return;
    L18:
        AtomicBoolean r5 = sEnableJsonWrapperRefine;     // Catch: JSONException -> L64
        boolean r7 = false;
        if (r15.optInt("enable_json_wrapper") <= 0) goto L21;
        boolean r6 = true;
    L22:
        r5.set(r6);     // Catch: JSONException -> L64
        AtomicBoolean r8 = sEnableTNCJsonoptRefine;     // Catch: JSONException -> L64
        if (r15.optInt("enable_tnc_jsonopt") <= 0) goto L25;
        boolean r9 = true;
    L26:
        r8.set(r9);     // Catch: JSONException -> L64
        JSONObject r10 = r15.optJSONObject("cronet_fallback_config");     // Catch: JSONException -> L64
        if (r10 == null) goto L53;
        AtomicBoolean r11 = sEnableWithContainArmabi;     // Catch: JSONException -> L64
        if (r10.optInt("enable_with_contain_armabi") <= 0) goto L31;
        boolean r12 = true;
    L32:
        r11.set(r12);     // Catch: JSONException -> L64
        AtomicBoolean r16 = sDisableFallbackReasonBoot;     // Catch: JSONException -> L64
        if (r10.optInt("disable_reason_boot") <= 0) goto L35;
        boolean r17 = true;
    L36:
        r16.set(r17);     // Catch: JSONException -> L64
        AtomicBoolean r18 = sDisableFallbackReasonCronetException;     // Catch: JSONException -> L64
        if (r10.optInt("disable_reason_cronet_exception") <= 0) goto L39;
        boolean r19 = true;
    L40:
        r18.set(r19);     // Catch: JSONException -> L64
        AtomicBoolean r110 = sDisableFallbackReasonNullAppconfig;     // Catch: JSONException -> L64
        if (r10.optInt("disable_reason_null_appconfig", 1) <= 0) goto L43;
        boolean r111 = true;
    L44:
        r110.set(r111);     // Catch: JSONException -> L64
        JSONArray r20 = r10.optJSONArray("merge_model_black_list");     // Catch: JSONException -> L64
        List<String> r112 = sMergeModelBlackList;     // Catch: JSONException -> L64
        convertJsonArrayToList(r20, r112);     // Catch: JSONException -> L64
        if (r16.get() == false) goto L48;
        AppConfig.getInstance(TTNetInit.getTTNetDepend().getContext()).resetCronetBootSucceed();     // Catch: JSONException -> L64
    L48:
        if (r112.contains(Build.MODEL) == false) goto L51;
        AppConfig.sCronetUnsupportedModel = true;     // Catch: JSONException -> L64
    L51:
        if (Logger.debug() == false) goto L53;
        Logger.d(TAG, "sEnableWithContainArmabi is " + r11);     // Catch: JSONException -> L64
        Logger.d(TAG, "sDisableFallbackReasonCronetException is " + r18);     // Catch: JSONException -> L64
        Logger.d(TAG, "sDisableFallbackReasonBoot is " + r16);     // Catch: JSONException -> L64
        Logger.d(TAG, "sDisableFallbackReasonNullAppconfig is " + r110);     // Catch: JSONException -> L64
        goto L53
    L43:
        r111 = false;
        goto L44
    L39:
        r19 = false;
        goto L40
    L35:
        r17 = false;
        goto L36
    L31:
        r12 = false;
    L53:
        JSONObject r113 = r15.optJSONObject("ttnet_okio");     // Catch: JSONException -> L64
        if (r113 != null) goto L56;
        return;
    L56:
        if (r113.optInt("okio_read_enabled", 1) <= 0) goto L58;
        boolean r0 = true;
    L59:
        BaseSsCall.setTncUseOkioRead(r0);     // Catch: JSONException -> L64
        if (r113.optInt("zero_copy_enabled", 1) <= 0) goto L62;
        r7 = true;
    L62:
        BaseCronetSsCall.setTncUseZeroCopyRead(r7);     // Catch: JSONException -> L64
        return;
    L58:
        r0 = false;
        goto L59
    L25:
        r9 = false;
        goto L26
    L21:
        r6 = false;
        goto L22
    L9:
        r15 = null;
        goto L16
    L11:
        if ((r13 instanceof JSONObject) == true) goto L13;
    L15:
        r15 = (JSONObject) r13;     // Catch: JSONException -> L64
        goto L16
    L13:
        if (((JSONObject) r13).isNull("data") == true) goto L15;
        r15 = ((JSONObject) r13).optJSONObject("data");     // Catch: JSONException -> L64
        goto L16
    }

    private static void convertJsonArrayToList(JSONArray r2, List<String> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.clear();
        if (r2 != null) goto L7;
        return;
    L7:
        int r0 = 0;
    L9:
        if (r0 >= r2.length()) goto L15;
        r3.add(r2.getString(r0));     // Catch: JSONException -> L12
        r0 = r0 + 1;
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }
}

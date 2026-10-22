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

/* JADX INFO: loaded from: classes.dex */
public class ExperimentalSwitches {
    private static final String TAG = "ExperimentalSwitches";
    private static final AtomicBoolean sDisableFallbackReasonBoot = null;
    private static final AtomicBoolean sDisableFallbackReasonCronetException = null;
    private static final AtomicBoolean sDisableFallbackReasonNullAppconfig = null;
    private static final AtomicBoolean sEnableJsonWrapperRefine = null;
    private static final AtomicBoolean sEnableTNCJsonoptRefine = null;
    private static final AtomicBoolean sEnableWithContainArmabi = null;
    private static final List<String> sMergeModelBlackList = null;

    static {
        sEnableJsonWrapperRefine = new AtomicBoolean(false);
        sEnableTNCJsonoptRefine = new AtomicBoolean(false);
        sEnableWithContainArmabi = new AtomicBoolean(false);
        sDisableFallbackReasonBoot = new AtomicBoolean(false);
        sDisableFallbackReasonCronetException = new AtomicBoolean(false);
        sDisableFallbackReasonNullAppconfig = new AtomicBoolean(true);
        sMergeModelBlackList = new CopyOnWriteArrayList();
    }

    public ExperimentalSwitches() {
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

    public static List<String> getMergeModelBlackList() {
        return sMergeModelBlackList;
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

    public static boolean isEnableJsonWrapperRefine() {
        return sEnableJsonWrapperRefine.get();
    }

    public static boolean isEnableTNCJsonoptRefine() {
        return sEnableTNCJsonoptRefine.get();
    }

    public static boolean isEnableWithContainArmabi() {
        return sEnableWithContainArmabi.get();
    }

    public static void onServerConfigChanged(Object r13) {
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        if ((r13 instanceof JsonOptConfig.JsonWrapper) == false) goto L13;
        JSONObject r14 = ((JsonOptConfig.JsonWrapper) r13).jsonObject();     // Catch: JSONException -> L9
        if (r14 == null) goto L11;
        JSONObject r15 = r14.optJSONObject("data");     // Catch: JSONException -> L9
    L18:
        if (r15 != null) goto L20;
        return;
    L20:
        AtomicBoolean r5 = sEnableJsonWrapperRefine;     // Catch: JSONException -> L9
        boolean r7 = false;
        if (r15.optInt("enable_json_wrapper") <= 0) goto L23;
        boolean r6 = true;
    L24:
        r5.set(r6);     // Catch: JSONException -> L9
        AtomicBoolean r8 = sEnableTNCJsonoptRefine;     // Catch: JSONException -> L9
        if (r15.optInt("enable_tnc_jsonopt") <= 0) goto L27;
        boolean r9 = true;
    L28:
        r8.set(r9);     // Catch: JSONException -> L9
        JSONObject r10 = r15.optJSONObject("cronet_fallback_config");     // Catch: JSONException -> L9
        if (r10 == null) goto L55;
        AtomicBoolean r11 = sEnableWithContainArmabi;     // Catch: JSONException -> L9
        if (r10.optInt("enable_with_contain_armabi") <= 0) goto L33;
        boolean r12 = true;
    L34:
        r11.set(r12);     // Catch: JSONException -> L9
        AtomicBoolean r16 = sDisableFallbackReasonBoot;     // Catch: JSONException -> L9
        if (r10.optInt("disable_reason_boot") <= 0) goto L37;
        boolean r17 = true;
    L38:
        r16.set(r17);     // Catch: JSONException -> L9
        AtomicBoolean r18 = sDisableFallbackReasonCronetException;     // Catch: JSONException -> L9
        if (r10.optInt("disable_reason_cronet_exception") <= 0) goto L41;
        boolean r19 = true;
    L42:
        r18.set(r19);     // Catch: JSONException -> L9
        AtomicBoolean r110 = sDisableFallbackReasonNullAppconfig;     // Catch: JSONException -> L9
        if (r10.optInt("disable_reason_null_appconfig", 1) <= 0) goto L45;
        boolean r111 = true;
    L46:
        r110.set(r111);     // Catch: JSONException -> L9
        JSONArray r20 = r10.optJSONArray("merge_model_black_list");     // Catch: JSONException -> L9
        List<String> r112 = sMergeModelBlackList;     // Catch: JSONException -> L9
        convertJsonArrayToList(r20, r112);     // Catch: JSONException -> L9
        if (r16.get() == false) goto L50;
        AppConfig.getInstance(TTNetInit.getTTNetDepend().getContext()).resetCronetBootSucceed();     // Catch: JSONException -> L9
    L50:
        if (r112.contains(Build.MODEL) == false) goto L53;
        AppConfig.sCronetUnsupportedModel = true;     // Catch: JSONException -> L9
    L53:
        if (Logger.debug() == false) goto L55;
        Logger.d(TAG, "sEnableWithContainArmabi is " + r11);     // Catch: JSONException -> L9
        Logger.d(TAG, "sDisableFallbackReasonCronetException is " + r18);     // Catch: JSONException -> L9
        Logger.d(TAG, "sDisableFallbackReasonBoot is " + r16);     // Catch: JSONException -> L9
        Logger.d(TAG, "sDisableFallbackReasonNullAppconfig is " + r110);     // Catch: JSONException -> L9
        goto L55
    L45:
        r111 = false;
        goto L46
    L41:
        r19 = false;
        goto L42
    L37:
        r17 = false;
        goto L38
    L33:
        r12 = false;
    L55:
        JSONObject r113 = r15.optJSONObject("ttnet_okio");     // Catch: JSONException -> L9
        if (r113 != null) goto L58;
        return;
    L58:
        if (r113.optInt("okio_read_enabled", 1) <= 0) goto L60;
        boolean r0 = true;
    L61:
        BaseSsCall.setTncUseOkioRead(r0);     // Catch: JSONException -> L9
        if (r113.optInt("zero_copy_enabled", 1) <= 0) goto L64;
        r7 = true;
    L64:
        BaseCronetSsCall.setTncUseZeroCopyRead(r7);     // Catch: JSONException -> L9
        return;
    L60:
        r0 = false;
        goto L61
    L27:
        r9 = false;
        goto L28
    L23:
        r6 = false;
        goto L24
    L11:
        r15 = null;
        goto L18
    L13:
        if ((r13 instanceof JSONObject) == true) goto L15;
    L17:
        r15 = (JSONObject) r13;     // Catch: JSONException -> L9
        goto L18
    L15:
        if (((JSONObject) r13).isNull("data") == true) goto L17;
        r15 = ((JSONObject) r13).optJSONObject("data");     // Catch: JSONException -> L9
        goto L18
    }
}

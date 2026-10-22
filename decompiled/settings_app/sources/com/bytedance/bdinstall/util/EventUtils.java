package com.bytedance.bdinstall.util;

import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdinstall.oaid.OaidMonitor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class EventUtils {
    public EventUtils() {
    }

    public static void onDidFetchResult(InstallOptions r6, JSONObject r7, JSONObject r8) {
        JSONObject r0 = new JSONObject();
        if (r8 != null) goto L5;
    L7:
        boolean r9 = false;
    L8:
        JSONObject r1 = r7.optJSONObject("oaid");
        String r2 = null;
        if (r1 == null) goto L11;
        OaidModel r3 = OaidModel.create(r1.toString());
    L12:
        boolean r4 = TextUtils.isEmpty(r7.optString(Api.KEY_INSTALL_ID));
        boolean r5 = TextUtils.isEmpty(r7.optString("device_id"));
        r0.put("reqeust_did_success", r9);     // Catch: JSONException -> L19
        r0.put("empty_iid", r4);     // Catch: JSONException -> L19
        r0.put("empty_did", r5);     // Catch: JSONException -> L19
        if (r3 == null) goto L17;
        r2 = r3.oaid;     // Catch: JSONException -> L19
    L17:
        r0.put("dr_oaid", r2);     // Catch: JSONException -> L19
        r0.put("oaid_thread_switch_ts", OaidMonitor.getReadStartInitTs() - OaidMonitor.getInitTs());     // Catch: JSONException -> L19
        r0.put("oaid_file_load_ts", OaidMonitor.getStartSystemCall() - OaidMonitor.getReadStartInitTs());     // Catch: JSONException -> L19
        r0.put("oaid_sys_call_ts", OaidMonitor.getSystemCallFinished() - OaidMonitor.getStartSystemCall());     // Catch: JSONException -> L19
        r0.put("oaid_save_ts", OaidMonitor.getOnFinishFetchOaid() - OaidMonitor.getSystemCallFinished());     // Catch: JSONException -> L19
        r0.put("dr_wait_oaid_realtime", OaidMonitor.getRegisterWaitFinish() - OaidMonitor.getRegisterWaitOaid());     // Catch: JSONException -> L19
        r0.put("dr_wait_oaid_estimate_time", OaidMonitor.getRegisterWaitFinish() - OaidMonitor.getRegisterWaitOaid());     // Catch: JSONException -> L19
        r0.put("support_oaid", r7.optBoolean(SstLoader.KEY_OAID_SUPPORT));     // Catch: JSONException -> L19
        r0.put("oaid_impl", Oaid.instance(r6.getContext()).getImplName());     // Catch: JSONException -> L19
    L21:
        r6.getEventDepend().onEvent("did_fetch_result", r0);
        DrLog.v("did_fetch_result, " + r0);
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L11:
        r3 = null;
        goto L12
    L5:
        if (TextUtils.isEmpty(r8.optString("device_id_str")) == true) goto L7;
        r9 = true;
        goto L8
    }
}

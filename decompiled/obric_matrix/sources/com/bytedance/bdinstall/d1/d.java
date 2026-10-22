package com.bytedance.bdinstall.d1;

import android.text.TextUtils;
import com.bytedance.bdinstall.i0;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void a(i0 r6, JSONObject r7, JSONObject r8) {
        JSONObject r0 = new JSONObject();
        if (r8 != null) goto L5;
    L7:
        boolean r9 = false;
    L8:
        JSONObject r1 = r7.optJSONObject("oaid");
        String r2 = null;
        if (r1 == null) goto L11;
        com.bytedance.bdinstall.a1.e r3 = com.bytedance.bdinstall.a1.e.a(r1.toString());
    L12:
        boolean r4 = TextUtils.isEmpty(r7.optString("install_id"));
        boolean r5 = TextUtils.isEmpty(r7.optString(WsConstants.KEY_DEVICE_ID));
        r0.put("reqeust_did_success", r9);     // Catch: JSONException -> L19
        r0.put("empty_iid", r4);     // Catch: JSONException -> L19
        r0.put("empty_did", r5);     // Catch: JSONException -> L19
        if (r3 == null) goto L17;
        r2 = r3.f2652a;     // Catch: JSONException -> L19
    L17:
        r0.put("dr_oaid", r2);     // Catch: JSONException -> L19
        r0.put("oaid_thread_switch_ts", com.bytedance.bdinstall.a1.f.c() - com.bytedance.bdinstall.a1.f.a());     // Catch: JSONException -> L19
        r0.put("oaid_file_load_ts", com.bytedance.bdinstall.a1.f.f() - com.bytedance.bdinstall.a1.f.c());     // Catch: JSONException -> L19
        r0.put("oaid_sys_call_ts", com.bytedance.bdinstall.a1.f.g() - com.bytedance.bdinstall.a1.f.f());     // Catch: JSONException -> L19
        r0.put("oaid_save_ts", com.bytedance.bdinstall.a1.f.b() - com.bytedance.bdinstall.a1.f.g());     // Catch: JSONException -> L19
        r0.put("dr_wait_oaid_realtime", com.bytedance.bdinstall.a1.f.d() - com.bytedance.bdinstall.a1.f.e());     // Catch: JSONException -> L19
        r0.put("dr_wait_oaid_estimate_time", com.bytedance.bdinstall.a1.f.d() - com.bytedance.bdinstall.a1.f.e());     // Catch: JSONException -> L19
        r0.put("support_oaid", r7.optBoolean("oaid_may_support"));     // Catch: JSONException -> L19
        r0.put("oaid_impl", com.bytedance.bdinstall.a1.b.l(r6.t()).h());     // Catch: JSONException -> L19
    L21:
        r6.w().onEvent("did_fetch_result", r0);
        com.bytedance.bdinstall.q.g("did_fetch_result, " + r0);
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

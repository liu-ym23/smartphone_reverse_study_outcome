package com.bytedance.sdk.account.monitor;

import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.e;
import com.ss.android.i.j;
import d.b.s.a.l0.s;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(Throwable r3) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
        if (r3 == null) goto L5;
        r0.put("exception_stack_trace", Log.getStackTraceString(r3));     // Catch: Exception -> L7
        r0.put("exception_msg", r3.getMessage());     // Catch: Exception -> L7
    L5:
        r0.put("passport-sdk-version", 601339);     // Catch: Exception -> L7
        r0.put("sdkVersion", 2);     // Catch: Exception -> L7
        k("passport_common_err", r0);     // Catch: Exception -> L7
        return;
    }

    public static void b(String r16, String r17, String r18, d.b.s.a.q.j.b r19, JSONObject r20) {
        if (r19 == null) goto L23;
        String r0 = r19.f14893i;
        if (TextUtils.isEmpty(r0) == false) goto L7;
        r0 = r19.f14894j;
    L7:
        String r7 = r0;
        if (r20 == null) goto L25;
        JSONObject r2 = r20;
    L27:
        r2.put("logid", r19.f14885a);     // Catch: JSONException -> L20
        if ((r19 instanceof d.b.s.a.q.j.d) == false) goto L22;
        String r1 = ((d.b.s.a.q.j.d) r19).p;     // Catch: JSONException -> L20
        if (TextUtils.isEmpty(r1) == true) goto L22;
        r2.put("logout_from", r1);     // Catch: JSONException -> L20
    L22:
        JSONObject r8 = r2;
        c(r16, r19.f14888d, r17, r18, r19.f14887c, r19.f14892h, r7, r8);
        return;
    L20:
        e = e;
    L21:
        e.printStackTrace();
        goto L22
    L25:
        r2 = new JSONObject();     // Catch: JSONException -> L11
    L11:
        e = e;
        r2 = r20;
        goto L21
    L23:
        c(r16, null, r17, r18, false, -1, null, r20);
    }

    public static void c(String r1, String r2, String r3, String r4, boolean r5, int r6, String r7, JSONObject r8) {
        if (r8 == null) goto L19;
    L4:
        r8.put(WsConstants.KEY_PLATFORM, r3);     // Catch: JSONException -> L16
        r8.put("scene", r4);     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r8.put("urlpath", r2);     // Catch: JSONException -> L16
    L8:
        if (r5 == true) goto L10;
        r8.put("result", 0);     // Catch: JSONException -> L16
        r8.put("errorCode", r6);     // Catch: JSONException -> L16
        if (r7 == null) goto L14;
        r8.put("errDesc", r7);     // Catch: JSONException -> L16
    L14:
        r8.put("passport-sdk-version", 601339);     // Catch: JSONException -> L16
        r8.put("sdkVersion", 2);     // Catch: JSONException -> L16
        k(r1, r8);     // Catch: JSONException -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L10:
        r8.put("result", 1);     // Catch: JSONException -> L16
        goto L14
    L19:
        r8 = new JSONObject();     // Catch: JSONException -> L16
        goto L4
    }

    public static void d(String r2, int r3, String r4, String r5) {
        d.b.s.a.a0.a.d("AccountMonitorUtil", String.format("eventType=%s, errorMessage=%s, extraInfo=%s", new Object[]{r2, r4, r5}));
        if (com.bytedance.sdk.account.settings.f.a.l() == true) goto L8;
        return;
    L8:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
        r0.put("event_type", r2);     // Catch: Exception -> L7
        r0.put(WsConstants.ERROR_CODE, r3);     // Catch: Exception -> L7
        r0.put("error_desc", r4);     // Catch: Exception -> L7
        r0.put("extra_info", r5);     // Catch: Exception -> L7
        k("passport_full_path", r0);     // Catch: Exception -> L7
        return;
    }

    public static void e(JSONObject r1) {
        k("passport_net_request_monitor", r1);
    }

    public static void f(String r2, String r3, String r4, String r5, String r6, com.bytedance.sdk.account.settings.e.a r7) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("carrier", r2);     // Catch: Throwable -> L4
        r0.put("path", r3);     // Catch: Throwable -> L4
        r0.put("logid", r4);     // Catch: Throwable -> L4
        r0.put("ip_match", r5);     // Catch: Throwable -> L4
        r0.put("pre_ip_match", r6);     // Catch: Throwable -> L4
        r0.put("enable_cellular_opt", r7.g());     // Catch: Throwable -> L4
        r0.put("enable_ipv4_opt", r7.h());     // Catch: Throwable -> L4
        k("passport_ip_match_result", r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        d.b.s.a.a0.a.b("AccountMonitorUtil", "monitorIpMatchResult, " + th.getMessage());
    }

    public static void g(String r2, String r3, long r4, long r6, long r8) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("path", r2);     // Catch: JSONException -> L4
        r0.put("logid", r3);     // Catch: JSONException -> L4
        r0.put("duration_interceptor_request", r4);     // Catch: JSONException -> L4
        r0.put("duration_interceptor_response", r6);     // Catch: JSONException -> L4
        r0.put("duration_interceptor_process", r8);     // Catch: JSONException -> L4
        e(r0);     // Catch: JSONException -> L4
        return;
    }

    public static void h(String r2, String r3, long r4, int r6, String r7, String r8, boolean r9, int r10, boolean r11, boolean r12, boolean r13, long r14) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L28
        r0.put("host", r2);     // Catch: Throwable -> L28
        r0.put("path", r3);     // Catch: Throwable -> L28
        r0.put(TypedValues.TransitionType.S_DURATION, r4);     // Catch: Throwable -> L28
        r0.put(WsConstants.ERROR_CODE, r6);     // Catch: Throwable -> L28
        r0.put("error_desc", r7);     // Catch: Throwable -> L28
        r0.put("logid", r8);     // Catch: Throwable -> L28
        int r5 = 1;
        if (r9 == false) goto L5;
        int r15 = 1;
    L6:
        r0.put("request_x_tt_token", r15);     // Catch: Throwable -> L28
        r0.put("request_csrf_token", r10);     // Catch: Throwable -> L28
        if (r11 == false) goto L9;
        int r16 = 1;
    L10:
        r0.put("response_x_tt_token", r16);     // Catch: Throwable -> L28
        if (r12 == false) goto L13;
        int r17 = 1;
    L14:
        r0.put("response_csrf_token", r17);     // Catch: Throwable -> L28
        if (r13 == true) goto L18;
        r5 = 0;
    L18:
        r0.put("csrf_token_status", r5);     // Catch: Throwable -> L28
        e r18 = j.m();     // Catch: Throwable -> L28
        if (r18 != null) goto L24;
        long r19 = j.o();     // Catch: Throwable -> L28
        if (r19 <= 0) goto L23;
        r0.put("interval_from_sdk_init", r14 - r19);     // Catch: Throwable -> L28
    L23:
        k("passport_net_request_result", r0);     // Catch: Throwable -> L28
        return;
    L24:
        r18.a();     // Catch: Throwable -> L28
        throw null;
    L13:
        r17 = 0;
        goto L14
    L9:
        r16 = 0;
        goto L10
    L5:
        r15 = 0;
        goto L6
    }

    public static void i(String r2, Throwable r3, int r4, String r5) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L11
        r0.put("urlpath", new URI(r2).getPath().toLowerCase());     // Catch: Exception -> L11
        if (r3 == null) goto L7;
        r0.put("exception_class_name", r3.getClass().getName());     // Catch: Exception -> L11
        r0.put("exception_msg", r3.getMessage());     // Catch: Exception -> L11
    L9:
        r0.put("errorCode", r4);     // Catch: Exception -> L11
        r0.put("passport-sdk-version", 601339);     // Catch: Exception -> L11
        r0.put("sdkVersion", 2);     // Catch: Exception -> L11
        k("passport_net_err", r0);     // Catch: Exception -> L11
        return;
    L7:
        if (TextUtils.isEmpty(r5) == true) goto L9;
        r0.put("exception_msg", r5);     // Catch: Exception -> L11
    }

    public static void j(String r0, String r1, String r2, d.b.s.a.q.j.b r3, d.b.s.a.q.j.a r4) {
        if (r4 == null) goto L4;
        JSONObject r5 = r4.e(r0);
    L5:
        b(r0, r1, r2, r3, r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    public static void k(String r0, JSONObject r1) {
        a.c(r0, r1);
    }

    public static void l() {
        k("never_call_token_init", null);
    }

    public static void m(String r2, String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("supplement", r2);     // Catch: Throwable -> L4
        r0.put("match_template", r3);     // Catch: Throwable -> L4
        r0.put("map_info", r4);     // Catch: Throwable -> L4
        r0.put("scene", r5);     // Catch: Throwable -> L4
        k("passport_supplement_value_error", r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        d.b.s.a.a0.a.c("AccountMonitorUtil", "onSupplementValueError", th);
    }

    public static void n(String r2) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("token", s.j(r2));     // Catch: Throwable -> L4
        k("passport_token_value_error", r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        d.b.s.a.a0.a.c("AccountMonitorUtil", "onTokenValueError", th);
    }
}

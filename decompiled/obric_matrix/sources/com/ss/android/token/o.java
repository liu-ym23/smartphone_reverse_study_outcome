package com.ss.android.token;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.android.sdk.bdticketguard.d0;
import com.bytedance.android.sdk.bdticketguard.z0;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.wschannel.WsConstants;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashSet<String> f12257a;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f12258f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f12259g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ a[] f12260h = null;

        static {
            a r0 = new a("ignore", 0);
            f12258f = r0;
            a r1 = new a("logout", 1);
            f12259g = r1;
            f12260h = new a[]{r0, r1};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f12260h.clone();
        }
    }

    static {
        f12257a = new HashSet();
    }

    public static void A(long r2, String r4) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("uid", String.valueOf(r2));     // Catch: JSONException -> L4
        r0.put("token", d.b.s.a.l0.s.j(r4));     // Catch: JSONException -> L4
        C("passport_user_mixed_uid_reveal", r0);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        d.b.s.a.a0.a.c("AccountSDK", "monitorUserMixedUidReveal error", e);
    }

    public static void B(long r1, long r3, String r5, String r6, boolean r7, boolean r8, String r9) {
        if (com.bytedance.sdk.account.settings.f.a.l() == true) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder();
        if (r7 == false) goto L8;
        r0.append("tee");
    L8:
        if (r8 == true) goto L10;
    L13:
        JSONObject r10 = new JSONObject();
        r10.put("settings_duration", r1);     // Catch: Exception -> L17
        r10.put("total_duration", r3);     // Catch: Exception -> L17
        r10.put("host", r5);     // Catch: Exception -> L17
        r10.put("path", r6);     // Catch: Exception -> L17
        r10.put("sign_type", r0.toString());     // Catch: Exception -> L17
        r10.put("trigger_type", r9);     // Catch: Exception -> L17
    L15:
        com.bytedance.sdk.account.monitor.c.d("x_tt_token_guard", 0, null, r10.toString());
        return;
    L10:
        if (r0.length() <= 0) goto L12;
        r0.append(",");
    L12:
        r0.append("ree");
        goto L13
    }

    public static void C(String r3, JSONObject r4) {
        if (r4 != null) goto L9;
    L7:
        com.bytedance.sdk.account.monitor.a.c(r3, r4);
        return;
    L9:
        r4.put("token_config_version", com.bytedance.sdk.account.ticketguard.f.d());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        d.b.s.a.a0.a.c("AccountSDK", "onEvent error", e);
        goto L7
    }

    public static void D(String r2, String r3, String r4, String r5, boolean r6) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L17
        if (TextUtils.isEmpty(r4) == true) goto L6;
        r0.put("logid", r4);     // Catch: JSONException -> L17
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r0.put("urlpath", r3);     // Catch: JSONException -> L17
    L8:
        r0.put("sdkVersion", 2);     // Catch: JSONException -> L17
        if (TextUtils.isEmpty(r5) == true) goto L12;
        r0.put(WsConstants.KEY_EXTRA, r5);     // Catch: JSONException -> L17
    L12:
        if (r6 == false) goto L14;
        String r7 = LocationInfoConst.ALLOW_USE_LOCATION;
    L15:
        r0.put("user_was_login", r7);     // Catch: JSONException -> L17
        r0.put("result", 0);     // Catch: JSONException -> L17
        C(r2, r0);     // Catch: JSONException -> L17
        return;
    L14:
        r7 = BDLocationException.ERROR_TIMEOUT;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public static void E() {
        C("syn_login_status_error", null);
    }

    public static void F(String r2, JSONObject r3) {
        if (r3 == null) goto L9;
    L4:
        r3.put("result", 0);     // Catch: JSONException -> L6
        C(r2, r3);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        r3 = new JSONObject();     // Catch: JSONException -> L6
        goto L4
    }

    public static void a(boolean r4, boolean r5, boolean r6, boolean r7, String r8, String r9, long r10, boolean r12) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L24
        int r2 = 1;
        if (r4 == false) goto L5;
        int r11 = 1;
    L6:
        r0.put("is_login", r11);     // Catch: Throwable -> L24
        if (r5 == false) goto L9;
        int r13 = 1;
    L10:
        r0.put("sessionid", r13);     // Catch: Throwable -> L24
        if (r6 == false) goto L13;
        String r14 = "default";
    L14:
        r0.put("xtttoken_location", r14);     // Catch: Throwable -> L24
        if (r7 == false) goto L17;
        int r15 = 1;
    L18:
        r0.put("has_tssign", r15);     // Catch: Throwable -> L24
        r0.put("csrf_token_location", r8);     // Catch: Throwable -> L24
        r0.put("extra_headers", r9);     // Catch: Throwable -> L24
        r0.put("uid", String.valueOf(r10));     // Catch: Throwable -> L24
        if (r12 == true) goto L22;
        r2 = 0;
    L22:
        r0.put("token_contains_sessionid", r2);     // Catch: Throwable -> L24
        C("passport_load_login_token", r0);     // Catch: Throwable -> L24
        return;
    L17:
        r15 = 0;
        goto L18
    L13:
        r14 = "none";
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r11 = 0;
    L24:
        th = move-exception;
        th.printStackTrace();
    }

    public static String b(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L15;
    L14:
        return r3;
    L15:
        URI r0 = new URI(r3);     // Catch: Exception -> L12
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r0.getHost()) == true) goto L8;
        r1.append(r0.getHost());     // Catch: Exception -> L12
    L8:
        if (TextUtils.isEmpty(r0.getPath()) == true) goto L10;
        r1.append(r0.getPath());     // Catch: Exception -> L12
    L10:
        return r1.toString();
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static void c(String r2, String r3) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put(TypedValues.TransitionType.S_FROM, r2);     // Catch: JSONException -> L4
        r0.put("old_token", d.b.s.a.l0.s.j(r3));     // Catch: JSONException -> L4
        C("passport_login_token_update", r0);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void d(String r2, String r3, JSONObject r4) {
        if (r4 == null) goto L17;
    L4:
        r4.put("error_name", r2);     // Catch: Exception -> L14
        r4.put("error_message", r3);     // Catch: Exception -> L14
        int r0 = 1;
        if (d.b.s.a.l0.l.f(com.ss.android.i.j.j()) == false) goto L7;
        int r5 = 1;
    L8:
        r4.put("network_available", r5);     // Catch: Exception -> L14
        if (d.b.s.a.l0.d.k() == true) goto L12;
        r0 = 0;
    L12:
        r4.put("app_in_foreground", r0);     // Catch: Exception -> L14
        F("token_config_err_v2", r4);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        r5 = 0;
        goto L8
    L17:
        r4 = new JSONObject();     // Catch: Exception -> L14
        goto L4
    }

    public static void e(String r2, String r3) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("path", r2);     // Catch: JSONException -> L4
        r0.put("logid", r3);     // Catch: JSONException -> L4
        com.bytedance.sdk.account.monitor.c.k("passport_device_transfer", r0);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        d.b.s.a.a0.a.c("AccountSDK", "monitorDeviceTransfer error", e);
    }

    public static void f(Throwable r3) {
        r3.printStackTrace();     // Catch: Exception -> L8
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L8
        r0.put("exception_msg", r3.getMessage());     // Catch: Exception -> L8
        r0.put("exception_stack_trace", Log.getStackTraceString(r3));     // Catch: Exception -> L8
        F("tt_token_exception", r0);     // Catch: Exception -> L8
        com.ss.android.e r4 = com.ss.android.i.j.m();     // Catch: Exception -> L8
        if (r4 == null) goto L13;
        r4.c();     // Catch: Exception -> L8
        throw null;
    L13:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void g(String r2, String r3, boolean r4) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L8
        r0.put("host", r2);     // Catch: Throwable -> L8
        r0.put("path", r3);     // Catch: Throwable -> L8
        if (r4 == false) goto L5;
        int r5 = 1;
    L6:
        r0.put("xtoken", r5);     // Catch: Throwable -> L8
        C("passport_http_with_xtoken", r0);     // Catch: Throwable -> L8
        return;
    L5:
        r5 = 0;
    L8:
        th = move-exception;
        th.printStackTrace();
    }

    public static void h(String r2, String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put("host", r2);     // Catch: Exception -> L4
        r0.put("path", r3);     // Catch: Exception -> L4
        r0.put("logid", r4);     // Catch: Exception -> L4
        r0.put("token", r5);     // Catch: Exception -> L4
        F("passport_mfa_token_update", r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void i(String r3, Set<String> r4) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L9
        URI r1 = new URI(r3);     // Catch: Exception -> L9
        String r5 = r1.getHost();     // Catch: Exception -> L9
        if (r1.getPath().startsWith("/passport/") == true) goto L6;
        return;
    L6:
        if (f12257a.contains(r5) == true) goto L14;
        f12257a.add(r5);     // Catch: Exception -> L9
        r0.put("host", r5);     // Catch: Exception -> L9
        r0.put("tt_account_share_token_domains", r4.toString());     // Catch: Exception -> L9
        F("passport_request_without_x_tt_token", r0);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public static void j() {
        F("tt_token_not_call_add_host_list", null);
    }

    public static void k(String r8, String r9, String r10) {
        if (com.bytedance.sdk.account.ticketguard.f.n() == true) goto L8;
        return;
    L8:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
        r0.put("host", r8);     // Catch: Exception -> L7
        r0.put("path", r9);     // Catch: Exception -> L7
        r0.put("reason", r10);     // Catch: Exception -> L7
        z0.f1102e.p("account_not_mark_get", "all", 0, r9 + " not mark get ticket", r0.toString(), null);     // Catch: Exception -> L7
        return;
    }

    public static void l(String r2) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("path", r2);     // Catch: JSONException -> L4
        C("passport_request_not_use_account_sdk", r0);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        d.b.s.a.a0.a.c("AccountSDK", "monitorUserMixed error", e);
    }

    public static void m(String r8, String r9, String r10, List<m> r11, Collection<String> r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (r12.isEmpty() == true) goto L59;
        HashSet r0 = new HashSet(r12);
        r0.add("X-Tt-Token".toLowerCase());
        HashMap r1 = new HashMap();
        if (r11 != null) goto L9;
    L16:
        StringBuffer r13 = new StringBuffer();
        Iterator r2 = r0.iterator();
        int r3 = 0;
        boolean r4 = false;
        boolean r5 = false;
    L18:
        if (r2.hasNext() == false) goto L29;
        String r6 = (String) r2.next();
        if (r6 == null) goto L18;
        String r7 = r6.toLowerCase();
        if (r13.length() <= 0) goto L25;
        r13.append(",");
    L25:
        r13.append(r7);
        r13.append("=");
        if (TextUtils.isEmpty((String) r1.get(r7)) == false) goto L27;
        r13.append(0);
        r5 = true;
        goto L18
    L27:
        r13.append(1);
        r4 = true;
        goto L18
    L29:
        if (r4 == false) goto L58;
        if (r5 == false) goto L60;
        d.b.s.a.a0.a.a("TTTokenMonitor", "response extra headers no identical: " + r13);
        JSONObject r14 = new JSONObject();
        r14.put("host", r8);     // Catch: Exception -> L38
        r14.put("path", r9);     // Catch: Exception -> L38
        r14.put("logid", r10);     // Catch: Exception -> L38
        if (r1.containsKey("X-Tt-Token") == false) goto L36;
        r3 = 1;
    L36:
        r14.put("x_tt_token", r3);     // Catch: Exception -> L38
        r14.put("extra_headers", r13.toString());     // Catch: Exception -> L38
    L40:
        C("passport_response_extra_header", r14);
        return;
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L60:
        return;
    L58:
        return;
    L9:
        if (r11.isEmpty() == true) goto L16;
        Iterator<m> r15 = r11.iterator();
    L12:
        if (r15.hasNext() == false) goto L16;
        m r16 = r15.next();
        if (TextUtils.isEmpty(r16.a()) == true) goto L12;
        r1.put(r16.a().toLowerCase(), r16.b());
        goto L12
    }

    public static void n(String r2, String r3, String r4, String r5, long r6) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("path", r2);     // Catch: JSONException -> L4
        r0.put("logid", r3);     // Catch: JSONException -> L4
        r0.put("body_session_key", d.b.s.a.l0.s.h(r4));     // Catch: JSONException -> L4
        r0.put("header_keys", r5);     // Catch: JSONException -> L4
        r0.put("uid", r6);     // Catch: JSONException -> L4
        com.bytedance.sdk.account.monitor.c.k("passport_response_header_sessionid_miss", r0);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        d.b.s.a.a0.a.c("AccountSDK", "monitorResponseHeaderSessionIdMiss error", e);
    }

    public static void o() {
        JSONObject r0 = new JSONObject();
        r0.put("sdk_aid", 71769);     // Catch: Exception -> L5
        r0.put("sdk_version", "0.6.1-alpha.319-matrix");     // Catch: Exception -> L5
    L7:
        C("sdk_session_launch", r0);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void p(String r5, List r6, boolean r7) {
        String r0 = "";
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L18
        if (r6 != null) goto L5;
    L16:
        String r8 = r1.toString();     // Catch: Exception -> L18
        D("tt_token_logout", b(r5), r0, r8, r7);     // Catch: Exception -> L18
        return;
    L5:
        if (r6.isEmpty() == true) goto L16;
        Iterator r9 = r6.iterator();     // Catch: Exception -> L18
    L8:
        if (r9.hasNext() == false) goto L16;
        Object r2 = r9.next();     // Catch: Exception -> L18
        if ((r2 instanceof m) == true) goto L12;
        if (r2 == null) goto L8;
        r1.append(r2.toString());     // Catch: Exception -> L18
        r1.append(";");     // Catch: Exception -> L18
        goto L8
    L12:
        if ("X-TT-LOGID".equalsIgnoreCase(((m) r2).a()) == false) goto L8;
        r0 = ((m) r2).b();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        f(e);
    }

    public static void q(String r2, String r3, String r4, String r5, a r6) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put("scene", r2);     // Catch: Exception -> L4
        r0.put("from_host", r3);     // Catch: Exception -> L4
        r0.put("from_path", r4);     // Catch: Exception -> L4
        r0.put("from_logid", r5);     // Catch: Exception -> L4
        r0.put("handle", r6.name());     // Catch: Exception -> L4
        C("passport_session_expired_result", r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f(e);
    }

    public static void r(String r2, List<m> r3, int r4, String r5) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L16
        r0.put(WsConstants.ERROR_CODE, r4);     // Catch: Exception -> L16
        r0.put("error_code_msg", r5);     // Catch: Exception -> L16
        StringBuilder r6 = new StringBuilder();     // Catch: Exception -> L16
        if (r3 != null) goto L5;
    L14:
        r0.put(WsConstants.KEY_EXTRA, r6.toString());     // Catch: Exception -> L16
        F(r2, r0);     // Catch: Exception -> L16
        return;
    L5:
        if (r3.isEmpty() == true) goto L14;
        Iterator<m> r7 = r3.iterator();     // Catch: Exception -> L16
    L8:
        if (r7.hasNext() == false) goto L14;
        m r8 = r7.next();     // Catch: Exception -> L16
        if ((r8 instanceof m) == true) goto L11;
        if (r8 == null) goto L8;
        r6.append(r8.toString());     // Catch: Exception -> L16
        r6.append(";");     // Catch: Exception -> L16
        goto L8
    L11:
        r0.put(r8.a(), r8.b());     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
    }

    public static void s(String r2, String r3) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put("token", p.O(r2));     // Catch: Exception -> L4
        r0.put("logid", r3);     // Catch: Exception -> L4
        F("tt_token_change", r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void t(String r2, String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("path", r2);     // Catch: JSONException -> L4
        r0.put("ticket_name", r3);     // Catch: JSONException -> L4
        r0.put(WsConstants.ERROR_CODE, r4);     // Catch: JSONException -> L4
        r0.put("error_desc", r5);     // Catch: JSONException -> L4
        C("passport_token_guard_fail", r0);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void u(long r2) {
        if (com.bytedance.sdk.account.settings.f.a.l() == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        r0.put("read_cache_duration", r2);     // Catch: Exception -> L9
    L7:
        com.bytedance.sdk.account.monitor.c.d("token_init_finish", 0, null, r0.toString());
    }

    public static void v(String r2) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put("urlpath", b(r2));     // Catch: Exception -> L4
        F("x_tt_token_lost", r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void w(Long r2, Long r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("old_id", String.valueOf(r2));     // Catch: JSONException -> L4
        r0.put("new_id", String.valueOf(r3));     // Catch: JSONException -> L4
        r0.put("path", r4);     // Catch: JSONException -> L4
        r0.put(TypedValues.TransitionType.S_FROM, r5);     // Catch: JSONException -> L4
        C("passport_uid_update", r0);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        d.b.s.a.a0.a.c("AccountSDK", "monitorUidUpdate error", e);
    }

    public static void x(String r7, String r8, String r9, h r10, t r11, String r12, List<m> r13, String r14) {
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L64
        r1.put("host", r7);     // Catch: JSONException -> L64
        r1.put("path", r8);     // Catch: JSONException -> L64
        r1.put("log_id", r9);     // Catch: JSONException -> L64
        int r15 = 1;
        if (r10 == null) goto L27;
        d0 r16 = r10.f12211b;     // Catch: JSONException -> L64
        if (r16 == null) goto L27;
        if (r16.a() == null) goto L27;
        if (r16.a().isEmpty() == true) goto L27;
        Iterator<Pair<String, String>> r17 = r16.a().iterator();     // Catch: JSONException -> L64
        int r18 = 0;
        int r2 = 0;
        int r3 = 0;
    L13:
        if (r17.hasNext() == false) goto L26;
        Pair<String, String> r4 = r17.next();     // Catch: JSONException -> L64
        if (r4 == null) goto L13;
        if (TextUtils.equals("bd-ticket-guard-client-csr", (CharSequence) r4.first) == true) goto L19;
        if (TextUtils.equals("bd-ticket-guard-client-cert", (CharSequence) r4.first) == true) goto L22;
        if (TextUtils.equals("bd-ticket-guard-ree-public-key", (CharSequence) r4.first) == false) goto L13;
        r3 = !TextUtils.isEmpty((CharSequence) r4.second) ? 1 : 0;     // Catch: JSONException -> L64
        goto L13
    L22:
        r2 = !TextUtils.isEmpty((CharSequence) r4.second) ? 1 : 0;     // Catch: JSONException -> L64
        goto L13
    L19:
        r18 = !TextUtils.isEmpty((CharSequence) r4.second) ? 1 : 0;     // Catch: JSONException -> L64
        goto L13
    L26:
        r1.put("csr", r18);     // Catch: JSONException -> L64
        r1.put("client_cert", r2);     // Catch: JSONException -> L64
        r1.put("ree_public_key", r3);     // Catch: JSONException -> L64
    L27:
        if (r13 == null) goto L51;
        if (r13.isEmpty() == true) goto L51;
        StringBuffer r19 = new StringBuffer();     // Catch: JSONException -> L64
        Iterator<m> r110 = r13.iterator();     // Catch: JSONException -> L64
    L32:
        if (r110.hasNext() == false) goto L48;
        m r111 = r110.next();     // Catch: JSONException -> L64
        if ("set-cookie".equalsIgnoreCase(r111.a()) == false) goto L32;
        String r112 = r111.b();     // Catch: JSONException -> L64
        if (TextUtils.isEmpty(r112) == true) goto L32;
        if (r112.contains("sessionid") == false) goto L32;
        String r113 = r112.split(";")[0].split("=")[0];     // Catch: JSONException -> L64
        if (r113 == null) goto L32;
        if (r113.startsWith("sessionid") == false) goto L32;
        if (r19.length() <= 0) goto L46;
        r19.append(",");     // Catch: JSONException -> L64
    L46:
        r19.append(r113);     // Catch: JSONException -> L64
        r19.append("=1");     // Catch: JSONException -> L64
        goto L32
    L48:
        if (r19.length() <= 0) goto L51;
        r1.put("cookies", r19.toString());     // Catch: JSONException -> L64
    L51:
        if (TextUtils.isEmpty(r11.f12309a) == true) goto L53;
        int r114 = 1;
    L54:
        r1.put("token", r114);     // Catch: JSONException -> L64
        if (TextUtils.isEmpty(r11.f12310b) == true) goto L57;
        int r115 = 1;
    L58:
        r1.put("tssign", r115);     // Catch: JSONException -> L64
        if (TextUtils.isEmpty(r11.f12311c) == false) goto L62;
        r15 = 0;
    L62:
        r1.put("attest_tssign", r15);     // Catch: JSONException -> L64
        r1.put("new_token", d.b.s.a.l0.s.j(r11.f12309a));     // Catch: JSONException -> L64
        r1.put("old_token", d.b.s.a.l0.s.j(r12));     // Catch: JSONException -> L64
        r1.put(TypedValues.TransitionType.S_FROM, r14);     // Catch: JSONException -> L64
        C("passport_login_token_update", r1);     // Catch: JSONException -> L64
        return;
    L57:
        r115 = 0;
        goto L58
    L53:
        r114 = 0;
    L64:
        e = move-exception;
        e.printStackTrace();
    }

    public static void y(String r4, String r5, boolean r6, boolean r7, boolean r8, String r9, String r10, String r11) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L16
        int r2 = 1;
        if (r7 == false) goto L5;
        int r12 = 1;
    L6:
        r0.put("response_token_is_null", r12);     // Catch: JSONException -> L16
        if (r6 == false) goto L9;
        int r13 = 1;
    L10:
        r0.put("triggle_retry", r13);     // Catch: JSONException -> L16
        r0.put("path", r4);     // Catch: JSONException -> L16
        r0.put("logid", r5);     // Catch: JSONException -> L16
        if (r8 == true) goto L14;
        r2 = 0;
    L14:
        r0.put("response_equals_local", r2);     // Catch: JSONException -> L16
        r0.put("local_token", d.b.s.a.l0.s.j(r9));     // Catch: JSONException -> L16
        r0.put("last_token", d.b.s.a.l0.s.j(r10));     // Catch: JSONException -> L16
        r0.put("request_token", d.b.s.a.l0.s.j(r11));     // Catch: JSONException -> L16
        C("passport_user_mixed_new", r0);     // Catch: JSONException -> L16
        return;
    L9:
        r13 = 0;
        goto L10
    L5:
        r12 = 0;
    L16:
        e = move-exception;
        d.b.s.a.a0.a.c("AccountSDK", "monitorUserMixed error", e);
    }

    public static void z(String r4, String r5, boolean r6, String r7, String r8, boolean r9, String r10) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L20
        int r2 = 1;
        if (r6 == false) goto L5;
        int r11 = 1;
    L6:
        r0.put("token_is_null", r11);     // Catch: JSONException -> L20
        if (TextUtils.isEmpty(r7) == false) goto L9;
        int r1 = 1;
    L10:
        r0.put("response_sec_uid_is_null", r1);     // Catch: JSONException -> L20
        if (TextUtils.isEmpty(r8) == false) goto L13;
        int r3 = 1;
    L14:
        r0.put("sec_uid_is_null", r3);     // Catch: JSONException -> L20
        r0.put("path", r4);     // Catch: JSONException -> L20
        r0.put("logid", r5);     // Catch: JSONException -> L20
        if (r9 == true) goto L18;
        r2 = 0;
    L18:
        r0.put("is_login", r2);     // Catch: JSONException -> L20
        r0.put("sec_uid", r8);     // Catch: JSONException -> L20
        r0.put("response_sec_uid", r7);     // Catch: JSONException -> L20
        r0.put("error_name", r10);     // Catch: JSONException -> L20
        C("passport_user_mixed_uid", r0);     // Catch: JSONException -> L20
        return;
    L13:
        r3 = 0;
        goto L14
    L9:
        r1 = 0;
        goto L10
    L5:
        r11 = 0;
    L20:
        e = move-exception;
        d.b.s.a.a0.a.c("AccountSDK", "monitorUserMixedUid error", e);
    }
}

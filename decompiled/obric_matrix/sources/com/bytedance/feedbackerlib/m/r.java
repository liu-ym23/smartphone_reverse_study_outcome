package com.bytedance.feedbackerlib.m;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class r {
    public static void a(String r0, String r1) {
    }

    public static void b() {
    }

    public static void c() {
    }

    public static void d() {
    }

    public static void e() {
        q.c r0 = q.c.f4308h;
        if (r0.a(-1) >= 0) goto L5;
        return;
    L5:
        r0.b(-1);
    }

    public static void f(@NonNull String r7, @Nullable Map<String, String> r8) {
        if (TextUtils.isEmpty(r7) == false) goto L16;
        return;
    L16:
        com.bytedance.framwork.core.sdkmonitor.k r0 = com.bytedance.feedbackerlib.j.b.b();     // Catch: RuntimeException -> L15
        if (r8 != null) goto L18;
    L12:
        JSONObject r6 = null;
    L13:
        r0.b0(r7, 0, new JSONObject(), null, r6);     // Catch: RuntimeException -> L15
        r0.B();     // Catch: RuntimeException -> L15
        return;
    L18:
        r6 = new JSONObject(new Gson().v(r8));     // Catch: JSONException -> L10 RuntimeException -> L15
        goto L13
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: RuntimeException -> L15
    }

    public static void g(@NonNull String r3, @NonNull String r4, String... r5) {
        com.bytedance.framwork.core.sdkmonitor.k r0 = com.bytedance.feedbackerlib.j.b.b();
        if (r0 != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put("logID", r3);     // Catch: Throwable -> L9
        r1.put("description", r4);     // Catch: Throwable -> L9
        r1.put("args", Arrays.asList(r5));     // Catch: Throwable -> L9
    L7:
        r0.X("feedbacker_float_window_hide", null, null, r1);
        r0.B();
    }

    public static void h(@NonNull String r3, @NonNull String r4, String... r5) {
        com.bytedance.framwork.core.sdkmonitor.k r0 = com.bytedance.feedbackerlib.j.b.b();
        if (r0 != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put("logID", r3);     // Catch: Throwable -> L9
        r1.put("description", r4);     // Catch: Throwable -> L9
        r1.put("args", Arrays.asList(r5));     // Catch: Throwable -> L9
    L7:
        r0.X("feedbacker_float_window_show", null, null, r1);
        r0.B();
    }

    public static void i(@NonNull String r3, @NonNull String r4, String... r5) {
        com.bytedance.framwork.core.sdkmonitor.k r0 = com.bytedance.feedbackerlib.j.b.b();
        if (r0 != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put("logID", r3);     // Catch: Throwable -> L9
        r1.put("description", r4);     // Catch: Throwable -> L9
        r1.put("args", Arrays.asList(r5));     // Catch: Throwable -> L9
    L7:
        r0.X("feedbacker_module_classification", null, null, r1);
        r0.B();
    }

    public static void j(@NonNull String r3, @NonNull String r4, String... r5) {
        com.bytedance.framwork.core.sdkmonitor.k r0 = com.bytedance.feedbackerlib.j.b.b();
        if (r0 != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put("logID", r3);     // Catch: Throwable -> L9
        r1.put("description", r4);     // Catch: Throwable -> L9
        r1.put("args", Arrays.asList(r5));     // Catch: Throwable -> L9
    L7:
        r0.X("feedbacker_record", null, null, r1);
        r0.B();
    }

    public static void k(@NonNull String r3, @NonNull String r4, String... r5) {
        com.bytedance.framwork.core.sdkmonitor.k r0 = com.bytedance.feedbackerlib.j.b.b();
        if (r0 != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put("logID", r3);     // Catch: Throwable -> L9
        r1.put("description", r4);     // Catch: Throwable -> L9
        r1.put("args", Arrays.asList(r5));     // Catch: Throwable -> L9
    L7:
        r0.X("feedbacker_sso", null, null, r1);
        r0.B();
    }

    public static void l(String r7, String r8, long r9) {
        com.bytedance.framwork.core.sdkmonitor.k r6 = com.bytedance.feedbackerlib.j.b.b();
        if (r6 != null) goto L5;
        return;
    L5:
        JSONObject r5 = new JSONObject();
        JSONObject r4 = new JSONObject();
        r5.put("sso_log_id", r7);     // Catch: Throwable -> L8
        r5.put("code", r8);     // Catch: Throwable -> L8
        r4.put(TypedValues.TransitionType.S_DURATION, r9 + "");     // Catch: Throwable -> L8
    L10:
        r6.b0("sso_failed", 0, new JSONObject(), r4, r5);
        r6.B();
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    public static void m(String r7, List<String> r8) {
        com.bytedance.framwork.core.sdkmonitor.k r6 = com.bytedance.feedbackerlib.j.b.b();
        if (r6 != null) goto L17;
        return;
    L17:
        HashMap r1 = new HashMap();     // Catch: Throwable -> L13
        r1.put("sso_retry_log_id", r7);     // Catch: Throwable -> L13
        String r9 = "";
        if (r8 != null) goto L9;
    L11:
        r1.put("error_infos", r9);     // Catch: Throwable -> L13
        JSONObject r5 = new JSONObject(new Gson().v(r1));     // Catch: Throwable -> L13
    L15:
        r6.b0("sso_retry_click_failed", 0, new JSONObject(), null, r5);
        r6.B();
        return;
    L9:
        if (r8.size() <= 0) goto L11;
        r9 = com.bytedance.apm.util.v.a(r8.toArray(), ',', 0, r8.size());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        r5 = null;
        goto L15
    }

    public static void n(String r7, long r8) {
        com.bytedance.framwork.core.sdkmonitor.k r6 = com.bytedance.feedbackerlib.j.b.b();
        if (r6 != null) goto L5;
        return;
    L5:
        JSONObject r5 = new JSONObject();
        JSONObject r4 = new JSONObject();
        r5.put("sso_log_id", r7);     // Catch: Throwable -> L8
        r4.put(TypedValues.TransitionType.S_DURATION, r8 + "");     // Catch: Throwable -> L8
    L10:
        r6.b0("sso_succeed", 0, new JSONObject(), r4, r5);
        r6.B();
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    public static void o(@NonNull String r3, @NonNull String r4, String... r5) {
        com.bytedance.framwork.core.sdkmonitor.k r0 = com.bytedance.feedbackerlib.j.b.b();
        if (r0 != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put("logID", r3);     // Catch: Throwable -> L9
        r1.put("description", r4);     // Catch: Throwable -> L9
        r1.put("args", Arrays.asList(r5));     // Catch: Throwable -> L9
    L7:
        r0.X("feedbacker_submit_feedback", null, null, r1);
        r0.B();
    }
}

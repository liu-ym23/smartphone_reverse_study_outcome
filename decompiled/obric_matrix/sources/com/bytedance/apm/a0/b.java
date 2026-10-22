package com.bytedance.apm.a0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.apm.core.ActivityLifeObserver;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(@NonNull com.bytedance.apm.t.d.e r1, boolean r2) {
        r1.f(e.a().b(r2));
    }

    public static void b(@NonNull JSONObject r3, String r4) {
        r3.put("timestamp", System.currentTimeMillis());
        r3.put("crash_time", System.currentTimeMillis());
        r3.put("is_main_process", com.bytedance.apm.d.G());
        r3.put("process_name", com.bytedance.apm.d.i());
        r3.put("event_type", r4);
        r3.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());
    }

    @NonNull
    public static void c(@NonNull com.bytedance.apm.t.d.e r5) {
        String r1 = e.a().c();
        JSONObject r2 = r5.f1998e;
        if (r2 != null) goto L14;
        r2 = new JSONObject();
    L14:
        if (TextUtils.isEmpty(r1) == false) goto L8;
        r1 = ActivityLifeObserver.getInstance().getTopActivityClassName();     // Catch: JSONException -> L13
    L8:
        r2.put("scene", r1);     // Catch: JSONException -> L13
        r2.put("process_name", com.bytedance.apm.d.i());     // Catch: JSONException -> L13
        r2.put("is_main_process", com.bytedance.apm.d.G());     // Catch: JSONException -> L13
        if (r2.isNull("is_front") == false) goto L11;
        r2.put("is_front", ActivityLifeObserver.getInstance().isForeground());     // Catch: JSONException -> L13
    L11:
        r5.f1998e = r2;     // Catch: JSONException -> L13
        return;
    }
}

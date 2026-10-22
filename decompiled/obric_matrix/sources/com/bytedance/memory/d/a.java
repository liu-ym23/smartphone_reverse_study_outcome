package com.bytedance.memory.d;

import android.text.TextUtils;
import com.bytedance.apm.x.e;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.apm.api.EventConfig;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a(String r2) {
        return b("custom_event_settings", "allow_service_name", r2);
    }

    public static boolean b(String r3, String r4, String r5) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L24:
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L24;
        if (TextUtils.isEmpty(r5) == true) goto L24;
        if (com.bytedance.memory.a.a.l().i() == false) goto L25;
        return true;
    L25:
        IConfigManager r0 = (IConfigManager) d.a(IConfigManager.class);     // Catch: Exception -> L22
        if (r0 == null) goto L27;
        JSONObject r6 = r0.getConfigJSON(r3);     // Catch: Exception -> L22
        if (r6 == null) goto L28;
        JSONObject r7 = r6.optJSONObject(r4);     // Catch: Exception -> L22
        if (r7 == null) goto L29;
        if (r7.optInt(r5, 0) == 1) goto L21;
        return false;
    L21:
        return true;
    L29:
        return false;
    L28:
        return false;
    L27:
        return false;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public static boolean c(String r2) {
        if (b("performance_modules", "memory", r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (com.bytedance.memory.a.a.l().i() == true) goto L8;
        return false;
    }

    public static void d(String r7) {
        boolean r1 = c("memory_dump_event");
        if (com.bytedance.apm.d.C() == false) goto L5;
        e.d("memory", new String[]{"memory_dump_event : " + r1});
    L5:
        if (r1 == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r7) == true) goto L20;
        IApmAgent r2 = (IApmAgent) d.a(IApmAgent.class);     // Catch: Exception -> L13
        if (r2 == null) goto L19;
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L13
        r3.put(r7, 1);     // Catch: Exception -> L13
        r2.monitorEvent("memory_dump_event", r3, null, null);     // Catch: Exception -> L13
        return;
    L19:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void e(String r7) {
        boolean r1 = c("memory_dump_event");
        if (com.bytedance.apm.d.C() == false) goto L5;
        e.d("memory", new String[]{"memory_dump_event : " + r1});
    L5:
        if (r1 == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r7) == true) goto L20;
        IApmAgent r2 = (IApmAgent) d.a(IApmAgent.class);     // Catch: Exception -> L13
        if (r2 == null) goto L19;
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L13
        r3.put(r7, 1);     // Catch: Exception -> L13
        r2.monitorEvent(EventConfig.builder().setServiceName("memory_dump_event").setCategory(r3).isUploadImmediate(true).build());     // Catch: Exception -> L13
        return;
    L19:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void f(String r6, long r7) {
        boolean r1 = c("memory_dump_event");
        if (com.bytedance.apm.d.C() == false) goto L5;
        e.d("memory", new String[]{"memory_dump_event : " + r1});
    L5:
        if (r1 == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r6) == true) goto L20;
        IApmAgent r2 = (IApmAgent) d.a(IApmAgent.class);     // Catch: Exception -> L13
        if (r2 == null) goto L19;
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L13
        r3.put(r6, r7);     // Catch: Exception -> L13
        r2.monitorEvent("memory_dump_event", null, r3, null);     // Catch: Exception -> L13
        return;
    L19:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}

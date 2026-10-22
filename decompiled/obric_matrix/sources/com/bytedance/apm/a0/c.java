package com.bytedance.apm.a0;

import androidx.annotation.NonNull;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements IConfigListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Boolean> f1124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Boolean> f1125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f1126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f1127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f1128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f1129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile JSONObject f1130g;

    static /* synthetic */ class a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f1131a = null;

        static {
            f1131a = new c(null);
        }

        static /* synthetic */ c a() {
            return f1131a;
        }
    }

    private c() {
        this.f1124a = new ConcurrentHashMap();
        this.f1125b = new ConcurrentHashMap();
        this.f1129f = new HashMap();
        LinkedList r0 = new LinkedList();
        this.f1126c = r0;
        r0.addAll(Arrays.asList(new String[]{"battery", "smooth", "cpu", "disk", "memory", "thread", "fd", "page_load", "page_load_trace", "start", "start_trace", "traffic", "ui"}));
        ArrayList r1 = new ArrayList();
        this.f1127d = r1;
        r1.add("enable_upload");
        this.f1127d.add("drop_enable_upload");
        this.f1127d.add("serious_block_enable_upload");
        this.f1127d.add("block_enable_upload");
        this.f1127d.add("slow_method_enable_upload");
        LinkedList r2 = new LinkedList();
        this.f1128e = r2;
        r2.add("enable_perf_data_collect");
        this.f1129f.put("enable_upload", "fps");
        this.f1129f.put("drop_enable_upload", "fps_drop");
        this.f1129f.put("block_enable_upload", "block_monitor");
        this.f1129f.put("slow_method_enable_upload", "drop_frame_stack");
        this.f1129f.put("serious_block_enable_upload", "serious_block_monitor");
        ((IConfigManager) com.bytedance.news.common.service.manager.d.a(IConfigManager.class)).registerConfigListener(this);
    }

    /* synthetic */ c(a r1) {
        this();
    }

    public static c a() {
        return b.a();
    }

    private void e(JSONObject r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Map<String, Boolean> r0 = this.f1125b;
        boolean r2 = false;
        if (r6.optInt("temperature_enable_upload", 0) != 1) goto L7;
        boolean r1 = true;
    L8:
        r0.put("temperature", Boolean.valueOf(r1));
        Map<String, Boolean> r5 = this.f1125b;
        if (r6.optInt("exception_enable_upload", 0) != 1) goto L11;
        r2 = true;
    L11:
        r5.put("battery_trace", Boolean.valueOf(r2));
        return;
    L7:
        r1 = false;
        goto L8
    }

    private void f(JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Map<String, Boolean> r2 = this.f1125b;
        boolean r1 = false;
        if (r3.optInt("exception", 0) != 1) goto L7;
        r1 = true;
    L7:
        r2.put("cpu_trace", Boolean.valueOf(r1));
    }

    private void g(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Map<String, Boolean> r3 = this.f1125b;
        boolean r1 = false;
        if (r4.optInt("memory_object_monitor", 0) != 1) goto L7;
        r1 = true;
    L7:
        r3.put("memory_object_monitor", Boolean.valueOf(r1));
    }

    private void h(@NonNull JSONObject r6) {
        JSONObject r7 = r6.optJSONObject("performance_modules");
        if (r7 != null) goto L5;
        return;
    L5:
        Iterator<String> r0 = this.f1126c.iterator();
    L7:
        if (r0.hasNext() == false) goto L29;
        String r1 = r0.next();
        JSONObject r3 = r7.optJSONObject(r1);
        if ("smooth".equals(r1) == true) goto L10;
        if ("memory".equals(r1) == false) goto L15;
        g(r3);
    L15:
        if ("battery".equals(r1) == false) goto L18;
        e(r3);
    L18:
        if ("cpu".equals(r1) == false) goto L21;
        f(r3);
    L21:
        if ("start_trace".equals(r1) == false) goto L23;
        j(r3);
    L23:
        if (r3 != null) goto L25;
    L27:
        Map<String, Boolean> r2 = this.f1124a;
        Boolean r4 = Boolean.FALSE;
    L28:
        r2.put(r1, r4);
        goto L7
    L25:
        if (r3.optInt("enable_upload", 0) != 1) goto L27;
        r2 = this.f1124a;
        r4 = Boolean.TRUE;
        goto L28
    L10:
        i(r3);
        goto L7
    L29:
        this.f1130g = com.bytedance.apm.util.h.f(r7, "smooth", "scene_enable_upload");
    }

    private void i(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = this.f1127d.iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        String r1 = r0.next();
        Map<String, Boolean> r2 = this.f1125b;     // Catch: Exception -> L13
        String r3 = this.f1129f.get(r1);     // Catch: Exception -> L13
        boolean r4 = false;
        if (r7.optInt(r1, 0) != 1) goto L11;
        r4 = true;
    L11:
        r2.put(r3, Boolean.valueOf(r4));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    private void j(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = this.f1128e.iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        String r1 = r0.next();
        Map<String, Boolean> r2 = this.f1125b;     // Catch: Exception -> L13
        boolean r3 = false;
        if (r7.optInt(r1, 0) != 1) goto L11;
        r3 = true;
    L11:
        r2.put(r1, Boolean.valueOf(r3));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public boolean b(String r1) {
        Boolean r0 = this.f1124a.get(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public boolean c(String r4, String r5) {
        Boolean r6 = this.f1125b.get(r4);
        if (this.f1130g != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r6 != null) goto L10;
    L12:
        if (r3 == true) goto L14;
        return false;
    L14:
        return true;
    L10:
        if (r6.booleanValue() == false) goto L12;
    L5:
        if (this.f1130g.optInt(r5) != 1) goto L7;
        r3 = true;
        goto L8
    }

    public boolean d(String r1) {
        Boolean r0 = this.f1125b.get(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        h(r1);
    }
}

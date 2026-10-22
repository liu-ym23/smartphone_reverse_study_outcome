package com.bytedance.memory.h;

import android.text.TextUtils;
import com.bytedance.apm.d;
import com.bytedance.apm.util.k;
import com.bytedance.apm.util.l;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.services.apm.api.HttpResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<String> f5045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<String> f5046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List<String> f5047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f5048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile long f5049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile boolean f5050f;

    /* JADX INFO: renamed from: com.bytedance.memory.h.a$a, reason: collision with other inner class name */
    static class RunnableC0158a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f5051f;

        RunnableC0158a(String r1) {
            this.f5051f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r2 = new JSONObject();
            JSONArray r3 = new JSONArray();
            JSONObject r4 = new JSONObject();
            r4.put("d_s_t", System.currentTimeMillis());     // Catch: Throwable -> L8
            r4.put("event_type", "memory_object_monitor");     // Catch: Throwable -> L8
            r4.put("log_id", 464);     // Catch: Throwable -> L8
            r4.put("log_type", "memory_object_monitor");     // Catch: Throwable -> L8
            r4.put("memory_object", new JSONObject(this.f5051f).optJSONObject("memory_object"));     // Catch: Throwable -> L8
            r4.put("network_type", k.a(d.h()).a());     // Catch: Throwable -> L8
            String r8 = d.j().getSessionId();     // Catch: Throwable -> L8
            if (TextUtils.isEmpty(r8) == true) goto L6;
            r4.put("session_id", r8);     // Catch: Throwable -> L8
        L6:
            r4.put(WsConstants.KEY_SESSION_ID, d.A());     // Catch: Throwable -> L8
            r4.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L8
            r3.put(r4);     // Catch: Throwable -> L8
            r2.put("data", r3);     // Catch: Throwable -> L8
            r2.put("header", d.k());     // Catch: Throwable -> L8
        L10:
            Iterator<String> r9 = a.f5047c.iterator();
        L12:
            if (r9.hasNext() == false) goto L22;
            String r0 = r9.next();
            HttpResponse r1 = d.d(r0, r2.toString().getBytes(), null);     // Catch: Exception -> L20
            if (r1 == null) goto L12;
            if (new JSONObject(new String(r1.getResponseBytes())).optInt(WsConstants.ERROR_CODE, -1) != 0) goto L12;
            com.bytedance.memory.b.c.c("client analysis report success", new Object[0]);     // Catch: Exception -> L20
            return;
        L20:
            e = move-exception;
            e.printStackTrace();
            goto L12
        L22:
            return;
        L8:
            th = move-exception;
            th.printStackTrace();
            goto L10
        }
    }

    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.memory.b.c.c("MemoryNetApi uploadFile begin", new Object[0]);     // Catch: Throwable -> L17
            JSONObject r0 = d.k();     // Catch: Throwable -> L17
            r0.put("update_version_code", com.bytedance.memory.heap.a.o().s());     // Catch: Throwable -> L17
            JSONObject r1 = new JSONObject();     // Catch: Throwable -> L17
            r1.put("event_type", "memory_object_monitor");     // Catch: Throwable -> L17
            r1.put("hprof_type", com.bytedance.memory.heap.a.o().n());     // Catch: Throwable -> L17
            r1.put("timestamp", com.bytedance.memory.heap.a.o().l());     // Catch: Throwable -> L17
            HashMap r2 = new HashMap(2);     // Catch: Throwable -> L17
            r2.put("header", r0.toString());     // Catch: Throwable -> L17
            r2.put("data", r1.toString());     // Catch: Throwable -> L17
            ArrayList r3 = new ArrayList(1);     // Catch: Throwable -> L17
            r3.add(new File(com.bytedance.memory.heap.a.o().q()));     // Catch: Throwable -> L17
            com.bytedance.memory.d.a.d("upload_dump");     // Catch: Throwable -> L17
            List<String> r4 = a.f5046b;     // Catch: Throwable -> L17
            if (r4 != null) goto L6;
        L19:
            a.a(false);
            return;
        L6:
            if (r4.size() <= 0) goto L19;
            Iterator<String> r5 = a.f5046b.iterator();     // Catch: Throwable -> L17
        L9:
            if (r5.hasNext() == false) goto L19;
            HttpResponse r6 = d.l0(r5.next(), r3, r2);     // Catch: Throwable -> L17
            if (r6 == null) goto L9;
            if (TextUtils.isEmpty(new String(r6.getResponseBytes())) == true) goto L14;
            com.bytedance.memory.b.c.c("MemoryNetApi uploadFile failed", new Object[0]);     // Catch: Throwable -> L17
            goto L9
        L14:
            com.bytedance.memory.b.c.c("MemoryNetApi uploadFile succeed", new Object[0]);     // Catch: Throwable -> L17
            com.bytedance.memory.heap.a.o().i();     // Catch: Throwable -> L17
            com.bytedance.memory.d.a.d("upload_dump_success");     // Catch: Throwable -> L17
            com.bytedance.memory.i.a.i().j(false);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            th.printStackTrace();
            goto L19
        }
    }

    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<String> r5 = a.f5045a;     // Catch: Exception -> L15
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.size() <= 0) goto L24;
            Iterator<String> r6 = a.f5045a.iterator();     // Catch: Exception -> L15
        L8:
            if (r6.hasNext() == false) goto L27;
            HttpResponse r0 = d.c(String.format(r6.next(), new Object[]{Integer.valueOf(d.k().optInt(WsConstants.KEY_APP_ID, 0))}), null);     // Catch: Exception -> L15
            if (r0 == null) goto L8;
            boolean r7 = new JSONObject(new String(r0.getResponseBytes())).optBoolean("should_upload");     // Catch: Exception -> L15
            com.bytedance.memory.b.c.c("uploadCheck with api: shouldUpload " + r7, new Object[0]);     // Catch: Exception -> L15
            if (r7 == false) goto L25;
            com.bytedance.memory.heap.a.o().F();     // Catch: Exception -> L15
            return;
        L25:
            return;
        L27:
            return;
        L24:
            return;
        L15:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static {
        f5045a = new ArrayList();
        f5046b = new ArrayList();
        f5047c = new ArrayList();
        f5048d = "hprof_force_upload";
        f5049e = 0;
        f5050f = false;
    }

    public a() {
    }

    static /* synthetic */ boolean a(boolean r0) {
        f5050f = r0;
        return r0;
    }

    public static void b() {
        long r0 = System.currentTimeMillis();
        if ((r0 - f5049e) >= 300000) goto L5;
    L19:
        com.bytedance.memory.b.c.c("uploadCheck return", new Object[0]);
        return;
    L5:
        if (com.bytedance.memory.c.b.d().k() == false) goto L19;
        if (l.c(com.bytedance.memory.a.a.l().j()) == false) goto L19;
        String r2 = com.bytedance.memory.heap.a.o().s();
        if (TextUtils.equals(d.k().optString("update_version_code", ""), r2) == true) goto L13;
        com.bytedance.memory.heap.a.o().i();
        return;
    L13:
        f5049e = r0;
        if (com.bytedance.memory.d.a.c(f5048d) == false) goto L17;
        com.bytedance.memory.b.c.c("hprof_force_upload", new Object[0]);
        com.bytedance.memory.heap.a.o().F();
        return;
    L17:
        com.bytedance.memory.b.b.f4995a.a(new c(), "uploadCheck-MNA");
    }

    public static void c(String r2) {
        com.bytedance.memory.b.b.f4995a.a(new RunnableC0158a(r2), "uploadClientResult-MNA");
    }

    public static void d() {
        monitor-enter(a.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f5050f == false) goto L7;
    L13:
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return;
    L7:
        if (TextUtils.isEmpty(com.bytedance.memory.heap.a.o().q()) == true) goto L13;
        f5050f = true;     // Catch: Throwable -> L15
        monitor-exit(a.class);     // Catch: Throwable -> L15
        com.bytedance.memory.b.b.f4995a.a(new b(), "uploadFile-MNA");
    }
}

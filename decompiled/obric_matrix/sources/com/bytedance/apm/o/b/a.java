package com.bytedance.apm.o.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.t.d.e;
import com.bytedance.apm.t.d.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.apm.o.b.a$a, reason: collision with other inner class name */
    static class RunnableC0049a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1661f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f1662g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f1663h;

        RunnableC0049a(String r1, String r2, JSONObject r3) {
            this.f1661f = r1;
            this.f1662g = r2;
            this.f1663h = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.apm.t.c.a.p().e(new f(this.f1661f, this.f1662g, this.f1663h, null));
        }
    }

    static class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1664f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f1665g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f1666h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ JSONObject f1667i;

        b(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
            this.f1664f = r1;
            this.f1665g = r2;
            this.f1666h = r3;
            this.f1667i = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            e r6 = new e(this.f1664f, "", this.f1665g, this.f1666h, this.f1667i);
            com.bytedance.apm.t.c.a.p().e(r6);
        }
    }

    static class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONObject f1668f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f1669g;

        c(JSONObject r1, JSONObject r2) {
            this.f1668f = r1;
            this.f1669g = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e r6 = new e("start", "", this.f1668f, null, this.f1669g);
            com.bytedance.apm.t.c.a.p().e(r6);
        }
    }

    static class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1670f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f1671g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f1672h;

        d(String r1, long r2, String r4) {
            this.f1670f = r1;
            this.f1671g = r2;
            this.f1672h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r3 = new JSONObject();     // Catch: Exception -> L4
            r3.put(this.f1670f, this.f1671g);     // Catch: Exception -> L4
            JSONObject r4 = new JSONObject();     // Catch: Exception -> L4
            r4.put("scene", this.f1672h);     // Catch: Exception -> L4
            e r6 = new e("page_load", "page_load", r3, r4, null);     // Catch: Exception -> L4
            com.bytedance.apm.t.c.a.p().e(r6);     // Catch: Exception -> L4
            return;
        }
    }

    public static void a(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        com.bytedance.apm.f0.b.f().i(new b(r2, r3, r4, r5));
    }

    public static void b(JSONObject r2, long r3, long r5) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put("begin_time", r3);     // Catch: Exception -> L4
        r0.put("end_time", r5);     // Catch: Exception -> L4
        r0.put(TypedValues.TransitionType.S_FROM, "monitor-plugin");     // Catch: Exception -> L4
        com.bytedance.apm.f0.b.f().i(new c(r2, r0));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void c(String r2, String r3, JSONObject r4) {
        com.bytedance.apm.f0.b.f().i(new RunnableC0049a(r2, r3, r4));
    }

    public static void d(String r2, String r3, long r4) {
        com.bytedance.apm.f0.b.f().i(new d(r3, r4, r2));
    }
}

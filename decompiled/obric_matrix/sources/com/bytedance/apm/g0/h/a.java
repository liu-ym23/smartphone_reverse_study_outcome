package com.bytedance.apm.g0.h;

import com.bytedance.apm.d;
import com.bytedance.apm.util.f;
import com.bytedance.apm.x.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.apm.f0.b.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, b> f1583b;

    /* JADX INFO: renamed from: com.bytedance.apm.g0.h.a$a, reason: collision with other inner class name */
    class RunnableC0047a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1584f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f1585g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f1586h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f1587i;

        RunnableC0047a(a r1, String r2, Map r3, float r4) {
            this.f1587i = r1;
            this.f1584f = r2;
            this.f1585g = r3;
            this.f1586h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            b r0 = (b) a.a(this.f1587i).get(this.f1584f);
            if (r0 != null) goto L5;
            b r1 = new b(this.f1585g, this.f1584f, this.f1586h);
            a.a(this.f1587i).put(this.f1584f, r1);
            return;
        L5:
            r0.a(this.f1586h);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, String> f1588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f1590c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1591d;

        b(Map<String, String> r1, String r2, float r3) {
            this.f1588a = r1;
            this.f1589b = r3;
            this.f1590c = System.currentTimeMillis();
            this.f1591d = 1;
        }

        void a(float r2) {
            this.f1589b += r2;
            this.f1591d++;
        }

        float b() {
            int r0 = this.f1591d;
            if (r0 > 0) goto L5;
            return -1.0f;
        L5:
            return this.f1589b / r0;
        }

        boolean c(long r3) {
            if ((r3 - this.f1590c) <= 120000) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f1592a = null;

        static {
            f1592a = new a(null);
        }

        static /* synthetic */ a a() {
            return f1592a;
        }
    }

    private a() {
        this.f1583b = new HashMap();
        this.f1582a = true;
        com.bytedance.apm.f0.b.f().c(this);
    }

    /* synthetic */ a(RunnableC0047a r1) {
        this();
    }

    static /* synthetic */ HashMap a(a r0) {
        return r0.f1583b;
    }

    public static a c() {
        return c.a();
    }

    public void b(Map<String, String> r3, String r4, float r5) {
        com.bytedance.apm.f0.b.f().i(new RunnableC0047a(this, r4, r3, r5));
    }

    @Override // com.bytedance.apm.f0.b.e
    public void onTimeEvent(long r13) {
        if (this.f1583b.isEmpty() == true) goto L34;
        Iterator<Map.Entry<String, b>> r0 = this.f1583b.entrySet().iterator();
        int r1 = f.e();
    L6:
        if (r0.hasNext() == false) goto L47;
        Map.Entry<String, b> r2 = r0.next();
        String r6 = r2.getKey();
        b r3 = r2.getValue();
        if (r3.c(r13) == false) goto L6;
        r0.remove();
        float r4 = r3.b();
        boolean r10 = false;
        if (d.C() == false) goto L13;
        e.d(com.bytedance.apm.x.b.f2127c, new String[]{"aggregate fps: " + r6 + " , value: " + r4});
    L13:
        if (r4 <= 0.0f) goto L6;
        float r5 = r1;
        if (r4 <= r5) goto L36;
        r4 = r5;
    L36:
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L35
        r7.put("fps", r4);     // Catch: Exception -> L35
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L35
        r8.put("scene", r6);     // Catch: Exception -> L35
        com.bytedance.apm.t.d.e r9 = new com.bytedance.apm.t.d.e("fps", r6, r7, r8, null);     // Catch: Exception -> L35
        d.b.b.m.a.b.a(r9, true);     // Catch: Exception -> L35
        JSONObject r11 = r9.f1999f;     // Catch: Exception -> L35
        r11.put("refresh_rate", r1);     // Catch: Exception -> L35
        if (this.f1582a == false) goto L24;
        this.f1582a = false;     // Catch: Exception -> L35
        r11.put("device_max_refresh_rate", f.b());     // Catch: Exception -> L35
        if (f.h() == true) goto L23;
        r10 = true;
    L23:
        r11.put("refresh_rate_restricted", r10);     // Catch: Exception -> L35
    L24:
        Map<String, String> r12 = r3.f1588a;     // Catch: Exception -> L35
        if (r12 != null) goto L27;
    L32:
        com.bytedance.apm.t.c.a.p().e(r9);     // Catch: Exception -> L35
        goto L6
    L27:
        if (r12.isEmpty() == true) goto L32;
        Iterator<Map.Entry<String, String>> r14 = r3.f1588a.entrySet().iterator();     // Catch: Exception -> L35
    L30:
        if (r14.hasNext() == false) goto L32;
        Map.Entry<String, String> r15 = r14.next();     // Catch: Exception -> L35
        r9.f1999f.put(r15.getKey(), r15.getValue());     // Catch: Exception -> L35
        goto L30
    L47:
        return;
    }
}

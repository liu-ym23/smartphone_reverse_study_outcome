package com.bytedance.apm.a0;

import android.os.Looper;
import android.text.TextUtils;
import com.ss.ttuploader.TTVideoUploader;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h extends com.bytedance.apm.a0.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f1174h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f1175i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f1176j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f1177k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f1178l;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f1179g;

    static class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f1180f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int[] f1181g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f1182h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f1183i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ ThreadGroup f1184j;

        a(boolean r1, int[] r2, String r3, int r4, ThreadGroup r5) {
            this.f1180f = r1;
            this.f1181g = r2;
            this.f1182h = r3;
            this.f1183i = r4;
            this.f1184j = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1180f == false) goto L5;
        L26:
            JSONObject r8 = h.q(this.f1182h, this.f1183i, this.f1181g[0], null);     // Catch: Exception -> L25
            if (r8 == null) goto L34;
            com.bytedance.apm.t.c.a.p().e(new com.bytedance.apm.t.d.e("thread", null, null, r8));     // Catch: Exception -> L25
            return;
        L34:
            return;
        L35:
            return;
        L5:
            if (this.f1181g[0] < h.o()) goto L26;
            if (h.p() == false) goto L26;
            int[] r0 = this.f1181g;
            Thread[] r4 = new Thread[r0[0] + (r0[0] / 2)];
            r0[0] = this.f1184j.enumerate(r4);
            StringBuilder r1 = new StringBuilder();
            int r5 = 0;
        L10:
            int[] r6 = this.f1181g;
            if (r5 >= r6[0]) goto L28;
            String r7 = r4[r5].getName();
            if (TextUtils.isEmpty(r7) == true) goto L15;
            r1.append(r7);
            r1.append(",");
        L15:
            r5 = r5 + 1;
            goto L10
        L28:
            JSONObject r9 = h.q(this.f1182h, this.f1183i, r6[0], r1.toString());     // Catch: Throwable -> L24
            if (r9 == null) goto L32;
            com.bytedance.apm.t.c.a.p().e(new com.bytedance.apm.t.d.e("thread", null, null, r9));     // Catch: Throwable -> L24
            return;
        L32:
            return;
        }
    }

    static {
        f1174h = Runtime.getRuntime().availableProcessors();
        f1175i = false;
        f1176j = TTVideoUploader.KeyIsGetTosKey;
        f1177k = false;
        f1178l = false;
    }

    public h() {
        this.f1179g = 600000;
        this.f1122e = "thread";
    }

    static /* synthetic */ int o() {
        return f1176j;
    }

    static /* synthetic */ boolean p() {
        return f1175i;
    }

    static /* synthetic */ JSONObject q(String r0, int r1, int r2, String r3) {
        return r(r0, r1, r2, r3);
    }

    private static JSONObject r(String r2, int r3, int r4, String r5) {
        JSONObject r0 = new JSONObject();
        if (r3 > 0) goto L16;
    L5:
        r0.put("java_thread_count", r4);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r0.put("scene", r2);     // Catch: JSONException -> L13
    L9:
        if (TextUtils.isEmpty(r5) == true) goto L11;
        r0.put("thread_detail", r5);     // Catch: JSONException -> L13
    L11:
        r0.put("is_main_process", com.bytedance.apm.d.G());     // Catch: JSONException -> L13
        r0.put("cpu_count", f1174h);     // Catch: JSONException -> L13
        r0.put("process_name", com.bytedance.apm.d.i());     // Catch: JSONException -> L13
    L15:
        return r0;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L16:
        r0.put("total_thread_count", r3);     // Catch: JSONException -> L13
        goto L5
    }

    private void s() {
        t(null, false);
    }

    public static int t(String r11, boolean r12) {
        int r1 = new File("/proc/self/task/").list().length;     // Catch: Throwable -> L5
    L6:
        if (r1 != 0) goto L8;
        return 0;
    L8:
        ThreadGroup r7 = Looper.getMainLooper().getThread().getThreadGroup();
    L10:
        if (r7.getParent() == null) goto L12;
        r7 = r7.getParent();
        goto L10
    L12:
        int[] r8 = {r7.activeCount()};
        com.bytedance.apm.f0.b.f().i(new a(r12, r8, r11, r1, r7));
        return (r1 << 16) + r8[0];
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.bytedance.apm.a0.a
    protected void c(JSONObject r5) {
        super.c(r5);
        boolean r1 = false;
        if (r5.optInt("enable_thread_collect", 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        f1177k = r0;
        if (r5.optInt("enable_upload", 0) != 1) goto L9;
        r1 = true;
    L9:
        f1178l = r1;
        f1176j = r5.optInt("thread_count_threshold", TTVideoUploader.KeyIsGetTosKey);
        this.f1179g = r5.optLong("collect_interval", 10) * 60000;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.apm.a0.a
    protected boolean f() {
        return true;
    }

    @Override // com.bytedance.apm.a0.a
    protected void i() {
        super.i();
        if (f1177k == true) goto L5;
        return;
    L5:
        if (f1178l == true) goto L7;
        return;
    L7:
        if ((System.currentTimeMillis() - com.bytedance.apm.d.t()) <= 1200000) goto L12;
        s();
        return;
    }

    @Override // com.bytedance.apm.a0.a
    protected long n() {
        return this.f1179g;
    }

    @Override // com.bytedance.apm.a0.a, com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        super.onReady();
        f1175i = true;
    }
}

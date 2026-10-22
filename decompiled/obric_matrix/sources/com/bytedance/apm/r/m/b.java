package com.bytedance.apm.r.m;

import android.os.Build;
import android.view.FrameMetrics;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.apm.r.m.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f1866e = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<com.bytedance.apm.g0.h.c> f1867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap<String, c> f1868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0058b f1869d;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f1870f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f1871g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ b f1872h;

        a(b r1, long r2, boolean r4) {
            this.f1872h = r1;
            this.f1870f = r2;
            this.f1871g = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.i(this.f1872h).a(this.f1870f, this.f1871g);
            int r0 = 0;
        L4:
            if (r0 >= b.j(this.f1872h).size()) goto L6;
            ((com.bytedance.apm.g0.h.c) b.j(this.f1872h).get(r0)).a(this.f1870f, this.f1871g);
            r0 = r0 + 1;
            goto L4
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.r.m.b$b, reason: collision with other inner class name */
    public static class C0058b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f1875c;

        public C0058b() {
            this.f1873a = 0;
            this.f1874b = 0;
            this.f1875c = 0;
        }

        public void a(long r3, boolean r5) {
            if (r5 == false) goto L4;
            this.f1873a++;
        L4:
            this.f1874b++;
            this.f1875c += r3;
        }
    }

    private class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f1876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f1877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1879d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int[] f1880e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1881f;

        c(b r1, String r2) {
            this.f1878c = 0;
            this.f1876a = r2;
            int r3 = com.bytedance.apm.util.f.e() - 1;
            this.f1881f = r3;
            this.f1880e = new int[(r3 - 0) + 1];
        }

        void a(long r4) {
            float r0 = com.bytedance.apm.util.f.c();
            this.f1877b += r4;
            int r5 = Math.min(Math.max((int) (r4 / r0), 0), this.f1881f);
            int[] r6 = this.f1880e;
            r6[r5] = r6[r5] + 1;
            this.f1879d += r5;
            this.f1878c++;
        }

        void b() {
            float r3 = com.bytedance.apm.util.f.c();     // Catch: Throwable -> L13
            JSONObject r7 = new JSONObject();     // Catch: Throwable -> L13
            int r4 = 0;
        L5:
            if (r4 > this.f1881f) goto L10;
            if (this.f1880e[r4] <= 0) goto L9;
            r7.put(String.valueOf(r4), this.f1880e[r4]);     // Catch: Throwable -> L13
        L9:
            r4 = r4 + 1;     // Catch: Throwable -> L13
            goto L5
        L10:
            com.bytedance.apm.g0.h.a.c().b(null, this.f1876a, (float) (((double) (((this.f1878c * 100) * com.bytedance.apm.util.f.e()) / (this.f1878c + this.f1879d))) / 100.0d));     // Catch: Throwable -> L13
            JSONObject r8 = new JSONObject();     // Catch: Throwable -> L13
            r8.put("scene", this.f1876a);     // Catch: Throwable -> L13
            JSONObject r9 = new JSONObject();     // Catch: Throwable -> L13
            r9.put("total_scroll_time", this.f1877b);     // Catch: Throwable -> L13
            r9.put("drop_time_rate", 1.0f - ((this.f1878c * 1.0f) / ((int) (this.f1877b / r3))));     // Catch: Throwable -> L13
            r9.put("refresh_rate", this.f1881f + 1);     // Catch: Throwable -> L13
            com.bytedance.apm.t.c.a.p().e(new com.bytedance.apm.t.d.e("fps_drop", this.f1876a, r7, r8, r9));     // Catch: Throwable -> L13
        L11:
            this.f1878c = 0;
            this.f1879d = 0;
            this.f1877b = 0;
        }

        public String toString() {
            return "visibleScene=" + this.f1876a + ", sumFrame=" + this.f1878c + ", sumDroppedFrames=" + this.f1879d + ", sumFrameCost=" + this.f1877b + ", dropLevel=" + Arrays.toString(this.f1880e);
        }
    }

    static {
    }

    public b() {
        this.f1867b = new ArrayList();
        this.f1868c = new HashMap();
        this.f1869d = new C0058b();
        e.A().S(true);
        com.bytedance.apm.g0.h.b.d(true);
    }

    static /* synthetic */ C0058b i(b r0) {
        return r0.f1869d;
    }

    static /* synthetic */ ArrayList j(b r0) {
        return r0.f1867b;
    }

    private void l(String r4, long r5) {
        if (f1866e == true) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L16;
        c r0 = this.f1868c.get(r4);
        if (r0 != null) goto L10;
        r0 = new c(this, r4);
        this.f1868c.put(r4, r0);
    L10:
        r0.a(r5);
        if (r0.f1877b < BDLocationConfig.sScanBleMaxInterval) goto L15;
        this.f1868c.remove(r4);
        r0.b();
        return;
    L15:
        return;
    }

    public static void m(boolean r0) {
        f1866e = r0;
    }

    @Override // com.bytedance.apm.r.a
    public void e(String r3, long r4, long r6) {
        super.e(r3, r4, r6);
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return;
    L5:
        long r7 = r6 - r4;
        l(r3, r7);
        int r5 = 0;
    L7:
        if (r5 >= this.f1867b.size()) goto L9;
        this.f1867b.get(r5).b(r7);
        r5 = r5 + 1;
        goto L7
    }

    @Override // com.bytedance.apm.r.a
    public void g(String r2, long r3, int r5) {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        l(r2, r3);
        int r4 = 0;
    L6:
        if (r4 >= this.f1867b.size()) goto L10;
        this.f1867b.get(r4).b(r3);
        r4 = r4 + 1;
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.apm.r.a
    public void h(String r5, FrameMetrics r6, int r7) {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        int r8 = 0;
        long r0 = (((((r6.getMetric(0) + r6.getMetric(1)) + r6.getMetric(2)) + r6.getMetric(3)) + r6.getMetric(4)) + r6.getMetric(5)) / TimeUtils.NANOSECONDS_PER_MILLISECOND;
        l(r5, r0);
    L6:
        if (r8 >= this.f1867b.size()) goto L10;
        this.f1867b.get(r8).b(r0);
        r8 = r8 + 1;
        goto L6
    L10:
        return;
    }

    public void k(long r3, boolean r5) {
        e.A().o.b(new a(this, r3, r5));
    }
}

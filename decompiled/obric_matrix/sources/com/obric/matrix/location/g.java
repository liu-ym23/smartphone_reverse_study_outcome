package com.obric.matrix.location;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9203d;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f9204f;

        /* JADX INFO: renamed from: com.obric.matrix.location.g$a$a, reason: collision with other inner class name */
        class C0243a extends TimerTask {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f9205f;

            C0243a(a r1) {
                this.f9205f = r1;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                g.a(this.f9205f.f9204f);
            }
        }

        a(g r1) {
            this.f9204f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            new Timer().schedule(new C0243a(this), g.b(this.f9204f), g.b(this.f9204f));
        }
    }

    public g() {
        TimeUnit r0 = TimeUnit.MINUTES;
        this.f9200a = r0.toMillis(1) * 60;
        this.f9201b = r0.toMillis(1) * 60;
        this.f9202c = SystemClock.elapsedRealtime();
        this.f9203d = SystemClock.elapsedRealtime();
    }

    static /* synthetic */ void a(g r0) {
        r0.l();
    }

    static /* synthetic */ long b(g r2) {
        return r2.f9200a;
    }

    public static void d(String r2, Throwable r3) {
        com.obric.matrix.r.d.c r0 = new com.obric.matrix.r.d.c("com.obric.common.location.call_decodeLocation");
        r0.g("calling_pkgName", r2);
        if (r3 == null) goto L5;
        String r4 = "exception_decodeLocation";
    L6:
        r0.g("error_type", r4);
        if (r3 == null) goto L9;
        String r5 = r3.toString();
    L10:
        r0.h("error_msg", r5);
        m(r0.b());
        r0.j();
        return;
    L9:
        r5 = "";
        goto L10
    L5:
        r4 = "success";
        goto L6
    }

    public static void e(String r2, Throwable r3) {
        com.obric.matrix.r.d.c r0 = new com.obric.matrix.r.d.c("com.obric.common.location.call_getIntersectFences");
        r0.g("calling_pkgName", r2);
        if (r3 == null) goto L5;
        String r4 = "exception_getIntersectFences";
    L6:
        r0.g("error_type", r4);
        if (r3 == null) goto L9;
        String r5 = r3.toString();
    L10:
        r0.h("error_msg", r5);
        m(r0.b());
        r0.j();
        return;
    L9:
        r5 = "";
        goto L10
    L5:
        r4 = "success";
        goto L6
    }

    public static void f(@NonNull String r3, BDLocation r4, BDLocationException r5) {
        String r0 = "";
        if (r5 == null) goto L5;
        r0 = r5.toString();
        String r6 = "exception_getLastKnownLocation";
    L17:
        com.obric.matrix.r.d.c r1 = new com.obric.matrix.r.d.c("com.obric.common.location.call_getLocation");
        r1.g("calling_pkgName", r3);
        r1.g("geometry_valiable", Boolean.valueOf(h.b(r4)));
        r1.g("address_avaliable", Boolean.valueOf(h.a(r4)));
        r1.g("error_type", r6);
        r1.h("error_msg", r0);
        m(r1.b());
        r1.j();
        return;
    L5:
        if (r4 != null) goto L8;
        r6 = "null_location";
        goto L17
    L8:
        if (r4.isEmpty() == false) goto L11;
        r6 = "empty_location";
        goto L17
    L11:
        if (h.b(r4) == true) goto L14;
        r6 = "empty_geometry";
        goto L17
    L14:
        if (h.a(r4) == true) goto L16;
        r6 = "empty_address";
        goto L17
    L16:
        r6 = "success";
        goto L17
    }

    public static void g(String r2, boolean r3, Throwable r4) {
        com.obric.matrix.r.d.c r0 = new com.obric.matrix.r.d.c("com.obric.common.location.call_refreshLocation");
        r0.g("calling_pkgName", r2);
        r0.g("ignore_cache", Boolean.valueOf(r3));
        if (r4 == null) goto L5;
        String r5 = "exception_refreshLocation";
    L6:
        r0.g("error_type", r5);
        if (r4 == null) goto L9;
        String r6 = r4.toString();
    L10:
        r0.h("error_msg", r6);
        m(r0.b());
        r0.j();
        return;
    L9:
        r6 = "";
        goto L10
    L5:
        r5 = "success";
        goto L6
    }

    private void k(String r3, i r4) {
        com.obric.matrix.r.d.c r2 = new com.obric.matrix.r.d.c(r3);
        r2.i("elapsedTime_sdk_getLocation", Long.valueOf(r4.a()));
        r2.i("elapsedTime_since_boot", Long.valueOf(r4.f9212g));
        r2.g("triggerType", r4.f9210e);
        r2.g("force", Boolean.valueOf(r4.f9206a));
        r2.g("need_delay", Boolean.valueOf(r4.f9207b));
        r2.g("retry_count", Long.valueOf(r4.f9209d));
        r2.g("retry_interval", Long.valueOf(r4.f9217l));
        r2.g("callback_type", r4.f9215j);
        r2.g("geometry_available", Boolean.valueOf(r4.f9213h));
        r2.g("address_available", Boolean.valueOf(r4.f9214i));
        r2.g("valid_since_boot", Long.valueOf(r4.f9209d));
        r2.g("error_msg", r4.f9216k);
        m(r2.b());
        r2.j();
    }

    private void l() {
        long r0 = SystemClock.elapsedRealtime() - this.f9202c;
        long r2 = SystemClock.elapsedRealtime() - this.f9203d;
        long r4 = this.f9201b;
        if (r0 <= r4) goto L5;
    L8:
        com.obric.matrix.r.d.b r6 = new com.obric.matrix.r.d.b("location_exception");
        r6.g("durationGeometryValiable", Long.valueOf(r0));
        r6.g("durationAddressValiable", Long.valueOf(r2));
        m(r6.b());
        r6.j();
        return;
    L5:
        if (r2 > r4) goto L8;
        com.obric.matrix.r.c.c.j("LocationMonitor", "reportLocationException: no exception");
    }

    private static void m(Map<String, Object> r2) {
        r2.put("is_location_enabled", Boolean.valueOf(h.c()));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.obric.matrix.r.c.c.g("LocationMonitor", "addBasicCatory: ", e);
    }

    public void c(Handler r2) {
        r2.post(new a(this));
    }

    public void h(@Nullable BDLocationException r1, i r2) {
        r2.onError(r1);
        k("com.obric.common.location.location_callback", r2);
    }

    public void i(@Nullable BDLocation r3, i r4) {
        r4.onLocationChanged(r3);
        k("com.obric.common.location.location_callback", r4);
        if (h.b(r3) == false) goto L6;
        this.f9202c = SystemClock.elapsedRealtime();
    L6:
        if (h.a(r3) == false) goto L9;
        this.f9203d = SystemClock.elapsedRealtime();
        return;
    }

    public void j(i r3) {
        r3.b();
        com.obric.matrix.r.d.c r2 = new com.obric.matrix.r.d.c("com.obric.common.location.location_start");
        r2.g("triggerType", r3.f9210e);
        r2.g("force", Boolean.valueOf(r3.f9206a));
        r2.g("need_delay", Boolean.valueOf(r3.f9207b));
        r2.g("retry_count", Long.valueOf(r3.f9209d));
        r2.g("retry_interval", Long.valueOf(r3.f9209d));
        m(r2.b());
        r2.j();
    }
}

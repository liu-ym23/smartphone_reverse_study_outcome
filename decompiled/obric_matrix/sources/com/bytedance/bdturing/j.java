package com.bytedance.bdturing;

import androidx.core.app.NotificationCompat;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<p> f3087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f3088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f3089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3090d;

    static /* synthetic */ class a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static j f3091a;

        static {
            f3091a = new j(null);
        }

        static /* synthetic */ j a() {
            return f3091a;
        }
    }

    private j() {
        this.f3090d = false;
    }

    /* synthetic */ j(a r1) {
        this();
    }

    public static j a() {
        return b.a();
    }

    public long b() {
        return this.f3089c;
    }

    public long c() {
        return this.f3088b;
    }

    public void d() {
        this.f3090d = true;
    }

    public boolean e(int r4) {
        WeakReference<p> r0 = this.f3087a;
        if (r0 != null) goto L5;
        return false;
    L5:
        p r1 = r0.get();
        if (this.f3090d == false) goto L12;
        if (r1 == null) goto L12;
        if (r4 != r1.w().j()) goto L12;
        this.f3090d = false;
        this.f3089c = System.currentTimeMillis();
        r1.r(com.bytedance.bdturing.u.c.b(1, "bytedcert.refreshVerifyView", NotificationCompat.CATEGORY_CALL, new JSONObject(), "bytedcert.refreshVerifyView"));
        r1.show();
        return true;
    L12:
        return false;
    }
}

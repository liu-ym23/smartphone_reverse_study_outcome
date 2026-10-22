package com.obric.matrix.push.n.c;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J$\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0003J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0003J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u001c\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J$\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/matrix/push/common/log/Logger;", "", "()V", "TAG", "", "androidLogger", "Lcom/obric/matrix/push/common/log/ILogger;", "enableAndroidLog", "", "proxyLogger", "d", "", NotificationCompat.CATEGORY_MESSAGE, LocationMonitorConst.TAG, "e", "tr", "", "formatMsg", "formatTag", "i", "init", "impl", BaseSwitches.V, "w", "sdk_push_common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9759a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f9760b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b f9761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final b f9762d = null;

    static {
        f9759a = new c();
        f9762d = new a();
    }

    private c() {
    }

    public static final void a(String r1) {
        o.f(r1, NotificationCompat.CATEGORY_MESSAGE);
        b("", r1);
    }

    public static final void b(String r1, String r2) {
        o.f(r1, LocationMonitorConst.TAG);
        o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        String r0 = g(r1);
        String r3 = f(r1, r2);
        if (f9760b == false) goto L5;
        f9762d.a(r0, r3);
    L5:
        b r4 = f9761c;
        if (r4 == null) goto L9;
        r4.a(r0, r3);
        return;
    }

    public static final void c(String r3) {
        o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        e("", r3, null, 4, null);
    }

    public static final void d(String r1, String r2, Throwable r3) {
        o.f(r1, LocationMonitorConst.TAG);
        o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        String r0 = g(r1);
        String r4 = f(r1, r2);
        if (f9760b == false) goto L5;
        f9762d.b(r0, r4, r3);
    L5:
        b r5 = f9761c;
        if (r5 == null) goto L9;
        r5.b(r0, r4, r3);
        return;
    }

    public static /* synthetic */ void e(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        d(r0, r1, r2);
    }

    private static final String f(String r1, String r2) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return r2;
    L11:
        return r1 + "-->" + r2;
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    private static final String g(String r0) {
        return "MATRIX_PUSH";
    }

    public static final void h(String r1) {
        o.f(r1, NotificationCompat.CATEGORY_MESSAGE);
        i("", r1);
    }

    public static final void i(String r1, String r2) {
        o.f(r1, LocationMonitorConst.TAG);
        o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        String r0 = g(r1);
        String r3 = f(r1, r2);
        if (f9760b == false) goto L5;
        f9762d.d(r0, r3);
    L5:
        b r4 = f9761c;
        if (r4 == null) goto L9;
        r4.d(r0, r3);
        return;
    }

    public static final void k(String r1, String r2, Throwable r3) {
        o.f(r1, LocationMonitorConst.TAG);
        o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        String r0 = g(r1);
        String r4 = f(r1, r2);
        if (f9760b == false) goto L5;
        f9762d.c(r0, r4, r3);
    L5:
        b r5 = f9761c;
        if (r5 == null) goto L9;
        r5.c(r0, r4, r3);
        return;
    }

    public static /* synthetic */ void l(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        k(r0, r1, r2);
    }

    public final void j(boolean r1, b r2) {
        f9760b = r1;
        f9761c = r2;
    }
}

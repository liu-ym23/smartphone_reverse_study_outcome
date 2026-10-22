package com.obric.matrix.r.c;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.agilelogger.ALog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/common_utils/log/ALogManager;", "", "()V", "BASE_TAG", "", "d", "", LocationMonitorConst.TAG, NotificationCompat.CATEGORY_MESSAGE, "e", "tr", "", "genMsg", "i", BaseSwitches.V, "w", "common_utils_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9916a = null;

    static {
        f9916a = new b();
    }

    private b() {
    }

    private final String d(String r2, String r3) {
        return Thread.currentThread().getName() + "|[" + r2 + "], " + r3;
    }

    public final void a(String r3, String r4) {
        o.f(r3, LocationMonitorConst.TAG);
        o.f(r4, NotificationCompat.CATEGORY_MESSAGE);
        boolean r0 = a.f9914a.b().get();
        String r2 = d(r3, r4);
        if (r0 == true) goto L5;
        Log.d("O_MATRIX", r2);
        return;
    L5:
        ALog.d("O_MATRIX", r2);
    }

    public final void b(String r3, String r4) {
        o.f(r3, LocationMonitorConst.TAG);
        o.f(r4, NotificationCompat.CATEGORY_MESSAGE);
        boolean r0 = a.f9914a.b().get();
        String r2 = d(r3, r4);
        if (r0 == true) goto L5;
        Log.e("O_MATRIX", r2);
        return;
    L5:
        ALog.e("O_MATRIX", r2);
    }

    public final void c(String r3, String r4, Throwable r5) {
        o.f(r3, LocationMonitorConst.TAG);
        o.f(r4, NotificationCompat.CATEGORY_MESSAGE);
        o.f(r5, "tr");
        boolean r0 = a.f9914a.b().get();
        String r2 = d(r3, r4);
        if (r0 == true) goto L5;
        Log.e("O_MATRIX", r2, r5);
        return;
    L5:
        ALog.e("O_MATRIX", r2, r5);
    }

    public final void e(String r3, String r4) {
        o.f(r3, LocationMonitorConst.TAG);
        o.f(r4, NotificationCompat.CATEGORY_MESSAGE);
        boolean r0 = a.f9914a.b().get();
        String r2 = d(r3, r4);
        if (r0 == true) goto L5;
        Log.i("O_MATRIX", r2);
        return;
    L5:
        ALog.i("O_MATRIX", r2);
    }

    public final void f(String r3, String r4) {
        o.f(r3, LocationMonitorConst.TAG);
        o.f(r4, NotificationCompat.CATEGORY_MESSAGE);
        boolean r0 = a.f9914a.b().get();
        String r2 = d(r3, r4);
        if (r0 == true) goto L5;
        Log.v("O_MATRIX", r2);
        return;
    L5:
        ALog.v("O_MATRIX", r2);
    }

    public final void g(String r3, String r4) {
        o.f(r3, LocationMonitorConst.TAG);
        o.f(r4, NotificationCompat.CATEGORY_MESSAGE);
        boolean r0 = a.f9914a.b().get();
        String r2 = d(r3, r4);
        if (r0 == true) goto L5;
        Log.w("O_MATRIX", r2);
        return;
    L5:
        ALog.w("O_MATRIX", r2);
    }

    public final void h(String r3, String r4, Throwable r5) {
        o.f(r3, LocationMonitorConst.TAG);
        o.f(r4, NotificationCompat.CATEGORY_MESSAGE);
        o.f(r5, "tr");
        boolean r0 = a.f9914a.b().get();
        String r2 = d(r3, r4);
        if (r0 == true) goto L5;
        Log.w("O_MATRIX", r2, r5);
        return;
    L5:
        ALog.w("O_MATRIX", r2, r5);
    }
}

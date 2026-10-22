package com.obric.matrix.base.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.os.Handler;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.mpaas.push.IPushService;
import com.obric.matrix.base.settings.iconfig.IMatrixConfig;
import com.obric.matrix.q.h.k;
import com.obric.matrix.r.e.h;
import com.obric.matrix.r.e.j;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/base/settings/MatrixSettingsManager;", "", "()V", "POLL_TOKEN", "", "mContext", "Landroid/content/Context;", "mHandler", "Landroid/os/Handler;", "getMatrixConfig", "Lcom/obric/matrix/base/settings/config/MatrixConfig;", "init", "", "context", "isNeedUpdate", "", "logSettings", "settingsJson", "Lorg/json/JSONObject;", "registerStateChangeListener", "triggerAutoPoll", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class MatrixSettingsManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MatrixSettingsManager f8847a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Handler f8848b;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/base/settings/MatrixSettingsManager$registerStateChangeListener$1", "Lcom/obric/matrix/base/system/ISystemStateListener;", "onNetworkAvailable", "", "network", "Landroid/net/Network;", "onScreenStateChanged", "on", "", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements com.obric.matrix.q.h.d {
        a() {
        }

        @Override // com.obric.matrix.q.h.d
        public void a(Network r1) {
            if (MatrixSettingsManager.b(MatrixSettingsManager.f8847a) == true) goto L5;
        L7:
            com.obric.matrix.r.c.c.b("MatrixSettingsManager", " settings on net available but don't need update");
            return;
        L5:
            if (j.c() == false) goto L7;
            com.obric.matrix.r.c.c.b("MatrixSettingsManager", " settings force update on net available");
            com.bytedance.news.common.settings.e.g(true);
        }

        @Override // com.obric.matrix.q.h.d
        public void b(boolean r1) {
            if (r1 == false) goto L6;
            MatrixSettingsManager r0 = MatrixSettingsManager.f8847a;
            MatrixSettingsManager.c(r0);
            if (MatrixSettingsManager.b(r0) == false) goto L10;
            com.bytedance.news.common.settings.e.g(true);
            return;
        L10:
            return;
        L6:
            Handler r2 = MatrixSettingsManager.a();
            if (r2 == null) goto L12;
            r2.removeCallbacksAndMessages("settings_poll_token");
            return;
        }
    }

    static {
        f8847a = new MatrixSettingsManager();
    }

    private MatrixSettingsManager() {
    }

    public static final /* synthetic */ Handler a() {
        return f8848b;
    }

    public static final /* synthetic */ boolean b(MatrixSettingsManager r0) {
        return r0.h();
    }

    public static final /* synthetic */ void c(MatrixSettingsManager r0) {
        r0.m();
    }

    private static final IPushService f() {
        return new MatrixSettingsManager$init$1$1();
    }

    private static final void g() {
        f8847a.l();
    }

    private final boolean h() {
        int r8 = d().b();
        if (r8 <= 0) goto L7;
        long r2 = com.obric.matrix.q.e.a.i(com.obric.matrix.q.e.a.f9851a, "key_settings_update_time", null, null, 6, null);
        com.obric.matrix.r.c.c.b("MatrixSettingsManager", "last update settings time = " + r2 + "， polling interval =  " + r8);
        if ((System.currentTimeMillis() - r2) <= ((r8 * 60) * 1000)) goto L9;
        return true;
    L9:
        return false;
    L7:
        com.obric.matrix.r.c.c.b("MatrixSettingsManager", "autoPollingInterval error  " + r8);
        return false;
    }

    public static /* synthetic */ IPushService i() {
        return f();
    }

    public static /* synthetic */ void j() {
        n();
    }

    public static /* synthetic */ void k() {
        g();
    }

    private final void l() {
        k.l(new a());
    }

    private final void m() {
        int r4 = d().b();
        com.obric.matrix.r.c.c.b("MatrixSettingsManager", "triggerAutoPoll with " + r4 + " min delay");
        if (r4 <= 0) goto L8;
        Handler r0 = f8848b;
        if (r0 == null) goto L9;
        r0.postDelayed(b.f8853f, "settings_poll_token", (r4 * 60) * 1000);
        return;
    L9:
        return;
    }

    private static final void n() {
        boolean r0 = h.b();
        boolean r1 = j.c();
        com.obric.matrix.r.c.c.b("MatrixSettingsManager", "force update settings when polling ，net available =  " + r0 + ", screen on = " + r1);
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        com.bytedance.news.common.settings.e.g(true);
    L6:
        f8847a.m();
    }

    public final com.obric.matrix.base.settings.config.d d() {
        return ((IMatrixConfig) com.bytedance.news.common.settings.e.e(IMatrixConfig.class)).getMatrixConfig();
    }

    public final void e(Context r3) {
        o.f(r3, "context");
        com.obric.matrix.r.c.c.b("MatrixSettingsManager", "init() called network status = " + com.bytedance.news.common.settings.h.j.a(com.bytedance.mpaas.app.a.f5245g));
        f8848b = new Handler(r3.getMainLooper());
        com.bytedance.news.common.service.manager.d.c(IPushService.class, com.obric.matrix.base.settings.a.f8852a);
        com.bytedance.news.common.settings.e.g(true);
        m();
        Handler r2 = f8848b;
        if (r2 == null) goto L6;
        r2.postDelayed(c.f8854f, BDLocationConfig.sScanBleMaxInterval);
        return;
    }
}

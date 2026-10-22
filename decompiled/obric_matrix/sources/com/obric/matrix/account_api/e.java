package com.obric.matrix.account_api;

import android.content.Context;
import android.content.Intent;
import com.bytedance.news.common.settings.f;
import com.bytedance.sdk.account.impl.g;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/account_api/SecShareInstance;", "", "()V", "TAG", "", "app", "Landroid/content/Context;", "lastSendInitPassword", "", "initSecShare", "", "sendCancelInitPasswordBroadcast", "sendInitPasswordBroadcast", "sendLogoutBroadcast", "logoutScene", "", "updateAccountShareInfo", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f8822a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8823b = "SecShareInstance";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f8824c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f8825d = -1;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/obric/matrix/account_api/SecShareInstance$initSecShare$1", "Lcom/obric/matrix/account_api/IAccountStatusListener;", "onAccountInfoUpdate", "", "scene", "", "onLogin", "onLogout", "logoutScene", "", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8826a;

        a(Context r1) {
            this.f8826a = r1;
        }

        @Override // com.obric.matrix.account_api.c
        public void e() {
            com.obric.matrix.r.c.c.j(e.b(), "onLogin.");
        }

        @Override // com.obric.matrix.account_api.c
        public void h(int r4) {
            com.obric.matrix.r.c.c.j(e.b(), "onLogout " + r4);
            e.c(e.f8822a, this.f8826a, r4);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            com.obric.matrix.r.c.c.f(e.b(), "onLogout sendLogoutBroadcast " + th);
        }

        @Override // com.obric.matrix.account_api.c
        public void j(String r3) {
            o.f(r3, "scene");
            com.obric.matrix.r.c.c.j(e.b(), "onAccountInfoUpdate " + r3);
            e.d(e.f8822a);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/account_api/SecShareInstance$initSecShare$2", "Lcom/bytedance/news/common/settings/SettingsUpdateListener;", "onSettingsUpdate", "", "settingsData", "Lcom/bytedance/news/common/settings/api/SettingsData;", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements f {
        b() {
        }

        @Override // com.bytedance.news.common.settings.f
        public void a(com.bytedance.news.common.settings.g.c r5) {
            com.obric.matrix.r.c.c.f(e.b(), "initSecShare onSettingsUpdate 1 isEnableTokenGuard=" + com.bytedance.sdk.account.ticketguard.f.s());
            Context r4 = e.a();
            JSONObject r0 = null;
            if (r4 == null) goto L19;
            d.b.s.a.d0.r.a r6 = g.b(r4);
            if (r6 == null) goto L17;
            String r1 = e.b();
            StringBuilder r2 = new StringBuilder();
            r2.append("initSecShare onSettingsUpdate updateSettings isNull:");
            if (r5 == null) goto L9;
            JSONObject r3 = r5.a();
        L10:
            if (r3 != null) goto L12;
            boolean r7 = true;
        L13:
            r2.append(r7);
            com.obric.matrix.r.c.c.b(r1, r2.toString());
            if (r5 == null) goto L16;
            r0 = r5.a();
        L16:
            r6.c(r0);
            goto L17
        L12:
            r7 = false;
            goto L13
        L9:
            r3 = null;
        L17:
            com.obric.matrix.r.c.c.f(e.b(), "initSecShare onSettingsUpdate 2 isEnableTokenGuard=" + com.bytedance.sdk.account.ticketguard.f.s());
            return;
        L19:
            o.v("app");
            throw null;
        }
    }

    static {
        f8822a = new e();
    }

    private e() {
    }

    public static final /* synthetic */ Context a() {
        return f8824c;
    }

    public static final /* synthetic */ String b() {
        return f8823b;
    }

    public static final /* synthetic */ void c(e r0, Context r1, int r2) {
        r0.h(r1, r2);
    }

    public static final /* synthetic */ void d(e r0) {
        r0.i();
    }

    private final void f(Context r4) {
        com.obric.matrix.r.c.c.f(f8823b, "sendCancelInitPasswordBroadcast " + f8825d);
        Intent r3 = new Intent();
        r3.setAction("com.obric.account.CancelInitPasswordReceiver");
        r3.setPackage("com.obric.account");
        r4.sendBroadcast(r3, "com.obric.account.permission.LOGOUT_NOTIFICATION");
    }

    private final void g(Context r4) {
        com.obric.matrix.r.c.c.f(f8823b, "sendInitPasswordBroadcast " + f8825d);
        Intent r3 = new Intent();
        r3.setAction("com.obric.account.SetInitPasswordReceiver");
        r3.setPackage("com.obric.account");
        r4.sendBroadcast(r3, "com.obric.account.permission.LOGOUT_NOTIFICATION");
    }

    private final void h(Context r2, int r3) {
        com.obric.matrix.r.c.c.j(f8823b, "sendLogoutBroadcast");
        Intent r1 = new Intent();
        r1.setAction("com.obric.account.LogoutSceneReceiver");
        r1.putExtra("logout_scene", r3);
        r1.setPackage("com.obric.account");
        r2.sendBroadcast(r1, "com.obric.account.permission.LOGOUT_NOTIFICATION");
    }

    private final void i() {
        String r0 = f8823b;
        StringBuilder r1 = new StringBuilder();
        r1.append("updateAccountShareInfo isLogin=");
        com.obric.matrix.account.a r2 = com.obric.matrix.account.a.f8438a;
        r1.append(r2.v());
        r1.append(" hasPassword=");
        r1.append(r2.f());
        com.obric.matrix.r.c.c.j(r0, r1.toString());
        if (r2.v() == false) goto L9;
        com.ss.android.i.n.a.d.a r3 = new com.ss.android.i.n.a.d.a();
        r3.c(r2.m());
        r3.a(d.b.s.a.u.a.b(r2.m()));
        r3.f(r2.s());
        r3.d(r2.c());
        r3.e(null);
        r3.g(r2.t());
        r3.b(1);
        com.ss.android.i.n.a.e.b r4 = com.ss.android.i.n.a.e.b.f11939f;
        Context r5 = f8824c;
        if (r5 == null) goto L7;
        r4.j(r5, r3);
    L13:
        if (r2.v() == false) goto L27;
        if (r2.f() == true) goto L27;
        long r6 = System.nanoTime() / ((long) 1000000);
        long r8 = f8825d;
        if (r8 > 0) goto L19;
    L21:
        Context r7 = f8824c;
        if (r7 == null) goto L24;
        g(r7);
        f8825d = r6;
        return;
    L24:
        o.v("app");
        throw null;
    L19:
        if ((r6 - r8) >= 86400000) goto L21;
        return;
    L27:
        if (f8825d > 0) goto L29;
        return;
    L29:
        Context r9 = f8824c;
        if (r9 == null) goto L33;
        f(r9);
        f8825d = -1;
        return;
    L33:
        o.v("app");
        throw null;
    L7:
        o.v("app");
        throw null;
    L9:
        com.ss.android.i.n.a.e.b r10 = com.ss.android.i.n.a.e.b.f11939f;
        Context r11 = f8824c;
        if (r11 == null) goto L35;
        r10.h(r11, "key_account_info", "", null);
        goto L13
    L35:
        o.v("app");
        throw null;
    }

    public final void e(Context r5) {
        o.f(r5, "app");
        String r4 = f8823b;
        com.obric.matrix.r.c.c.j(r4, "initSecShare.");
        f8824c = r5;
        com.ss.android.i.n.a.e.d r0 = new com.ss.android.i.n.a.e.d();
        HashMap r1 = new HashMap();
        r1.put("com.larus.nova", "FF04B47EC9DD20B79F758AF67A184926DB00AC55CFD2A01E03FBA9A1DCA9DE2A");
        r0.b(r1);
        com.ss.android.i.n.a.e.b.f11939f.d(r5, r0);
        com.obric.matrix.r.c.c.j(r4, "initSecShare addAccountStatusListener.");
        com.obric.matrix.account.q.a.l().k(new a(r5));
        com.obric.matrix.r.c.c.j(r4, "initSecShare registerListener SettingsUpdateListener.");
        com.bytedance.news.common.settings.e.f(new b(), true);
    }
}

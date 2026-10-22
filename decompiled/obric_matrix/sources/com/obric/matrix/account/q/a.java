package com.obric.matrix.account.q;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.common.wschannel.WsConstants;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.obric.matrix.account_api.c, c, b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final a f8612d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashSet<com.obric.matrix.account_api.c> f8615c;

    static {
        f8612d = new a();
    }

    private a() {
        this.f8613a = false;
        this.f8614b = 0;
        this.f8615c = new HashSet();
    }

    public static a l() {
        return f8612d;
    }

    private static boolean n(long r2, long r4) {
        if (r4 > (120000 + r2)) goto L5;
    L7:
        return false;
    L5:
        if (r4 >= (r2 + 7200000)) goto L7;
        return true;
    }

    @Override // com.obric.matrix.account.q.c
    public void b(String r2, String r3) {
        com.obric.matrix.r.c.c.b("AccountMonitor", "onTryUpdateInfo: triggerType = " + r2 + ", scene = " + r3);
        com.obric.matrix.r.d.c r1 = new com.obric.matrix.r.d.c("com.obric.common.account.try_update_info");
        r1.g("trigger_type", r2);
        r1.g("try_scene", r3);
        r1.j();
    }

    @Override // com.obric.matrix.account.q.c
    public void c(String r4) {
        com.obric.matrix.r.c.c.b("AccountMonitor", "onInfoUpdated: triggerType = " + r4);
        com.obric.matrix.r.c.c.b("AccountMonitor", "onInfoUpdated: mAccountStatusListenerSet.sz = " + this.f8615c.size());
        Iterator<com.obric.matrix.account_api.c> r3 = this.f8615c.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().j(r4);
        goto L4
    L6:
        com.obric.matrix.r.d.c r5 = new com.obric.matrix.r.d.c("com.obric.common.account.info_updated");
        r5.g("trigger_type", r4);
        r5.j();
    }

    @Override // com.obric.matrix.account.q.b
    public void d(String r7) {
        com.obric.matrix.r.c.c.b("AccountMonitor", "onApiForceUpdateAccountCall: pkgName = " + r7);
        long r0 = SystemClock.elapsedRealtime();
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (n(this.f8614b, r0) == false) goto L10;
        com.obric.matrix.r.d.b r1 = new com.obric.matrix.r.d.b("account_forceUpdate_exception");     // Catch: Throwable -> L15
        r1.g("calling_pkgName", r7);     // Catch: Throwable -> L15
        r1.j();     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L10:
        if (r0 <= (this.f8614b + 120000)) goto L13;
        this.f8614b = r0;     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
    }

    @Override // com.obric.matrix.account_api.c
    public void e() {
        j("login");
    }

    @Override // com.obric.matrix.account.q.b
    public void f(@NonNull String r2, boolean r3, int r4, @Nullable String r5) {
        com.obric.matrix.r.c.c.b("AccountMonitor", "onApiLogoutCall: pkgName = " + r2 + ", logoutSuccess = " + r3 + ", errorCode = " + r4 + ", errorMsg = " + r5);
        com.obric.matrix.r.d.c r1 = new com.obric.matrix.r.d.c("com.obric.common.account.api_call_logout");
        r1.g("calling_pkgName", r2);
        r1.g("logout_success", Boolean.valueOf(r3));
        r1.g(WsConstants.ERROR_CODE, Integer.valueOf(r4));
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        r1.h("error_msg", r5);
        r1.j();
    }

    @Override // com.obric.matrix.account.q.c
    public void g(String r3, int r4) {
        com.obric.matrix.r.c.c.b("AccountMonitor", "onStateUpdated: triggerType = " + r3 + ", scene = " + r4);
        if (r3.equals("login") == false) goto L9;
        Iterator<com.obric.matrix.account_api.c> r2 = this.f8615c.iterator();
    L6:
        if (r2.hasNext() == false) goto L14;
        r2.next().e();
    L14:
        com.obric.matrix.r.d.c r5 = new com.obric.matrix.r.d.c("com.obric.common.account.state_updated");
        r5.g("trigger_type", r3);
        r5.g("logout_scene", Integer.valueOf(r4));
        r5.j();
        return;
    L9:
        if (r3.equals("logout") == false) goto L14;
        Iterator<com.obric.matrix.account_api.c> r6 = this.f8615c.iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        r6.next().h(r4);
        goto L12
    }

    @Override // com.obric.matrix.account_api.c
    public void h(int r1) {
        j("logout");
    }

    @Override // com.obric.matrix.account.q.b
    public void i(@NonNull String r2, @NonNull String r3) {
        com.obric.matrix.r.c.c.b("AccountMonitor", "onApiCall: method = " + r2 + ", pkgName = " + r3);
        com.obric.matrix.r.d.c r1 = new com.obric.matrix.r.d.c("com.obric.common.account.api_call");
        r1.g("calling_method", r2);
        r1.g("calling_pkgName", r3);
        r1.j();
    }

    @Override // com.obric.matrix.account_api.c
    public void j(String r1) {
    }

    public void k(com.obric.matrix.account_api.c r1) {
        this.f8615c.add(r1);
    }

    public void m() {
        if (this.f8613a == false) goto L6;
        com.obric.matrix.r.c.c.s("AccountMonitor", "Init already.");
        return;
    L6:
        j("init");
        com.obric.matrix.account.p.b.f8600a.i(this);
        this.f8613a = true;
    }
}

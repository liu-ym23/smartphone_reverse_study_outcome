package com.obric.matrix.account.n;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdturing.verify.b.i;
import com.ttnet.org.chromium.base.BaseSwitches;
import d.b.s.a.l0.h;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.u0.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/account/core/TTAccountConfig;", "Lcom/ss/android/AbsTTAccountConfig;", "()V", "appId", "", "getApplicationContext", "Landroid/content/Context;", "getIBdTruing", "Lcom/ss/android/account/dbtring/IBdTruing;", "getISec", "Lcom/ss/android/account/sec/IAccountSec;", "getLogger", "Lcom/bytedance/sdk/account/log/api/IUserLogger;", "getMonitor", "Lcom/bytedance/sdk/account/utils/IMonitor;", "getNetwork", "Lcom/bytedance/sdk/account/INetWork;", "host", "", "isLocalTest", "", "isSaveLoginInfo", "isSupportMultiLogin", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class d extends com.ss.android.a {

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/obric/matrix/account/core/TTAccountConfig$getIBdTruing$1", "Lcom/ss/android/account/dbtring/AbsBdTuringImpl;", "forceDisable", "", "init", "context", "Landroid/content/Context;", "showVerifyDialog", "", "challengeCode", "", "decisionConf", "", "callback", "Lcom/ss/android/account/dbtring/IBdTruing$IAccountBdTuringCallback;", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends com.ss.android.i.k.a {

        /* JADX INFO: renamed from: com.obric.matrix.account.n.d$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/account/core/TTAccountConfig$getIBdTruing$1$showVerifyDialog$2", "Lcom/bytedance/bdturing/BdTuringCallback;", "onFail", "", "result", "", "extras", "Lorg/json/JSONObject;", "onSuccess", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class C0222a implements com.bytedance.bdturing.c {
            C0222a() {
            }

            @Override // com.bytedance.bdturing.c
            public void a(int r1, JSONObject r2) {
            }

            @Override // com.bytedance.bdturing.c
            public void b(int r1, JSONObject r2) {
            }
        }

        a() {
        }

        @Override // com.ss.android.i.k.b
        public boolean b() {
            return false;
        }

        @Override // com.ss.android.i.k.b
        public void c(int r1, String r2, com.ss.android.i.k.b.a r3) {
            com.bytedance.bdturing.b r0 = com.bytedance.bdturing.b.f();
            Activity r4 = d.b.s.a.l0.d.i();
            if (r2 == null) goto L5;
            i r5 = new i(r2);
        L6:
            r0.i(r4, r5, new C0222a());
            return;
        L5:
            r5 = null;
            goto L6
        }

        @Override // com.ss.android.i.k.b
        public boolean init(Context r1) {
            return true;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\"\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\"\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u000f"}, d2 = {"com/obric/matrix/account/core/TTAccountConfig$getLogger$1", "Lcom/bytedance/sdk/account/log/api/IUserLogger;", "canLog", "", LocationMonitorConst.TAG, "", "d", "", NotificationCompat.CATEGORY_MESSAGE, "e", "throwable", "", "i", BaseSwitches.V, "w", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements d.b.s.a.a0.c.a {
        b() {
        }

        private final boolean c(String r4) {
            if (k.F(r4, "Ticket", false, 2, null) == false) goto L5;
            return false;
        L5:
            if (k.F(r4, "BaseAccountApi", false, 2, null) == false) goto L7;
            return false;
        L7:
            if (k.F(r4, "Token", false, 2, null) == true) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // d.b.s.a.a0.c.a
        public void a(String r2, String r3) {
            o.f(r2, LocationMonitorConst.TAG);
            o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
            if (c(r2) == false) goto L6;
            com.obric.matrix.r.c.c.b(r2, r3);
            return;
        }

        @Override // d.b.s.a.a0.c.a
        public void b(String r2, String r3) {
            o.f(r2, LocationMonitorConst.TAG);
            o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
            if (c(r2) == false) goto L6;
            com.obric.matrix.r.c.c.j(r2, r3);
            return;
        }

        @Override // d.b.s.a.a0.c.a
        public void e(String r2, String r3) {
            o.f(r2, LocationMonitorConst.TAG);
            o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
            if (c(r2) == false) goto L6;
            com.obric.matrix.r.c.c.q(r2, r3);
            return;
        }

        @Override // d.b.s.a.a0.c.a
        public void e(String r2, String r3, Throwable r4) {
            o.f(r2, LocationMonitorConst.TAG);
            o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
            if (c(r2) == false) goto L6;
            com.obric.matrix.r.c.c.g(r2, r3, r4);
            return;
        }

        @Override // d.b.s.a.a0.c.a
        public void w(String r2, String r3, Throwable r4) {
            o.f(r2, LocationMonitorConst.TAG);
            o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
            if (c(r2) == false) goto L6;
            com.obric.matrix.r.c.c.t(r2, r3, r4);
            return;
        }
    }

    public d() {
    }

    private static final boolean m(Context r0) {
        return true;
    }

    public static /* synthetic */ boolean n(Context r0) {
        return m(r0);
    }

    @Override // com.ss.android.d
    public d.b.s.a.a0.c.a a() {
        return new b();
    }

    @Override // com.ss.android.d
    public h b() {
        return new com.obric.matrix.account.l.a();
    }

    @Override // com.ss.android.d
    public String c() {
        if (com.obric.matrix.account.http.i.c().a() == false) goto L5;
        return "os-assistant-boe.bytedance.net";
    L5:
        return "os.oceancloudapi.com";
    }

    @Override // com.ss.android.d
    public d.b.s.a.i d() {
        return new com.obric.matrix.account.l.b();
    }

    @Override // com.ss.android.d
    public Context e() {
        return d.g.f.a.a.f16974a.d();
    }

    @Override // com.ss.android.d
    public int f() {
        return 508474;
    }

    @Override // com.ss.android.d
    public boolean g() {
        return false;
    }

    @Override // com.ss.android.d
    public boolean h() {
        return true;
    }

    @Override // com.ss.android.d
    public com.ss.android.i.k.b i() {
        return new a();
    }

    @Override // com.ss.android.d
    public com.ss.android.i.m.a k() {
        return com.obric.matrix.account.n.a.f8590a;
    }

    @Override // com.ss.android.d
    public boolean l() {
        return true;
    }
}

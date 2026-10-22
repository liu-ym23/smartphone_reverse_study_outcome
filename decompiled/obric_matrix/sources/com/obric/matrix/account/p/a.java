package com.obric.matrix.account.p;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.sdk.account.impl.e;
import com.obric.matrix.account.k;
import com.obric.matrix.r.e.l;
import com.ss.android.i.j;
import com.ss.android.token.n;
import d.b.s.a.q.k.c;
import d.b.s.a.q.m.d;
import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0006\u0010\u0013\u001a\u00020\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\u0006\u0010\u0019\u001a\u00020\u0015J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0015J\u0006\u0010 \u001a\u00020\u0015J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0004J\u0010\u0010\"\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020\u0010J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/matrix/account/manager/BDAccountManagerProxy;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "()V", "KEY_ACCOUNT_INFO_RAW_JSON_DATA", "", "TAG", "UPDATE_ACCOUNT_INFO", "", "UPDATE_DEFAULT_INTERVAL", "", "lastUpdateTime", "lastUpdateTokenTime", "mHandler", "Lcom/bytedance/common/utility/collection/WeakHandler;", "mLastToken", "mUpdating", "", "compareDataIsEqualOldRawJson", "dataJsonStr", "getUserRawJsonData", "handleMsg", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "isUpdatable", "onLogout", "removeUnnecessaryParams", "rawData", "sendBroadcastForAccountRefreshIfNeed", "accountInfoResponse", "Lcom/bytedance/sdk/account/api/response/GetAccountInfoResponse;", "sendQueryUserInfoMsg", "stopUpdate", "storeUserRawJsonData", "tryUpdateTokenIfNeed", "force", "tryUpdateUserInfo", "scene", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f8593f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final WeakHandler f8594g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f8595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile boolean f8596i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static long f8597j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static long f8598k;

    /* JADX INFO: renamed from: com.obric.matrix.account.p.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/matrix/account/manager/BDAccountManagerProxy$tryUpdateUserInfo$1", "Lcom/bytedance/sdk/account/api/callback/GetAccountInfoCallback;", "onError", "", "getAccountInfoResult", "Lcom/bytedance/sdk/account/api/response/GetAccountInfoResponse;", "p1", "", "onSuccess", "accountInfoResponse", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0223a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f8599c;

        C0223a(String r1) {
            this.f8599c = r1;
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void j(d.b.s.a.q.j.b r1, int r2) {
            m((d) r1, r2);
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void l(d.b.s.a.q.j.b r1) {
            n((d) r1);
        }

        public void m(d r1, int r2) {
            o.f(r1, "getAccountInfoResult");
            com.obric.matrix.r.c.c.f("BDAccountManagerProxy", "getNewAccountInfo() onError: logid = " + r1.f14885a + ", errorCode = " + r1.f14891g + ", errorMsg = " + r1.f14893i);
            a.f8593f.g();
            a.a(false);
        }

        public void n(d r5) {
            StringBuilder r0 = new StringBuilder();
            r0.append("getNewAccountInfo() onSuccess, logId: [");
            d.b.s.a.k0.a r1 = null;
            if (r5 == null) goto L5;
            String r2 = r5.f14885a;
        L6:
            r0.append(r2);
            r0.append(']');
            com.obric.matrix.r.c.c.j("BDAccountManagerProxy", r0.toString());
            k r3 = k.f8544a;
            if (r5 == null) goto L9;
            d.b.s.a.k0.a r4 = r5.p;
        L10:
            r3.c(r4, "getNewAccountInfo onSuccess");
            com.obric.matrix.account.a r6 = com.obric.matrix.account.a.f8438a;
            if (r5 == null) goto L13;
            r1 = r5.p;
        L13:
            r6.B(r1, this.f8599c);
            a r7 = a.f8593f;
            r7.f(r5);
            r7.g();
            a.a(false);
            return;
        L9:
            r4 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
        a r0 = new a();
        f8593f = r0;
        f8594g = new WeakHandler(Looper.getMainLooper(), r0);
        f8595h = com.obric.matrix.account.a.f8438a.u();
    }

    private a() {
    }

    public static final /* synthetic */ void a(boolean r0) {
        f8596i = r0;
    }

    private final boolean b(String r2) {
        String r0 = c();
        return o.a(e(r2), r0);
    }

    private final String e(String r8) {
        JSONObject r0 = l.f9944a.b(r8);     // Catch: Exception -> L18
        if (r0 != null) goto L6;
        r0 = new JSONObject();     // Catch: Exception -> L18
    L6:
        JSONArray r1 = r0.optJSONArray("connects");     // Catch: Exception -> L18
        if (r1 != null) goto L9;
        return r8;
    L9:
        JSONArray r2 = new JSONArray();     // Catch: Exception -> L18
        int r3 = 0;
        int r4 = r1.length();     // Catch: Exception -> L18
    L10:
        if (r3 >= r4) goto L16;
        Object r5 = r1.get(r3);     // Catch: Exception -> L18
        if (r5 == null) goto L15;
        JSONObject r6 = (JSONObject) r5;     // Catch: Exception -> L18
        r6.remove("expires_in");     // Catch: Exception -> L18
        r2.put(r6);     // Catch: Exception -> L18
        r3 = r3 + 1;     // Catch: Exception -> L18
        goto L10
    L15:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: Exception -> L18
    L16:
        r0.put("connects", r2);     // Catch: Exception -> L18
        String r7 = r0.toString();     // Catch: Exception -> L18
        o.e(r7, "rawJson.toString()");     // Catch: Exception -> L18
        return r7;
    L18:
        e = move-exception;
        com.obric.matrix.r.c.c.f("BDAccountManagerProxy", "process raw json exception " + Log.getStackTraceString(e));
        return r8;
    }

    public static /* synthetic */ void k(a r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.j(r1);
    }

    public static /* synthetic */ void m(a r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.l(r1, r2);
    }

    public final String c() {
        return com.obric.matrix.q.e.a.k(com.obric.matrix.q.e.a.f9851a, "account_info_raw_json_data", null, null, 6, null);
    }

    public final void d() {
        com.obric.matrix.q.e.a.c(com.obric.matrix.q.e.a.f9851a, "account_info_raw_json_data", null, 2, null);
    }

    public final void f(d r5) {
        if (r5 == null) goto L6;
        d.b.s.a.k0.a r6 = r5.a();
        if (r6 == null) goto L6;
        JSONObject r7 = r6.i();
    L7:
        String r8 = String.valueOf(r7);
        boolean r1 = true;
        if (b(r8) == true) goto L10;
        com.obric.matrix.r.c.c.b("BDAccountManagerProxy", "AccountInfo has update ");
        i(r8);
        boolean r4 = true;
    L11:
        String r9 = f8595h;
        com.obric.matrix.account.a r0 = com.obric.matrix.account.a.f8438a;
        if (o.a(r9, r0.u()) == true) goto L14;
        com.obric.matrix.r.c.c.b("BDAccountManagerProxy", "xTTToken has update");
        f8595h = r0.u();
    L15:
        if (r1 == false) goto L17;
        com.obric.matrix.r.c.c.b("BDAccountManagerProxy", "call OAccountManager.sendBroadcastForAccountRefresh");
        b.f8600a.j("xTTTokenUpdated");
        return;
    L17:
        com.obric.matrix.r.c.c.b("BDAccountManagerProxy", "AccountInfo no update");
        return;
    L14:
        com.obric.matrix.r.c.c.b("BDAccountManagerProxy", "xTTToken no update");
        r1 = r4;
        goto L15
    L10:
        r4 = false;
    L6:
        r7 = null;
        goto L7
    }

    public final void g() {
        com.obric.matrix.r.c.c.b("BDAccountManagerProxy", "sendQueryUserInfoMsg() called");
        if (j.m() != null) goto L6;
        f8594g.sendEmptyMessageDelayed(1000, 600000);
        return;
    L6:
        j.m().d();
        throw null;
    }

    public final void h() {
        f8594g.removeMessages(1000);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r4) {
        if (r4 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == false) goto L11;
        f8594g.removeMessages(1000);
        m(this, "polling", false, 2, null);
        return;
    L11:
        return;
    L5:
        if (r4.what != 1000) goto L7;
        r5 = true;
        goto L8
    }

    public final void i(String r8) {
        o.f(r8, "rawData");
        String r3 = e(r8);
        com.obric.matrix.r.c.c.b("BDAccountManagerProxy", "storeUserRawJsonData final json " + r3);
        com.obric.matrix.q.e.a.m(com.obric.matrix.q.e.a.f9851a, "account_info_raw_json_data", r3, null, 4, null);
    }

    public final void j(boolean r5) {
        if (r5 == false) goto L4;
    L7:
        com.obric.matrix.r.c.c.j("BDAccountManagerProxy", "tryUpdateTokenIfNeed() called with interval: " + (SystemClock.elapsedRealtime() - f8598k) + ", force: " + r5);
        f8598k = SystemClock.elapsedRealtime();
        n.y();
        return;
    L4:
        if ((SystemClock.elapsedRealtime() - f8598k) >= 600000) goto L6;
        return;
    L6:
        if (com.obric.matrix.r.e.j.c() == true) goto L7;
    }

    public final void l(String r8, boolean r9) {
        o.f(r8, "scene");
        StringBuilder r0 = new StringBuilder();
        r0.append("tryUpdateUserInfo() called with isLogin = ");
        com.obric.matrix.account.a r1 = com.obric.matrix.account.a.f8438a;
        r0.append(r1.v());
        r0.append(", mUpdating = ");
        r0.append(f8596i);
        r0.append(", scene: ");
        r0.append(r8);
        com.obric.matrix.r.c.c.b("BDAccountManagerProxy", r0.toString());
        com.obric.matrix.account.q.c r2 = com.obric.matrix.account.q.c.a();
        if (r2 == null) goto L6;
        r2.b("tryUpdateUserInfo", r8);
    L6:
        if ((SystemClock.elapsedRealtime() - f8597j) >= 600000) goto L12;
        if (r9 == true) goto L12;
        String r7 = "tryUpdateUserInfo() called with interval: " + (SystemClock.elapsedRealtime() - f8597j);
    L9:
        com.obric.matrix.r.c.c.j("BDAccountManagerProxy", r7);
        return;
    L12:
        if (com.obric.matrix.r.e.j.c() == true) goto L15;
        if (r9 == true) goto L15;
        r7 = "tryUpdateUserInfo() called with screen off";
    L15:
        f8597j = SystemClock.elapsedRealtime();
        if (r1.v() == true) goto L19;
        g();
        f8596i = false;
        return;
    L19:
        if (f8596i == true) goto L23;
        f8596i = true;
        e.a().d("normal", new C0223a(r8));
        return;
    }
}

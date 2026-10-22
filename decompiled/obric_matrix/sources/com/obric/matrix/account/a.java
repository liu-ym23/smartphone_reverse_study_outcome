package com.obric.matrix.account;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.token.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010H\u001a\u00020IJ\u0018\u0010J\u001a\u00020I2\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b \u0010\u001bR\u0011\u0010!\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b!\u0010\u001bR$\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010\u000f\"\u0004\b%\u0010\u001fR$\u0010'\u001a\u00020&2\u0006\u0010\"\u001a\u00020&8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010/R\u0011\u00100\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b1\u0010\u0017R\u0011\u00102\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b3\u0010\u000fR\u0011\u00104\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b5\u0010\u000fR\u001d\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004078F¢\u0006\u0006\u001a\u0004\b8\u00109R\u0011\u0010:\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b;\u0010\u000fR\u0011\u0010<\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b=\u0010\u0017R\u0011\u0010>\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b?\u0010)R\u0011\u0010@\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bA\u0010\u000fR\u0011\u0010B\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bC\u0010\u000fR\u0011\u0010D\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bE\u0010\u000fR\u0011\u0010F\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bG\u0010\u000f¨\u0006N"}, d2 = {"Lcom/obric/matrix/account/AccountGlobals;", "", "()V", "KEY_INNER_SSO_TOKEN", "", "KEY_LOGIN_PHONE_NUMBER", "KEY_LOGIN_UTC_TIME", "KEY_LOGOUT_SCENE", "TAG", "accountInfo", "Lcom/obric/matrix/account_api/AccountInfo;", "getAccountInfo", "()Lcom/obric/matrix/account_api/AccountInfo;", "avatarUrl", "getAvatarUrl", "()Ljava/lang/String;", "bdAccount", "Lcom/bytedance/sdk/account/api/IBDAccount;", "getBdAccount", "()Lcom/bytedance/sdk/account/api/IBDAccount;", "countryCode", "", "getCountryCode", "()I", "hasPassword", "", "getHasPassword", "()Z", "innerSSOToken", "getInnerSSOToken", "setInnerSSOToken", "(Ljava/lang/String;)V", "isLogin", "isNewUser", "value", "loginPhoneNumber", "getLoginPhoneNumber", "setLoginPhoneNumber", "", "loginUtcTime", "getLoginUtcTime", "()J", "setLoginUtcTime", "(J)V", "logoutScene", "getLogoutScene", "setLogoutScene", "(I)V", "odinUserType", "getOdinUserType", "screenName", "getScreenName", "secUserId", "getSecUserId", "tokenMap", "", "getTokenMap", "()Ljava/util/Map;", "userEmail", "getUserEmail", "userGender", "getUserGender", "userId", "getUserId", "userMobile", "getUserMobile", "userName", "getUserName", "userSession", "getUserSession", "xTTToken", "getXTTToken", "clearAccountInfo", "", "updateUserInfo", LocationMonitorConst.INFO, "Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;", "scene", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8438a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f8439b = "";

    static {
        f8438a = new a();
    }

    private a() {
    }

    public final void A(int r7) {
        com.obric.matrix.q.e.a.m(com.obric.matrix.q.e.a.f9851a, "logout_scene", Integer.valueOf(r7), null, 4, null);
    }

    public final void B(d.b.s.a.k0.a r4, String r5) {
        o.f(r5, "scene");
        if (r4 != null) goto L6;
        com.obric.matrix.r.c.c.s("AccountGlobals", "updateUserInfo, " + r5 + ", info is null");
        return;
    L6:
        com.obric.matrix.r.c.e.a("AccountGlobals", "updateUserInfo, " + r5 + ", " + r4.j());
        r4.a();
        d.b.s.a.q.f r3 = d();
        if (r3 == null) goto L10;
        r3.u(r4, true);
        return;
    }

    public final void a() {
        d.b.s.a.q.f r1 = d();
        if (r1 == null) goto L6;
        r1.x(false);
        return;
    }

    public final com.obric.matrix.account_api.a b() {
        boolean r1 = v();
        int r2 = j();
        String r3 = m();
        String r4 = String.valueOf(q());
        int r5 = k();
        String r6 = u();
        String r8 = c();
        int r9 = e();
        String r10 = s();
        String r11 = l();
        String r12 = o();
        String r13 = r();
        boolean r14 = f();
        int r15 = p();
        boolean r16 = w();
        String r17 = t();
        String r20 = h();
        return new com.obric.matrix.account_api.a(r1, r2, r3, r4, r5, r6, "", r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, i(), r20);
    }

    public final String c() {
        if (v() == false) goto L12;
        d.b.s.a.q.f r2 = d();
        if (r2 == null) goto L7;
        String r3 = r2.p();
    L8:
        if (r3 != null) goto L11;
        return "";
    L11:
        return r3;
    L7:
        r3 = null;
        goto L8
    L12:
        return "";
    }

    public final d.b.s.a.q.f d() {
        com.obric.matrix.r.b r1 = com.obric.matrix.r.b.f9910a;
        if (r1.d() == true) goto L9;
        if (r1.f() == true) goto L9;
        return null;
    L9:
        return com.bytedance.sdk.account.impl.g.d(r1.a());
    }

    public final int e() {
        d.b.s.a.q.f r0 = d();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.f();
    }

    public final boolean f() {
        d.b.s.a.q.f r0 = d();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.t();
    }

    public final String g() {
        return f8439b;
    }

    public final String h() {
        return com.obric.matrix.q.e.a.k(com.obric.matrix.q.e.a.f9851a, "login_phone_number", "", null, 4, null);
    }

    public final long i() {
        return com.obric.matrix.q.e.a.i(com.obric.matrix.q.e.a.f9851a, "login_utc_time", 0L, null, 4, null);
    }

    public final int j() {
        return com.obric.matrix.q.e.a.g(com.obric.matrix.q.e.a.f9851a, "logout_scene", 0, null, 4, null);
    }

    public final int k() {
        d.b.s.a.q.f r0 = d();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.g();
    }

    public final String l() {
        d.b.s.a.q.f r0 = d();
        if (r0 == null) goto L5;
        String r1 = r0.w();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String m() {
        d.b.s.a.q.f r0 = d();
        if (r0 == null) goto L5;
        String r1 = r0.k();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final Map<String, String> n() {
        Map<String, String> r1 = n.d("https://" + com.ss.android.i.j.k().c());
        o.e(r1, "addRequestHeader(\"https:…tInit.getConfig().host())");
        return r1;
    }

    public final String o() {
        d.b.s.a.q.f r0 = d();
        if (r0 == null) goto L5;
        String r1 = r0.n();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final int p() {
        d.b.s.a.q.f r0 = d();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.r();
    }

    public final long q() {
        d.b.s.a.q.f r2 = d();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.getUserId();
    }

    public final String r() {
        d.b.s.a.q.f r0 = d();
        if (r0 == null) goto L5;
        String r1 = r0.j();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String s() {
        d.b.s.a.q.f r0 = d();
        if (r0 == null) goto L5;
        String r1 = r0.e();
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L19;
        k r3 = k.f8544a;
        d.b.s.a.q.f r4 = d();
        if (r4 == null) goto L16;
        long r5 = r4.getUserId();
    L18:
        return r3.a(r5);
    L16:
        r5 = 0;
        goto L18
    L19:
        return r1;
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final String t() {
        if (v() == false) goto L12;
        d.b.s.a.q.f r2 = d();
        if (r2 == null) goto L7;
        String r3 = r2.getSessionKey();
    L8:
        if (r3 != null) goto L11;
        return "";
    L11:
        return r3;
    L7:
        r3 = null;
        goto L8
    L12:
        return "";
    }

    public final String u() {
        if (v() == false) goto L9;
        String r1 = n.j();
        if (r1 != null) goto L8;
        return "";
    L8:
        return r1;
    L9:
        return "";
    }

    public final boolean v() {
        d.b.s.a.q.f r0 = d();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.m();
    }

    public final boolean w() {
        d.b.s.a.q.f r0 = d();
        if (r0 == null) goto L7;
        d.b.s.a.k0.a r1 = r0.a();
        if (r1 == null) goto L7;
        return r1.f14834g;
    L7:
        return false;
    }

    public final void x(String r1) {
        o.f(r1, "<set-?>");
        f8439b = r1;
    }

    public final void y(String r7) {
        o.f(r7, "value");
        com.obric.matrix.q.e.a.m(com.obric.matrix.q.e.a.f9851a, "login_phone_number", r7, null, 4, null);
    }

    public final void z(long r7) {
        com.obric.matrix.q.e.a.m(com.obric.matrix.q.e.a.f9851a, "login_utc_time", Long.valueOf(r7), null, 4, null);
    }
}

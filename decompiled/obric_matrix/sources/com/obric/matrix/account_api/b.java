package com.obric.matrix.account_api;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0001¨\u0006\u0005"}, d2 = {"fromBundle", "Lcom/obric/matrix/account_api/AccountInfo;", "bundle", "Landroid/os/Bundle;", "toBundle", "account_api_cnRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class b {
    public static final Bundle a(a r4) {
        o.f(r4, "<this>");
        Bundle r0 = new Bundle();
        r0.putBoolean("loginState", r4.f());
        r0.putInt("logoutScene", r4.h());
        r0.putString("secUserId", r4.k());
        r0.putString("userId", r4.n());
        r0.putInt("odinUserType", r4.i());
        r0.putString("token", r4.r());
        r0.putString("innerSsoToken", r4.d());
        r0.putString("avatarUrl", r4.a());
        r0.putInt("countryCode", r4.b());
        r0.putString("userName", r4.p());
        r0.putString("screenName", r4.j());
        r0.putString("userEmail", r4.l());
        r0.putString("userMobile", r4.o());
        r0.putBoolean("hasPassword", r4.c());
        r0.putInt("userGender", r4.m());
        r0.putBoolean("isNewUser", r4.s());
        r0.putString("userSession", r4.q());
        r0.putLong("loginUtcTime", r4.g());
        r0.putString("loginPhoneNumber", r4.e());
        return r0;
    }
}

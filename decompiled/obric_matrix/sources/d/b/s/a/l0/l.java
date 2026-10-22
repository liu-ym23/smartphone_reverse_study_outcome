package d.b.s.a.l0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class l {
    public static void a(Map<String, String> r0) {
        com.ss.android.e r1 = com.ss.android.i.j.m();
        if (r1 != null) goto L5;
        return;
    L5:
        r1.b();
        throw null;
    }

    public static com.ss.android.h b(int r1, String r2, List<com.ss.android.f> r3, int r4) {
        d.b.s.a.i r0 = com.ss.android.i.j.k().d();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.b(r1, r2, r3, r4);
    }

    public static com.ss.android.h c(int r7, String r8, Map<String, String> r9, List<com.ss.android.f> r10, int r11) {
        d.b.s.a.i r1 = com.ss.android.i.j.k().d();
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.e(r7, r8, r9, r10, r11);
    }

    public static com.ss.android.h d(int r2, String r3, Map<String, String> r4, List<com.ss.android.f> r5, int r6) {
        if (com.bytedance.sdk.account.settings.f.a.u() == false) goto L13;
        HashMap r0 = new HashMap();
        if (r4 == null) goto L7;
        r0.putAll(r4);
    L7:
        a(r0);
        r0.put("account_sdk_source", "app");
        r0.put("passport_support_flow", d.b.s.a.v.a.b.d());
        if (com.ss.android.i.j.k().h() == false) goto L11;
        r0.put("multi_login", LocationInfoConst.ALLOW_USE_LOCATION);
    L11:
        return c(r2, e(r3).toString(), r0, r5, r6);
    L13:
        return c(r2, r3, r4, r5, r6);
    }

    public static d.b.s.a.e0.c e(String r2) {
        d.b.s.a.e0.c r0 = new d.b.s.a.e0.c(r2);
        r0.a("passport-sdk-version", 601339);
        if (com.bytedance.sdk.account.settings.b.c() == false) goto L5;
        r0.b("use_new_token_expire_rule", "true");
    L5:
        r0.b("request_from_account_sdk", LocationInfoConst.ALLOW_USE_LOCATION);
        r0.b("is_from_ttaccountsdk", LocationInfoConst.ALLOW_USE_LOCATION);
        return r0;
    }

    public static boolean f(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r3 == null) goto L12;
        if (r3.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static com.ss.android.h g(int r8, String r9, Map<String, String> r10, String r11, String r12, List<com.ss.android.f> r13) {
        d.b.s.a.i r1 = com.ss.android.i.j.k().d();
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.d(r8, r9, r10, r11, r12, r13);
    }
}

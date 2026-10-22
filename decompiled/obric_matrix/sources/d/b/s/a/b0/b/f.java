package d.b.s.a.b0.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.k;
import com.bytedance.sdk.account.impl.l;
import d.b.s.a.b0.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends l<d.b.s.a.q.j.e<g>> {
    private g u;

    private f(Context r1, d.b.s.a.w.a r2, g r3, d.b.s.a.b0.b.g.e r4) {
        super(r1, r2, r4);
        this.u = r3;
    }

    protected static Map<String, String> J(g r3) {
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r3.f14667l) == true) goto L6;
        r0.put(NotificationCompat.CATEGORY_EMAIL, k.a(r3.f14667l));
    L6:
        if (TextUtils.isEmpty(r3.n) == true) goto L9;
        r0.put("mobile", k.a(r3.n));
    L9:
        if (TextUtils.isEmpty(r3.m) == true) goto L12;
        r0.put("username", k.a(r3.m));
    L12:
        if (TextUtils.isEmpty(r3.o) == true) goto L15;
        r0.put("account", k.a(r3.o));
    L15:
        if (TextUtils.isEmpty(r3.q) == true) goto L18;
        r0.put("token", r3.q);
    L18:
        if (TextUtils.isEmpty(r3.r) == true) goto L20;
        r0.put("captcha", r3.r);
    L20:
        int r1 = r3.s;
        if (r1 <= 0) goto L23;
        r0.put("scene", k.a(String.valueOf(r1)));
    L23:
        r0.put("password", k.a(r3.p));
        r0.put("mix_mode", LocationInfoConst.ALLOW_USE_LOCATION);
        return r0;
    }

    public static f M(Context r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, int r18, Map<String, String> r19, d.b.s.a.b0.b.g.e r20) {
        g r9 = new g(r12, r13, r11, r14, r15, r16, r17, r18);
        d.b.s.a.w.a.C0402a r0 = new d.b.s.a.w.a.C0402a();
        r0.l(d.b.s.a.q.d.g());
        r0.h(J(r9));
        r0.h(r19);
        return new f(r10, r0.j(), r9, r20);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return L(r1, r2);
    }

    public void K(d.b.s.a.q.j.e<g> r3) {
        com.bytedance.sdk.account.monitor.c.j("passport_account_login", null, null, r3, this.f5622j);
    }

    protected d.b.s.a.q.j.e<g> L(boolean r2, d.b.s.a.w.b r3) {
        return new d.b.s.a.q.j.e(r2, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, this.u);
    }

    @Override // com.bytedance.sdk.account.impl.l
    public /* bridge */ /* synthetic */ void t(d.b.s.a.q.j.b r1) {
        K((d.b.s.a.q.j.e) r1);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void u(JSONObject r2, JSONObject r3) {
        com.bytedance.sdk.account.impl.c.b(this.u, r2);
        this.u.f14657f = r3;
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void x(JSONObject r2, JSONObject r3) {
        g r0 = this.u;
        r0.t = com.bytedance.sdk.account.impl.c.a.a(r2, r3);
        this.u.f14657f = r2;
    }
}

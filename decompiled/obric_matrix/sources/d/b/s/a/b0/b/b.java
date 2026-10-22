package d.b.s.a.b0.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.k;
import com.bytedance.sdk.account.impl.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends l<d.b.s.a.q.j.e<d.b.s.a.b0.a.d>> {
    private d.b.s.a.b0.a.d u;

    private b(Context r1, d.b.s.a.w.a r2, d.b.s.a.b0.a.d r3, d.b.s.a.b0.b.g.a r4) {
        super(r1, r2, r4);
        this.u = r3;
    }

    protected static Map<String, String> J(d.b.s.a.b0.a.d r3) {
        HashMap r0 = new HashMap();
        r0.put("mobile", k.a(r3.f14664l));
        if (TextUtils.isEmpty(r3.o) == true) goto L5;
        r0.put("captcha", r3.o);
    L5:
        r0.put("code", k.a(String.valueOf(r3.m)));
        r0.put("mix_mode", LocationInfoConst.ALLOW_USE_LOCATION);
        Integer r4 = r3.n;
        if (r4 == null) goto L8;
        r0.put("auth_opposite", String.valueOf(r4));
    L8:
        return r0;
    }

    public static b L(Context r1, String r2, String r3, Integer r4, String r5, Map<String, String> r6, d.b.s.a.b0.b.g.a r7) {
        d.b.s.a.b0.a.d r0 = new d.b.s.a.b0.a.d(r2, r3, r4, r5);
        d.b.s.a.w.a.C0402a r8 = new d.b.s.a.w.a.C0402a();
        r8.l(d.b.s.a.e.m());
        r8.i(J(r0), r6);
        r8.d();
        return new b(r1, r8.j(), r0, r7);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return M(r1, r2);
    }

    public void K(d.b.s.a.q.j.e<d.b.s.a.b0.a.d> r4) {
        com.bytedance.sdk.account.monitor.c.j("passport_mobile_login", "mobile", "login", r4, this.f5622j);
    }

    protected d.b.s.a.q.j.e<d.b.s.a.b0.a.d> M(boolean r2, d.b.s.a.w.b r3) {
        return new d.b.s.a.q.j.e(r2, PointerIconCompat.TYPE_CELL, this.u);
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
        d.b.s.a.b0.a.d r0 = this.u;
        r0.p = com.bytedance.sdk.account.impl.c.a.a(r2, r3);
        this.u.f14657f = r2;
    }
}

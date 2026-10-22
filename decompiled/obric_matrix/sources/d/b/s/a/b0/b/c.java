package d.b.s.a.b0.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.k;
import com.bytedance.sdk.account.impl.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends l<d.b.s.a.q.j.e<d.b.s.a.b0.a.e>> {
    private d.b.s.a.b0.a.e u;
    private boolean v;

    private c(Context r1, d.b.s.a.w.a r2, d.b.s.a.b0.a.e r3, boolean r4, d.b.s.a.b0.b.g.b r5) {
        super(r1, r2, r5);
        this.u = r3;
        this.v = r4;
    }

    protected static Map<String, String> J(d.b.s.a.b0.a.e r3) {
        HashMap r0 = new HashMap();
        r0.put("mobile", k.a(r3.f14665l));
        if (TextUtils.isEmpty(r3.o) == true) goto L5;
        r0.put("captcha", r3.o);
    L5:
        r0.put("code", k.a(r3.m));
        r0.put("password", k.a(r3.n));
        r0.put("mix_mode", LocationInfoConst.ALLOW_USE_LOCATION);
        return r0;
    }

    public static c L(Context r6, String r7, String r8, String r9, String r10, boolean r11, Map<String, String> r12, d.b.s.a.b0.b.g.b r13) {
        d.b.s.a.b0.a.e r3 = new d.b.s.a.b0.a.e(r7, r8, r9, r10);
        d.b.s.a.w.a.C0402a r14 = new d.b.s.a.w.a.C0402a();
        r14.l(d.b.s.a.e.n());
        r14.i(J(r3), r12);
        return new c(r6, r14.j(), r3, r11, r13);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return M(r1, r2);
    }

    public void K(d.b.s.a.q.j.e<d.b.s.a.b0.a.e> r4) {
        com.bytedance.sdk.account.monitor.c.j("passport_mobile_reset_password", "mobile", null, r4, this.f5622j);
    }

    protected d.b.s.a.q.j.e<d.b.s.a.b0.a.e> M(boolean r2, d.b.s.a.w.b r3) {
        return new d.b.s.a.q.j.e(r2, 1003, this.u);
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
        if (this.v == false) goto L5;
        d.b.s.a.b0.a.e r0 = this.u;
        r0.p = com.bytedance.sdk.account.impl.c.a.a(r2, r3);
    L6:
        this.u.f14657f = r2;
        return;
    L5:
        this.u.p = null;
        goto L6
    }
}

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
public class e extends l<d.b.s.a.q.j.e<a>> {
    private a u;

    public static class a extends d.b.s.a.b0.a.b {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        String f14668l;
        String m;

        public a(String r2, String r3) {
            super(13);
            this.f14668l = r2;
            this.m = r3;
        }
    }

    public e(Context r1, d.b.s.a.w.a r2, a r3, d.b.s.a.b0.b.g.d r4) {
        super(r1, r2, r4);
        this.u = r3;
    }

    protected static Map<String, String> J(a r3, Map<String, String> r4) {
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r3.m) == true) goto L5;
        r0.put("captcha", r3.m);
    L5:
        r0.put("password", k.a(r3.f14668l));
        r0.put("mix_mode", LocationInfoConst.ALLOW_USE_LOCATION);
        if (r4 == null) goto L8;
        r0.putAll(r4);
    L8:
        return r0;
    }

    public static e L(Context r1, String r2, String r3, d.b.s.a.b0.b.g.d r4) {
        a r0 = new a(r2, r3);
        d.b.s.a.w.a.C0402a r5 = new d.b.s.a.w.a.C0402a();
        r5.l(d.b.s.a.e.k());
        r5.h(J(r0, null));
        return new e(r1, r5.j(), r0, r4);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return M(r1, r2);
    }

    public void K(d.b.s.a.q.j.e<a> r4) {
        com.bytedance.sdk.account.monitor.c.j("passport_mobile_set_password", "mobile", null, r4, this.f5622j);
    }

    protected d.b.s.a.q.j.e<a> M(boolean r2, d.b.s.a.w.b r3) {
        return new d.b.s.a.q.j.e(r2, 10002, this.u);
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
    protected void x(JSONObject r1, JSONObject r2) {
        this.u.f14657f = r1;
    }
}

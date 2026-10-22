package d.b.s.a.y;

import android.content.Context;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.k;
import com.bytedance.sdk.account.impl.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends l<d.b.s.a.q.m.b> {
    private d.b.s.a.q.m.b u;

    private b(Context r1, d.b.s.a.w.a r2, d.b.s.a.q.k.b r3) {
        super(r1, r2, r3);
    }

    public static b J(Context r2, String r3, d.b.s.a.q.k.b r4) {
        d.b.s.a.w.a.C0402a r0 = new d.b.s.a.w.a.C0402a();
        r0.l(d.b.s.a.e.i());
        r0.h(K(r3));
        return new b(r2, r0.j(), r4);
    }

    protected static Map<String, String> K(String r2) {
        HashMap r0 = new HashMap();
        r0.put("password", k.a(r2));
        r0.put("mix_mode", LocationInfoConst.ALLOW_USE_LOCATION);
        return r0;
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return M(r1, r2);
    }

    public void L(d.b.s.a.q.m.b r3) {
        com.bytedance.sdk.account.monitor.c.j("passport_check_password", null, null, r3, this.f5622j);
    }

    protected d.b.s.a.q.m.b M(boolean r2, d.b.s.a.w.b r3) {
        d.b.s.a.q.m.b r1 = this.u;
        if (r1 != null) goto L5;
        r1 = new d.b.s.a.q.m.b(r2, 10011);
    L6:
        if (r2 == true) goto L8;
        r1.f14891g = r3.f14962b;
        r1.f14893i = r3.f14963c;
    L8:
        return r1;
    L5:
        r1.f14887c = r2;
        goto L6
    }

    @Override // com.bytedance.sdk.account.impl.l
    public /* bridge */ /* synthetic */ void t(d.b.s.a.q.j.b r1) {
        L((d.b.s.a.q.m.b) r1);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void u(JSONObject r1, JSONObject r2) {
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void x(JSONObject r3, JSONObject r4) {
        this.u = new d.b.s.a.q.m.b(true, 10011);
        r4.optString("captcha");
    }
}

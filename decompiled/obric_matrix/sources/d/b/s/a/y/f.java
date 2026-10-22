package d.b.s.a.y;

import android.content.Context;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.k;
import com.bytedance.sdk.account.impl.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends l<d.b.s.a.q.m.g> {
    private f(Context r1, d.b.s.a.w.a r2, d.b.s.a.q.k.e r3) {
        super(r1, r2, r3);
    }

    protected static Map<String, String> J(String r2, String r3) {
        HashMap r0 = new HashMap();
        r0.put("current_password", k.a(r2));
        r0.put("password", k.a(r3));
        r0.put("mix_mode", LocationInfoConst.ALLOW_USE_LOCATION);
        return r0;
    }

    public static f M(Context r2, String r3, String r4, d.b.s.a.q.k.e r5) {
        d.b.s.a.w.a.C0402a r0 = new d.b.s.a.w.a.C0402a();
        r0.l(d.b.s.a.e.l());
        r0.h(J(r3, r4));
        return new f(r2, r0.j(), r5);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return L(r1, r2);
    }

    public void K(d.b.s.a.q.m.g r3) {
        com.bytedance.sdk.account.monitor.c.j("passport_update_pwd", null, null, r3, this.f5622j);
    }

    protected d.b.s.a.q.m.g L(boolean r2, d.b.s.a.w.b r3) {
        d.b.s.a.q.m.g r1 = new d.b.s.a.q.m.g(r2, 10012);
        if (r2 == true) goto L6;
        r1.f14891g = r3.f14962b;
        r1.f14893i = r3.f14963c;
    L6:
        return r1;
    }

    @Override // com.bytedance.sdk.account.impl.l
    public /* bridge */ /* synthetic */ void t(d.b.s.a.q.j.b r1) {
        K((d.b.s.a.q.m.g) r1);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void u(JSONObject r1, JSONObject r2) {
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void x(JSONObject r1, JSONObject r2) {
    }
}

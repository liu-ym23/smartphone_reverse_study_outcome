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
public class a extends l<d.b.s.a.q.j.c> {
    private boolean u;

    public a(Context r1, d.b.s.a.w.a r2, d.b.s.a.q.j.a<d.b.s.a.q.j.c> r3) {
        super(r1, r2, r3);
    }

    public static a J(Context r2, String r3, d.b.s.a.q.j.a<d.b.s.a.q.j.c> r4) {
        d.b.s.a.w.a.C0402a r0 = new d.b.s.a.w.a.C0402a();
        r0.l(d.b.s.a.e.h());
        r0.h(K(r3));
        return new a(r2, r0.j(), r4);
    }

    protected static Map<String, String> K(String r2) {
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r0.put("mobile", k.a(r2));
    L5:
        r0.put("mix_mode", LocationInfoConst.ALLOW_USE_LOCATION);
        return r0;
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return M(r1, r2);
    }

    public void L(d.b.s.a.q.j.c r3) {
        com.bytedance.sdk.account.monitor.c.j("passport_user_check_mobile_registered", null, null, r3, this.f5622j);
    }

    protected d.b.s.a.q.j.c M(boolean r3, d.b.s.a.w.b r4) {
        d.b.s.a.q.j.c r0 = new d.b.s.a.q.j.c(r3, 10034);
        if (r3 == false) goto L5;
        r0.p = this.u;
    L6:
        return r0;
    L5:
        r0.f14891g = r4.f14962b;
        r0.f14893i = r4.f14963c;
        goto L6
    }

    @Override // com.bytedance.sdk.account.impl.l
    public /* bridge */ /* synthetic */ void t(d.b.s.a.q.j.b r1) {
        L((d.b.s.a.q.j.c) r1);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void u(JSONObject r1, JSONObject r2) {
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void x(JSONObject r1, JSONObject r2) {
        this.u = r2.optBoolean("is_registered");
    }
}

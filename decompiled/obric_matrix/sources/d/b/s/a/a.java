package d.b.s.a;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.sdk.account.impl.l<d.b.s.a.q.j.d> {
    private String u;
    private d.b.s.a.h0.a v;

    private a(Context r1, d.b.s.a.w.a r2, String r3, d.b.s.a.q.j.a<d.b.s.a.q.j.d> r4) {
        super(r1, r2, r4);
        this.v = new d.b.s.a.h0.a();
        this.u = r3;
    }

    public static a J(Context r2, String r3, Map r4, d.b.s.a.q.j.a<d.b.s.a.q.j.d> r5) {
        d.b.s.a.w.a.C0402a r0 = new d.b.s.a.w.a.C0402a();
        r0.l(d.b.s.a.q.d.f());
        r0.g("logout_from", r3);
        r0.h(r4);
        return new a(r2, r0.j(), r3, r5);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return L(r1, r2);
    }

    public void K(d.b.s.a.q.j.d r3) {
        com.bytedance.sdk.account.monitor.c.j("passport_logout", null, null, r3, this.f5622j);
    }

    protected d.b.s.a.q.j.d L(boolean r2, d.b.s.a.w.b r3) {
        d.b.s.a.q.j.d r4 = new d.b.s.a.q.j.d(r2, 10001);
        if (r2 == false) goto L5;
        r4.b(this.v.f14780c);
    L6:
        r4.p = this.u;
        return r4;
    L5:
        d.b.s.a.h0.a r5 = this.v;
        r4.f14891g = r5.f14778a;
        r4.f14893i = r5.f14779b;
        goto L6
    }

    @Override // com.bytedance.sdk.account.impl.l
    public /* bridge */ /* synthetic */ void t(d.b.s.a.q.j.b r1) {
        K((d.b.s.a.q.j.d) r1);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void u(JSONObject r1, JSONObject r2) {
        com.bytedance.sdk.account.impl.c.a(this.v, r1, r2);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void x(JSONObject r1, JSONObject r2) {
        d.b.s.a.h0.a r0 = this.v;
        r0.f14780c = r1.optString("session_key");
    }
}

package d.b.s.a.y;

import android.content.Context;
import com.bytedance.sdk.account.impl.l;
import com.ss.android.i.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends l<d.b.s.a.q.m.d> {
    private d.b.s.a.q.m.d u;

    private d(Context r1, d.b.s.a.w.a r2, d.b.s.a.q.k.c r3) {
        super(r1, r2, r3);
    }

    public static d J(Context r3, String r4, d.b.s.a.q.k.c r5) {
        if (j.n() == null) goto L5;
        com.ss.android.f r0 = j.n().a(true);
    L6:
        d.b.s.a.w.a.C0402a r1 = new d.b.s.a.w.a.C0402a();
        r1.g("scene", r4);
        r1.l(d.b.s.a.q.d.c());
        r1.a(r0);
        return new d(r3, r1.f(), r5);
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return L(r1, r2);
    }

    public void K(d.b.s.a.q.m.d r3) {
        com.bytedance.sdk.account.monitor.c.j("passport_account_info", null, null, r3, this.f5622j);
    }

    protected d.b.s.a.q.m.d L(boolean r2, d.b.s.a.w.b r3) {
        d.b.s.a.q.m.d r1 = this.u;
        if (r1 != null) goto L5;
        r1 = new d.b.s.a.q.m.d(r2, 10017);
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
        K((d.b.s.a.q.m.d) r1);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void u(JSONObject r4, JSONObject r5) {
        d.b.s.a.q.m.d r0 = new d.b.s.a.q.m.d(false, 10017);
        this.u = r0;
        r0.m = r5;
        String r6 = "name";
        if (r4.has("name") == false) goto L5;
    L4:
        d.b.s.a.q.m.d r3 = this.u;
        r3.q = r4.optString(r6);
        return;
    L5:
        r6 = "error_name";
        if (r4.has("error_name") == true) goto L4;
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void x(JSONObject r4, JSONObject r5) {
        d.b.s.a.q.m.d r0 = new d.b.s.a.q.m.d(true, 10017);
        this.u = r0;
        r0.m = r4;
        r0.p = com.bytedance.sdk.account.impl.c.a.a(r4, r5);
    }
}

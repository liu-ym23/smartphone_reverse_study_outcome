package d.b.s.a.x.d.c;

import android.content.Context;
import com.bytedance.sdk.account.impl.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends l<c> {
    private String u;

    public b(Context r1, d.b.s.a.w.a r2, a r3) {
        super(r1, r2, r3);
    }

    public static b L(Context r2, String r3, a r4) {
        d.b.s.a.w.a.C0402a r0 = new d.b.s.a.w.a.C0402a();
        r0.l(d.b.s.a.x.c.i());
        r0.e("avatar", r3);
        return new b(r2, r0.k(), r4);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return K(r1, r2);
    }

    public void J(c r3) {
        com.bytedance.sdk.account.monitor.c.j("user_update_upload_avatar", null, null, r3, this.f5622j);
    }

    protected c K(boolean r3, d.b.s.a.w.b r4) {
        c r0 = new c(r3, 80002);
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
        J((c) r1);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void u(JSONObject r1, JSONObject r2) {
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void x(JSONObject r1, JSONObject r2) {
        this.u = r2.optString("web_uri");
    }
}

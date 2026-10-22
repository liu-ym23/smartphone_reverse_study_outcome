package d.b.s.a.y;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.impl.l;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends l<d.b.s.a.q.m.c> {
    private JSONObject u;
    private JSONObject v;
    private d.b.s.a.k0.a w;

    private c(Context r1, d.b.s.a.w.a r2, d.b.s.a.q.j.a<d.b.s.a.q.m.c> r3) {
        super(r1, r2, r3);
    }

    public static c J(Context r1, String r2, Map<String, String> r3, Map<String, String> r4, d.b.s.a.q.j.a<d.b.s.a.q.m.c> r5) {
        return new c(r1, K(d.b.s.a.q.d.e(r2), r3, r4, false), r5);
    }

    private static d.b.s.a.w.a K(String r1, Map<String, String> r2, Map<String, String> r3, boolean r4) {
        d.b.s.a.w.a.C0402a r0 = new d.b.s.a.w.a.C0402a();
        r0.l(r1);
        r0.b(r2);
        r0.h(r3);
        if (r4 == false) goto L7;
        return r0.f();
    L7:
        return r0.j();
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return M(r1, r2);
    }

    public void L(d.b.s.a.q.m.c r3) {
        if (TextUtils.isEmpty(r3.f14888d) == false) goto L5;
        return;
    L5:
        if (r3.f14888d.contains("/passport/token/beat/v2/") == false) goto L7;
        return;
    L7:
        if (r3.f14888d.contains("/passport/account/info/v2/") == true) goto L12;
        com.bytedance.sdk.account.monitor.c.j("passport_sdk_common_request", null, null, r3, this.f5622j);
        return;
    }

    protected d.b.s.a.q.m.c M(boolean r8, d.b.s.a.w.b r9) {
        d.b.s.a.q.m.c r0 = new d.b.s.a.q.m.c(r8, 10055);
        if (r8 == true) goto L5;
        r0.f14891g = r9.f14962b;
        r0.f14893i = r9.f14963c;
    L6:
        r0.m = this.u;
        r0.q = this.v;
        if (r8 == true) goto L9;
    L12:
        return r0;
    L9:
        if (r9.f14961a.f14948e <= 0) goto L12;
        String r2 = d.b.s.a.l0.g.d(r9.f14964d);
        Map<String, String> r3 = r9.f14961a.f14946c;
        JSONObject r7 = new JSONObject();
        r7.put("result", r0.m);     // Catch: Exception -> L13
        r7.put("data", r0.q);     // Catch: Exception -> L13
        d.b.s.a.l0.g r1 = d.b.s.a.l0.g.c();     // Catch: Exception -> L13
        String r4 = r7.toString();     // Catch: Exception -> L13
        long r10 = System.currentTimeMillis();     // Catch: Exception -> L13
        r1.g(r2, r3, r4, r9.f14961a.f14948e + r10);     // Catch: Exception -> L13
        goto L12
    L5:
        r0.p = this.w;
        goto L6
    }

    @Override // com.bytedance.sdk.account.impl.l
    public /* bridge */ /* synthetic */ void t(d.b.s.a.q.j.b r1) {
        L((d.b.s.a.q.m.c) r1);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void u(JSONObject r1, JSONObject r2) {
        this.u = r2;
        this.v = r1;
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void x(JSONObject r6, JSONObject r7) {
        this.u = r6;
        this.v = r7;
        boolean r0 = false;
        if (r7.optLong("user_id", 0) <= 0) goto L5;
        boolean r8 = true;
    L6:
        int r2 = com.bytedance.sdk.account.settings.f.a.b();
        if (r8 == true) goto L9;
    L16:
        if (r8 == true) goto L18;
    L20:
        if (r8 == false) goto L23;
        this.w = com.bytedance.sdk.account.impl.c.a.b(r6);
        return;
    L23:
        return;
    L18:
        if ((r2 & 2) == 0) goto L20;
        r8 = !TextUtils.isEmpty(this.f5620h.f14969i);
        goto L20
    L9:
        if ((r2 & 1) == 0) goto L16;
        if (TextUtils.isEmpty(this.f5619g.f14944a) == false) goto L13;
    L15:
        r8 = r0;
        goto L16
    L13:
        if (this.f5619g.f14944a.contains("/passport/") == false) goto L15;
        r0 = true;
        goto L15
    L5:
        r8 = false;
        goto L6
    }
}

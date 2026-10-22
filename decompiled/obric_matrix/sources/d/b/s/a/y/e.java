package d.b.s.a.y;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.k;
import com.bytedance.sdk.account.impl.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends l<d.b.s.a.q.m.f> {
    private String u;
    private d.b.s.a.h0.a v;
    d.b.s.a.k0.a w;
    private JSONObject x;

    private e(Context r1, d.b.s.a.w.a r2, String r3, d.b.s.a.q.k.d r4) {
        super(r1, r2, r4);
        this.u = "";
        this.u = r3;
        this.v = new d.b.s.a.h0.a();
    }

    protected static Map<String, String> J(String r2, String r3, Map<String, String> r4) {
        HashMap r0 = new HashMap();
        r0.put("password", k.a(r2));
        r0.put("ticket", k.a(r3));
        r0.put("mix_mode", LocationInfoConst.ALLOW_USE_LOCATION);
        if (r4 == null) goto L5;
        r0.putAll(r4);
    L5:
        return r0;
    }

    public static e L(Context r2, String r3, String r4, d.b.s.a.q.k.d r5) {
        d.b.s.a.w.a.C0402a r0 = new d.b.s.a.w.a.C0402a();
        r0.l(d.b.s.a.q.d.d());
        r0.h(J(r3, r4, null));
        return new e(r2, r0.j(), "mobile", r5);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return M(r1, r2);
    }

    public void K(d.b.s.a.q.m.f r4) {
        if (TextUtils.isEmpty(this.u) == true) goto L11;
        String r1 = "mobile";
        if (this.u.equals("mobile") == false) goto L8;
        d.b.s.a.q.j.a r3 = this.f5622j;
        String r0 = "passport_mobile_reset_password";
    L7:
        com.bytedance.sdk.account.monitor.c.j(r0, r1, "ticket", r4, r3);
        return;
    L8:
        String r2 = this.u;
        r1 = NotificationCompat.CATEGORY_EMAIL;
        if (r2.equals(NotificationCompat.CATEGORY_EMAIL) == false) goto L13;
        r3 = this.f5622j;
        r0 = "passport_email_reset_password";
        goto L7
    L13:
        return;
    }

    protected d.b.s.a.q.m.f M(boolean r4, d.b.s.a.w.b r5) {
        d.b.s.a.q.m.f r0 = new d.b.s.a.q.m.f(r4, PointerIconCompat.TYPE_ZOOM_IN);
        if (r4 == false) goto L5;
        r0.p = this.w;
    L8:
        r0.m = this.x;
        return r0;
    L5:
        r0.f14891g = r5.f14962b;
        r0.f14893i = r5.f14963c;
        d.b.s.a.h0.a r6 = this.v;
        if (r6.f14778a != 1075) goto L8;
        long r1 = r6.f14782e;
        String r7 = r6.f14785h;
        String r8 = r6.f14784g;
        long r2 = r6.f14783f;
        String r9 = r6.f14781d;
        goto L8
    }

    @Override // com.bytedance.sdk.account.impl.l
    public /* bridge */ /* synthetic */ void t(d.b.s.a.q.j.b r1) {
        K((d.b.s.a.q.m.f) r1);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void u(JSONObject r1, JSONObject r2) {
        this.x = r2;
        com.bytedance.sdk.account.impl.c.a(this.v, r1, r2);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void x(JSONObject r1, JSONObject r2) {
        this.w = com.bytedance.sdk.account.impl.c.a.a(r1, r2);
        this.x = r1;
    }
}

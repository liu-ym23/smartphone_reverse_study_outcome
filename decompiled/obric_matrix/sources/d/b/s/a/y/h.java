package d.b.s.a.y;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.k;
import com.bytedance.sdk.account.impl.l;
import d.b.s.a.p;
import d.b.s.a.q.m.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h extends l<i> {
    private String u;
    private String v;
    private String w;
    private JSONObject x;

    public h(Context r1, d.b.s.a.w.a r2, d.b.s.a.q.k.g r3) {
        super(r1, r2, r3);
    }

    protected static Map<String, String> J(String r3, String r4, String r5, String r6, String r7) {
        HashMap r0 = new HashMap();
        r0.put("mix_mode", LocationInfoConst.ALLOW_USE_LOCATION);
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r0.put("username", k.a(r3));
    L6:
        if (TextUtils.isEmpty(r4) == true) goto L9;
        r0.put("mobile", k.a(r4));
    L9:
        if (TextUtils.isEmpty(r5) == true) goto L12;
        r0.put(NotificationCompat.CATEGORY_EMAIL, k.a(r5));
    L12:
        if (TextUtils.isEmpty(r6) == true) goto L15;
        r0.put("password", k.a(r6));
    L15:
        if (TextUtils.isEmpty(r7) == true) goto L17;
        r0.put("verify_ticket", r7);
    L17:
        return r0;
    }

    public static h M(Context r2, String r3, String r4, String r5, String r6, String r7, Map<String, String> r8, d.b.s.a.q.k.g r9) {
        d.b.s.a.w.a.C0402a r0 = new d.b.s.a.w.a.C0402a();
        r0.l(p.h());
        r0.i(J(r3, r4, r5, r6, r7), r8);
        return new h(r2, r0.j(), r9);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return L(r1, r2);
    }

    public void K(i r3) {
        com.bytedance.sdk.account.monitor.c.j("passport_account_verify", null, null, r3, this.f5622j);
    }

    protected i L(boolean r3, d.b.s.a.w.b r4) {
        i r0 = new i(r3, 10031);
        if (r3 == false) goto L5;
        r0.d(this.u);
        r0.e(this.w);
    L6:
        r0.m = this.x;
        return r0;
    L5:
        r0.c(this.v);
        r0.f14891g = r4.f14962b;
        r0.f14893i = r4.f14963c;
        goto L6
    }

    @Override // com.bytedance.sdk.account.impl.l
    public /* bridge */ /* synthetic */ void t(d.b.s.a.q.j.b r1) {
        K((i) r1);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void u(JSONObject r2, JSONObject r3) {
        this.v = r2.optString("captcha");
        this.x = r3;
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void x(JSONObject r2, JSONObject r3) {
        this.u = r3.optString("ticket");
        this.w = r3.optString("verify_ticket");
        this.x = r2;
    }
}

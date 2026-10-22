package d.b.s.a.y;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.k;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sdk.account.impl.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends l<d.b.s.a.q.m.a> {
    private String u;
    private JSONObject v;

    private a(Context r1, d.b.s.a.w.a r2, d.b.s.a.q.k.a r3) {
        super(r1, r2, r3);
    }

    public static a J(Context r2, String r3, String r4, int r5, d.b.s.a.q.k.a r6) {
        d.b.s.a.w.a.C0402a r0 = new d.b.s.a.w.a.C0402a();
        r0.l(d.b.s.a.q.d.a());
        r0.h(K(r3, r4, r5));
        return new a(r2, r0.j(), r6);
    }

    protected static Map<String, String> K(String r2, String r3, int r4) {
        HashMap r0 = new HashMap();
        r0.put("mobile", k.a(r2));
        r0.put("code", k.a(r3));
        r0.put(WsConstants.KEY_CONNECTION_TYPE, k.a(String.valueOf(r4)));
        r0.put("mix_mode", LocationInfoConst.ALLOW_USE_LOCATION);
        r0.put("fixed_mix_mode", LocationInfoConst.ALLOW_USE_LOCATION);
        return r0;
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return M(r1, r2);
    }

    public void L(d.b.s.a.q.m.a r3) {
        if (TextUtils.isEmpty(r3.f14888d) == false) goto L5;
        return;
    L5:
        if (r3.f14888d.contains(d.b.s.a.q.d.a()) == false) goto L7;
        String r0 = "passport_mobile_check_code";
    L8:
        com.bytedance.sdk.account.monitor.c.j(r0, null, null, r3, this.f5622j);
        return;
    L7:
        r0 = "passport_email_check_code";
        goto L8
    }

    protected d.b.s.a.q.m.a M(boolean r3, d.b.s.a.w.b r4) {
        d.b.s.a.q.m.a r0 = new d.b.s.a.q.m.a(r3, PointerIconCompat.TYPE_ZOOM_OUT);
        if (r3 == false) goto L5;
        r0.p = this.u;
    L6:
        r0.m = this.v;
        return r0;
    L5:
        r0.f14891g = r4.f14962b;
        r0.f14893i = r4.f14963c;
        goto L6
    }

    @Override // com.bytedance.sdk.account.impl.l
    public /* bridge */ /* synthetic */ void t(d.b.s.a.q.j.b r1) {
        L((d.b.s.a.q.m.a) r1);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void u(JSONObject r1, JSONObject r2) {
        this.v = r2;
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void x(JSONObject r2, JSONObject r3) {
        this.u = r3.optString("ticket");
        this.v = r2;
    }
}

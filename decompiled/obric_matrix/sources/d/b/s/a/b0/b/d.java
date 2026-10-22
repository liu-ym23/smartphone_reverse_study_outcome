package d.b.s.a.b0.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.k;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sdk.account.impl.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends l<d.b.s.a.q.j.e<d.b.s.a.b0.a.f>> {
    private final d.b.s.a.b0.a.f u;

    private d(Context r1, d.b.s.a.w.a r2, d.b.s.a.b0.a.f r3, d.b.s.a.b0.b.g.c r4) {
        super(r1, r2, r4);
        this.u = r3;
    }

    protected static Map<String, String> J(d.b.s.a.b0.a.f r5) {
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r5.f14666l) == true) goto L6;
        r0.put("mobile", k.a(r5.f14666l));
    L6:
        if (TextUtils.isEmpty(r5.r) == true) goto L9;
        r0.put("old_mobile", k.a(r5.r));
    L9:
        if (TextUtils.isEmpty(r5.m) == true) goto L11;
        r0.put("captcha", r5.m);
    L11:
        r0.put(WsConstants.KEY_CONNECTION_TYPE, k.a(String.valueOf(r5.p)));
        r0.put("unbind_exist", k.a(String.valueOf(r5.q)));
        r0.put("mix_mode", LocationInfoConst.ALLOW_USE_LOCATION);
        int r1 = r5.z;
        if (r1 != 1) goto L14;
        r0.put("check_register", LocationInfoConst.ALLOW_USE_LOCATION);
    L17:
        if (TextUtils.isEmpty(r5.t) == true) goto L19;
        r0.put("ticket", r5.t);
    L19:
        r0.put("auto_read", String.valueOf(r5.u));
        if (TextUtils.isEmpty(r5.v) == true) goto L23;
        r0.put("shark_ticket", r5.v);
    L23:
        if (TextUtils.isEmpty(r5.x) == true) goto L26;
        r0.put("auth_token", r5.x);
    L26:
        if (TextUtils.isEmpty(r5.w) == true) goto L28;
        r0.put("unusable_mobile_ticket", r5.w);
    L28:
        return r0;
    L14:
        if (r1 != 0) goto L17;
        r0.put("check_register", BDLocationException.ERROR_TIMEOUT);
        goto L17
    }

    public static d L(Context r12, String r13, String r14, int r15, int r16, String r17, int r18, int r19, String r20, String r21, Map r22, d.b.s.a.b0.b.g.c r23) {
        d.b.s.a.b0.a.f r11 = new d.b.s.a.b0.a.f(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
        d.b.s.a.w.a.C0402a r0 = M(r11);
        r0.l(d.b.s.a.e.o());
        return new d(r12, r0.j(), r11, r23);
    }

    private static d.b.s.a.w.a.C0402a M(d.b.s.a.b0.a.f r2) {
        d.b.s.a.w.a.C0402a r0 = new d.b.s.a.w.a.C0402a();
        r0.i(J(r2), r2.y);
        return r0;
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return N(r1, r2);
    }

    public void K(d.b.s.a.q.j.e<d.b.s.a.b0.a.f> r4) {
        com.bytedance.sdk.account.monitor.c.j("passport_mobile_sendcode", "mobile", this.f5619g.b(WsConstants.KEY_CONNECTION_TYPE), r4, this.f5622j);
    }

    protected d.b.s.a.q.j.e<d.b.s.a.b0.a.f> N(boolean r3, d.b.s.a.w.b r4) {
        if (r3 == false) goto L5;
        d.b.s.a.b0.a.f r5 = this.u;
        r5.f14652a = 0;
        r5.f14654c = "";
        r5.f14653b = 0;
    L5:
        return new d.b.s.a.q.j.e(r3, 1002, this.u);
    }

    @Override // com.bytedance.sdk.account.impl.l
    public /* bridge */ /* synthetic */ void t(d.b.s.a.q.j.b r1) {
        K((d.b.s.a.q.j.e) r1);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void u(JSONObject r2, JSONObject r3) {
        com.bytedance.sdk.account.impl.c.b(this.u, r2);
        this.u.f14657f = r3;
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void x(JSONObject r4, JSONObject r5) {
        d.b.s.a.b0.a.f r0 = this.u;
        r0.s = r5.optInt("retry_time", 30);
        this.u.f14657f = r4;
    }
}

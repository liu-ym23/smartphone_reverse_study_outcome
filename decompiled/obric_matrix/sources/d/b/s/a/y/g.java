package d.b.s.a.y;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.sdk.account.impl.l;
import com.ss.android.i.j;
import com.ss.android.token.n;
import com.ss.android.token.o;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends l<d.b.s.a.q.m.h> {
    private static String v;
    private static String w;
    private d.b.s.a.q.m.h u;

    private g(Context r1, d.b.s.a.w.a r2, d.b.s.a.q.k.f r3) {
        super(r1, r2, r3);
    }

    private String J(d.b.s.a.q.m.h r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        List<com.ss.android.f> r5 = r4.f14896l;
        if (r5 != null) goto L8;
    L18:
        d.b.s.a.a0.a.d("UpdateTokenJob", "response sec uid is null");
        return null;
    L8:
        if (r5.isEmpty() == true) goto L18;
        Iterator<com.ss.android.f> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L18;
        com.ss.android.f r0 = r6.next();
        if (r0 == null) goto L11;
        if (r0.a().equalsIgnoreCase("d-ticket-sec-uid") == false) goto L11;
        return r0.b();
    }

    private void K(String r9, String r10, String r11, boolean r12) {
        if (r12 == true) goto L8;
        String r13 = "handle user mixed failed, request failed";
    L5:
        d.b.s.a.a0.a.d("UpdateTokenJob", r13);
        return;
    L8:
        if (com.bytedance.sdk.account.settings.f.a.s() == true) goto L11;
        r13 = "handle user mixed failed, retry monitor disable";
        goto L5
    L11:
        if (com.bytedance.sdk.account.settings.f.a.C("/passport/token/beat/v2/") == true) goto L13;
        r13 = "handle user mixed failed, validate monitor disable";
        goto L5
    L13:
        String r4 = v;
        String r14 = w;
        if (TextUtils.isEmpty(r4) == false) goto L19;
        if (TextUtils.isEmpty(r14) == false) goto L19;
        r13 = "handle user mixed failed, all info is null";
    L19:
        if (TextUtils.isEmpty(r10) == true) goto L24;
        if (r10.equals(r4) == false) goto L24;
        r13 = "handle user mixed failed, sec uid is same";
    L24:
        if ("session_expired".equalsIgnoreCase(r11) == false) goto L26;
    L52:
        r13 = "handle user mixed failed, ignore from session_expired or session_drop";
        goto L5
    L26:
        if ("session_drop".equalsIgnoreCase(r11) == true) goto L52;
        boolean r0 = TextUtils.isEmpty(r4);
        boolean r7 = TextUtils.isEmpty(r10);
        if (r0 == true) goto L34;
        if (r7 == false) goto L34;
        if (TextUtils.isEmpty(com.ss.android.i.b.M().b()) == false) goto L34;
        r13 = "handle user mixed failed, ignore from logout";
    L34:
        boolean r5 = com.bytedance.sdk.account.impl.g.d(j.k().e()).m();
        StringBuilder r1 = new StringBuilder();
        r1.append("account user uid mixed, logid=");
        r1.append(r9);
        r1.append(",sec_uid_is_null: ");
        boolean r2 = TextUtils.isEmpty(r4);
        String r3 = LocationInfoConst.ALLOW_USE_LOCATION;
        if (r2 == false) goto L37;
        String r6 = LocationInfoConst.ALLOW_USE_LOCATION;
    L38:
        r1.append(r6);
        r1.append(",response_sec_uid_is_null: ");
        if (TextUtils.isEmpty(r10) == false) goto L41;
        String r8 = LocationInfoConst.ALLOW_USE_LOCATION;
    L42:
        r1.append(r8);
        r1.append(",token_is_null: ");
        if (TextUtils.isEmpty(r14) == true) goto L46;
        r3 = BDLocationException.ERROR_TIMEOUT;
    L46:
        r1.append(r3);
        r1.append(",sec_uid: ");
        r1.append(r4);
        r1.append(",response_sec_uid: ");
        r1.append(r10);
        r1.append(",error_name: ");
        r1.append(r11);
        d.b.s.a.a0.a.d("UpdateTokenJob", r1.toString());
        o.z("/passport/token/beat/v2/", r9, TextUtils.isEmpty(r14), r10, r4, r5, r11);
        if (r7 == false) goto L49;
        return;
    L49:
        if (com.bytedance.sdk.account.settings.f.a.v() == false) goto L54;
        n.w();
        return;
    L54:
        return;
    L41:
        r8 = BDLocationException.ERROR_TIMEOUT;
        goto L42
    L37:
        r6 = BDLocationException.ERROR_TIMEOUT;
        goto L38
    }

    public static void N() {
        v = com.bytedance.sdk.account.impl.g.d(j.k().e()).k();
        w = n.j();
    }

    public static g O(Context r2, String r3, d.b.s.a.q.k.f r4) {
        N();
        if (j.n() == null) goto L5;
        com.ss.android.f r0 = j.n().a(true);
    L6:
        d.b.s.a.w.a.C0402a r1 = new d.b.s.a.w.a.C0402a();
        r1.l(r3);
        r1.a(r0);
        return new g(r2, r1.f(), r4);
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return M(r1, r2);
    }

    public void L(d.b.s.a.q.m.h r5) {
        if (com.bytedance.sdk.account.settings.f.a.w() == false) goto L6;
        if (r5 == null) goto L6;
        K(r5.f14885a, J(r5), r5.p, r5.f14887c);
    L6:
        com.bytedance.sdk.account.monitor.c.j("passport_token_beat_v2", null, null, r5, this.f5622j);
    }

    protected d.b.s.a.q.m.h M(boolean r2, d.b.s.a.w.b r3) {
        d.b.s.a.q.m.h r1 = this.u;
        if (r1 != null) goto L5;
        r1 = new d.b.s.a.q.m.h(r2, 10022);
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
        L((d.b.s.a.q.m.h) r1);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void u(JSONObject r4, JSONObject r5) {
        d.b.s.a.q.m.h r0 = new d.b.s.a.q.m.h(false, 10022);
        this.u = r0;
        r0.m = r5;
        r0.p = r4.optString("error_name");
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void x(JSONObject r3, JSONObject r4) {
        d.b.s.a.q.m.h r5 = new d.b.s.a.q.m.h(true, 10022);
        this.u = r5;
        r5.m = r3;
    }
}

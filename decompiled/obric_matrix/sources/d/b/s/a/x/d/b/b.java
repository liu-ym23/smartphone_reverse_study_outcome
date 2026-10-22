package d.b.s.a.x.d.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.impl.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends l<c> {
    private d.b.s.a.x.d.b.d.b u;
    private d.b.s.a.x.d.b.d.a v;
    private d.b.s.a.x.d.b.d.a w;
    private JSONObject x;
    private JSONObject y;

    public b(Context r1, d.b.s.a.w.a r2, a r3) {
        super(r1, r2, r3);
    }

    private static String J(String[] r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.length <= 0) goto L22;
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L16;
        String r3 = r5[r2];
        if (TextUtils.isEmpty(r3) == true) goto L14;
        if (r0.length() <= 0) goto L13;
        r0.append(",");
    L13:
        r0.append(r3);
    L14:
        r2 = r2 + 1;
        goto L6
    L16:
        return r0.toString();
    L22:
        return null;
    }

    private d.b.s.a.x.d.b.d.a K(JSONObject r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        d.b.s.a.x.d.b.d.a r0 = new d.b.s.a.x.d.b.d.a();
        boolean r1 = r5.optBoolean("is_auditing");
        d.b.s.a.x.d.b.d.b r4 = L(r5.optJSONObject("audit_info"));
        Long r6 = Long.valueOf(r5.optLong("last_update_time"));
        r0.b(r1);
        r0.c(r6);
        if (r4 == null) goto L8;
        r0.a(r4);
    L8:
        return r0;
    }

    private d.b.s.a.x.d.b.d.b L(JSONObject r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        d.b.s.a.x.d.b.d.b r6 = new d.b.s.a.x.d.b.d.b();
        String r0 = r7.optString("name");
        String r1 = r7.optString("avatar_url");
        String r2 = r7.optString("description");
        String r3 = r7.optString("area");
        Integer r4 = Integer.valueOf(r7.optInt("gender"));
        JSONObject r8 = r7.optJSONObject("expend_attrs");
        if (TextUtils.isEmpty(r0) == true) goto L9;
        r6.f(r0);
    L9:
        if (TextUtils.isEmpty(r1) == true) goto L12;
        r6.b(r1);
    L12:
        if (TextUtils.isEmpty(r2) == true) goto L15;
        r6.c(r2);
    L15:
        if (TextUtils.isEmpty(r3) == true) goto L17;
        r6.a(r3);
    L17:
        r6.e(r4);
        if (r8 == null) goto L20;
        r6.d(r8.toString());
    L20:
        return r6;
    }

    private static Map<String, String> M(Map<String, String> r1, JSONObject r2, String[] r3) {
        if (r1 != null) goto L4;
        r1 = new HashMap();
    L4:
        if (r2 == null) goto L6;
        r1.put("expend_attrs", r2.toString());
    L6:
        String r4 = J(r3);
        if (TextUtils.isEmpty(r4) == true) goto L9;
        r1.put("delete_attrs", r4);
    L9:
        return r1;
    }

    public static b P(Context r2, Map<String, String> r3, JSONObject r4, String[] r5, boolean r6, a r7) {
        d.b.s.a.w.a.C0402a r0 = new d.b.s.a.w.a.C0402a();
        r0.l(d.b.s.a.x.c.h());
        r0.h(M(r3, r4, r5));
        r0.m(r6);
        return new b(r2, r0.j(), r7);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected /* bridge */ /* synthetic */ d.b.s.a.q.j.b E(boolean r1, d.b.s.a.w.b r2) {
        return O(r1, r2);
    }

    public void N(c r3) {
        com.bytedance.sdk.account.monitor.c.j("user_update_user_info", null, null, r3, this.f5622j);
    }

    protected c O(boolean r3, d.b.s.a.w.b r4) {
        c r0 = new c(r3, 80003);
        if (r3 == true) goto L6;
        r0.f14891g = r4.f14962b;
        r0.f14893i = r4.f14963c;
    L6:
        r0.m = this.y;
        return r0;
    }

    @Override // com.bytedance.sdk.account.impl.l
    public /* bridge */ /* synthetic */ void t(d.b.s.a.q.j.b r1) {
        N((c) r1);
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void u(JSONObject r1, JSONObject r2) {
        this.x = r1;
        this.y = r2;
    }

    @Override // com.bytedance.sdk.account.impl.l
    protected void x(JSONObject r4, JSONObject r5) {
        JSONObject r0 = r5.optJSONObject("current_info");
        JSONObject r1 = r5.optJSONObject("pgc_audit_info");
        JSONObject r2 = r5.optJSONObject("verified_audit_info");
        if (r0 == null) goto L5;
        this.u = L(r0);
    L5:
        if (r1 == null) goto L7;
        this.v = K(r1);
    L7:
        if (r2 == null) goto L9;
        this.w = K(r2);
    L9:
        this.x = r5;
        this.y = r4;
    }
}

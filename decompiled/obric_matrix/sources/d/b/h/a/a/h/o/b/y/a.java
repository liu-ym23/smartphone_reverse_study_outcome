package d.b.h.a.a.h.o.b.y;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends d.b.h.a.a.e.c.b<d> {
    public a() {
    }

    private Map<String, String> k(JSONObject r5) {
        HashMap r4 = new HashMap();
        if (r5 != null) goto L5;
    L15:
        return r4;
    L5:
        if (r5.length() == 0) goto L15;
        Iterator<String> r0 = r5.keys();
    L9:
        if (r0.hasNext() == false) goto L15;
        String r1 = r0.next();
        String r2 = r5.optString(r1);
        if (TextUtils.isEmpty(r1) == true) goto L9;
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r4.put(r1, r2);
        goto L9
    }

    @Override // d.b.h.a.a.e.c.b
    public String a() {
        return "ttnet_req_meta_dp";
    }

    @Override // d.b.h.a.a.e.c.b
    public /* bridge */ /* synthetic */ d.b.h.a.a.e.c.c e(Object r1) {
        return j(r1);
    }

    public d j(Object r3) {
        if ((r3 instanceof JSONObject) == false) goto L5;
        JSONObject r4 = (JSONObject) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        d r0 = new d();
        r0.f13636b = k(r4.optJSONObject("query_add"));
        r0.f13637c = f(r4.optJSONArray("query_rm"));
        r0.f13638d = k(r4.optJSONObject("header_add"));
        r0.f13639e = f(r4.optJSONArray("header_rm"));
        return r0;
    L5:
        r4 = null;
        goto L6
    }
}

package d.b.h.a.a.h.o.b.z;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f13677b;

    static {
    }

    public h(JSONObject r5) {
        super(f.b.f13676l);
        this.f13677b = new HashMap();
        if (r5 != null) goto L5;
        return;
    L5:
        Iterator<String> r0 = r5.keys();
    L7:
        if (r0.hasNext() == false) goto L13;
        String r1 = r0.next();
        String r2 = r5.optString(r1);
        if (TextUtils.isEmpty(r1) == true) goto L7;
        if (TextUtils.isEmpty(r2) == true) goto L7;
        this.f13677b.put(r1, r2);
        goto L7
    }

    @Override // d.b.h.a.a.h.o.b.z.f
    public void a(m r5) {
        if (r5.b() == null) goto L8;
        Iterator<Map.Entry<String, String>> r4 = this.f13677b.entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        Map.Entry<String, String> r0 = r4.next();
        r5.b().add(new d.b.r.h0.b(r0.getKey(), r0.getValue()));
        goto L6
    L10:
        return;
    }

    @Override // d.b.h.a.a.h.o.b.z.f
    public String d(Uri r1) {
        return r1.toString();
    }

    @Override // d.b.h.a.a.h.o.b.z.f
    public boolean e() {
        return false;
    }
}

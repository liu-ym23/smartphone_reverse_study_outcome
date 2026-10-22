package d.b.h.a.a.h.o.b.z;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f13678b;

    static {
    }

    public i(JSONObject r5) {
        super(f.b.f13671g);
        this.f13678b = new HashMap();
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
        this.f13678b.put(r1, r2);
        goto L7
    }

    @Override // d.b.h.a.a.h.o.b.z.f
    public void a(m r1) {
    }

    @Override // d.b.h.a.a.h.o.b.z.f
    public String d(Uri r3) {
        String r0 = r3.getHost();
        String r4 = r3.toString();
        String r2 = this.f13678b.get(r0);
        if (TextUtils.isEmpty(r2) == true) goto L6;
        Logger.debug();
        return r4.replaceFirst(r0, r2);
    L6:
        return r4;
    }

    @Override // d.b.h.a.a.h.o.b.z.f
    public boolean e() {
        return false;
    }
}

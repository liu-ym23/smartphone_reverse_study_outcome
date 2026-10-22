package com.bytedance.bdinstall.z0;

import com.bytedance.bdinstall.i0;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i0 f2919e;

    h(i0 r3) {
        super(false, true);
        this.f2919e = r3;
    }

    @Override // com.bytedance.bdinstall.z0.d
    protected boolean a(JSONObject r3) {
        Map<String, Object> r2 = this.f2919e.s();
        if (r2 != null) goto L17;
        return true;
    L17:
        if (r2.isEmpty() == true) goto L25;
        Iterator<Map.Entry<String, Object>> r4 = r2.entrySet().iterator();     // Catch: Exception -> L16
    L8:
        if (r4.hasNext() == false) goto L27;
        Map.Entry<String, Object> r0 = r4.next();     // Catch: Exception -> L16
        if (r0 == null) goto L8;
        r3.put(r0.getKey(), r0.getValue());     // Catch: Exception -> L16
    L27:
        return true;
    L25:
        return true;
    L26:
        return true;
    }
}

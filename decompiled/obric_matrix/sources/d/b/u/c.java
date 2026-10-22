package d.b.u;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c implements h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h f15010f;

    public c(h r1) {
        this.f15010f = r1;
    }

    private void F(Map<String, String> r6) {
        Collection<n> r5 = t.b();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L41;
        Iterator<n> r7 = r5.iterator();
    L9:
        if (r7.hasNext() == false) goto L42;
        n r0 = r7.next();
        if (r0 == null) goto L9;
        h r1 = r0.f();
        if (r1 == null) goto L9;
        Map<String, String> r2 = r1.getCommonParams();
        if (r2 == null) goto L9;
        Iterator<Map.Entry<String, String>> r3 = r2.entrySet().iterator();
    L21:
        if (r3.hasNext() == false) goto L9;
        Map.Entry<String, String> r4 = r3.next();
        if (r6.containsKey(r4.getKey()) == true) goto L24;
        r6.put(r4.getKey(), r4.getValue());
        goto L21
    L24:
        d.b.u.x.b.b("duplicate key between the common param of " + r0.e() + " and host/other biz. ignore it");
        goto L21
    L42:
        return;
    }

    @Override // d.b.u.h
    public Map<String, String> getCommonParams() {
        h r0 = this.f15010f;
        if (r0 == null) goto L5;
        Map<String, String> r1 = r0.getCommonParams();
    L6:
        if (r1 != null) goto L8;
        r1 = new HashMap();
    L8:
        r1.put("bytesync_sdk_version", String.valueOf(10100));
        F(r1);
        return r1;
    L5:
        r1 = null;
        goto L6
    }
}

package d.b.s.a.l0;

import com.bytedance.android.sdk.bdticketguard.t0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class o {
    public static List<t0> a(List<com.ss.android.f> r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.isEmpty() == true) goto L13;
        ArrayList r0 = new ArrayList();
        Iterator<com.ss.android.f> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        com.ss.android.f r1 = r5.next();
        r0.add(new t0(r1.a(), r1.b()));
        goto L7
    L9:
        return r0;
    L13:
        return null;
    }

    public static List<com.ss.android.f> b(List<t0> r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.isEmpty() == true) goto L13;
        ArrayList r0 = new ArrayList();
        Iterator<t0> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        t0 r1 = r5.next();
        r0.add(new com.ss.android.f(r1.a(), r1.b()));
        goto L7
    L9:
        return r0;
    L13:
        return null;
    }
}

package d.b.s.a.l0;

import kotlin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static final JSONObject a(u<String, ? extends Object>... r5) {
        kotlin.n0.d.o.g(r5, "pairs");
        JSONObject r0 = new JSONObject();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        u<String, ? extends Object> r3 = r5[r2];
        r0.put(r3.c(), r3.d());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }
}

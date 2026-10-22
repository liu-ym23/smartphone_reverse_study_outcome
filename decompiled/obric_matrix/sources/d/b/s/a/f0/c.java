package d.b.s.a.f0;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f14746a = "max_cache";

    static {
    }

    public static int a() {
        JSONObject r0 = ((d.b.s.a.d0.r.a) d.b.s.a.d0.s.c.a(d.b.s.a.d0.r.a.class)).a();
        int r1 = a.f14729a;
        if (r0 == null) goto L5;
        r1 = r0.optInt(f14746a, r1);
    L5:
        if (r1 >= 0) goto L9;
        return 0;
    L9:
        return r1;
    }
}

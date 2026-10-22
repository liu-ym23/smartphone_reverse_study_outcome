package d.b.h.a.a.h.o.b;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import p000j.d0;
import p000j.f0;
import p000j.x;

/* JADX INFO: loaded from: classes.dex */
public class p implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f13520a;

    public interface a {
        boolean a(String r1, String r2, Map<String, List<String>> r3, String r4);
    }

    static {
    }

    public p() {
    }

    @Override // p000j.x
    public f0 a(x.a r6) {
        d0 r5 = r6.b();
        if (f13520a == null) goto L12;
        if ("/get_domains/v5/".equals(r5.k().h()) == false) goto L12;
        if (f13520a.a(r5.f(), r5.k().toString(), r5.d().l(), "") == true) goto L12;
        throw new IOException("TNC requsest dropped by sandbox");
    L12:
        return r6.d(r5);
    }
}

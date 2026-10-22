package d.b.h.a.a.h.o.b;

import com.bytedance.bdlocation.client.LocationInfoConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p000j.d0;
import p000j.f0;
import p000j.x;

/* JADX INFO: loaded from: classes.dex */
public class m implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f13505a;

    public interface a {
        void a(String r1, String r2, Map<String, List<String>> r3, String r4);
    }

    static {
    }

    public m() {
    }

    @Override // p000j.x
    public f0 a(x.a r6) {
        d0 r5 = r6.b();
        if (r5 != null) goto L5;
    L9:
        boolean r0 = false;
    L10:
        ArrayList r1 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r2 = r5.d().l().entrySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L20;
        String r3 = r2.next().getKey();
        if (r3.equals("x-tt-bypass-dp") == false) goto L17;
        if (r0 == false) goto L17;
    L18:
        r1.add(r3);
    L17:
        if (r3.startsWith("x-metasec") == false) goto L12;
    L20:
        if (r1.size() <= 0) goto L27;
        d0.a r7 = r5.g();
        Iterator r4 = r1.iterator();
    L23:
        if (r4.hasNext() == false) goto L25;
        r7.h((String) r4.next());
        goto L23
    L25:
        r5 = r7.b();
    L27:
        if (f13505a == null) goto L30;
        f13505a.a(r5.f(), r5.k().toString(), r5.d().l(), "");
    L30:
        return r6.d(r5);
    L5:
        if (r5.d() == null) goto L9;
        if (r5.d().d("x-metasec-bypass-ttnet-features") == null) goto L9;
        r0 = LocationInfoConst.ALLOW_USE_LOCATION.equals(r5.d().d("x-metasec-bypass-ttnet-features"));
        goto L10
    }
}

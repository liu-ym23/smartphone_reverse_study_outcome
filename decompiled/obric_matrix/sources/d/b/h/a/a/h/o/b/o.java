package d.b.h.a.a.h.o.b;

import com.bytedance.bdlocation.client.LocationInfoConst;
import java.util.Iterator;
import java.util.Map;
import p000j.d0;
import p000j.f0;
import p000j.x;

/* JADX INFO: loaded from: classes.dex */
public class o implements x {
    public o() {
    }

    @Override // p000j.x
    public f0 a(x.a r7) {
        d0 r6 = r7.b();
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r6.d().d("x-metasec-bypass-mssdk")) == false) goto L7;
        d0.a r8 = r6.g();
        r8.h("x-metasec-bypass-mssdk");
        d0 r9 = r8.b();
    L6:
        return r7.d(r9);
    L7:
        Map<String, String> r0 = d.b.h.a.a.h.g.b0(r6.k().toString(), r6.d().l());
        Map<String, String> r1 = null;
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r6.d().d("x-tt-oec-opaque-enable")) == false) goto L10;
        r1 = d.b.h.a.a.h.g.Z(r6.k().toString(), r6.d().l());
    L10:
        if (r0 != null) goto L14;
        if (r1 != null) goto L14;
        return r7.d(r6);
    L14:
        d0.a r2 = new d0.a();
        r2.l(r6.k());
        r2.f(r6.f(), r6.a());
        r2.j(r6.i());
        j.v.a r10 = r6.d().h();
        if (r0 == null) goto L20;
        Iterator<Map.Entry<String, String>> r3 = r0.entrySet().iterator();
    L18:
        if (r3.hasNext() == false) goto L20;
        Map.Entry<String, String> r4 = r3.next();
        r10.a(r4.getKey(), r4.getValue());
    L20:
        if (r1 == null) goto L25;
        Iterator<Map.Entry<String, String>> r5 = r1.entrySet().iterator();
    L23:
        if (r5.hasNext() == false) goto L25;
        Map.Entry<String, String> r11 = r5.next();
        r10.a(r11.getKey(), r11.getValue());
    L25:
        r10.e("x-tt-oec-opaque-enable");
        r2.e(r10.d());
        r9 = r2.b();
        goto L6
    }
}

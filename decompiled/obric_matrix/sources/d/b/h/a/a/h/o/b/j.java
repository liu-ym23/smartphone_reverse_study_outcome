package d.b.h.a.a.h.o.b;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000j.d0;
import p000j.f0;
import p000j.x;

/* JADX INFO: loaded from: classes.dex */
public class j implements x {
    public j() {
    }

    @Override // p000j.x
    public f0 a(x.a r13) {
        d0 r0 = r13.b();
        if (r0 != null) goto L5;
    L87:
        URI r1 = r0.k().E();     // Catch: Exception -> L12
    L13:
        d0.a r2 = r0.g();
        CookieHandler r3 = CookieHandler.getDefault();
        p000j.v r4 = r0.d();
        Map<String, List<String>> r5 = null;
        if (r1 == null) goto L16;
        String r6 = d.b.h.a.a.h.s.c.l(r1.toString());
    L85:
        HashMap r7 = new HashMap();     // Catch: Throwable -> L82
        if (r4 == null) goto L28;
        Set<String> r8 = r4.g();     // Catch: Throwable -> L82
        if (r8 == null) goto L28;
        if (r8.isEmpty() == true) goto L28;
        Iterator<String> r9 = r8.iterator();     // Catch: Throwable -> L82
    L25:
        if (r9.hasNext() == false) goto L28;
        String r10 = r9.next();     // Catch: Throwable -> L82
        r7.put(r10, r4.n(r10));     // Catch: Throwable -> L82
    L28:
        if (r0 != null) goto L30;
    L34:
        boolean r11 = false;
    L35:
        if (r3 == null) goto L43;
        if (r11 == true) goto L43;
        if (r6 == null) goto L39;
        Map<String, List<String>> r12 = r3.get(new URI(r6), r7);     // Catch: IOException -> L41 Throwable -> L82
    L40:
        r5 = r12;
        goto L89
    L39:
        r12 = r3.get(r1, r7);     // Catch: IOException -> L41 Throwable -> L82
    L41:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L82
    L43:
        if (r5 == null) goto L89;
        if (r5.size() <= 0) goto L89;
        Iterator<Map.Entry<String, List<String>>> r14 = r5.entrySet().iterator();     // Catch: Throwable -> L82
    L47:
        if (r14.hasNext() == false) goto L89;
        Map.Entry<String, List<String>> r15 = r14.next();     // Catch: Throwable -> L82
        String r16 = r15.getKey();     // Catch: Throwable -> L82
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L82
        if (CronetHttpURLConnection.SS_COOKIE.equalsIgnoreCase(r16) == true) goto L56;
        if ("Cookie".equalsIgnoreCase(r16) == true) goto L56;
        if ("Cookie2".equalsIgnoreCase(r16) == false) goto L47;
    L56:
        if (r15.getValue().isEmpty() == true) goto L47;
        Iterator<String> r18 = r15.getValue().iterator();     // Catch: Throwable -> L82
        int r19 = 0;
    L59:
        if (r18.hasNext() == false) goto L64;
        String r110 = r18.next();     // Catch: Throwable -> L82
        if (r19 <= 0) goto L63;
        r17.append("; ");     // Catch: Throwable -> L82
    L63:
        r17.append(r110);     // Catch: Throwable -> L82
        r19 = r19 + 1;     // Catch: Throwable -> L82
        goto L59
    L64:
        r2.a(r16, r17.toString());     // Catch: Throwable -> L82
        goto L47
    L30:
        if (r0.d() == null) goto L34;
        r11 = LocationInfoConst.ALLOW_USE_LOCATION.equals(r0.c("x-metasec-bypass-okhttp-cookie"));     // Catch: Throwable -> L82
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r0.c("x-metasec-ok-bypass-downgrade-cookie")) == false) goto L35;
        r11 = true;
    L89:
        r0 = r2.b();     // Catch: Throwable -> L83
    L67:
        f0 r111 = r13.d(r0);
        HashMap r112 = new HashMap();
        p000j.v r20 = r111.F();
        if (r20 == null) goto L77;
        Set<String> r21 = r20.g();
        if (r21 == null) goto L77;
        if (r21.isEmpty() == true) goto L77;
        Iterator<String> r22 = r21.iterator();
    L75:
        if (r22.hasNext() == false) goto L77;
        String r23 = r22.next();
        r112.put(r23, r20.n(r23));
    L77:
        if (r3 != null) goto L94;
    L81:
        return r111;
    L94:
        if (r6 == null) goto L80;
        r3.put(new URI(r6), r112);     // Catch: Throwable -> L84
    L93:
        goto L81
    L80:
        r3.put(r1, r112);     // Catch: Throwable -> L84
        goto L93
    L16:
        r6 = null;
    L12:
        r1 = d.b.h.a.a.h.s.j.a(r0.k().toString());
        goto L13
    L5:
        if (r0.d() == null) goto L87;
        if (BDLocationException.ERROR_TIMEOUT.equals(r0.c("x-ttnet-bypass-cookie")) == false) goto L87;
        d0.a r113 = r0.g();
        r113.h("x-ttnet-bypass-cookie");
        return r13.d(r113.b());
    }
}

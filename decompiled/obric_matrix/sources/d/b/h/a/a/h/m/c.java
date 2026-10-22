package d.b.h.a.a.h.m;

import android.text.TextUtils;
import java.net.CookieManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends CookieManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f13427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f13428b;

    public c(e r1, d r2) {
        if (r1 != null) goto L5;
        r1 = new f();
    L5:
        this.f13427a = r1;
        if (r2 != null) goto L8;
        r2 = d.f13430b;
    L8:
        this.f13428b = r2;
    }

    private static Map<String, List<String>> a(List<g> r5) {
        if (r5.isEmpty() == true) goto L5;
        StringBuilder r0 = new StringBuilder();
        Iterator<g> r1 = r5.iterator();
        int r2 = 1;
        int r3 = 1;
    L8:
        if (r1.hasNext() == false) goto L10;
        r3 = Math.min(r3, r1.next().F());
        goto L8
    L10:
        if (r3 != 1) goto L12;
        r0.append("$Version=\"1\"; ");
    L12:
        r0.append(r5.get(0).toString());
    L14:
        if (r2 >= r5.size()) goto L17;
        r0.append("; ");
        r0.append(r5.get(r2).toString());
        r2 = r2 + 1;
        goto L14
    L17:
        return Collections.singletonMap("Cookie", Collections.singletonList(r0.toString()));
    L5:
        return Collections.emptyMap();
    }

    private static List<g> b(Map<String, List<String>> r4) {
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L20;
        Map.Entry<String, List<String>> r1 = r5.next();
        String r2 = r1.getKey();
        if (r2 == null) goto L4;
        if (r2.equalsIgnoreCase("Set-cookie") == true) goto L11;
        if (r2.equalsIgnoreCase("Set-cookie2") == false) goto L4;
    L11:
        Iterator<String> r3 = r1.getValue().iterator();
    L13:
        if (r3.hasNext() == false) goto L4;
        Iterator<g> r6 = g.L(r3.next()).iterator();     // Catch: IllegalArgumentException -> L21
    L17:
        if (r6.hasNext() == false) goto L13;
        r0.add(r6.next());     // Catch: IllegalArgumentException -> L21
    L20:
        return r0;
    }

    public static String c(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return "/";
    L7:
        return r2.substring(0, r2.lastIndexOf(47) + 1);
    }

    private void e(URI r4, List<g> r5) {
        if (com.bytedance.common.utility.e.a(r5) == false) goto L5;
        return;
    L5:
        Iterator<g> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L25;
        g r0 = r6.next();
        if (TextUtils.isEmpty(r0.y()) == false) goto L12;
        r0.Q(r4.getHost());
    L12:
        if (TextUtils.isEmpty(r0.C()) == false) goto L15;
        r0.S(c(r4.getPath()));
    L15:
        if ("".equals(r0.D()) == true) goto L16;
        if (r0.D() == null) goto L23;
        if (g.O(r0, r4) == false) goto L7;
    L23:
        if (this.f13428b.a(r4, r0) == false) goto L7;
        this.f13427a.a(r4, r0);
        goto L7
    L16:
        r0.T(Integer.toString(l.d(r4.getScheme(), r4.getPort())));
        goto L23
    }

    public void d(URI r4, List<String> r5) {
        if (r4 == null) goto L15;
        if (r5 == null) goto L15;
        ArrayList r0 = new ArrayList();
        Iterator<String> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L12;
        String r1 = r6.next();
        if (com.bytedance.common.utility.k.c(r1) == true) goto L6;
        r0.addAll(g.L(r1));     // Catch: IllegalArgumentException -> L16
        goto L6
    L12:
        e(r4, r0);
        return;
    L15:
        throw new IllegalArgumentException();
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public Map<String, List<String>> get(URI r3, Map<String, List<String>> r4) {
        if (r3 == null) goto L17;
        if (r4 == null) goto L17;
        ArrayList r5 = new ArrayList();
        Iterator<g> r2 = this.f13427a.b(r3).iterator();
    L6:
        if (r2.hasNext() == false) goto L15;
        g r0 = r2.next();
        if (g.N(r0, r3) == false) goto L6;
        if (g.P(r0, r3) == false) goto L6;
        if (g.O(r0, r3) == false) goto L6;
        r5.add(r0);
        goto L6
    L15:
        return a(r5);
    L17:
        throw new IllegalArgumentException();
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public void put(URI r1, Map<String, List<String>> r2) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
        e(r1, b(r2));
        return;
    L7:
        throw new IllegalArgumentException();
    }
}

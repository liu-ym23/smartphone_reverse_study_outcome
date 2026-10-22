package com.bytedance.ttnet.q;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.k;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import d.b.h.a.a.h.g;
import d.b.h.a.a.h.s.l;
import d.b.r.d0;
import d.b.r.h0.c;
import d.b.r.h0.d;
import d.b.r.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d.b.h.a.a.h.q.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile boolean f6568f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f6569g = false;

    static {
    }

    public a() {
    }

    public static void e(boolean r0) {
        f6568f = r0;
    }

    private String f(String r7) {
        if (k.c(r7) == false) goto L51;
        return r7;
    L51:
        LinkedHashMap r6 = new LinkedHashMap();     // Catch: Throwable -> L50
        Pair<String, String> r0 = l.k(r7, r6);     // Catch: Throwable -> L50
        if (r0 != null) goto L9;
        return r7;
    L9:
        if (r6.isEmpty() == true) goto L28;
        Iterator r1 = r6.entrySet().iterator();     // Catch: Throwable -> L50
    L12:
        if (r1.hasNext() == false) goto L28;
        Map.Entry r2 = (Map.Entry) r1.next();     // Catch: Throwable -> L50
        if (r2 == null) goto L12;
        List r3 = (List) r2.getValue();     // Catch: Throwable -> L50
        if (r3 == null) goto L12;
        if (r3.isEmpty() == true) goto L12;
        LinkedHashSet r4 = new LinkedHashSet();     // Catch: Throwable -> L50
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L50
    L23:
        if (r5.hasNext() == false) goto L12;
        String r8 = (String) r5.next();     // Catch: Throwable -> L50
        if (r4.contains(r8) == true) goto L26;
        r4.add(r8);     // Catch: Throwable -> L50
        goto L23
    L26:
        r5.remove();     // Catch: Throwable -> L50
    L28:
        d.b.h.a.a.h.s.k r9 = new d.b.h.a.a.h.s.k(((String) r0.first) + ((String) r0.second));     // Catch: Throwable -> L50
        if (r6.isEmpty() == true) goto L48;
        Iterator r10 = r6.entrySet().iterator();     // Catch: Throwable -> L50
    L32:
        if (r10.hasNext() == false) goto L48;
        Map.Entry r11 = (Map.Entry) r10.next();     // Catch: Throwable -> L50
        if (r11 == null) goto L32;
        if (r11.getKey() == null) goto L32;
        List r12 = (List) r11.getValue();     // Catch: Throwable -> L50
        if (r12 == null) goto L32;
        if (r12.isEmpty() == true) goto L32;
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L50
    L46:
        if (r13.hasNext() == false) goto L32;
        r9.b((String) r11.getKey(), (String) r13.next());     // Catch: Throwable -> L50
    L48:
        return r9.c();
    L50:
        return r7;
    }

    @Override // d.b.h.a.a.h.q.a
    protected c b(c r9) {
        c r10 = super.b(r9);
        if (r10 != null) goto L7;
        return null;
    L7:
        if (f6569g == true) goto L9;
        com.bytedance.ttnet.m.b.d();
        f6569g = true;
    L9:
        long r0 = SystemClock.uptimeMillis();
        c.a r2 = r10.O();
        String r8 = f(r10.G());
        r2.h(r8);
        if (r10.z() == null) goto L12;
        y r3 = r10.z();
        r3.X = SystemClock.uptimeMillis() - r0;
    L12:
        Long r1 = Long.valueOf(SystemClock.uptimeMillis());
        ArrayList r4 = new ArrayList();
        if (r10.v() == null) goto L16;
        r4.addAll(r10.v());
    L16:
        if (f6568f == false) goto L31;
        LinkedList r5 = new LinkedList();     // Catch: Throwable -> L45
        String r6 = d.b.h.b.a.a.g(r8, r5);     // Catch: Throwable -> L45
        if (r6 == null) goto L21;
        r2.h(r6);     // Catch: Throwable -> L45
    L21:
        if (r5.isEmpty() == true) goto L31;
        Iterator r7 = r5.iterator();     // Catch: Throwable -> L45
    L23:
        if (r7.hasNext() == false) goto L31;
        Pair r11 = (Pair) r7.next();     // Catch: Throwable -> L45
        if (r11 == null) goto L23;
        r4.add(new d.b.r.h0.b((String) r11.first, (String) r11.second));     // Catch: Throwable -> L45
    L31:
        if (r10.z() == null) goto L33;
        y r12 = r10.z();
        r12.Y = SystemClock.uptimeMillis() - r1.longValue();
    L33:
        Long r13 = Long.valueOf(SystemClock.uptimeMillis());
        String r14 = com.bytedance.ttnet.s.c.g(r8);     // Catch: Throwable -> L46
        if (k.c(r14) == true) goto L38;
        r4.add(new d.b.r.h0.b("X-SS-REQ-TICKET", r14));     // Catch: Throwable -> L46
    L38:
        if (r10.z() == null) goto L40;
        y r15 = r10.z();
        r15.Z = SystemClock.uptimeMillis() - r13.longValue();
    L40:
        Long r16 = Long.valueOf(SystemClock.uptimeMillis());
        com.bytedance.ttnet.s.a.h(r8, r4);
        if (r10.z() == null) goto L43;
        y r17 = r10.z();
        r17.b0 = SystemClock.uptimeMillis() - r16.longValue();
    L43:
        ClientKeyManager.k().a(r4, r10.z());
        r2.b(r4);
        return r2.a();
    }

    @Override // d.b.h.a.a.h.q.a
    protected void c(c r18, d0 r19) {
        super.c(r18, r19);
        if (r18 == null) goto L128;
        if (r19 == null) goto L130;
        d r2 = r19.g();
        Long r3 = Long.valueOf(SystemClock.uptimeMillis());
        if (g.h() == null) goto L21;
        String r4 = g.h().b();     // Catch: Throwable -> L98
        if (k.c(r4) == true) goto L21;
        List<d.b.r.h0.b> r5 = r2.h(r4);     // Catch: Throwable -> L98
        if (r5 == null) goto L21;
        if (r5.size() <= 0) goto L21;
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L98
        Iterator<d.b.r.h0.b> r7 = r5.iterator();     // Catch: Throwable -> L98
    L17:
        if (r7.hasNext() == false) goto L19;
        r6.add(r7.next().b());     // Catch: Throwable -> L98
        goto L17
    L19:
        g.h().a(r6);     // Catch: Throwable -> L98
    L21:
        if (r18.z() == null) goto L23;
        r18.z().f0 = SystemClock.uptimeMillis() - r3.longValue();
    L23:
        ClientKeyManager.k().g(r18, r2);
        Long r8 = Long.valueOf(SystemClock.uptimeMillis());
        Object r9 = r2.b();
        String r10 = null;
        if ((r9 instanceof com.bytedance.ttnet.m.b) == false) goto L41;
        com.bytedance.ttnet.m.b r11 = (com.bytedance.ttnet.m.b) r9;
        if (r11.f13358e == 0) goto L106;
        JSONObject r12 = new JSONObject();
        List<d.b.r.h0.b> r13 = r2.d();
        int r14 = 0;
    L29:
        if (r14 >= r13.size()) goto L37;
        d.b.r.h0.b r15 = r13.get(r14);     // Catch: Exception -> L99
        if (r15 == null) goto L36;
        if (TextUtils.isEmpty(r15.a()) == true) goto L36;
        r12.put(r15.a().toUpperCase(), r15.b());     // Catch: Exception -> L99
    L36:
        r14 = r14 + 1;
        goto L29
    L37:
        T r16 = r11.f13358e;
        if ((r16 instanceof com.bytedance.ttnet.m.d) == false) goto L40;
        ((com.bytedance.ttnet.m.d) r16).F = r12;
    L40:
        ((com.bytedance.ttnet.m.d) r16).f13367b = r2.e();
        ((com.bytedance.ttnet.m.d) r11.f13358e).f13366a = r11.f13357d;
    L106:
        String r17 = r2.g();     // Catch: Throwable -> L100
        d.b.r.h0.b r20 = r18.u("X-SS-REQ-TICKET");     // Catch: Throwable -> L100
        if (r20 == null) goto L45;
        String r21 = r20.b();     // Catch: Throwable -> L100
    L46:
        d.b.r.h0.b r1 = r2.c("X-SS-REQ-TICKET");     // Catch: Throwable -> L100
        if (r1 == null) goto L49;
        String r22 = r1.b();     // Catch: Throwable -> L100
    L50:
        if (r22 == null) goto L52;
        r10 = r22;
    L52:
        com.bytedance.ttnet.s.c.a(r17, r21, r10, r11);     // Catch: Throwable -> L100
        goto L112
    L49:
        r22 = null;
        goto L50
    L45:
        r21 = null;
    L112:
        String r23 = r18.G();     // Catch: Throwable -> L103
        Uri r24 = Uri.parse(r23);     // Catch: Throwable -> L103
        if (r24.getHost().endsWith(com.bytedance.ttnet.c.a()) == true) goto L56;
        return;
    L56:
        String[] r25 = {"Set-Cookie"};     // Catch: Throwable -> L103
        int r26 = 2;
        String[] r27 = {"sessionid", "tt_sessionid"};     // Catch: Throwable -> L103
        int r110 = 0;
    L58:
        if (r110 >= 1) goto L92;
        List<d.b.r.h0.b> r111 = r2.h(r25[r110]);     // Catch: Throwable -> L103
        if (r111 == null) goto L90;
        if (r111.size() <= 0) goto L90;
        Iterator<d.b.r.h0.b> r112 = r111.iterator();     // Catch: Throwable -> L103
    L66:
        if (r112.hasNext() == false) goto L90;
        d.b.r.h0.b r113 = r112.next();     // Catch: Throwable -> L103
        int r114 = 0;
    L68:
        if (r114 >= r26) goto L66;
        String r115 = d.b.h.a.a.h.p.a.a(r113.b(), r27[r114]);     // Catch: Throwable -> L103
        Logger.debug();     // Catch: Throwable -> L103
        if (k.c(r115) == false) goto L72;
        Uri r116 = r24;
    L89:
        r114 = r114 + 1;
        r24 = r116;
        r26 = 2;
        goto L68
    L72:
        int r117 = r2.e();     // Catch: Throwable -> L103
        boolean r118 = r11.d0;     // Catch: Throwable -> L103
        JSONObject r28 = new JSONObject();     // Catch: Throwable -> L103
        String r29 = r24.getEncodedQuery();     // Catch: Throwable -> L102
        if (k.c(r29) == true) goto L78;
        r116 = r24;
        r28.put("url_query", r29);     // Catch: Throwable -> L101
    L80:
        if (k.c(r11.f13357d) == true) goto L83;
        r28.put(ICronetClient.KEY_REMOTE_IP, r11.f13357d);     // Catch: Throwable -> L103
    L83:
        if (r2.d() == null) goto L85;
        r28.put("header_list", r2.d().toString());     // Catch: Throwable -> L103
    L85:
        int r30 = r23.indexOf("?");     // Catch: Throwable -> L103
        if (r30 != (-1)) goto L88;
        r30 = r23.length();     // Catch: Throwable -> L103
    L88:
        com.bytedance.ttnet.s.c.d("set_cookie", r23.substring(0, r30), r117, r118, r28);     // Catch: Throwable -> L103
    L78:
        r116 = r24;
    L90:
        r110 = r110 + 1;
        r24 = r24;
        r26 = 2;
    L92:
        if (r18.z() == null) goto L94;
        r18.z().a0 = SystemClock.uptimeMillis() - r8.longValue();
    L94:
        Long r31 = Long.valueOf(SystemClock.uptimeMillis());
        com.bytedance.ttnet.s.a.f(r18, r2, r11);
        if (r18.z() == null) goto L129;
        r18.z().e0 = SystemClock.uptimeMillis() - r31.longValue();
        return;
    L129:
        return;
    L41:
        r11 = null;
        goto L106
    L130:
        return;
    }
}

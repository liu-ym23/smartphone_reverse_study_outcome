package com.ss.android.account.token;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ss.android.token.h;
import com.ss.android.token.m;
import com.ss.android.token.n;
import com.ss.android.token.p;
import d.b.r.d0;
import d.b.r.h0.c;
import d.b.r.k0.j;
import d.b.s.a.l0.k;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b implements d.b.r.j0.a {
    public b() {
        d.b.s.a.a0.a.d("TTTokenInterceptor", "TTTokenInterceptor created. isTokenInit: " + p.g0());
    }

    @Nullable
    private List<m> b(h r4, d0 r5) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.f12213d == false) goto L31;
        ArrayList r3 = new ArrayList();
        Object r6 = r5.g().b();
        if ((r6 instanceof d.b.h.a.a.h.b) == true) goto L22;
    L18:
        return r3;
    L22:
        JSONObject r7 = new JSONObject(((d.b.h.a.a.h.b) r6).H);     // Catch: Throwable -> L21
        Iterator<String> r8 = r7.keys();     // Catch: Throwable -> L21
    L11:
        if (r8.hasNext() == false) goto L18;
        String r0 = r8.next();     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r0) == true) goto L11;
        String r1 = r7.optString(r0);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r1) == true) goto L11;
        r3.add(new m(r0, r1));     // Catch: Throwable -> L21
    L31:
        return null;
    }

    private String c(c r4) {
        String r0 = null;
        if (com.bytedance.sdk.account.ticketguard.c.c() == true) goto L5;
        return null;
    L5:
        if (com.bytedance.sdk.account.ticketguard.c.d(r4.A()) == false) goto L40;
        if ("post".equalsIgnoreCase(r4.y()) == false) goto L21;
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: Throwable -> L29
        j r1 = r4.s();     // Catch: Exception -> L26 Throwable -> L17
        if (r1 == null) goto L30;
        if ((r1 instanceof d.b.r.k0.c) == false) goto L30;
        r1.b(r3);     // Catch: Exception -> L26 Throwable -> L17
        r0 = r3.toString();     // Catch: Exception -> L26 Throwable -> L17
    L17:
        th = move-exception;
        r3.close();     // Catch: Exception -> L27 Throwable -> L29
    L19:
        throw th;     // Catch: Throwable -> L29
    L30:
        r3.close();     // Catch: Exception -> L28 Throwable -> L29
    L21:
        if (TextUtils.isEmpty(r0) == true) goto L23;
        return r0;
    L23:
        if (r4.G().contains("?") == true) goto L25;
        return r0;
    L25:
        return r4.G().split("\\?")[1];
    L41:
        return r0;
    L40:
        return null;
    }

    @Override // d.b.r.j0.a
    public d0 a(d.b.r.j0.a.InterfaceC0391a r19) {
        long r6 = System.currentTimeMillis();
        c r1 = r19.b();
        ArrayList r2 = new ArrayList();
        r2.addAll(r1.v());
        List<m> r8 = TTTokenUtils.a(r2);
        String r9 = k.b(r1.G());
        String r10 = r1.G();
        n.r(r9);
        h r3 = n.c(r10, c(r1), r8);
        if (r3 == null) goto L18;
        Map<String, String> r4 = r3.f12210a;
        if (r4 == null) goto L18;
        if (r4.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L10:
        if (r5.hasNext() == false) goto L18;
        Map.Entry<String, String> r7 = r5.next();
        if (r7 == null) goto L10;
        if (TextUtils.isEmpty(r7.getKey()) == true) goto L10;
        if (TextUtils.isEmpty(r7.getValue()) == true) goto L10;
        r2.add(new d.b.r.h0.b(r7.getKey(), r7.getValue()));
    L18:
        long r12 = System.currentTimeMillis() - r6;
        c.a r11 = r1.O();
        r11.b(r2);
        d0 r14 = r19.c(r11.a());
        long r16 = (System.currentTimeMillis() - r6) - r12;
        List<m> r13 = TTTokenUtils.a(r14.d());
        n.t(r10, r3, b(r3, r14), r13, r6);
        n.s(r9, r14.b());
        if (r14.e() == false) goto L21;
        com.ss.android.j.a.c(r10, r9, r8, r13);
    L21:
        n.o(r10, r13, r12, ((System.currentTimeMillis() - r6) - r12) - r16, r16);
        return r14;
    }
}

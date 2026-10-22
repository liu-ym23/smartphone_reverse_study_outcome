package com.ss.android.account.token;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.account.ticketguard.c;
import com.ss.android.token.n;
import com.ss.android.token.o;
import com.ss.android.token.t;
import d.b.h.a.a.h.g;
import d.b.h.a.a.h.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a implements g.n {
    public a() {
    }

    private String b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        Uri r1 = Uri.parse(r2);
        if (r1 == null) goto L11;
        String r0 = r1.getPath();
        if (TextUtils.isEmpty(r0) == false) goto L10;
        return r0;
    L10:
        return r0.toLowerCase(Locale.getDefault());
    L11:
        return null;
    }

    private boolean c(String r9, String r10, List<d.b.r.h0.b> r11, String r12, String r13, String r14, boolean r15) {
        if (TextUtils.isEmpty(r13) == false) goto L5;
        return false;
    L5:
        if (r11 != null) goto L7;
    L34:
        return false;
    L7:
        if (r11.isEmpty() == true) goto L34;
        Iterator<d.b.r.h0.b> r0 = r11.iterator();
    L11:
        if (r0.hasNext() == false) goto L15;
        d.b.r.h0.b r2 = r0.next();
        if ("x-tt-token".equalsIgnoreCase(r2.a()) == false) goto L11;
        String r1 = r2.b();
    L16:
        String r7 = r1;
        if (TextUtils.isEmpty(r7) == false) goto L20;
        return false;
    L20:
        if (r13.equals(r7) == false) goto L23;
        return false;
    L23:
        if (com.bytedance.sdk.account.settings.f.a.x() == true) goto L25;
    L27:
        d.b.s.a.a0.a.h("AccountSDK", "account user mixed, path=" + r9 + ", logid=" + r10);
        if (com.bytedance.sdk.account.settings.f.a.s() == true) goto L30;
        return true;
    L30:
        if (com.bytedance.sdk.account.settings.f.a.C(r9) == false) goto L39;
        o.y(r9, r10, r15, TextUtils.isEmpty(r12), r13.equals(r12), r13, r14, r7);
        return true;
    L39:
        return true;
    L25:
        if (r7.equals(r14) == false) goto L27;
        return false;
    L15:
        r1 = null;
        goto L16
    }

    @Override // d.b.h.a.a.h.g.n
    public i a(String r12, List<d.b.r.h0.b> r13, Map<String, List<String>> r14, boolean r15) {
        String r16 = b(r12);
        HashMap r8 = null;
        boolean r9 = false;
        if (r14 != null) goto L5;
    L24:
        String r2 = null;
        String r4 = null;
    L25:
        t r17 = n.i();
        String r6 = n.e();
        if (r17 != null) goto L28;
        String r5 = null;
    L30:
        if (com.bytedance.sdk.account.settings.f.a.r() == true) goto L32;
    L34:
        boolean r18 = false;
    L36:
        if (c(r16, r2, r13, r4, r5, r6, r18) == false) goto L56;
        if (r18 == false) goto L56;
        if (c.c() == true) goto L41;
    L43:
        boolean r11 = false;
    L44:
        d.b.s.a.a0.a.h("AccountSDK", "account user mixed, isSecUidGuard is " + r11);
        if (r11 == true) goto L56;
        r8 = new HashMap();
        Map<String, String> r19 = n.d(r12);
        if (r19 == null) goto L52;
        if (r19.isEmpty() == true) goto L52;
        r8.putAll(r19);
    L52:
        if ("/passport/token/beat/v2/".equalsIgnoreCase(r16) == false) goto L54;
        d.b.s.a.y.g.N();
    L54:
        r9 = true;
        goto L56
    L41:
        if (c.d(r16) == false) goto L43;
        r11 = true;
    L56:
        return new i(r9, r8);
    L32:
        if (com.bytedance.sdk.account.settings.f.a.B(r16) == false) goto L34;
        r18 = true;
        goto L36
    L28:
        r5 = r17.f12309a;
        goto L30
    L5:
        if (r14.isEmpty() == true) goto L24;
        Iterator<String> r0 = r14.keySet().iterator();
        String r1 = null;
        r2 = null;
    L8:
        if (r0.hasNext() == false) goto L23;
        String r3 = r0.next();
        if ("x-tt-token".equalsIgnoreCase(r3) == false) goto L17;
        List<String> r7 = r14.get(r3);
        if (r7 == null) goto L17;
        if (r7.isEmpty() == true) goto L17;
        r1 = r7.get(0);
    L17:
        if ("x-tt-logid".equalsIgnoreCase(r3) == false) goto L8;
        List<String> r10 = r14.get(r3);
        if (r10 == null) goto L8;
        if (r10.isEmpty() == true) goto L8;
        r2 = r10.get(0);
        goto L8
    L23:
        r4 = r1;
        goto L25
    }
}

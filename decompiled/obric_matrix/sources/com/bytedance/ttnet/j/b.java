package com.bytedance.ttnet.j;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.TTNetInit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f6346a;

    private b() {
    }

    public static b a() {
        if (f6346a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6346a != null) goto L9;
        f6346a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f6346a;
    }

    public void b(ArrayList<String> r23, String r24) {
        String r6 = "";
        if (r23 != null) goto L5;
        return;
    L5:
        if (r23.isEmpty() == true) goto L85;
        Context r7 = TTNetInit.getTTNetDepend().getContext();
        if (r7 != null) goto L10;
        return;
    L10:
        Logger.debug();
        Iterator<String> r8 = r23.iterator();
    L12:
        if (r8.hasNext() == false) goto L88;
        String r9 = r8.next();
        com.bytedance.ttnet.m.a r10 = new com.bytedance.ttnet.m.a();     // Catch: Throwable -> L63
        r10.f6475d = true;     // Catch: Throwable -> L63
        r10.f6476e = false;     // Catch: Throwable -> L63
        d.b.h.a.a.h.s.k r11 = new d.b.h.a.a.h.s.k(r9);     // Catch: Throwable -> L63
        r11.b("tnc_src", "7");     // Catch: Throwable -> L63
        String r12 = r11.toString();     // Catch: Throwable -> L63
        HashMap r13 = new HashMap();     // Catch: Throwable -> L63
        HashMap r14 = new HashMap();     // Catch: Throwable -> L63
        if (TextUtils.isEmpty(r24) == true) goto L21;
        r14.put("x-tt-tnc-summary", r24);     // Catch: Throwable -> L65
    L21:
        if (com.bytedance.ttnet.r.c.l().x("GET", r12, r14, "") == false) goto L22;
        String r15 = com.bytedance.ttnet.m.c.a(r12, r14, r13, r10);     // Catch: Throwable -> L65
        Logger.debug();     // Catch: Throwable -> L65
        if (com.bytedance.ttnet.r.c.l().y("GET", r12, r13, r15) == false) goto L25;
        if (com.bytedance.common.utility.k.c(r15) == true) goto L12;
        if ("success".equals(new JSONObject(r15).getString("message")) == false) goto L12;
        if (r13.get("x-ss-etag") != null) goto L35;
    L37:
        String r16 = "";
    L39:
        if (r13.get("x-ss-canary") != null) goto L41;
    L43:
        String r17 = "";
    L45:
        if (r13.get("x-tt-tnc-config") != null) goto L47;
    L49:
        String r18 = "";
    L51:
        if (r13.get("x-tt-tnc-abtest") != null) goto L53;
    L55:
        String r19 = "";
    L57:
        if (r13.get("x-tt-tnc-control") != null) goto L59;
    L61:
        Logger.debug();     // Catch: Throwable -> L66
        com.bytedance.frameworks.baselib.network.http.cronet.e.j.w(r7).C(r16, r17, r18, r19, r6, r15);     // Catch: Throwable -> L66
        return;
    L59:
        if (TextUtils.isEmpty((CharSequence) ((List) r13.get("x-tt-tnc-control")).get(0)) == true) goto L61;
        r6 = (String) ((List) r13.get("x-tt-tnc-control")).get(0);     // Catch: Throwable -> L66
        goto L61
    L53:
        if (TextUtils.isEmpty((CharSequence) ((List) r13.get("x-tt-tnc-abtest")).get(0)) == true) goto L55;
        r19 = (String) ((List) r13.get("x-tt-tnc-abtest")).get(0);     // Catch: Throwable -> L66
        goto L57
    L47:
        if (TextUtils.isEmpty((CharSequence) ((List) r13.get("x-tt-tnc-config")).get(0)) == true) goto L49;
        r18 = (String) ((List) r13.get("x-tt-tnc-config")).get(0);     // Catch: Throwable -> L66
        goto L51
    L41:
        if (TextUtils.isEmpty((CharSequence) ((List) r13.get("x-ss-canary")).get(0)) == true) goto L43;
        r17 = (String) ((List) r13.get("x-ss-canary")).get(0);     // Catch: Throwable -> L66
        goto L45
    L35:
        if (TextUtils.isEmpty((CharSequence) ((List) r13.get("x-ss-etag")).get(0)) == true) goto L37;
        r16 = (String) ((List) r13.get("x-ss-etag")).get(0);     // Catch: Throwable -> L66
    L87:
        return;
    L25:
        return;
    L22:
        return;
    L88:
        return;
    }
}

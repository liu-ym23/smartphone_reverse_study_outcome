package com.obric.matrix.account.http;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.article.common.network.ICommonApi;
import com.obric.matrix.common_api.INetworkApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class f extends com.bytedance.common.utility.g {
    public f() {
    }

    private static List<d.b.r.h0.b> k(Map<String, String> r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        Map.Entry<String, String> r1 = r5.next();
        r0.add(new d.b.r.h0.b(r1.getKey(), r1.getValue()));
        goto L7
    L9:
        return r0;
    }

    private static Pair<String, String> l(String r4) {
        Uri r5 = Uri.parse(r4);
        StringBuilder r0 = new StringBuilder();
        String r1 = r5.getScheme();
        String r2 = r5.getHost();
        int r3 = r5.getPort();
        if (r2 == null) goto L9;
        if (r1 == null) goto L6;
        r0.append(r1);
        r0.append("://");
    L6:
        r0.append(r2);
        if (r3 <= 0) goto L9;
        r0.append(':');
        r0.append(r3);
    L9:
        String r6 = r0.toString();
        String r7 = r5.getPath();
        String r8 = r5.getQuery();
        if (r8 == null) goto L13;
        r7 = r7 + "?" + r8;
    L13:
        return new Pair(r6, r7);
    }

    @Override // com.bytedance.common.utility.g
    public String e(String r2, Map<String, String> r3, com.bytedance.common.utility.g.a r4) {
        Pair<String, String> r1 = l(r2);
        String r5 = (String) r1.first;
        String r6 = (String) r1.second;
        ICommonApi r7 = (ICommonApi) com.bytedance.ttnet.s.d.f(r5, ICommonApi.class);
        List<d.b.r.h0.b> r8 = k(r3);
        if (r4 == null) goto L5;
        boolean r9 = r4.f3274a;
    L7:
        return r7.get(-1, r6, r8, r9).execute().a();
    L5:
        r9 = false;
        goto L7
    }

    @Override // com.bytedance.common.utility.g
    public String g(String r8, List<Pair<String, String>> r9, Map<String, String> r10, com.bytedance.common.utility.g.a r11) {
        Pair<String, String> r12 = l(r8);     // Catch: Exception -> L14
        String r0 = (String) r12.first;     // Catch: Exception -> L14
        String r3 = (String) r12.second;     // Catch: Exception -> L14
        ICommonApi r1 = (ICommonApi) com.bytedance.ttnet.s.d.f(r0, ICommonApi.class);     // Catch: Exception -> L14
        List<d.b.r.h0.b> r5 = k(r10);     // Catch: Exception -> L14
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Exception -> L14
        if (r9 == null) goto L9;
        Iterator<Pair<String, String>> r13 = r9.iterator();     // Catch: Exception -> L14
    L7:
        if (r13.hasNext() == false) goto L9;
        Pair<String, String> r14 = r13.next();     // Catch: Exception -> L14
        r4.put((String) r14.first, (String) r14.second);     // Catch: Exception -> L14
    L9:
        if (r11 == null) goto L11;
        boolean r6 = r11.f3274a;     // Catch: Exception -> L14
    L12:
        return r1.postForm(-1, r3, r4, r5, r6).execute().a();
    L11:
        r6 = false;
    L14:
        e = move-exception;
        if ((e instanceof d.b.h.a.a.h.l.d) == true) goto L24;
        if ((e instanceof com.bytedance.frameworks.baselib.network.http.cronet.e.e) == false) goto L22;
        throw new com.bytedance.common.utility.a(((com.bytedance.frameworks.baselib.network.http.cronet.e.e) e).e(), e.getMessage());
    L22:
        throw new com.bytedance.common.utility.a(0, e.getMessage());
    L24:
        throw new com.bytedance.common.utility.a(((d.b.h.a.a.h.l.d) e).c(), e.getMessage());
    }

    @Override // com.bytedance.common.utility.g
    public String h(String r8, byte[] r9, Map<String, String> r10, com.bytedance.common.utility.g.a r11) {
        Pair<String, String> r12 = l(r8);     // Catch: Exception -> L12
        String r0 = (String) r12.first;     // Catch: Exception -> L12
        String r3 = (String) r12.second;     // Catch: Exception -> L12
        ICommonApi r1 = (ICommonApi) com.bytedance.ttnet.s.d.f(r0, ICommonApi.class);     // Catch: Exception -> L12
        String r13 = null;
        if (r10 == null) goto L6;
        String r2 = r10.get(INetworkApi.CONTENT_TYPE);     // Catch: Exception -> L12
        r10.remove(INetworkApi.CONTENT_TYPE);     // Catch: Exception -> L12
        r13 = r2;
    L6:
        List<d.b.r.h0.b> r5 = k(r10);     // Catch: Exception -> L12
        if (r11 == null) goto L9;
        boolean r6 = r11.f3274a;     // Catch: Exception -> L12
    L10:
        return r1.postData(-1, r3, new d.b.r.k0.g(r13, r9, new String[0]), r5, r6).execute().a();
    L9:
        r6 = false;
    L12:
        e = move-exception;
        if ((e instanceof d.b.h.a.a.h.l.d) == true) goto L22;
        if ((e instanceof com.bytedance.frameworks.baselib.network.http.cronet.e.e) == false) goto L20;
        com.bytedance.frameworks.baselib.network.http.cronet.e.e r14 = (com.bytedance.frameworks.baselib.network.http.cronet.e.e) e;
        throw new e(r14.e(), r14.b(), e.getMessage());
    L20:
        throw new e(0, 0, e.getMessage());
    L22:
        throw new e(((d.b.h.a.a.h.l.d) e).c(), 0, e.getMessage());
    }
}

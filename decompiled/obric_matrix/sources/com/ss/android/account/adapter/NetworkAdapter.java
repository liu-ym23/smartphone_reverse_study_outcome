package com.ss.android.account.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.k;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.m.d;
import com.ss.android.f;
import com.ss.android.g;
import com.ss.android.h;
import d.b.h.a.a.h.s.l;
import d.b.r.b;
import d.b.r.d0;
import d.b.r.k0.j;
import d.b.s.a.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkAdapter implements i {
    public NetworkAdapter() {
    }

    private h g(b<String> r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        d0<String> r1 = r7.execute();
        if (r1 != null) goto L9;
        return null;
    L9:
        if (r1.g() == null) goto L11;
        String r0 = r1.g().g();
        int r2 = r1.g().e();
    L12:
        h r4 = new h(r0, r2, k(r1.d()), r1.a());
        if (r7.b() == null) goto L15;
        r4.g(new g(r7.b().x(), r7.b().G(), k(r7.b().v())));
    L15:
        return r4;
    L11:
        r2 = -1;
        r0 = "";
        goto L12
    }

    private b<String> h(int r9, String r10, List<f> r11, int r12) {
        d r0 = null;
        if (k.c(r10) == false) goto L5;
        return null;
    L5:
        LinkedHashMap r5 = new LinkedHashMap();
        Pair<String, String> r8 = l.j(r10, r5);
        String r13 = (String) r8.first;
        String r4 = (String) r8.second;
        INetworkApi r1 = (INetworkApi) com.bytedance.ttnet.s.d.f(r13, INetworkApi.class);
        LinkedList r6 = new LinkedList();
        if (r11 != null) goto L8;
    L15:
        if (r1 == null) goto L20;
        if (r12 == 0) goto L19;
        r0 = new d();
        r0.s = r12;
    L19:
        return r1.doGet(true, r9, r4, r5, r6, r0);
    L20:
        return null;
    L8:
        if (r11.isEmpty() == true) goto L15;
        Iterator<f> r14 = r11.iterator();
    L11:
        if (r14.hasNext() == false) goto L15;
        f r15 = r14.next();
        if (r15 == null) goto L11;
        r6.add(new d.b.r.h0.b(r15.a(), r15.b()));
        goto L11
    }

    private b<String> i(int r9, String r10, Map<String, String> r11, List<f> r12, int r13) {
        d r0 = null;
        if (k.c(r10) == false) goto L5;
        return null;
    L5:
        LinkedHashMap r4 = new LinkedHashMap();
        Pair<String, String> r8 = l.j(r10, r4);
        String r14 = (String) r8.first;
        String r3 = (String) r8.second;
        INetworkApi r1 = (INetworkApi) com.bytedance.ttnet.s.d.f(r14, INetworkApi.class);
        LinkedList r6 = new LinkedList();
        if (r12 != null) goto L8;
    L15:
        LinkedHashMap r5 = new LinkedHashMap();
        if (r11 == null) goto L21;
        if (r11.isEmpty() == true) goto L21;
        r5.putAll(r11);
    L21:
        if (TextUtils.equals(r5.get("account_sdk_ignore_common_param"), LocationInfoConst.ALLOW_USE_LOCATION) == true) goto L23;
        d.b.h.a.a.h.g.D(r5, true);
    L23:
        if (r1 == null) goto L28;
        if (r13 == 0) goto L27;
        r0 = new d();
        r0.s = r13;
    L27:
        return r1.doPost(r9, r3, r4, r5, r6, r0);
    L28:
        return null;
    L8:
        if (r12.size() == 0) goto L15;
        Iterator<f> r15 = r12.iterator();
    L11:
        if (r15.hasNext() == false) goto L15;
        f r16 = r15.next();
        if (r16 == null) goto L11;
        r6.add(new d.b.r.h0.b(r16.a(), r16.b()));
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    private b<String> j(int r8, String r9, Map<String, j> r10, List<f> r11) {
        if (k.c(r9) == false) goto L5;
        return null;
    L5:
        LinkedHashMap r4 = new LinkedHashMap();
        Pair<String, String> r7 = l.j(r9, r4);
        String r12 = (String) r7.first;
        String r3 = (String) r7.second;
        INetworkApi r1 = (INetworkApi) com.bytedance.ttnet.s.d.f(r12, INetworkApi.class);
        LinkedList r6 = new LinkedList();
        if (r11 != null) goto L8;
    L13:
        LinkedHashMap r13 = new LinkedHashMap();
        d.b.h.a.a.h.g.D(r13, true);
        if (r13.isEmpty() == true) goto L22;
        Iterator r14 = r13.entrySet().iterator();
    L17:
        if (r14.hasNext() == false) goto L22;
        Map.Entry r15 = (Map.Entry) r14.next();
        if (r15 == null) goto L17;
        r10.put(r15.getKey(), new d.b.r.k0.k((String) r15.getValue()));
    L22:
        if (r1 != null) goto L24;
        return null;
    L24:
        return r1.postMultiPart(r8, r3, r4, r10, r6);
    L8:
        if (r11.size() <= 0) goto L13;
        Iterator<f> r16 = r11.iterator();
    L11:
        if (r16.hasNext() == false) goto L13;
        f r17 = r16.next();
        r6.add(new d.b.r.h0.b(r17.a(), r17.b()));
        goto L11
    }

    private List<f> k(List<d.b.r.h0.b> r4) {
        ArrayList r3 = new ArrayList();
        if (r4 != null) goto L5;
    L12:
        return r3;
    L5:
        if (r4.isEmpty() == true) goto L12;
        Iterator<d.b.r.h0.b> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        d.b.r.h0.b r0 = r5.next();
        if (r0 == null) goto L8;
        r3.add(new f(r0.a(), r0.b()));
        goto L8
    }

    @Override // d.b.s.a.i
    public List<String> a() {
        return TTNetInit.getPublicIPv6List();
    }

    @Override // d.b.s.a.i
    public h b(int r1, String r2, List<f> r3, int r4) {
        return g(h(r1, r2, r3, r4));
    }

    @Override // d.b.s.a.i
    public List<String> c() {
        return TTNetInit.getPublicIPv4List();
    }

    @Override // d.b.s.a.i
    public h d(int r6, String r7, Map<String, String> r8, String r9, String r10, List<f> r11) {
        if (k.c(r7) == false) goto L5;
        return null;
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        if (r8 != null) goto L8;
    L13:
        r0.put(r9, new d.b.r.k0.h(null, new File(r10)));
        return g(j(r6, r7, r0, r11));
    L8:
        if (r8.isEmpty() == true) goto L13;
        Iterator<Map.Entry<String, String>> r12 = r8.entrySet().iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        Map.Entry<String, String> r2 = r12.next();
        r0.put(r2.getKey(), new d.b.r.k0.k(r2.getValue()));
        goto L11
    }

    @Override // d.b.s.a.i
    public h e(int r1, String r2, Map<String, String> r3, List<f> r4, int r5) {
        return g(i(r1, r2, r3, r4, r5));
    }

    @Override // d.b.s.a.i
    public int f(Context r1, Throwable r2) {
        return 0;
    }
}

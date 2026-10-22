package com.obric.matrix.account.l;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.s.d;
import com.obric.matrix.r.c.c;
import com.ss.android.f;
import com.ss.android.h;
import d.b.h.a.a.h.g;
import d.b.r.d0;
import d.b.s.a.i;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8545a;

    public b() {
        this.f8545a = "NetworkAdapter";
    }

    private h g(d0<String> r8) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.g() == null) goto L6;
        String r7 = r8.g().g();
        int r0 = r8.g().e();
    L7:
        ArrayList r1 = new ArrayList();
        List<d.b.r.h0.b> r2 = r8.d();
        if (r2 == null) goto L18;
        if (r2.size() <= 0) goto L18;
        Iterator<d.b.r.h0.b> r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L18;
        d.b.r.h0.b r4 = r3.next();
        if (r4 == null) goto L13;
        r1.add(new f(r4.a(), r4.b()));
    L18:
        return new h(r7, r0, r1, r8.a());
    L6:
        r0 = -1;
        r7 = "";
        goto L7
    }

    @Override // d.b.s.a.i
    public h b(int r9, String r10, List<f> r11, int r12) {
        c.b(this.f8545a, "executeGet");     // Catch: Exception -> L19
        d0<String> r0 = null;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        LinkedHashMap r5 = new LinkedHashMap();     // Catch: Exception -> L19
        Pair<String, String> r13 = d.g.f.c.a.a(r10, r5);     // Catch: Exception -> L19
        String r14 = (String) r13.first;     // Catch: Exception -> L19
        String r4 = (String) r13.second;     // Catch: Exception -> L19
        INetworkApi r1 = (INetworkApi) d.f(r14, INetworkApi.class);     // Catch: Exception -> L19
        LinkedList r6 = new LinkedList();     // Catch: Exception -> L19
        if (r11 != null) goto L8;
    L15:
        if (r1 == null) goto L17;
        r0 = r1.doGet(true, r9, r4, r5, r6, null).execute();     // Catch: Exception -> L19
    L17:
        return g(r0);
    L8:
        if (r11.isEmpty() == true) goto L15;
        Iterator<f> r15 = r11.iterator();     // Catch: Exception -> L19
    L11:
        if (r15.hasNext() == false) goto L15;
        f r16 = r15.next();     // Catch: Exception -> L19
        if (r16 == null) goto L11;
        r6.add(new d.b.r.h0.b(r16.a(), r16.b()));     // Catch: Exception -> L19
    L19:
        e = move-exception;
        c.g(this.f8545a, "NetworkAdapter.executeGet e=" + e, e);
        throw e;
    }

    @Override // d.b.s.a.i
    public h d(int r9, String r10, Map<String, String> r11, String r12, String r13, List<f> r14) {
        c.b(this.f8545a, "NetworkAdapter.postFile, paramName: " + r12);
        d0<String> r1 = null;
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        LinkedHashMap r5 = new LinkedHashMap();     // Catch: Exception -> L29
        Pair<String, String> r15 = d.g.f.c.a.a(r10, r5);     // Catch: Exception -> L29
        String r0 = (String) r15.first;     // Catch: Exception -> L29
        String r4 = (String) r15.second;     // Catch: Exception -> L29
        INetworkApi r2 = (INetworkApi) d.f(r0, INetworkApi.class);     // Catch: Exception -> L29
        LinkedList r7 = new LinkedList();     // Catch: Exception -> L29
        if (r14 != null) goto L9;
    L16:
        LinkedHashMap r16 = new LinkedHashMap();     // Catch: Exception -> L29
        if (r11 == null) goto L22;
        if (r11.isEmpty() == true) goto L22;
        r16.putAll(r11);     // Catch: Exception -> L29
    L22:
        if (TextUtils.equals((CharSequence) r16.get("account_sdk_ignore_common_param"), LocationInfoConst.ALLOW_USE_LOCATION) == true) goto L24;
        g.D(r16, true);     // Catch: Exception -> L29
    L24:
        d.b.r.k0.h r17 = new d.b.r.k0.h("application/octet-stream", new File(r13));     // Catch: Exception -> L29
        HashMap r6 = new HashMap();     // Catch: Exception -> L29
        r6.put(r12, r17);     // Catch: Exception -> L29
        if (r2 == null) goto L27;
        r1 = r2.postMultiPart(r9, r4, r5, r6, r7).execute();     // Catch: Exception -> L29
    L27:
        return g(r1);
    L9:
        if (r14.isEmpty() == true) goto L16;
        Iterator<f> r18 = r14.iterator();     // Catch: Exception -> L29
    L12:
        if (r18.hasNext() == false) goto L16;
        f r19 = r18.next();     // Catch: Exception -> L29
        if (r19 == null) goto L12;
        r7.add(new d.b.r.h0.b(r19.a(), r19.b()));     // Catch: Exception -> L29
    L29:
        e = move-exception;
        c.g(this.f8545a, "NetworkAdapter.postFile e=" + e, e);
        throw e;
    }

    @Override // d.b.s.a.i
    public h e(int r9, String r10, Map<String, String> r11, List<f> r12, int r13) {
        c.b(this.f8545a, "executePost");     // Catch: Exception -> L27
        d0<String> r0 = null;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Exception -> L27
        Pair<String, String> r14 = d.g.f.c.a.a(r10, r4);     // Catch: Exception -> L27
        String r15 = (String) r14.first;     // Catch: Exception -> L27
        String r3 = (String) r14.second;     // Catch: Exception -> L27
        INetworkApi r1 = (INetworkApi) d.f(r15, INetworkApi.class);     // Catch: Exception -> L27
        LinkedList r6 = new LinkedList();     // Catch: Exception -> L27
        if (r12 != null) goto L8;
    L15:
        LinkedHashMap r5 = new LinkedHashMap();     // Catch: Exception -> L27
        if (r11 == null) goto L21;
        if (r11.isEmpty() == true) goto L21;
        r5.putAll(r11);     // Catch: Exception -> L27
    L21:
        if (TextUtils.equals(r5.get("account_sdk_ignore_common_param"), LocationInfoConst.ALLOW_USE_LOCATION) == true) goto L23;
        g.D(r5, true);     // Catch: Exception -> L27
    L23:
        if (r1 == null) goto L25;
        r0 = r1.doPost(r9, r3, r4, r5, r6, null).execute();     // Catch: Exception -> L27
    L25:
        return g(r0);
    L8:
        if (r12.size() == 0) goto L15;
        Iterator<f> r16 = r12.iterator();     // Catch: Exception -> L27
    L11:
        if (r16.hasNext() == false) goto L15;
        f r17 = r16.next();     // Catch: Exception -> L27
        if (r17 == null) goto L11;
        r6.add(new d.b.r.h0.b(r17.a(), r17.b()));     // Catch: Exception -> L27
    L27:
        e = move-exception;
        c.g(this.f8545a, "NetworkAdapter.executePost e=" + e, e);
        throw e;
    }

    @Override // d.b.s.a.i
    public int f(Context r2, Throwable r3) {
        c.j(this.f8545a, "NetworkAdapter.checkResponseException");
        if (r3 == null) goto L7;
        c.g(this.f8545a, "NetworkAdapter.checkResponseException e=" + r3, r3);
        return 0;
    L7:
        return 0;
    }
}

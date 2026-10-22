package com.bytedance.ttnet.j;

import android.webkit.CookieManager;
import com.bytedance.ttnet.TTNetInit;
import d.b.h.a.a.h.o.b.s;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i implements d.b.h.a.a.h.g.j, d.b.h.b.a.a.InterfaceC0365a, com.bytedance.ttnet.d.c, com.bytedance.frameworks.baselib.network.http.cronet.e.j.b, com.bytedance.frameworks.baselib.network.http.cronet.e.j.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile i f6383l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f6384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6387i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6388j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f6389k;

    private i() {
        a();
    }

    private boolean b(String r2, List<String> r3) {
        if (com.bytedance.common.utility.k.c(r2) == false) goto L5;
    L14:
        return false;
    L5:
        if (com.bytedance.common.utility.e.a(r3) == true) goto L14;
        Iterator<String> r1 = r3.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        if (r2.endsWith(r1.next()) == false) goto L9;
        return true;
    }

    public static i f() {
        if (f6383l != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6383l != null) goto L9;
        f6383l = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f6383l;
    }

    public void a() {
        TTNetInit.getTTNetDepend();     // Catch: Throwable -> L23
        this.f6384f = TTNetInit.getTTNetDepend().h(TTNetInit.getTTNetDepend().getContext(), "share_cookie_host_list", "");
        TTNetInit.getTTNetDepend().e(this.f6384f);
        boolean r4 = false;
        this.f6385g = TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_open", 0);
        int r0 = TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_header_open", 0);
        this.f6386h = r0;
        if (this.f6385g > 0) goto L6;
        if (r0 > 0) goto L6;
    L7:
        this.f6387i = TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_plaintext_open", 1);
        this.f6388j = TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "http_dns_enabled", 0);
        this.f6389k = TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "chromium_boot_failures", 0);
        int r8 = TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "query_filter_enabled", Integer.MIN_VALUE);
        String r1 = TTNetInit.getTTNetDepend().h(TTNetInit.getTTNetDepend().getContext(), "query_filter_actions", "");
        d.b.h.a.a.j.d.f().k(TTNetInit.getTTNetDepend().h(TTNetInit.getTTNetDepend().getContext(), "L0_params", ""));
        if (r8 == Integer.MIN_VALUE) goto L15;
        d.b.h.a.a.j.d r2 = d.b.h.a.a.j.d.f();
        if (r8 <= 0) goto L12;
        boolean r9 = true;
    L13:
        r2.d(r9);
        d.b.h.a.a.j.d.f().g(r1);
        goto L15
    L12:
        r9 = false;
    L15:
        if (TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "private_protocol_enabled", 1) < 1) goto L17;
        boolean r10 = true;
    L18:
        d.b.h.a.a.h.g.S(r10);
        if (TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "disable_rotating_host_path_retry", -1) < 1) goto L21;
        r4 = true;
    L21:
        d.b.h.a.a.h.g.Q(r4);
        return;
    L17:
        r10 = false;
    L6:
        com.bytedance.ttnet.q.a.e(true);
    }

    @Override // d.b.h.b.a.a.InterfaceC0365a
    public boolean c() {
        if (this.f6386h <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // d.b.h.b.a.a.InterfaceC0365a
    public boolean d() {
        if (this.f6387i <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // d.b.h.a.a.h.g.j
    public List<String> e(CookieManager r9, d.b.h.a.a.h.m.c r10, URI r11) {
        if (r11 == null) goto L41;
        if (r9 != null) goto L44;
        if (r10 == null) goto L41;
    L44:
        String r1 = r11.getHost();     // Catch: Exception -> L9
    L10:
        ArrayList r2 = new ArrayList();
        String[] r3 = this.f6384f.split(",");
        int r4 = r3.length;
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L17;
        String r6 = r3[r5];
        if (com.bytedance.common.utility.k.c(r6) == true) goto L15;
        r2.add(r6);
    L15:
        r5 = r5 + 1;
        goto L11
    L17:
        if (com.bytedance.common.utility.k.c(r1) == true) goto L41;
        if (b(r1, r2) == false) goto L41;
        if (com.bytedance.common.utility.k.c(TTNetInit.getTTNetDepend().k()) == false) goto L24;
        return null;
    L24:
        ArrayList r8 = new ArrayList();
        if (r9 == null) goto L30;
        String r12 = r9.getCookie(TTNetInit.getTTNetDepend().k());
        if (com.bytedance.common.utility.k.c(r12) == true) goto L30;
        r8.add(r12);
    L30:
        if (com.bytedance.common.utility.e.a(r8) == false) goto L53;
        if (r10 == null) goto L54;
        Map<String, List<String>> r13 = r10.get(URI.create(r11.getScheme() + "://" + TTNetInit.getTTNetDepend().k()), new LinkedHashMap());     // Catch: Throwable -> L43
        if (r13 != null) goto L35;
        return r8;
    L35:
        if (r13.isEmpty() == true) goto L56;
        List<String> r14 = r13.get("Cookie");     // Catch: Throwable -> L43
        if (r14 == null) goto L40;
        r14.add("x-tt-cookie-backup-source=1");     // Catch: Throwable -> L42
    L40:
        return r14;
    L56:
        return r8;
    L57:
        return r8;
    L54:
        return r8;
    L53:
        return r8;
    L9:
        r1 = null;
    L41:
        return null;
    }

    @Override // d.b.h.a.a.h.g.j
    public List<String> g(String r7) {
        ArrayList r0 = new ArrayList();
        String[] r1 = this.f6384f.split(",");
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        String r4 = r1[r3];
        if (com.bytedance.common.utility.k.c(r4) == true) goto L7;
        r0.add(r4);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        String r5 = TTNetInit.getTTNetDepend().k();
        if (com.bytedance.common.utility.k.c(r5) == true) goto L14;
        if (b(r5, r0) == true) goto L14;
        r0.add(r5);
    L14:
        if (b(r7, r0) == false) goto L16;
        return r0;
    L16:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.e.j.b
    public boolean h() {
        if (a.N == false) goto L6;
        return false;
    L6:
        if (this.f6388j <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.ttnet.d.c
    public boolean i() {
        if (a.N == false) goto L7;
        s.v(0);
        return false;
    L7:
        if (a.P == false) goto L12;
        int r2 = 8;
    L9:
        s.v(r2);
        return false;
    L12:
        if (a.y() == false) goto L15;
        return false;
    L15:
        if (a.L == true) goto L20;
        if (this.f6389k <= 5) goto L20;
        r2 = 3;
    L20:
        if (TTNetInit.getTTNetDepend().g() == true) goto L22;
        r2 = 6;
        goto L9
    L22:
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.e.j.a
    public boolean isCronetBootFailureExpected() {
        if (a.L == false) goto L6;
        return true;
    L6:
        if (TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "chromium_boot_failures", 0) > 5) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // d.b.h.b.a.a.InterfaceC0365a
    public boolean k() {
        if (this.f6385g <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}

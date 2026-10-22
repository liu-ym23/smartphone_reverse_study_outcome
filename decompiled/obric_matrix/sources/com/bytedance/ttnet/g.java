package com.bytedance.ttnet;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import d.b.h.a.a.h.s.l;
import d.b.r.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g implements c0.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile g f6324c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f6325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f6326b;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final List<String> f6329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final List<String> f6330d;

        a(int r3, int r4, List<String> r5, List<String> r6) {
            ArrayList r0 = new ArrayList();
            this.f6329c = r0;
            ArrayList r1 = new ArrayList();
            this.f6330d = r1;
            this.f6327a = r3;
            this.f6328b = r4;
            r0.addAll(r5);
            r1.addAll(r6);
        }
    }

    public g() {
        this.f6325a = new CopyOnWriteArrayList();
        this.f6326b = new AtomicBoolean(false);
    }

    public static g c() {
        if (f6324c != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6324c != null) goto L9;
        f6324c = new g();     // Catch: Throwable -> L11
        c0.w(f6324c);     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f6324c;
    }

    @Override // d.b.r.c0.d
    public boolean a(d.b.r.h0.c r2) {
        if ((r2.t() instanceof d.b.h.a.a.h.c) == false) goto L10;
        int r1 = ((d.b.h.a.a.h.c) r2.t()).n;
        if ((r1 & 256) <= 0) goto L7;
    L8:
        return true;
    L7:
        if ((r1 & 512) > 0) goto L8;
        return false;
    L10:
        return false;
    }

    @Override // d.b.r.c0.d
    public d.b.r.h0.c b(d.b.r.h0.c r7) {
        if (r7 != null) goto L4;
        return r7;
    L4:
        if (this.f6326b.get() == false) goto L80;
        Iterator<a> r6 = this.f6325a.iterator();
    L7:
        boolean r1 = true;
        if (r6.hasNext() == false) goto L39;
        a r0 = r6.next();
        Iterator<String> r3 = r0.f6329c.iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        if (l.i(r7.w(), r3.next()) == false) goto L11;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L7;
        List<String> r5 = r0.f6330d;
        if (r5 == null) goto L7;
        Iterator<String> r8 = r5.iterator();
    L23:
        if (r8.hasNext() == false) goto L29;
        String r9 = r8.next();
        if (r7.A() == null) goto L23;
        if (r7.A().startsWith(r9) == false) goto L23;
    L30:
        if (r1 == false) goto L7;
        if (r7.t() != null) goto L36;
        d.b.r.h0.c.a r10 = r7.O();
        r10.g(new d.b.h.a.a.h.c());
        r7 = r10.a();
    L36:
        if ((r7.t() instanceof d.b.h.a.a.h.c) == false) goto L7;
        d.b.h.a.a.h.c r2 = (d.b.h.a.a.h.c) r7.t();
        r2.s |= r0.f6327a;
        r2.n = r0.f6328b | r2.n;
        d.b.r.h0.c.a r11 = r7.O();
        r11.g(r2);
        r7 = r11.a();
        goto L7
    L29:
        r1 = false;
        goto L30
    L15:
        r4 = false;
        goto L16
    L39:
        if ((r7.t() instanceof d.b.h.a.a.h.c) == false) goto L78;
        int r12 = ((d.b.h.a.a.h.c) r7.t()).n;
        if ((r12 & 512) <= 0) goto L43;
        boolean r13 = true;
    L45:
        if ((r12 & 1024) > 0) goto L48;
        r1 = false;
    L48:
        if (r13 == true) goto L50;
        if (r1 == true) goto L50;
        return r7;
    L50:
        d.b.r.h0.c.a r14 = r7.O();
        ArrayList r15 = new ArrayList();
        r15.addAll(r7.v());
        if (r13 == false) goto L53;
        r15.add(new d.b.r.h0.b("x-metasec-bypass-ttnet-features", LocationInfoConst.ALLOW_USE_LOCATION));
    L53:
        if (r1 == false) goto L55;
        r15.add(new d.b.r.h0.b("x-tt-bypass-dp", LocationInfoConst.ALLOW_USE_LOCATION));
    L55:
        r14.b(r15);
        return r14.a();
    L43:
        r13 = false;
        goto L45
    L78:
        return r7;
    L80:
        return r7;
    }

    public void d(JSONObject r13) {
        JSONArray r0 = r13.optJSONArray("request_flag_control");
        if (r0 != null) goto L5;
        return;
    L5:
        this.f6326b.set(false);
        this.f6325a.clear();
        ArrayList r1 = new ArrayList();     // Catch: JSONException -> L36
        int r3 = 0;
    L8:
        if (r3 >= r0.length()) goto L31;
        JSONObject r4 = r0.getJSONObject(r3);     // Catch: JSONException -> L36
        int r5 = r4.optInt("cronet_flags");     // Catch: JSONException -> L36
        int r6 = r4.optInt("ttnet_flags");     // Catch: JSONException -> L36
        JSONArray r7 = r4.optJSONArray("prefix_group");     // Catch: JSONException -> L36
        JSONArray r8 = r4.optJSONArray("host_group");     // Catch: JSONException -> L36
        ArrayList r9 = new ArrayList();     // Catch: JSONException -> L36
        if (r7 == null) goto L16;
        int r10 = 0;
    L14:
        if (r10 >= r7.length()) goto L16;
        r9.add(r7.optString(r10, ""));     // Catch: JSONException -> L36
        r10 = r10 + 1;     // Catch: JSONException -> L36
    L16:
        ArrayList r11 = new ArrayList();     // Catch: JSONException -> L36
        if (r8 == null) goto L22;
        int r12 = 0;
    L20:
        if (r12 >= r8.length()) goto L22;
        r11.add(r8.optString(r12, ""));     // Catch: JSONException -> L36
        r12 = r12 + 1;     // Catch: JSONException -> L36
    L22:
        if (r5 > 0) goto L25;
        if (r6 > 0) goto L25;
    L29:
        r3 = r3 + 1;     // Catch: JSONException -> L36
    L25:
        if (r9.isEmpty() == true) goto L29;
        if (r11.isEmpty() == true) goto L29;
        r1.add(new a(r5, r6, r11, r9));     // Catch: JSONException -> L36
        Logger.debug();     // Catch: JSONException -> L36
        goto L29
    L31:
        if (r13.optInt("req_flag_ctl_enabled") > 0) goto L33;
        return;
    L33:
        if (r1.size() <= 0) goto L47;
        this.f6325a.addAll(r1);     // Catch: JSONException -> L36
        this.f6326b.set(true);     // Catch: JSONException -> L36
        return;
    L47:
        return;
    }
}

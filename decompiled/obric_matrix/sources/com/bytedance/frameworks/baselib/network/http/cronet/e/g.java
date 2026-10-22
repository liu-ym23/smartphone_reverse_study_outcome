package com.bytedance.frameworks.baselib.network.http.cronet.e;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile g f4724c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f4725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<a> f4726b;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<String> f4727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final List<String> f4728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<String> f4729c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        List<String> f4730d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        List<Pattern> f4731e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Set<Integer> f4732f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f4733g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f4734h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        String f4735i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile int f4736j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile long f4737k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f4738l;
        int m;
        boolean n;
        boolean o;
        String p;
        boolean q;
        int r;

        public a(List<String> r2, List<String> r3) {
            this.q = false;
            this.r = 0;
            this.f4727a = r2;
            this.f4728b = r3;
            this.f4737k = SystemClock.uptimeMillis();
            this.f4736j = 0;
            this.f4734h = Integer.MAX_VALUE;
            this.f4733g = 0;
            this.f4738l = false;
            this.f4735i = UUID.randomUUID().toString();
            this.n = false;
            this.m = 4000;
            this.o = true;
            this.p = null;
        }

        public List<String> a() {
            return this.f4728b;
        }

        public String b() {
            return this.f4735i;
        }
    }

    static {
    }

    private g() {
        this.f4725a = 0;
        this.f4726b = new CopyOnWriteArrayList();
    }

    private a a(String r3) {
        Iterator<a> r2 = this.f4726b.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        a r0 = r2.next();
        if (r0.b().equals(r3) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    public static g d() {
        if (f4724c != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4724c != null) goto L9;
        f4724c = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f4724c;
    }

    private static boolean f(List<?> r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean g(d.b.r.h0.c r5, a r6) {
        if (r6.f4733g <= 0) goto L8;
        if (r6.f4738l == false) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(r5.G()) == false) goto L10;
        return false;
    L10:
        Iterator<String> r4 = r6.f4727a.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        if (d.b.h.a.a.h.s.l.i(r5.w(), r4.next()) == false) goto L12;
        boolean r7 = true;
    L17:
        if (r7 == true) goto L20;
        Logger.debug();
        return false;
    L20:
        String r8 = r5.A();
        if (TextUtils.isEmpty(r8) == false) goto L24;
        return false;
    L24:
        if (f(r6.f4729c) == true) goto L32;
        Iterator<String> r9 = r6.f4729c.iterator();
    L27:
        if (r9.hasNext() == false) goto L32;
        if (r8.equals(r9.next()) == false) goto L27;
        return true;
    L32:
        if (f(r6.f4730d) == true) goto L40;
        Iterator<String> r10 = r6.f4730d.iterator();
    L35:
        if (r10.hasNext() == false) goto L40;
        if (r8.startsWith(r10.next()) == false) goto L35;
        return true;
    L40:
        if (f(r6.f4731e) == true) goto L49;
        Iterator<Pattern> r11 = r6.f4731e.iterator();
    L43:
        if (r11.hasNext() == false) goto L49;
        Pattern r12 = r11.next();
        if (r12 == null) goto L43;
        if (r12.matcher(r8).matches() == false) goto L43;
        return true;
    L49:
        return false;
    L16:
        r7 = false;
        goto L17
    }

    private static boolean j(JSONObject r2, String r3, List<String> r4) {
        int r0 = 0;
        if (r2 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L19;
        if (r4 == null) goto L19;
        JSONArray r5 = r2.optJSONArray(r3);
        if (r5 != null) goto L12;
        return false;
    L12:
        if (r0 >= r5.length()) goto L17;
        String r6 = r5.optString(r0);
        if (TextUtils.isEmpty(r6) == true) goto L16;
        r4.add(r6);
    L16:
        r0 = r0 + 1;
        goto L12
    L17:
        return true;
    }

    private void k(JSONObject r9) {
        ArrayList r0 = new ArrayList();
        j(r9, "host_group", r0);
        ArrayList r1 = new ArrayList();
        j(r9, "concurrent_hosts", r1);
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        if (r1.size() < 2) goto L57;
        a r2 = new a(r0, r1);
        ArrayList r3 = new ArrayList();
        if (j(r9, "equal_group", r3) == false) goto L10;
        r2.f4729c = r3;
    L10:
        ArrayList r4 = new ArrayList();
        if (j(r9, "prefix_group", r4) == false) goto L13;
        r2.f4730d = r4;
    L13:
        ArrayList r5 = new ArrayList();
        JSONArray r6 = r9.optJSONArray("pattern_group");
        int r7 = 0;
        if (r6 == null) goto L23;
        int r8 = 0;
    L17:
        if (r8 >= r6.length()) goto L22;
        String r10 = r6.optString(r8);
        if (TextUtils.isEmpty(r10) == true) goto L21;
        r5.add(Pattern.compile(r10, 2));     // Catch: Throwable -> L49
    L21:
        r8 = r8 + 1;
        goto L17
    L22:
        r2.f4731e = r5;
    L23:
        r2.f4734h = r9.optInt("fail_count", Integer.MAX_VALUE);
        r2.f4733g = r9.optInt("forbid_seconds", 0);
        r2.m = r9.optInt("connect_interval_millis", 4000);
        boolean r11 = true;
        if (r9.optInt("bypass_rs_enabled", 1) <= 0) goto L26;
        boolean r12 = true;
    L27:
        r2.o = r12;
        String r13 = r9.optString("concurrent_route");
        r2.p = r13;
        if (TextUtils.isEmpty(r13) == false) goto L31;
        r2.p = r9.optString("rs_name", null);
    L31:
        if (r9.optInt("fin_fix_enabled", 0) <= 0) goto L33;
        boolean r14 = true;
    L34:
        r2.q = r14;
        r2.r = r9.optInt("max_wait_seconds", 0);
        if (r2.m > 0) goto L38;
        return;
    L38:
        if (r9.optInt("retry_for_not_2xx_code", 0) > 0) goto L41;
        r11 = false;
    L41:
        r2.n = r11;
        HashSet r15 = new HashSet();
        JSONArray r16 = r9.optJSONArray("block_code_list");
        if (r16 != null) goto L44;
    L47:
        this.f4726b.add(r2);
        return;
    L44:
        if (r7 >= r16.length()) goto L46;
        r15.add(Integer.valueOf(r16.optInt(r7)));
        r7 = r7 + 1;
        goto L44
    L46:
        r2.f4732f = r15;
        goto L47
    L33:
        r14 = false;
        goto L34
    L26:
        r12 = false;
        goto L27
    }

    private void l() {
        Iterator<a> r5 = this.f4726b.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        a r0 = r5.next();
        if (r0.f4738l == false) goto L4;
        if ((SystemClock.uptimeMillis() - r0.f4737k) <= (r0.f4733g * 1000)) goto L10;
        r0.f4738l = false;
    L10:
        Logger.debug();
        goto L4
    }

    private void m(a r3, boolean r4) {
        Logger.debug();
        int r2 = r3.f4736j;
        if (r4 == false) goto L10;
        if (r2 == 0) goto L6;
    L8:
        r3.f4736j = 0;
        r3.f4738l = false;
        return;
    L6:
        if (r3.f4738l == true) goto L8;
        return;
    L10:
        int r5 = r2 + 1;
        r3.f4736j = r5;
        if (r5 >= r3.f4734h) goto L14;
        return;
    L14:
        if (r3.f4738l == true) goto L16;
        r3.f4738l = true;
        r3.f4737k = SystemClock.uptimeMillis();
    L16:
        Logger.debug();
    }

    public a b(d.b.r.h0.c r4) {
        l();
        Iterator<a> r0 = this.f4726b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        a r1 = r0.next();
        if (g(r4, r1) == false) goto L4;
        return r1;
    L8:
        return null;
    }

    public boolean c(int r3, String r4) {
        if (r3 != 0) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L14;
        a r2 = a(r4);
        if (r2 == null) goto L14;
        Set<Integer> r5 = r2.f4732f;
        if (r5 == null) goto L14;
        return r5.contains(Integer.valueOf(r3));
    }

    public boolean e() {
        if (this.f4725a <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void h(String r2, boolean r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        a r4 = a(r2);
        if (r4 != null) goto L8;
        return;
    L8:
        m(r4, r3);
    }

    public void i(String r3) {
        Logger.debug();
        if (TextUtils.isEmpty(r3) == false) goto L12;
        return;
    L12:
        JSONObject r0 = new JSONObject(r3);     // Catch: Throwable -> L10
        int r1 = 0;
        this.f4725a = r0.optInt("enabled_v2", 0);     // Catch: Throwable -> L10
        this.f4726b.clear();     // Catch: Throwable -> L10
        JSONArray r4 = r0.getJSONArray("match_rules");     // Catch: Throwable -> L10
    L7:
        if (r1 >= r4.length()) goto L15;
        k((JSONObject) r4.get(r1));     // Catch: Throwable -> L10
        r1 = r1 + 1;
        goto L7
    L15:
        return;
    L10:
        Logger.debug();
    }
}

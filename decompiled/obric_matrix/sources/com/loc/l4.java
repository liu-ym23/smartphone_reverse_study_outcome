package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l4 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static l4 f7514i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f7515j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f7516k = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<String> f7518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private u3 f7519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private u3 f7520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f7522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f7523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7524h;

    final class a extends s1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f7525g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ l4 f7526h;

        a(l4 r1, int r2) {
            this.f7526h = r1;
            this.f7525g = r2;
        }

        @Override // com.loc.s1
        public final void b() {
            StringBuilder r3 = new StringBuilder("http://");
            r3.append(r4.I());
            r3.append("?host=dualstack-a.apilocate.amap.com&query=");
            if (this.f7525g != l4.f7516k) goto L5;
            int r4 = 6;
        L6:
            r3.append(r4);
            String r5 = r3.toString();
            m4 r6 = new m4();
            r6.L(r5);
            r6.M(r5);
            r6.d(t0.a.f7805j);
            r6.f(t0.c.f7814f);
            o0.b();     // Catch: Throwable -> L31
            JSONObject r7 = new JSONObject(new String(o0.c(r6).f7856a));     // Catch: Throwable -> L31
            String[] r8 = l4.i(r7.optJSONArray("ips"), l4.f7515j);     // Catch: Throwable -> L31
            if (r8 != null) goto L10;
        L14:
            String[] r9 = l4.i(r7.optJSONArray("ipsv6"), l4.f7516k);     // Catch: Throwable -> L31
            if (r9 == null) goto L22;
            if (r9.length <= 0) goto L22;
            if (l4.h(r9, l4.c(this.f7526h, l4.f7516k).d()) == true) goto L22;
            l4.c(this.f7526h, l4.f7516k).c(r9);     // Catch: Throwable -> L31
            l4.k(this.f7526h, l4.f7516k);     // Catch: Throwable -> L31
        L22:
            if (r7.has("ips") == true) goto L26;
            if (r7.has("ipsv6") == true) goto L26;
            return;
        L26:
            if (r7.has("ttl") == false) goto L42;
            int r0 = r7.getInt("ttl");     // Catch: Throwable -> L31
            if (r0 <= 30) goto L43;
            l4.a(this.f7526h, r0 * 1000);     // Catch: Throwable -> L31
            return;
        L43:
            return;
        L42:
            return;
        L10:
            if (r8.length <= 0) goto L14;
            if (l4.h(r8, l4.c(this.f7526h, l4.f7515j).d()) == true) goto L14;
            l4.c(this.f7526h, l4.f7515j).c(r8);     // Catch: Throwable -> L31
            l4.k(this.f7526h, l4.f7515j);     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            JSONObject r1 = new JSONObject();
            r1.put("key", "dnsError");     // Catch: Throwable -> L36
            r1.put("reason", th.getMessage());     // Catch: Throwable -> L36
        L34:
            y4.n(l4.b(this.f7526h), "O018", r1);
            return;
        L5:
            r4 = 4;
            goto L6
        }
    }

    static {
    }

    private l4(Context r3) {
        this.f7517a = 0;
        this.f7518b = new ArrayList();
        this.f7519c = new u3();
        this.f7520d = new u3();
        this.f7521e = 120000;
        this.f7524h = false;
        this.f7522f = r3;
    }

    static /* synthetic */ long a(l4 r0, long r1) {
        r0.f7521e = r1;
        return r1;
    }

    static /* synthetic */ Context b(l4 r0) {
        return r0.f7522f;
    }

    static /* synthetic */ u3 c(l4 r0, int r1) {
        return r0.j(r1);
    }

    public static synchronized l4 d(Context r2) {
        monitor-enter(l4.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f7514i != null) goto L7;
        f7514i = new l4(r2);     // Catch: Throwable -> L10
    L7:
        l4 r3 = f7514i;     // Catch: Throwable -> L10
        monitor-exit(l4.class);
        return r3;
    }

    static /* synthetic */ boolean h(String[] r0, String[] r1) {
        return m(r0, r1);
    }

    static /* synthetic */ String[] i(JSONArray r0, int r1) {
        return n(r0, r1);
    }

    private u3 j(int r2) {
        if (r2 != f7516k) goto L7;
        return this.f7520d;
    L7:
        return this.f7519c;
    }

    static /* synthetic */ void k(l4 r0, int r1) {
        r0.r(r1);
    }

    private synchronized void l(boolean r9, int r10) {
        monitor-enter(this);
        if (r9 == true) goto L11;
    L27:
        th = move-exception;
        throw th;
    L5:
        if (r4.G() == true) goto L11;
        if (this.f7524h == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (this.f7517a == 0) goto L21;
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L27
        long r2 = this.f7517a;     // Catch: Throwable -> L27
        if ((r0 - r2) >= this.f7521e) goto L18;
        monitor-exit(this);
        return;
    L18:
        if ((r0 - r2) >= 60000) goto L21;
        monitor-exit(this);
        return;
    L21:
        this.f7517a = System.currentTimeMillis();     // Catch: Throwable -> L27
        this.f7524h = true;     // Catch: Throwable -> L27
        StackTraceElement[] r11 = Thread.currentThread().getStackTrace();     // Catch: Throwable -> L27
        StringBuffer r1 = new StringBuffer();     // Catch: Throwable -> L27
        int r3 = r11.length;     // Catch: Throwable -> L27
        int r4 = 0;
    L22:
        if (r4 >= r3) goto L24;
        StackTraceElement r5 = r11[r4];     // Catch: Throwable -> L27
        r1.append(r5.getClassName() + "(" + r5.getMethodName() + ":" + r5.getLineNumber() + "),");     // Catch: Throwable -> L27
        r4 = r4 + 1;     // Catch: Throwable -> L27
        goto L22
    L24:
        r1.f().d(new a(this, r10));     // Catch: Throwable -> L27
        monitor-exit(this);
    }

    private static boolean m(String[] r5, String[] r6) {
        if (r5 != null) goto L5;
    L22:
        return false;
    L5:
        if (r5.length == 0) goto L22;
        if (r6 == null) goto L22;
        if (r6.length == 0) goto L22;
        if (r5.length == r6.length) goto L14;
        return false;
    L14:
        int r1 = r5.length;
        int r2 = 0;
    L15:
        if (r2 >= r1) goto L20;
        if (r5[r2].equals(r6[r2]) == false) goto L18;
        r2 = r2 + 1;
        goto L15
    L18:
        return false;
    L20:
        return true;
    }

    private static String[] n(JSONArray r6, int r7) {
        int r0 = 0;
        if (r6 == null) goto L18;
        if (r6.length() == 0) goto L18;
        int r1 = r6.length();
        String[] r2 = new String[r1];
    L8:
        if (r0 >= r1) goto L16;
        String r3 = r6.getString(r0);
        if (TextUtils.isEmpty(r3) == true) goto L15;
        if (r7 != f7516k) goto L14;
        r3 = "[" + r3 + "]";
    L14:
        r2[r0] = r3;
    L15:
        r0 = r0 + 1;
        goto L8
    L16:
        return r2;
    L18:
        return new String[0];
    }

    private static String o(int r1) {
        if (r1 != f7516k) goto L6;
        return "last_ip_6";
    L6:
        return "last_ip_4";
    }

    private void p(int r3) {
        if (j(r3).i() == false) goto L6;
        SharedPreferences.Editor r0 = z4.d(this.f7522f, "cbG9jaXA");
        z4.h(r0, o(r3));
        z4.g(r0);
        j(r3).b(false);
        return;
    }

    private String q(int r7) {
        int r0 = 0;
        l(false, r7);
        String[] r1 = j(r7).d();
        if (r1 != null) goto L5;
    L19:
        s(r7);
        return j(r7).e();
    L5:
        if (r1.length <= 0) goto L19;
        int r2 = r1.length;
    L8:
        if (r0 >= r2) goto L13;
        String r4 = r1[r0];
        if (this.f7518b.contains(r4) == false) goto L15;
        r0 = r0 + 1;
    L15:
        if (TextUtils.isEmpty(r4) == false) goto L17;
        return null;
    L17:
        j(r7).a(r4);
        return r4;
    L13:
        r4 = null;
        goto L15
    }

    private void r(int r3) {
        if (j(r3).d() != null) goto L5;
        return;
    L5:
        if (j(r3).d().length <= 0) goto L16;
        String r0 = j(r3).d()[0];
        if (r0.equals(this.f7523g) == false) goto L10;
        return;
    L10:
        if (this.f7518b.contains(r0) == true) goto L15;
        this.f7523g = r0;
        SharedPreferences.Editor r2 = z4.d(this.f7522f, "cbG9jaXA");
        z4.k(r2, o(r3), r0);
        z4.g(r2);
        return;
    L15:
        return;
    }

    private void s(int r5) {
        String r0 = z4.f(this.f7522f, "cbG9jaXA", o(r5), null);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        if (this.f7518b.contains(r0) == true) goto L9;
        j(r5).a(r0);
        j(r5).f(r0);
        j(r5).b(true);
        return;
    }

    public final String e(o4 r6, int r7) {
        if (r4.H() == true) goto L6;
        return null;
    L6:
        if (r6 == null) goto L27;
        String r1 = r6.j();     // Catch: Throwable -> L28
        String r2 = new URL(r1).getHost();     // Catch: Throwable -> L28
        if ("http://abroad.apilocate.amap.com/mobile/binary".equals(r1) == true) goto L27;
        if ("abroad.apilocate.amap.com".equals(r2) == true) goto L27;
        if ("apilocate.amap.com".equalsIgnoreCase(r2) == false) goto L15;
        String r3 = "httpdns.apilocate.amap.com";
    L17:
        if (j5.S(r3) == true) goto L19;
        return null;
    L19:
        String r5 = q(r7);     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r5) == true) goto L27;
        r6.c0(r1.replace(r2, r5));     // Catch: Throwable -> L28
        r6.b().put("host", r3);     // Catch: Throwable -> L28
        r6.d0(r3);     // Catch: Throwable -> L28
        if (r7 != f7516k) goto L24;
        boolean r8 = true;
    L25:
        r6.i(r8);     // Catch: Throwable -> L28
        return r5;
    L24:
        r8 = false;
        goto L25
    L15:
        r3 = r2;
    L27:
        return null;
    }

    public final void f(int r3) {
        if (j(r3).j() == true) goto L6;
        this.f7518b.add(j(r3).e());
        p(r3);
        l(true, r3);
        return;
    L6:
        p(r3);
    }

    public final void g(boolean r3, int r4) {
        j(r4).g(r3);
        if (r3 == false) goto L10;
        String r5 = j(r4).h();
        String r0 = j(r4).e();
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return;
    L7:
        if (r0.equals(r5) == true) goto L12;
        SharedPreferences.Editor r2 = z4.d(this.f7522f, "cbG9jaXA");
        z4.k(r2, o(r4), r0);
        z4.g(r2);
        return;
    L12:
        return;
    }
}

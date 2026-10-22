package d.b.h.a.a.h.m;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import d.b.r.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements d.b.r.h0.e, d.b.r.l0.c, h, j {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile boolean f13416j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile boolean f13417k = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected d.b.r.h0.c f13418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected d.b.h.a.a.h.b f13419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f13420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected volatile boolean f13421i;

    class a implements d.b.r.k0.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f13422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.b.h.a.a.h.b f13423b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f13424c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.b.r.h0.c f13425d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.b.r.h0.e f13426e;

        a(h r1, d.b.h.a.a.h.b r2, boolean r3, d.b.r.h0.c r4, d.b.r.h0.e r5) {
            this.f13422a = r1;
            this.f13423b = r2;
            this.f13424c = r3;
            this.f13425d = r4;
            this.f13426e = r5;
        }

        @Override // d.b.r.k0.i
        public String a() {
            return this.f13422a.o();
        }

        @Override // d.b.r.k0.i
        public InputStream d() {
            InputStream r0 = d.b.h.a.a.h.p.f.g(this.f13422a.k(), this.f13422a.u(), this.f13422a.p(), this.f13423b.Y);     // Catch: Exception -> L4
        L9:
            return new d.b.h.a.a.h.e(r0, this.f13426e);
        L4:
            e = move-exception;
            if (this.f13424c == false) goto L11;
            r0 = this.f13422a.n();
            goto L9
        L11:
            throw new d.b.h.a.a.h.l.d(this.f13422a.l(), "reason = " + this.f13422a.r() + "  exception = " + e.getMessage(), this.f13425d.A(), null);
        }
    }

    static {
    }

    protected b(d.b.r.h0.c r5) {
        boolean r0 = false;
        this.f13420h = false;
        this.f13421i = false;
        this.f13418f = r5;
        d.b.h.a.a.h.b r1 = d.b.h.a.a.h.b.a();
        this.f13419g = r1;
        r1.Y = r5.z();
        d.b.h.a.a.h.b r6 = this.f13419g;
        y r2 = r6.Y;
        if (r2 == null) goto L5;
        r6.f13359f = r2.p;
        r6.f13360g = r2.q;
    L5:
        r6.f13361h = System.currentTimeMillis();
        if (this.f13418f.N() == false) goto L8;
        d.b.h.a.a.h.b r7 = this.f13419g;
        r0 = true;
    L9:
        r7.G = r0;
        if ((this.f13418f.t() instanceof d.b.h.a.a.h.c) == false) goto L19;
        d.b.h.a.a.h.b r8 = this.f13419g;
        r8.f13358e = (T) this.f13418f.t();
        T r9 = this.f13419g.f13358e;
        this.f13420h = r9.o;
        List<d.b.h.a.a.h.c.C0358c> r10 = r9.C;
        if (r10 != null) goto L14;
        return;
    L14:
        if (r10.size() > 0) goto L16;
        return;
    L16:
        if (r10.size() > 3) goto L22;
        d.b.h.a.a.h.b r4 = this.f13419g;
        r4.T = new d.b.h.a.a.h.j(r10);
        return;
    L22:
        return;
    L19:
        return;
    L8:
        r7 = this.f13419g;
        goto L9
    }

    protected static void A(d.b.h.a.a.h.b r5, j r6) {
        if (r6 != null) goto L32;
    L4:
        y r7 = r5.Y;     // Catch: Throwable -> L31
        if (r7 == null) goto L34;
        r7.m = d.b.h.a.a.c.k().n;     // Catch: Throwable -> L31
        y r8 = r5.Y;     // Catch: Throwable -> L31
        r8.n = d.b.h.a.a.c.k().K;     // Catch: Throwable -> L31
        y r9 = r5.Y;     // Catch: Throwable -> L31
        r9.N = SystemClock.uptimeMillis();     // Catch: Throwable -> L31
        y r10 = r5.Y;     // Catch: Throwable -> L31
        r10.t = System.currentTimeMillis();     // Catch: Throwable -> L31
        y r11 = r5.Y;     // Catch: Throwable -> L31
        r11.k0 = "4.2.228.16-pico";     // Catch: Throwable -> L31
        r11.j0.put("sentByteCount", Long.valueOf(r5.x));     // Catch: Throwable -> L31
        r5.Y.j0.put("receivedByteCount", Long.valueOf(r5.y));     // Catch: Throwable -> L31
        JSONObject r12 = r5.F;     // Catch: Throwable -> L31
        long r0 = r5.N;     // Catch: Throwable -> L31
        if (r0 < 0) goto L9;
        r12.put("turing_callback", r0);     // Catch: Throwable -> L31
    L9:
        long r1 = r5.R;     // Catch: Throwable -> L31
        if (r1 < 0) goto L14;
        r12.put("retry_for_account_cost", r1);     // Catch: Throwable -> L31
    L14:
        if (r5.O == false) goto L17;
        r12.put("turing_retry", LocationInfoConst.ALLOW_USE_LOCATION);     // Catch: Throwable -> L31
    L17:
        if (r5.Q == false) goto L19;
        r12.put("account_retry", LocationInfoConst.ALLOW_USE_LOCATION);     // Catch: Throwable -> L31
    L19:
        String r2 = r5.P;     // Catch: Throwable -> L31
        if (r2 == null) goto L22;
        r12.put("retry_by_header", r2);     // Catch: Throwable -> L31
    L22:
        d.b.h.a.a.h.j r3 = r5.T;     // Catch: Throwable -> L31
        if (r3 == null) goto L29;
        JSONObject r4 = r3.a();     // Catch: Throwable -> L31
        if (r4 == null) goto L29;
        if (r4.length() <= 0) goto L29;
        r12.put("rotation_host_retry", r4);     // Catch: Throwable -> L31
        r5.Y.H0 = r4;     // Catch: Throwable -> L31
    L29:
        r12.put("retrofit", r5.Y.f());     // Catch: Throwable -> L31
        return;
    L35:
        return;
    L34:
        return;
    L32:
        r6.b(r5);     // Catch: Throwable -> L31
        goto L4
    }

    private static boolean C(d.b.h.a.a.h.b r0) {
        if (r0 == null) goto L8;
        T r1 = r0.f13358e;
        if (r1 == 0) goto L8;
        if (r1.m == false) goto L8;
        return true;
    L8:
        return false;
    }

    private static boolean D(d.b.h.a.a.h.b r0) {
        if (r0 == null) goto L8;
        T r1 = r0.f13358e;
        if (r1 == 0) goto L8;
        if (r1.f13375j == false) goto L8;
        return true;
    L8:
        return false;
    }

    protected static String J(d.b.h.a.a.h.b r8, Map<String, List<String>> r9, int r10, InputStream r11, String r12, boolean r13) {
        if (r11 != null) goto L42;
        return null;
    L42:
    L36:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L34
    L6:
        if (r8.f13355b == false) goto L8;
        byte[] r14 = d.b.h.a.a.h.p.f.j(r13, r9, r10, r11, r8.Y);     // Catch: Throwable -> L34 Exception -> L36
    L14:
        d.b.h.a.a.h.p.f.l(r11);
        if (r14.length > 0) goto L17;
        return null;
    L17:
        if (com.bytedance.common.utility.k.c(r12) == false) goto L19;
        return null;
    L19:
        if (Logger.debug() == false) goto L21;
    L43:
        d.b.h.a.a.h.p.b r15 = new d.b.h.a.a.h.p.b(r12);     // Catch: Throwable -> L41
        if ("text".equalsIgnoreCase(r15.c()) == false) goto L25;
    L26:
        String r16 = r15.b("charset");     // Catch: Throwable -> L41
        if (com.bytedance.common.utility.k.c(r16) == false) goto L30;
        r16 = "utf-8";
    L30:
        if (Q(r8) == false) goto L50;
        return new String(r14, r16);
    L50:
        return null;
    L25:
        if ("application/json".equalsIgnoreCase(r15.a()) == true) goto L26;
        return null;
    L51:
        return null;
    L21:
        if (Q(r8) == true) goto L43;
        return null;
    L8:
        int[] r1 = new int[1];     // Catch: Throwable -> L34 Exception -> L36
        byte[] r17 = d.b.h.a.a.h.p.f.h(r13, r9, r10, r11, r1, r8.Y);     // Catch: Throwable -> L34 Exception -> L36
        byte[] r18 = new byte[r1[0]];     // Catch: Throwable -> L34 Exception -> L36
        if (r17 != null) goto L11;
    L13:
        r14 = r18;
        goto L14
    L11:
        if (r1[0] <= 0) goto L13;
        System.arraycopy(r17, 0, r18, 0, r1[0]);     // Catch: Throwable -> L34 Exception -> L36
    L34:
        th = move-exception;
        d.b.h.a.a.h.p.f.l(r11);
        throw th;
    }

    protected static byte[] K(String r9, int r10, d.b.h.a.a.h.b r11, h r12, j r13) {
        if (r12.l() != 200) goto L5;
    L25:
        r11.f13365l = System.currentTimeMillis();
        InputStream r0 = r12.k();     // Catch: Exception -> L28
    L59:
    L51:
        th = move-exception;
        d.b.h.a.a.h.p.f.l(r0);
        throw th;
    L53:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L51
    L33:
        if (r11.f13355b == false) goto L36;
        byte[] r14 = d.b.h.a.a.h.p.f.j(r12.p(), r12.u(), r10, r0, r11.Y);     // Catch: Throwable -> L51 Exception -> L53
    L46:
        d.b.h.a.a.h.p.f.l(r0);
        if (d.b.h.a.a.h.p.f.n(r12.o()) == false) goto L49;
        d.b.h.a.a.h.p.f.a(r14, r14.length);
    L49:
        r11.m = System.currentTimeMillis();
        r11.f13364k = d.b.h.a.a.h.a.b();
        A(r11, r13);
        d.b.h.a.a.h.g.t(r9, r11);
        return r14;
    L36:
        if (f13416j == true) goto L38;
    L40:
        int[] r7 = new int[1];     // Catch: Throwable -> L51 Exception -> L53
        byte[] r15 = d.b.h.a.a.h.p.f.h(r12.p(), r12.u(), r10, r0, r7, r11.Y);     // Catch: Throwable -> L51 Exception -> L53
        byte[] r2 = new byte[r7[0]];     // Catch: Throwable -> L51 Exception -> L53
        if (r15 != null) goto L43;
    L45:
        r14 = r2;
        goto L46
    L43:
        if (r7[0] <= 0) goto L45;
        System.arraycopy(r15, 0, r2, 0, r7[0]);     // Catch: Throwable -> L51 Exception -> L53
        goto L45
    L38:
        if (f13417k == false) goto L40;
        r14 = d.b.h.a.a.h.p.f.i(r12.p(), r12.u(), r10, r0, r11.Y);     // Catch: Throwable -> L51 Exception -> L53
    L28:
        e = move-exception;
        if (D(r11) == false) goto L58;
        r0 = r12.n();
        goto L59
    L58:
        throw e;
    L5:
        if (D(r11) == true) goto L25;
        if (r12.l() != 304) goto L10;
        r11.f13365l = System.currentTimeMillis();
        r11.m = System.currentTimeMillis();
        r11.f13364k = d.b.h.a.a.h.a.b();
        A(r11, r13);
        d.b.h.a.a.h.g.t(r9, r11);
    L10:
        String r16 = null;
        InputStream r1 = r12.k();     // Catch: Throwable -> L13 Exception -> L15
    L12:
        InputStream r5 = r1;
        if (r5 == null) goto L18;
        r16 = J(r11, r12.u(), r10, r5, r12.o(), r12.p());     // Catch: Throwable -> L13
    L18:
        r12.t();     // Catch: Throwable -> L13
        String r17 = "";
    L21:
        d.b.h.a.a.h.l.d r3 = new d.b.h.a.a.h.l.d(r12.l(), r17, d.b.h.a.a.h.l.d.b(r9), r16);
        if (r12.l() != 304) goto L65;
        r3.a(true, true, false, r9, r11.Z, r11);
        throw r3;
    L65:
        throw r3;
    L15:
        r1 = r12.n();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r17 = "reason = " + r12.r() + "  exception = " + th.getMessage();
        goto L21
    }

    protected static d.b.r.k0.i L(String r7, d.b.r.h0.c r8, d.b.h.a.a.h.b r9, h r10, j r11, d.b.r.h0.e r12, boolean r13) {
        if (r8.N() == false) goto L30;
        boolean r14 = D(r9);
        if (r10.l() >= 200) goto L7;
    L8:
        if (r14 == false) goto L13;
    L9:
        d.b.r.k0.i r15 = j(r8, r9, r10, r12, r14);
        if (r15 != null) goto L36;
        if (r13 == true) goto L38;
        return r15;
    L38:
        return new d.b.r.k0.g(r10.o(), new byte[0], new String[0]);
    L36:
        return r15;
    L13:
        String r16 = null;
        InputStream r17 = r10.k();     // Catch: Throwable -> L16 Exception -> L18
    L15:
        InputStream r3 = r17;
        if (r3 == null) goto L21;
        r16 = J(r9, r10.u(), r8.x(), r3, r10.o(), r10.p());     // Catch: Throwable -> L16
    L21:
        r10.t();
        String r18 = "";
    L24:
        d.b.h.a.a.h.l.d r19 = new d.b.h.a.a.h.l.d(r10.l(), r18, r8.A(), r16);
        r9.V.set(true);
        r19.a(true, true, false, r7, r9.Z, r9);
        throw r19;
    L18:
        r17 = r10.n();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r18 = "reason = " + r10.r() + "  exception = " + th.getMessage();     // Catch: Throwable -> L26
        r10.t();
    L26:
        th = move-exception;
        r10.t();
        throw th;
    L7:
        if (r10.l() < 300) goto L9;
    L30:
        return new d.b.r.k0.g(r10.o(), K(r7, r8.x(), r9, r10, r11), new String[0]);
    }

    public static void O(boolean r0) {
        f13416j = r0;
    }

    public static void P(boolean r0) {
        f13417k = r0;
    }

    private static boolean Q(d.b.h.a.a.h.b r0) {
        if (r0 == null) goto L8;
        T r1 = r0.f13358e;
        if (r1 == 0) goto L8;
        if (r1.f13377l == false) goto L8;
        return true;
    L8:
        return false;
    }

    protected static void R(d.b.r.h0.c r4, d.b.h.a.a.h.b r5) {
        long r0 = SystemClock.uptimeMillis();
        d.b.h.a.a.h.g.c0();
        if (d.b.h.a.a.h.g.v(r4.t()) == true) goto L5;
        d.b.h.a.a.h.g.d0();
    L5:
        y r6 = r5.Y;
        if (r6 == null) goto L9;
        r6.A0 = SystemClock.uptimeMillis() - r0;
        return;
    }

    private void S(d.b.r.h0.c r8, int r9, d.b.h.a.a.h.b r10, h r11, IOException r12, boolean r13) {
        d.b.h.a.a.h.i r14 = d.b.h.a.a.h.g.Y(r8, r9, r10, r8.v(), null, r13, false);
        if (r14 != null) goto L5;
        throw r12;
    L5:
        if (r14.d() == true) goto L7;
        throw r12;
    L7:
        if (r10.S == false) goto L12;
        d.b.r.h0.c.a r15 = r8.O();
        r15.h(r14.b());
        M(r15.a(), r10, r11, r14.a());
        return;
    L12:
        throw r12;
    }

    protected static void T(String r3, d.b.h.a.a.h.b r4, h r5, j r6, Exception r7) {
        String r0 = w(r5.u());     // Catch: Throwable -> L20
        if (com.bytedance.common.utility.k.c(r0) == true) goto L5;
        r4.F.put("response-headers", r0);     // Catch: Throwable -> L20
    L5:
        String r1 = r7.getMessage();     // Catch: Throwable -> L20
        Throwable r2 = r7.getCause();     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r1) == true) goto L11;
        if (r2 == null) goto L11;
        if (TextUtils.isEmpty(r2.getMessage()) == true) goto L11;
        r1 = r1 + ", cause = " + r2.getMessage();     // Catch: Throwable -> L20
    L11:
        r4.F.put("ex", r1);     // Catch: Throwable -> L20
    L12:
        r5.t();
        if (com.bytedance.common.utility.k.c(r4.f13357d) == false) goto L15;
        z(y(r7), r4);
    L15:
        r4.m = System.currentTimeMillis();
        if (r4.G == false) goto L18;
        r4.V.set(true);
    L18:
        A(r4, r6);
        d.b.h.a.a.h.g.s(r3, r7, r4);
    }

    protected static void g(boolean r1, Context r2, String r3) {
        if (r1 == true) goto L9;
        if (r2 != null) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.i.o(r2) == false) goto L8;
        return;
    L8:
        throw new d.b.h.a.a.h.l.e("network not available for " + r3);
    }

    protected static List<d.b.r.h0.b> i(h r6, List<String> r7) {
        Map<String, List<String>> r8 = r6.u();
        if (r8 != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r9 = r8.entrySet().iterator();
    L8:
        if (r9.hasNext() == false) goto L26;
        Map.Entry<String, List<String>> r1 = r9.next();
        String r2 = r1.getKey();
        if (r2 == null) goto L22;
        if (r7 == null) goto L22;
        if (r7.isEmpty() == true) goto L22;
        boolean r3 = false;
        Iterator<String> r4 = r7.iterator();
    L16:
        if (r4.hasNext() == false) goto L20;
        if (r2.equalsIgnoreCase(r4.next()) == false) goto L16;
        r3 = true;
    L20:
        if (r3 == true) goto L8;
    L22:
        Iterator<String> r5 = r1.getValue().iterator();
    L24:
        if (r5.hasNext() == false) goto L8;
        r0.add(new d.b.r.h0.b(r2, r5.next()));
        goto L24
    L26:
        return r0;
    }

    protected static d.b.r.k0.i j(d.b.r.h0.c r7, d.b.h.a.a.h.b r8, h r9, d.b.r.h0.e r10, boolean r11) {
        if (r9.q() != 0) goto L7;
        r10.cancel();
        return null;
    L7:
        return new a(r9, r8, r11, r7, r10);
    }

    private static String w(Map<String, List<String>> r8) {
        if (r8 != null) goto L36;
    L34:
        return "";
    L36:
        if (r8.isEmpty() == true) goto L34;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L35
        Iterator<Map.Entry<String, List<String>>> r9 = r8.entrySet().iterator();     // Catch: Throwable -> L35
    L9:
        if (r9.hasNext() == false) goto L32;
        Map.Entry<String, List<String>> r2 = r9.next();     // Catch: Throwable -> L35
        if (r2 == null) goto L9;
        String r3 = r2.getKey();     // Catch: Throwable -> L35
        if (com.bytedance.common.utility.k.c(r3) == true) goto L9;
        List<String> r4 = r2.getValue();     // Catch: Throwable -> L35
        if (r4 == null) goto L9;
        if (r4.isEmpty() == true) goto L9;
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L35
        int r6 = 0;
        Iterator<String> r7 = r4.iterator();     // Catch: Throwable -> L35
    L23:
        if (r7.hasNext() == false) goto L31;
        String r10 = r7.next();     // Catch: Throwable -> L35
        if (com.bytedance.common.utility.k.c(r10) == true) goto L23;
        if (r6 != 0) goto L29;
    L28:
        r5.append(r10);     // Catch: Throwable -> L35
        r6 = r6 + 1;     // Catch: Throwable -> L35
        goto L23
    L29:
        r5.append("; ");     // Catch: Throwable -> L35
        goto L28
    L31:
        r1.put(r3, r5.toString());     // Catch: Throwable -> L35
        goto L9
    L32:
        return r1.toString();
    }

    private static String y(Exception r3) {
        if (r3 != null) goto L16;
        return "";
    L16:
        String r1 = r3.getMessage();     // Catch: Throwable -> L15
        if (r1 == null) goto L14;
        if (TextUtils.isEmpty(r3.getMessage()) == true) goto L14;
        String[] r4 = r1.split("\\|");     // Catch: Throwable -> L15
        if (r4.length < 2) goto L14;
        return r4[0];
    L14:
        return "";
    }

    private static void z(String r1, d.b.h.a.a.h.b r2) {
        if (com.bytedance.common.utility.k.c(r1) == false) goto L10;
        return;
    L10:
        r2.f13357d = r1;     // Catch: Throwable -> L9
        T r3 = r2.f13358e;     // Catch: Throwable -> L9
        if (r3 == 0) goto L12;
        r3.f13366a = r1;     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    protected int B(IOException r1) {
        return -1;
    }

    protected void E() {
    }

    protected void F(d.b.h.a.a.h.b r3, h r4) {
        r3.f13362i = System.currentTimeMillis();
        r3.W = d.b.h.a.a.h.a.e(r4.o());
        z(r4.m("x-net-info.remoteaddr"), r3);
        T r2 = r3.f13358e;
        if (r2 == 0) goto L5;
        r2.f13367b = r4.l();
    L5:
        String r5 = r4.m("X-TT-LOGID");
        r3.Z = r5;
        if (r5 != null) goto L8;
        r3.Z = "";
    L8:
        y r6 = r3.Y;
        if (r6 == null) goto L11;
        r6.m0 = r3.Z;
    L11:
        r3.A = r4.s();
    }

    protected void G(Exception r1) {
    }

    protected abstract void H(d.b.r.k0.i r1);

    protected abstract void I(String r1, d.b.r.h0.c r2, d.b.h.a.a.h.b r3, Map<String, String> r4);

    protected void M(d.b.r.h0.c r8, d.b.h.a.a.h.b r9, h r10, Map<String, String> r11) {
        r10.t();
        r9.U = System.currentTimeMillis();
        I(r8.G(), r8, r9, r11);
        v();     // Catch: IOException -> L5
        N(r8, r9, this, false, false);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        S(r8, B(e), r9, r10, e, false);
    }

    protected List<String> N(d.b.r.h0.c r8, d.b.h.a.a.h.b r9, h r10, boolean r11, boolean r12) {
        d.b.h.a.a.h.i r13 = d.b.h.a.a.h.g.Y(r8, r10.l(), r9, r8.v(), r10.u(), r11, r12);
        ArrayList r14 = null;
        if (r13 == null) goto L12;
        if (r13.d() == false) goto L12;
        if (r9.S == false) goto L9;
        d.b.r.h0.c.a r15 = r8.O();
        r15.h(r13.b());
        r8 = r15.a();
    L9:
        M(r8, r9, r10, r13.a());
        return null;
    L12:
        if (com.bytedance.common.utility.k.c(r9.P) == true) goto L19;
        if (r13 != null) goto L15;
    L16:
        r14 = new ArrayList();
        if (com.bytedance.common.utility.k.c(r9.P) == true) goto L19;
        r14.add(r9.P);
        goto L19
    L15:
        if (r13.c() == true) goto L16;
    L19:
        return r14;
    }

    protected abstract boolean e();

    @Override // d.b.r.h0.e
    public d.b.r.h0.d execute() {
        y r0 = this.f13419g.Y;
        if (r0 == null) goto L6;
        r0.s = System.currentTimeMillis();
    L6:
        if (this.f13421i == true) goto L69;
        E();
        R(this.f13418f, this.f13419g);
        g(e(), x(), this.f13418f.A());
        I(this.f13418f.G(), this.f13418f, this.f13419g, null);
        boolean r9 = false;
    L39:
        e = e;
    L70:
        G(e);     // Catch: Throwable -> L57
        if ((e instanceof d.b.h.a.a.h.l.d) == false) goto L47;
        if (((d.b.h.a.a.h.l.d) e).c() != 304) goto L47;
        throw e;     // Catch: Throwable -> L57
    L47:
        if ((e instanceof IOException) == true) goto L49;
    L52:
        T(this.f13418f.G(), this.f13419g, this, this, e);     // Catch: Throwable -> L57
        f(this.f13418f, e);     // Catch: Throwable -> L57
        if (this.f13418f.N() == false) goto L56;
        this.f13419g.V.set(true);     // Catch: Throwable -> L57
    L56:
        throw h(e);     // Catch: Throwable -> L57
    L49:
        if ("Canceled".equals(e.getMessage()) == false) goto L52;
        throw e;     // Catch: Throwable -> L57
    L57:
        th = th;
        boolean r11 = r9;
        r9 = true;
    L60:
        if (this.f13418f.N() == false) goto L62;
        if (r9 == true) goto L62;
    L64:
        if (this.f13418f.N() == true) goto L67;
        if (r11 == false) goto L67;
        d.b.h.a.a.f.d.c().e();
    L67:
        throw th;
    L62:
        t();
    L37:
        th = th;
        r11 = false;
        goto L60
    L9:
        if (this.f13418f.N() == true) goto L16;
        d.b.h.a.a.h.g.i r1 = d.b.h.a.a.h.g.j();     // Catch: Throwable -> L37 Exception -> L39
        if (r1 == null) goto L16;
        if (r1.a(this.f13418f.G()) == false) goto L16;
        d.b.h.a.a.f.d.c().d();     // Catch: Throwable -> L37 Exception -> L39
        r11 = true;
    L73:
        List<String> r12 = new ArrayList();     // Catch: Throwable -> L33 Exception -> L35
        v();     // Catch: IOException -> L20 Throwable -> L33 Exception -> L35
        r12 = N(this.f13418f, this.f13419g, this, true, false);     // Catch: IOException -> L20 Throwable -> L33 Exception -> L35
    L23:
        F(this.f13419g, this);     // Catch: Throwable -> L33 Exception -> L35
        String r2 = this.f13418f.G();     // Catch: Throwable -> L33 Exception -> L35
        d.b.r.h0.c r3 = this.f13418f;     // Catch: Throwable -> L33 Exception -> L35
        d.b.h.a.a.h.b r4 = this.f13419g;     // Catch: Throwable -> L33 Exception -> L35
        d.b.r.k0.i r5 = L(r2, r3, r4, this, this, this, C(r4));     // Catch: Throwable -> L33 Exception -> L35
        H(r5);     // Catch: Throwable -> L33 Exception -> L35
        d.b.r.h0.d r6 = new d.b.r.h0.d(this.f13418f.G(), l(), r(), i(this, r12), r5);     // Catch: Throwable -> L33 Exception -> L35
        r6.k(this.f13419g);     // Catch: Throwable -> L33 Exception -> L35
        r6.l(this.f13419g.Z);     // Catch: Throwable -> L33 Exception -> L35
    L25:
        if (this.f13418f.N() == true) goto L29;
        t();
    L29:
        if (this.f13418f.N() == true) goto L32;
        if (r11 == false) goto L32;
        d.b.h.a.a.f.d.c().e();
    L32:
        return r6;
    L20:
        e = move-exception;
        S(this.f13418f, B(e), this.f13419g, this, e, true);     // Catch: Throwable -> L33 Exception -> L35
    L35:
        e = e;
        r9 = r11;
    L33:
        th = th;
        goto L60
    L16:
        r11 = false;
        goto L73
    L69:
        throw new IOException("request canceled");
    }

    protected void f(d.b.r.h0.c r1, Exception r2) {
    }

    protected IOException h(Exception r2) {
        return new IOException(r2.getMessage(), r2.getCause());
    }

    protected abstract void v();

    protected abstract Context x();
}

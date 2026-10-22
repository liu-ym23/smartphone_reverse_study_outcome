package com.bytedance.sdk.account.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import d.b.s.a.l0.r;
import d.b.s.a.l0.s;
import d.b.s.a.q.j.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class l<R extends d.b.s.a.q.j.b> implements d.b.s.a.q.l.c, d.b.s.a.q.l.a {
    private static d.b.s.a.q.l.b s;
    private static n t;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Context f5618f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    protected d.b.s.a.w.a f5619g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected d.b.s.a.w.b f5620h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected com.ss.android.h f5621i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected d.b.s.a.q.j.a<R> f5622j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected com.bytedance.sdk.account.impl.b f5623k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected List<Integer> f5624l;
    private String m;
    private int n;
    boolean o;
    boolean p;
    String q;
    private boolean r;

    class a implements d.b.s.a.v.a.a.InterfaceC0400a {
        a(l r1, boolean r2, d.b.s.a.q.j.b r3) {
        }
    }

    static class b implements d.b.s.a.q.l.b {
        b() {
        }

        @Override // d.b.s.a.q.l.b
        public d.b.s.a.q.l.d a(d.b.s.a.q.l.c r2) {
            d r1 = new d(r2, null);
            r1.u();
            return r1;
        }
    }

    static class c implements n {
        c() {
        }

        @Override // com.bytedance.sdk.account.impl.n
        public void a(o r2) {
            Handler r1 = i.S(com.ss.android.i.j.k().e()).N();
            Message r0 = Message.obtain(r1, 100);
            r0.obj = r2;
            r1.sendMessage(r0);
        }
    }

    private static class d extends d.b.s.a.l0.a implements d.b.s.a.q.l.d {
        private d.b.s.a.q.l.c m;

        private d(d.b.s.a.q.l.c r1) {
            this.m = r1;
        }

        /* synthetic */ d(d.b.s.a.q.l.c r1, a r2) {
            this(r1);
        }

        @Override // d.b.s.a.c0.a.c, java.lang.Runnable
        public void run() {
            this.m.a();
        }
    }

    static {
        s = new b();
        t = new c();
    }

    public l(Context r2, @NonNull d.b.s.a.w.a r3, d.b.s.a.q.j.a r4) {
        this.f5624l = new ArrayList();
        this.n = 0;
        this.f5618f = r2.getApplicationContext();
        this.f5619g = r3;
        this.f5622j = r4;
        if (r4 == null) goto L5;
        r4.attachController(this);
    L5:
        d.b.s.a.w.b r5 = new d.b.s.a.w.b(r3);
        this.f5620h = r5;
        this.f5623k = new com.bytedance.sdk.account.impl.b(r3, r5);
    }

    private com.ss.android.h A(String r7, Map<String, String> r8, List<com.ss.android.f> r9, String r10, String r11) {
        HashMap r2 = new HashMap();
        d.b.s.a.e0.c r0 = d.b.s.a.l0.l.e(r7);
        if (r8 == null) goto L5;
        r2.putAll(r8);
    L5:
        r2.put("account_sdk_source", "app");
        r2.put("passport_support_flow", d.b.s.a.v.a.b.d());
        if (r9 != null) goto L8;
        r9 = new ArrayList();
    L8:
        List<com.ss.android.f> r5 = r9;
        if (com.ss.android.i.j.k().h() == false) goto L12;
        r2.put("multi_login", LocationInfoConst.ALLOW_USE_LOCATION);
        c(r5, r7);
    L12:
        if (q() == false) goto L14;
        b(r7, r5);
    L14:
        String r1 = r0.toString();
        this.f5620h.f14964d = r1;
        this.f5623k.c(System.currentTimeMillis());
        com.ss.android.h r12 = d.b.s.a.l0.l.g(Integer.MAX_VALUE, r1, r2, r10, r11, r5);
        this.f5623k.b(System.currentTimeMillis());
        return r12;
    }

    private d.b.s.a.w.a B(d.b.s.a.w.a r7) {
        Map<String, String> r6 = r7.f14946c;
        if (r6 != null) goto L5;
        return r7;
    L5:
        if (r6.isEmpty() == true) goto L49;
        com.bytedance.sdk.account.settings.e.a r8 = com.bytedance.sdk.account.settings.f.a.g();
        if (r8.g() == false) goto L45;
        String r0 = r7.f14946c.get(TypedValues.TransitionType.S_FROM);
        if (TextUtils.isEmpty(r0) == false) goto L12;
        return r7;
    L12:
        if (r8.b().contains(r0) == false) goto L50;
        String r1 = r.a(r7.f14944a);
        if (TextUtils.isEmpty(r1) == false) goto L17;
        return r7;
    L17:
        String r2 = r7.f14946c.get("token");
        if (TextUtils.isEmpty(r2) == false) goto L21;
        r2 = r7.f14946c.get("validate_token");
    L21:
        if (TextUtils.isEmpty(r2) == false) goto L23;
    L25:
        boolean r3 = false;
    L26:
        if (r3 == true) goto L28;
        return r7;
    L28:
        r7.f14952i |= 536870912;
        d.b.s.a.a0.a.d("BaseAccountApi", "processApiRequest(), set requestFlag:" + r7.f14952i + ", url=" + r7.f14944a);
        if (r8.h() == true) goto L31;
        return r7;
    L31:
        if (r8.e().contains(r0) == false) goto L48;
        String r9 = r8.d();
        if (TextUtils.isEmpty(r9) == false) goto L35;
        String r10 = "processApiRequest(), ipv4Host is empty";
    L40:
        d.b.s.a.a0.a.h("BaseAccountApi", r10);
        return r7;
    L35:
        String r4 = r7.f14944a;
        String r5 = Uri.parse(r4).buildUpon().authority(r9).build().toString();     // Catch: Throwable -> L38
        d.b.s.a.w.a.C0402a r11 = r7.a();     // Catch: Throwable -> L38
        r11.l(r5);     // Catch: Throwable -> L38
        r7 = r11.c();     // Catch: Throwable -> L38
        d.b.s.a.a0.a.d("BaseAccountApi", "processApiRequest(), replace host to " + r9 + ", oldUrl=" + r4 + ", newUrl=" + r5);     // Catch: Throwable -> L38
        return r7;
    L38:
        th = move-exception;
        r10 = "processApiRequest(), path:" + r1 + ", replace host fail, " + th;
        goto L40
    L48:
        return r7;
    L23:
        if (r8.f().contains(r1) == false) goto L25;
        r3 = true;
        goto L26
    L50:
        return r7;
    L45:
        return r7;
    L49:
        return r7;
    }

    private void C() {
        d.b.s.a.q.j.b r0 = f();
        if (r0 == null) goto L37;
        d.b.s.a.w.b r1 = this.f5620h;
        if (r1 == null) goto L8;
        r0.f14888d = r1.f14964d;
        r0.f14885a = r1.f14966f;
        r0.f14886b = r1.f14968h;
        r0.f14896l = r1.f14970j;
        r0.m = r1.f14971k;
        r0.n = this.f5624l;
    L8:
        if (TextUtils.isEmpty(r0.f14888d) == false) goto L12;
        d.b.s.a.w.a r2 = this.f5619g;
        if (r2 == null) goto L12;
        r0.f14888d = r2.f14944a;
    L12:
        t(r0);
        d.b.s.a.w.b r3 = this.f5620h;
        if (r3 == null) goto L32;
        int r4 = r3.f14962b;
        if (r4 == 0) goto L32;
        if (d.b.s.a.l0.b.f14847a.a(r4) == false) goto L32;
        d.b.s.a.v.a.a.InterfaceC0400a r5 = l(r0, false);
        Iterator<d.b.s.a.v.a.a> r6 = d.b.s.a.v.a.b.a().iterator();
    L20:
        if (r6.hasNext() == false) goto L24;
        if (r6.next().b(this.f5620h.f14962b, this.f5619g.f14946c, r0, r5) == false) goto L20;
        return;
    L24:
        d.b.s.a.v.a.a r7 = d.b.s.a.v.a.b.b(new int[]{this.f5620h.f14962b});
        if (r7 == null) goto L30;
        if (r7.b(this.f5620h.f14962b, this.f5619g.f14946c, r0, r5) == false) goto L30;
        return;
    L30:
        if (F(r0, false) == false) goto L32;
        return;
    L32:
        s(r0);
        return;
    }

    private boolean F(R r10, boolean r11) {
        d.b.s.a.v.a.a.InterfaceC0400a r7 = l(r10, true);
        Iterator<d.b.s.a.v.a.a> r8 = d.b.s.a.v.a.b.a().iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        d.b.s.a.v.a.a r1 = r8.next();
        if ((r1 instanceof d.b.s.a.v.a.c) == false) goto L4;
        if (((d.b.s.a.v.a.c) r1).a(this.f5620h.f14962b, this.f5619g.f14946c, r10, r11, r7) == false) goto L4;
        return true;
    L10:
        Iterator<d.b.s.a.v.a.a> r9 = d.b.s.a.v.a.b.c().values().iterator();
    L12:
        if (r9.hasNext() == false) goto L18;
        d.b.s.a.v.a.a r2 = r9.next();
        if ((r2 instanceof d.b.s.a.v.a.c) == false) goto L12;
        if (((d.b.s.a.v.a.c) r2).a(this.f5620h.f14962b, this.f5619g.f14946c, r10, r11, r7) == false) goto L12;
        return true;
    L18:
        return false;
    }

    private void H(String r1) {
        Context r0 = this.f5618f;
        if (r0 == null) goto L6;
        i.S(r0).q0(r1);
        return;
    }

    private void I(String r1) {
        Context r0 = this.f5618f;
        if (r0 == null) goto L6;
        i.S(r0).s0(r1);
        return;
    }

    private void d(d.b.s.a.q.j.b r4) {
        if (r4 == null) goto L26;
        int r0 = this.f5620h.f14962b;
        if (r0 >= 0) goto L10;
        r4.f14891g = -1005;
        r4.f14892h = r0;
        if ((r4 instanceof d.b.s.a.q.j.e) == false) goto L16;
        T r2 = ((d.b.s.a.q.j.e) r4).p;
        if (r2 == 0) goto L16;
        r2.f14652a = -1005;
        r2.f14653b = r0;
    L16:
        if (r0 != 0) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(r4.f14894j) == false) goto L24;
        String r1 = this.f5620h.f14965e;
        if (r1 != null) goto L23;
        r1 = "";
    L23:
        r4.f14894j = r1;
    L24:
        String r5 = this.f5619g.f14944a;
        d.b.s.a.w.b r3 = this.f5620h;
        com.bytedance.sdk.account.monitor.c.i(r5, null, r3.f14962b, r3.f14965e);
        return;
    L10:
        if (r0 <= 0) goto L16;
        r4.f14892h = r0;
        if ((r4 instanceof d.b.s.a.q.j.e) == false) goto L16;
        T r6 = ((d.b.s.a.q.j.e) r4).p;
        if (r6 == 0) goto L16;
        r6.f14653b = r0;
        goto L16
    }

    public static void e(o r1) {
        t.a(r1);
    }

    private com.ss.android.h h(String r4, Map<String, String> r5, List<com.ss.android.f> r6) {
        d.b.s.a.e0.c r0 = d.b.s.a.l0.l.e(r4);
        if (r5 == null) goto L8;
        Iterator<Map.Entry<String, String>> r7 = r5.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        Map.Entry<String, String> r1 = r7.next();
        r0.f(r1.getKey(), r1.getValue());
    L8:
        if (r6 != null) goto L11;
        r6 = new ArrayList();
    L11:
        if (com.ss.android.i.j.k().h() == false) goto L14;
        r0.b("multi_login", LocationInfoConst.ALLOW_USE_LOCATION);
        c(r6, r4);
    L14:
        if (q() == false) goto L16;
        b(r4, r6);
    L16:
        r0.b("account_sdk_source", "app");
        r0.b("passport_support_flow", d.b.s.a.v.a.b.d());
        String r8 = r0.toString();
        this.f5620h.f14964d = r8;
        this.f5623k.c(System.currentTimeMillis());
        com.ss.android.h r9 = d.b.s.a.l0.l.b(Integer.MAX_VALUE, r8, r6, this.f5619g.f14952i);
        this.f5623k.b(System.currentTimeMillis());
        return r9;
    }

    private com.ss.android.h i(String r4, Map<String, String> r5, List<com.ss.android.f> r6) {
        HashMap r0 = new HashMap();
        d.b.s.a.e0.c r1 = d.b.s.a.l0.l.e(r4);
        if (r5 == null) goto L5;
        r0.putAll(r5);
    L5:
        r0.put("account_sdk_source", "app");
        r0.put("passport_support_flow", d.b.s.a.v.a.b.d());
        if (r6 != null) goto L9;
        r6 = new ArrayList();
    L9:
        if (com.ss.android.i.j.k().h() == false) goto L12;
        r0.put("multi_login", LocationInfoConst.ALLOW_USE_LOCATION);
        c(r6, r4);
    L12:
        if (q() == false) goto L14;
        b(r4, r6);
    L14:
        String r7 = r1.toString();
        this.f5620h.f14964d = r7;
        this.f5623k.c(System.currentTimeMillis());
        com.ss.android.h r8 = d.b.s.a.l0.l.c(Integer.MAX_VALUE, r7, r0, r6, this.f5619g.f14952i);
        this.f5623k.b(System.currentTimeMillis());
        return r8;
    }

    private boolean j() {
        if (this.f5618f != null) goto L7;
        d.b.s.a.w.b r11 = this.f5620h;
        r11.f14962b = -24;
        String r0 = "context_is_null";
    L5:
        r11.f14965e = r0;
        return false;
    L7:
        boolean r1 = true;
        Map<String, String> r2 = this.f5619g.f14946c;
        if (r2 != null) goto L10;
    L12:
        if (r1 == true) goto L14;
    L16:
        d.b.s.a.w.a r3 = this.f5619g;
        Map<String, String> r4 = k(r3.f14946c, r3.f14951h);
        if (r4 != null) goto L19;
        r4 = new HashMap();
    L19:
        Map<String, String> r5 = r4;
        d.b.s.a.l0.l.a(r5);
        this.f5619g = B(this.f5619g);
        long r9 = System.currentTimeMillis();
        com.bytedance.sdk.account.settings.e.a r6 = com.bytedance.sdk.account.settings.f.a.g();
        if ("get".equals(this.f5619g.f14945b) == false) goto L24;
        d.b.s.a.w.a r7 = this.f5619g;
        com.ss.android.h r8 = h(r7.f14944a, r5, r7.f14947d);
    L22:
        this.f5621i = r8;
    L29:
        long r10 = System.currentTimeMillis() - r9;
        y(this.f5621i, r6);
        com.ss.android.h r12 = this.f5621i;
        if (r12 != null) goto L32;
    L36:
        r11 = this.f5620h;
        r11.f14962b = -25;
        r0 = "response null";
        goto L5
    L32:
        if (com.bytedance.common.utility.k.c(r12.a()) == true) goto L36;
        boolean r13 = v(new JSONObject(this.f5621i.a()));
        p(r10, this.f5620h.f14966f, r9);
        return r13;
    L24:
        if ("post".equals(this.f5619g.f14945b) == false) goto L27;
        d.b.s.a.w.a r14 = this.f5619g;
        r8 = i(r14.f14944a, r5, r14.f14947d);
        goto L22
    L27:
        if ("post_file".equals(this.f5619g.f14945b) == false) goto L29;
        d.b.s.a.w.a r15 = this.f5619g;
        r8 = A(r15.f14944a, r5, r15.f14947d, r15.f14949f, r15.f14950g);
        goto L22
    L14:
        if (d.b.s.a.l0.k.c(this.f5618f) == true) goto L16;
        r11 = this.f5620h;
        r11.f14962b = -12;
        r0 = "no net work";
        goto L5
    L10:
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r2.remove("local_account_sdk_skip_network_check")) == false) goto L12;
        r1 = false;
        goto L12
    }

    private Map<String, String> k(Map<String, String> r3, boolean r4) {
        if (r3 != null) goto L4;
    L15:
        return r3;
    L4:
        if (r3.size() <= 0) goto L15;
        HashMap r2 = new HashMap();
        Iterator<Map.Entry<String, String>> r5 = r3.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L14;
        Map.Entry<String, String> r0 = r5.next();
        if (TextUtils.isEmpty(r0.getKey()) == true) goto L7;
        if (r4 == true) goto L13;
        if (TextUtils.isEmpty(r0.getValue()) == true) goto L7;
    L13:
        r2.put(r0.getKey(), r0.getValue());
        goto L7
    L14:
        return r2;
    }

    private d.b.s.a.v.a.a.InterfaceC0400a l(R r2, boolean r3) {
        return new a(this, r3, r2);
    }

    private String m(String r3) {
        int r2 = r3.indexOf("=");
        int r0 = r3.indexOf(";");
        if (r0 != (-1)) goto L5;
        r0 = r3.length();
    L5:
        if (r2 <= 0) goto L11;
        int r4 = r2 + 1;
        if (r4 >= r3.length()) goto L13;
        if (r4 < r0) goto L10;
        return "";
    L10:
        return r3.substring(r4, r0);
    L13:
        return "";
    L11:
        return "";
    }

    private void n(R r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r2 = r3.f14891g;
        d.b.s.a.e0.a r0 = com.bytedance.sdk.account.settings.f.b.b(r2);
        if (r0 == null) goto L9;
        r3.f14889e = r0;
        if (TextUtils.isEmpty(r0.a()) == false) goto L9;
        r0.b(r3.f14893i);
    L9:
        d.b.s.a.a0.a.a("BaseAccountApi", "handleErrorCodeTask, errorCode: " + r2 + ", task: " + r0);
    }

    private void p(long r15, String r17, long r18) {
        Uri r1 = Uri.parse(this.f5619g.f14944a);
        String r2 = r1.getHost();
        String r3 = r1.getPath();
        if (TextUtils.isEmpty(this.q) == true) goto L6;
        d.b.s.a.a0.a.a("BaseAccountApi", String.format("Passport service has set csrf token: host=%s, path=%s, logid=%s", new Object[]{r2, r3, r17}));
    L6:
        if (this.p == false) goto L9;
        d.b.s.a.a0.a.a("BaseAccountApi", String.format("Passport service has set x-tt-token: host=%s, path=%s, logid=%s", new Object[]{r2, r3, r17}));
    L9:
        if (this.o == false) goto L11;
        d.b.s.a.a0.a.a("BaseAccountApi", String.format("set-cookie sessionid: host=%s, path=%s, logid=%s", new Object[]{r2, r3, r17}));
    L11:
        d.b.s.a.w.b r4 = this.f5620h;
        com.bytedance.sdk.account.monitor.c.h(r2, r3, r15, r4.f14962b, r4.f14965e, r17, !TextUtils.isEmpty(this.m), this.n, this.p, !TextUtils.isEmpty(this.q), d.b.s.a.f.f(), r18);
    }

    private void r(String r3, JSONObject r4, JSONObject r5) {
        if (WsConstants.KEY_CONNECTION_ERROR.equals(r3) == false) goto L5;
    L6:
        if (r5 != null) goto L8;
        r5 = r4;
    L8:
        if (r5 == null) goto L18;
        String r6 = WsConstants.ERROR_CODE;
        if (r5.has(WsConstants.ERROR_CODE) == false) goto L12;
    L11:
        d.b.s.a.w.b r0 = this.f5620h;
        r0.f14962b = r5.optInt(r6, r0.f14962b);
    L15:
        d.b.s.a.w.b r7 = this.f5620h;
        r7.f14963c = r5.optString("description");
        d.b.s.a.w.b r8 = this.f5620h;
        r8.f14965e = r8.f14963c;
        r8.f14967g = r5.optString("verify_center_decision_conf");
        d.b.s.a.w.b r9 = this.f5620h;
        r9.f14968h = r5.optString("verify_center_secondary_decision_conf");
        u(r5, r4);
        return;
    L12:
        r6 = "code";
        if (r5.has("code") == false) goto L15;
    L18:
        return;
    L5:
        if ("exception".equals(r3) == true) goto L6;
    }

    private boolean v(JSONObject r5) {
        this.f5620h.f14971k = r5;
        JSONObject r0 = w(r5);
        String r2 = r5.optString("message");
    L12:
        return false;
    L4:
        if (TextUtils.isEmpty(r2) == false) goto L6;
        if (r0 == null) goto L11;
        return z(r0, w(r0), r0.optString("message"));
    L11:
        return z(r5, new JSONObject(), "success");
    L6:
        return z(r5, r0, r2);
    }

    private JSONObject w(JSONObject r3) {
        JSONObject r2 = null;
        if (r3 != null) goto L5;
    L18:
        return r2;
    L5:
        if (r3.has("data") == false) goto L18;
        Object r4 = r3.opt("data");     // Catch: Exception -> L20
        if (r4 != null) goto L11;
        return null;
    L11:
        if ((r4 instanceof JSONObject) == false) goto L14;
        r2 = (JSONObject) r4;     // Catch: Exception -> L20
    L21:
        goto L18
    L14:
        if ((r4 instanceof JSONArray) == false) goto L21;
        JSONArray r5 = (JSONArray) r4;     // Catch: Exception -> L20
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L20
        r1.put("data", r5);     // Catch: Exception -> L19
    L17:
        r2 = r1;
        goto L21
    }

    private void y(com.ss.android.h r13, com.bytedance.sdk.account.settings.e.a r14) {
        if (r13 != null) goto L4;
        return;
    L4:
        if (r13.b() == null) goto L147;
        List<com.ss.android.f> r0 = r13.b();     // Catch: Exception -> L97
        this.f5620h.f14970j = r0;     // Catch: Exception -> L97
        Iterator<com.ss.android.f> r1 = r0.iterator();     // Catch: Exception -> L97
        String r2 = "";
        String r3 = "";
        String r4 = r3;
        String r5 = null;
    L9:
        if (r1.hasNext() == false) goto L72;
        com.ss.android.f r6 = r1.next();     // Catch: Exception -> L97
        String r7 = r6.a();     // Catch: Exception -> L97
        if (TextUtils.isEmpty(r7) == true) goto L9;
        String r8 = r6.b();     // Catch: Exception -> L97
        if (TextUtils.isEmpty(r8) == true) goto L9;
        String r9 = r7.toLowerCase();     // Catch: Exception -> L97
        byte r10 = -1;
        switch(r9.hashCode()) {
            case -1846329444: goto L44;
            case -1403626347: goto L41;
            case -1210797355: goto L38;
            case -694021551: goto L35;
            case -272647289: goto L32;
            case -265255391: goto L29;
            case 213977896: goto L26;
            case 1200578924: goto L23;
            case 1237214767: goto L20;
            default: goto L46;
        };     // Catch: Exception -> L97
    L46:
        switch(r10) {
            case 0: goto L71;
            case 1: goto L70;
            case 2: goto L69;
            case 3: goto L68;
            case 4: goto L53;
            case 5: goto L50;
            case 6: goto L51;
            case 7: goto L49;
            case 8: goto L48;
            default: goto L9;
        };     // Catch: Exception -> L97
    L48:
        r3 = r8;
        goto L9
    L49:
        r2 = r8;
        goto L9
    L50:
        this.f5620h.f14969i = r8;     // Catch: Exception -> L97
        this.p = true;     // Catch: Exception -> L97
    L51:
        r5 = r8;
        goto L9
    L53:
        if (r8.contains("sessionid") == true) goto L54;
        if (r8.startsWith("passport_csrf_token=") == true) goto L65;
        if (TextUtils.isEmpty(this.q) == false) goto L63;
        if (r8.startsWith("passport_csrf_token_default=") == true) goto L65;
    L63:
        if (r8.startsWith("d_ticket=") == false) goto L9;
        r4 = m(r8);     // Catch: Exception -> L97
    L65:
        String r11 = m(r8);     // Catch: Exception -> L97
        this.q = r11;     // Catch: Exception -> L97
        if (TextUtils.isEmpty(r11) == true) goto L9;
        d.b.s.a.f.g(this.q);     // Catch: Exception -> L97
        goto L9
    L54:
        this.o = true;     // Catch: Exception -> L97
        s.b();     // Catch: Exception -> L97
        goto L9
    L68:
        i.S(this.f5618f).o0(r8);     // Catch: Exception -> L97
        goto L9
    L69:
        this.f5620h.f14966f = r8;     // Catch: Exception -> L97
        goto L9
    L70:
        I(r8);     // Catch: Exception -> L97
        goto L9
    L71:
        H(r8);     // Catch: Exception -> L97
        goto L9
    L20:
        if (r9.equals("set-cookie") == false) goto L46;
        r10 = 4;
        goto L46
    L23:
        if (r9.equals("x-tt-session-sign") == false) goto L46;
        r10 = 3;
        goto L46
    L26:
        if (r9.equals("x-tt-passport-ip-match-result") == false) goto L46;
        r10 = 6;
        goto L46
    L29:
        if (r9.equals("x-tt-token") == false) goto L46;
        r10 = 5;
        goto L46
    L32:
        if (r9.equals("x-tt-logid") == false) goto L46;
        r10 = 2;
        goto L46
    L35:
        if (r9.equals("x-tt-multi-sids") == false) goto L46;
        r10 = 0;
        goto L46
    L38:
        if (r9.equals("x-tt-multi-sids-sec") == false) goto L46;
        r10 = 1;
        goto L46
    L41:
        if (r9.equals("d-ticket") == false) goto L46;
        r10 = 8;
        goto L46
    L44:
        if (r9.equals("d-ticket-sec-uid") == false) goto L46;
        r10 = 7;
        goto L46
    L72:
        com.ss.android.g r15 = r13.d();     // Catch: Exception -> L97
        if (r15 == null) goto L81;
        Iterator<com.ss.android.f> r16 = r15.f11865a.iterator();     // Catch: Exception -> L97
    L76:
        if (r16.hasNext() == false) goto L81;
        com.ss.android.f r12 = r16.next();     // Catch: Exception -> L97
        if ("X-Tt-Token".equalsIgnoreCase(r12.a()) == false) goto L76;
        this.m = r12.b();     // Catch: Exception -> L97
    L81:
        if (TextUtils.isEmpty(r5) == true) goto L89;
        if ("{}".equals(r5) == true) goto L89;
        JSONObject r17 = new JSONObject(r5);     // Catch: Throwable -> L86
        com.bytedance.sdk.account.monitor.c.f(this.f5619g.b(TypedValues.TransitionType.S_FROM), r.a(this.f5619g.f14944a), this.f5620h.f14966f, r17.optString("ip_match", null), r17.optString("pre_ip_match", null), r14);     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        d.b.s.a.a0.a.d("BaseAccountApi", "parse x-tt-passport-ip-match-result fail, value=" + r5 + ", error=" + th.getMessage());     // Catch: Exception -> L97
    L89:
        if (TextUtils.isEmpty(r2) == false) goto L91;
        return;
    L91:
        if (TextUtils.isEmpty(r3) == false) goto L94;
        r3 = r4;
    L94:
        if (TextUtils.isEmpty(r3) == true) goto L146;
        d.b.s.a.u.a.d(r2, r3);     // Catch: Exception -> L97
        return;
    L146:
        return;
    L148:
        return;
    }

    private boolean z(JSONObject r2, JSONObject r3, String r4) {
        if ("success".equals(r4) == true) goto L6;
        r(r4, r2, r3);
        return false;
    L6:
        if (r3 == null) goto L10;
        x(r2, r3);
        return true;
    L10:
        return true;
    }

    public final void D() {
        s.a(this);
    }

    protected abstract R E(boolean r1, d.b.s.a.w.b r2);

    public void G(long r1) {
        com.bytedance.sdk.account.impl.b r0 = this.f5623k;
        if (r0 == null) goto L6;
        r0.e(r1);
        return;
    }

    @Override // d.b.s.a.q.l.c
    public void a() {
        C();
    }

    public void b(String r3, List<com.ss.android.f> r4) {
        Pair<Integer, String> r5 = d.b.s.a.f.b(r3);     // Catch: Exception -> L7
        this.n = ((Integer) r5.first).intValue();     // Catch: Exception -> L7
        String r2 = (String) r5.second;     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r4.add(new com.ss.android.f("x-tt-passport-csrf-token", r2));     // Catch: Exception -> L7
        d.b.s.a.f.g(r2);     // Catch: Exception -> L7
    L8:
        return;
    L5:
        d.b.s.a.a0.a.a("BaseAccountApi", String.format("Csrf token is empty: csrf_token_status=%s", new Object[]{Boolean.valueOf(d.b.s.a.f.f())}));     // Catch: Exception -> L7
    }

    public void c(List<com.ss.android.f> r3, String r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.f5618f != null) goto L17;
        return;
    L17:
        if (o(r4) == false) goto L19;
        i r2 = i.S(this.f5618f);     // Catch: Exception -> L16
        String r5 = r2.v();     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r5) == true) goto L12;
        r3.add(new com.ss.android.f("x-tt-multi-sids", r5));     // Catch: Exception -> L16
    L12:
        String r6 = r2.q();     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r6) == true) goto L20;
        r3.add(new com.ss.android.f("x-tt-multi-sids-sec", r6));     // Catch: Exception -> L16
        return;
    L20:
        return;
    L19:
        return;
    }

    public R f() {
        this.r = false;
        this.r = j();     // Catch: Throwable -> L5
        d.b.s.a.a0.a.a("BaseAccountApi", "executeRequest path: " + this.f5619g.f14944a + "  executeStatus: " + this.r);     // Catch: Throwable -> L5
    L7:
        R r0 = (R) E(this.r, this.f5620h);
        int r1 = r0.f14891g;
        if (r1 == 0) goto L10;
        this.f5624l.add(Integer.valueOf(r1));
    L10:
        d(r0);
        return r0;
    L5:
        th = move-exception;
        d.b.s.a.a0.a.b("BaseAccountApi", "executeRequest failed with exception, path:" + this.f5619g.f14944a + ", error:" + th);
        this.f5620h.f14962b = d.b.s.a.l0.k.a(this.f5618f, th);
        com.bytedance.sdk.account.monitor.c.i(this.f5619g.f14944a, th, this.f5620h.f14962b, "");
        this.f5620h.f14965e = th.getMessage();
        goto L7
    }

    @Override // d.b.s.a.q.l.a
    public void g() {
        this.f5622j = null;
    }

    protected boolean o(String r2) {
        return com.ss.android.token.n.m(r2, Uri.parse(r2).getHost());
    L4:
        th = move-exception;
        d.b.s.a.a0.a.h("BaseAccountApi", "isArrowShareToken(), parse url fail, " + th.getMessage());
        return false;
    }

    protected boolean q() {
        return true;
    }

    protected void s(R r2) {
        n(r2);
        e(new o(this.f5622j, r2));
    }

    public abstract void t(R r1);

    protected abstract void u(JSONObject r1, JSONObject r2);

    protected abstract void x(JSONObject r1, JSONObject r2);
}

package com.bytedance.sdk.account.settings.e;

import d.b.s.a.l0.n;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0184a f5727h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f5729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f5730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f5731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<String> f5732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f5733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f5734g;

    /* JADX INFO: renamed from: com.bytedance.sdk.account.settings.e.a$a, reason: collision with other inner class name */
    public static final class C0184a {
        private C0184a() {
        }

        public /* synthetic */ C0184a(g r1) {
            this();
        }

        public final a a(JSONObject r12) {
            if (r12 == null) goto L4;
            boolean r2 = r12.optBoolean("enable", false);
            LinkedHashSet r3 = new LinkedHashSet();
            JSONArray r11 = r12.optJSONArray("carrier");
            if (r11 != null) goto L8;
        L15:
            LinkedHashSet r4 = new LinkedHashSet();
            JSONArray r13 = r12.optJSONArray("path");
            if (r13 != null) goto L18;
        L25:
            r4.add("/passport/auth/one_login/");
            r4.add("/passport/auth/one_login_only/");
            r4.add("/passport/auth/validate_mobile_login/");
            r4.add("/passport/mobile/bind_login/");
            r4.add("/passport/auth/one_login_with_mask_mobile/");
            r4.add("/passport/complex_env/one_login/");
            if (r2 == true) goto L28;
        L30:
            boolean r5 = false;
        L31:
            LinkedHashSet r6 = new LinkedHashSet();
            JSONArray r1 = r12.optJSONArray("ipv4_opt_carrier");
            if (r1 != null) goto L34;
        L41:
            String r7 = r12.optString("ipv4_host", "");
            if (r2 == true) goto L44;
        L46:
            boolean r8 = false;
        L47:
            o.b(r7, "ipv4Host");
            return new a(r2, r3, r4, r5, r6, r7, r8);
        L44:
            if (r12.optBoolean("enable_alternative_net_opt", false) == false) goto L46;
            r8 = true;
            goto L47
        L34:
            if (r1.length() <= 0) goto L41;
            int r9 = r1.length();
            int r10 = 0;
        L36:
            if (r10 >= r9) goto L41;
            String r14 = r1.optString(r10);
            if (n.a(r14) == false) goto L40;
            r6.add(r14);
        L40:
            r10 = r10 + 1;
            goto L36
        L28:
            if (r12.optBoolean("enable_ipv4_opt", false) == false) goto L30;
            r5 = true;
            goto L31
        L18:
            if (r13.length() <= 0) goto L25;
            int r15 = r13.length();
            int r16 = 0;
        L20:
            if (r16 >= r15) goto L25;
            String r17 = r13.optString(r16);
            if (n.a(r17) == false) goto L24;
            r4.add(r17);
        L24:
            r16 = r16 + 1;
            goto L20
        L8:
            if (r11.length() <= 0) goto L15;
            int r18 = r11.length();
            int r19 = 0;
        L10:
            if (r19 >= r18) goto L15;
            String r20 = r11.optString(r19);
            if (n.a(r20) == false) goto L14;
            r3.add(r20);
        L14:
            r19 = r19 + 1;
            goto L10
        L4:
            return b();
        }

        public final a b() {
            return new a(false, new LinkedHashSet(), new LinkedHashSet(), false, new LinkedHashSet(), "", false);
        }
    }

    static {
        f5727h = new C0184a(null);
    }

    public a(boolean r2, Set<String> r3, Set<String> r4, boolean r5, Set<String> r6, String r7, boolean r8) {
        o.g(r3, "carriers");
        o.g(r4, "paths");
        o.g(r6, "ipv4OptCarriers");
        o.g(r7, "ipv4Host");
        this.f5728a = r2;
        this.f5729b = r3;
        this.f5730c = r4;
        this.f5731d = r5;
        this.f5732e = r6;
        this.f5733f = r7;
        this.f5734g = r8;
    }

    public static final a a(JSONObject r1) {
        return f5727h.a(r1);
    }

    public static final a c() {
        return f5727h.b();
    }

    public final Set<String> b() {
        return this.f5729b;
    }

    public final String d() {
        return this.f5733f;
    }

    public final Set<String> e() {
        return this.f5732e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
    L31:
        return true;
    L5:
        if ((r5 instanceof a) == false) goto L30;
        a r6 = (a) r5;
        if (this.f5728a != r6.f5728a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L30;
        if (o.a(this.f5729b, r6.f5729b) == false) goto L30;
        if (o.a(this.f5730c, r6.f5730c) == false) goto L30;
        if (this.f5731d != r6.f5731d) goto L18;
        boolean r2 = true;
    L19:
        if (r2 == false) goto L30;
        if (o.a(this.f5732e, r6.f5732e) == false) goto L30;
        if (o.a(this.f5733f, r6.f5733f) == false) goto L30;
        if (this.f5734g != r6.f5734g) goto L27;
        boolean r4 = true;
    L28:
        if (r4 == false) goto L30;
    L27:
        r4 = false;
        goto L28
    L18:
        r2 = false;
        goto L19
    L9:
        r1 = false;
    L30:
        return false;
    }

    public final Set<String> f() {
        return this.f5730c;
    }

    public final boolean g() {
        return this.f5728a;
    }

    public final boolean h() {
        return this.f5731d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public int hashCode() {
        boolean r0 = this.f5728a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        Set<String> r4 = this.f5729b;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        Set<String> r8 = this.f5730c;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (r7 + r9) * 31;
        boolean r11 = this.f5731d;
        ?? r12 = r11;
        if (r11 == false) goto L16;
        r12 = 1;
    L16:
        int r13 = (r10 + r12) * 31;
        Set<String> r14 = this.f5732e;
        if (r14 == null) goto L19;
        int r15 = r14.hashCode();
    L20:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f5733f;
        if (r17 == null) goto L23;
        r5 = r17.hashCode();
    L23:
        int r18 = (r16 + r5) * 31;
        boolean r19 = this.f5734g;
        if (r19 == true) goto L28;
        r1 = r19;
    L28:
        return r18 + r1;
    L19:
        r15 = 0;
        goto L20
    L12:
        r9 = 0;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }

    public String toString() {
        return "RequestUseCellularConfig(isEnable=" + this.f5728a + ", carriers=" + this.f5729b + ", paths=" + this.f5730c + ", isEnableIpv4Opt=" + this.f5731d + ", ipv4OptCarriers=" + this.f5732e + ", ipv4Host=" + this.f5733f + ", isEnableAlternativeNetOpt=" + this.f5734g + ")";
    }
}

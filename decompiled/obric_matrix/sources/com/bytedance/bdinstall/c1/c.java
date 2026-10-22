package com.bytedance.bdinstall.c1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.bdinstall.d1.m;
import com.bytedance.bdinstall.d1.o;
import com.bytedance.bdinstall.v0;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile String f2692i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile String[] f2693j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile String f2694k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile JSONArray f2695l;

    c(Context r1, k r2) {
        super(r1, r2);
    }

    private static String g() {
        String r1 = "ZQLiNFJR+CWEI4px" + o.d();
        return new String(new char[]{r1.charAt(1), r1.charAt(3), r1.charAt(1), r1.charAt(11), r1.charAt(15), r1.charAt(10), r1.charAt(8), r1.charAt(17), r1.charAt(9), r1.charAt(9), r1.charAt(12), r1.charAt(13), r1.charAt(13), r1.charAt(5), r1.charAt(18), r1.charAt(13), r1.charAt(14), r1.charAt(11), r1.charAt(4), r1.charAt(19), r1.charAt(7)}).substring(2, 18);
    }

    @Override // com.bytedance.bdinstall.c1.a, com.bytedance.bdinstall.b1.a
    public String b(boolean r9) {
        if (TextUtils.isEmpty(this.f2682e) == false) goto L5;
        String r0 = com.bytedance.bdinstall.d1.f.a(this.f2678a);
        SharedPreferences r1 = com.bytedance.bdinstall.d1.h.a(this.f2678a);
        String r3 = null;
        String r4 = r1.getString("openudid", null);
        if (v0.k(r0) == false) goto L18;
        if ("9774d56d682e549c".equals(r0) == true) goto L18;
        if (v0.k(r4) == false) goto L15;
        String r10 = this.f2680c.j(r0, r4);     // Catch: Exception -> L47
    L16:
        r0 = r10;
        goto L41
    L15:
        r10 = this.f2680c.j(null, r0);     // Catch: Exception -> L47
    L18:
        if (v0.k(r4) == true) goto L36;
        r4 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L47
        if (r4.charAt(0) != '-') goto L22;
        r4 = r4.substring(1);     // Catch: Exception -> L47
    L22:
        int r5 = 13 - r4.length();     // Catch: Exception -> L47
        if (r5 <= 0) goto L28;
        StringBuilder r6 = new StringBuilder();     // Catch: Exception -> L47
    L25:
        if (r5 <= 0) goto L27;
        r6.append('F');     // Catch: Exception -> L47
        r5 = r5 - 1;     // Catch: Exception -> L47
        goto L25
    L27:
        r6.append(r4);     // Catch: Exception -> L47
        r4 = r6.toString();     // Catch: Exception -> L47
    L28:
        if (r9 == false) goto L35;
        b r11 = this.f2681d;     // Catch: Exception -> L47
        if (r11 == null) goto L33;
        r3 = r11.j(null, r4);     // Catch: Exception -> L47
    L33:
        if (v0.k(r3) == false) goto L35;
        r4 = r3;
    L35:
        SharedPreferences.Editor r12 = r1.edit();     // Catch: Exception -> L47
        r12.putString("openudid", r4);     // Catch: Exception -> L47
        r12.apply();     // Catch: Exception -> L47
    L39:
        r0 = r4;
        goto L41
    L36:
        b r13 = this.f2681d;     // Catch: Exception -> L47
        if (r13 == null) goto L39;
        r13.j(r4, null);     // Catch: Exception -> L47
    L41:
        if (TextUtils.isEmpty(r0) == true) goto L44;
        r0 = r0 + this.f2685h;
    L44:
        if (TextUtils.isEmpty(r0) == true) goto L46;
        this.f2682e = r0;
    L46:
        return r0;
    L5:
        return this.f2682e;
    }

    @Override // com.bytedance.bdinstall.c1.a, com.bytedance.bdinstall.b1.a
    public String c() {
        if (TextUtils.isEmpty(this.f2683f) == false) goto L5;
        SharedPreferences r1 = com.bytedance.bdinstall.d1.h.a(this.f2678a);     // Catch: Exception -> L23
        String r2 = null;
        String r3 = r1.getString("clientudid", null);     // Catch: Exception -> L23
        if (v0.k(r3) == true) goto L15;
        r3 = UUID.randomUUID().toString();     // Catch: Exception -> L23
        b r4 = this.f2681d;     // Catch: Exception -> L23
        if (r4 == null) goto L12;
        r2 = r4.i(null, r3);     // Catch: Exception -> L23
    L12:
        if (v0.k(r2) == false) goto L14;
        r3 = r2;
    L14:
        SharedPreferences.Editor r5 = r1.edit();     // Catch: Exception -> L23
        r5.putString("clientudid", r3);     // Catch: Exception -> L23
        r5.apply();     // Catch: Exception -> L23
    L19:
        if (TextUtils.isEmpty(r3) == true) goto L21;
        r3 = r3 + this.f2685h;     // Catch: Exception -> L23
    L21:
        this.f2683f = r3;     // Catch: Exception -> L23
        return r3;
    L15:
        b r0 = this.f2681d;     // Catch: Exception -> L23
        if (r0 == null) goto L19;
        r0.i(r3, null);     // Catch: Exception -> L23
    L23:
        return "";
    L5:
        return this.f2683f;
    }

    @Override // com.bytedance.bdinstall.c1.a
    protected void d(k r10, d r11) {
        String r6 = g();
        boolean r7 = !r10.f();
        h r8 = new h(this.f2678a, r7, Environment.getExternalStorageDirectory().getPath() + o.a("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U=") + this.f2685h, r10.b(), r6);     // Catch: Exception -> L7
        r11.m(r8);     // Catch: Exception -> L7
        r11 = r8;
    L11:
        r11.m(new h(this.f2678a, r7, Environment.getExternalStorageDirectory().getPath() + "/" + o.d() + this.f2685h, r10.b(), r6));     // Catch: Exception -> L8
        return;
    }

    public String h() {
        if (TextUtils.isEmpty(this.f2692i) == true) goto L13;
        return this.f2692i;
    L13:
        String r1 = this.f2680c.k(null, m.g(this.f2678a, this.f2679b.c()));     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r1) == true) goto L10;
        r1 = r1 + this.f2685h;     // Catch: Exception -> L12
    L10:
        this.f2692i = r1;     // Catch: Exception -> L12
        return r1;
    L12:
        return null;
    }

    public String[] i() {
        if (this.f2693j == null) goto L18;
        if (this.f2693j.length <= 0) goto L18;
        return this.f2693j;
    L18:
        String[] r1 = this.f2680c.h(null, m.h(this.f2678a, this.f2679b.c()));     // Catch: Exception -> L17
        int r2 = 0;
        if (r1 != null) goto L13;
        r1 = new String[0];     // Catch: Exception -> L17
    L13:
        if (r2 >= r1.length) goto L15;
        r1[r2] = r1[r2] + this.f2685h;     // Catch: Exception -> L17
        r2 = r2 + 1;     // Catch: Exception -> L17
        goto L13
    L15:
        this.f2693j = r1;     // Catch: Exception -> L17
        return r1;
    L17:
        return null;
    }

    public String j() {
        if (TextUtils.isEmpty(this.f2694k) == true) goto L13;
        return this.f2694k;
    L13:
        String r1 = this.f2680c.l(null, m.d(this.f2678a, this.f2679b.c()));     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r1) == true) goto L10;
        r1 = r1 + this.f2685h;     // Catch: Exception -> L12
    L10:
        this.f2694k = r1;     // Catch: Exception -> L12
        return r1;
    L12:
        return null;
    }

    public JSONArray k() {
        if (this.f2695l != null) goto L5;
        this.f2695l = m.f(this.f2678a, this.f2679b.c());     // Catch: Exception -> L8
        return this.f2695l;
    L8:
        return null;
    L5:
        return this.f2695l;
    }
}

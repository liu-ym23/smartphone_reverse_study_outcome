package com.bytedance.bdinstall.c1;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.d1.l;
import com.bytedance.bdinstall.v0;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements com.bytedance.bdinstall.b1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f2678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final k f2679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected d f2680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected b f2681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f2682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f2683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile String f2684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final String f2685h;

    a(Context r4, k r5) {
        this.f2685h = e(r5.g());
        Context r0 = r4.getApplicationContext();
        this.f2678a = r0;
        this.f2679b = r5;
        this.f2680c = new j(r0, r5.d());
        if (com.bytedance.bdinstall.migrate.a.g(r4) == true) goto L11;
        b r1 = new b(r4, r5.e());
        this.f2681d = r1;
        this.f2680c.m(r1);
        b r2 = this.f2681d;
        if (l.q() == false) goto L9;
        if (l.B(r4) == true) goto L11;
    L9:
        if (r5.h() == false) goto L11;
        d(r5, r2);
    L11:
        f(r5.a());
    }

    private String e(boolean r1) {
        if (r1 == false) goto L4;
        return "_local";
    L4:
        return "";
    }

    @Override // com.bytedance.bdinstall.b1.a
    public void a(String r3) {
        if (v0.a(r3) == true) goto L5;
        return;
    L5:
        if (v0.d(r3, this.f2684g) == true) goto L10;
        this.f2684g = this.f2680c.c(r3, this.f2684g);
        return;
    }

    @Override // com.bytedance.bdinstall.b1.a
    public String b(boolean r7) {
        if (TextUtils.isEmpty(this.f2682e) == false) goto L5;
        String r8 = com.bytedance.bdinstall.d1.f.a(this.f2678a);
        SharedPreferences r0 = com.bytedance.bdinstall.d1.h.a(this.f2678a);
        String r1 = r0.getString("openudid", null);
        if (v0.k(r8) == false) goto L12;
        if ("9774d56d682e549c".equals(r8) == false) goto L24;
    L12:
        if (v0.k(r1) == true) goto L23;
        r1 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L31
        if (r1.charAt(0) != '-') goto L16;
        r1 = r1.substring(1);     // Catch: Exception -> L31
    L16:
        int r3 = 13 - r1.length();     // Catch: Exception -> L31
        if (r3 <= 0) goto L23;
        StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L31
    L19:
        if (r3 <= 0) goto L21;
        r4.append('F');     // Catch: Exception -> L31
        r3 = r3 - 1;     // Catch: Exception -> L31
        goto L19
    L21:
        r4.append(r1);     // Catch: Exception -> L31
        r8 = r4.toString();     // Catch: Exception -> L31
    L23:
        r8 = r1;
    L24:
        SharedPreferences.Editor r2 = r0.edit();
        r2.putString("openudid", r8);
        r2.apply();
        if (TextUtils.isEmpty(r8) == true) goto L28;
        r8 = r8 + this.f2685h;
    L28:
        if (TextUtils.isEmpty(r8) == true) goto L30;
        this.f2682e = r8;
    L30:
        return r8;
    L5:
        return this.f2682e;
    }

    @Override // com.bytedance.bdinstall.b1.a
    public String c() {
        if (TextUtils.isEmpty(this.f2683f) == false) goto L5;
        SharedPreferences r1 = com.bytedance.bdinstall.d1.h.a(this.f2678a);     // Catch: Exception -> L14
        String r2 = r1.getString("clientudid", null);     // Catch: Exception -> L14
        if (v0.k(r2) == true) goto L10;
        r2 = UUID.randomUUID().toString();     // Catch: Exception -> L14
        SharedPreferences.Editor r3 = r1.edit();     // Catch: Exception -> L14
        r3.putString("clientudid", r2);     // Catch: Exception -> L14
        r3.apply();     // Catch: Exception -> L14
    L10:
        if (TextUtils.isEmpty(r2) == true) goto L12;
        r2 = r2 + this.f2685h;     // Catch: Exception -> L14
    L12:
        this.f2683f = r2;     // Catch: Exception -> L14
        return r2;
    L14:
        return "";
    L5:
        return this.f2683f;
    }

    protected void d(k r1, d r2) {
    }

    public void f(Account r1) {
        b r0 = this.f2681d;
        if (r0 == null) goto L6;
        r0.p(r1);
        return;
    }

    @Override // com.bytedance.bdinstall.b1.a
    public String getDeviceId() {
        if (TextUtils.isEmpty(this.f2684g) == false) goto L5;
        this.f2684g = this.f2680c.c("", "");
        return this.f2684g;
    L5:
        return this.f2684g;
    }
}

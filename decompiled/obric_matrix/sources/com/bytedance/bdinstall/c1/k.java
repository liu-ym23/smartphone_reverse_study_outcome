package com.bytedance.bdinstall.c1;

import android.accounts.Account;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.i0;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f2717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Account f2720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private i0 f2723h;

    public k() {
        this.f2722g = false;
    }

    public Account a() {
        return this.f2720e;
    }

    String b() {
        return this.f2716a;
    }

    public i0 c() {
        return this.f2723h;
    }

    public SharedPreferences d() {
        return this.f2717b;
    }

    String e() {
        return this.f2721f;
    }

    public boolean f() {
        return this.f2719d;
    }

    boolean g() {
        return this.f2718c;
    }

    public boolean h() {
        return this.f2722g;
    }

    public void i(Account r1, String r2) {
        this.f2720e = r1;
        this.f2721f = r2;
    }

    void j(boolean r1) {
        this.f2719d = r1;
    }

    public void k(String r1) {
        this.f2716a = r1;
    }

    public void l(boolean r1) {
        this.f2718c = r1;
    }

    public void m(boolean r1) {
        this.f2722g = r1;
    }

    public void n(i0 r1) {
        this.f2723h = r1;
    }

    public void o(SharedPreferences r1) {
        this.f2717b = r1;
    }
}

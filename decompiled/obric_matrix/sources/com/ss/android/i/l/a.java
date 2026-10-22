package com.ss.android.i.l;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import d.b.s.a.l0.s;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f11907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public String f11909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public String f11910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public String f11911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f11912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f11913l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public String r;
    public String s;
    public String t;
    public String u;
    public long v;
    public long w;

    static {
    }

    public a(String r2) {
        this.f11907f = r2;
        this.f11908g = false;
        this.f11909h = "";
        this.f11910i = null;
        this.f11911j = "";
    }

    public static a c(String r1) {
        return new a(r1);
    }

    public static String e(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return r4;
    L6:
        if (r4.length() > 12) goto L9;
        return "***";
    L9:
        return r4.substring(0, 6) + "***" + r4.substring(r4.length() - 6);
    }

    public a a() {
        return (a) super.clone();
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    public String d() {
        return "BDAccountPlatformEntity{mName='" + this.f11907f + "', mPlatformId=" + this.q + ", mAccessToken='" + e(this.r) + "', mOpenId='" + e(this.s) + "', mScope='" + this.t + "', mExpire=" + this.n + "(" + s.d(this.n) + "), refreshAt=" + this.v + "(" + s.d(this.v) + ")}";
    }

    public void f() {
        this.f11908g = false;
        this.f11909h = "";
        this.f11910i = null;
        this.f11911j = "";
        this.f11912k = "";
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.m = 0;
        this.q = 0;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
    }

    public String toString() {
        return "BDAccountPlatformEntity{mName='" + this.f11907f + "', mLogin=" + this.f11908g + ", mNickname='" + this.f11909h + "', mAvatar='" + this.f11910i + "', mPlatformUid='" + this.f11911j + "', mSecPlatformUid='" + this.f11912k + "', mCreateTIme='" + this.f11913l + "', mModifyTime=" + this.m + ", mExpire=" + this.n + "(" + s.d(this.n) + "), mExpireIn=" + this.o + ", mUserId=" + this.p + ", mPlatformId=" + this.q + ", mAccessToken='" + this.r + "', mOpenId='" + this.s + "', mScope='" + this.t + "', mExtra='" + this.u + "', refreshAt=" + this.v + "(" + s.d(this.v) + "), refreshTime=" + this.w + '}';
    }
}

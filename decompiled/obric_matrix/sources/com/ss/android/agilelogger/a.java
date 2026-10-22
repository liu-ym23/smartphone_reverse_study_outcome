package com.ss.android.agilelogger;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f11831j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11832k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f11833l;

    /* JADX INFO: renamed from: com.ss.android.agilelogger.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0306a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f11834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f11835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f11836c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f11837d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f11838e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f11839f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f11840g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f11841h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f11842i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f11843j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f11844k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f11845l;

        public b(Context r3) {
            this.f11835b = 14;
            this.f11836c = 20971520;
            this.f11837d = 2097152;
            this.f11840g = true;
            this.f11841h = true;
            this.f11842i = 3;
            this.f11843j = "fecbb32b759120b672045f74edc41d159b6a426ffc863b9e0be9ad4be12824546f549959b838993a430344f15197221e87bd362298814c75f5068148b980306f";
            this.f11844k = true;
            this.f11845l = false;
            if (r3 == null) goto L10;
            Context r0 = r3.getApplicationContext();
            if (r0 == null) goto L7;
            r3 = r0;
        L7:
            this.f11834a = r3;
            return;
        L10:
            throw new RuntimeException("context must not be null");
        }

        public a a() {
            a r0 = new a(null);
            r0.o(this.f11834a);
            r0.s(this.f11835b);
            r0.u(this.f11836c);
            r0.w(this.f11837d);
            if (TextUtils.isEmpty(this.f11838e) == false) goto L5;
            String r1 = com.ss.android.agilelogger.h.a.a(this.f11834a);
        L6:
            r0.m(r1);
            if (TextUtils.isEmpty(this.f11839f) == false) goto L9;
            String r2 = com.ss.android.agilelogger.h.a.b(this.f11834a).getAbsolutePath();
        L10:
            r0.r(r2);
            r0.n(this.f11840g);
            r0.p(this.f11841h);
            r0.q(this.f11842i);
            r0.x(this.f11843j);
            r0.t(this.f11844k);
            r0.v(this.f11845l);
            return r0;
        L9:
            r2 = this.f11839f;
            goto L10
        L5:
            r1 = this.f11838e;
            goto L6
        }

        public b b(String r1) {
            this.f11838e = r1;
            return this;
        }

        public b c(int r1) {
            this.f11842i = r1;
            return this;
        }

        public b d(String r1) {
            this.f11839f = r1;
            return this;
        }

        public b e(int r1) {
            this.f11835b = r1;
            return this;
        }

        public b f(int r1) {
            this.f11836c = r1;
            return this;
        }

        public b g(int r1) {
            this.f11837d = r1;
            return this;
        }
    }

    private a() {
    }

    /* synthetic */ a(C0306a r1) {
        this();
    }

    public String a() {
        return this.f11826e;
    }

    public Context b() {
        return this.f11822a;
    }

    public int c() {
        return this.f11830i;
    }

    public String d() {
        return this.f11827f;
    }

    public int e() {
        return this.f11823b;
    }

    public int f() {
        return this.f11824c;
    }

    public int g() {
        return this.f11825d;
    }

    public String h() {
        return this.f11831j;
    }

    public boolean i() {
        return this.f11828g;
    }

    public boolean j() {
        return this.f11829h;
    }

    public boolean k() {
        return this.f11832k;
    }

    public boolean l() {
        return this.f11833l;
    }

    public void m(String r1) {
        this.f11826e = r1;
    }

    public void n(boolean r1) {
        this.f11828g = r1;
    }

    public void o(Context r1) {
        this.f11822a = r1;
    }

    public void p(boolean r1) {
        this.f11829h = r1;
    }

    public void q(int r1) {
        this.f11830i = r1;
    }

    public void r(String r1) {
        this.f11827f = r1;
    }

    public void s(int r1) {
        this.f11823b = r1;
    }

    public void t(boolean r1) {
        this.f11832k = r1;
    }

    public void u(int r1) {
        this.f11824c = r1;
    }

    public void v(boolean r1) {
        this.f11833l = r1;
    }

    public void w(int r1) {
        this.f11825d = r1;
    }

    public void x(String r1) {
        this.f11831j = r1;
    }
}

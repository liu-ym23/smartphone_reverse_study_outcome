package com.loc;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@a0(a = "a")
public final class t5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @b0(a = "a1", b = 6)
    private String f7837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b0(a = "a2", b = 6)
    private String f7838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @b0(a = "a6", b = 2)
    private int f7839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @b0(a = "a4", b = 6)
    private String f7840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @b0(a = "a5", b = 6)
    private String f7841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f7843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f7844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f7845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f7846j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String[] f7847k;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f7850c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f7851d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f7852e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f7853f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String[] f7854g;

        public a(String r2, String r3, String r4) {
            this.f7852e = true;
            this.f7853f = "standard";
            this.f7854g = null;
            this.f7848a = r3;
            this.f7849b = r3;
            this.f7851d = r4;
            this.f7850c = r2;
        }

        static /* synthetic */ String d(a r0) {
            return r0.f7848a;
        }

        static /* synthetic */ String e(a r0) {
            return r0.f7849b;
        }

        static /* synthetic */ String f(a r0) {
            return r0.f7850c;
        }

        static /* synthetic */ String g(a r0) {
            return r0.f7851d;
        }

        static /* synthetic */ boolean h(a r0) {
            return r0.f7852e;
        }

        static /* synthetic */ String i(a r0) {
            return r0.f7853f;
        }

        static /* synthetic */ String[] j(a r0) {
            return r0.f7854g;
        }

        public final a a(String r1) {
            this.f7849b = r1;
            return this;
        }

        public final a b(String[] r1) {
            if (r1 == null) goto L4;
            this.f7854g = (String[]) r1.clone();
        L4:
            return this;
        }

        public final t5 c() {
            if (this.f7854g == null) goto L7;
            return new t5(this, 0);
        L7:
            throw new h5("sdk packages is null");
        }
    }

    private t5() {
        this.f7839c = 1;
        this.f7847k = null;
    }

    private t5(a r2) {
        this.f7839c = 1;
        this.f7847k = null;
        this.f7842f = a.d(r2);
        this.f7843g = a.e(r2);
        this.f7845i = a.f(r2);
        this.f7844h = a.g(r2);
        this.f7839c = a.h(r2) ? 1 : 0;
        this.f7846j = a.i(r2);
        this.f7847k = a.j(r2);
        this.f7838b = u5.q(this.f7843g);
        this.f7837a = u5.q(this.f7845i);
        u5.q(this.f7844h);
        this.f7840d = u5.q(b(this.f7847k));
        this.f7841e = u5.q(this.f7846j);
    }

    /* synthetic */ t5(a r1, byte r2) {
        this(r1);
    }

    private static String b(String[] r5) {
        if (r5 != null) goto L13;
        return null;
    L13:
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L10
        int r2 = r5.length;     // Catch: Throwable -> L10
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        r1.append(r5[r3]);     // Catch: Throwable -> L10
        r1.append(";");     // Catch: Throwable -> L10
        r3 = r3 + 1;     // Catch: Throwable -> L10
        goto L6
    L8:
        return r1.toString();
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String[] d(String r1) {
        return r1.split(";");
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.f7845i) == false) goto L8;
        if (TextUtils.isEmpty(this.f7837a) == true) goto L8;
        this.f7845i = u5.u(this.f7837a);
    L8:
        return this.f7845i;
    }

    public final void c(boolean r1) {
        this.f7839c = r1 ? 1 : 0;
    }

    public final String e() {
        return this.f7842f;
    }

    public final boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5 != this) goto L9;
        return true;
    L9:
        if (t5.class == r5.getClass()) goto L20;
        return false;
    L20:
        if (this.f7845i.equals(((t5) r5).f7845i) == false) goto L18;
        if (this.f7842f.equals(((t5) r5).f7842f) == false) goto L18;
        if (this.f7843g.equals(((t5) r5).f7843g) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public final String f() {
        if (TextUtils.isEmpty(this.f7843g) == false) goto L8;
        if (TextUtils.isEmpty(this.f7838b) == true) goto L8;
        this.f7843g = u5.u(this.f7838b);
    L8:
        return this.f7843g;
    }

    public final String g() {
        if (TextUtils.isEmpty(this.f7846j) == false) goto L8;
        if (TextUtils.isEmpty(this.f7841e) == true) goto L8;
        this.f7846j = u5.u(this.f7841e);
    L8:
        if (TextUtils.isEmpty(this.f7846j) == false) goto L11;
        this.f7846j = "standard";
    L11:
        return this.f7846j;
    }

    public final boolean h() {
        if (this.f7839c != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public final String[] i() {
        String[] r0 = this.f7847k;
        if (r0 == null) goto L7;
        if (r0.length == 0) goto L7;
    L10:
        return (String[]) this.f7847k.clone();
    L7:
        if (TextUtils.isEmpty(this.f7840d) == true) goto L10;
        this.f7847k = d(u5.u(this.f7840d));
        goto L10
    }
}

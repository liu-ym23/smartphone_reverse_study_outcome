package com.obric.olog;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f10703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f10705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10706e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10707f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10708g;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.obric.olog.b$b, reason: collision with other inner class name */
    public static class C0290b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f10709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f10710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f10711c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f10712d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f10713e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f10714f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f10715g;

        public C0290b(Context r2) {
            this.f10710b = false;
            this.f10711c = 3;
            this.f10712d = true;
            this.f10715g = 14;
            if (r2 == null) goto L14;
            Context r0 = r2.getApplicationContext();
            if (r0 == null) goto L7;
            r2 = r0;
        L7:
            this.f10709a = r2;
            if (b() == false) goto L10;
            int r3 = 31457280;
        L11:
            this.f10714f = r3;
            return;
        L10:
            r3 = 20971520;
            goto L11
        L14:
            throw new RuntimeException("context must not be null");
        }

        private boolean b() {
            return Build.TYPE.equals("userdebug");
        }

        public b a() {
            b r0 = new b(null);
            r0.h(this.f10709a);
            r0.m(this.f10710b);
            r0.i(this.f10711c);
            r0.n(this.f10712d);
            r0.j(this.f10713e);
            r0.l(this.f10714f);
            r0.k(this.f10715g);
            return r0;
        }
    }

    private b() {
        this.f10703b = false;
        this.f10704c = 3;
        this.f10705d = true;
        this.f10708g = 14;
    }

    /* synthetic */ b(a r1) {
        this();
    }

    public Context a() {
        return this.f10702a;
    }

    public int b() {
        return this.f10704c;
    }

    public String c() {
        return this.f10706e;
    }

    public int d() {
        return this.f10708g;
    }

    public int e() {
        return this.f10707f;
    }

    public boolean f() {
        return this.f10703b;
    }

    public boolean g() {
        return this.f10705d;
    }

    public void h(Context r1) {
        this.f10702a = r1;
    }

    public void i(int r1) {
        this.f10704c = r1;
    }

    public void j(String r1) {
        this.f10706e = r1;
    }

    public void k(int r1) {
        this.f10708g = r1;
    }

    public void l(int r1) {
        this.f10707f = r1;
    }

    public void m(boolean r1) {
        this.f10703b = r1;
    }

    public void n(boolean r1) {
        this.f10705d = r1;
    }
}

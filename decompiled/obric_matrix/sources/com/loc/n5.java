package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;

/* JADX INFO: loaded from: classes2.dex */
public final class n5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile b f7573a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static n5 f7574a;

        static {
            f7574a = new n5();
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected boolean f7576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f7577c;

        private b() {
            this.f7575a = 0;
            this.f7576b = true;
            this.f7577c = false;
        }

        /* synthetic */ b(byte r1) {
            this();
        }

        public final void a(Context r3) {
            if (r3 != null) goto L5;
            return;
        L5:
            if (this.f7575a <= 0) goto L7;
            return;
        L7:
            if (Build.VERSION.SDK_INT < 4) goto L11;
            this.f7575a = r3.getApplicationContext().getApplicationInfo().targetSdkVersion;
            return;
        }

        public final void b(boolean r1) {
            this.f7576b = r1;
        }

        public final boolean c() {
            if (this.f7577c == false) goto L5;
        L27:
            return true;
        L5:
            if (Build.VERSION.SDK_INT < 28) goto L7;
            boolean r0 = true;
        L9:
            if (this.f7576b == false) goto L19;
            int r5 = this.f7575a;
            if (r5 > 0) goto L13;
            r5 = 28;
        L13:
            if (r5 < 28) goto L15;
            boolean r6 = true;
        L16:
            if (r6 == true) goto L19;
            boolean r7 = false;
        L20:
            if (r0 == false) goto L23;
            if (r7 == false) goto L23;
            boolean r8 = true;
        L24:
            if (r8 == true) goto L27;
            return false;
        L23:
            r8 = false;
            goto L24
        L15:
            r6 = false;
        L19:
            r7 = true;
            goto L20
        L7:
            r0 = false;
            goto L9
        }
    }

    public n5() {
        this.f7573a = new b(0);
        new d0("HttpsDecisionUtil");
    }

    public static n5 a() {
        return a.f7574a;
    }

    public static String b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return r2;
    L5:
        if (r2.startsWith(LocationInfoConst.HTTPS) == true) goto L13;
        Uri.Builder r1 = Uri.parse(r2).buildUpon();     // Catch: Throwable -> L9
        r1.scheme(LocationInfoConst.HTTPS);     // Catch: Throwable -> L9
        return r1.build().toString();
    L14:
        return r2;
    L13:
        return r2;
    }

    public static void f(Context r1) {
        g(r1, true);
    }

    private static void g(Context r1, boolean r2) {
        SharedPreferences.Editor r3 = d0.d(r1, "open_common");
        d0.l(r3, "a3", r2);
        d0.g(r3);
    }

    private static boolean i() {
        if (Build.VERSION.SDK_INT != 19) goto L6;
        return true;
    L6:
        return false;
    }

    public final void c(Context r5) {
        if (this.f7573a != null) goto L5;
        this.f7573a = new b(0);
    L5:
        this.f7573a.b(d0.m(r5, "open_common", "a3", true));
        this.f7573a.a(r5);
        h.a(r5).b();
    }

    final void d(Context r3, boolean r4) {
        if (this.f7573a != null) goto L5;
        this.f7573a = new b(0);
    L5:
        g(r3, r4);
        this.f7573a.b(r4);
    }

    public final boolean e(boolean r3) {
        if (i() == false) goto L5;
        return false;
    L5:
        if (r3 == false) goto L7;
        return true;
    L7:
        if (h() == true) goto L12;
        return false;
    L12:
        return true;
    }

    public final boolean h() {
        if (this.f7573a != null) goto L6;
        this.f7573a = new b(0);
    L6:
        return this.f7573a.c();
    }
}

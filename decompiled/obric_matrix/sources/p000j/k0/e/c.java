package p000j.k0.e;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import p000j.d0;
import p000j.f0;
import p000j.k0.g.d;
import p000j.k0.g.e;
import p000j.v;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f17811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f17812b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f17813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final d0 f17814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final f0 f17815c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Date f17816d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f17817e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Date f17818f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f17819g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Date f17820h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f17821i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f17822j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f17823k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f17824l;

        public a(long r4, d0 r6, f0 r7) {
            this.f17824l = -1;
            this.f17813a = r4;
            this.f17814b = r6;
            this.f17815c = r7;
            if (r7 == null) goto L22;
            this.f17821i = r7.d0();
            this.f17822j = r7.X();
            v r5 = r7.F();
            int r8 = 0;
            int r9 = r5.k();
        L5:
            if (r8 >= r9) goto L30;
            String r10 = r5.f(r8);
            String r1 = r5.m(r8);
            if ("Date".equalsIgnoreCase(r10) == false) goto L10;
            this.f17816d = d.b(r1);
            this.f17817e = r1;
        L21:
            r8 = r8 + 1;
            goto L5
        L10:
            if ("Expires".equalsIgnoreCase(r10) == false) goto L13;
            this.f17820h = d.b(r1);
            goto L21
        L13:
            if ("Last-Modified".equalsIgnoreCase(r10) == false) goto L16;
            this.f17818f = d.b(r1);
            this.f17819g = r1;
            goto L21
        L16:
            if ("ETag".equalsIgnoreCase(r10) == false) goto L19;
            this.f17823k = r1;
            goto L21
        L19:
            if ("Age".equalsIgnoreCase(r10) == false) goto L21;
            this.f17824l = e.f(r1, -1);
            goto L21
        L30:
            return;
        }

        private long a() {
            Date r0 = this.f17816d;
            long r1 = 0;
            if (r0 == null) goto L5;
            r1 = Math.max(0, this.f17822j - r0.getTime());
        L5:
            int r2 = this.f17824l;
            if (r2 == (-1)) goto L8;
            r1 = Math.max(r1, TimeUnit.SECONDS.toMillis(r2));
        L8:
            long r3 = this.f17822j;
            return (r1 + (r3 - this.f17821i)) + (this.f17813a - r3);
        }

        private long b() {
            p000j.d r0 = this.f17815c.b();
            if (r0.d() == (-1)) goto L7;
            return TimeUnit.SECONDS.toMillis(r0.d());
        L7:
            if (this.f17820h == null) goto L17;
            Date r1 = this.f17816d;
            if (r1 == null) goto L11;
            long r3 = r1.getTime();
        L12:
            long r5 = this.f17820h.getTime() - r3;
            if (r5 > 0) goto L15;
            return 0;
        L15:
            return r5;
        L11:
            r3 = this.f17822j;
            goto L12
        L17:
            if (this.f17818f != null) goto L19;
            return 0;
        L19:
            if (this.f17815c.Y().k().z() != null) goto L30;
            Date r2 = this.f17816d;
            if (r2 == null) goto L23;
            long r4 = r2.getTime();
        L24:
            long r6 = r4 - this.f17818f.getTime();
            if (r6 > 0) goto L27;
            return 0;
        L27:
            return r6 / 10;
        L23:
            r4 = this.f17821i;
            goto L24
        L30:
            return 0;
        }

        private c d() {
            if (this.f17815c != null) goto L7;
            return new c(this.f17814b, null);
        L7:
            if (this.f17814b.e() == false) goto L13;
            if (this.f17815c.x() != null) goto L13;
            return new c(this.f17814b, null);
        L13:
            if (c.a(this.f17815c, this.f17814b) == false) goto L15;
            p000j.d r0 = this.f17814b.b();
            if (r0.h() == true) goto L61;
            if (e(this.f17814b) == true) goto L61;
            p000j.d r2 = this.f17815c.b();
            long r3 = a();
            long r5 = b();
            if (r0.d() == (-1)) goto L24;
            r5 = Math.min(r5, TimeUnit.SECONDS.toMillis(r0.d()));
        L24:
            long r9 = 0;
            if (r0.f() == (-1)) goto L27;
            long r11 = TimeUnit.SECONDS.toMillis(r0.f());
        L29:
            if (r2.g() == true) goto L34;
            if (r0.e() == (-1)) goto L34;
            r9 = TimeUnit.SECONDS.toMillis(r0.e());
        L34:
            if (r2.h() == true) goto L47;
            long r12 = r11 + r3;
            if (r12 >= (r9 + r5)) goto L47;
            f0.a r1 = this.f17815c.Q();
            if (r12 < r5) goto L41;
            r1.a("Warning", "110 HttpURLConnection \"Response is stale\"");
        L41:
            if (r3 <= 86400000) goto L46;
            if (f() == false) goto L46;
            r1.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
        L46:
            return new c(null, r1.c());
        L47:
            String r4 = this.f17823k;
            String r6 = "If-Modified-Since";
            if (r4 == null) goto L51;
            r6 = "If-None-Match";
        L56:
            v.a r7 = this.f17814b.d().h();
            p000j.k0.a.f17790a.b(r7, r6, r4);
            d0.a r8 = this.f17814b.g();
            r8.e(r7.d());
            return new c(r8.b(), this.f17815c);
        L51:
            if (this.f17818f == null) goto L54;
            r4 = this.f17819g;
            goto L56
        L54:
            if (this.f17816d == null) goto L59;
            r4 = this.f17817e;
            goto L56
        L59:
            return new c(this.f17814b, null);
        L27:
            r11 = 0;
        L61:
            return new c(this.f17814b, null);
        L15:
            return new c(this.f17814b, null);
        }

        private static boolean e(d0 r1) {
            if (r1.c("If-Modified-Since") == null) goto L5;
        L8:
            return true;
        L5:
            if (r1.c("If-None-Match") != null) goto L8;
            return false;
        }

        private boolean f() {
            if (this.f17815c.b().d() == (-1)) goto L5;
        L7:
            return false;
        L5:
            if (this.f17820h != null) goto L7;
            return true;
        }

        public c c() {
            c r0 = d();
            if (r0.f17811a != null) goto L5;
        L8:
            return r0;
        L5:
            if (this.f17814b.b().j() == false) goto L8;
            return new c(null, null);
        }
    }

    c(d0 r1, f0 r2) {
        this.f17811a = r1;
        this.f17812b = r2;
    }

    public static boolean a(f0 r3, d0 r4) {
        int r0 = r3.s();
        if (r0 == 200) goto L35;
        if (r0 == 410) goto L35;
        if (r0 == 414) goto L35;
        if (r0 == 501) goto L35;
        if (r0 == 203) goto L35;
        if (r0 == 204) goto L35;
        if (r0 == 307) goto L25;
        if (r0 == 308) goto L35;
        if (r0 == 404) goto L35;
        if (r0 == 405) goto L35;
        switch(r0) {
            case 300: goto L35;
            case 301: goto L35;
            case 302: goto L25;
            default: goto L33;
        };
    L33:
        return false;
    L25:
        if (r3.A("Expires") != null) goto L35;
        if (r3.b().d() != (-1)) goto L35;
        if (r3.b().c() == true) goto L35;
        if (r3.b().b() == false) goto L33;
    L35:
        if (r3.b().i() == false) goto L37;
        return false;
    L37:
        if (r4.b().i() == true) goto L41;
        return true;
    L41:
        return false;
    }
}

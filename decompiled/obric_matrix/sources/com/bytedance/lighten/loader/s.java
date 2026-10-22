package com.bytedance.lighten.loader;

import android.app.ActivityManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.memory.d0;
import com.facebook.imagepipeline.memory.e0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class s {

    static class a implements com.facebook.imageutils.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.b.k.a.r f4977a;

        a(d.b.k.a.r r1) {
            this.f4977a = r1;
        }

        @Override // com.facebook.imageutils.c.a
        public void loadLibrary(String r1) {
            this.f4977a.n().loadLibrary(r1);
        }
    }

    static class b implements d.c.g.a.c.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.b.k.a.r f4978a;

        b(d.b.k.a.r r1) {
            this.f4978a = r1;
        }

        @Override // d.c.g.a.c.c
        public d.c.g.a.c.b a(d.c.g.a.a.a r4, Object r5, d.c.h.d r6, int r7) {
            d.b.k.a.y.c r8 = null;
            if ((r5 instanceof HashMap) == true) goto L6;
            return null;
        L6:
            if (this.f4978a.a() != null) goto L8;
        L30:
            return null;
        L8:
            if (this.f4978a.a().isEmpty() == true) goto L30;
            HashMap r9 = (HashMap) r5;
            Object r10 = r9.get("frame_scheduler_id");
            if ((r10 instanceof Integer) == true) goto L13;
            return null;
        L13:
            Object r11 = r9.get("frame_scheduler_listener");
            Iterator<d.b.k.a.a> r3 = this.f4978a.a().iterator();
        L15:
            if (r3.hasNext() == false) goto L19;
            d.b.k.a.a r0 = r3.next();
            if (((Integer) r10).intValue() != r0.b()) goto L15;
        L20:
            if (r0 != null) goto L22;
            return null;
        L22:
            d.c.g.a.b.a r12 = (d.c.g.a.b.a) ((d.c.g.a.a.b) r4).g();
            if (r12 != null) goto L25;
            return null;
        L25:
            int[] r13 = r0.a();
            if ((r11 instanceof d.b.k.a.y.c) == false) goto L28;
            r8 = (d.b.k.a.y.c) r11;
        L28:
            int[] r14 = s.a(r4, r13, r8);
            f r15 = new f(r4, r14);
            r12.q(new e(r14, r15));
            return r15;
        L19:
            r0 = null;
            goto L20
        }
    }

    static /* synthetic */ int[] a(d.c.g.a.a.a r0, int[] r1, d.b.k.a.y.c r2) {
        return e(r0, r1, r2);
    }

    private static void b(d.b.k.a.r r2) {
        d.h.a.d.h(r2.c());
        d.h.a.d.j(new t(r2.h()));
        d.h.a.d.k(false);
        d.h.a.d.l(true);
        d.h.a.d.i(r2.q());
    }

    private static d.c.b.b.c c(d.b.k.a.r r5) {
        d.c.b.b.c.b r0 = d.c.b.b.c.q(r5.c());
        r0.s(r5.f());
        r0.r("fresco_cache");
        if (r5.j() <= 0) goto L5;
        r0.u(r5.j());
    L5:
        r0.t(d.c.c.a.c.b());
        return r0.q();
    }

    private static d.c.b.b.c d(d.b.k.a.r r5) {
        d.c.b.b.c.b r0 = d.c.b.b.c.q(r5.c());
        r0.s(r5.f());
        r0.r("fresco_small_cache");
        if (r5.m() <= 0) goto L5;
        r0.u(r5.m());
    L5:
        r0.t(d.c.c.a.c.b());
        return r0.q();
    }

    private static int[] e(@NonNull d.c.g.a.a.a r9, @NonNull int[] r10, d.b.k.a.y.c r11) {
        int r12 = r9.a();
        ArrayList r0 = new ArrayList();
        int r1 = r10.length;
        int r3 = 0;
        int r6 = -1;
        int r4 = 0;
        boolean r5 = false;
    L4:
        if (r4 >= r1) goto L12;
        int r8 = r10[r4];
        if (r8 >= r12) goto L10;
        if (r8 <= (-1)) goto L10;
        if (r8 == r6) goto L10;
        r0.add(Integer.valueOf(r8));
        r6 = r8;
    L11:
        r4 = r4 + 1;
    L10:
        r5 = true;
        goto L11
    L12:
        if (r5 == true) goto L21;
        int r2 = r10.length;
        int r7 = 0;
    L14:
        if (r7 >= r2) goto L19;
        if (r10[r7] == (r12 - 1)) goto L17;
        r7 = r7 + 1;
        goto L14
    L17:
        boolean r13 = true;
    L20:
        r5 = !r13;
        goto L21
    L19:
        r13 = false;
    L21:
        if (r5 == false) goto L24;
        if (r11 == null) goto L24;
        r11.a(r12, r10);
    L24:
        int r14 = r0.size();
        int[] r15 = new int[r14];
    L25:
        if (r3 >= r14) goto L27;
        r15[r3] = ((Integer) r0.get(r3)).intValue();
        r3 = r3 + 1;
        goto L25
    L27:
        return r15;
    }

    private static void f(d.b.k.a.r r1) {
        AnimatedDrawable2.i(new b(r1));
    }

    private static void g(d.b.k.a.r r2, d.c.i.g.h.b r3) {
        if (r2.p() == false) goto L6;
        HashSet r0 = new HashSet();
        q.b(new d.h.a.e());
        r0.add(q.a());
        r3.M(r0);
        b(r2);
        return;
    }

    private static void h(d.b.k.a.r r4, d.c.i.g.h.b r5) {
        r5.E(new com.bytedance.lighten.loader.b((ActivityManager) r4.c().getSystemService("activity"), (int) r4.i()));
        r5.H(new g((int) r4.k()));
    }

    private static void i(d.b.k.a.r r2, d.c.i.g.h.b r3) {
        if (r2.r() == false) goto L6;
        r3.J(p.b());
        d0.b r0 = d0.l();
        r0.m(p.b());
        r3.L(new e0(r0.l()));
        return;
    }

    private static void j(d.b.k.a.r r1, d.c.i.g.h.b r2) {
        if (r1.g() == null) goto L6;
        r2.K(new n(r1.g()));
        return;
    }

    private static void k(d.b.k.a.r r1) {
        if (r1.l() < 0) goto L6;
        d.c.i.c.b.b.d(r1.l());
        return;
    }

    private static void l(d.b.k.a.r r1) {
        if (r1.n() != null) goto L5;
        return;
    L5:
        com.facebook.imageutils.c.c(new a(r1));
    }

    static d.c.i.g.h m(d.b.k.a.r r2) {
        if (d.c.f.a.a.c.c() == false) goto L5;
        Log.e("Lighten:", "Fresco has been initialized, lighten will override the fresco config!!!");
    L5:
        k(r2);
        d.c.i.g.h.b r0 = d.c.i.g.h.F(r2.c());
        r0.I(c(r2));
        r0.N(d(r2));
        r0.F(r2.b());
        r0.G(true);
        i(r2, r0);
        j(r2, r0);
        h(r2, r0);
        g(r2, r0);
        f(r2);
        l(r2);
        return r0.D();
    }
}

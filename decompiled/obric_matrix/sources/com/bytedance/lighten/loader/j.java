package com.bytedance.lighten.loader;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
class j {

    private static class a implements View.OnAttachStateChangeListener, View.OnTouchListener, b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        d.c.f.i.b<d.c.f.h.b> f4946f;

        public a(d.c.f.i.b<d.c.f.h.b> r1) {
            this.f4946f = r1;
        }

        @Override // com.bytedance.lighten.loader.j.b
        public void a(b r1) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r1, MotionEvent r2) {
            d.c.f.i.b<d.c.f.h.b> r0 = this.f4946f;
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.m(r2) == false) goto L10;
            return true;
        L10:
            return false;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r1) {
            d.c.f.i.b<d.c.f.h.b> r0 = this.f4946f;
            if (r0 == null) goto L6;
            r0.k();
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r1) {
            d.c.f.i.b<d.c.f.h.b> r0 = this.f4946f;
            if (r0 == null) goto L6;
            r0.l();
            return;
        }
    }

    public interface b {
        void a(b r1);
    }

    private static d.c.f.f.a a(ImageView r2, d.b.k.a.s r3) {
        if (r2 == null) goto L34;
        if (r3 == null) goto L36;
        d.c.f.f.d r0 = new d.c.f.f.d();
        if (r3.j() == null) goto L8;
        r0 = o.l(r0, r3.j());
    L8:
        d.c.f.f.b r1 = new d.c.f.f.b(r2.getResources());
        r1.u(r3.c());
        r1.D(r0);
        if (r3.a() == null) goto L12;
        r1.t(u.a(r3.a()));
    L12:
        if (r3.t() <= 0) goto L17;
        r1.y(r3.t());
        if (r3.v() == null) goto L20;
        r1.A(u.a(r3.v()));
    L20:
        if (r3.m() <= 0) goto L25;
        r1.w(r3.m());
        if (r3.n() == null) goto L25;
        r1.x(u.a(r3.n()));
    L25:
        if (r3.y() <= 0) goto L30;
        r1.B(r3.y());
        if (r3.z() == null) goto L30;
        r1.C(u.a(r3.z()));
    L30:
        if (r3.l() <= 0) goto L33;
        r1.v(r3.l());
    L33:
        return r1.a();
    L17:
        if (r3.u() == null) goto L20;
        r1.z(r3.u());
        goto L20
    L36:
        return null;
    L34:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void b(ImageView r8, d.b.k.a.s r9) {
        if (r8 == 0) goto L55;
        if (r9 == null) goto L57;
        Object r0 = d.b.k.a.z.a.a(r8);
        d.c.i.q.b[] r2 = null;
        if ((r0 instanceof d.c.f.i.b) == false) goto L8;
        d.c.f.i.b r1 = (d.c.f.i.b) r0;
    L9:
        c r3 = new c();
        r3.k(r9);
        boolean r4 = true;
        if (r1 != null) goto L35;
        r1 = d.c.f.i.b.e(null, r8.getContext());
        a r5 = new a(r1);
        r1.p(a(r8, r9));
        if (r9.C() == null) goto L17;
        if (r9.C().b() == true) goto L17;
        r2 = o.h(r9);
    L19:
        if (r2 != null) goto L21;
        return;
    L21:
        if (r2.length == 0) goto L54;
        d.c.f.a.a.e r6 = d.c.f.a.a.c.g();
        r6.x(r9.G());
        d.c.f.a.a.e r7 = r6;
        r7.z(r3);
        d.c.f.a.a.e r10 = r7;
        r10.E(r1.g());
        d.c.f.a.a.e r11 = r10;
        r11.A(r2);
        d.c.f.a.a.e r12 = r11;
        r12.F(false);
        d.c.f.a.a.e r13 = r12;
        if (r9.y() > 0) goto L27;
        r4 = false;
    L27:
        r13.G(r4);
        r1.o(r13.c());
        if ((r8 instanceof b) == false) goto L31;
        ((b) r8).a(r5);
    L31:
        if (c(r8) == false) goto L33;
        r5.onViewAttachedToWindow(r8);
    L33:
        r8.addOnAttachStateChangeListener(r5);
        r8.setOnTouchListener(r5);
        d.b.k.a.z.a.d(r8, r1);
    L52:
        r8.setImageDrawable(r1.i());
        return;
    L54:
        return;
    L17:
        if (r9.B() == null) goto L19;
        r2 = new d.c.i.q.b[]{o.g(r9, r9.B())};
        goto L19
    L35:
        r1.l();
        r1.p(a(r8, r9));
        if (r9.C() == null) goto L41;
        if (r9.C().b() == true) goto L41;
        r2 = o.h(r9);
    L43:
        if (r2 != null) goto L45;
        return;
    L45:
        if (r2.length == 0) goto L58;
        d.c.f.a.a.e r14 = d.c.f.a.a.c.g();
        r14.x(r9.G());
        d.c.f.a.a.e r15 = r14;
        r15.z(r3);
        d.c.f.a.a.e r16 = r15;
        r16.A(r2);
        d.c.f.a.a.e r17 = r16;
        r17.E(r1.g());
        d.c.f.a.a.e r18 = r17;
        r18.F(false);
        d.c.f.a.a.e r19 = r18;
        if (r9.y() > 0) goto L51;
        r4 = false;
    L51:
        r19.G(r4);
        r1.o(r19.c());
        r1.k();
        goto L52
    L58:
        return;
    L41:
        if (r9.B() == null) goto L43;
        r2 = new d.c.i.q.b[]{o.g(r9, r9.B())};
        goto L43
    L8:
        r1 = null;
        goto L9
    L57:
        return;
    }

    private static boolean c(View r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return r2.isAttachedToWindow();
    L7:
        if (r2.getWindowToken() == null) goto L9;
        return true;
    L9:
        return false;
    }
}

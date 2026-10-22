package com.obric.oui.panel.d;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f11228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f11229b;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f11230f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f11231g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f11232h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ a[] f11233i = null;

        static {
            a r1 = new a("NONE", 0);
            f11230f = r1;
            a r2 = new a("DOING", 1);
            f11231g = r2;
            a r3 = new a("DONE", 2);
            f11232h = r3;
            f11233i = new a[]{r1, r2, r3};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f11233i.clone();
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.panel.d.b$b, reason: collision with other inner class name */
    public static final class C0295b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f11234a;

        C0295b(b r1) {
            this.f11234a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r2) {
            o.f(r2, "animation");
            this.f11234a.e(a.f11232h);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            o.f(r2, "animation");
            this.f11234a.e(a.f11232h);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
            o.f(r1, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2) {
            o.f(r2, "animation");
            this.f11234a.e(a.f11231g);
        }
    }

    static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f11235a;

        c(l r1) {
            this.f11235a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            o.f(r2, "animation");
            v.a r0 = v.f21457g;     // Catch: Throwable -> L5
            this.f11235a.invoke(Float.valueOf(r2.getAnimatedFraction()));     // Catch: Throwable -> L5
            v.b(f0.f18324a);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            v.a r3 = v.f21457g;
            v.b(w.a(th));
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f11236a;

        d(b r1) {
            this.f11236a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r2) {
            o.f(r2, "animation");
            this.f11236a.f(a.f11232h);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            o.f(r2, "animation");
            this.f11236a.f(a.f11232h);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
            o.f(r1, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2) {
            o.f(r2, "animation");
            this.f11236a.f(a.f11231g);
        }
    }

    static final class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f11237a;

        e(l r1) {
            this.f11237a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            o.f(r2, "animation");
            v.a r0 = v.f21457g;     // Catch: Throwable -> L5
            v.b((f0) this.f11237a.invoke(Float.valueOf(r2.getAnimatedFraction())));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            v.a r3 = v.f21457g;
            v.b(w.a(th));
        }
    }

    public b() {
        a r0 = a.f11230f;
        this.f11228a = r0;
        this.f11229b = r0;
    }

    private final ObjectAnimator c(ObjectAnimator r2, l<? super Float, f0> r3) {
        r2.addListener(new C0295b(this));
        r2.addUpdateListener(new c(r3));
        return r2;
    }

    private final ObjectAnimator d(ObjectAnimator r2, l<? super Float, f0> r3) {
        r2.addListener(new d(this));
        r2.addUpdateListener(new e(r3));
        return r2;
    }

    public final void a(ObjectAnimator r3, l<? super Float, f0> r4) {
        o.f(r4, "animProgressListener");
        if (this.f11228a == a.f11230f) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        c(r3, r4);
        r3.start();
    }

    public final void b(ObjectAnimator r3, l<? super Float, f0> r4) {
        o.f(r4, "animProgressListener");
        if (this.f11229b == a.f11230f) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        d(r3, r4);
        r3.start();
    }

    public final void e(a r2) {
        o.f(r2, "<set-?>");
        this.f11228a = r2;
    }

    public final void f(a r2) {
        o.f(r2, "<set-?>");
        this.f11229b = r2;
    }
}

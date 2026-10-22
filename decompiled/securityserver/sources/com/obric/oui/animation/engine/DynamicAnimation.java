package com.obric.oui.animation.engine;

import android.view.View;
import com.obric.oui.animation.engine.DynamicAnimation;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {
    public static final ViewProperty m = null;
    public static final ViewProperty n = null;
    public static final ViewProperty o = null;
    public static final ViewProperty p = null;
    public static final ViewProperty q = null;
    public static final ViewProperty r = null;
    public static final ViewProperty s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f167a;
    public float b;
    public boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f168d;
    public final FloatPropertyCompat e;
    public boolean f;
    public float g;
    public float h;
    public long i;
    public final float j;
    public final ArrayList k;
    public final ArrayList l;

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.DynamicAnimation$1, reason: invalid class name */
    public class AnonymousClass1 extends ViewProperty {
        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final float a(Object r1) {
            return ((View) r1).getTranslationX();
        }

        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final void b(Object r1, float r2) {
            ((View) r1).setTranslationX(r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.DynamicAnimation$10, reason: invalid class name */
    public class AnonymousClass10 extends ViewProperty {
        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final float a(Object r1) {
            return ((View) r1).getY();
        }

        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final void b(Object r1, float r2) {
            ((View) r1).setY(r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.DynamicAnimation$11, reason: invalid class name */
    public class AnonymousClass11 extends ViewProperty {
        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final float a(Object r1) {
            return ((View) r1).getZ();
        }

        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final void b(Object r1, float r2) {
            ((View) r1).setZ(r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.DynamicAnimation$12, reason: invalid class name */
    public class AnonymousClass12 extends ViewProperty {
        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final float a(Object r1) {
            return ((View) r1).getAlpha();
        }

        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final void b(Object r1, float r2) {
            ((View) r1).setAlpha(r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.DynamicAnimation$13, reason: invalid class name */
    public class AnonymousClass13 extends ViewProperty {
        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final float a(Object r1) {
            return ((View) r1).getScrollX();
        }

        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final void b(Object r1, float r2) {
            ((View) r1).setScrollX((int) r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.DynamicAnimation$14, reason: invalid class name */
    public class AnonymousClass14 extends ViewProperty {
        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final float a(Object r1) {
            return ((View) r1).getScrollY();
        }

        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final void b(Object r1, float r2) {
            ((View) r1).setScrollY((int) r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.DynamicAnimation$15, reason: invalid class name */
    class AnonymousClass15 extends FloatPropertyCompat {
        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final float a(Object r1) {
            throw null;
        }

        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final void b(Object r1, float r2) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.DynamicAnimation$2, reason: invalid class name */
    public class AnonymousClass2 extends ViewProperty {
        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final float a(Object r1) {
            return ((View) r1).getTranslationY();
        }

        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final void b(Object r1, float r2) {
            ((View) r1).setTranslationY(r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.DynamicAnimation$3, reason: invalid class name */
    public class AnonymousClass3 extends ViewProperty {
        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final float a(Object r1) {
            return ((View) r1).getTranslationZ();
        }

        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final void b(Object r1, float r2) {
            ((View) r1).setTranslationZ(r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.DynamicAnimation$4, reason: invalid class name */
    public class AnonymousClass4 extends ViewProperty {
        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final float a(Object r1) {
            return ((View) r1).getScaleX();
        }

        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final void b(Object r1, float r2) {
            ((View) r1).setScaleX(r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.DynamicAnimation$5, reason: invalid class name */
    public class AnonymousClass5 extends ViewProperty {
        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final float a(Object r1) {
            return ((View) r1).getScaleY();
        }

        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final void b(Object r1, float r2) {
            ((View) r1).setScaleY(r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.DynamicAnimation$6, reason: invalid class name */
    public class AnonymousClass6 extends ViewProperty {
        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final float a(Object r1) {
            return ((View) r1).getRotation();
        }

        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final void b(Object r1, float r2) {
            ((View) r1).setRotation(r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.DynamicAnimation$7, reason: invalid class name */
    public class AnonymousClass7 extends ViewProperty {
        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final float a(Object r1) {
            return ((View) r1).getRotationX();
        }

        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final void b(Object r1, float r2) {
            ((View) r1).setRotationX(r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.DynamicAnimation$8, reason: invalid class name */
    public class AnonymousClass8 extends ViewProperty {
        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final float a(Object r1) {
            return ((View) r1).getRotationY();
        }

        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final void b(Object r1, float r2) {
            ((View) r1).setRotationY(r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.DynamicAnimation$9, reason: invalid class name */
    public class AnonymousClass9 extends ViewProperty {
        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final float a(Object r1) {
            return ((View) r1).getX();
        }

        @Override // com.obric.oui.animation.engine.FloatPropertyCompat
        public final void b(Object r1, float r2) {
            ((View) r1).setX(r2);
        }
    }

    public static class MassState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f169a;
        public float b;
    }

    public interface OnAnimationEndListener {
        void a(DynamicAnimation r1, boolean r2);
    }

    public interface OnAnimationUpdateListener {
        void a(DynamicAnimation r1, float r2, float r3);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
    }

    static {
        m = new AnonymousClass2();
        n = new AnonymousClass4();
        o = new AnonymousClass5();
        p = new AnonymousClass6();
        q = new AnonymousClass7();
        r = new AnonymousClass8();
        s = new AnonymousClass12();
    }

    public DynamicAnimation(Object r3, FloatPropertyCompat r4) {
        this.f167a = 0.0f;
        this.b = Float.MAX_VALUE;
        this.c = false;
        this.f = false;
        this.g = Float.MAX_VALUE;
        this.h = -Float.MAX_VALUE;
        this.i = 0;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.f168d = r3;
        this.e = r4;
        if (r4 != p) goto L5;
    L19:
        this.j = 0.1f;
        return;
    L5:
        if (r4 == q) goto L19;
        if (r4 == r) goto L19;
        if (r4 != s) goto L13;
        this.j = 0.00390625f;
        return;
    L13:
        if (r4 != n) goto L15;
    L18:
        this.j = 0.00390625f;
        return;
    L15:
        if (r4 == o) goto L18;
        this.j = 1.0f;
    }

    @Override // com.obric.oui.animation.engine.AnimationHandler.AnimationFrameCallback
    public final boolean a(long r8) {
        long r0 = this.i;
        if (r0 != 0) goto L6;
        this.i = r8;
        b(this.b);
        return false;
    L6:
        this.i = r8;
        boolean r9 = c(r8 - r0);
        float r10 = Math.min(this.b, this.g);
        this.b = r10;
        float r11 = Math.max(r10, this.h);
        this.b = r11;
        b(r11);
        if (r9 == false) goto L27;
        this.f = false;
        ThreadLocal r12 = AnimationHandler.f;
        if (r12.get() != null) goto L11;
        r12.set(new AnimationHandler());
    L11:
        AnimationHandler r13 = (AnimationHandler) r12.get();
        r13.f163a.remove(this);
        ArrayList r1 = r13.b;
        int r2 = r1.indexOf(this);
        if (r2 < 0) goto L14;
        r1.set(r2, null);
        r13.e = true;
    L14:
        this.i = 0;
        this.c = false;
        int r14 = 0;
    L15:
        ArrayList r3 = this.k;
        if (r14 >= r3.size()) goto L21;
        if (r3.get(r14) == null) goto L20;
        ((OnAnimationEndListener) r3.get(r14)).a(this, false);
    L20:
        r14 = r14 + 1;
        goto L15
    L21:
        int r7 = r3.size() - 1;
    L22:
        if (r7 < 0) goto L27;
        if (r3.get(r7) != null) goto L26;
        r3.remove(r7);
    L26:
        r7 = r7 - 1;
    L27:
        return r9;
    }

    public final void b(float r4) {
        this.e.b(this.f168d, r4);
        int r5 = 0;
    L3:
        ArrayList r0 = this.l;
        if (r5 >= r0.size()) goto L9;
        if (r0.get(r5) == null) goto L8;
        ((OnAnimationUpdateListener) r0.get(r5)).a(this, this.b, this.f167a);
    L8:
        r5 = r5 + 1;
        goto L3
    L9:
        int r3 = r0.size() - 1;
    L10:
        if (r3 < 0) goto L15;
        if (r0.get(r3) != null) goto L14;
        r0.remove(r3);
    L14:
        r3 = r3 - 1;
        goto L10
    }

    public abstract boolean c(long r1);
}

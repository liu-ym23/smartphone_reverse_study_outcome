package d.g.d.c.f;

import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.IdRes;
import com.obric.common.oui.f;
import com.obric.oui.animation.easy.SpringAnimationConfig;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.animation.engine.DynamicAnimation;
import com.obric.oui.animation.style.UtilKt;
import kotlin.f0;
import kotlin.m;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16894a = null;

    /* JADX INFO: renamed from: d.g.d.c.f.a$a, reason: collision with other inner class name */
    public static final enum EnumC0444a extends Enum<EnumC0444a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0444a f16895g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0444a f16896h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final EnumC0444a f16897i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ EnumC0444a[] f16898j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float f16899f;

        static {
            EnumC0444a r1 = new EnumC0444a("SMALL", 0, 0.4f);
            f16895g = r1;
            EnumC0444a r2 = new EnumC0444a("MEDIUM", 1, 0.8f);
            f16896h = r2;
            EnumC0444a r3 = new EnumC0444a("LARGE", 2, 1.0f);
            f16897i = r3;
            f16898j = new EnumC0444a[]{r1, r2, r3};
        }

        private EnumC0444a(String r1, int r2, float r3) {
            super(r1, r2);
            this.f16899f = r3;
        }

        public static EnumC0444a valueOf(String r1) {
            return (EnumC0444a) Enum.valueOf(EnumC0444a.class, r1);
        }

        public static EnumC0444a[] values() {
            return (EnumC0444a[]) f16898j.clone();
        }

        public final float a() {
            return this.f16899f;
        }
    }

    static final class b implements DynamicAnimation.OnAnimationUpdateListener {
        b(float r1, float r2, float r3, float r4, Window r5, boolean r6, int r7) {
        }
    }

    static final class c extends q implements l<SpringAnimationConfig, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f16900f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f16901g;

        c(float r1, float r2) {
            this.f16900f = r1;
            this.f16901g = r2;
            super(1);
        }

        public final void a(SpringAnimationConfig r2) {
            o.f(r2, "$receiver");
            r2.setDampingRatio(this.f16900f);
            r2.setStiffness(this.f16901g);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(SpringAnimationConfig r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    static final class d implements DynamicAnimation.OnAnimationUpdateListener {
        d(float r1, float r2, Window r3, boolean r4, int r5, float r6) {
        }
    }

    static final class e extends q implements l<SpringAnimationConfig, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f16902f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f16903g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f16904h;

        e(float r1, float r2, int r3) {
            this.f16902f = r1;
            this.f16903g = r2;
            this.f16904h = r3;
            super(1);
        }

        public final void a(SpringAnimationConfig r2) {
            o.f(r2, "$receiver");
            r2.setDampingRatio(this.f16902f);
            r2.setStiffness(this.f16903g);
            r2.setStartValue(this.f16904h);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(SpringAnimationConfig r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    static {
        f16894a = new a();
    }

    private a() {
    }

    private final EnumC0444a b(View r1, int r2) {
        if (r2 <= 0) goto L4;
        float r0 = r1.getHeight() / r2;
        EnumC0444a r3 = EnumC0444a.f16895g;
        if (r0 < r3.a()) goto L13;
        EnumC0444a r4 = EnumC0444a.f16896h;
        if (r0 >= r4.a()) goto L12;
        return r4;
    L12:
        return EnumC0444a.f16897i;
    L13:
        return r3;
    L4:
        return EnumC0444a.f16896h;
    }

    private final u<Float, Float> c(boolean r4, EnumC0444a r5, boolean r6) {
        Float r3 = Float.valueOf(1.0f);
        if (r4 == true) goto L7;
        return new u(r3, Float.valueOf(480.0f));
    L7:
        if (r6 == false) goto L18;
        int r7 = d.g.d.c.f.b.f16905a[r5.ordinal()];
        if (r7 == 1) goto L31;
        if (r7 == 2) goto L30;
        if (r7 != 3) goto L15;
        return new u(r3, Float.valueOf(247.0f));
    L15:
        throw new m();
    L30:
        return new u(Float.valueOf(0.85f), Float.valueOf(247.0f));
    L31:
        return new u(Float.valueOf(0.85f), Float.valueOf(439.0f));
    L18:
        int r8 = d.g.d.c.f.b.f16906b[r5.ordinal()];
        if (r8 == 1) goto L28;
        if (r8 == 2) goto L33;
        if (r8 != 3) goto L25;
        return new u(r3, Float.valueOf(322.0f));
    L25:
        throw new m();
    L33:
        return new u(Float.valueOf(0.85f), Float.valueOf(322.0f));
    L28:
        return new u(Float.valueOf(0.85f), Float.valueOf(632.0f));
    }

    public static /* synthetic */ ViewPropertySpringAnimator e(a r1, View r2, Window r3, boolean r4, boolean r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = true;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r5 = true;
    L12:
        return r1.d(r2, r3, r4, r5);
    }

    public static /* synthetic */ ViewPropertySpringAnimator g(a r6, View r7, Window r8, boolean r9, float r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r8 = null;
    L5:
        Window r2 = r8;
        if ((r12 & 2) == 0) goto L8;
        boolean r3 = true;
    L10:
        if ((r12 & 4) == 0) goto L12;
        r10 = 0.6f;
    L12:
        float r4 = r10;
        if ((r12 & 8) == 0) goto L15;
        boolean r5 = true;
    L17:
        return r6.f(r7, r2, r3, r4, r5);
    L15:
        r5 = r11;
        goto L17
    L8:
        r3 = r9;
        goto L10
    }

    private final <T extends View> ViewPropertySpringAnimator<T> h(T r3, @IdRes int r4) {
        d.g.d.f.b r2 = d.g.d.f.b.f16934a;
        Object r5 = r3.getTag(r4);
        if (r5 != null) goto L6;
    L4:
        r5 = null;
    L7:
        ViewPropertySpringAnimator<T> r6 = (ViewPropertySpringAnimator) r5;
        if (r6 != null) goto L11;
        ViewPropertySpringAnimator<T> r7 = new ViewPropertySpringAnimator(r3);
        r3.setTag(r4, r7);
        return r7;
    L11:
        return r6;
    L6:
        if ((r5 instanceof ViewPropertySpringAnimator) == false) goto L4;
        goto L4
    }

    public final void a(View r4) {
        o.f(r4, "container");
        Resources r0 = Resources.getSystem();
        o.e(r0, "Resources.getSystem()");
        int r3 = kotlin.o0.a.a(TypedValue.applyDimension(1, 10, r0.getDisplayMetrics()));
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2.topMargin >= r3) goto L7;
        r2.topMargin = r3;
    L7:
        f0 r5 = f0.f18324a;
        r4.setLayoutParams(r1);
    }

    public final ViewPropertySpringAnimator<View> d(View r12, Window r13, boolean r14, boolean r15) {
        o.f(r12, "$this$dialogBottomHide");
        Resources r0 = Resources.getSystem();
        o.e(r0, "Resources.getSystem()");
        int r1 = r0.getDisplayMetrics().heightPixels;
        int r2 = r12.getHeight();
        Resources r4 = Resources.getSystem();
        o.e(r4, "Resources.getSystem()");
        int r10 = r2 + kotlin.o0.a.a(TypedValue.applyDimension(1, 32, r4.getDisplayMetrics()));
        u<Float, Float> r16 = c(r15, b(r12, r1), false);
        float r5 = r10;
        ViewPropertySpringAnimator<View> r11 = h(r12, f.i0).translationY(r5, new c(r16.a().floatValue(), r16.b().floatValue()));
        if (r13 == null) goto L10;
        if (r14 == false) goto L10;
        r13.addFlags(2);     // Catch: Exception -> L8
        r11.setUpdateListener(new b(0.0f, r5, r13.getAttributes().dimAmount, 0.0f, r13, r14, r10));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.w("DialogAnimStyle", "dialogBottomHide, can't show dim anim: " + e.getMessage());
    L10:
        UtilKt.hideSoftKeyboard(r12);
        return r11;
    }

    public final ViewPropertySpringAnimator<View> f(View r10, Window r11, boolean r12, float r13, boolean r14) {
        o.f(r10, "$this$dialogBottomShow");
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        int r3 = r2.getDisplayMetrics().heightPixels;
        int r5 = r10.getHeight();
        Resources r7 = Resources.getSystem();
        o.e(r7, "Resources.getSystem()");
        int r6 = r5 + kotlin.o0.a.a(TypedValue.applyDimension(1, 32, r7.getDisplayMetrics()));
        r10.setAlpha(1.0f);
        u<Float, Float> r4 = c(r14, b(r10, r3), true);
        ViewPropertySpringAnimator<View> r8 = h(r10, f.h0).translationY(0.0f, new e(r4.a().floatValue(), r4.b().floatValue(), r6));
        if (r11 == null) goto L10;
        if (r12 == false) goto L10;
        r11.addFlags(2);     // Catch: Exception -> L8
        r8.setUpdateListener(new d(r6, 0.0f, r11, r12, r6, r13));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.w("DialogAnimStyle", "dialogBottomShow, can't show dim anim: " + e.getMessage());
    L10:
        return r8;
    }
}

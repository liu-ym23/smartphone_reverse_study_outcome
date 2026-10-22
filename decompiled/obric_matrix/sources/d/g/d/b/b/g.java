package d.g.d.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import androidx.core.content.ContextCompat;
import java.lang.ref.WeakReference;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
public class g implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WeakReference<View> f16764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16765g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f16766h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f16767i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f16768j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f16769k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f16770l;
    private int m;
    private float n;
    private Context o;
    private AttributeSet p;
    private int q;
    private int r;
    private ColorDrawable s;
    private ColorDrawable t;
    private ObjectAnimator u;
    private ObjectAnimator v;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f16771a;

        a(g r1) {
            this.f16771a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            g.a(this.f16771a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r1) {
            g.a(this.f16771a);
        }
    }

    public g(Context r3, AttributeSet r4, int r5, int r6) {
        this.f16765g = true;
        this.f16766h = false;
        this.f16767i = true;
        this.f16768j = false;
        this.f16769k = false;
        this.f16770l = 1.0f;
        this.m = 0;
        this.n = 0.3f;
        this.o = r3;
        this.p = r4;
        this.q = r5;
        this.r = r6;
    }

    static /* synthetic */ void a(g r0) {
        r0.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
        View r0 = this.f16764f.get();
        if (r0 != 0) goto L6;
        return;
    L6:
        if (this.f16765g == false) goto L12;
        if (r0.isPressed() == false) goto L12;
    L9:
        ColorDrawable r2 = this.s;
    L10:
        r0.setForeground(r2);
        return;
    L12:
        if (this.f16765g == false) goto L19;
        if ((r0 instanceof f) == false) goto L19;
        if (((f) r0).a() == true) goto L9;
    L19:
        if (this.f16768j == true) goto L21;
    L23:
        r2 = null;
        goto L10
    L21:
        if (r0.isSelected() == false) goto L23;
        r2 = this.t;
        goto L10
    }

    private void e(View r11) {
        int r0 = ContextCompat.getColor(r11.getContext(), com.obric.common.oui.c.E);
        boolean r4 = false;
        int[] r2 = {ContextCompat.getColor(r11.getContext(), com.obric.common.oui.c.v), ContextCompat.getColor(r11.getContext(), com.obric.common.oui.c.H)};
        this.m = r0;
        TypedArray r3 = this.o.obtainStyledAttributes(this.p, com.obric.common.oui.k.Y0, this.q, this.r);
        if (this.p == null) goto L5;
    L8:
        int r6 = r3.getIndexCount();
        int r7 = 0;
    L9:
        if (r7 >= r6) goto L18;
        int r8 = r3.getIndex(r7);
        if (r8 != com.obric.common.oui.k.a1) goto L14;
        this.m = r3.getColor(r8, r0);
    L16:
        r7 = r7 + 1;
        goto L9
    L14:
        if (r8 != com.obric.common.oui.k.Z0) goto L16;
        this.n = r3.getFloat(r8, -1.0f);
    L18:
        if (this.m != r0) goto L27;
        Drawable r1 = r11.getBackground();
        if ((r1 instanceof ColorDrawable) == false) goto L27;
        int r5 = 0;
    L22:
        if (r5 >= 2) goto L27;
        if (((ColorDrawable) r1).getColor() != r2[r5]) goto L26;
        this.m = ContextCompat.getColor(r11.getContext(), com.obric.common.oui.c.M);
    L26:
        r5 = r5 + 1;
    L27:
        this.s = new ColorDrawable(this.m);
        this.t = new ColorDrawable(this.m);
        if (this.m <= 0) goto L30;
        boolean r9 = true;
    L31:
        this.f16765g = r9;
        if (this.n <= 0.0f) goto L34;
        r4 = true;
    L34:
        this.f16767i = r4;
        l(r11, r11.isEnabled());
        if (Build.VERSION.SDK_INT < 23) goto L45;
        ObjectAnimator r12 = ObjectAnimator.ofInt(this.s, "alpha", new int[]{0, 255});
        this.u = r12;
        r12.setDuration(10);
        this.u.setInterpolator(new DecelerateInterpolator());
        this.u.addUpdateListener(new d.g.d.b.b.a(this));
        ObjectAnimator r13 = ObjectAnimator.ofInt(this.s, "alpha", new int[]{255, 0});
        this.v = r13;
        r13.setDuration(300);
        this.v.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.v.addListener(new a(this));
        this.v.addUpdateListener(new b(this));
        return;
    L45:
        return;
    L30:
        r9 = false;
        goto L31
    L5:
        if (this.q != 0) goto L8;
        if (this.r == 0) goto L18;
        goto L8
    }

    private /* synthetic */ void g(ValueAnimator r2) {
        o(r2, "press anim");
    }

    private /* synthetic */ void i(ValueAnimator r2) {
        o(r2, "release anim");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ f0 k(boolean r1, View r2) {
        if ((r2 instanceof e) == false) goto L7;
        ((e) r2).setKeepPressAlpha(r1);
        return null;
    L7:
        return null;
    }

    private void o(ValueAnimator r4, String r5) {
        KeyEvent.Callback r3 = (View) this.f16764f.get();
        if ((r3 instanceof f) == true) goto L5;
        return;
    L5:
        f r6 = (f) r3;
        Object r7 = r4.getAnimatedValue("alpha");
        if (r6.d() == false) goto L16;
        if ((r7 instanceof Integer) == false) goto L16;
        int r0 = ((Integer) r7).intValue();
        if (r0 >= 0) goto L12;
    L14:
        d.g.d.f.f.b.b("OUIAlphaHelper", "pressColorAnimSideEffect, invalid alpha: " + r0 + ", scene: " + r5);
        goto L16
    L12:
        if (r0 > 255) goto L14;
        r6.e((255 - r0) / 255.0f);
    L16:
        if ((r7 instanceof Integer) == false) goto L19;
        r6.c(((Integer) r7).intValue());
        return;
    }

    private void q() {
        this.u.cancel();
        this.v.cancel();
        this.s.setAlpha(0);
        View r2 = this.f16764f.get();
        if (r2 == null) goto L6;
        r2.setForeground(null);
        return;
    }

    @Override // d.g.d.b.b.e
    public void b(String r1) {
        View r2 = this.f16764f.get();
        if (r2 != null) goto L6;
        d.g.d.f.f.b.b("OUIAlphaHelper", "refreshColors: owner is null");
        return;
    L6:
        e(r2);
    }

    public void d(MotionEvent r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        int r3 = r2.getAction();
        if (r3 == 1) goto L10;
        if (r3 == 3) goto L10;
        return;
    L10:
        if (this.f16769k == false) goto L13;
        q();
        return;
    }

    public void f(View r2) {
        this.f16764f = new WeakReference(r2);
        e(r2);
    }

    public /* synthetic */ void h(ValueAnimator r1) {
        g(r1);
    }

    public /* synthetic */ void j(ValueAnimator r1) {
        i(r1);
    }

    public void l(View r3, boolean r4) {
        View r0 = this.f16764f.get();
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.f16767i == false) goto L10;
        if (r4 == true) goto L10;
        float r2 = this.n;
    L11:
        if (r3 != r0) goto L13;
    L15:
        r0.setAlpha(r2);
        return;
    L13:
        if (r0.isEnabled() == r4) goto L15;
        r0.setEnabled(r4);
    L10:
        r2 = this.f16770l;
        goto L11
    }

    public void m(View r1, boolean r2) {
        if (this.f16764f.get() != null) goto L5;
        return;
    L5:
        this.u.cancel();
        this.v.cancel();
        if (this.f16765g == true) goto L8;
        return;
    L8:
        if (this.f16766h == true) goto L17;
        if (r2 == false) goto L13;
        c();
        ObjectAnimator r0 = this.u;
    L11:
        r0.start();
        return;
    L13:
        if (this.f16769k == false) goto L15;
        q();
        return;
    L15:
        r0 = this.v;
        goto L11
    }

    public void n(View r1, boolean r2) {
        if (this.f16768j == false) goto L6;
        c();
        return;
    }

    public void p(boolean r1, boolean r2) {
        this.f16765g = r1;
        View r3 = this.f16764f.get();
        if (r3 == null) goto L7;
        if (r2 == false) goto L8;
        m(r3, r3.isPressed());
        return;
    L8:
        return;
    }

    @Override // d.g.d.b.b.e
    public void setChangeAlphaWhenDisable(boolean r2) {
        this.f16767i = r2;
        View r3 = this.f16764f.get();
        if (r3 == null) goto L6;
        l(r3, r3.isEnabled());
        return;
    }

    @Override // d.g.d.b.b.e
    public void setChangeAlphaWhenPress(boolean r2) {
        p(r2, false);
    }

    @Override // d.g.d.b.b.e
    public void setChangeAlphaWhenSelected(boolean r1) {
        this.f16768j = r1;
    }

    @Override // d.g.d.b.b.e
    public void setKeepPressAlpha(final boolean r3) {
        d.g.d.f.f.b.i("OUIAlphaHelper", "setKeepPressAlpha, " + r3 + ", target: " + this.f16764f.get());
        if (this.f16766h == r3) goto L7;
        this.f16766h = r3;
        if (r3 == true) goto L7;
        m(this.f16764f.get(), false);
    L7:
        d.g.d.f.e.b(this.f16764f.get(), new c(r3));
    }
}

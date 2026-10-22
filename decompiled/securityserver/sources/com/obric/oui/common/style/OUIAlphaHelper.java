package com.obric.oui.common.style;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import androidx.core.content.ContextCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.utils.log.L;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class OUIAlphaHelper implements IOUIAlpha {
    public WeakReference b;
    public boolean c;
    public boolean e;
    public boolean f;
    public boolean i;
    public int j;
    public int k;
    public float l;
    public Context m;
    public AttributeSet n;
    public int o;
    public int p;
    public ColorDrawable q;
    public ColorDrawable r;
    public ObjectAnimator s;
    public ObjectAnimator t;

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        View r0 = (View) this.b.get();
        if (r0 != 0) goto L6;
        return;
    L6:
        if (this.c == false) goto L11;
        if (r0.isPressed() == false) goto L11;
        r0.setForeground(this.q);
        return;
    L11:
        if (this.c == false) goto L18;
        if ((r0 instanceof IOUILayout) == false) goto L18;
        if (((IOUILayout) r0).a() == false) goto L18;
        r0.setForeground(this.q);
        return;
    L18:
        if (this.i == true) goto L20;
    L22:
        r0.setForeground(null);
        return;
    L20:
        if (r0.isSelected() == false) goto L22;
        r0.setForeground(this.r);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public final void b(View r1, boolean r2) {
        if (this.i == false) goto L6;
        a();
        return;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public final void c(String r1) {
        View r2 = (View) this.b.get();
        if (r2 != null) goto L6;
        L.b("OUIAlphaHelper", "refreshColors: owner is null");
        return;
    L6:
        d(r2);
    }

    public final void d(View r10) {
        int r0 = this.k;
        if (r0 != (-1)) goto L5;
        r0 = ContextCompat.getColor(r10.getContext(), R.color.oui_fill_element_3);
    L5:
        int[] r1 = {ContextCompat.getColor(r10.getContext(), R.color.oui_accent_bg), ContextCompat.getColor(r10.getContext(), R.color.oui_functional_red_6)};
        this.j = r0;
        int[] r2 = com.obric.common.oui.R.styleable.t;
        Context r3 = this.m;
        AttributeSet r4 = this.n;
        int r5 = this.o;
        int r6 = this.p;
        TypedArray r7 = r3.obtainStyledAttributes(r4, r2, r5, r6);
        boolean r8 = true;
        if (r4 != null) goto L9;
        if (r5 != 0) goto L9;
        if (r6 != 0) goto L9;
    L18:
        if (this.j != r0) goto L28;
        Drawable r9 = r10.getBackground();
        if ((r9 instanceof ColorDrawable) == false) goto L28;
        int r11 = 0;
    L23:
        if (r11 >= 2) goto L28;
        if (((ColorDrawable) r9).getColor() != r1[r11]) goto L27;
        this.j = ContextCompat.getColor(r10.getContext(), R.color.oui_pressed_on_color);
    L27:
        r11 = r11 + 1;
    L28:
        this.q = new ColorDrawable(this.j);
        this.r = new ColorDrawable(this.j);
        if (this.j <= 0) goto L31;
        boolean r12 = true;
    L32:
        this.c = r12;
        if (this.l > 0.0f) goto L36;
        r8 = false;
    L36:
        this.f = r8;
        e(r10, r10.isEnabled());
        ObjectAnimator r13 = ObjectAnimator.ofInt(this.q, "alpha", new int[]{0, 255});
        this.s = r13;
        r13.setDuration(10);
        this.s.setInterpolator(new DecelerateInterpolator());
        final int r14 = 0;
        this.s.addUpdateListener(new a(this, r14));
        ObjectAnimator r15 = ObjectAnimator.ofInt(this.q, "alpha", new int[]{255, 0});
        this.t = r15;
        r15.setDuration(300);
        this.t.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.t.addListener(new AnonymousClass1(this));
        final int r16 = 1;
        this.t.addUpdateListener(new a(this, r16));
        return;
    L31:
        r12 = false;
    L9:
        int r17 = r7.getIndexCount();
        int r18 = 0;
    L10:
        if (r18 >= r17) goto L18;
        int r19 = r7.getIndex(r18);
        if (r19 != 1) goto L14;
        this.j = r7.getColor(r19, r0);
    L16:
        r18 = r18 + 1;
        goto L10
    L14:
        if (r19 != 0) goto L16;
        this.l = r7.getFloat(r19, -1.0f);
        goto L16
    }

    public final void e(View r4, boolean r5) {
        View r0 = (View) this.b.get();
        if (r0 != null) goto L5;
        return;
    L5:
        float r2 = 1.0f;
        if (this.f == false) goto L10;
        if (r5 == true) goto L10;
        r2 = this.l;
    L10:
        if (r4 != r0) goto L12;
    L14:
        r0.setAlpha(r2);
        return;
    L12:
        if (r0.isEnabled() == r5) goto L14;
        r0.setEnabled(r5);
        goto L14
    }

    public final void f(boolean r2) {
        if (((View) this.b.get()) != null) goto L5;
        return;
    L5:
        this.s.cancel();
        this.t.cancel();
        if (this.c == true) goto L8;
        return;
    L8:
        if (this.e == true) goto L14;
        if (r2 == false) goto L11;
        a();
        this.s.start();
        return;
    L11:
        this.t.start();
        return;
    }

    public final void g(ValueAnimator r4, String r5) {
        KeyEvent.Callback r3 = (View) this.b.get();
        if ((r3 instanceof IOUILayout) == true) goto L5;
        return;
    L5:
        IOUILayout r6 = (IOUILayout) r3;
        Object r7 = r4.getAnimatedValue("alpha");
        if (r6.e() == false) goto L16;
        if ((r7 instanceof Integer) == false) goto L16;
        int r0 = ((Integer) r7).intValue();
        if (r0 >= 0) goto L12;
    L14:
        L.b("OUIAlphaHelper", "pressColorAnimSideEffect, invalid alpha: " + r0 + ", scene: " + r5);
        goto L16
    L12:
        if (r0 > 255) goto L14;
        r6.f((255 - r0) / 255.0f);
    L16:
        if ((r7 instanceof Integer) == false) goto L19;
        r6.d(((Integer) r7).intValue());
        return;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public final void setChangeAlphaWhenDisable(boolean r2) {
        this.f = r2;
        View r3 = (View) this.b.get();
        if (r3 == null) goto L6;
        e(r3, r3.isEnabled());
        return;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public final void setChangeAlphaWhenPress(boolean r1) {
        this.c = r1;
        View r0 = (View) this.b.get();
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public final void setKeepPressAlpha(boolean r5) {
        L.f("OUIAlphaHelper", "setKeepPressAlpha, " + r5 + ", target: " + this.b.get());
        int r1 = 0;
        if (this.e == r5) goto L7;
        this.e = r5;
        if (r5 == true) goto L7;
        View r0 = (View) this.b.get();
        f(false);
    L7:
        View r4 = (View) this.b.get();
        if (r4 != null) goto L11;
        return;
    L11:
        if ((r4 instanceof ViewGroup) == false) goto L20;
        ViewGroup r6 = (ViewGroup) r4;
        int r2 = r6.getChildCount();
    L13:
        if (r1 >= r2) goto L26;
        KeyEvent.Callback r3 = r6.getChildAt(r1);
        if (r3 == null) goto L19;
        if ((r3 instanceof IOUIAlpha) == false) goto L19;
        ((IOUIAlpha) r3).setKeepPressAlpha(r5);
    L19:
        r1 = r1 + 1;
        goto L13
    L26:
        return;
    }
}

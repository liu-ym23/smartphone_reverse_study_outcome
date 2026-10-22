package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.e;
import com.obric.common.oui.k;
import com.obric.oui.common.util.j;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F\u0012\b\b\u0002\u0010H\u001a\u00020 ¢\u0006\u0004\bI\u0010JJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u001b\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c*\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010#\u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\tH\u0016¢\u0006\u0004\b&\u0010\u0019J\u0017\u0010'\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b)\u0010\u0019J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010\u0019J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010\u0019J\u001f\u0010.\u001a\u00020\u00042\u0006\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020 H\u0016¢\u0006\u0004\b.\u0010$J7\u00104\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020 H\u0014¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0004H\u0014¢\u0006\u0004\b6\u0010\bR\u0016\u00109\u001a\u00020 8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\t8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010?¨\u0006K"}, d2 = {"Lcom/obric/oui/oswitch/OSwitch;", "Lcom/obric/oui/oswitch/b;", "Landroid/view/MotionEvent;", "ev", "Lkotlin/f0;", "m", "(Landroid/view/MotionEvent;)V", "u", "()V", "", "checked", "withAnim", "t", "(ZZ)V", "Landroid/graphics/drawable/Drawable;", "getUncheckedDrawable", "()Landroid/graphics/drawable/Drawable;", "getCheckedDrawable", "Landroid/content/Context;", "context", "isChecked", "Lcom/obric/oui/oswitch/a;", "r", "(Landroid/content/Context;Z)Lcom/obric/oui/oswitch/a;", "o", "(Z)V", "n", "Landroid/graphics/drawable/TransitionDrawable;", "", "kotlin.jvm.PlatformType", "s", "(Landroid/graphics/drawable/TransitionDrawable;)Ljava/lang/Object;", "", "xAmount", "yAmount", "p", "(II)V", "enabled", "setEnabled", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "setCheckedWithoutFeedback", "setChecked", "setCheckedNoAnim", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "onAttachedToWindow", "getTouchMode", "()I", "touchMode", "", "getThumbPosition", "()F", "thumbPosition", "e0", "I", "trackChecked", "getTargetCheckedState", "()Z", "targetCheckedState", "d0", "trackUnchecked", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OSwitch extends b {
    private int d0;
    private int e0;

    static {
    }

    public OSwitch(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public OSwitch(Context r3, AttributeSet r4, int r5) {
        o.f(r3, "context");
        super(r3, r4, r5);
        int[] r0 = k.V0;
        o.e(r0, "R.styleable.OSwitch");
        TypedArray r6 = r3.obtainStyledAttributes(r4, r0, r5, 0);
        this.d0 = r6.getResourceId(k.X0, 0);
        this.e0 = r6.getResourceId(k.W0, 0);
        r6.recycle();
        if (getThumbDrawable() != null) goto L6;
        setThumbDrawable(ContextCompat.getDrawable(r3, e.I));
    L6:
        if (getTrackDrawable() != null) goto L8;
        setTrackDrawable(r(r3, isChecked()));
    L8:
        setEnabled(isEnabled());
    }

    public /* synthetic */ OSwitch(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = com.obric.common.oui.b.f8193b;
    L8:
        this(r1, r2, r3);
    }

    private final Drawable getCheckedDrawable() {
        if (this.e0 != 0) goto L5;
        Drawable r1 = ContextCompat.getDrawable(getContext(), e.f8225J);
        o.c(r1);
        Drawable r2 = r1.mutate();
        String r0 = "ContextCompat.getDrawabl…                .mutate()";
    L6:
        o.e(r2, r0);
        return r2;
    L5:
        Drawable r3 = ContextCompat.getDrawable(getContext(), this.e0);
        o.c(r3);
        r2 = r3.mutate();
        r0 = "ContextCompat.getDrawabl… trackChecked)!!.mutate()";
        goto L6
    }

    private final boolean getTargetCheckedState() {
        if (getThumbPosition() <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final float getThumbPosition() {
        Field r0 = b.class.getDeclaredField("C");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        o.e(r0, BaseSwitches.V);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Object r2 = r0.get(this);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        if (r2 == null) goto L6;
        return ((Float) r2).floatValue();
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
    L7:
        e = move-exception;
        e.printStackTrace();
    L11:
        return 0.0f;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private final int getTouchMode() {
        Field r0 = b.class.getDeclaredField("w");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        o.e(r0, BaseSwitches.V);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Object r2 = r0.get(this);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        if (r2 == null) goto L6;
        return ((Integer) r2).intValue();
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
    L7:
        e = move-exception;
        e.printStackTrace();
    L11:
        return 0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private final Drawable getUncheckedDrawable() {
        if (this.d0 != 0) goto L5;
        Drawable r1 = ContextCompat.getDrawable(getContext(), e.K);
        o.c(r1);
        Drawable r2 = r1.mutate();
        String r0 = "ContextCompat.getDrawabl…                .mutate()";
    L6:
        o.e(r2, r0);
        return r2;
    L5:
        Drawable r3 = ContextCompat.getDrawable(getContext(), this.d0);
        o.c(r3);
        r2 = r3.mutate();
        r0 = "ContextCompat.getDrawabl…rackUnchecked)!!.mutate()";
        goto L6
    }

    private final void m(MotionEvent r4) {
        u();
        boolean r2 = true;
        if (r4.getAction() == 1) goto L5;
    L7:
        r2 = false;
    L8:
        boolean r0 = isChecked();
        if (r2 == false) goto L11;
        boolean r3 = getTargetCheckedState();
    L12:
        if (r3 == r0) goto L14;
        playSoundEffect(0);
    L14:
        setChecked(r3);
        MotionEvent r5 = MotionEvent.obtain(r4);
        o.e(r5, "cancel");
        r5.setAction(3);
        super.onTouchEvent(r5);
        r5.recycle();
        return;
    L11:
        r3 = r0;
        goto L12
    L5:
        if (isEnabled() == false) goto L7;
        goto L7
    }

    private final void n(boolean r3) {
        Drawable r0 = getTrackDrawable();
        if ((r0 instanceof TransitionDrawable) == false) goto L9;
        TransitionDrawable r1 = (TransitionDrawable) r0;
        if (r3 == false) goto L7;
        s(r1);
        return;
    L7:
        r1.resetTransition();
        return;
    L9:
        if ((r0 instanceof a) == false) goto L17;
        a r2 = (a) r0;
        if (r3 == false) goto L13;
        r2.d();
        return;
    L13:
        r2.b();
        return;
    }

    private final void o(boolean r4) {
        Drawable r3 = getTrackDrawable();
        if ((r3 instanceof TransitionDrawable) == false) goto L9;
        TransitionDrawable r5 = (TransitionDrawable) r3;
        if (r4 == false) goto L7;
        r5.startTransition(260);
        return;
    L7:
        r5.reverseTransition(100);
        return;
    L9:
        if ((r3 instanceof a) == false) goto L17;
        a r6 = (a) r3;
        if (r4 == false) goto L13;
        r6.e(260);
        return;
    L13:
        r6.c(100);
        return;
    }

    private final void p(int r13, int r14) {
        measure(0, 0);     // Catch: Exception -> L21
        int r2 = getMeasuredWidth();     // Catch: Exception -> L21
        int r3 = getMeasuredHeight();     // Catch: Exception -> L21
        if (r2 <= 0) goto L20;
        if (r3 <= 0) goto L26;
        Resources r4 = Resources.getSystem();     // Catch: Exception -> L21
        o.e(r4, "Resources.getSystem()");     // Catch: Exception -> L21
        int r15 = kotlin.o0.a.a(TypedValue.applyDimension(1, r13, r4.getDisplayMetrics())) + r2;     // Catch: Exception -> L21
        Resources r5 = Resources.getSystem();     // Catch: Exception -> L21
        o.e(r5, "Resources.getSystem()");     // Catch: Exception -> L21
        int r16 = kotlin.o0.a.a(TypedValue.applyDimension(1, r14, r5.getDisplayMetrics())) + r3;     // Catch: Exception -> L21
        d.g.d.f.b r0 = d.g.d.f.b.f16934a;     // Catch: Exception -> L21
        ViewParent r1 = getParent();     // Catch: Exception -> L21
        if (r1 != null) goto L11;
    L9:
        r1 = null;
    L12:
        ViewGroup r6 = (ViewGroup) r1;     // Catch: Exception -> L21
        if (r6 == null) goto L18;
        r6.measure(0, 0);     // Catch: Exception -> L21
        int r7 = r6.getMeasuredWidth();     // Catch: Exception -> L21
        if (r16 > r6.getMeasuredHeight()) goto L17;
        if (r15 <= r7) goto L18;
    L17:
        j.c(r6, r15, r16, false, 4, null);     // Catch: Exception -> L21
    L18:
        j.c(this, r15, r16, false, 4, null);     // Catch: Exception -> L21
        return;
    L11:
        if ((r1 instanceof ViewGroup) == false) goto L9;
    L26:
        return;
    L20:
        return;
    L21:
        e = move-exception;
        d.g.d.f.f.b.c("OSwitch", "increaseTouchArea, error", e);
    }

    static /* synthetic */ void q(OSwitch r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 20;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 20;
    L8:
        r1.p(r2, r3);
    }

    private final a r(Context r2, boolean r3) {
        a r0 = new a(getUncheckedDrawable(), getCheckedDrawable());
        if (r3 == false) goto L5;
        r0.e(0);
    L6:
        return r0;
    L5:
        r0.b();
        goto L6
    }

    private final Object s(TransitionDrawable r4) {
        Method r3 = TransitionDrawable.class.getDeclaredMethod("showSecondLayer", new Class[0]);     // Catch: Exception -> L4
        o.e(r3, "showSecondLayerMethod");     // Catch: Exception -> L4
        r3.setAccessible(true);     // Catch: Exception -> L4
        return r3.invoke(r4, new Object[0]);
    L4:
        e = move-exception;
        d.g.d.f.f.b.c("OSwitch", "reflectShowSecondLayer, error", e);
        return f0.f18324a;
    }

    private final void t(boolean r3, boolean r4) {
        if (r3 == isChecked()) goto L11;
        if (r4 == false) goto L11;
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L11;
        Drawable r1 = getTrackDrawable();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        TransitionDrawable r2 = (TransitionDrawable) r1;
        if (r3 == false) goto L10;
        r2.startTransition(180);
        goto L11
    L10:
        r2.reverseTransition(180);
    L11:
        super.setChecked(r3);
    }

    private final void u() {
        Field r0 = b.class.getDeclaredField("w");     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        o.e(r0, BaseSwitches.V);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r0.set(this, 0);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
    L12:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        q(this, 0, 0, 3, null);
    }

    @Override // com.obric.oui.oswitch.b, android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // com.obric.oui.oswitch.b, android.widget.TextView, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // com.obric.oui.oswitch.b, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        o.f(r4, "ev");
        if (r4.getAction() == 3) goto L7;
        if (r4.getAction() == 1) goto L7;
    L11:
        return super.onTouchEvent(r4);
    L7:
        if (getTouchMode() != 2) goto L11;
        m(r4);
        super.onTouchEvent(r4);
        return true;
    }

    @Override // com.obric.oui.oswitch.b, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r3) {
        boolean r0 = isChecked();
        super.setChecked(r3);
        boolean r4 = isChecked();
        if (getWindowToken() != null) goto L5;
    L8:
        if (r0 == r4) goto L13;
        n(r4);
        return;
    L13:
        return;
    L5:
        if (ViewCompat.isLaidOut(this) == false) goto L8;
        if (r0 == r4) goto L11;
        o(r4);
        return;
    }

    @Override // com.obric.oui.oswitch.b
    public void setCheckedNoAnim(boolean r2) {
        boolean r0 = isChecked();
        super.setCheckedNoAnim(r2);
        boolean r3 = isChecked();
        if (r0 == r3) goto L6;
        n(r3);
        return;
    }

    public final void setCheckedWithoutFeedback(boolean r2) {
        t(r2, true);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        Drawable r0 = getTrackDrawable();
        if (r0 == null) goto L9;
        if (r1 == false) goto L6;
        int r2 = 255;
    L7:
        r0.setAlpha(r2);
        return;
    L6:
        r2 = 76;
        goto L7
    }
}

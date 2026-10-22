package com.obric.oui.checkbox;

import a.a;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.haptic.VibratorSmt;
import com.obric.oui.utils.VectorBreaker;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OCheckBox extends AppCompatImageView implements Checkable {
    public static final int[] s = null;
    public static final int[] t = null;
    public Drawable b;
    public int c;
    public final int e;
    public int f;
    public boolean i;
    public boolean j;
    public ColorMatrixColorFilter k;
    public PorterDuffColorFilter l;
    public OnCheckedStateChangedListener m;
    public OnCheckedChangeListener n;
    public int o;
    public int p;
    public int q;
    public boolean r;

    @Metadata
    public static final class Companion {

        @Metadata
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention
        public @interface CheckedState {
        }
    }

    @Metadata
    public interface OnCheckedChangeListener {
        void a();
    }

    @Metadata
    public interface OnCheckedStateChangedListener {
        void a();
    }

    static {
        s = new int[]{R.attr.state_checked};
        t = new int[]{com.bytedance.securityserver.R.attr.oui_state_indeterminate};
    }

    public OCheckBox(Context r4) {
        Intrinsics.f(r4, "context");
        super(r4);
        this.e = a.d("Resources.getSystem()", 1, 18);
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = true;
        h(r4, null, com.bytedance.securityserver.R.attr.OCheckBoxStyle);
    }

    public static /* synthetic */ void getCheckedState$annotations() {
    }

    public final void g() {
        int r2 = this.p;
        if (r2 == (-1)) goto L6;
        this.k = new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(r2), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(r2), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(r2), 0.0f, 0.0f, 0.0f, (Color.alpha(r2) * 1.0f) / 255, 0.0f});
    L6:
        if (this.q == (-1)) goto L9;
        this.l = new PorterDuffColorFilter(this.q, PorterDuff.Mode.SRC_IN);
        return;
    }

    public final int getCheckedState() {
        return this.f;
    }

    public final void h(Context r4, AttributeSet r5, int r6) {
        TypedArray r7 = r4.obtainStyledAttributes(r5, com.obric.common.oui.R.styleable.h, r6, 0);
        Intrinsics.e(r7, "context.obtainStyledAttr…heckBox, defStyleAttr, 0)");
        this.c = r7.getInt(4, 0);
        this.r = r7.getBoolean(0, true);
        this.o = r7.getColor(5, -1);
        this.p = r7.getColor(3, -1);
        this.q = r7.getColor(6, -1);
        Drawable r8 = r7.getDrawable(2);
        if (r8 != null) goto L6;
        r8 = null;
    L6:
        this.b = r8;
        this.j = r7.getBoolean(1, false);
        if (r7.hasValue(7) == false) goto L9;
        setCheckedState(r7.getInt(7, 0));
    L9:
        r7.recycle();
        g();
        Drawable r9 = this.b;
        if (r9 != null) goto L12;
        j();
    L13:
        setBackground(null);
        i();
        setClickable(true);
        return;
    L12:
        setImageDrawable(r9);
        goto L13
    }

    public final void i() {
        Drawable r0 = getDrawable();
        if (r0 == null) goto L5;
        r0.clearColorFilter();
    L5:
        g();
        Drawable r1 = getDrawable();
        if (r1 != null) goto L8;
        return;
    L8:
        if (isChecked() == false) goto L10;
        ColorFilter r2 = this.k;
    L11:
        r1.setColorFilter(r2);
        return;
    L10:
        r2 = this.l;
        goto L11
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        if (this.f == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void j() {
        boolean r0 = this.j;
        if (r0 == false) goto L6;
        Drawable r1 = getResources().getDrawable(com.bytedance.securityserver.R.drawable.o_checkbox_circle_always_light, null);
    L12:
        this.b = r1;
        int r2 = this.o;
        if (r2 != (-1)) goto L15;
    L36:
        setImageDrawable(this.b);
        return;
    L15:
        if ((r1 instanceof StateListDrawable) == false) goto L36;
        if (r1 == null) goto L35;
        StateListDrawable r3 = (StateListDrawable) r1;
        int r4 = r3.getStateCount();
        int r5 = 0;
    L18:
        if (r5 >= r4) goto L36;
        Drawable r6 = r3.getStateDrawable(r5);
        if ((r6 instanceof VectorDrawable) == false) goto L27;
        VectorDrawable r7 = (VectorDrawable) r6;
        VectorBreaker.a(r7, r2);     // Catch: Exception -> L24
        r7.invalidateSelf();     // Catch: Exception -> L24
    L33:
        r5 = r5 + 1;
    L24:
        e = move-exception;
        Log.e("VectorBreaker", "Color injection failed", e);
        goto L33
    L27:
        if ((r6 instanceof AnimatedVectorDrawable) == false) goto L33;
        AnimatedVectorDrawable r8 = (AnimatedVectorDrawable) r6;
        VectorBreaker.b(r8, r2);     // Catch: Exception -> L31
        r8.invalidateSelf();     // Catch: Exception -> L31
    L31:
        e = move-exception;
        Log.e("VectorBreaker", "setPathColor2, Color injection failed", e);
        goto L33
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.StateListDrawable");
    L6:
        if (r0 == false) goto L8;
        r1 = getResources().getDrawable(com.bytedance.securityserver.R.drawable.o_checkbox_circle, null);
        goto L12
    L8:
        if (this.c == 1) goto L10;
        r1 = getResources().getDrawable(com.bytedance.securityserver.R.drawable.o_checkbox_circle, null);
        goto L12
    L10:
        r1 = getResources().getDrawable(com.bytedance.securityserver.R.drawable.o_checkbox_circle_on_image, null);
        goto L12
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.r == false) goto L6;
        Resources r1 = Resources.getSystem();
        Intrinsics.e(r1, "Resources.getSystem()");
        ViewExtensionsKt.a(this, MathKt.a(TypedValue.applyDimension(1, 44, r1.getDisplayMetrics())));
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int r3) {
        int[] r4 = super.onCreateDrawableState(r3 + 2);
        if (this.f != 2) goto L6;
        View.mergeDrawableStates(r4, t);
    L6:
        if (isChecked() == false) goto L8;
        View.mergeDrawableStates(r4, s);
    L8:
        return r4;
    }

    @Override // android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r1, int r2) {
        int r3 = View.MeasureSpec.makeMeasureSpec(this.e, BasicMeasure.EXACTLY);
        super.onMeasure(r3, r3);
    }

    @Override // android.view.View
    public final boolean performClick() {
        toggle();
        boolean r0 = super.performClick();
        if (r0 == true) goto L6;
        playSoundEffect(0);
    L6:
        if (isChecked() == false) goto L8;
        VibratorSmt.a(getContext(), 1);
    L8:
        return r0;
    }

    public final void setAlwaysLight(boolean r1) {
        this.j = r1;
        j();
        invalidate();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        setCheckedState(r1 ? 1 : 0);
    }

    public final void setCheckedState(int r2) {
        if (this.f == r2) goto L17;
        this.f = r2;
        i();
        refreshDrawableState();
        if (this.i == false) goto L7;
        return;
    L7:
        this.i = true;
        OnCheckedStateChangedListener r3 = this.m;
        if (r3 == null) goto L11;
        r3.a();
    L11:
        if (this.f == 2) goto L15;
        OnCheckedChangeListener r4 = this.n;
        if (r4 == null) goto L15;
        r4.a();
    L15:
        this.i = false;
        return;
    }

    public final void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener r1) {
        this.n = r1;
    }

    public final void setOnCheckedStateChangedListener(@Nullable OnCheckedStateChangedListener r1) {
        this.m = r1;
    }

    public final void setPrimaryColor(@ColorInt int r1) {
        this.o = r1;
        j();
        invalidate();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    public OCheckBox(@NotNull Context r4, @NotNull AttributeSet r5) {
        Intrinsics.f(r4, "context");
        Intrinsics.f(r5, "attrs");
        super(r4, r5);
        this.e = a.d("Resources.getSystem()", 1, 18);
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = true;
        h(r4, r5, com.bytedance.securityserver.R.attr.OCheckBoxStyle);
    }

    public OCheckBox(Context r4, AttributeSet r5, int r6) {
        Intrinsics.f(r4, "context");
        Intrinsics.f(r5, "attrs");
        super(r4, r5, r6);
        this.e = a.d("Resources.getSystem()", 1, 18);
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = true;
        h(r4, r5, r6);
    }
}

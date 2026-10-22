package com.obric.oui.checkbox;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.bytedance.securityserver.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OCheckBoxLayout extends FrameLayout implements Checkable {
    public final OCheckBox b;

    @JvmOverloads
    public OCheckBoxLayout(@NotNull Context r5, @Nullable AttributeSet r6) {
        Intrinsics.f(r5, "context");
        super(r5, r6, 0);
        if (r6 == null) goto L5;
        OCheckBox r3 = new OCheckBox(r5, r6, 0);
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -2);
        r7.gravity = 17;
        r3.setLayoutParams(r7);
        this.b = r3;
        addView(r3);
        return;
    L5:
        OCheckBox r8 = new OCheckBox(r5);
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-2, -2);
        r9.gravity = 17;
        r8.setLayoutParams(r9);
        this.b = r8;
        addView(r8);
    }

    @NotNull
    public final OCheckBox getCheckBox() {
        return this.b;
    }

    public final int getCheckedState() {
        return this.b.getCheckedState();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.b.isChecked();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        Resources r4 = Resources.getSystem();
        Intrinsics.e(r4, "Resources.getSystem()");
        int r5 = View.MeasureSpec.makeMeasureSpec(MathKt.a(TypedValue.applyDimension(1, 32, r4.getDisplayMetrics())), BasicMeasure.EXACTLY);
        super.onMeasure(r5, r5);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        if (r4 == null) goto L15;
        if (isEnabled() == false) goto L15;
        int r0 = r4.getAction();
        if (r0 != 0) goto L8;
        setBackground(getResources().getDrawable(R.drawable.o_ic_radio_round_press_bg, null));
        goto L15
    L8:
        if (r0 != 1) goto L10;
    L12:
        setBackground(null);
        goto L15
    L10:
        if (r0 == 3) goto L12;
    L15:
        return super.onTouchEvent(r4);
    }

    @Override // android.view.View
    public final boolean performClick() {
        return this.b.performClick();
    }

    public final void setAlwaysLight(boolean r1) {
        this.b.setAlwaysLight(r1);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        this.b.setChecked(r1);
    }

    public final void setCheckedState(int r1) {
        this.b.setCheckedState(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.b.setEnabled(r2);
        if (r2 == true) goto L6;
        setBackground(null);
        return;
    }

    public final void setOnCheckedChangeListener(@Nullable OCheckBox.OnCheckedChangeListener r1) {
        this.b.setOnCheckedChangeListener(r1);
    }

    public final void setOnCheckedStateChangedListener(@Nullable OCheckBox.OnCheckedStateChangedListener r1) {
        this.b.setOnCheckedStateChangedListener(r1);
    }

    public final void setPrimaryColor(@ColorInt int r1) {
        this.b.setPrimaryColor(r1);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.b.toggle();
    }
}

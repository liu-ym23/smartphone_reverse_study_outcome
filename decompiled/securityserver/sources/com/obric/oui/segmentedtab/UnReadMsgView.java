package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class UnReadMsgView extends AppCompatTextView {
    public final GradientDrawable b;
    public int c;
    public int e;
    public int f;
    public int i;
    public boolean j;
    public boolean k;

    @JvmOverloads
    public UnReadMsgView(@NotNull Context r3, @Nullable AttributeSet r4) {
        Intrinsics.f(r3, "context");
        super(r3, r4, 0);
        this.b = new GradientDrawable();
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.f151a);
        Intrinsics.e(r5, "context.obtainStyledAttr…trs, R.styleable.MsgView)");
        this.c = r5.getColor(0, 0);
        this.e = r5.getDimensionPixelSize(1, 0);
        this.f = r5.getDimensionPixelSize(5, 0);
        this.i = r5.getColor(4, 0);
        this.j = r5.getBoolean(2, false);
        this.k = r5.getBoolean(3, false);
        r5.recycle();
    }

    private final void setCornerRadius(int r1) {
        this.e = a(r1);
        b();
    }

    private final void setStrokeWidth(int r1) {
        this.f = a(r1);
        b();
    }

    public final int a(float r2) {
        Context r1 = getContext();
        Intrinsics.e(r1, "context");
        Resources r3 = r1.getResources();
        Intrinsics.e(r3, "context.resources");
        return (int) ((r2 * r3.getDisplayMetrics().density) + 0.5f);
    }

    public final void b() {
        StateListDrawable r0 = new StateListDrawable();
        GradientDrawable r1 = this.b;
        int r2 = this.c;
        int r3 = this.i;
        r1.setColor(r2);
        r1.setCornerRadius(this.e);
        r1.setStroke(this.f, r3);
        r0.addState(new int[]{-16842919}, r1);
        setBackground(r0);
    }

    public final int getBackgroundColor() {
        return this.c;
    }

    public final int getCornerRadius() {
        return this.e;
    }

    public final int getStrokeColor() {
        return this.i;
    }

    public final int getStrokeWidth() {
        return this.f;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.j == false) goto L5;
        setCornerRadius(getHeight() / 2);
        return;
    L5:
        b();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r2, int r3) {
        if (this.k == true) goto L5;
    L13:
        super.onMeasure(r2, r3);
        return;
    L5:
        if (getWidth() <= 0) goto L13;
        if (getHeight() <= 0) goto L13;
        int r4 = getWidth();
        int r5 = getHeight();
        if (r4 >= r5) goto L11;
        r4 = r5;
    L11:
        int r6 = View.MeasureSpec.makeMeasureSpec(r4, BasicMeasure.EXACTLY);
        super.onMeasure(r6, r6);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        this.c = r1;
        b();
    }

    public final void setIsRadiusHalfHeight(boolean r1) {
        this.j = r1;
        b();
    }

    public final void setIsWidthHeightEqual(boolean r1) {
        this.k = r1;
        b();
    }

    public final void setStrokeColor(int r1) {
        this.i = r1;
        b();
    }
}

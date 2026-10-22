package com.obric.oui.button;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.common.oui.R;
import com.obric.oui.common.style.IOUIAlpha;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OButtonGroup extends OShadowFrame {
    public LinearLayout u;
    public final int v;
    public View w;
    public boolean x;

    @Metadata
    public static final class Companion {
    }

    @JvmOverloads
    public OButtonGroup(@NotNull Context r6, @Nullable AttributeSet r7) {
        Intrinsics.f(r6, "context");
        super(r6, r7, 0);
        float r1 = 0;
        Resources r2 = Resources.getSystem();
        Intrinsics.e(r2, "Resources.getSystem()");
        MathKt.a(TypedValue.applyDimension(1, r1, r2.getDisplayMetrics()));
        Resources r3 = Resources.getSystem();
        Intrinsics.e(r3, "Resources.getSystem()");
        this.v = MathKt.a(TypedValue.applyDimension(1, r1, r3.getDisplayMetrics()));
        TypedArray r8 = r6.obtainStyledAttributes(r7, R.styleable.e);
        Intrinsics.e(r8, "context.obtainStyledAttr…R.styleable.OButtonGroup)");
        this.v = r8.getDimensionPixelSize(3, 0);
        r8.getDimensionPixelSize(2, 0);
        r8.getDimensionPixelSize(1, 5);
        r8.recycle();
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r7) {
        Intrinsics.f(r7, "event");
        boolean r1 = false;
        if (getItemCount() != 1) goto L5;
        boolean r0 = true;
    L6:
        boolean r3 = super.dispatchTouchEvent(r7);
        if (r0 == false) goto L28;
        int r2 = r7.getActionMasked();
        if (r2 == 0) goto L27;
        if (r2 != 1) goto L12;
    L26:
        getContentView().setPressed(false);
        goto L28
    L12:
        if (r2 != 2) goto L14;
        float r4 = 0;
        if (r7.getX() >= r4) goto L19;
    L25:
        getContentView().setPressed(r1);
        goto L28
    L19:
        if (r7.getX() >= getWidth()) goto L25;
        if (r7.getY() < r4) goto L25;
        if (r7.getY() >= getHeight()) goto L25;
        r1 = true;
        goto L25
    L14:
        if (r2 == 3) goto L26;
    L27:
        getContentView().setPressed(true);
    L28:
        return r3;
    L5:
        r0 = false;
        goto L6
    }

    public final int getItemCount() {
        LinearLayout r0 = this.u;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getChildCount();
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void j(Context r2, FrameLayout r3, TypedArray r4) {
        Intrinsics.f(r2, "context");
        Intrinsics.f(r3, "contentView");
        r3.removeAllViews();
        setChangeAlphaWhenPress(false);
        getContentView().setDuplicateParentStateEnabled(false);
        LinearLayout r0 = new LinearLayout(r2);
        r0.setOrientation(0);
        r0.setGravity(17);
        this.u = r0;
        r3.addView(r0);
        int r5 = this.v;
        setWidthMin(r5);
        getContentView().setWidthMin(r5);
        LinearLayout r6 = this.u;
        if (r6 == null) goto L17;
        if (r6.getChildCount() != 1) goto L15;
        View r7 = r6.getChildAt(0);
        if (this.w == r7) goto L9;
        l();
        this.w = r7;
    L9:
        Intrinsics.e(r7, "only");
        boolean r8 = r7 instanceof IOUIAlpha;
        Object r9 = r7;
        if (r8 == true) goto L12;
        r9 = null;
    L12:
        IOUIAlpha r10 = (IOUIAlpha) r9;
        if (r10 == null) goto L17;
        r10.setChangeAlphaWhenPress(false);
        this.x = true;
        goto L17
    L15:
        l();
    L17:
        if (getItemCount() != 0) goto L19;
        setVisibility(8);
        return;
    L19:
        setVisibility(0);
    }

    public final void l() {
        KeyEvent.Callback r0 = this.w;
        if (r0 != null) goto L5;
    L12:
        this.w = null;
        this.x = false;
        return;
    L5:
        if (this.x == false) goto L12;
        if ((r0 instanceof IOUIAlpha) == true) goto L9;
        r0 = null;
    L9:
        IOUIAlpha r1 = (IOUIAlpha) r0;
        if (r1 == null) goto L12;
        r1.setChangeAlphaWhenPress(true);
        goto L12
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r1) {
        getLayoutHelper().setWidthMin(r1);
    }
}

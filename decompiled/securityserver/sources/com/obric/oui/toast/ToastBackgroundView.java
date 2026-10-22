package com.obric.oui.toast;

import a.a;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.common.style.SmoothCornerH;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ToastBackgroundView extends FrameLayout {
    public final int b;
    public final float c;
    public final RectF e;
    public final Paint f;
    public final Paint i;
    public boolean j;

    @Metadata
    public static final class Companion {
    }

    @JvmOverloads
    public ToastBackgroundView(@NotNull Context r4, @Nullable AttributeSet r5) {
        Intrinsics.f(r4, "context");
        super(r4, r5, 0);
        this.b = a.d("Resources.getSystem()", 1, 24.0f);
        this.c = 1.0f;
        this.e = new RectF();
        Paint r1 = new Paint(1);
        r1.setStyle(Paint.Style.FILL);
        this.f = r1;
        Paint r2 = new Paint(1);
        r2.setStyle(Paint.Style.STROKE);
        r2.setStrokeWidth(1.0f);
        this.i = r2;
        setBackgroundColor(0);
        r1.setColor(getResources().getColor(R.color.oui_fill_toast_tooltip, null));
        r2.setColor(getResources().getColor(R.color.LineTertiary, null));
    }

    public final int getCornerRadius() {
        return this.b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.f(r9, "canvas");
        if (this.j == false) goto L5;
        RectF r0 = this.e;
        float r1 = getPaddingLeft();
        float r2 = 2;
        float r3 = this.c;
        r0.set((r3 / r2) + r1, (r3 / r2) + getPaddingTop(), (getWidth() - getPaddingRight()) - (r3 / r2), (getHeight() - getPaddingBottom()) - (r3 / r2));
        float r4 = this.b * 1.0f;
        SmoothCornerH.f(r9, r0, r4, this.f);
        SmoothCornerH.f(r9, r0, r4, this.i);
    L5:
        super.onDraw(r9);
    }

    public final void setupBackground(int r4) {
        if (r4 != (this.b * 2)) goto L5;
        setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.o_toast_background_capsule_form, null));
        this.j = false;
    L6:
        L.a("ToastBackgroundView", "setupBackground: drawSelf = " + this.j + ", height = " + r4);
        invalidate();
        return;
    L5:
        this.j = true;
        goto L6
    }
}

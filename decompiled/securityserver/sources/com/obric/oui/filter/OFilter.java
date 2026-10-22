package com.obric.oui.filter;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import com.bytedance.securityserver.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OFilter extends DrawableCenterButton {
    public boolean b;
    public OnFilterSelectChangeListener c;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface OnFilterSelectChangeListener {
        void a(OFilter r1, boolean r2);
    }

    public final void a() {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        setMinHeight(-1);
        if (isSelected() == false) goto L12;
        if (this.b == true) goto L10;
        setTypeface(null, 1);
        int r0 = R.color.BGInput;
    L15:
        ContextCompat.getColor(getContext(), r0);
        throw null;
    L10:
        setTypeface(null, 1);
        r0 = R.color.BGBrand;
        goto L15
    L12:
        if (this.b == true) goto L14;
        setTypeface(null, 0);
        r0 = R.color.oui_basic_text_4;
        goto L15
    L14:
        setTypeface(null, 0);
        r0 = R.color.Transparent;
        goto L15
    }

    public final boolean getIsAlwaysLight() {
        return this.b;
    }

    public final int getStyle() {
        return 0;
    }

    @Override // com.obric.oui.filter.DrawableCenterButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.f(r4, "canvas");
        r4.save();
        r4.translate(getScrollX() * 1.0f, getScrollY() * 1.0f);
        Resources r0 = Resources.getSystem();
        Intrinsics.e(r0, "Resources.getSystem()");
        MathKt.a(TypedValue.applyDimension(1, 4, r0.getDisplayMetrics()));
        getWidth();
        getHeight();
        throw null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setAlwaysLight(boolean r1) {
        this.b = r1;
        a();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        if (r1 == false) goto L5;
        setAlpha(1.0f);
        a();
        return;
    L5:
        setAlpha(0.5f);
    }

    public final void setSelectChangeListener(@NotNull OnFilterSelectChangeListener r2) {
        Intrinsics.f(r2, "listener");
        this.c = r2;
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        a();
        OnFilterSelectChangeListener r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(this, r2);
        return;
    }
}

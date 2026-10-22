package com.obric.oui.filter;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatButton;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/filter/DrawableCenterButton;", "Landroidx/appcompat/widget/AppCompatButton;", "Landroid/graphics/Canvas;", "canvas", "Lkotlin/f0;", "onDraw", "(Landroid/graphics/Canvas;)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class DrawableCenterButton extends AppCompatButton {
    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas r5) {
        o.f(r5, "canvas");
        Drawable[] r0 = getCompoundDrawables();
        o.e(r0, "compoundDrawables");
        Drawable r1 = r0[2];
        if (r1 == null) goto L7;
        float r2 = getPaint().measureText(getText().toString());
        float r3 = (((r2 + r1.getIntrinsicHeight()) + getCompoundDrawablePadding()) + getPaddingLeft()) + getPaddingRight();
        if (r3 > getMeasuredWidth()) goto L7;
        r5.translate((r3 - getMeasuredWidth()) / 2, 0.0f);
    L7:
        super.onDraw(r5);
    }
}

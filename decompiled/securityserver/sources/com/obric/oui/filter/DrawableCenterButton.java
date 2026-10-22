package com.obric.oui.filter;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class DrawableCenterButton extends AppCompatButton {
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r5) {
        Intrinsics.f(r5, "canvas");
        Drawable[] r0 = getCompoundDrawables();
        Intrinsics.e(r0, "compoundDrawables");
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

package com.obric.oui.filter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DrawableCenterButton.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\r"}, d2 = {"Lcom/obric/oui/filter/DrawableCenterButton;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class DrawableCenterButton extends AppCompatButton {
    public DrawableCenterButton(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public DrawableCenterButton(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ DrawableCenterButton(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public DrawableCenterButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setGravity(GravityCompat.END);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        Drawable[] r0 = getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(r0, "compoundDrawables");
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

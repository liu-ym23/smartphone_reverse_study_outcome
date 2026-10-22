package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IndicatorImageDotView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u000fH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\r¨\u0006#"}, d2 = {"Lcom/obric/oui/indicator/IndicatorImageDotView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/obric/oui/indicator/IndicatorIcon;", "context", "Landroid/content/Context;", "initialDrawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;)V", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "value", "", "dotColor", "getDotColor", "()I", "setDotColor", "(I)V", "strokeColor", "getStrokeColor", "setStrokeColor", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "setEndMargin", "", "margin", "setHorizontalMargin", "horizontalMargin", "setStartMargin", "setWidth", MaterialConfigFormatNames.WIDTH, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IndicatorImageDotView extends AppCompatImageView implements IndicatorIcon {
    private float cornerRadius;
    private int dotColor;
    private int strokeColor;
    private float strokeWidth;

    public IndicatorImageDotView(Context r2, Drawable r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.dotColor = -7829368;
        setImageDrawable(r3);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public int getDotColor() {
        return this.dotColor;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setDotColor(int r2) {
        if (this.dotColor == r2) goto L5;
        this.dotColor = r2;
    L5:
        setColorFilter(r2);
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setWidth(int r1) {
        IndicatorExternalsKt.setWidth(this, r1);
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public float getCornerRadius() {
        return this.cornerRadius;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setCornerRadius(float r1) {
        this.cornerRadius = r1;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setStrokeWidth(float r1) {
        this.strokeWidth = r1;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public int getStrokeColor() {
        return this.strokeColor;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setStrokeColor(int r1) {
        this.strokeColor = r1;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setHorizontalMargin(int r1) {
        IndicatorExternalsKt.setHorizontalMargin(this, r1);
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setStartMargin(int r4) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        ViewGroup.MarginLayoutParams r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L9;
        r1.setMarginStart(r4);
        requestLayout();
        r2 = r1;
    L9:
        setLayoutParams(r2);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setEndMargin(int r4) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        ViewGroup.MarginLayoutParams r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L9;
        r1.setMarginEnd(r4);
        requestLayout();
        r2 = r1;
    L9:
        setLayoutParams(r2);
        return;
    L5:
        r1 = null;
        goto L6
    }
}

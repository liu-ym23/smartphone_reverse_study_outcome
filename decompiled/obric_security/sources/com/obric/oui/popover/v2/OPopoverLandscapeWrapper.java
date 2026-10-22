package com.obric.oui.popover.v2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedanceos.security.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPopoverLandscapeWrapper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J0\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015H\u0014J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015H\u0014R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverLandscapeWrapper;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "orientationAngle", "getOrientationAngle", "()F", "setOrientationAngle", "(F)V", "rotationLayer", "Landroid/widget/FrameLayout;", "getRotationLayer", "()Landroid/widget/FrameLayout;", "addView", "", "child", "Landroid/view/View;", Utils.INTENT_KEY_INDEX, "", "params", "Landroid/view/ViewGroup$LayoutParams;", "onLayout", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverLandscapeWrapper extends ViewGroup {
    private float orientationAngle;
    private final FrameLayout rotationLayer;

    public OPopoverLandscapeWrapper(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        FrameLayout r0 = new FrameLayout(r3);
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        this.rotationLayer = r0;
        setClipChildren(false);
        setClipToPadding(false);
        super.addView(r0, -1, new ViewGroup.LayoutParams(-2, -2));
    }

    public final float getOrientationAngle() {
        return this.orientationAngle;
    }

    public final void setOrientationAngle(float r2) {
        this.orientationAngle = r2;
        this.rotationLayer.setRotation(r2);
        requestLayout();
    }

    public final FrameLayout getRotationLayer() {
        return this.rotationLayer;
    }

    @Override // android.view.ViewGroup
    public void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        Intrinsics.checkNotNullParameter(r2, "child");
        this.rotationLayer.addView(r2, r3, r4);
    }

    @Override // android.view.View
    protected void onMeasure(int r3, int r4) {
        if ((this.orientationAngle % 180) != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        measureChild(this.rotationLayer, r4, r3);
        setMeasuredDimension(this.rotationLayer.getMeasuredHeight(), this.rotationLayer.getMeasuredWidth());
        return;
    L8:
        measureChild(this.rotationLayer, r3, r4);
        setMeasuredDimension(this.rotationLayer.getMeasuredWidth(), this.rotationLayer.getMeasuredHeight());
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r8 = r6 - r4;
        int r9 = this.rotationLayer.getMeasuredWidth();
        int r10 = this.rotationLayer.getMeasuredHeight();
        int r11 = (r8 - r9) / 2;
        int r12 = ((r7 - r5) - r10) / 2;
        this.rotationLayer.layout(r11, r12, r11 + r9, r12 + r10);
        this.rotationLayer.setPivotX(r9 / 2.0f);
        this.rotationLayer.setPivotY(r10 / 2.0f);
    }
}

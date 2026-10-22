package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class CardViewBaseImpl implements CardViewImpl {
    final RectF mCornerRect;

    public CardViewBaseImpl() {
        this.mCornerRect = new RectF();
    }

    private RoundRectDrawableWithShadow createBackground(Context r7, ColorStateList r8, float r9, float r10, float r11) {
        return new RoundRectDrawableWithShadow(r7.getResources(), r8, r9, r10, r11);
    }

    private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate r1) {
        return (RoundRectDrawableWithShadow) r1.getCardBackground();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList getBackgroundColor(CardViewDelegate r1) {
        return getShadowBackground(r1).getColor();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getElevation(CardViewDelegate r1) {
        return getShadowBackground(r1).getShadowSize();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMaxElevation(CardViewDelegate r1) {
        return getShadowBackground(r1).getMaxShadowSize();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinHeight(CardViewDelegate r1) {
        return getShadowBackground(r1).getMinHeight();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinWidth(CardViewDelegate r1) {
        return getShadowBackground(r1).getMinWidth();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getRadius(CardViewDelegate r1) {
        return getShadowBackground(r1).getCornerRadius();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new AnonymousClass1(this);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initialize(CardViewDelegate r7, Context r8, ColorStateList r9, float r10, float r11, float r12) {
        RoundRectDrawableWithShadow r13 = createBackground(r8, r9, r10, r11, r12);
        r13.setAddPaddingForCorners(r7.getPreventCornerOverlap());
        r7.setCardBackground(r13);
        updatePadding(r7);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onCompatPaddingChanged(CardViewDelegate r1) {
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onPreventCornerOverlapChanged(CardViewDelegate r3) {
        getShadowBackground(r3).setAddPaddingForCorners(r3.getPreventCornerOverlap());
        updatePadding(r3);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setBackgroundColor(CardViewDelegate r1, @Nullable ColorStateList r2) {
        getShadowBackground(r1).setColor(r2);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setElevation(CardViewDelegate r1, float r2) {
        getShadowBackground(r1).setShadowSize(r2);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setMaxElevation(CardViewDelegate r2, float r3) {
        getShadowBackground(r2).setMaxShadowSize(r3);
        updatePadding(r2);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setRadius(CardViewDelegate r2, float r3) {
        getShadowBackground(r2).setCornerRadius(r3);
        updatePadding(r2);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void updatePadding(CardViewDelegate r5) {
        Rect r0 = new Rect();
        getShadowBackground(r5).getMaxShadowAndCornerPadding(r0);
        r5.setMinWidthHeightInternal((int) Math.ceil(getMinWidth(r5)), (int) Math.ceil(getMinHeight(r5)));
        r5.setShadowPadding(r0.left, r0.top, r0.right, r0.bottom);
    }
}

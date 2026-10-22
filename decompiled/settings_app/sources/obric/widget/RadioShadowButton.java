package obric.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* JADX INFO: loaded from: classes5.dex */
public class RadioShadowButton extends RadioButton {
    private ColorStateList mShadowColors;
    private float mShadowDx;
    private float mShadowDy;
    private float mShadowRadius;

    public RadioShadowButton(Context context) {
        super(context);
    }

    public RadioShadowButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public RadioShadowButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        updateShadowColor();
    }

    private void updateShadowColor() {
        ColorStateList r0 = this.mShadowColors;
        if (r0 == null) goto L6;
        setShadowLayer(this.mShadowRadius, this.mShadowDx, this.mShadowDy, r0.getColorForState(getDrawableState(), 0));
        invalidate();
        return;
    }

    public void setShadowColorState(ColorStateList shadowColors, float shadowX, float shadowY, float shadowRadius) {
        this.mShadowColors = shadowColors;
        this.mShadowDx = shadowX;
        this.mShadowDy = shadowY;
        this.mShadowRadius = shadowRadius;
        updateShadowColor();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateShadowColor();
    }

    @Override // android.widget.TextView
    public void setFreezesText(boolean freezesText) {
        super.setFreezesText(false);
    }
}

package obric.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class ShadowTextView extends TextView {
    private boolean mEnableShadow;
    private ColorStateList mShadowColors;
    private float mShadowDx;
    private float mShadowDy;
    private float mShadowRadius;

    public ShadowTextView(Context context) {
        this(context, null);
    }

    public ShadowTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public ShadowTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ShadowTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mEnableShadow = true;
        TypedArray r2 = context.obtainStyledAttributes(attrs, R.styleable.ShadowTextView, defStyleAttr, defStyleRes);
        this.mShadowColors = r2.getColorStateList(R.styleable.ShadowTextView_shadowColors);
        this.mShadowDx = r2.getFloat(R.styleable.ShadowTextView_android_shadowDx, 0.0f);
        this.mShadowDy = r2.getFloat(R.styleable.ShadowTextView_android_shadowDy, 0.0f);
        this.mShadowRadius = r2.getFloat(R.styleable.ShadowTextView_android_shadowRadius, 0.0f);
        r2.recycle();
        updateTextShadow(this, this.mShadowColors, this.mShadowRadius, this.mShadowDx, this.mShadowDy);
    }

    public void setShadowColors(ColorStateList shadowColors, float radius, float dx, float dy) {
        this.mShadowColors = shadowColors;
        this.mShadowRadius = radius;
        this.mShadowDx = dx;
        this.mShadowDy = dy;
        updateTextShadow(this, shadowColors, radius, dx, dy);
    }

    public static void updateTextShadow(TextView target, ColorStateList shadowColors, float radius, float dx, float dy) {
        if (shadowColors == null) goto L6;
        if (target == null) goto L7;
        target.setShadowLayer(radius, dx, dy, shadowColors.getColorForState(target.getDrawableState(), 0));
        target.invalidate();
        return;
    L7:
        return;
    }

    public void setShadowEnable(boolean enable) {
        this.mEnableShadow = enable;
        refreshDrawableState();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mEnableShadow == false) goto L5;
        updateTextShadow(this, this.mShadowColors, this.mShadowRadius, this.mShadowDx, this.mShadowDy);
        return;
    L5:
        updateTextShadow(this, this.mShadowColors, 0.0f, 0.0f, 0.0f);
    }
}

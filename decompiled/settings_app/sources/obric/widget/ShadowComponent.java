package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ShadowComponent {
    public static final int ORIENTATION_ABOVE_HOST = 1;
    public static final int ORIENTATION_BELOW_HOST = 2;
    final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private Context mContext;
    private View mHostView;
    private int mShadowDrawable;
    private ImageView mShadowView;
    private boolean mShadowVisible;

    public static class IllegalParentException extends RuntimeException {
        public IllegalParentException(String detailMessage) {
            super(detailMessage);
        }
    }

    abstract int getDefaultShadowRes();

    protected int getShadowOrientation() {
        return 2;
    }

    abstract boolean isShadowVisibleDefault();

    protected void onShadowLayout() {
    }

    static /* synthetic */ void access$000(ShadowComponent r0) {
        r0.invalidateShadow();
    }

    static /* synthetic */ View access$100(ShadowComponent r0) {
        return r0.mHostView;
    }

    public ShadowComponent(View hostView, AttributeSet attrs, int defStyle) {
        ViewTreeObserver.OnGlobalLayoutListener r0 = new AnonymousClass1(this);
        this.globalLayoutListener = r0;
        this.mHostView = hostView;
        Context r1 = hostView.getContext();
        this.mContext = r1;
        TypedArray r6 = r1.obtainStyledAttributes(attrs, R.styleable.SmartisanShadow, defStyle, 0);
        if (r6 == null) goto L5;
        this.mShadowDrawable = r6.getResourceId(R.styleable.SmartisanShadow_shadowDrawable, getDefaultShadowRes());
        this.mShadowVisible = r6.getBoolean(R.styleable.SmartisanShadow_shadowVisible, isShadowVisibleDefault());
        r6.recycle();
    L5:
        hostView.getViewTreeObserver().addOnGlobalLayoutListener(r0);
    }

    private void invalidateShadow() {
        ViewParent r0 = this.mHostView.getParent();
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.mShadowVisible == true) goto L8;
        ViewGroup r1 = (ViewGroup) r0;
        ImageView r2 = this.mShadowView;
        if (r2 == null) goto L38;
        r1.removeView(r2);
    L38:
        this.mShadowView = null;
        return;
    L8:
        if ((r0 instanceof RelativeLayout) == false) goto L24;
        RelativeLayout r3 = (RelativeLayout) r0;
        ImageView r4 = this.mShadowView;
        if (r4 != null) goto L22;
        this.mShadowView = new ImageView(this.mContext);
        RelativeLayout.LayoutParams r5 = new RelativeLayout.LayoutParams(-1, -2);
        if (getShadowOrientation() != 1) goto L18;
        if (this.mHostView.getId() <= 0) goto L16;
        r5.addRule(2, this.mHostView.getId());
    L21:
        this.mShadowView.setBackgroundResource(this.mShadowDrawable);
        r3.addView(this.mShadowView, r5);
        return;
    L16:
        r5.bottomMargin = r3.getHeight() - this.mHostView.getTop();
        r5.addRule(12);
        goto L21
    L18:
        if (this.mHostView.getId() <= 0) goto L20;
        r5.addRule(3, this.mHostView.getId());
        goto L21
    L20:
        r5.topMargin = this.mHostView.getBottom();
        goto L21
    L22:
        r4.setBackgroundResource(this.mShadowDrawable);
        return;
    L24:
        if ((r0 instanceof FrameLayout) == false) goto L34;
        FrameLayout r6 = (FrameLayout) r0;
        ImageView r7 = this.mShadowView;
        if (r7 != null) goto L32;
        this.mShadowView = new ImageView(this.mContext);
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-1, -2);
        if (getShadowOrientation() != 1) goto L30;
        r8.bottomMargin = r6.getHeight() - this.mHostView.getTop();
        r8.gravity = 80;
    L31:
        this.mShadowView.setBackgroundResource(this.mShadowDrawable);
        r6.addView(this.mShadowView, r8);
        return;
    L30:
        r8.topMargin = this.mHostView.getBottom();
        goto L31
    L32:
        r7.setBackgroundResource(this.mShadowDrawable);
        return;
    L34:
        throw new IllegalParentException("parent must be RelativeLayout or FrameLayout if you want to show shadow");
    }

    public void setShadowDrawable(int resId) {
        if (resId == this.mShadowDrawable) goto L8;
        this.mShadowDrawable = resId;
        if (this.mShadowVisible == false) goto L9;
        invalidateShadow();
        return;
    L9:
        return;
    }

    public void setShadowVisible(boolean visible) {
        if (this.mShadowVisible == visible) goto L6;
        this.mShadowVisible = visible;
        invalidateShadow();
        return;
    }

    public ImageView getShadowView() {
        return this.mShadowView;
    }
}

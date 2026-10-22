package obric.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public class ShadowDrawable extends RippleDrawable {
    private int mInsetLR;
    private int mInsetTB;
    private Drawable mShadow;
    private boolean mShouldProjects;
    private Drawable mTarget;

    public ShadowDrawable(Drawable shadow, Drawable target, int insetLR, int insetTB) {
        super(ColorStateList.valueOf(0), null, null);
        this.mShouldProjects = true;
        this.mShadow = shadow;
        this.mTarget = target;
        this.mInsetLR = insetLR;
        this.mInsetTB = insetTB;
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        this.mTarget.setBounds(bounds);
        Rect r0 = new Rect(bounds);
        r0.inset(-this.mInsetLR, -this.mInsetTB);
        this.mShadow.setBounds(r0);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean getPadding(Rect padding) {
        return this.mTarget.getPadding(padding);
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] stateSet) {
        if (this.mTarget.isStateful() == false) goto L5;
        boolean r0 = this.mTarget.setState(stateSet);
    L7:
        if (this.mShadow.isStateful() == true) goto L9;
        return r0;
    L9:
        return r0 | this.mShadow.setState(stateSet);
    L5:
        r0 = false;
        goto L7
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.mTarget.isStateful() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mShadow.isStateful() == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mShadow.draw(canvas);
        this.mTarget.draw(canvas);
    }

    @Override // android.graphics.drawable.LayerDrawable
    public int getNumberOfLayers() {
        if (this.mShouldProjects == false) goto L5;
        return 0;
    L5:
        return 2;
    }

    public Drawable getBackgroundDrawable() {
        return this.mTarget;
    }

    public static void setViewBackground(View view, int bgId, int shadowId) {
        setViewBackground(view, view.getResources().getDrawable(bgId), shadowId);
    }

    public static void setViewBackground(View view, Drawable drawable, int shadowId) {
        Drawable r5 = view.getResources().getDrawable(shadowId);
        Rect r0 = new Rect();
        r5.getPadding(r0);
        view.setBackground(new ShadowDrawable(r5, drawable, r0.left, r0.top));
    }

    static ShadowDrawable setViewBackground(View view, Drawable drawable, int shadowId, boolean shouldProject) {
        Drawable r5 = view.getResources().getDrawable(shadowId);
        Rect r0 = new Rect();
        r5.getPadding(r0);
        ShadowDrawable r1 = new ShadowDrawable(r5, drawable, r0.left, r0.top);
        r1.setProjectBackwards(shouldProject);
        view.setBackground(r1);
        return r1;
    }

    public void setProjectBackwards(boolean shouldProject) {
        this.mShouldProjects = shouldProject;
    }
}

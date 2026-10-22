package obric.widget;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public class ShadowDrawableHelper {
    private boolean mShadowEnabled;
    private boolean mShadowShouldProject;
    private View mView;

    public boolean hasNewShadowFeature() {
        return true;
    }

    public ShadowDrawableHelper(View view, AttributeSet attrs, int defStyleAttr) {
        this.mView = view;
        TypedArray r3 = view.getContext().obtainStyledAttributes(attrs, R.styleable.SmtShadow, defStyleAttr, 0);
        this.mShadowEnabled = r3.getBoolean(R.styleable.SmtShadow_smt_shadow_enabled, true);
        this.mShadowShouldProject = r3.getBoolean(R.styleable.SmtShadow_smt_shadow_project, true);
        r3.recycle();
    }

    public boolean setBackground(Drawable background, int drawableId) {
        if ((this.mView.getBackground() instanceof ShadowDrawable) == false) goto L9;
        if (((ShadowDrawable) this.mView.getBackground()).getBackgroundDrawable() != background) goto L9;
        ((ShadowDrawable) this.mView.getBackground()).setProjectBackwards(this.mShadowShouldProject);
        return true;
    L9:
        if (this.mShadowEnabled == true) goto L11;
        return false;
    L11:
        if ((background instanceof ShadowDrawable) == true) goto L16;
        ShadowDrawable.setViewBackground(this.mView, background, drawableId, this.mShadowShouldProject);
        return true;
    L16:
        return false;
    }

    public void setShadowEnabled(boolean enabled) {
        this.mShadowEnabled = enabled;
    }

    public void setShadowShouldProjects(boolean shouldProjects) {
        this.mShadowShouldProject = shouldProjects;
    }

    boolean isShadowEnabled() {
        return this.mShadowEnabled;
    }

    boolean isShadowShouldProject() {
        return this.mShadowShouldProject;
    }
}

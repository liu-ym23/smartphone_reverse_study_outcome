package com.android.setupwizardlib.template;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.setupwizardlib.R;
import com.android.setupwizardlib.TemplateLayout;

/* JADX INFO: loaded from: classes.dex */
public class IconMixin implements Mixin {
    private final TemplateLayout templateLayout;

    public IconMixin(TemplateLayout r3, AttributeSet r4, int r5) {
        this.templateLayout = r3;
        TypedArray r6 = r3.getContext().obtainStyledAttributes(r4, R.styleable.SuwIconMixin, r5, 0);
        int r7 = r6.getResourceId(R.styleable.SuwIconMixin_android_icon, 0);
        if (r7 == 0) goto L5;
        setIcon(r7);
    L5:
        r6.recycle();
    }

    public void setIcon(Drawable r1) {
        ImageView r0 = getView();
        if (r0 == null) goto L10;
        r0.setImageDrawable(r1);
        if (r1 == null) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    public void setIcon(int r1) {
        ImageView r0 = getView();
        if (r0 == null) goto L10;
        r0.setImageResource(r1);
        if (r1 == 0) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    public Drawable getIcon() {
        ImageView r0 = getView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDrawable();
    }

    public void setContentDescription(CharSequence r1) {
        ImageView r0 = getView();
        if (r0 == null) goto L6;
        r0.setContentDescription(r1);
        return;
    }

    public CharSequence getContentDescription() {
        ImageView r0 = getView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContentDescription();
    }

    protected ImageView getView() {
        return (ImageView) this.templateLayout.findManagedViewById(R.id.suw_layout_icon);
    }
}

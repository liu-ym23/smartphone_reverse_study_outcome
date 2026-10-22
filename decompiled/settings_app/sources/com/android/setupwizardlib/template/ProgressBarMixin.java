package com.android.setupwizardlib.template;

import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewStub;
import android.widget.ProgressBar;
import com.android.setupwizardlib.R;
import com.android.setupwizardlib.TemplateLayout;

/* JADX INFO: loaded from: classes.dex */
public class ProgressBarMixin implements Mixin {
    private ColorStateList color;
    private final TemplateLayout templateLayout;

    public ProgressBarMixin(TemplateLayout r1) {
        this.templateLayout = r1;
    }

    public boolean isShown() {
        View r1 = this.templateLayout.findManagedViewById(R.id.suw_layout_progress);
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.getVisibility() != 0) goto L7;
        return true;
    }

    public void setShown(boolean r1) {
        if (r1 == false) goto L6;
        ProgressBar r0 = getProgressBar();
        if (r0 == null) goto L10;
        r0.setVisibility(0);
        return;
    L10:
        return;
    L6:
        ProgressBar r2 = peekProgressBar();
        if (r2 == null) goto L12;
        r2.setVisibility(8);
        return;
    }

    private ProgressBar getProgressBar() {
        if (peekProgressBar() != null) goto L9;
        ViewStub r0 = (ViewStub) this.templateLayout.findManagedViewById(R.id.suw_layout_progress_stub);
        if (r0 == null) goto L7;
        r0.inflate();
    L7:
        setColor(this.color);
    L9:
        return peekProgressBar();
    }

    public ProgressBar peekProgressBar() {
        return (ProgressBar) this.templateLayout.findManagedViewById(R.id.suw_layout_progress);
    }

    public void setColor(ColorStateList r1) {
        this.color = r1;
        ProgressBar r0 = peekProgressBar();
        if (r0 == null) goto L6;
        r0.setIndeterminateTintList(r1);
        r0.setProgressBackgroundTintList(r1);
        return;
    }

    public ColorStateList getColor() {
        return this.color;
    }
}

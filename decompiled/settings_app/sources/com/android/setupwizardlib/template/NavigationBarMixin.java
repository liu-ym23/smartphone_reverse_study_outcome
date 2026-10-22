package com.android.setupwizardlib.template;

import android.view.View;
import com.android.setupwizardlib.R;
import com.android.setupwizardlib.TemplateLayout;
import com.android.setupwizardlib.view.NavigationBar;

/* JADX INFO: loaded from: classes.dex */
public class NavigationBarMixin implements Mixin {
    private final TemplateLayout templateLayout;

    public NavigationBarMixin(TemplateLayout r1) {
        this.templateLayout = r1;
    }

    public NavigationBar getNavigationBar() {
        View r1 = this.templateLayout.findManagedViewById(R.id.suw_layout_navigation_bar);
        if ((r1 instanceof NavigationBar) == true) goto L7;
        return null;
    L7:
        return (NavigationBar) r1;
    }

    public void setNextButtonText(int r1) {
        getNavigationBar().getNextButton().setText(r1);
    }

    public void setNextButtonText(CharSequence r1) {
        getNavigationBar().getNextButton().setText(r1);
    }

    public CharSequence getNextButtonText() {
        return getNavigationBar().getNextButton().getText();
    }

    public void setNavigationBarListener(NavigationBar.NavigationBarListener r1) {
        getNavigationBar().setNavigationBarListener(r1);
    }
}

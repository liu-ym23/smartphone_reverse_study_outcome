package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public class HomepageAppBarScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
    private boolean mInitialized;

    public HomepageAppBarScrollingViewBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout r1, View r2, View r3) {
        boolean r4 = super.onDependentViewChanged(r1, r2, r3);
        if (this.mInitialized == false) goto L5;
    L7:
        return r4;
    L5:
        if ((r3 instanceof AppBarLayout) == false) goto L7;
        this.mInitialized = true;
        setAppBarLayoutTransparent((AppBarLayout) r3);
        goto L7
    }

    void setAppBarLayoutTransparent(AppBarLayout r1) {
        r1.setBackgroundColor(0);
        r1.setTargetElevation(0.0f);
    }
}

package com.obric.oui.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes3.dex */
public class HomepageAppBarScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
    private boolean mInitialized;

    public HomepageAppBarScrollingViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        boolean r1 = super.onDependentViewChanged(parent, child, dependency);
        if (this.mInitialized == false) goto L5;
    L7:
        return r1;
    L5:
        if ((dependency instanceof AppBarLayout) == false) goto L7;
        this.mInitialized = true;
        setAppBarLayoutTransparent((AppBarLayout) dependency);
        goto L7
    }

    void setAppBarLayoutTransparent(AppBarLayout appBarLayout) {
        appBarLayout.setBackgroundColor(0);
        appBarLayout.setTargetElevation(0.0f);
    }
}

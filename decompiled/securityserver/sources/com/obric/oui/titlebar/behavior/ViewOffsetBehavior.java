package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes2.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewOffsetHelper f308a;
    public int b;

    public ViewOffsetBehavior() {
        this.b = 0;
    }

    public void layoutChild(CoordinatorLayout r1, View r2, int r3) {
        r1.onLayoutChild(r2, r3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r1, View r2, int r3) {
        layoutChild(r1, r2, r3);
        if (this.f308a != null) goto L5;
        this.f308a = new ViewOffsetHelper(r2);
    L5:
        ViewOffsetHelper r4 = this.f308a;
        View r5 = r4.f309a;
        r4.b = r5.getTop();
        r4.c = r5.getLeft();
        this.f308a.a();
        int r6 = this.b;
        if (r6 == 0) goto L13;
        ViewOffsetHelper r7 = this.f308a;
        if (r7.f310d == r6) goto L10;
        r7.f310d = r6;
        r7.a();
    L10:
        this.b = 0;
        return true;
    L13:
        return true;
    }

    public ViewOffsetBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.b = 0;
    }
}

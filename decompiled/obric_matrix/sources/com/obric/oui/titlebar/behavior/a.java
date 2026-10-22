package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes2.dex */
class a<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f11585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11587c;

    public a() {
        this.f11586b = 0;
        this.f11587c = 0;
    }

    public a(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.f11586b = 0;
        this.f11587c = 0;
    }

    public int getTopAndBottomOffset() {
        b r0 = this.f11585a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b();
    }

    protected void layoutChild(@NonNull CoordinatorLayout r1, @NonNull V r2, int r3) {
        r1.onLayoutChild(r2, r3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r1, @NonNull V r2, int r3) {
        layoutChild(r1, r2, r3);
        if (this.f11585a != null) goto L5;
        this.f11585a = new b(r2);
    L5:
        this.f11585a.c();
        this.f11585a.a();
        int r4 = this.f11586b;
        if (r4 == 0) goto L8;
        this.f11585a.e(r4);
        this.f11586b = 0;
    L8:
        int r5 = this.f11587c;
        if (r5 == 0) goto L13;
        this.f11585a.d(r5);
        this.f11587c = 0;
        return true;
    L13:
        return true;
    }

    public boolean setTopAndBottomOffset(int r2) {
        b r0 = this.f11585a;
        if (r0 != null) goto L5;
        this.f11586b = r2;
        return false;
    L5:
        return r0.e(r2);
    }
}

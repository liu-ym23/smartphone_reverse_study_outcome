package com.obric.oui.calendar;

import android.content.Context;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
class c extends ViewPager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10874f;

    public c(@NonNull Context r1) {
        super(r1);
        this.f10874f = true;
    }

    public void a(boolean r1) {
        this.f10874f = r1;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int r2) {
        if (this.f10874f == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r2) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r2) {
        if (this.f10874f == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically(r2) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.f10874f == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r2) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        if (this.f10874f == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r2) == false) goto L7;
        return true;
    }
}

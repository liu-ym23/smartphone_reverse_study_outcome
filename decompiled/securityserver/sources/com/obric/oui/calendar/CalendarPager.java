package com.obric.oui.calendar;

import android.content.Context;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
class CalendarPager extends ViewPager {
    public boolean b;

    public CalendarPager(Context r1) {
        super(r1);
        this.b = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean canScrollHorizontally(int r2) {
        if (this.b == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r2) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r2) {
        if (this.b == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically(r2) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.b == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r2) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        if (this.b == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r2) == false) goto L7;
        return true;
    }
}

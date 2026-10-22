package com.obric.oui.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes3.dex */
class CalendarPager extends ViewPager {
    private boolean pagingEnabled;

    public CalendarPager(Context r1) {
        super(r1);
        this.pagingEnabled = true;
    }

    public CalendarPager(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.pagingEnabled = true;
    }

    public void setPagingEnabled(boolean r1) {
        this.pagingEnabled = r1;
    }

    public boolean isPagingEnabled() {
        return this.pagingEnabled;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.pagingEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r2) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        if (this.pagingEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r2) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r2) {
        if (this.pagingEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically(r2) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int r2) {
        if (this.pagingEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r2) == false) goto L7;
        return true;
    }
}

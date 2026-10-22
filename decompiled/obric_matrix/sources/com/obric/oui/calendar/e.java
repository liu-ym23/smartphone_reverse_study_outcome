package com.obric.oui.calendar;

import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes2.dex */
abstract class e extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayList<t> f10887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayList<j> f10888g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final DayOfWeek f10889h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f10890i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MaterialCalendarView f10891j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CalendarDay f10892k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CalendarDay f10893l;
    private CalendarDay m;
    protected boolean n;
    private final Collection<g> o;

    protected static class a extends ViewGroup.MarginLayoutParams {
        public a() {
            super(-2, -2);
        }
    }

    public e(@NonNull MaterialCalendarView r2, CalendarDay r3, DayOfWeek r4, boolean r5) {
        super(r2.getContext());
        this.f10887f = new ArrayList();
        this.f10888g = new ArrayList();
        this.f10890i = 4;
        this.f10893l = null;
        this.m = null;
        ArrayList r0 = new ArrayList();
        this.o = r0;
        this.f10891j = r2;
        this.f10892k = r3;
        this.f10889h = r4;
        this.n = r5;
        setClipChildren(false);
        setClipToPadding(false);
        if (r5 == false) goto L5;
        c(k());
    L5:
        b(r0, k());
    }

    private void c(LocalDate r5) {
        int r0 = 0;
    L4:
        if (r0 >= 7) goto L9;
        t r1 = new t(getContext(), r5.getDayOfWeek());
        if (Build.VERSION.SDK_INT < 16) goto L8;
        r1.setImportantForAccessibility(2);
    L8:
        this.f10887f.add(r1);
        addView(r1);
        r5 = r5.plusDays(1);
        r0 = r0 + 1;
        goto L4
    }

    protected void a(Collection<g> r3, LocalDate r4) {
        CalendarDay r5 = CalendarDay.d(r4);
        g r0 = new g(getContext(), r5);
        r0.setOnClickListener(this);
        r0.setOnLongClickListener(this);
        r3.add(r0);
        addView(r0, new a());
    }

    protected abstract void b(Collection<g> r1, LocalDate r2);

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof a;
    }

    protected a d() {
        return new a();
    }

    public a e(AttributeSet r1) {
        return new a();
    }

    protected DayOfWeek f() {
        return this.f10889h;
    }

    protected CalendarDay g() {
        return this.f10892k;
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return d();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return e(r1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new a();
    }

    protected abstract int h();

    protected void i() {
        i r0 = new i();
        Iterator<g> r1 = this.o.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        g r2 = r1.next();
        r0.g();
        Iterator<j> r3 = this.f10888g.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        j r4 = r3.next();
        if (r4.f10907a.a(r2.g()) == false) goto L7;
        r4.f10908b.a(r0);
        goto L7
    L11:
        r2.a(r0);
        goto L4
    }

    protected abstract boolean j(CalendarDay r1);

    protected LocalDate k() {
        boolean r1 = true;
        LocalDate r0 = g().e().with(WeekFields.of(this.f10889h, 1).dayOfWeek(), 1);
        int r3 = f().getValue() - r0.getDayOfWeek().getValue();
        if (MaterialCalendarView.K(this.f10890i) == false) goto L6;
        if (r3 >= 0) goto L9;
    L8:
        r1 = false;
    L9:
        if (r1 == false) goto L12;
        r3 = r3 - 7;
    L12:
        return r0.plusDays(r3);
    L6:
        if (r3 <= 0) goto L8;
        goto L8
    }

    public void l(int r4) {
        Iterator<g> r0 = this.o.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setTextAppearance(getContext(), r4);
        goto L4
    }

    public void m(com.obric.oui.calendar.v.e r2) {
        Iterator<g> r1 = this.o.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().l(r2);
        goto L4
    }

    public void n(com.obric.oui.calendar.v.e r2) {
        Iterator<g> r1 = this.o.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().m(r2);
        goto L4
    }

    void o(List<j> r2) {
        this.f10888g.clear();
        if (r2 == null) goto L5;
        this.f10888g.addAll(r2);
    L5:
        i();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if ((r2 instanceof g) == false) goto L6;
        MaterialCalendarView r1 = this.f10891j;
        r1.C((g) r2);
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r1) {
        super.onInitializeAccessibilityEvent(r1);
        r1.setClassName(e.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setClassName(e.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        int r13 = getWidth();
        int r14 = getChildCount();
        int r0 = r13;
        int r15 = 0;
        int r16 = 0;
        int r1 = 0;
    L3:
        if (r15 >= r14) goto L15;
        View r2 = getChildAt(r15);
        int r3 = r2.getMeasuredWidth();
        int r4 = r2.getMeasuredHeight();
        int r5 = r15 % 7;
        if (r5 <= 0) goto L8;
        r16 = r16 + this.f10891j.getTileHSpacing();
        r0 = r0 + this.f10891j.getTileHSpacing();
    L8:
        if (k.a() == false) goto L10;
        int r6 = r0 - r3;
        r2.layout(r6, r1, r0, r1 + r4);
        r0 = r6;
    L12:
        if (r5 != 6) goto L14;
        r1 = (r1 + r4) + this.f10891j.getTileVSpacing();
        r0 = r13;
        r16 = 0;
    L14:
        r15 = r15 + 1;
        goto L3
    L10:
        int r7 = r3 + r16;
        r2.layout(r16, r1, r7, r1 + r4);
        r16 = r7;
        goto L12
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r2) {
        if ((r2 instanceof g) == false) goto L6;
        MaterialCalendarView r1 = this.f10891j;
        r1.D((g) r2);
        return true;
    L6:
        return false;
    }

    @Override // android.view.View
    protected void onMeasure(int r5, int r6) {
        int r0 = View.MeasureSpec.getSize(r5);
        int r7 = View.MeasureSpec.getMode(r5);
        int r1 = View.MeasureSpec.getSize(r6);
        if (View.MeasureSpec.getMode(r6) == 0) goto L10;
        if (r7 == 0) goto L10;
        int r8 = r0 / 7;
        int r9 = r1 / h();
        int r2 = 0;
        setMeasuredDimension(r0, r1 + (this.f10891j.getTileVSpacing() * Math.max(0, h() - 1)));
        int r10 = getChildCount();
    L6:
        if (r2 >= r10) goto L8;
        getChildAt(r2).measure(View.MeasureSpec.makeMeasureSpec(this.f10891j.getTileWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r9, BasicMeasure.EXACTLY));
        r2 = r2 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new IllegalStateException("CalendarPagerView should never be left to decide it's size");
    }

    public void p(CalendarDay r1) {
        this.m = r1;
        x();
    }

    public void q(CalendarDay r1) {
        this.f10893l = r1;
        x();
    }

    public void r(Collection<CalendarDay> r4) {
        Iterator<g> r0 = this.o.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        g r1 = r0.next();
        CalendarDay r2 = r1.g();
        if (r4 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        r1.setChecked(r3);
        goto L4
    L8:
        if (r4.contains(r2) == false) goto L10;
        r3 = true;
        goto L11
    L12:
        postInvalidate();
    }

    public void s(int r2) {
        Iterator<g> r1 = this.o.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().o(r2);
        goto L4
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t(boolean r4) {
        Iterator<g> r0 = this.o.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        g r1 = r0.next();
        if (r4 == false) goto L8;
        e r2 = this;
    L9:
        r1.setOnClickListener(r2);
        r1.setClickable(r4);
        goto L4
    L8:
        r2 = null;
        goto L9
    }

    public void u(int r1) {
        this.f10890i = r1;
        x();
    }

    public void v(com.obric.oui.calendar.v.h r2) {
        Iterator<t> r1 = this.f10887f.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().b(r2);
        goto L4
    }

    public void w(int r4) {
        Iterator<t> r0 = this.f10887f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setTextAppearance(getContext(), r4);
        goto L4
    }

    protected void x() {
        Iterator<g> r0 = this.o.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        g r1 = r0.next();
        CalendarDay r2 = r1.g();
        r1.q(this.f10890i, r2.p(this.f10893l, this.m), j(r2));
        goto L4
    L6:
        postInvalidate();
    }
}

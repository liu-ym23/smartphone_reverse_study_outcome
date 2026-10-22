package com.obric.oui.calendar;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.text.TextUtilsCompat;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.oui.calendar.format.WeekDayFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes2.dex */
abstract class CalendarPagerView extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {
    public final ArrayList b;
    public final ArrayList c;
    public final DayOfWeek e;
    public int f;
    public final MaterialCalendarView i;
    public final CalendarDay j;
    public CalendarDay k;
    public CalendarDay l;
    public final boolean m;
    public final ArrayList n;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams() {
            super(-2, -2);
        }
    }

    public CalendarPagerView(MaterialCalendarView r2, CalendarDay r3, DayOfWeek r4, boolean r5) {
        super(r2.getContext());
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.f = 4;
        this.k = null;
        this.l = null;
        ArrayList r0 = new ArrayList();
        this.n = r0;
        this.i = r2;
        this.j = r3;
        this.e = r4;
        this.m = r5;
        setClipChildren(false);
        setClipToPadding(false);
        if (r5 == false) goto L5;
        c(f());
    L5:
        b(r0, f());
    }

    public final void a(ArrayList r3, LocalDate r4) {
        CalendarDay r5 = CalendarDay.a(r4);
        DayView r0 = new DayView(getContext(), r5);
        r0.setOnClickListener(this);
        r0.setOnLongClickListener(this);
        r3.add(r0);
        addView(r0, new LayoutParams());
    }

    public abstract void b(ArrayList r1, LocalDate r2);

    public final void c(LocalDate r5) {
        int r0 = 0;
    L4:
        if (r0 >= 7) goto L6;
        WeekDayView r1 = new WeekDayView(getContext(), r5.getDayOfWeek());
        r1.setImportantForAccessibility(2);
        this.b.add(r1);
        addView(r1);
        r5 = r5.plusDays(1);
        r0 = r0 + 1;
        goto L4
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    public abstract int d();

    public abstract boolean e(CalendarDay r1);

    public final LocalDate f() {
        LocalDate r0 = this.j.b().with(WeekFields.of(this.e, 1).dayOfWeek(), 1);
        int r2 = this.e.getValue() - r0.getDayOfWeek().getValue();
        if (MaterialCalendarView.e(this.f) == false) goto L6;
        if (r2 < 0) goto L9;
    L7:
        r2 = r2 - 7;
    L9:
        return r0.plusDays(r2);
    L6:
        if (r2 <= 0) goto L9;
        goto L7
    }

    public final void g(int r4) {
        Iterator r0 = this.n.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((DayView) r0.next()).setTextAppearance(getContext(), r4);
        goto L4
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return new LayoutParams();
    }

    public final void h(DayFormatter r10) {
        Iterator r9 = this.n.iterator();
    L4:
        if (r9.hasNext() == false) goto L22;
        DayView r0 = (DayView) r9.next();
        DayFormatter r1 = r0.k;
        if (r1 != r0.j) goto L8;
        r1 = r10;
    L8:
        r0.k = r1;
        if (r10 != null) goto L11;
        DayFormatter r2 = DayFormatter.f192a;
    L12:
        r0.j = r2;
        CharSequence r3 = r0.getText();
        if ((r3 instanceof Spanned) == false) goto L15;
        Object[] r4 = ((Spanned) r3).getSpans(0, r3.length(), Object.class);
    L16:
        SpannableString r5 = new SpannableString(r0.j.a(r0.b));
        if (r4 == null) goto L21;
        int r6 = r4.length;
        int r7 = 0;
    L19:
        if (r7 >= r6) goto L21;
        r5.setSpan(r4[r7], 0, r5.length(), 33);
        r7 = r7 + 1;
    L21:
        r0.setText(r5);
        goto L4
    L15:
        r4 = null;
        goto L16
    L11:
        r2 = r10;
        goto L12
    }

    public final void i(DayFormatter r4) {
        Iterator r3 = this.n.iterator();
    L4:
        if (r3.hasNext() == false) goto L14;
        DayView r0 = (DayView) r3.next();
        if (r4 != null) goto L8;
        DayFormatter r1 = r0.j;
    L9:
        r0.k = r1;
        if (r1 != null) goto L12;
        String r2 = r0.j.a(r0.b);
    L13:
        r0.setContentDescription(r2);
        goto L4
    L12:
        r2 = r1.a(r0.b);
        goto L13
    L8:
        r1 = r4;
        goto L9
    }

    public final void j(List r10) {
        ArrayList r0 = this.c;
        r0.clear();
        if (r10 == null) goto L5;
        r0.addAll(r10);
    L5:
        DayViewFacade r11 = new DayViewFacade();
        Iterator r9 = this.n.iterator();
    L7:
        if (r9.hasNext() == false) goto L36;
        DayView r1 = (DayView) r9.next();
        r11.b = null;
        r11.c = null;
        LinkedList r3 = r11.f180d;
        r3.clear();
        r11.f179a = false;
        r11.e = false;
        Iterator r5 = r0.iterator();
    L10:
        if (r5.hasNext() == false) goto L20;
        DecoratorResult r6 = (DecoratorResult) r5.next();
        DayViewDecorator r7 = r6.f181a;
        CalendarDay r8 = r1.b;
        if (r7.b() == false) goto L10;
        DayViewFacade r12 = r6.b;
        Drawable r13 = r12.c;
        if (r13 == null) goto L16;
        r11.c = r13;
        r11.f179a = true;
    L16:
        Drawable r14 = r12.b;
        if (r14 == null) goto L19;
        r11.b = r14;
        r11.f179a = true;
    L19:
        r3.addAll(r12.f180d);
        r11.f179a |= r12.f179a;
        r11.e = r12.e;
        goto L10
    L20:
        r1.getClass();
        r1.n = r11.e;
        r1.c();
        Drawable r15 = r11.b;
        if (r15 != null) goto L23;
        r1.e = null;
    L24:
        r1.invalidate();
        Drawable r16 = r11.c;
        if (r16 != null) goto L27;
        r1.f = null;
    L28:
        r1.b();
        List r4 = Collections.unmodifiableList(r3);
        if (r4.isEmpty() == false) goto L30;
        r1.setText(r1.j.a(r1.b));
        goto L7
    L30:
        String r17 = r1.j.a(r1.b);
        SpannableString r18 = new SpannableString(r1.j.a(r1.b));
        Iterator r19 = r4.iterator();
    L32:
        if (r19.hasNext() == false) goto L34;
        ((DayViewFacade.Span) r19.next()).getClass();
        r18.setSpan(null, 0, r17.length(), 33);
        goto L32
    L34:
        r1.setText(r18);
        goto L7
    L27:
        r1.f = r16.getConstantState().newDrawable(r1.getResources());
        goto L28
    L23:
        r1.e = r15.getConstantState().newDrawable(r1.getResources());
        goto L24
    }

    public final void k(Collection r4) {
        Iterator r0 = this.n.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        DayView r1 = (DayView) r0.next();
        CalendarDay r2 = r1.b;
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

    public final void l(int r2) {
        Iterator r1 = this.n.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        DayView r0 = (DayView) r1.next();
        r0.c = r2;
        r0.b();
        goto L4
    }

    public final void m(boolean r4) {
        Iterator r0 = this.n.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        DayView r1 = (DayView) r0.next();
        if (r4 == false) goto L8;
        CalendarPagerView r2 = this;
    L9:
        r1.setOnClickListener(r2);
        r1.setClickable(r4);
        goto L4
    L8:
        r2 = null;
        goto L9
    }

    public final void n(int r1) {
        this.f = r1;
        q();
    }

    public final void o(WeekDayFormatter r4) {
        Iterator r3 = this.b.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        WeekDayView r0 = (WeekDayView) r3.next();
        r0.getClass();
        if (r4 != null) goto L8;
        WeekDayFormatter r1 = WeekDayFormatter.f194a;
    L9:
        r0.b = r1;
        DayOfWeek r2 = r0.c;
        r0.c = r2;
        r0.setText(r1.a(r2));
        goto L4
    L8:
        r1 = r4;
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        if ((r8 instanceof DayView) == false) goto L43;
        DayView r9 = (DayView) r8;
        MaterialCalendarView r7 = this.i;
        CalendarDay r0 = r7.getCurrentDate();
        CalendarDay r1 = r9.b;
        int r2 = r0.d();
        int r3 = r1.d();
        if (r7.m == CalendarMode.c) goto L7;
    L19:
        CalendarDay r4 = r9.b;
        boolean r10 = !r9.isChecked();
        int r5 = r7.B;
        if (r5 != 2) goto L22;
        r7.j.p(r4, r10);
        r7.c(r4, r10);
        return;
    L22:
        if (r5 == 3) goto L24;
        r7.j.a();
        r7.j.p(r4, true);
        r7.c(r4, true);
        return;
    L24:
        List r6 = r7.j.g();
        if (r6.size() != 0) goto L28;
        r7.j.p(r4, r10);
        r7.c(r4, r10);
        return;
    L28:
        if (r6.size() != 1) goto L40;
        CalendarDay r11 = (CalendarDay) r6.get(0);
        if (r11.equals(r4) == false) goto L33;
        r7.j.p(r4, r10);
        r7.c(r4, r10);
        return;
    L33:
        if (r11.f(r4) == false) goto L37;
        r7.j.o(r4, r11);
        r7.j.g();
        OnRangeSelectedListener r12 = r7.u;
        if (r12 == null) goto L47;
        r12.a();
        return;
    L47:
        return;
    L37:
        r7.j.o(r11, r4);
        r7.j.g();
        OnRangeSelectedListener r13 = r7.u;
        if (r13 == null) goto L49;
        r13.a();
        return;
    L49:
        return;
    L40:
        r7.j.a();
        r7.j.p(r4, r10);
        r7.c(r4, r10);
        return;
    L7:
        if (r7.C == false) goto L19;
        if (r2 == r3) goto L19;
        boolean r14 = r0.f(r1);
        CalendarPager r15 = r7.i;
        if (r14 == false) goto L15;
        if (r15.getCurrentItem() <= 0) goto L19;
        r15.setCurrentItem(r15.getCurrentItem() - 1, true);
        goto L19
    L15:
        if (r0.g(r1) == false) goto L19;
        if (r15.getCurrentItem() >= (r7.j.getCount() - 1)) goto L19;
        r15.setCurrentItem(r15.getCurrentItem() + 1, true);
        goto L19
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
        super.onInitializeAccessibilityEvent(r1);
        r1.setClassName(CalendarPagerView.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setClassName(CalendarPagerView.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getWidth();
        int r16 = getChildCount();
        int r0 = r15;
        int r17 = 0;
        int r18 = 0;
        int r1 = 0;
    L3:
        if (r17 >= r16) goto L15;
        View r2 = getChildAt(r17);
        int r3 = r2.getMeasuredWidth();
        int r4 = r2.getMeasuredHeight();
        int r5 = r17 % 7;
        MaterialCalendarView r6 = this.i;
        if (r5 <= 0) goto L8;
        r18 = r18 + r6.getTileHSpacing();
        r0 = r0 + r6.getTileHSpacing();
    L8:
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L10;
        int r7 = r0 - r3;
        r2.layout(r7, r1, r0, r1 + r4);
        r0 = r7;
    L12:
        if (r5 != 6) goto L14;
        r1 = (r1 + r4) + r6.getTileVSpacing();
        r0 = r15;
        r18 = 0;
    L14:
        r17 = r17 + 1;
        goto L3
    L10:
        int r8 = r3 + r18;
        r2.layout(r18, r1, r8, r1 + r4);
        r18 = r8;
        goto L12
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        if ((r2 instanceof DayView) == false) goto L9;
        DayView r3 = (DayView) r2;
        OnDateLongClickListener r1 = this.i.s;
        if (r1 == null) goto L11;
        CalendarDay r4 = r3.b;
        r1.a();
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    @Override // android.view.View
    public final void onMeasure(int r6, int r7) {
        int r0 = View.MeasureSpec.getSize(r6);
        int r8 = View.MeasureSpec.getMode(r6);
        int r1 = View.MeasureSpec.getSize(r7);
        if (View.MeasureSpec.getMode(r7) == 0) goto L10;
        if (r8 == 0) goto L10;
        int r9 = r1 / d();
        int r2 = 0;
        int r10 = Math.max(0, d() - 1);
        MaterialCalendarView r3 = this.i;
        setMeasuredDimension(r0, (r3.getTileVSpacing() * r10) + r1);
        int r11 = getChildCount();
    L6:
        if (r2 >= r11) goto L8;
        getChildAt(r2).measure(View.MeasureSpec.makeMeasureSpec(r3.getTileWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r9, BasicMeasure.EXACTLY));
        r2 = r2 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new IllegalStateException("CalendarPagerView should never be left to decide it's size");
    }

    public final void p(int r4) {
        Iterator r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WeekDayView) r0.next()).setTextAppearance(getContext(), r4);
        goto L4
    }

    public final void q() {
        Iterator r0 = this.n.iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        DayView r1 = (DayView) r0.next();
        CalendarDay r2 = r1.b;
        int r3 = this.f;
        CalendarDay r4 = this.k;
        CalendarDay r5 = this.l;
        r2.getClass();
        if (r4 != null) goto L8;
    L9:
        if (r5 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        boolean r7 = e(r2);
        r1.o = r3;
        r1.m = r7;
        r1.l = r6;
        r1.c();
        goto L4
    L11:
        if (r5.g(r2) == false) goto L14;
    L13:
        r6 = false;
        goto L15
    L8:
        if (r4.f(r2) == true) goto L13;
    L16:
        postInvalidate();
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams();
    }
}

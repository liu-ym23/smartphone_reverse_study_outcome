package com.obric.oui.calendar;

import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.oui.calendar.format.WeekDayFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes4.dex */
abstract class CalendarPagerView extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {
    protected static final int DAY_NAMES_ROW = 1;
    protected static final int DEFAULT_DAYS_IN_WEEK = 7;
    protected static final int MIN_DAYS_IN_FIRST_WEEK = 1;
    private final Collection<DayView> dayViews;
    private final ArrayList<DecoratorResult> decoratorResults;
    private final DayOfWeek firstDayOfWeek;
    private CalendarDay firstViewDay;
    private CalendarDay maxDate;
    private MaterialCalendarView mcv;
    private CalendarDay minDate;
    protected int showOtherDates;
    protected boolean showWeekDays;
    private final ArrayList<WeekDayView> weekDayViews;

    protected static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams() {
            super(-2, -2);
        }
    }

    protected abstract void buildDayViews(Collection<DayView> r1, LocalDate r2);

    protected abstract int getRows();

    protected abstract boolean isDayEnabled(CalendarDay r1);

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public CalendarPagerView(MaterialCalendarView r2, CalendarDay r3, DayOfWeek r4, boolean r5) {
        super(r2.getContext());
        this.weekDayViews = new ArrayList();
        this.decoratorResults = new ArrayList();
        this.showOtherDates = 4;
        this.minDate = null;
        this.maxDate = null;
        ArrayList r0 = new ArrayList();
        this.dayViews = r0;
        this.mcv = r2;
        this.firstViewDay = r3;
        this.firstDayOfWeek = r4;
        this.showWeekDays = r5;
        setClipChildren(false);
        setClipToPadding(false);
        if (r5 == false) goto L5;
        buildWeekDays(resetAndGetWorkingCalendar());
    L5:
        buildDayViews(r0, resetAndGetWorkingCalendar());
    }

    private void buildWeekDays(LocalDate r5) {
        int r0 = 0;
    L4:
        if (r0 >= 7) goto L6;
        WeekDayView r1 = new WeekDayView(getContext(), r5.getDayOfWeek());
        r1.setImportantForAccessibility(2);
        this.weekDayViews.add(r1);
        addView(r1);
        r5 = r5.plusDays(1);
        r0 = r0 + 1;
        goto L4
    }

    protected void addDayView(Collection<DayView> r3, LocalDate r4) {
        CalendarDay r5 = CalendarDay.from(r4);
        DayView r0 = new DayView(getContext(), r5);
        r0.setOnClickListener(this);
        r0.setOnLongClickListener(this);
        r3.add(r0);
        addView(r0, new LayoutParams());
    }

    protected LocalDate resetAndGetWorkingCalendar() {
        return getFirstViewDayOfMonth(getFirstViewDay().getDate(), this.firstDayOfWeek, MaterialCalendarView.showOtherMonths(this.showOtherDates));
    }

    static LocalDate getFirstViewDayOfMonth(LocalDate r4, DayOfWeek r5, boolean r6) {
        boolean r0 = true;
        LocalDate r7 = r4.with(WeekFields.of(r5, 1).dayOfWeek(), 1);
        int r8 = r5.getValue() - r7.getDayOfWeek().getValue();
        if (r6 == false) goto L6;
        if (r8 >= 0) goto L9;
    L8:
        r0 = false;
    L9:
        if (r0 == false) goto L12;
        r8 = r8 - 7;
    L12:
        return r7.plusDays(r8);
    L6:
        if (r8 <= 0) goto L8;
        goto L8
    }

    static int getWeekCountForMonth(LocalDate r4, DayOfWeek r5, boolean r6) {
        LocalDate r7 = getFirstViewDayOfMonth(r4, r5, r6);
        LocalDate r8 = r4.withDayOfMonth(r4.lengthOfMonth());
        return (int) ((((ChronoUnit.DAYS.between(r7, r8) + 1) + 7) - 1) / 7);
    }

    protected DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    void setDayViewDecorators(List<DecoratorResult> r2) {
        this.decoratorResults.clear();
        if (r2 == null) goto L5;
        this.decoratorResults.addAll(r2);
    L5:
        invalidateDecorators();
    }

    public void setWeekDayTextAppearance(int r4) {
        Iterator<WeekDayView> r0 = this.weekDayViews.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setTextAppearance(getContext(), r4);
        goto L4
    }

    public void setDateTextAppearance(int r4) {
        Iterator<DayView> r0 = this.dayViews.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setTextAppearance(getContext(), r4);
        goto L4
    }

    public void setShowOtherDates(int r1) {
        this.showOtherDates = r1;
        updateUi();
    }

    public void setSelectionEnabled(boolean r4) {
        Iterator<DayView> r0 = this.dayViews.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        DayView r1 = r0.next();
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

    public void setSelectionColor(int r2) {
        Iterator<DayView> r1 = this.dayViews.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setSelectionColor(r2);
        goto L4
    }

    public void setCalendarMode(CalendarMode r2) {
        Iterator<DayView> r1 = this.dayViews.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setCalendarMode(r2);
        goto L4
    }

    public void setWeekDayFormatter(WeekDayFormatter r2) {
        Iterator<WeekDayView> r1 = this.weekDayViews.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setWeekDayFormatter(r2);
        goto L4
    }

    public void setDayFormatter(DayFormatter r2) {
        Iterator<DayView> r1 = this.dayViews.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setDayFormatter(r2);
        goto L4
    }

    public void setDayFormatterContentDescription(DayFormatter r2) {
        Iterator<DayView> r1 = this.dayViews.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setDayFormatterContentDescription(r2);
        goto L4
    }

    public void setMinimumDate(CalendarDay r1) {
        this.minDate = r1;
        updateUi();
    }

    public void setMaximumDate(CalendarDay r1) {
        this.maxDate = r1;
        updateUi();
    }

    public void setSelectedDates(Collection<CalendarDay> r5) {
        Iterator<DayView> r0 = this.dayViews.iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        DayView r1 = r0.next();
        CalendarDay r2 = r1.getDate();
        if (r5 != null) goto L8;
    L10:
        boolean r3 = false;
    L12:
        if (r1.isVisibleEnabled() == false) goto L4;
        r1.setChecked(r3);
        goto L4
    L8:
        if (r5.contains(r2) == false) goto L10;
        r3 = true;
        goto L12
    L14:
        postInvalidate();
    }

    protected void updateUi() {
        Iterator<DayView> r0 = this.dayViews.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        DayView r1 = r0.next();
        CalendarDay r2 = r1.getDate();
        r1.setupSelection(this.showOtherDates, r2.isInRange(this.minDate, this.maxDate), isDayEnabled(r2));
        goto L4
    L6:
        postInvalidate();
    }

    protected void invalidateDecorators() {
        DayViewFacade r0 = new DayViewFacade();
        Iterator<DayView> r1 = this.dayViews.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        DayView r2 = r1.next();
        r0.reset();
        Iterator<DecoratorResult> r3 = this.decoratorResults.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        DecoratorResult r4 = r3.next();
        if (r4.decorator.shouldDecorate(r2.getDate()) == false) goto L7;
        r4.result.applyTo(r0);
        goto L7
    L11:
        r2.applyFacade(r0);
        goto L4
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if ((r2 instanceof DayView) == false) goto L6;
        MaterialCalendarView r1 = this.mcv;
        r1.onDateClicked((DayView) r2);
        return;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r2) {
        if ((r2 instanceof DayView) == false) goto L6;
        MaterialCalendarView r1 = this.mcv;
        r1.onDateLongClicked((DayView) r2);
        return true;
    L6:
        return false;
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.View
    protected void onMeasure(int r5, int r6) {
        int r0 = View.MeasureSpec.getSize(r5);
        int r7 = View.MeasureSpec.getMode(r5);
        int r1 = View.MeasureSpec.getSize(r6);
        if (View.MeasureSpec.getMode(r6) == 0) goto L16;
        if (r7 == 0) goto L16;
        setMeasuredDimension(r0, r1);
        int r8 = getChildCount();
        int r9 = 0;
    L6:
        if (r9 >= r8) goto L14;
        View r2 = getChildAt(r9);
        int r3 = View.MeasureSpec.makeMeasureSpec(this.mcv.getMeasureInfo().tileWidth, 1073741824);
        if (this.showWeekDays == true) goto L10;
    L12:
        int r4 = View.MeasureSpec.makeMeasureSpec(this.mcv.getMeasureInfo().tileHeight, 1073741824);
    L13:
        r2.measure(r3, r4);
        r9 = r9 + 1;
        goto L6
    L10:
        if (r9 >= 7) goto L12;
        r4 = View.MeasureSpec.makeMeasureSpec(this.mcv.getWeekDaysHeight(), 1073741824);
        goto L13
    L14:
        return;
    L16:
        throw new IllegalStateException("CalendarPagerView should never be left to decide it's size");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
        int r16 = getWidth();
        int r17 = getChildCount();
        int r18 = getHeight();
        int r19 = getRows();
        if (this.showWeekDays == false) goto L5;
        r19 = Math.max(0, r19 - 1);
    L5:
        int r110 = this.mcv.getTileHSpacing();
        int r1 = this.mcv.getTileVSpacing();
        if (r110 >= 0) goto L8;
        r110 = (r16 - (this.mcv.getMeasureInfo().tileWidth * 7)) / 6;
    L8:
        if (r1 >= 0) goto L17;
        int r2 = r19 - (!this.showWeekDays ? 1 : 0);
        if (r2 == 0) goto L16;
        int r111 = r18 - (this.mcv.getMeasureInfo().tileHeight * r19);
        if (this.showWeekDays == false) goto L14;
        int r112 = this.mcv.getWeekDaysHeight();
    L15:
        r1 = (r111 - r112) / r2;
        goto L17
    L14:
        r112 = 0;
        goto L15
    L16:
        r1 = 0;
    L17:
        int r3 = r16;
        int r113 = 0;
        int r114 = 0;
        int r4 = 0;
    L18:
        if (r113 >= r17) goto L29;
        View r5 = getChildAt(r113);
        int r6 = r5.getMeasuredWidth();
        int r7 = r5.getMeasuredHeight();
        int r8 = r113 % 7;
        if (r8 <= 0) goto L23;
        r114 = r114 + r110;
        r3 = r3 + r110;
    L23:
        if (LocalUtils.isRTL() == false) goto L25;
        int r9 = r3 - r6;
        r5.layout(r9, r4, r3, r4 + r7);
        r3 = r9;
    L26:
        if (r8 != 6) goto L28;
        r4 = (r4 + r7) + r1;
        r3 = r16;
        r114 = 0;
    L28:
        r113 = r113 + 1;
        goto L18
    L25:
        int r10 = r6 + r114;
        r5.layout(r114, r4, r10, r4 + r7);
        r114 = r10;
        goto L26
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r1) {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
        super.onInitializeAccessibilityEvent(r1);
        r1.setClassName(CalendarPagerView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setClassName(CalendarPagerView.class.getName());
    }

    protected CalendarDay getFirstViewDay() {
        return this.firstViewDay;
    }

    private int dpToPx(int r2) {
        return (int) TypedValue.applyDimension(1, r2, getResources().getDisplayMetrics());
    }
}

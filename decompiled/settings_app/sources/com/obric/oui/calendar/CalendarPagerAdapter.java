package com.obric.oui.calendar;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.obric.oui.calendar.CalendarPagerView;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.oui.calendar.format.TitleFormatter;
import com.obric.oui.calendar.format.WeekDayFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes4.dex */
abstract class CalendarPagerAdapter<V extends CalendarPagerView> extends PagerAdapter {
    private Integer color;
    private final ArrayDeque<V> currentViews;
    private Integer dateTextAppearance;
    private DayFormatter dayFormatter;
    private DayFormatter dayFormatterContentDescription;
    private List<DecoratorResult> decoratorResults;
    private List<DayViewDecorator> decorators;
    private CalendarDay maxDate;
    protected final MaterialCalendarView mcv;
    private CalendarDay minDate;
    private DateRangeIndex rangeIndex;
    private List<CalendarDay> selectedDates;
    private boolean selectionEnabled;
    private int showOtherDates;
    boolean showWeekDays;
    private TitleFormatter titleFormatter;
    private final CalendarDay today;
    private WeekDayFormatter weekDayFormatter;
    private Integer weekDayTextAppearance;

    protected abstract DateRangeIndex createRangeIndex(CalendarDay r1, CalendarDay r2);

    protected abstract V createView(int r1);

    protected abstract int indexOf(V r1);

    protected abstract boolean isInstanceOfView(Object r1);

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r1, Object r2) {
        if (r1 != r2) goto L4;
        return true;
    L4:
        return false;
    }

    CalendarPagerAdapter(MaterialCalendarView r3) {
        this.titleFormatter = TitleFormatter.DEFAULT;
        this.color = null;
        this.dateTextAppearance = null;
        this.weekDayTextAppearance = null;
        this.showOtherDates = 4;
        this.minDate = null;
        this.maxDate = null;
        this.selectedDates = new ArrayList();
        this.weekDayFormatter = WeekDayFormatter.DEFAULT;
        DayFormatter r1 = DayFormatter.DEFAULT;
        this.dayFormatter = r1;
        this.dayFormatterContentDescription = r1;
        this.decorators = new ArrayList();
        this.decoratorResults = null;
        this.selectionEnabled = true;
        this.mcv = r3;
        this.today = CalendarDay.today();
        ArrayDeque<V> r4 = new ArrayDeque();
        this.currentViews = r4;
        r4.iterator();
        setRangeDates(null, null);
    }

    public void setDecorators(List<DayViewDecorator> r1) {
        this.decorators = r1;
        invalidateDecorators();
    }

    public void invalidateDecorators() {
        this.decoratorResults = new ArrayList();
        Iterator<DayViewDecorator> r0 = this.decorators.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        DayViewDecorator r1 = r0.next();
        DayViewFacade r2 = new DayViewFacade();
        r1.decorate(r2);
        if (r2.isDecorated() == false) goto L4;
        this.decoratorResults.add(new DecoratorResult(r1, r2));
        goto L4
    L8:
        Iterator<V> r3 = this.currentViews.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        r3.next().setDayViewDecorators(this.decoratorResults);
        goto L10
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.rangeIndex.getCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int r2) {
        return this.titleFormatter.format(getItem(r2));
    }

    public CalendarPagerAdapter<?> migrateStateAndReturn(CalendarPagerAdapter<?> r2) {
        r2.titleFormatter = this.titleFormatter;
        r2.color = this.color;
        r2.dateTextAppearance = this.dateTextAppearance;
        r2.weekDayTextAppearance = this.weekDayTextAppearance;
        r2.showOtherDates = this.showOtherDates;
        r2.minDate = this.minDate;
        r2.maxDate = this.maxDate;
        r2.selectedDates = this.selectedDates;
        r2.weekDayFormatter = this.weekDayFormatter;
        r2.dayFormatter = this.dayFormatter;
        r2.dayFormatterContentDescription = this.dayFormatterContentDescription;
        r2.decorators = this.decorators;
        r2.decoratorResults = this.decoratorResults;
        r2.selectionEnabled = this.selectionEnabled;
        return r2;
    }

    public int getIndexForDay(CalendarDay r2) {
        if (r2 == null) goto L4;
        CalendarDay r0 = this.minDate;
        if (r0 != null) goto L8;
    L11:
        CalendarDay r1 = this.maxDate;
        if (r1 == null) goto L18;
        if (r2.isAfter(r1) == false) goto L18;
        return getCount() - 1;
    L18:
        return this.rangeIndex.indexOf(r2);
    L8:
        if (r2.isBefore(r0) == false) goto L11;
        return 0;
    L4:
        return getCount() / 2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object r3) {
        if (isInstanceOfView(r3) == true) goto L5;
        return -2;
    L5:
        CalendarPagerView r4 = (CalendarPagerView) r3;
        if (r4.getFirstViewDay() != null) goto L8;
        return -2;
    L8:
        int r2 = indexOf(r4);
        if (r2 >= 0) goto L11;
        return -2;
    L11:
        return r2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r2, int r3) {
        CalendarPagerView r4 = createView(r3);
        r4.setContentDescription(this.mcv.getCalendarContentDescription());
        r4.setAlpha(0.0f);
        r4.setSelectionEnabled(this.selectionEnabled);
        r4.setWeekDayFormatter(this.weekDayFormatter);
        r4.setDayFormatter(this.dayFormatter);
        r4.setDayFormatterContentDescription(this.dayFormatterContentDescription);
        Integer r0 = this.color;
        if (r0 == null) goto L6;
        r4.setSelectionColor(r0.intValue());
    L6:
        if ((r4 instanceof WeekView) == false) goto L8;
        CalendarMode r1 = CalendarMode.WEEKS;
    L9:
        r4.setCalendarMode(r1);
        Integer r5 = this.dateTextAppearance;
        if (r5 == null) goto L12;
        r4.setDateTextAppearance(r5.intValue());
    L12:
        Integer r6 = this.weekDayTextAppearance;
        if (r6 == null) goto L15;
        r4.setWeekDayTextAppearance(r6.intValue());
    L15:
        r4.setShowOtherDates(this.showOtherDates);
        r4.setMinimumDate(this.minDate);
        r4.setMaximumDate(this.maxDate);
        r4.setSelectedDates(this.selectedDates);
        r2.addView(r4);
        this.currentViews.add((V) r4);
        r4.setDayViewDecorators(this.decoratorResults);
        return r4;
    L8:
        r1 = CalendarMode.MONTHS;
        goto L9
    }

    public void setShowWeekDays(boolean r1) {
        this.showWeekDays = r1;
    }

    public boolean isShowWeekDays() {
        return this.showWeekDays;
    }

    public void setSelectionEnabled(boolean r3) {
        this.selectionEnabled = r3;
        Iterator<V> r4 = this.currentViews.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.next().setSelectionEnabled(this.selectionEnabled);
        goto L4
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r1, int r2, Object r3) {
        CalendarPagerView r4 = (CalendarPagerView) r3;
        this.currentViews.remove(r4);
        r1.removeView(r4);
    }

    public void setTitleFormatter(TitleFormatter r1) {
        if (r1 != null) goto L4;
        r1 = TitleFormatter.DEFAULT;
    L4:
        this.titleFormatter = r1;
    }

    public void setSelectionColor(int r2) {
        this.color = Integer.valueOf(r2);
        Iterator<V> r1 = this.currentViews.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setSelectionColor(r2);
        goto L4
    }

    public void setDateTextAppearance(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        this.dateTextAppearance = Integer.valueOf(r2);
        Iterator<V> r1 = this.currentViews.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().setDateTextAppearance(r2);
        goto L6
    }

    public void setShowOtherDates(int r2) {
        this.showOtherDates = r2;
        Iterator<V> r1 = this.currentViews.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setShowOtherDates(r2);
        goto L4
    }

    public void setWeekDayFormatter(WeekDayFormatter r2) {
        this.weekDayFormatter = r2;
        Iterator<V> r1 = this.currentViews.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setWeekDayFormatter(r2);
        goto L4
    }

    public void setDayFormatter(DayFormatter r3) {
        DayFormatter r0 = this.dayFormatterContentDescription;
        if (r0 != this.dayFormatter) goto L5;
        r0 = r3;
    L5:
        this.dayFormatterContentDescription = r0;
        this.dayFormatter = r3;
        Iterator<V> r2 = this.currentViews.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r2.next().setDayFormatter(r3);
        goto L7
    }

    public void setDayFormatterContentDescription(DayFormatter r2) {
        this.dayFormatterContentDescription = r2;
        Iterator<V> r1 = this.currentViews.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setDayFormatterContentDescription(r2);
        goto L4
    }

    public int getShowOtherDates() {
        return this.showOtherDates;
    }

    public void setWeekDayTextAppearance(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        this.weekDayTextAppearance = Integer.valueOf(r2);
        Iterator<V> r1 = this.currentViews.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().setWeekDayTextAppearance(r2);
        goto L6
    }

    public void setRangeDates(CalendarDay r3, CalendarDay r4) {
        this.minDate = r3;
        this.maxDate = r4;
        Iterator<V> r0 = this.currentViews.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        V r1 = r0.next();
        r1.setMinimumDate(r3);
        r1.setMaximumDate(r4);
        goto L4
    L6:
        if (r3 != null) goto L8;
        r3 = CalendarDay.from(this.today.getYear() - 200, this.today.getMonth(), this.today.getDay());
    L8:
        if (r4 != null) goto L10;
        r4 = CalendarDay.from(this.today.getYear() + 200, this.today.getMonth(), this.today.getDay());
    L10:
        this.rangeIndex = createRangeIndex(r3, r4);
        notifyDataSetChanged();
        invalidateSelectedDates();
    }

    public DateRangeIndex getRangeIndex() {
        return this.rangeIndex;
    }

    public void clearSelections() {
        this.selectedDates.clear();
        invalidateSelectedDates();
    }

    public void setDateSelected(CalendarDay r1, boolean r2) {
        if (r2 == false) goto L7;
        if (this.selectedDates.contains(r1) == true) goto L10;
        this.selectedDates.add(r1);
        invalidateSelectedDates();
        return;
    L10:
        return;
    L7:
        if (this.selectedDates.contains(r1) == false) goto L12;
        this.selectedDates.remove(r1);
        invalidateSelectedDates();
        return;
    }

    public void selectRange(CalendarDay r3, CalendarDay r4) {
        this.selectedDates.clear();
        LocalDate r5 = LocalDate.of(r3.getYear(), r3.getMonth(), r3.getDay());
        LocalDate r6 = r4.getDate();
    L4:
        if (r5.isBefore(r6) == true) goto L10;
        if (r5.equals(r6) == true) goto L10;
        invalidateSelectedDates();
        return;
    L10:
        this.selectedDates.add(CalendarDay.from(r5));
        r5 = r5.plusDays(1);
        goto L4
    }

    private void invalidateSelectedDates() {
        validateSelectedDates();
        Iterator<V> r0 = this.currentViews.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setSelectedDates(this.selectedDates);
        goto L4
    }

    private void validateSelectedDates() {
        int r0 = 0;
    L4:
        if (r0 >= this.selectedDates.size()) goto L15;
        CalendarDay r1 = this.selectedDates.get(r0);
        CalendarDay r2 = this.minDate;
        if (r2 != null) goto L8;
    L9:
        CalendarDay r3 = this.maxDate;
        if (r3 == null) goto L14;
        if (r3.isBefore(r1) == false) goto L14;
    L13:
        this.selectedDates.remove(r0);
        this.mcv.onDateUnselected(r1);
        r0 = r0 - 1;
    L14:
        r0 = r0 + 1;
        goto L4
    L8:
        if (r2.isAfter(r1) == true) goto L13;
    }

    public CalendarDay getItem(int r1) {
        return this.rangeIndex.getItem(r1);
    }

    public List<CalendarDay> getSelectedDates() {
        return Collections.unmodifiableList(this.selectedDates);
    }

    protected int getDateTextAppearance() {
        Integer r0 = this.dateTextAppearance;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    protected int getWeekDayTextAppearance() {
        Integer r0 = this.weekDayTextAppearance;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }
}

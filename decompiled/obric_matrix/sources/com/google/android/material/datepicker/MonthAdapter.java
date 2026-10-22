package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class MonthAdapter extends BaseAdapter {
    static final int MAXIMUM_WEEKS = 0;
    final CalendarConstraints calendarConstraints;
    CalendarStyle calendarStyle;
    final DateSelector<?> dateSelector;
    final Month month;
    private Collection<Long> previouslySelectedDates;

    static {
        MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    }

    MonthAdapter(Month r1, DateSelector<?> r2, CalendarConstraints r3) {
        this.month = r1;
        this.dateSelector = r2;
        this.calendarConstraints = r3;
        this.previouslySelectedDates = r2.getSelectedDays();
    }

    private void initializeStyles(Context r2) {
        if (this.calendarStyle != null) goto L6;
        this.calendarStyle = new CalendarStyle(r2);
        return;
    }

    private boolean isSelected(long r5) {
        Iterator<Long> r4 = this.dateSelector.getSelectedDays().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        long r0 = r4.next().longValue();
        if (UtcDates.canonicalYearMonthDay(r5) != UtcDates.canonicalYearMonthDay(r0)) goto L4;
        return true;
    L9:
        return false;
    }

    private void updateSelectedState(@Nullable TextView r3, long r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.calendarConstraints.getDateValidator().isValid(r4) == false) goto L13;
        r3.setEnabled(true);
        if (isSelected(r4) == false) goto L9;
        CalendarItemStyle r2 = this.calendarStyle.selectedDay;
    L14:
        r2.styleItem(r3);
        return;
    L9:
        long r0 = UtcDates.getTodayCalendar().getTimeInMillis();
        CalendarStyle r5 = this.calendarStyle;
        if (r0 != r4) goto L12;
        r2 = r5.todayDay;
        goto L14
    L12:
        r2 = r5.day;
        goto L14
    L13:
        r3.setEnabled(false);
        r2 = this.calendarStyle.invalidDay;
        goto L14
    }

    private void updateSelectedStateForDate(MaterialCalendarGridView r3, long r4) {
        if (Month.create(r4).equals(this.month) == false) goto L6;
        int r0 = this.month.getDayOfMonth(r4);
        updateSelectedState((TextView) r3.getChildAt(r3.getAdapter().dayToPosition(r0) - r3.getFirstVisiblePosition()), r4);
        return;
    }

    int dayToPosition(int r1) {
        return firstPositionInMonth() + (r1 - 1);
    }

    int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.month.daysInMonth + firstPositionInMonth();
    }

    @Override // android.widget.Adapter
    @Nullable
    public Long getItem(int r2) {
        if (r2 >= this.month.daysFromStartOfWeekToFirstOfMonth()) goto L5;
        return null;
    L5:
        if (r2 <= lastPositionInMonth()) goto L8;
        return null;
    L8:
        return Long.valueOf(this.month.getDay(positionToDay(r2)));
    }

    @Override // android.widget.Adapter
    @Nullable
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1 / this.month.daysInWeek;
    }

    @Override // android.widget.Adapter
    @NonNull
    public /* bridge */ /* synthetic */ View getView(int r1, @Nullable View r2, @NonNull ViewGroup r3) {
        return getView(r1, r2, r3);
    }

    @Override // android.widget.Adapter
    @NonNull
    public TextView getView(int r6, @Nullable View r7, @NonNull ViewGroup r8) {
        initializeStyles(r8.getContext());
        TextView r0 = (TextView) r7;
        if (r7 != null) goto L5;
        r0 = (TextView) LayoutInflater.from(r8.getContext()).inflate(R.layout.mtrl_calendar_day, r8, false);
    L5:
        int r9 = r6 - firstPositionInMonth();
        if (r9 < 0) goto L15;
        Month r10 = this.month;
        if (r9 >= r10.daysInMonth) goto L15;
        int r11 = r9 + 1;
        r0.setTag(r10);
        r0.setText(String.format(r0.getResources().getConfiguration().locale, TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(r11)}));
        long r12 = this.month.getDay(r11);
        if (this.month.year != Month.current().year) goto L13;
        CharSequence r13 = DateStrings.getMonthDayOfWeekDay(r12);
    L14:
        r0.setContentDescription(r13);
        r0.setVisibility(0);
        r0.setEnabled(true);
    L16:
        Long r14 = getItem(r6);
        if (r14 != null) goto L19;
        return r0;
    L19:
        updateSelectedState(r0, r14.longValue());
        return r0;
    L13:
        r13 = DateStrings.getYearMonthDayOfWeekDay(r12);
    L15:
        r0.setVisibility(8);
        r0.setEnabled(false);
        goto L16
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    boolean isFirstInRow(int r1) {
        if ((r1 % this.month.daysInWeek) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isLastInRow(int r2) {
        if (((r2 + 1) % this.month.daysInWeek) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    int lastPositionInMonth() {
        return (this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth) - 1;
    }

    int positionToDay(int r1) {
        return (r1 - this.month.daysFromStartOfWeekToFirstOfMonth()) + 1;
    }

    public void updateSelectedStates(MaterialCalendarGridView r4) {
        Iterator<Long> r0 = this.previouslySelectedDates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        updateSelectedStateForDate(r4, r0.next().longValue());
        goto L4
    L6:
        DateSelector<?> r1 = this.dateSelector;
        if (r1 == null) goto L16;
        Iterator<Long> r2 = r1.getSelectedDays().iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        updateSelectedStateForDate(r4, r2.next().longValue());
        goto L10
    L12:
        this.previouslySelectedDates = this.dateSelector.getSelectedDays();
        return;
    }

    boolean withinMonth(int r2) {
        if (r2 >= firstPositionInMonth()) goto L5;
    L7:
        return false;
    L5:
        if (r2 > lastPositionInMonth()) goto L7;
        return true;
    }
}

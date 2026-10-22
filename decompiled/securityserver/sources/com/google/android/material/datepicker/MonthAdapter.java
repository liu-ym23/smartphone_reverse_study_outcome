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
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class MonthAdapter extends BaseAdapter {
    static final int MAXIMUM_WEEKS = 0;
    final CalendarConstraints calendarConstraints;
    CalendarStyle calendarStyle;
    final DateSelector<?> dateSelector;
    final Month month;

    static {
        MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    }

    public MonthAdapter(Month r1, DateSelector<?> r2, CalendarConstraints r3) {
        this.month = r1;
        this.dateSelector = r2;
        this.calendarConstraints = r3;
    }

    private void initializeStyles(Context r2) {
        if (this.calendarStyle != null) goto L6;
        this.calendarStyle = new CalendarStyle(r2);
        return;
    }

    public int dayToPosition(int r1) {
        return firstPositionInMonth() + (r1 - 1);
    }

    public int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.month.daysInMonth + firstPositionInMonth();
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

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public boolean isFirstInRow(int r1) {
        if ((r1 % this.month.daysInWeek) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLastInRow(int r2) {
        if (((r2 + 1) % this.month.daysInWeek) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public int lastPositionInMonth() {
        return (this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth) - 1;
    }

    public int positionToDay(int r1) {
        return (r1 - this.month.daysFromStartOfWeekToFirstOfMonth()) + 1;
    }

    public boolean withinMonth(int r2) {
        if (r2 >= firstPositionInMonth()) goto L5;
    L7:
        return false;
    L5:
        if (r2 > lastPositionInMonth()) goto L7;
        return true;
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
    @NonNull
    public TextView getView(int r6, @Nullable View r7, @NonNull ViewGroup r8) {
        initializeStyles(r8.getContext());
        TextView r0 = (TextView) r7;
        if (r7 != null) goto L5;
        r0 = (TextView) LayoutInflater.from(r8.getContext()).inflate(R.layout.mtrl_calendar_day, r8, false);
    L5:
        int r9 = r6 - firstPositionInMonth();
        if (r9 < 0) goto L15;
        Month r2 = this.month;
        if (r9 >= r2.daysInMonth) goto L15;
        int r10 = r9 + 1;
        r0.setTag(r2);
        r0.setText(String.valueOf(r10));
        long r3 = this.month.getDay(r10);
        if (this.month.year != Month.current().year) goto L13;
        r0.setContentDescription(DateStrings.getMonthDayOfWeekDay(r3));
    L14:
        r0.setVisibility(0);
        r0.setEnabled(true);
    L16:
        Long r11 = getItem(r6);
        if (r11 != null) goto L20;
        return r0;
    L20:
        if (this.calendarConstraints.getDateValidator().isValid(r11.longValue()) == false) goto L34;
        r0.setEnabled(true);
        Iterator<Long> r12 = this.dateSelector.getSelectedDays().iterator();
    L23:
        if (r12.hasNext() == false) goto L29;
        long r1 = r12.next().longValue();
        if (UtcDates.canonicalYearMonthDay(r11.longValue()) != UtcDates.canonicalYearMonthDay(r1)) goto L23;
        this.calendarStyle.selectedDay.styleItem(r0);
        return r0;
    L29:
        if (UtcDates.getTodayCalendar().getTimeInMillis() != r11.longValue()) goto L32;
        this.calendarStyle.todayDay.styleItem(r0);
        return r0;
    L32:
        this.calendarStyle.day.styleItem(r0);
        return r0;
    L34:
        r0.setEnabled(false);
        this.calendarStyle.invalidDay.styleItem(r0);
        return r0;
    L13:
        r0.setContentDescription(DateStrings.getYearMonthDayOfWeekDay(r3));
    L15:
        r0.setVisibility(8);
        r0.setEnabled(false);
        goto L16
    }
}

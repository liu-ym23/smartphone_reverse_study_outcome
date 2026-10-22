package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {

    @NonNull
    private final CalendarConstraints calendarConstraints;
    private final DateSelector<?> dateSelector;
    private final int itemHeight;
    private final MaterialCalendar.OnDayClickListener onDayClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final MaterialCalendarGridView monthGrid;
        final TextView monthTitle;

        public ViewHolder(@NonNull LinearLayout r3, boolean r4) {
            super(r3);
            TextView r0 = (TextView) r3.findViewById(R.id.month_title);
            this.monthTitle = r0;
            ViewCompat.setAccessibilityHeading(r0, true);
            this.monthGrid = (MaterialCalendarGridView) r3.findViewById(R.id.month_grid);
            if (r4 == true) goto L6;
            r0.setVisibility(8);
            return;
        }
    }

    public MonthsPagerAdapter(@NonNull Context r4, DateSelector<?> r5, @NonNull CalendarConstraints r6, MaterialCalendar.OnDayClickListener r7) {
        Month r0 = r6.getStart();
        Month r1 = r6.getEnd();
        Month r2 = r6.getOpenAt();
        if (r0.compareTo2(r2) > 0) goto L15;
        if (r2.compareTo2(r1) > 0) goto L13;
        int r3 = MonthAdapter.MAXIMUM_WEEKS;
        int r8 = MaterialCalendar.getDayHeight(r4) * r3;
        if (MaterialDatePicker.isFullscreen(r4) == false) goto L9;
        int r9 = MaterialCalendar.getDayHeight(r4);
    L10:
        this.itemHeight = r8 + r9;
        this.calendarConstraints = r6;
        this.dateSelector = r5;
        this.onDayClickListener = r7;
        setHasStableIds(true);
        return;
    L9:
        r9 = 0;
        goto L10
    L13:
        throw new IllegalArgumentException("currentPage cannot be after lastPage");
    L15:
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    public static /* synthetic */ MaterialCalendar.OnDayClickListener access$000(MonthsPagerAdapter r0) {
        return r0.onDayClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.calendarConstraints.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r1) {
        return this.calendarConstraints.getStart().monthsLater(r1).getStableId();
    }

    @NonNull
    public Month getPageMonth(int r1) {
        return this.calendarConstraints.getStart().monthsLater(r1);
    }

    @NonNull
    public CharSequence getPageTitle(int r1) {
        return getPageMonth(r1).getLongName();
    }

    public int getPosition(@NonNull Month r1) {
        return this.calendarConstraints.getStart().monthsUntil(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((ViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public void onBindViewHolder(@NonNull ViewHolder r4, int r5) {
        Month r6 = this.calendarConstraints.getStart().monthsLater(r5);
        r4.monthTitle.setText(r6.getLongName());
        final MaterialCalendarGridView r7 = (MaterialCalendarGridView) r4.monthGrid.findViewById(R.id.month_grid);
        if (r7.getAdapter() != null) goto L5;
    L7:
        MonthAdapter r0 = new MonthAdapter(r6, this.dateSelector, this.calendarConstraints);
        r7.setNumColumns(r6.daysInWeek);
        r7.setAdapter(r0);
    L8:
        r7.setOnItemClickListener(new AnonymousClass1(this, r7));
        return;
    L5:
        if (r6.equals(r7.getAdapter().month) == false) goto L7;
        r7.getAdapter().notifyDataSetChanged();
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup r3, int r4) {
        LinearLayout r5 = (LinearLayout) LayoutInflater.from(r3.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, r3, false);
        if (MaterialDatePicker.isFullscreen(r3.getContext()) == false) goto L7;
        r5.setLayoutParams(new RecyclerView.LayoutParams(-1, this.itemHeight));
        return new ViewHolder(r5, true);
    L7:
        return new ViewHolder(r5, false);
    }
}

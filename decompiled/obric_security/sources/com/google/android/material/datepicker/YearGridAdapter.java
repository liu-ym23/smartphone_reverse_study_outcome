package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final MaterialCalendar<?> materialCalendar;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;

        ViewHolder(TextView r1) {
            super(r1);
            this.textView = r1;
        }
    }

    static /* synthetic */ MaterialCalendar access$000(YearGridAdapter r0) {
        return r0.materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((ViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    YearGridAdapter(MaterialCalendar<?> r1) {
        this.materialCalendar = r1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        return new ViewHolder((TextView) LayoutInflater.from(r2.getContext()).inflate(R.layout.mtrl_calendar_year, r2, false));
    }

    public void onBindViewHolder(ViewHolder r8, int r9) {
        int r10 = getYearForPosition(r9);
        String r0 = r8.textView.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        r8.textView.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(r10)}));
        r8.textView.setContentDescription(String.format(r0, new Object[]{Integer.valueOf(r10)}));
        CalendarStyle r1 = this.materialCalendar.getCalendarStyle();
        Calendar r2 = UtcDates.getTodayCalendar();
        if (r2.get(1) != r10) goto L5;
        CalendarItemStyle r3 = r1.todayYear;
    L6:
        Iterator<Long> r4 = this.materialCalendar.getDateSelector().getSelectedDays().iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        r2.setTimeInMillis(r4.next().longValue());
        if (r2.get(1) != r10) goto L8;
        r3 = r1.selectedYear;
        goto L8
    L12:
        r3.styleItem(r8.textView);
        r8.textView.setOnClickListener(createYearClickListener(r10));
        return;
    L5:
        r3 = r1.year;
        goto L6
    }

    private View.OnClickListener createYearClickListener(final int r2) {
        return new AnonymousClass1(this, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.materialCalendar.getCalendarConstraints().getYearSpan();
    }

    int getPositionForYear(int r1) {
        return r1 - this.materialCalendar.getCalendarConstraints().getStart().year;
    }

    int getYearForPosition(int r1) {
        return this.materialCalendar.getCalendarConstraints().getStart().year + r1;
    }
}

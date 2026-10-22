package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class DaysOfWeekAdapter extends BaseAdapter {
    private static final int CALENDAR_DAY_STYLE = 0;
    private static final int NARROW_FORMAT = 4;

    @NonNull
    private final Calendar calendar;
    private final int daysInWeek;
    private final int firstDayOfWeek;

    static {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        int r0 = 4;
    L6:
        CALENDAR_DAY_STYLE = r0;
        return;
    L5:
        r0 = 1;
        goto L6
    }

    public DaysOfWeekAdapter() {
        Calendar r0 = UtcDates.getUtcCalendar();
        this.calendar = r0;
        this.daysInWeek = r0.getMaximum(7);
        this.firstDayOfWeek = r0.getFirstDayOfWeek();
    }

    private int positionToDayOfWeek(int r2) {
        int r3 = r2 + this.firstDayOfWeek;
        int r1 = this.daysInWeek;
        if (r3 > r1) goto L5;
        return r3;
    L5:
        return r3 - r1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.daysInWeek;
    }

    @Override // android.widget.Adapter
    @Nullable
    public Integer getItem(int r2) {
        if (r2 < this.daysInWeek) goto L7;
        return null;
    L7:
        return Integer.valueOf(positionToDayOfWeek(r2));
    }

    @Override // android.widget.Adapter
    @Nullable
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return 0;
    }

    @Override // android.widget.Adapter
    @Nullable
    @SuppressLint({"WrongConstant"})
    public View getView(int r5, @Nullable View r6, @NonNull ViewGroup r7) {
        TextView r0 = (TextView) r6;
        if (r6 != null) goto L5;
        r0 = (TextView) LayoutInflater.from(r7.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, r7, false);
    L5:
        this.calendar.set(7, positionToDayOfWeek(r5));
        r0.setText(this.calendar.getDisplayName(7, CALENDAR_DAY_STYLE, r0.getResources().getConfiguration().locale));
        r0.setContentDescription(String.format(r7.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), new Object[]{this.calendar.getDisplayName(7, 2, Locale.getDefault())}));
        return r0;
    }
}

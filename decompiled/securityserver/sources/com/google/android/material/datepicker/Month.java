package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = null;
    final int daysInMonth;
    final int daysInWeek;

    @NonNull
    private final Calendar firstOfMonth;

    @NonNull
    private final String longName;
    final int month;
    final long timeInMillis;
    final int year;

    static {
        CREATOR = new AnonymousClass1();
    }

    private Month(@NonNull Calendar r4) {
        r4.set(5, 1);
        Calendar r5 = UtcDates.getDayCopy(r4);
        this.firstOfMonth = r5;
        this.month = r5.get(2);
        this.year = r5.get(1);
        this.daysInWeek = r5.getMaximum(7);
        this.daysInMonth = r5.getActualMaximum(5);
        this.longName = UtcDates.getYearMonthFormat().format(r5.getTime());
        this.timeInMillis = r5.getTimeInMillis();
    }

    @NonNull
    public static Month create(long r1) {
        Calendar r0 = UtcDates.getUtcCalendar();
        r0.setTimeInMillis(r1);
        return new Month(r0);
    }

    @NonNull
    public static Month current() {
        return new Month(UtcDates.getTodayCalendar());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(@NonNull Month r1) {
        return compareTo2(r1);
    }

    public int daysFromStartOfWeekToFirstOfMonth() {
        int r0 = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
        if (r0 < 0) goto L5;
        return r0;
    L5:
        return r0 + this.daysInWeek;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Month) == true) goto L8;
        return false;
    L8:
        Month r6 = (Month) r5;
        if (this.month != r6.month) goto L14;
        if (this.year != r6.year) goto L14;
        return true;
    L14:
        return false;
    }

    public long getDay(int r2) {
        Calendar r1 = UtcDates.getDayCopy(this.firstOfMonth);
        r1.set(5, r2);
        return r1.getTimeInMillis();
    }

    @NonNull
    public String getLongName() {
        return this.longName;
    }

    public long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    @NonNull
    public Month monthsLater(int r2) {
        Calendar r1 = UtcDates.getDayCopy(this.firstOfMonth);
        r1.add(2, r2);
        return new Month(r1);
    }

    public int monthsUntil(@NonNull Month r3) {
        if ((this.firstOfMonth instanceof GregorianCalendar) == false) goto L7;
        int r0 = (r3.year - this.year) * 12;
        return (r3.month - this.month) + r0;
    L7:
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r1, int r2) {
        r1.writeInt(this.year);
        r1.writeInt(this.month);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NonNull Month r1) {
        return this.firstOfMonth.compareTo(r1.firstOfMonth);
    }

    @NonNull
    public static Month create(int r2, int r3) {
        Calendar r0 = UtcDates.getUtcCalendar();
        r0.set(1, r2);
        r0.set(2, r3);
        return new Month(r0);
    }
}

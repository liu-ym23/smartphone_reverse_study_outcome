package com.obric.oui.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import org.apache.commons.math3.geometry.VectorFormat;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes4.dex */
public final class CalendarDay implements Parcelable {
    public static final Parcelable.Creator<CalendarDay> CREATOR = null;
    private final LocalDate date;

    private static int hashCode(int r0, int r1, int r2) {
        return ((r0 * 10000) + (r1 * 100)) + r2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private CalendarDay(int r1, int r2, int r3) {
        this.date = LocalDate.of(r1, r2, r3);
    }

    private CalendarDay(LocalDate r1) {
        this.date = r1;
    }

    public static CalendarDay today() {
        return from(LocalDate.now());
    }

    public static CalendarDay from(int r1, int r2, int r3) {
        return new CalendarDay(r1, r2, r3);
    }

    public static CalendarDay from(LocalDate r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new CalendarDay(r1);
    }

    public int getYear() {
        return this.date.getYear();
    }

    public int getMonth() {
        return this.date.getMonthValue();
    }

    public int getDay() {
        return this.date.getDayOfMonth();
    }

    public LocalDate getDate() {
        return this.date;
    }

    public boolean isInRange(CalendarDay r1, CalendarDay r2) {
        if (r1 != null) goto L4;
    L5:
        if (r2 != null) goto L7;
    L10:
        return true;
    L7:
        if (r2.isBefore(this) == false) goto L10;
    L9:
        return false;
    L4:
        if (r1.isAfter(this) == true) goto L9;
        goto L5
    }

    public boolean isBefore(CalendarDay r1) {
        return this.date.isBefore(r1.getDate());
    }

    public boolean isAfter(CalendarDay r1) {
        return this.date.isAfter(r1.getDate());
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof CalendarDay) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.date.equals(((CalendarDay) r2).getDate()) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return hashCode(this.date.getYear(), this.date.getMonthValue(), this.date.getDayOfMonth());
    }

    public String toString() {
        return "CalendarDay{" + this.date.getYear() + "-" + this.date.getMonthValue() + "-" + this.date.getDayOfMonth() + VectorFormat.DEFAULT_SUFFIX;
    }

    public CalendarDay(Parcel r3) {
        this(r3.readInt(), r3.readInt(), r3.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.date.getYear());
        r1.writeInt(this.date.getMonthValue());
        r1.writeInt(this.date.getDayOfMonth());
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}

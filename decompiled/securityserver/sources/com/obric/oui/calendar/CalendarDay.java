package com.obric.oui.calendar;

import a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.keva.KevaImpl;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
public final class CalendarDay implements Parcelable {
    public static final Parcelable.Creator<CalendarDay> CREATOR = null;
    public final LocalDate b;

    /* JADX INFO: renamed from: com.obric.oui.calendar.CalendarDay$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<CalendarDay> {
        @Override // android.os.Parcelable.Creator
        public final CalendarDay createFromParcel(Parcel r3) {
            return new CalendarDay(r3.readInt(), r3.readInt(), r3.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final CalendarDay[] newArray(int r1) {
            return new CalendarDay[r1];
        }
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public CalendarDay(int r1, int r2, int r3) {
        this.b = LocalDate.of(r1, r2, r3);
    }

    public static CalendarDay a(LocalDate r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new CalendarDay(r1);
    }

    public static CalendarDay h() {
        return a(LocalDate.now());
    }

    public final LocalDate b() {
        return this.b;
    }

    public final int c() {
        return this.b.getDayOfMonth();
    }

    public final int d() {
        return this.b.getMonthValue();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int e() {
        return this.b.getYear();
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof CalendarDay) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.b.equals(((CalendarDay) r2).b) == false) goto L7;
        return true;
    }

    public final boolean f(CalendarDay r1) {
        return this.b.isAfter(r1.b);
    }

    public final boolean g(CalendarDay r1) {
        return this.b.isBefore(r1.b);
    }

    public final int hashCode() {
        int r0 = this.b.getYear();
        int r1 = this.b.getMonthValue();
        int r2 = this.b.getDayOfMonth();
        int r3 = r1 * 100;
        return (r3 + (r0 * KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD)) + r2;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("CalendarDay{");
        r0.append(this.b.getYear());
        r0.append("-");
        r0.append(this.b.getMonthValue());
        r0.append("-");
        return a.n(r0, "}", this.b.getDayOfMonth());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.b.getYear());
        r1.writeInt(this.b.getMonthValue());
        r1.writeInt(this.b.getDayOfMonth());
    }

    public CalendarDay(LocalDate r1) {
        this.b = r1;
    }
}

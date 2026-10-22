package com.obric.oui.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.keva.KevaImpl;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
public final class CalendarDay implements Parcelable {
    public static final Parcelable.Creator<CalendarDay> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    private final LocalDate f10825f;

    class a implements Parcelable.Creator<CalendarDay> {
        a() {
        }

        public CalendarDay a(Parcel r1) {
            return new CalendarDay(r1);
        }

        public CalendarDay[] b(int r1) {
            return new CalendarDay[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarDay createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarDay[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    private CalendarDay(int r1, int r2, int r3) {
        this.f10825f = LocalDate.of(r1, r2, r3);
    }

    public CalendarDay(Parcel r3) {
        this(r3.readInt(), r3.readInt(), r3.readInt());
    }

    private CalendarDay(@NonNull LocalDate r1) {
        this.f10825f = r1;
    }

    @NonNull
    public static CalendarDay b(int r1, int r2, int r3) {
        return new CalendarDay(r1, r2, r3);
    }

    public static CalendarDay d(@Nullable LocalDate r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new CalendarDay(r1);
    }

    private static int i(int r0, int r1, int r2) {
        return ((r0 * KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) + (r1 * 100)) + r2;
    }

    @NonNull
    public static CalendarDay q() {
        return d(LocalDate.now());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public LocalDate e() {
        return this.f10825f;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof CalendarDay) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f10825f.equals(((CalendarDay) r2).e()) == false) goto L7;
        return true;
    }

    public int f() {
        return this.f10825f.getDayOfMonth();
    }

    public int g() {
        return this.f10825f.getMonthValue();
    }

    public int h() {
        return this.f10825f.getYear();
    }

    public int hashCode() {
        return i(this.f10825f.getYear(), this.f10825f.getMonthValue(), this.f10825f.getDayOfMonth());
    }

    public boolean j(@NonNull CalendarDay r1) {
        return this.f10825f.isAfter(r1.e());
    }

    public boolean l(@NonNull CalendarDay r1) {
        return this.f10825f.isBefore(r1.e());
    }

    public boolean p(@Nullable CalendarDay r1, @Nullable CalendarDay r2) {
        if (r1 != null) goto L4;
    L5:
        if (r2 != null) goto L7;
    L10:
        return true;
    L7:
        if (r2.l(this) == false) goto L10;
    L9:
        return false;
    L4:
        if (r1.j(this) == true) goto L9;
        goto L5
    }

    public String toString() {
        return "CalendarDay{" + this.f10825f.getYear() + "-" + this.f10825f.getMonthValue() + "-" + this.f10825f.getDayOfMonth() + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.f10825f.getYear());
        r1.writeInt(this.f10825f.getMonthValue());
        r1.writeInt(this.f10825f.getDayOfMonth());
    }
}

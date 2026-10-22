package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = null;
    private final long point;

    static {
        CREATOR = new AnonymousClass1();
    }

    public /* synthetic */ DateValidatorPointBackward(long r1, AnonymousClass1 r3) {
        this(r1);
    }

    @NonNull
    public static DateValidatorPointBackward before(long r1) {
        return new DateValidatorPointBackward(r1);
    }

    @NonNull
    public static DateValidatorPointBackward now() {
        return before(UtcDates.getTodayCalendar().getTimeInMillis());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof DateValidatorPointBackward) == true) goto L9;
        return false;
    L9:
        if (this.point != ((DateValidatorPointBackward) r6).point) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long r3) {
        if (r3 > this.point) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r3, int r4) {
        r3.writeLong(this.point);
    }

    private DateValidatorPointBackward(long r1) {
        this.point = r1;
    }
}

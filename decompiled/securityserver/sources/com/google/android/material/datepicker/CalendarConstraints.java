package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = null;

    @NonNull
    private final Month end;
    private final int monthSpan;

    @NonNull
    private final Month openAt;

    @NonNull
    private final Month start;
    private final DateValidator validator;
    private final int yearSpan;

    public static final class Builder {
        private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        static final long DEFAULT_END = 0;
        static final long DEFAULT_START = 0;
        private long end;
        private Long openAt;
        private long start;
        private DateValidator validator;

        static {
            DEFAULT_START = UtcDates.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
            DEFAULT_END = UtcDates.canonicalYearMonthDay(Month.create(2100, 11).timeInMillis);
        }

        public Builder() {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
        }

        @NonNull
        public CalendarConstraints build() {
            if (this.openAt != null) goto L11;
            long r0 = MaterialDatePicker.thisMonthInUtcMilliseconds();
            long r2 = this.start;
            if (r2 <= r0) goto L7;
        L9:
            r0 = r2;
        L10:
            this.openAt = Long.valueOf(r0);
            goto L11
        L7:
            if (r0 > this.end) goto L9;
        L11:
            Bundle r1 = new Bundle();
            r1.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            return new CalendarConstraints(Month.create(this.start), Month.create(this.end), Month.create(this.openAt.longValue()), (DateValidator) r1.getParcelable(DEEP_COPY_VALIDATOR_KEY), null);
        }

        @NonNull
        public Builder setEnd(long r1) {
            this.end = r1;
            return this;
        }

        @NonNull
        public Builder setOpenAt(long r1) {
            this.openAt = Long.valueOf(r1);
            return this;
        }

        @NonNull
        public Builder setStart(long r1) {
            this.start = r1;
            return this;
        }

        @NonNull
        public Builder setValidator(DateValidator r1) {
            this.validator = r1;
            return this;
        }

        public Builder(@NonNull CalendarConstraints r3) {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
            this.start = CalendarConstraints.access$100(r3).timeInMillis;
            this.end = CalendarConstraints.access$200(r3).timeInMillis;
            this.openAt = Long.valueOf(CalendarConstraints.access$300(r3).timeInMillis);
            this.validator = CalendarConstraints.access$400(r3);
        }
    }

    public interface DateValidator extends Parcelable {
        boolean isValid(long r1);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public /* synthetic */ CalendarConstraints(Month r1, Month r2, Month r3, DateValidator r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    public static /* synthetic */ Month access$100(CalendarConstraints r0) {
        return r0.start;
    }

    public static /* synthetic */ Month access$200(CalendarConstraints r0) {
        return r0.end;
    }

    public static /* synthetic */ Month access$300(CalendarConstraints r0) {
        return r0.openAt;
    }

    public static /* synthetic */ DateValidator access$400(CalendarConstraints r0) {
        return r0.validator;
    }

    public Month clamp(Month r2) {
        if (r2.compareTo2(this.start) >= 0) goto L7;
        return this.start;
    L7:
        if (r2.compareTo2(this.end) > 0) goto L9;
        return r2;
    L9:
        return this.end;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CalendarConstraints) == true) goto L8;
        return false;
    L8:
        CalendarConstraints r6 = (CalendarConstraints) r5;
        if (this.start.equals(r6.start) == false) goto L18;
        if (this.end.equals(r6.end) == false) goto L18;
        if (this.openAt.equals(r6.openAt) == false) goto L18;
        if (this.validator.equals(r6.validator) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    @NonNull
    public Month getEnd() {
        return this.end;
    }

    public int getMonthSpan() {
        return this.monthSpan;
    }

    @NonNull
    public Month getOpenAt() {
        return this.openAt;
    }

    @NonNull
    public Month getStart() {
        return this.start;
    }

    public int getYearSpan() {
        return this.yearSpan;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    public boolean isWithinBounds(long r5) {
        if (this.start.getDay(1) > r5) goto L7;
        Month r4 = this.end;
        if (r5 > r4.getDay(r4.daysInMonth)) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.start, 0);
        r2.writeParcelable(this.end, 0);
        r2.writeParcelable(this.openAt, 0);
        r2.writeParcelable(this.validator, 0);
    }

    private CalendarConstraints(@NonNull Month r1, @NonNull Month r2, @NonNull Month r3, DateValidator r4) {
        this.start = r1;
        this.end = r2;
        this.openAt = r3;
        this.validator = r4;
        if (r1.compareTo2(r3) > 0) goto L11;
        if (r3.compareTo2(r2) > 0) goto L9;
        this.monthSpan = r1.monthsUntil(r2) + 1;
        this.yearSpan = (r2.year - r1.year) + 1;
        return;
    L9:
        throw new IllegalArgumentException("current Month cannot be after end Month");
    L11:
        throw new IllegalArgumentException("start Month cannot be after current Month");
    }
}

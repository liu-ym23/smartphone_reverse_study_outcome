package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = null;

    @NonNull
    private final Month end;
    private final int monthSpan;

    @Nullable
    private Month openAt;

    @NonNull
    private final Month start;

    @NonNull
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

        Builder(@NonNull CalendarConstraints r3) {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
            this.start = CalendarConstraints.access$100(r3).timeInMillis;
            this.end = CalendarConstraints.access$200(r3).timeInMillis;
            this.openAt = Long.valueOf(CalendarConstraints.access$300(r3).timeInMillis);
            this.validator = CalendarConstraints.access$400(r3);
        }

        @NonNull
        public CalendarConstraints build() {
            Bundle r0 = new Bundle();
            r0.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            Month r4 = Month.create(this.start);
            Month r5 = Month.create(this.end);
            DateValidator r6 = (DateValidator) r0.getParcelable(DEEP_COPY_VALIDATOR_KEY);
            Long r9 = this.openAt;
            if (r9 != null) goto L5;
            Month r10 = null;
        L7:
            return new CalendarConstraints(r4, r5, r6, r10, null);
        L5:
            r10 = Month.create(r9.longValue());
            goto L7
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
        public Builder setValidator(@NonNull DateValidator r1) {
            this.validator = r1;
            return this;
        }
    }

    public interface DateValidator extends Parcelable {
        boolean isValid(long r1);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    private CalendarConstraints(@NonNull Month r1, @NonNull Month r2, @NonNull DateValidator r3, @Nullable Month r4) {
        this.start = r1;
        this.end = r2;
        this.openAt = r4;
        this.validator = r3;
        if (r4 != null) goto L5;
    L9:
        if (r4 != null) goto L11;
    L15:
        this.monthSpan = r1.monthsUntil(r2) + 1;
        this.yearSpan = (r2.year - r1.year) + 1;
        return;
    L11:
        if (r4.compareTo2(r2) <= 0) goto L15;
        throw new IllegalArgumentException("current Month cannot be after end Month");
    L5:
        if (r1.compareTo2(r4) <= 0) goto L9;
        throw new IllegalArgumentException("start Month cannot be after current Month");
    }

    /* synthetic */ CalendarConstraints(Month r1, Month r2, DateValidator r3, Month r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    static /* synthetic */ Month access$100(CalendarConstraints r0) {
        return r0.start;
    }

    static /* synthetic */ Month access$200(CalendarConstraints r0) {
        return r0.end;
    }

    static /* synthetic */ Month access$300(CalendarConstraints r0) {
        return r0.openAt;
    }

    static /* synthetic */ DateValidator access$400(CalendarConstraints r0) {
        return r0.validator;
    }

    Month clamp(Month r2) {
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
        if (ObjectsCompat.equals(this.openAt, r6.openAt) == false) goto L18;
        if (this.validator.equals(r6.validator) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    @NonNull
    Month getEnd() {
        return this.end;
    }

    int getMonthSpan() {
        return this.monthSpan;
    }

    @Nullable
    Month getOpenAt() {
        return this.openAt;
    }

    @NonNull
    Month getStart() {
        return this.start;
    }

    int getYearSpan() {
        return this.yearSpan;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    boolean isWithinBounds(long r5) {
        if (this.start.getDay(1) > r5) goto L7;
        Month r4 = this.end;
        if (r5 > r4.getDay(r4.daysInMonth)) goto L7;
        return true;
    L7:
        return false;
    }

    void setOpenAt(@Nullable Month r1) {
        this.openAt = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.start, 0);
        r2.writeParcelable(this.end, 0);
        r2.writeParcelable(this.openAt, 0);
        r2.writeParcelable(this.validator, 0);
    }
}

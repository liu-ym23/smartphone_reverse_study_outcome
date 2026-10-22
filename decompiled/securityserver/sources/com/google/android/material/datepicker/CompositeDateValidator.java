package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = null;

    @NonNull
    private final List<CalendarConstraints.DateValidator> validators;

    static {
        CREATOR = new AnonymousClass1();
    }

    public /* synthetic */ CompositeDateValidator(List r1, AnonymousClass1 r2) {
        this(r1);
    }

    @NonNull
    public static CalendarConstraints.DateValidator allOf(@NonNull List<CalendarConstraints.DateValidator> r1) {
        return new CompositeDateValidator(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof CompositeDateValidator) == true) goto L10;
        return false;
    L10:
        return this.validators.equals(((CompositeDateValidator) r2).validators);
    }

    public int hashCode() {
        return this.validators.hashCode();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long r2) {
        Iterator<CalendarConstraints.DateValidator> r1 = this.validators.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        CalendarConstraints.DateValidator r0 = r1.next();
        if (r0 == null) goto L4;
        if (r0.isValid(r2) == true) goto L4;
        return false;
    L12:
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r1, int r2) {
        r1.writeList(this.validators);
    }

    private CompositeDateValidator(@NonNull List<CalendarConstraints.DateValidator> r1) {
        this.validators = r1;
    }
}

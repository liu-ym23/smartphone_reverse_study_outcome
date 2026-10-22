package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialTextInputPicker<S> extends PickerFragment<S> {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";

    @Nullable
    private CalendarConstraints calendarConstraints;

    @Nullable
    private DateSelector<S> dateSelector;

    public MaterialTextInputPicker() {
    }

    @NonNull
    public static <T> MaterialTextInputPicker<T> newInstance(@NonNull DateSelector<T> r3, @NonNull CalendarConstraints r4) {
        MaterialTextInputPicker<T> r0 = new MaterialTextInputPicker();
        Bundle r1 = new Bundle();
        r1.putParcelable(DATE_SELECTOR_KEY, r3);
        r1.putParcelable(CALENDAR_CONSTRAINTS_KEY, r4);
        r0.setArguments(r1);
        return r0;
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    @NonNull
    public DateSelector<S> getDateSelector() {
        DateSelector<S> r1 = this.dateSelector;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("dateSelector should not be null. Use MaterialTextInputPicker#newInstance() to create this fragment with a DateSelector, and call this method after the fragment has been created.");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle r2) {
        super.onCreate(r2);
        if (r2 != null) goto L5;
        r2 = getArguments();
    L5:
        this.dateSelector = (DateSelector) r2.getParcelable(DATE_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) r2.getParcelable(CALENDAR_CONSTRAINTS_KEY);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater r7, @Nullable ViewGroup r8, @Nullable Bundle r9) {
        return this.dateSelector.onCreateTextInputView(r7, r8, r9, this.calendarConstraints, new AnonymousClass1(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        r3.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
    }
}

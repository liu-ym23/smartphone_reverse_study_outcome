package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialTextInputPicker<S> extends PickerFragment<S> {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    private static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";

    @Nullable
    private CalendarConstraints calendarConstraints;

    @Nullable
    private DateSelector<S> dateSelector;

    @StyleRes
    private int themeResId;

    public MaterialTextInputPicker() {
    }

    @NonNull
    static <T> MaterialTextInputPicker<T> newInstance(DateSelector<T> r3, @StyleRes int r4, @NonNull CalendarConstraints r5) {
        MaterialTextInputPicker<T> r0 = new MaterialTextInputPicker();
        Bundle r1 = new Bundle();
        r1.putInt(THEME_RES_ID_KEY, r4);
        r1.putParcelable(DATE_SELECTOR_KEY, r3);
        r1.putParcelable(CALENDAR_CONSTRAINTS_KEY, r5);
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
        this.themeResId = r2.getInt(THEME_RES_ID_KEY);
        this.dateSelector = (DateSelector) r2.getParcelable(DATE_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) r2.getParcelable(CALENDAR_CONSTRAINTS_KEY);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12) {
        LayoutInflater r4 = r10.cloneInContext(new ContextThemeWrapper(getContext(), this.themeResId));
        return this.dateSelector.onCreateTextInputView(r4, r11, r12, this.calendarConstraints, new AnonymousClass1(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putInt(THEME_RES_ID_KEY, this.themeResId);
        r3.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        r3.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
    }
}

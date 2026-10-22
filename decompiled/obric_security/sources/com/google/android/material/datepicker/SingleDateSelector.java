package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = null;
    private Long selectedItem;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ Long getSelection() {
        return getSelection();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ void setSelection(Long r1) {
        setSelection2(r1);
    }

    public SingleDateSelector() {
    }

    static /* synthetic */ void access$000(SingleDateSelector r0) {
        r0.clearSelection();
    }

    static /* synthetic */ Long access$102(SingleDateSelector r0, Long r1) {
        r0.selectedItem = r1;
        return r1;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long r1) {
        this.selectedItem = Long.valueOf(r1);
    }

    private void clearSelection() {
        this.selectedItem = null;
    }

    /* JADX INFO: renamed from: setSelection, reason: avoid collision after fix types in other method */
    public void setSelection2(Long r3) {
        if (r3 != null) goto L4;
        Long r4 = null;
    L5:
        this.selectedItem = r4;
        return;
    L4:
        r4 = Long.valueOf(UtcDates.canonicalYearMonthDay(r3.longValue()));
        goto L5
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        if (this.selectedItem == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> getSelectedDays() {
        ArrayList r0 = new ArrayList();
        Long r1 = this.selectedItem;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        return r0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    public Long getSelection() {
        return this.selectedItem;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(LayoutInflater r8, ViewGroup r9, Bundle r10, final CalendarConstraints r11, final OnSelectionChangedListener<Long> r12) {
        View r13 = r8.inflate(R.layout.mtrl_picker_text_input_date, r9, false);
        final TextInputLayout r4 = (TextInputLayout) r13.findViewById(R.id.mtrl_picker_text_input_date);
        EditText r14 = r4.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters() == false) goto L5;
        r14.setInputType(17);
    L5:
        final SimpleDateFormat r3 = UtcDates.getTextInputFormat();
        final String r2 = UtcDates.getTextInputHint(r13.getResources(), r3);
        r4.setPlaceholderText(r2);
        Long r15 = this.selectedItem;
        if (r15 == null) goto L8;
        r14.setText(r3.format(r15));
    L8:
        r14.addTextChangedListener(new AnonymousClass1(this, r2, r3, r4, r11, r12));
        ViewUtils.requestFocusAndShowKeyboard(r14);
        return r13;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context r2) {
        return MaterialAttributes.resolveOrThrow(r2, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionDisplayString(Context r4) {
        Resources r5 = r4.getResources();
        Long r3 = this.selectedItem;
        if (r3 == null) goto L5;
        String r6 = DateStrings.getYearMonthDay(r3.longValue());
        return r5.getString(R.string.mtrl_picker_date_header_selected, new Object[]{r6});
    L5:
        return r5.getString(R.string.mtrl_picker_date_header_unselected);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_date_header_title;
    }

    static {
        CREATOR = new AnonymousClass2();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeValue(this.selectedItem);
    }
}

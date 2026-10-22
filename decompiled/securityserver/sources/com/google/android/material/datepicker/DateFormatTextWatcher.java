package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
abstract class DateFormatTextWatcher implements TextWatcher {
    private final CalendarConstraints constraints;
    private final DateFormat dateFormat;
    private final String formatHint;
    private final String outOfRange;

    @NonNull
    private final TextInputLayout textInputLayout;

    public DateFormatTextWatcher(String r1, DateFormat r2, @NonNull TextInputLayout r3, CalendarConstraints r4) {
        this.formatHint = r1;
        this.dateFormat = r2;
        this.textInputLayout = r3;
        this.constraints = r4;
        this.outOfRange = r3.getContext().getString(R.string.mtrl_picker_out_of_range);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public void onInvalidDate() {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence r4, int r5, int r6, int r7) {
        if (TextUtils.isEmpty(r4) == false) goto L16;
        this.textInputLayout.setError(null);
        onValidDate(null);
        return;
    L16:
        Date r8 = this.dateFormat.parse(r4.toString());     // Catch: ParseException -> L13
        this.textInputLayout.setError(null);     // Catch: ParseException -> L13
        long r9 = r8.getTime();     // Catch: ParseException -> L13
        if (this.constraints.getDateValidator().isValid(r9) == true) goto L9;
    L11:
        this.textInputLayout.setError(String.format(this.outOfRange, new Object[]{DateStrings.getDateString(r9)}));     // Catch: ParseException -> L13
        onInvalidDate();     // Catch: ParseException -> L13
    L15:
        return;
    L9:
        if (this.constraints.isWithinBounds(r9) == false) goto L11;
        onValidDate(Long.valueOf(r8.getTime()));     // Catch: ParseException -> L13
    L13:
        String r10 = this.textInputLayout.getContext().getString(R.string.mtrl_picker_invalid_format);
        String r11 = String.format(this.textInputLayout.getContext().getString(R.string.mtrl_picker_invalid_format_use), new Object[]{this.formatHint});
        String r12 = String.format(this.textInputLayout.getContext().getString(R.string.mtrl_picker_invalid_format_example), new Object[]{this.dateFormat.format(new Date(UtcDates.getTodayCalendar().getTimeInMillis()))});
        this.textInputLayout.setError(r10 + "\n" + r11 + "\n" + r12);
        onInvalidDate();
    }

    public abstract void onValidDate(@Nullable Long r1);
}

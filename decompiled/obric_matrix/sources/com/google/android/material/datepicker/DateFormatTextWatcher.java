package com.google.android.material.datepicker;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
abstract class DateFormatTextWatcher extends TextWatcherAdapter {
    private static final int VALIDATION_DELAY = 1000;
    private final CalendarConstraints constraints;
    private final DateFormat dateFormat;
    private final String outOfRange;
    private final Runnable setErrorCallback;
    private Runnable setRangeErrorCallback;

    @NonNull
    private final TextInputLayout textInputLayout;

    DateFormatTextWatcher(final String r1, DateFormat r2, @NonNull TextInputLayout r3, CalendarConstraints r4) {
        this.dateFormat = r2;
        this.textInputLayout = r3;
        this.constraints = r4;
        this.outOfRange = r3.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.setErrorCallback = new AnonymousClass1(this, r1);
    }

    static /* synthetic */ TextInputLayout access$000(DateFormatTextWatcher r0) {
        return r0.textInputLayout;
    }

    static /* synthetic */ DateFormat access$100(DateFormatTextWatcher r0) {
        return r0.dateFormat;
    }

    static /* synthetic */ String access$200(DateFormatTextWatcher r0) {
        return r0.outOfRange;
    }

    private Runnable createRangeErrorCallback(final long r2) {
        return new AnonymousClass2(this, r2);
    }

    void onInvalidDate() {
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence r1, int r2, int r3, int r4) {
        this.textInputLayout.removeCallbacks(this.setErrorCallback);
        this.textInputLayout.removeCallbacks(this.setRangeErrorCallback);
        this.textInputLayout.setError(null);
        onValidDate(null);
        if (TextUtils.isEmpty(r1) == false) goto L15;
        return;
    L15:
        Date r5 = this.dateFormat.parse(r1.toString());     // Catch: ParseException -> L13
        this.textInputLayout.setError(null);     // Catch: ParseException -> L13
        long r6 = r5.getTime();     // Catch: ParseException -> L13
        if (this.constraints.getDateValidator().isValid(r6) == true) goto L8;
    L11:
        Runnable r7 = createRangeErrorCallback(r6);     // Catch: ParseException -> L13
        this.setRangeErrorCallback = r7;     // Catch: ParseException -> L13
        runValidation(this.textInputLayout, r7);     // Catch: ParseException -> L13
        return;
    L8:
        if (this.constraints.isWithinBounds(r6) == false) goto L11;
        onValidDate(Long.valueOf(r5.getTime()));     // Catch: ParseException -> L13
        return;
    L13:
        runValidation(this.textInputLayout, this.setErrorCallback);
    }

    abstract void onValidDate(@Nullable Long r1);

    public void runValidation(View r3, Runnable r4) {
        r3.postDelayed(r4, 1000);
    }
}

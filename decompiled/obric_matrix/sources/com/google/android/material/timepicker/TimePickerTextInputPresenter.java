package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.color.MaterialColors;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class TimePickerTextInputPresenter implements TimePickerView.OnSelectionChange, TimePickerPresenter {
    private final TimePickerTextInputKeyController controller;
    private final EditText hourEditText;
    private final ChipTextInputComboView hourTextInput;
    private final TextWatcher hourTextWatcher;
    private final EditText minuteEditText;
    private final ChipTextInputComboView minuteTextInput;
    private final TextWatcher minuteTextWatcher;
    private final TimeModel time;
    private final LinearLayout timePickerView;
    private MaterialButtonToggleGroup toggle;

    public TimePickerTextInputPresenter(LinearLayout r7, TimeModel r8) {
        this.minuteTextWatcher = new AnonymousClass1(this);
        this.hourTextWatcher = new AnonymousClass2(this);
        this.timePickerView = r7;
        this.time = r8;
        Resources r0 = r7.getResources();
        ChipTextInputComboView r1 = (ChipTextInputComboView) r7.findViewById(R.id.material_minute_text_input);
        this.minuteTextInput = r1;
        ChipTextInputComboView r2 = (ChipTextInputComboView) r7.findViewById(R.id.material_hour_text_input);
        this.hourTextInput = r2;
        int r3 = R.id.material_label;
        TextView r4 = (TextView) r1.findViewById(r3);
        TextView r5 = (TextView) r2.findViewById(r3);
        r4.setText(r0.getString(R.string.material_timepicker_minute));
        r5.setText(r0.getString(R.string.material_timepicker_hour));
        int r6 = R.id.selection_type;
        r1.setTag(r6, 12);
        r2.setTag(r6, 10);
        if (r8.format != 0) goto L5;
        setupPeriodToggle();
    L5:
        View.OnClickListener r9 = new AnonymousClass3(this);
        r2.setOnClickListener(r9);
        r1.setOnClickListener(r9);
        r2.addInputFilter(r8.getHourInputValidator());
        r1.addInputFilter(r8.getMinuteInputValidator());
        EditText r10 = r2.getTextInput().getEditText();
        this.hourEditText = r10;
        EditText r11 = r1.getTextInput().getEditText();
        this.minuteEditText = r11;
        if (Build.VERSION.SDK_INT >= 21) goto L8;
        int r12 = MaterialColors.getColor(r7, R.attr.colorPrimary);
        setCursorDrawableColor(r10, r12);
        setCursorDrawableColor(r11, r12);
    L8:
        this.controller = new TimePickerTextInputKeyController(r2, r1, r8);
        r2.setChipDelegate(new ClickActionDelegate(r7.getContext(), R.string.material_hour_selection));
        r1.setChipDelegate(new ClickActionDelegate(r7.getContext(), R.string.material_minute_selection));
        initialize();
    }

    static /* synthetic */ TimeModel access$000(TimePickerTextInputPresenter r0) {
        return r0.time;
    }

    private void addTextWatchers() {
        this.hourEditText.addTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.addTextChangedListener(this.minuteTextWatcher);
    }

    private void removeTextWatchers() {
        this.hourEditText.removeTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.removeTextChangedListener(this.minuteTextWatcher);
    }

    private static void setCursorDrawableColor(EditText r5, @ColorInt int r6) {
        Context r0 = r5.getContext();     // Catch: Throwable -> L4
        Field r1 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Throwable -> L4
        r1.setAccessible(true);     // Catch: Throwable -> L4
        int r2 = r1.getInt(r5);     // Catch: Throwable -> L4
        Field r3 = TextView.class.getDeclaredField("mEditor");     // Catch: Throwable -> L4
        r3.setAccessible(true);     // Catch: Throwable -> L4
        Object r7 = r3.get(r5);     // Catch: Throwable -> L4
        Field r4 = r7.getClass().getDeclaredField("mCursorDrawable");     // Catch: Throwable -> L4
        r4.setAccessible(true);     // Catch: Throwable -> L4
        Drawable r8 = AppCompatResources.getDrawable(r0, r2);     // Catch: Throwable -> L4
        r8.setColorFilter(r6, PorterDuff.Mode.SRC_IN);     // Catch: Throwable -> L4
        r4.set(r7, new Drawable[]{r8, r8});     // Catch: Throwable -> L4
        return;
    }

    private void setTime(TimeModel r6) {
        removeTextWatchers();
        Locale r0 = this.timePickerView.getResources().getConfiguration().locale;
        String r2 = String.format(r0, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r6.minute)});
        String r7 = String.format(r0, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r6.getHourForDisplay())});
        this.minuteTextInput.setText(r2);
        this.hourTextInput.setText(r7);
        addTextWatchers();
        updateSelection();
    }

    private void setupPeriodToggle() {
        MaterialButtonToggleGroup r0 = (MaterialButtonToggleGroup) this.timePickerView.findViewById(R.id.material_clock_period_toggle);
        this.toggle = r0;
        r0.addOnButtonCheckedListener(new AnonymousClass4(this));
        this.toggle.setVisibility(0);
        updateSelection();
    }

    private void updateSelection() {
        MaterialButtonToggleGroup r0 = this.toggle;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.time.period != 0) goto L8;
        int r1 = R.id.material_clock_period_am_button;
    L9:
        r0.check(r1);
        return;
    L8:
        r1 = R.id.material_clock_period_pm_button;
        goto L9
    }

    public void clearCheck() {
        this.minuteTextInput.setChecked(false);
        this.hourTextInput.setChecked(false);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        View r0 = this.timePickerView.getFocusedChild();
        if (r0 != null) goto L6;
    L4:
        this.timePickerView.setVisibility(8);
        return;
    L6:
        InputMethodManager r2 = (InputMethodManager) ContextCompat.getSystemService(this.timePickerView.getContext(), InputMethodManager.class);
        if (r2 == null) goto L4;
        r2.hideSoftInputFromWindow(r0.getWindowToken(), 0);
        goto L4
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void initialize() {
        addTextWatchers();
        setTime(this.time);
        this.controller.bind();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        setTime(this.time);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void onSelectionChanged(int r5) {
        this.time.selection = r5;
        ChipTextInputComboView r0 = this.minuteTextInput;
        boolean r1 = true;
        if (r5 != 12) goto L5;
        boolean r3 = true;
    L6:
        r0.setChecked(r3);
        ChipTextInputComboView r2 = this.hourTextInput;
        if (r5 == 10) goto L10;
        r1 = false;
    L10:
        r2.setChecked(r1);
        updateSelection();
        return;
    L5:
        r3 = false;
        goto L6
    }

    public void resetChecked() {
        ChipTextInputComboView r0 = this.minuteTextInput;
        boolean r2 = true;
        if (this.time.selection != 12) goto L5;
        boolean r1 = true;
    L6:
        r0.setChecked(r1);
        ChipTextInputComboView r3 = this.hourTextInput;
        if (this.time.selection == 10) goto L10;
        r2 = false;
    L10:
        r3.setChecked(r2);
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.timePickerView.setVisibility(0);
    }
}

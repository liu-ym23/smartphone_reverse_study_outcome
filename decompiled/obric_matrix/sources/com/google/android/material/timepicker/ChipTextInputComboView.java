package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {
    private final Chip chip;
    private final EditText editText;
    private TextView label;
    private final TextInputLayout textInputLayout;
    private TextWatcher watcher;

    /* JADX INFO: renamed from: com.google.android.material.timepicker.ChipTextInputComboView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class TextFormatter extends TextWatcherAdapter {
        private static final String DEFAULT_TEXT = "00";
        final /* synthetic */ ChipTextInputComboView this$0;

        private TextFormatter(ChipTextInputComboView r1) {
            this.this$0 = r1;
        }

        /* synthetic */ TextFormatter(ChipTextInputComboView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable r2) {
            if (TextUtils.isEmpty(r2) == false) goto L6;
            ChipTextInputComboView.access$200(this.this$0).setText(ChipTextInputComboView.access$100(this.this$0, DEFAULT_TEXT));
            return;
        L6:
            ChipTextInputComboView.access$200(this.this$0).setText(ChipTextInputComboView.access$100(this.this$0, r2));
        }
    }

    public ChipTextInputComboView(@NonNull Context r2) {
        this(r2, null);
    }

    public ChipTextInputComboView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ChipTextInputComboView(@NonNull Context r4, @Nullable AttributeSet r5, int r6) {
        super(r4, r5, r6);
        LayoutInflater r7 = LayoutInflater.from(r4);
        Chip r8 = (Chip) r7.inflate(R.layout.material_time_chip, this, false);
        this.chip = r8;
        TextInputLayout r9 = (TextInputLayout) r7.inflate(R.layout.material_time_input, this, false);
        this.textInputLayout = r9;
        EditText r0 = r9.getEditText();
        this.editText = r0;
        r0.setVisibility(4);
        TextFormatter r1 = new TextFormatter(this, null);
        this.watcher = r1;
        r0.addTextChangedListener(r1);
        updateHintLocales();
        addView(r8);
        addView(r9);
        this.label = (TextView) findViewById(R.id.material_label);
        r0.setSaveEnabled(false);
    }

    static /* synthetic */ String access$100(ChipTextInputComboView r0, CharSequence r1) {
        return r0.formatText(r1);
    }

    static /* synthetic */ Chip access$200(ChipTextInputComboView r0) {
        return r0.chip;
    }

    private String formatText(CharSequence r1) {
        return TimeModel.formatText(getResources(), r1);
    }

    private void updateHintLocales() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        LocaleList r0 = getContext().getResources().getConfiguration().getLocales();
        this.editText.setImeHintLocales(r0);
        return;
    }

    public void addInputFilter(InputFilter r3) {
        InputFilter[] r0 = this.editText.getFilters();
        InputFilter[] r1 = (InputFilter[]) Arrays.copyOf(r0, r0.length + 1);
        r1[r0.length] = r3;
        this.editText.setFilters(r1);
    }

    public TextInputLayout getTextInput() {
        return this.textInputLayout;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.chip.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        updateHintLocales();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r4) {
        this.chip.setChecked(r4);
        EditText r0 = this.editText;
        int r1 = 0;
        if (r4 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        Chip r3 = this.chip;
        if (r4 == false) goto L9;
        r1 = 8;
    L9:
        r3.setVisibility(r1);
        if (isChecked() == false) goto L15;
        ViewUtils.requestFocusAndShowKeyboard(this.editText);
        if (TextUtils.isEmpty(this.editText.getText()) == true) goto L16;
        EditText r5 = this.editText;
        r5.setSelection(r5.getText().length());
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r2 = 4;
        goto L6
    }

    public void setChipDelegate(AccessibilityDelegateCompat r1) {
        ViewCompat.setAccessibilityDelegate(this.chip, r1);
    }

    public void setCursorVisible(boolean r1) {
        this.editText.setCursorVisible(r1);
    }

    public void setHelperText(CharSequence r1) {
        this.label.setText(r1);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener r1) {
        this.chip.setOnClickListener(r1);
    }

    @Override // android.view.View
    public void setTag(int r1, Object r2) {
        this.chip.setTag(r1, r2);
    }

    public void setText(CharSequence r2) {
        this.chip.setText(formatText(r2));
        if (TextUtils.isEmpty(this.editText.getText()) == true) goto L6;
        this.editText.removeTextChangedListener(this.watcher);
        this.editText.setText(null);
        this.editText.addTextChangedListener(this.watcher);
        return;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.chip.toggle();
    }
}

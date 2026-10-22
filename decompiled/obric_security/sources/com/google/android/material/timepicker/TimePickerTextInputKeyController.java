package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes2.dex */
class TimePickerTextInputKeyController implements TextView.OnEditorActionListener, View.OnKeyListener {
    private final ChipTextInputComboView hourLayoutComboView;
    private boolean keyListenerRunning;
    private final ChipTextInputComboView minuteLayoutComboView;
    private final TimeModel time;

    TimePickerTextInputKeyController(ChipTextInputComboView r2, ChipTextInputComboView r3, TimeModel r4) {
        this.keyListenerRunning = false;
        this.hourLayoutComboView = r2;
        this.minuteLayoutComboView = r3;
        this.time = r4;
    }

    public void bind() {
        TextInputLayout r0 = this.hourLayoutComboView.getTextInput();
        TextInputLayout r1 = this.minuteLayoutComboView.getTextInput();
        EditText r2 = r0.getEditText();
        EditText r3 = r1.getEditText();
        r2.setImeOptions(268435461);
        r3.setImeOptions(268435462);
        r2.setOnEditorActionListener(this);
        r2.setOnKeyListener(this);
        r3.setOnKeyListener(this);
    }

    private void moveSelection(int r5) {
        ChipTextInputComboView r0 = this.minuteLayoutComboView;
        boolean r2 = true;
        if (r5 != 12) goto L5;
        boolean r1 = true;
    L6:
        r0.setChecked(r1);
        ChipTextInputComboView r3 = this.hourLayoutComboView;
        if (r5 == 10) goto L10;
        r2 = false;
    L10:
        r3.setChecked(r2);
        this.time.selection = r5;
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 5) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        moveSelection(12);
    L8:
        return r4;
    L5:
        r4 = false;
        goto L6
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r4, int r5, KeyEvent r6) {
        if (this.keyListenerRunning == false) goto L5;
        return false;
    L5:
        this.keyListenerRunning = true;
        EditText r7 = (EditText) r4;
        if (this.time.selection != 12) goto L8;
        boolean r8 = onMinuteKeyPress(r5, r6, r7);
    L9:
        this.keyListenerRunning = false;
        return r8;
    L8:
        r8 = onHourKeyPress(r5, r6, r7);
        goto L9
    }

    private boolean onMinuteKeyPress(int r4, KeyEvent r5, EditText r6) {
        if (r4 == 67) goto L5;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L13;
        moveSelection(10);
        return true;
    L13:
        return false;
    L5:
        if (r5.getAction() != 0) goto L9;
        if (TextUtils.isEmpty(r6.getText()) == false) goto L9;
        r7 = true;
        goto L10
    }

    private boolean onHourKeyPress(int r5, KeyEvent r6, EditText r7) {
        Editable r0 = r7.getText();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r5 >= 7) goto L8;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == false) goto L20;
        moveSelection(12);
        return true;
    L20:
        return false;
    L8:
        if (r5 > 16) goto L16;
        if (r6.getAction() != 1) goto L16;
        if (r7.getSelectionStart() != 2) goto L16;
        if (r0.length() != 2) goto L16;
        r8 = true;
        goto L17
    }
}

package com.android.settings;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes2.dex */
class EditPinPreference extends CustomEditTextPreference {
    private OnPinEnteredListener mPinListener;

    interface OnPinEnteredListener {
        void onPinEntered(EditPinPreference r1, boolean r2);
    }

    public EditPinPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public EditPinPreference(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public void setOnPinEnteredListener(OnPinEnteredListener r1) {
        this.mPinListener = r1;
    }

    @Override // com.android.settings.CustomEditTextPreference
    protected void onBindDialogView(View r1) {
        super.onBindDialogView(r1);
        EditText r0 = (EditText) r1.findViewById(android.R.id.edit);
        if (r0 == null) goto L6;
        r0.setInputType(18);
        return;
    }

    @Override // com.android.settings.CustomEditTextPreference
    public boolean isDialogOpen() {
        Dialog r0 = getDialog();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() == false) goto L7;
        return true;
    }

    @Override // com.android.settings.CustomEditTextPreference
    protected void onDialogClosed(boolean r2) {
        super.onDialogClosed(r2);
        OnPinEnteredListener r0 = this.mPinListener;
        if (r0 == null) goto L6;
        r0.onPinEntered(this, r2);
        return;
    }

    public void showPinDialog() {
        Dialog r0 = getDialog();
        if (r0 != null) goto L5;
    L6:
        onClick();
        return;
    L5:
        if (r0.isShowing() == false) goto L6;
    }
}

package com.android.settings;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes2.dex */
public class SelectableEditTextPreference extends CustomEditTextPreference {
    public static final int SELECTION_CURSOR_END = 0;
    public static final int SELECTION_CURSOR_START = 1;
    public static final int SELECTION_SELECT_ALL = 2;
    private int mSelectionMode;

    public SelectableEditTextPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public void setInitialSelectionMode(int r1) {
        this.mSelectionMode = r1;
    }

    @Override // com.android.settings.CustomEditTextPreference
    protected void onBindDialogView(View r4) {
        super.onBindDialogView(r4);
        EditText r5 = getEditText();
        if (r5.getText() == null) goto L5;
        int r0 = r5.getText().length();
    L7:
        if (TextUtils.isEmpty(r5.getText()) == true) goto L19;
        int r3 = this.mSelectionMode;
        if (r3 != 0) goto L11;
        r5.setSelection(r0);
        return;
    L11:
        if (r3 != 1) goto L13;
        r5.setSelection(0);
        return;
    L13:
        if (r3 != 2) goto L22;
        r5.setSelection(0, r0);
        return;
    L22:
        return;
    L19:
        return;
    L5:
        r0 = 0;
        goto L7
    }
}

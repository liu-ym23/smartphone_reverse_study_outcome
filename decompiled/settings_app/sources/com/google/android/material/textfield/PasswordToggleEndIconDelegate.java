package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes3.dex */
class PasswordToggleEndIconDelegate extends EndIconDelegate {
    private final TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener;
    private final TextInputLayout.OnEndIconChangedListener onEndIconChangedListener;
    private final TextWatcher textWatcher;

    static /* synthetic */ boolean access$000(PasswordToggleEndIconDelegate r0) {
        return r0.hasPasswordTransformation();
    }

    static /* synthetic */ TextWatcher access$100(PasswordToggleEndIconDelegate r0) {
        return r0.textWatcher;
    }

    PasswordToggleEndIconDelegate(TextInputLayout r1, int r2) {
        super(r1, r2);
        this.textWatcher = new AnonymousClass1(this);
        this.onEditTextAttachedListener = new AnonymousClass2(this);
        this.onEndIconChangedListener = new AnonymousClass3(this);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void initialize() {
        TextInputLayout r0 = this.textInputLayout;
        if (this.customEndIcon != 0) goto L5;
        int r1 = R.drawable.design_password_eye;
    L6:
        r0.setEndIconDrawable(r1);
        this.textInputLayout.setEndIconContentDescription(this.textInputLayout.getResources().getText(R.string.password_toggle_content_description));
        this.textInputLayout.setEndIconVisible(true);
        this.textInputLayout.setEndIconCheckable(true);
        this.textInputLayout.setEndIconOnClickListener(new AnonymousClass4(this));
        this.textInputLayout.addOnEditTextAttachedListener(this.onEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.onEndIconChangedListener);
        EditText r3 = this.textInputLayout.getEditText();
        if (isInputTypePassword(r3) == false) goto L10;
        r3.setTransformationMethod(PasswordTransformationMethod.getInstance());
        return;
    L10:
        return;
    L5:
        r1 = this.customEndIcon;
        goto L6
    }

    private boolean hasPasswordTransformation() {
        EditText r0 = this.textInputLayout.getEditText();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r0.getTransformationMethod() instanceof PasswordTransformationMethod) == false) goto L7;
        return true;
    }

    private static boolean isInputTypePassword(EditText r2) {
        if (r2 != null) goto L4;
    L12:
        return false;
    L4:
        if (r2.getInputType() != 16) goto L6;
    L11:
        return true;
    L6:
        if (r2.getInputType() == 128) goto L11;
        if (r2.getInputType() == 144) goto L11;
        if (r2.getInputType() != 224) goto L12;
        goto L11
    }
}

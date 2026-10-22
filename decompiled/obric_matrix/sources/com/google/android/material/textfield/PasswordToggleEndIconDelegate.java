package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
class PasswordToggleEndIconDelegate extends EndIconDelegate {
    private final TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener;
    private final TextInputLayout.OnEndIconChangedListener onEndIconChangedListener;
    private final TextWatcher textWatcher;

    PasswordToggleEndIconDelegate(@NonNull TextInputLayout r1, @DrawableRes int r2) {
        super(r1, r2);
        this.textWatcher = new AnonymousClass1(this);
        this.onEditTextAttachedListener = new AnonymousClass2(this);
        this.onEndIconChangedListener = new AnonymousClass3(this);
    }

    static /* synthetic */ boolean access$000(PasswordToggleEndIconDelegate r0) {
        return r0.hasPasswordTransformation();
    }

    static /* synthetic */ TextWatcher access$100(PasswordToggleEndIconDelegate r0) {
        return r0.textWatcher;
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

    @Override // com.google.android.material.textfield.EndIconDelegate
    void initialize() {
        TextInputLayout r0 = this.textInputLayout;
        int r1 = this.customEndIcon;
        if (r1 != 0) goto L5;
        r1 = R.drawable.design_password_eye;
    L5:
        r0.setEndIconDrawable(r1);
        TextInputLayout r2 = this.textInputLayout;
        r2.setEndIconContentDescription(r2.getResources().getText(R.string.password_toggle_content_description));
        this.textInputLayout.setEndIconOnClickListener(new AnonymousClass4(this));
        this.textInputLayout.addOnEditTextAttachedListener(this.onEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.onEndIconChangedListener);
        EditText r3 = this.textInputLayout.getEditText();
        if (isInputTypePassword(r3) == false) goto L9;
        r3.setTransformationMethod(PasswordTransformationMethod.getInstance());
        return;
    }
}

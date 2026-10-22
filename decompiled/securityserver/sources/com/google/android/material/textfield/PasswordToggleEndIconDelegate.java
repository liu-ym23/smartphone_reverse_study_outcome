package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
class PasswordToggleEndIconDelegate extends EndIconDelegate {
    private final TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener;
    private final TextInputLayout.OnEndIconChangedListener onEndIconChangedListener;
    private final TextWatcher textWatcher;

    public PasswordToggleEndIconDelegate(@NonNull TextInputLayout r1) {
        super(r1);
        this.textWatcher = new AnonymousClass1(this);
        this.onEditTextAttachedListener = new AnonymousClass2(this);
        this.onEndIconChangedListener = new AnonymousClass3(this);
    }

    public static /* synthetic */ boolean access$000(PasswordToggleEndIconDelegate r0) {
        return r0.hasPasswordTransformation();
    }

    public static /* synthetic */ TextWatcher access$100(PasswordToggleEndIconDelegate r0) {
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
    public void initialize() {
        this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, R.drawable.design_password_eye));
        TextInputLayout r0 = this.textInputLayout;
        r0.setEndIconContentDescription(r0.getResources().getText(R.string.password_toggle_content_description));
        this.textInputLayout.setEndIconOnClickListener(new AnonymousClass4(this));
        this.textInputLayout.addOnEditTextAttachedListener(this.onEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.onEndIconChangedListener);
        EditText r3 = this.textInputLayout.getEditText();
        if (isInputTypePassword(r3) == false) goto L6;
        r3.setTransformationMethod(PasswordTransformationMethod.getInstance());
        return;
    }
}

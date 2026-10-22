package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class CredentialsDialogBinding implements ViewBinding {
    public final TextView error;
    public final TextView hint;
    public final EditText oldPassword;
    public final TextView oldPasswordPrompt;
    private final OScrollView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private CredentialsDialogBinding(OScrollView r1, TextView r2, TextView r3, EditText r4, TextView r5) {
        this.rootView = r1;
        this.error = r2;
        this.hint = r3;
        this.oldPassword = r4;
        this.oldPasswordPrompt = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static CredentialsDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static CredentialsDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.credentials_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static CredentialsDialogBinding bind(View r8) {
        int r0 = R.id.error;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r8, R.id.error);
        if (r4 == null) goto L13;
        r0 = R.id.hint;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.hint);
        if (r5 == null) goto L13;
        r0 = R.id.old_password;
        EditText r6 = (EditText) ViewBindings.findChildViewById(r8, R.id.old_password);
        if (r6 == null) goto L13;
        r0 = R.id.old_password_prompt;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.old_password_prompt);
        if (r7 == null) goto L13;
        return new CredentialsDialogBinding((OScrollView) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}

package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import obric.widget.PasswordEditText;

/* JADX INFO: loaded from: classes2.dex */
public final class VerifyCloudPwdDialogBinding implements ViewBinding {
    public final RelativeLayout bottomLayout;
    public final TextView exitNoticeForDialog;
    public final Button findForgetPwdForDialog;
    public final PasswordEditText inputPwdEdittextForDialog;
    private final OScrollView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private VerifyCloudPwdDialogBinding(OScrollView r1, RelativeLayout r2, TextView r3, Button r4, PasswordEditText r5) {
        this.rootView = r1;
        this.bottomLayout = r2;
        this.exitNoticeForDialog = r3;
        this.findForgetPwdForDialog = r4;
        this.inputPwdEdittextForDialog = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static VerifyCloudPwdDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static VerifyCloudPwdDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.verify_cloud_pwd_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static VerifyCloudPwdDialogBinding bind(View r8) {
        int r0 = R.id.bottom_layout;
        RelativeLayout r4 = (RelativeLayout) ViewBindings.findChildViewById(r8, R.id.bottom_layout);
        if (r4 == null) goto L13;
        r0 = R.id.exit_notice_for_dialog;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.exit_notice_for_dialog);
        if (r5 == null) goto L13;
        r0 = R.id.find_forget_pwd_for_dialog;
        Button r6 = (Button) ViewBindings.findChildViewById(r8, R.id.find_forget_pwd_for_dialog);
        if (r6 == null) goto L13;
        r0 = R.id.input_pwd_edittext_for_dialog;
        PasswordEditText r7 = (PasswordEditText) ViewBindings.findChildViewById(r8, R.id.input_pwd_edittext_for_dialog);
        if (r7 == null) goto L13;
        return new VerifyCloudPwdDialogBinding((OScrollView) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}

package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SetBackupPwBinding implements ViewBinding {
    public final Button backupPwCancelButton;
    public final Button backupPwSetButton;
    public final EditText confirmNewBackupPw;
    public final EditText currentBackupPw;
    public final EditText newBackupPw;
    public final TextView prompt1;
    public final TextView prompt2;
    public final TextView prompt3;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SetBackupPwBinding(RelativeLayout r1, Button r2, Button r3, EditText r4, EditText r5, EditText r6, TextView r7, TextView r8, TextView r9) {
        this.rootView = r1;
        this.backupPwCancelButton = r2;
        this.backupPwSetButton = r3;
        this.confirmNewBackupPw = r4;
        this.currentBackupPw = r5;
        this.newBackupPw = r6;
        this.prompt1 = r7;
        this.prompt2 = r8;
        this.prompt3 = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SetBackupPwBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SetBackupPwBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.set_backup_pw, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SetBackupPwBinding bind(View r12) {
        int r0 = R.id.backup_pw_cancel_button;
        Button r4 = (Button) ViewBindings.findChildViewById(r12, R.id.backup_pw_cancel_button);
        if (r4 == null) goto L21;
        r0 = R.id.backup_pw_set_button;
        Button r5 = (Button) ViewBindings.findChildViewById(r12, R.id.backup_pw_set_button);
        if (r5 == null) goto L21;
        r0 = R.id.confirm_new_backup_pw;
        EditText r6 = (EditText) ViewBindings.findChildViewById(r12, R.id.confirm_new_backup_pw);
        if (r6 == null) goto L21;
        r0 = R.id.current_backup_pw;
        EditText r7 = (EditText) ViewBindings.findChildViewById(r12, R.id.current_backup_pw);
        if (r7 == null) goto L21;
        r0 = R.id.new_backup_pw;
        EditText r8 = (EditText) ViewBindings.findChildViewById(r12, R.id.new_backup_pw);
        if (r8 == null) goto L21;
        r0 = R.id.prompt1;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r12, R.id.prompt1);
        if (r9 == null) goto L21;
        r0 = R.id.prompt2;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r12, R.id.prompt2);
        if (r10 == null) goto L21;
        r0 = R.id.prompt3;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r12, R.id.prompt3);
        if (r11 == null) goto L21;
        return new SetBackupPwBinding((RelativeLayout) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}

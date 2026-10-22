package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.CheckableLinearLayout;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class RestrictedDialogSinglechoiceBinding implements ViewBinding {
    public final ImageView restrictedLockIcon;
    private final CheckableLinearLayout rootView;
    public final CheckedTextView text1;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RestrictedDialogSinglechoiceBinding(CheckableLinearLayout r1, ImageView r2, CheckedTextView r3) {
        this.rootView = r1;
        this.restrictedLockIcon = r2;
        this.text1 = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CheckableLinearLayout getRoot() {
        return this.rootView;
    }

    public static RestrictedDialogSinglechoiceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RestrictedDialogSinglechoiceBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.restricted_dialog_singlechoice, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RestrictedDialogSinglechoiceBinding bind(View r3) {
        int r0 = R.id.restricted_lock_icon;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.restricted_lock_icon);
        if (r1 == null) goto L9;
        r0 = R.id.text1;
        CheckedTextView r2 = (CheckedTextView) ViewBindings.findChildViewById(r3, R.id.text1);
        if (r2 == null) goto L9;
        return new RestrictedDialogSinglechoiceBinding((CheckableLinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}

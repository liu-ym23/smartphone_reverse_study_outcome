package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.view.SecurityEditorText;

/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmLockPasswordBinding implements ViewBinding {
    public final TextView headerText;
    public final SecurityEditorText passwordEntry;
    public final FrameLayout pinKeyboardLayout;
    private final RelativeLayout rootView;
    public final OTextView title;
    public final OFloatingTitleBar viewTitle;
    public final ImageView xtsEnterpriseIcon;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ConfirmLockPasswordBinding(RelativeLayout r1, TextView r2, SecurityEditorText r3, FrameLayout r4, OTextView r5, OFloatingTitleBar r6, ImageView r7) {
        this.rootView = r1;
        this.headerText = r2;
        this.passwordEntry = r3;
        this.pinKeyboardLayout = r4;
        this.title = r5;
        this.viewTitle = r6;
        this.xtsEnterpriseIcon = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ConfirmLockPasswordBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ConfirmLockPasswordBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.confirm_lock_password, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ConfirmLockPasswordBinding bind(View r10) {
        int r0 = R.id.headerText;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, R.id.headerText);
        if (r4 == null) goto L17;
        r0 = R.id.passwordEntry;
        SecurityEditorText r5 = (SecurityEditorText) ViewBindings.findChildViewById(r10, R.id.passwordEntry);
        if (r5 == null) goto L17;
        r0 = R.id.pin_keyboard_layout;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r10, R.id.pin_keyboard_layout);
        if (r6 == null) goto L17;
        r0 = R.id.title;
        OTextView r7 = (OTextView) ViewBindings.findChildViewById(r10, R.id.title);
        if (r7 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r8 == null) goto L17;
        r0 = R.id.xts_enterprise_icon;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r10, R.id.xts_enterprise_icon);
        if (r9 == null) goto L17;
        return new ConfirmLockPasswordBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}

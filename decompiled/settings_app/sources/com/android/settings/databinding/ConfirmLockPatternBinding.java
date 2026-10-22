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
import com.android.internal.widget.LinearLayoutWithDefaultTouchRecepient;
import com.android.settings.R;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmLockPatternBinding implements ViewBinding {
    public final TextView footerText;
    public final OTextView headerText;
    public final FrameLayout lockPatternFL;
    private final RelativeLayout rootView;
    public final OTextView title;
    public final LinearLayoutWithDefaultTouchRecepient topLayout;
    public final OFloatingTitleBar viewTitle;
    public final ImageView xtsEnterpriseIcon;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ConfirmLockPatternBinding(RelativeLayout r1, TextView r2, OTextView r3, FrameLayout r4, OTextView r5, LinearLayoutWithDefaultTouchRecepient r6, OFloatingTitleBar r7, ImageView r8) {
        this.rootView = r1;
        this.footerText = r2;
        this.headerText = r3;
        this.lockPatternFL = r4;
        this.title = r5;
        this.topLayout = r6;
        this.viewTitle = r7;
        this.xtsEnterpriseIcon = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ConfirmLockPatternBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ConfirmLockPatternBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.confirm_lock_pattern, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ConfirmLockPatternBinding bind(View r11) {
        int r0 = R.id.footerText;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r11, R.id.footerText);
        if (r4 == null) goto L19;
        r0 = R.id.headerText;
        OTextView r5 = (OTextView) ViewBindings.findChildViewById(r11, R.id.headerText);
        if (r5 == null) goto L19;
        r0 = R.id.lockPatternFL;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r11, R.id.lockPatternFL);
        if (r6 == null) goto L19;
        r0 = R.id.title;
        OTextView r7 = (OTextView) ViewBindings.findChildViewById(r11, R.id.title);
        if (r7 == null) goto L19;
        r0 = R.id.topLayout;
        LinearLayoutWithDefaultTouchRecepient r8 = ViewBindings.findChildViewById(r11, R.id.topLayout);
        if (r8 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r9 == null) goto L19;
        r0 = R.id.xts_enterprise_icon;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r11, R.id.xts_enterprise_icon);
        if (r10 == null) goto L19;
        return new ConfirmLockPatternBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}

package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.internal.widget.LinearLayoutWithDefaultTouchRecepient;
import com.android.settings.R;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ChooseLockPatternBinding implements ViewBinding {
    public final TextView footerText;
    public final OTextView headerText;
    public final FrameLayout lockPatternFL;
    private final RelativeLayout rootView;
    public final OTextView title;
    public final LinearLayoutWithDefaultTouchRecepient topLayout;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ChooseLockPatternBinding(RelativeLayout r1, TextView r2, OTextView r3, FrameLayout r4, OTextView r5, LinearLayoutWithDefaultTouchRecepient r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.footerText = r2;
        this.headerText = r3;
        this.lockPatternFL = r4;
        this.title = r5;
        this.topLayout = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ChooseLockPatternBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ChooseLockPatternBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.choose_lock_pattern, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ChooseLockPatternBinding bind(View r10) {
        int r0 = R.id.footerText;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, R.id.footerText);
        if (r4 == null) goto L17;
        r0 = R.id.headerText;
        OTextView r5 = (OTextView) ViewBindings.findChildViewById(r10, R.id.headerText);
        if (r5 == null) goto L17;
        r0 = R.id.lockPatternFL;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r10, R.id.lockPatternFL);
        if (r6 == null) goto L17;
        r0 = R.id.title;
        OTextView r7 = (OTextView) ViewBindings.findChildViewById(r10, R.id.title);
        if (r7 == null) goto L17;
        r0 = R.id.topLayout;
        LinearLayoutWithDefaultTouchRecepient r8 = ViewBindings.findChildViewById(r10, R.id.topLayout);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new ChooseLockPatternBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}

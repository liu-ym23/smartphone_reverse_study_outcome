package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.widget.SizeChangedRelativeLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class ChooseLockPasswordBinding implements ViewBinding {
    public final OTextView headerText;
    public final OInputLayout passwordEntry;
    public final FrameLayout pinKeyboardLayout;
    private final SizeChangedRelativeLayout rootView;
    public final SizeChangedRelativeLayout sizeChangedLayout;
    public final OTextView title;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ChooseLockPasswordBinding(SizeChangedRelativeLayout r1, OTextView r2, OInputLayout r3, FrameLayout r4, SizeChangedRelativeLayout r5, OTextView r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.headerText = r2;
        this.passwordEntry = r3;
        this.pinKeyboardLayout = r4;
        this.sizeChangedLayout = r5;
        this.title = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SizeChangedRelativeLayout getRoot() {
        return this.rootView;
    }

    public static ChooseLockPasswordBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ChooseLockPasswordBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.choose_lock_password, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ChooseLockPasswordBinding bind(View r10) {
        int r0 = R.id.headerText;
        OTextView r4 = (OTextView) ViewBindings.findChildViewById(r10, R.id.headerText);
        if (r4 == null) goto L15;
        r0 = R.id.passwordEntry;
        OInputLayout r5 = (OInputLayout) ViewBindings.findChildViewById(r10, R.id.passwordEntry);
        if (r5 == null) goto L15;
        r0 = R.id.pin_keyboard_layout;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r10, R.id.pin_keyboard_layout);
        if (r6 == null) goto L15;
        SizeChangedRelativeLayout r7 = (SizeChangedRelativeLayout) r10;
        r0 = R.id.title;
        OTextView r8 = (OTextView) ViewBindings.findChildViewById(r10, R.id.title);
        if (r8 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L15;
        return new ChooseLockPasswordBinding(r7, r4, r5, r6, r7, r8, r9);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}

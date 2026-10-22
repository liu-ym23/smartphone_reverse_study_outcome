package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class EnableAccessibilityServiceDialogContentBinding implements ViewBinding {
    public final LinearLayout capabilities;
    public final OTextView capabilitiesHeader;
    public final OTextView capabilitiesWarning;
    public final OTextView encryptionWarning;
    private final OScrollView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private EnableAccessibilityServiceDialogContentBinding(OScrollView r1, LinearLayout r2, OTextView r3, OTextView r4, OTextView r5) {
        this.rootView = r1;
        this.capabilities = r2;
        this.capabilitiesHeader = r3;
        this.capabilitiesWarning = r4;
        this.encryptionWarning = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static EnableAccessibilityServiceDialogContentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static EnableAccessibilityServiceDialogContentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.enable_accessibility_service_dialog_content, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static EnableAccessibilityServiceDialogContentBinding bind(View r8) {
        int r0 = R.id.capabilities;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.capabilities);
        if (r4 == null) goto L13;
        r0 = R.id.capabilities_header;
        OTextView r5 = (OTextView) ViewBindings.findChildViewById(r8, R.id.capabilities_header);
        if (r5 == null) goto L13;
        r0 = R.id.capabilities_warning;
        OTextView r6 = (OTextView) ViewBindings.findChildViewById(r8, R.id.capabilities_warning);
        if (r6 == null) goto L13;
        r0 = R.id.encryption_warning;
        OTextView r7 = (OTextView) ViewBindings.findChildViewById(r8, R.id.encryption_warning);
        if (r7 == null) goto L13;
        return new EnableAccessibilityServiceDialogContentBinding((OScrollView) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}

package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class EnableAccessibilityServiceDialogContent2Binding implements ViewBinding {
    public final LinearLayout capabilities;
    public final OSectionTitleBar capabilitiesHeader;
    private final OScrollView rootView;
    public final OScrollView scrollView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private EnableAccessibilityServiceDialogContent2Binding(OScrollView r1, LinearLayout r2, OSectionTitleBar r3, OScrollView r4) {
        this.rootView = r1;
        this.capabilities = r2;
        this.capabilitiesHeader = r3;
        this.scrollView = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static EnableAccessibilityServiceDialogContent2Binding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static EnableAccessibilityServiceDialogContent2Binding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.enable_accessibility_service_dialog_content_2, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static EnableAccessibilityServiceDialogContent2Binding bind(View r3) {
        int r0 = R.id.capabilities;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r3, R.id.capabilities);
        if (r1 == null) goto L9;
        r0 = R.id.capabilities_header;
        OSectionTitleBar r2 = (OSectionTitleBar) ViewBindings.findChildViewById(r3, R.id.capabilities_header);
        if (r2 == null) goto L9;
        OScrollView r4 = (OScrollView) r3;
        return new EnableAccessibilityServiceDialogContent2Binding(r4, r1, r2, r4);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}

package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class EnableAccessibilityServiceDialogRoundIconBinding implements ViewBinding {
    public final ImageView icon;
    public final LinearLayout iconContainer;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private EnableAccessibilityServiceDialogRoundIconBinding(LinearLayout r1, ImageView r2, LinearLayout r3) {
        this.rootView = r1;
        this.icon = r2;
        this.iconContainer = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EnableAccessibilityServiceDialogRoundIconBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static EnableAccessibilityServiceDialogRoundIconBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.enable_accessibility_service_dialog_round_icon, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static EnableAccessibilityServiceDialogRoundIconBinding bind(View r2) {
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r2, R.id.icon);
        if (r1 == null) goto L7;
        LinearLayout r3 = (LinearLayout) r2;
        return new EnableAccessibilityServiceDialogRoundIconBinding(r3, r1, r3);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.icon)));
    }
}

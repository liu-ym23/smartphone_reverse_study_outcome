package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SetupWizardLocalePickerListTitleBinding implements ViewBinding {
    public final LinearLayout localeListTitle;
    private final LinearLayout rootView;
    public final TextView setupWizardLocaleListTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SetupWizardLocalePickerListTitleBinding(LinearLayout r1, LinearLayout r2, TextView r3) {
        this.rootView = r1;
        this.localeListTitle = r2;
        this.setupWizardLocaleListTitle = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SetupWizardLocalePickerListTitleBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SetupWizardLocalePickerListTitleBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.setup_wizard_locale_picker_list_title, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SetupWizardLocalePickerListTitleBinding bind(View r3) {
        LinearLayout r0 = (LinearLayout) r3;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.setup_wizard_locale_list_title);
        if (r2 == null) goto L7;
        return new SetupWizardLocalePickerListTitleBinding(r0, r0, r2);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(R.id.setup_wizard_locale_list_title)));
    }
}

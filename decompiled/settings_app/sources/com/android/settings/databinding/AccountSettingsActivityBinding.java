package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AccountSettingsActivityBinding implements ViewBinding {
    public final OSectionSupportiveText disclosureWithName;
    public final TextView learnMoreContentDescription;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AccountSettingsActivityBinding(RelativeLayout r1, OSectionSupportiveText r2, TextView r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.disclosureWithName = r2;
        this.learnMoreContentDescription = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AccountSettingsActivityBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AccountSettingsActivityBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.account_settings_activity, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AccountSettingsActivityBinding bind(View r4) {
        int r0 = R.id.disclosure_with_name;
        OSectionSupportiveText r1 = (OSectionSupportiveText) ViewBindings.findChildViewById(r4, R.id.disclosure_with_name);
        if (r1 == null) goto L11;
        r0 = R.id.learn_more_content_description;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.learn_more_content_description);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new AccountSettingsActivityBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}

package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingsHomepageAppBarRegularPhoneLayoutBinding implements ViewBinding {
    public final OTextView homepageTitle;
    public final OTextView homepageTitleLast;
    public final OTextView homepageTitleMid;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingsHomepageAppBarRegularPhoneLayoutBinding(LinearLayout r1, OTextView r2, OTextView r3, OTextView r4) {
        this.rootView = r1;
        this.homepageTitle = r2;
        this.homepageTitleLast = r3;
        this.homepageTitleMid = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SettingsHomepageAppBarRegularPhoneLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingsHomepageAppBarRegularPhoneLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.settings_homepage_app_bar_regular_phone_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingsHomepageAppBarRegularPhoneLayoutBinding bind(View r4) {
        int r0 = R.id.homepage_title;
        OTextView r1 = (OTextView) ViewBindings.findChildViewById(r4, R.id.homepage_title);
        if (r1 == null) goto L11;
        r0 = R.id.homepage_title_last;
        OTextView r2 = (OTextView) ViewBindings.findChildViewById(r4, R.id.homepage_title_last);
        if (r2 == null) goto L11;
        r0 = R.id.homepage_title_mid;
        OTextView r3 = (OTextView) ViewBindings.findChildViewById(r4, R.id.homepage_title_mid);
        if (r3 == null) goto L11;
        return new SettingsHomepageAppBarRegularPhoneLayoutBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}

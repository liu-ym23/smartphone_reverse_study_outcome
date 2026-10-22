package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivitySelfAppBarRegularPhoneLayoutBinding implements ViewBinding {
    public final OTextView homepageTitle400;
    public final OTextView homepageTitle500;
    public final OTextView homepageTitle600;
    public final OTextView homepageTitle640;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivitySelfAppBarRegularPhoneLayoutBinding(RelativeLayout r1, OTextView r2, OTextView r3, OTextView r4, OTextView r5) {
        this.rootView = r1;
        this.homepageTitle400 = r2;
        this.homepageTitle500 = r3;
        this.homepageTitle600 = r4;
        this.homepageTitle640 = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySelfAppBarRegularPhoneLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivitySelfAppBarRegularPhoneLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activity_self_app_bar_regular_phone_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivitySelfAppBarRegularPhoneLayoutBinding bind(View r8) {
        int r0 = R.id.homepage_title_400;
        OTextView r4 = (OTextView) ViewBindings.findChildViewById(r8, R.id.homepage_title_400);
        if (r4 == null) goto L13;
        r0 = R.id.homepage_title_500;
        OTextView r5 = (OTextView) ViewBindings.findChildViewById(r8, R.id.homepage_title_500);
        if (r5 == null) goto L13;
        r0 = R.id.homepage_title_600;
        OTextView r6 = (OTextView) ViewBindings.findChildViewById(r8, R.id.homepage_title_600);
        if (r6 == null) goto L13;
        r0 = R.id.homepage_title_640;
        OTextView r7 = (OTextView) ViewBindings.findChildViewById(r8, R.id.homepage_title_640);
        if (r7 == null) goto L13;
        return new ActivitySelfAppBarRegularPhoneLayoutBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}

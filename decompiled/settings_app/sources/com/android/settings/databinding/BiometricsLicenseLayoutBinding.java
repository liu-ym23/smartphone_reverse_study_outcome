package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.actionbar.v2.OBottomActionBarNormalVertical;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class BiometricsLicenseLayoutBinding implements ViewBinding {
    public final OBottomActionBarNormalVertical bottomActionBarV;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final ViewStub viewContent;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BiometricsLicenseLayoutBinding(RelativeLayout r1, OBottomActionBarNormalVertical r2, OScrollView r3, ViewStub r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.bottomActionBarV = r2;
        this.pageScrollview = r3;
        this.viewContent = r4;
        this.viewTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiometricsLicenseLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BiometricsLicenseLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.biometrics_license_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BiometricsLicenseLayoutBinding bind(View r8) {
        int r0 = R.id.bottom_action_bar_v;
        OBottomActionBarNormalVertical r4 = (OBottomActionBarNormalVertical) ViewBindings.findChildViewById(r8, R.id.bottom_action_bar_v);
        if (r4 == null) goto L13;
        r0 = R.id.page_scrollview;
        OScrollView r5 = (OScrollView) ViewBindings.findChildViewById(r8, R.id.page_scrollview);
        if (r5 == null) goto L13;
        r0 = R.id.view_content;
        ViewStub r6 = (ViewStub) ViewBindings.findChildViewById(r8, R.id.view_content);
        if (r6 == null) goto L13;
        r0 = R.id.view_title;
        OFloatingTitleBar r7 = (OFloatingTitleBar) ViewBindings.findChildViewById(r8, R.id.view_title);
        if (r7 == null) goto L13;
        return new BiometricsLicenseLayoutBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}

package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.AboutStaticItem;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneFragmentAboutBostonBinding implements ViewBinding {
    public final ImageView aboutLogo;
    public final AboutStaticItem compileInfo;
    public final AboutStaticItem deviceModel;
    public final AboutStaticItem modVersion;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final AboutStaticItem resolutionDisplay;
    private final RelativeLayout rootView;
    public final AboutStaticItem serialNumber;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneFragmentAboutBostonBinding(RelativeLayout r1, ImageView r2, AboutStaticItem r3, AboutStaticItem r4, AboutStaticItem r5, LinearLayout r6, OScrollView r7, AboutStaticItem r8, AboutStaticItem r9, OFloatingTitleBar r10) {
        this.rootView = r1;
        this.aboutLogo = r2;
        this.compileInfo = r3;
        this.deviceModel = r4;
        this.modVersion = r5;
        this.pageContainer = r6;
        this.pageScrollview = r7;
        this.resolutionDisplay = r8;
        this.serialNumber = r9;
        this.viewTitle = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevoneFragmentAboutBostonBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneFragmentAboutBostonBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_fragment_about_boston, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneFragmentAboutBostonBinding bind(View r13) {
        int r0 = R.id.about_logo;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r13, R.id.about_logo);
        if (r4 == null) goto L23;
        r0 = R.id.compile_info;
        AboutStaticItem r5 = (AboutStaticItem) ViewBindings.findChildViewById(r13, R.id.compile_info);
        if (r5 == null) goto L23;
        r0 = R.id.device_model;
        AboutStaticItem r6 = (AboutStaticItem) ViewBindings.findChildViewById(r13, R.id.device_model);
        if (r6 == null) goto L23;
        r0 = R.id.mod_version;
        AboutStaticItem r7 = (AboutStaticItem) ViewBindings.findChildViewById(r13, R.id.mod_version);
        if (r7 == null) goto L23;
        r0 = R.id.page_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.page_container);
        if (r8 == null) goto L23;
        r0 = R.id.page_scrollview;
        OScrollView r9 = (OScrollView) ViewBindings.findChildViewById(r13, R.id.page_scrollview);
        if (r9 == null) goto L23;
        r0 = R.id.resolution_display;
        AboutStaticItem r10 = (AboutStaticItem) ViewBindings.findChildViewById(r13, R.id.resolution_display);
        if (r10 == null) goto L23;
        r0 = R.id.serial_number;
        AboutStaticItem r11 = (AboutStaticItem) ViewBindings.findChildViewById(r13, R.id.serial_number);
        if (r11 == null) goto L23;
        r0 = R.id.view_title;
        OFloatingTitleBar r12 = (OFloatingTitleBar) ViewBindings.findChildViewById(r13, R.id.view_title);
        if (r12 == null) goto L23;
        return new RevoneFragmentAboutBostonBinding((RelativeLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}

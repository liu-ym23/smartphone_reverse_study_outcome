package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public final class NavbarSwipeLayoutBinding implements ViewBinding {
    public final ImageView idImg1;
    public final ImageView idImg2;
    public final ImageView idNavbarImageSwipe;
    public final LinearLayout idNavbarImageTapContainer;
    public final SettingItemCheck idTriggerNavbarSwipe;
    public final SettingItemCheck idTriggerNavbarTap;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NavbarSwipeLayoutBinding(RelativeLayout r1, ImageView r2, ImageView r3, ImageView r4, LinearLayout r5, SettingItemCheck r6, SettingItemCheck r7, LinearLayout r8, OScrollView r9, OFloatingTitleBar r10) {
        this.rootView = r1;
        this.idImg1 = r2;
        this.idImg2 = r3;
        this.idNavbarImageSwipe = r4;
        this.idNavbarImageTapContainer = r5;
        this.idTriggerNavbarSwipe = r6;
        this.idTriggerNavbarTap = r7;
        this.pageContainer = r8;
        this.pageScrollview = r9;
        this.viewTitle = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NavbarSwipeLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NavbarSwipeLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.navbar_swipe_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NavbarSwipeLayoutBinding bind(View r13) {
        int r0 = R.id.id_img_1;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r13, R.id.id_img_1);
        if (r4 == null) goto L23;
        r0 = R.id.id_img_2;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r13, R.id.id_img_2);
        if (r5 == null) goto L23;
        r0 = R.id.id_navbar_image_swipe;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r13, R.id.id_navbar_image_swipe);
        if (r6 == null) goto L23;
        r0 = R.id.id_navbar_image_tap_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.id_navbar_image_tap_container);
        if (r7 == null) goto L23;
        r0 = R.id.id_trigger_navbar_swipe;
        SettingItemCheck r8 = (SettingItemCheck) ViewBindings.findChildViewById(r13, R.id.id_trigger_navbar_swipe);
        if (r8 == null) goto L23;
        r0 = R.id.id_trigger_navbar_tap;
        SettingItemCheck r9 = (SettingItemCheck) ViewBindings.findChildViewById(r13, R.id.id_trigger_navbar_tap);
        if (r9 == null) goto L23;
        r0 = R.id.page_container;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.page_container);
        if (r10 == null) goto L23;
        r0 = R.id.page_scrollview;
        OScrollView r11 = (OScrollView) ViewBindings.findChildViewById(r13, R.id.page_scrollview);
        if (r11 == null) goto L23;
        r0 = R.id.view_title;
        OFloatingTitleBar r12 = (OFloatingTitleBar) ViewBindings.findChildViewById(r13, R.id.view_title);
        if (r12 == null) goto L23;
        return new NavbarSwipeLayoutBinding((RelativeLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}

package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.VerticalOptionsCheckView;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class SmartScreenSettingsLayoutBinding implements ViewBinding {
    public final VerticalOptionsCheckView idNavigationLayoutOneHandMode;
    public final ImageView idSmartScreenIntroImg;
    public final TextView idSmartScreenLearnMore;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final SettingItemSwitch triggerSmartScreenMode;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SmartScreenSettingsLayoutBinding(RelativeLayout r1, VerticalOptionsCheckView r2, ImageView r3, TextView r4, LinearLayout r5, OScrollView r6, SettingItemSwitch r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.idNavigationLayoutOneHandMode = r2;
        this.idSmartScreenIntroImg = r3;
        this.idSmartScreenLearnMore = r4;
        this.pageContainer = r5;
        this.pageScrollview = r6;
        this.triggerSmartScreenMode = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SmartScreenSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SmartScreenSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.smart_screen_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SmartScreenSettingsLayoutBinding bind(View r11) {
        int r0 = R.id.id_navigation_layout_one_hand_mode;
        VerticalOptionsCheckView r4 = (VerticalOptionsCheckView) ViewBindings.findChildViewById(r11, R.id.id_navigation_layout_one_hand_mode);
        if (r4 == null) goto L19;
        r0 = R.id.id_smart_screen_intro_img;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r11, R.id.id_smart_screen_intro_img);
        if (r5 == null) goto L19;
        r0 = R.id.id_smart_screen_learn_more;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, R.id.id_smart_screen_learn_more);
        if (r6 == null) goto L19;
        r0 = R.id.page_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.page_container);
        if (r7 == null) goto L19;
        r0 = R.id.page_scrollview;
        OScrollView r8 = (OScrollView) ViewBindings.findChildViewById(r11, R.id.page_scrollview);
        if (r8 == null) goto L19;
        r0 = R.id.trigger_smart_screen_mode;
        SettingItemSwitch r9 = (SettingItemSwitch) ViewBindings.findChildViewById(r11, R.id.trigger_smart_screen_mode);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L19;
        return new SmartScreenSettingsLayoutBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}

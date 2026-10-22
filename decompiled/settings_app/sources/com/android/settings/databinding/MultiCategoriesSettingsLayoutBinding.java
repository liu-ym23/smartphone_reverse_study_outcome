package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiCategoriesSettingsLayoutBinding implements ViewBinding {
    public final ViewStub idPhoneCaseShowStub;
    public final TextView idPhoneCaseTips;
    public final ImageView idPhoneCaseVideoIntro;
    public final TextView idPhoneCaseVideoIntroTips;
    private final RelativeLayout rootView;
    public final SettingItemSwitch triggerPhoneCaseKeys;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private MultiCategoriesSettingsLayoutBinding(RelativeLayout r1, ViewStub r2, TextView r3, ImageView r4, TextView r5, SettingItemSwitch r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.idPhoneCaseShowStub = r2;
        this.idPhoneCaseTips = r3;
        this.idPhoneCaseVideoIntro = r4;
        this.idPhoneCaseVideoIntroTips = r5;
        this.triggerPhoneCaseKeys = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MultiCategoriesSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MultiCategoriesSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.multi_categories_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static MultiCategoriesSettingsLayoutBinding bind(View r10) {
        int r0 = R.id.id_phone_case_show_stub;
        ViewStub r4 = (ViewStub) ViewBindings.findChildViewById(r10, R.id.id_phone_case_show_stub);
        if (r4 == null) goto L17;
        r0 = R.id.id_phone_case_tips;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, R.id.id_phone_case_tips);
        if (r5 == null) goto L17;
        r0 = R.id.id_phone_case_video_intro;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r10, R.id.id_phone_case_video_intro);
        if (r6 == null) goto L17;
        r0 = R.id.id_phone_case_video_intro_tips;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, R.id.id_phone_case_video_intro_tips);
        if (r7 == null) goto L17;
        r0 = R.id.trigger_phone_case_keys;
        SettingItemSwitch r8 = (SettingItemSwitch) ViewBindings.findChildViewById(r10, R.id.trigger_phone_case_keys);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new MultiCategoriesSettingsLayoutBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}

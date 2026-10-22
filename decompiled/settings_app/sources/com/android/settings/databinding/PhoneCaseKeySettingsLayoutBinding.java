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
public final class PhoneCaseKeySettingsLayoutBinding implements ViewBinding {
    public final ImageView idPhoneCaseContact;
    public final TextView idPhoneCaseContactTitle;
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

    private PhoneCaseKeySettingsLayoutBinding(RelativeLayout r1, ImageView r2, TextView r3, ViewStub r4, TextView r5, ImageView r6, TextView r7, SettingItemSwitch r8, OFloatingTitleBar r9) {
        this.rootView = r1;
        this.idPhoneCaseContact = r2;
        this.idPhoneCaseContactTitle = r3;
        this.idPhoneCaseShowStub = r4;
        this.idPhoneCaseTips = r5;
        this.idPhoneCaseVideoIntro = r6;
        this.idPhoneCaseVideoIntroTips = r7;
        this.triggerPhoneCaseKeys = r8;
        this.viewTitle = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PhoneCaseKeySettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PhoneCaseKeySettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.phone_case_key_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PhoneCaseKeySettingsLayoutBinding bind(View r12) {
        int r0 = R.id.id_phone_case_contact;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r12, R.id.id_phone_case_contact);
        if (r4 == null) goto L21;
        r0 = R.id.id_phone_case_contact_title;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r12, R.id.id_phone_case_contact_title);
        if (r5 == null) goto L21;
        r0 = R.id.id_phone_case_show_stub;
        ViewStub r6 = (ViewStub) ViewBindings.findChildViewById(r12, R.id.id_phone_case_show_stub);
        if (r6 == null) goto L21;
        r0 = R.id.id_phone_case_tips;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r12, R.id.id_phone_case_tips);
        if (r7 == null) goto L21;
        r0 = R.id.id_phone_case_video_intro;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r12, R.id.id_phone_case_video_intro);
        if (r8 == null) goto L21;
        r0 = R.id.id_phone_case_video_intro_tips;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r12, R.id.id_phone_case_video_intro_tips);
        if (r9 == null) goto L21;
        r0 = R.id.trigger_phone_case_keys;
        SettingItemSwitch r10 = (SettingItemSwitch) ViewBindings.findChildViewById(r12, R.id.trigger_phone_case_keys);
        if (r10 == null) goto L21;
        r0 = R.id.view_title;
        OFloatingTitleBar r11 = (OFloatingTitleBar) ViewBindings.findChildViewById(r12, R.id.view_title);
        if (r11 == null) goto L21;
        return new PhoneCaseKeySettingsLayoutBinding((RelativeLayout) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}

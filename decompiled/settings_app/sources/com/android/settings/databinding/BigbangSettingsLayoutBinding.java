package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemImage;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemCustom;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class BigbangSettingsLayoutBinding implements ViewBinding {
    public final ListContentItemCustom gifContainer;
    public final ViewStub gifViewStub;
    public final TextView idAudioTips1;
    public final TextView idBigBangTips;
    public final SettingItemText idOcrDetail;
    public final TextView idOcrInAppTips;
    public final TextView idOcrTipsV2;
    public final LinearLayout introVideoContainer;
    public final SettingItemText ocrAppSublist;
    public final SettingItemSwitch ocrGameSwitch;
    public final SettingItemSwitch ocrSwitch;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final ImageView preloadGifImg;
    private final RelativeLayout rootView;
    public final LinearLayout subSettingsContainer;
    public final SettingItemSwitch textBoomSwitch;
    public final SettingItemText textboomTriggerAreaOptions;
    public final SettingItemImage videoIntro;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BigbangSettingsLayoutBinding(RelativeLayout r3, ListContentItemCustom r4, ViewStub r5, TextView r6, TextView r7, SettingItemText r8, TextView r9, TextView r10, LinearLayout r11, SettingItemText r12, SettingItemSwitch r13, SettingItemSwitch r14, LinearLayout r15, OScrollView r16, ImageView r17, LinearLayout r18, SettingItemSwitch r19, SettingItemText r20, SettingItemImage r21, OFloatingTitleBar r22) {
        this.rootView = r3;
        this.gifContainer = r4;
        this.gifViewStub = r5;
        this.idAudioTips1 = r6;
        this.idBigBangTips = r7;
        this.idOcrDetail = r8;
        this.idOcrInAppTips = r9;
        this.idOcrTipsV2 = r10;
        this.introVideoContainer = r11;
        this.ocrAppSublist = r12;
        this.ocrGameSwitch = r13;
        this.ocrSwitch = r14;
        this.pageContainer = r15;
        this.pageScrollview = r16;
        this.preloadGifImg = r17;
        this.subSettingsContainer = r18;
        this.textBoomSwitch = r19;
        this.textboomTriggerAreaOptions = r20;
        this.videoIntro = r21;
        this.viewTitle = r22;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BigbangSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BigbangSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bigbang_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BigbangSettingsLayoutBinding bind(View r24) {
        int r1 = R.id.gif_container;
        ListContentItemCustom r5 = (ListContentItemCustom) ViewBindings.findChildViewById(r24, R.id.gif_container);
        if (r5 == null) goto L43;
        r1 = R.id.gif_view_stub;
        ViewStub r6 = (ViewStub) ViewBindings.findChildViewById(r24, R.id.gif_view_stub);
        if (r6 == null) goto L43;
        r1 = R.id.id_audio_tips1;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r24, R.id.id_audio_tips1);
        if (r7 == null) goto L43;
        r1 = R.id.id_big_bang_tips;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r24, R.id.id_big_bang_tips);
        if (r8 == null) goto L43;
        r1 = R.id.id_ocr_detail;
        SettingItemText r9 = (SettingItemText) ViewBindings.findChildViewById(r24, R.id.id_ocr_detail);
        if (r9 == null) goto L43;
        r1 = R.id.id_ocr_in_app_tips;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r24, R.id.id_ocr_in_app_tips);
        if (r10 == null) goto L43;
        r1 = R.id.id_ocr_tips_v2;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r24, R.id.id_ocr_tips_v2);
        if (r11 == null) goto L43;
        r1 = R.id.intro_video_container;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r24, R.id.intro_video_container);
        if (r12 == null) goto L43;
        r1 = R.id.ocr_app_sublist;
        SettingItemText r13 = (SettingItemText) ViewBindings.findChildViewById(r24, R.id.ocr_app_sublist);
        if (r13 == null) goto L43;
        r1 = R.id.ocr_game_switch;
        SettingItemSwitch r14 = (SettingItemSwitch) ViewBindings.findChildViewById(r24, R.id.ocr_game_switch);
        if (r14 == null) goto L43;
        r1 = R.id.ocr_switch;
        SettingItemSwitch r15 = (SettingItemSwitch) ViewBindings.findChildViewById(r24, R.id.ocr_switch);
        if (r15 == null) goto L43;
        r1 = R.id.page_container;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r24, R.id.page_container);
        if (r16 == null) goto L43;
        r1 = R.id.page_scrollview;
        OScrollView r17 = (OScrollView) ViewBindings.findChildViewById(r24, R.id.page_scrollview);
        if (r17 == null) goto L43;
        r1 = R.id.preload_gif_img;
        ImageView r18 = (ImageView) ViewBindings.findChildViewById(r24, R.id.preload_gif_img);
        if (r18 == null) goto L43;
        r1 = R.id.sub_settings_container;
        LinearLayout r19 = (LinearLayout) ViewBindings.findChildViewById(r24, R.id.sub_settings_container);
        if (r19 == null) goto L43;
        r1 = R.id.text_boom_switch;
        SettingItemSwitch r20 = (SettingItemSwitch) ViewBindings.findChildViewById(r24, R.id.text_boom_switch);
        if (r20 == null) goto L43;
        r1 = R.id.textboom_trigger_area_options;
        SettingItemText r21 = (SettingItemText) ViewBindings.findChildViewById(r24, R.id.textboom_trigger_area_options);
        if (r21 == null) goto L43;
        r1 = R.id.video_intro;
        SettingItemImage r22 = (SettingItemImage) ViewBindings.findChildViewById(r24, R.id.video_intro);
        if (r22 == null) goto L43;
        r1 = R.id.view_title;
        OFloatingTitleBar r23 = (OFloatingTitleBar) ViewBindings.findChildViewById(r24, R.id.view_title);
        if (r23 == null) goto L43;
        return new BigbangSettingsLayoutBinding((RelativeLayout) r24, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r24.getResources().getResourceName(r1)));
    }
}

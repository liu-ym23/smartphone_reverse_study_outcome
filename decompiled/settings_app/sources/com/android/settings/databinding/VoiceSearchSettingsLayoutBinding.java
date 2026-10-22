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
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class VoiceSearchSettingsLayoutBinding implements ViewBinding {
    public final SettingItemText allowedSearch;
    public final ContactVoiceSettingLayoutBinding contactVoiceSettings;
    public final TextView fuzzyToneTipsView;
    public final TextView globalSuggestionsTips;
    public final OListItemSettings idGlobalSearch;
    public final TextView idHeaderVoiceSearch;
    public final SettingItemText idImageSearch;
    public final SettingItemText idRecognizeLang;
    public final View idSearchableItemGap;
    public final SettingItemSwitch idSlideUpLauncher;
    public final LinearLayout idSlideUpSettings;
    public final View idVoiceTopShadow;
    public final ImageView ivSlideUpLauncherIntro;
    public final SettingItemSwitch menu;
    public final LinearLayout menuSettingsContainer;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final SettingItemText pinyinFuzzyToneSearchItem;
    public final TextView recognitionLanguageTip;
    private final RelativeLayout rootView;
    public final OListItemSettings searchMenu;
    public final TextView searchSettingTitle;
    public final SettingItemSwitch switchApplicationSuggestions;
    public final SettingItemSwitch switchPopularInformation;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private VoiceSearchSettingsLayoutBinding(RelativeLayout r3, SettingItemText r4, ContactVoiceSettingLayoutBinding r5, TextView r6, TextView r7, OListItemSettings r8, TextView r9, SettingItemText r10, SettingItemText r11, View r12, SettingItemSwitch r13, LinearLayout r14, View r15, ImageView r16, SettingItemSwitch r17, LinearLayout r18, LinearLayout r19, OScrollView r20, SettingItemText r21, TextView r22, OListItemSettings r23, TextView r24, SettingItemSwitch r25, SettingItemSwitch r26, OFloatingTitleBar r27) {
        this.rootView = r3;
        this.allowedSearch = r4;
        this.contactVoiceSettings = r5;
        this.fuzzyToneTipsView = r6;
        this.globalSuggestionsTips = r7;
        this.idGlobalSearch = r8;
        this.idHeaderVoiceSearch = r9;
        this.idImageSearch = r10;
        this.idRecognizeLang = r11;
        this.idSearchableItemGap = r12;
        this.idSlideUpLauncher = r13;
        this.idSlideUpSettings = r14;
        this.idVoiceTopShadow = r15;
        this.ivSlideUpLauncherIntro = r16;
        this.menu = r17;
        this.menuSettingsContainer = r18;
        this.pageContainer = r19;
        this.pageScrollview = r20;
        this.pinyinFuzzyToneSearchItem = r21;
        this.recognitionLanguageTip = r22;
        this.searchMenu = r23;
        this.searchSettingTitle = r24;
        this.switchApplicationSuggestions = r25;
        this.switchPopularInformation = r26;
        this.viewTitle = r27;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VoiceSearchSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static VoiceSearchSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.voice_search_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static VoiceSearchSettingsLayoutBinding bind(View r29) {
        int r1 = R.id.allowed_search;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r29, R.id.allowed_search);
        if (r5 == null) goto L53;
        r1 = R.id.contact_voice_settings;
        View r2 = ViewBindings.findChildViewById(r29, R.id.contact_voice_settings);
        if (r2 == null) goto L53;
        ContactVoiceSettingLayoutBinding r6 = ContactVoiceSettingLayoutBinding.bind(r2);
        r1 = R.id.fuzzy_tone_tips_view;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r29, R.id.fuzzy_tone_tips_view);
        if (r7 == null) goto L53;
        r1 = R.id.global_suggestions_tips;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r29, R.id.global_suggestions_tips);
        if (r8 == null) goto L53;
        r1 = R.id.id_global_search;
        OListItemSettings r9 = (OListItemSettings) ViewBindings.findChildViewById(r29, R.id.id_global_search);
        if (r9 == null) goto L53;
        r1 = R.id.id_header_voice_search;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r29, R.id.id_header_voice_search);
        if (r10 == null) goto L53;
        r1 = R.id.id_image_search;
        SettingItemText r11 = (SettingItemText) ViewBindings.findChildViewById(r29, R.id.id_image_search);
        if (r11 == null) goto L53;
        r1 = R.id.id_recognize_lang;
        SettingItemText r12 = (SettingItemText) ViewBindings.findChildViewById(r29, R.id.id_recognize_lang);
        if (r12 == null) goto L53;
        r1 = R.id.id_searchable_item_gap;
        View r13 = ViewBindings.findChildViewById(r29, R.id.id_searchable_item_gap);
        if (r13 == null) goto L53;
        r1 = R.id.id_slide_up_launcher;
        SettingItemSwitch r14 = (SettingItemSwitch) ViewBindings.findChildViewById(r29, R.id.id_slide_up_launcher);
        if (r14 == null) goto L53;
        r1 = R.id.id_slide_up_settings;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r29, R.id.id_slide_up_settings);
        if (r15 == null) goto L53;
        r1 = R.id.id_voice_top_shadow;
        View r16 = ViewBindings.findChildViewById(r29, R.id.id_voice_top_shadow);
        if (r16 == null) goto L53;
        r1 = R.id.iv_slide_up_launcher_intro;
        ImageView r17 = (ImageView) ViewBindings.findChildViewById(r29, R.id.iv_slide_up_launcher_intro);
        if (r17 == null) goto L53;
        r1 = R.id.menu;
        SettingItemSwitch r18 = (SettingItemSwitch) ViewBindings.findChildViewById(r29, R.id.menu);
        if (r18 == null) goto L53;
        r1 = R.id.menu_settings_container;
        LinearLayout r19 = (LinearLayout) ViewBindings.findChildViewById(r29, R.id.menu_settings_container);
        if (r19 == null) goto L53;
        r1 = R.id.page_container;
        LinearLayout r20 = (LinearLayout) ViewBindings.findChildViewById(r29, R.id.page_container);
        if (r20 == null) goto L53;
        r1 = R.id.page_scrollview;
        OScrollView r21 = (OScrollView) ViewBindings.findChildViewById(r29, R.id.page_scrollview);
        if (r21 == null) goto L53;
        r1 = R.id.pinyin_fuzzy_tone_search_item;
        SettingItemText r22 = (SettingItemText) ViewBindings.findChildViewById(r29, R.id.pinyin_fuzzy_tone_search_item);
        if (r22 == null) goto L53;
        r1 = R.id.recognition_language_tip;
        TextView r23 = (TextView) ViewBindings.findChildViewById(r29, R.id.recognition_language_tip);
        if (r23 == null) goto L53;
        r1 = R.id.search_menu;
        OListItemSettings r24 = (OListItemSettings) ViewBindings.findChildViewById(r29, R.id.search_menu);
        if (r24 == null) goto L53;
        r1 = R.id.search_setting_title;
        TextView r25 = (TextView) ViewBindings.findChildViewById(r29, R.id.search_setting_title);
        if (r25 == null) goto L53;
        r1 = R.id.switch_application_suggestions;
        SettingItemSwitch r26 = (SettingItemSwitch) ViewBindings.findChildViewById(r29, R.id.switch_application_suggestions);
        if (r26 == null) goto L53;
        r1 = R.id.switch_popular_information;
        SettingItemSwitch r27 = (SettingItemSwitch) ViewBindings.findChildViewById(r29, R.id.switch_popular_information);
        if (r27 == null) goto L53;
        r1 = R.id.view_title;
        OFloatingTitleBar r28 = (OFloatingTitleBar) ViewBindings.findChildViewById(r29, R.id.view_title);
        if (r28 == null) goto L53;
        return new VoiceSearchSettingsLayoutBinding((RelativeLayout) r29, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    L53:
        throw new NullPointerException("Missing required view with ID: ".concat(r29.getResources().getResourceName(r1)));
    }
}

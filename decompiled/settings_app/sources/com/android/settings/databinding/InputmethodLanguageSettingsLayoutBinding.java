package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class InputmethodLanguageSettingsLayoutBinding implements ViewBinding {
    public final OCardListItem autofillService;
    public final OCardListItem idSecurityKeyboard;
    public final ItemSubSettingsPaddingLayout2Binding idSpellingCheckGap;
    public final OSectionTitleBar idTextInputMethod;
    public final LinearLayout inputmethodList;
    public final LinearLayout inputmethodListWork;
    public final OSectionTitleBar inputmethodListWorkTitle;
    public final OCardListItem itemIdButtonSpellingCheck;
    public final OCardListItem itemIdDefaultInputmethod;
    public final OCardListItem itemIdLanguage;
    public final OCardListItem itemIdSwitchSpellingCheck;
    public final OCardListItem itemIdUserDictionary;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private InputmethodLanguageSettingsLayoutBinding(RelativeLayout r3, OCardListItem r4, OCardListItem r5, ItemSubSettingsPaddingLayout2Binding r6, OSectionTitleBar r7, LinearLayout r8, LinearLayout r9, OSectionTitleBar r10, OCardListItem r11, OCardListItem r12, OCardListItem r13, OCardListItem r14, OCardListItem r15, LinearLayout r16, OScrollView r17, OFloatingTitleBar r18) {
        this.rootView = r3;
        this.autofillService = r4;
        this.idSecurityKeyboard = r5;
        this.idSpellingCheckGap = r6;
        this.idTextInputMethod = r7;
        this.inputmethodList = r8;
        this.inputmethodListWork = r9;
        this.inputmethodListWorkTitle = r10;
        this.itemIdButtonSpellingCheck = r11;
        this.itemIdDefaultInputmethod = r12;
        this.itemIdLanguage = r13;
        this.itemIdSwitchSpellingCheck = r14;
        this.itemIdUserDictionary = r15;
        this.pageContainer = r16;
        this.pageScrollview = r17;
        this.viewTitle = r18;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static InputmethodLanguageSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static InputmethodLanguageSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.inputmethod_language_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static InputmethodLanguageSettingsLayoutBinding bind(View r20) {
        int r1 = R.id.autofill_service;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r20, R.id.autofill_service);
        if (r5 == null) goto L35;
        r1 = R.id.id_security_keyboard;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r20, R.id.id_security_keyboard);
        if (r6 == null) goto L35;
        r1 = R.id.id_spelling_check_gap;
        View r2 = ViewBindings.findChildViewById(r20, R.id.id_spelling_check_gap);
        if (r2 == null) goto L35;
        ItemSubSettingsPaddingLayout2Binding r7 = ItemSubSettingsPaddingLayout2Binding.bind(r2);
        r1 = R.id.id_text_input_method;
        OSectionTitleBar r8 = (OSectionTitleBar) ViewBindings.findChildViewById(r20, R.id.id_text_input_method);
        if (r8 == null) goto L35;
        r1 = R.id.inputmethod_list;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r20, R.id.inputmethod_list);
        if (r9 == null) goto L35;
        r1 = R.id.inputmethod_list_work;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r20, R.id.inputmethod_list_work);
        if (r10 == null) goto L35;
        r1 = R.id.inputmethod_list_work_title;
        OSectionTitleBar r11 = (OSectionTitleBar) ViewBindings.findChildViewById(r20, R.id.inputmethod_list_work_title);
        if (r11 == null) goto L35;
        r1 = R.id.item_id_button_spelling_check;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r20, R.id.item_id_button_spelling_check);
        if (r12 == null) goto L35;
        r1 = R.id.item_id_default_inputmethod;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r20, R.id.item_id_default_inputmethod);
        if (r13 == null) goto L35;
        r1 = R.id.item_id_language;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r20, R.id.item_id_language);
        if (r14 == null) goto L35;
        r1 = R.id.item_id_switch_spelling_check;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r20, R.id.item_id_switch_spelling_check);
        if (r15 == null) goto L35;
        r1 = R.id.item_id_user_dictionary;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r20, R.id.item_id_user_dictionary);
        if (r16 == null) goto L35;
        r1 = R.id.page_container;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r20, R.id.page_container);
        if (r17 == null) goto L35;
        r1 = R.id.page_scrollview;
        OScrollView r18 = (OScrollView) ViewBindings.findChildViewById(r20, R.id.page_scrollview);
        if (r18 == null) goto L35;
        r1 = R.id.view_title;
        OFloatingTitleBar r19 = (OFloatingTitleBar) ViewBindings.findChildViewById(r20, R.id.view_title);
        if (r19 == null) goto L35;
        return new InputmethodLanguageSettingsLayoutBinding((RelativeLayout) r20, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r20.getResources().getResourceName(r1)));
    }
}
